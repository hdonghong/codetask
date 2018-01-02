package pers.hdh.model;

import java.io.Serializable;

public class Profession implements Serializable {

    private Long id;
    private Long create_at;
    private Long update_at;

    private String job;
    private String description;
    private Integer level;
    private Integer degree;
    private Integer demand;
    private Integer students;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getDemand() {
        return demand;
    }

    public void setDemand(Integer demand) {
        this.demand = demand;
    }

    public Integer getStudents() {
        return students;
    }

    public void setStudents(Integer students) {
        this.students = students;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", job='" + job + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", degree=" + degree +
                ", demand=" + demand +
                ", students=" + students +
                ", message='" + message + '\'' +
                '}';
    }
}
