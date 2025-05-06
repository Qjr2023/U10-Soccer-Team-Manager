package soccerteam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The TeamModelImpl class implements the TeamModel interface and represents a soccer team.
 * It manages the players in the team, handles the starting lineup, and provides team information.
 */
public class TeamModelImpl implements TeamModel {
  private static final int MINIMUM_AGE = 0;
  private static final int MAXIMUM_AGE = 10;
  private static final int MINIMUM_PLAYERS = 10;
  private static final int MAXIMUM_PLAYERS = 20;
  private static final int STARTING_LINEUP_SIZE = 7;
  private final List<TeamPlayer> candidates;
  private final List<TeamPlayer> players;
  private final List<TeamPlayer> startingLineup;
  private final Random random = new Random();

  /**
   * Constructs a new TeamModelImpl object.
   */
  public TeamModelImpl() {
    candidates = new ArrayList<>();
    players = new ArrayList<>();
    startingLineup = new ArrayList<>();
  }

  @Override
  public boolean addPlayer(TeamPlayer player) throws IllegalArgumentException {
    if (player.getAge() < MINIMUM_AGE || player.getAge() >= MAXIMUM_AGE) {
      throw new IllegalArgumentException("Player age must be between 0 and 10.");
    }
    boolean added = false;
    if (players.size() < MAXIMUM_PLAYERS) {
      added = players.add(player);
      assignJerseyNumber(player);
      candidates.add(copyPlayer(player));
      if (players.size() >= MINIMUM_PLAYERS) {
        selectStartingLineup();
      }
    } else {
      added = replaceLowestSkillPlayer(player);
      if (added) {
        candidates.add(copyPlayer(player));
      }
    }
    return added;
  }

  /**
   * Replaces the lowest skill level player in the team with a new player if the new player has a
   * higher skill level.
   *
   * @param newPlayer the new player to add to the team
   * @return true if the player was added, false otherwise
   */
  private boolean replaceLowestSkillPlayer(TeamPlayer newPlayer) {
    TeamPlayer lowestSkillPlayer = players.stream()
        .min(PlayerComparators.bySkillInAscending()
            .thenComparing(PlayerComparators.byPreferredPosition())
            .thenComparing(PlayerComparators.byLastName()))
        .orElse(null);

    if (lowestSkillPlayer != null
        && newPlayer.getSkillLevel().compareTo(lowestSkillPlayer.getSkillLevel()) > 0) {
      players.remove(lowestSkillPlayer);
      players.add(newPlayer);
      assignJerseyNumber(newPlayer);
      selectStartingLineup();
      return true;
    }
    return false;
  }

  /**
   * Assigns a unique jersey number to the player.
   *
   * @param player the player to assign a jersey number to
   * @throws IllegalStateException if no available jersey numbers are found
   */
  private void assignJerseyNumber(TeamPlayer player) {
    List<Integer> availableNumbers = getAvailableJerseyNumbers();
    if (availableNumbers.isEmpty()) {
      throw new IllegalStateException("No available jersey numbers");
    }

    int randomIndex = random.nextInt(availableNumbers.size());
    int jerseyNumber = availableNumbers.get(randomIndex);
    player.setJerseyNumber(jerseyNumber);
  }

  /**
   * Gets a list of available jersey numbers that are not currently assigned to any player.
   *
   * @return a list of available jersey numbers
   */
  private List<Integer> getAvailableJerseyNumbers() {
    Set<Integer> usedNumbers = players.stream()
        .map(TeamPlayer::getJerseyNumber)
        .collect(Collectors.toSet());

    return IntStream.rangeClosed(1, 20)
        .filter(i -> !usedNumbers.contains(i))
        .boxed()
        .collect(Collectors.toList());
  }

