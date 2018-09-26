package org.pl.blockchain.ioc;

import java.util.Date;

import org.pl.blockchain.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ="org.pl.blockchain")
public class AppConfig {

	@Bean
	public Person getPerson(){
		return new Person(1,"张三",new Date());
	}
}
