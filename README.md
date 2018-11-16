This is Nicholas Petrocelli's submission for OM1's Spring 2019 Co-op
technical exercise.

The logic for computing the number of anagrams in a string array is
located in the static getAnagramNum(String[]) method in Anagram.java.
A set of unit tests can be found in AnagramTest.java. All tests pass,
with the testSpeed test (one that runs the anagram algorithm on 1,000,000
strings) finishing in about 1.9 seconds.

**Complexity analysis**

The first part of this algorithm involves preparing the list of strings
by making a single pass over the list, sorting each string alphabetically
then appending them to the end of a newly created doubly linked list. Theoretically,
this preparation stage is O(N), as it involves a single pass over the inputs
and the overhead of adding to a linked list is O(1); however, the sorting algorithm
must also be considered.

To sort the strings, I used a modified version of counting sort, a O(N) sorting
algorithm. This was possible because the set of allowed characters was limited
to alpha characters. The typical counting sort was modified to store linked lists
of each character rather than numerical counts to save overhead when reconstructing
the sorted string, as appending linked lists to each other is O(1).

Therefore the complexity of the preparation pass is O(NK) where N is the number
  of words and K is the length of the average word. Therefore this algorithm is most
  efficient when the average word length is much smaller than the number of words,
  which is a safe assumption to make (on the english language, at least).

To find the number of anagrams, another pass is made over the list of sorted strings.
This time, a hashmap between 

