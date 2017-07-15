package com.proximosolutions.myapplication;

/**
 * Created by Isuru Tharanga on 7/14/2017.
 */

public class MessageHandler {
    String message;
    public void receiveMessage(String message){
        this.message = this.message + message;
    }

    public String getCommand(){
        if(message.contains("^")){
            String[] commands = message.split("^");
            String command = commands[0];
            String command2 = commands[1];
            message = "";
            for(int i =2;i<commands.length;i++){
                message+=(commands[i]);
            }
            return  command+command2;

        }else{
            return "INCOMPLETE";
        }
    }

    public Command decryptCommand(String commandString){
        if(commandString=="INCOMPLETE"){
            return  null;
        }else{
            Command cmd = new Command();
            String[] params = commandString.split(";");
            if(params[0].contains("LEARN")){
                cmd.setP1("LEARN");
            }
            if(params[0].contains("TRANS")){
                cmd.setP1("TRANS");
            }
            cmd.setP2(params[1]);
            cmd.setP3(params[2]);
            cmd.setP4(params[3]);
            cmd.setP5(params[4].substring(0,params[4].length()-3));
            return cmd;
        }
    }

}
