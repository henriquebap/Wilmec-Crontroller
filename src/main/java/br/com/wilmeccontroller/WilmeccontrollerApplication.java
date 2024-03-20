package br.com.wilmeccontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class WilmeccontrollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WilmeccontrollerApplication.class, args);
	}

	@RequestMapping
	@RequestBody
	public String home() {
		return "Wilmec Controller";
	}
}
