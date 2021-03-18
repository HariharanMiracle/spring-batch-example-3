package com.darkdevil.springbatchexample3.controller;


import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/batchStart")
public class BatchStartContoller {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping
    public boolean start() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException{
        try{
            Map<String, JobParameter> maps = new HashMap<>();
            maps.put("time", new JobParameter(System.currentTimeMillis()));
            JobParameters parameters = new JobParameters(maps);
            JobExecution jobExecution = jobLauncher.run(job, parameters);

            System.out.println("JobExecution: " + jobExecution.getStatus());

            System.out.println("Batch is running");
            while(jobExecution.isRunning()){
                System.out.println("...");
            }

            System.out.println(jobExecution.getStatus());

            return true;
        }
        catch (Exception e){
            System.out.println("BatchStartContoller => start: error");
            e.printStackTrace();
            return false;
        }
    }

}
