package ch.juventus.example;

import ch.juventus.example.data.Employee;
import ch.juventus.example.data.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBootWebApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	@Component
	class initRepositoryCLR implements CommandLineRunner {

		private final EmployeeRepository repository;

		@Autowired
		public initRepositoryCLR(EmployeeRepository repository) {
			this.repository = repository;
		}

		@Override
		public void run(String... strings) throws Exception {
			repository.save(new Employee("Tim", "Taylor"));
			repository.save(new Employee("Al", "Borland"));
			repository.save(new Employee("Wilson", "Wilson"));
			repository.save(new Employee("Bob", "Vila"));
		}
	}
}
