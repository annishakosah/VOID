package gameworld;

/**
 * This class represents a guard challenge which must be bribed
 * with a beer by the player in order to access a portal.
 */
public class Guard extends ChallengeItem {

  public Guard(int row, int col) {
    super(row, col);
  }

  @Override
  public String getName() {
    return "";
  }

  @Override
  public String getDescription() {
    return "";
  }

  @Override
  public String toString() {
    return "Guard";
  }

}
