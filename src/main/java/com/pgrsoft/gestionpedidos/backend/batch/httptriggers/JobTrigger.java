package com.pgrsoft.gestionpedidos.backend.batch.httptriggers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobTrigger {

	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	@Qualifier(value="importCamareroJob")
	Job job;
	
	@RequestMapping("/job1")
	public String triggerJob1() throws Exception{
		
		JobParameter jobParameter = new JobParameter(new Date().toString() + (int)(Math.random() * 1000));
		Map<String, JobParameter> parametersMap = new HashMap<String, JobParameter>();
		parametersMap.put("parametro1", jobParameter);
		jobLauncher.run(job, new JobParameters(parametersMap));
		return "job1 disparado...";
	}
	
}
