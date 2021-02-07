package lesson_6_midka.entities;

public class Task {
    private int id;
    private int userId;
    private String text;
    private boolean status;

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
