public class HasLength implements Predicate<String>{

	private int length;
	
	public HasLength(int length) {
		if(length < 0)
			throw new IllegalArgumentException("Negative Length!");
		this.length= length;
	}
	

	
	@Override
	public boolean test(String value) {
		boolean result;
		if(value == null)
			return false;
		
		if(length == value.length())
			result = true;
		else
			result = false;
		
		return result;
	}
}
