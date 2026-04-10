package anetwork.channel.cache;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public interface Cache {

    /* JADX INFO: compiled from: Taobao */
    public static class Entry implements Serializable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public byte[] f560s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f561t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public long f562u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public long f563v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public Map<String, List<String>> f564w = Collections.EMPTY_MAP;

        public boolean f() {
            return System.currentTimeMillis() <= this.f563v;
        }
    }

    void clear();

    Entry get(String str);

    void put(String str, Entry entry);

    void remove(String str);
}
