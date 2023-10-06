package br.tec.gtech.ruleengine.instrument;

import java.util.UUID;

public class MutualFund extends Instrument {
	
	public MutualFund() {
		this.id = UUID.randomUUID().toString();
	}

	@Override
	public InstrumentType getTtype() {
		return InstrumentType.MUTUAL_FUND;
	}

}