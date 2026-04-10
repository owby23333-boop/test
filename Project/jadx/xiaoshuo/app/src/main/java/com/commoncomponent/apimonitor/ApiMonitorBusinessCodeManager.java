package com.commoncomponent.apimonitor;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class ApiMonitorBusinessCodeManager {
    public static final String BUSINESS_CODE_KEY = "business_code_key";
    private static volatile ApiMonitorBusinessCodeManager sInstance;
    private final Map<String, Integer> datas = new HashMap();

    private ApiMonitorBusinessCodeManager() {
    }

    public static ApiMonitorBusinessCodeManager getInstance() {
        if (sInstance == null) {
            synchronized (ApiMonitorBusinessCodeManager.class) {
                if (sInstance == null) {
                    sInstance = new ApiMonitorBusinessCodeManager();
                }
            }
        }
        return sInstance;
    }

    public synchronized Integer getAndRemove(String str) {
        return this.datas.remove(str);
    }

    public synchronized void put(String str, Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            num = Integer.valueOf(num.intValue() - 1000000);
        } else if (num.intValue() > 0) {
            num = Integer.valueOf(num.intValue() + 1000000);
        }
        this.datas.put(str, num);
    }
}
