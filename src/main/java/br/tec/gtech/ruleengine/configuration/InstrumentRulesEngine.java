package br.tec.gtech.ruleengine.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.tec.gtech.ruleengine.instrument.InstrumentType;
import br.tec.gtech.ruleengine.rule.InstrumentRule;
import br.tec.gtech.ruleengine.rule.chain.RulesChainBuilder;
import br.tec.gtech.ruleengine.rule.multimap.RulesMultiMap;


@Configuration
public class InstrumentRulesEngine {
	
	@Autowired
	private List<InstrumentRule> instrumentRules;
	
	@Bean
	public Map<InstrumentType, InstrumentRule> instrumentRulesChainMap() {
		RulesMultiMap instrumentRulesConvertersMap = new RulesMultiMap();
	    for (InstrumentRule instrumentRule : instrumentRules) {
	    	instrumentRulesConvertersMap.putObject(instrumentRule.getInstrumentType(), instrumentRule);
	    }
	    
	    Map<InstrumentType, InstrumentRule> rulesChain = new HashMap<>();
	    
	    instrumentRulesConvertersMap.entrySet()
	    							.stream()
	    							.forEach(e -> rulesChain.put(e.getKey(), RulesChainBuilder.buildRuleSetFrom(e.getValue())));
	    
	    return rulesChain;
	}

}