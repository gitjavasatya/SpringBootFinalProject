package com.app.Controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Content;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook book, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=\"Book1.xls\"");

List<Uom> uomList=(List<Uom>) map.get("uomList");
Sheet sheet=book.createSheet("uoms");
setHead(sheet);
setBody(uomList, sheet);
	
		
	}
	private void setHead(Sheet sheet){
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("uomId");
		row.createCell(1).setCellValue("uomType");
		row.createCell(2).setCellValue("uomModel");
		row.createCell(3).setCellValue("createdDate");
		row.createCell(4).setCellValue("lastModifiedDate");
		row.createCell(5).setCellValue("description");
		
	}
	private void setBody(List<Uom> uomList,Sheet sheet) {
		int rowNum=1;
		for(Uom uom:uomList){
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(uom.getUomId());
			row.createCell(1).setCellValue(uom.getUomType());
			row.createCell(2).setCellValue(uom.getUomModel());
			row.createCell(3).setCellValue(uom.getCreatedDate().toString());
			row.createCell(4).setCellValue(uom.getLastModifiedDate()!=null?uom.getLastModifiedDate().toString():"-NA-");
			row.createCell(5).setCellValue(uom.getDescription());
		}
	}

}
