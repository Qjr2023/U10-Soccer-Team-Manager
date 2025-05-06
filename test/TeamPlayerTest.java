import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Before;
import org.junit.Test;
import soccerteam.Position;
import soccerteam.SkillLevel;
import soccerteam.TeamPlayer;

/**
 * The TeamPlayerTest class contains unit tests for the TeamPlayer class.
 */
public class TeamPlayerTest {
  private TeamPlayer player;

  /**
   * Sets up the test environment by initializing a TeamPlayer instance before each test.
   */
  @Before
  public void setUp() {
    player = new TeamPlayer("John", "Doe", "2016-01-01",
        Position.MIDFIELDER, SkillLevel.ONE);
  }

  /**
   * Tests the constructor to ensure it correctly initializes a TeamPlayer object.
   */
  @Test
  public void testConstructor() {
    assertEquals("John Doe", player.getFullName());
    assertEquals("2016-01-01", player.getDateOfBirth());
    assertEquals(Position.MIDFIELDER, player.getPreferredPosition());
    assertEquals(SkillLevel.ONE, player.getSkillLevel());
    assertEquals(0, player.getJerseyNumber());
    assertNull(player.getTeamPosition());
  }

  /**
   * Tests the getJerseyNumber() method to ensure it returns the correct jersey number.
   */
  @Test
  public void testGetJerseyNumber() {
    assertEquals(0, player.getJerseyNumber());
  }

  /**
   * Tests the getTeamPosition() method to ensure it returns the correct team position.
   */
  @Test
  public void testGetTeamPosition() {
    assertNull(player.getTeamPosition());
  }

  /**
   * Tests the getJerseyNumber() method to ensure it returns the correct jersey number.
   */
  @Test
  public void testSetJerseyNumber() {
    try {
      Method setJerseyNumberMethod =
          TeamPlayer.class.getDeclaredMethod("setJerseyNumber", int.class);
      setJerseyNumberMethod.setAccessible(true);
      setJerseyNumberMethod.invoke(player, 10);

      assertEquals(10, player.getJerseyNumber());
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
      fail("Method setJerseyNumber() not found.");
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      fail("Method setJerseyNumber() access error.");
    } catch (InvocationTargetException e) {
      e.printStackTrace();
      fail("Method setJerseyNumber() invocation error.");
    }
  }

  /**
   * Tests the getTeamPosition() method to ensure it returns the correct team position.
   */
  @Test
  public void testSetTeamPosition() {
    try {
      Method setTeamPositionMethod =
          TeamPlayer.class.getDeclaredMethod("setTeamPosition", Position.class);
      setTeamPositionMethod.setAccessible(true);
      setTeamPositionMethod.invoke(player, Position.FORWARD);

      assertEquals(Position.FORWARD, player.getTeamPosition());
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
      fail("Method setTeamPosition() not found.");
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      fail("Method setTeamPosition() access error.");
    } catch (InvocationTargetException e) {
      e.printStackTrace();
      fail("Method setTeamPosition() invocation error.");
    }
  }
}
