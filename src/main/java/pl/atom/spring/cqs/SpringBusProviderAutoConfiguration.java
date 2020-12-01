package pl.atom.spring.cqs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import pl.atom.spring.cqs.command.CommandBus;
import pl.atom.spring.cqs.query.QueryBus;

@Configuration
class SpringBusProviderAutoConfiguration {

    @Bean
    @Lazy
    BusProvider busProvider(CommandBus commandBus, QueryBus queryBus) {
        return new BusProvider(commandBus, queryBus);
    }
}
