package isep.esinf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import isep.esinf.model.comparators.ElementByCode;

public class ElementTest {
    private static Element e = new ElementByCode(0, "element");

    @Test
    public void testvalueSumTimeInterval(){
        e.addProductionData(new ProductionData(1997, new Value(100, "unit", "flag", "flagDescription")));
        e.addProductionData(new ProductionData(2000, new Value(100, "unit", "flag", "flagDescription")));
        e.addProductionData(new ProductionData(2003, new Value(200, "unit", "flag", "flagDescription")));
        e.addProductionData(new ProductionData(2005, new Value(300, "unit", "flag", "flagDescription")));
        e.addProductionData(new ProductionData(2007, new Value(250, "unit", "flag", "flagDescription")));
        e.addProductionData(new ProductionData(2009, new Value(100, "unit", "flag", "flagDescription")));

        assertEquals(e.valueSumTimeInterval(2001, 2007), (float)(200+300+250));
    }

    @Test
    public void testvalueSumTimeIntervalWithNullElement(){
        assertEquals(e.valueSumTimeInterval(2001, 2007), 0);
    }

    @Test
    public void testvalueSumTimeIntervalWhitoutData(){
        e.addProductionData(new ProductionData(1997, new Value(100, "unit", "flag", "flagDescription")));
        e.addProductionData(new ProductionData(2000, new Value(100, "unit", "flag", "flagDescription")));

        assertEquals(e.valueSumTimeInterval(2001, 2007), 0);
    }
}
