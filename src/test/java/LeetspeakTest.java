import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class LeetspeakTest {


  @Test
  public void Leatspeak_returnsAStringAsIsWhenNoLeetspeakIsPresent_wordDoesntChange() {
    Leetspeak testLeetspeak = new Leetspeak();
    assertEquals("happy", testLeetspeak.leetspeak("happy"));
  }

  @Test
  public void leetspeak_replacesEveryEInAStringWithA3_wordChanges() {
    Leetspeak testLeetspeak = new Leetspeak();
    assertEquals("33", testLeetspeak.leetspeak("eE"));
  }

  @Test
  public void leetspeak_replacesEveryOinAStringWithA0_wordChanges() {
    Leetspeak testLeetspeak = new Leetspeak();
    assertEquals("00", testLeetspeak.leetspeak("oO"));
  }

  @Test
  public void leetspeak_replacesEveryIInaStringWithA1_wordChanges() {
    Leetspeak testLeetspeak = new Leetspeak();
    assertEquals("1", testLeetspeak.leetspeak("I"));
  }

  // @Test
  // public void leetspeak_replacesEverySInAStringWithAZ_wordChanges() {
  //   Leetspeak testLeetspeak = new Leetspeak();
  //   assertEquals("zz", testLeetspeak.leetspeak("sS"));
  // }

  @Test
  public void leetspeak_doesNotReplaceSWhenFirstLetter_wordChanges() {
    Leetspeak testLeetspeak = new Leetspeak();
    assertEquals("Suzi3 Sunzhin3", testLeetspeak.leetspeak("Susie Sunshine"));
  }
}
