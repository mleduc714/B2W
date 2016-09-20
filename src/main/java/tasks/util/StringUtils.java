package tasks.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	public static String titleCase(String sText){
		Pattern pOneWordAllUppper = Pattern.compile("^[\\p{Lu}0-9]+$");
		Pattern pLetternsAndNumbers= Pattern.compile("([\\p{Lu}\\p{Ll}0-9]+)");
		Matcher m;
		String tc=sText.replaceAll("\\s+", " ");
		
		if(!pOneWordAllUppper.matcher(tc).find()) {
			m = pLetternsAndNumbers.matcher(tc);
			while(m.find()){
				String match = m.group();
				String _match = match.substring(0,1).toUpperCase() + match.substring(1).toLowerCase();
				tc = tc.replace(match, _match);
			}
		}
		return tc;
	}
	public static String escapeRegex(String sRegex) {
		String reg = "\\[\\^\\$\\.\\|\\?\\*\\+\\(\\)\\\\";
		return sRegex.replaceAll("([" + reg + "])", "\\\\$1");
	}
	

	
}
