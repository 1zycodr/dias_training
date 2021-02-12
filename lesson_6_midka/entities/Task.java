package lesson_6_midka.entities;

import java.sql.Date;

public class Task {
    private int id;
    private int userId;
    private String text;
    private boolean status;
    private Date start_date;
    private Date post_date;

    public Task() {
    }

    public Task(int id, int userId, String text, boolean status) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.status = status;
    }

    public Task(int userId, String text, boolean status) {
        this.userId = userId;
        this.text = text;
        this.status = status;
    }

    public Task(int id, int userId, String text, boolean status, Date start_date, Date post_date) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.status = status;
        this.start_date = start_date;
        this.post_date = post_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", userId=" + userId +
                ", text='" + text + '\'' +
                ", status=" + status +
                '}';
    }
}
