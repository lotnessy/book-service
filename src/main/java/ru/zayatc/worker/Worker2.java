package ru.zayatc.worker;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Worker2 {

    @Setter(AccessLevel.NONE)
    private String firstName;

    private String lastName;
    private String unit;
    private String grade;
    private Double salary;
    private String department;
    private Integer age;

    public static Builder newBuilder(String firstName) {
        return new Builder(firstName);
    }

    @Setter
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    public static class Builder {
        private static final int MIN_AGE = 30;
        private static final int MAX_AGE = 40;

        private final String firstName;
        private String lastName;
        private String unit;
        private String grade;
        private Double salary;
        private String department;
        private Integer age;

        public Builder age(Integer age) {
            validateAge(age);
            this.age = age;
            return this;
        }

        public Worker2 build() {
            validateAge(age);
            return new Worker2(firstName, lastName, unit, grade, salary, department, age);
        }

        private void validateAge(Integer age) {
            if (age == null) {
                throw new IllegalArgumentException("Age must be specified");
            }
            if (age < MIN_AGE || age > MAX_AGE) {
                throw new IllegalArgumentException(String.format("Age must be between %d and %d", MIN_AGE, MAX_AGE));
            }
        }
    }
}
