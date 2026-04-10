package com.alibaba.sdk.android.httpdns.b;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f2171i;
    public long id;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f2172o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f2173p;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("[IpRecord] ");
        sb.append("id:");
        sb.append(this.id);
        sb.append(com.anythink.expressad.foundation.g.a.bQ);
        sb.append("host_id:");
        sb.append(this.f2171i);
        sb.append(com.anythink.expressad.foundation.g.a.bQ);
        sb.append("ip:");
        sb.append(this.f2172o);
        sb.append(com.anythink.expressad.foundation.g.a.bQ);
        sb.append("ttl:");
        sb.append(this.f2173p);
        sb.append(com.anythink.expressad.foundation.g.a.bQ);
        return sb.toString();
    }
}
