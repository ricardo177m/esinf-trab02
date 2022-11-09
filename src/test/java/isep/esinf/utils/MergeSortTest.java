package isep.esinf.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortTest {

  private static final Comparator<Integer> cmp = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return o1.compareTo(o2);
    }
  };

  private static final Comparator<String> cmpStr = new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
      return o1.compareTo(o2);
    }
  };

  @Test
  public void testMergeSort() {
    System.out.println("testMergeSort");
    List<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(4);
    list.add(3);
    list.add(2);
    list.add(1);

    MergeSort<Integer> mergeSort = new MergeSort<>();
    List<Integer> sortedList = mergeSort.sort(list, cmp);

    assertEquals(1, sortedList.get(0));
    assertEquals(2, sortedList.get(1));
    assertEquals(3, sortedList.get(2));
    assertEquals(4, sortedList.get(3));
    assertEquals(5, sortedList.get(4));

  }

  @Test
  public void testMergeSortWithNullList() {
    System.out.println("testMergeSortWithNullList");
    List<Integer> list = null;

    MergeSort<Integer> mergeSort = new MergeSort<>();
    List<Integer> sortedList = mergeSort.sort(list, cmp);

    assertEquals(null, sortedList);
  }

  @Test
  public void testMergeSortWithEmptyList() {
    System.out.println("testMergeSortWithEmptyList");
    List<Integer> list = new ArrayList<>();

    MergeSort<Integer> mergeSort = new MergeSort<>();
    List<Integer> sortedList = mergeSort.sort(list, cmp);

    assertEquals(0, sortedList.size());
  }

  @Test
  public void testMergeSortWithSizeList() {
    System.out.println("testMergeSortWithSizeList");
    List<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(4);
    list.add(3);
    list.add(2);
    list.add(1);

    MergeSort<Integer> mergeSort = new MergeSort<>();
    List<Integer> sortedList = mergeSort.sort(list, cmp);

    assertEquals(5, sortedList.size());
  }

  @Test
  public void testMergeSortWithNullComparator() {
    System.out.println("testMergeSortWithNullComparator");
    List<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(4);
    list.add(3);
    list.add(2);
    list.add(1);

    MergeSort<Integer> mergeSort = new MergeSort<>();
    List<Integer> sortedList = mergeSort.sort(list, null);
    List<Integer> expectedList = new ArrayList<>();
    expectedList.add(5);
    expectedList.add(4);
    expectedList.add(3);
    expectedList.add(2);
    expectedList.add(1);

    assertEquals(expectedList, sortedList);
  }

  @Test
  public void testMergeSortWithEqualElements() {
    System.out.println("testMergeSortWithEqualElements");
    List<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(4);
    list.add(3);
    list.add(2);
    list.add(1);
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    MergeSort<Integer> mergeSort = new MergeSort<>();
    List<Integer> sortedList = mergeSort.sort(list, cmp);

    assertEquals(1, sortedList.get(0));
    assertEquals(1, sortedList.get(1));
    assertEquals(2, sortedList.get(2));
    assertEquals(2, sortedList.get(3));
    assertEquals(3, sortedList.get(4));
    assertEquals(3, sortedList.get(5));
    assertEquals(4, sortedList.get(6));
    assertEquals(4, sortedList.get(7));
    assertEquals(5, sortedList.get(8));
    assertEquals(5, sortedList.get(9));
  }

  @Test
  public void testMergeSortWithNegativeElements() {
    System.out.println("testMergeSortWithNegativeElements");
    List<Integer> list = new ArrayList<>();
    list.add(-5);
    list.add(-4);
    list.add(-3);
    list.add(-2);
    list.add(-1);

    MergeSort<Integer> mergeSort = new MergeSort<>();
    List<Integer> sortedList = mergeSort.sort(list, cmp);

    assertEquals(-5, sortedList.get(0));
    assertEquals(-4, sortedList.get(1));
    assertEquals(-3, sortedList.get(2));
    assertEquals(-2, sortedList.get(3));
    assertEquals(-1, sortedList.get(4));
  }

  @Test
  public void testMergeSortWithPositiveAndNegativeElements() {
    System.out.println("testMergeSortWithPositiveAndNegativeElements");
    List<Integer> list = new ArrayList<>();
    list.add(-5);
    list.add(-4);
    list.add(-3);
    list.add(-2);
    list.add(-1);
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    MergeSort<Integer> mergeSort = new MergeSort<>();
    List<Integer> sortedList = mergeSort.sort(list, cmp);

    assertEquals(-5, sortedList.get(0));
    assertEquals(-4, sortedList.get(1));
    assertEquals(-3, sortedList.get(2));
    assertEquals(-2, sortedList.get(3));
    assertEquals(-1, sortedList.get(4));
    assertEquals(1, sortedList.get(5));
    assertEquals(2, sortedList.get(6));
    assertEquals(3, sortedList.get(7));
    assertEquals(4, sortedList.get(8));
    assertEquals(5, sortedList.get(9));
  }

  @Test
  public void testMergeSortWithPositiveAndNegativeElementsAndEqualElements() {
    System.out.println("testMergeSortWithPositiveAndNegativeElementsAndEqualElements");
    List<Integer> list = new ArrayList<>();
    list.add(-4);
    list.add(-3);
    list.add(-2);
    list.add(-1);
    list.add(2);
    list.add(3);
    list.add(5);
    list.add(4);
    list.add(3);
    list.add(2);
    list.add(1);
    list.add(-2);
    list.add(-3);
    list.add(-4);

    MergeSort<Integer> mergeSort = new MergeSort<>();
    List<Integer> sortedList = mergeSort.sort(list, cmp);

    assertEquals(-4, sortedList.get(0));
    assertEquals(-4, sortedList.get(1));
    assertEquals(-3, sortedList.get(2));
    assertEquals(-3, sortedList.get(3));
    assertEquals(-2, sortedList.get(4));
    assertEquals(-2, sortedList.get(5));
    assertEquals(-1, sortedList.get(6));
    assertEquals(1, sortedList.get(7));
    assertEquals(2, sortedList.get(8));
    assertEquals(2, sortedList.get(9));
    assertEquals(3, sortedList.get(10));
    assertEquals(3, sortedList.get(11));
    assertEquals(4, sortedList.get(12));
    assertEquals(5, sortedList.get(13));
  }

  @Test
  public void testMergeSortWithStrings() {
    System.out.println("testMergeSortWithStrings");
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("d");
    list.add("c");
    list.add("b");
    list.add("e");

    MergeSort<String> mergeSort = new MergeSort<>();
    List<String> sortedList = mergeSort.sort(list, cmpStr);
    List<String> expectedList = new ArrayList<>();
    expectedList.add("a");
    expectedList.add("b");
    expectedList.add("c");
    expectedList.add("d");
    expectedList.add("e");

    assertEquals(expectedList, sortedList);
  }
}
