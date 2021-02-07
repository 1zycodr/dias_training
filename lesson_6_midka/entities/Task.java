package lesson_6_midka.entities;

public class Task {
    private int id;
    private int user_id;
    private String text;
    private boolean status;

    public Task() {
    }

    public Task(int id, int user_id, String text, boolean status) {
        this.id = id;
        this.user_id = user_id;
        this.text = text;
        this.status = status;
    }

    public Task(int user_id, String text, boolean status) {
        this.user_id = user_id;
        this.text = text;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
                ", user_id=" + user_id +
                ", text='" + text + '\'' +
                ", status=" + status +
                '}';
    }
}
