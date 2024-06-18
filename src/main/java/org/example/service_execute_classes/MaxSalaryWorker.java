package org.example.service_execute_classes;

public class MaxSalaryWorker {
    private String name;

    public MaxSalaryWorker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "name='" + name + '\'' +
                '}';
    }
}
