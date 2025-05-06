# U10 Soccer Team Manager

## About/Overview
This program is a U10 Soccer Team Manager application that helps manage a team of young soccer players (under 10 years old). It allows users to add players, create teams, view the starting lineup, and display all players in the team. The application uses a graphical user interface (GUI) for easy interaction.

## List of Features
- Add new players to the team
- Create a team when enough players are available
- View player Candidates after add a player
- View all players in the team
- View the starting lineup
- Automatically assign jersey numbers to players
- Replace players with higher skill levels when the team is full

## How To Run
To run the program:
1. Ensure you have Java installed on your system.
2. Download the jar file: `U10SoccerTeam.jar`
3. Open a terminal or command prompt.
4. Navigate to the directory containing the jar file.
5. Run the following command:
   ```
   java -jar U10SoccerTeamManager.jar
   ```
No additional arguments are required to run the program.

## How to Use the Program
1. **Adding a Player**: Fill in the player details in the input fields and click "Add Player."
2. **Viewing Player Candidates**: After successfully adding a player, their information will be displayed in the Player Candidates area.
3. **Creating a Team**: Click "Create Team" once you have at least 10 players to form a team.
4. **Viewing All Players**: Click "Show All Players" to see a list of all players currently in the team.
5. **Viewing Starting Lineup**: Click "Show Starting Lineup" to view the current starting lineup.

## Design/Model Changes
- **Candidates List**: Added a list to keep track of all players considered for the team.
- **Age Limit**: Added a constant value `MINIMUM_AGE` to restrict player age to between 0 and 10 years.
- **Add Player Logic**: Modified the logic for adding players to make it more streamlined and clear.

## Assumptions
- Assumes that all input names are valid English names.
- Assumes that all input data is accurate and requires no removal or modification.
- Assumes that all required input fields are filled out (e.g., a player's name is needed to add them successfully).

## Limitations
- **No Data Persistence**: The program does not save data between sessions. All data is lost upon closing the application.
- **No Editing/Removing Players**: The current version does not allow for editing or removing players once they have been added.
- **Team Creation Process**: There's no need to click "Create Team" before viewing the team players and starting lineup. These can be accessed directly once 10 players have been added.

## Citations
1. https://chatgpt.com
2. https://claude.ai