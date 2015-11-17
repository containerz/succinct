package edu.berkeley.cs.succinct.util;

public class BitUtils {

  public static final long ALL_SET = 0xFFFFFFFFFFFFFFFFL;

  public static final long[] HIGH_BITS_SET =
    new long[] {
      0x0000000000000000L, 0x8000000000000000L, 0xC000000000000000L, 0xE000000000000000L,
      0xF000000000000000L, 0xF800000000000000L, 0xFC00000000000000L, 0xFE00000000000000L,
      0xFF00000000000000L, 0xFF80000000000000L, 0xFFC0000000000000L, 0xFFE0000000000000L,
      0xFFF0000000000000L, 0xFFF8000000000000L, 0xFFFC000000000000L, 0xFFFE000000000000L,
      0xFFFF000000000000L, 0xFFFF800000000000L, 0xFFFFC00000000000L, 0xFFFFE00000000000L,
      0xFFFFF00000000000L, 0xFFFFF80000000000L, 0xFFFFFC0000000000L, 0xFFFFFE0000000000L,
      0xFFFFFF0000000000L, 0xFFFFFF8000000000L, 0xFFFFFFC000000000L, 0xFFFFFFE000000000L,
      0xFFFFFFF000000000L, 0xFFFFFFF800000000L, 0xFFFFFFFC00000000L, 0xFFFFFFFE00000000L,
      0xFFFFFFFF00000000L, 0xFFFFFFFF80000000L, 0xFFFFFFFFC0000000L, 0xFFFFFFFFE0000000L,
      0xFFFFFFFFF0000000L, 0xFFFFFFFFF8000000L, 0xFFFFFFFFFC000000L, 0xFFFFFFFFFE000000L,
      0xFFFFFFFFFF000000L, 0xFFFFFFFFFF800000L, 0xFFFFFFFFFFC00000L, 0xFFFFFFFFFFE00000L,
      0xFFFFFFFFFFF00000L, 0xFFFFFFFFFFF80000L, 0xFFFFFFFFFFFC0000L, 0xFFFFFFFFFFFE0000L,
      0xFFFFFFFFFFFF0000L, 0xFFFFFFFFFFFF8000L, 0xFFFFFFFFFFFFC000L, 0xFFFFFFFFFFFFE000L,
      0xFFFFFFFFFFFFF000L, 0xFFFFFFFFFFFFF800L, 0xFFFFFFFFFFFFFC00L, 0xFFFFFFFFFFFFFE00L,
      0xFFFFFFFFFFFFFF00L, 0xFFFFFFFFFFFFFF80L, 0xFFFFFFFFFFFFFFC0L, 0xFFFFFFFFFFFFFFE0L,
      0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFF8L, 0xFFFFFFFFFFFFFFFCL, 0xFFFFFFFFFFFFFFFEL,
      0xFFFFFFFFFFFFFFFFL};

  public static final long[] HIGH_BITS_UNSET =
    new long[] {
      0xFFFFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFFFL, 0x3FFFFFFFFFFFFFFFL, 0x1FFFFFFFFFFFFFFFL,
      0x0FFFFFFFFFFFFFFFL, 0x07FFFFFFFFFFFFFFL, 0x03FFFFFFFFFFFFFFL, 0x01FFFFFFFFFFFFFFL,
      0x00FFFFFFFFFFFFFFL, 0x007FFFFFFFFFFFFFL, 0x003FFFFFFFFFFFFFL, 0x001FFFFFFFFFFFFFL,
      0x000FFFFFFFFFFFFFL, 0x0007FFFFFFFFFFFFL, 0x0003FFFFFFFFFFFFL, 0x0001FFFFFFFFFFFFL,
      0x0000FFFFFFFFFFFFL, 0x00007FFFFFFFFFFFL, 0x00003FFFFFFFFFFFL, 0x00001FFFFFFFFFFFL,
      0x00000FFFFFFFFFFFL, 0x000007FFFFFFFFFFL, 0x000003FFFFFFFFFFL, 0x000001FFFFFFFFFFL,
      0x000000FFFFFFFFFFL, 0x0000007FFFFFFFFFL, 0x0000003FFFFFFFFFL, 0x0000001FFFFFFFFFL,
      0x0000000FFFFFFFFFL, 0x00000007FFFFFFFFL, 0x00000003FFFFFFFFL, 0x00000001FFFFFFFFL,
      0x00000000FFFFFFFFL, 0x000000007FFFFFFFL, 0x000000003FFFFFFFL, 0x000000001FFFFFFFL,
      0x000000000FFFFFFFL, 0x0000000007FFFFFFL, 0x0000000003FFFFFFL, 0x0000000001FFFFFFL,
      0x0000000000FFFFFFL, 0x00000000007FFFFFL, 0x00000000003FFFFFL, 0x00000000001FFFFFL,
      0x00000000000FFFFFL, 0x000000000007FFFFL, 0x000000000003FFFFL, 0x000000000001FFFFL,
      0x000000000000FFFFL, 0x0000000000007FFFL, 0x0000000000003FFFL, 0x0000000000001FFFL,
      0x0000000000000FFFL, 0x00000000000007FFL, 0x00000000000003FFL, 0x00000000000001FFL,
      0x00000000000000FFL, 0x000000000000007FL, 0x000000000000003FL, 0x000000000000001FL,
      0x000000000000000FL, 0x0000000000000007L, 0x0000000000000003L, 0x0000000000000001L,
      0x0000000000000000L};

