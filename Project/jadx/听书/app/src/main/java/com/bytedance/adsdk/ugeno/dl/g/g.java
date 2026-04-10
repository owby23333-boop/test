package com.bytedance.adsdk.ugeno.dl.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.i;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.m.fo;
import com.bytedance.sdk.component.utils.wp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements fo.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ls f223a;
    private Context dl;
    private fv g;
    private com.bytedance.adsdk.ugeno.g.dl gc;
    private Handler m = new fo(Looper.getMainLooper(), this);
    private int z;

    public g(Context context, ls lsVar, com.bytedance.adsdk.ugeno.g.dl dlVar) {
        this.dl = context;
        this.f223a = lsVar;
        this.gc = dlVar;
    }

    public void z(fv fvVar) {
        this.g = fvVar;
    }

    public void z() {
        ls lsVar = this.f223a;
        if (lsVar == null) {
            return;
        }
        try {
            int i = Integer.parseInt(com.bytedance.adsdk.ugeno.a.g.z(lsVar.dl().optString("delay"), this.gc.uy()));
            this.z = i;
            this.m.sendEmptyMessageDelayed(1001, i);
        } catch (NumberFormatException e) {
            wp.z(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.m.fo.z
    public void z(Message message) {
        if (message.what != 1001) {
            return;
        }
        JSONObject jSONObjectDl = this.f223a.dl();
        if (TextUtils.equals(jSONObjectDl.optString("type"), "onAnimation")) {
            String strOptString = jSONObjectDl.optString("nodeId");
            com.bytedance.adsdk.ugeno.g.dl dlVar = this.gc;
            com.bytedance.adsdk.ugeno.g.dl dlVarA = dlVar.g(dlVar).a(strOptString);
            new i(dlVarA.fo(), com.bytedance.adsdk.ugeno.dl.z.z(jSONObjectDl.optJSONObject("animatorSet"), dlVarA)).z();
        } else {
            fv fvVar = this.g;
            if (fvVar != null) {
                ls lsVar = this.f223a;
                com.bytedance.adsdk.ugeno.g.dl dlVar2 = this.gc;
                fvVar.z(lsVar, dlVar2, dlVar2);
            }
        }
        this.m.removeMessages(1001);
    }
}
