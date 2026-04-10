package com.anythink.expressad.mbbanner.a.a;

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
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.umeng.message.common.inter.ITagManager;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Dialog {
    private final String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f10770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WindVaneWebView f10771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f10772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f10773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<com.anythink.expressad.foundation.d.c> f10774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.anythink.expressad.mbbanner.a.c.a f10775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private IMraidJSBridge f10776j;

    /* JADX INFO: renamed from: com.anythink.expressad.mbbanner.a.a.b$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.mbbanner.a.a.b$2, reason: invalid class name */
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
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.anythink.expressad.mbbanner.a.a.b.2.1
                    private static void a() {
                    }

                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
            b.a(b.this);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.mbbanner.a.a.b$3, reason: invalid class name */
    final class AnonymousClass3 implements DialogInterface.OnDismissListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            if (b.this.f10775i != null) {
                b.this.f10775i.a(false);
            }
            b.this.f10771e.loadDataWithBaseURL(null, "", "text/html", com.anythink.expressad.foundation.g.a.bN, null);
            b.this.f10770d.removeView(b.this.f10771e);
            b.this.f10771e.release();
            b.this.f10771e = null;
            b.this.f10775i = null;
        }
    }

    public b(Context context, Bundle bundle, com.anythink.expressad.mbbanner.a.c.a aVar) {
        super(context);
        this.a = "BannerExpandDialog";
        this.f10776j = new IMraidJSBridge() { // from class: com.anythink.expressad.mbbanner.a.a.b.4
            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public final void close() {
                b.this.dismiss();
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
                    if (b.this.f10771e != null && System.currentTimeMillis() - b.this.f10771e.lastTouchTime > com.anythink.expressad.a.b.a.f8029c) {
                        com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) b.this.f10774h.get(0);
                        b.this.f10771e.getUrl();
                        if (com.anythink.expressad.a.b.a.a(cVar)) {
                            return;
                        }
                    }
                    o.d("BannerExpandDialog", str);
                    if (b.this.f10774h.size() > 1) {
                        n.a().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        str = null;
                    }
                    if (b.this.f10775i != null) {
                        b.this.f10775i.a(true, str);
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
                    b.this.f10772f.setVisibility(z2 ? 4 : 0);
                } catch (Throwable th) {
                    o.b("BannerExpandDialog", "useCustomClose", th);
                }
            }
        };
        this.b = bundle.getString("url");
        this.f10769c = bundle.getBoolean("shouldUseCustomClose");
        this.f10775i = aVar;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        this.f10770d = new FrameLayout(getContext());
        this.f10770d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f10771e = new WindVaneWebView(getContext().getApplicationContext());
        this.f10771e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f10770d.addView(this.f10771e);
        this.f10772f = new TextView(getContext());
        this.f10772f.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f10772f.setLayoutParams(layoutParams);
        this.f10772f.setVisibility(this.f10769c ? 4 : 0);
        this.f10772f.setOnClickListener(new AnonymousClass1());
        this.f10770d.addView(this.f10772f);
        setContentView(this.f10770d);
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
        this.f10771e.setWebViewListener(new AnonymousClass2());
        this.f10771e.setObject(this.f10776j);
        this.f10771e.loadUrl(this.b);
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
            this.f10771e.getLocationInWindow(new int[2]);
            CallMraidJS.getInstance().fireSetDefaultPosition(this.f10771e, r0[0], r0[1], this.f10771e.getWidth(), this.f10771e.getHeight());
            CallMraidJS.getInstance().fireSetCurrentPosition(this.f10771e, r0[0], r0[1], this.f10771e.getWidth(), this.f10771e.getHeight());
            CallMraidJS.getInstance().fireSetScreenSize(this.f10771e, fE, f2);
            CallMraidJS.getInstance().fireSetMaxSize(this.f10771e, iIntValue, iIntValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(this.f10771e, map);
            CallMraidJS.getInstance().fireReadyEvent(this.f10771e);
        } catch (Throwable th) {
            o.b("BannerExpandDialog", "notifyMraid", th);
        }
    }

    private void a() {
        this.f10770d = new FrameLayout(getContext());
        this.f10770d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f10771e = new WindVaneWebView(getContext().getApplicationContext());
        this.f10771e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f10770d.addView(this.f10771e);
        this.f10772f = new TextView(getContext());
        this.f10772f.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f10772f.setLayoutParams(layoutParams);
        this.f10772f.setVisibility(this.f10769c ? 4 : 0);
        this.f10772f.setOnClickListener(new AnonymousClass1());
        this.f10770d.addView(this.f10772f);
        setContentView(this.f10770d);
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
        this.f10771e.setWebViewListener(new AnonymousClass2());
        this.f10771e.setObject(this.f10776j);
        this.f10771e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
    }

    public final void a(String str, List<com.anythink.expressad.foundation.d.c> list) {
        this.f10773g = str;
        this.f10774h = list;
    }

    static /* synthetic */ void a(b bVar) {
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
            bVar.f10771e.getLocationInWindow(new int[2]);
            CallMraidJS.getInstance().fireSetDefaultPosition(bVar.f10771e, r1[0], r1[1], bVar.f10771e.getWidth(), bVar.f10771e.getHeight());
            CallMraidJS.getInstance().fireSetCurrentPosition(bVar.f10771e, r1[0], r1[1], bVar.f10771e.getWidth(), bVar.f10771e.getHeight());
            CallMraidJS.getInstance().fireSetScreenSize(bVar.f10771e, fE, f2);
            CallMraidJS.getInstance().fireSetMaxSize(bVar.f10771e, iIntValue, iIntValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(bVar.f10771e, map);
            CallMraidJS.getInstance().fireReadyEvent(bVar.f10771e);
        } catch (Throwable th) {
            o.b("BannerExpandDialog", "notifyMraid", th);
        }
    }
}
