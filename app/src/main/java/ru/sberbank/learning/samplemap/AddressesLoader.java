package ru.sberbank.learning.samplemap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Дмитрий Соколов <DPSokolov.SBT@sberbank.ru>
 */

public class AddressesLoader {

    public List<String> doLoad() {
        List<String> result = new ArrayList<>();

        try {
            Document document = Jsoup.connect("http://shoko.ru/moskva/adresa_kofeen/vse_kofejni/").get();
            Element element = document.getElementById("spec_predlojenie_adress_new");
            Elements rows = element.getElementsByTag("tr");


            for (int i = 0; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements cols = row.getElementsByTag("td");
                Element addressCol = cols.get(1);
                result.add(addressCol.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }

}
