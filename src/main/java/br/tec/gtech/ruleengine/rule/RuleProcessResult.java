package br.tec.gtech.ruleengine.rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.tec.gtech.ruleengine.rule.error.RuleValidationError;

public abstract class RuleProcessResult {
	private List<RuleValidationError> validationErrors;
	
	protected RuleProcessResult() {
		validationErrors = new ArrayList<>();
	}
	
	
	public void add(RuleValidationError ruleValidationError) {
		validationErrors.add(ruleValidationError);
	}
	
	public List<RuleValidationError> getValidationErrors(){
		return Collections.unmodifiableList(validationErrors);
	}
	
	public abstract String getName();
}