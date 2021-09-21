package com.jeebon.etransaction.etransactionapp;

import com.jeebon.etransaction.etransactionapp.threads.SummaryTransThreadService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class EtransactionappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtransactionappApplication.class, args);
	}


	@Bean(name = "taskExecutor")
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(100);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setThreadNamePrefix("Async-");
		executor.initialize();
		return executor;


	}

	@Configuration
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity security) throws Exception
		{
			security.httpBasic().disable();
		}
	}

	@Bean
	CommandLineRunner init(
			SummaryTransThreadService summaryTransThreadService
	) {
		return (args) -> {
			try{
				summaryTransThreadService.init();
			} catch (Exception e){
				System.out.println("Thread Error: ");
				System.out.println(e);
			}
		};
	}
	
}
