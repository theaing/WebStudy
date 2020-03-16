package com.theaking.pojo;

public class Workload {
    private Integer id;

    private Integer personId;

    private Integer projectId;

    private Integer workId;

    private Float workCount;

    private String workRemarks;

    public Workload(Integer id, Integer personId, Integer projectId, Integer workId, Float workCount, String workRemarks) {
        this.id = id;
        this.personId = personId;
        this.projectId = projectId;
        this.workId = workId;
        this.workCount = workCount;
        this.workRemarks = workRemarks;
    }

    public Workload() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Float getWorkCount() {
        return workCount;
    }

    public void setWorkCount(Float workCount) {
        this.workCount = workCount;
    }

    public String getWorkRemarks() {
        return workRemarks;
    }

    public void setWorkRemarks(String workRemarks) {
        this.workRemarks = workRemarks == null ? null : workRemarks.trim();
    }
}