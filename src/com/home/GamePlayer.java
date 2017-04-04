package com.home;

import java.util.ArrayList;

/**
 * Created by Козак on 04.04.2017.
 */

public class GamePlayer  {

    private String username;
    private int id;
    ArrayList<String> chatlist = new ArrayList<>();

    public GamePlayer() {}

    public GamePlayer(String username) {
        this.username = username;
        chatlist.add(username);
    }

    public boolean usernameIsNotNull() {
        if(this.username.getBytes().length>0) {
            return true;
        } else return false;
    }

    public String getUsername() {
        return this.username;
    }

    public int checkUserId(String username) {
        id = chatlist.indexOf(username);
        return id;
    }

    public String getClients() {
        for(int i=0; i<=chatlist.size(); i++) {
            return ("\n" + chatlist.get(i));
        }
        return null;
    }

    public boolean isClientThere(String username) {
        if(chatlist.contains(username)) {
            return true;
        } else return false;
    }

    public void removeClient() {
        chatlist.remove(this.username);
    }

    @Override
    public String toString() {
        return this.username;
    }

}