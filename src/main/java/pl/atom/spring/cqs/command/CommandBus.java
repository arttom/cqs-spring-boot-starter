package pl.atom.spring.cqs.command;

public interface CommandBus {

    <C extends Command> void execute(C command);
}
