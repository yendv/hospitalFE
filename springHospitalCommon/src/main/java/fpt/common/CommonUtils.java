/**
 * 
 */
package fpt.common;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author YenDV
 *
 */
public class CommonUtils {
	public static BigDecimal convertToBigDecimal(String value) {
		BigDecimal result = new BigDecimal("0");
		String regexBigDecimal = "-?(?:\\d+(?:\\.\\d+)?|\\.\\d+)";
		result = value != null && value.matches(regexBigDecimal) ? 
				new BigDecimal(value) : null; 
		return result;
	}
	
	public static Integer convertToInteger(String value) {
		Integer result = null;
		String regexInteger = "^-?\\d{1,19}$";
		result = value != null && value.matches(regexInteger) ? 
				Integer.parseInt(value) : null;
		return result;
	}
	
	public static java.sql.Timestamp convertToTimeStamp(String value) {
		Timestamp result = null;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		String regexTimeStamp = "^-?\\d{1,19}$";
		try {
			result = value != null && value.matches(regexTimeStamp) ? 
					new Timestamp(df.parse(value).getTime()) : null;
		} catch (ParseException e) {
			
		}
		return result;
	}
}
