package com.lmx.demo.launcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author  liumingxin
 * @create   2018/2/26 10:29
 * @desc
 */
@Service
public class MyJobLauncher {

    private final JobLauncher jobLauncher;
    private final Job job;

    private static Logger log = LoggerFactory.getLogger(MyJobLauncher.class);

    @Autowired
    public MyJobLauncher(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    public JobExecution handle() throws Exception {
        JobExecution execution = jobLauncher.run(job, new JobParameters());
        log.info("com.hui.launcher.MyJobLauncher.handle:{}",execution);
        return execution;
    }

}
