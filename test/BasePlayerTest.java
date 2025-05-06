import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Period;
import org.junit.Before;
import org.junit.Test;
import soccerteam.BasePlayer;
import soccerteam.Position;
import soccerteam.SkillLevel;

/**
 * The BasePlayerTest class contains unit tests for the BasePlayer class.
 */
public class BasePlayerTest {
  private BasePlayer player;

  /**
   * Sets up the test environment by initializing a BasePlayer instance before each test.
   */
  @Before
  public void setUp() {
    player = new BasePlayer("John", "Doe", "2010-05-15",
        Position.MIDFIELDER, SkillLevel.FIVE);
  }

  /**
   * Tests the getFirstName() method to ensure it returns the correct first name.
   */
  @Test
  public void testGetFirstName() {
    assertEquals("John", player.getFirstName());
  }

  /**
   * Tests the getLastName() method to ensure it returns the correct last name.
   */
  @Test
  public void testGetLastName() {
    assertEquals("Doe", player.getLastName());
  }

  /**
   * Tests the getAge() method to ensure it returns the correct age based on the date of birth.
   */
  @Test
  public void testGetAge() {
    int expectedAge = Period.between(LocalDate.of(2010, 5, 15),
        LocalDate.now()).getYears();
    assertEquals(expectedAge, player.getAge());
  }

  /**
   * Tests the getPreferredPosition() method to ensure it returns the correct preferred position.
   */
  @Test
  public void testGetPreferredPosition() {
    assertEquals(Position.MIDFIELDER, player.getPreferredPosition());
  }

  /**
   * Tests the getSkillLevel() method to ensure it returns the correct skill level.
   */
  @Test
  public void testGetSkillLevel() {
    assertEquals(SkillLevel.FIVE, player.getSkillLevel());
  }

  /**
   * Tests the getAge() method with an invalid date format to ensure it
   * throws an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetAgeWithInvalidDate() {
    BasePlayer invalidPlayer = new BasePlayer("Jane", "Doe",
        "22220908", Position.DEFENDER, SkillLevel.FIVE);
    invalidPlayer.getAge();
  }

  /**
   * Tests the getFullName() method to ensure it returns the correct full name.
   */
  @Test
  public void testGetFullName() {
    assertEquals("John Doe", player.getFullName());
  }

  /**
   * Tests the getDateOfBirth() method to ensure it returns the correct date of birth.
   */
  @Test
  public void testGetDateOfBirth() {
    assertEquals("2010-05-15", player.getDateOfBirth());
  }
}