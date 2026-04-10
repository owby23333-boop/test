package com.ss.android.downloadlib.addownload.z;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.g.m;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import com.ss.android.downloadlib.e.kb;
import com.ss.android.downloadlib.uy;
import com.ss.android.socialbase.downloader.downloader.e;
import com.ss.android.z.z.g.v;
import com.ss.android.z.z.gc.dl;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z {
    private static z g = null;
    private static final String z = "z";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2000a = false;
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.g.z> dl;
    private String gc;
    private g m;

    /* JADX INFO: renamed from: com.ss.android.downloadlib.addownload.z.z$z, reason: collision with other inner class name */
    public interface InterfaceC0441z {
        void z();
    }

    private z() {
        g gVar = new g();
        this.m = gVar;
        this.dl = gVar.z("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static z z() {
        if (g == null) {
            g = new z();
        }
        return g;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:20:0x004f, B:22:0x005f, B:23:0x0069, B:25:0x006f, B:27:0x0077, B:29:0x0083, B:31:0x008b, B:33:0x009a, B:36:0x00c0, B:34:0x009e), top: B:40:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006f A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:20:0x004f, B:22:0x005f, B:23:0x0069, B:25:0x006f, B:27:0x0077, B:29:0x0083, B:31:0x008b, B:33:0x009a, B:36:0x00c0, B:34:0x009e), top: B:40:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean z(android.app.Activity r22, com.ss.android.socialbase.downloader.e.dl r23, boolean r24, com.ss.android.downloadlib.addownload.z.z.InterfaceC0441z r25) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.z.z.z(android.app.Activity, com.ss.android.socialbase.downloader.e.dl, boolean, com.ss.android.downloadlib.addownload.z.z$z):boolean");
    }

    public boolean z(Activity activity, boolean z2, InterfaceC0441z interfaceC0441z) {
        if (wp.fo().optInt("disable_install_app_dialog") == 1 || this.f2000a) {
            return false;
        }
        return z(activity, z(activity), z2, interfaceC0441z);
    }

    public void z(Context context, com.ss.android.downloadlib.addownload.g.z zVar, boolean z2, InterfaceC0441z interfaceC0441z) {
        this.dl.clear();
        z(context, zVar, interfaceC0441z, z2);
        this.f2000a = true;
        uy.z(context).dl();
        this.m.g("sp_ad_install_back_dialog", "key_uninstalled_list");
        kb.z(z, "tryShowInstallDialog isShow:true", null);
    }

    public com.ss.android.socialbase.downloader.e.dl z(Context context) {
        long jG;
        List<com.ss.android.socialbase.downloader.e.dl> listG;
        com.ss.android.socialbase.downloader.e.dl dlVar = null;
        try {
            jG = uy.z(context).g();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        if (wp.fo().optInt("enable_miniapp_dialog", 0) != 0 && (listG = e.g(context).g("application/vnd.android.package-archive")) != null && !listG.isEmpty()) {
            long j = 0;
            for (com.ss.android.socialbase.downloader.e.dl dlVar2 : listG) {
                if (dlVar2 != null && !i.gc(context, dlVar2.x()) && i.z(dlVar2.v())) {
                    long jLastModified = new File(dlVar2.v()).lastModified();
                    if (jLastModified >= jG && dlVar2.gk() != null) {
                        try {
                            if (new JSONObject(dlVar2.gk()).has("isMiniApp") && (j == 0 || jLastModified > j)) {
                                dlVar = dlVar2;
                                j = jLastModified;
                            }
                        } catch (Exception e2) {
                            com.bytedance.sdk.component.utils.wp.z(e2);
                        }
                    }
                }
            }
            return dlVar;
        }
        return null;
    }

    public void z(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i = 0; i < this.dl.size(); i++) {
            com.ss.android.downloadlib.addownload.g.z zVar = this.dl.get(i);
            if (zVar != null && zVar.g == j2) {
                this.dl.set(i, new com.ss.android.downloadlib.addownload.g.z(j, j2, j3, str, str2, str3, str4));
                this.m.z("sp_ad_install_back_dialog", "key_uninstalled_list", this.dl);
                return;
            }
        }
        this.dl.add(new com.ss.android.downloadlib.addownload.g.z(j, j2, j3, str, str2, str3, str4));
        this.m.z("sp_ad_install_back_dialog", "key_uninstalled_list", this.dl);
    }

    private void z(final Context context, final com.ss.android.downloadlib.addownload.g.z zVar, final InterfaceC0441z interfaceC0441z, boolean z2) {
        final com.ss.android.g.z.g.g gVarA = m.z().a(zVar.g);
        if (gVarA == null) {
            com.ss.android.downloadlib.gc.dl.z().z("showBackInstallDialog nativeModel null");
            return;
        }
        v vVarDl = wp.dl();
        dl.z zVarZ = new dl.z(context).z(z2 ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(zVar.gc) ? "刚刚下载的应用" : zVar.gc;
        vVarDl.g(zVarZ.g(String.format("%1$s下载完成，是否立即安装？", objArr)).dl("立即安装").a(z2 ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).z(false).z(i.z(context, zVar.e)).z(new dl.g() { // from class: com.ss.android.downloadlib.addownload.z.z.1
            @Override // com.ss.android.z.z.gc.dl.g
            public void z(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.a.z.z().g("backdialog_install", gVarA);
                com.ss.android.socialbase.appdownloader.a.z(context, (int) zVar.z);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.z.z.gc.dl.g
            public void g(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.a.z.z().g("backdialog_exit", gVarA);
                InterfaceC0441z interfaceC0441z2 = interfaceC0441z;
                if (interfaceC0441z2 != null) {
                    interfaceC0441z2.z();
                }
                z.this.g("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.z.z.gc.dl.g
            public void dl(DialogInterface dialogInterface) {
                z.this.g("");
            }
        }).z(1).z());
        com.ss.android.downloadlib.a.z.z().g("backdialog_show", gVarA);
        this.gc = zVar.f1989a;
    }

    public boolean z(String str) {
        return TextUtils.equals(this.gc, str);
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            this.gc = "";
        } else if (TextUtils.equals(this.gc, str)) {
            this.gc = "";
        }
    }

    public void z(com.ss.android.g.z.g.g gVar) {
        if (wp.fo().optInt("enable_open_app_dialog", 0) == 1 && !gVar.yx() && gVar.p() && Build.VERSION.SDK_INT < 34) {
            gVar.kb(true);
            TTDelegateActivity.z(gVar);
        }
    }
}
