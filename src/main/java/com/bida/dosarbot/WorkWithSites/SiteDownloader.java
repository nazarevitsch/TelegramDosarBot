package com.bida.dosarbot.WorkWithSites;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SiteDownloader {

    private static final String ordineLink = "http://cetatenie.just.ro/index.php/ro/ordine/articol-11";
    private static final String stadiuDosarLink = "http://cetatenie.just.ro/index.php/ro/centru-de-presa-2/dosar-articol-11";
    private static final String mainLink = "http://cetatenie.just.ro";
    private static File ordineHtmlFile = new File("src/main/resources/Pages of HTML/ordine.html");
    private static File stadiuDosarHtmlFile = new File("src/main/resources/Pages of HTML/stadiuDosar.html");

    public static void downloadAll(){
        downloadHTML(ordineHtmlFile, ordineLink);
        downloadHTML(stadiuDosarHtmlFile, stadiuDosarLink);
    }

    public static void downloadHTML(File file, String link) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            URLConnection connection = new URL(link).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.write(line + "\n");
            }
            writer.close();
        } catch (Exception e){
            System.out.println("ERROR with download");
        }
    }
}
