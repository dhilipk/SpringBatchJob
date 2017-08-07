package com.studies.sample.reader;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		executeBatchHelloWorldJob();
	  }

	private static void paymentUpdateToStagging() {
		String[] springConfig  = {"job-paymentUpdate-jdbcChunk.xml"};
		
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
			
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job flow = (Job) context.getBean("PaymentProgramJob");

		try {
			JobExecution execution = jobLauncher.run(flow, new JobParametersBuilder().addString("targetFile", "products.txt")
					.addString("targetDirectory", "./work/output/").addString("inputFile", "classpath:zip/input/input.zip").toJobParameters());
			System.out.println("Exit Status : " + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

	private static void decompressTasklet() {
		String[] springConfig  = {"job-decompress-tasklet.xml"};
			
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
			
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job flow = (Job) context.getBean("ImportProductsJob");

		try {
			JobExecution execution = jobLauncher.run(flow, new JobParametersBuilder().addString("targetFile", "products.txt")
					.addString("targetDirectory", "./work/output/").addString("inputFile", "classpath:zip/input/input.zip").toJobParameters());
			System.out.println("Exit Status : " + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

	private static void executeBatchHelloWorldJob() {
		String[] springConfig  = {"job-hello-world.xml"};
			
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
			
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("helloWorldJob");

		try {
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}
}
