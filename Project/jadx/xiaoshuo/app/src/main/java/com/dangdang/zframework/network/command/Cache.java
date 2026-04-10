package com.dangdang.zframework.network.command;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface Cache {

    public static class Entry {
        public int code;
        public byte[] data;
        public String etag;
        public Map<String, String> responseHeaders = new HashMap();
        public long serverDate;
        public long softTtl;
        public long ttl;

        public boolean isExpired() {
            return this.ttl < System.currentTimeMillis();
        }

        public boolean refreshNeeded() {
            return this.softTtl < System.currentTimeMillis();
        }
    }

    void clear();

    Entry get(String str);

    void initialize();

    void invalidate(String str, boolean z);

    void put(String str, Entry entry);

    void remove(String str);
}
