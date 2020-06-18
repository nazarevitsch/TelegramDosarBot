package com.bida.dosarbot.WorkWithPDF;

import com.bida.dosarbot.domain.User;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ParsePDF {

    private static File currentPDF = new File("src/main/resources/currentPDF.pdf");

    public static List<User> findAllUsersInStadiuDosarPDF(){
        List<User> users = new ArrayList<User>();
        try (PDDocument document = PDDocument.load(currentPDF)) {
            if (!document.isEncrypted()) {
                String[] lines = new PDFTextStripper().getText(document).split("\\r?\\n");
                for (String line : lines) {
                    if(line.contains("/RD/")) {
                        int index = line.indexOf("/RD/");
                        String dosarNumber = line.substring(0, index);
                        String year = line.substring(index + 4, index + 8);
                        int index2 = line.indexOf(".");
                        String month = line.substring(index2 + 1, index2 + 3);
                        try {
                            users.add(new User(Integer.valueOf(year), Integer.valueOf(dosarNumber), Integer.valueOf(month), 0L, false));
                        } catch (Exception e){
                            System.out.println("ERROR with create User");
                        }
                    }
                }
            }
        }catch (Exception e) {}
        return users;
    }
}
