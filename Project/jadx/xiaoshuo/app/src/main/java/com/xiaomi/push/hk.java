package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class hk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<hd> f507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8045b;
    private String c;
    private String d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8046a = new a("internal-server-error");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8047b = new a("forbidden");
        public static final a c = new a("bad-request");
        public static final a d = new a("conflict");
        public static final a e = new a("feature-not-implemented");
        public static final a f = new a("gone");
        public static final a g = new a("item-not-found");
        public static final a h = new a("jid-malformed");
        public static final a i = new a("not-acceptable");
        public static final a j = new a("not-allowed");
        public static final a k = new a("not-authorized");
        public static final a l = new a("payment-required");
        public static final a m = new a("recipient-unavailable");
        public static final a n = new a("redirect");
        public static final a o = new a("registration-required");
        public static final a p = new a("remote-server-error");
        public static final a q = new a("remote-server-not-found");
        public static final a r = new a("remote-server-timeout");
        public static final a s = new a("resource-constraint");
        public static final a t = new a("service-unavailable");
        public static final a u = new a("subscription-required");
        public static final a v = new a("undefined-condition");
        public static final a w = new a("unexpected-request");
        public static final a x = new a("request-timeout");

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f508a;

        public a(String str) {
            this.f508a = str;
        }

        public String toString() {
            return this.f508a;
        }
    }

    public hk(a aVar) {
        this.f507a = null;
        a(aVar);
        this.d = null;
    }

    private void a(a aVar) {
        this.f8045b = aVar.f508a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f8045b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.f8044a);
        sb.append(")");
        if (this.d != null) {
            sb.append(" ");
            sb.append(this.d);
        }
        return sb.toString();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f506a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f8044a);
        String str2 = this.c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f8045b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<hd> list = this.f507a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            Iterator<hd> it = this.f507a.iterator();
            int i = 0;
            while (it.hasNext()) {
                Bundle bundleA = it.next().a();
                if (bundleA != null) {
                    bundleArr[i] = bundleA;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public hk(int i, String str, String str2, String str3, String str4, List<hd> list) {
        this.f8044a = i;
        this.f506a = str;
        this.c = str2;
        this.f8045b = str3;
        this.d = str4;
        this.f507a = list;
    }

    public hk(Bundle bundle) {
        this.f507a = null;
        this.f8044a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f506a = bundle.getString("ext_err_type");
        }
        this.f8045b = bundle.getString("ext_err_cond");
        this.c = bundle.getString("ext_err_reason");
        this.d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f507a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                hd hdVarA = hd.a((Bundle) parcelable);
                if (hdVarA != null) {
                    this.f507a.add(hdVarA);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m500a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.f8044a);
        sb.append("\"");
        if (this.f506a != null) {
            sb.append(" type=\"");
            sb.append(this.f506a);
            sb.append("\"");
        }
        if (this.c != null) {
            sb.append(" reason=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f8045b != null) {
            sb.append("<");
            sb.append(this.f8045b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.d);
            sb.append("</text>");
        }
        Iterator<hd> it = m501a().iterator();
        while (it.hasNext()) {
            sb.append(it.next().d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized List<hd> m501a() {
        List<hd> list = this.f507a;
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }
}
