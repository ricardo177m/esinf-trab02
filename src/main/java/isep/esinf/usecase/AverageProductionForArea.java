package isep.esinf.usecase;

import isep.esinf.exceptions.InvalidTimeIntervalException;
import isep.esinf.exceptions.NullAreaException;
import isep.esinf.model.Area;

/**
 * Alínea 2
 * 
 * @author Carlos Lopes
 */
public class AverageProductionForArea {
  private Area area;
  private int firstYear, lastYear;

  public AverageProductionForArea(Area area, int firstYear, int lastYear) throws InvalidTimeIntervalException, NullAreaException{
    setArea(area);
    setTimeInterval(firstYear, lastYear);
  }

  public void setArea(Area area) throws NullAreaException{
    if(area != null){
      this.area = area;
    }else{
      throw new NullAreaException();
    }
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
