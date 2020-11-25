package com.xybb.entity;

public class Grade {

    private Integer grade_id;
    private Integer user_id;
    private String paper;
    private Integer score;
    private String time;

    public Grade() {
    }

    public Grade(Integer grade_id, Integer user_id, String paper, Integer score, String time) {
        this.grade_id = grade_id;
        this.user_id = user_id;
        this.paper = paper;
        this.score = score;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade_id=" + grade_id +
                ", user_id=" + user_id +
                ", paper='" + paper + '\'' +
                ", score=" + score +
                ", time='" + time + '\'' +
                '}';
    }

    public Integer getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(Integer grade_id) {
        this.grade_id = grade_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
