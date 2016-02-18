package com.UploadImg;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

@WebServlet("/uploadAndShow")
@MultipartConfig
public class UpAndSoImg extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		 response.setContentType("text/html;charset=UTF-8");
	
		 final Part filePart = request.getPart("photo");
		 InputStream is = filePart.getInputStream();
		
		 
	        BufferedImage bimg=ImageIO.read(new File("E:/mydoc/a.jpg"));
	        ByteArrayOutputStream baos=new ByteArrayOutputStream();
	        ImageIO.write(bimg, "jpg", baos);
	        baos.flush();
	        byte[] imageinByteArray=baos.toByteArray();
	        baos.close();
	        String b64=DatatypeConverter.printBase64Binary(imageinByteArray);
	        request.setAttribute("uploadImg", b64);
	        request.setAttribute("message", "Uploading Image has been done successfully!");
	        getServletContext().getRequestDispatcher("/jsp/welcome.jsp").forward(request, response);
	    
//	      NOTE----  This is put into the JSP page
//	        <img border="0" src="data:image/jpg;base64,<%=(String)request.getAttribute("uploadImg")%>"  height="200" width="200">
	
	}

}
