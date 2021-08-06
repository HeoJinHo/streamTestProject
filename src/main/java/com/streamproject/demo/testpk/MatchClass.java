package com.streamproject.demo.testpk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchClass
{


    public static void main(String[] args) {


        List<String> list = Arrays.asList("MASTER", "AGENT");

        Map<String, String> mapData = new HashMap<>();


        for (String str : list){
            if("MASTER".equals(str)){
                System.out.println("master");
                mapData.put("matser", str);
            }
            if("AGENT".equals(str)){
                System.out.println("agent");
                mapData.put("agent", str);
            }
            if("RESELLER".equals(str)){
                System.out.println("reseller");
                mapData.put("reseller", str);
            }else{
                mapData.put("reseller", "");
            }
        }


        System.out.println(mapData);

    }

}
