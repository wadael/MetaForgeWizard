package org.wadael.forge.metaforgewizard;

import java.io.Serializable;

/**
 * Contains the ingredients to pass from step to step.
 * 
 * @author Jerome Baton : @wadael
 *
 */
public class SpellIngredients implements Serializable {
	private static final long serialVersionUID = 1L;

	Boolean overwrite;
	String destinationPackageName;
	String destinationSourceFolder;
	String nextStep;
	int stepNumber;
	int stepCount;
	boolean last;
	String categories = "\"generated\",\"by\",\"Wadael's\",\"MetaWizard\",\"You may donate via paypal to let the magic continue\"";
	String className;
	String commandName;

	public Boolean getOverwrite() {
		return overwrite;
	}

	public void setOverwrite(Boolean overwrite) {
		this.overwrite = overwrite;
	}

	public String getDestinationPackageName() {
		return destinationPackageName;
	}

	public void setDestinationPackageName(String destinationPackageName) {
		this.destinationPackageName = destinationPackageName;
	}

	public String getDestinationSourceFolder() {
		return destinationSourceFolder;
	}

	public void setDestinationSourceFolder(String destinationSourceFolder) {
		this.destinationSourceFolder = destinationSourceFolder;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public int getStepNumber() {
		return stepNumber;
	}

	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public boolean isLast() {
		return last;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public int getStepCount() {
		return stepCount;
	}

	public void setStepCount(int stepCount) {
		this.stepCount = stepCount;
	}
}
