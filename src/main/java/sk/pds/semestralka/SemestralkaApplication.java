package sk.pds.semestralka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("sk.pds.semestralka.mapper")
public class SemestralkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SemestralkaApplication.class, args);
	}
}

