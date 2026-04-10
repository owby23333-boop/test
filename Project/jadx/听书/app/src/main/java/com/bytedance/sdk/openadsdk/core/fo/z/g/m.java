package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.umeng.analytics.pro.d;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g
public class m implements com.bytedance.sdk.component.kb.z.z.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.bytedance.sdk.component.kb.g.z(z = "material_meta")
    private na f1051a;

    @com.bytedance.sdk.component.kb.g.z(z = d.R)
    private Context dl;

    @com.bytedance.sdk.component.kb.g.z(z = "ad_dislike")
    private com.bytedance.sdk.openadsdk.core.dislike.ui.z g;

    @com.bytedance.sdk.component.kb.g.z(z = "outer_dislike")
    private Dialog z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        Dialog dialog = this.z;
        if (dialog != null) {
            dialog.show();
            zVar.z(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar2 = this.g;
        if (zVar2 != null) {
            zVar2.z();
            zVar.z(map2);
            return true;
        }
        TTDelegateActivity.z(this.dl, this.f1051a);
        zVar.z(map2);
        return true;
    }
}
