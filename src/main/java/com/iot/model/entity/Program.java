package com.iot.model.entity;

public class Program {
    private Integer id;

    public Program(Integer companyId, String name, String language) {
        this.companyId = companyId;
        this.language = language;
        this.name = name;

    }


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Program(Integer id, Integer companyId, String language, String name) {
        this.id = id;
        this.companyId = companyId;
        this.language = language;
        this.name = name;
    }

    private Integer companyId;
    private String language;
    private String name;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", language='" + language + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
