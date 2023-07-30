/*
Player
Thomas Warenski
7/29/2023
This class is a subclass of abstract class NamedEntity. It adds a lot of fields and getter/setter/incrementor/calculator methods for most of them.
*/
public class Player extends NamedEntity{
	
	private int number, atBats, plateAppearances, singles, doubles, triples, homeRuns, hits, runs, errors, walks, steals, games;
	private double batting, slugging, onBase;
	private char bats, throwArm; // Represented by 'B' for ambidextrous(both) throwing or batting, 'R' and 'L' for right and left handedness.

	/* Constructor with arguments corresponding to every field that isn't calculated. This is the constructer the outside world will use to load saved players' data. 
 */
	public Player(String name, int number, int atBats, int plateAppearances, int singles, int doubles, int triples, int homeRuns, int hits, int runs, int errors, int walks, int steals, int games, char bats, char throwArm){
		super(name);
		this.number = number;
		this.atBats = atBats;
		this.plateAppearances = plateAppearances;
		this.singles = singles;
		this.doubles = doubles;
		this.triples = triples;
		this.homeRuns = homeRuns;
		this.hits = hits;
		this.errors = errors;
		this.walks = walks;
		this.steals = steals;
		this.games = games;
		this.bats = bats;
		this.throwArm = throwArm;

		batting = 1.0 * hits / atBats;
		slugging = (4.0 * homeRuns + 3.0 * triples + 2.0 * doubles + 1.0 * singles) / atBats;
		onBase = 1.0 * (hits + walks) / plateAppearances;
	}

	/* This constructor has only two fields. This will be the most likely one to be used when a new player is added to the system that only has a name and a number.
 */
	public Player(String name, int number){
		this(name, number, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'R', 'R');
	}
	
	/* This constructor may never be used. It only has an argument for name, which may be useful in case a player doesn't have a number or team, but it is unlikely.
 */
	public Player(String name){
		this(name, 0);
	}

	/* This constucter creates a blank "default" Player. This is useful as filler for the Team class' roster field.
 */
	public Player(){
		this("Nameless");
	}

	// Calculators, setters, incrementors, and getters.
	/* Calcs. These methods calculate the value of fields that are wholely dependent on other fields sums/differences/products/quotients/etc.
	*/
	private void calcBatting(){
		batting = 1.0 * hits / atBats;
	}

	private void calcSlugging(){
		slugging = (4.0 * homeRuns + 3.0 * triples + 2.0 * doubles + 1.0 * singles) / atBats;
	}

	private void calcOnBase(){
		onBase = 1.0 * (hits + walks) / plateAppearances;
	}

	/* Setters. Each of these is public and is used to reset the number of whatever.
	*/
	public void setPlateAppearances(int plateAppearances){
		this.plateAppearances = plateAppearances;
	}

	public void setAtBats(int atBats){
		this.atBats = atBats;
	}
	
	public void setHits(int hits){
		this.hits = hits;
	}

	public void setSingles(int singles){
		this.singles = singles;
	}

	public void setDoubles(int doubles){
		this.doubles = doubles;
	}

	public void setTriples(int triples){
		this.triples = triples;
	}

	public void setHomeRuns(int homeRuns){
		this.homeRuns = homeRuns;
	}

	public void setWalks(int walks){
		this.walks = walks;
	}

	public void setRuns(int runs){
		this.runs = runs;
	}

	public void setErrors(int errors){
		this.errors = errors;
	}

	public void setSteals(int steals){
		this.steals = steals;
	}

	public void setGames(int games){
		this.games = games;
	}

	public void setBats(char bats){
		this.bats = bats;
	}

	public void setThrowArm(char throwArm){
		this.throwArm = throwArm;
	}

	/* Incrementors. Each of these is visible to the outside world to add one of whatever at a time. The idea behind these is that the final program can use them to go at bat by at bat and update statistics. Some of these call each other so that only the "most specific" one must be called by the program. ie. a single is a hit, which is an at bat, which is a plate appearance, so they call each other in that order.
 */
	public void addPlateAppearance(){
		plateAppearances ++;
	}

	public void addAtBat(){
		addPlateAppearance();
		atBats ++;
	}

	public void addHit(){
		addAtBat();
		hits ++;
	}

	public void addSingle(){
		addHit();
		singles ++;
	}

	public void addDouble(){
		addHit();
		doubles ++;
	}

	public void addTriple(){
		addHit();
		triples ++;
	}

	public void addHomeRun(){
		addHit();
		addRun();
		homeRuns ++;
	}

	public void addWalk(){
		addAtBat();
		walks ++;
	}

	public void addRun(){
		runs ++;
	}

	public void addError(){
		errors ++;
	}

	public void addSteal(){
		steals ++;
	}

	public void addGame(){
		games ++;
	}

	// Getters. Some of these call calculators to ensure they provide up to date information.
	public double getOnBase(){
		calcOnBase();
		return onBase;
	}

	public double getBatting(){
		calcBatting();
		return batting;
	}

	public double getSlugging(){
		calcSlugging();
		return slugging;
	}
	
	public int getNumber(){
		return number;
	}
	
	public int getPlateAppearances(){
		return plateAppearances;
	}

	public int getAtBats(){
		return atBats;
	}

	public int getHits(){
		return hits;
	}

	public int getSingles(){
		return singles;
	}

	public int getDoubles(){
		return doubles;
	}

	public int getTriples(){
		return triples;
	}

	public int getHomeRuns(){
		return homeRuns;
	}

	public int getWalks(){
		return walks;
	}

	public int getRuns(){
		return runs;
	}

	public int getErrors(){
		return errors;
	}

	public int getSteals(){
		return steals;
	}

	public int getGames(){
		return games;
	}

	public char getBats(){
		return bats;
	}

	public char getThrowArm(){
		return throwArm;
	}

	/* getString() lists every statistic like a baseball card does. This works great for display and for saving data, though a compressed version might be created to save data better.
 */
	public String getString(){
		String strRep = "Fielder " +getName() + " # " + number
									+ "\nG: " + games
									+ "\nAB: " + atBats
									+ "\nPA: " + plateAppearances
									+ "\nR: " + runs
									+ "\nH: " + hits
									+ "\nE: " + errors
									+ "\n1B: " + singles
									+ "\n2B: " + doubles
									+ "\n3B: " + triples
									+ "\nHR: " + homeRuns
									+ "\nBB: " + walks
									+ "\nSB: " + steals
									+ "\nOBP: " + getOnBase()
									+ "\nAVG: " + getBatting()
									+ "\nSLG: " + getSlugging()
									+ "\nBats: " + bats
									+ "\nThrows: " + throwArm;
		return strRep;
	}
}
