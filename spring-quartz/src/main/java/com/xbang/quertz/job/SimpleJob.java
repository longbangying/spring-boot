package com.xbang.quertz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/10/26
 * update date: 2020/10/26
 */
public class SimpleJob extends QuartzJobBean {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("test :{}",jobExecutionContext.getMergedJobDataMap());
    }
}
