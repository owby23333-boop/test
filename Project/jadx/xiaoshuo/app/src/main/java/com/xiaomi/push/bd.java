package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f166a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f167a = new HashMap();

    public String a() {
        return this.f166a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f7818a), this.f167a.toString(), this.f166a);
    }
}
