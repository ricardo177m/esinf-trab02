/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package isep.esinf.utils;

/**
 *
 * @author DEI-ESINF
 * @param <E>
 */
public interface BSTInterface<E> {
  public boolean isEmpty();

  public void insert(E element);

  public void remove(E element);

  public int size();

  public int height();

  public E smallestElement();

  public E biggestElement();

  public Iterable<E> inOrder();

  public Iterable<E> preOrder();

  public Iterable<E> posOrder();

}
