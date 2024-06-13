package com.devpayton;

import java.util.Scanner;

public class Main {
    private static Scanner scannerUtil = new Scanner(System.in);
    public static void main(String[] args) {
        PasswordCreator passwordCreator = new PasswordCreator(promptUserOptions());



    }

    private static int  promptUserOptions(){
        System.out.println("[+] For password length, please choose one of the following options:");
        for ( int i = 1; i <= 7; i ++){
            System.out.print(i + ". Password length of: " + (i + 1) + "\n");
        }
        String userLengthInput = "";
        boolean isPrompting = true;
        while(isPrompting){
             userLengthInput = scannerUtil.nextLine();
            for ( int i = 1; i <= 7; i ++){
                if (userLengthInput.equals(i + "")){
                    isPrompting = false;
                }
                else continue;
            }
            if (isPrompting){
                System.out.println("[+] Invalid has been entered, please try again.");
            }
            

        }
        return Integer.parseInt(userLengthInput);
    }
}
