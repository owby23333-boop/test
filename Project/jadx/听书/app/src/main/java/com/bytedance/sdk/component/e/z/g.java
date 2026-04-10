package com.bytedance.sdk.component.e.z;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public Map<String, Object> z(Map<String, Object> map, com.bytedance.sdk.component.a.g.z zVar, boolean z) {
        if (zVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = zVar.decrypt(key);
            }
            concurrentHashMap.put(key, zVar.decrypt(value.toString()));
        }
        return concurrentHashMap;
    }

    public Map<String, Object> g(Map<String, Object> map, com.bytedance.sdk.component.a.g.z zVar, boolean z) {
        if (zVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = zVar.encrypt(key);
            }
            concurrentHashMap.put(key, zVar.encrypt(value.toString()));
        }
        return concurrentHashMap;
    }
}
