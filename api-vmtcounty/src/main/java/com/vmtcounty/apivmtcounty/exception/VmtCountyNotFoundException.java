package com.vmtcounty.apivmtcounty.exception;

public class VmtCountyNotFoundException extends RuntimeException {
	
	public VmtCountyNotFoundException(Integer id) {
		super("No existe nivel de actividad de vehículos para id: " + id);
	}
}
