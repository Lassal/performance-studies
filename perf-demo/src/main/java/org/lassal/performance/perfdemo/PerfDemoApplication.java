package org.lassal.performance.perfdemo;

import org.lassal.performance.perfdemo.command.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication(scanBasePackages = "org.lassal.performance.perfdemo.*")
public class PerfDemoApplication implements ApplicationRunner {

	@Autowired
	private CommandBuilder commandBuilder;

	private List<Command> commands = new ArrayList<Command>();

	public static void main(String[] args) {
		SpringApplication.run(PerfDemoApplication.class, args);
	}



	@Override
	public void run(ApplicationArguments args) throws Exception {

		int numberOfExecutions = 1000;

		if(args.containsOption("n")){
			List<String> values = args.getOptionValues("n");

			if(values.size() > 0){

				try{
					numberOfExecutions = Integer.parseInt(values.get(0));
				}
				catch (NumberFormatException nfe){
					numberOfExecutions = 1000;
				}

			}
		}

		if(args.containsOption("test")){
            List<String> tests = args.getOptionValues("test");

            for(String test : tests){
            	Command cmd = this.commandBuilder.createPerformanceCommand(test, numberOfExecutions);

            	if(cmd != null){
            		this.commands.add(cmd);
				}
			}
	    }

		if(this.commands.size() < 1){
			this.commands.add( new HelpCommand());
		}

		this.executeCommands();

	}

	private void executeCommands(){

		for(Command cmd : this.commands){
			cmd.execute();
		}
	}
}
