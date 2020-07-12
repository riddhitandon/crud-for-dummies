package io.riddhi.spring.student.entity;

import javax.persistence.*;

@Entity
@Table(
        name = "student"
        //uniqueConstraints = {@UniqueConstraint(columnNames = {"roll_number"})}
)
public class StudentEntity {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id //to make primary key to the column
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(unique = true,name="roll_number")
    private Integer rollNumber;

    @Column(name="info")
    private String info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
