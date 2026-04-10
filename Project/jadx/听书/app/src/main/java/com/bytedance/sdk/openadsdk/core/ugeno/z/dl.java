package com.bytedance.sdk.openadsdk.core.ugeno.z;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.ugeno.express.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends a {
    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.a, com.bytedance.sdk.component.adexpress.g.a
    public int dl() {
        return 8;
    }

    public dl(Context context, na naVar, com.bytedance.sdk.openadsdk.core.ugeno.express.g gVar, ViewGroup viewGroup) {
        super(context, naVar, gVar, viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.a
    protected JSONObject z() {
        return v();
    }

    private JSONObject v() {
        try {
            return new JSONObject(z.z(this.m, this.e).z(this.m));
        } catch (Throwable th) {
            wp.z(th);
            return null;
        }
    }
}
