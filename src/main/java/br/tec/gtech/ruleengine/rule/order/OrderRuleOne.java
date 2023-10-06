package br.tec.gtech.ruleengine.rule.order;

import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import br.tec.gtech.ruleengine.instrument.Instrument;
import br.tec.gtech.ruleengine.instrument.InstrumentType;
import br.tec.gtech.ruleengine.rule.InstrumentRule;
import br.tec.gtech.ruleengine.rule.RuleProcessResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderRuleOne extends InstrumentRule {

	@Override
	public RuleProcessResult apply(Instrument instrument) {
		Random random = new Random();
		IntStream limitedIntStreamWithinARange = random.ints(10);
		boolean ruleApproved = limitedIntStreamWithinARange.findFirst().getAsInt() % 2 == 0;
		
		log.info("Order ID:", instrument.getId());
		
		if(ruleApproved && hasSuccessor()){
			log.debug("Rule approved and has successor!");
			return successor.apply(instrument);
		}
		
		log.debug("Returning OrderRuleProcessResult!");
		return new OrderRuleProcessResult();
	}

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
		return "OrderRuleOne";
	}

}