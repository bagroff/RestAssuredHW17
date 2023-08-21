package reqres.pojo;

public class UserData {
    private String name;
    private String job;

    public UserData(String name, String job) {
        this.name = name;
        this.job = job;

    }

    public UserData(){

    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
