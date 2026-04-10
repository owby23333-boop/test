package com.bytedance.sdk.openadsdk.core.component.reward.business.g.z;

import android.app.Activity;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.uy;
import com.bytedance.sdk.openadsdk.core.iq.gp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.widget.m;
import com.bytedance.sdk.openadsdk.res.gc;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    private m g;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public String z() {
        return "恭喜您已经获得奖励，是否要继续观看视频，再得超值奖励";
    }

    public g(Activity activity, na naVar) {
        super(activity, naVar);
        this.g = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.z, com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z z(final uy uyVar) {
        g.z zVarZ = super.z(uyVar);
        if (zVarZ.dl()) {
            return zVarZ;
        }
        final m mVar = new m(this.gz);
        this.g = mVar;
        mVar.z(tb.dl(this.gz, "tt_retain_gift")).z(z()).dl(gp.z(this.e, this.kb, this.wp)).a("坚持退出");
        mVar.z(gc.fo(this.gz));
        this.g.z(new m.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.g.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.m.z
            public void z() {
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
        this.g.show();
        return new g.z(true, 0, "", this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public boolean g() {
        m mVar = this.g;
        return mVar != null && mVar.isShowing();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public void dl() {
        m mVar = this.g;
        if (mVar != null) {
            mVar.dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public void a() {
        m mVar = this.g;
        if (mVar != null) {
            mVar.z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public void gc() {
        m mVar = this.g;
        if (mVar != null) {
            mVar.g();
        }
    }
}
