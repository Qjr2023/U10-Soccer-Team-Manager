package soccerteam;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * The SwingTeamView class implement the TeamView interface for managing a U10 soccer team.
 * It allows users to input player details, add players to the team, and create the team
 * with a starting lineup. It extends the JFrame class to create a graphical user interface.
 */
public class SwingTeamView extends JFrame implements TeamView {
  private final JTextField firstNameField;
  private final JTextField lastNameField;
  private final JTextField dobField;
  private final JComboBox<Position> positionComboBox;
  private final JComboBox<SkillLevel> skillLevelComboBox;
  private final JButton addPlayerButton;
  private final JButton createTeamButton;
  private final JButton showAllPlayersButton;
  private final JButton showStartingLineupButton;
  private final JTextArea candidatesArea;
  private final JTextArea startingLineupArea;
  private final JTextArea allPlayersArea;
  private final JTextArea messageArea;

  /**
   * Constructs a SwingTeamView instance, initializing the user interface components and setting up
   * the layout.
   */
  public SwingTeamView() {
    setTitle("U10 Soccer Team Manager");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout(10, 10));
    ((JPanel) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

    // Input Panel
    JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
    inputPanel.setBorder(BorderFactory.createTitledBorder("Add Player"));
    inputPanel.add(new JLabel("First Name:"));
    firstNameField = new JTextField();
    inputPanel.add(firstNameField);
    inputPanel.add(new JLabel("Last Name:"));
    lastNameField = new JTextField();
    inputPanel.add(lastNameField);
    inputPanel.add(new JLabel("Date of Birth (YYYY-MM-DD):"));
    dobField = new JTextField();
    inputPanel.add(dobField);
    inputPanel.add(new JLabel("Preferred Position:"));
    positionComboBox = new JComboBox<>(Position.values());
    inputPanel.add(positionComboBox);
    inputPanel.add(new JLabel("Skill Level:"));
    skillLevelComboBox = new JComboBox<>(SkillLevel.values());
    inputPanel.add(skillLevelComboBox);
    addPlayerButton = new JButton("Add Player");
    inputPanel.add(addPlayerButton);

    // Button Panel
    final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
    createTeamButton = new JButton("Create Team");
    showAllPlayersButton = new JButton("Show All Players");
    showStartingLineupButton = new JButton("Show Starting Lineup");
    buttonPanel.add(createTeamButton);
    buttonPanel.add(showAllPlayersButton);
    buttonPanel.add(showStartingLineupButton);

    // Candidates Area
    candidatesArea = new JTextArea(10, 30);
    candidatesArea.setEditable(false);
    JScrollPane candidatesScrollPane = new JScrollPane(candidatesArea);
    candidatesScrollPane.setBorder(BorderFactory.createTitledBorder("Player Candidates"));

    // Starting Lineup Area
    startingLineupArea = new JTextArea(10, 30);
    startingLineupArea.setEditable(false);
    JScrollPane startingLineupScrollPane = new JScrollPane(startingLineupArea);
    startingLineupScrollPane.setBorder(BorderFactory.createTitledBorder("Starting Lineup"));

    // All Players Area
    allPlayersArea = new JTextArea(10, 30);
    allPlayersArea.setEditable(false);
    JScrollPane allPlayersScrollPane = new JScrollPane(allPlayersArea);
    allPlayersScrollPane.setBorder(BorderFactory.createTitledBorder("All Players"));

    // Message Area
    messageArea = new JTextArea(2, 30);
    messageArea.setEditable(false);
    JScrollPane messageScrollPane = new JScrollPane(messageArea);
    messageScrollPane.setBorder(BorderFactory.createTitledBorder("Messages"));

    // Layout
    JPanel topPanel = new JPanel(new BorderLayout(10, 10));
    topPanel.add(inputPanel, BorderLayout.WEST);
    topPanel.add(candidatesScrollPane, BorderLayout.CENTER);

    JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
    centerPanel.add(buttonPanel, BorderLayout.NORTH);
    centerPanel.add(startingLineupScrollPane, BorderLayout.EAST);
    centerPanel.add(allPlayersScrollPane, BorderLayout.CENTER);

    add(topPanel, BorderLayout.NORTH);
    add(centerPanel, BorderLayout.CENTER);
    add(messageScrollPane, BorderLayout.SOUTH);
  }

  @Override
  public void setAddPlayerListener(ActionListener listener) {
    addPlayerButton.addActionListener(listener);
  }

  @Override
  public void setCreateTeamListener(ActionListener listener) {
    createTeamButton.addActionListener(listener);
  }

  @Override
  public void setShowAllPlayersListener(ActionListener listener) {
    showAllPlayersButton.addActionListener(listener);
  }

  @Override
  public void setShowStartingLineupListener(ActionListener listener) {
    showStartingLineupButton.addActionListener(listener);
  }

  @Override
  public String getFirstName() {
    return firstNameField.getText();
  }

  @Override
  public String getLastName() {
    return lastNameField.getText();
  }

  @Override
  public String getDateOfBirth() {
    return dobField.getText();
  }

  @Override
  public Position getSelectedPosition() {
    return (Position) positionComboBox.getSelectedItem();
  }

  @Override
  public SkillLevel getSelectedSkillLevel() {
    return (SkillLevel) skillLevelComboBox.getSelectedItem();
  }

  @Override
  public void displayMessage(String message) {
    messageArea.setText(message);
  }

  @Override
  public void clearInputFields() {
    firstNameField.setText("");
    lastNameField.setText("");
    dobField.setText("");
    positionComboBox.setSelectedIndex(0);
    skillLevelComboBox.setSelectedIndex(0);
  }

  @Override
  public void displayCandidates(String candidatesInfo) {
    candidatesArea.setText(candidatesInfo);
  }

  @Override
  public void displayStartingLineup(List<TeamPlayer> startingLineup) {
    StringBuilder sb = new StringBuilder();
    for (TeamPlayer player : startingLineup) {
      sb.append(player.toString(true)).append("\n");
    }
    startingLineupArea.setText(sb.toString());
  }

  @Override
  public void displayAllPlayers(List<TeamPlayer> players) {
    StringBuilder sb = new StringBuilder();
    for (TeamPlayer player : players) {
      sb.append(player.toString(false)).append("\n");
    }
    allPlayersArea.setText(sb.toString());
  }

  @Override
  public void showErrorDialog(String message) {
    JOptionPane.showMessageDialog(this, message, "Error",
        JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void display() {
    SwingUtilities.invokeLater(() -> {
      pack();
      setLocationRelativeTo(null);
      setVisible(true);
    });
  }
}