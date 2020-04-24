package Domain.App;

import Domain.Entity;

public class User extends Entity<String> {

    private String password;
    private String nickname;
    // alte date


    public User(String username,String password, String nickname) {
        this.id = username;
        this.password = password;
        this.nickname = nickname;
    }

    public User(String username,String password) {
        this.id = username;
        this.password = password;
        this.nickname = "";
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername(){return this.id;}

    public void setUsername(String username){this.id = username;}
}

