package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q.v;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    na z;

    dl(na naVar) {
        this.z = naVar;
    }

    public void z(final int i, final boolean z) {
        v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.dl.1
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("render_type", Integer.valueOf(i));
                jSONObject.putOpt("is_root_container", Boolean.valueOf(z));
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().gz(dl.this.z.vk()).z("stats_easy_playable_render_start").g(jSONObject.toString());
            }
        }, "stats_easy_playable_render_start");
    }

    public void z(final int i) {
        v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.dl.2
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("render_type", Integer.valueOf(i));
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().gz(dl.this.z.vk()).z("stats_easy_playable_render_exec").g(jSONObject.toString());
            }
        }, "stats_easy_playable_render_exec");
    }

    public void g(final int i) {
        v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.dl.3
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("render_type", Integer.valueOf(i));
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().gz(dl.this.z.vk()).z("stats_easy_playable_inject_view").g(jSONObject.toString());
            }
        }, "stats_easy_playable_inject_view");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(boolean r4, java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.core.iq.na r0 = r3.z
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.iq.sy.dl(r0)
            if (r5 == 0) goto L20
            java.lang.String r1 = "render_type"
            java.lang.Object r1 = r5.get(r1)
            boolean r2 = r1 instanceof java.lang.Integer
            if (r2 == 0) goto L20
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r2 = 1
            if (r1 != r2) goto L1c
            goto L21
        L1c:
            if (r1 != 0) goto L20
            r2 = 2
            goto L21
        L20:
            r2 = -1
        L21:
            com.bytedance.sdk.openadsdk.core.iq.na r1 = r3.z
            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.uy.z(r1, r4, r0, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.dl.z(boolean, java.util.Map):void");
    }
}
