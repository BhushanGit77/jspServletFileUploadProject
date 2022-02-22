package com.bhushan;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;

public class FileUpload extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multiFiles;
			multiFiles = sf.parseRequest(request);
			
			for(FileItem item: multiFiles) {
				item.write(new File("C:\\Users\\bhushan.jain\\eclipse-workspace\\servlet\\FileUploadDemo\\uploaded-files" + item.getName()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		response.getWriter().print("Files Uploaded!!!");
	}
}