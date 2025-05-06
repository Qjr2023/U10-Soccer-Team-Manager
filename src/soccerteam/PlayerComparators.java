package soccerteam;

import java.util.Comparator;

/**
 * The PlayerComparators class provides static comparator methods for comparing TeamPlayer objects
 * based on different criteria such as skill level, position, and name.
 */
public class PlayerComparators {

  /**
   * Returns a comparator that compares TeamPlayer objects by their skill level in descending order.
   *
   * @return a comparator for comparing by skill level in descending order
   */
  public static Comparator<TeamPlayer> bySkillInDescending() {
    return Comparator.comparing((TeamPlayer p) -> p.getSkillLevel().getLevel()).reversed();
  }

  /**
   * Returns a comparator that compares TeamPlayer objects by their skill level in ascending order.
   *
   * @return a comparator for comparing by skill level in ascending order
   */
  public static Comparator<TeamPlayer> bySkillInAscending() {
    return Comparator.comparing((TeamPlayer p) -> p.getSkillLevel().getLevel());
  }

  /**
   * Returns a comparator that compares TeamPlayer objects by their preferred position order.
   *
   * @return a comparator for comparing by preferred position order
   */
  public static Comparator<TeamPlayer> byPreferredPosition() {
    return Comparator.comparing((TeamPlayer p) -> p.getPreferredPosition().getOrder());
  }

  /**
   * Returns a comparator that compares TeamPlayer objects by their team position.
   *
   * @return a comparator for comparing by team position
   */
  public static Comparator<TeamPlayer> byTeamPosition() {
    return Comparator.comparing(TeamPlayer::getTeamPosition);
  }

  /**
   * Returns a comparator that compares TeamPlayer objects by their last name.
   *
   * @return a comparator for comparing by last name
   */
  public static Comparator<TeamPlayer> byLastName() {
    return Comparator.comparing(TeamPlayer::getLastName);
  }
}

