package com.imolczek.school.banking.activiti.model;

import java.util.HashMap;
import java.util.Map;

public class FormInformation {

	private String info;
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Map<String, String> getFormInformationDataMap() {
		Map<String, String> formInformationDataMap = new HashMap<String, String> ();
		formInformationDataMap.put("info", this.info);
		return formInformationDataMap;
	}

}
