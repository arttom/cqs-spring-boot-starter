package pl.atom.spring.cqs.query;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Autoconfiguration for QueryBus. Registers DefaultQueryBus and QueryHandlerProvider if no other present QueryBus is
 * present
 *
 * @author Artur Tomaszewski arttom
 */
@Configuration
@ConditionalOnMissingBean(QueryBus.class)
class SpringQueryAutoConfiguration {

    @Bean
    QueryBus queryBus(ApplicationContext applicationContext) {
        return new DefaultQueryBus(queryHandlerProvider(applicationContext));
    }

    @Bean
    QueryHandlerProvider queryHandlerProvider(ApplicationContext applicationContext) {
        return new QueryHandlerProvider(applicationContext);
    }
}
