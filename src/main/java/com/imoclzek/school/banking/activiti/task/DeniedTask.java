package com.imoclzek.school.banking.activiti.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.log4j.Logger;

public class DeniedTask implements JavaDelegate {

	private Logger LOG = Logger.getLogger(DeniedTask.class);
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {

		String firstName = (String) execution.getVariable("firstName");
		String lastName = (String) execution.getVariable("lastName");
		
		LOG.info("The loan request for " + firstName + " " + lastName + " has been denied!");
		
	}

}
