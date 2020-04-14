package controller.comand.factory;

import controller.comand.action.ActionCommand;
import controller.comand.action.impl.EmptyCommand;

public class ActionFactory {
    public ActionCommand defineCommand(String path){
        ActionCommand current = new EmptyCommand();
        if (path == null || path.isEmpty()) {
            return current;
        }
        try {
            System.out.println(path.toUpperCase()+"path to uperkase");
            CommandEnum currentEnum = CommandEnum.valueOf(path.toUpperCase());
            System.out.println(path+4);
            current = currentEnum.getCurrentCommand();
            System.out.println(path+5);
        } catch (IllegalArgumentException e) {
            System.out.println(path+6);
            return current;
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }
        return current;
    }
}
