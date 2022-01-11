package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Excel;
import com.example.demo.model.ExcelDTO;

@Component
public class ExcelConverter {
	
	public ExcelDTO excelToDto(Excel excel) {
		ExcelDTO exceldto= new ExcelDTO();
		exceldto.setNomeProdotto(excel.getNomeProdotto());
		exceldto.setCategoriaProdotto(excel.getCategoriaProdotto());
		exceldto.setPrezzo(excel.getPrezzo());
		return exceldto;
	}
	
	public List<ExcelDTO> listExcelToDto(List<Excel> excel){
		List<ExcelDTO> exceldto= new ArrayList<>();
		for(int  i = 0; i<excel.size(); i++ ) {
			exceldto.add(excelToDto(excel.get(i)));
		}
		return exceldto;
	}

}
