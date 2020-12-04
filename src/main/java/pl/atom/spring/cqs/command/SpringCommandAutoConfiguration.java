package pl.atom.spring.cqs.command;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Autoconfiguration for CommandBus. Registers DefaultCommandBus and CommandHandlerProvider if no other present
 * CommandBus is present
 *
 * @author Artur Tomaszewski arttom
 */
@Configuration
@ConditionalOnMissingBean(CommandBus.class)
class SpringCommandAutoConfiguration {

    @Bean
    CommandBus commandBus(ApplicationContext applicationContext) {
        return new DefaultCommandBus(commandHandlerProvider(applicationContext));
    }

    @Bean
    CommandHandlerProvider commandHandlerProvider(ApplicationContext applicationContext) {
        return new CommandHandlerProvider(applicationContext);
    }
}
