package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.openadsdk.core.widget.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ti extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private e.z z;

    public static void z(com.bytedance.sdk.component.z.p pVar, e.z zVar) {
        pVar.z("UgenDownloadDialogInteraction", (com.bytedance.sdk.component.z.gc<?, ?>) new ti(zVar));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        z(jSONObject);
        return dl();
    }

    private void z(JSONObject jSONObject) {
        if (jSONObject == null || this.z == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("InteractionType");
        if (iOptInt == 1) {
            this.z.dl(null);
            return;
        }
        if (iOptInt == 2) {
            this.z.z(null);
            return;
        }
        if (iOptInt == 3) {
            this.z.z();
        } else if (iOptInt == 4) {
            this.z.g(null);
        } else {
            if (iOptInt != 5) {
                return;
            }
            this.z.a(null);
        }
    }

    public ti(e.z zVar) {
        this.z = zVar;
    }

    public JSONObject dl() {
        return new JSONObject();
    }
}
