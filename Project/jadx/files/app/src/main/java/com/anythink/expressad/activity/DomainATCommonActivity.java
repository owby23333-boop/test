package com.anythink.expressad.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.anythink.expressad.foundation.b.a;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.foundation.webview.BrowserView;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes2.dex */
public class DomainATCommonActivity extends Activity {
    private static final String b = "ATCommonActivity";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f8125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BrowserView f8126d;
    String a = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BrowserView.a f8127e = new BrowserView.a() { // from class: com.anythink.expressad.activity.DomainATCommonActivity.1
        @Override // com.anythink.expressad.foundation.webview.BrowserView.a
        public final void a() {
            DomainATCommonActivity.this.finish();
        }

        @Override // com.anythink.expressad.foundation.webview.BrowserView.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.webview.BrowserView.a
        public final boolean a(WebView webView, String str) {
            o.d(DomainATCommonActivity.b, "shouldOverrideUrlLoading  ".concat(String.valueOf(str)));
            if (s.a.a(str) && s.a.a(DomainATCommonActivity.this, str, null)) {
                DomainATCommonActivity.this.finish();
            }
            return DomainATCommonActivity.this.a(webView, str);
        }
    };

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            o.d(b, th.getMessage());
        }
        if (a.b().d() == null) {
            a.b().a(getApplicationContext());
        }
        this.a = getIntent().getStringExtra("url");
        if (TextUtils.isEmpty(this.a)) {
            Toast.makeText(this, "Error: no data", 0).show();
            return;
        }
        this.f8125c = (c) getIntent().getSerializableExtra("mvcommon");
        this.f8126d = new BrowserView(this, this.f8125c);
        this.f8126d.setListener(this.f8127e);
        this.f8126d.loadUrl(this.a);
        BrowserView browserView = this.f8126d;
        if (browserView != null) {
            setContentView(browserView);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BrowserView browserView = this.f8126d;
        if (browserView != null) {
            browserView.destroy();
        }
    }

    private void a() {
        this.a = getIntent().getStringExtra("url");
        if (TextUtils.isEmpty(this.a)) {
            Toast.makeText(this, "Error: no data", 0).show();
            return;
        }
        this.f8125c = (c) getIntent().getSerializableExtra("mvcommon");
        this.f8126d = new BrowserView(this, this.f8125c);
        this.f8126d.setListener(this.f8127e);
        this.f8126d.loadUrl(this.a);
        BrowserView browserView = this.f8126d;
        if (browserView != null) {
            setContentView(browserView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WebView webView, String str) {
        String str2;
        try {
        } catch (Throwable th) {
            o.d(b, th.getMessage());
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri uri = Uri.parse(str);
        boolean z2 = true;
        if (!(uri.getScheme().equals("http") || uri.getScheme().equals("https")) && uri.getScheme().equals("intent")) {
            Intent uri2 = Intent.parseUri(str, 1);
            try {
                str2 = uri2.getPackage();
            } catch (Throwable th2) {
                o.d(b, th2.getMessage());
            }
            if (!TextUtils.isEmpty(str2) && getPackageManager().getLaunchIntentForPackage(str2) != null) {
                uri2.addCategory("android.intent.category.BROWSABLE");
                uri2.setComponent(null);
                if (Build.VERSION.SDK_INT >= 15) {
                    uri2.setSelector(null);
                }
                uri2.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                startActivityForResult(uri2, 0);
                finish();
                return true;
            }
            try {
                String stringExtra = uri2.getStringExtra("browser_fallback_url");
                if (!TextUtils.isEmpty(stringExtra)) {
                    Uri uri3 = Uri.parse(str);
                    if (!uri3.getScheme().equals("http") && !uri3.getScheme().equals("https")) {
                        z2 = false;
                    }
                    if (z2) {
                        webView.loadUrl(stringExtra);
                        return false;
                    }
                }
            } catch (Throwable th3) {
                o.d(b, th3.getMessage());
            }
            o.d(b, th.getMessage());
            return false;
        }
        return false;
    }
}
