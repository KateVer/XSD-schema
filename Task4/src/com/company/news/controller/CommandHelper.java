package com.company.news.controller;

import com.company.news.command.Command;
import com.company.news.command.impl.FindNewsCommand;
import com.company.news.command.impl.SaveNewNewsCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class CommandHelper {
    private Map<CommandName, Command> commands = new HashMap<>();

    CommandHelper() {
        commands.put(CommandName.SAVE_NEW_NEWS, new SaveNewNewsCommand());

        commands.put(CommandName.FIND_NEWS, new FindNewsCommand());
    }

    public Command getCommand(String name){
        CommandName commandName = CommandName.valueOf(name);
        Command command = commands.get(commandName);

        return command;

    }

}
