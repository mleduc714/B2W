package tasks.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	public static Date getDateFromString(String sDate) {
		Date dReturn;
		String pattern = "yyyy/M/d";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			dReturn = sdf.parse(sDate);
		} catch (ParseException e) {
			dReturn = null;
		}
		return dReturn;
	}
	public static Date getDateFromStringWithPattern(String sDate, String sPattern) {
		Date dReturn;
		SimpleDateFormat sdf = new SimpleDateFormat(sPattern);
		try {
			dReturn = sdf.parse(sDate);
		} catch (ParseException e) {
			dReturn = null;
		}
		return dReturn;
	}

	public static String getStringFromDateByPattern(Date date, String sPattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(sPattern);
		return sdf.format(date);
	}
	
	public static int getNumberFromID(String sID){

		int iLastIndex = sID.lastIndexOf("_");
		String s = sID.substring(++iLastIndex, sID.length());
		return new Integer(s).intValue();
		
	}

	public static int getHoursFromDuration(String sDuration) {
		int iLastIndex = sDuration.lastIndexOf(" HR");
		if (iLastIndex > 0 ) {
			String s = sDuration.substring(0, iLastIndex);
			return new Integer(s).intValue();
		} else {
			return 0;
		}
	}

	public static int getMinutesFromDuration(String sDuration) {
		int iLastIndex = sDuration.lastIndexOf(" MIN");
		if (iLastIndex > 0 ) {
			int iFirstIndex = sDuration.lastIndexOf(", ");
			if (iFirstIndex < 0) iFirstIndex = -2;
			String s = sDuration.substring(iFirstIndex + 2, iLastIndex);
			return new Integer(s).intValue();
		} else {
			return 0;
		}
	}

}
