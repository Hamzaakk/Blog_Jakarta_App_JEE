package com.example.blog_app_jakarta_ee.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.*;
import java.util.logging.Logger;

public class Services {

    // this function return filename and can move file get in request post atribute name image
  public static String uploadImageTOServergetByPostRequest(String  uploadDirectory , HttpServletRequest request ) throws ServletException, IOException {
    //  String uploadDirectory = "C:\\Users\\DELL 6430\\abdelmalek sadi\\Desktop\\javaexamprepaA\\Blog_App_Jakarta_EE\\src\\main\\webapp\\images\\upload";
      // Create the directory if it doesn't exist
      File dir = new File(uploadDirectory);
      if (!dir.exists()) {
          dir.mkdirs();
      }

      // Get the image file part from the request
      Part filePart = request.getPart("image");

      // Generate a unique name for the uploaded file
      String fileName = "image_" + System.currentTimeMillis() + ".jpg"; // You can modify the file extension based on the type of image

      // Save the image to the specified directory
      OutputStream outputStream = new FileOutputStream(new File(uploadDirectory, fileName));
      InputStream fileContent = filePart.getInputStream();

      int read;
      final byte[] bytes = new byte[1024];
      while ((read = fileContent.read(bytes)) != -1) {
          outputStream.write(bytes, 0, read);
      }
      System.out.println(fileName);
      // Close streams
      outputStream.close();
      fileContent.close();
      String imagePath = "/images/upload/" + fileName;

      return  imagePath;
  }
}
