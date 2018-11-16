import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nick on 11/16/18.
 */
public class AnagramTest {
  /**
   * Test for Anagram algorithm correctness based on given example.
   */
  @Test
  public void testExample() {
    String[] ex = {"Act", "cat", "cat", "dog", "dog", "aardvark"};
    int result = Anagram.getAnagramNum(ex);
    assertEquals("Mismatch: expected 5 anagrams, got " + Integer.toString(result), result, 5);
  }

  /**
   * Test empty case.
   */
  @Test
  public void testEmpty() {
    String[] ex1 = {};
    int result = Anagram.getAnagramNum(ex1);
    assertEquals("Mismatch: expected 0 anagrams, got " + Integer.toString(result), result, 0);
  }

  /**
   * Test that exception is thrown if list contains illegal characters
   */
  @Test (expected = IllegalArgumentException.class)
  public void testMalformed() {
    String[] ex1 = {"ab231", "ba123"};
    int result = Anagram.getAnagramNum(ex1);
  }

  /**
   * Test case with no anagrams.
   */
  @Test
  public void testUnique() {
    String[] ex1 = {"as", "sd", "df", "fg", "gh", "hj"};
    int result = Anagram.getAnagramNum(ex1);
    assertEquals("Mismatch: expected 0 anagrams, got " + Integer.toString(result), result, 0);
  }

  /**
   * Test case where every string is an anagram.
   */
  @Test
  public void testAllAnagrams() {
    String[] ex1 = {"abc", "cba", "bca", "cab", "acb", "abc", "ABC", "bAc"};
    int result = Anagram.getAnagramNum(ex1);
    assertEquals("Mismatch: expected 8 anagrams, got " + Integer.toString(result), result, 8);
  }

  /**
   * Test case with some anagrams
   */
  @Test
  public void testSomeAnagrams() {
    String[] ex1 = {"abc", "cba", "bca", "dsa", "iop", "lol", "ok"};
    int result = Anagram.getAnagramNum(ex1);
    assertEquals("Mismatch: expected 3 anagrams, got " + Integer.toString(result), result, 3);
  }

  /**
   * Test that anagram algorithm runs in reasonable speed on 1,000,000 strings.
   * This will have to be eyeballed somewhat, and no assertions are used here.
   */
  @Test
  public void testSpeed() {
    String[] ex = {"Act", "cat", "cat", "dog", "dog", "aardvark", "bee", "eeB", "colossus",
    "qwertyUIOP"};
    String[] randoms = new String[1000000];
    Random rand = new Random(50);
    for (int i = 0; i < 1000000; ++i) {
      int j = rand.nextInt(10);
      randoms[i] = ex[j];
    }
    System.out.println("Completed array init");
    System.out.println(Anagram.getAnagramNum(randoms));
  }


}
