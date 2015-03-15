package practise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}



/*
java -cp hsqldb.jar org.hsqldb.Server -database.0 file:newDbfile -dbname.0 omdb

mvn spring-boot:run

wmic - cmd prompt fgull screen
*/