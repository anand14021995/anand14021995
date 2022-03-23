package com.alo.eparts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPumpcountry {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> country = new ArrayList<String>();
        country.add("India");
        country.add("Pakistan");
        country.add("Australia");
        country.add("England");
        country.add("South Africa");

        List<String> language = new ArrayList<String>();
        language.add("English");
        language.add("Spanish");
        language.add("Turkish");
        language.add("French");
        language.add("Arabic");

        expandableListDetail.put("Country", country);
        expandableListDetail.put("Language", language);

        return expandableListDetail;
    }
}
