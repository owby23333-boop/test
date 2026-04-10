package com.ss.android.z.z.z;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import com.ss.android.z.z.g.uy;
import com.ss.android.z.z.g.zw;

/* JADX INFO: loaded from: classes4.dex */
public class g implements uy {
    private zw z;

    @Override // com.ss.android.z.z.g.uy
    public void z(Activity activity, String[] strArr, zw zwVar) {
        this.z = zwVar;
        activity.requestPermissions(strArr, 1);
    }

    @Override // com.ss.android.z.z.g.uy
    public boolean z(Context context, String str) {
        return (context == null || str == null || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) ? false : true;
    }

    @Override // com.ss.android.z.z.g.uy
    public void z(Activity activity, int i, String[] strArr, int[] iArr) {
        zw zwVar;
        if (iArr.length <= 0 || (zwVar = this.z) == null) {
            return;
        }
        int i2 = iArr[0];
        if (i2 == -1) {
            zwVar.z(strArr[0]);
        } else if (i2 == 0) {
            zwVar.z();
        }
    }
}
