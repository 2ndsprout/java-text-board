package org.example.domain.article;

import org.example.base.CommonUtill;
import org.example.view.ArticleView;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    CommonUtill commonUtill = new CommonUtill();
    ArticleRepository articleRepository = new ArticleRepository();
    ArticleView articleView = new ArticleView();
    Scanner scan = commonUtill.getScan();
    public void add () {
        System.out.print("제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("내용을 입력해주세요 : ");
        String body = scan.nextLine();

        articleRepository.saveArticle(title, body);

        System.out.println("게시물 저장이 완료되었습니다.");
        System.out.println("==============================");

    }
    public void list () {
        ArrayList<Article> article = articleRepository.findAll();
        articleView.printArticle(article);

    }
    public void update () {
        System.out.print("수정하실 게시물 번호를 입력해주세요 : ");
        int inputId = Integer.parseInt(scan.nextLine());
        System.out.println("==============================");

        Article article = articleRepository.findArticleById(inputId);

        if (article == null) {
            System.out.println("없는 게시물 번호입니다.");
            System.out.println("==============================");
        }
        else {
            System.out.print("수정하실 제목을 입력해주세요 : ");
            String newTitle = scan.nextLine();
            System.out.print("수정하실 내용을 입력해주세요 : ");
            String newBody = scan.nextLine();

            articleRepository.updateArticle(article, newTitle, newBody);

            System.out.println(inputId + "번 게시물 수정이 완료되었습니다.");
            System.out.println("==============================");
        }

    }
    public void delete () {
        System.out.print("삭제하실 게시물 번호를 입력해주세요 : ");
        int inputId = Integer.parseInt(scan.nextLine());
        System.out.println("==============================");

        Article article = articleRepository.findArticleById(inputId);

        if(article == null) {
            System.out.println("없는 게시물 번호입니다.");
            System.out.println("==============================");
        }
        else {
            articleRepository.deleteArticle(article);
            System.out.println(inputId + "번 게시물이 삭제되었습니다.");
        }

    }
    public void detail () {
        System.out.print("상세보기 하실 게시물 번호를 입력해주세요 : ");
        int inputId = Integer.parseInt(scan.nextLine());

        Article article = articleRepository.findArticleById(inputId);

        articleView.printArticleDetail(article);

    }
    public void search () {
        System.out.print("검색 키워드를 입력하세요 : ");
        String keyword = scan.nextLine();
        System.out.println("==============================");

        ArrayList<Article> searchList = articleRepository.findArticleByKeyword(keyword);

        articleView.printArticle(searchList);

    }
}
