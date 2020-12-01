package pl.atom.spring.cqs.query;

import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class QueryHandlerProvider {

    private final Map<Class< ? extends Query<?>>, QueryHandler<?, ? extends Query<?>>> queryHandlers;

    @SuppressWarnings("unchecked")
    QueryHandlerProvider(ApplicationContext context) {
        queryHandlers = context.getBeansOfType(QueryHandler.class)
            .values()
            .stream()
            .map(handler -> Map.entry(resolveQuery(handler), handler))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    @SuppressWarnings("unchecked")
    private <Q extends Query<?>> Class<Q> resolveQuery(QueryHandler<?, Q> handler) {
        Class<?>[] parameters = GenericTypeResolver.resolveTypeArguments(handler.getClass(), QueryHandler.class);
        if (parameters == null) {
            throw new WrongQueryHandlerImplementationException(handler);
        }
        return (Class<Q>) parameters[1];
    }

    @SuppressWarnings("unchecked")
    <Q extends Query<?>> Optional<QueryHandler<?, Q>> getQueryHandler(Q query) {
        return Optional.ofNullable(queryHandlers.get(query.getClass()))
            .map(handler -> (QueryHandler<?, Q>) handler);
    }
}
