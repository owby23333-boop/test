package com.bytedance.pangle.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String b = "request_finish";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f14506c = "download_start";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f14507d = "download_finish";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f14508e = "install_start";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f14509f = "install_finish";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f14510g = "load_start";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f14511h = "load_finish";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile b f14512i;
    public final List<com.bytedance.pangle.c.a> a = new ArrayList();

    public static class a {
        public static int A = 41000;
        public static int B = 42000;
        public static int a = 12000;
        public static int b = 12001;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static int f14513c = 12002;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static int f14514d = 12003;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static int f14515e = 12004;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f14516f = 20000;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static int f14517g = 21000;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static int f14518h = 21001;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static int f14519i = 21002;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static int f14520j = 22000;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f14521k = 22001;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f14522l = 22002;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static int f14523m = 22999;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static int f14524n = 30000;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static int f14525o = 31000;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static int f14526p = 32000;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static int f14527q = 32001;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static int f14528r = 32002;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static int f14529s = 32003;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static int f14530t = 32004;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static int f14531u = 32005;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static int f14532v = 32006;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static int f14533w = 32007;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static int f14534x = 32008;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static int f14535y = 32999;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static int f14536z = 40000;
    }

    private b() {
    }

    public static b a() {
        if (f14512i == null) {
            synchronized (b.class) {
                f14512i = new b();
            }
        }
        return f14512i;
    }

    public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.a) {
            Iterator<com.bytedance.pangle.c.a> it = this.a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(str, jSONObject, jSONObject2, jSONObject3);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
