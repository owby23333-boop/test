package com.xiaomi.httpdns.api;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes8.dex */
public interface DnsProvider {
    boolean enableDnsCache();

    boolean isEnable();

    String name();

    String[] query(@NonNull String str, int i, boolean z);

    int ttl();
}
