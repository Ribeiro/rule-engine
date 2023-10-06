package br.tec.gtech.ruleengine.instrument;

public abstract class Instrument {
	protected String id;
	public abstract InstrumentType getTtype();
	public String getId() {
		return this.id;
	}
}
