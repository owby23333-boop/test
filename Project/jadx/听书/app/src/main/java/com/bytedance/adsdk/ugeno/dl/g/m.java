package com.bytedance.adsdk.ugeno.dl.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.m.fo;
import com.bytedance.sdk.component.utils.wp;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m implements fo.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f225a;
    private fv dl;
    private Handler e = new fo(Looper.getMainLooper(), this);
    private int g;
    private ls gc;
    private com.bytedance.adsdk.ugeno.g.dl m;
    private boolean z;

    public m(Context context, ls lsVar, com.bytedance.adsdk.ugeno.g.dl dlVar) {
        this.f225a = context;
        this.gc = lsVar;
        this.m = dlVar;
    }

    public void z(fv fvVar) {
        this.dl = fvVar;
    }

    public void z() {
        ls lsVar = this.gc;
        if (lsVar == null) {
            return;
        }
        JSONObject jSONObjectDl = lsVar.dl();
        try {
            this.g = Integer.parseInt(com.bytedance.adsdk.ugeno.a.g.z(jSONObjectDl.optString(an.aU, "8000"), this.m.uy()));
            this.z = jSONObjectDl.optBoolean("repeat");
            this.e.sendEmptyMessageDelayed(1001, this.g);
        } catch (NumberFormatException e) {
            wp.z(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.m.fo.z
    public void z(Message message) {
        if (message.what != 1001) {
            return;
        }
        fv fvVar = this.dl;
        if (fvVar != null) {
            ls lsVar = this.gc;
            com.bytedance.adsdk.ugeno.g.dl dlVar = this.m;
            fvVar.z(lsVar, dlVar, dlVar);
        }
        if (this.z) {
            this.e.sendEmptyMessageDelayed(1001, this.g);
        } else {
            this.e.removeMessages(1001);
        }
    }
}
