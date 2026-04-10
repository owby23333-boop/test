package com.bytedance.sdk.openadsdk.core.kb.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.kb.a.dl;
import com.bytedance.sdk.openadsdk.core.kb.a.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import com.ss.android.downloadlib.addownload.z.z;
import com.ss.android.socialbase.downloader.a.lq;
import com.ss.android.socialbase.downloader.a.x;
import com.ss.android.z.z.g.p;
import com.ss.android.z.z.g.q;
import com.ss.android.z.z.g.tb;
import com.ss.android.z.z.gc.z;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pf {
    public static com.bytedance.sdk.openadsdk.core.kb.a.a dl;
    private static Map<Integer, dl.z> e;
    private static final com.ss.android.z.z.dl.z.z fo;
    private static TTAdInteractionListener gz;
    private static Context m;
    public static volatile String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f1214a = new AtomicBoolean(false);
    private static final AtomicBoolean gc = new AtomicBoolean(false);
    public static boolean g = true;

    static {
        try {
            z = com.bytedance.sdk.openadsdk.api.plugin.g.z(getContext(), Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        fo = new com.ss.android.z.z.dl.z.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.8
            @Override // com.ss.android.z.z.dl.z.z
            public void z(com.ss.android.socialbase.downloader.e.dl dlVar, String str) {
                pf.dl(str);
            }
        };
    }

    public static void z(TTAdInteractionListener tTAdInteractionListener) {
        gz = tTAdInteractionListener;
    }

    public static TTAdInteractionListener z() {
        return gz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.kb.a.a e() {
        if (dl == null) {
            dl = i.a();
        }
        return dl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl(String str) {
        com.ss.android.g.z.g.g gVarZ;
        JSONObject jSONObjectE;
        if (TextUtils.isEmpty(str) || (gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(str)) == null || (jSONObjectE = gVarZ.e()) == null || e() == null) {
            return;
        }
        e().z(jSONObjectE, str);
    }

    public static void z(Context context) {
        if (context == null) {
            context = zw.getContext();
        }
        if (context == null) {
            return;
        }
        AtomicBoolean atomicBoolean = f1214a;
        if (!atomicBoolean.get()) {
            synchronized (pf.class) {
                if (!atomicBoolean.get()) {
                    m = context.getApplicationContext();
                    if (e() != null) {
                        String strZ = e().z(g);
                        if (!TextUtils.isEmpty(strZ)) {
                            z = strZ;
                        }
                    }
                    atomicBoolean.set(g(m));
                }
            }
        }
        if (atomicBoolean.get()) {
            AtomicBoolean atomicBoolean2 = gc;
            if (atomicBoolean2.compareAndSet(false, true)) {
                if ((e() != null ? e().g() : null) == null) {
                    atomicBoolean2.set(false);
                }
            }
        }
    }

    public static void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        z = str;
    }

    public static com.ss.android.downloadlib.uy g() {
        z(getContext());
        return com.ss.android.downloadlib.uy.z(getContext());
    }

    public static boolean z(Context context, Uri uri, com.ss.android.z.z.dl.dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar, p pVar) {
        return g().gc().z(context, uri, dlVar, gVar, zVar, pVar);
    }

    public static boolean z(Context context, Uri uri, com.ss.android.z.z.dl.dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar) {
        return g().gc().z(context, uri, dlVar, gVar, zVar);
    }

    public static boolean z(Uri uri) {
        return com.ss.android.downloadlib.g.uy.z(uri);
    }

    public static void dl() {
        g().e();
        if (e() != null) {
            e().g(z);
        }
    }

    public static void z(int i) {
        Map<Integer, dl.z> map = e;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }

    public static void z(int i, dl.z zVar) {
        if (zVar != null) {
            if (e == null) {
                e = Collections.synchronizedMap(new WeakHashMap());
            }
            e.put(Integer.valueOf(i), zVar);
        }
    }

    public static Map<Integer, dl.z> a() {
        return e;
    }

    public static boolean z(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, dl.z> mapA;
        boolean z2 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (mapA = a()) != null) {
            for (Map.Entry<Integer, dl.z> entry : mapA.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                dl.z value = entry.getValue();
                if (value != null) {
                    boolean z3 = value.z(iIntValue, jSONObject.toString(), str, str2, obj);
                    if (!z2 && !z3) {
                        z2 = true;
                    }
                }
            }
        }
        return z2;
    }

    private static boolean gz() {
        return UMModuleRegister.INNER.equals(gk.e);
    }

    private static boolean g(final Context context) {
        com.ss.android.z.z.z zVarZ;
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (gz()) {
            try {
                zVarZ = com.ss.android.downloadlib.uy.z(applicationContext).z("pangolin");
            } catch (Throwable unused) {
                zVarZ = com.ss.android.downloadlib.uy.z(applicationContext).z();
            }
        } else {
            zVarZ = com.ss.android.downloadlib.uy.z(applicationContext).z();
        }
        if (zVarZ == null) {
            return false;
        }
        zVarZ.z(new a()).z(new g()).z(new gc(applicationContext)).z(new dl()).z(new com.ss.android.socialbase.appdownloader.dl.e() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.5
            @Override // com.ss.android.socialbase.appdownloader.dl.e
            public Uri z(int i, String str, String str2) {
                return ls.z(context).z(str, str2);
            }
        }).z(new com.ss.android.socialbase.appdownloader.dl.dl() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.4
            @Override // com.ss.android.socialbase.appdownloader.dl.dl
            public Map<String, Object> z(Object obj) {
                if (com.bytedance.sdk.openadsdk.ls.dl.a.g(gk.dl)) {
                    return ls.z(context).z(obj);
                }
                return null;
            }
        }).z(new com.ss.android.z.z.g.wp() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.3
            @Override // com.ss.android.z.z.g.wp
            public JSONObject z() {
                return pf.fo();
            }
        }).z(new z()).z(new com.ss.android.z.z.g.g() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.2
            @Override // com.ss.android.z.z.g.g
            public boolean z() {
                if (pf.e() != null) {
                    return pf.e().dl();
                }
                return false;
            }
        }).z(new z.C0485z().g("143").z("open_news").dl(gk.f1105a).a(String.valueOf(gk.dl)).z()).z(new tb() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.1
            @Override // com.ss.android.z.z.g.tb
            public byte[] z(byte[] bArr, int i) {
                return new byte[0];
            }
        }).z(packageName + ".TTFileProvider").z(z(applicationContext, fo())).z();
        com.ss.android.downloadlib.e.z.z();
        if (!gk.e.equals(UMModuleRegister.INNER)) {
            com.ss.android.downloadlib.uy.z(applicationContext).a().z(1);
            com.ss.android.downloadlib.uy.z(applicationContext).z(fo);
            com.ss.android.socialbase.appdownloader.a.kb().z(new lq() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.6
                @Override // com.ss.android.socialbase.downloader.a.lq
                public boolean z(Intent intent) {
                    return false;
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject fo() {
        try {
            com.bytedance.sdk.openadsdk.core.kb.a.a aVarE = e();
            if (aVarE != null) {
                JSONObject jSONObjectZ = aVarE.z();
                if (jSONObjectZ.optInt("enable_app_install_receiver", 1) == 0) {
                    jSONObjectZ.put("enable_app_install_receiver", 0);
                }
                return jSONObjectZ;
            }
        } catch (Exception unused) {
        }
        return new JSONObject();
    }

    private static com.ss.android.socialbase.downloader.downloader.gz z(Context context, JSONObject jSONObject) {
        return new com.ss.android.socialbase.downloader.downloader.gz(context).z(new x() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.7
            @Override // com.ss.android.socialbase.downloader.a.x
            public JSONObject z() {
                return pf.fo();
            }
        }).z(new m());
    }

    public static boolean z(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<com.ss.android.socialbase.downloader.e.dl> listG = com.ss.android.socialbase.appdownloader.a.kb().g(context);
            if (!listG.isEmpty()) {
                for (com.ss.android.socialbase.downloader.e.dl dlVar : listG) {
                    if (dlVar != null && str.equals(dlVar.uy())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static Context getContext() {
        Context context = m;
        return context == null ? zw.getContext() : context;
    }

    public static Bundle z(int i, int i2, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        try {
            if (i2 == 101) {
                boolean zDl = eo.dl(m, str);
                String str5 = zDl ? TtmlNode.TEXT_EMPHASIS_MARK_OPEN : "install";
                if (zDl) {
                    bundle.putString(NotificationCompat.CATEGORY_MESSAGE, "open " + com.ss.android.downloadlib.e.fo.z(str).z());
                } else {
                    bundle.putString(NotificationCompat.CATEGORY_MESSAGE, "install ".concat(String.valueOf(com.ss.android.socialbase.appdownloader.a.z(m, i))));
                }
                com.bytedance.sdk.openadsdk.core.kb.gc.z(str2, str3, str4, str5, str, "media_install", (String) null, (String) null);
                bundle.putString(NotificationCompat.CATEGORY_MESSAGE, "success");
            } else {
                bundle.putString(NotificationCompat.CATEGORY_MESSAGE, "event_type:" + i + " not support");
            }
        } catch (Exception e2) {
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, e2.getMessage());
        }
        return bundle;
    }

    private static class a implements com.ss.android.z.z.g.uy {
        @Override // com.ss.android.z.z.g.uy
        public void z(Activity activity, int i, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.z.z.g.uy
        public void z(Activity activity, String[] strArr, final com.ss.android.z.z.g.zw zwVar) {
            if (pf.e() != null) {
                pf.e().z(activity, strArr, new com.bytedance.sdk.openadsdk.core.kb.a.m() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.a.1
                    @Override // com.bytedance.sdk.openadsdk.core.kb.a.m
                    public void z() {
                        com.ss.android.z.z.g.zw zwVar2 = zwVar;
                        if (zwVar2 != null) {
                            zwVar2.z();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kb.a.m
                    public void z(String str) {
                        com.ss.android.z.z.g.zw zwVar2 = zwVar;
                        if (zwVar2 != null) {
                            zwVar2.z(str);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.z.z.g.uy
        public boolean z(Context context, String str) {
            if (pf.e() != null) {
                return pf.e().z(context, str);
            }
            return false;
        }
    }

    private static class z implements com.ss.android.z.z.g.kb {
        private z() {
        }

        @Override // com.ss.android.z.z.g.kb
        public boolean z(com.ss.android.z.z.dl.dl dlVar, com.ss.android.socialbase.downloader.e.dl dlVar2) {
            com.bytedance.sdk.openadsdk.core.kb.a.a aVarE = pf.e();
            if (aVarE != null) {
                return aVarE.z(dlVar, dlVar2);
            }
            return false;
        }

        @Override // com.ss.android.z.z.g.kb
        public boolean g(com.ss.android.z.z.dl.dl dlVar, com.ss.android.socialbase.downloader.e.dl dlVar2) {
            com.bytedance.sdk.openadsdk.core.kb.a.a aVarE = pf.e();
            if (aVarE != null) {
                return aVarE.g(dlVar, dlVar2);
            }
            return false;
        }

        @Override // com.ss.android.z.z.g.kb
        public boolean z(com.ss.android.z.z.dl.dl dlVar) {
            com.bytedance.sdk.openadsdk.core.kb.a.a aVarE = pf.e();
            if (aVarE != null) {
                return aVarE.z(dlVar);
            }
            return false;
        }
    }

    private static class dl implements com.ss.android.z.z.g.fo {
        private dl() {
        }

        @Override // com.ss.android.z.z.g.fo
        public void z(String str, String str2, Map<String, Object> map, final q qVar) {
            str.hashCode();
            int i = 0;
            if (!str.equals("GET") && str.equals("POST")) {
                i = 1;
            }
            if (pf.e() != null) {
                pf.e().z(i, str2, map, new com.bytedance.sdk.openadsdk.core.kb.a.gc() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.dl.1
                    @Override // com.bytedance.sdk.openadsdk.core.kb.a.gc
                    public void z(String str3) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.z(str3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kb.a.gc
                    public void z(Throwable th) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.z(th);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.z.z.g.fo
        public void z(String str, byte[] bArr, String str2, int i, final q qVar) {
            if (pf.e() != null) {
                pf.e().z(str, bArr, str2, new com.bytedance.sdk.openadsdk.core.kb.a.gc() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.dl.2
                    @Override // com.bytedance.sdk.openadsdk.core.kb.a.gc
                    public void z(String str3) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.z(str3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kb.a.gc
                    public void z(Throwable th) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.z(th);
                        }
                    }
                });
            }
        }
    }

    public static class m implements com.ss.android.socialbase.downloader.fo.uy {
        @Override // com.ss.android.socialbase.downloader.fo.uy
        public com.ss.android.socialbase.downloader.fo.fo z(int i, String str, List<com.ss.android.socialbase.downloader.e.gc> list) throws IOException {
            final v.z zVarZ = v.z(str, list);
            if (zVarZ != null) {
                return new com.ss.android.socialbase.downloader.fo.fo() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.m.1
                    @Override // com.ss.android.socialbase.downloader.fo.e
                    public void dl() {
                    }

                    @Override // com.ss.android.socialbase.downloader.fo.fo
                    public InputStream z() {
                        return zVarZ.z;
                    }

                    @Override // com.ss.android.socialbase.downloader.fo.e
                    public String z(String str2) {
                        if (zVarZ.g != null) {
                            return zVarZ.g.get(str2);
                        }
                        return null;
                    }

                    @Override // com.ss.android.socialbase.downloader.fo.e
                    public int g() {
                        return zVarZ.dl;
                    }

                    @Override // com.ss.android.socialbase.downloader.fo.fo
                    public void a() {
                        try {
                            zVarZ.f1215a.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                };
            }
            return null;
        }
    }

    public static class gc implements com.ss.android.z.z.g.v {
        private final WeakReference<Context> z;

        public gc(Context context) {
            this.z = new WeakReference<>(context);
        }

        @Override // com.ss.android.z.z.g.v
        public void z(int i, Context context, com.ss.android.z.z.dl.dl dlVar, String str, Drawable drawable, int i2) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.a("LibUIFactory", "showToastWithDuration e " + e.getMessage());
            }
        }

        @Override // com.ss.android.z.z.g.v
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public AlertDialog g(com.ss.android.z.z.gc.dl dlVar) {
            if (dlVar != null && pf.e() != null) {
                if (dlVar.z != null && (dlVar.z instanceof Activity)) {
                    return pf.e().z((Activity) dlVar.z, dlVar.uy == 1, dl(dlVar));
                }
                pf.e().z(this.z, dlVar.uy == 1, dl(dlVar));
            }
            return null;
        }

        private com.bytedance.sdk.openadsdk.core.kb.a.z dl(final com.ss.android.z.z.gc.dl dlVar) {
            return com.bytedance.sdk.openadsdk.core.kb.a.z.z().z(dlVar.g).g(dlVar.dl).a(dlVar.gc).dl(dlVar.f2121a).z(dlVar.e).z(new com.bytedance.sdk.openadsdk.core.kb.a.g() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.gc.1
                @Override // com.bytedance.sdk.openadsdk.core.kb.a.g
                public void z(DialogInterface dialogInterface) {
                    if (dlVar.gz != null) {
                        dlVar.gz.z(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.a.g
                public void g(DialogInterface dialogInterface) {
                    if (dlVar.gz != null) {
                        try {
                            dlVar.gz.g(dialogInterface);
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.wp.z(e);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.a.g
                public void dl(DialogInterface dialogInterface) {
                    if (dlVar.gz != null) {
                        dlVar.gz.dl(dialogInterface);
                    }
                }
            });
        }
    }

    public static class g implements com.ss.android.z.z.g.e {
        @Override // com.ss.android.z.z.g.e
        public void z(com.ss.android.z.z.gc.a aVar) {
            z(aVar, true);
        }

        @Override // com.ss.android.z.z.g.e
        public void g(com.ss.android.z.z.gc.a aVar) {
            z(aVar, false);
            dl(aVar);
        }

        private void dl(com.ss.android.z.z.gc.a aVar) {
            if (aVar == null) {
                return;
            }
            Object objWp = aVar.wp();
            gz gzVarG = gz.z().z(aVar.g()).g(aVar.gz()).z(objWp instanceof JSONObject ? (JSONObject) objWp : null).g(aVar.dl());
            boolean z = "download_notification".equals(aVar.g()) || "landing_h5_download_ad_button".equals(aVar.g());
            if (pf.e() != null) {
                pf.e().z(gzVarG, z);
            }
        }

        private void z(com.ss.android.z.z.gc.a aVar, boolean z) {
            e eVarG;
            if (pf.e() == null || (eVarG = pf.e().g()) == null || aVar == null) {
                return;
            }
            if (eVarG.z() && pf.e().z(aVar.toString())) {
                return;
            }
            if (z) {
                pf.g(aVar);
            } else {
                pf.g(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject g(com.ss.android.z.z.gc.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", aVar.z());
            jSONObject.put("tag", aVar.g());
            jSONObject.put("label", aVar.dl());
            jSONObject.put("isAd", aVar.a());
            jSONObject.put("adId", aVar.gc());
            jSONObject.put("logExtra", aVar.m());
            jSONObject.put("extValue", aVar.e());
            jSONObject.put("extJson", aVar.gz());
            jSONObject.put("paramsJson", aVar.fo());
            jSONObject.put("eventSource", aVar.kb());
            jSONObject.put("extraObject", aVar.wp());
            jSONObject.put("clickTrackUrl", aVar.uy());
            jSONObject.put("isV3", aVar.i());
            jSONObject.put("V3EventName", aVar.v());
            jSONObject.put("V3EventParams", aVar.pf());
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
        return jSONObject;
    }

    public static boolean z(Activity activity, final com.bytedance.sdk.openadsdk.ls.dl.z.z zVar) {
        return com.ss.android.downloadlib.addownload.z.z.z().z(activity, false, new z.InterfaceC0441z() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.pf.9
            @Override // com.ss.android.downloadlib.addownload.z.z.InterfaceC0441z
            public void z() {
                com.bytedance.sdk.openadsdk.ls.dl.z.z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.z();
                }
            }
        });
    }
}
