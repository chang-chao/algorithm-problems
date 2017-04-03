package chao.algorithm.leetcode.n30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SubstringWithConcatenationOfAllWords {
  public List<Integer> findSubstring(String s, String[] words) {
    Map<String, Integer> wordToIndexMap = new HashMap<>();

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (!wordToIndexMap.containsKey(word)) {
        wordToIndexMap.put(word, 1);
      } else {
        wordToIndexMap.put(word, wordToIndexMap.get(word) + 1);
      }
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

  private boolean match(char[] sCharArray, int index, Map<String, Integer> wordToIndexMap, int wordSize,
      int wordCount) {
    int stringLen = sCharArray.length - index;
    if (stringLen < wordCount * wordSize) {
      return false;
    }

    Map<String, Integer> remainingWordMap = new HashMap<>();
    Set<Entry<String, Integer>> entrySet = wordToIndexMap.entrySet();
    for (Entry<String, Integer> entry : entrySet) {
      remainingWordMap.put(entry.getKey(), entry.getValue());
    }

    for (int i = 0; i < wordCount; i++) {
      String str = new String(sCharArray, index + wordSize * i, wordSize);
      if (remainingWordMap.containsKey(str)) {
        remainingWordMap.put(str, remainingWordMap.get(str) - 1);
        if (remainingWordMap.get(str) == 0) {
          remainingWordMap.remove(str);
        }
      } else {
        return false;
      }
    }
    return remainingWordMap.isEmpty();
  }
}
