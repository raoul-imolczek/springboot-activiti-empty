package com.imoclzek.school.banking.activiti.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.log4j.Logger;

public class CalculateRiskScoreTask implements JavaDelegate {

	private Logger LOG = Logger.getLogger(CalculateRiskScoreTask.class);
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {

		// Read some variable
		Long loanAmount = (Long) execution.getVariable("loanAmount");
		Long currentBalance = (Long) execution.getVariable("currentBalance");
		Long income = (Long) execution.getVariable("income");
		
		long score = income / (loanAmount + currentBalance);
		
		boolean approved = false;
		boolean denied = false;
		
		if (score > 10) {
			approved = true;
			LOG.info("Loan application automatically approved");
		} else if (score < 5) {
			denied = true;
			LOG.info("Loan application automatically denied");
		} else {
			LOG.info("Loan application requires manual decision");
		}
		
		// Set some variable value
		execution.setVariable("approved", approved);
		execution.setVariable("denied", denied);
		
	}

}
