import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Nick on 11/16/18.
 * Class designed to satisfy OM1's anagram exercise.
 * @author Nicholas Petrocelli
 */
public class Anagram {
  //Map used for sorting later on.
  //This will prevent a big ugly switch case, improving readability and efficiency.
  private static final Map<Character, Integer> charToIndex;
  static {
    charToIndex = new HashMap<>();
    charToIndex.put('a', 0);
    charToIndex.put('b', 1);
    charToIndex.put('c', 2);
    charToIndex.put('d', 3);
    charToIndex.put('e', 4);
    charToIndex.put('f', 5);
    charToIndex.put('g', 6);
    charToIndex.put('h', 7);
    charToIndex.put('i', 8);
    charToIndex.put('j', 9);
    charToIndex.put('k', 10);
    charToIndex.put('l', 11);
    charToIndex.put('m', 12);
    charToIndex.put('n', 13);
    charToIndex.put('o', 14);
    charToIndex.put('p', 15);
    charToIndex.put('q', 16);
    charToIndex.put('r', 17);
    charToIndex.put('s', 18);
    charToIndex.put('t', 19);
    charToIndex.put('u', 20);
    charToIndex.put('v', 21);
    charToIndex.put('w', 22);
    charToIndex.put('x', 23);
    charToIndex.put('y', 24);
    charToIndex.put('z', 25);
  }


  /**
   * Gets the number of strings in a given array for which there exists at least one other
   * anagram of that word in the array.
   * @param array The array of strings to be processed
   * @return The number of strings in the array for which there exists at least one other anagram
   */
  public static int getAnagramNum(String[] array){
    //Convert to linked list, downcase all strings, and convert to character arrays,
    //then sort arrays.

    //I am using a linked list because its add() and remove() methods are very efficient, and my
    //implementation will be using these methods a lot.



    //The conversion to character arrays is so that I can sort these and compare them to find
    //anagrams.

    //Want to total the anagrams in a O(N) pass.
    //To do this I will iterate through the list while storing already seen strings into a hashmap,
    //then use that set to determine if a string has an anagram or not.
    //A map is used to store a binary value for if that string has been recorded as an anagram
    //already or not.
    //Also HashMap has O(1) for determining if a key is present.

    //I am doing all of these operations in one pass for efficiency purposes.

    HashMap<String, Boolean> seenStrings = new HashMap<>(array.length);
    int count = 0;
    String s2, s3;
    for (String s : array) {
      s2 = s.toLowerCase();
      s3 = sortCharsIntoString(s2.toCharArray());

      if (seenStrings.containsKey(s3)) {
        //i.e. this is the 3rd or greater time we have seen this string
        if (seenStrings.get(s3)) {
          ++count;
        }
        //because both this string and its earlier found pair should now be recorded as anagrams on
        //the second time we find this string
        else {
          count = count + 2;
          seenStrings.put(s3, true);
        }
      }
      //If the string hasn't been seen yet
      else {
        seenStrings.put(s3, false);
      }
    }
    return count;
  }


  /**
   * Sorts characters from character array then places them into a string.
   * Assumes two things:
   * <ul>
   *   <li>Only alpha characters (a-z, no numbers or special characters)</li>
   *   <li>All lowercase characters</li>
   * </ul>
   * This method uses a modified version of counting sort. I chose this algorithm because it is
   * O(n) time efficient, and the parameters of the problem (i.e. the strict character restrictions)
   * allow this algorithm to be used.
   *
   * I modify the algorithm by using linked lists to store the count then appending them at the end.
   * While this is much less memory efficient, it should be more time efficient as appending
   * two linked lists is a O(1) operation.
   * @param arr Array of characters to be sorted.
   * @return Sorted string of characters.
   */
  private static String sortCharsIntoString(char[] arr){
    //Initialize 26 length ArrayList of linked lists
    //Using arraylist here because I need arbitrary access in O(1) time
    ArrayList<LinkedList<Character>> lists = new ArrayList<>(26);
    //Initialize
    for (int i=0; i<26; ++i) {
      lists.add(new LinkedList<>());
    }
    //sort array into lists
    for (char c : arr) {
      if (!charToIndex.containsKey(c)) {
        throw new IllegalArgumentException("Error: word contains illegal character " + c);
      }
      lists.get(charToIndex.get(c)).add(c);
    }
    LinkedList<Character> sorted = new LinkedList<>();
    //Now append all lists, returning a sorted list
    for (int i = 0; i<26; ++i) {
      sorted.addAll(lists.get(i));
    }
    StringBuilder ret = new StringBuilder(sorted.size());
    for (Character c : sorted) {
      ret.append(c);
    }
    return ret.toString();
  }
}
