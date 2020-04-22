package zhwei.test.domain;

import java.util.List;

/**
 * Ticket: Grade
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/4/13 23:20
 */
public class Grade {
    private Integer gradeid;

    private String gradename;

    private String address;

    private List<Student> studentList;

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeid=" + gradeid +
                ", gradename='" + gradename + '\'' +
                ", address='" + address + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
