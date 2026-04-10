package com.duokan.reader.common.bitmap;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class HashBag<K> extends HashMap<K, Integer> {
    public void add(K k) {
        if (get(k) == null) {
            put(k, 1);
        } else {
            put(k, Integer.valueOf(get(k).intValue() + 1));
        }
    }

    public int getCount(K k) {
        if (get(k) == null) {
            return 0;
        }
        return get(k).intValue();
    }

    public Iterator<K> iterator() {
        return keySet().iterator();
    }
}
