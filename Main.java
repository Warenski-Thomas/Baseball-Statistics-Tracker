/*
Baseball Record-Keeper
Thomas Warenski
7/29/2023
This program is designed to keep record of baseball statistics. It is a little messy looking, but comments and blank lines should distinguish different sections of the code.
*/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.collections.*;
import javafx.scene.control.CheckBox;
import java.io.File;
import java.io.PrintWriter;

public class Main extends Application { 
	// Main class variables, used by all the methods.
	private Team workingTeam = new Team();
	private Player workingPlayer = new Player();
	private Pitcher workingPitcher = new Pitcher();

	// Several methods created to allow anonymous methods to modify variables(since anonymous functions can only directly reference final variables).

	// Sets the active team to an instance of Team.
	void setTeam(String name){
		workingTeam = new Team(name);
	}

	// Sets the active player to an instance of Player or Pitcher
	void setPlayer(String name, int number, boolean isNew, boolean isPitcher){
		workingTeam.setPlayer(workingPlayer);
		// Creates a new Player or Pitcher if necessary, otherwise pulls up an old one.
		if(isNew){
			if(isPitcher){
				workingPitcher = new Pitcher(name, number);
				workingTeam.setPlayer(workingPitcher);
			}else{
				workingPlayer = new Player(name, number);
				workingTeam.setPlayer(workingPlayer);
			}
		}else{
			if(isPitcher) {
				workingPlayer = (Player)workingTeam.getPlayer(number);
			}else{
				workingPitcher = (Pitcher)workingTeam.getPlayer(number);
			}
		}
	}

	// Allows for modification of the label using information from non-final variables.
	void renameTeamLabel(Label label){
		label.setText("The team you are editing is the " + workingTeam.getName());
	}

	// In essence the same as renameTeamLabel().
	void renamePlayerLabel(Label label){
		label.setText("The player you are editing is the " + workingPlayer.getName());
	}

	// Allows for editing of fields.
	void teamEdit(int selection, int amount){
		switch(selection){
			case 0:
				workingTeam.setWins(amount);
				System.out.println("hi");
				break;
			case 1:
				workingTeam.setLosses(amount);
				break;
			case 2:
				workingTeam.addWin();
				break;
			case 3:
				workingTeam.addLoss();
				break;
		}
	}

	void playerEdit(int selection, int amount){
		switch(selection){
			case 0:
				workingPlayer.setAtBats(amount);
				break;
			case 1:
				workingPlayer.setPlateAppearances(amount);
				break;
			case 2:
				workingPlayer.setSingles(amount);
				break;
			case 3:
				workingPlayer.setDoubles(amount);
				break;
			case 4:
				workingPlayer.setTriples(amount);
				break;
			case 5:
				workingPlayer.setHomeRuns(amount);
				break;
			case 6:
				workingPlayer.setHits(amount);
				break;
			case 7:
				workingPlayer.setRuns(amount);
				break;
			case 8:
				workingPlayer.setErrors(amount);
				break;
			case 9:
				workingPlayer.setWalks(amount);
				break;
			case 10:
				workingPlayer.setSteals(amount);
				break;
			case 11:
				workingPlayer.setGames(amount);
				break;
			case 12:
				workingPlayer.setBats((char)amount);
				break;
			case 13:
				workingPlayer.setThrowArm((char)amount);
				break;
			case 14:
				workingPlayer.addAtBat();
				break;
			case 15:
				workingPlayer.addPlateAppearance();
				break;
			case 16:
				workingPlayer.addSingle();
				break;
			case 17:
				workingPlayer.addSingle();
				break;
			case 18:
				workingPlayer.addDouble();
				break;
			case 19:
				workingPlayer.addTriple();
				break;
			case 20:
				workingPlayer.addHomeRun();
				break;
			case 21:
				workingPlayer.addHit();
				break;
			case 22:
				workingPlayer.addRun();
				break;
			case 23:
				workingPlayer.addError();
				break;
			case 24:
				workingPlayer.addSteal();
				break;
			case 25:
				workingPlayer.addGame();
				break;
		}
	}	

