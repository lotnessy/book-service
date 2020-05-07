package ru.zayatc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.zayatc.worker.Worker;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Worker worker1 = new Worker.Builder("John")
                .age(40)
                .build();

        Worker worker = Worker.newBuilder("John")
                .age(35)
                .salary(200.0)
                .department("GovDep")
                .build();

    }
}
