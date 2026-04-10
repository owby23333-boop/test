package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.uy;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q.v;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.component.reward.g.g f969a;
    protected na dl;
    protected int e = 0;
    protected na g;
    protected com.bytedance.sdk.openadsdk.core.component.reward.g.gc gc;
    protected TTBaseVideoActivity m;
    protected boolean z;

    public dl(TTBaseVideoActivity tTBaseVideoActivity, na naVar, com.bytedance.sdk.openadsdk.core.component.reward.g.g gVar, com.bytedance.sdk.openadsdk.core.component.reward.g.gc gcVar, boolean z) {
        this.m = tTBaseVideoActivity;
        this.g = naVar;
        this.f969a = gVar;
        this.gc = gcVar;
        this.z = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void dl(View view) {
        z(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void z(View view) {
        z(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void g(View view) {
        z(3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void a(View view) {
        z(4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void gc(View view) {
        z(5);
        this.m.gz(3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void m(View view) {
        z(6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void e(View view) {
        z(7);
    }

    protected boolean z() {
        if (js.kb(this.g) || gb.g() <= 0) {
            return false;
        }
        int i = this.e;
        this.e = i + 1;
        if (i < gb.g()) {
            return false;
        }
        v.z().z(this.g, "stats_reward_full_close_force", this.m.bv().z(new JSONObject()));
        this.m.finish();
        return true;
    }

    protected void z(int i) {
        this.m.yx();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("topImpl", getClass().getName());
            jSONObject.put("topType", i);
        } catch (Throwable unused) {
        }
        v.z().z(this.g, "stats_reward_full_top_handle", jSONObject);
    }

    public void z(na naVar) {
        this.dl = naVar;
    }

    protected boolean z(uy uyVar) {
        na naVar = this.dl;
        if (naVar != null) {
            return this.m.z(naVar, uyVar);
        }
        return this.m.z(this.g, uyVar);
    }
}
