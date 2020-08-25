public class StartsWith implements Predicate<String>{
	
	private String prefix;
	
	public StartsWith(String prefix) {
		if(prefix == null)
			throw new IllegalArgumentException("NullArgument!");
		
		this.prefix = prefix;
	}
	
	

	@Override
	public boolean test(String string) {
		int k = 0;
		boolean result;
		if (string == null)
			return false;
		else if(prefix.length() == 0)
		{
			return true;
		}
		else if(prefix.length() != 0 && string.length() == 0)
		{
			return false;
		}
		else if(prefix.length() > string.length())
		    return false;
		
		char [] pref = new char [prefix.length()]; // converting prefix to char-array
		for(int i = 0; i < prefix.length(); i++)
		{
			pref[i] = prefix.charAt(i);
		}
		
		char [] val = new char [string.length()]; // converting value to char-array
			
		for(int i = 0; i < string.length(); i++)
		{
			val[i] = string.charAt(i);
		}
		
		for(int i = 0; i < prefix.length(); i++) // controlling if the first chars of value those of prefix are
		{
			if(pref[i] != val[i])
				k++;
		}
		
		if (k != 0)
			result = false;
		else
			result = true;
		
		return result;
	}
	
}
