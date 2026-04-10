package com.anythink.expressad.advanced.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.webkit.WebView;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends BroadcastReceiver {
    private static final String a = c.class.getSimpleName();
    private WebView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8142c;

    public c(WebView webView) {
        this.b = webView;
    }

    public final void a() {
        this.b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                a(this.b, 0);
                return;
            }
            if (!com.anythink.expressad.foundation.g.a.bW) {
                a(this.b, 0);
                return;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                a(this.b, 0);
                return;
            }
            if (activeNetworkInfo.getState() != NetworkInfo.State.CONNECTING && activeNetworkInfo.getState() != NetworkInfo.State.DISCONNECTING) {
                if (activeNetworkInfo.getType() == 1) {
                    a(this.b, 9);
                    return;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    a(this.b, 0);
                    return;
                }
                this.f8142c = telephonyManager.getNetworkType();
                this.f8142c = k.a(this.f8142c);
                a(this.b, this.f8142c);
            }
        } catch (Throwable th) {
            o.a(a, th.getMessage());
        }
    }

    private static void a(WebView webView, int i2) {
        if (webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(NativeAdvancedJsUtils.f8243m, i2);
                j.a();
                j.a(webView, NativeAdvancedJsUtils.f8242l, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Throwable th) {
                o.a(a, th.getMessage());
            }
        }
    }
}
