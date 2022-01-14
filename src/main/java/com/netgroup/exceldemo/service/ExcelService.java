package com.netgroup.exceldemo.service;

import java.time.LocalDate;
import java.util.List;

import com.netgroup.exceldemo.data.dao.Excel;

public interface ExcelService {

	public Excel salva(Excel excel);

	public List<Excel> listFile();

	public List<Excel> arrayToList(Excel[] lista);

	public List<Excel> betweenDates(LocalDate start, LocalDate end);

}
