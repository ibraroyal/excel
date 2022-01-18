package com.netgroup.exceldemo.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netgroup.exceldemo.data.dao.Excel;
import com.netgroup.exceldemo.service.ExcelService;
import com.netgroup.exceldemo.util.ExcelExport;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping(value="/download")
public class DownloadExcelController {

	@Autowired
	ExcelService excelService;

	@GetMapping(value="")
	public ModelAndView init(){
		return new ModelAndView("download/download");
	}

	@GetMapping(value = "/dates")
	public void exportBetweenDates(@RequestParam("start") String start,@RequestParam("end") String end, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=prodotti.xlsx";
		resp.setHeader(headerKey, headervalue);

		List<Excel> listExcel = excelService.betweenDates(Date.valueOf(start).toLocalDate(),Date.valueOf(end).toLocalDate());
		ExcelExport exp = new ExcelExport(listExcel);
		exp.export(resp);
	}

	@PostMapping(value="/testing")
	public ModelAndView test(){
		Excel e=new Excel();
		e.setCategoriaProdotto("categoria");
		e.setNomeProdotto("nomeprod");
		e.setPrezzo(195);
		e.setUploadDate(LocalDate.now());

		excelService.salva(e);
		return new ModelAndView("download/download");
	}

	@GetMapping(value="/template")
	public void template(HttpServletResponse resp) throws IOException {
		List<Excel> listExcel=new ArrayList<Excel>();
		resp.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=prodotti.xlsx";
		resp.setHeader(headerKey, headervalue);
		ExcelExport exp = new ExcelExport(listExcel);
		exp.export(resp);
		resp.sendRedirect("/Home/Home");
	}
}
