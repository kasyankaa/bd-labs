package com.iot.model.entity;

public class Reporter {
    public Reporter(Integer id, Integer programId, String first_name, String last_name) {
        this.id = id;
        this.programId = programId;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public Reporter(Integer programId, String first_name, String last_name) {

        this.programId = programId;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    private Integer id;
    private Integer programId;
    private String first_name;
    private String last_name;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    @Override
    public String toString() {
        return "Reporter{" +
                "id=" + id +
                ", programId=" + programId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
