package com.anythink.expressad.advanced.js;

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
import com.anythink.expressad.advanced.d.a;
import com.anythink.expressad.atsignalcommon.a.b;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.umeng.message.common.inter.ITagManager;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeAdvancedExpandDialog extends Dialog {
    private final String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f8217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WindVaneWebView f8218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f8219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f8220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<c> f8221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f8222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private IMraidJSBridge f8223j;

    /* JADX INFO: renamed from: com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NativeAdvancedExpandDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog$2, reason: invalid class name */
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
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.2.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str2) {
                    }
                });
            }
            NativeAdvancedExpandDialog.a(NativeAdvancedExpandDialog.this);
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog$3, reason: invalid class name */
    class AnonymousClass3 implements DialogInterface.OnDismissListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (NativeAdvancedExpandDialog.this.f8222i != null) {
                NativeAdvancedExpandDialog.this.f8222i.a(false);
            }
            NativeAdvancedExpandDialog.this.f8218e.loadDataWithBaseURL(null, "", "text/html", com.anythink.expressad.foundation.g.a.bN, null);
            NativeAdvancedExpandDialog.this.f8217d.removeView(NativeAdvancedExpandDialog.this.f8218e);
            NativeAdvancedExpandDialog.this.f8218e.release();
            NativeAdvancedExpandDialog.this.f8218e = null;
            NativeAdvancedExpandDialog.this.f8222i = null;
        }
    }

    public NativeAdvancedExpandDialog(Context context, Bundle bundle, a aVar) {
        super(context);
        this.a = "NativeAdvancedExpandDialog";
        this.f8223j = new IMraidJSBridge() { // from class: com.anythink.expressad.advanced.js.NativeAdvancedExpandDialog.4
            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void close() {
                NativeAdvancedExpandDialog.this.dismiss();
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
                    if (NativeAdvancedExpandDialog.this.f8218e != null && System.currentTimeMillis() - NativeAdvancedExpandDialog.this.f8218e.lastTouchTime > com.anythink.expressad.a.b.a.f8029c) {
                        c cVar = (c) NativeAdvancedExpandDialog.this.f8221h.get(0);
                        NativeAdvancedExpandDialog.this.f8218e.getUrl();
                        if (com.anythink.expressad.a.b.a.a(cVar)) {
                            return;
                        }
                    }
                    o.d("NativeAdvancedExpandDialog", str);
                    if (NativeAdvancedExpandDialog.this.f8221h.size() > 1) {
                        n.a().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        str = null;
                    }
                    if (NativeAdvancedExpandDialog.this.f8222i != null) {
                        NativeAdvancedExpandDialog.this.f8222i.a(str);
                    }
                } catch (Throwable th) {
                    o.b("NativeAdvancedExpandDialog", ConnType.PK_OPEN, th);
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void unload() {
                close();
            }

            @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
            public void useCustomClose(boolean z2) {
                try {
                    NativeAdvancedExpandDialog.this.f8219f.setVisibility(z2 ? 4 : 0);
                } catch (Throwable th) {
                    o.b("NativeAdvancedExpandDialog", "useCustomClose", th);
                }
            }
        };
        if (bundle != null) {
            this.b = bundle.getString("url");
            this.f8216c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.f8222i = aVar;
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
        this.f8217d = new FrameLayout(getContext());
        this.f8217d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f8218e = new WindVaneWebView(getContext().getApplicationContext());
        this.f8218e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f8217d.addView(this.f8218e);
        this.f8219f = new TextView(getContext());
        this.f8219f.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f8219f.setLayoutParams(layoutParams);
        this.f8219f.setVisibility(this.f8216c ? 4 : 0);
        this.f8219f.setOnClickListener(new AnonymousClass1());
        this.f8217d.addView(this.f8219f);
        setContentView(this.f8217d);
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
        this.f8218e.setWebViewListener(new AnonymousClass2());
        this.f8218e.setObject(this.f8223j);
        this.f8218e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
    }

    public void setCampaignList(String str, List<c> list) {
        this.f8220g = str;
        this.f8221h = list;
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
            map.put(CallMraidJS.a, CallMraidJS.f8288k);
            map.put(CallMraidJS.b, CallMraidJS.f8284g);
            map.put(CallMraidJS.f8280c, ITagManager.STATUS_TRUE);
            map.put(CallMraidJS.f8281d, jSONObject);
            this.f8218e.getLocationInWindow(new int[2]);
            CallMraidJS.getInstance().fireSetDefaultPosition(this.f8218e, r0[0], r0[1], this.f8218e.getWidth(), this.f8218e.getHeight());
            CallMraidJS.getInstance().fireSetCurrentPosition(this.f8218e, r0[0], r0[1], this.f8218e.getWidth(), this.f8218e.getHeight());
            CallMraidJS.getInstance().fireSetScreenSize(this.f8218e, fE, f2);
            CallMraidJS.getInstance().fireSetMaxSize(this.f8218e, iIntValue, iIntValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(this.f8218e, map);
            CallMraidJS.getInstance().fireReadyEvent(this.f8218e);
        } catch (Throwable th) {
            o.b("NativeAdvancedExpandDialog", "notifyMraid", th);
        }
    }

    private void a() {
        this.f8217d = new FrameLayout(getContext());
        this.f8217d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f8218e = new WindVaneWebView(getContext().getApplicationContext());
        this.f8218e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f8217d.addView(this.f8218e);
        this.f8219f = new TextView(getContext());
        this.f8219f.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f8219f.setLayoutParams(layoutParams);
        this.f8219f.setVisibility(this.f8216c ? 4 : 0);
        this.f8219f.setOnClickListener(new AnonymousClass1());
        this.f8217d.addView(this.f8219f);
        setContentView(this.f8217d);
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
        this.f8218e.setWebViewListener(new AnonymousClass2());
        this.f8218e.setObject(this.f8223j);
        this.f8218e.loadUrl(this.b);
        setOnDismissListener(new AnonymousClass3());
    }

    static /* synthetic */ void a(NativeAdvancedExpandDialog nativeAdvancedExpandDialog) {
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
            map.put(CallMraidJS.a, CallMraidJS.f8288k);
            map.put(CallMraidJS.b, CallMraidJS.f8284g);
            map.put(CallMraidJS.f8280c, ITagManager.STATUS_TRUE);
            map.put(CallMraidJS.f8281d, jSONObject);
            nativeAdvancedExpandDialog.f8218e.getLocationInWindow(new int[2]);
            CallMraidJS.getInstance().fireSetDefaultPosition(nativeAdvancedExpandDialog.f8218e, r1[0], r1[1], nativeAdvancedExpandDialog.f8218e.getWidth(), nativeAdvancedExpandDialog.f8218e.getHeight());
            CallMraidJS.getInstance().fireSetCurrentPosition(nativeAdvancedExpandDialog.f8218e, r1[0], r1[1], nativeAdvancedExpandDialog.f8218e.getWidth(), nativeAdvancedExpandDialog.f8218e.getHeight());
            CallMraidJS.getInstance().fireSetScreenSize(nativeAdvancedExpandDialog.f8218e, fE, f2);
            CallMraidJS.getInstance().fireSetMaxSize(nativeAdvancedExpandDialog.f8218e, iIntValue, iIntValue2);
            CallMraidJS.getInstance().fireChangeEventForPropertys(nativeAdvancedExpandDialog.f8218e, map);
            CallMraidJS.getInstance().fireReadyEvent(nativeAdvancedExpandDialog.f8218e);
        } catch (Throwable th) {
            o.b("NativeAdvancedExpandDialog", "notifyMraid", th);
        }
    }
}
