package org.example.base;

import org.example.domain.article.ArticleController;

import java.util.Scanner;

public class BoardApp {
    CommonUtill commonUtill = new CommonUtill();
    Scanner scan = commonUtill.getScan();
    ArticleController articleController = new ArticleController();
    public void run () {

        while (true) {
            System.out.print("명령어 : ");
            String cmd = scan.nextLine();

            if (cmd.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                System.out.println("==============================");
                break;
            }
            switch (cmd) {
                case "add" -> {
                    articleController.add();
                }
                case "list" -> {
                    articleController.list();
                }
                case "update" -> {
                    articleController.update();
                }
                case "delete" -> {
                    articleController.delete();
                }
                case "detail" -> {
                    articleController.detail();
                }
                case "search" -> {
                    articleController.search();
                }
                default -> {
                    System.out.println("올바르지 않은 입력입니다.");
                }
            }
        }
    }
}
