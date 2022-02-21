package com.alo.eparts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("Aerialsssss");
        cricket.add("Amplifier for sound system");
        cricket.add("Connection for external audio sources");
        cricket.add("Control unit for infor-mation electronics");
        cricket.add("Data Plate");

        List<String> football = new ArrayList<String>();
//        football.add("Brazil");
//        football.add("Spain");
//        football.add("Germany");
//        football.add("Netherlands");
//        football.add("Italy");

        List<String> basketball = new ArrayList<String>();
//        basketball.add("United States");
//        basketball.add("Spain");
//        basketball.add("Argentina");
//        basketball.add("France");
//        basketball.add("Russia");

        expandableListDetail.put("Access, Infotainment, Miscell", cricket);
        expandableListDetail.put("Bodysss", football);
        expandableListDetail.put("Electrics", basketball);
        return expandableListDetail;
    }
}
