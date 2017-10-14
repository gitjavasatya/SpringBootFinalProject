package com.app.Controller.multipart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.Controller.view.UomExcelView;
import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;
@Controller
public class UomMultiPartController {
	@Autowired
	private IUomService service;
	@Autowired
	private UomUtil uomUtil;

	@GetMapping("/uomMultipart")
	public String showUomMultiPart(){
		
		return "UomMultiPart";
	}
	@GetMapping("/uomExport")
	public ModelAndView exportUom(){
		List<Uom> uoms=service.getAll();
		return new ModelAndView(new UomExcelView(),"uomList", uoms);
	}
	@PostMapping("/uomImport")
	public String importUom(@RequestParam("efile")MultipartFile file, ModelMap map){
		List<Uom> uomList=uomUtil.processUtilImport(file);
		service.saveMultiple(uomList);
		map.addAttribute("importmessage", "Excel Data Imported to DataBase");
		return "UomMultiPart";
	}
}
