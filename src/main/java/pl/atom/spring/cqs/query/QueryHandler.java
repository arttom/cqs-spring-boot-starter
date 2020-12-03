package pl.atom.spring.cqs.query;

/**
 * QueryHandler executes data fetch. Returns value assigned to the Query.
 *
 * @param <R> Return type of Query
 * @param <Q> class implementing Query
 */
public interface QueryHandler<R, Q extends Query<R>> {

    R handle(Q query);
}