  /**
   * Selects the starting lineup based on the players' skill levels and preferred positions.
   * The starting lineup is limited to a predefined size.
   * @throws IllegalStateException if the team is not valid
   */
  private void selectStartingLineup() throws IllegalStateException {
    validateTeam();
    startingLineup.clear();

    // Initialize position counters
    Map<Position, Integer> positionCounts = new EnumMap<>(Position.class);
    for (Position position : Position.values()) {
      positionCounts.put(position, 0);
    }

    // Sort all players by skill level, position, and last name
    List<TeamPlayer> sortedPlayers = players.stream()
        .sorted(PlayerComparators.bySkillInDescending()
            .thenComparing(PlayerComparators.byPreferredPosition())
            .thenComparing(PlayerComparators.byLastName()))
        .toList();

    // First pass: Fill preferred positions as much as possible
    for (TeamPlayer player : sortedPlayers) {
      Position preferredPosition = player.getPreferredPosition();
      if (startingLineup.size() < STARTING_LINEUP_SIZE && positionCounts.get(preferredPosition)
          < preferredPosition.getMaxPlayers()) {
        startingLineup.add(player);
        positionCounts.put(preferredPosition, positionCounts.get(preferredPosition) + 1);
        player.setTeamPosition(preferredPosition);
      }
    }

    // Second pass: Fill remaining positions
    for (TeamPlayer player : sortedPlayers) {
      if (startingLineup.size() < STARTING_LINEUP_SIZE && !startingLineup.contains(player)) {
        Position position = determinePositionForRemaining(player, positionCounts);
        startingLineup.add(player);
        positionCounts.put(position, positionCounts.get(position) + 1);
        player.setTeamPosition(position);
      }
    }
  }

  /**
   * Determines the position for a player based on their preferred position and the current
   * counts of players in each position.
   *
   * @param player the player to determine the position for
   * @param positionCounts the current counts of players in each position
   * @return the determined position for the player
   * @throws IllegalStateException if all positions are full
   */
  private Position determinePositionForRemaining(TeamPlayer player,
                                                 Map<Position, Integer> positionCounts)
      throws IllegalStateException {
    Position preferredPosition = player.getPreferredPosition();
    if (positionCounts.get(preferredPosition) < preferredPosition.getMaxPlayers()) {
      return preferredPosition;
    }

    return Arrays.stream(Position.values())
        .filter(p -> positionCounts.get(p) < p.getMaxPlayers())
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("All positions are full"));
  }

  /**
   * Creates a deep copy of a player.
   *
   * @param player the player to copy
   * @return a copy of the player
   */
  private TeamPlayer copyPlayer(TeamPlayer player) {
    TeamPlayer copy = new TeamPlayer(player.getFirstName(), player.getLastName(),
        player.getDateOfBirth(), player.getPreferredPosition(), player.getSkillLevel());
    copy.setJerseyNumber(player.getJerseyNumber());
    copy.setTeamPosition(player.getTeamPosition());
    return copy;
  }

  @Override
  public List<TeamPlayer> getCandidates() {
    return candidates.stream()
        .map(this::copyPlayer)
        .collect(Collectors.toList());
  }

  @Override
  public List<TeamPlayer> getAllPlayers() throws IllegalStateException {
    validateTeam();
    return players.stream()
        .sorted(PlayerComparators.byLastName())
        .map(this::copyPlayer)
        .collect(Collectors.toList());
  }

  @Override
  public List<TeamPlayer> getStartingLineup() throws IllegalStateException {
    validateTeam();
    return startingLineup.stream()
        .sorted(PlayerComparators.byTeamPosition()
            .thenComparing(PlayerComparators.byLastName()))
        .map(this::copyPlayer)
        .collect(Collectors.toList());
  }

  /**
   * Validates the team to ensure it has the correct number of players.
   *
   * @throws IllegalStateException if the team size is invalid
   */
  private void validateTeam() throws IllegalStateException {
    if (players.size() < MINIMUM_PLAYERS
        || players.size() > MAXIMUM_PLAYERS) {
      throw new IllegalStateException(
          "Team is not valid. Please ensure there are between 10 and 20 players.");
    }
  }
}