import com.bida.dosarbot.WorkWithPDF.DownloadPDF;
import com.bida.dosarbot.WorkWithPDF.ParsePDF;
import com.bida.dosarbot.WorkWithSites.SiteDownloader;
import com.bida.dosarbot.WorkWithSites.SiteParser;
import com.bida.dosarbot.domain.User;
import com.bida.dosarbot.service.ServiceFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        SiteDownloader.downloadAll();
//        List<String> lis = SiteParser.findAllLinksInStadiuDosar();
//        System.out.println(lis.get(7));
//        DownloadPDF.downloadPDF(lis.get(7));
        List<User> users = ParsePDF.findAllUsersInStadiuDosarPDF();
        ServiceFactory serviceFactory = new ServiceFactory();
        User user = null;
        for(int i = 90; i <users.size(); i++){
            user = serviceFactory.getUserService().getUser(users.get(i).getYear(), users.get(i).getDosarNumber());
            if (user == null) {
                serviceFactory.getUserService().addUser(users.get(i));
            }
        }
        System.out.println(serviceFactory.getUserService().getUser(2017, 36));
    }

}
