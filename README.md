# Spring CQS library
spring-boot-started library to allow easily follow CQS principle

# How to use
## Command
Create Command by implementing Command interface

```java
public class ExampleCommand implements Command {
    private final String textToLog;
    // constructor/getters
}
```

Then create Bean Handler for that Command (by default only one allowed)

```java
@Component
public class ExampleCommandHandler implements CommandHandler<ExampleCommand> {

    void handle(ExampleCommand command) {
        log.info(command.getTextToLog());
    }
}
```

Inject somewhere BusProvider and call CommandBus to execute the command

```java
@Service
class ExampleService {
    
    private final BusProvider busProvider;

    void executeExampleCommand() {
        busProvider.getCommandBus().execute(new ExampleCommand("Log this"));
    }
}
```

## Query
Create Query by implementing Query interface

```java
public class ExampleQuery implements Query<String> {
    private final String textToLowercase;
}
```

Then create Bean Handler for that Command (by default only one allowed)

```java
@Component
public class ExampleQueryHandler implements QueryHandler<String, ExampleQuery> {

    String handle(ExampleQuery query) {
        return query.getTextToLowercase().toLowerCase();
    }
}
```

Inject somewhere BusProvider and call CommandBus to execute the command

```java
@Service
class ExampleService {
    
    private final BusProvider busProvider;

    String executeTextExampleQuery() {
        return busProvider.getQueryBus().execute(new ExampleQuery("Make ThIS LOwerCase"));
    }
}
```

# MVN artifact

```xml
<dependency>
  <groupId>com.github.arttom</groupId>
  <artifactId>cqs-spring-boot-starter</artifactId>
  <version>0.1</version>
</dependency>
```
