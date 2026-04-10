package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.ss.android.downloadlib.addownload.g.m;
import com.ss.android.downloadlib.addownload.pf;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.addownload.z.gc;
import com.ss.android.downloadlib.e.gz;
import com.ss.android.downloadlib.e.i;
import com.ss.android.downloadlib.guide.install.z;
import com.ss.android.downloadlib.uy;
import com.ss.android.g.z.g.g;
import com.ss.android.socialbase.downloader.downloader.e;
import com.ss.android.socialbase.downloader.e.dl;
import com.ss.android.z.z.g.v;
import com.ss.android.z.z.g.zw;
import com.ss.android.z.z.gc.dl;
import com.umeng.analytics.pro.an;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TTDelegateActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static z f1966a;
    private g dl;
    private boolean g;
    protected Intent z = null;

    public static void z(String str, String[] strArr) {
        Intent intent = new Intent(wp.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (wp.getContext() != null) {
            wp.getContext().startActivity(intent);
        }
    }

    public static void z(String str, com.ss.android.g.z.g.z zVar) {
        Intent intentDl = dl(zVar);
        intentDl.addFlags(268435456);
        intentDl.putExtra("type", 2);
        intentDl.putExtra("open_url", str);
        if (wp.getContext() != null) {
            wp.getContext().startActivity(intentDl);
        }
    }

    public static void g(String str, com.ss.android.g.z.g.z zVar) {
        Intent intentDl = dl(zVar);
        intentDl.addFlags(268435456);
        intentDl.putExtra("type", 11);
        intentDl.putExtra(an.o, str);
        if (wp.getContext() != null) {
            wp.getContext().startActivity(intentDl);
        }
    }

    public static void z(com.ss.android.g.z.g.z zVar) {
        Intent intentDl = dl(zVar);
        intentDl.addFlags(268435456);
        intentDl.putExtra("type", 4);
        intentDl.putExtra("model_id", zVar.g());
        if (wp.getContext() != null) {
            wp.getContext().startActivity(intentDl);
        }
    }

    public static void z(com.ss.android.g.z.g.z zVar, z zVar2) {
        Intent intentDl = dl(zVar);
        intentDl.addFlags(268435456);
        intentDl.putExtra("type", 9);
        f1966a = zVar2;
        if (wp.getContext() != null) {
            wp.getContext().startActivity(intentDl);
        }
    }

    public static void z(long j) {
        Intent intent = new Intent(wp.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (wp.getContext() != null) {
            wp.getContext().startActivity(intent);
        }
    }

    public static void z(String str, long j, String str2, JSONObject jSONObject) {
        Intent intent = new Intent(wp.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra(an.o, str);
        intent.putExtra("model_id", j);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (wp.getContext() != null) {
            wp.getContext().startActivity(intent);
        }
    }

    public static void z(String str, long j, String str2) {
        Intent intent = new Intent(wp.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 13);
        intent.putExtra(an.o, str);
        intent.putExtra("model_id", j);
        intent.putExtra("need_comment", str2);
        if (wp.getContext() != null) {
            wp.getContext().startActivity(intent);
        }
    }

    public static void g(String str, long j, String str2) {
        Intent intent = new Intent(wp.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 14);
        intent.putExtra(an.o, str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (wp.getContext() != null) {
            wp.getContext().startActivity(intent);
        }
    }

    public static void z(String str, long j) {
        Intent intent = new Intent(wp.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 15);
        intent.putExtra(an.o, str);
        intent.putExtra("model_id", j);
        if (wp.getContext() != null) {
            wp.getContext().startActivity(intent);
        }
    }

    public static void z(Context context, String str, long j) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 16);
        intent.putExtra(an.o, str);
        intent.putExtra("model_id", j);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    private static Intent dl(com.ss.android.g.z.g.z zVar) {
        return new Intent(wp.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    public static void g(com.ss.android.g.z.g.z zVar) {
        z(zVar, 5, "", "", "", "");
    }

    public static void z(com.ss.android.g.z.g.z zVar, String str) {
        z(zVar, 19, "", "", "", str);
    }

    public static void z(com.ss.android.g.z.g.z zVar, String str, String str2, String str3) {
        z(zVar, 8, str, str2, str3, "");
    }

    public static void z(com.ss.android.g.z.g.z zVar, String str, String str2, String str3, String str4) {
        z(zVar, 21, str, str2, str3, str4);
    }

    public static void g(com.ss.android.g.z.g.z zVar, String str, String str2, String str3) {
        z(zVar, 7, str, str2, str3, "");
    }

    public static void g(com.ss.android.g.z.g.z zVar, String str, String str2, String str3, String str4) {
        z(zVar, 20, str, str2, str3, str4);
    }

    private static void z(com.ss.android.g.z.g.z zVar, int i, String str, String str2, String str3, String str4) {
        Intent intentDl = dl(zVar);
        intentDl.addFlags(268435456);
        intentDl.putExtra("type", i);
        if (!TextUtils.isEmpty(str2)) {
            intentDl.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intentDl.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            intentDl.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            intentDl.putExtra("message_text", str);
        }
        intentDl.putExtra("model_id", zVar.g());
        if (wp.getContext() != null) {
            wp.getContext().startActivity(intentDl);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g();
        this.z = getIntent();
        wp.g(this);
        z();
    }

    private void g() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.z = intent;
        wp.g(this);
        z();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        wp.gc().z(this, i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onStop() {
        g gVar;
        dl dlVarG;
        super.onStop();
        if (!this.g || (gVar = this.dl) == null) {
            return;
        }
        if (!TextUtils.isEmpty(gVar.tc())) {
            dlVarG = uy.z(wp.getContext()).z(this.dl.tc(), null, true);
        } else {
            dlVarG = uy.z(wp.getContext()).g(this.dl.z());
        }
        if (dlVarG == null || dlVarG.sf() < dlVarG.s() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void z() {
        Intent intent = this.z;
        if (intent != null) {
            switch (intent.getIntExtra("type", 0)) {
                case 1:
                    g(this.z.getStringExtra("permission_id_key"), this.z.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    z(this.z.getStringExtra("open_url"));
                    break;
                case 3:
                case 6:
                case 17:
                case 18:
                default:
                    com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
                    break;
                case 4:
                    g(this.z.getLongExtra("model_id", 0L));
                    break;
                case 5:
                    z(this.z.getLongExtra("model_id", 0L), "");
                    break;
                case 7:
                case 8:
                case 20:
                case 21:
                    dl();
                    break;
                case 9:
                    z zVar = f1966a;
                    if (zVar != null) {
                        zVar.z();
                    }
                    com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
                    break;
                case 10:
                    dl(this.z.getLongExtra("app_info_id", 0L));
                    break;
                case 11:
                    g(this.z.getStringExtra(an.o));
                    break;
                case 12:
                    gz.z(this, this.z.getStringExtra(an.o), this.z.getLongExtra("model_id", 0L), this.z.getStringExtra("param"), this.z.getStringExtra("ext_json"));
                    com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
                    break;
                case 13:
                    gz.z(this, this.z.getStringExtra(an.o), this.z.getLongExtra("model_id", 0L), this.z.getStringExtra("need_comment"));
                    com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
                    break;
                case 14:
                    gz.g(this, this.z.getStringExtra(an.o), this.z.getLongExtra("model_id", 0L), this.z.getStringExtra("market_app_id"));
                    com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
                    break;
                case 15:
                    gz.z(this, this.z.getStringExtra(an.o), this.z.getLongExtra("model_id", 0L));
                    com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
                    break;
                case 16:
                    gz.g(this, this.z.getStringExtra(an.o), this.z.getLongExtra("model_id", 0L));
                    com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
                    break;
                case 19:
                    z(this.z.getLongExtra("model_id", 0L), this.z.getStringExtra("delete_button_text"));
                    break;
            }
            this.z = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void dl() {
        /*
            Method dump skipped, instruction units count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.activity.TTDelegateActivity.dl():void");
    }

    private void z(long j, String str) {
        if (pf.z() == null) {
            return;
        }
        g gVarA = m.z().a(j);
        if (gVarA != null) {
            dl dlVarGz = e.g(wp.getContext()).gz(gVarA.js());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - gVarA.ec()));
                jSONObject.putOpt("click_download_size", Long.valueOf(gVarA.bv()));
                if (dlVarGz != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(dlVarGz.sf()));
                    jSONObject.putOpt("download_percent", Long.valueOf(dlVarGz.sf() / dlVarGz.s()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(dlVarGz.s()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (dlVarGz.sf() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (dlVarGz.s() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)));
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            if (!TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.a.z.z().z("cancel_pause_reserve_wifi_dialog_show", jSONObject, gVarA);
            } else {
                com.ss.android.downloadlib.a.z.z().g("pause_reserve_wifi_dialog_show", jSONObject, gVarA);
            }
        }
        gc.z zVarZ = new gc.z(this).z(false).z(pf.z());
        if (!TextUtils.isEmpty(str)) {
            zVarZ.a(str).z(pf.g());
        }
        zVarZ.z().show();
        this.g = true;
        this.dl = gVarA;
    }

    private void g(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
            return;
        }
        zw zwVar = new zw() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
            private WeakReference<Activity> dl;

            {
                this.dl = new WeakReference<>(TTDelegateActivity.this);
            }

            @Override // com.ss.android.z.z.g.zw
            public void z() {
                com.ss.android.downloadlib.e.uy.z(str);
                com.ss.android.socialbase.appdownloader.dl.z(this.dl.get());
            }

            @Override // com.ss.android.z.z.g.zw
            public void z(String str2) {
                com.ss.android.downloadlib.e.uy.z(str, str2);
                com.ss.android.socialbase.appdownloader.dl.z(this.dl.get());
            }
        };
        try {
            wp.gc().z(this, strArr, zwVar);
        } catch (Exception e) {
            wp.tb().z(e, "requestPermission");
            zwVar.z();
        }
    }

    private void z(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.putExtra("open_url", str);
            intent.addFlags(268435456);
            if (com.ss.android.socialbase.downloader.i.z.dl().z("fix_app_link_flag")) {
                intent.addFlags(67108864);
            }
            intent.putExtra("start_only_for_android", true);
            startActivity(intent);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        } finally {
            com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
        }
    }

    private void g(String str) {
        Intent intentE = i.e(this, str);
        if (intentE == null) {
            return;
        }
        try {
            intentE.addFlags(268435456);
            intentE.putExtra("start_only_for_android", true);
            startActivity(intentE);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        } finally {
            com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
        }
    }

    private void g(long j) {
        final g gVarA = m.z().a(j);
        if (gVarA == null) {
            com.ss.android.downloadlib.gc.dl.z().z("showOpenAppDialogInner nativeModel null");
            com.ss.android.socialbase.appdownloader.dl.z((Activity) this);
            return;
        }
        v vVarDl = wp.dl();
        dl.z zVarZ = new dl.z(this).z("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(gVarA.xl()) ? "刚刚下载的应用" : gVarA.xl();
        vVarDl.g(zVarZ.g(String.format("%1$s已安装完成，是否立即打开？", objArr)).dl("打开").a("取消").z(false).z(i.a(this, gVarA.gc())).z(new dl.g() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.z.z.gc.dl.g
            public void z(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.g.z.g(gVarA);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                com.ss.android.socialbase.appdownloader.dl.z((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.z.z.gc.dl.g
            public void g(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.a.z.z().g("market_openapp_cancel", gVarA);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                com.ss.android.socialbase.appdownloader.dl.z((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.z.z.gc.dl.g
            public void dl(DialogInterface dialogInterface) {
                com.ss.android.socialbase.appdownloader.dl.z((Activity) TTDelegateActivity.this);
            }
        }).z(2).z());
        com.ss.android.downloadlib.a.z.z().g("market_openapp_window_show", gVarA);
    }

    private void dl(long j) {
        new com.ss.android.downloadlib.addownload.compliance.z(this, j).show();
    }
}