  public static final long[] LOW_BITS_SET =
    new long[] {
      0x0000000000000000L, 0x0000000000000001L, 0x0000000000000003L, 0x0000000000000007L,
      0x000000000000000FL, 0x000000000000001FL, 0x000000000000003FL, 0x000000000000007FL,
      0x00000000000000FFL, 0x00000000000001FFL, 0x00000000000003FFL, 0x00000000000007FFL,
      0x0000000000000FFFL, 0x0000000000001FFFL, 0x0000000000003FFFL, 0x0000000000007FFFL,
      0x000000000000FFFFL, 0x000000000001FFFFL, 0x000000000003FFFFL, 0x000000000007FFFFL,
      0x00000000000FFFFFL, 0x00000000001FFFFFL, 0x00000000003FFFFFL, 0x00000000007FFFFFL,
      0x0000000000FFFFFFL, 0x0000000001FFFFFFL, 0x0000000003FFFFFFL, 0x0000000007FFFFFFL,
      0x000000000FFFFFFFL, 0x000000001FFFFFFFL, 0x000000003FFFFFFFL, 0x000000007FFFFFFFL,
      0x00000000FFFFFFFFL, 0x00000001FFFFFFFFL, 0x00000003FFFFFFFFL, 0x00000007FFFFFFFFL,
      0x0000000FFFFFFFFFL, 0x0000001FFFFFFFFFL, 0x0000003FFFFFFFFFL, 0x0000007FFFFFFFFFL,
      0x000000FFFFFFFFFFL, 0x000001FFFFFFFFFFL, 0x000003FFFFFFFFFFL, 0x000007FFFFFFFFFFL,
      0x00000FFFFFFFFFFFL, 0x00001FFFFFFFFFFFL, 0x00003FFFFFFFFFFFL, 0x00007FFFFFFFFFFFL,
      0x0000FFFFFFFFFFFFL, 0x0001FFFFFFFFFFFFL, 0x0003FFFFFFFFFFFFL, 0x0007FFFFFFFFFFFFL,
      0x000FFFFFFFFFFFFFL, 0x001FFFFFFFFFFFFFL, 0x003FFFFFFFFFFFFFL, 0x007FFFFFFFFFFFFFL,
      0x00FFFFFFFFFFFFFFL, 0x01FFFFFFFFFFFFFFL, 0x03FFFFFFFFFFFFFFL, 0x07FFFFFFFFFFFFFFL,
      0x0FFFFFFFFFFFFFFFL, 0x1FFFFFFFFFFFFFFFL, 0x3FFFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFFFL,
      0xFFFFFFFFFFFFFFFFL};

  public static final long[] LOW_BITS_UNSET =
    new long[] {
      0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFEL, 0xFFFFFFFFFFFFFFFCL, 0xFFFFFFFFFFFFFFF8L,
      0xFFFFFFFFFFFFFFF0L, 0xFFFFFFFFFFFFFFE0L, 0xFFFFFFFFFFFFFFC0L, 0xFFFFFFFFFFFFFF80L,
      0xFFFFFFFFFFFFFF00L, 0xFFFFFFFFFFFFFE00L, 0xFFFFFFFFFFFFFC00L, 0xFFFFFFFFFFFFF800L,
      0xFFFFFFFFFFFFF000L, 0xFFFFFFFFFFFFE000L, 0xFFFFFFFFFFFFC000L, 0xFFFFFFFFFFFF8000L,
      0xFFFFFFFFFFFF0000L, 0xFFFFFFFFFFFE0000L, 0xFFFFFFFFFFFC0000L, 0xFFFFFFFFFFF80000L,
      0xFFFFFFFFFFF00000L, 0xFFFFFFFFFFE00000L, 0xFFFFFFFFFFC00000L, 0xFFFFFFFFFF800000L,
      0xFFFFFFFFFF000000L, 0xFFFFFFFFFE000000L, 0xFFFFFFFFFC000000L, 0xFFFFFFFFF8000000L,
      0xFFFFFFFFF0000000L, 0xFFFFFFFFE0000000L, 0xFFFFFFFFC0000000L, 0xFFFFFFFF80000000L,
      0xFFFFFFFF00000000L, 0xFFFFFFFE00000000L, 0xFFFFFFFC00000000L, 0xFFFFFFF800000000L,
      0xFFFFFFF000000000L, 0xFFFFFFE000000000L, 0xFFFFFFC000000000L, 0xFFFFFF8000000000L,
      0xFFFFFF0000000000L, 0xFFFFFE0000000000L, 0xFFFFFC0000000000L, 0xFFFFF80000000000L,
      0xFFFFF00000000000L, 0xFFFFE00000000000L, 0xFFFFC00000000000L, 0xFFFF800000000000L,
      0xFFFF000000000000L, 0xFFFE000000000000L, 0xFFFC000000000000L, 0xFFF8000000000000L,
      0xFFF0000000000000L, 0xFFE0000000000000L, 0xFFC0000000000000L, 0xFF80000000000000L,
      0xFF00000000000000L, 0xFE00000000000000L, 0xFC00000000000000L, 0xF800000000000000L,
      0xF000000000000000L, 0xE000000000000000L, 0xC000000000000000L, 0x8000000000000000L,
      0x0000000000000000L};

  public static long getBit(long n, int i) {
    return n >>> i & 1L;
  }

  public static long setBit(long n, int i) {
    return n | 1L << i;
  }

  public static long clearBit(long n, int i) {
    return n & ~(1L << i);
  }

  public static int bitsToBlocks64(long bits) {
    return (int) (bits % 64 == 0 ? (bits >>> 6) : ((bits >>> 6) + 1));
  }

  public static int bitWidth(long n) {
    int l = 1;
    while ((n >>= 1) != 0)
      ++l;
    return l;
  }
}