package org.lassal.performance.perfdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.lassal.performance.perfdemo.service")
public class PerfDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfDemoApplication.class, args);
	}

}
