package com.bytedance.sdk.openadsdk.core.component.reward.dl;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.widget.m;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends z {
    private com.bytedance.sdk.openadsdk.core.widget.m p;

    public gc(Activity activity, na naVar) {
        super(activity, naVar);
        this.p = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.z, com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z g(final uy uyVar) {
        final com.bytedance.sdk.openadsdk.core.widget.m mVar = new com.bytedance.sdk.openadsdk.core.widget.m(this.gz);
        this.p = mVar;
        mVar.z(tb.dl(this.gz, "tt_retain_gift")).z(fo()).dl("继续观看").a("坚持退出");
        mVar.z(com.bytedance.sdk.openadsdk.res.gc.i(this.gz));
        this.p.z(new m.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.dl.gc.1
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
        this.p.z(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.dl.gc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mVar.dismiss();
                uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.dl();
                }
            }
        });
        this.p.show();
        return new g.z(true, 0, "", this.p);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public String z() {
        return "继续观看" + this.z + "秒可获得奖励\n确定要退出吗？";
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
