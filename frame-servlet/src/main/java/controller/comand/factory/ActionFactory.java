package controller.comand.factory;

import controller.comand.action.ActionCommand;
import controller.comand.action.impl.EmptyCommand;

public class ActionFactory {
    public ActionCommand defineCommand(String path) {
        ActionCommand current = new EmptyCommand();
        if (path == null || path.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(path.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            return current;
        } catch (Exception ignored) {
        }
        return current;
    }
}
