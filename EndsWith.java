public class EndsWith implements Predicate<String> {

	private String suffix;
	
	public EndsWith(String suffix) {
		if(suffix == null)
			throw new IllegalArgumentException("Nullargument!");
		this.suffix = suffix;
	}

   
	@Override
	public boolean test (String value) {
		int k = 0;
		boolean result;
		
		if(value == null)
			return false;
		if(suffix.length() == 0)
		    return true;
	    else if(suffix.length() != 0 && value.length() == 0)
	        return false;
   
		
		char [] suff = new char [suffix.length()]; // converting suffix to char-array
		
		for(int i = 0; i < suffix.length(); i++)
		{
			suff[i] = suffix.charAt(i);
		}
		
		char [] val = new char [value.length()]; // converting value to char-array
		
		for(int i = 0; i < value.length(); i++)
		{
			val[i] = value.charAt(i);
		}
		
		int j = 0;
		for(int i = value.length() - suffix.length(); i < value.length(); i++) // controlling if the last chars of value the same as suffix are
		{
		    
			if(suff[j] != val[i])
				k++;
				
			j++;
		}
		
		if(k != 0)
			result = false;
		else 
			result = true;
		
		return result;
		
	}
	
}
