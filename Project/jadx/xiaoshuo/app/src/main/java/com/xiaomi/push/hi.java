package com.xiaomi.push;

import android.os.Bundle;

/* JADX INFO: loaded from: classes8.dex */
public class hi extends hg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private b f503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8038b;

    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public hi(b bVar) {
        this.f503a = b.available;
        this.f8038b = null;
        this.f8037a = Integer.MIN_VALUE;
        this.f502a = null;
        a(bVar);
    }

    @Override // com.xiaomi.push.hg
    public Bundle a() {
        Bundle bundleA = super.a();
        b bVar = this.f503a;
        if (bVar != null) {
            bundleA.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f8038b;
        if (str != null) {
            bundleA.putString("ext_pres_status", str);
        }
        int i = this.f8037a;
        if (i != Integer.MIN_VALUE) {
            bundleA.putInt("ext_pres_prio", i);
        }
        a aVar = this.f502a;
        if (aVar != null && aVar != a.available) {
            bundleA.putString("ext_pres_mode", aVar.toString());
        }
        return bundleA;
    }

    public hi(Bundle bundle) {
        super(bundle);
        this.f503a = b.available;
        this.f8038b = null;
        this.f8037a = Integer.MIN_VALUE;
        this.f502a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f503a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f8038b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f8037a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f502a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f503a = bVar;
            return;
        }
        throw new NullPointerException("Type cannot be null");
    }

    public void a(String str) {
        this.f8038b = str;
    }

    public void a(int i) {
        if (i >= -128 && i <= 128) {
            this.f8037a = i;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
    }

    public void a(a aVar) {
        this.f502a = aVar;
    }

    @Override // com.xiaomi.push.hg
    /* JADX INFO: renamed from: a */
    public String mo496a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(hr.a(l()));
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(hr.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(hr.a(k()));
            sb.append("\"");
        }
        if (this.f503a != null) {
            sb.append(" type=\"");
            sb.append(this.f503a);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f8038b != null) {
            sb.append("<status>");
            sb.append(hr.a(this.f8038b));
            sb.append("</status>");
        }
        if (this.f8037a != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.f8037a);
            sb.append("</priority>");
        }
        a aVar = this.f502a;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.f502a);
            sb.append("</show>");
        }
        sb.append(o());
        hk hkVarM497a = m497a();
        if (hkVarM497a != null) {
            sb.append(hkVarM497a.m500a());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
