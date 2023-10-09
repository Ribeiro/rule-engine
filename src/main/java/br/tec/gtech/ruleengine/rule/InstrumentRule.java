package br.tec.gtech.ruleengine.rule;

import br.tec.gtech.ruleengine.instrument.Instrument;
import br.tec.gtech.ruleengine.instrument.InstrumentType;

public abstract class InstrumentRule {
	
	protected InstrumentRule successor;

	public void setSuccessor(InstrumentRule successor)
	{
		this.successor = successor;
	}
	
	private RuleProcessResult applyNextRuleOn(Instrument instrument, RuleProcessResult ruleProcessResult) {
		if(this.successor != null) {
			return successor.apply(instrument, ruleProcessResult);
		}
		else {
			return ruleProcessResult;
		}
	}

	public RuleProcessResult apply(Instrument instrument, RuleProcessResult ruleProcessResult) {
		doApply(instrument, ruleProcessResult);
		return applyNextRuleOn(instrument, ruleProcessResult);
	}
	
	public abstract void doApply(Instrument instrument, RuleProcessResult ruleProcessResult);
	public abstract String getName();
	public abstract InstrumentType getInstrumentType();
	
};