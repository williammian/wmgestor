package br.com.wm.wmgestorapi.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super( "Resource Not found with id = " + id);
	}

}
