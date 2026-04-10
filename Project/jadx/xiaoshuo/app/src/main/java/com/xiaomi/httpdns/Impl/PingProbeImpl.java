package com.xiaomi.httpdns.Impl;

import com.xiaomi.httpdns.api.Probe;
import com.xiaomi.httpdns.utils.Ping;

/* JADX INFO: loaded from: classes8.dex */
public class PingProbeImpl implements Probe {
    @Override // com.xiaomi.httpdns.api.Probe
    public int probe(String str, String str2) {
        try {
            return Ping.a("ping -c1 -s1 -w1 " + str2);
        } catch (Exception e) {
            e.printStackTrace();
            return Integer.MAX_VALUE;
        }
    }
}
