package com.vmtcounty.apivmtcounty.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmtcounty.apivmtcounty.exception.VmtCountyIdInUseException;
import com.vmtcounty.apivmtcounty.exception.VmtCountyNotFoundException;
import com.vmtcounty.apivmtcounty.model.VmtCounty;
import com.vmtcounty.apivmtcounty.repository.VmtCountyRepository;
import com.vmtcounty.apivmtcounty.request.DeleteRequestBody;
import com.vmtcounty.apivmtcounty.service.VmtcountyService;

@Service
public class VmtcountyServiceImpl implements VmtcountyService {

	@Autowired
	private VmtCountyRepository vmtCountyRepository;
	
	public Iterable<VmtCounty> all() {
		return vmtCountyRepository.findAll();
	}
	
	public VmtCounty findById( Integer id ) {
		return vmtCountyRepository.findById( id )
				.orElseThrow(() -> new VmtCountyNotFoundException( id ));
	}
	
	public VmtCounty add( VmtCounty newEntity ) {
		Optional<VmtCounty> vmtCounty = vmtCountyRepository.findById( newEntity.getId() );
		if ( vmtCounty.isPresent() ) {
			throw new VmtCountyIdInUseException( vmtCounty.get() );
		}
		
		return vmtCountyRepository.save( newEntity );
	}
	
	public VmtCounty update( VmtCounty vmtCounty ) {
		if ( vmtCountyRepository.findById( vmtCounty.getId() ).isPresent() ) {
			return vmtCountyRepository.save( vmtCounty );
		}

		throw new VmtCountyNotFoundException( vmtCounty.getId() );		
	}
	
	public boolean delete( DeleteRequestBody body ) {
		VmtCounty vmtCounty = vmtCountyRepository.findById( body.getId() )
				.orElseThrow(() -> new VmtCountyNotFoundException( body.getId() ));
		
		vmtCountyRepository.delete( vmtCounty );
		return true;
	}
}
