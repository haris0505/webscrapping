package com.example.webscrapping.service;

import com.example.webscrapping.Model.CovidDataDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Scrapedata {



    public List<CovidDataDto> retrieveCovidData(){


        String url="https://en.wikipedia.org/wiki/COVID-19_pandemic_by_country_and_territory";
        List<CovidDataDto> mylist=new ArrayList<CovidDataDto>();

        try {
          Document webpage  =Jsoup.connect(url).get();

          Element tbody=webpage.getElementById("thetable").getElementsByTag("tbody").get(0);
          Element rows=tbody.children().remove(2);

            for (Element i: rows.children()) {
System.out.println(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return mylist;
    }


    public void GetData(){
        try {
            int numofpages=8;
            for(int i=1;i<=numofpages;i++){
                String url="https://www.codetriage.com/?language=Java&page="+i;

                Document doc = Jsoup.connect(url).get();

                System.out.println("Page no: "+i);
                // With the document fetched, we use JSoup's title() method to fetch the title
                System.out.printf("Title: %s\n", doc.title());

                // Get the list of repositories
                Elements repositories = doc.getElementsByClass("repo-item");

                /**
                 * For each repository, extract the following information:
                 * 1. Title
                 * 2. Number of issues
                 * 3. Description
                 * 4. Full name on github
                 */
                for (Element repository : repositories) {
                    // Extract the title
                    String repositoryTitle = repository.getElementsByClass("repo-item-title").text();

                    // Extract the number of issues on the repository
                    String repositoryIssues = repository.getElementsByClass("repo-item-issues").text();

                    // Extract the description of the repository
                    String repositoryDescription = repository.getElementsByClass("repo-item-description").text();

                    // Get the full name of the repository
                    String repositoryGithubName = repository.getElementsByClass("repo-item-full-name").text();

                    // The reposiory full name contains brackets that we remove first before generating the valid Github link.
                    String repositoryGithubLink = "https://github.com/" + repositoryGithubName.replaceAll("[()]", "");

                    // Format and print the information to the console
                    System.out.println(repositoryTitle + " - " + repositoryIssues);
                    System.out.println("\t" + repositoryDescription);
                    System.out.println("\t" + repositoryGithubLink);
                    System.out.println("\n");
                }

                // In case of any IO errors, we want the messages written to the console
            }

            } catch (IOException e) {
            e.printStackTrace();
        }
            // Here we create a document object and use JSoup to fetch the website

    }

    public  void TestData(){
        String url="";
        for(int i=0;i<10;i++){
            url="https://ikman.lk/en/ads/sri-lanka/electronics?sort=date&order=desc&buy_now=0&urgent=0&page="+i;

            try{
                Document doc = Jsoup.connect(url).get();

                //Element body=doc.body();

                if(doc.hasText()){

                }
                Elements list=doc.getElementsByClass("list--3NxGO").get(0).children();
                for (Element ele: list) {
                    String name=ele.getElementsByClass("heading--2eONR heading-2--1OnX8 title--3yncE block--3v-Ow").text();
                    String category=ele.getElementsByClass("description--2-ez3").text();
                    String price=ele.getElementsByClass("price--3SnqI color--t0tGX").text();

                    System.out.println(name);
                    System.out.println("\t" + category);
                    System.out.println("\t" + price);
                    System.out.println("\n");

                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}
