package isep.esinf.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.geom.Point2D;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoDTreeTest {
    Point2D.Double[] arr = new Point2D.Double[6];
    {
        arr[0] = new Point2D.Double(30, 40);
        arr[1] = new Point2D.Double(5, 25);
        arr[2] = new Point2D.Double(10, 12);
        arr[3] = new Point2D.Double(70, 70);
        arr[4] = new Point2D.Double(50, 30);
        arr[5] = new Point2D.Double(35, 45);
    }

    TwoDTree<Integer> tree;

    public TwoDTreeTest() {
    }

    @BeforeEach
    public void setUp() {
        tree = new TwoDTree<>();
        TwoDNode<Integer> root = new TwoDNode<>(0, null, null, arr[0]);
        tree.root = root;

    }

    @Test
    public void testInsertionTwoDTree() {
        System.out.println(tree.root.getCoords());

        tree.insert(59, arr[1].getX(), arr[1].getY());
        tree.insert(13, arr[2].getX(), arr[2].getY());
        tree.insert(22, arr[3].getX(), arr[3].getY());
        tree.insert(11, arr[4].getX(), arr[4].getY());
        tree.insert(33, arr[5].getX(), arr[5].getY());
        Iterable<Integer> list = tree.inOrder();
        Iterable<Integer> expected = List.of(59, 13, 11, 33, 22, 0);
        assertEquals(expected, list);
    }

}
