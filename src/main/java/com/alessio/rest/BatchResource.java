package com.alessio.rest;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchResource {
	
	@Autowired
    private JobLauncher jobLauncher;
	
	@Autowired
	private Job importUserJob;

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/startBatch")
	public void startBatch() throws Exception {
		jobLauncher.run(importUserJob, new JobParameters());
	}
}
