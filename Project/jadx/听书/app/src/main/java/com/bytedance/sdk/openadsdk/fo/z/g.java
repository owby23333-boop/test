package com.bytedance.sdk.openadsdk.fo.z;

import com.bytedance.sdk.component.z.a;
import com.bytedance.sdk.component.z.p;
import com.bytedance.sdk.openadsdk.core.mc;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends com.bytedance.sdk.component.z.a<JSONObject, JSONObject> {
    private static WeakReference<z> z;
    private WeakReference<mc> g;

    public interface z {
        void z();

        void z(int i);
    }

    @Override // com.bytedance.sdk.component.z.a
    protected void a() {
    }

    private g(mc mcVar) {
        this.g = new WeakReference<>(mcVar);
    }

    public static void z(p pVar, final mc mcVar) {
        pVar.z("onClickBrowseCloseCallback", new a.g() { // from class: com.bytedance.sdk.openadsdk.fo.z.g.1
            @Override // com.bytedance.sdk.component.z.a.g
            public com.bytedance.sdk.component.z.a z() {
                return new g(mcVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.z.a
    public void z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        WeakReference<z> weakReference = z;
        z zVar = weakReference != null ? weakReference.get() : null;
        if (this.g == null || jSONObject == null) {
            if (zVar != null) {
                zVar.z();
                return;
            }
            return;
        }
        int iOptInt = jSONObject.optInt("remainTime", Integer.MIN_VALUE);
        if (iOptInt == Integer.MIN_VALUE) {
            if (zVar != null) {
                zVar.z();
            }
        } else if (zVar != null) {
            zVar.z(iOptInt);
        }
    }

    public static void z(z zVar) {
        z = new WeakReference<>(zVar);
    }
}
