package pl.atom.spring.cqs.command;

/**
 * Default CommandBus that uses CommandHandlerProvider for resolving proper handler for given Command
 *
 * @author Artur Tomaszewski arttom
 */
class DefaultCommandBus implements CommandBus {

    private final CommandHandlerProvider commandHandlerProvider;

    DefaultCommandBus(CommandHandlerProvider commandHandlerProvider) {
        this.commandHandlerProvider = commandHandlerProvider;
    }

    @Override
    public <C extends Command> void execute(C command) throws NoSuitableCommandHandlerException {
        commandHandlerProvider.getCommandHandler(command)
            .orElseThrow(() -> new NoSuitableCommandHandlerException(command.getClass()))
            .handle(command);
    }
}
