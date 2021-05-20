package com.vmtcounty.apivmtcounty.exception;

import com.vmtcounty.apivmtcounty.model.VmtCounty;

public class VmtCountyIdInUseException extends RuntimeException {
	
	private static final String ERROR_MESSAGE = "El id [%s] ya se encuentra en uso para detalle de %s, %s del %s";

	public VmtCountyIdInUseException(VmtCounty vmtCounty) {
		super(String.format(ERROR_MESSAGE, vmtCounty.getId(), vmtCounty.getCountyName(), vmtCounty.getStateName(), vmtCounty.getDate()));
	}
	
}
