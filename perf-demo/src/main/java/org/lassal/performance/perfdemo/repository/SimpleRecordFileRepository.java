package org.lassal.performance.perfdemo.repository;

import org.lassal.performance.perfdemo.domain.SimpleRecord;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

public class SimpleRecordFileRepository implements Closeable {

    private int commitSize = 1000;
    private PrintWriter writer = null;
    private int recordsWritten = 0;
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void open(String outputFile, boolean append, int commitSize) throws IOException {
        this.commitSize = commitSize;

        FileWriter fileWriter = new FileWriter(outputFile, append);
        this.writer = new PrintWriter(fileWriter);

        this.recordsWritten = 0;
    }

    @Override
    public void close() throws IOException {
        this.writer.close();
    }

    public void save(SimpleRecord record){

        if(this.recordsWritten >= this.commitSize){
            this.commit();
        }
        this.writer.printf("%20s|%18d|%s|%18s|%016.7f|%18s|%18s|%18d|%18s|%s\n"
                ,record.getField1()
                , record.getField2()
                , df.format(record.getField3())
                , record.getField4()
                , record.getField5()
                , record.getField6()
                , record.getField7()
                , record.getField8()
                , record.getField9()
                , df.format(record.getField10()));
        this.recordsWritten++;
    }

    private void commit(){
        this.writer.flush();
        this.recordsWritten = 0;
    }

    public void save(List<SimpleRecord> records){
        for (SimpleRecord rec: records){
            this.save(rec);
        }
    }
}
