package com.bytedance.sdk.openadsdk.core.q;

import android.content.Context;
import android.text.TextUtils;
import androidx.media3.session.MediaController;
import com.bytedance.sdk.component.gz.z.z;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static final Set<String> gc;
    public static final String z = UUID.randomUUID().toString();
    public static AtomicInteger g = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1299a = "_create";
    public static final AtomicBoolean dl = new AtomicBoolean(false);

    static {
        HashSet hashSet = new HashSet();
        gc = hashSet;
        hashSet.add("click_start");
        hashSet.add("download_start");
        hashSet.add("download_finish");
        hashSet.add("install_finish");
        hashSet.add("click");
        hashSet.add("show");
    }

    public static void z(Context context, boolean z2) {
        if (dl.compareAndSet(false, true) || com.bytedance.sdk.component.gz.g.z.z("csj")) {
            g(context, z2);
            com.bytedance.sdk.component.utils.gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.q.g.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.gz.g.z.a("csj");
                }
            }, com.bytedance.sdk.openadsdk.core.uy.ls().e() ? 20000L : MediaController.RELEASE_UNBIND_TIMEOUT_MS);
        }
    }

    private static void g(Context context, boolean z2) {
        if (context == null) {
            return;
        }
        int iTi = zw.g().ti();
        if (iTi <= 0 || iTi == Integer.MAX_VALUE) {
            iTi = 100;
        }
        int iSy = zw.g().sy();
        if (iSy > iTi) {
            iSy = 5;
            iTi = 10;
        }
        com.bytedance.sdk.component.gz.g.z.z(new z.C0136z().dl(com.bytedance.sdk.component.gz.g.a.g.z.z(iSy, iTi)).z(com.bytedance.sdk.component.gz.g.a.g.z.z(1, iTi)).g(com.bytedance.sdk.component.gz.g.a.g.z.z(1, iTi)).g(z2).z("csj").z(context).z(new fo()).z(gz.z).z(zw.g().h()).z());
    }

    public static void z() {
        com.bytedance.sdk.component.gz.g.z.z(false, "csj");
    }

    public static void z(com.bytedance.sdk.component.gz.g.a.z.z zVar, String str, int i) {
        if (com.bytedance.sdk.component.gz.g.z.z("csj")) {
            z(zw.getContext(), com.bytedance.sdk.openadsdk.core.multipro.g.dl());
        }
        if (zw.g().cb()) {
            return;
        }
        com.bytedance.sdk.component.gz.g.z.z(zVar, "csj");
    }

    public static void g() {
        com.bytedance.sdk.component.gz.g.z.z(gz.z, "csj");
    }

    private static void z(String str, com.bytedance.sdk.component.gz.g.a.z.z zVar) {
        if (zw.g().tb()) {
            try {
                zVar.dl(com.bytedance.sdk.component.gz.g.dl.z.g(str));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.dl(e.getMessage());
            }
        }
    }

    public static void z(com.bytedance.sdk.openadsdk.core.i.z zVar, String str) {
        if (!zw.g().cb() || gc.contains(str)) {
            com.bytedance.sdk.component.gz.g.a.z.z zVar2 = new com.bytedance.sdk.component.gz.g.a.z.z(zVar.a(), zVar);
            zVar2.g(zVar.m() ? (byte) 1 : (byte) 2);
            zVar2.z((byte) 0);
            z(zVar.dl(), zVar2);
            if (com.bytedance.sdk.component.gz.g.z.z("csj")) {
                z(zw.getContext(), com.bytedance.sdk.openadsdk.core.multipro.g.dl());
            }
            com.bytedance.sdk.component.gz.g.z.z(zVar2, "csj");
        }
    }

    public static com.bytedance.sdk.openadsdk.core.q.dl.z dl() {
        return i.z;
    }

    public static void z(String str, List<String> list, boolean z2, Map<String, String> map, JSONObject jSONObject) {
        if (list == null || list.size() == 0) {
            return;
        }
        list.size();
        if (com.bytedance.sdk.component.gz.g.z.z("csj")) {
            z(zw.getContext(), com.bytedance.sdk.openadsdk.core.multipro.g.dl());
        }
        com.bytedance.sdk.component.gz.g.z.z("csj", str, z(list, com.bytedance.sdk.openadsdk.core.un.uy.dl(false)), z2, map, jSONObject);
    }

    public static List<String> z(List<String> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList(list);
            list = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                String strReplace = (String) arrayList.get(i);
                if (!TextUtils.isEmpty(strReplace)) {
                    if (strReplace.contains("{OAID}") || strReplace.contains("__OAID__")) {
                        strReplace = strReplace.replace("{OAID}", str).replace("__OAID__", str);
                    }
                    list.add(strReplace);
                }
            }
        }
        return list;
    }

    public static void z(String str) {
        if (com.bytedance.sdk.component.gz.g.z.z("csj")) {
            z(zw.getContext(), com.bytedance.sdk.openadsdk.core.multipro.g.dl());
        }
        com.bytedance.sdk.component.gz.g.z.z("csj", str);
    }

    public static void a() {
        try {
            com.bytedance.sdk.component.gz.g.z.g("csj");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.a(f1299a, e.getMessage());
        }
    }
}
