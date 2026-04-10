package com.amgcyo.cuttadon.activity.setting;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity;
import com.amgcyo.cuttadon.api.entity.config.Fission;
import com.amgcyo.cuttadon.api.entity.config.JsJsonObject;
import com.amgcyo.cuttadon.api.entity.config.LoadingMsg;
import com.amgcyo.cuttadon.api.entity.other.SystemInfo;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkKeepAliveActivity extends BaseWebViewAcitivity<UserPresenter> {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private String f2848p0;

    private class b {
        private b() {
        }

        @JavascriptInterface
        public void Loading(boolean z2, String str) {
            LoadingMsg loadingMsg = new LoadingMsg(z2, str);
            Message messageA = Message.a(MkKeepAliveActivity.this.a(), new Object[0]);
            messageA.f21197s = 867;
            messageA.f21202x = loadingMsg;
            messageA.b();
        }

        @JavascriptInterface
        public void copyText(String str) {
            Message messageA = Message.a(MkKeepAliveActivity.this.a(), new Object[0]);
            messageA.f21197s = 869;
            messageA.f21202x = str;
            messageA.b();
        }

        @JavascriptInterface
        public void finishActivityByUrl(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MkApplication.getAppContext().clearActivityByUrl(str);
        }

        @JavascriptInterface
        public void finishAllActivity() {
            MkApplication.getAppContext().clearAllActivity();
        }

        @JavascriptInterface
        public void finishAndReload(String str) {
        }

        @JavascriptInterface
        public void finishSelf() {
            MkKeepAliveActivity.this.a().finish();
        }

        @JavascriptInterface
        public String getFissionData(int i2) {
            ArrayList<Fission> arrayListK = com.amgcyo.cuttadon.utils.otherutils.h.K();
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayListK)) {
                return "{\"fission\":[]}";
            }
            for (Fission fission : arrayListK) {
                if (fission.getScheme() == i2) {
                    return com.amgcyo.cuttadon.utils.otherutils.r.a(fission);
                }
            }
            return "{\"fission\":[]}";
        }

        @JavascriptInterface
        public String getSystemInfo() {
            SystemInfo systemInfo = new SystemInfo();
            systemInfo.setAppname(com.amgcyo.cuttadon.f.o.d(R.string.app_name));
            systemInfo.setPackname(com.amgcyo.cuttadon.utils.otherutils.h.t());
            if (me.jessyan.art.f.a.h()) {
                systemInfo.setPlatform("小米MIUI");
                systemInfo.setGosetting(1);
            } else if (me.jessyan.art.f.a.a()) {
                systemInfo.setPlatform("华为EMUI");
                systemInfo.setGosetting(1);
            } else if (me.jessyan.art.f.a.e()) {
                systemInfo.setPlatform("三星手机");
                systemInfo.setGosetting(1);
            } else if (me.jessyan.art.f.a.c()) {
                systemInfo.setPlatform("魅族Flyme");
                systemInfo.setGosetting(1);
            } else if (me.jessyan.art.f.a.d()) {
                systemInfo.setPlatform("OPPO ColorOS");
                systemInfo.setGosetting(1);
            } else if (me.jessyan.art.f.a.g()) {
                systemInfo.setPlatform("vivo Funtouch OS");
                systemInfo.setGosetting(1);
            } else if (me.jessyan.art.f.a.b()) {
                systemInfo.setPlatform("乐视 EUI");
                systemInfo.setGosetting(1);
            } else if (me.jessyan.art.f.a.f()) {
                systemInfo.setPlatform("锤子 Smartisan OS");
                systemInfo.setGosetting(1);
            } else {
                systemInfo.setPlatform("其它手机");
                systemInfo.setGosetting(1);
            }
            MkKeepAliveActivity.this.f2848p0 = systemInfo.getPlatform();
            return com.amgcyo.cuttadon.utils.otherutils.r.a(systemInfo);
        }

        @JavascriptInterface
        public String getUserInfo() {
            return MkKeepAliveActivity.this.e("base64");
        }

        @JavascriptInterface
        public String getUserInfoByType(String str) {
            return MkKeepAliveActivity.this.e(str);
        }

        @JavascriptInterface
        public void goSetting() {
            if (TextUtils.isEmpty(MkKeepAliveActivity.this.f2848p0)) {
            }
            switch (MkKeepAliveActivity.this.f2848p0) {
                case "小米MIUI":
                    me.jessyan.art.f.a.g(MkKeepAliveActivity.this.a());
                    break;
                case "华为EMUI":
                    me.jessyan.art.f.a.a(MkKeepAliveActivity.this.a());
                    break;
                case "三星手机":
                    me.jessyan.art.f.a.e(MkKeepAliveActivity.this.a());
                    break;
                case "魅族Flyme":
                    me.jessyan.art.f.a.c(MkKeepAliveActivity.this.a());
                    break;
                case "OPPO ColorOS":
                    me.jessyan.art.f.a.d(MkKeepAliveActivity.this.a());
                    break;
                case "vivo Funtouch OS":
                    me.jessyan.art.f.a.f(MkKeepAliveActivity.this.a());
                    break;
                case "乐视 EUI":
                    me.jessyan.art.f.a.b(MkKeepAliveActivity.this.a());
                    break;
                case "锤子 Smartisan OS":
                    me.jessyan.art.f.a.e(MkKeepAliveActivity.this.a());
                    break;
                case "其它手机":
                    me.jessyan.art.f.a.h(MkKeepAliveActivity.this.a());
                    break;
            }
        }

        @JavascriptInterface
        public void httpRequest(String str) {
            JsJsonObject jsJsonObject = (JsJsonObject) com.amgcyo.cuttadon.utils.otherutils.r.a(str, JsJsonObject.class);
            if (jsJsonObject != null) {
                MkKeepAliveActivity.this.a(jsJsonObject);
            }
        }

        @JavascriptInterface
        public void loginPage() {
            if (((BaseTitleBarActivity) MkKeepAliveActivity.this).f2277w == null) {
                return;
            }
            r0.b(((BaseTitleBarActivity) MkKeepAliveActivity.this).f2277w);
            MkKeepAliveActivity.this.a().finish();
        }

        @JavascriptInterface
        public void openF3IncomeDetailPage() {
        }

        @JavascriptInterface
        public void openTaboBao(String str) {
        }

        @JavascriptInterface
        public void openWebview(String str) {
            TextUtils.isEmpty(str);
        }

        @JavascriptInterface
        public void refreshUserInfo() {
            me.jessyan.art.d.f.a().a(new MkCommentEvent(), "refreshLoginStatus");
        }

        @JavascriptInterface
        public void screenshotsShare(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Intent intent = new Intent(((BaseTitleBarActivity) MkKeepAliveActivity.this).f2277w, (Class<?>) MkWebviewActivity.class);
            intent.putExtra("param_url", str);
            intent.putExtra("webview_width", 750);
            intent.putExtra("webview_height", 1333);
            ((BaseTitleBarActivity) MkKeepAliveActivity.this).f2277w.startActivity(intent);
        }

        @JavascriptInterface
        public void screenshotsShareWithSize(String str, int i2, int i3) {
            String str2 = str + "  " + i2 + "  " + i3;
            if (TextUtils.isEmpty(str) || i2 <= 0 || i3 <= 0) {
                return;
            }
            Intent intent = new Intent(((BaseTitleBarActivity) MkKeepAliveActivity.this).f2277w, (Class<?>) MkWebviewActivity.class);
            intent.putExtra("param_url", str);
            intent.putExtra("webview_width", i2);
            intent.putExtra("webview_height", i3);
            ((BaseTitleBarActivity) MkKeepAliveActivity.this).f2277w.startActivity(intent);
        }

        @JavascriptInterface
        public void showMenu(String str, String str2) {
            Message messageA = Message.a(MkKeepAliveActivity.this.a(), new Object[0]);
            messageA.f21197s = 868;
            messageA.f21203y = new Object[]{str, str2};
            messageA.b();
        }

        @JavascriptInterface
        public void showToast(String str) {
            MkKeepAliveActivity.this.showMessage(str);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.mRefreshView.setEnabled(false);
        String stringExtra = getIntent().getStringExtra("param_url");
        MkApplication.getAppContext().addActivity(stringExtra, this);
        this.webView.loadUrl(stringExtra);
        this.webView.addJavascriptInterface(new b(), this.f2284n0);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity, me.jessyan.art.base.f.h
    @NonNull
    public UserPresenter obtainPresenter() {
        if (this.f2276v == 0) {
            this.f2276v = new UserPresenter(me.jessyan.art.f.e.a(this));
        }
        return (UserPresenter) this.f2276v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JsJsonObject jsJsonObject) {
        if ("POST".equals(jsJsonObject.getMethod())) {
            obtainPresenter().y(Message.a(a(), new Object[]{jsJsonObject}));
        } else if ("GET".equals(jsJsonObject.getMethod())) {
            obtainPresenter().k(Message.a(a(), new Object[]{jsJsonObject}));
        }
    }
}
