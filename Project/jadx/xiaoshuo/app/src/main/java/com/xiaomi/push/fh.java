package com.xiaomi.push;

import android.util.Pair;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Vector<Pair<String, Long>> f7965a = new Vector<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ConcurrentHashMap<String, Long> f383a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f7965a) {
            for (int i = 0; i < f7965a.size(); i++) {
                Pair<String, Long> pairElementAt = f7965a.elementAt(i);
                sb.append((String) pairElementAt.first);
                sb.append(":");
                sb.append(pairElementAt.second);
                if (i < f7965a.size() - 1) {
                    sb.append(";");
                }
            }
            f7965a.clear();
        }
        return sb.toString();
    }
}
