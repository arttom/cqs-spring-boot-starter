package pl.atom.spring.cqs.query;

public class WrongQueryHandlerImplementationException extends RuntimeException {

    public WrongQueryHandlerImplementationException(QueryHandler<?, ?> handler) {
        super(handler.getClass().getCanonicalName() + " has incorrect implementation");
    }
}
