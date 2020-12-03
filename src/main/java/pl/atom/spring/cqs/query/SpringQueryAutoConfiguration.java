package pl.atom.spring.cqs.query;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Autoconfiguration for QueryBus. Registers DefaultQueryBus and QueryHandlerProvider if no other present QueryBus is
 * present
 *
 * @author Artur Tomaszewski arttom
 */
@Configuration
class SpringQueryAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(QueryBus.class)
    QueryBus queryBus(ApplicationContext applicationContext) {
        return new DefaultQueryBus(queryHandlerProvider(applicationContext));
    }

    @Bean
    @Lazy
    QueryHandlerProvider queryHandlerProvider(ApplicationContext applicationContext) {
        return new QueryHandlerProvider(applicationContext);
    }
}
