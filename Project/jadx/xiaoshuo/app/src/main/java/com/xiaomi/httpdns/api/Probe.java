package com.xiaomi.httpdns.api;

/* JADX INFO: loaded from: classes8.dex */
public interface Probe {
    public static final int PROBE_ERROR = Integer.MAX_VALUE;
    public static final int PROBE_TIME_OUT = 5000;

    int probe(String str, String str2);
}
