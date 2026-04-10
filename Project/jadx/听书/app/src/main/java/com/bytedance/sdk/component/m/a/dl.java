package com.bytedance.sdk.component.m.a;

import android.text.TextUtils;
import com.bytedance.sdk.component.m.fv;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends z {
    @Override // com.bytedance.sdk.component.m.a.fo
    public String z() {
        return "generate_key";
    }

    @Override // com.bytedance.sdk.component.m.a.fo
    public void z(com.bytedance.sdk.component.m.dl.dl dlVar) {
        if (TextUtils.isEmpty(dlVar.getMemoryCacheKey())) {
            fv fvVarGc = dlVar.wp().gc();
            dlVar.g(fvVarGc.z(dlVar));
            dlVar.z(fvVarGc.g(dlVar));
        }
        dlVar.z(new e());
    }
}
