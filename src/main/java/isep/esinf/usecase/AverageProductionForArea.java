package isep.esinf.usecase;

import javax.swing.text.AbstractDocument.Content;

import isep.esinf.exceptions.InvalidTimeIntervalException;
import isep.esinf.exceptions.NullAreaException;
import isep.esinf.model.Area;
import isep.esinf.model.Container;
import isep.esinf.model.comparators.AreaByName;

/**
 * Alínea 2
 * 
 * @author Carlos Lopes
 */
public class AverageProductionForArea {
  private int firstYear, lastYear;
  private Area area;

  public AverageProductionForArea(String area, int firstYear, int lastYear, Container container) throws InvalidTimeIntervalException, NullAreaException{
    if(area == null || area.equals(""))
    throw new NullAreaException();

    Area a = new AreaByName(0, "", area);
    this.area = container.getArea(a);

    setTimeInterval(firstYear, lastYear);
  }

  public void setTimeInterval(int firstYear, int lastYear) throws InvalidTimeIntervalException{
    if(firstYear <= 0 || lastYear <= 0){

      if(lastYear < firstYear){
        this.lastYear = firstYear;
        this.firstYear = lastYear;
      }else{
        this.lastYear = lastYear;
        this.firstYear = firstYear;
      }

    }else{
      throw new InvalidTimeIntervalException();
    }
  }
  
  public void execute() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
