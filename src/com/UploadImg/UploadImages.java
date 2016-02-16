package com.UploadImg;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UploadImages  extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("I am in Upload images in action ");
		
		String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
         
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = req.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        req.setAttribute("uploadSuccess", "Images Uploaded Sucess Fully!!!");
        req.setAttribute("img", inputStream);
        int size=0;
        byte[] bytearray = new byte[1048576];
        res.reset();
        res.setContentType("image/jpeg");
        while((size = inputStream.read(bytearray)) != -1 ){
            res.getOutputStream().
            write(bytearray,0,size);
        }
        
        
        RequestDispatcher rd=req.getRequestDispatcher("/jsp/welcome.jsp");
        rd.forward(req, res);
	}

}
