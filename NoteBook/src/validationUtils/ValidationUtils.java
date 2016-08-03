package validationUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
	
	private String codding;
	
	public String getCodding() {
		return codding;
	}

	public void setCodding(String codding) {
		this.codding = codding;
	}
	
	public ValidationUtils (String codding){
		if (codding == "UA" || codding == "EN"){
			this.codding = codding;
		}else{
			this.codding = "UA";
		}
	}

	public static final Pattern charactersUA = Pattern.compile("^[à-ÿÀ-ß³²¿¯ºª']{1,10}([-]{0,1}[à-ÿÀ-ß³²¿¯ºª']{1,10}){0,11}([-]{0,1}[à-ÿÀ-ß³²¿¯ºª']{1,10}){0,11}$");  /*"^[à-ÿÀ-ß³²¿¯ºª'a-zA-Z-]{1,20}$");*/
	public static final Pattern charactersEN = Pattern.compile("^[a-zA-Z]{1,10}([-]{0,1}[a-zA-Z]{1,10}){0,11}([-]{0,1}[a-zA-Z]{1,10}){0,11}$");
	
	//public static final Pattern email = Pattern.compile("^[a-zA-Z._]{1,20}\\@{1}[a-zA-Z]{3,10}\\.{1}[a-zA-Z]{2,4}$");
	public static final Pattern email = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");
	public static final Pattern date = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])[/](0?[1-9]|1[012])[/]((19|20)\\d\\d)");
	public static final Pattern index = Pattern.compile("[0-9]{5}");
	//public static final Pattern town = Pattern.compile("");
	//public static final Pattern street = Pattern.compile("");
	public static final Pattern buildNumber = Pattern.compile("[0-9à-ÿÀ-ß³²¿¯ºª'a-zA-Z/\\s]{1,10}");
	public static final Pattern telNumber = Pattern.compile("[0-9]{6,10}");
	
	public boolean checkharacters(String str){
		Matcher m;
		if (codding == "UA"){
			m = charactersUA.matcher(str); 
		}else{
			m = charactersEN.matcher(str); 
		}
        return m.matches();  
	}
	
	public static boolean checkEmail(String str){
        Matcher m = email.matcher(str);  
        return m.matches();  
	}
	
	public static boolean checkDate(String str){
        Matcher m = date.matcher(str);  
        return m.matches();  
	}
	
	public static boolean checkIndex(String str){
        Matcher m = index.matcher(str);  
        return m.matches();  
	}
	
/*	public static boolean checkTown(String str){
        Matcher m = title.matcher(str);  
        return m.matches();  
	}
*//*	
	public static boolean checkStreet(String str){
        Matcher m = title.matcher(str);  
        return m.matches();  
	}
*/	
	public static boolean checkBuildNumber(String str){
        Matcher m = buildNumber.matcher(str);  
        return m.matches();  
	}
	
	public static boolean checkTelNumber(String str){
        Matcher m = telNumber.matcher(str);  
        return m.matches();  
	}
	
}
