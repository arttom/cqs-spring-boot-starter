package pl.atom.spring.cqs.command;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Autoconfiguration for CommandBus. Registers DefaultCommandBus and CommandHandlerProvider if no other present
 * CommandBus is present
 *
 * @author Artur Tomaszewski arttom
 */
@Configuration
class SpringCommandAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(CommandBus.class)
    CommandBus commandBus(ApplicationContext applicationContext) {
        return new DefaultCommandBus(commandHandlerProvider(applicationContext));
    }

    @Bean
    @Lazy
    CommandHandlerProvider commandHandlerProvider(ApplicationContext applicationContext) {
        return new CommandHandlerProvider(applicationContext);
    }
}
