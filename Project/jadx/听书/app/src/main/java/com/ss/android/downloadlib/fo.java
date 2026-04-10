package com.ss.android.downloadlib;

import androidx.media3.session.MediaController;
import com.ss.android.downloadlib.e.i;
import com.ss.android.downloadlib.e.wp;
import com.ss.android.socialbase.appdownloader.dl.ls;

/* JADX INFO: loaded from: classes4.dex */
public class fo {
    private static boolean g = false;
    private static final String z = "fo";

    private static class z {
        private static fo z = new fo();
    }

    private fo() {
    }

    public static fo z() {
        return z.z;
    }

    public void z(com.ss.android.downloadlib.addownload.g.gc gcVar, final com.ss.android.g.z.g.g gVar) {
        if (!com.ss.android.downloadlib.e.gc.dl(gVar)) {
            wp.z().z(z, "checkMarketInstallFinishEvent", "开关未开启, 不使用动态广播监听能力");
            return;
        }
        if (gVar == null) {
            wp.z().g(z, "checkMarketInstallFinishEvent", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (gVar.f()) {
            wp.z().g(z, "checkMarketInstallFinishEvent", "正在监听中,不重复监听");
            return;
        }
        try {
            wp wpVarZ = wp.z();
            String str = z;
            wpVarZ.z(str, "checkMarketInstallFinishEvent", "针对商店直投广告,开始检测安装完成事件");
            if (com.ss.android.downloadlib.e.gc.a(gVar)) {
                wp.z().z(str, "checkMarketInstallFinishEvent", "开始进行动态广播监听");
                int iOptInt = com.ss.android.downloadlib.addownload.wp.fo().optInt("market_install_finish_check_time", 600);
                if (gVar.me() == 0 || System.currentTimeMillis() - gVar.me() > ((long) iOptInt) * 1000) {
                    gVar.uy(System.currentTimeMillis());
                    z(iOptInt, new ls() { // from class: com.ss.android.downloadlib.fo.1
                        @Override // com.ss.android.socialbase.appdownloader.dl.ls
                        public void z() {
                            wp.z().z(fo.z, "checkMarketInstallFinishEvent", "注册广播监听成功,注册耗时" + (System.currentTimeMillis() - gVar.me()));
                            gVar.uy(true);
                            com.ss.android.downloadlib.addownload.g.m.z().z(gVar);
                        }

                        @Override // com.ss.android.socialbase.appdownloader.dl.ls
                        public void g() {
                            wp.z().z(fo.z, "checkMarketInstallFinishEvent", "广播监听时间结束,主动解除了广播监听");
                            if (!i.g(gVar)) {
                                wp.z().z(fo.z, "checkMarketInstallFinishEvent", "监听结束依然没有完成安装");
                            }
                            gVar.uy(false);
                            com.ss.android.downloadlib.addownload.g.m.z().z(gVar);
                        }
                    });
                } else {
                    wp.z().z(str, "checkMarketInstallFinishEvent", "目前仍在广播监听的生效期内,不进行重复注册");
                }
            }
            if (com.ss.android.downloadlib.e.gc.gc(gVar)) {
                wp.z().z(str, "checkMarketInstallFinishEvent", "开启轮询线程能力,作为容灾手段");
                com.ss.android.downloadlib.addownload.i.z().z(gVar);
            }
            com.ss.android.downloadlib.addownload.g.fo.z().z(gVar);
        } catch (Exception unused) {
            com.ss.android.downloadlib.gc.dl.z().z(false, "监听商店场景安装完成事件发生异常");
        }
    }

    public void z(final com.ss.android.g.z.g.g gVar) {
        if (!com.ss.android.downloadlib.e.gc.dl(gVar)) {
            wp.z().z(z, "checkMarketInstallFinishEventForReboot", "线程轮询总开关未开启,因此不执行兜底逻辑");
            return;
        }
        if (gVar == null) {
            wp.z().g(z, "checkMarketInstallFinishEventForReboot", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (gVar.gc.get() && System.currentTimeMillis() - gVar.me() > MediaController.RELEASE_UNBIND_TIMEOUT_MS) {
            wp.z().z(z, "checkMarketInstallFinishEventForReboot", "兜底过一次了,不进行重复兜底");
            return;
        }
        if (com.ss.android.downloadlib.e.gc.a(gVar)) {
            long jOptInt = ((long) com.ss.android.downloadlib.addownload.wp.fo().optInt("market_install_finish_check_time", 600)) * 1000;
            if (System.currentTimeMillis() - gVar.me() >= jOptInt) {
                wp.z().z(z, "checkMarketInstallFinishEventForReboot", "当前时间距离首次检测时间超出了广播生效期,不再执行兜底策略");
            } else {
                z((int) (((gVar.me() + jOptInt) - System.currentTimeMillis()) / 1000), new ls() { // from class: com.ss.android.downloadlib.fo.2
                    @Override // com.ss.android.socialbase.appdownloader.dl.ls
                    public void z() {
                        wp.z().z(fo.z, "checkMarketInstallFinishEventForReboot", "进程被杀,重新注册广播监听成功,正式执行冷启兜底逻辑");
                        gVar.gc.compareAndSet(false, true);
                        com.ss.android.downloadlib.addownload.g.fo.z().z(gVar);
                    }

                    @Override // com.ss.android.socialbase.appdownloader.dl.ls
                    public void g() {
                        wp.z().z(fo.z, "checkMarketInstallFinishEventForReboot", "兜底监听执行完毕,解除广播监听");
                        if (!i.g(gVar)) {
                            wp.z().z(fo.z, "checkMarketInstallFinishEventForReboot", "监听结束依然没有完成安装");
                        }
                        gVar.gc.compareAndSet(true, false);
                        gVar.uy(false);
                        com.ss.android.downloadlib.addownload.g.fo.z().z(gVar);
                    }
                });
            }
        }
    }

    public void z(int i, ls lsVar) {
        wp.z().z(z, "registerMarketInstallFinishBroadcast", "动态广播监听的持续时间为:".concat(String.valueOf(i)));
        if (!g) {
            com.ss.android.socialbase.appdownloader.a.kb().z(lsVar);
            g = true;
        }
        com.ss.android.socialbase.appdownloader.a.kb().z(i);
    }
}
