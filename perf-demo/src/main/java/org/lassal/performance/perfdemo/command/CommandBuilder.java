package org.lassal.performance.perfdemo.command;

import org.h2.server.web.WebApp;
import org.lassal.performance.perfdemo.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommandBuilder {

    Logger logger = LoggerFactory.getLogger(CommandBuilder.class);

    @Autowired
    private CNPJService cnpjService;

    @Autowired
    private DBService dbService;

    @Autowired
    private FileService fileService;

    @Autowired
    private FindMethodsService findMethodsService;

    @Autowired
    private WebRESTService webRESTService;

    private String webApiURL;

    public Command createPerformanceCommand(String requestedTest, int numberOfExecutions){

        if(requestedTest != null){
            PerfDemoCommands cmd = null;
            try{
                cmd = PerfDemoCommands.valueOf(requestedTest);
            }
            catch (IllegalArgumentException iax){
                logger.error("Test not found : " + requestedTest + "  {IGNORING}");
            }

            if(cmd != null){

                switch (cmd){
                    case OnlyCPU : return new DoCPUOnlyProcessingCommand(numberOfExecutions, this.cnpjService);
                    case FileWrite: return new WriteRecordToFileCommand(numberOfExecutions, this.fileService );
                    case DBWrite:  return new WriteRecordToDBCommand(numberOfExecutions, this.dbService);
                    case DBWrite10Indx: return new WriteRecordToDB10IndexesCommand(numberOfExecutions, this.dbService);
                    case WebApiCall: return  new DoWebApiCallCommand(this.webApiURL, numberOfExecutions, this.webRESTService);
                    case FindInList: return new FindInListCommand(numberOfExecutions, this.findMethodsService);
                    case FindInHash: return  new FindInMapCommand(numberOfExecutions, this.findMethodsService);
                }
            }
        }
        return null;
    }

    public void setWebApiUrl(String webApiUrl) {
        this.webApiURL = webApiUrl;
    }
}
