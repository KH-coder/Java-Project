public class NumberComparator implements Comparator {
	
	public boolean isEqualTo(Object item1, Object item2) {
		if ((int)item1 == (int)item2)
			return true;
		else
			return false;
	}
	
	public boolean isGreaterThan (Object item1, Object item2) {
		if ((int)item1 > (int)item2)
			return true;
		else
			return false;
	}
	
	public boolean isLessThan (Object item1, Object item2) {
		if ((int)item1 < (int)item2)
			return true;
		else
			return false;
	}
	
	public boolean isLessThanOrEqualTo (Object item1, Object item2) {
		return isEqualTo(item1, item2) || isLessThan(item1, item2);
	}
	
	public boolean isGreaterThanOrEqualTo (Object item1, Object item2){
		return isEqualTo(item1, item2) || isGreaterThan(item1, item2);
	}
}
