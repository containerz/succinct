package edu.berkeley.cs.succinct.util.stream.serops;

import edu.berkeley.cs.succinct.util.stream.LongArrayStream;

import java.io.IOException;

public class ArrayOps {

  /**
   * Get rank1 value at specified index in serialized Long array.
   *
   * @param arrayBuf Serialized Long array.
   * @param startPos Start position.
   * @param size     Size of array.
   * @param i        Rank query.
   * @return Value of rank1 for query.
   */
  public static int getRank1(LongArrayStream arrayBuf, int startPos, int size, long i)
    throws IOException {
    int sp = 0, ep = size - 1;
    int m;

    while (sp <= ep) {
      m = (sp + ep) / 2;
      if (arrayBuf.get(startPos + m) == i) {
        return m + 1;
      } else if (i < arrayBuf.get(startPos + m)) {
        ep = m - 1;
      } else {
        sp = m + 1;
      }
    }

    return ep + 1;
  }
}
