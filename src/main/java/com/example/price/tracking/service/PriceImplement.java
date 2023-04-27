package com.example.price.tracking.service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class PriceImplement implements Price{
    @Override
    public String getLatestPrice(){
        try {
            Document document = Jsoup.connect("https://www.metal.com/Lithium-ion-Battery/202303240001").get();
            String price = document.select("span.strong___1JlBD.priceDown___2TbRQ").first().text();
            return price;
        }catch (Exception e){
            return "problem in the server. please try again later.";
        }


    }
}
