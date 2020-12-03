package pl.atom.spring.cqs;

import pl.atom.spring.cqs.command.CommandBus;
import pl.atom.spring.cqs.query.QueryBus;

public interface CqsBusProvider {

    QueryBus getQueryBus();

    CommandBus getCommandBus();
}
