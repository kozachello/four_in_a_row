package com.home;

import java.io.Serializable;
import java.util.function.Consumer;

/**
 * Created by Козак on 04.04.2017.
 */

public class Client extends ConnectionControl {

    private String ipadress;
    private int port;
    private String user;


    public Client(String ipadress, int port, Consumer<Serializable> ifGotSendBack) {
        super(ifGotSendBack); // konstruktor af superklassen
        this.port = port;
        this.ipadress = ipadress;
        this.user = user;
    }

    @Override
    protected boolean isServer() {
        return false; // det er en klient
    }

    @Override
    protected boolean isClient() {
        return true;
    }

    @Override
    protected String getIP() {
        return ipadress;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getUser() {
        return user.toString();
    }
}