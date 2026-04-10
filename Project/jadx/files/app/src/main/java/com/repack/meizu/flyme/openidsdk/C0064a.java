package com.repack.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import j0.a;
import j0.c;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class C0064a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        boolean z2 = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        if (intExtra == 1 || intExtra != 2) {
            z2 = true;
        } else {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
            if (stringArrayListExtra != null) {
                stringArrayListExtra.contains(context.getPackageName());
            }
        }
        if (z2) {
            a aVarA = a.a();
            String stringExtra = intent.getStringExtra("openIdType");
            aVarA.getClass();
            c cVar = "oaid".equals(stringExtra) ? aVarA.b : "vaid".equals(stringExtra) ? aVarA.f20915d : "aaid".equals(stringExtra) ? aVarA.f20914c : "udid".equals(stringExtra) ? aVarA.a : null;
            if (cVar != null) {
                cVar.a = 0L;
            }
        }
    }
}
