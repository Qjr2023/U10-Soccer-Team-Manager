package soccerteam;

/**
 * The Position enum represents the different positions a player can have in a soccer team.
 * Each position has a maximum number of players allowed and an order value for sorting purposes.
 */
public enum Position {
  GOALIE(1), DEFENDER(2), MIDFIELDER(3), FORWARD(1);

  private final int maxPlayers;

  /**
   * Constructs a Position enum with the specified maximum number of players.
   *
   * @param maxPlayers the maximum number of players allowed for this position
   */
  Position(int maxPlayers) {
    this.maxPlayers = maxPlayers;
  }

  /**
   * Gets the maximum number of players allowed for this position.
   *
   * @return the maximum number of players
   */
  public int getMaxPlayers() {
    return maxPlayers;
  }

  /**
   * Gets the order value of this position for sorting purposes.
   *
   * @return the order value of the position
   */
  public int getOrder() {
    return ordinal();
  }
}