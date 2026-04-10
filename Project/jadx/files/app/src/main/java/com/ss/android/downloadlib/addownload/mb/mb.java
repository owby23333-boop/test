package com.ss.android.downloadlib.addownload.mb;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.je;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.downloadlib.ww;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mb {
    private static final String mb = "mb";
    private static mb ox;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f18001h;
    private boolean hj = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ox f18002u = new ox();

    @NonNull
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.model.mb> b = this.f18002u.mb("sp_ad_install_back_dialog", "key_uninstalled_list");

    /* JADX INFO: renamed from: com.ss.android.downloadlib.addownload.mb.mb$mb, reason: collision with other inner class name */
    public interface InterfaceC0510mb {
        void mb();
    }

    private mb() {
    }

    public static mb mb() {
        if (ox == null) {
            ox = new mb();
        }
        return ox;
    }

    public void ox(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f18001h = "";
        } else if (TextUtils.equals(this.f18001h, str)) {
            this.f18001h = "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051 A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:21:0x0051, B:22:0x005e, B:23:0x006a, B:25:0x0070, B:28:0x0079, B:30:0x0085, B:33:0x008e, B:35:0x009d, B:38:0x00c3, B:36:0x00a1), top: B:42:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070 A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:21:0x0051, B:22:0x005e, B:23:0x006a, B:25:0x0070, B:28:0x0079, B:30:0x0085, B:33:0x008e, B:35:0x009d, B:38:0x00c3, B:36:0x00a1), top: B:42:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean mb(android.app.Activity r22, com.ss.android.socialbase.downloader.model.DownloadInfo r23, boolean r24, com.ss.android.downloadlib.addownload.mb.mb.InterfaceC0510mb r25) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.mb.mb.mb(android.app.Activity, com.ss.android.socialbase.downloader.model.DownloadInfo, boolean, com.ss.android.downloadlib.addownload.mb.mb$mb):boolean");
    }

    @MainThread
    public boolean mb(Activity activity, boolean z2, InterfaceC0510mb interfaceC0510mb) {
        if (x.lz().optInt("disable_install_app_dialog") == 1 || this.hj) {
            return false;
        }
        return mb(activity, mb(activity), z2, interfaceC0510mb);
    }

    public void mb(Context context, com.ss.android.downloadlib.addownload.model.mb mbVar, boolean z2, InterfaceC0510mb interfaceC0510mb) {
        this.b.clear();
        mb(context, mbVar, interfaceC0510mb, z2);
        this.hj = true;
        ww.mb(context).b();
        this.f18002u.ox("sp_ad_install_back_dialog", "key_uninstalled_list");
        com.ss.android.downloadlib.utils.x.mb(mb, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo mb(Context context) {
        long jOx;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            jOx = ww.mb(context).ox();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (x.lz().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK)) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j2 = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !jb.hj(context, downloadInfo2.getPackageName()) && jb.mb(downloadInfo2.getTargetFilePath())) {
                    long jLastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (jLastModified >= jOx && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j2 == 0 || jLastModified > j2)) {
                                downloadInfo = downloadInfo2;
                                j2 = jLastModified;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void mb(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            com.ss.android.downloadlib.addownload.model.mb mbVar = this.b.get(i2);
            if (mbVar != null && mbVar.ox == j3) {
                this.b.set(i2, new com.ss.android.downloadlib.addownload.model.mb(j2, j3, j4, str, str2, str3, str4));
                this.f18002u.mb("sp_ad_install_back_dialog", "key_uninstalled_list", this.b);
                return;
            }
        }
        this.b.add(new com.ss.android.downloadlib.addownload.model.mb(j2, j3, j4, str, str2, str3, str4));
        this.f18002u.mb("sp_ad_install_back_dialog", "key_uninstalled_list", this.b);
    }

    private void mb(final Context context, final com.ss.android.downloadlib.addownload.model.mb mbVar, final InterfaceC0510mb interfaceC0510mb, boolean z2) {
        final com.ss.android.downloadad.api.mb.ox oxVarHj = u.mb().hj(mbVar.ox);
        if (oxVarHj == null) {
            com.ss.android.downloadlib.exception.b.mb().mb("showBackInstallDialog nativeModel null");
            return;
        }
        je jeVarB = x.b();
        DownloadAlertDialogInfo.mb mbVarMb = new DownloadAlertDialogInfo.mb(context).mb(z2 ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(mbVar.f18009h) ? "刚刚下载的应用" : mbVar.f18009h;
        jeVarB.ox(mbVarMb.ox(String.format("%1$s下载完成，是否立即安装？", objArr)).b("立即安装").hj(z2 ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).mb(false).mb(jb.mb(context, mbVar.ko)).mb(new DownloadAlertDialogInfo.ox() { // from class: com.ss.android.downloadlib.addownload.mb.mb.1
            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void b(DialogInterface dialogInterface) {
                mb.this.ox("");
            }

            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void mb(DialogInterface dialogInterface) {
                AdEventHandler.mb().ox(EventConstants.Label.BACK_DIALOG_INSTALL, oxVarHj);
                com.ss.android.socialbase.appdownloader.hj.mb(context, (int) mbVar.mb);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void ox(DialogInterface dialogInterface) {
                AdEventHandler.mb().ox(EventConstants.Label.BACK_DIALOG_EXIT, oxVarHj);
                InterfaceC0510mb interfaceC0510mb2 = interfaceC0510mb;
                if (interfaceC0510mb2 != null) {
                    interfaceC0510mb2.mb();
                }
                mb.this.ox("");
                dialogInterface.dismiss();
            }
        }).mb(1).mb());
        AdEventHandler.mb().ox(EventConstants.Label.BACK_DIALOG_SHOW, oxVarHj);
        this.f18001h = mbVar.hj;
    }

    public boolean mb(String str) {
        return TextUtils.equals(this.f18001h, str);
    }

    public void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        if (x.lz().optInt("enable_open_app_dialog", 0) == 1 && !oxVar.cd() && oxVar.e()) {
            oxVar.jb(true);
            TTDelegateActivity.mb(oxVar);
        }
    }
}
