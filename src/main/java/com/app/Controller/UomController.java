package com.app.Controller;

import java.util.ArrayList;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;

@Controller
public class UomController {
	@Autowired
	private IUomService service;
	@Autowired
	private UomUtil uomUtil;
	
	@GetMapping(value={"/","/regUom"})
	public String showRegpage(ModelMap map){
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}
	@PostMapping("/insertUom")
	public String save(@ModelAttribute @Valid Uom uom,BindingResult errors, ModelMap map){
		
		if(errors.hasErrors()){
			
			map.addAttribute("uom", uom);
		}else{
			
			long uomId=service.save(uom);
			map.addAttribute("Msg", uomId);
			map.addAttribute("uom", new Uom());
		}
		
	return "UomRegister";
	}
	@GetMapping("/getAllUom")
	public String getAllUoms(ModelMap map){
		List<Uom> uomList=service.getAll();
		uomUtil.replaceWithValues(uomList);
		map.addAttribute("Uomdata", uomList);
		return "UomData";
	}
	@GetMapping("/deleteUom")
	public String deleteById(@RequestParam("uomId")long uomId){
		service.deleteById(uomId);
		return "redirect:/getAllUom";
	}
	@GetMapping("/editUom")
	public String getById(@RequestParam("uomId")long uomId,ModelMap map){
		Uom uomOb=service.getOneById(uomId);
		map.addAttribute("uom", uomOb);
		map.addAttribute("uomTypes", uomUtil.getUomTypes());
		return "UomDataEditPage";
	}
	@PostMapping("/updateUom")
	public String updateUom(@ModelAttribute @Valid Uom uom,BindingResult errors, ModelMap map){
		if(errors.hasErrors()){
			map.addAttribute("uom", uom);
		}else{
			service.update(uom);
		}
		return "redirect:getAllUom";
	}
	
	
}
