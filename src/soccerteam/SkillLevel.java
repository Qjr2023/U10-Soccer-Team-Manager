package soccerteam;

/**
 * This enum represents the skill level of a player.
 * Skill levels range from ONE (lowest) to FIVE (highest).
 */
public enum SkillLevel {
  ONE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5);

  private final int level;

  /**
   * Constructs a new SkillLevel with the specified skill level.
   *
   * @param level the skill level of the player
   */
  SkillLevel(int level) {
    this.level = level;
  }

  /**
   * Returns the skill level of the player.
   *
   * @return the skill level of the player
   */
  public int getLevel() {
    return level;
  }
}
