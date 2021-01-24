package lesson_3.hw.task_2;

public class Student extends Person {
    private String program;
    private int year;
    private int fee;

    public Student(String name, String address, String program, int year, int fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student[" +
                super.toString() +
                ", program='" + program + '\'' +
                ", year=" + year +
                ", fee=" + fee +
                ']';
    }
}
