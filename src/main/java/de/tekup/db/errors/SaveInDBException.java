package de.tekup.db.errors;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SaveInDBException extends RuntimeException{

	public SaveInDBException(String message) {
		super(message);
	}

}
