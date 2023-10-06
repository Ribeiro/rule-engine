package br.tec.gtech.ruleengine.rule;

import br.tec.gtech.ruleengine.instrument.Instrument;
import br.tec.gtech.ruleengine.instrument.InstrumentType;

public abstract class InstrumentRule {
	
	protected InstrumentRule successor;

	public void setSuccessor(InstrumentRule successor)
	{
		this.successor = successor;
	}
	
	public boolean hasSuccessor() {
		return this.successor != null;
	}

	public abstract RuleProcessResult apply(Instrument instrument);
	public abstract String getName();
	public abstract InstrumentType getInstrumentType();
	
}