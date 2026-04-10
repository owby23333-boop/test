package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.loader.a;
import com.ss.android.downloadlib.constants.EventConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static int Zv;

    static class a {
        private long ZA;
        private int ZB;
        private String ZC;
        private int Zw;
        private int Zx;
        private String Zy;
        private String Zz;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a G(long j2) {
            this.ZA = j2;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a aP(int i2) {
            this.Zw = i2;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a aQ(int i2) {
            this.Zx = i2;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a aR(int i2) {
            this.ZB = i2;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a aS(String str) {
            this.Zy = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a aT(String str) {
            this.Zz = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a aU(String str) {
            this.ZC = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.Zw));
                jSONObject.putOpt("update_count", Integer.valueOf(this.Zx));
                jSONObject.putOpt("dynamic_version", this.Zy);
                jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_URL, this.Zz);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.ZA));
                jSONObject.putOpt("error_code", Integer.valueOf(this.ZB));
                jSONObject.putOpt("error_msg", this.ZC);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.Zw + ", update_count=" + this.Zx + ", dynamic_version='" + this.Zy + "', download_url='" + this.Zz + "', duration_ms=" + this.ZA + ", error_code=" + this.ZB + ", error_msg='" + this.ZC + "'}";
        }
    }

    private static void a(int i2, a.C0427a c0427a, long j2, int i3, String str) {
        if (c0427a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).aP(i2).aQ(Zv).aS(c0427a.sdkVersion).aT(c0427a.Zb).G(j2).aR(i3).aU(str).toJson();
            StringBuilder sb = new StringBuilder("status:");
            sb.append(i2);
            sb.append("--jo:");
            sb.append(json);
            com.kwad.sdk.api.c.a("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }

    public static void a(a.C0427a c0427a) {
        Zv++;
        a(1, c0427a, 0L, 0, "");
    }

    public static void a(a.C0427a c0427a, int i2, String str) {
        a(4, c0427a, 0L, i2, str);
    }

    public static void a(a.C0427a c0427a, long j2) {
        a(2, c0427a, j2, 0, "");
    }

    public static void a(a.C0427a c0427a, long j2, String str) {
        a(3, c0427a, j2, 0, str);
    }

    public static void b(a.C0427a c0427a) {
        a(5, c0427a, 0L, 0, "");
    }

    public static void b(a.C0427a c0427a, int i2, String str) {
        a(7, c0427a, 0L, i2, str);
    }

    public static void b(a.C0427a c0427a, long j2) {
        a(6, c0427a, j2, 0, "");
    }
}
