This is Nicholas Petrocelli's submission for OM1's Spring 2019 Co-op
technical exercise.

The logic for computing the number of anagrams in a string array is
located in the static getAnagramNum(String[]) method in Anagram.java.
A set of unit tests can be found in AnagramTest.java. All tests pass,
with the testSpeed test (one that runs the anagram algorithm on 1,000,000
strings) finishing in about 1.6 seconds.

**Complexity analysis**

This algorithm performs all of its computations during a single pass over the
input string array of length N. First, it takes each string and sorts it using the modified form
of counting sort described in the next paragraph. Then, it takes the sorted string and
compares it to a HashMap of strings that have already been "seen" during the pass, with said
strings being the keys of the HashMap.
If the HashMap already contains the string, then that means it has an anagram
somewhere in the list, and a running anagram total can be incremented. An additional
boolean value associated with each string is kept as the value, which represents whether this
string has already been seen twice. If it hasn't, this means that the count must be incremented
by 2 instead of 1 (as both the current string and the previous equivalent string are anagrams of
each other).

To sort the strings, I used a modified version of counting sort, a O(n) sorting
algorithm. This was possible because the set of allowed characters was limited
to alpha characters. The typical counting sort was modified to store linked lists
of each character rather than numerical counts to save overhead when reconstructing
the sorted string, as appending linked lists to each other is O(1).

Therefore the complexity of this algorithm is O(NK) where N is the number
  of words and K is the length of the average word. This is because a single pass
   is made over the length of the array, but on each word a full sorting computation
   must be performed over the length of that word. Therefore this algorithm is most
  efficient when the average word length is much smaller than the number of words,
  which is a safe assumption to make (on the english language, at least).


