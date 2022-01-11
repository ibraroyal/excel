package com.netgroup.exceldemo.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.netgroup.exceldemo.exportToExcel.ConverterExcel;


@Controller
public class ControllerEsempio {
	
	@Autowired
	ConverterExcel converterExcel;

//	@GetMapping("/index")
//	public String hello() {
//		return "uploader";
//	}
	
	
	@GetMapping("/index/jsp")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("Excel/upload");
		return model;
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile mFile) throws IllegalStateException, IOException{
		String fileName = mFile.getOriginalFilename();
		mFile.transferTo(new File("C:\\Users\\simon\\OneDrive\\Immagini\\" + fileName));
		return ResponseEntity.ok("salvataggio riuscito");
	}
	@PostMapping("/upload/excel")
	public ResponseEntity<?> handleFileUploadExcel(@RequestParam("file") MultipartFile mFile) throws IllegalStateException, IOException{
		String fileName = mFile.getOriginalFilename();
		
		mFile.transferTo(new File("C:\\Users\\simon\\OneDrive\\Desktop\\esempio\\" + fileName));
		converterExcel.Excel2Data("C:\\Users\\simon\\OneDrive\\Desktop\\esempio\\" + fileName);
		return ResponseEntity.ok("salvataggio riuscito");
	}
}
