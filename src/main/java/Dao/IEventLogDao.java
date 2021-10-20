package Dao;

import Dto.EventLog;

import java.io.IOException;

public interface IEventLogDao {
    void log(EventLog ventLog) throws IOException;
}
