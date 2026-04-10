package com.bytedance.sdk.openadsdk.core.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class wl<K, V> extends HashMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    public wl<String, Object> e(K k, V v) {
        put(k, v);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public wl<String, Object> e(Map<? extends K, ? extends V> map) {
        putAll(map);
        return this;
    }
}
