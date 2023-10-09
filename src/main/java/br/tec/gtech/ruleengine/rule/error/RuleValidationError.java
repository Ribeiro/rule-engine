package br.tec.gtech.ruleengine.rule.error;

public class RuleValidationError {

	private String ruleName;
	private String message;

	public RuleValidationError(String ruleName, String message) {
		this.ruleName = ruleName;
		this.message = message;
	}
	
	public String getRuleName() {
		return this.ruleName;
	}
	
	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		return "RuleValidationError [ruleName=" + ruleName + ", message=" + message + "]";
	}
	
}