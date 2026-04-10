package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.aq;
import com.bytedance.embedapplog.ga;

/* JADX INFO: loaded from: classes.dex */
final class fy extends zb<ga> {
    public fy() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.embedapplog.zb
    public aq.bf<ga, String> e() {
        return new aq.bf<ga, String>() { // from class: com.bytedance.embedapplog.fy.1
            @Override // com.bytedance.embedapplog.aq.bf
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public ga bf(IBinder iBinder) {
                return ga.e.e(iBinder);
            }

            @Override // com.bytedance.embedapplog.aq.bf
            public String e(ga gaVar) {
                if (gaVar == null) {
                    return null;
                }
                return gaVar.d();
            }
        };
    }

    @Override // com.bytedance.embedapplog.zb
    public Intent e(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
