package reqres.pojo;

public class CreatePostUserRequest {
    private String name;
    private String job;

    public CreatePostUserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public CreatePostUserRequest(){

    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
