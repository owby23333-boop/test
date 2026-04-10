package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.embedapplog.aq;
import com.bytedance.embedapplog.rk;
import com.bytedance.embedapplog.vm;

/* JADX INFO: loaded from: classes.dex */
public class xy extends zb<vm> {
    private final Context e;

    public xy(Context context) {
        super("com.coolpad.deviceidsupport");
        this.e = context;
    }

    @Override // com.bytedance.embedapplog.zb, com.bytedance.embedapplog.rk
    public /* bridge */ /* synthetic */ boolean bf(Context context) {
        return super.bf(context);
    }

    @Override // com.bytedance.embedapplog.zb, com.bytedance.embedapplog.rk
    public rk.e d(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                rk.e eVar = new rk.e();
                eVar.bf = string;
                return eVar;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.d(context);
    }

    @Override // com.bytedance.embedapplog.zb
    public aq.bf<vm, String> e() {
        return new aq.bf<vm, String>() { // from class: com.bytedance.embedapplog.xy.1
            @Override // com.bytedance.embedapplog.aq.bf
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public vm bf(IBinder iBinder) {
                return vm.e.e(iBinder);
            }

            @Override // com.bytedance.embedapplog.aq.bf
            public String e(vm vmVar) {
                if (vmVar == null) {
                    return null;
                }
                return vmVar.bf(xy.this.e.getPackageName());
            }
        };
    }

    @Override // com.bytedance.embedapplog.zb
    public Intent e(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }
}
