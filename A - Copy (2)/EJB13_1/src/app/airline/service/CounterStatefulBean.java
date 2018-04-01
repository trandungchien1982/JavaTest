package app.airline.service;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class CounterBean
 */
@Stateful
@LocalBean
public class CounterStatefulBean {

	private Integer count = 0;
	
    /**
     * Default constructor. 
     */
    public CounterStatefulBean() {
        // TODO Auto-generated constructor stub
    }

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public void addOneToCount() {
		this.count++;
	}

}
