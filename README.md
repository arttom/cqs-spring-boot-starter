# Spring CQS library
spring-boot-started library to allow easily follow CQS principle

# How to use
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

    void executeTestCommand() {
        busProvider.getCommandBus().execute(new ExampleCommand("Log this"));
    }
}
```
