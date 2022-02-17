package com.alo.eparts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPumpProduct {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();
        List<String> cricket = new ArrayList<String>();
        cricket.add("Part Name");

        List<String> FootBall = new ArrayList<String>();
        FootBall.add("Part Name");

        expandableListDetail.put("Part Name", cricket);
        expandableListDetail.put("Part Name1", FootBall);
        return expandableListDetail;

    }

    public static HashMap<String, List<String>> getDataService() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();
        List<String> cricket = new ArrayList<String>();
        cricket.add("Part Name");

        List<String> FootBall = new ArrayList<String>();
        FootBall.add("Part Name");

        expandableListDetail.put("Part Name", cricket);
        expandableListDetail.put("Part Name1", FootBall);
        return expandableListDetail;

    }
}
