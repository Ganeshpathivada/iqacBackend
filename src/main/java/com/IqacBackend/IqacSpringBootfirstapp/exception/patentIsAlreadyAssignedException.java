package com.IqacBackend.IqacSpringBootfirstapp.exception;

import java.text.MessageFormat;

public class patentIsAlreadyAssignedException extends RuntimeException {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 3199469405029601450L;
public patentIsAlreadyAssignedException(final Long patentId,final Long staffId) {
	super(MessageFormat.format("patent: {0} is already assigned to staff : {1}",patentId,staffId));
}
		
}
