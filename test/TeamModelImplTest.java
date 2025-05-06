import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import soccerteam.Position;
import soccerteam.SkillLevel;
import soccerteam.TeamModelImpl;
import soccerteam.TeamPlayer;

/**
 * Unit tests for the {@link TeamModelImpl} class.
 */
public class TeamModelImplTest {
  private TeamModelImpl team;
  private TeamPlayer player1;
  private TeamPlayer player2;
  private TeamPlayer player3;
  private TeamPlayer player4;
  private TeamPlayer player5;
  private TeamPlayer player6;
  private TeamPlayer player7;
  private TeamPlayer player8;
  private TeamPlayer player9;
  private TeamPlayer player10;
  private TeamPlayer player11;

  /**
   * Sets up the test environment by initializing a {@link TeamModelImpl} instance and creating
   * sample {@link TeamPlayer} objects.
   */
  @Before
  public void setUp() {
    team = new TeamModelImpl();
    player1 = new TeamPlayer("John", "Doe", "2015-01-01",
        Position.FORWARD, SkillLevel.THREE);
    player2 = new TeamPlayer("Jane", "Smith", "2015-02-02",
        Position.MIDFIELDER, SkillLevel.ONE);
    player3 = new TeamPlayer("Bob", "Brown", "2016-03-03",
        Position.DEFENDER, SkillLevel.TWO);
    player4 = new TeamPlayer("Alice", "Johnson", "2017-04-04",
        Position.GOALIE, SkillLevel.FIVE);
    player5 = new TeamPlayer("Charlie", "Davis", "2015-05-05",
        Position.FORWARD, SkillLevel.FOUR);
    player6 = new TeamPlayer("Diana", "Miller", "2016-06-06",
        Position.MIDFIELDER, SkillLevel.TWO);
    player7 = new TeamPlayer("Eve", "Wilson", "2016-07-07",
        Position.DEFENDER, SkillLevel.THREE);
    player8 = new TeamPlayer("Frank", "Moore", "2017-08-08",
        Position.GOALIE, SkillLevel.FOUR);
    player9 = new TeamPlayer("Grace", "Taylor", "2015-09-09",
        Position.FORWARD, SkillLevel.FIVE);
    player10 = new TeamPlayer("Hank", "Anderson", "2018-10-10",
        Position.MIDFIELDER, SkillLevel.FOUR);
    player11 = new TeamPlayer("Ivy", "Thomas", "2019-11-11",
        Position.DEFENDER, SkillLevel.ONE);
  }

  /**
   * Tests the addPlayer(TeamPlayer) method for adding players to the team work as expected.
   */
  @Test
  public void testAddPlayer() {
    assertTrue(team.addPlayer(player1));
    assertTrue(team.addPlayer(player2));
    assertTrue(team.addPlayer(player3));
    assertTrue(team.addPlayer(player4));
    assertTrue(team.addPlayer(player5));
    assertTrue(team.addPlayer(player6));
    assertTrue(team.addPlayer(player7));
    assertTrue(team.addPlayer(player8));
    assertTrue(team.addPlayer(player9));
    assertTrue(team.addPlayer(player10));
    assertEquals(10, team.getAllPlayers().size());

    assertTrue(team.addPlayer(player11));
    assertEquals(11, team.getAllPlayers().size());

    // Test adding players until maximum threshold
    for (int i = 12; i <= 20; i++) {
      assertTrue(team.addPlayer(new TeamPlayer("Player" + i,
          "Last" + i, "2016-01-01", Position.FORWARD, SkillLevel.FOUR)));
    }
    assertEquals(20, team.getAllPlayers().size());

    // Test trying to add a player beyond maximum threshold with lower skill
    assertFalse(team.addPlayer(new TeamPlayer("LowSkill",
        "Player", "2017-01-01", Position.FORWARD, SkillLevel.ONE)));
    assertEquals(20, team.getAllPlayers().size());

    // Test adding a higher skill player when at maximum threshold
    assertTrue(team.addPlayer(new TeamPlayer("HighSkill",
        "Player", "2015-01-01", Position.FORWARD, SkillLevel.FIVE)));
    assertEquals(20, team.getAllPlayers().size());
  }

