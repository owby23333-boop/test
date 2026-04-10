package com.yuewen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes12.dex */
public class uc1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f18423b = "state";
    public static final int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vc1 f18424a;

    public void a() {
        this.f18424a = null;
    }

    public void b(vc1 vc1Var) {
        this.f18424a = vc1Var;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        vc1 vc1Var;
        String action = intent.getAction();
        qt1.a("HeadsetReceiver", "action = " + action);
        if (!"android.intent.action.HEADSET_PLUG".equals(action)) {
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                qt1.a("HeadsetReceiver", "state = " + intExtra);
                if (intExtra != 0 || (vc1Var = this.f18424a) == null) {
                    return;
                }
                vc1Var.c();
                return;
            }
            return;
        }
        if (intent.hasExtra("state")) {
            if (intent.getIntExtra("state", 0) == 0) {
                vc1 vc1Var2 = this.f18424a;
                if (vc1Var2 != null) {
                    vc1Var2.a();
                    return;
                }
                return;
            }
            vc1 vc1Var3 = this.f18424a;
            if (vc1Var3 != null) {
                vc1Var3.b();
            }
        }
    }
}
