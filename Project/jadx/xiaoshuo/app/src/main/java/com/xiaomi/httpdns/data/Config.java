package com.xiaomi.httpdns.data;

import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes8.dex */
@Keep
public class Config {
    public String country;
    public final List<String> hosts;
    public boolean isDebug;
    public boolean isPreferredIPV4;
    public final List<String> persistentCoreHosts;
    public long persistentInvalidTime;

    @Keep
    public static class Builder {
        public String[] coreHosts;
        public String[] persistentCoreHosts;
        public boolean isDebug = false;
        public boolean isPreferredIPV4 = false;
        public long persistentInvalidTime = 604800000;
        public String country = "CN";

        public Config build() {
            Config config = new Config();
            config.isDebug = this.isDebug;
            config.country = this.country;
            config.isPreferredIPV4 = this.isPreferredIPV4;
            config.persistentInvalidTime = this.persistentInvalidTime;
            String[] strArr = this.coreHosts;
            if (strArr != null && strArr.length > 0) {
                config.hosts.clear();
                config.hosts.addAll(Arrays.asList(this.coreHosts));
            }
            String[] strArr2 = this.persistentCoreHosts;
            if (strArr2 != null && strArr2.length > 0) {
                config.persistentCoreHosts.clear();
                config.persistentCoreHosts.addAll(Arrays.asList(this.persistentCoreHosts));
            }
            return config;
        }

        public Builder coreHosts(String[] strArr) {
            this.coreHosts = strArr;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public Builder isPreferredIPV4(boolean z) {
            this.isPreferredIPV4 = z;
            return this;
        }

        public Builder params(HashMap<String, String> map, @IntRange(from = 0, to = 1) int i) {
            InnerConfig.a(map, i);
            return this;
        }

        public Builder persistentCoreHost(String[] strArr) {
            this.persistentCoreHosts = strArr;
            this.persistentInvalidTime = 604800000L;
            return this;
        }

        public Builder sampling(@IntRange(from = 0, to = 1000000) int i) {
            if (i <= 0) {
                InnerConfig.o = false;
                return this;
            }
            if (i > 1000000) {
                i = 1000000;
            }
            InnerConfig.o = new Random().nextInt(i) < 1;
            return this;
        }

        public Builder persistentCoreHost(String[] strArr, long j) {
            this.persistentCoreHosts = strArr;
            this.persistentInvalidTime = j;
            return this;
        }
    }

    public Config() {
        this.isDebug = false;
        this.isPreferredIPV4 = false;
        this.persistentCoreHosts = new ArrayList();
        this.persistentInvalidTime = 604800000L;
        this.hosts = new ArrayList();
        this.country = "CN";
    }

    @NonNull
    public List<String> getCoreHosts() {
        return this.hosts;
    }

    public String getCountry() {
        return this.country;
    }

    @NonNull
    public List<String> getPersistentCoreHosts() {
        return this.persistentCoreHosts;
    }

    public long getPersistentInvalidTime() {
        return this.persistentInvalidTime;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public boolean isPreferredIPV4() {
        return this.isPreferredIPV4;
    }

    public void setCountry(String str) {
        this.country = str;
    }
}
