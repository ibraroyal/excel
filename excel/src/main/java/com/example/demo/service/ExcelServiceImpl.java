package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.ExcelConverter;
import com.example.demo.model.Excel;
import com.example.demo.model.ExcelDTO;
import com.example.demo.repository.ExcelRepository;

@Service
public class ExcelServiceImpl implements ExcelService{
	@Autowired
	ExcelRepository excelRepository;
	
	@Autowired
	ExcelConverter excelConverter;
	

	@Override
	public Excel findByIdExcel(Integer id) {
		
		return excelRepository.findById(id).get();
	}

	@Override
	public List<Excel> findAllExcel() {
		
		return excelRepository.findAll();
	}

	@Override
	public Excel saveExcel(Excel excel) {
		return excelRepository.save(excel);
	}

	@Override
	public ExcelDTO findByIdExcelDto(Integer id) {
		Excel excel= excelRepository.findById(id).get();
		ExcelDTO exceldto = excelConverter.excelToDto(excel);
		return exceldto;
	}

	@Override
	public List<ExcelDTO> findAllExcelDto() {
		List<Excel> excel= excelRepository.findAll();
		return excelConverter.listExcelToDto(excel) ;
	}

}
