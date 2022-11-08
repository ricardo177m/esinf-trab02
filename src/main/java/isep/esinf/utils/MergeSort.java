package isep.esinf.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort<E> {
  public static <E> List<E> sort(List<E> original, Comparator<E> comparator) {

    // copy original list to aux list
    List<E> aux = new ArrayList<>(original);

    if (aux.size() <= 1) {
      return original;
    }

    int mid = aux.size() / 2;
    List<E> left = new ArrayList<E>(aux.subList(0, mid));
    List<E> right = new ArrayList<E>(aux.subList(mid, aux.size()));

    sort(left, comparator);
    sort(right, comparator);

    return merge(left, right, comparator);
  }

  private static <E> List<E> merge(List<E> left, List<E> right, Comparator<E> comparator) {

    List<E> merged = new ArrayList<E>();

    int i = 0, j = 0, k = 0;

    while (i < left.size() && j < right.size()) {
      if (comparator.compare(left.get(i), right.get(j)) <= 0) {
        merged.add(k++, left.get(i++));
      } else {
        merged.add(k++, right.get(j++));
      }
    }
    while (i < left.size()) {
      merged.add(k++, left.get(i++));
    }
    while (j < right.size()) {
      merged.add(k++, right.get(j++));
    }
    return merged;
  }
}
