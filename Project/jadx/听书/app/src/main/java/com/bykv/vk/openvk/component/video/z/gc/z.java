package com.bykv.vk.openvk.component.video.z.gc;

import android.os.Build;
import android.view.View;
import com.kuaishou.weapon.p0.bi;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final int z = Build.VERSION.SDK_INT;

    public static int z(long j, long j2) {
        return Math.min(Math.max(0, j2 > 0 ? (int) (((j * 1.0d) / j2) * 100.0d) : 0), 100);
    }

    public static String z(long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = j / 60000;
        long j3 = ((j % bi.s) % 60000) / 1000;
        if (j2 >= 10) {
            sb.append(j2);
        } else if (j2 > 0) {
            sb.append(0);
            sb.append(j2);
        } else {
            sb.append("00");
        }
        sb.append(":");
        if (j3 >= 10) {
            sb.append(j3);
        } else if (j3 > 0) {
            sb.append(0);
            sb.append(j3);
        } else {
            sb.append("00");
        }
        return sb.toString();
    }

    public static void z(View view, boolean z2) {
        if (view == null) {
            return;
        }
        if (z2) {
            view.setSystemUiVisibility(0);
            return;
        }
        int i = z;
        if (i >= 19) {
            view.setSystemUiVisibility(3846);
        } else if (i >= 16) {
            view.setSystemUiVisibility(5);
        } else {
            view.setSystemUiVisibility(1);
        }
    }
}
