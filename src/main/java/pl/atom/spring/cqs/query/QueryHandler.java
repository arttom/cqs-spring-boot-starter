package pl.atom.spring.cqs.query;

public interface QueryHandler<R, Q extends Query<R>> {

    R handle(Q query);
}
