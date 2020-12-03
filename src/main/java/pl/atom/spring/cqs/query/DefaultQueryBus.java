package pl.atom.spring.cqs.query;

class DefaultQueryBus implements QueryBus {

    private final QueryHandlerProvider queryHandlerProvider;


    public DefaultQueryBus(QueryHandlerProvider queryHandlerProvider) {
        this.queryHandlerProvider = queryHandlerProvider;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R, Q extends Query<R>> R execute(Q query) {
        return queryHandlerProvider.getQueryHandler(query)
            .map(handler -> handler.handle(query))
            .map(result -> (R) result)
            .orElseThrow(() -> new NoSuitableQueryHandlerException(query));
    }
}
