package pl.atom.spring.cqs;

import org.springframework.stereotype.Component;
import pl.atom.spring.cqs.query.QueryHandler;

@Component
public class TestQueryHandler implements QueryHandler<String, TestQuery> {

    @Override
    public String handle(TestQuery query) {
        return "TestMessage";
    }
}
