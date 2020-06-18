package com.bida.dosarbot.WorkWithSites;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SiteParser {

    private static File ordineHtmlFile = new File("src/main/resources/Pages of HTML/ordine.html");
    private static File stadiuDosarFile = new File("src/main/resources/Pages of HTML/stadiuDosar.html");


    public static List<String> findAllLinksInOrdine(){
        return findLinksInFile(ordineHtmlFile);
    }

    public static List<String> findAllLinksInStadiuDosar(){
        return findLinksInFile(stadiuDosarFile);
    }

    private static List<String> findLinksInFile(File file) {
        List<String> list = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                if (line.indexOf("pdf") != -1){
                    Matcher m = Pattern.compile("(href){1}[\\S]+(pdf)").matcher(line);
                    while (m.find()) {
                        list.add(line.substring(m.start(), m.end()).replaceAll("href", "").replaceAll("=", "").replaceAll("\"", ""));
                    }
                }
                line = reader.readLine();
            }
        } catch (Exception e){
            System.out.println("ERROR with parser");
        }
        return list;
    }

}
