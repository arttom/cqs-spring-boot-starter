package pl.atom.spring.cqs;

import org.springframework.stereotype.Component;
import pl.atom.spring.cqs.command.CommandHandler;

@Component
public class TestCommandHandler implements CommandHandler<TestCommand> {

    @Override
    public void handle(TestCommand command) {

    }
}
