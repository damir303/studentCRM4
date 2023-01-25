package dao.timeTable;

import model.TimeTableItem;

import java.util.ArrayList;
import java.util.HashMap;

public interface IDBTimeTable {
    HashMap<String, TimeTableItem> getTimeTable(int groupId);
    TimeTableItem getTimetableByID(int id);
    public void createNewTimetableItem(TimeTableItem timeTableItem);
    public void updateTimetableItem(TimeTableItem timeTableItem);


}
