package unis.palmfarm;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;

import javax.persistence.EntityManager;

@EnableJpaAuditing
@SpringBootApplication
public class PalmfarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(PalmfarmApplication.class, args);
	}
	@Bean
	public JPAQueryFactory jPAQueryFactory (EntityManager em){
		return new JPAQueryFactory(em);
	}
}
