package org.wadael.forge.metaforgewizard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.inject.Inject;

import org.jboss.forge.addon.projects.ProjectFactory;
import org.jboss.forge.addon.projects.ui.AbstractProjectCommand;
import org.jboss.forge.addon.resource.FileResource;
import org.jboss.forge.addon.resource.Resource;
import org.jboss.forge.addon.resource.ResourceFactory;
import org.jboss.forge.addon.templates.Template;
import org.jboss.forge.addon.templates.TemplateFactory;
import org.jboss.forge.addon.templates.freemarker.FreemarkerTemplate;
import org.jboss.forge.addon.ui.context.UIBuilder;
import org.jboss.forge.addon.ui.context.UIContext;
import org.jboss.forge.addon.ui.context.UIExecutionContext;
import org.jboss.forge.addon.ui.context.UIValidationContext;
import org.jboss.forge.addon.ui.hints.InputType;
import org.jboss.forge.addon.ui.input.InputComponent;
import org.jboss.forge.addon.ui.input.UICompleter;
import org.jboss.forge.addon.ui.input.UIInput;
import org.jboss.forge.addon.ui.metadata.UICommandMetadata;
import org.jboss.forge.addon.ui.metadata.WithAttributes;
import org.jboss.forge.addon.ui.result.Result;
import org.jboss.forge.addon.ui.result.Results;
import org.jboss.forge.addon.ui.util.Categories;
import org.jboss.forge.addon.ui.util.Metadata;

/**
 * Wizard that creates sources of Forge wizard addons.
 * 
 * @author Jerome Baton : @wadael
 *
 */
public class MetaWizard extends AbstractProjectCommand { // implements UIWizard
															// {

	public static final String SEPARATION_CHARS = ",;:";

	public static final String FILE_SEPARATOR = System.getProperty("file.separator");

	@Inject
	ProjectFactory projectFactory;

	@Inject
	ResourceFactory resourceFactory;

	@Inject
	TemplateFactory templateFactory;

	@Inject
	@WithAttributes(defaultValue = "org.wadael.changeme", label = "Destination package name", type = InputType.JAVA_PACKAGE_PICKER)
	private UIInput<String> destinationPackageName;

	@Inject
	@WithAttributes(required = true, requiredMessage = "You really should input a name for your command.", label = "Command name", description = "The name of the comand that will start your wizard", type = InputType.TEXTBOX)
	private UIInput<String> commandName;

	@Inject
	@WithAttributes(required = true, defaultValue = "YourWizard>Step1>Step2", label = "List of wizard and steps names", description = "The name of the class of the wizard, and its steps. Separated by any of the following characters " + SEPARATION_CHARS + "    Do not use chars used in shell like |,< or >", type = InputType.TEXTBOX)
	private UIInput<String> stepsNames;

	@Inject
	@WithAttributes(defaultValue = "false", label = "Overwrite ?", description = "Overwrite existing sources if they exist", type = InputType.CHECKBOX)
	private UIInput<Boolean> overwrite;

	@Inject
	@WithAttributes(defaultValue = "gen", label = "Name of the destination source folder", type = InputType.DROPDOWN)
	private UIInput<String> destinationSourceFolder;

	@Override
	public UICommandMetadata getMetadata(UIContext context) {
		return Metadata.forCommand(MetaWizard.class).name("wizard-generator").category(Categories.create("forge", "addon", "generation"));
	}

	@Override
	public void initializeUI(UIBuilder builder) throws Exception {
		destinationSourceFolder.setCompleter(new UICompleter<String>() {
			@Override
			public Iterable<String> getCompletionProposals(UIContext arg0, InputComponent<?, String> arg1, String arg2) {
				List<String> ret = new ArrayList<String>();
				ret.add("gen");
				ret.add("src");
				return ret;
			}
		});

		builder.add(destinationSourceFolder);
		builder.add(destinationPackageName);
		builder.add(overwrite);
		builder.add(commandName);
		builder.add(stepsNames);
	}

