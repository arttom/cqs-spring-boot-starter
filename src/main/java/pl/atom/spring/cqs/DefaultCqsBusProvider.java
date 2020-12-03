package pl.atom.spring.cqs;

import pl.atom.spring.cqs.command.CommandBus;
import pl.atom.spring.cqs.query.QueryBus;

class DefaultCqsBusProvider implements CqsBusProvider {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public DefaultCqsBusProvider(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @Override
    public CommandBus getCommandBus() {
        return commandBus;
    }

    @Override
    public QueryBus getQueryBus() {
        return queryBus;
    }
}
