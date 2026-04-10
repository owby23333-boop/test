package com.bytedance.sdk.openadsdk.core.kb;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    public static com.bytedance.sdk.openadsdk.core.kb.g.dl z(Context context, na naVar, String str, boolean z) {
        return new com.bytedance.sdk.openadsdk.core.kb.dl.e(context, naVar, str, z);
    }

    public static com.bytedance.sdk.openadsdk.core.kb.g.a g(Context context, na naVar, String str, boolean z) {
        if (eo.g(context)) {
            return new com.bytedance.sdk.openadsdk.core.kb.dl.a(context, naVar, str, z);
        }
        return new com.bytedance.sdk.openadsdk.core.kb.dl.z(context, naVar, str, z);
    }

    public static com.bytedance.sdk.openadsdk.core.kb.g.dl z(Context context, String str, na naVar, String str2) {
        return new com.bytedance.sdk.openadsdk.core.kb.dl.fo(context, str, naVar, str2, eo.iq(naVar));
    }
}
