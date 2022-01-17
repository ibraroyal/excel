package com.netgroup.exceldemo.controller2.controllerJsp;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netgroup.exceldemo.data.dao.Excel;
import com.netgroup.exceldemo.service.ExcelService;
import com.netgroup.exceldemo.util.ExcelUtils;
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


	@GetMapping(value = "/export")
	public void exportToExcel(HttpServletResponse resp) throws IOException {
		resp.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=prodotto.xlsx";
		resp.setHeader(headerKey, headervalue);

		List<Excel> listExcel = excelService.listFile();
		ExcelUtils exp = new ExcelUtils(listExcel);
		exp.export(resp);
	}

	@GetMapping(value = "/dates")
	public void exportBetweenDates(@RequestParam("start") String start,@RequestParam("end") String end, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=prodotto.xlsx";
		resp.setHeader(headerKey, headervalue);

		List<Excel> listExcel = excelService.betweenDates(Date.valueOf(start).toLocalDate(),Date.valueOf(end).toLocalDate());


		ExcelUtils exp = new ExcelUtils(listExcel);

		exp.export(resp);
	}
}
