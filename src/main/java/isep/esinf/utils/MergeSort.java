package isep.esinf.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<E> {

  public static <E> E[] sort(E[] original, Comparator<E> cmp) {
    E[] array = Arrays.copyOf(original, original.length);

    // if the array contains only one integer, it is already sorted
    if (array.length <= 1)
      return original;

    // divide the array into two halves
    int mid = array.length / 2;

    // keep dividing recursively until left + right = 1
    E[] left = sort(Arrays.copyOfRange(array, 0, mid), cmp);
    E[] right = sort(Arrays.copyOfRange(array, mid, array.length), cmp);

    // finally, merge both halves
    return merge(left, right, cmp);
  }

  private static <E> E[] merge(E[] left, E[] right, Comparator<E> cmp) {
    // merging the 2 sub arrays into a single array
    int length = left.length + right.length;
    E[] merged = (E[]) Array.newInstance(left.getClass().getComponentType(), length);
    int i = 0, j = 0;

    // reorder the greater integers into the correct position
    while (i < left.length && j < right.length) {
      if (cmp.compare(left[i], right[j]) <= 0) {
        merged[i + j] = left[i++];
      } else {
        merged[i + j] = right[j++];
      }
    }

    // finally, fill with the remainding integers
    while (i < left.length) {
      merged[i + j] = left[i++];
    }
    while (j < right.length) {
      merged[i + j] = right[j++];
    }

    return merged;
  }
}
