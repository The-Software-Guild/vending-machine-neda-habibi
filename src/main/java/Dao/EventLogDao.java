package Dao;

import Dto.EventLog;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EventLogDao implements IEventLogDao{
    private static final String FILE_NAME = "EventLog.txt";
    private static final String SEPARATOR = "::";

    public void log(EventLog eventLog) throws IOException {
        PrintWriter out;

        out = new PrintWriter(new FileWriter(FILE_NAME));

        String serializedObject = marshall(eventLog);
        out.println(serializedObject);
        out.flush();
        out.close();
    }

    private String marshall(EventLog eventLog){
        String serializedObject = eventLog.getDate() + SEPARATOR;
        serializedObject += eventLog.getEvent() ;
        return serializedObject;
    }
}
