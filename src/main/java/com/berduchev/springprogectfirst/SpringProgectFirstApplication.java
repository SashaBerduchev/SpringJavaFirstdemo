package com.berduchev.springprogectfirst;

import com.berduchev.springprogectfirst.Tools.Trace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProgectFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProgectFirstApplication.class, args);
		Trace.writeTrace("Start");
	}
}
