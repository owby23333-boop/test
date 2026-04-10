package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class he extends hg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f8030a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Map<String, String> f493a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8031a = new a("get");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8032b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a("error");
        public static final a e = new a("command");

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f494a;

        private a(String str) {
            this.f494a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = f8031a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = f8032b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = e;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        public String toString() {
            return this.f494a;
        }
    }

    public he() {
        this.f8030a = a.f8031a;
        this.f493a = new HashMap();
    }

    public synchronized void a(Map<String, String> map) {
        this.f493a.putAll(map);
    }

    public String b() {
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public a m495a() {
        return this.f8030a;
    }

    public he(Bundle bundle) {
        super(bundle);
        this.f8030a = a.f8031a;
        this.f493a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f8030a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.f8030a = a.f8031a;
        } else {
            this.f8030a = aVar;
        }
    }

    @Override // com.xiaomi.push.hg
    public Bundle a() {
        Bundle bundleA = super.a();
        a aVar = this.f8030a;
        if (aVar != null) {
            bundleA.putString("ext_iq_type", aVar.toString());
        }
        return bundleA;
    }

    @Override // com.xiaomi.push.hg
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo496a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(hr.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(hr.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(hr.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f493a.entrySet()) {
            sb.append(hr.a(entry.getKey()));
            sb.append("=\"");
            sb.append(hr.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.f8030a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"");
            sb.append(m495a());
            sb.append("\">");
        }
        String strB = b();
        if (strB != null) {
            sb.append(strB);
        }
        sb.append(o());
        hk hkVarM497a = m497a();
        if (hkVarM497a != null) {
            sb.append(hkVarM497a.m500a());
        }
        sb.append("</iq>");
        return sb.toString();
    }
}
