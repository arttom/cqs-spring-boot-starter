package pl.atom.spring.cqs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import pl.atom.spring.cqs.command.CommandBus;
import pl.atom.spring.cqs.query.QueryBus;

/**
 * Autoconfiguration for CqsBusProvider. Registers DefaultCqsBusProvider if no other present CqsBusProvider is present
 * Lazy to resolve any Circular Dependencies
 *
 * @author Artur Tomaszewski arttom
 */
@Configuration
class SpringBusProviderAutoConfiguration {

    @Bean
    @Lazy
    @ConditionalOnMissingBean(DefaultCqsBusProvider.class)
    DefaultCqsBusProvider busProvider(CommandBus commandBus, QueryBus queryBus) {
        return new DefaultCqsBusProvider(commandBus, queryBus);
    }
}
