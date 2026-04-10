package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.downloadnew.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.e;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.config.je;
import com.ss.android.download.api.config.ko;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.config.lz;
import com.ss.android.download.api.config.ww;
import com.ss.android.download.api.config.x;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;
import com.ss.android.download.api.model.mb;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.mb.mb;
import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.IInstallAppHandler;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class hj {
    public static ITTDownloadVisitor b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Context f14711h;
    private static final com.ss.android.download.api.download.mb.mb ko;
    public static volatile String mb;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> f14712u;
    private static final AtomicBoolean hj = new AtomicBoolean(false);
    public static boolean ox = true;

    public static class h implements IDownloadHttpService {
        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public IDownloadHttpConnection downloadWithConnection(int i2, String str, List<HttpHeader> list) throws IOException {
            final b.mb mbVarMb = com.bytedance.sdk.openadsdk.downloadnew.b.mb(str, list);
            if (mbVarMb != null) {
                return new IDownloadHttpConnection() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.h.1
                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public void cancel() {
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
                    public void end() {
                        try {
                            mbVarMb.hj.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
                    public InputStream getInputStream() {
                        return mbVarMb.mb;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public int getResponseCode() {
                        return mbVarMb.b;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public String getResponseHeaderField(String str2) {
                        Map<String, String> map = mbVarMb.ox;
                        if (map != null) {
                            return map.get(str2);
                        }
                        return null;
                    }
                };
            }
            return null;
        }
    }

    static {
        try {
            mb = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        ko = new com.ss.android.download.api.download.mb.mb() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.6
            @Override // com.ss.android.download.api.download.mb.mb
            public void mb(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTDownloadVisitor", "completeListener: onDownloadStart");
            }

            @Override // com.ss.android.download.api.download.mb.mb
            public void ox(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTDownloadVisitor", "completeListener: onInstalled");
                hj.b(str);
            }

            @Override // com.ss.android.download.api.download.mb.mb
            public void mb(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTDownloadVisitor", "completeListener: onDownloadFinished");
            }

            @Override // com.ss.android.download.api.download.mb.mb
            public void mb(DownloadInfo downloadInfo, BaseException baseException, String str) {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTDownloadVisitor", "completeListener: onDownloadFailed");
            }

            @Override // com.ss.android.download.api.download.mb.mb
            public void mb(DownloadInfo downloadInfo) {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTDownloadVisitor", "completeListener: onCanceled");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        com.ss.android.downloadad.api.mb.ox oxVarMb;
        JSONObject jSONObjectKo;
        if (TextUtils.isEmpty(str) || (oxVarMb = u.mb().mb(str)) == null || (jSONObjectKo = oxVarMb.ko()) == null || h() == null) {
            return;
        }
        h().checkAutoControl(jSONObjectKo, str);
    }

    private static Context getContext() {
        Context context = f14711h;
        return context == null ? TTAppContextHolder.getContext() : context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ITTDownloadVisitor h() {
        ITTDownloadVisitor iTTDownloadVisitor = b;
        if (iTTDownloadVisitor != null) {
            return iTTDownloadVisitor;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            return null;
        }
        return (ITTDownloadVisitor) adManager.getExtra(ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.ox.mb(1));
    }

    private static boolean u() {
        return false;
    }

    private static class b implements lz {
        @Override // com.ss.android.download.api.config.lz
        public void mb(Activity activity, int i2, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.lz
        public void mb(Activity activity, String[] strArr, final gm gmVar) {
            if (hj.h() != null) {
                hj.h().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.b.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onDenied(String str) {
                        gm gmVar2 = gmVar;
                        if (gmVar2 != null) {
                            gmVar2.mb(str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onGranted() {
                        gm gmVar2 = gmVar;
                        if (gmVar2 != null) {
                            gmVar2.mb();
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.lz
        public boolean mb(Context context, String str) {
            if (hj.h() != null) {
                return hj.h().hasPermission(context, str);
            }
            return false;
        }
    }

    public static class mb implements ko {
        private void b(com.ss.android.download.api.model.ox oxVar) {
            if (oxVar == null) {
                return;
            }
            Object objJe = oxVar.je();
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(oxVar.ox()).setExtJson(oxVar.ww()).setMaterialMeta(objJe instanceof JSONObject ? (JSONObject) objJe : null).setLabel(oxVar.b());
            boolean z2 = EventConstants.Tag.NOTIFICATION.equals(oxVar.ox()) || EventConstants.Tag.LANDING_H5_DOWNLOAD_AD_BUTTON.equals(oxVar.ox());
            if (hj.h() != null) {
                hj.h().executeLogUpload(label, z2);
            }
        }

        @Override // com.ss.android.download.api.config.ko
        public void mb(com.ss.android.download.api.model.ox oxVar) {
            com.bytedance.sdk.openadsdk.api.mb.ox("LibEventLogger", "onV3Event");
            mb(oxVar, true);
        }

        @Override // com.ss.android.download.api.config.ko
        public void ox(com.ss.android.download.api.model.ox oxVar) {
            com.bytedance.sdk.openadsdk.api.mb.ox("LibEventLogger", "onEvent called");
            mb(oxVar, false);
            b(oxVar);
        }

        private void mb(com.ss.android.download.api.model.ox oxVar, boolean z2) {
            TTDownloadEventLogger tTDownloadEventLogger;
            if (hj.h() == null || (tTDownloadEventLogger = hj.h().getTTDownloadEventLogger()) == null || oxVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && hj.h().isOpenSdkEvent(oxVar.toString())) {
                return;
            }
            if (z2) {
                tTDownloadEventLogger.onV3Event(hj.ox(oxVar));
            } else {
                tTDownloadEventLogger.onEvent(hj.ox(oxVar));
            }
        }
    }

    public static void mb(Context context) {
        if (context == null) {
            context = TTAppContextHolder.getContext();
        }
        if (context == null || hj.get()) {
            return;
        }
        synchronized (hj.class) {
            if (!hj.get()) {
                f14711h = context.getApplicationContext();
                if (h() != null) {
                    String strInitPath = h().initPath(ox);
                    if (!TextUtils.isEmpty(strInitPath)) {
                        mb = strInitPath;
                    }
                }
                hj.set(ox(f14711h));
            }
        }
    }

    public static void ox() {
        mb().ko();
        if (h() != null) {
            h().clearAllData(mb);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.downloadnew.hj$hj, reason: collision with other inner class name */
    public static class C0309hj implements je {
        private final WeakReference<Context> mb;

        public C0309hj(Context context) {
            this.mb = new WeakReference<>(context);
        }

        private DialogBuilder b(final DownloadAlertDialogInfo downloadAlertDialogInfo) {
            return DialogBuilder.builder().setTitle(downloadAlertDialogInfo.ox).setMessage(downloadAlertDialogInfo.b).setNegativeBtnText(downloadAlertDialogInfo.f17944h).setPositiveBtnText(downloadAlertDialogInfo.hj).setIcon(downloadAlertDialogInfo.ko).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.hj.1
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    DownloadAlertDialogInfo.ox oxVar = downloadAlertDialogInfo.ww;
                    if (oxVar != null) {
                        oxVar.b(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    DownloadAlertDialogInfo.ox oxVar = downloadAlertDialogInfo.ww;
                    if (oxVar != null) {
                        try {
                            oxVar.ox(dialogInterface);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    DownloadAlertDialogInfo.ox oxVar = downloadAlertDialogInfo.ww;
                    if (oxVar != null) {
                        oxVar.mb(dialogInterface);
                    }
                }
            });
        }

        @Override // com.ss.android.download.api.config.je
        public void mb(int i2, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i3) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e2) {
                Logger.e("LibUIFactory", "showToastWithDuration e " + e2.getMessage());
            }
        }

        @Override // com.ss.android.download.api.config.je
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public AlertDialog ox(DownloadAlertDialogInfo downloadAlertDialogInfo) {
            if (downloadAlertDialogInfo != null && hj.h() != null) {
                Context context = downloadAlertDialogInfo.mb;
                if (context != null && (context instanceof Activity)) {
                    return hj.h().showDialogBySelf((Activity) downloadAlertDialogInfo.mb, downloadAlertDialogInfo.f17946x == 1, b(downloadAlertDialogInfo));
                }
                hj.h().showDialogByDelegate(this.mb, downloadAlertDialogInfo.f17946x == 1, b(downloadAlertDialogInfo));
            }
            return null;
        }
    }

    private static class ox implements ww {
        private ox() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
        @Override // com.ss.android.download.api.config.ww
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mb(java.lang.String r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.Object> r7, final com.ss.android.download.api.config.l r8) {
            /*
                r4 = this;
                int r0 = r5.hashCode()
                r1 = 70454(0x11336, float:9.8727E-41)
                r2 = 1
                r3 = 0
                if (r0 == r1) goto L1b
                r1 = 2461856(0x2590a0, float:3.449795E-39)
                if (r0 == r1) goto L11
                goto L25
            L11:
                java.lang.String r0 = "POST"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L25
                r5 = 1
                goto L26
            L1b:
                java.lang.String r0 = "GET"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L25
                r5 = 0
                goto L26
            L25:
                r5 = -1
            L26:
                if (r5 == 0) goto L2c
                if (r5 == r2) goto L2b
                goto L2c
            L2b:
                r3 = 1
            L2c:
                com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor r5 = com.bytedance.sdk.openadsdk.downloadnew.hj.hj()
                if (r5 == 0) goto L3e
                com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor r5 = com.bytedance.sdk.openadsdk.downloadnew.hj.hj()
                com.bytedance.sdk.openadsdk.downloadnew.hj$ox$1 r0 = new com.bytedance.sdk.openadsdk.downloadnew.hj$ox$1
                r0.<init>()
                r5.execute(r3, r6, r7, r0)
            L3e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.hj.ox.mb(java.lang.String, java.lang.String, java.util.Map, com.ss.android.download.api.config.l):void");
        }

        @Override // com.ss.android.download.api.config.ww
        public void mb(String str, byte[] bArr, String str2, int i2, final l lVar) {
            if (hj.h() != null) {
                hj.h().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.ox.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        l lVar2 = lVar;
                        if (lVar2 != null) {
                            lVar2.mb(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        l lVar2 = lVar;
                        if (lVar2 != null) {
                            lVar2.mb(str3);
                        }
                    }
                });
            }
        }
    }

    private static boolean ox(Context context) {
        com.ss.android.download.api.mb mbVarMb;
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (u()) {
            try {
                mbVarMb = com.ss.android.downloadlib.ww.mb(applicationContext).mb(AdBaseConstants.DownloadConfigureName.PANGOLIN);
            } catch (Throwable unused) {
                mbVarMb = com.ss.android.downloadlib.ww.mb(applicationContext).mb();
            }
        } else {
            mbVarMb = com.ss.android.downloadlib.ww.mb(applicationContext).mb();
        }
        if (mbVarMb == null) {
            return false;
        }
        mbVarMb.mb(new b()).mb(new mb()).mb(new C0309hj(applicationContext)).mb(new ox()).mb(new x() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.3
            @Override // com.ss.android.download.api.config.x
            public JSONObject mb() {
                return hj.h() != null ? hj.h().getDownloadSettings() : new JSONObject();
            }
        }).mb(new com.ss.android.download.api.config.ox() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.2
            @Override // com.ss.android.download.api.config.ox
            public boolean mb() {
                if (hj.h() != null) {
                    return hj.h().getAppIsBackground();
                }
                return false;
            }
        }).mb(new mb.C0509mb().ox("143").mb(TTAdConstant.APP_NAME).b("5.1.0.2").hj(String.valueOf(5102)).mb()).mb(new e() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.1
            @Override // com.ss.android.download.api.config.e
            public byte[] mb(byte[] bArr, int i2) {
                return new byte[0];
            }
        }).mb(packageName + ".TTFileProvider").mb(mb(applicationContext, h() != null ? h().getDownloadSettings() : new JSONObject())).mb();
        com.ss.android.downloadlib.utils.mb.mb();
        com.ss.android.downloadlib.ww.mb(applicationContext).hj().mb(1);
        com.ss.android.downloadlib.ww.mb(applicationContext).mb(ko);
        com.ss.android.socialbase.appdownloader.hj.x().mb(new IInstallAppHandler() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.4
            @Override // com.ss.android.socialbase.downloader.depend.IInstallAppHandler
            public boolean installApp(Intent intent) {
                return false;
            }
        });
        TTDownloadEventLogger tTDownloadEventLogger = h().getTTDownloadEventLogger();
        if (tTDownloadEventLogger != null) {
            tTDownloadEventLogger.onDownloadConfigReady();
        }
        return true;
    }

    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> b() {
        return f14712u;
    }

    public static void mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mb = str;
    }

    public static com.ss.android.downloadlib.ww mb() {
        mb(getContext());
        return com.ss.android.downloadlib.ww.mb(getContext());
    }

    public static boolean mb(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return mb().h().mb(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean mb(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return mb().h().mb(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean mb(Uri uri) {
        return com.ss.android.downloadlib.ox.x.mb(uri);
    }

    public static void mb(int i2) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map = f14712u;
        if (map != null) {
            map.remove(Integer.valueOf(i2));
        }
    }

    public static void mb(int i2, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (f14712u == null) {
                f14712u = Collections.synchronizedMap(new WeakHashMap());
            }
            f14712u.put(Integer.valueOf(i2), onEventLogHandler);
        }
    }

    public static boolean mb(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> mapB;
        boolean z2 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (mapB = b()) != null) {
            for (Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> entry : mapB.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                ITTDownloadAdapter.OnEventLogHandler value = entry.getValue();
                if (value != null) {
                    boolean zOnEventLog = value.onEventLog(iIntValue, jSONObject.toString(), str, str2, obj);
                    if (!z2 && !zOnEventLog) {
                        z2 = true;
                    }
                }
            }
        }
        return z2;
    }

    private static DownloaderBuilder mb(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new IDownloadSettings() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.5
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadSettings
            public JSONObject get() {
                return hj.h() != null ? hj.h().getDownloadSettings() : new JSONObject();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject ox(com.ss.android.download.api.model.ox oxVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", oxVar.mb());
            jSONObject.put("tag", oxVar.ox());
            jSONObject.put("label", oxVar.b());
            jSONObject.put("isAd", oxVar.hj());
            jSONObject.put("adId", oxVar.h());
            jSONObject.put(TTDownloadField.TT_LOG_EXTRA, oxVar.u());
            jSONObject.put("extValue", oxVar.ko());
            jSONObject.put("extJson", oxVar.ww());
            jSONObject.put("paramsJson", oxVar.lz());
            jSONObject.put("eventSource", oxVar.jb());
            jSONObject.put("extraObject", oxVar.je());
            jSONObject.put("clickTrackUrl", oxVar.x());
            jSONObject.put("isV3", oxVar.nk());
            jSONObject.put("V3EventName", oxVar.o());
            jSONObject.put("V3EventParams", oxVar.lc());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean mb(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> listOx = com.ss.android.socialbase.appdownloader.hj.x().ox(context);
            if (!listOx.isEmpty()) {
                for (DownloadInfo downloadInfo : listOx) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean mb(Activity activity, final ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.mb.mb.mb().mb(activity, false, new mb.InterfaceC0510mb() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.7
            @Override // com.ss.android.downloadlib.addownload.mb.mb.InterfaceC0510mb
            public void mb() {
                ExitInstallListener exitInstallListener2 = exitInstallListener;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }
}
