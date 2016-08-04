package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
	
	private String codding;
	
	private static String NAME_PATTERN;
	private static String EMAIL_PATTERN;
	private static String DATE_PATTERN;
	private static String INDEX_PATTERN;
	private static String STREET_PATTERN;
	private static String BUILD_PATTERN;
	private static String TELNUMBER_PATTERN;
	private static String TOWN_PATTERN;
	
	
	public String getCodding() {
		return codding;
	}

	public void setCodding(String codding) {
		this.codding = codding;
	}
	
	private void setPatterns(){
		if (codding == "UA"){
			NAME_PATTERN = "^[A-ZÀ-ß²¯]{1}[à-ÿ³¿º'a-z]{1,9}([-]{1}[A-ZÀ-ß²¯]{1}[à-ÿ³¿º'a-z]{1,9}){0,11}$";
			DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])[\\.](0?[1-9]|1[012])[\\.]((19|20)\\d\\d)";
			
		}
		if (codding == "EN"){
			NAME_PATTERN = "^[A-Z]{1}[a-z]{1,9}([-]{1}[A-Z]{1}[a-z]{1,9}){0,11}$";
			DATE_PATTERN = "(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)";
		}
		EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
		INDEX_PATTERN = "[1-9]{1}[0-9]{4}";
		STREET_PATTERN ="^([1-9A-ZÀ-ß¯ª]{1}[0-9A-ZÀ-ß²¯à-ÿ³¿º'a-z-\\s\\.]{0,19}){1,20}$"; 
		BUILD_PATTERN = "^([1-9]{1}[0-9]{0,9}(/{0,1}[à-ÿÀ-ß³²¿¯ºª'a-zA-Z]{1,2}){0,3}\\s{0,1}([1-9]{1,9}[0-9]{0,8}){0,9}){1,10}$"; //"([1-9]{1}[0-9à-ÿÀ-ß³²¿¯ºª'a-zA-Z/\\s]{0,9}){1,10}"; 
		TELNUMBER_PATTERN = "[(]{1}[0-9]{3}[)]{1}[0-9]{7}";
		TOWN_PATTERN = "^[A-Z]{1}[a-z]{1,9}([-]{1}\\s{1}[A-Z]{1}[a-z]{1,9}){0,11}$";
	}
	
	public ValidationUtils (String codding){
		if ("UA".equals(codding) || "EN".equals(codding)){
			this.codding = codding;
		}else{
			this.codding = "UA";
		}
		setPatterns();
	}
	
	public ValidationUtils (){
	}
	
	
	public boolean checkCharacters(String str){
		Matcher m = Pattern.compile(NAME_PATTERN).matcher(str); 
        return m.matches();  
	}
	
	public boolean checkEmail(String str){
        Matcher m =Pattern.compile(EMAIL_PATTERN).matcher(str);  
        return m.matches();  
	}
	
	public boolean checkDate(String str){
		Matcher m = Pattern.compile(DATE_PATTERN).matcher(str); 
        return m.matches();  
	}
	
	public boolean checkIndex(String str){
        Matcher m = Pattern.compile(INDEX_PATTERN).matcher(str);  
        return m.matches();  
	}
	
	public boolean checkTown(String str){
        Matcher m = Pattern.compile(TOWN_PATTERN).matcher(str);  
        return m.matches();  
	}
	
	
	
	public boolean checkStreet(String str){
        Matcher m = Pattern.compile(STREET_PATTERN).matcher(str);  
        return m.matches();  
	}
	
	public boolean checkBuildNumber(String str){
        Matcher m = Pattern.compile(BUILD_PATTERN).matcher(str);  
        return m.matches();  
	}
	 
	public boolean checkTelNumber(String str){
        Matcher m = Pattern.compile(TELNUMBER_PATTERN).matcher(str);  
        return m.matches();  
	}
	
}
