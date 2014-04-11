package edu.ycp.cs320.myYorkSpace.server.controllers;

import java.util.ArrayList;

import edu.ycp.cs320.myYorkSpace.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.myYorkSpace.shared.Account;
import edu.ycp.cs320.myYorkSpace.shared.Site;

public class SiteController {
	//returns the 
	public Account logIn(String email, String password){
		return DatabaseProvider.getInstance().logIn(email, password);
	}
	public void addUser(Account account) {
		if(verifyUser(account)){
			DatabaseProvider.getInstance().addUser(account);
		}
		else{
			System.out.print("not a valid account");
		}
	}
	
	
	public boolean verifyUser(Account user){
		if(validEmail(user.getEmail())&&validPassword(user.getPassword())) return true;
		else return false;
	}
	public boolean validEmail(String email){
		boolean valid = false;
		if(email.contains("@")&&(email.contains(".edu"))) valid=true;
		return valid;
	}
	public boolean validPassword(String password){
		//password must be at least 5 characters long
		if(password.length()<5)return false;
		//password must be sequence of numbers between 0-9 or capitol/lower case letters.
		boolean valid = true;
		for(int i = 0; i<password.length()-1; i++){
			if(!(password.charAt(i) >= '0' && password.charAt(i) <= '9')&&!(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')&& !(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')) valid=false;
		}
		return valid; 
	}

}
