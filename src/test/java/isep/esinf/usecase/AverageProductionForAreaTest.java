package isep.esinf.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import isep.esinf.exceptions.InvalidTimeIntervalException;
import isep.esinf.exceptions.NullAreaException;
import isep.esinf.exceptions.NullContainerException;
import isep.esinf.mock.MockContainer;
import isep.esinf.model.Container;

public class AverageProductionForAreaTest {
    private List<Map.Entry<Map.Entry<String,String>, Double>> list;
    private Container c;
    private AverageProductionForArea test;
    private MockContainer mockContainer = new MockContainer();


    @Test
    public void testWorks() throws InvalidTimeIntervalException, NullAreaException, NullContainerException{
        c = mockContainer.mockByNameExtraMini();
        test = new AverageProductionForArea("Portugal", 1980, 1981, c);

        list = test.execute();

        assertEquals(1, list.size());


        String entryKey = list.get(0).getKey().getKey();
        assertEquals("Item 1", entryKey);

        String entryValue = list.get(0).getKey().getValue();
        assertEquals("Element 1", entryValue);

        Double value = list.get(0).getValue();
        assertEquals((10)/2, value);
    }

    @Test
    public void testWorksForInvertedTimeInterval() throws InvalidTimeIntervalException, NullAreaException, NullContainerException{
        c = mockContainer.mockByNameExtraMini();
        test = new AverageProductionForArea("Portugal", 1981, 1980, c);

        list = test.execute();

        assertEquals(1, list.size());

        String entryKey = list.get(0).getKey().getKey();
        assertEquals("Item 1", entryKey);

        String entryValue = list.get(0).getKey().getValue();
        assertEquals("Element 1", entryValue);

        Double value = list.get(0).getValue();
        assertEquals((10)/2, value);
    }

    @Test
    public void testWorksForInvalidArea() throws InvalidTimeIntervalException, NullAreaException, NullContainerException{
        c = new Container();
        test = new AverageProductionForArea("Invalid Area", 1980, 1981, c);

        assertEquals(null, test.execute());
    }

    @Test
    public void testWorksForBiggerContainer() throws InvalidTimeIntervalException, NullAreaException, NullContainerException{
        c = mockContainer.mockByName();
        test = new AverageProductionForArea("Burundi", 1980, 1983, c);

        list = test.execute();

        assertEquals(3, list.size());


        String entryKey = list.get(0).getKey().getKey();
        assertEquals("Item 7", entryKey);

        String entryValue = list.get(0).getKey().getValue();
        assertEquals("Element 1", entryValue);

        Double value = list.get(0).getValue();
        assertEquals((200+300+400)/4, value);

        

        entryKey = list.get(1).getKey().getKey();
        assertEquals("Item 7", entryKey);

        entryValue = list.get(1).getKey().getValue();
        assertEquals("Element 2", entryValue);

        value = list.get(1).getValue();
        assertEquals((200+500)/4, value);



        entryKey = list.get(2).getKey().getKey();
        assertEquals("Item 8", entryKey);

        entryValue = list.get(2).getKey().getValue();
        assertEquals("Element 4", entryValue);

        value = list.get(2).getValue();
        assertEquals((200)/4, value);
    }

    @Test
    public void testWithInvalidTimeInterval(){
        c = mockContainer.mockByName();
        assertThrows(InvalidTimeIntervalException.class, () -> new AverageProductionForArea("Burundi", -2, -2, c));
    }

    @Test
    public void testWithInvalidArea(){
        c = mockContainer.mockByName();
        assertThrows(NullAreaException.class, () -> new AverageProductionForArea(null, 1980, 1983, c));
    }
    
    @Test
    public void testWithInvalidContainer(){
        assertThrows(NullContainerException.class, () -> new AverageProductionForArea("Portugal", 1980, 1983, null));
    }

    
}
