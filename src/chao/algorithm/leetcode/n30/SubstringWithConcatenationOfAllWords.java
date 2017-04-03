package chao.algorithm.leetcode.n30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubstringWithConcatenationOfAllWords {
  public List<Integer> findSubstring(String s, String[] words) {
    Map<String, Set<Integer>> wordToIndexMap = new HashMap<>();

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (!wordToIndexMap.containsKey(word)) {
        wordToIndexMap.put(word, new HashSet<>());
      }
      wordToIndexMap.get(word).add(i);
    }

    int wordSize = words[0].length();
    char[] sCharArray = s.toCharArray();
    for (int i = 0; i < sCharArray.length; i++) {

      if (match(sCharArray, i, wordToIndexMap, wordSize, words.length)) {
        result.add(i);
      }

    }

    return result;
  }

  private boolean match(char[] sCharArray, int index, Map<String, Set<Integer>> wordToIndexMap, int wordSize,
      int wordCount) {
    int stringLen = sCharArray.length - index;
    if (stringLen < wordCount * wordSize) {
      return false;
    }

    Set<Integer> indices = new HashSet<>();
    for (int i = 0; i < wordCount; i++) {
      String str = new String(sCharArray, index + wordSize * i, wordSize);
      if (wordToIndexMap.containsKey(str)) {
        Set<Integer> wordIndices = wordToIndexMap.get(str);

        boolean added = false;
        for (Integer wordIndex : wordIndices) {
          if (!indices.contains(wordIndex)) {
            indices.add(wordIndex);
            added = true;
            break;
          }
        }

        if (!added) {
          return false;
        }
      } else {
        return false;
      }
    }
    return indices.size()==wordCount;
  }
}
