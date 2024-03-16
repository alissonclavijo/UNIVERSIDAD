package ec.edu.pry_conjunta;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nick;
    private String password;

    public Usuario() {}

    public Usuario(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
