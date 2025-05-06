package soccerteam;

import java.util.List;

/**
 * The SwingTeamController class implements the TeamController interface for managing a U10 soccer
 * team. It allows users to add players to the team, create the team, and display the list of all
 * players and the starting lineup. It interacts with the TeamModel and TeamView to update the data
 * and the user interface.
 */
public class SwingTeamController implements TeamController {
  private final TeamModel model;
  private final TeamView view;

  /**
   * Constructs a new SwingTeamController with the specified model and view.
   *
   * @param model the team model to be managed by this controller
   * @param view the team view to be managed by this controller
   * @throws IllegalArgumentException if the model or view is null
   */
  public SwingTeamController(TeamModel model, TeamView view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Model and View can't be null");
    }
    this.model = model;
    this.view = view;

    view.setAddPlayerListener(e -> addPlayer());
    view.setCreateTeamListener(e -> createTeam());
    view.setShowAllPlayersListener(e -> showAllPlayers());
    view.setShowStartingLineupListener(e -> showStartingLineup());
  }

  /**
   * Adds a player to the team. The method retrieves the player information from the view, validates
   * the input, and updates the model accordingly. It also refreshes the view to display the updated
   * list of candidates.
   */
  private void addPlayer() {
    try {
      String firstName = view.getFirstName();
      String lastName = view.getLastName();
      String dateOfBirth = view.getDateOfBirth();
      Position position = view.getSelectedPosition();
      SkillLevel skillLevel = view.getSelectedSkillLevel();

      TeamPlayer player = new TeamPlayer(firstName, lastName, dateOfBirth, position, skillLevel);
      boolean added = model.addPlayer(player);

      if (added) {
        view.displayMessage("Player added successfully.");
        view.clearInputFields();
        updateCandidatesDisplay();
      } else {
        view.showErrorDialog("Player could not be added. Team is full and new player's "
            + "skill level is not higher than any existing player.");
      }
    } catch (IllegalArgumentException e) {
      view.showErrorDialog("Error: " + e.getMessage());
    }
  }

  @Override
  public void createTeam() {
    try {
      List<TeamPlayer> allPlayers = model.getAllPlayers();
      if (allPlayers.size() >= 10) {
        view.displayMessage("Team created successfully.");
      } else {
        view.displayMessage("Error: Not enough players to create a team. Minimum 10 players "
            + "required.");
      }
    } catch (IllegalStateException e) {
      view.showErrorDialog("Error: " + e.getMessage());
    }
  }

  /**
   * Shows all players in the team. The method retrieves the list of all players from the model and
   * updates the view to display the list.
   */
  private void showAllPlayers() {
    updateAllPlayersDisplay();
  }

  /**
   * Shows the starting lineup of the team. The method retrieves the starting lineup from the model
   * and updates the view to display the lineup.
   */
  private void showStartingLineup() {
    updateStartingLineupDisplay();
  }

  /**
   * Updates the candidates display in the view.
   */
  private void updateCandidatesDisplay() {
    List<TeamPlayer> candidates = model.getCandidates();
    StringBuilder sb = new StringBuilder();
    int index = 1;
    for (TeamPlayer player : candidates) {
      sb.append(String.format("%d. %s %s (age: %d, skill: %s) - %s%n",
          index++,
          player.getFirstName(),
          player.getLastName(),
          player.getAge(),
          player.getSkillLevel().getLevel(),
          player.getPreferredPosition()));
    }
    view.displayCandidates(sb.toString());
  }

  /**
   * Updates the starting lineup display in the view.
   */
  private void updateStartingLineupDisplay() {
    try {
      List<TeamPlayer> startingLineup = model.getStartingLineup();
      view.displayStartingLineup(startingLineup);
    } catch (IllegalStateException e) {
      view.showErrorDialog("Error: " + e.getMessage());
    }
  }

  /**
   * Updates the all players display in the view.
   */
  private void updateAllPlayersDisplay() {
    try {
      List<TeamPlayer> allPlayers = model.getAllPlayers();
      view.displayAllPlayers(allPlayers);
    } catch (IllegalStateException e) {
      view.showErrorDialog("Error: " + e.getMessage());
    }
  }
}