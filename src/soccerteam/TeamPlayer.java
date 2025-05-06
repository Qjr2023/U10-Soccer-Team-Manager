package soccerteam;

/**
 * The TeamPlayer class extends the BasePlayer class and represents a player in a soccer team.
 * It includes additional attributes such as the player's jersey number and the position they
 * play in the team, and whether they are in the starting lineup.
 */
public class TeamPlayer extends BasePlayer {
  private int jerseyNumber;
  private Position teamPosition;

  /**
   * Constructs a TeamPlayer object with the specified parameters.
   *
   * @param firstName         the first name of the player
   * @param lastName          the last name of the player
   * @param dateOfBirth       the date of birth of the player
   * @param preferredPosition the preferred position of the player
   * @param skillLevel        the skill level of the player
   */
  public TeamPlayer(String firstName, String lastName, String dateOfBirth,
                    Position preferredPosition, SkillLevel skillLevel) {
    super(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
    this.jerseyNumber = 0;
    this.teamPosition = null;
  }

  /**
   * Gets the jersey number of the player.
   *
   * @return the jersey number of the player
   */
  public int getJerseyNumber() {
    return jerseyNumber;
  }

  /**
   * Sets the jersey number of the player.
   *
   * @param jerseyNumber the new jersey number of the player
   */
  protected void setJerseyNumber(int jerseyNumber) {
    this.jerseyNumber = jerseyNumber;
  }

  /**
   * Gets the position of the player in the team.
   *
   * @return the position of the player in the team
   */
  public Position getTeamPosition() {
    return teamPosition;
  }

  /**
   * Sets the position of the player in the team.
   *
   * @param teamPosition the new position of the player in the team
   */
  protected void setTeamPosition(Position teamPosition) {
    this.teamPosition = teamPosition;
  }

  /**
   * Returns a string representation of the player.
   *
   * @param includePosition whether to include the player's position in the team
   * @return a string representation of the player
   */
  public String toString(boolean includePosition) {
    StringBuilder sb = new StringBuilder();
    sb.append(getFullName()).append(" (Jersey #").append(jerseyNumber).append(")");
    if (includePosition && teamPosition != null) {
      sb.append(" - ").append(teamPosition);
    }
    return sb.toString();
  }

  @Override
  public String toString() {
    return toString(false);
  }
}

