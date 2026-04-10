package com.xiaomi.httpdns.net;

import com.xiaomi.httpdns.core.ConfigManager;

/* JADX INFO: loaded from: classes8.dex */
public class Url {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f7376a = {"223.5.5.5", "223.6.6.6"};

    public static String a(char c) {
        return c != 1 ? c != 2 ? c != 3 ? c != 4 ? "" : "https://120.53.53.53/dns-query?name=" : "https://dns.google/resolve?name=" : "https://dns.alidns.com/resolve?name=" : ConfigManager.Holder.f7342a.a() ? "http://staging-api.edns.xiaomi.com/resolve" : "https://dispatch.mgslb.com/resolve";
    }
}
