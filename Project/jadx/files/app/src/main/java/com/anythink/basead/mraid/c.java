package com.anythink.basead.mraid;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
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
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.umeng.message.common.inter.ITagManager;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Dialog {
    private final String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f6077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WindVaneWebView f6078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f6079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f6080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private IMraidJSBridge f6081h;

    /* JADX INFO: renamed from: com.anythink.basead.mraid.c$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.mraid.c$2, reason: invalid class name */
    final class AnonymousClass2 extends com.anythink.expressad.atsignalcommon.a.b {
        AnonymousClass2() {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            StringBuilder sb = new StringBuilder("javascript:");
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            if (Build.VERSION.SDK_INT <= 19) {
                webView.loadUrl(sb.toString());
            } else {
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.anythink.basead.mraid.c.2.1
                    private static void a() {
                    }

                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
            c.a(c.this);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.mraid.c$3, reason: invalid class name */
    final class AnonymousClass3 implements DialogInterface.OnDismissListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            c.this.f6078e.loadDataWithBaseURL(null, "", "text/html", com.anythink.expressad.foundation.g.a.bN, null);
            c.this.f6077d.removeView(c.this.f6078e);
            c.this.f6078e.release();
            c.this.f6078e = null;
            c.this.f6080g = null;
        }
    }

    public c(Context context, Bundle bundle, b bVar) {
        super(context);
        this.a = "BannerExpandDialog";
        this.f6081h = new IMraidJSBridge() { // from class: com.anythink.basead.mraid.c.4
            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final void close() {
                c.this.dismiss();
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final void expand(String str, boolean z2) {
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final com.anythink.expressad.foundation.d.c getMraidCampaign() {
                return null;
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final void open(String str) {
                try {
                    o.d("BannerExpandDialog", str);
                    if (c.this.f6080g != null) {
                        c.this.f6080g.open(str);
                    }
                } catch (Throwable th) {
                    o.b("BannerExpandDialog", ConnType.PK_OPEN, th);
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final void unload() {
                close();
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final void useCustomClose(boolean z2) {
                try {
                    c.this.f6079f.setVisibility(z2 ? 4 : 0);
                } catch (Throwable th) {
                    o.b("BannerExpandDialog", "useCustomClose", th);
                }
            }
        };
        this.b = bundle.getString("url");
        this.f6076c = bundle.getBoolean("shouldUseCustomClose");
        this.f6080g = bVar;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        this.f6077d = new FrameLayout(getContext());
        this.f6077d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f6078e = new WindVaneWebView(getContext().getApplicationContext());
        this.f6078e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f6077d.addView(this.f6078e);
        this.f6079f = new TextView(getContext());
        this.f6079f.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f6079f.setLayoutParams(layoutParams);
        this.f6079f.setVisibility(this.f6076c ? 4 : 0);
        this.f6079f.setOnClickListener(new AnonymousClass1());
        this.f6077d.addView(this.f6079f);
        setContentView(this.f6077d);
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
        this.f6078e.setWebViewListener(new AnonymousClass2());
        this.f6078e.setObject(this.f6081h);
        this.f6078e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
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
            this.f6078e.getLocationInWindow(new int[2]);
            CallMraidJS.getInstance().fireSetDefaultPosition(this.f6078e, r0[0], r0[1], this.f6078e.getWidth(), this.f6078e.getHeight());
            CallMraidJS.getInstance().fireSetCurrentPosition(this.f6078e, r0[0], r0[1], this.f6078e.getWidth(), this.f6078e.getHeight());
            CallMraidJS.getInstance().fireSetScreenSize(this.f6078e, fE, f2);
            CallMraidJS.getInstance().fireSetMaxSize(this.f6078e, iIntValue, iIntValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(this.f6078e, map);
            CallMraidJS.getInstance().fireReadyEvent(this.f6078e);
        } catch (Throwable th) {
            o.b("BannerExpandDialog", "notifyMraid", th);
        }
    }

    private void a() {
        this.f6077d = new FrameLayout(getContext());
        this.f6077d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f6078e = new WindVaneWebView(getContext().getApplicationContext());
        this.f6078e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f6077d.addView(this.f6078e);
        this.f6079f = new TextView(getContext());
        this.f6079f.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f6079f.setLayoutParams(layoutParams);
        this.f6079f.setVisibility(this.f6076c ? 4 : 0);
        this.f6079f.setOnClickListener(new AnonymousClass1());
        this.f6077d.addView(this.f6079f);
        setContentView(this.f6077d);
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
        this.f6078e.setWebViewListener(new AnonymousClass2());
        this.f6078e.setObject(this.f6081h);
        this.f6078e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
    }

    static /* synthetic */ void a(c cVar) {
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
            cVar.f6078e.getLocationInWindow(new int[2]);
            CallMraidJS.getInstance().fireSetDefaultPosition(cVar.f6078e, r1[0], r1[1], cVar.f6078e.getWidth(), cVar.f6078e.getHeight());
            CallMraidJS.getInstance().fireSetCurrentPosition(cVar.f6078e, r1[0], r1[1], cVar.f6078e.getWidth(), cVar.f6078e.getHeight());
            CallMraidJS.getInstance().fireSetScreenSize(cVar.f6078e, fE, f2);
            CallMraidJS.getInstance().fireSetMaxSize(cVar.f6078e, iIntValue, iIntValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(cVar.f6078e, map);
            CallMraidJS.getInstance().fireReadyEvent(cVar.f6078e);
        } catch (Throwable th) {
            o.b("BannerExpandDialog", "notifyMraid", th);
        }
    }
}
