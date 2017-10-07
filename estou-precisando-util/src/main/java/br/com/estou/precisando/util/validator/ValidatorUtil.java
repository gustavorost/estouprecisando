package br.com.estou.precisando.util.validator;

import java.util.ResourceBundle;

import org.apache.commons.validator.routines.EmailValidator;

import antlr.StringUtils;

public class ValidatorUtil {

	private static ResourceBundle labels = ResourceBundle.getBundle("messages_pt");
	private static final String TEXT_SPACE = " ";

	public static void notNullParameter(final Object parameter) {
		if (parameter == null) {
			throw new IllegalArgumentException(labels.getString("pamater.not.null"));
		}
	}

	public static void notNullParameter(final Object parameter, String parameterField) {
		if (parameter == null) {
			throw new IllegalArgumentException(
					parameterField + TEXT_SPACE + labels.getString("pamater.field.not.null"));
		}
	}

	public static void validateEmail(final String email) {
		EmailValidator emailValidator = EmailValidator.getInstance();
		if (!emailValidator.isValid(email)) {
			throw new IllegalArgumentException("pamater.field.email.invalid");
		}
	}

}
