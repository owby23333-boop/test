package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.loader.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class l {
    public static int aum;

    public static void a(a.C0385a c0385a) {
        aum++;
        a(1, c0385a, 0L, 0, "");
    }

    public static void a(a.C0385a c0385a, long j) {
        a(2, c0385a, j, 0, "");
    }

    public static void a(a.C0385a c0385a, long j, String str) {
        a(3, c0385a, j, 0, str);
    }

    public static void a(a.C0385a c0385a, int i, String str) {
        a(4, c0385a, 0L, i, str);
    }

    public static void b(a.C0385a c0385a) {
        a(5, c0385a, 0L, 0, "");
    }

    public static void b(a.C0385a c0385a, long j) {
        a(6, c0385a, j, 0, "");
    }

    public static void b(a.C0385a c0385a, int i, String str) {
        a(7, c0385a, 0L, i, str);
    }

    private static void a(int i, a.C0385a c0385a, long j, int i2, String str) {
        if (c0385a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).cq(i).cr(aum).cs(c0385a.sdkVersion).ct(c0385a.atC).ap(j).cs(i2).cu(str).toJson();
            new StringBuilder("status:").append(i).append("--jo:").append(json);
            com.kwad.sdk.api.c.g("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }

    static class a {
        private int aun;
        private int auo;
        private String aup;
        private String auq;
        private long aur;
        private int aus;
        private String aut;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cq(int i) {
            this.aun = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cr(int i) {
            this.auo = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cs(String str) {
            this.aup = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ct(String str) {
            this.auq = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ap(long j) {
            this.aur = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cs(int i) {
            this.aus = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cu(String str) {
            this.aut = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.aun));
                jSONObject.putOpt("update_count", Integer.valueOf(this.auo));
                jSONObject.putOpt("dynamic_version", this.aup);
                jSONObject.putOpt("download_url", this.auq);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.aur));
                jSONObject.putOpt("error_code", Integer.valueOf(this.aus));
                jSONObject.putOpt("error_msg", this.aut);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.aun + ", update_count=" + this.auo + ", dynamic_version='" + this.aup + "', download_url='" + this.auq + "', duration_ms=" + this.aur + ", error_code=" + this.aus + ", error_msg='" + this.aut + "'}";
        }
    }
}