	@Override
	public void validate(UIValidationContext validator) {
		super.validate(validator);
		String tmp = (String) commandName.getValue();
		if (tmp == null || tmp.trim().length() == 0 || tmp.trim().length() < 7)
			validator.addValidationError(commandName, "Set your command name wisely, at least 7 characters.");

		tmp = (String) stepsNames.getValue();

		if (tmp == null || tmp.trim().length() == 0)
			validator.addValidationError(stepsNames, "Set your steps name wisely, you are a coder, dammit. RTFDescription");

		StringTokenizer tokenizer = new StringTokenizer(tmp, SEPARATION_CHARS);
		if (tokenizer.countTokens() == 1) {
			validator.addValidationError(stepsNames, "Do not use this command for only one step. That's craaaaazzzzzzy.");
		}
	}

	@Override
	public Result execute(UIExecutionContext context) throws Exception {
		String step = (String) stepsNames.getValue(); 
		/* at this moment, its all  the steps */

		StringTokenizer tokenizer = new StringTokenizer(step, SEPARATION_CHARS);

		boolean everyThingIsFine = true;
		SpellIngredients ingredients = new SpellIngredients();

		ingredients.setDestinationPackageName(destinationPackageName.getValue().toString());
		ingredients.setDestinationSourceFolder(destinationSourceFolder.getValue());
		ingredients.setOverwrite(overwrite.getValue());
		ingredients.setCommandName(commandName.getValue());
		ingredients.setDestinationPackageName(destinationPackageName.getValue());
		ingredients.setStepCount(tokenizer.countTokens());

		if (ingredients.getStepCount() == 0)
			return Results.fail("Use your tools wisely.");

		if (ingredients.getStepCount() == 1) {
			step = tokenizer.nextToken();
			ingredients.setClassName(step);
			everyThingIsFine = createGeneratedFile(context, ingredients, "template1.ftl");
		} else {
			step = tokenizer.nextToken();
			ingredients.setClassName(step);
			step = tokenizer.nextToken();

			ingredients.setNextStep(step);

			boolean stop = false;

			while (everyThingIsFine && !stop) {
				everyThingIsFine = createGeneratedFile(context, ingredients, "template1.ftl");

				if (tokenizer.hasMoreElements()) {
					ingredients.setClassName(ingredients.getNextStep());
					ingredients.setStepNumber(ingredients.getStepNumber() + 1);

					try {
						step = tokenizer.nextToken();
						ingredients.setNextStep(step);
					} catch (Exception e) {
						ingredients.setNextStep("");
						ingredients.setLast(true);
						stop = true;
					}
				} else {
					stop = true;
					ingredients.setClassName(ingredients.getNextStep());
					ingredients.setNextStep(null);
					ingredients.setLast(true);
					ingredients.setStepNumber(ingredients.getStepNumber() + 1);

					everyThingIsFine = createGeneratedFile(context, ingredients, "template1.ftl");
				}
			}
		}

		if (everyThingIsFine)
			return Results.success("Now, check the generated code for a little tweaking (categories, what-it-must-do");
		else
			return Results.fail("Error while processing step " + step + ". Sorry for the inconvenience.");
	}

	@Override
	protected ProjectFactory getProjectFactory() {
		return projectFactory;
	}

	@Override
	protected boolean isProjectRequired() {
		return true;
	}

	private boolean createGeneratedFile(UIExecutionContext context, SpellIngredients params, String nomTemplate) {

		try {
			StringBuilder destFileName = new StringBuilder();
			destFileName.append(getSelectedProject(context.getUIContext()).getRoot().getFullyQualifiedName());

			destFileName.append(FILE_SEPARATOR);
			destFileName.append(params.getDestinationSourceFolder()); // gen or
																		// src
			destFileName.append(FILE_SEPARATOR);
			destFileName.append("main");
			destFileName.append(FILE_SEPARATOR);
			destFileName.append("java");
			destFileName.append(FILE_SEPARATOR);

			destFileName.append(params.getDestinationPackageName().replace(".", FILE_SEPARATOR));
			destFileName.append(FILE_SEPARATOR);
			destFileName.append(params.getClassName());
			destFileName.append(".java");

			File destFile = new File(destFileName.toString());
			destFile.getParentFile().mkdirs();
			destFile.createNewFile();

			URL urlTemplate = getClass().getClassLoader().getResource(nomTemplate);
			Resource<URL> templateResource = resourceFactory.create(FileResource.class, urlTemplate);

			Template template = templateFactory.create(templateResource, FreemarkerTemplate.class);

			String resul = template.process(params);
			FileWriter fw = new FileWriter(destFile);

			fw.write(resul);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}