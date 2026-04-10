package com.anythink.expressad.splash.js;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import anet.channel.entity.ConnType;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.a.b;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.splash.d.a;
import com.umeng.message.common.inter.ITagManager;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SplashExpandDialog extends Dialog {
    private final String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f11350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WindVaneWebView f11351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f11352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<c> f11354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f11355i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private IMraidJSBridge f11356j;

    /* JADX INFO: renamed from: com.anythink.expressad.splash.js.SplashExpandDialog$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SplashExpandDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.js.SplashExpandDialog$2, reason: invalid class name */
    class AnonymousClass2 extends b {
        AnonymousClass2() {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            StringBuilder sb = new StringBuilder("javascript:");
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            if (Build.VERSION.SDK_INT <= 19) {
                webView.loadUrl(sb.toString());
            } else {
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.anythink.expressad.splash.js.SplashExpandDialog.2.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str2) {
                    }
                });
            }
            SplashExpandDialog.a(SplashExpandDialog.this);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.js.SplashExpandDialog$3, reason: invalid class name */
    class AnonymousClass3 implements DialogInterface.OnDismissListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (SplashExpandDialog.this.f11355i != null) {
                SplashExpandDialog.this.f11355i.a(false);
                SplashExpandDialog.this.f11355i.c();
            }
            SplashExpandDialog.this.f11351e.loadDataWithBaseURL(null, "", "text/html", com.anythink.expressad.foundation.g.a.bN, null);
            SplashExpandDialog.this.f11350d.removeView(SplashExpandDialog.this.f11351e);
            SplashExpandDialog.this.f11351e.release();
            SplashExpandDialog.this.f11351e = null;
            SplashExpandDialog.this.f11355i = null;
        }
    }

    public SplashExpandDialog(Context context, Bundle bundle, a aVar) {
        super(context);
        this.a = "SplashExpandDialog";
        this.f11356j = new IMraidJSBridge() { // from class: com.anythink.expressad.splash.js.SplashExpandDialog.4
            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void close() {
                SplashExpandDialog.this.dismiss();
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void expand(String str, boolean z2) {
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public c getMraidCampaign() {
                return null;
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void open(String str) {
                try {
                    if (SplashExpandDialog.this.f11351e != null && System.currentTimeMillis() - SplashExpandDialog.this.f11351e.lastTouchTime > com.anythink.expressad.a.b.a.f8029c) {
                        c cVar = (c) SplashExpandDialog.this.f11354h.get(0);
                        SplashExpandDialog.this.f11351e.getUrl();
                        if (com.anythink.expressad.a.b.a.a(cVar)) {
                            return;
                        }
                    }
                    o.d("SplashExpandDialog", str);
                    if (SplashExpandDialog.this.f11354h.size() > 1) {
                        n.a().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        str = null;
                    }
                    if (SplashExpandDialog.this.f11355i != null) {
                        SplashExpandDialog.this.f11355i.b(str);
                    }
                } catch (Throwable th) {
                    o.b("SplashExpandDialog", ConnType.PK_OPEN, th);
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void unload() {
                close();
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void useCustomClose(boolean z2) {
                try {
                    SplashExpandDialog.this.f11352f.setVisibility(z2 ? 4 : 0);
                } catch (Throwable th) {
                    o.b("SplashExpandDialog", "useCustomClose", th);
                }
            }
        };
        if (bundle != null) {
            this.b = bundle.getString("url");
            this.f11349c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.f11355i = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        this.f11350d = new FrameLayout(getContext());
        this.f11350d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f11351e = new WindVaneWebView(getContext().getApplicationContext());
        this.f11351e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f11350d.addView(this.f11351e);
        this.f11352f = new TextView(getContext());
        this.f11352f.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f11352f.setLayoutParams(layoutParams);
        this.f11352f.setVisibility(this.f11349c ? 4 : 0);
        this.f11352f.setOnClickListener(new AnonymousClass1());
        this.f11350d.addView(this.f11352f);
        setContentView(this.f11350d);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 16) {
                getWindow().getDecorView().setSystemUiVisibility(i2 >= 19 ? 4615 : 519);
            }
        }
        this.f11351e.setWebViewListener(new AnonymousClass2());
        this.f11351e.setObject(this.f11356j);
        this.f11351e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
    }

    public void setCampaignList(String str, List<c> list) {
        this.f11353g = str;
        this.f11354h = list;
    }

    private void b() {
        try {
            int i2 = n.a().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i2 == 2 ? "landscape" : i2 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", ITagManager.STATUS_TRUE);
            float fE = k.e(n.a().g());
            float f2 = k.f(n.a().g());
            HashMap mapG = k.g(n.a().g());
            int iIntValue = ((Integer) mapG.get("width")).intValue();
            int iIntValue2 = ((Integer) mapG.get("height")).intValue();
            HashMap map = new HashMap();
            map.put(CallMraidJS.a, "Interstitial");
            map.put(CallMraidJS.b, CallMraidJS.f8284g);
            map.put(CallMraidJS.f8280c, ITagManager.STATUS_TRUE);
            map.put(CallMraidJS.f8281d, jSONObject);
            this.f11351e.getLocationInWindow(new int[2]);
            CallMraidJS.getInstance().fireSetDefaultPosition(this.f11351e, r0[0], r0[1], this.f11351e.getWidth(), this.f11351e.getHeight());
            CallMraidJS.getInstance().fireSetCurrentPosition(this.f11351e, r0[0], r0[1], this.f11351e.getWidth(), this.f11351e.getHeight());
            CallMraidJS.getInstance().fireSetScreenSize(this.f11351e, fE, f2);
            CallMraidJS.getInstance().fireSetMaxSize(this.f11351e, iIntValue, iIntValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(this.f11351e, map);
            CallMraidJS.getInstance().fireReadyEvent(this.f11351e);
        } catch (Throwable th) {
            o.b("SplashExpandDialog", "notifyMraid", th);
        }
    }

    private void a() {
        this.f11350d = new FrameLayout(getContext());
        this.f11350d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f11351e = new WindVaneWebView(getContext().getApplicationContext());
        this.f11351e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f11350d.addView(this.f11351e);
        this.f11352f = new TextView(getContext());
        this.f11352f.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f11352f.setLayoutParams(layoutParams);
        this.f11352f.setVisibility(this.f11349c ? 4 : 0);
        this.f11352f.setOnClickListener(new AnonymousClass1());
        this.f11350d.addView(this.f11352f);
        setContentView(this.f11350d);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 16) {
                getWindow().getDecorView().setSystemUiVisibility(i2 >= 19 ? 4615 : 519);
            }
        }
        this.f11351e.setWebViewListener(new AnonymousClass2());
        this.f11351e.setObject(this.f11356j);
        this.f11351e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
    }

    static /* synthetic */ void a(SplashExpandDialog splashExpandDialog) {
        try {
            int i2 = n.a().g().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i2 == 2 ? "landscape" : i2 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", ITagManager.STATUS_TRUE);
            float fE = k.e(n.a().g());
            float f2 = k.f(n.a().g());
            HashMap mapG = k.g(n.a().g());
            int iIntValue = ((Integer) mapG.get("width")).intValue();
            int iIntValue2 = ((Integer) mapG.get("height")).intValue();
            HashMap map = new HashMap();
            map.put(CallMraidJS.a, "Interstitial");
            map.put(CallMraidJS.b, CallMraidJS.f8284g);
            map.put(CallMraidJS.f8280c, ITagManager.STATUS_TRUE);
            map.put(CallMraidJS.f8281d, jSONObject);
            splashExpandDialog.f11351e.getLocationInWindow(new int[2]);
            CallMraidJS.getInstance().fireSetDefaultPosition(splashExpandDialog.f11351e, r1[0], r1[1], splashExpandDialog.f11351e.getWidth(), splashExpandDialog.f11351e.getHeight());
            CallMraidJS.getInstance().fireSetCurrentPosition(splashExpandDialog.f11351e, r1[0], r1[1], splashExpandDialog.f11351e.getWidth(), splashExpandDialog.f11351e.getHeight());
            CallMraidJS.getInstance().fireSetScreenSize(splashExpandDialog.f11351e, fE, f2);
            CallMraidJS.getInstance().fireSetMaxSize(splashExpandDialog.f11351e, iIntValue, iIntValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(splashExpandDialog.f11351e, map);
            CallMraidJS.getInstance().fireReadyEvent(splashExpandDialog.f11351e);
        } catch (Throwable th) {
            o.b("SplashExpandDialog", "notifyMraid", th);
        }
    }
}
