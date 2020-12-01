package pl.atom.spring.cqs.command;

public interface CommandHandler<C extends Command> {

    void handle(C command);
}
