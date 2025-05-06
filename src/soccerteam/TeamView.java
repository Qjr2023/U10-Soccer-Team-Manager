package soccerteam;

import java.awt.event.ActionListener;
import java.util.List;

/**
 * The TeamView interface provides methods to display the soccer team user interface.
 */
public interface TeamView {

  /**
   * Sets the listener for the add player button.
   *
   * @param listener the ActionListener for the add player button
   */
  void setAddPlayerListener(ActionListener listener);

  /**
   * Sets the listener for the create team button.
   *
   * @param listener the ActionListener for the create team button
   */
  void setCreateTeamListener(ActionListener listener);

  /**
   * Sets the listener for the show all players button.
   *
   * @param listener the ActionListener for the show all players button
   */
  void setShowAllPlayersListener(ActionListener listener);

  /**
   * Sets the listener for the show starting lineup button.
   *
   * @param listener the ActionListener for the show starting lineup button
   */
  void setShowStartingLineupListener(ActionListener listener);

  /**
   * Returns the first name entered by the user.
   *
   * @return the first name entered by the user
   */
  String getFirstName();

  /**
   * Returns the last name entered by the user.
   *
   * @return the last name entered by the user
   */
  String getLastName();

  /**
   * Returns the date of birth entered by the user.
   *
   * @return the date of birth entered by the user
   */
  String getDateOfBirth();

  /**
   * Returns the selected position from the user interface.
   *
   * @return the selected position
   */
  Position getSelectedPosition();

  /**
   * Returns the selected skill level from the user interface.
   *
   * @return the selected skill level
   */
  SkillLevel getSelectedSkillLevel();

  /**
   * Displays the specified message in the user interface.
   *
   * @param message the message to display
   */
  void displayMessage(String message);

  /**
   * Clears the input fields in the user interface.
   */
  void clearInputFields();

  /**
   * Updates the display of the candidates in the user interface.
   *
   * @param candidatesInfo the information about the candidates to display
   */
  void displayCandidates(String candidatesInfo);

  /**
   * Updates the display of the starting lineup in the user interface.
   *
   * @param startingLineup the list of players in the starting lineup
   */
  void displayStartingLineup(List<TeamPlayer> startingLineup);

  /**
   * Updates the display of all players in the user interface.
   *
   * @param players the list of all players
   */
  void displayAllPlayers(List<TeamPlayer> players);

  /**
   * Shows an error dialog with the specified message.
   *
   * @param message the error message to display
   */
  void showErrorDialog(String message);

  /**
   * Displays the user interface.
   */
  void display();
}
