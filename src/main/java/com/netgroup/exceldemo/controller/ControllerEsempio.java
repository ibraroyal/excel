package com.netgroup.exceldemo.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.netgroup.exceldemo.util.ConverterExcel;


@Controller
public class ControllerEsempio {
	
	@Autowired
	ConverterExcel converterExcel;

	@GetMapping("/index/jsp")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("Excel/upload");
		return model;
	}

	@PostMapping("/upload")
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile mFile) throws IllegalStateException, IOException{
		converterExcel.Excel2Data(mFile.getInputStream());
		return ResponseEntity.ok("salvataggio riuscito");
	}

	@PostMapping("/upload/excel")
	public ResponseEntity<?> handleFileUploadExcel(@RequestParam("file") MultipartFile mFile) throws IllegalStateException, IOException{
		converterExcel.Excel2Data(mFile.getInputStream());
		return ResponseEntity.ok("salvataggio riuscito");
	}
}
