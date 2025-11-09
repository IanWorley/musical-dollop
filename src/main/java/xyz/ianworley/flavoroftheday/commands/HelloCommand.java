package xyz.ianworley.flavoroftheday.commands;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

public class HelloCommand {

    @ShellMethod( key = "hello", value = "Prints 'Hello World!'")
    public String hello(@ShellOption(defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }

    @ShellMethod(key = "goodbye", value = "Prints 'Goodbye'")
    public String goodbye(@ShellOption String name) {
        return "GoodBye " + name + "!";
    }


}
