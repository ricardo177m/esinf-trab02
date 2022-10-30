package isep.esinf.usecase;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;

import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.Element;
import isep.esinf.model.Item;
import isep.esinf.model.comparators.AreaByName;
import isep.esinf.model.comparators.ElementByName;
import isep.esinf.model.comparators.ItemByName;

public class AcumulatedProductionInAreaTest {
  AccumulatedProductionInArea aInArea = new AccumulatedProductionInArea();

  @Test
  public void testAccumulatedProductionInArea() throws FileNotFoundException {
    Container c = new Container();

    Area portugal = new AreaByName(13, 100, "Portugal");
    Area spain = new AreaByName(14, 50, "Spain");
    Area italy = new AreaByName(11, 90, "Italy");

    c.addArea(portugal);
    c.addArea(spain);
    c.addArea(italy);

    Item item = new ItemByName(10, 12, "Wheat");
    Element element = new ElementByName(10, "Test");

    List<Area> list = aInArea.execute(3, 3, 9, 9, item, 2010, element, c);

  }
}
