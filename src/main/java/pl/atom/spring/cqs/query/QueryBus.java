package pl.atom.spring.cqs.query;

public interface QueryBus {

    <R, Q extends Query<R>> R execute(Q query);
}
