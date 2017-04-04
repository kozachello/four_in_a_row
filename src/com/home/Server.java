package com.home;

import java.io.Serializable;
import java.util.function.Consumer;

/**
 * Created by Козак on 04.04.2017.
 */

public class Server extends ConnectionControl {

    private int port;
    // lav et array
    public Server(int port, Consumer<Serializable> ifGotSendBack) {
        super(ifGotSendBack); // konstruktor af superklassen
        this.port = port;
    }

    @Override
    protected boolean isServer() {
        return true; // ok fordi det er en server
    }

    @Override
    protected boolean isClient() {
        return false;
    }

    @Override
    protected String getIP() {
        return null;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getUser() {
        return null;
    }

}