	void pitcherEdit(int selection, int amount){
		switch(selection){
			case 0:
				workingPitcher.setAtBats(amount);
				break;
			case 1:
				workingPitcher.setPlateAppearances(amount);
				break;
			case 2:
				workingPitcher.setSingles(amount);
				break;
			case 3:
				workingPitcher.setDoubles(amount);
				break;
			case 4:
				workingPitcher.setTriples(amount);
				break;
			case 5:
				workingPitcher.setHomeRuns(amount);
				break;
			case 6:
				workingPitcher.setHits(amount);
				break;
			case 7:
				workingPitcher.setRuns(amount);
				break;
			case 8:
				workingPitcher.setErrors(amount);
				break;
			case 9:
				workingPitcher.setWalks(amount);
				break;
			case 10:
				workingPitcher.setSteals(amount);
				break;
			case 11:
				workingPitcher.setGames(amount);
				break;
			case 12:
				workingPitcher.setBats((char)amount);
				break;
			case 13:
				workingPitcher.setThrowArm((char)amount);
				break;
			case 14:
				workingPitcher.setWins(amount);
				break;
			case 15:
				workingPitcher.setLosses(amount);
				break;
			case 16:
				workingPitcher.setSaves(amount);
				break;
			case 17:
				workingPitcher.setRunsAllowed(amount);
				break;
			case 18:
				workingPitcher.setInnings(amount);
				break;
			case 19:
				workingPitcher.addAtBat();
				break;
			case 20:
				workingPitcher.addPlateAppearance();
				break;
			case 21:
				workingPitcher.addSingle();
				break;
			case 22:
				workingPitcher.addDouble();
				break;
			case 23:
				workingPitcher.addTriple();
				break;
			case 24:
				workingPitcher.addHomeRun();
				break;
			case 25:
				workingPitcher.addHit();
				break;
			case 26:
				workingPitcher.addRun();
				break;
			case 27:
				workingPitcher.addError();
				break;
			case 28:
				workingPitcher.addWalk();
				break;
			case 29:
				workingPitcher.addSteal();
				break;
			case 30:
				workingPitcher.addGame();
				break;
			case 31:
				workingPitcher.addWin();
				break;
			case 32:
				workingPitcher.addLoss();
				break;
			case 33:
				workingPitcher.addSave();
				break;
			case 34:
				workingPitcher.addRunAllowed();
				break;
			case 35:
				workingPitcher.addInning();
				break;
		}
	}

	// Sets workingPlayer/workingPitcher back as part of workingTeam.roster to 'save' it.
	void savePlayer(){
		workingTeam.setPlayer(workingPlayer);
	}

	void savePitcher(){
		workingTeam.setPlayer(workingPitcher);
	}

	// Actually saves a file this time. The file has the string representation of workingTeam printed to it.
	void saveTeam(){
		String saveStr = workingTeam.getString();
		try {
			PrintWriter saveFile = new PrintWriter("output.txt");
			saveFile.println(saveStr);
			saveFile.close();
		}catch(Exception ex){}finally {
			System.out.println(saveStr);
		}
	}

