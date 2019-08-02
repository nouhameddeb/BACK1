package com.spark.gmao.exception;

public class PieceNotFoundException extends DataNotFoundException{
	
private static final long serialVersionUID = -585393677381609541L;
	
	/**
	 * Exception code
	 */
	private static final String code = "ERROR_NF_001";
	
	/**
	 * Exception message
	 */
	private static final String message = "Pièce not found";
	
	/**
	 * 
	 * @param code
	 * @param message
	 */
	public PieceNotFoundException() {
		super(code, message);
	}

}
