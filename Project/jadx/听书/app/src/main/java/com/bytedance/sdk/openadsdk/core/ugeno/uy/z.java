package com.bytedance.sdk.openadsdk.core.ugeno.uy;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.dl.pf;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.a;
import com.bytedance.sdk.openadsdk.core.ugeno.component.skip.g;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements l.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dl f1366a;
    private dl dl;
    private dl e;
    private dl fo;
    private int fv;
    private pf g;
    private dl gc;
    private dl gz;
    private int hh;
    private int i;
    private boolean io;
    private int iq;
    private boolean js;
    private dl kb;
    private boolean l;
    private int ls;
    private dl m;
    private int p;
    private int pf;
    private int q;
    private int sy;
    private int tb;
    private boolean uf;
    private dl uy;
    private int v;
    private int wp;
    protected final l z = new l(Looper.getMainLooper(), this);
    private boolean zw;

    public z(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("xCreative");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("xSetting");
            String strOptString = jSONObject.optString("dynamic_configs", "");
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("video");
                if (jSONObjectOptJSONObject3 != null) {
                    this.i = jSONObjectOptJSONObject3.optInt("video_duration");
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("reward_full_time_type", 0);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("reward_full_play_time", 0);
                if (iOptInt == 1) {
                    this.v = iOptInt2;
                    this.js = true;
                }
            }
            if (jSONObjectOptJSONObject2 != null) {
                if (jSONObjectOptJSONObject2.optInt("ad_slot_type", 0) == 8) {
                    this.wp = jSONObjectOptJSONObject2.optInt("iv_skip_time", 0);
                } else {
                    this.wp = jSONObjectOptJSONObject2.optInt("rv_skip_time", 0);
                }
            }
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                if (new JSONObject(strOptString).optBoolean("is_show_video_duration", false)) {
                    this.js = false;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public void z(pf pfVar, dl dlVar) {
        this.g = pfVar;
        this.dl = dlVar;
        dl dlVarGc = dlVar.gc("RVCountdown");
        this.f1366a = dlVarGc;
        if (dlVarGc == null) {
            this.f1366a = this.dl.gc("FVCountdown");
        }
        dl dlVarGc2 = this.dl.gc("RVSkip");
        this.m = dlVarGc2;
        if (dlVarGc2 == null) {
            this.m = this.dl.gc("FVSkip");
        }
        this.gc = this.dl.gc("CycleCountDownView");
        this.e = this.dl.gc("RewardClickCountdown");
        this.gz = this.dl.gc("CycleSkip");
        this.uy = this.dl.gc("CsjRefreshTip");
        this.fo = this.dl.a("CsjRefreshTipContainer");
        this.kb = this.dl.a("CsjRefreshTipCancel");
    }

    private void dl() {
        int i;
        int i2;
        dl dlVar;
        if (this.js) {
            i = this.v;
            i2 = this.ls;
        } else {
            i = this.i;
            i2 = this.pf;
        }
        pf pfVar = this.g;
        if (pfVar != null && (dlVar = this.dl) != null) {
            pfVar.z(dlVar, "videoProgress", Integer.valueOf(i2));
        }
        int i3 = i2 + this.p;
        int iMax = Math.max(0, i - i3);
        boolean z = i3 >= this.wp || iMax == 0 || this.fv <= 0;
        dl dlVar2 = this.f1366a;
        if (dlVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.z) {
            dlVar2.g(0);
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.z) this.f1366a).z(iMax, i3, this.fv);
        }
        dl dlVar3 = this.m;
        if (dlVar3 instanceof g) {
            ((g) dlVar3).a(z);
        }
        dl dlVar4 = this.e;
        if (dlVar4 instanceof a) {
            ((a) dlVar4).z(iMax, i3, this.fv);
        }
        dl dlVar5 = this.gc;
        if (dlVar5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.g) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.g) dlVar5).z(i, i3, iMax, z);
        }
        dl dlVar6 = this.gz;
        if (dlVar6 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.skip.z) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.skip.z) dlVar6).g(this.tb, this.q);
        }
        dl dlVar7 = this.fo;
        if (dlVar7 != null) {
            dlVar7.g(this.zw ? 0 : 8);
        }
        dl dlVar8 = this.kb;
        if (dlVar8 != null) {
            dlVar8.g(this.uf ? 0 : 8);
        }
        dl dlVar9 = this.uy;
        if (dlVar9 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.dl) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.dl) dlVar9).z(this.iq, this.sy, this.hh, this.io, this.l);
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message.what != 100) {
            return;
        }
        this.z.sendEmptyMessageDelayed(100, 200L);
        dl();
    }

    public void z() {
        if (a()) {
            this.z.sendEmptyMessage(100);
        }
    }

    public void g() {
        this.z.removeCallbacksAndMessages(null);
    }

    private boolean a() {
        return (this.f1366a == null && this.m == null && this.gc == null && this.gz == null && this.uy == null) ? false : true;
    }

    public void z(int i, int i2, int i3, int i4) {
        this.pf = i;
        this.ls = i2;
        this.p = i3;
        this.fv = i4;
    }

    public void z(int i, int i2) {
        this.tb = i;
        this.q = i2;
    }

    public void z(int i, boolean z, int i2, int i3, boolean z2, boolean z3, boolean z4) {
        this.iq = i;
        this.sy = i2;
        this.hh = i3;
        this.zw = z2;
        this.io = z3;
        this.uf = z4;
        this.l = z;
    }
}
