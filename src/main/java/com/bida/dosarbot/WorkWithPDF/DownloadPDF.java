package com.bida.dosarbot.WorkWithPDF;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;

public class DownloadPDF {

    private static File currentPDF = new File("src/main/resources/currentPDF.pdf");
    private static String mainLink = "http://cetatenie.just.ro";

    public static void downloadPDF(String link){
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(currentPDF))) {
            InputStream inputStream = null;
            try {
                URLConnection connection = new URL(mainLink + link).openConnection();
                inputStream = connection.getInputStream();
            } catch (Exception e){
                System.out.println("ERROR with ");
            }
            int inp = inputStream.read();
            while (inp != -1) {
                outputStream.write(inp);
                inp = inputStream.read();
            }
            inputStream.close();
        } catch (Exception e) {
            System.out.println("ERROR with download of PDF!");
        }
    }
}
