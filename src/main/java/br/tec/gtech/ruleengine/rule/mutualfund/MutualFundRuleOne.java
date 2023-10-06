package br.tec.gtech.ruleengine.rule.mutualfund;

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
public class MutualFundRuleOne extends InstrumentRule {

	@Override
	public RuleProcessResult apply(Instrument instrument) {
		Random random = new Random();
		IntStream limitedIntStreamWithinARange = random.ints(10);
		boolean ruleApproved = limitedIntStreamWithinARange.findFirst().getAsInt() % 2 == 0;
		
		log.info("MutualFund ID: " + instrument.getId());
		
		if(ruleApproved && hasSuccessor()){
			log.info("Rule approved and has successor!");
			return successor.apply(instrument);
		}
		
		log.info("Returning MutualFundRuleProcessResult!");
		return new MutualFundRuleProcessResult();
	}

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.MUTUAL_FUND;
	}

	@Override
	public String getName() {
		return "MutualFundRuleOne";
	}

	@Override
	public String toString() {
		return "MutualFundRuleOne [getName()=" + getName() + "]";
	}

}