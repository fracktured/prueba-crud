package com.vmtcounty.apivmtcounty.controller;


import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.vmtcounty.apivmtcounty.model.VmtCounty;
import com.vmtcounty.apivmtcounty.request.DeleteRequestBody;
import com.vmtcounty.apivmtcounty.service.VmtcountyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RestController
public class ApiVmtcountyController {
	
	private final VmtcountyService vmtcountyService;

    public ApiVmtcountyController(VmtcountyService vmtcountyService) {
        this.vmtcountyService = vmtcountyService;
    }

	
    @Operation(summary = "Obtiene listado de nivel de actividad de vehículos en un estado por dia")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "OK", 
    				content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VmtCounty.class)) }),
            @ApiResponse(responseCode = "404", description = "No existen registros de nivel de actividad de vehículos", content = @Content)})
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Iterable<VmtCounty>> all() {
    	return ResponseEntity
    			.ok()
    			.body( vmtcountyService.all() );
    }
    
    @Operation(summary = "Obtiene nivel de actividad de vehículos en un estado por dia")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "OK", 
    				content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VmtCounty.class)) }),
    		@ApiResponse(responseCode = "400", description = "Campo id inválido", content = @Content), 
            @ApiResponse(responseCode = "404", description = "Nivel de actividad de vehículos no encontrado", content = @Content)})
    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<VmtCounty> findById( @PathVariable(value = "id") Integer id ) {
    	return ResponseEntity
    			.ok()
    			.body( vmtcountyService.findById(id) );
    }
    
    @Operation(summary = "Registra nuevo nivel de actividad de vehículos en un estado por dia")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "201", description = "Creado", 
    				content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VmtCounty.class)) }),
    		@ApiResponse(responseCode = "400", description = "Campo inválido", content = @Content), 
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content)})
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<VmtCounty> add(@Valid @RequestBody VmtCounty body, UriComponentsBuilder b) {
    	UriComponents uriComponents = b.path("/add").buildAndExpand();
    	
    	return ResponseEntity
    			.created(uriComponents.toUri())
    			.body(vmtcountyService.add( body ));
    }
    
    @Operation(summary = "Actualiza nuevo nivel de actividad de vehículos en un estado por dia")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Actualizado", 
    				content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VmtCounty.class)) }),
    		@ApiResponse(responseCode = "400", description = "Campo inválido", content = @Content), 
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content)})
    @PostMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<VmtCounty> modify(@Valid @RequestBody VmtCounty body) {
    	return ResponseEntity
    			.ok()
    			.body( vmtcountyService.update(body) );
    }
    
    @Operation(summary = "Elimina registro de nivel de actividad de vehículos en un estado por dia")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "Eliminado", 
    				content = { @Content(mediaType = "application/json", schema = @Schema(implementation = VmtCounty.class)) }),
    		@ApiResponse(responseCode = "400", description = "Campo id inválido", content = @Content), 
            @ApiResponse(responseCode = "404", description = "Nivel de actividad de vehículos no encontrado", content = @Content)})
    @PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<String> delete(@RequestBody DeleteRequestBody body ) {
    	vmtcountyService.delete( body );
    	return ResponseEntity
    			.ok()
    			.build();
    }

}
