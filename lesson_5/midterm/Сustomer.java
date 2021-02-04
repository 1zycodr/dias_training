package lesson_5.midterm;

public class Сustomer {
    private String name;
    private boolean member = false;
    private String memberType;

    public Сustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return "Сustomer{" +
                "name='" + name + '\'' +
                ", member=" + member +
                ", memberType='" + memberType + '\'' +
                '}';
    }
}
