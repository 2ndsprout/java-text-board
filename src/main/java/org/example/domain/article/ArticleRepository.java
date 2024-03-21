package org.example.domain.article;

import org.example.base.CommonUtill;

import java.util.ArrayList;

public class ArticleRepository {
    CommonUtill commonUtill = new CommonUtill();
    ArrayList<Article> articleList = new ArrayList<>();
    int latestId = 4;
    public ArticleRepository () {
        makeTest();
    }
    public void makeTest () {
        Article a1 = new Article(1,"안녕","하이",0,commonUtill.getCurrentDate());
        Article a2 = new Article(2,"안녕","하이",0,commonUtill.getCurrentDate());
        Article a3 = new Article(3,"안녕","하이",0,commonUtill.getCurrentDate());

        articleList.add(a1);
        articleList.add(a2);
        articleList.add(a3);

    }

    public void saveArticle (String title, String body) {
        Article article = new Article(latestId, title, body, 0, commonUtill.getCurrentDate());
        articleList.add(article);
        latestId++;
    }
    public void updateArticle (Article article, String newTitle, String newBody) {
        article.setTitle(newTitle);
        article.setBody(newBody);
    }
    public void deleteArticle (Article article) {
        articleList.remove(article);
    }
    public ArrayList<Article> findAll () {
        return articleList;
    }
    public Article findArticleById (int id) {
        for (Article target : articleList) {
            if (target.getId() == id) {
                return target;
            }
        }
        return null;
    }
    public ArrayList<Article> findArticleByKeyword (String keyword) {
        ArrayList<Article> searchList = new ArrayList<>();

        for (Article article : articleList) {
            if (article.getTitle().contains(keyword)) {
                searchList.add(article);
            }
        }
        return searchList;
    }

}
