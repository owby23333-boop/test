package com.bytedance.sdk.openadsdk.core.io;

import android.os.SystemClock;
import com.bytedance.sdk.component.g.z.fo;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.p;
import com.bytedance.sdk.component.g.z.v;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile String g = "0";
    private static volatile long z;

    public static String z() {
        return System.currentTimeMillis() - z < 7200000 ? g : "0";
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.io.z$z, reason: collision with other inner class name */
    public static class C0180z implements fo {
        @Override // com.bytedance.sdk.component.g.z.fo
        public ls z(fo.z zVar) throws IOException {
            p pVarM;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            v vVarZ = zVar.z();
            ls lsVarZ = zVar.z(vVarZ);
            if (!"GET".equalsIgnoreCase(vVarZ.dl()) || (pVarM = lsVarZ.m()) == null) {
                return lsVarZ;
            }
            long jZ = pVarM.z();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (jElapsedRealtime2 > 0 && jZ > 10240) {
                String unused = z.g = String.format("%.2f", Double.valueOf(((jZ / 1024.0d) / jElapsedRealtime2) * 1000.0d));
                long unused2 = z.z = System.currentTimeMillis();
                String unused3 = z.g;
            }
            return lsVarZ;
        }
    }
}
