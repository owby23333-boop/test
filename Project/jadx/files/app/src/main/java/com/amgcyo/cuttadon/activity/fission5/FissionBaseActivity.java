package com.amgcyo.cuttadon.activity.fission5;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity;
import com.amgcyo.cuttadon.activity.setting.MkWebviewActivity;
import com.amgcyo.cuttadon.api.entity.config.Fission;
import com.amgcyo.cuttadon.api.entity.config.FissionData;
import com.amgcyo.cuttadon.api.entity.config.JsJsonObject;
import com.amgcyo.cuttadon.api.entity.config.LoadingMsg;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.r;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class FissionBaseActivity extends BaseWebViewAcitivity<UserPresenter> {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    FissionData f2541p0;

    private class b {
        private b() {
        }

        @JavascriptInterface
        public void Loading(boolean z2, String str) {
            LoadingMsg loadingMsg = new LoadingMsg(z2, str);
            Message messageA = Message.a(FissionBaseActivity.this.a(), new Object[0]);
            messageA.f21197s = 867;
            messageA.f21202x = loadingMsg;
            messageA.b();
        }

        @JavascriptInterface
        public void copyText(String str) {
            Message messageA = Message.a(FissionBaseActivity.this.a(), new Object[0]);
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
            FissionBaseActivity.this.a().finish();
        }

        @JavascriptInterface
        public String getFissionData(int i2) {
            ArrayList<Fission> arrayListK = com.amgcyo.cuttadon.utils.otherutils.h.K();
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayListK)) {
                return "{\"fission\":[]}";
            }
            for (Fission fission : arrayListK) {
                if (fission.getScheme() == i2) {
                    return r.a(fission);
                }
            }
            return "{\"fission\":[]}";
        }

        @JavascriptInterface
        public String getFissionInfo() {
            FissionData fissionData = FissionBaseActivity.this.f2541p0;
            return fissionData != null ? r.a(fissionData) : "{}";
        }

        @JavascriptInterface
        public String getUserInfo() {
            return FissionBaseActivity.this.e("base64");
        }

        @JavascriptInterface
        public String getUserInfoByType(String str) {
            return FissionBaseActivity.this.e(str);
        }

        @JavascriptInterface
        public void httpRequest(String str) {
            JsJsonObject jsJsonObject = (JsJsonObject) r.a(str, JsJsonObject.class);
            if (jsJsonObject != null) {
                FissionBaseActivity.this.a(jsJsonObject);
            }
        }

        @JavascriptInterface
        public void loginPage() {
            if (((BaseTitleBarActivity) FissionBaseActivity.this).f2277w == null) {
                return;
            }
            r0.b(((BaseTitleBarActivity) FissionBaseActivity.this).f2277w);
            FissionBaseActivity.this.a().finish();
        }

        @JavascriptInterface
        public void openF3IncomeDetailPage() {
            if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
                FissionBaseActivity.this.o();
            }
        }

        @JavascriptInterface
        public void openTaboBao(String str) {
        }

        @JavascriptInterface
        public void openWebViewRequireLogin(String str) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
                FissionBaseActivity.this.o();
            } else {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                FissionBaseActivity fissionBaseActivity = FissionBaseActivity.this;
                if (fissionBaseActivity.f2541p0 != null) {
                    r0.a(((BaseTitleBarActivity) fissionBaseActivity).f2277w, str, FissionBaseActivity.this.f2541p0);
                }
            }
        }

        @JavascriptInterface
        public void openWebview(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            FissionBaseActivity fissionBaseActivity = FissionBaseActivity.this;
            if (fissionBaseActivity.f2541p0 != null) {
                r0.a(((BaseTitleBarActivity) fissionBaseActivity).f2277w, str, FissionBaseActivity.this.f2541p0);
            }
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
            Intent intent = new Intent(((BaseTitleBarActivity) FissionBaseActivity.this).f2277w, (Class<?>) MkWebviewActivity.class);
            intent.putExtra("param_url", str);
            intent.putExtra("webview_width", 750);
            intent.putExtra("webview_height", 1333);
            intent.putExtra("WEBVIEW_SHARE", 0);
            ((BaseTitleBarActivity) FissionBaseActivity.this).f2277w.startActivity(intent);
        }

        @JavascriptInterface
        public void screenshotsShareWithSize(String str, int i2, int i3) {
            String str2 = str + "  " + i2 + "  " + i3;
            if (TextUtils.isEmpty(str) || i2 <= 0 || i3 <= 0) {
                return;
            }
            Intent intent = new Intent(((BaseTitleBarActivity) FissionBaseActivity.this).f2277w, (Class<?>) MkWebviewActivity.class);
            intent.putExtra("param_url", str);
            intent.putExtra("webview_width", i2);
            intent.putExtra("webview_height", i3);
            ((BaseTitleBarActivity) FissionBaseActivity.this).f2277w.startActivity(intent);
        }

        @JavascriptInterface
        public void showMenu(String str, String str2) {
            Message messageA = Message.a(FissionBaseActivity.this.a(), new Object[0]);
            messageA.f21197s = 868;
            messageA.f21203y = new Object[]{str, str2};
            messageA.b();
        }

        @JavascriptInterface
        public void showToast(String str) {
            FissionBaseActivity.this.showMessage(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        r0.a(this.f2277w, true);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        String responeJson;
        String responeJson2;
        super.handleMessage(message);
        switch (message.f21197s) {
            case 865:
                JsJsonObject jsJsonObject = (JsJsonObject) message.f21202x;
                if (jsJsonObject != null && (responeJson = jsJsonObject.getResponeJson()) != null && !TextUtils.isEmpty(responeJson)) {
                    this.webView.evaluateJavascript(jsJsonObject.getCallback() + "('" + jsJsonObject.getCallback_key() + "','" + responeJson + "')", null);
                }
                break;
            case 866:
                JsJsonObject jsJsonObject2 = (JsJsonObject) message.f21202x;
                if (jsJsonObject2 != null && (responeJson2 = jsJsonObject2.getResponeJson()) != null && !TextUtils.isEmpty(responeJson2)) {
                    this.webView.evaluateJavascript(jsJsonObject2.getCallback() + "('" + jsJsonObject2.getCallback_key() + "','" + responeJson2 + "')", null);
                }
                break;
            case 867:
                LoadingMsg loadingMsg = (LoadingMsg) message.f21202x;
                if (!loadingMsg.isShowHide()) {
                    hideLoading();
                } else {
                    showLoading(loadingMsg.getMsg());
                }
                break;
            case 868:
                Object[] objArr = message.f21203y;
                String str = (String) objArr[0];
                final String str2 = (String) objArr[1];
                if (this.D != null) {
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.f2541p0 == null) {
                        this.D.setVisibility(8);
                        this.D.setEnabled(false);
                    } else {
                        this.D.setEnabled(true);
                        this.D.setText(str);
                        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.fission5.h
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                this.f2548s.a(str2, view);
                            }
                        });
                        this.D.setVisibility(0);
                    }
                    break;
                }
                break;
            case 869:
                String str3 = (String) message.f21202x;
                if (!TextUtils.isEmpty(str3)) {
                    o.a(this.f2277w, str3, R.string.copy_suc);
                }
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("param_url");
        this.f2541p0 = (FissionData) intent.getSerializableExtra("fission_data");
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
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

    public /* synthetic */ void a(String str, View view) {
        r0.a(this.f2277w, str, this.f2541p0);
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
