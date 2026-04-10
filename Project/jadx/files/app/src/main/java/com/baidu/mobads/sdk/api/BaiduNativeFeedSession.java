package com.baidu.mobads.sdk.api;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduNativeFeedSession {
    private static HashMap<String, String> sessionHashMap = new HashMap<>();
    private static BaiduNativeFeedSession theInstance;

    private BaiduNativeFeedSession() {
    }

    public static synchronized BaiduNativeFeedSession getInstance() {
        if (theInstance == null) {
            theInstance = new BaiduNativeFeedSession();
        }
        return theInstance;
    }

    public int getSequenceId(int i2) {
        int i3 = 1;
        if (i2 < 1) {
            return 1;
        }
        try {
            if (sessionHashMap.containsKey(i2 + "")) {
                int i4 = Integer.parseInt(sessionHashMap.get(i2 + "")) + 1;
                if (i4 >= 1) {
                    i3 = i4;
                }
                sessionHashMap.put(i2 + "", i3 + "");
            } else {
                sessionHashMap.put(i2 + "", "1");
            }
        } catch (Exception unused) {
        }
        return i3;
    }
}
