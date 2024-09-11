package project;

import java.util.ArrayList;

public class PostRepository {
    private ArrayList<Post> posts = new ArrayList<>();

    public void save(Post post) {
        posts.add(post);
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void delete(Post post) {
        posts.remove(post);
    }

    public Post findById(int targetId) {
        for (Post post : getPosts()) {
            if (post.getId() == targetId) {
                return post;
            }
        }
        return null;
    }

    public ArrayList<Post> findBykeyword(String keyword) {
        ArrayList<Post> searchList = new ArrayList<>();
        for (Post post : getPosts()) {
            if (post.getTitle().contains(keyword)) {
                searchList.add(post);
            }
        }
        return searchList;
    }
}
