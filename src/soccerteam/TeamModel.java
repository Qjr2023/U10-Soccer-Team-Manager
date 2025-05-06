package soccerteam;

import java.util.List;

/**
 * The TeamModel interface represents the model of a soccer team.
 * It provides methods to add a player to the team, retrieve all players,
 * and get the starting lineup.
 */
public interface TeamModel {

  /**
   * Adds a player to the team. The method may also update the starting lineup if necessary.
   *
   * @param player the player to be added to the team
   * @return true if the player was successfully added, false otherwise
   * @throws IllegalArgumentException if the player is not eligible to join the team
   * @throws IllegalStateException    if the team is invalid to select Starting Lineup
   *                             or if all positions are full when assigning a player to a position
   */
  boolean addPlayer(TeamPlayer player) throws IllegalArgumentException, IllegalStateException;

  /**
   * Retrieves the candidates for the team.
   *
   * @return a list of players who are candidates for the team
   */
  List<TeamPlayer> getCandidates();

  /**
   * Retrieves all players on the team.
   *
   * @return a list of all players on the team
   * @throws IllegalStateException if the team is invalid
   */
  List<TeamPlayer> getAllPlayers() throws IllegalStateException;

  /**
   * Retrieves the starting lineup for the team.
   *
   * @return a list of players in the starting lineup
   * @throws IllegalStateException if the team is invalid
   */
  List<TeamPlayer> getStartingLineup() throws IllegalStateException;
}
