import java.util.List;
import soccerteam.Position;
import soccerteam.SkillLevel;
import soccerteam.TeamModel;
import soccerteam.TeamModelImpl;
import soccerteam.TeamPlayer;

/**
 * The Driver class demonstrates the creation and management of a soccer team with players under 10
 * years old. It creates instances of TeamMember and adds them to the SoccerTeam. The class also
 * prints all players and the starting lineup of the team.
 */
public class Driver {

  /**
   * The main method serves as the entry point for the application. It initializes a SoccerTeam
   * object and can be used to demonstrate the functionality of the program or perform any required
   * tasks related to the SoccerTeam class.
   *
   * @param args An array of command-line arguments passed to the application.
   */
  public static void main(String[] args) {
    TeamModel team = new TeamModelImpl();

    try {
      // Attempt to add a player with an invalid age
      TeamPlayer invalidPlayer = new TeamPlayer("John", "Doe",
          "2014-06-10", Position.FORWARD, SkillLevel.FIVE);
      team.addPlayer(invalidPlayer);
    } catch (IllegalArgumentException e) {
      System.out.println("Caught exception: " + e.getMessage());
    }

    // Add valid players
    try {
      team.addPlayer(new TeamPlayer("Ethan", "Taylor", "2015-03-15",
          Position.DEFENDER, SkillLevel.THREE));
      team.addPlayer(new TeamPlayer("Olivia", "Parker", "2015-04-25",
          Position.DEFENDER, SkillLevel.FOUR));
      team.addPlayer(new TeamPlayer("Liam", "Johnson", "2016-05-10",
          Position.DEFENDER, SkillLevel.FIVE));
      team.addPlayer(new TeamPlayer("Ava", "Martinez", "2017-06-20",
          Position.MIDFIELDER, SkillLevel.TWO));
      team.addPlayer(new TeamPlayer("Noah", "Clark", "2016-07-30",
          Position.DEFENDER, SkillLevel.FOUR));
      team.addPlayer(new TeamPlayer("Sophia", "Miller", "2015-08-25",
          Position.DEFENDER, SkillLevel.FIVE));
      team.addPlayer(new TeamPlayer("Mason", "Wilson", "2016-09-15",
          Position.DEFENDER, SkillLevel.THREE));
      team.addPlayer(new TeamPlayer("Isabella", "Moore", "2018-10-05",
          Position.FORWARD, SkillLevel.FOUR));
      team.addPlayer(new TeamPlayer("Lucas", "Taylor", "2015-01-12",
          Position.DEFENDER, SkillLevel.TWO));
      team.addPlayer(new TeamPlayer("Mia", "Adams", "2015-02-28",
          Position.MIDFIELDER, SkillLevel.THREE));
      team.addPlayer(new TeamPlayer("Jacob", "Rodriguez", "2015-03-15",
          Position.DEFENDER, SkillLevel.FIVE));
      team.addPlayer(new TeamPlayer("Charlotte", "Harris", "2015-04-22",
          Position.MIDFIELDER, SkillLevel.FOUR));
      team.addPlayer(new TeamPlayer("James", "Walker", "2015-05-30",
          Position.DEFENDER, SkillLevel.THREE));
      team.addPlayer(new TeamPlayer("Amelia", "Scott", "2015-06-18",
          Position.DEFENDER, SkillLevel.ONE));
      team.addPlayer(new TeamPlayer("William", "Lewis", "2015-07-10",
          Position.FORWARD, SkillLevel.FIVE));
      team.addPlayer(new TeamPlayer("Harper", "Young", "2015-08-12",
          Position.FORWARD, SkillLevel.TWO));
      team.addPlayer(new TeamPlayer("Benjamin", "Roberts", "2015-09-20",
          Position.FORWARD, SkillLevel.THREE));
      team.addPlayer(new TeamPlayer("Ella", "Carter", "2016-10-05",
          Position.DEFENDER, SkillLevel.FOUR));


      System.out.println("\nAll Players:");
      printTeamPlayers(team.getAllPlayers());

      System.out.println("\nStarting Lineup:");
      printLineupPlayers(team.getStartingLineup());

    } catch (IllegalStateException e) {
      System.out.println(
          "Caught exception while retrieving starting lineup info: " + e.getMessage());
    }
  }

  /**
   * Prints the information of each Team Player in the provided list.
   *
   * @param teamPlayers a list of TeamPlayer objects to be printed
   */
  private static void printTeamPlayers(List<TeamPlayer> teamPlayers) {
    for (TeamPlayer player : teamPlayers) {
      System.out.println(player.toString(false));
    }
  }

  /**
   * Prints a formatted list of lineup players to the console.
   *
   * @param lineupPlayers the list of TeamPlayer objects representing the players
   *                      in the starting lineup.
   */
  private static void printLineupPlayers(List<TeamPlayer> lineupPlayers) {
    for (TeamPlayer player : lineupPlayers) {
      System.out.println(player.toString(true));
    }
  }
}