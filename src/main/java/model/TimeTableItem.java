package model;

import java.util.Objects;

public class TimeTableItem {
    private int id;
    private int groupId;
    private int dayOfWeek;
    private String pairIndexView;
    private String dayOfWeekView;
    private int pairInIndex;
    private String content;
    private String header;

    public TimeTableItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        switch (dayOfWeek){
            case 1 : this.dayOfWeekView = "(ПН)";
                break;
            case 2 : this.dayOfWeekView = "(ВТ)";
                break;
            case 3 : this.dayOfWeekView = "(СР)";
                break;
            case 4 : this.dayOfWeekView = "(ЧТ)";
                break;
            case 5 : this.dayOfWeekView = "(ПТ)";
                break;
            case 6 : this.dayOfWeekView = "(СБ)";
                break;
        }
    }

    public int getPairInIndex() {
        return pairInIndex;
    }

    public void setPairInIndex(int pairInIndex) {
        this.pairInIndex = pairInIndex;
        switch (pairInIndex){
            case 1 : this.pairIndexView = "09:30 - 10:50";
                break;
            case 2 : this.pairIndexView = "11:10 - 12:30";
                break;
            case 3 : this.pairIndexView = "13:00 - 14:20";
                break;
            case 4 : this.pairIndexView = "14:40 - 16:00";
                break;
            case 5 : this.pairIndexView = "16:20 - 17:40";
                break;
            case 6 : this.pairIndexView = "18:00 - 19:20";
                break;
            case 7 : this.pairIndexView = "19:40 - 21:00";
                break;
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeader() {
        return "" + this.dayOfWeekView + " " + this.pairIndexView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeTableItem that = (TimeTableItem) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupId, dayOfWeek, pairInIndex, content, header);
    }

    @Override
    public String toString() {
        return "TimeTableItem{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", dayOfWeek=" + dayOfWeek +
                ", pairInIndex=" + pairInIndex +
                ", content=" + content +
                ", header=" + header +
                '}';
    }
}
