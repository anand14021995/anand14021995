package com.alo.eparts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RatingsExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> country = new ArrayList<String>();
        country.add("View Commenets");


        List<String> language = new ArrayList<String>();
        language.add("English");
        language.add("Spanish");
        language.add("Turkish");
        language.add("French");
        language.add("Arabic");

        expandableListDetail.put("Serial Id : 123456", country);


        return expandableListDetail;
    }
}
