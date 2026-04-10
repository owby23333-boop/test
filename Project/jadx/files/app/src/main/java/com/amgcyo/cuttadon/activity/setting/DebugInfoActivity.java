package com.amgcyo.cuttadon.activity.setting;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.fatcatfat.io.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class DebugInfoActivity extends BaseTitleBarActivity {

    @BindView(R.id.et_website)
    EditText et_website;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private String f2805o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private a f2806p0;

    @BindView(R.id.scrollView)
    ScrollView scrollView;

    @BindView(R.id.tv_ping)
    TextView tv_ping;

    @BindView(R.id.tv_submit)
    TextView tv_submit;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private StringBuilder f2804n0 = new StringBuilder();

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private boolean f2807q0 = false;

    static class a extends Handler {
        WeakReference<DebugInfoActivity> a;

        a(@NonNull Looper looper, DebugInfoActivity debugInfoActivity) {
            super(looper);
            this.a = new WeakReference<>(debugInfoActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            DebugInfoActivity debugInfoActivity = this.a.get();
            if (debugInfoActivity == null || debugInfoActivity.f2804n0 == null || debugInfoActivity.tv_ping == null) {
                return;
            }
            debugInfoActivity.f2804n0.append(message.getData().getString(com.anythink.expressad.foundation.h.i.f10646d));
            if (!debugInfoActivity.f2807q0) {
                debugInfoActivity.tv_ping.setBackgroundColor(Color.parseColor("#121212"));
                debugInfoActivity.f2807q0 = true;
            }
            debugInfoActivity.tv_ping.setText(debugInfoActivity.f2804n0.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        String strSubstring;
        StringBuilder sb = this.f2804n0;
        sb.append("Brand：");
        sb.append(Build.MANUFACTURER);
        sb.append(" Model：");
        sb.append(Build.BRAND);
        sb.append("_");
        sb.append(Build.MODEL);
        StringBuilder sb2 = this.f2804n0;
        sb2.append(" Android");
        sb2.append(Build.VERSION.RELEASE);
        StringBuilder sb3 = this.f2804n0;
        sb3.append(" NetWorkType：");
        sb3.append(com.amgcyo.cuttadon.utils.otherutils.g.c((Context) a()));
        StringBuilder sb4 = this.f2804n0;
        sb4.append(" Position：");
        sb4.append(com.amgcyo.cuttadon.app.o.c.h());
        StringBuilder sb5 = this.f2804n0;
        sb5.append(" SimOperator：");
        sb5.append(com.amgcyo.cuttadon.utils.otherutils.g.b((Context) a()));
        StringBuilder sb6 = this.f2804n0;
        sb6.append(" MyIP：");
        sb6.append(com.amgcyo.cuttadon.utils.otherutils.g0.a().d("MyIPlA"));
        TelephonyManager telephonyManager = (TelephonyManager) a().getSystemService("phone");
        if (telephonyManager != null) {
            StringBuilder sb7 = this.f2804n0;
            sb7.append(" IsoCountryCode：");
            sb7.append(telephonyManager.getNetworkCountryIso());
            try {
                String networkOperator = telephonyManager.getNetworkOperator();
                String strSubstring2 = "";
                if (TextUtils.isEmpty(networkOperator)) {
                    strSubstring = "";
                } else {
                    strSubstring = networkOperator.length() >= 3 ? networkOperator.substring(0, 3) : "";
                    if (networkOperator.length() >= 5) {
                        strSubstring2 = networkOperator.substring(3, 5);
                    }
                }
                if (!TextUtils.isEmpty(strSubstring)) {
                    StringBuilder sb8 = this.f2804n0;
                    sb8.append(" MobileCountryCode：");
                    sb8.append(strSubstring);
                }
                if (!TextUtils.isEmpty(strSubstring2)) {
                    StringBuilder sb9 = this.f2804n0;
                    sb9.append(" MobileNetworkCode：");
                    sb9.append(strSubstring2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f2804n0.append("\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e4 A[Catch: Exception -> 0x0104, TryCatch #4 {Exception -> 0x0104, blocks: (B:47:0x00d6, B:51:0x00de, B:53:0x00e4, B:55:0x00fb, B:57:0x0100), top: B:68:0x00d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fb A[Catch: Exception -> 0x0104, TryCatch #4 {Exception -> 0x0104, blocks: (B:47:0x00d6, B:51:0x00de, B:53:0x00e4, B:55:0x00fb, B:57:0x0100), top: B:68:0x00d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0100 A[Catch: Exception -> 0x0104, TRY_LEAVE, TryCatch #4 {Exception -> 0x0104, blocks: (B:47:0x00d6, B:51:0x00de, B:53:0x00e4, B:55:0x00fb, B:57:0x0100), top: B:68:0x00d6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void p() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.activity.setting.DebugInfoActivity.p():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00db A[Catch: Exception -> 0x00fb, TryCatch #2 {Exception -> 0x00fb, blocks: (B:44:0x00d1, B:46:0x00db, B:48:0x00f2, B:50:0x00f7), top: B:60:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f2 A[Catch: Exception -> 0x00fb, TryCatch #2 {Exception -> 0x00fb, blocks: (B:44:0x00d1, B:46:0x00db, B:48:0x00f2, B:50:0x00f7), top: B:60:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f7 A[Catch: Exception -> 0x00fb, TRY_LEAVE, TryCatch #2 {Exception -> 0x00fb, blocks: (B:44:0x00d1, B:46:0x00db, B:48:0x00f2, B:50:0x00f7), top: B:60:0x00d1 }] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.InputStream, java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String q() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.activity.setting.DebugInfoActivity.q():java.lang.String");
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        this.D.setVisibility(0);
        this.D.setText("查询IP");
        this.D.setTextSize(12.0f);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.setting.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2858s.e(view);
            }
        });
        this.f2806p0 = new a(Looper.getMainLooper(), this);
        this.tv_submit.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.setting.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2861s.f(view);
            }
        });
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.activity_debug_info;
    }

    public void isPingSuccess(int i2, String str) {
        String line;
        try {
            Process processExec = Runtime.getRuntime().exec("/system/bin/ping -c " + i2 + " " + str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                e(line + "\r\n");
            }
            if (TextUtils.isEmpty(line)) {
                e(processExec.waitFor() == 0 ? "ping success" : "ping failed");
                e("\n测试完成，请截图发送给客服。");
                if (this.scrollView != null) {
                    this.scrollView.post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.setting.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2859s.n();
                        }
                    });
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    public /* synthetic */ void n() {
        this.scrollView.fullScroll(130);
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        a aVar = this.f2806p0;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return com.amgcyo.cuttadon.f.o.d(R.string.app_name);
    }

    public /* synthetic */ void e(View view) {
        com.amgcyo.cuttadon.view.webview.b.startActivity(a(), "https://www.ip138.com/");
    }

    public /* synthetic */ void f(View view) {
        this.f2805o0 = this.et_website.getText().toString();
        if (TextUtils.isEmpty(this.f2805o0)) {
            showMessage("请输入网址");
            return;
        }
        if (this.f2805o0.contains("http://") || this.f2805o0.contains("https://")) {
            this.f2805o0 = this.f2805o0.replaceAll("http://", "").replaceAll("https://", "");
        }
        if (this.f2805o0.contains("/")) {
            this.f2805o0 = this.f2805o0.replaceAll("/", "");
        }
        this.et_website.setText(this.f2805o0);
        this.et_website.setSelection(this.f2805o0.length());
        this.tv_ping.setText("");
        StringBuilder sb = this.f2804n0;
        sb.delete(0, sb.length());
        this.tv_submit.setEnabled(false);
        this.tv_submit.setAlpha(0.4f);
        this.tv_submit.setText("正在测试中，请耐心等待...");
        com.amgcyo.cuttadon.utils.otherutils.g.c((Activity) a());
        com.amgcyo.cuttadon.j.g.b.a(new e0(this, ""));
    }

    private void e(String str) {
        a aVar = this.f2806p0;
        if (aVar != null) {
            Message messageObtainMessage = aVar.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putString(com.anythink.expressad.foundation.h.i.f10646d, str);
            messageObtainMessage.setData(bundle);
            this.f2806p0.sendMessage(messageObtainMessage);
        }
    }
}
