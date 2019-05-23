package org.lassal.performance.perfdemo;

import org.springframework.boot.ApplicationArguments;

import java.util.List;

public class PerfDemoOptions {

    public static String ARG_NUMBER_EXECUTIONS = "n";
    public static String ARG_TEST_SCENARIO = "test";
    public static String ARG_WEBAPI_URL = "webapiurl";
    public static int DEFAULT_NUMBER_EXECUTIONS = 1000;

    private ApplicationArguments appArgs;
    private Integer numberOfExecutions = null;
    private String webApiUrl = null;

    public PerfDemoOptions(ApplicationArguments args, String defaultWebApiUrl){
        this.appArgs = args;
        this.setWebApiUrl(defaultWebApiUrl);
    }

    public int getNumberOfExecutions(){
        if(this.numberOfExecutions == null){
            this.numberOfExecutions = PerfDemoOptions.DEFAULT_NUMBER_EXECUTIONS;

            if(this.appArgs.containsOption("n")){
                List<String> values = this.appArgs.getOptionValues(PerfDemoOptions.ARG_NUMBER_EXECUTIONS);

                if(values.size() > 0){

                    try{
                        numberOfExecutions = Integer.parseInt(values.get(0));
                    }
                    catch (NumberFormatException nfe){
                        numberOfExecutions = 1000;
                    }

                }
            }
        }

        return this.numberOfExecutions.intValue();

    }

    public String getWebApiUrl(){
        return this.webApiUrl;
    }

    public void setWebApiUrl(String defaultUrl){
        this.webApiUrl = defaultUrl;

        if(this.appArgs.containsOption(PerfDemoOptions.ARG_WEBAPI_URL)){
            List<String> values = this.appArgs.getOptionValues(PerfDemoOptions.ARG_WEBAPI_URL);

            if(values != null && values.size() > 0){
                this.webApiUrl = values.get(0);
            }
        }
    }
}
