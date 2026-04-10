package com.bytedance.sdk.openadsdk.s;

import com.alipay.sdk.m.w.a;
import com.iflytek.aikit.media.param.MscKeys;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class p {

    public static class e {
        public Map<String, String> bf;
        public String e;
    }

    public static String bf(String str) {
        e eVarE = e(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, String> map = eVarE.bf;
        if (map != null) {
            if (map.containsKey("v")) {
                linkedHashMap.put("v", eVarE.bf.get("v"));
                eVarE.bf.remove("v");
            }
            for (Map.Entry<String, String> entry : eVarE.bf.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return e(eVarE.e, linkedHashMap);
    }

    public static e e(String str) {
        e eVar = new e();
        if (str == null) {
            return eVar;
        }
        String strTrim = str.trim();
        if (strTrim.equals("")) {
            return eVar;
        }
        String[] strArrSplit = strTrim.split("\\?");
        eVar.e = strArrSplit[0];
        if (strArrSplit.length == 1) {
            return eVar;
        }
        String[] strArrSplit2 = strArrSplit[1].split(a.p);
        eVar.bf = new HashMap();
        for (String str2 : strArrSplit2) {
            String[] strArrSplit3 = str2.split(MscKeys.KEY_VAL_SEP);
            if (strArrSplit3.length >= 2) {
                eVar.bf.put(strArrSplit3[0], strArrSplit3[1]);
            }
        }
        return eVar;
    }

    private static String e(String str, LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return sb.toString();
        }
        sb.append(str);
        boolean z = str.contains("?") || str.contains(a.p);
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String str2 : linkedHashMap.keySet()) {
                if (!z) {
                    sb.append("?");
                    z = true;
                } else {
                    sb.append(a.p);
                }
                sb.append(str2);
                sb.append(MscKeys.KEY_VAL_SEP);
                sb.append(linkedHashMap.get(str2));
            }
        }
        return sb.toString();
    }
}
