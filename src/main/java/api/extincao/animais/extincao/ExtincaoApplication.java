package api.extincao.animais.extincao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ExtincaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtincaoApplication.class, args);
	}

}
