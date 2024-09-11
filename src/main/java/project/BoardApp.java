package project;

import java.util.Scanner;

public class BoardApp {
    private Scanner sc = new Scanner(System.in);
    private PostController postController = new PostController();


    public void run() {
        while (true) {
            System.out.print("명령어를 입력하시오 : ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                postController.add();
            } else if (command.equals("list")) {
                postController.list();
            } else if (command.equals("update")) {
                postController.update();
            } else if (command.equals("delete")) {
                postController.delete();
            } else if (command.equals("detail")) {
                postController.detail();
            } else if (command.equals("search")) {
                postController.search();
            } else {
                System.out.println("명령어를 다시 입력하세요");
            }
        }
    }
}
