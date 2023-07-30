/*
Team
Thomas Warenski
7/15/2023
This class is designed to aggregate statistics for a whole baseball team. As such is has a roster of players, along with but a few fields for statistics.
*/
public class Team extends NamedEntity{
	private Player[] roster = new Player[100]; /* Uniform numbers can range from 0 to 99. The length 100, while it does waste space, allows each possible uniform number to have it's own spot and provides simple lookup, plus since storage is getting bigger and bigger on computers it's less costly.
 */
	
	private int wins, losses;

	// This is the constructor for an already established team.
	public Team(String name, Player[] roster, int wins, int losses){
		super(name);
		this.roster = roster;
		this.wins = wins;
		this.losses = losses;
	}

	/* This is the constructor for a team being added to the program without any data yet. All statistics are set to 0 and the roster is filled with blank Player instances.
*/
	public Team(String name){
		super(name);
		for(int i = 0; i < 100; i++){
			roster[i] = new Player();
		}
		wins = losses = 0;
	}

	public Team(){
		super();
		for(int i = 0; i < 100; i++){
			roster[i] = new Player();
		}
		wins = losses = 0;
	}

	// Setters, incrementors, and getters. See Player.java for details on the implementation of these varieties of methods.
	public void setPlayer(Player player){
		roster[player.getNumber()] = player;
	}

	public void setWins(int wins){
		this.wins = wins;
	}

	public void setLosses(int losses){
		this.losses = losses;
	}

	public void addWin(){
		wins ++;
	}

	public void addLoss(){
		losses ++;
	}

	public Player getPlayer(int number){
		return roster[number];
	}

	public int getWins(){
		return wins;
	}

	public int getLosses(){
		return losses;
	}

	public String getString(){
		// Initially puts the name and record of the team.
		String strRep = getName() + "(" + wins + "-" + losses + ")\n\n\n";
		// Then it puts every player in the roster.
		for(int i = 0; i < 100; i ++){
			// This selection allows it to ignore any blank Players.
			if(roster[i].getName() != "Nameless"){
				strRep += roster[i].getString();
				strRep += "\n\n";
			}
		}
		return strRep;
	}
}
