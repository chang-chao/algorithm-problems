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

  protected static class CharArrayRefString {
    protected char[] charArray;
    protected int offset;
    protected int len;

    CharArrayRefString(char[] charArray, int offset, int len) {
      this.charArray = charArray;
      this.offset = offset;
      this.len = len;
    }

    public CharArrayRefString(String key) {
      this.charArray = key.toCharArray();
      this.offset = 0;
      this.len = charArray.length;
    }

    public char[] getCharArray() {
      return charArray;
    }

    public void setCharArray(char[] charArray) {
      this.charArray = charArray;
    }

    public int getOffset() {
      return offset;
    }

    public void setOffset(int offset) {
      this.offset = offset;
    }

    public int getLen() {
      return len;
    }

    public void setLen(int len) {
      this.len = len;
    }

    @Override
    public int hashCode() {
      int result = 17;
      for (int i = 0; i < len; i++) {
        result += charArray[offset + i] * 31;
      }
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (!(obj instanceof CharArrayRefString)) {
        return false;
      }

      CharArrayRefString other = (CharArrayRefString) (obj);
      if (len != other.getLen()) {
        return false;

      }

      char[] otherCharArray = other.getCharArray();
      for (int i = 0; i < len; i++) {
        if (charArray[offset + i] != otherCharArray[other.getOffset() + i]) {
          return false;
        }
      }

      return true;
    }

  }

  private boolean match(char[] sCharArray, int index, Map<String, Integer> wordToIndexMap, int wordSize,
      int wordCount) {
    int stringLen = sCharArray.length - index;
    if (stringLen < wordCount * wordSize) {
      return false;
    }

    Map<CharArrayRefString, Integer> remainingWordMap = new HashMap<>();
    Set<Entry<String, Integer>> entrySet = wordToIndexMap.entrySet();
    for (Entry<String, Integer> entry : entrySet) {
      remainingWordMap.put(new CharArrayRefString(entry.getKey()), entry.getValue());
    }

    for (int i = 0; i < wordCount; i++) {
      CharArrayRefString str = new CharArrayRefString(sCharArray, index + wordSize * i, wordSize);
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
