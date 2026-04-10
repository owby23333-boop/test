package com.bytedance.sdk.openadsdk.core.component.reward.dl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.t;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.widget.m;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends z {
    private String fv;
    private com.bytedance.sdk.openadsdk.core.widget.m p;

    public gz(Activity activity, na naVar) {
        super(activity, naVar);
        this.p = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.z, com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z g(final uy uyVar) {
        final com.bytedance.sdk.openadsdk.core.widget.m mVar = new com.bytedance.sdk.openadsdk.core.widget.m(this.gz);
        this.p = mVar;
        z(mVar, this.f944a);
        this.p.z(new m.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.dl.gz.1
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
        return this.fv;
    }

    private void z(com.bytedance.sdk.openadsdk.core.widget.m mVar, boolean z) {
        if (iq.g(this.e)) {
            int iDa = this.e.da();
            int iZ = t.z(this.e);
            if (iDa == 0) {
                String str = "试玩时长达标才能领取奖励";
                if (iZ != 1 && !z && !this.dl) {
                    str = "试玩后才能领取奖励";
                }
                this.fv = str;
                mVar.z(tb.dl(this.gz, "tt_retain_gift")).z(fo()).dl("继续试玩").a("坚持退出");
                mVar.z(com.bytedance.sdk.openadsdk.res.gc.fo(this.gz));
                return;
            }
            if (iDa != 1) {
                if (iDa != 3) {
                    return;
                }
                this.fv = "确定退出吗?";
                if (this.gz != null) {
                    Intent intent = this.gz.getIntent();
                    this.fv = String.format("再看%s秒可得奖励", Integer.valueOf(intent != null ? intent.getIntExtra("remainTime", 0) : 0));
                }
                z(mVar, fo(), "继续观看", "坚持退出");
                mVar.z(Color.parseColor("#FC1D56"));
                return;
            }
            boolean zDl = js.dl(this.e);
            if (iZ == 0 && !zDl) {
                this.fv = "未满足奖励要求，需要继续浏览";
            } else {
                this.fv = String.format("再看%s秒可得奖励", Integer.valueOf(this.z));
            }
            if (zDl) {
                mVar.g("确定退出吗?");
                z(mVar, fo(), "继续观看", "坚持退出");
            } else {
                mVar.z(tb.dl(this.gz, "tt_reward_coin")).z(Color.parseColor("#FC1D56")).z(fo()).dl("继续观看").a("坚持退出");
                mVar.z(com.bytedance.sdk.openadsdk.res.gc.fo(this.gz));
            }
        }
    }

    private void z(com.bytedance.sdk.openadsdk.core.widget.m mVar, String str, String str2, String str3) {
        mVar.z(tb.dl(this.gz, "tt_reward_browse_multi_icon")).z(str).dl(str2).a(str3);
        mVar.z(com.bytedance.sdk.openadsdk.res.gc.mc(this.gz));
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
