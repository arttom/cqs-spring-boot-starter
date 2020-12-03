package pl.atom.spring.cqs.command;

/**
 * CommandBus provides interface for executing Commands
 *
 * @author Artur Tomaszewski arttom
 */
public interface CommandBus {

    <C extends Command> void execute(C command);
}
