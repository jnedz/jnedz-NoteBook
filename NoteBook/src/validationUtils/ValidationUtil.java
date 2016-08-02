package validationUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Address;

public class ValidationUtil {
	
	//TODO pattern
	public static final Pattern name = Pattern.compile("");
	public static final Pattern email = Pattern.compile("");
	public static final Pattern date = Pattern.compile("");
	public static final Pattern index = Pattern.compile("");
	public static final Pattern town = Pattern.compile("");
	public static final Pattern street = Pattern.compile("");
	public static final Pattern buildNumber = Pattern.compile("");
	public static final Pattern telNumber = Pattern.compile("");
	
	public static boolean checkName(String str){
        Matcher m = name.matcher(str);  
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
	
	public static boolean checkTown(String str){
        Matcher m = town.matcher(str);  
        return m.matches();  
	}
	
	public static boolean checkStreet(String str){
        Matcher m = street.matcher(str);  
        return m.matches();  
	}
	
	public static boolean checkBuildNumber(String str){
        Matcher m = buildNumber.matcher(str);  
        return m.matches();  
	}
	
	public static boolean checkTelNumber(String str){
        Matcher m = telNumber.matcher(str);  
        return m.matches();  
	}
	
}
