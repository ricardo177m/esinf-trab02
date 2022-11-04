package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import isep.esinf.exceptions.InvalidTimeIntervalException;
import isep.esinf.exceptions.NullAreaException;
import isep.esinf.mock.MockContainer;
import isep.esinf.model.Container;

public class AverageProductionForAreaTest {
    private List<Map.Entry<Map.Entry<String,String>, Double>> list;
    private Container c;
    private AverageProductionForArea test;
    private MockContainer mockContainer = new MockContainer();


    @Test
    public void averageProductionForAreaWorks() throws InvalidTimeIntervalException, NullAreaException{
        c = mockContainer.mockByNameExtraMini();
        test = new AverageProductionForArea("Portugal", 1980, 1981, c);

        list = test.execute();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }


        String entryKey = list.get(0).getKey().getKey();
        assertEquals("Item 1", entryKey);

        String entryValue = list.get(0).getKey().getValue();
        assertEquals("Element 1", entryValue);

        Double value = list.get(0).getValue();
        assertEquals((10)/2, value);
    }

    @Test
    public void averageProductionForAreaWorksForInvalidArea() throws InvalidTimeIntervalException, NullAreaException{
        c = new Container();
        test = new AverageProductionForArea("Invalid Area", 1980, 198, c);

        assertEquals(null, test.execute());
    }
}
