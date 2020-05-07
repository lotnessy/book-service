package ru.zayatc.worker;

import java.util.Objects;

public class Worker {

    private String firstName;
    private String lastName;
    private String unit;
    private String grade;
    private Double salary;
    private String department;
    private Integer age;

    protected Worker() {
    }

    private Worker(String firstName, String lastName, String unit, String grade, Double salary,
                   String department, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.unit = unit;
        this.grade = grade;
        this.salary = salary;
        this.department = department;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUnit() {
        return unit;
    }

    public String getGrade() {
        return grade;
    }

    public Double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getAge() {
        return age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return firstName.equals(worker.firstName) &&
                Objects.equals(lastName, worker.lastName) &&
                Objects.equals(unit, worker.unit) &&
                Objects.equals(grade, worker.grade) &&
                Objects.equals(salary, worker.salary) &&
                Objects.equals(department, worker.department) &&
                Objects.equals(age, worker.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, unit, grade, salary, department, age);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", unit='" + unit + '\'' +
                ", grade='" + grade + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", age=" + age +
                '}';
    }

    public static Builder newBuilder(String firstName) {
        return new Builder(firstName);
    }

    public static class Builder {
        private final String firstName;
        private String lastName;
        private String unit;
        private String grade;
        private Double salary;
        private String department;
        private Integer age;

        public Builder(String firstName) {
            this.firstName = firstName;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder unit(String unit) {
            this.unit = unit;
            return this;
        }

        public Builder grade(String grade) {
            this.grade = grade;
            return this;
        }

        public Builder salary(Double salary) {
            this.salary = salary;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder age(Integer age) {
            validateAge(age);
            this.age = age;
            return this;
        }

        public Worker build() {
            validateAge(age);
            return new Worker(firstName, lastName, unit, grade, salary, department, age);
        }

        private void validateAge(Integer age) {
            if (age == null) {
                throw new IllegalArgumentException("Age must be specified");
            }
            if (age < 30 || age > 40) {
                throw new IllegalArgumentException("Age should be between 30 - 40");
            }
        }
    }
}
