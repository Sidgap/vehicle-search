package com.learn2code.vehicleapi.serachn.Exceptions;

public class OwnerComanyNotfoundException extends RuntimeException {
	
  private static final long serialVersionUID=1L;
	
	public OwnerComanyNotfoundException(String message) {
        super(message);
    }

}
