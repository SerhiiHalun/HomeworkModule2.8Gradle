package org.example.service_execute_classes;

public class LongestProject {
    private String clientName;
    private int monthCount;

    public LongestProject(String clientName, int monthCount) {
        this.clientName = clientName;
        this.monthCount = monthCount;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "clientName='" + clientName + '\'' +
                ", monthCount=" + monthCount +
                '}';
    }
}
