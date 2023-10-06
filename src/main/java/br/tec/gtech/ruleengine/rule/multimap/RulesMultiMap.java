package br.tec.gtech.ruleengine.rule.multimap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import br.tec.gtech.ruleengine.instrument.InstrumentType;
import br.tec.gtech.ruleengine.rule.InstrumentRule;

public class RulesMultiMap extends HashMap<InstrumentType, List<InstrumentRule>>{

	private static final long serialVersionUID = 1798660041928375287L;
	
	public void putObject(InstrumentType key, InstrumentRule value){
		List<InstrumentRule> objectsList = this.get(key);
		if(objectsList == null) {
	    	objectsList = new ArrayList<>();
	    	this.put(key,objectsList);
	    }
		objectsList.add(value);
	}

}