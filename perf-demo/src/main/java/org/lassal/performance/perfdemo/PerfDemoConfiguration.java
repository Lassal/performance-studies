package org.lassal.performance.perfdemo;

import org.lassal.performance.perfdemo.command.CommandBuilder;
import org.lassal.performance.perfdemo.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("org.lassal.performance.perfdemo")
public class PerfDemoConfiguration {

    @Bean
    public CNPJService cnpjService(){
        return new CNPJService();
    }

    @Bean
    public DBService dbService(){
        return new DBService();
    }

    @Bean
    public FileService fileService(){
        return new FileService();
    }

    @Bean
    public FindMethodsService findMethodService(){
        return new FindMethodsService();
    }

    @Bean
    public WebRESTService webRESTService(){
        return new WebRESTService();
    }

    @Bean
    public CommandBuilder commandBuilder(){
        return new CommandBuilder();
    }
}
