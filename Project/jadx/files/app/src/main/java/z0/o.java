package z0;

import a0.e;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebView;
import com.sntech.cc.Cdo;
import com.sntech.cc.data.ActionInfo;
import com.sntech.event.SNEvent;
import com.sntech.net.Cif;
import com.sntech.net.DomainProvider;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SNCCTask.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static o f21785c;
    public Context a;
    public String b;

    public static o a() {
        if (f21785c == null) {
            synchronized (o.class) {
                if (f21785c == null) {
                    f21785c = new o();
                }
            }
        }
        return f21785c;
    }

    public static void b(SNEvent.AdPlatform adPlatform, String str, SNEvent.AdType adType, SNEvent.AdEvent adEvent, String str2) {
        String string = adPlatform.toString();
        String string2 = adType.toString();
        String string3 = adEvent.toString();
        String string4 = SNEvent.EventSource.OFFICIAL.toString();
        HashMap map = new HashMap();
        map.put("show_id", str2);
        ActionInfo actionInfoA = m.a(string, str, string2, string3, string4, map);
        if (actionInfoA != null) {
            actionInfoA.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final float f2, final SNEvent.WithdrawChannel withdrawChannel, final String str2) {
        final String userAgentString = new WebView(this.a).getSettings().getUserAgentString();
        a0.g.f159d.execute(new Runnable() { // from class: z0.g
            @Override // java.lang.Runnable
            public final void run() {
                o.a(userAgentString, str, f2, withdrawChannel, str2);
            }
        });
    }

    public void a(final String str, final JSONObject jSONObject) {
        a0.g.f159d.execute(new Runnable() { // from class: z0.a
            @Override // java.lang.Runnable
            public final void run() {
                m.a(str, jSONObject);
            }
        });
    }

    public void a(final SNEvent.UserEvent userEvent) {
        a0.g.f159d.execute(new Runnable() { // from class: z0.j
            @Override // java.lang.Runnable
            public final void run() {
                m.a(userEvent.toString(), (JSONObject) null);
            }
        });
    }

    public static void b(String str, int i2, String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("test_name", str);
            jSONObject.put("test_version", i2);
            if (strArr != null) {
                jSONObject.put("user_tags", new JSONArray(strArr));
            }
        } catch (JSONException unused) {
        }
        StringBuilder sb = new StringBuilder();
        MediaType mediaType = a0.g.a;
        sb.append(DomainProvider.baseUrl());
        sb.append("/ab");
        Cif.m103if(sb.toString(), jSONObject, false, new n());
    }

    public synchronized void a(final SNEvent.AdPlatform adPlatform, final String str, final SNEvent.AdType adType, final SNEvent.AdEvent adEvent, final String str2) {
        new Thread(new Runnable() { // from class: z0.k
            @Override // java.lang.Runnable
            public final void run() {
                o.b(adPlatform, str, adType, adEvent, str2);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SNEvent.AdPlatform adPlatform, String str, SNEvent.AdType adType, SNEvent.AdEvent adEvent, float f2, float f3, double d2, String str2) {
        String string = adPlatform.toString();
        String string2 = adType.toString();
        String string3 = adEvent.toString();
        String string4 = SNEvent.EventSource.OFFICIAL.toString();
        String str3 = this.b;
        HashMap map = new HashMap();
        map.put("client_ad_uuid", str3);
        map.put("ecpm", Double.valueOf(d2));
        map.put("show_id", str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", f2);
            jSONObject.put("height", f3);
        } catch (JSONException unused) {
        }
        map.put("ad_size", jSONObject);
        ActionInfo actionInfoA = m.a(string, str, string2, string3, string4, map);
        if (actionInfoA != null) {
            actionInfoA.getData();
        }
    }

    public static void b(String str) {
        m.a(str, 0);
    }

    public void a(final String str, final int i2, final String... strArr) {
        a0.g.f159d.execute(new Runnable() { // from class: z0.d
            @Override // java.lang.Runnable
            public final void run() {
                o.b(str, i2, strArr);
            }
        });
    }

    public void a(final String str) {
        a0.g.f159d.execute(new Runnable() { // from class: z0.c
            @Override // java.lang.Runnable
            public final void run() {
                o.b(str);
            }
        });
    }

    public void a(final String str, final float f2, final SNEvent.WithdrawChannel withdrawChannel, final String str2) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: z0.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f21766s.b(str, f2, withdrawChannel, str2);
            }
        });
    }

    public static void a(String str, String str2, float f2, SNEvent.WithdrawChannel withdrawChannel, String str3) {
        StringBuilder sb = new StringBuilder();
        MediaType mediaType = a0.g.a;
        sb.append(DomainProvider.baseUrl());
        sb.append("/wr");
        String string = sb.toString();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("user_agent", str);
            jSONObject.put("developer_user_id", str2);
            jSONObject.put("withdraw_amount", f2);
            jSONObject.put("withdraw_channel", withdrawChannel.toString());
            jSONObject.put("withdraw_order_id", str3);
            Response responseExecute = a0.g.a().newCall(new Request.Builder().url(string).addHeader("Content-Encoding", "gzip").post(RequestBody.create(a0.g.a, e.c.a(m.a(jSONObject).toString().getBytes()))).build()).execute();
            if (responseExecute.isSuccessful()) {
                responseExecute.body().string();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(final Cdo.InterfaceC0505do interfaceC0505do) {
        final Looper looperMyLooper = Looper.myLooper();
        a0.g.f159d.execute(new Runnable() { // from class: z0.e
            @Override // java.lang.Runnable
            public final void run() {
                o.a(looperMyLooper, interfaceC0505do);
            }
        });
    }

    public static void a(Looper looper, final Cdo.InterfaceC0505do interfaceC0505do) {
        StringBuilder sb = new StringBuilder();
        MediaType mediaType = a0.g.a;
        sb.append(DomainProvider.baseUrl());
        sb.append("/jr");
        String string = sb.toString();
        final boolean z2 = false;
        try {
            Response responseExecute = a0.g.a().newCall(new Request.Builder().url(string).addHeader("Content-Encoding", "gzip").post(RequestBody.create(a0.g.a, e.c.a(m.a(new JSONObject()).toString().getBytes()))).build()).execute();
            if (responseExecute.isSuccessful()) {
                if (new JSONObject(new String(e.a.a(Base64.decode(responseExecute.body().string(), 0), "x04VOtkJji86dsmn".getBytes(), "x04VOtkJji86dsmn".getBytes()))).optInt("risk_user", 0) > 0) {
                    z2 = true;
                }
            }
        } catch (Exception unused) {
        }
        if (looper != null) {
            new Handler(looper).post(new Runnable() { // from class: z0.b
                @Override // java.lang.Runnable
                public final void run() {
                    interfaceC0505do.mo76do(Boolean.valueOf(z2));
                }
            });
        } else {
            interfaceC0505do.mo76do(Boolean.valueOf(z2));
        }
    }

    public synchronized void a(View view, final SNEvent.AdPlatform adPlatform, final String str, final SNEvent.AdType adType, final SNEvent.AdEvent adEvent, final double d2, final String str2) {
        final float height;
        final float width;
        StringBuilder sbA = y.b.a("localId-");
        sbA.append(System.currentTimeMillis());
        this.b = sbA.toString();
        if (view != null) {
            width = view.getWidth();
            height = view.getHeight();
        } else {
            DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
            float f2 = displayMetrics.widthPixels;
            height = displayMetrics.heightPixels;
            width = f2;
        }
        new Thread(new Runnable() { // from class: z0.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f21771s.a(adPlatform, str, adType, adEvent, width, height, d2, str2);
            }
        }).start();
    }
}
