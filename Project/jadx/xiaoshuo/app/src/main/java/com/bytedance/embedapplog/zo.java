package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.aq;
import com.bytedance.embedapplog.tg;

/* JADX INFO: loaded from: classes.dex */
final class zo extends zb<tg> {
    public zo() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.zb
    public aq.bf<tg, String> e() {
        return new aq.bf<tg, String>() { // from class: com.bytedance.embedapplog.zo.1
            @Override // com.bytedance.embedapplog.aq.bf
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public tg bf(IBinder iBinder) {
                return tg.e.e(iBinder);
            }

            @Override // com.bytedance.embedapplog.aq.bf
            public String e(tg tgVar) {
                if (tgVar == null) {
                    return null;
                }
                return tgVar.e();
            }
        };
    }

    @Override // com.bytedance.embedapplog.zb
    public Intent e(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
