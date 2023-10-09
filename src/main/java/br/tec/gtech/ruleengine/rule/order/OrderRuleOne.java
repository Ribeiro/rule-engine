package br.tec.gtech.ruleengine.rule.order;

import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import br.tec.gtech.ruleengine.instrument.Instrument;
import br.tec.gtech.ruleengine.instrument.InstrumentType;
import br.tec.gtech.ruleengine.rule.InstrumentRule;
import br.tec.gtech.ruleengine.rule.RuleProcessResult;
import br.tec.gtech.ruleengine.rule.error.RuleValidationError;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderRuleOne extends InstrumentRule {

	private static final String ORDER_RULE_ONE = "OrderRuleOne";

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.ORDER;
	}

	@Override
	public String toString() {
		return "OrderRuleOne [getName()=" + getName() + "]";
	}

	@Override
	public String getName() {
		return ORDER_RULE_ONE;
	}

	@Override
	public void doApply(Instrument instrument, RuleProcessResult ruleProcessResult) {
		Random random = new Random();
		IntStream limitedIntStreamWithinARange = random.ints(10);
		boolean ruleNotApproved = limitedIntStreamWithinARange.findFirst().getAsInt() % 2 == 0;
		
		if(ruleNotApproved) {
			ruleProcessResult.add(new RuleValidationError(ORDER_RULE_ONE,"Validation failed!"));
		}
		
	}

}