  /**
   * Tests the assignJerseyNumber(TeamPlayer) method to ensure jersey numbers
   * are assigned correctly and uniquely within the range of 1 to 20.
   */
  @Test
  public void testAssignJerseyNumber() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);

    List<TeamPlayer> players = team.getAllPlayers();
    for (TeamPlayer player : players) {
      assertTrue(player.getJerseyNumber() > 0 && player.getJerseyNumber() <= 20);
    }

    assertEquals(10, players.stream().map(TeamPlayer::getJerseyNumber).distinct().count());
  }

  /**
   * Tests the getStartingLineup() method to ensure the starting lineup is
   * selected correctly based on the players' skill levels and preferred positions.
   */
  @Test
  public void testSelectStartingLineup() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);

    List<TeamPlayer> startingLineup = team.getStartingLineup();
    assertEquals(7, startingLineup.size());
    for (TeamPlayer player : startingLineup) {
      assertNotNull(player.getTeamPosition());
    }
  }

  /**
   * Tests the sorting of all players alphabetically by last name.
   * This test ensures that the list of players is sorted correctly by their last names
   */
  @Test
  public void testGetAllPlayersSortedAlphabetically() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);

    List<TeamPlayer> players = team.getAllPlayers();
    for (int i = 1; i < players.size(); i++) {
      assertTrue(players.get(i - 1)
          .getLastName().compareTo(players.get(i).getLastName()) <= 0);
    }
  }

  /**
   * Tests the sorting of the starting lineup by position and then by last name.
   * This test ensures that players in the starting lineup are sorted first by their position
   * and then by their last names.
   */
  @Test
  public void testGetStartingLineupSortedByPositionAndName() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.addPlayer(player10);

    List<TeamPlayer> startingLineup = team.getStartingLineup();
    for (int i = 1; i < startingLineup.size(); i++) {
      TeamPlayer previous = startingLineup.get(i - 1);
      TeamPlayer current = startingLineup.get(i);
      if (previous.getTeamPosition().getOrder() == current.getTeamPosition().getOrder()) {
        assertTrue(previous.getLastName().compareTo(current.getLastName()) <= 0);
      } else {
        assertTrue(
            previous.getTeamPosition().getOrder() <= current.getTeamPosition().getOrder());
      }
    }
  }

  /**
   * Tests the getAllPlayers() method when the team size is smaller than 10.
   * This test ensures that an {@link IllegalStateException} is thrown
   * if an attempt is made to retrieve all players when the team size is too small.
   */
  @Test(expected = IllegalStateException.class)
  public void testGetAllPlayersWithInvalidSmallTeamSize() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.getAllPlayers();
  }

  /**
   * Tests the getStartingLineup() method when the team size is smaller than 10.
   * This test ensures that an {@link IllegalStateException} is thrown if an attempt
   * is made to retrieve the starting lineup when the team size is too small.
   */
  @Test(expected = IllegalStateException.class)
  public void testGetStartingLineupWithInvalidSmallTeamSize() {
    team.addPlayer(player1);
    team.addPlayer(player2);
    team.addPlayer(player3);
    team.addPlayer(player4);
    team.addPlayer(player5);
    team.addPlayer(player6);
    team.addPlayer(player7);
    team.addPlayer(player8);
    team.addPlayer(player9);
    team.getStartingLineup();
  }

  /**
   * Tests the addPlayer(TeamPlayer) method with a player exceeding the age limit.
   * This test ensures that an {@link IllegalArgumentException} is thrown when
   * attempting to add a player who exceeds the maximum allowed age for the team.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerWithExceedingAge() {
    TeamPlayer oldPlayer = new TeamPlayer("Old", "Player",
        "2005-01-01", Position.FORWARD, SkillLevel.TWO);
    team.addPlayer(oldPlayer);
  }
}

