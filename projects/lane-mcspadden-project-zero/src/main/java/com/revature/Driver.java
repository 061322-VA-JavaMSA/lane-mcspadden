package com.revature;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.LoginException;
import com.revature.models.AnimePlush;
import com.revature.models.User;
import com.revature.modelview.ModelViewController;
import com.revature.modelview.pages.FacePage;
import com.revature.services.AuthService;
import com.revature.services.PlushService;
import com.revature.services.UserService;

public class Driver {

	public static Scanner scan;
	public static AuthService as;
	public static UserService us;
	public static PlushService ps;
	public static ModelViewController mvc;
	private static Logger log = LogManager.getLogger(Driver.class);
	
	public static void main(String args[]) {
		ClearConsole();
		initServices();
	}
	
	
	public static void initServices() {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		ps = new PlushService();
		mvc = new ModelViewController();
		FacePage start = new FacePage();
	}
	
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
        	log.error(e);
            System.out.println(e);
        }
    }
	
}
	
	
	
	

