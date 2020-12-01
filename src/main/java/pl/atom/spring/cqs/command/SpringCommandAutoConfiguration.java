package pl.atom.spring.cqs.command;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SpringCommandAutoConfiguration {

    @Bean
    CommandBus commandBus(ApplicationContext applicationContext) {
        return new InMemoryCommandBus(commandHandlerProvider(applicationContext));
    }

    @Bean
    CommandHandlerProvider commandHandlerProvider(ApplicationContext applicationContext) {
        return new CommandHandlerProvider(applicationContext);
    }
}
