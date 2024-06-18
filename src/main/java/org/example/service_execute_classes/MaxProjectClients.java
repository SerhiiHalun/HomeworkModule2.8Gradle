package org.example.service_execute_classes;

public class MaxProjectClients {
    private String name;
    private int projectCount;

    public MaxProjectClients(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectCliens{" +
                "name='" + name + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