	// Functions to rebuild the scenes everytime they switch.
	Scene buildPlayerEditScene(Stage primaryStage){
		// Player editing scene.
		Label playerEditLabel = new Label("The player you are editing is the " + workingPlayer.getName());

		// An array of options that are put into a ComboBox, along with a field to collect data and a submit button.
		String playerSetOptions[] = {"Set At Bats", "Set Plate Appearances", "Set Number of Singles", "Set Number of Doubles", "Set Number of Triples", "Set Number of Home Runs", "Set Number of Hits", "Set Number of Runs", "Set Number of Errors", "Set Number of Walks", "Set Number of Home Steals", "Set Number of Games", "Set Batting Arm", "Set Throwing Arm"};
		ComboBox playerSetCombo = new ComboBox(FXCollections.observableArrayList(playerSetOptions));
		TextField playerSetField = new TextField("");
		Button playerSetSubmit = new Button("Submit");
		playerSetSubmit.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
				playerEdit(playerSetCombo.getSelectionModel().getSelectedIndex(), Integer.valueOf(playerSetField.getText()));
      }
    });
		
		// Groups them together.
		HBox playerSetBox = new HBox(playerSetCombo, playerSetField, playerSetSubmit);

		// Array, ComboBox and Button, but not TextField since these options are all incrementors.
		String playerAddOptions[] = {"Add At Bat", "Add Plate Appearance", "Add Single", "Add Double", "Add Triple", "Add Home Run", "Add Hit", "Add Run", "Add Error", "Add Walk", "Add Steal", "Add Game"};
		ComboBox playerAddCombo = new ComboBox(FXCollections.observableArrayList(playerAddOptions));
		Button playerAddSubmit = new Button("Submit");
		playerAddSubmit.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
				playerEdit(playerAddCombo.getSelectionModel().getSelectedIndex() + 14, 1);
      }
    });
		
		// Groups them together.
		HBox playerAddBox = new HBox(playerAddCombo,  playerAddSubmit);

		Button playerEditSave = new Button("Save");
		playerEditSave.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
				savePlayer();
				primaryStage.setScene(buildTeamEditScene(primaryStage));
      }
    });
		
		// Groups them together.
		VBox playerEditSceneBox = new VBox(playerEditLabel, playerSetBox, playerAddBox, playerEditSave);
		
		return new Scene(playerEditSceneBox);
	}
	
	Scene buildPitcherEditScene(Stage primaryStage){
		// Pitcher editing scene. Mimics the player editing scene, since they have similarities.
		Label pitcherEditLabel = new Label("The player you are editing is the " + workingPlayer.getName());

		// An array of options that are put into a ComboBox, along with a field to collect data and a submit button.
		String pitcherSetOptions[] = {"Set At Bats", "Set Plate Appearances", "Set Number of Singles", "Set Number of Doubles", "Set Number of Triples", "Set Number of Home Runs", "Set Number of Hits", "Set Number of Runs", "Set Number of Errors", "Set Number of Walks", "Set Number of Home Steals", "Set Number of Games", "Set Batting Arm", "Set Throwing Arm", "Set Number of Wins", "Set Number of Losses", "Set Number of Saves", "Set Number of Runs Allowed", "Set Number of Innings"};
		ComboBox pitcherSetCombo = new ComboBox(FXCollections.observableArrayList(pitcherSetOptions));
		TextField pitcherSetField = new TextField("");
		Button pitcherSetSubmit = new Button("Submit");
		pitcherSetSubmit.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
				pitcherEdit(pitcherSetCombo.getSelectionModel().getSelectedIndex(), Integer.valueOf(pitcherSetField.getText()));
      }
    });
		
		// Groups them together.
		HBox pitcherSetBox = new HBox(pitcherSetCombo, pitcherSetField, pitcherSetSubmit);

		// Array, ComboBox and Button, but not TextField since these options are all incrementors.
		String pitcherAddOptions[] = {"Add At Bat", "Add Plate Appearance", "Add Single", "Add Double", "Add Triple", "Add Home Run", "Add Hit", "Add Run", "Add Error", "Add Walk", "Add Steal", "Add Game", "Add Win", "Add Loss", "Add Save", "Add Run Allowed", "Add Inning"};
		ComboBox pitcherAddCombo = new ComboBox(FXCollections.observableArrayList(pitcherAddOptions));
		Button pitcherAddSubmit = new Button("Submit");
		pitcherAddSubmit.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
				pitcherEdit(pitcherAddCombo.getSelectionModel().getSelectedIndex() + 19, 1);
      }
    });
		
		// Groups them together.
		HBox pitcherAddBox = new HBox(pitcherAddCombo,  pitcherAddSubmit);

		Button pitcherEditSave = new Button("Save");
		pitcherEditSave.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
				savePlayer();
				primaryStage.setScene(buildTeamEditScene(primaryStage));
      }
    });
		
		// Groups them together.
		VBox pitcherEditSceneBox = new VBox(pitcherEditLabel, pitcherSetBox, pitcherAddBox, pitcherEditSave);
		
		return new Scene(pitcherEditSceneBox);
	}
	
	Scene buildTeamEditScene(Stage primaryStage){
		// Team editing scene
		Label teamEditLabel = new Label("The team you are editing is the " + workingTeam.getName());

		// An array of options that are put into a ComboBox, along with a field to collect data and a submit button.
		String teamSetOptions[] = {"Set Wins", "Set Losses"};
		ComboBox teamSetCombo = new ComboBox(FXCollections.observableArrayList(teamSetOptions));
		TextField teamSetField = new TextField("");
		Button teamSetSubmit = new Button("Submit");
		teamSetSubmit.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
				System.out.println(teamSetCombo.getSelectionModel().getSelectedIndex());
				teamEdit(teamSetCombo.getSelectionModel().getSelectedIndex(), Integer.valueOf(teamSetField.getText()));
      }
    });
		// Groups them together.
		HBox teamSetBox = new HBox(teamSetCombo, teamSetField, teamSetSubmit);
		
		// Array, ComboBox and Button, but not TextField since these options are all incrementors.
		String teamAddOptions[] = {"Add Win", "Add Loss"};
		ComboBox teamAddCombo = new ComboBox(FXCollections.observableArrayList(teamAddOptions));
		Button teamAddSubmit = new Button("Submit");
		teamAddSubmit.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
				teamEdit((teamAddCombo.getSelectionModel().getSelectedIndex() + 2), 0);
      }
    });
		// Groups them together.
		HBox teamAddBox = new HBox(teamAddCombo, teamAddSubmit);

		// UI for selection a player to edit.
		// Gets a number for the player.
		Label playerEditNumberLabel = new Label("Enter a player number to edit: ");
		TextField playerEditNumberField = new TextField("");
		// Groups them together.
		HBox playerEditNumberBox = new HBox(playerEditNumberLabel, playerEditNumberField);

		// Gets a name, is only used for a new player.
		Label playerEditNameLabel = new Label ("If the player is new, enter their name \nand check the box. Name:");
		TextField playerEditNameField = new TextField("");
		CheckBox playerEditNameCheck = new CheckBox();
		// Groups them together.
		HBox playerEditNameBox = new HBox(playerEditNameLabel, playerEditNameField, playerEditNameCheck);

		// Gets input if the player is a pitcher and has the submit button.
		Label playerIsPitcherLabel = new Label("Check this box if a new pitcher.");
		CheckBox playerIsPitcherCheck = new CheckBox();
		Button playerEditSubmit = new Button("Submit");
		playerEditSubmit.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
				// Sets the new active player.
				if (playerEditNameCheck.isSelected()) {
					setPlayer(playerEditNameField.getText(), Integer.valueOf(playerEditNumberField.getText()), playerEditNameCheck.isSelected(), playerIsPitcherCheck.isSelected());

					// Opens the correct editing scene.
				if(playerIsPitcherCheck.isSelected()){
					primaryStage.setScene(buildPitcherEditScene(primaryStage));
				}else{
					primaryStage.setScene(buildPlayerEditScene(primaryStage));
				}
				}
      }
    });
		// Groups them together.
		HBox submitLineBox = new HBox(playerIsPitcherLabel, playerIsPitcherCheck, playerEditSubmit);

		// Groups them together.
		VBox playerEditBox = new VBox(playerEditNumberBox, playerEditNameBox, submitLineBox);

		Button teamEditSave = new Button("Save");
		teamEditSave.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
				saveTeam();
      }
    });

		// Groups them together.
		VBox teamEditBox = new VBox(teamEditLabel, teamSetBox, teamAddBox, playerEditBox,teamEditSave);
		
		return new Scene(teamEditBox);
	}
	
	Scene buildOpeningScene(Stage primaryStage){
		// Opening scene;
		// Allows to name whatever team is being worked on.
		Label openingLabel = new Label("What is the name of the team you'd like to work with?");
		
		TextField openingText = new TextField("");
		
		Button openingSubmit = new Button("Submit");
		openingSubmit.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
				setTeam(openingText.getText());
				primaryStage.setScene(buildTeamEditScene(primaryStage));
      }
    });

		// Groups them together.
		VBox openingBox = new VBox(openingLabel, openingText, openingSubmit);
		
		return new Scene(openingBox);
	}
  
  @Override
  public void start(Stage primaryStage) {
		primaryStage.setTitle("Baseball Record-Keeper");
    primaryStage.setScene(buildOpeningScene(primaryStage));
    primaryStage.show();
  } 
    
  public static void main(String[] args) {
    launch(args);
  }
} 
