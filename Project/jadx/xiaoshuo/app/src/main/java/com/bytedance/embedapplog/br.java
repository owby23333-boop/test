package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.aq;
import com.bytedance.embedapplog.d;

/* JADX INFO: loaded from: classes.dex */
final class br extends zb<d> {
    public br() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.zb
    public aq.bf<d, String> e() {
        return new aq.bf<d, String>() { // from class: com.bytedance.embedapplog.br.1
            @Override // com.bytedance.embedapplog.aq.bf
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public d bf(IBinder iBinder) {
                return d.e.e(iBinder);
            }

            @Override // com.bytedance.embedapplog.aq.bf
            public String e(d dVar) {
                return dVar.e();
            }
        };
    }

    @Override // com.bytedance.embedapplog.zb
    public Intent e(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
