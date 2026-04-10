package com.xiaomi.httpdns.core;

import com.xiaomi.httpdns.data.InnerConfig;

/* JADX INFO: loaded from: classes8.dex */
public class ConfigManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InnerConfig f7341a = new InnerConfig();

    public static final class Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ConfigManager f7342a = new ConfigManager();
    }

    public boolean a() {
        return this.f7341a.d.isDebug();
    }
}
