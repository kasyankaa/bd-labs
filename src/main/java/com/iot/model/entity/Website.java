package com.iot.model.entity;

public class Website {
    private Integer id;
    private String link;

    public Website(Integer id, Integer companyId, String link) {
        this.id = id;
        this.link = link;
        this.companyId = companyId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    private Integer companyId;

    public Website(Integer companyId, String link) {
        this.companyId = companyId;
        this.link = link;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    @Override
    public String toString() {
        return "Website{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
