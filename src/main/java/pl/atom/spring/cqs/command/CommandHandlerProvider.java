package pl.atom.spring.cqs.command;

import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class CommandHandlerProvider {

    private final Map<Class<? extends Command>, CommandHandler<? extends Command>> commandHandlers;

    @SuppressWarnings("unchecked")
    CommandHandlerProvider(ApplicationContext context) {
        commandHandlers = context.getBeansOfType(CommandHandler.class)
            .values()
            .stream()
        .map(handler -> Map.entry(resolveCommand(handler), handler))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    @SuppressWarnings("unchecked")
    private <C extends Command> Class<C> resolveCommand(CommandHandler<C> handler) {
        Class<?> command = GenericTypeResolver.resolveTypeArgument(handler.getClass(), CommandHandler.class);
        return (Class<C>) command;
    }

    @SuppressWarnings("unchecked")
    <C extends Command> Optional<CommandHandler<C>> getCommandHandler(C command) {
        return Optional.ofNullable(commandHandlers.get(command.getClass()))
            .map(handler -> (CommandHandler<C>) handler);
    }
}
