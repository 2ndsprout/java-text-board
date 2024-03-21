package org.example.view;

import org.example.domain.article.Article;

import java.util.ArrayList;

public class ArticleView {
    public void printArticle (ArrayList<Article> targetList) {
        for (int i = 0; i < targetList.size(); i++ ){
            Article article = targetList.get(i);

            System.out.println("번호 : " + article.getId());
            System.out.println("제목 : " + article.getTitle());
            System.out.println("등록날짜 : " + article.getRegDate());
            System.out.println("==============================");

        }
    }
    public void printArticleDetail (Article article) {

        article.increaseHit();
        System.out.println("번호 : " + article.getId());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("내용 : " + article.getBody());
        System.out.println("조회수 : " + article.getHit());
        System.out.println("등록날짜 : " + article.getRegDate());
        System.out.println("==============================");

    }
}
