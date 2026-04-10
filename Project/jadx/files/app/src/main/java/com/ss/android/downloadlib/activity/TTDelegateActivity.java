package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;
import com.ss.android.downloadad.api.mb.ox;
import com.ss.android.downloadlib.addownload.je;
import com.ss.android.downloadlib.addownload.mb.hj;
import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.exception.b;
import com.ss.android.downloadlib.guide.install.mb;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.downloadlib.utils.ko;
import com.ss.android.downloadlib.utils.lz;
import com.ss.android.downloadlib.ww;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static mb hj;
    private ox b;
    protected Intent mb = null;
    private boolean ox;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IntentType {
        public static final int AD_LP_APPINFO_DIALOG = 10;
        public static final int APK_INSTALL = 9;
        public static final int APK_SIZE_RETAIN = 8;
        public static final int DOWNLOAD_PERCENT_RETAIN = 7;
        public static final int INSTALL_GUIDE = 6;
        public static final int INTENT_CLEAN_DISK_SPACE = 3;
        public static final int OPEN_APP_DIALOG = 4;
        public static final int OPEN_URL = 2;
        public static final int OPEN_V1_MARKET = 12;
        public static final int PACKAGE_NAME = 11;
        public static final int REQUEST_PERMISSION = 1;
        public static final int REVERSE_WIFI_DIALOG = 5;
    }

    private static Intent b(@NonNull com.ss.android.downloadad.api.mb.mb mbVar) {
        return new Intent(x.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    private void hj(long j2) {
        new com.ss.android.downloadlib.addownload.compliance.mb(this, j2).show();
    }

    public static void mb(String str, String[] strArr) {
        Intent intent = new Intent(x.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("type", 1);
        intent.putExtra(com.bytedance.msdk.api.activity.TTDelegateActivity.PERMISSION_ID_KEY, str);
        intent.putExtra(com.bytedance.msdk.api.activity.TTDelegateActivity.PERMISSION_CONTENT_KEY, strArr);
        if (x.getContext() != null) {
            x.getContext().startActivity(intent);
        }
    }

    public static void ox(String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        Intent intentB = b(mbVar);
        intentB.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intentB.putExtra("type", 11);
        intentB.putExtra("package_name", str);
        if (x.getContext() != null) {
            x.getContext().startActivity(intentB);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ox();
        this.mb = getIntent();
        x.ox(this);
        mb();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.mb = intent;
        x.ox(this);
        mb();
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        x.h().mb(this, i2, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onStop() {
        DownloadInfo downloadInfoOx;
        super.onStop();
        if (!this.ox || this.b == null || (downloadInfoOx = ww.mb((Context) null).ox(this.b.mb())) == null || downloadInfoOx.getCurBytes() < downloadInfoOx.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    private void b() {
        String str;
        long longExtra = this.mb.getLongExtra(EventConstants.ExtraJson.MODEL_ID, 0L);
        String stringExtra = this.mb.getStringExtra("message_text");
        String stringExtra2 = this.mb.getStringExtra("positive_button_text");
        String stringExtra3 = this.mb.getStringExtra("negative_button_text");
        int intExtra = this.mb.getIntExtra("type", 0);
        ox oxVarHj = u.mb().hj(longExtra);
        hj.mb mbVarB = new hj.mb(this).mb(false).mb(stringExtra).ox(stringExtra2).b(stringExtra3);
        if (intExtra == 7) {
            if (com.ss.android.downloadlib.addownload.b.ox.mb() == null) {
                return;
            }
            mbVarB.mb(com.ss.android.downloadlib.addownload.b.ox.mb());
            mbVarB.mb().show();
            str = "download_percent";
        } else if (intExtra != 8) {
            str = "";
        } else {
            if (com.ss.android.downloadlib.addownload.b.mb.mb() == null) {
                return;
            }
            mbVarB.mb(com.ss.android.downloadlib.addownload.b.mb.mb());
            mbVarB.mb().show();
            str = EventConstants.ExtraJson.APK_SIZE;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ox = true;
        this.b = oxVarHj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, str);
            jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_ACTION, "show_dialog");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_OPTIMISE, jSONObject, oxVarHj);
    }

    public static void ox(@NonNull com.ss.android.downloadad.api.mb.mb mbVar) {
        mb(mbVar, 5, "", "", "");
    }

    public static void mb(String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        Intent intentB = b(mbVar);
        intentB.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intentB.putExtra("type", 2);
        intentB.putExtra(EventConstants.ExtraJson.OPEN_URL, str);
        if (x.getContext() != null) {
            x.getContext().startActivity(intentB);
        }
    }

    public static void ox(@NonNull com.ss.android.downloadad.api.mb.mb mbVar, String str, String str2, String str3) {
        mb(mbVar, 7, str, str2, str3);
    }

    private void ox() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void ox(long j2) {
        if (je.mb() == null) {
            return;
        }
        ox oxVarHj = u.mb().hj(j2);
        if (oxVarHj != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(oxVarHj.m());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.TIME_AFTER_CLICK, Long.valueOf(System.currentTimeMillis() - oxVarHj.sa()));
                jSONObject.putOpt(EventConstants.ExtraJson.CLICK_DOWNLOAD_SIZE, Long.valueOf(oxVarHj.sr()));
                if (downloadInfo != null) {
                    jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_LENGTH, Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_APK_SIZE, Long.valueOf(downloadInfo.getTotalBytes()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            AdEventHandler.mb().ox(EventConstants.Label.PAUSE_RESERVE_WIFI_DIALOG_SHOW, jSONObject, oxVarHj);
        }
        new hj.mb(this).mb(false).mb(je.mb()).mb().show();
        this.ox = true;
        this.b = oxVarHj;
    }

    public static void mb(com.ss.android.downloadad.api.mb.mb mbVar) {
        Intent intentB = b(mbVar);
        intentB.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intentB.putExtra("type", 4);
        intentB.putExtra(EventConstants.ExtraJson.MODEL_ID, mbVar.ox());
        if (x.getContext() != null) {
            x.getContext().startActivity(intentB);
        }
    }

    public static void mb(com.ss.android.downloadad.api.mb.mb mbVar, mb mbVar2) {
        Intent intentB = b(mbVar);
        intentB.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intentB.putExtra("type", 9);
        hj = mbVar2;
        if (x.getContext() != null) {
            x.getContext().startActivity(intentB);
        }
    }

    public static void mb(long j2) {
        Intent intent = new Intent(x.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j2);
        if (x.getContext() != null) {
            x.getContext().startActivity(intent);
        }
    }

    private void b(long j2) {
        final ox oxVarHj = u.mb().hj(j2);
        if (oxVarHj == null) {
            b.mb().mb("showOpenAppDialogInner nativeModel null");
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
            return;
        }
        com.ss.android.download.api.config.je jeVarB = x.b();
        DownloadAlertDialogInfo.mb mbVarMb = new DownloadAlertDialogInfo.mb(this).mb("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(oxVarHj.pa()) ? "刚刚下载的应用" : oxVarHj.pa();
        jeVarB.ox(mbVarMb.ox(String.format("%1$s已安装完成，是否立即打开？", objArr)).b("打开").hj("取消").mb(false).mb(jb.b(this, oxVarHj.h())).mb(new DownloadAlertDialogInfo.ox() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void b(DialogInterface dialogInterface) {
                com.ss.android.socialbase.appdownloader.b.mb((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void mb(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.ox.mb.ox(oxVarHj);
                dialogInterface.dismiss();
                com.ss.android.socialbase.appdownloader.b.mb((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void ox(DialogInterface dialogInterface) {
                AdEventHandler.mb().ox(EventConstants.Label.OPEN_APP_DIALOG_CANCEL, oxVarHj);
                dialogInterface.dismiss();
                com.ss.android.socialbase.appdownloader.b.mb((Activity) TTDelegateActivity.this);
            }
        }).mb(2).mb());
        AdEventHandler.mb().ox(EventConstants.Label.OPEN_APP_DIALOG_SHOW, oxVarHj);
    }

    private void ox(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            gm gmVar = new gm() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
                private WeakReference<Activity> b;

                {
                    this.b = new WeakReference<>(TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.config.gm
                public void mb() {
                    lz.mb(str);
                    com.ss.android.socialbase.appdownloader.b.mb(this.b.get());
                }

                @Override // com.ss.android.download.api.config.gm
                public void mb(String str2) {
                    lz.mb(str, str2);
                    com.ss.android.socialbase.appdownloader.b.mb(this.b.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    x.h().mb(this, strArr, gmVar);
                    return;
                } catch (Exception e2) {
                    x.m().mb(e2, "requestPermission");
                    gmVar.mb();
                    return;
                }
            }
            gmVar.mb();
            return;
        }
        com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
    }

    public static void mb(String str, long j2, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(x.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra(EventConstants.ExtraJson.MODEL_ID, j2);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (x.getContext() != null) {
            x.getContext().startActivity(intent);
        }
    }

    private void ox(String str) {
        Intent intentU = jb.u(this, str);
        if (intentU == null) {
            return;
        }
        try {
            try {
                intentU.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                intentU.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                startActivity(intentU);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
    }

    public static void mb(@NonNull com.ss.android.downloadad.api.mb.mb mbVar, String str, String str2, String str3) {
        mb(mbVar, 8, str, str2, str3);
    }

    private static void mb(@NonNull com.ss.android.downloadad.api.mb.mb mbVar, int i2, String str, String str2, String str3) {
        Intent intentB = b(mbVar);
        intentB.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intentB.putExtra("type", i2);
        if (!TextUtils.isEmpty(str2)) {
            intentB.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intentB.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str)) {
            intentB.putExtra("message_text", str);
        }
        intentB.putExtra(EventConstants.ExtraJson.MODEL_ID, mbVar.ox());
        if (x.getContext() != null) {
            x.getContext().startActivity(intentB);
        }
    }

    protected void mb() {
        Intent intent = this.mb;
        if (intent == null) {
            return;
        }
        switch (intent.getIntExtra("type", 0)) {
            case 1:
                ox(this.mb.getStringExtra(com.bytedance.msdk.api.activity.TTDelegateActivity.PERMISSION_ID_KEY), this.mb.getStringArrayExtra(com.bytedance.msdk.api.activity.TTDelegateActivity.PERMISSION_CONTENT_KEY));
                break;
            case 2:
                mb(this.mb.getStringExtra(EventConstants.ExtraJson.OPEN_URL));
                break;
            case 3:
            case 6:
            default:
                com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
                break;
            case 4:
                b(this.mb.getLongExtra(EventConstants.ExtraJson.MODEL_ID, 0L));
                break;
            case 5:
                ox(this.mb.getLongExtra(EventConstants.ExtraJson.MODEL_ID, 0L));
                break;
            case 7:
            case 8:
                b();
                break;
            case 9:
                mb mbVar = hj;
                if (mbVar != null) {
                    mbVar.mb();
                }
                com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
                break;
            case 10:
                hj(this.mb.getLongExtra("app_info_id", 0L));
                break;
            case 11:
                ox(this.mb.getStringExtra("package_name"));
                break;
            case 12:
                ko.mb(this, this.mb.getStringExtra("package_name"), this.mb.getLongExtra(EventConstants.ExtraJson.MODEL_ID, 0L), this.mb.getStringExtra("param"), this.mb.getStringExtra("ext_json"));
                com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
                break;
        }
        this.mb = null;
    }

    private void mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                Uri uri = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                intent.putExtra(EventConstants.ExtraJson.OPEN_URL, str);
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
                    intent.addFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
        }
    }
}
