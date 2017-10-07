package br.com.estou.precisando.util.validator;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.context.annotation.PropertySource;

import br.com.estou.precisando.user.User;

@PropertySource(value = { "messages_pt.properties" })
public class ValidatorDate {
	
	public static void validateAge(User user) {
		Calendar nowCal = new GregorianCalendar();
		Integer age = nowCal.get(Calendar.YEAR) - user.getDateOfBirth().get(Calendar.YEAR);
		if(age < 18) {
			throw new IllegalArgumentException("pamater.age.invalid");
		}
	}

}
