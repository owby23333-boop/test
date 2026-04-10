package com.yuewen;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public class nh1 {
    public static final String h = "GET";
    public static final String i = "POST";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14850b;
    public final Map<String, List<String>> c;
    public final List<v52<String>> d;
    public final byte[] e;
    public final File f;
    public final String g;

    public synchronized void f(String str, String str2) {
        List<String> linkedList = this.c.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.c.put(str, linkedList);
        }
        linkedList.add(str2);
    }

    public List<v52<String>> g() {
        return this.d;
    }

    public String h() {
        return this.g;
    }

    public byte[] i() {
        return this.e;
    }

    public File j() {
        return this.f;
    }

    public Map<String, List<String>> k() {
        return this.c;
    }

    public List<String> l(String str) {
        return this.c.get(str);
    }

    public String m() {
        return this.f14850b;
    }

    public a n() {
        return new a(this);
    }

    public void o(String str, String str2) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str2);
        this.c.put(str, linkedList);
    }

    public String p() {
        return this.f14849a;
    }

    public nh1(a aVar) {
        this.f14849a = aVar.f14851a;
        this.f14850b = aVar.f14852b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f14851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f14852b;
        public Map<String, List<String>> c;
        public List<v52<String>> d;
        public byte[] e;
        public File f;
        public String g;

        public a(nh1 nh1Var) {
            this.f14851a = nh1Var.f14849a;
            this.f14852b = nh1Var.f14850b;
            this.c = nh1Var.c;
            this.d = nh1Var.d;
            this.e = nh1Var.e;
        }

        public a h(List<v52<String>> list) {
            this.d = list;
            return this;
        }

        public a i(String str) {
            this.g = str;
            return this;
        }

        public nh1 j() {
            if (this.c == null) {
                this.c = new HashMap();
            }
            if (this.d == null) {
                this.d = new LinkedList();
            }
            if (this.f14852b == null) {
                this.f14852b = "GET";
            }
            return new nh1(this);
        }

        public a k(byte[] bArr) {
            this.e = bArr;
            return this;
        }

        public a l(File file) {
            this.f = file;
            return this;
        }

        public a m(Map<String, List<String>> map) {
            this.c = map;
            return this;
        }

        public a n(String str) {
            this.f14852b = str;
            return this;
        }

        public a o(String str) {
            this.f14851a = str;
            return this;
        }

        public a() {
        }
    }
}
