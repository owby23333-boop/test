package com.bytedance.sdk.openadsdk.hh;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gz {

    public static class z {
        public Map<String, String> g;
        public String z;
    }

    public static z z(String str) {
        z zVar = new z();
        if (str == null) {
            return zVar;
        }
        String strTrim = str.trim();
        if (strTrim.equals("")) {
            return zVar;
        }
        String[] strArrSplit = strTrim.split("\\?");
        zVar.z = strArrSplit[0];
        if (strArrSplit.length == 1) {
            return zVar;
        }
        String[] strArrSplit2 = strArrSplit[1].split("&");
        zVar.g = new HashMap();
        for (String str2 : strArrSplit2) {
            String[] strArrSplit3 = str2.split("=");
            if (strArrSplit3.length >= 2) {
                zVar.g.put(strArrSplit3[0], strArrSplit3[1]);
            }
        }
        return zVar;
    }

    private static String z(String str, LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return sb.toString();
        }
        sb.append(str);
        boolean z2 = str.contains("?") || str.contains("&");
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String str2 : linkedHashMap.keySet()) {
                if (!z2) {
                    sb.append("?");
                    z2 = true;
                } else {
                    sb.append("&");
                }
                sb.append(str2).append("=").append(linkedHashMap.get(str2));
            }
        }
        return sb.toString();
    }

    public static String g(String str) {
        z zVarZ = z(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (zVarZ.g != null) {
            if (zVarZ.g.containsKey("v")) {
                linkedHashMap.put("v", zVarZ.g.get("v"));
                zVarZ.g.remove("v");
            }
            for (Map.Entry<String, String> entry : zVarZ.g.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return z(zVarZ.z, linkedHashMap);
    }
}
