package com.bytedance.pangle.a;

import com.bytedance.sdk.openadsdk.api.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f505a = "install_start";
    public static String dl = "download_finish";
    public static String e = "7z_unzip_finish";
    public static String fo = "load_finish";
    public static String g = "download_start";
    public static String gc = "install_finish";
    public static String gz = "load_start";
    private static volatile g kb = null;
    public static String m = "7z_unzip_start";
    public static String uy = "rm_entry_finish";
    public static String z = "request_finish";
    private final List<com.bytedance.pangle.a.z> wp = new ArrayList();

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f506a = -2;
        public static int dl = -1;
        public static int e = 12002;
        public static int fo = 12004;
        public static int fv = 30000;
        public static int g = 2;
        public static int gc = 12000;
        public static int gk = 40000;
        public static int gz = 12003;
        public static int h = 32999;
        public static int hh = 32007;
        public static int i = 21002;
        public static int io = 32004;
        public static int iq = 32002;
        public static int js = 31000;
        public static int kb = 21000;
        public static int l = 32008;
        public static int lq = 42000;
        public static int ls = 22002;
        public static int m = 12001;
        public static int mc = 50000;
        public static int p = 22999;
        public static int pf = 22001;
        public static int q = 32001;
        public static int sy = 32006;
        public static int tb = 32000;
        public static int uf = 32005;
        public static int un = 50004;
        public static int uy = 20000;
        public static int v = 22000;
        public static int wp = 21001;
        public static int x = 41000;
        public static int z = 1;
        public static int zw = 32003;
    }

    public static g z() {
        if (kb == null) {
            synchronized (g.class) {
                kb = new g();
            }
        }
        return kb;
    }

    private g() {
    }

    public void z(com.bytedance.pangle.a.z zVar) {
        synchronized (this.wp) {
            this.wp.add(zVar);
        }
    }

    public void z(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.wp) {
            Iterator<com.bytedance.pangle.a.z> it = this.wp.iterator();
            while (it.hasNext()) {
                try {
                    it.next().z(str, jSONObject, jSONObject2, jSONObject3);
                } catch (Throwable th) {
                    m.z(th);
                }
            }
        }
    }
}
