package pl.atom.spring.cqs;

import pl.atom.spring.cqs.command.CommandBus;
import pl.atom.spring.cqs.query.QueryBus;

public class BusProvider {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public BusProvider(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    public CommandBus getCommandBus() {
        return commandBus;
    }

    public QueryBus getQueryBus() {
        return queryBus;
    }
}
