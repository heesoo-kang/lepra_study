package com.instagram.demo.controller;

import java.io.IOException;

import org.apache.tika.Tika;

public class FileUtils {
	private static Tika tika = new Tika();
	/*

    public static boolean validImgFile(InputStream inputStream) {
        try {
            List<String> notValidTypeList = Arrays.asList("image/jpeg", "image/pjpeg", "image/png", "image/jpg");

            String mimeType = tika.detect(inputStream);
            System.out.println("MimeType : " + mimeType);

            boolean isValid = notValidTypeList.stream().anyMatch(notValidType -> notValidType.equalsIgnoreCase(mimeType));

            return isValid;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }*/
}


