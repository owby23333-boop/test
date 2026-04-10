package com.bytedance.sdk.openadsdk.core.sy;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class wp {
    private static final HashMap<String, i> z = new HashMap<>();

    public static void z(na naVar) {
        dl dlVar = (dl) com.bytedance.sdk.openadsdk.ats.dl.z("pitaya");
        if (dlVar != null && dlVar.isPitayaInitSuccess() && dlVar.isPitayaEnvAvailable() && kb.g() && naVar != null && naVar.lw() != null) {
            String strAq = naVar.aq();
            String strMk = naVar.mk();
            String strA = naVar.lw().a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            i iVar = new i();
            iVar.z(1);
            iVar.z(strAq);
            iVar.g(strMk);
            z.put(strA, iVar);
        }
    }
}
