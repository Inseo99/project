package project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class PostController {
    private Scanner sc = new Scanner(System.in);
    private PostRepository postRepository = new PostRepository();
    private PostView postView = new PostView();

    public PostController() {
        Post p1 = new Post(1, "안녕하세요 반갑습니다. java 공부중이에요.", "냉무", getCurrentTime(), 5);
        Post p2 = new Post(2, "java 질문 좀 할게요~ ", "냉무", getCurrentTime(), 2);
        Post p3 = new Post(3, "정처기 따야되나요?", "냉무", getCurrentTime(), 0);

        postRepository.save(p1);
        postRepository.save(p2);
        postRepository.save(p3);

    }

    private int lastId = 4;


    public void add() {
        System.out.print("제목 : ");
        String title = sc.nextLine();
        System.out.print("내용 : ");
        String contect = sc.nextLine();

        Post post = new Post(lastId, title, contect, getCurrentTime(), 0);

        postRepository.save(post);
        lastId++;

        System.out.println("게시물이 등록되었습니다.");
    }

    public void list() {
        ArrayList<Post> posts = postRepository.getPosts();
        postView.printPostList(posts);
    }

    public void update() {
        System.out.print("수정할 게시물 번호 : ");
        int targetId = Integer.parseInt(sc.nextLine());
        Post post = postRepository.findById(targetId);

        if (post == null) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }
        System.out.print("제목 : ");
        String newtitle = sc.nextLine();
        System.out.print("내용 : ");
        String newcontect = sc.nextLine();

        post.setTitle(newtitle);
        post.setContect(newcontect);

        System.out.println(post.getId() + "번의 게시물이 수정되었습니다.");
    }

    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        int targetId = Integer.parseInt(sc.nextLine());
        Post post = postRepository.findById(targetId);

        if (post == null) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }

        postRepository.delete(post);

        System.out.println(post.getId() + "번의 게시물이 삭제되었습니다.");
    }

    public void detail() {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int targetId = Integer.parseInt(sc.nextLine());
        Post post = postRepository.findById(targetId);

        if (post == null) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }
        post.setHit(post.getHit() + 1);
        postView.printPostDetail(post);
    }

    public void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = sc.nextLine();
        ArrayList<Post> posts = postRepository.findBykeyword(keyword);

        if (posts.isEmpty()) {
            System.out.println("==================");
            System.out.println("검색 결과가 없습니다.");
            System.out.println("==================");
            return;
        }
        postView.printPostList(posts);
    }

    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return now.format(formatter);
    }
}
