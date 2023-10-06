package br.tec.gtech.ruleengine.instrument;

import java.util.UUID;

public class Order extends Instrument {
	
	public Order() {
		this.id = UUID.randomUUID().toString();
	}

	@Override
	public InstrumentType getTtype() {
		return InstrumentType.ORDER;
	}

}