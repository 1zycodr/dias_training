package lesson_3.oop;

public class Education {
    private String school;
    private int numOfClasses;
    private String university;
    private String degree;

    public Education() {
    }

    public Education(String school, int numOfClasses, String university, String degree) {
        this.school = school;
        this.numOfClasses = numOfClasses;
        this.university = university;
        this.degree = degree;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getNumOfClasses() {
        return numOfClasses;
    }

    public void setNumOfClasses(int numOfClasses) {
        this.numOfClasses = numOfClasses;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Education{" +
                "school='" + school + '\'' +
                ", numOfClasses=" + numOfClasses +
                ", university='" + university + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}
