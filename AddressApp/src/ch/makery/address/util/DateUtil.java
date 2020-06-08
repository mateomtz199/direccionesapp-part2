package ch.makery.address.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Yo
 * Funciones de ayuda para manejar fechas
 *
 */
public class DateUtil {
	/**
	 * El patron de fecha puede ser cambiado
	 */
	private static final String DATE_PATTERN = "dd.MM.yyyy";
	/**
	 * El formateador de fechas
	 */
	private static final DateTimeFormatter DATE_FORMATTER =
			DateTimeFormatter.ofPattern(DATE_PATTERN);
	/**
	 * Método que devuelve la fecha como una cadena
	 * @param date La fecha que se convertirá en una cadena
	 * @return la fecha en String
	 */
	public static String format(LocalDate date){
		if(date == null){
			return null;
		}
		return DATE_FORMATTER.format(date);
	}
	/**
	 * Convierte una cadena con formato de fecha a un objeto de tipo LocaDate
	 * devuelve nulo si la caea no se pudo convertir
	 *
	 * @param dateString La fecha en formato String
	 * @return La feca en un objeto o nulo si no se pudo convertir
	 */
	public static LocalDate parse(String dateString){
		try{
			return DATE_FORMATTER.parse(dateString, LocalDate::from);
		}catch (DateTimeException e) {
			return null;
		}
	}
	/**
	 * Comprueba la cadena si es una fecha válida
	 * @param dateString
	 * @return verdadero si la cadena es una fecha valida
	 */
	public static boolean validDate(String dateString){
		//Intenta analizar la cadena
		return DateUtil.parse(dateString) != null;
	}

}
