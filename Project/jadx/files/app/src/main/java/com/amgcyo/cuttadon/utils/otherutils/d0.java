package com.amgcyo.cuttadon.utils.otherutils;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;

/* JADX INFO: compiled from: MkVibratorUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class d0 {
    private Vibrator a;

    public d0(Activity activity) {
        if (this.a == null) {
            this.a = (Vibrator) activity.getSystemService("vibrator");
        }
    }

    public void a(long j2) {
        this.a.vibrate(j2);
    }

    public d0(Context context) {
        if (this.a == null) {
            this.a = (Vibrator) context.getSystemService("vibrator");
        }
    }
}
