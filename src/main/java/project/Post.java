package project;

public class Post {
    private int id;
    private String title;
    private String contect;
    private String time;
    private int hit;

    public Post(int id, String title, String contect, String time, int hit) {
        this.id = id;
        this.title = title;
        this.contect = contect;
        this.time = time;
        this.hit = hit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContect(String contect) {
        this.contect = contect;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContect() {
        return contect;
    }

    public String getTime() {
        return time;
    }

    public int getHit() {
        return hit;
    }
}
