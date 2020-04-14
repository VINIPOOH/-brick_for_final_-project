package controller.comand.factory;

public class Main {
    public static void main(String[] dd){
        System.out.println(CommandEnum.valueOf("REGISTRATION").getCurrentCommand());
    }
}
