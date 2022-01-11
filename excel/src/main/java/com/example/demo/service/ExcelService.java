package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Excel;
import com.example.demo.model.ExcelDTO;

public interface ExcelService {
	
	Excel findByIdExcel(Integer id);
	List<Excel> findAllExcel();
	Excel saveExcel(Excel excel);
	
	ExcelDTO findByIdExcelDto(Integer id);
	List<ExcelDTO> findAllExcelDto();

}
