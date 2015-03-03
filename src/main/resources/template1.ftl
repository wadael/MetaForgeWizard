package ${destinationPackageName};

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.jboss.forge.addon.projects.Project;
import org.jboss.forge.addon.projects.ProjectFactory;
import org.jboss.forge.addon.projects.ui.AbstractProjectCommand;
import org.jboss.forge.addon.ui.context.UIBuilder;
import org.jboss.forge.addon.ui.context.UIContext;
import org.jboss.forge.addon.ui.context.UIExecutionContext;
import org.jboss.forge.addon.ui.context.UIValidationContext;
import org.jboss.forge.addon.ui.hints.InputType;
import org.jboss.forge.addon.ui.input.UICompleter;
import org.jboss.forge.addon.ui.input.UIInput;
import org.jboss.forge.addon.ui.metadata.UICommandMetadata;
import org.jboss.forge.addon.ui.result.Result;
import org.jboss.forge.addon.ui.result.Results;
import org.jboss.forge.addon.ui.util.Categories;
import org.jboss.forge.addon.ui.util.Metadata;
<#if stepNumber==0>
import org.jboss.forge.addon.ui.wizard.UIWizard;
<#else>
import org.jboss.forge.addon.ui.wizard.UIWizardStep;
</#if>

public class ${className} extends AbstractProjectCommand implements <#if stepNumber == 0 >UIWizard<#else>UIWizardStep</#if> {

	@Inject
	ProjectFactory projectFactory;
	
	// You will probably need them too
	/*
	@Inject
	ResourceFactory resourceFactory;

	@Inject
	TemplateFactory templateFactory;
	*/
		
	// Left as an example
	// @Inject
	// @WithAttributes(label = "Displayed on screen",type=InputType.DEFAULT,description="what is to be input here")
	// private UIInput<String> input; 

	<#if stepNumber==0>
	@Override
	public UICommandMetadata getMetadata(UIContext context) {
		return Metadata.forCommand(${className}.class).name("${commandName}").category(Categories.create(${categories}));
	}
	</#if>
	@Override
	protected boolean isProjectRequired() {
		return true; // TODO your choice !
	}

	@Override
	public void initializeUI(UIBuilder builder) throws Exception {
		// TODO add your widgets here
	}
	
	@Override
	public void validate(UIValidationContext validator) {
		super.validate(validator);
		// TODO  validation of all inputs. 
	}
	
		
	public Result execute(UIExecutionContext context) throws Exception {
	<#if last>
		// TODO do your implementation here
	<#else>
		// TODO use context to pass the user input to the next step 
	</#if>
		return Results.success();
	}
	
	public org.jboss.forge.addon.ui.result.NavigationResult next(org.jboss.forge.addon.ui.context.UINavigationContext context) throws Exception {
		<#if last==false>
		return Results.navigateTo(${nextStep!""}.class);
		<#else>	
		return null;
		</#if>
	};

	@Override
	protected ProjectFactory getProjectFactory() {
		return projectFactory;
	}
}