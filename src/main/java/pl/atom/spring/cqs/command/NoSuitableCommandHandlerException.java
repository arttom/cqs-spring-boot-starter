package pl.atom.spring.cqs.command;

public class NoSuitableCommandHandlerException extends RuntimeException {

    public NoSuitableCommandHandlerException(Class<? extends Command> commandClass) {
        super("No suitable CommandHandler found for: " + commandClass.getCanonicalName());
    }
}
