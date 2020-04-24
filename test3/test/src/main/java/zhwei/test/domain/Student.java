package zhwei.test.domain;

/**
 * Ticket: Student
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/4/13 23:17
 */
public class Student {
    private Integer studentno;

    private String name;

    private String sex;

    private Integer age;

    private Integer phone;

    //当前学生属于哪一个班级
    private Integer gradeid;

    private Grade grade;

    public Integer getStudentno() {
        return studentno;
    }

    public void setStudentno(Integer studentno) {
        this.studentno = studentno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentno=" + studentno +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", gradeid=" + gradeid +
                ", grade=" + grade +
                '}';
    }
}
