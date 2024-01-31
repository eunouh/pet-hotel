package models;

import com.google.gson.Gson;

public class AllOwners {
    Owner[] allOwners = new Owner[10];
    int ownersCount = 0;

    public AllOwners() {
    }

    public AllOwners(String json) {
        fromJson(json);
    }

    public void addOwner(Owner owner) {
        allOwners[ownersCount] = owner;
        ownersCount++;
    }

    public Owner[] getAllOwners() {
        return allOwners;
    }

    public int getOwnersCount() {
        return ownersCount;
    }

    public String toJson() {
        Gson gson = new Gson();
        String res = gson.toJson(this);
        return res;
    }

    public void fromJson(String data) {
        Gson gson = new Gson();
        AllOwners res = gson.fromJson(data, getClass());
        allOwners = res.getAllOwners();
        ownersCount = res.getOwnersCount();
    }

}
