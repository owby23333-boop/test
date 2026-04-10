package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.umeng.analytics.pro.d;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g
public class z implements com.bytedance.sdk.component.kb.z.z.dl {

    @com.bytedance.sdk.component.kb.g.z(z = d.R)
    private Context dl;

    @com.bytedance.sdk.component.kb.g.z(z = "title")
    private String g;

    @com.bytedance.sdk.component.kb.g.z(z = "url")
    private String z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        TTDelegateActivity.a(this.dl, this.z, this.g);
        zVar.z(map2);
        return true;
    }
}
