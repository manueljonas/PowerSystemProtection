package br.ufrn.imd.model;

import java.util.Date; // Importando a classe Date
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ConvertDate {

	public ConvertDate() {
		// Metodo construtor vazio
	}

	// Converte data no formato String "yyyy/MM/dd HH:mm:ss.SSS" para o formato Date
	public Date convertStringToDate(String dateString) {
		Date date;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		try {
			date = sdf.parse(dateString);
		} catch (ParseException ex) {
			return null;
		}
		return date;
	}

	// Converte data no formato Date para o formato String "yyyy/MM/dd HH:mm:ss.SSS"
	public String convertDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		return sdf.format(date);
	}

	public long convertStringToTimeMillis(String dateString) {
		long dateTimeMillis;
		dateTimeMillis = convertStringToDate(dateString).getTime();
		return dateTimeMillis;
	}

	public String convertTimeMillisToString(long timeMillis) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		return sdf.format(timeMillis);
	}

}