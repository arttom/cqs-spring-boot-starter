package pl.atom.spring.cqs.query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SpringQueryAutoConfiguration {

    @Bean
    QueryBus queryBus(ApplicationContext applicationContext) {
        return new InMemoryQueryBus(queryHandlerProvider(applicationContext));
    }

    @Bean
    QueryHandlerProvider queryHandlerProvider(ApplicationContext applicationContext) {
        return new QueryHandlerProvider(applicationContext);
    }
}
