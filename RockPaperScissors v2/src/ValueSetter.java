

public class ValueSetter {
	
public static String getValue(int computerValue) {
	if (computerValue == 1) return "rock";
	else if (computerValue == 2) return "paper";
	else   if (computerValue == 3)return "Scissors";
	else return "code is bad";
}
public static int setValue(String input) {
	String rps[] = {"rock","paper","scissors"};
	for(int x = 0; x< 3; x++) {
		if(  input.equals(rps[x])){
			int value = x + 1;
			return value;
		} 
		}  return -1;
			
		
	}
		
	
	
}

