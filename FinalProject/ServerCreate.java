package FinalProject;

import java.util.ArrayList;

public class ServerCreate {
	private int IDIncr = 0;
	private ArrayList<Server> fullServList = new ArrayList<Server>(); // List of created servers.
	
	//default constructor
	public ServerCreate() {
		Server s = new Server(IDIncr);
		IDIncr++;
		fullServList.add(s);
	}
	
	@Override
	public String toString() {
		return "TotalServers=" + IDIncr + ", fullServList=" + fullServList;
	}
}