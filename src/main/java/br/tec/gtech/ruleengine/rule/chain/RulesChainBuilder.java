package br.tec.gtech.ruleengine.rule.chain;

import java.util.List;

import br.tec.gtech.ruleengine.rule.InstrumentRule;

public final class RulesChainBuilder {
	
	private RulesChainBuilder(){

	}
	
	public static InstrumentRule buildRuleSetFrom(List<InstrumentRule> chainNodes){
		int counter = 0;
		int listSize = chainNodes.size() - 1;
		while(counter < listSize){
			chainNodes.get(counter).setSuccessor(chainNodes.get(counter + 1));
			counter++;
		}
		
		return chainNodes.get(0);
	}

}