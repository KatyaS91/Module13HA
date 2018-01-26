package utils.waiterfactory;

import utils.data.WaiterType;

/**
 * Created by Katsiaryna_Skarzhyns on 1/26/2018.
 */
public class WaiterFactory {

	public Waiter wait(WaiterType waiterType){
		switch (waiterType) {
		case APPEARED:
			return new WaitForElementIsPresent();
		case DISAPPEARED:
			return new WaitForElementDisappeared();
		default:
			return null;
		}
	}
}