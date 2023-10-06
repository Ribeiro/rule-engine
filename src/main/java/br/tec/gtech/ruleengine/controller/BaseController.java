package br.tec.gtech.ruleengine.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.tec.gtech.ruleengine.instrument.InstrumentType;
import br.tec.gtech.ruleengine.instrument.MutualFund;
import br.tec.gtech.ruleengine.rule.InstrumentRule;
import br.tec.gtech.ruleengine.rule.RuleProcessResult;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BaseController {

	@Resource()
	private Map<InstrumentType, InstrumentRule> chainRules;
	
	@GetMapping
	public String demo() {
		MutualFund mutualFund = new MutualFund();
		log.info("MutualFund ID: " + mutualFund.getId());
		RuleProcessResult ruleProcessResult = chainRules.get(mutualFund.getTtype()).apply(mutualFund);
		log.info("RuleProcessResult Class: "+ ruleProcessResult.getName());
		return ("Done!");
	}
}