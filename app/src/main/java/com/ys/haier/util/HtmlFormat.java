package com.ys.haier.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by lzc on 2017-08-21.
 */

public class HtmlFormat {
    public static String getNews(String htmltext){
        Document doc = Jsoup.parse(htmltext);
        Elements elements = doc.getElementsByTag("img");
        for (Element element:elements) {
            element.attr("width","100%").attr("height","auto");
        }
        return doc.toString();
    }
}
