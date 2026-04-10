package com.bytedance.sdk.openadsdk.wp.z;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.pf;
import com.bytedance.sdk.component.g.z.uy;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.utils.gc;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.wp.z.z;
import com.funny.audio.core.utils.FileUtils;
import com.kwad.sdk.api.model.AdnName;
import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    private static final ConcurrentLinkedDeque<String> gz = new ConcurrentLinkedDeque<>();
    private long fo;
    private String kb;
    private final String uy;

    public boolean a() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void z(String str) {
    }

    public g(com.bytedance.sdk.openadsdk.wp.z zVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(zVar, str, str2, jSONObject, str3, str4);
        this.uy = "index_censorship.json";
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void z(final String str, final String str2) {
        v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.wp.z.g.1
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, str);
                    jSONObject.put("req_id", str2);
                } catch (Exception e) {
                    wp.z(e);
                }
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("web_upload_start").g(jSONObject.toString());
            }
        }, "web_upload_start");
    }

    public void z(final String str, final String str2, final long j, final String str3, final long j2, final long j3) {
        v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.wp.z.g.2
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, str);
                    jSONObject.put("req_id", str2);
                    jSONObject.put("duration", System.currentTimeMillis() - j);
                    jSONObject.put("weburl", str3);
                    jSONObject.put("size", j2);
                    jSONObject.put("avail_mem", j3);
                } catch (Exception e) {
                    wp.z(e);
                }
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("web_upload_finish").g(jSONObject.toString());
            }
        }, "web_upload_finish");
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public boolean z(WebView webView) {
        if (webView == null || gz.contains(this.g)) {
            return true;
        }
        return (this.gc != null && this.gc.get()) || this.z.g().get() > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(android.content.Context r9, java.lang.String r10, com.bytedance.sdk.openadsdk.wp.g r11, android.webkit.WebResourceResponse r12, com.bytedance.sdk.component.g.z.uy r13, java.util.Map<java.lang.String, java.lang.Object> r14) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.wp.z.g.z(android.content.Context, java.lang.String, com.bytedance.sdk.openadsdk.wp.g, android.webkit.WebResourceResponse, com.bytedance.sdk.component.g.z.uy, java.util.Map):void");
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    protected void z(JSONObject jSONObject, String str, uy uyVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("name", str2);
            jSONObject2.putOpt("url", str3);
            if (map != null) {
                jSONObject2.putOpt("request_headers", new JSONObject(map));
            }
            if (uyVar != null) {
                String lowerCase = uyVar.toString().toLowerCase();
                if (lowerCase.contains("image")) {
                    z(jSONObject2, jSONObject, "sub_pic");
                    return;
                }
                if (!lowerCase.contains("js") && !lowerCase.contains("javascript")) {
                    if (lowerCase.contains("css")) {
                        z(jSONObject2, jSONObject, "css");
                        return;
                    } else {
                        if (lowerCase.contains("html")) {
                            z(jSONObject2, jSONObject, "html");
                            return;
                        }
                        return;
                    }
                }
                z(jSONObject2, jSONObject, "js");
                return;
            }
            z(jSONObject2, jSONObject, AdnName.OTHER);
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    private void z(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(str);
            if (jSONArrayOptJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.m.putOpt(str, jSONArray);
            } else {
                jSONArrayOptJSONArray.put(jSONObject);
                this.m.putOpt(str, jSONArrayOptJSONArray);
            }
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void z() {
        try {
            this.m.putOpt("html", new JSONArray());
            this.m.putOpt("js", new JSONArray());
            this.m.putOpt("css", new JSONArray());
            this.m.putOpt("sub_pic", new JSONArray());
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public boolean z(uy uyVar) {
        try {
            Set<String> setGp = zw.g().gp();
            String str = uyVar.z().trim().toLowerCase() + "/" + uyVar.g().trim().toLowerCase();
            new StringBuilder("contentType======>").append(setGp);
            return setGp.contains(str);
        } catch (Exception e) {
            wp.z(e);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void z(com.bytedance.sdk.openadsdk.wp.g gVar, WebResourceResponse webResourceResponse, uy uyVar, z.InterfaceC0227z interfaceC0227z) {
        interfaceC0227z.z(true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(File file, String str, Context context, long j, long j2) {
        try {
            com.bytedance.sdk.openadsdk.wp.g.z.g(str);
            if (file != null && file.exists()) {
                file.delete();
            }
            int i = com.bytedance.sdk.openadsdk.wp.a.z.get();
            if (i > 0) {
                com.bytedance.sdk.openadsdk.wp.a.z.decrementAndGet();
            }
            if (i == 0) {
                com.bytedance.sdk.openadsdk.wp.g.z.g(com.bytedance.sdk.openadsdk.wp.a.g(context));
            }
            z(this.g, this.dl, this.fo, this.e, j, j2);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    private byte[] z(byte[] bArr, int i) {
        return com.bytedance.sdk.openadsdk.hh.g.z(bArr, i);
    }

    private String z(Context context) {
        String str = this.kb;
        if (str != null) {
            return str;
        }
        try {
            String str2 = com.bytedance.sdk.openadsdk.wp.a.g(context) + File.separator + this.g;
            this.kb = str2;
            return str2;
        } catch (Exception e) {
            wp.z(e);
            return File.separator + ".lp_cache" + File.separator + this.g;
        }
    }

    private boolean g(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.bytedance.sdk.openadsdk.wp.g.g.z(str, str2);
            return true;
        } catch (Throwable th) {
            wp.z(th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void g(Context context, String str, com.bytedance.sdk.openadsdk.wp.g gVar, WebResourceResponse webResourceResponse, uy uyVar, Map<String, Object> map) {
        try {
            if (com.bytedance.sdk.openadsdk.wp.a.dl()) {
                String strZ = z(context);
                String string = gVar.z().toString();
                String strG = uyVar.g();
                if (TextUtils.equals(strG.toLowerCase(), "javascript")) {
                    strG = "js";
                }
                File file = new File(strZ);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str2 = gc.g(string) + FileUtils.FILE_EXTENSION_SEPARATOR + strG;
                File file2 = new File(strZ, str2);
                if (file2.exists()) {
                    file2.delete();
                    file2.createNewFile();
                }
                file2.getAbsolutePath();
                zw.g().vm();
                if (com.bytedance.sdk.openadsdk.wp.g.z.z(webResourceResponse.getData(), strZ, str2, zw.g().vm())) {
                    z(this.m, str, uyVar, str2, string, gVar.dl(), map);
                }
            }
        } catch (Exception e) {
            wp.z(e);
            e.getMessage();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void dl() {
        if (gz.contains(this.g)) {
            this.z.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.wp.z.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.z(null, com.bytedance.sdk.openadsdk.wp.a.g(zw.getContext()), zw.getContext(), -1L, -1L);
                }
            });
        } else if (this.f1500a.compareAndSet(false, true)) {
            this.z.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.wp.z.g.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        g.this.gc.set(true);
                        g.this.gc();
                        g.this.f1500a.set(false);
                    } catch (Throwable th) {
                        wp.z(th);
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x019f A[Catch: Exception -> 0x01b8, LOOP:0: B:85:0x019f->B:87:0x01a7, LOOP_START, TryCatch #3 {Exception -> 0x01b8, blocks: (B:83:0x019b, B:85:0x019f, B:87:0x01a7, B:88:0x01ab, B:90:0x01b3), top: B:94:0x019b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void gc() {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.wp.z.g.gc():void");
    }

    private int z(byte[] bArr, int i, File file) {
        try {
            ls lsVarG = com.bytedance.sdk.openadsdk.core.io.gc.z().g().m().z(new v.z().z(zw.g().gb() + ("?aid=" + com.bytedance.sdk.openadsdk.core.uy.ls().q() + "&device_platform=android&device_type=android&source_type=union")).z(pf.z(uy.z("multipart/form-data"), bArr, FileUtils.URI_TYPE_FILE, file.getName())).g()).g();
            if (lsVarG.dl() == 200) {
                JSONObject jSONObject = new JSONObject(lsVarG.m().g());
                int iOptInt = jSONObject.optInt("code");
                String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                if (iOptInt == 0 && TextUtils.equals("success", strOptString)) {
                    return 200;
                }
                return g(bArr, i, file);
            }
            return g(bArr, i, file);
        } catch (Throwable th) {
            wp.z(th);
            th.getMessage();
            return g(bArr, i, file);
        }
    }

    private int g(byte[] bArr, int i, File file) {
        if (i <= 0) {
            return -1;
        }
        return z(bArr, i - 1, file);
    }
}
