package com.ss.android.downloadlib.addownload;

import android.os.SystemClock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class i {
    private static final String z = "i";

    private static class g {
        private static i z = new i();
    }

    private i() {
    }

    public static i z() {
        return g.z;
    }

    public void z(com.ss.android.g.z.g.g gVar) {
        com.ss.android.downloadlib.e.wp.z().z(z, "tryListenInstallFinish", "开始通过轮询线程监听安装完成事件");
        com.ss.android.downloadlib.gc.z().dl(new z(gVar));
    }

    private class z implements Runnable {
        private final com.ss.android.g.z.g.g g;

        z(com.ss.android.g.z.g.g gVar) {
            this.g = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.g.uy(true);
                    i.this.g(this.g);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            } finally {
                this.g.uy(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.ss.android.g.z.g.g gVar) {
        JSONObject jSONObject = new JSONObject();
        int iZ = com.ss.android.downloadlib.e.gc.z(gVar);
        int iG = com.ss.android.downloadlib.e.gc.g(gVar);
        if (com.ss.android.downloadlib.e.gc.gc(gVar) && com.ss.android.downloadlib.e.gc.a(gVar)) {
            com.ss.android.downloadlib.e.wp.z().z(z, "tryListenInstallFinishEvent", "上层库开启二级线程轮询检测策略");
            z(gVar, iZ, iG, jSONObject);
        } else {
            com.ss.android.downloadlib.e.wp.z().z(z, "tryListenInstallFinishEvent", "采用原有默认轮询策略");
            g(gVar, 15, 20000, jSONObject);
        }
    }

    private void z(com.ss.android.g.z.g.g gVar, int i, int i2, JSONObject jSONObject) {
        int iM;
        if (gVar.oq() == 4) {
            iM = wp.fo().optInt("market_install_finish_check_time", 600);
        } else {
            iM = com.ss.android.downloadlib.e.gc.m(gVar);
        }
        int i3 = ((iM * 1000) / 20000) + 1;
        com.ss.android.downloadlib.e.wp wpVarZ = com.ss.android.downloadlib.e.wp.z();
        String str = z;
        wpVarZ.z(str, "realListenInstallFinishEventOpt", "一级轮询次数，即广播生效期内的轮询次数为:".concat(String.valueOf(i3)));
        if (g(gVar, i3, 20000, jSONObject)) {
            return;
        }
        if (((long) iM) * 1000 < com.ss.android.downloadlib.e.gc.e(gVar)) {
            com.ss.android.downloadlib.e.wp.z().z(str, "tryListenInstallFinishEventOpt", "广播生效时间外，一级轮询完成且没有检测到安装完成事件，开始二级检测");
            if (g(gVar, i, i2, jSONObject)) {
                return;
            }
            com.ss.android.downloadlib.e.wp.z().z(str, "tryListenInstallFinishEventOpt", "监听时间结束,依然没有监听到安装完成事件");
            return;
        }
        com.ss.android.downloadlib.e.wp.z().z(str, "tryListenInstallFinishEventOpt", "一级轮询时间小于广播监听时间,且未监听到安装完成事件");
    }

    private boolean g(com.ss.android.g.z.g.g gVar, int i, int i2, JSONObject jSONObject) {
        com.ss.android.downloadlib.e.wp.z().z(z, "realListenInstallFinishEvent", "开始轮询检测,轮询时间间隔为" + i2 + ",轮询次数为" + i);
        long j = i2;
        SystemClock.sleep(j);
        while (i > 0) {
            if (com.ss.android.downloadlib.e.i.g(gVar)) {
                com.ss.android.downloadlib.z.z().z(gVar.gc());
                com.ss.android.downloadlib.e.wp.z().z(z, "realListenInstallFinishEvent", "检测到安装成功，当前剩余的轮询次数为".concat(String.valueOf(i)));
                return true;
            }
            i--;
            if (i == 0) {
                return false;
            }
            SystemClock.sleep(j);
        }
        return false;
    }
}
