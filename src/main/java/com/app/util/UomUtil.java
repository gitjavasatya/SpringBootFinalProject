package com.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Uom;

@Component
public class UomUtil {
	public  List<Uom> replaceWithValues(List<Uom> uomList){
		Iterator<Uom> uomItr=uomList.iterator();
		while (uomItr.hasNext()) {
			Uom uom = (Uom) uomItr.next();
			if(getUomTypes().get(uom.getUomType())!=null)
				uom.setUomType(getUomTypes().get(uom.getUomType()));
		}
		return uomList;
	}

	public Map<String,String> getUomTypes() {
		Map<String, String> uomTypes=new LinkedHashMap<String,String>();
		uomTypes.put("Pack","PACKING");
		uomTypes.put("NoPack","NOPACKING");
		uomTypes.put("Bag","BAG");
		uomTypes.put("Box","BOX");
		uomTypes.put("Roll","ROLL");
		uomTypes.put("NA","-NA-");
		return uomTypes;

	}

	public List<Uom> processUtilImport(MultipartFile file){
		List<Uom> uomlist=null;
		try {
			if(file!=null & file.getSize()>0)
				uomlist=new ArrayList<Uom>();
			InputStream is=file.getInputStream();
			XSSFWorkbook book =new XSSFWorkbook(is);
			Sheet sheet=book.getSheet("uoms");
			Iterator<Row> rowItr=sheet.iterator();
			while (rowItr.hasNext()) {
				Row row = (Row) rowItr.next();
				if(row.getRowNum()==0) continue;
				uomlist.add(
						new Uom(
								row.getCell(0).getStringCellValue(),
								row.getCell(1).getStringCellValue(),
								row.getCell(2).getStringCellValue(),new Date()));
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		return uomlist;

	}

}
