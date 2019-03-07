package self.eli.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "self.eli.demo.mapper")
public class EliJarApplication {
    public static void main(String[] args) {
        SpringApplication.run(EliJarApplication.class, args);
    }
}
