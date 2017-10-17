package com.app.provider;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
public class UomRestController {
	@Autowired
	private IUomService service;
	
	@PostMapping("/rest/saveUom")
	public ResponseEntity<?> saveUom(@RequestBody @Valid Uom uom,BindingResult errors){
		if(errors.hasErrors()){
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else{
			long uomId=service.save(uom);
			return ResponseEntity.ok("Uom data Saved with Id"+uomId);
		}
		
	}
	@PostMapping("/rest/updateUom")
	public ResponseEntity<?> updateUom(@RequestBody @Valid Uom uom,BindingResult errors){
		if(errors.hasErrors()){
			return ResponseEntity.badRequest().body(errors.getAllErrors());
			}else{
				service.update(uom);
				return ResponseEntity.ok("Uom Data Updated");
			}
		
		
	}
	@GetMapping("/rest/deleteUom/{uomId}")
	public String deleteUom(@PathVariable Long uomId){
		service.deleteById(uomId);
		return "Uom Record Deleted with id:"+uomId;
	}
	@GetMapping("/rest/getone/{uomId}")
	public ResponseEntity<?> getOne(@PathVariable Long uomId){
		Uom uom=service.getOneById(uomId);
		if(uom!=null)
			return ResponseEntity.ok(uom);
		else
			return ResponseEntity.ok("Record Not Found");
	}
	
	@GetMapping("/rest/getAll")
	public ResponseEntity<?> getAllUom(){
		List<Uom> uomList= service.getAll();
		if(uomList!=null & uomList.size()>0)
			return ResponseEntity.ok(uomList);
		else 
			return ResponseEntity.ok("Records Not Found");
	}

}
