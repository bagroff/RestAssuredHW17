package reqres.pojo;

public class SuccessLogin {
    private String token;

    public SuccessLogin(String token) {
        this.token = token;
    }

    public SuccessLogin(){

    }

    public String getToken() {
        return token;
    }
}
