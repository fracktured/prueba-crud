package com.vmtcounty.apivmtcounty.service;

import com.vmtcounty.apivmtcounty.model.VmtCounty;
import com.vmtcounty.apivmtcounty.request.DeleteRequestBody;

public interface VmtcountyService {
	
	Iterable<VmtCounty> all();
	VmtCounty findById( Integer id );
	VmtCounty add( VmtCounty body );
	VmtCounty update( VmtCounty body );
	boolean delete( DeleteRequestBody body );

}
