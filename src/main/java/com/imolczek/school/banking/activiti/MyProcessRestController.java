package com.imolczek.school.banking.activiti;

import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imolczek.school.banking.activiti.model.FormInformation;

@RestController
public class MyProcessRestController {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private FormService formService;

	@PostMapping("/start-process")
	public String startProcess(@ModelAttribute FormInformation formInformation) {
	   
	    ProcessInstance instance = runtimeService.startProcessInstanceByKey("myProcess");

	    Task task = taskService.createTaskQuery()
	    	      .processInstanceId(instance.getId())
	    	      .taskDefinitionKey("firstTask")
	    	      .singleResult();

	    Map<String, String> formInformationDataMap = formInformation.getFormInformationDataMap();
	    
		formService.submitTaskFormData(task.getId(), formInformationDataMap);
	    
	    return "Process started with ID: "
	    		+ instance.getId() 
	    		+ "\nNumber of currently running process instances: "
	    		+ runtimeService.createProcessInstanceQuery().count();
	}

}
