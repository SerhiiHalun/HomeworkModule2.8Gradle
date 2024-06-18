package org.example.service_execute_classes;


import java.sql.Date;

public class YoungestEldestWorker {
    private String type;
    private String name;
    private Date date;

    public YoungestEldestWorker(String type, String name, Date date) {
        this.type = type;
        this.name = name;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setData(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorker{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
