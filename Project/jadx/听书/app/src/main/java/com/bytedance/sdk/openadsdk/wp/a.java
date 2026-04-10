package com.bytedance.sdk.openadsdk.wp;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.m;
import com.bytedance.sdk.component.g.z.uy;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.io.gc;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.wp.z.z;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements z {
    public static final AtomicInteger z = new AtomicInteger(0);
    private String m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<com.bytedance.sdk.openadsdk.wp.z.z> f1496a = new ArrayList();
    private HashMap<String, HashMap<String, byte[]>> gc = new HashMap<>();
    public AtomicInteger g = new AtomicInteger(0);
    final ExecutorService dl = e.z();

    public static boolean dl() {
        return true;
    }

    private String z(int i) {
        if (i == 100) {
            return "Continue";
        }
        if (i == 101) {
            return "Switching Protocols";
        }
        switch (i) {
            case 200:
                return "OK";
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative Information";
            case 204:
                return "No Content";
            case 205:
                return "Reset Content";
            case 206:
                return "Partial Content";
            default:
                switch (i) {
                    case MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL /* 400 */:
                        return "Bad Request";
                    case 401:
                        return "Unauthorized";
                    case 402:
                        return "Payment Required";
                    case 403:
                        return "Forbidden";
                    case 404:
                        return "Not Found";
                    case 405:
                        return "Method Not Allowed";
                    case 406:
                        return "Not Acceptable";
                    case 407:
                        return "Proxy Authentication Required";
                    case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                        return "Request Time-out";
                    case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                        return "Conflict";
                    case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                        return "Gone";
                    case TTAdConstant.IMAGE_CODE /* 411 */:
                        return "Length Required";
                    case TTAdConstant.IMAGE_URL_CODE /* 412 */:
                        return "Precondition Failed";
                    case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                        return "Request Entity Too Large";
                    case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                        return "Request-URI Too Large";
                    case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                        return "Unsupported Media Type";
                    case 416:
                        return "Requested range not satisfiable";
                    case TTAdConstant.LIVE_FEED_URL_CODE /* 417 */:
                        return "Expectation Failed";
                    default:
                        switch (i) {
                            case 500:
                                return "Internal Server Error";
                            case 501:
                                return "Not Implemented";
                            case TypedValues.Position.TYPE_DRAWPATH /* 502 */:
                                return "Bad Gateway";
                            case TypedValues.Position.TYPE_PERCENT_WIDTH /* 503 */:
                                return "Service Unavailable";
                            case TypedValues.Position.TYPE_PERCENT_HEIGHT /* 504 */:
                                return "Gateway Time-out";
                            case TypedValues.Position.TYPE_SIZE_PERCENT /* 505 */:
                                return "HTTP Version not supported";
                            default:
                                return "";
                        }
                }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z
    public AtomicInteger g() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z
    public HashMap<String, HashMap<String, byte[]>> z() {
        return this.gc;
    }

    public static dl z(na naVar, Context context) {
        boolean z2 = false;
        boolean z3 = naVar.tc() == 1;
        boolean z4 = com.bytedance.sdk.openadsdk.core.m.g.z(naVar.g() / 100.0f, false);
        boolean z5 = zw.g().j() == 1;
        boolean z6 = v.a(context) || !(zw.g().bv() == 1);
        boolean zDl = dl();
        boolean z7 = z3 && z5 && z6 && zDl;
        if (z4 && z5 && zDl) {
            z2 = true;
        }
        dl dlVar = new dl();
        dlVar.z(z7);
        dlVar.g(z2);
        return dlVar;
    }

    public static a z(Context context, na naVar, String str) {
        JSONObject jSONObjectEn;
        dl dlVarZ = z(naVar, context);
        if ((!dlVarZ.z() && !dlVarZ.g()) || (jSONObjectEn = naVar.en()) == null) {
            return null;
        }
        String strOptString = jSONObjectEn.optString(CmcdConfiguration.KEY_CONTENT_ID);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        String strOptString2 = jSONObjectEn.optString("req_id");
        if (TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new a(dlVarZ, strOptString, strOptString2, jSONObjectEn, naVar.vk(), str);
    }

    private a(dl dlVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        if (dlVar != null) {
            if (dlVar.z()) {
                com.bytedance.sdk.openadsdk.wp.z.g gVar = new com.bytedance.sdk.openadsdk.wp.z.g(this, str, str2, jSONObject, str3, str4);
                gVar.g();
                this.f1496a.add(gVar);
            }
            if (dlVar.g()) {
                com.bytedance.sdk.openadsdk.wp.z.dl dlVar2 = new com.bytedance.sdk.openadsdk.wp.z.dl(this, str, str2, jSONObject, str3, str4);
                dlVar2.g();
                this.f1496a.add(dlVar2);
            }
            this.m = str4;
            z.incrementAndGet();
            z((WebView) null, this.m);
        }
    }

    public WebResourceResponse z(WebView webView, g gVar, WebResourceResponse webResourceResponse) {
        Iterator<com.bytedance.sdk.openadsdk.wp.z.z> it = this.f1496a.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().z(webView)) {
                z2 = true;
            }
        }
        return !z2 ? webResourceResponse : g(webView, gVar, webResourceResponse);
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z
    public void z(final Runnable runnable) {
        this.dl.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.wp.a.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.dl) {
                    try {
                        runnable.run();
                    } finally {
                    }
                }
            }
        });
    }

    public WebResourceResponse g(WebView webView, final g gVar, WebResourceResponse webResourceResponse) {
        String strG;
        if (gVar != null && (strG = gVar.g()) != null && TextUtils.equals(strG, "get")) {
            if (zw.g().t() == 1) {
                WebResourceResponse webResourceResponseZ = z(zw.getContext(), this.m, gVar);
                if (webResourceResponseZ != null) {
                    webResourceResponseZ.getResponseHeaders().put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                    return webResourceResponseZ;
                }
            } else {
                z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.wp.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.z(zw.getContext(), a.this.m, gVar);
                    }
                });
            }
        }
        return webResourceResponse;
    }

    protected WebResourceResponse z(final Context context, final String str, final g gVar) {
        WebResourceResponse webResourceResponse;
        final Pair<WebResourceResponse, WebResourceResponse> pairZ;
        final Pair<WebResourceResponse, uy> pairZ2 = z(gVar);
        if (pairZ2 == null || (webResourceResponse = (WebResourceResponse) pairZ2.first) == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.openadsdk.wp.z.z> it = this.f1496a.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().z((uy) pairZ2.second)) {
                z2 = true;
            }
        }
        if (!z2 || (pairZ = z(webResourceResponse)) == null) {
            return null;
        }
        for (final com.bytedance.sdk.openadsdk.wp.z.z zVar : this.f1496a) {
            zVar.z(gVar, (WebResourceResponse) pairZ.second, (uy) pairZ2.second, new z.InterfaceC0227z() { // from class: com.bytedance.sdk.openadsdk.wp.a.3
                @Override // com.bytedance.sdk.openadsdk.wp.z.z.InterfaceC0227z
                public void z(boolean z3, final Map<String, Object> map) {
                    if (z3) {
                        a.this.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.wp.a.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (zVar.gc == null || zVar.gc.get()) {
                                        return;
                                    }
                                    a.this.z(context, str, gVar, (WebResourceResponse) pairZ.second, (uy) pairZ2.second, map, zVar);
                                } catch (Throwable th) {
                                    wp.z(th);
                                }
                            }
                        });
                    }
                }
            });
        }
        return (WebResourceResponse) pairZ.first;
    }

    protected void z(Context context, String str, g gVar, WebResourceResponse webResourceResponse, uy uyVar, Map<String, Object> map, com.bytedance.sdk.openadsdk.wp.z.z zVar) {
        if (zVar.z(uyVar)) {
            zw.g().jq();
            if (zw.g().jq() == 1) {
                zVar.z(context, str, gVar, webResourceResponse, uyVar, map);
            } else {
                zVar.g(context, str, gVar, webResourceResponse, uyVar, map);
            }
        }
    }

    private Pair<WebResourceResponse, WebResourceResponse> z(WebResourceResponse webResourceResponse) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (com.bytedance.sdk.openadsdk.wp.g.g.z(webResourceResponse.getData(), byteArrayOutputStream) != -1) {
                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                try {
                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                } catch (Exception e) {
                    e = e;
                    wp.z(e);
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        wp.z(th);
                    }
                    byteArrayInputStream2 = null;
                }
            } else {
                byteArrayInputStream2 = null;
                byteArrayInputStream = null;
            }
        } catch (Exception e2) {
            e = e2;
            byteArrayInputStream = null;
        }
        if (!dl()) {
            return null;
        }
        String mimeType = webResourceResponse.getMimeType();
        String encoding = webResourceResponse.getEncoding();
        int statusCode = webResourceResponse.getStatusCode();
        String reasonPhrase = webResourceResponse.getReasonPhrase();
        Map<String, String> responseHeaders = webResourceResponse.getResponseHeaders();
        if (byteArrayInputStream == null) {
            byteArrayInputStream = new ByteArrayInputStream(new byte[0]);
        }
        WebResourceResponse webResourceResponse2 = new WebResourceResponse(mimeType, encoding, statusCode, reasonPhrase, responseHeaders, byteArrayInputStream);
        String mimeType2 = webResourceResponse.getMimeType();
        String encoding2 = webResourceResponse.getEncoding();
        int statusCode2 = webResourceResponse.getStatusCode();
        String reasonPhrase2 = webResourceResponse.getReasonPhrase();
        Map<String, String> responseHeaders2 = webResourceResponse.getResponseHeaders();
        if (byteArrayInputStream2 == null) {
            byteArrayInputStream2 = new ByteArrayInputStream(new byte[0]);
        }
        return new Pair<>(webResourceResponse2, new WebResourceResponse(mimeType2, encoding2, statusCode2, reasonPhrase2, responseHeaders2, byteArrayInputStream2));
    }

    private Pair<WebResourceResponse, uy> z(g gVar) {
        if (dl() && gVar != null) {
            try {
                com.bytedance.sdk.component.g.z.wp wpVarM = gc.z().g().m();
                v.z zVar = new v.z();
                Map<String, String> mapDl = gVar.dl();
                if (mapDl != null) {
                    for (String str : mapDl.keySet()) {
                        zVar.g(str, mapDl.get(str));
                    }
                }
                zVar.z(gVar.z().toString());
                ls lsVarG = wpVarM.z(zVar.g()).g();
                int iDl = lsVarG.dl();
                if (iDl == 200) {
                    HashMap map = new HashMap();
                    m mVarE = lsVarG.e();
                    if (mVarE != null) {
                        for (int i = 0; i < mVarE.z(); i++) {
                            map.put(mVarE.z(i), mVarE.g(i));
                        }
                    }
                    InputStream inputStreamDl = lsVarG.m().dl();
                    uy uyVarZ = z(map);
                    return new Pair<>(new WebResourceResponse(uyVarZ.z() + "/" + uyVarZ.g(), uyVarZ.dl() == null ? null : uyVarZ.dl().toString(), iDl, z(iDl), map, inputStreamDl), uyVarZ);
                }
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.sdk.component.g.z.uy z(java.util.Map<java.lang.String, java.lang.String> r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L2f
            java.lang.String r0 = "Content-Type"
            boolean r1 = r3.containsKey(r0)
            if (r1 == 0) goto L11
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L30
        L11:
            java.lang.String r0 = "content-type"
            boolean r1 = r3.containsKey(r0)
            if (r1 == 0) goto L20
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L30
        L20:
            java.lang.String r0 = "CONTENT-TYPE"
            boolean r1 = r3.containsKey(r0)
            if (r1 == 0) goto L2f
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            goto L30
        L2f:
            r3 = 0
        L30:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L38
            java.lang.String r3 = "text/html; charset=UTF-8"
        L38:
            com.bytedance.sdk.component.g.z.uy r3 = com.bytedance.sdk.component.g.z.uy.z(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.wp.a.z(java.util.Map):com.bytedance.sdk.component.g.z.uy");
    }

    public static void z(Context context) {
        if (dl()) {
            try {
                File file = new File(g(context));
                if (System.currentTimeMillis() - file.lastModified() <= C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS || !file.exists()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.wp.g.z.g(g(context));
            } catch (Throwable th) {
                wp.z(th);
            }
        }
    }

    public static String g(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.g.g(context).getAbsolutePath() + File.separator + ".lp_cache";
    }

    public void a() {
        if (!this.f1496a.isEmpty()) {
            Iterator<com.bytedance.sdk.openadsdk.wp.z.z> it = this.f1496a.iterator();
            while (it.hasNext()) {
                it.next().dl();
            }
        }
        this.f1496a.clear();
    }

    public void z(WebView webView, String str) {
        if (com.bytedance.sdk.component.utils.v.z(str)) {
            this.g.incrementAndGet();
            this.g.get();
            Iterator<com.bytedance.sdk.openadsdk.wp.z.z> it = this.f1496a.iterator();
            while (it.hasNext()) {
                it.next().z(str);
            }
        }
    }
}
