package project;

import java.util.ArrayList;

public class PostView {
    public void printPostList(ArrayList<Post> posts) {
        System.out.println("==================");
        for (Post post : posts) {
            System.out.println("번호 : " + post.getId());
            System.out.println("제목 : " + post.getTitle());
            System.out.println("==================");
        }
    }

    public void printPostDetail(Post post) {
        System.out.println("======================");
        System.out.println("번호 : " + post.getId());
        System.out.println("제목 : " + post.getTitle());
        System.out.println("내용 : " + post.getContect());
        System.out.println("작성일 : " + post.getTime());
        System.out.println("조회수 : " + post.getHit());
        System.out.println("======================");
    }
}
