package edu.ycp.cs320.myYorkSpace.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.myYorkSpace.client.FriendsService;
import edu.ycp.cs320.myYorkSpace.server.controllers.SiteController;
import edu.ycp.cs320.myYorkSpace.shared.Account;


public class FriendsServiceImpl extends RemoteServiceServlet implements
		FriendsService {

	@Override
	public List<Account> getFriends(String email){
		SiteController controller = new SiteController();
		return controller.getFriendsOfUser(email);
	}

}
 