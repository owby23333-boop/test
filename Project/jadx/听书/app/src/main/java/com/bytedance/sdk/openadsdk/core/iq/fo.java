package com.bytedance.sdk.openadsdk.core.iq;

import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.core.g.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f1157a;
    private final int[] dl;
    private final float e;
    private final long fo;
    private final String fv;
    private final int[] g;
    private final float gc;
    private final float gz;
    private final boolean hh;
    private final int i;
    private int io;
    private SparseArray<a.z> iq;
    private final String js;
    private final int kb;
    private final float ls;
    private final float m;
    private final int p;
    private final int pf;
    private final String q;
    private int sy;
    private final String tb;
    private String uf;
    private final long uy;
    private final float v;
    private final int wp;
    private final int[] z;
    private int zw;

    private fo(z zVar) {
        this.io = -1;
        this.sy = -1;
        this.z = zVar.kb;
        this.g = zVar.wp;
        this.f1157a = zVar.i;
        this.dl = zVar.uy;
        this.gc = zVar.fo;
        this.m = zVar.gz;
        this.e = zVar.e;
        this.gz = zVar.m;
        this.fo = zVar.gc;
        this.uy = zVar.f1158a;
        this.kb = zVar.v;
        this.wp = zVar.pf;
        this.i = zVar.ls;
        this.v = zVar.z;
        this.fv = zVar.js;
        this.js = zVar.tb;
        this.q = zVar.iq;
        this.tb = zVar.q;
        this.pf = zVar.g;
        this.ls = zVar.dl;
        this.p = zVar.fv;
        this.iq = zVar.p;
        this.zw = zVar.zw;
        this.io = zVar.io;
        this.uf = zVar.uf;
        this.sy = zVar.sy;
        this.hh = zVar.hh;
    }

    public JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.z;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.z[1]));
            }
            int[] iArr2 = this.g;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt(MediaFormat.KEY_WIDTH, Integer.valueOf(iArr2[0])).putOpt(MediaFormat.KEY_HEIGHT, Integer.valueOf(this.g[1]));
            }
            int[] iArr3 = this.dl;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.dl[1]));
            }
            int[] iArr4 = this.f1157a;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.f1157a[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.iq != null) {
                for (int i = 0; i < this.iq.size(); i++) {
                    a.z zVarValueAt = this.iq.valueAt(i);
                    if (zVarValueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(zVarValueAt.dl)).putOpt("mr", Double.valueOf(zVarValueAt.g)).putOpt(TypedValues.Cycle.S_WAVE_PHASE, Integer.valueOf(zVarValueAt.z)).putOpt("ts", Long.valueOf(zVarValueAt.f1068a));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.p)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Float.toString(this.gc)).putOpt("down_y", Float.toString(this.m)).putOpt("up_x", Float.toString(this.e)).putOpt("up_y", Float.toString(this.gz)).putOpt("down_time", Long.valueOf(this.fo)).putOpt("up_time", Long.valueOf(this.uy)).putOpt("toolType", Integer.valueOf(this.kb)).putOpt("deviceId", Integer.valueOf(this.wp)).putOpt("source", Integer.valueOf(this.i)).putOpt("density", Float.valueOf(this.v)).putOpt("densityDpi", Integer.valueOf(this.pf)).putOpt("scaleDensity", Float.valueOf(this.ls)).putOpt("ft", jSONObject2).putOpt("click_area_type", this.fv).putOpt("areaType", this.js).putOpt("rectInfo", this.q).putOpt("click_area_id", this.tb);
            int i2 = this.zw;
            if (i2 != -1) {
                jSONObject.putOpt("if_shake", Integer.valueOf(i2));
            }
            int i3 = this.io;
            if (i3 != -1) {
                jSONObject.putOpt("if_twist", Integer.valueOf(i3));
            }
            int i4 = this.sy;
            if (i4 != -1) {
                jSONObject.putOpt("dpa_position", Integer.valueOf(i4)).putOpt("dpa_pid", this.uf);
            }
            if (this.hh) {
                jSONObject.put("referer", "directDownload");
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static class z {
        float dl;
        private int fv;
        int g;
        private int[] i;
        private String iq;
        private String js;
        private int[] kb;
        private SparseArray<a.z> p;
        private String q;
        private String tb;
        private String uf;
        private int[] uy;
        private int[] wp;
        float z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f1158a = -1;
        private long gc = -1;
        private float m = -1.0f;
        private float e = -1.0f;
        private float gz = -1.0f;
        private float fo = -1.0f;
        private int v = -1;
        private int pf = -1;
        private int ls = -1024;
        private int zw = -1;
        private int io = -1;
        private int sy = -1;
        private boolean hh = false;

        public z z(float f) {
            this.z = f;
            return this;
        }

        public z z(int i) {
            this.g = i;
            return this;
        }

        public z g(float f) {
            this.dl = f;
            return this;
        }

        public z g(int i) {
            this.fv = i;
            return this;
        }

        public z z(SparseArray<a.z> sparseArray) {
            this.p = sparseArray;
            return this;
        }

        public z z(long j) {
            this.f1158a = j;
            return this;
        }

        public z g(long j) {
            this.gc = j;
            return this;
        }

        public z dl(float f) {
            this.m = f;
            return this;
        }

        public z a(float f) {
            this.e = f;
            return this;
        }

        public z gc(float f) {
            this.gz = f;
            return this;
        }

        public z m(float f) {
            this.fo = f;
            return this;
        }

        public z z(int[] iArr) {
            this.uy = iArr;
            return this;
        }

        public z g(int[] iArr) {
            this.kb = iArr;
            return this;
        }

        public z dl(int[] iArr) {
            this.wp = iArr;
            return this;
        }

        public z a(int[] iArr) {
            this.i = iArr;
            return this;
        }

        public z dl(int i) {
            this.v = i;
            return this;
        }

        public z a(int i) {
            this.pf = i;
            return this;
        }

        public z gc(int i) {
            this.ls = i;
            return this;
        }

        public z z(String str) {
            this.js = str;
            return this;
        }

        public z g(String str) {
            this.tb = str;
            return this;
        }

        public z dl(String str) {
            this.q = str;
            return this;
        }

        public z a(String str) {
            this.iq = str;
            return this;
        }

        public z m(int i) {
            this.zw = i;
            return this;
        }

        public z e(int i) {
            this.io = i;
            return this;
        }

        public z gc(String str) {
            this.uf = str;
            return this;
        }

        public z gz(int i) {
            this.sy = i;
            return this;
        }

        public z z(boolean z) {
            this.hh = z;
            return this;
        }

        public fo z() {
            return new fo(this);
        }
    }
}
