package dw;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
      String s="{\"area\":\"shandong\",\"uid\":\"7756\",\"itemid\":45,\"npgid\":23,\"evid\":\"" +
              "clickItem\",\"os\":\"ios\",\"pgid\":31,\"appid\":\"data2020\",\"mid\":\"mid_30014\",\"type\":\"event\"}";
        String strip = StringUtils.strip(s, "{}");
        String[] split = strip.split(",");
        String header=null;
        for (String s1 : split) {
            if ( s1.contains("type")){
                String[] split1 = s1.split(":");
                header= split1[1].substring(1,split1[1].length()-1);
            }
        }
        stringStringHashMap.put("logType",header);
        System.out.println(stringStringHashMap.toString());
    }
}
