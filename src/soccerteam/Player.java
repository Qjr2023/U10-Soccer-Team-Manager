package soccerteam;

/**
 * The Player interface represents a player in a soccer team.
 * It provides methods to retrieve the player's personal information,
 * preferred position on the field, and skill level.
 */
public interface Player {

  /**
   * Gets the first name of the player.
   *
   * @return the first name of the player
   */
  String getFirstName();

  /**
   * Gets the last name of the player.
   *
   * @return the last name of the player
   */
  String getLastName();

  /**
   * Gets the full name of the player.
   *
   * @return the full name of the player
   */
  String getFullName();

  /**
   * Gets the date of birth of the player.
   *
   * @return the date of birth of the player
   */
  String getDateOfBirth();

  /**
   * Gets the age of the player.
   *
   * @return the age of the player
   */
  int getAge() throws IllegalArgumentException;

  /**
   * Gets the preferred position of the player on the field.
   *
   * @return the preferred position of the player
   */
  Position getPreferredPosition();

  /**
   * Gets the skill level of the player.
   *
   * @return the skill level of the player
   */
  SkillLevel getSkillLevel();
}
