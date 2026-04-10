package com.bytedance.sdk.openadsdk.core.un;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class lq<K, V> extends HashMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    public lq<String, Object> z(K k, V v) {
        put(k, v);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public lq<String, Object> z(Map<? extends K, ? extends V> map) {
        putAll(map);
        return this;
    }
}
