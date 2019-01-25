package com.imoclzek.school.banking.activiti.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.log4j.Logger;

public class ExampleTask implements JavaDelegate {

	private Logger LOG = Logger.getLogger(ExampleTask.class);
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {

		// Read some variable
		String readVariable = (String) execution.getVariable("readVariable");
		LOG.info("Read value " + readVariable);
		
		// Set some variable value
		execution.setVariable("writeVariable", "value");
		
	}

}
