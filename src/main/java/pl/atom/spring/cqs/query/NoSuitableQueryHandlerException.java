package pl.atom.spring.cqs.query;

import pl.atom.spring.cqs.command.Command;

public class NoSuitableQueryHandlerException extends RuntimeException {

    public NoSuitableQueryHandlerException(Class<? extends Query<?>> queryClass) {
        super("No suitable QueryHandler found for: " + queryClass.getCanonicalName());
    }

    public <Q extends Query<?>> NoSuitableQueryHandlerException(Q query) {
        super("No suitable QueryHandler found for: " + query.getClass().getCanonicalName());
    }
}
