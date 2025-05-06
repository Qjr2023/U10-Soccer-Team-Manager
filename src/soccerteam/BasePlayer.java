package soccerteam;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The BasePlayer class implements the Player interface and represents a player in a soccer team.
 * It provides methods to retrieve the player's personal information,
 * preferred position on the field, and skill level.
 * It also includes a method to calculate the player's age based on their date of birth.
 */
public class BasePlayer implements Player {
  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private final String firstName;
  private final String lastName;
  private final String dateOfBirth;
  private final Position preferredPosition;
  private final SkillLevel skillLevel;

  /**
   * Constructs a BasePlayer object with the specified firstName, lastName, dateOfBirth,
   * preferredPosition, and skillLevel.
   *
   * @param firstName         the first name of the player
   * @param lastName          the last name of the player
   * @param dateOfBirth       the date of birth of the player
   * @param preferredPosition the preferred position of the player
   * @param skillLevel        the skill level of the player
   */
  public BasePlayer(String firstName, String lastName, String dateOfBirth,
                    Position preferredPosition, SkillLevel skillLevel) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.preferredPosition = preferredPosition;
    this.skillLevel = skillLevel;
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  @Override
  public String getFullName() {
    return firstName + " " + lastName;
  }

  @Override
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  @Override
  public int getAge() {
    try {
      LocalDate birthDate = LocalDate.parse(dateOfBirth, DATE_FORMATTER);
      LocalDate currentDate = LocalDate.now();
      return Period.between(birthDate, currentDate).getYears();
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid date of birth format: " + dateOfBirth, e);
    }
  }

  @Override
  public Position getPreferredPosition() {
    return preferredPosition;
  }

  @Override
  public SkillLevel getSkillLevel() {
    return skillLevel;
  }
}
