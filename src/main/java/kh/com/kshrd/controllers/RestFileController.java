package kh.com.kshrd.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kh.com.kshrd.KshrdExcelToDbApplication;

@Controller
@RequestMapping(value="/files")
public class RestFileController {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listAllFiles(){
		Map<String, Object> model = new HashMap<String, Object>();
		return new ResponseEntity<Map<String, Object>>(model, HttpStatus.OK);
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> uploadExcel(@RequestParam("excelFile") MultipartFile file, HttpServletRequest request){
		System.out.println("FILE="+file.getOriginalFilename());
		String filename = "";
        Map<String, Object> model = new HashMap<String, Object>();
		if (!file.isEmpty()) {
            try { 
            	filename = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                String extension = filename.substring(filename.lastIndexOf(".")+1);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(KshrdExcelToDbApplication.ROOT + File.separator  + file.getOriginalFilename())));
                stream.write(bytes);
                stream.close();
                
                FileInputStream inputStream = new FileInputStream(new File(KshrdExcelToDbApplication.ROOT+File.separator+filename));
                
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet firstSheet = workbook.getSheetAt(0);
                System.out.println("SHEET NAME= "+firstSheet.getSheetName());
                
                System.out.println( "You successfully uploaded " + KshrdExcelToDbApplication.ROOT + File.separator + filename + "!");
                model.put("MESSAGE", "SUCCESSFULLY");
                model.put("ERROR", HttpStatus.OK.value());
                model.put("IMAGE", filename);
        		return new ResponseEntity<Map<String, Object>>(model, HttpStatus.OK);
            } catch (Exception e) {
            	System.out.println(e.getMessage());
                System.out.println("You failed to upload " + filename + " => " + e.getMessage());
                model.put("MESSAGE", "ERROR " + e.getMessage());
                model.put("ERROR", HttpStatus.INTERNAL_SERVER_ERROR.value());
                model.put("IMAGE", filename);
        		return new ResponseEntity<Map<String, Object>>(model, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            System.out.println("You failed to upload " + filename + " because the file was empty.");
            model.put("MESSAGE", "UNSUCCESSFULLY");
            model.put("ERROR", HttpStatus.NOT_FOUND.value());
            model.put("IMAGE", filename);
    		return new ResponseEntity<Map<String, Object>>(model, HttpStatus.NOT_FOUND);
        }
	}
	
}
