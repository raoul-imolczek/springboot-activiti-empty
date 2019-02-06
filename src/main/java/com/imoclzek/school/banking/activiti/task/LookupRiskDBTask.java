package com.imoclzek.school.banking.activiti.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.log4j.Logger;

public class LookupRiskDBTask implements JavaDelegate {

	private Logger LOG = Logger.getLogger(LookupRiskDBTask.class);
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {

		// Read some variable
		String firstName = (String) execution.getVariable("firstName");
		String lastName = (String) execution.getVariable("lastName");
		
		long currentBalance;
		
		if ("Fabian".equals(firstName)) {
			currentBalance = 4000;
		} else if ("Andrew".equals(firstName)) {
			currentBalance = 0;
		} else if ("Clément".equals(firstName)) {
			currentBalance = 1000;
		} else if ("Lucas".equals(firstName)) {
			currentBalance = 2000;
		} else {
			currentBalance = 5000;
		}
		
		LOG.info("Consulted current balance for customer " + firstName + " " + lastName + ": " + currentBalance + " €");
		
		// Set some variable value
		execution.setVariable("currentBalance", currentBalance);
		
	}

}
