package com.bytedance.sdk.openadsdk.core.component.reward.dl;

import android.app.Activity;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.widget.m;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends z {
    private com.bytedance.sdk.openadsdk.core.widget.m p;

    public dl(Activity activity, na naVar) {
        super(activity, naVar);
        this.p = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.z, com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z g(final uy uyVar) {
        g.z zVarG = super.g(uyVar);
        if (zVarG.dl()) {
            return zVarG;
        }
        final com.bytedance.sdk.openadsdk.core.widget.m mVar = new com.bytedance.sdk.openadsdk.core.widget.m(this.gz);
        this.p = mVar;
        mVar.z(tb.dl(this.gz, "tt_retain_gift")).z(fo()).dl("继续观看").a("坚持退出");
        this.p.z(com.bytedance.sdk.openadsdk.res.gc.fo(this.gz));
        this.p.z(new m.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.dl.dl.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.m.z
            public void z() {
                mVar.dismiss();
                uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.z();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.m.z
            public void g() {
                mVar.dismiss();
                uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.g();
                }
            }
        });
        this.p.show();
        return new g.z(true, 0, "", this.p);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public String z() {
        if ((this.z <= 0) || !this.gc) {
            return this.gc ? "忘记点击广告领取奖励啦～" : "再看" + this.z + "s可领取奖励";
        }
        return "再看" + this.z + "s，并点击一下广告可领取奖励";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public boolean g() {
        com.bytedance.sdk.openadsdk.core.widget.m mVar = this.p;
        return mVar != null && mVar.isShowing();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public void dl() {
        com.bytedance.sdk.openadsdk.core.widget.m mVar = this.p;
        if (mVar != null) {
            mVar.dismiss();
        }
    }
}
