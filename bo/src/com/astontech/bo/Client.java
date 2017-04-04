package com.astontech.bo;

import java.util.ArrayList;
import java.util.List;

public class Client extends BaseBO {

    //region PROPERTIES

    private String clientName;
    private int clientId;
    private List<Phone> phoneNumbers = new ArrayList<>();

    //endregion

    //region CONSTRUCTORS

    public Client(String clientName, int clientId) {
        this.clientName = clientName;
        this.clientId = clientId;
    }

    public Client(String clientName) {
        this.clientName = clientName;
    }

    //endregion

    //region GETTER SETTERS

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    //endregion

    //region CUSTOM METHODS
    //endregion
}
