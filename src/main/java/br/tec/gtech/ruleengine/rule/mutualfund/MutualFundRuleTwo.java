package br.tec.gtech.ruleengine.rule.mutualfund;

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
public class MutualFundRuleTwo extends InstrumentRule {

	private static final String MUTUAL_FUND_RULE_TWO = "MutualFundRuleTwo";

	@Override
	public InstrumentType getInstrumentType() {
		return InstrumentType.MUTUAL_FUND;
	}

	@Override
	public String toString() {
		return "MutualFundRuleTwo [getName()=" + getName() + "]";
	}

	@Override
	public String getName() {
		return MUTUAL_FUND_RULE_TWO;
	}

	@Override
	public void doApply(Instrument instrument, RuleProcessResult ruleProcessResult) {
		Random random = new Random();
		IntStream limitedIntStreamWithinARange = random.ints(10);
		boolean ruleNotApproved = limitedIntStreamWithinARange.findFirst().getAsInt() % 2 == 0;
		
		if(ruleNotApproved) {
			ruleProcessResult.add(new RuleValidationError(MUTUAL_FUND_RULE_TWO,"Validation failed!"));
		}
		
	}

}