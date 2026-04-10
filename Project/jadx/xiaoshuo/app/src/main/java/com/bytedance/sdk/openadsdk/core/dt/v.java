package com.bytedance.sdk.openadsdk.core.dt;

import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.core.bf.tg;
import com.market.sdk.utils.Constants;
import com.yuewen.xa3;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class v {
    private final int[] bf;
    private final int bh;
    private int cv;
    private final int[] d;
    private final String dt;
    private final int[] e;
    private final String f;
    private final float ga;
    private final String k;
    private final int l;
    private final long m;
    private final float p;
    private final String pe;
    private final int s;
    private final float t;
    private final int[] tg;
    private final float v;
    private final float vn;
    private final float w;
    private int wl;
    private final int wu;
    private final int xu;
    private SparseArray<tg.e> y;
    private final long zk;

    public static class e {
        int bf;
        private int[] bh;
        float d;
        private String dt;
        float e;
        private int f;
        private String k;
        private SparseArray<tg.e> l;
        private int[] m;
        private String pe;
        private int[] wu;
        private int[] xu;
        private String y;
        private long tg = -1;
        private long ga = -1;
        private float vn = -1.0f;
        private float p = -1.0f;
        private float v = -1.0f;
        private float zk = -1.0f;
        private int t = -1;
        private int s = -1;
        private int w = -1024;
        private int cv = -1;
        private int wl = -1;

        public e bf(float f) {
            this.d = f;
            return this;
        }

        public e d(float f) {
            this.vn = f;
            return this;
        }

        public e e(float f) {
            this.e = f;
            return this;
        }

        public e ga(float f) {
            this.v = f;
            return this;
        }

        public e p(int i) {
            this.wl = i;
            return this;
        }

        public e tg(float f) {
            this.p = f;
            return this;
        }

        public e vn(float f) {
            this.zk = f;
            return this;
        }

        public e bf(int i) {
            this.f = i;
            return this;
        }

        public e d(int[] iArr) {
            this.xu = iArr;
            return this;
        }

        public e e(int i) {
            this.bf = i;
            return this;
        }

        public e ga(int i) {
            this.w = i;
            return this;
        }

        public e tg(int[] iArr) {
            this.bh = iArr;
            return this;
        }

        public e vn(int i) {
            this.cv = i;
            return this;
        }

        public e bf(long j) {
            this.ga = j;
            return this;
        }

        public e d(int i) {
            this.t = i;
            return this;
        }

        public e e(SparseArray<tg.e> sparseArray) {
            this.l = sparseArray;
            return this;
        }

        public e tg(int i) {
            this.s = i;
            return this;
        }

        public e bf(int[] iArr) {
            this.wu = iArr;
            return this;
        }

        public e d(String str) {
            this.pe = str;
            return this;
        }

        public e e(long j) {
            this.tg = j;
            return this;
        }

        public e tg(String str) {
            this.y = str;
            return this;
        }

        public e bf(String str) {
            this.dt = str;
            return this;
        }

        public e e(int[] iArr) {
            this.m = iArr;
            return this;
        }

        public e e(String str) {
            this.k = str;
            return this;
        }

        public v e() {
            return new v(this);
        }
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.e;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.e[1]));
            }
            int[] iArr2 = this.bf;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.bf[1]));
            }
            int[] iArr3 = this.d;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.d[1]));
            }
            int[] iArr4 = this.tg;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.tg[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.y != null) {
                for (int i = 0; i < this.y.size(); i++) {
                    tg.e eVarValueAt = this.y.valueAt(i);
                    if (eVarValueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(eVarValueAt.d)).putOpt("mr", Double.valueOf(eVarValueAt.bf)).putOpt(TypedValues.CycleType.S_WAVE_PHASE, Integer.valueOf(eVarValueAt.e)).putOpt(xa3.c, Long.valueOf(eVarValueAt.tg));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.l)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Float.toString(this.ga)).putOpt("down_y", Float.toString(this.vn)).putOpt("up_x", Float.toString(this.p)).putOpt("up_y", Float.toString(this.v)).putOpt("down_time", Long.valueOf(this.zk)).putOpt("up_time", Long.valueOf(this.m)).putOpt("toolType", Integer.valueOf(this.wu)).putOpt("deviceId", Integer.valueOf(this.xu)).putOpt("source", Integer.valueOf(this.bh)).putOpt(Constants.JSON_DENSITY, Float.valueOf(this.t)).putOpt("densityDpi", Integer.valueOf(this.s)).putOpt("scaleDensity", Float.valueOf(this.w)).putOpt("ft", jSONObject2).putOpt("click_area_type", this.f).putOpt("areaType", this.k).putOpt("rectInfo", this.pe).putOpt("click_area_id", this.dt);
            int i2 = this.cv;
            if (i2 != -1) {
                jSONObject.putOpt("if_shake", Integer.valueOf(i2));
            }
            int i3 = this.wl;
            if (i3 != -1) {
                jSONObject.putOpt("if_twist", Integer.valueOf(i3));
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private v(e eVar) {
        this.wl = -1;
        this.e = eVar.wu;
        this.bf = eVar.xu;
        this.tg = eVar.bh;
        this.d = eVar.m;
        this.ga = eVar.zk;
        this.vn = eVar.v;
        this.p = eVar.p;
        this.v = eVar.vn;
        this.zk = eVar.ga;
        this.m = eVar.tg;
        this.wu = eVar.t;
        this.xu = eVar.s;
        this.bh = eVar.w;
        this.t = eVar.e;
        this.f = eVar.k;
        this.k = eVar.dt;
        this.pe = eVar.y;
        this.dt = eVar.pe;
        this.s = eVar.bf;
        this.w = eVar.d;
        this.l = eVar.f;
        this.y = eVar.l;
        this.cv = eVar.cv;
        this.wl = eVar.wl;
    }
}
