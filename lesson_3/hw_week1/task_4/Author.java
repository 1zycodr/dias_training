package lesson_3.hw_week1.task_4;

public class Author {
    private String authorName;
    private String email;
    private char gender;

    public Author(String authorName, String email, char gender) {
        this.authorName = authorName;
        this.email = email;
        this.gender = gender;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author[" +
                "name = " + authorName + '\'' +
                ", email = " + email + '\'' +
                ", gender = " + gender +
                ']';
    }
}
