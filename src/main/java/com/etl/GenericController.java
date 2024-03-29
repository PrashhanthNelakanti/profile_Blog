package com.etl;

import com.processExcel.service.ExcelProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class GenericController {

    @Autowired
    ExcelProcessService excelProcessService;

    @GetMapping("/etl/status/{tblname}/{env}")
    public String tblCreation(@PathVariable("tblname") String tblname, @PathVariable("env") String env) {
        return excelProcessService.getProcessQueryCreateTbl(tblname, env);
    }

    @GetMapping("/etl/transfer/{srcTbl}/{env}")
    public String tblCreationInsertn(@PathVariable("srcTbl") String srcTbl, @PathVariable("env") String env) {
        return excelProcessService.insertQueryForExistingTbl(srcTbl, env);
    }
}
