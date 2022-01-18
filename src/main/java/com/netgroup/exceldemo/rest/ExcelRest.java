
package com.netgroup.exceldemo.rest;

import com.netgroup.exceldemo.data.dao.Excel;
import com.netgroup.exceldemo.service.ExcelService;
import com.netgroup.exceldemo.util.ExcelExport;
import javax.servlet.http.HttpServletResponse;
import com.netgroup.exceldemo.util.ExcelExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.netgroup.exceldemo.data.dao.Excel;
import com.netgroup.exceldemo.service.ExcelService;

@RestController
@RequestMapping("/api/excel")
public class ExcelRest {

	@Autowired
	ExcelService excelService;
	
	
	
	@GetMapping(value = "/export")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=prodotti.xlsx";

		response.setHeader(headerKey, headervalue);
		List<Excel> listExcel = excelService.listFile();
		ExcelExport exp = new ExcelExport(listExcel);

		exp.export(response);
	}
}
