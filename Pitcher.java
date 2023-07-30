/*
Pitcher
Thomas Warenski
7/29/2023
The Pitcher class is a subclass of Player, designed specifically for pitchers, with new fields that apply to pitchers. See Player.java for information regarding the application of calculators, setters, incrementors, and getters in these classes.
*/
public class Pitcher extends Player{
	int wins, losses, saves, runsAllowed, innings;
	double ERA;

	// This constructor is useful for a pitcher that already has data for both pitching and batting
	Pitcher(String name, int number, int atBats, int plateAppearances, int singles, int doubles, int triples, int homeRuns, int hits, int runs, int errors, int walks, int steals, int games, char bats, char throwArm, int wins, int losses, int saves, int runsAllowed, int innings){
		super(name, number, atBats, plateAppearances, singles, doubles, triples, homeRuns, hits, runs, errors, walks, steals, games, bats, throwArm);
		this.wins = wins;
		this.losses = losses;
		this.saves = saves;
		this.runsAllowed = runsAllowed;
		this.innings = innings;
		ERA = 9.0 * runsAllowed / innings;
	}

	// This constructor is useful for a pitcher with no batting data, but still with pitching data.
	Pitcher(String name, int number, int errors, int games, char throwArm, int wins, int losses, int saves, int runsAllowed, int innings){
		this(name, number, 0, 0, 0, 0, 0, 0, 0, 0, errors, 0, 0, games, 'R', throwArm, wins, losses, saves, runsAllowed, innings);
	}

	// If a pitcher has no statistics yet, this is the constructor to use.
	Pitcher(String name, int number){
		this(name, number, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'R', 'R', 0, 0, 0, 0, 0);
	}

	// This constructor is for a pitcher with not number or one not yet assigned to a team.
	Pitcher(String name){
		this(name, 0);
	}

	// This is the blank Pitcher constuctor. It is likely unnecessary.
	Pitcher(){
		this("Nameless", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'R', 'R', 0, 0, 0, 0, 0);
	}	

	// Calculators, setters, incrementors, and getters.
	// Single Calculator for the class.
	private void calcERA(){
		ERA = 9.0 * runsAllowed / innings;
	}

	// Setters.
	public void setWins(int wins){
		this.wins = wins;
	}

	public void setLosses(int losses){
		this.losses = losses;
	}

	public void setSaves(int saves){
		this.saves = saves;
	}

	public void setRunsAllowed(int runsAllowed){
		this.runsAllowed = runsAllowed;
	}

	public void setInnings(int innings){
		this.innings = innings;
	}

	// Incrementors.
	public void addRunAllowed(){
		runsAllowed ++;
	}

	public void addInning(){
		innings ++;
	}

	public void addWin(){
		wins ++;
	}

	public void addLoss(){
		losses ++;
	}

	public void addSave(){
		saves ++;
	}

	// Getters.
	public int getRunsAllowed(){
		return runsAllowed;
	}

	public int getInnings(){
		return innings;
	}

	public int getWins(){
		return wins;
	}

	public int getLosses(){
		return losses;
	}

	public int getSaves(){
		return saves;
	}

	public double getERA(){
		calcERA();
		return ERA;
	}

	public String getString(){
		String strRep;

		/* Even with the adoption of designated hitters in the National league, some pitchers, like Shohei Ohtani, still bat, technically playing two positions at once. As such, some pitchers still have batting statistics, but not all. Additionally, youth leagues do not all have DH's, but some do. This selection allows for both scenariors to be represented in the String output.
		*/
		if(getPlateAppearances() == 0){
			strRep = "Pitcher " + getName() + " # " + getNumber()
						 + "\nE: " + getErrors()
						 + "\nG: " + getGames() 
						 + "\nThrows: " + getThrowArm()
						 + "\nW: " + wins
						 + "\nL: " + losses
						 + "\nS: " + saves
						 + "\nRA: " + runsAllowed
						 + "\nIP: " + innings
						 + "\nERA: " + getERA();
		}else{
			strRep = " Pitcher/Batter " + getName() + " # " + getNumber()
						 + "\nG: " + getGames()
						 + "\nAB: " + getAtBats()
						 + "\nPA: " + getPlateAppearances()
						 + "\nR: " + getRuns()
						 + "\nH: " + getHits()
						 + "\nE: " + getErrors()
						 + "\n1B: " + getSingles()
						 + "\n2B: " + getDoubles()
						 + "\n3B: " + getTriples()
						 + "\nHR: " + getHomeRuns()
						 + "\nBB: " + getWalks()
						 + "\nSB: " + getSteals()
						 + "\nOBP: " + getOnBase()
						 + "\nAVG: " + getBatting()
						 + "\nSLG: " + getSlugging()
						 + "\nW: " + wins
						 + "\nL: " + losses
						 + "\nS: " + saves
						 + "\nRA: " + runsAllowed
						 + "\nIP: " + innings
						 + "\nERA: " +getERA()
						 + "\nBats: " + getBats()
						 + "\nThrows: " + getThrowArm();
		}
		return strRep;
	}
}
