package com.bytedance.sdk.openadsdk.core.ugeno.dl;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.bytedance.adsdk.ugeno.dl.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.i.a;
import com.bytedance.sdk.openadsdk.core.i.m;
import com.bytedance.sdk.openadsdk.core.iq.fo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends z implements tb {
    private float e;
    private float fo;
    private float gz;
    private long kb;
    private boolean m;
    private float uy;
    private com.bytedance.adsdk.ugeno.g.dl wp;

    public dl(Activity activity, ViewGroup viewGroup, m mVar, na naVar, String str, int i, com.bytedance.sdk.openadsdk.core.multipro.g.z zVar) {
        super(activity, viewGroup, mVar, naVar, str, i, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl.z
    protected void z(JSONObject jSONObject) {
        this.g.z((tb) this);
        try {
            jSONObject.put("isPlayable", "true");
            jSONObject.put("remainTime", gc());
        } catch (Exception e) {
            wp.z(e);
        }
    }

    private int gc() {
        return (int) (((double) (iq.gc(this.z) * this.z.kg())) / 100.0d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl.z
    protected void z(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
        this.wp = dlVar.a("fl_count_down");
    }

    private void z(MotionEvent motionEvent) {
        if (!this.m) {
            int iGz = oq.gz(zw.getContext());
            a.z("click", this.z, new fo.z().m(this.e).gc(this.gz).a(this.fo).dl(this.uy).g(this.kb).z(motionEvent.getEventTime()).dl(motionEvent.getToolType(0)).a(motionEvent.getDeviceId()).gc(this.gc).g(uy.ls().dl() ? 1 : 2).z(iGz).z(oq.m(zw.getContext())).g(oq.e(zw.getContext())).z(), this.f1346a, true, null, -1, false);
        }
        this.m = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl.z
    public void a() {
        super.a();
        m();
    }

    private void m() {
        Animation animation;
        com.bytedance.adsdk.ugeno.g.dl dlVar = this.wp;
        if (dlVar != null) {
            dlVar.g(8);
            View viewFo = this.wp.fo();
            if (viewFo == null || (animation = viewFo.getAnimation()) == null) {
                return;
            }
            animation.cancel();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.tb
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, MotionEvent motionEvent) {
        if (motionEvent == null || this.m) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.kb = motionEvent.getDownTime();
            this.e = motionEvent.getRawX();
            this.gz = motionEvent.getRawY();
            m();
            return;
        }
        if (action != 1) {
            return;
        }
        this.fo = motionEvent.getRawX();
        this.uy = motionEvent.getRawY();
        z(motionEvent);
    }
}
