package pl.atom.spring.cqs.command;

class InMemoryCommandBus implements CommandBus {

    private final CommandHandlerProvider commandHandlerProvider;

    InMemoryCommandBus(CommandHandlerProvider commandHandlerProvider) {
        this.commandHandlerProvider = commandHandlerProvider;
    }

    @Override
    public <C extends Command> void execute(C command) {
        commandHandlerProvider.getCommandHandler(command)
            .orElseThrow(() -> new NoSuitableCommandHandlerException(command.getClass()))
            .handle(command);
    }
}
