package com.anythink.core.basead.ui.web;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.basead.a;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.am;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.j.c;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.l;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class WebLandPageActivity extends Activity {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f6592e = 343452;
    JSONArray b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WebProgressBarView f6595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WebView f6596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageButton f6597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImageButton f6598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageButton f6599j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ImageButton f6600k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f6601l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private i f6602m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private j f6603n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f6604o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private IOfferClickHandler f6605p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private b f6606q;
    int a = 8;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ValueCallback<Uri[]> f6607r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f6608s = 512;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f6593c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f6594d = 0;

    /* JADX INFO: renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$1, reason: invalid class name */
    final class AnonymousClass1 implements DownloadListener {
        AnonymousClass1() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            if (WebLandPageActivity.this.f6602m == null || WebLandPageActivity.this.f6603n == null || TextUtils.isEmpty(WebLandPageActivity.this.f6602m.B())) {
                WebLandPageActivity webLandPageActivity = WebLandPageActivity.this;
                webLandPageActivity.a = 11;
                l.a(webLandPageActivity, str);
            } else if (WebLandPageActivity.this.f6605p != null && (WebLandPageActivity.this.f6605p instanceof IOfferClickHandler) && WebLandPageActivity.this.f6605p.startDownloadApp(WebLandPageActivity.this.getApplicationContext(), WebLandPageActivity.this.f6602m, WebLandPageActivity.this.f6603n, str)) {
                WebLandPageActivity webLandPageActivity2 = WebLandPageActivity.this;
                webLandPageActivity2.a = 6;
                webLandPageActivity2.f6594d = 1;
            } else {
                WebLandPageActivity webLandPageActivity3 = WebLandPageActivity.this;
                webLandPageActivity3.f6594d = 2;
                l.a(webLandPageActivity3, str);
                WebLandPageActivity.this.a = 7;
            }
            WebLandPageActivity.this.finish();
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (WebLandPageActivity.this.f6596g.canGoBack()) {
                WebLandPageActivity.this.f6596g.goBack();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$3, reason: invalid class name */
    final class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (WebLandPageActivity.this.f6596g.canGoForward()) {
                WebLandPageActivity.this.f6596g.goForward();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$4, reason: invalid class name */
    final class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WebLandPageActivity.this.f6596g.reload();
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.basead.ui.web.WebLandPageActivity$5, reason: invalid class name */
    final class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WebLandPageActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        ((ViewGroup) getWindow().getDecorView()).removeAllViews();
        super.finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        Uri[] uriArr;
        Uri[] uriArr2;
        ClipData clipData;
        if (i2 == 512) {
            try {
                if (this.f6607r == null) {
                    return;
                }
                if (i3 != -1 || intent == null) {
                    uriArr = null;
                } else {
                    String dataString = intent.getDataString();
                    try {
                        clipData = intent.getClipData();
                    } catch (Throwable unused) {
                    }
                    if (clipData != null) {
                        uriArr2 = new Uri[clipData.getItemCount()];
                        for (int i4 = 0; i4 < clipData.getItemCount(); i4++) {
                            try {
                                uriArr2[i4] = clipData.getItemAt(i4).getUri();
                            } catch (Throwable unused2) {
                            }
                        }
                    } else {
                        uriArr2 = null;
                    }
                    uriArr = dataString != null ? new Uri[]{Uri.parse(dataString)} : uriArr2;
                }
                this.f6607r.onReceiveValue(uriArr);
                this.f6607r = null;
            } catch (Throwable unused3) {
            }
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(-1);
        this.f6601l = getWindow().requestFeature(2);
        if (this.f6601l) {
            getWindow().setFeatureInt(2, -1);
        }
        Intent intent = getIntent();
        if (intent != null) {
            try {
                Serializable serializableExtra = intent.getSerializableExtra(a.C0154a.f6570c);
                if (serializableExtra != null && (serializableExtra instanceof i)) {
                    this.f6602m = (i) serializableExtra;
                    this.f6606q = new b(this.f6602m);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Serializable serializableExtra2 = intent.getSerializableExtra(a.C0154a.f6572e);
                if (serializableExtra2 != null && (serializableExtra2 instanceof j)) {
                    this.f6603n = (j) serializableExtra2;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                Serializable serializableExtra3 = intent.getSerializableExtra(a.C0154a.f6579l);
                if (serializableExtra3 != null && (serializableExtra3 instanceof IOfferClickHandler)) {
                    this.f6605p = (IOfferClickHandler) serializableExtra3;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                this.f6604o = intent.getStringExtra(a.C0154a.f6577j);
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        }
        String strA = this.f6604o;
        if (TextUtils.isEmpty(strA)) {
            i iVar = this.f6602m;
            strA = iVar != null ? iVar.A() : "";
        }
        Context applicationContext = getApplicationContext();
        if (TextUtils.isEmpty(strA)) {
            Toast.makeText(applicationContext, h.a(applicationContext, "basead_click_empty", com.anythink.expressad.foundation.h.i.f10649g), 0).show();
            finish();
            return;
        }
        am amVarA = com.anythink.core.basead.a.a.a(applicationContext, strA);
        if (amVarA.f7206m) {
            a(amVarA);
            return;
        }
        a(amVarA);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-16777216);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(f6592e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, h.a(this, 55.0f));
        layoutParams.addRule(12);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(new ColorDrawable(-592138));
        int iA = h.a(this, 20.0f);
        linearLayout.setPadding(iA, 0, iA, 0);
        relativeLayout.addView(linearLayout);
        this.f6597h = a(getResources().getDrawable(h.a(this, "browser_unleft_icon", com.anythink.expressad.foundation.h.i.f10645c)));
        this.f6598i = a(getResources().getDrawable(h.a(this, "browser_unright_icon", com.anythink.expressad.foundation.h.i.f10645c)));
        this.f6599j = a(getResources().getDrawable(h.a(this, "browser_refresh_icon", com.anythink.expressad.foundation.h.i.f10645c)));
        this.f6600k = a(getResources().getDrawable(h.a(this, "browser_close_icon", com.anythink.expressad.foundation.h.i.f10645c)));
        linearLayout.addView(this.f6597h);
        linearLayout.addView(this.f6598i);
        linearLayout.addView(this.f6599j);
        linearLayout.addView(this.f6600k);
        this.f6596g = new BaseWebView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, f6592e);
        this.f6596g.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.f6596g);
        View view = new View(this);
        view.setBackgroundColor(-2434342);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, h.a(this, 1.0f));
        layoutParams3.addRule(2, f6592e);
        view.setLayoutParams(layoutParams3);
        relativeLayout.addView(view);
        this.f6595f = new WebProgressBarView(this);
        this.f6595f.setProgress(0);
        relativeLayout.addView(this.f6595f, new RelativeLayout.LayoutParams(-1, h.a(this, 2.0f)));
        setContentView(relativeLayout);
        this.f6597h.setBackgroundColor(0);
        this.f6597h.setOnClickListener(new AnonymousClass2());
        this.f6598i.setBackgroundColor(0);
        this.f6598i.setOnClickListener(new AnonymousClass3());
        this.f6599j.setBackgroundColor(0);
        this.f6599j.setOnClickListener(new AnonymousClass4());
        this.f6600k.setBackgroundColor(0);
        this.f6600k.setOnClickListener(new AnonymousClass5());
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
        WebSettings settings = this.f6596g.getSettings();
        this.f6596g.setHorizontalScrollBarEnabled(false);
        this.f6596g.setVerticalScrollBarEnabled(false);
        this.f6596g.setVerticalScrollBarEnabled(false);
        this.f6596g.requestFocus();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAllowFileAccess(false);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, Boolean.FALSE);
            } catch (Exception unused) {
            }
        }
        settings.setDatabaseEnabled(true);
        String path = getDir("database", 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        this.f6596g.setWebViewClient(new a(this));
        this.f6596g.setDownloadListener(new AnonymousClass1());
        am amVarA2 = com.anythink.core.basead.a.a.a(strA);
        this.a = amVarA2.f7205l;
        this.f6596g.loadUrl(amVarA2.f7208o);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        j jVar;
        super.onDestroy();
        WebView webView = this.f6596g;
        if (webView != null) {
            webView.destroy();
        }
        this.f6596g = null;
        i iVar = this.f6602m;
        if (iVar == null || (jVar = this.f6603n) == null) {
            return;
        }
        c.a(jVar.b, jVar.f7303d, iVar.d(), this.f6602m.p(), this.b, this.f6593c, this.f6594d, this.a, this.f6604o, this.f6603n.f7309j);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
        this.f6596g.setWebChromeClient(null);
        WebView webView = this.f6596g;
        if (isFinishing()) {
            webView.stopLoading();
            webView.loadUrl("");
        }
        webView.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
        this.f6596g.setWebChromeClient(new WebChromeClient() { // from class: com.anythink.core.basead.ui.web.WebLandPageActivity.6
            @Override // android.webkit.WebChromeClient
            public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                try {
                    callback.invoke(str, true, false);
                } catch (Throwable unused) {
                }
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }

            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView, int i2) {
                if (WebLandPageActivity.this.f6595f != null) {
                    WebLandPageActivity.this.f6595f.setProgress(i2);
                    if (i2 == 100) {
                        n.a().a(new Runnable() { // from class: com.anythink.core.basead.ui.web.WebLandPageActivity.6.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                WebLandPageActivity.this.f6595f.setVisibility(8);
                            }
                        }, 200L);
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                try {
                    WebLandPageActivity.this.f6607r = valueCallback;
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                    intent.setType("*/*");
                    intent.addCategory("android.intent.category.OPENABLE");
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                    WebLandPageActivity.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 512);
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
        this.f6596g.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    private void b() {
        Intent intent = getIntent();
        if (intent != null) {
            try {
                Serializable serializableExtra = intent.getSerializableExtra(a.C0154a.f6570c);
                if (serializableExtra != null && (serializableExtra instanceof i)) {
                    this.f6602m = (i) serializableExtra;
                    this.f6606q = new b(this.f6602m);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Serializable serializableExtra2 = intent.getSerializableExtra(a.C0154a.f6572e);
                if (serializableExtra2 != null && (serializableExtra2 instanceof j)) {
                    this.f6603n = (j) serializableExtra2;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                Serializable serializableExtra3 = intent.getSerializableExtra(a.C0154a.f6579l);
                if (serializableExtra3 != null && (serializableExtra3 instanceof IOfferClickHandler)) {
                    this.f6605p = (IOfferClickHandler) serializableExtra3;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                this.f6604o = intent.getStringExtra(a.C0154a.f6577j);
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        }
    }

    private void c() {
        this.f6597h.setBackgroundColor(0);
        this.f6597h.setOnClickListener(new AnonymousClass2());
        this.f6598i.setBackgroundColor(0);
        this.f6598i.setOnClickListener(new AnonymousClass3());
        this.f6599j.setBackgroundColor(0);
        this.f6599j.setOnClickListener(new AnonymousClass4());
        this.f6600k.setBackgroundColor(0);
        this.f6600k.setOnClickListener(new AnonymousClass5());
    }

    private void d() {
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    private View e() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-16777216);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(f6592e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, h.a(this, 55.0f));
        layoutParams.addRule(12);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(new ColorDrawable(-592138));
        int iA = h.a(this, 20.0f);
        linearLayout.setPadding(iA, 0, iA, 0);
        relativeLayout.addView(linearLayout);
        this.f6597h = a(getResources().getDrawable(h.a(this, "browser_unleft_icon", com.anythink.expressad.foundation.h.i.f10645c)));
        this.f6598i = a(getResources().getDrawable(h.a(this, "browser_unright_icon", com.anythink.expressad.foundation.h.i.f10645c)));
        this.f6599j = a(getResources().getDrawable(h.a(this, "browser_refresh_icon", com.anythink.expressad.foundation.h.i.f10645c)));
        this.f6600k = a(getResources().getDrawable(h.a(this, "browser_close_icon", com.anythink.expressad.foundation.h.i.f10645c)));
        linearLayout.addView(this.f6597h);
        linearLayout.addView(this.f6598i);
        linearLayout.addView(this.f6599j);
        linearLayout.addView(this.f6600k);
        this.f6596g = new BaseWebView(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, f6592e);
        this.f6596g.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.f6596g);
        View view = new View(this);
        view.setBackgroundColor(-2434342);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, h.a(this, 1.0f));
        layoutParams3.addRule(2, f6592e);
        view.setLayoutParams(layoutParams3);
        relativeLayout.addView(view);
        this.f6595f = new WebProgressBarView(this);
        this.f6595f.setProgress(0);
        relativeLayout.addView(this.f6595f, new RelativeLayout.LayoutParams(-1, h.a(this, 2.0f)));
        return relativeLayout;
    }

    public static void a(Context context, com.anythink.core.basead.b.a aVar) {
        Intent intent = new Intent();
        intent.setClass(context, WebLandPageActivity.class);
        intent.putExtra(a.C0154a.f6570c, aVar.f6586c);
        intent.putExtra(a.C0154a.f6572e, aVar.f6591h);
        intent.putExtra(a.C0154a.f6577j, aVar.f6589f);
        IOfferClickHandler iOfferClickHandler = aVar.f6590g;
        if (iOfferClickHandler != null) {
            intent.putExtra(a.C0154a.f6579l, iOfferClickHandler);
        }
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        context.startActivity(intent);
    }

    public static void a(Context context, String str) {
        com.anythink.core.basead.b.a aVar = new com.anythink.core.basead.b.a();
        aVar.f6589f = str;
        a(context, aVar);
    }

    private void a(boolean z2) {
        this.f6598i.setImageResource(z2 ? h.a(this, "browser_right_icon", com.anythink.expressad.foundation.h.i.f10645c) : h.a(this, "browser_unright_icon", com.anythink.expressad.foundation.h.i.f10645c));
    }

    private void b(boolean z2) {
        this.f6597h.setImageResource(z2 ? h.a(this, "browser_left_icon", com.anythink.expressad.foundation.h.i.f10645c) : h.a(this, "browser_unleft_icon", com.anythink.expressad.foundation.h.i.f10645c));
    }

    public final void a(WebView webView, String str) {
        JSONObject jSONObject;
        this.f6597h.setImageResource(webView.canGoBack() ? h.a(this, "browser_left_icon", com.anythink.expressad.foundation.h.i.f10645c) : h.a(this, "browser_unleft_icon", com.anythink.expressad.foundation.h.i.f10645c));
        this.f6598i.setImageResource(webView.canGoForward() ? h.a(this, "browser_right_icon", com.anythink.expressad.foundation.h.i.f10645c) : h.a(this, "browser_unright_icon", com.anythink.expressad.foundation.h.i.f10645c));
        b bVar = this.f6606q;
        if (bVar == null || (jSONObject = bVar.b) == null) {
            return;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && str != null && str.contains(next) && bVar.f6610c.get(next) == null) {
                    bVar.f6610c.put(next, Boolean.TRUE);
                    webView.loadUrl(bVar.b.optString(next));
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void b(String str) {
        if (this.b == null) {
            this.b = new JSONArray();
        }
        this.b.put(str);
    }

    private void a(String str) {
        WebSettings settings = this.f6596g.getSettings();
        this.f6596g.setHorizontalScrollBarEnabled(false);
        this.f6596g.setVerticalScrollBarEnabled(false);
        this.f6596g.setVerticalScrollBarEnabled(false);
        this.f6596g.requestFocus();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAllowFileAccess(false);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, Boolean.FALSE);
            } catch (Exception unused) {
            }
        }
        settings.setDatabaseEnabled(true);
        String path = getDir("database", 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        this.f6596g.setWebViewClient(new a(this));
        this.f6596g.setDownloadListener(new AnonymousClass1());
        am amVarA = com.anythink.core.basead.a.a.a(str);
        this.a = amVarA.f7205l;
        this.f6596g.loadUrl(amVarA.f7208o);
    }

    public final WebProgressBarView a() {
        return this.f6595f;
    }

    private ImageButton a(Drawable drawable) {
        ImageButton imageButton = new ImageButton(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, h.a(this, 35.0f), 1.0f);
        layoutParams.gravity = 16;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setBackgroundColor(0);
        imageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageButton.setImageDrawable(drawable);
        return imageButton;
    }

    protected final void a(am amVar) {
        this.a = amVar.f7205l;
        if (amVar.f7207n) {
            if (amVar.f7206m) {
                this.f6593c = 1;
                finish();
            } else {
                this.f6593c = 2;
            }
        }
    }
}
