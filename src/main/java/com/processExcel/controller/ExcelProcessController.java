package com.processExcel.controller;

import com.processExcel.service.ExcelProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class ExcelProcessController {
    Logger logger = LoggerFactory.getLogger(ExcelProcessController.class);

    @Autowired
    ExcelProcessService service;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (service.hasExcelFormat(file)) {
            try {
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                logger.info(message);
                service.processExcelData(file.getInputStream(),file.getOriginalFilename());
                return new ResponseEntity<>(message,HttpStatus.CREATED);
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
            }
        }

        message = "Please upload an excel file!";
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
}
