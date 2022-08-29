package com.rotemyanco.android_demo_app_005_lec_13.models.responses;

import com.rotemyanco.android_demo_app_005_lec_13.models.Vehicle;

import java.util.List;

public class VehicleResponse {

    private int count;
    private String next;
    private String previous;
    private List<Vehicle> results;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<Vehicle> getResults() {
        return results;
    }
}
