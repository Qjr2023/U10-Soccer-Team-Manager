package soccerteam;

import javax.swing.SwingUtilities;

/**
 * The Main class contains the main method to run the U10 Soccer Team Manager application.
 * It creates a new TeamModel, TeamView, and TeamController, and displays the view.
 */
public class Main {
  /**
   * The main method to run the U10 Soccer Team Manager application.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      TeamModel model = new TeamModelImpl();
      TeamView view = new SwingTeamView();
      TeamController controller = new SwingTeamController(model, view);

      view.display();
    });
  }
}
