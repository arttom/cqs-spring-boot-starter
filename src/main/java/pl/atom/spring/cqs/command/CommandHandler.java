package pl.atom.spring.cqs.command;

/**
 * CommandHandler executes logic of a command. Doesn't return any value.
 *
 * @param <C> class implementing Command.
 * @author Artur Tomaszewski arttom
 */
public interface CommandHandler<C extends Command> {

    void handle(C command);
}
