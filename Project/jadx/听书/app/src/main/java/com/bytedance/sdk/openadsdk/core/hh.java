package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.session.MediaController;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.iq.bv;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.ja;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.sd;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import com.kwad.sdk.api.model.AdnName;
import com.umeng.analytics.pro.an;
import com.umeng.umcrash.UMCrash;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class hh implements sy<com.bytedance.sdk.openadsdk.core.i.z> {
    private static final AtomicInteger dl = new AtomicInteger(0);
    public static Map<String, Long> z = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicLong f1117a = new AtomicLong(0);
    private final Context g;

    private boolean g(int i) {
        return i == 3 || i == 4;
    }

    hh(Context context) {
        this.g = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031 A[Catch: all -> 0x03be, TRY_ENTER, TryCatch #2 {all -> 0x03be, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0031, B:13:0x0037, B:16:0x0043, B:17:0x0048, B:18:0x004c, B:22:0x0054, B:24:0x0058, B:26:0x005f, B:28:0x0067, B:53:0x00de, B:57:0x010c, B:32:0x007c, B:34:0x0080, B:8:0x0027), top: B:156:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0339 A[Catch: all -> 0x03bf, TryCatch #3 {all -> 0x03bf, blocks: (B:80:0x01c2, B:82:0x01ca, B:84:0x01d4, B:86:0x01da, B:89:0x01e3, B:91:0x01e9, B:92:0x01f2, B:94:0x01fc, B:95:0x0209, B:98:0x0217, B:101:0x022f, B:102:0x0238, B:104:0x026b, B:107:0x0298, B:109:0x029c, B:111:0x02a4, B:113:0x02ca, B:115:0x02ce, B:116:0x02d5, B:120:0x02f7, B:123:0x031e, B:124:0x032e, B:126:0x0339, B:128:0x0360, B:131:0x0368, B:134:0x037f, B:136:0x0383, B:132:0x0370, B:138:0x0391, B:142:0x039a, B:143:0x03a3, B:145:0x03ad, B:99:0x021e), top: B:158:0x01c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0391 A[Catch: all -> 0x03bf, TryCatch #3 {all -> 0x03bf, blocks: (B:80:0x01c2, B:82:0x01ca, B:84:0x01d4, B:86:0x01da, B:89:0x01e3, B:91:0x01e9, B:92:0x01f2, B:94:0x01fc, B:95:0x0209, B:98:0x0217, B:101:0x022f, B:102:0x0238, B:104:0x026b, B:107:0x0298, B:109:0x029c, B:111:0x02a4, B:113:0x02ca, B:115:0x02ce, B:116:0x02d5, B:120:0x02f7, B:123:0x031e, B:124:0x032e, B:126:0x0339, B:128:0x0360, B:131:0x0368, B:134:0x037f, B:136:0x0383, B:132:0x0370, B:138:0x0391, B:142:0x039a, B:143:0x03a3, B:145:0x03ad, B:99:0x021e), top: B:158:0x01c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0145 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[Catch: all -> 0x03be, TryCatch #2 {all -> 0x03be, blocks: (B:4:0x0017, B:7:0x0022, B:11:0x0031, B:13:0x0037, B:16:0x0043, B:17:0x0048, B:18:0x004c, B:22:0x0054, B:24:0x0058, B:26:0x005f, B:28:0x0067, B:53:0x00de, B:57:0x010c, B:32:0x007c, B:34:0x0080, B:8:0x0027), top: B:156:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0 A[Catch: all -> 0x00de, TryCatch #1 {all -> 0x00de, blocks: (B:35:0x0085, B:37:0x00a0, B:39:0x00a7, B:41:0x00b5, B:43:0x00bc, B:45:0x00c2, B:46:0x00c7, B:48:0x00cd, B:50:0x00d3, B:52:0x00d9), top: B:154:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7 A[Catch: all -> 0x00de, TryCatch #1 {all -> 0x00de, blocks: (B:35:0x0085, B:37:0x00a0, B:39:0x00a7, B:41:0x00b5, B:43:0x00bc, B:45:0x00c2, B:46:0x00c7, B:48:0x00cd, B:50:0x00d3, B:52:0x00d9), top: B:154:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2 A[Catch: all -> 0x00de, TryCatch #1 {all -> 0x00de, blocks: (B:35:0x0085, B:37:0x00a0, B:39:0x00a7, B:41:0x00b5, B:43:0x00bc, B:45:0x00c2, B:46:0x00c7, B:48:0x00cd, B:50:0x00d3, B:52:0x00d9), top: B:154:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cd A[Catch: all -> 0x00de, TryCatch #1 {all -> 0x00de, blocks: (B:35:0x0085, B:37:0x00a0, B:39:0x00a7, B:41:0x00b5, B:43:0x00bc, B:45:0x00c2, B:46:0x00c7, B:48:0x00cd, B:50:0x00d3, B:52:0x00d9), top: B:154:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d9 A[Catch: all -> 0x00de, TRY_LEAVE, TryCatch #1 {all -> 0x00de, blocks: (B:35:0x0085, B:37:0x00a0, B:39:0x00a7, B:41:0x00b5, B:43:0x00bc, B:45:0x00c2, B:46:0x00c7, B:48:0x00cd, B:50:0x00d3, B:52:0x00d9), top: B:154:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0189 A[Catch: all -> 0x03bb, TryCatch #0 {all -> 0x03bb, blocks: (B:60:0x0145, B:61:0x015f, B:65:0x016f, B:67:0x0189, B:68:0x018e, B:72:0x019b, B:78:0x01b9), top: B:152:0x0145 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ca A[Catch: all -> 0x03bf, TryCatch #3 {all -> 0x03bf, blocks: (B:80:0x01c2, B:82:0x01ca, B:84:0x01d4, B:86:0x01da, B:89:0x01e3, B:91:0x01e9, B:92:0x01f2, B:94:0x01fc, B:95:0x0209, B:98:0x0217, B:101:0x022f, B:102:0x0238, B:104:0x026b, B:107:0x0298, B:109:0x029c, B:111:0x02a4, B:113:0x02ca, B:115:0x02ce, B:116:0x02d5, B:120:0x02f7, B:123:0x031e, B:124:0x032e, B:126:0x0339, B:128:0x0360, B:131:0x0368, B:134:0x037f, B:136:0x0383, B:132:0x0370, B:138:0x0391, B:142:0x039a, B:143:0x03a3, B:145:0x03ad, B:99:0x021e), top: B:158:0x01c2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject z(com.bytedance.sdk.openadsdk.ls.dl.dl.g r22, com.bytedance.sdk.openadsdk.core.iq.j r23, int r24, boolean r25, int r26) {
        /*
            Method dump skipped, instruction units count: 960
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.hh.z(com.bytedance.sdk.openadsdk.ls.dl.dl.g, com.bytedance.sdk.openadsdk.core.iq.j, int, boolean, int):org.json.JSONObject");
    }

    private void z(JSONObject jSONObject, j jVar) {
        if (jVar == null || jVar.gc == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", jVar.gc);
        } catch (Exception unused) {
        }
    }

    private void z(com.bytedance.sdk.openadsdk.core.iq.g gVar, long j, long j2, long j3, long j4) {
        if (gVar == null) {
            return;
        }
        gVar.z(j);
        gVar.g(j3);
        gVar.dl(j2);
        gVar.a(j4);
    }

    private boolean g(String str) {
        if (com.bytedance.sdk.openadsdk.core.pf.dl.z()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.pf.dl.z(str)) {
            return false;
        }
        String strG = com.bytedance.sdk.openadsdk.core.pf.dl.g();
        if (!TextUtils.isEmpty(strG)) {
            com.bytedance.sdk.openadsdk.core.q.v.z(strG, System.currentTimeMillis(), false);
        }
        return true;
    }

    private boolean dl(String str) {
        if (com.bytedance.sdk.openadsdk.core.pf.dl.dl()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.pf.dl.g(str)) {
            return false;
        }
        String strA = com.bytedance.sdk.openadsdk.core.pf.dl.a();
        if (!TextUtils.isEmpty(strA)) {
            com.bytedance.sdk.openadsdk.core.q.v.z(strA, System.currentTimeMillis(), true);
        }
        return true;
    }

    private boolean z(String str, j jVar) {
        float fA = com.bytedance.sdk.openadsdk.core.dl.gc.z().a();
        if (jVar != null && jVar.f1172a == 2 && fA > 0.0f) {
            return dl(str);
        }
        return g(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final j jVar, final int i, sy.g gVar2) {
        final com.bytedance.sdk.openadsdk.core.z.z zVar = new com.bytedance.sdk.openadsdk.core.z.z(gVar2);
        zVar.z(i);
        if ((i != 3 || !com.bytedance.sdk.openadsdk.core.component.splash.gc.z(gVar)) && Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.uy.e.gc(new com.bytedance.sdk.component.uy.fo("get_ad") { // from class: com.bytedance.sdk.openadsdk.core.hh.1
                @Override // java.lang.Runnable
                public void run() {
                    hh.this.a(gVar, jVar, i, zVar);
                }
            });
        } else {
            a(gVar, jVar, i, zVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void g(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final j jVar, final int i, sy.g gVar2) {
        final com.bytedance.sdk.openadsdk.core.z.z zVar = new com.bytedance.sdk.openadsdk.core.z.z(gVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("bid_pre") { // from class: com.bytedance.sdk.openadsdk.core.hh.12
                @Override // java.lang.Runnable
                public void run() {
                    hh.this.z(gVar, jVar, i, zVar, "/api/ad/union/server_bidding/pre_cache/", 2);
                }
            });
        } else {
            z(gVar, jVar, i, zVar, "/api/ad/union/server_bidding/pre_cache/", 2);
        }
    }

    public com.bytedance.sdk.openadsdk.core.h.g z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, com.bytedance.sdk.openadsdk.core.iq.g gVar2, j jVar, int i, int i2, sy.g gVar3) {
        com.bytedance.sdk.openadsdk.core.h.g gVarG;
        com.bytedance.sdk.openadsdk.tools.g.z(gVar);
        boolean z2 = i2 == 5;
        jVar.z("buildAdBodyReady", z2);
        JSONObject jSONObjectZ = z(gVar, jVar, i, false, i2);
        jVar.z("doBuildAdBody", z2);
        if (jSONObjectZ == null) {
            gVar2.z(-9);
            gVar3.z(-9, fo.z(-9), gVar2);
            return null;
        }
        String string = jSONObjectZ.toString();
        if (i2 == 5) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            gVarG = com.bytedance.sdk.openadsdk.core.dl.m.z().z(string);
            jVar.z("encrypt", System.currentTimeMillis() - jCurrentTimeMillis, z2);
        } else {
            gVarG = com.bytedance.sdk.openadsdk.core.dl.m.z().g(string);
        }
        if (gVarG == null) {
            gVar2.z(-9);
            gVar3.z(-9, fo.z(-9), gVar2);
            return null;
        }
        gVarG.z(jSONObjectZ);
        return gVarG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar, int i, sy.g gVar2, String str, int i2) {
        g(gVar, jVar, i, gVar2, str, i2);
    }

    public void a(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar, int i, sy.g gVar2) {
        g(gVar, jVar, i, gVar2, "/api/ad/union/sdk/get_ads/", 5);
    }

    private void g(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final j jVar, final int i, final sy.g gVar2, String str, final int i2) {
        final com.bytedance.sdk.openadsdk.core.iq.g gVar3 = new com.bytedance.sdk.openadsdk.core.iq.g();
        gVar3.z(gVar);
        try {
            if (z(gVar, gVar3, gVar2, i2 == 5, jVar, i)) {
                return;
            }
            com.bytedance.sdk.component.fo.g.gc gcVarZ = z(gVar, jVar, i, gVar2, str, i2, gVar3);
            if (gcVarZ == null) {
                gVar3.z(-15);
                gVar2.z(-15, fo.z(-15), gVar3);
            } else {
                gcVarZ.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.18
                    @Override // com.bytedance.sdk.component.fo.z.z
                    public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar4) {
                        hh.this.z(aVar, gVar4, gVar3, gVar2, gVar, jVar, i, i2);
                    }

                    @Override // com.bytedance.sdk.component.fo.z.z
                    public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                        hh.this.z(aVar, iOException, gVar3, gVar2);
                    }
                });
                com.bytedance.sdk.openadsdk.core.a.z().dl();
                z();
            }
        } catch (Throwable th) {
            z(th, gVar3, gVar2);
        }
    }

    private boolean z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, com.bytedance.sdk.openadsdk.core.iq.g gVar2, sy.g gVar3, boolean z2, j jVar, int i) {
        if (gVar3 == null) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            gVar2.z(1000);
            gVar3.z(1000, "广告请求开关已关闭,请联系穿山甲管理员", gVar2);
            return true;
        }
        if (!z2) {
            return false;
        }
        jVar.z("execGetAdReady", z2);
        if (!TextUtils.isEmpty(gVar.q()) && jVar.f1172a <= 0) {
            z(gVar2, gVar, gVar3, jVar, i);
            com.bytedance.sdk.openadsdk.core.q.g.z();
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z(gVar.a(), jVar)) {
            gVar2.z(-8);
            gVar3.z(-8, fo.z(-8), gVar2);
            com.bytedance.sdk.openadsdk.core.q.g.z();
            return true;
        }
        jVar.z("checkCallFreq", System.currentTimeMillis() - jCurrentTimeMillis, z2);
        return false;
    }

    private void z(com.bytedance.sdk.openadsdk.core.iq.g gVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar2, final sy.g gVar3, j jVar, int i) {
        gVar.dl(2);
        gVar.z(gVar2.q());
        try {
            boolean z2 = false;
            JSONObject jSONObjectZ = com.bytedance.sdk.openadsdk.core.dl.m.z(new JSONObject(gVar2.q()), false, true);
            if (jSONObjectZ == null) {
                z(gVar3, gVar);
                return;
            }
            z zVarZ = z.z(jSONObjectZ, gVar2, jVar);
            gVar.z(zVarZ.uy);
            tb.z(zVarZ.fo);
            if (zVarZ.f1128a != 20000) {
                gVar.z(zVarZ.f1128a);
                StringBuilder sb = new StringBuilder("reason: ");
                sb.append(zVarZ.m).append("  message: ").append(zVarZ.gc);
                gVar3.z(zVarZ.f1128a, sb.toString(), gVar);
                return;
            }
            if (zVarZ.gz == null) {
                z(gVar3, gVar);
                return;
            }
            zVarZ.gz.z(jSONObjectZ);
            List<na> listG = zVarZ.gz.g();
            if (listG != null) {
                List<na> arrayList = new ArrayList<>(listG);
                for (na naVar : listG) {
                    na naVarZ = com.bytedance.sdk.openadsdk.core.un.gc.z(naVar.lq(), i);
                    if (naVarZ != null) {
                        arrayList.remove(naVar);
                        naVarZ.h(naVar.ka());
                        arrayList.add(naVarZ);
                    } else if (naVar.mc()) {
                        final String str = zVarZ.e;
                        if (!TextUtils.isEmpty(str) && jVar != null) {
                            jVar.z(str);
                        }
                        final String strA = gVar2.a();
                        final String strZ = com.bytedance.sdk.openadsdk.core.un.eo.z(gVar2);
                        zw.z().dl(gVar2, jVar, i, new sy.g() { // from class: com.bytedance.sdk.openadsdk.core.hh.19
                            @Override // com.bytedance.sdk.openadsdk.core.sy.g
                            public void z(int i2, String str2, com.bytedance.sdk.openadsdk.core.iq.g gVar4) {
                                com.bytedance.sdk.openadsdk.core.q.v.z().z(i2, str2, str, strA, strZ);
                                gVar3.z(i2, str2, gVar4);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.sy.g
                            public void z(com.bytedance.sdk.openadsdk.core.iq.z zVar, com.bytedance.sdk.openadsdk.core.iq.g gVar4) {
                                com.bytedance.sdk.openadsdk.core.q.v.z().z(0, "success", str, strA, strZ);
                                gVar3.z(zVar, gVar4);
                            }
                        });
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                } else {
                    zVarZ.gz.z(arrayList);
                }
            }
            gVar3.z(zVarZ.gz, gVar);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.dl("NetApiImpl", "get ad error: ", th);
            z(gVar3, gVar);
        }
    }

    private com.bytedance.sdk.component.fo.g.gc z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar, int i, sy.g gVar2, String str, int i2, com.bytedance.sdk.openadsdk.core.iq.g gVar3) throws JSONException {
        byte[] bytes;
        Map<String, String> mapZ;
        com.bytedance.sdk.openadsdk.core.h.g gVarZ = z(gVar, gVar3, jVar, i, i2, gVar2);
        if (gVarZ == null) {
            return null;
        }
        String strZ = com.bytedance.sdk.openadsdk.core.un.eo.z(str, true);
        com.bytedance.sdk.component.fo.g.gc gcVarG = com.bytedance.sdk.openadsdk.core.io.gc.z().g().g();
        String strZ2 = com.bytedance.sdk.openadsdk.e.dl.z(gcVarG, strZ);
        gcVarG.z(strZ2);
        if (gVarZ.z() != null) {
            com.bytedance.sdk.openadsdk.e.dl.z(gVarZ.z(), 0);
        }
        if (i2 == 5) {
            if (gVarZ.a() != null) {
                JSONObject jSONObjectA = gVarZ.a();
                gcVarG.z(jSONObjectA);
                bytes = jSONObjectA.toString().getBytes(StandardCharsets.UTF_8);
                gcVarG.z(false);
            } else {
                if (gVarZ.dl() == null) {
                    return null;
                }
                bytes = gVarZ.dl();
                gcVarG.z("application/octet-stream", bytes);
                gcVarG.z(true);
            }
        } else {
            JSONObject jSONObjectA2 = gVarZ.a();
            gcVarG.z(jSONObjectA2);
            bytes = jSONObjectA2.toString().getBytes(StandardCharsets.UTF_8);
        }
        boolean z2 = i2 == 5;
        jVar.z("doHttpReqSignReady", z2);
        com.bytedance.sdk.openadsdk.z.z.z zVarZ = com.bytedance.sdk.openadsdk.z.z.z.z(true);
        jVar.z("MSInst", z2);
        Map<String, String> mapZ2 = zVarZ.z(strZ2, bytes);
        jVar.z("doHttpReqSign", z2);
        if (mapZ2 == null) {
            mapZ2 = new HashMap<>();
        }
        if (i2 == 5 && (mapZ = com.bytedance.sdk.openadsdk.tools.g.z(gVar.a())) != null) {
            mapZ2.putAll(mapZ);
        }
        com.bytedance.sdk.openadsdk.core.un.ti.z(mapZ2);
        Map<String, String> mapGc = gVarZ.gc();
        gcVarG.g("User-Agent", com.bytedance.sdk.openadsdk.core.un.uy.i());
        if (mapGc != null) {
            mapZ2.putAll(mapGc);
        }
        if (mapZ2.size() > 0) {
            for (Map.Entry<String, String> entry : mapZ2.entrySet()) {
                gcVarG.g(entry.getKey(), entry.getValue());
            }
        }
        gcVarG.gc(z(bytes, mapGc, gVarZ));
        jVar.z("appendHeader", z2);
        return gcVarG;
    }

    private Map<String, Object> z(byte[] bArr, Map<String, String> map, com.bytedance.sdk.openadsdk.core.h.g gVar) {
        HashMap map2 = new HashMap();
        try {
            com.bytedance.sdk.openadsdk.core.h.z zVar = new com.bytedance.sdk.openadsdk.core.h.z();
            zVar.gz(System.currentTimeMillis());
            zVar.fo(bArr == null ? 0L : bArr.length);
            zVar.dl(gVar.g());
            if (map != null) {
                zVar.z(map.get("x-pglcypher"));
            }
            zVar.z(gVar.z());
            com.bytedance.sdk.component.a.z zVarG = com.bytedance.sdk.openadsdk.core.un.io.g();
            zVar.g(zVarG != null ? zVarG.getSpecificArmorLoadStatus() : 0);
            zVar.z(zw.g().sf());
            map2.put("load_time_model", zVar);
        } catch (Exception unused) {
        }
        return map2;
    }

    private void z() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f1117a.get() >= MediaController.RELEASE_UNBIND_TIMEOUT_MS) {
            this.f1117a.set(jCurrentTimeMillis);
            com.bytedance.sdk.component.utils.gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hh.20
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.gk.gz.z((com.bytedance.sdk.openadsdk.core.gk.gc) null).dl();
                }
            }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException, com.bytedance.sdk.openadsdk.core.iq.g gVar, sy.g gVar2) {
        com.bytedance.sdk.openadsdk.core.q.g.z();
        if (iOException != null) {
            gVar.z(602);
            gVar2.z(602, iOException.getMessage(), gVar);
            com.bytedance.sdk.component.utils.wp.z("NetApiImpl", "onFailure: ", 601);
        }
    }

    private void z(Throwable th, com.bytedance.sdk.openadsdk.core.iq.g gVar, sy.g gVar2) {
        if (gVar2 != null) {
            gVar.z(4000);
            gVar2.z(4000, th.getMessage(), gVar);
            com.bytedance.sdk.component.utils.wp.dl("NetApiImpl", " msg = ", th.getMessage());
        }
    }

    private void z(com.bytedance.sdk.component.fo.g gVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar2, int i, j jVar, sy.g gVar3, com.bytedance.sdk.openadsdk.core.iq.g gVar4, com.bytedance.sdk.component.fo.g.a aVar) {
        z zVar;
        String str;
        JSONObject jSONObject;
        int i2;
        JSONObject jSONObject2;
        j jVar2 = jVar;
        com.bytedance.sdk.openadsdk.core.iq.g gVar5 = gVar4;
        if (gVar == null) {
            return;
        }
        if (gVar.gz()) {
            try {
                com.bytedance.sdk.openadsdk.core.h.z zVarZ = z(aVar);
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strA = gVar.a();
                gVar5.z(strA);
                if (LogAdapter.z != null) {
                    LogAdapter.z.a("NetApiImpl", "response:");
                    LogAdapter.z.a("NetApiImpl", strA);
                }
                JSONObject jSONObject3 = new JSONObject(strA);
                int iOptInt = jSONObject3.optInt("status_code");
                String strOptString = new JSONObject(gVar2.q()).optString("auction_price");
                int i3 = 20000;
                try {
                    if (iOptInt != 20000) {
                        if (iOptInt == 40046) {
                            gVar5.z(iOptInt);
                            gVar3.z(40046, fo.z(iOptInt), gVar5);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("adms");
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        JSONObject jSONObject4 = new JSONObject(jSONObjectOptJSONObject.optString(itKeys.next()));
                        jSONObject4.put("auction_price", strOptString);
                        JSONObject jSONObjectZ = com.bytedance.sdk.openadsdk.core.dl.m.z(jSONObject4, false, true);
                        if (jSONObjectZ == null) {
                            z(gVar3, gVar4);
                            return;
                        }
                        z zVarZ2 = z.z(jSONObjectZ, gVar2, jVar2);
                        gVar5.z(zVarZ2.uy);
                        if (zVarZ2.f1128a != i3) {
                            gVar5.z(zVarZ2.f1128a);
                            StringBuilder sb = new StringBuilder();
                            sb.append("reason: ").append(zVarZ2.m).append("  message: ").append(zVarZ2.gc);
                            gVar3.z(zVarZ2.f1128a, sb.toString(), gVar5);
                            return;
                        }
                        if (zVarZ2.gz == null) {
                            z(gVar3, gVar4);
                            return;
                        }
                        zVarZ2.gz.z(jSONObjectZ);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (jVar2 != null) {
                            try {
                                zVar = zVarZ2;
                                str = strOptString;
                                jSONObject = jSONObjectOptJSONObject;
                                i2 = 20000;
                                jSONObject2 = jSONObjectZ;
                                z(gVar4, zVarZ.fo() - jVar2.e, zVarZ2.z, jCurrentTimeMillis - zVarZ.fo(), jCurrentTimeMillis2 - jCurrentTimeMillis);
                            } catch (Throwable th) {
                                th = th;
                                com.bytedance.sdk.component.utils.wp.dl("NetApiImpl", "get ad error: ", th);
                                z(gVar3, gVar4);
                                return;
                            }
                        } else {
                            zVar = zVarZ2;
                            jSONObject = jSONObjectOptJSONObject;
                            jSONObject2 = jSONObjectZ;
                            str = strOptString;
                            i2 = i3;
                        }
                        gVar3.z(zVar.gz, gVar4);
                        com.bytedance.sdk.openadsdk.g.g.z().z(jSONObject2);
                        jSONObjectOptJSONObject = jSONObject;
                        jVar2 = jVar;
                        gVar5 = gVar4;
                        strOptString = str;
                        i3 = i2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            int iZ = gVar.z();
            String strG = gVar.g();
            gVar5.z(iZ);
            gVar3.z(iZ, strG, gVar5);
        }
    }

    public void gc(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final j jVar, final int i, sy.g gVar2) {
        final com.bytedance.sdk.openadsdk.core.z.z zVar = new com.bytedance.sdk.openadsdk.core.z.z(gVar2);
        com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("bid_p_f") { // from class: com.bytedance.sdk.openadsdk.core.hh.21
            @Override // java.lang.Runnable
            public void run() {
                hh.this.z(gVar, jVar, i, zVar, "/api/ad/union/server_bidding/pre_fetch/", 1);
            }
        });
    }

    private void z(com.bytedance.sdk.component.fo.g gVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar2, int i, j jVar, sy.g gVar3, com.bytedance.sdk.openadsdk.core.iq.g gVar4) {
        if (gVar != null) {
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(gVar.a()).optJSONArray("ads");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    if (gVar3 != null) {
                        gVar3.z(-9, fo.z(-9), gVar4);
                        return;
                    }
                    return;
                }
                int iGk = zw.g().gk();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.getJSONObject(i2).optJSONObject("creative");
                    if (jSONObjectOptJSONObject != null) {
                        JSONObject jSONObjectZ = com.bytedance.sdk.openadsdk.core.dl.m.z(new JSONObject(jSONObjectOptJSONObject.optString("adm")), false, true);
                        if (jSONObjectZ == null && gVar3 != null) {
                            gVar3.z(-9, fo.z(-9), gVar4);
                        } else {
                            z zVarZ = z.z(jSONObjectZ, gVar2, jVar);
                            com.bytedance.sdk.openadsdk.core.un.gc.z(zVarZ.gz, i, iGk);
                            if (gVar3 != null) {
                                gVar3.z(zVarZ.gz, gVar4);
                            }
                        }
                    } else if (gVar3 != null) {
                        gVar3.z(-9, fo.z(-9), gVar4);
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
                if (gVar3 != null) {
                    gVar3.z(-9, fo.z(-9), gVar4);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void dl(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final j jVar, final int i, sy.g gVar2) {
        final com.bytedance.sdk.openadsdk.core.z.z zVar = new com.bytedance.sdk.openadsdk.core.z.z(gVar2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("bid_g_m") { // from class: com.bytedance.sdk.openadsdk.core.hh.22
                @Override // java.lang.Runnable
                public void run() {
                    hh.this.z(gVar, jVar, i, zVar, "/api/ad/union/server_bidding/get_materials/", 3);
                }
            });
        } else {
            z(gVar, jVar, i, zVar, "/api/ad/union/server_bidding/get_materials/", 3);
        }
    }

    private com.bytedance.sdk.openadsdk.core.h.z z(com.bytedance.sdk.component.fo.g.a aVar) {
        try {
            Object obj = aVar.dl().get("load_time_model");
            if (obj instanceof com.bytedance.sdk.openadsdk.core.h.z) {
                com.bytedance.sdk.openadsdk.core.h.z zVar = (com.bytedance.sdk.openadsdk.core.h.z) obj;
                zVar.dl(true);
                return zVar;
            }
        } catch (Throwable unused) {
        }
        return new com.bytedance.sdk.openadsdk.core.h.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar, com.bytedance.sdk.openadsdk.core.iq.g gVar2, sy.g gVar3, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar4, j jVar, int i, int i2) {
        String str;
        int i3;
        long length;
        final JSONObject jSONObjectZ;
        final boolean zBooleanValue;
        JSONObject jSONObject;
        z zVar;
        com.bytedance.sdk.openadsdk.core.h.z zVar2;
        int i4;
        long length2;
        if (gVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!gVar.gz()) {
            int iZ = gVar.z();
            String strG = gVar.g();
            gVar2.z(iZ);
            gVar3.z(iZ, strG, gVar2);
            com.bytedance.sdk.openadsdk.core.m.g.g();
            return;
        }
        if (i2 == 1) {
            z(gVar, gVar4, i, jVar, gVar3, gVar2);
            return;
        }
        if (i2 == 3) {
            z(gVar, gVar4, i, jVar, gVar3, gVar2, aVar);
            return;
        }
        com.bytedance.sdk.openadsdk.core.h.z zVarZ = z(aVar);
        zVarZ.m(jCurrentTimeMillis);
        com.bytedance.sdk.openadsdk.core.q.g.z();
        try {
            final String strA = gVar.a();
            if (i2 == 5) {
                byte[] bArrUy = gVar.uy();
                Pair<Boolean, JSONObject> pairZ = com.bytedance.sdk.openadsdk.core.dl.m.z(gVar, "get_ads", true);
                jSONObjectZ = (JSONObject) pairZ.second;
                zBooleanValue = ((Boolean) pairZ.first).booleanValue();
                if (zBooleanValue) {
                    length2 = TextUtils.isEmpty(strA) ? 0L : strA.getBytes(StandardCharsets.UTF_8).length;
                    gVar2.z(strA);
                } else {
                    length2 = bArrUy == null ? 0L : bArrUy.length;
                }
                length = length2;
                if (LogAdapter.z == null || jSONObjectZ == null) {
                    i3 = 0;
                } else {
                    i3 = 0;
                    com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("logAdapter") { // from class: com.bytedance.sdk.openadsdk.core.hh.23
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String string = "";
                                if (zBooleanValue) {
                                    string = strA;
                                } else {
                                    Pair<Integer, JSONObject> pairZ2 = com.bytedance.sdk.openadsdk.core.dl.m.z().z(jSONObjectZ.toString(), false);
                                    if (pairZ2 != null && pairZ2.second != null) {
                                        string = ((JSONObject) pairZ2.second).toString();
                                    }
                                }
                                if (LogAdapter.z == null || TextUtils.isEmpty(string)) {
                                    return;
                                }
                                LogAdapter.z.a("NetApiImpl", "response:");
                                LogAdapter.z.a("NetApiImpl", string);
                            } catch (Exception e) {
                                com.bytedance.sdk.component.utils.wp.dl(e.getMessage());
                            }
                        }
                    });
                }
            } else {
                i3 = 0;
                gVar2.z(strA);
                if (LogAdapter.z != null) {
                    LogAdapter.z.a("NetApiImpl", "response:");
                    LogAdapter.z.a("NetApiImpl", strA);
                }
                JSONObject jSONObject2 = new JSONObject(strA);
                length = TextUtils.isEmpty(strA) ? 0L : strA.getBytes(StandardCharsets.UTF_8).length;
                jSONObjectZ = com.bytedance.sdk.openadsdk.core.dl.m.z(jSONObject2, false, true);
                zBooleanValue = false;
            }
            JSONObject jSONObject3 = jSONObjectZ;
            zVarZ.e(length);
            if (jSONObject3 == null) {
                z(gVar3, gVar2);
                return;
            }
            com.bytedance.sdk.openadsdk.e.dl.g(jSONObject3, i3);
            z zVarZ2 = z.z(jSONObject3, gVar4, jVar);
            gVar2.z(zVarZ2.uy);
            tb.z(zVarZ2.fo);
            if (zVarZ2.f1128a != 20000) {
                gVar2.z(zVarZ2.f1128a);
                gVar2.g(zVarZ2.m);
                StringBuilder sb = new StringBuilder("reason: ");
                sb.append(zVarZ2.m).append("  message: ").append(zVarZ2.gc);
                gVar3.z(zVarZ2.f1128a, sb.toString(), gVar2);
                return;
            }
            if (zVarZ2.gz == null) {
                z(gVar3, gVar2);
                return;
            }
            zVarZ2.gz.z(jSONObject3);
            zVarZ.g(System.currentTimeMillis());
            if (jVar != null) {
                zVar = zVarZ2;
                jSONObject = jSONObject3;
                zVar2 = zVarZ;
                str = "NetApiImpl";
                i4 = 1;
                try {
                    z(gVar2, zVarZ.fo() - jVar.e, zVarZ2.z, zVarZ.m() - zVarZ.fo(), zVarZ.g() - zVarZ.m());
                } catch (Throwable th) {
                    th = th;
                    com.bytedance.sdk.component.utils.wp.dl(str, "get ad error: ", th);
                    z(gVar3, gVar2);
                    return;
                }
            } else {
                jSONObject = jSONObject3;
                zVar = zVarZ2;
                zVar2 = zVarZ;
                str = "NetApiImpl";
                i4 = 1;
            }
            gVar3.z(zVar.gz, gVar2);
            for (na naVar : zVar.gz.g()) {
                if (jVar != null) {
                    naVar.sy(jVar.g());
                    naVar.ac().z(jVar.z);
                    naVar.ac().g(i4);
                }
                if (com.bytedance.sdk.openadsdk.gc.z.z(naVar)) {
                    com.bytedance.sdk.openadsdk.upie.g.z().z(this.g, com.bytedance.sdk.openadsdk.gc.z.fo(naVar));
                }
            }
            if (zVar2.wp() && zVar.gz.g() != null && !zVar.gz.g().isEmpty()) {
                na naVar2 = zVar.gz.g().get(0);
                com.bytedance.sdk.openadsdk.core.a.z().z(naVar2);
                String strG2 = com.bytedance.sdk.openadsdk.core.un.eo.g(i);
                int i5 = i4;
                com.bytedance.sdk.openadsdk.core.h.z zVar3 = zVar2;
                zVar3.g(i2 != 5 ? i5 : 0);
                zVar3.z((i2 != 5 || zBooleanValue) ? i5 : 0);
                zVar3.gc(gVar.gc());
                zVar3.a(gVar.m());
                zVar3.z(zVar.z);
                com.bytedance.sdk.component.g.z.kb kbVarKb = gVar.kb();
                if (kbVarKb != null) {
                    zVar3.uy(kbVarKb.z);
                    zVar3.kb(kbVarKb.g);
                    zVar3.wp(kbVarKb.dl);
                    zVar3.i(kbVarKb.f718a);
                    zVar3.v(kbVarKb.gc);
                }
                z(jVar, naVar2, strG2, zVar3);
            }
            com.bytedance.sdk.openadsdk.g.g.z().z(jSONObject);
            com.bytedance.sdk.openadsdk.core.m.g.g();
        } catch (Throwable th2) {
            th = th2;
            str = "NetApiImpl";
        }
    }

    private void z(j jVar, na naVar, String str, com.bytedance.sdk.openadsdk.core.h.z zVar) {
        long jG;
        long j;
        if (zw.g().lw() && zVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (jVar != null) {
                try {
                    if (jVar.e > 0) {
                        jSONObject.put("client_start_time", zVar.fo() - jVar.e);
                        jG = zVar.g() - jVar.e;
                    } else {
                        jG = 0;
                    }
                    if (jVar.gz > 0) {
                        jSONObject.put("real_user_duration", zVar.g() - jVar.gz);
                        jSONObject.put("switch_st1_time", jVar.e - jVar.gz);
                    }
                    j = jG;
                } catch (Exception unused) {
                    return;
                }
            } else {
                j = 0;
            }
            jSONObject.put("net_send_time", zVar.gc() - zVar.fo());
            jSONObject.put("net_rcv_time", zVar.a() - zVar.gc());
            jSONObject.put("net_callback_time", zVar.m() - zVar.a());
            jSONObject.put("network_time", zVar.m() - zVar.fo());
            jSONObject.put("sever_time", zVar.z());
            jSONObject.put("client_end_time", zVar.g() - zVar.m());
            if (zVar.uy() > 0) {
                jSONObject.put("req_body_length", zVar.uy());
            }
            if (zVar.gz() > 0) {
                jSONObject.put("res_body_length", zVar.gz());
            }
            if (!TextUtils.isEmpty(zVar.kb())) {
                jSONObject.put("x-pglcypher", zVar.kb());
            }
            jSONObject.put("cypher_v", zVar.fv());
            jSONObject.put("armor_s", zVar.js());
            long jDl = zVar.dl();
            if (jDl > 0) {
                jSONObject.put("raw_req_length", jDl);
            }
            int i = 1;
            jSONObject.put("sdk_parallel_load", 1);
            jSONObject.put("net_module", com.bytedance.sdk.openadsdk.core.dl.dl.z().m());
            if (!zVar.e()) {
                i = 2;
            }
            jSONObject.put("has_base64", i);
            jSONObject.put("req_build_opt", com.bytedance.sdk.openadsdk.core.dl.dl.z().e());
            jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.a.z.a());
            jSONObject.put("opt_config", String.valueOf(zw.g().ux()));
            jSONObject.put("report_index", dl.getAndIncrement());
            if (zVar.ls() > 0) {
                jSONObject.put("net_whqueue", zVar.v() - zVar.i());
                jSONObject.put("net_wtqueue", zVar.pf() - zVar.v());
                jSONObject.put("net_oconn", zVar.p() - zVar.ls());
                jSONObject.put("net_bconn", zVar.ls() - zVar.pf());
            }
            try {
                JSONObject jSONObjectZ = jVar.v.z(-1L);
                Iterator<String> itKeys = jSONObjectZ.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next)) {
                        jSONObject.put(next, jSONObjectZ.opt(next));
                    }
                }
            } catch (Exception unused2) {
            }
            com.bytedance.sdk.openadsdk.core.i.a.z(naVar, str, "load_ad_time", j, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void z(com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar, List<com.bytedance.sdk.openadsdk.ls.dl.g.m> list) {
        JSONObject jSONObjectG;
        if (com.bytedance.sdk.openadsdk.core.gk.fo.z() && (jSONObjectG = g(gVar, list)) != null) {
            com.bytedance.sdk.openadsdk.core.un.na naVar = new com.bytedance.sdk.openadsdk.core.un.na(com.bytedance.sdk.openadsdk.core.io.gc.z().g().m());
            naVar.z(com.bytedance.sdk.openadsdk.core.un.eo.gz("/api/ad/union/dislike_event/"));
            naVar.dl(jSONObjectG, "dislike");
            naVar.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.24
                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar2) {
                }

                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                }
            });
        }
    }

    private JSONObject g(com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar, List<com.bytedance.sdk.openadsdk.ls.dl.g.m> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "dislike");
            jSONObject2.put(UMCrash.SP_KEY_TIMESTAMP, System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", gk.f1105a);
            com.bytedance.sdk.openadsdk.pf.g.z(this.g, jSONObject2);
            if (gVar != null) {
                jSONObject2.put("extra", gVar.a());
                if (gVar.g() == null) {
                    gVar.z(AdnName.OTHER);
                }
                jSONObject2.put("dislike_source", gVar.g());
            }
            String strZ = z(list);
            if (strZ != null) {
                jSONObject2.put("comment", strZ);
                list.clear();
            } else {
                jSONObject2.put("comment", (Object) null);
            }
            jSONObject2.put("filter_words", g(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String z(List<com.bytedance.sdk.openadsdk.ls.dl.g.m> list) {
        if (list.get(0).z().equals("0:00")) {
            return list.get(0).g();
        }
        return null;
    }

    private JSONArray g(List<com.bytedance.sdk.openadsdk.ls.dl.g.m> list) {
        if (list == null || list.isEmpty()) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.ls.dl.g.m> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().z());
        }
        return jSONArray;
    }

    public static void z(sy.g gVar, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
        gVar2.z(-1);
        gVar.z(-1, fo.z(-1), gVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(sy.gc gcVar) {
        gcVar.z(-1, fo.z(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(sy.a aVar) {
        aVar.z(-1, fo.z(-1));
    }

    private JSONObject z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, int i) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        try {
            z(jSONObject, "keywords", uy.ls().io());
            jSONObject.put("protection_of_minors", uy.ls().j());
            if (!com.bytedance.sdk.openadsdk.core.dl.a.z().e(i)) {
                com.bytedance.sdk.openadsdk.pf.g.a(this.g, jSONObject);
            }
            String strG = g(gVar);
            String strZ = com.bytedance.sdk.openadsdk.core.dl.a.z().z(gVar.a(), "");
            if (!TextUtils.isEmpty(strZ)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("name", "dynamic_slot_ab_extra");
                jSONObject2.putOpt("value", strZ);
                if (TextUtils.isEmpty(strG)) {
                    jSONArray = new JSONArray();
                } else {
                    jSONArray = new JSONArray(strG);
                }
                jSONArray.put(jSONObject2);
                String string = jSONArray.toString();
                if (!TextUtils.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, string)) {
                    z(jSONObject, "data", string);
                }
            } else if (!TextUtils.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, strG)) {
                z(jSONObject, "data", strG);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONArray z(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                jSONObject = new JSONObject();
                jSONObject.put("name", "can_use_sensor");
                jSONObject.put("value", str);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
                return jSONArray;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return jSONArray;
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            jSONArray.put(jSONArray.length(), jSONObject);
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(0, jSONObject);
        return jSONArray2;
    }

    private static String g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        String strDl = dl(gVar);
        Map<String, Object> mapHh = uy.ls().hh();
        if (mapHh != null && !mapHh.isEmpty()) {
            try {
                JSONArray jSONArray = TextUtils.isEmpty(strDl) ? new JSONArray() : new JSONArray(strDl);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("name") : "";
                    if (!TextUtils.isEmpty(strOptString) && mapHh.containsKey(strOptString)) {
                        mapHh.remove(strOptString);
                    }
                }
                for (Map.Entry<String, Object> entry : mapHh.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", entry.getKey());
                        jSONObject.put("value", entry.getValue());
                        jSONArray.put(jSONObject);
                    }
                }
                return z(jSONArray).toString();
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
        return strDl;
    }

    private static JSONArray g(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.equals("0", str)) {
                jSONObject = new JSONObject();
                jSONObject.put("name", "is_shake_ads");
                jSONObject.put("value", "0");
                uy.ls().g("0");
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return jSONArray;
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONArray.put(jSONArray.length(), jSONObject);
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, jSONObject);
            return jSONArray2;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return jSONArray;
        }
    }

    private static String z(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            JSONArray jSONArrayG = g(z((JSONArray) null, str2), str2);
            if (jSONArrayG == null) {
                return null;
            }
            return jSONArrayG.toString();
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            boolean z2 = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && TextUtils.equals(jSONObjectOptJSONObject.optString("name"), "is_shake_ads")) {
                    if (TextUtils.equals("0", str2)) {
                        jSONObjectOptJSONObject.put("value", "0");
                        uy.ls().g("0");
                    } else {
                        uy.ls().g(jSONObjectOptJSONObject.optString("value"));
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                jSONArray = g(jSONArray, str2);
            }
            JSONArray jSONArrayZ = z(jSONArray, str2);
            return jSONArrayZ == null ? str : jSONArrayZ.toString();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return str;
        }
    }

    private static String dl(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        String strSy = uy.ls().sy();
        String strM = uy.ls().m();
        uy.ls().g((String) null);
        String strIq = gVar != null ? gVar.iq() : null;
        if (TextUtils.isEmpty(strSy)) {
            return z(strIq, strM);
        }
        try {
            if (!TextUtils.isEmpty(strSy) && strSy.contains("game_adapter_did")) {
                strSy = z(new JSONArray(strSy)).toString();
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        if (TextUtils.isEmpty(strIq)) {
            return z(strSy, strM);
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(strIq);
            int length = jSONArray.length();
            boolean z2 = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString("name", null);
                    if (TextUtils.equals("is_shake_ads", strOptString)) {
                        if (TextUtils.equals(strM, "0")) {
                            jSONObject.put("value", "0");
                            uy.ls().g("0");
                        } else {
                            uy.ls().g(jSONObject.optString("value"));
                        }
                        z2 = true;
                    }
                    hashSet.add(strOptString);
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(strSy);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        String strOptString2 = jSONObject2.optString("name", null);
                        if (!hashSet.contains(strOptString2)) {
                            if (TextUtils.equals("is_shake_ads", strOptString2)) {
                                if (TextUtils.equals(strM, "0")) {
                                    jSONObject2.put("value", "0");
                                    uy.ls().g("0");
                                } else {
                                    uy.ls().g(jSONObject2.optString("value"));
                                }
                                z2 = true;
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                if (!z2) {
                    jSONArray = g(jSONArray, strM);
                }
                return z(z(jSONArray), strM).toString();
            } catch (Throwable unused) {
                return z(strIq, strM);
            }
        } catch (Throwable unused2) {
            return z(strSy, strM);
        }
    }

    private static JSONArray z(JSONArray jSONArray) throws JSONException {
        if (gk.e() && jSONArray != null && jSONArray.length() != 0) {
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            JSONObject jSONObject = null;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    String strOptString = jSONObject2.optString("name", null);
                    if (!"device_id".equals(strOptString)) {
                        if ("game_adapter_did".equals(strOptString)) {
                            jSONObject = jSONObject2;
                        } else {
                            jSONArray2.put(jSONObject2);
                        }
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject.put("name", "device_id");
                jSONArray2.put(jSONObject);
                return jSONArray2;
            }
        }
        return jSONArray;
    }

    private void z(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private JSONObject z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, int i, j jVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", gVar.a());
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, gVar.js());
            jSONObject.put("show_seq", gVar.fv());
            jSONObject.put("adtype", i);
            jSONObject.put("themeStatus", uy.ls().bv());
            jSONObject.put("download_type", 0);
            jSONObject.put("show_time", com.bytedance.sdk.openadsdk.core.v.dl.gc().z(gVar.a()));
            if (!TextUtils.isEmpty(gVar.z()) || !TextUtils.isEmpty(gVar.g()) || !TextUtils.isEmpty(gVar.dl()) || com.bytedance.sdk.openadsdk.tools.g.z()) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(gVar.z())) {
                    jSONObject2.put(MediationConstant.EXTRA_ADID, gVar.z());
                }
                if (!TextUtils.isEmpty(gVar.g())) {
                    jSONObject2.put("creative_id", gVar.g());
                }
                if (gVar.dl() != null) {
                    jSONObject2.put("ext", gVar.dl());
                }
                com.bytedance.sdk.openadsdk.tools.g.z(jSONObject2, gVar.a());
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (com.bytedance.sdk.openadsdk.tools.g.z() && uy.ls().b()) {
                com.bytedance.sdk.openadsdk.tools.g.g(jSONObject, gVar.a());
            }
            uy.a aVarMe = uy.ls().me();
            if (aVarMe != null && com.bytedance.sdk.openadsdk.core.un.eo.fo().equals("com.pangolin_demo.toutiao")) {
                aVarMe.z(jSONObject);
            }
            int iWp = 1;
            if (i == 3 || i == 4) {
                if (jVar != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("publisher_timeout_control", jVar.fo);
                    jSONObject3.put("time_out_control", jVar.uy);
                    jSONObject3.put("time_out", jVar.kb);
                    jSONObject.put("tmax", jSONObject3);
                }
                jSONObject.put("splash_button_type", 1);
            }
            if (jVar != null) {
                jSONObject.put("render_method", jVar.m);
                if (jVar.m == 1) {
                    if (a(gVar)) {
                        z(i, jSONObject);
                    } else {
                        z(jSONObject, "accepted_size", gVar.m(), gVar.e());
                    }
                } else if (jVar.m == 2) {
                    if (gVar.gz() <= 0.0f || gVar.fo() <= 0.0f) {
                        if (a(gVar)) {
                            z(i, jSONObject);
                        } else {
                            z(jSONObject, "accepted_size", gVar.m(), gVar.e());
                        }
                    } else {
                        z(jSONObject, "accepted_size", com.bytedance.sdk.openadsdk.core.un.oq.dl(this.g, gVar.gz()), com.bytedance.sdk.openadsdk.core.un.oq.dl(this.g, gVar.fo()));
                    }
                }
            } else {
                jSONObject.put("render_method", 1);
                z(jSONObject, "accepted_size", gVar.m(), gVar.e());
            }
            jSONObject.put("ptpl_ids", com.bytedance.sdk.openadsdk.core.dl.g.z().z(gVar.a(), i));
            jSONObject.put("ptpl_ids_v3", com.bytedance.sdk.openadsdk.core.dl.g.z().g(gVar.a(), i));
            jSONObject.put("pos", com.bytedance.sdk.openadsdk.core.un.eo.gc(i));
            jSONObject.put("is_support_dpl", gVar.uy());
            jSONObject.put("if_support_render_control", gVar.kb() ? 1 : 0);
            jSONObject.put("support_icon_style", (gk.dl < 5900 || !gVar.sy()) ? 0 : 1);
            if (i == 3 || i == 4) {
                jSONObject.put("splash_load_type", zw.g().fo(com.bytedance.sdk.openadsdk.core.un.eo.g(gVar)));
            }
            if (i == 1 || i == 2) {
                jSONObject.put("is_origin_ad", true);
            }
            if (jVar != null && jVar.wp != null) {
                jSONObject.put("session_params", jVar.wp);
            }
            int iWp2 = gVar.wp();
            if (i == 7) {
                if (com.bytedance.sdk.openadsdk.core.iq.x.z()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.bytedance.sdk.openadsdk.core.iq.x.gc());
                }
                if (com.bytedance.sdk.openadsdk.core.iq.x.dl()) {
                    jSONObject.put("refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.bytedance.sdk.openadsdk.core.iq.x.e());
                }
                if (com.bytedance.sdk.openadsdk.core.iq.x.a()) {
                    jSONObject.put("force_refresh_ad_control", 1);
                    jSONObject.put("refresh_ad_req_num", com.bytedance.sdk.openadsdk.core.iq.x.e());
                }
                iWp2 = 1;
            }
            if (i == 8) {
                boolean zLs = zw.g().ls(gVar.a());
                boolean z2 = com.bytedance.sdk.openadsdk.core.pf.a.z(gVar.a());
                if (!zLs) {
                    jSONObject.put("refresh_control", 0);
                } else if (z2) {
                    jSONObject.put("refresh_control", 0);
                    com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.2
                        @Override // com.bytedance.sdk.openadsdk.kb.z.z
                        public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put(CmcdConfiguration.KEY_CONTENT_ID, "");
                            } catch (JSONException e) {
                                com.bytedance.sdk.component.utils.wp.z(e);
                            }
                            return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("refresh_max").g(jSONObject4.toString());
                        }
                    }, "refresh_max");
                } else {
                    jSONObject.put("refresh_control", 1);
                    jSONObject.put("refresh_ad_req_num", zw.g().xf());
                }
                if (com.bytedance.sdk.openadsdk.core.iq.x.g()) {
                    jSONObject.put("insert_ad_control", 1);
                    jSONObject.put("insert_ad_req_num", com.bytedance.sdk.openadsdk.core.iq.x.m());
                }
            } else {
                iWp = iWp2;
            }
            if (jVar != null && jVar.gc != null) {
                iWp = gVar.wp();
            }
            jSONObject.put("ad_count", iWp);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void z(int i, JSONObject jSONObject) {
        if (g(i)) {
            z(jSONObject, "accepted_size", com.bytedance.sdk.openadsdk.core.un.oq.a(this.g), com.bytedance.sdk.openadsdk.core.un.oq.gc(this.g));
        } else {
            z(jSONObject, "accepted_size", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    private boolean a(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        return gVar != null && gVar.e() == 320 && gVar.m() == 640;
    }

    private void z(JSONObject jSONObject, String str, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (i > 0 && i2 > 0) {
                jSONObject2.put(MediaFormat.KEY_WIDTH, i);
                jSONObject2.put(MediaFormat.KEY_HEIGHT, i2);
            } else {
                jSONObject2.put(MediaFormat.KEY_WIDTH, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK);
                jSONObject2.put(MediaFormat.KEY_HEIGHT, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void z(JSONObject jSONObject, String str, float f, float f2) {
        if (f <= 0.0f || f2 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put(MediaFormat.KEY_WIDTH, (int) f);
            jSONObject2.put(MediaFormat.KEY_HEIGHT, (int) f2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f1128a;
        final long dl;
        final String e;
        final String fo;
        final long g;
        final String gc;
        public final com.bytedance.sdk.openadsdk.core.iq.z gz;
        final int m;
        final ArrayList<Integer> uy;
        final int z;

        private z(String str, int i, int i2, String str2, int i3, String str3, com.bytedance.sdk.openadsdk.core.iq.z zVar, long j, long j2, ArrayList<Integer> arrayList) {
            this.z = i;
            this.f1128a = i2;
            this.gc = str2;
            this.e = str3;
            this.gz = zVar;
            this.fo = str;
            this.m = i3;
            this.g = j;
            this.dl = j2;
            this.uy = arrayList;
        }

        public static z z(JSONObject jSONObject) {
            return z(jSONObject, null, null);
        }

        public static z z(JSONObject jSONObject, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar) {
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString("desc");
            String strOptString3 = jSONObject.optString("request_id");
            int iOptInt3 = jSONObject.optInt(MediationConstant.KEY_REASON);
            Pair<com.bytedance.sdk.openadsdk.core.iq.z, ArrayList<Integer>> pairZ = com.bytedance.sdk.openadsdk.core.z.z(jSONObject, gVar, jVar, jOptLong2);
            if (pairZ != null && pairZ.first != null) {
                ((com.bytedance.sdk.openadsdk.core.iq.z) pairZ.first).z(jSONObject.optLong("request_after"));
            }
            if (pairZ == null) {
                return new z(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null);
            }
            return new z(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, (com.bytedance.sdk.openadsdk.core.iq.z) pairZ.first, jOptLong, jOptLong2, (ArrayList) pairZ.second);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void z(JSONObject jSONObject, final sy.gc gcVar) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            if (gcVar != null) {
                gcVar.z(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || gcVar == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.un.na naVar = new com.bytedance.sdk.openadsdk.core.un.na(com.bytedance.sdk.openadsdk.core.io.gc.z().g().m());
            naVar.z(com.bytedance.sdk.openadsdk.core.un.eo.gz("/api/ad/union/sdk/reward_video/reward/"));
            naVar.dl(jSONObject, "verify");
            naVar.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.3
                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                    if (gVar != null) {
                        if (gVar.gz()) {
                            try {
                                Pair<Boolean, JSONObject> pairZ = com.bytedance.sdk.openadsdk.core.dl.m.z(gVar, "verify", false);
                                a aVarZ = a.z(pairZ.second != null ? (JSONObject) pairZ.second : new JSONObject(gVar.a()));
                                if (aVarZ.z != 20000) {
                                    gcVar.z(aVarZ.z, fo.z(aVarZ.z));
                                    return;
                                } else if (aVarZ.dl == null) {
                                    hh.this.z(gcVar);
                                    return;
                                } else {
                                    gcVar.z(aVarZ);
                                    return;
                                }
                            } catch (Exception e) {
                                com.bytedance.sdk.component.utils.wp.z(e);
                            }
                        } else {
                            String strZ = fo.z(-2);
                            int iZ = gVar.z();
                            if (!gVar.gz() && !TextUtils.isEmpty(gVar.g())) {
                                strZ = gVar.g();
                            }
                            gcVar.z(iZ, strZ);
                            return;
                        }
                    }
                    hh.this.z(gcVar);
                }

                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                    gcVar.z(-2, iOException.getMessage());
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void z(JSONObject jSONObject, final sy.a aVar) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            if (aVar != null) {
                aVar.z(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            }
        } else {
            if (jSONObject == null || aVar == null) {
                return;
            }
            JSONObject jSONObjectZ = com.bytedance.sdk.component.utils.z.z(jSONObject);
            com.bytedance.sdk.component.fo.g.gc gcVarG = com.bytedance.sdk.openadsdk.core.io.gc.z().g().g();
            gcVarG.z(com.bytedance.sdk.openadsdk.core.un.eo.gz("/api/ad/union/sdk/reward_video/live_room/reward"));
            gcVarG.dl(jSONObjectZ.toString());
            gcVarG.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.4
                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar2, com.bytedance.sdk.component.fo.g gVar) {
                    if (gVar != null) {
                        if (gVar.gz() && !TextUtils.isEmpty(gVar.a())) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(gVar.a());
                                String strDl = jSONObject2.optInt("cypher", -1) == 3 ? com.bytedance.sdk.component.utils.z.dl(jSONObject2.optString("message")) : null;
                                if (!TextUtils.isEmpty(strDl)) {
                                    try {
                                        jSONObject2 = new JSONObject(strDl);
                                    } catch (Throwable unused) {
                                    }
                                }
                                dl dlVarZ = dl.z(jSONObject2);
                                if (dlVarZ.z != 20000) {
                                    aVar.z(dlVarZ.z, fo.z(dlVarZ.z));
                                    return;
                                } else if (dlVarZ.dl == null) {
                                    hh.this.z(aVar);
                                    return;
                                } else {
                                    aVar.z(dlVarZ);
                                    return;
                                }
                            } catch (JSONException e) {
                                com.bytedance.sdk.component.utils.wp.z(e);
                            }
                        } else {
                            String strZ = fo.z(-2);
                            int iZ = gVar.z();
                            if (!gVar.gz() && !TextUtils.isEmpty(gVar.g())) {
                                strZ = gVar.g();
                            }
                            aVar.z(iZ, strZ);
                            return;
                        }
                    }
                    hh.this.z(aVar);
                }

                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar2, IOException iOException) {
                    aVar.z(-2, iOException.getMessage());
                }
            });
        }
    }

    public static class a {
        public final sd dl;
        public final boolean g;
        public final int z;

        private a(int i, boolean z, sd sdVar) {
            this.z = i;
            this.g = z;
            this.dl = sdVar;
        }

        public static a z(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            boolean zOptBoolean = jSONObject.optBoolean("verify");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            sd sdVar = new sd();
            if (jSONObjectOptJSONObject != null) {
                try {
                    sdVar.z(jSONObjectOptJSONObject.optInt(MediationConstant.KEY_REASON));
                    sdVar.g(jSONObjectOptJSONObject.optInt("corp_type"));
                    sdVar.dl(jSONObjectOptJSONObject.optInt(MediationConstant.REWARD_AMOUNT));
                    sdVar.z(jSONObjectOptJSONObject.optString(MediationConstant.REWARD_NAME));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                }
            }
            return new a(iOptInt, zOptBoolean, sdVar);
        }
    }

    public static class dl {
        public final bv dl;
        public final String g;
        public final int z;

        private dl(int i, String str, bv bvVar) {
            this.z = i;
            this.g = str;
            this.dl = bvVar;
        }

        public static dl z(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            String strOptString = jSONObject.optString("message");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            bv bvVar = new bv();
            if (jSONObjectOptJSONObject != null) {
                try {
                    bvVar.z(jSONObjectOptJSONObject.optBoolean("is_open"));
                    bvVar.z(jSONObjectOptJSONObject.optString("req_id"));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                }
            }
            return new dl(iOptInt, strOptString, bvVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1 A[PHI: r13
  0x00c1: PHI (r13v10 java.lang.String) = (r13v9 java.lang.String), (r13v14 java.lang.String) binds: [B:32:0x00a4, B:37:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.bytedance.sdk.openadsdk.core.sy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String z(com.bytedance.sdk.openadsdk.ls.dl.dl.g r12, boolean r13, int r14) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.hh.z(com.bytedance.sdk.openadsdk.ls.dl.dl.g, boolean, int):java.lang.String");
    }

    private boolean z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar, int i) {
        boolean z2 = zw.g().z(gVar.a());
        if (z2) {
            gc(gVar, jVar, i, new sy.g() { // from class: com.bytedance.sdk.openadsdk.core.hh.5
                @Override // com.bytedance.sdk.openadsdk.core.sy.g
                public void z(int i2, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
                    com.bytedance.sdk.openadsdk.core.q.v.z().z(i2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.sy.g
                public void z(com.bytedance.sdk.openadsdk.core.iq.z zVar, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
                    com.bytedance.sdk.openadsdk.core.q.v.z().z(0);
                }
            });
        }
        return z2;
    }

    private void z(boolean z2, JSONObject jSONObject, String str) throws Exception {
        String strZ = com.bytedance.sdk.openadsdk.core.component.reward.z.z.z.z().z(z2, str);
        String strOptString = "0";
        String str2 = null;
        if (strZ != null && !TextUtils.isEmpty(strZ)) {
            if (TextUtils.equals(strZ, "0")) {
                str2 = "0";
            } else if (TextUtils.equals(strZ, "1")) {
                str2 = "1";
            } else {
                JSONObject jSONObject2 = new JSONObject(strZ);
                jSONObject.putOpt("cache_info", jSONObject2);
                strOptString = jSONObject2.optString("req_id");
            }
        }
        com.bytedance.sdk.openadsdk.core.q.v.z().z(str, strOptString, str2, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public String z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        return z(gVar, false, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void z(String str, String str2, final sy.z zVar) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            if (zVar != null) {
                zVar.z(false, -1L, 0L);
                return;
            }
            return;
        }
        if (str == null || str2 == null || zVar == null) {
            return;
        }
        JSONObject jSONObjectZ = com.bytedance.sdk.openadsdk.core.gc.g.dl.z(str, str2);
        com.bytedance.sdk.openadsdk.core.un.na naVar = new com.bytedance.sdk.openadsdk.core.un.na(com.bytedance.sdk.openadsdk.core.io.gc.z().g().m());
        String strGz = com.bytedance.sdk.openadsdk.core.un.eo.gz("/api/ad/union/sdk/material/check/");
        try {
            if (TextUtils.isEmpty(new URL(strGz).getQuery())) {
                strGz = strGz + "?abort_aes=1";
            } else {
                strGz = strGz + "&abort_aes=1";
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        naVar.z(strGz);
        naVar.dl(jSONObjectZ, "check_ad");
        naVar.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.6
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                if (gVar != null) {
                    if (gVar.gz()) {
                        boolean z2 = false;
                        if (gVar.a() != null) {
                            try {
                                g gVarZ = g.z(new JSONObject(gVar.a()));
                                j = gVarZ.z;
                                z2 = gVarZ.g;
                            } catch (JSONException e2) {
                                com.bytedance.sdk.component.utils.wp.z(e2);
                            }
                        }
                        zVar.z(z2, j, gVar.fo());
                        return;
                    }
                    zVar.z(false, gVar.z() != 0 ? gVar.z() : -1L, gVar.fo());
                }
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                zVar.z(false, 0L, 0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void z(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.core.gc.g.g gVar) {
        if (gVar == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.un.na naVar = new com.bytedance.sdk.openadsdk.core.un.na(com.bytedance.sdk.openadsdk.core.io.gc.z().g().m());
        String strGz = com.bytedance.sdk.openadsdk.core.un.eo.gz("/api/ad/union/sdk/material/cali/");
        try {
            if (TextUtils.isEmpty(new URL(strGz).getQuery())) {
                strGz = strGz + "?abort_aes=1";
            } else {
                strGz = strGz + "&abort_aes=1";
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        naVar.z(strGz);
        naVar.dl(jSONObject, "checkAndCorrectAd");
        naVar.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.7
            /* JADX WARN: Removed duplicated region for block: B:17:0x0033 A[PHI: r5
  0x0033: PHI (r5v4 com.bytedance.sdk.openadsdk.core.gc.g.a) = 
  (r5v0 com.bytedance.sdk.openadsdk.core.gc.g.a)
  (r5v1 com.bytedance.sdk.openadsdk.core.gc.g.a)
  (r5v2 com.bytedance.sdk.openadsdk.core.gc.g.a)
 binds: [B:10:0x0023, B:16:0x0030, B:12:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // com.bytedance.sdk.component.fo.z.z
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void z(com.bytedance.sdk.component.fo.g.a r11, com.bytedance.sdk.component.fo.g r12) {
                /*
                    r10 = this;
                    if (r12 == 0) goto L50
                    long r0 = java.lang.System.currentTimeMillis()
                    long r2 = r2
                    long r0 = r0 - r2
                    boolean r11 = r12.gz()
                    r2 = -1
                    if (r11 == 0) goto L3b
                    java.lang.String r11 = "checkAndCorrectAd"
                    r4 = 0
                    android.util.Pair r11 = com.bytedance.sdk.openadsdk.core.dl.m.z(r12, r11, r4)     // Catch: java.lang.Exception -> L3b
                    java.lang.Object r4 = r11.second     // Catch: java.lang.Exception -> L3b
                    r5 = 0
                    if (r4 == 0) goto L22
                    java.lang.Object r11 = r11.second     // Catch: java.lang.Exception -> L3b
                    org.json.JSONObject r11 = (org.json.JSONObject) r11     // Catch: java.lang.Exception -> L3b
                    goto L23
                L22:
                    r11 = r5
                L23:
                    if (r11 == 0) goto L33
                    com.bytedance.sdk.openadsdk.core.gc.g.a r5 = com.bytedance.sdk.openadsdk.core.gc.g.a.z(r11)     // Catch: java.lang.Exception -> L2f
                    if (r5 == 0) goto L33
                    int r11 = r5.z     // Catch: java.lang.Exception -> L2f
                    long r6 = (long) r11
                    goto L34
                L2f:
                    r11 = move-exception
                    com.bytedance.sdk.component.utils.wp.z(r11)     // Catch: java.lang.Exception -> L3b
                L33:
                    r6 = r2
                L34:
                    com.bytedance.sdk.openadsdk.core.gc.g.g r4 = r4     // Catch: java.lang.Exception -> L3b
                    r8 = r0
                    r4.z(r5, r6, r8)     // Catch: java.lang.Exception -> L3b
                    return
                L3b:
                    int r11 = r12.z()
                    if (r11 == 0) goto L48
                    int r11 = r12.z()
                    long r11 = (long) r11
                    r6 = r11
                    goto L49
                L48:
                    r6 = r2
                L49:
                    com.bytedance.sdk.openadsdk.core.gc.g.g r4 = r4
                    r5 = 0
                    r8 = r0
                    r4.z(r5, r6, r8)
                L50:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.hh.AnonymousClass7.z(com.bytedance.sdk.component.fo.g.a, com.bytedance.sdk.component.fo.g):void");
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                gVar.z(null, -1L, 0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public com.bytedance.sdk.component.adexpress.z.dl.z z(int i) {
        String strZz;
        com.bytedance.sdk.component.adexpress.z.dl.z zVarA = null;
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            return null;
        }
        if (i == 2) {
            strZz = zw.g().vo();
        } else {
            strZz = zw.g().zz();
        }
        if (TextUtils.isEmpty(strZz)) {
            return null;
        }
        com.bytedance.sdk.component.fo.g.dl dlVarDl = com.bytedance.sdk.openadsdk.core.io.gc.z().g().dl();
        dlVarDl.z(com.bytedance.sdk.openadsdk.core.un.ti.g(strZz));
        com.bytedance.sdk.component.fo.g gVarZ = dlVarDl.z();
        if (gVarZ != null) {
            try {
                if (gVarZ.gz()) {
                    if (i == 2) {
                        zVarA = com.bytedance.sdk.openadsdk.core.ugeno.m.g.gc(gVarZ.a());
                    } else {
                        zVarA = com.bytedance.sdk.component.adexpress.z.dl.z.a(gVarZ.a());
                    }
                }
            } catch (Exception unused) {
            }
        }
        return zVarA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public com.bytedance.sdk.openadsdk.core.iq.a z(final na naVar, String str) {
        String strOc;
        String strI;
        Object obj;
        if (naVar != null) {
            strOc = naVar.oc();
            com.bytedance.sdk.openadsdk.core.iq.gc gcVarC = naVar.c();
            com.bytedance.sdk.openadsdk.core.iq.m mVarBw = naVar.bw();
            strI = mVarBw != null ? mVarBw.i() : null;
            if (TextUtils.isEmpty(strI) && gcVarC != null) {
                strI = gcVarC.a();
            }
            Map<String, Object> mapFq = naVar.fq();
            if (TextUtils.isEmpty(strI) && mapFq != null && (obj = mapFq.get("ad_package_name")) != null) {
                strI = obj.toString();
            }
            if (TextUtils.isEmpty(strI)) {
                strI = naVar.g;
            }
        } else {
            strOc = null;
            strI = null;
        }
        com.bytedance.sdk.component.fo.g.dl dlVarDl = com.bytedance.sdk.openadsdk.core.io.gc.z().g().dl();
        dlVarDl.z("https://" + zw.g().lk() + "/customer/api/app/pkg_info");
        dlVarDl.z("convert_id", strOc);
        dlVarDl.z(an.o, strI);
        dlVarDl.z("download_url", com.bytedance.sdk.openadsdk.hh.gz.g(str));
        String str2 = strOc + "_" + strI + "_" + str;
        com.bytedance.sdk.openadsdk.core.iq.a aVarZ = com.bytedance.sdk.openadsdk.core.kb.z.z(str2);
        if (aVarZ != null) {
            return aVarZ;
        }
        final com.bytedance.sdk.component.fo.g[] gVarArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        dlVarDl.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.8
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                gVarArr[0] = gVar;
                countDownLatch.countDown();
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(final com.bytedance.sdk.component.fo.g.a aVar, final IOException iOException) {
                countDownLatch.countDown();
                com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.8.1
                    @Override // com.bytedance.sdk.openadsdk.kb.z.z
                    public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        com.bytedance.sdk.component.fo.g.a aVar2 = aVar;
                        if (aVar2 != null) {
                            jSONObject.putOpt("net_extra", aVar2.a());
                        }
                        IOException iOException2 = iOException;
                        if (iOException2 != null) {
                            jSONObject.putOpt("io_error", iOException2.getMessage());
                        }
                        return com.bytedance.sdk.openadsdk.core.q.z.g.g().gz(naVar != null ? naVar.vk() : "").z("pkg_info_failed").g(jSONObject.toString());
                    }
                }, "pkg_info_failed");
            }
        });
        try {
            countDownLatch.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        try {
            com.bytedance.sdk.component.fo.g gVar = gVarArr[0];
            if (gVar != null && gVar.gz() && !TextUtils.isEmpty(gVarArr[0].a()) && new JSONObject(gVarArr[0].a()).optInt("code", -1) == 0) {
                com.bytedance.sdk.openadsdk.core.iq.a aVar = new com.bytedance.sdk.openadsdk.core.iq.a(new JSONObject(gVarArr[0].a()));
                com.bytedance.sdk.openadsdk.core.kb.z.z(str2, aVar);
                return aVar;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void z(final ja jaVar, final String str, final String str2, final sy.dl dlVar, final int i, final long j) {
        if (dlVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("get_wlink") { // from class: com.bytedance.sdk.openadsdk.core.hh.9
                @Override // java.lang.Runnable
                public void run() {
                    hh.this.g(jaVar, str, str2, dlVar, i, j);
                }
            });
        } else {
            g(jaVar, str, str2, dlVar, i, j);
        }
    }

    private JSONObject z(ja jaVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adv_id", jaVar.dl());
            jSONObject.put("site_id", jaVar.a());
            jSONObject.put("page_url", str);
            jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, str2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ja jaVar, String str, String str2, final sy.dl dlVar, int i, long j) {
        JSONObject jSONObjectZ = z(jaVar, str, str2);
        com.bytedance.sdk.component.fo.g.gc gcVarG = com.bytedance.sdk.openadsdk.core.io.gc.z().g().g();
        if (i == 1) {
            gcVarG.z(jaVar.e());
        } else {
            gcVarG.z(jaVar.z());
        }
        gcVarG.z(jSONObjectZ);
        gcVarG.gc(new HashMap());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.bytedance.sdk.component.utils.gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hh.10
            @Override // java.lang.Runnable
            public void run() {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                dlVar.z(602, "time out!");
            }
        }, j);
        gcVarG.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.11
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                if (gVar == null) {
                    dlVar.z(603, "response is null!");
                    return;
                }
                if (gVar.gz()) {
                    try {
                        JSONObject jSONObject = new JSONObject(gVar.a());
                        String strOptString = jSONObject.optString("message");
                        int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -1);
                        if (iOptInt != 200) {
                            dlVar.z(iOptInt, strOptString);
                            return;
                        }
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                        if (jSONObjectOptJSONObject == null) {
                            dlVar.z(605, strOptString + ", data is null!");
                            return;
                        } else {
                            dlVar.z(jSONObjectOptJSONObject);
                            return;
                        }
                    } catch (Throwable th) {
                        dlVar.z(605, th.getMessage());
                        return;
                    }
                }
                dlVar.z(gVar.z(), gVar.g());
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                dlVar.z(601, iOException.getMessage());
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void z(String str) {
        a(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void z(final JSONObject jSONObject, final sy.dl<com.bytedance.sdk.component.fo.g> dlVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.bytedance.sdk.component.uy.e.z().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hh.13
                @Override // java.lang.Runnable
                public void run() {
                    hh.this.g(jSONObject, (sy.dl<com.bytedance.sdk.component.fo.g>) dlVar);
                }
            });
        } else {
            g(jSONObject, dlVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void z(final Function<SparseArray<Object>, Object> function) {
        com.bytedance.sdk.component.fo.g.gc gcVarG = com.bytedance.sdk.openadsdk.core.io.gc.z().g().g();
        gcVarG.z("https://" + uy.ls().lw() + "/ad_union_qa/sdk/query_config_list");
        gcVarG.g("x-pglcypher", "4");
        gcVarG.g("x-ad-sdk-version", gk.f1105a);
        gcVarG.g("x-plugin-version", "7.1.0.5");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_APP_ID, uy.ls().q());
            jSONObject.put(an.x, "android");
            jSONObject.put("ad_sdk_version", gk.f1105a);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
        } catch (Throwable unused) {
        }
        byte[] bArrZ = com.bytedance.sdk.openadsdk.core.un.i.z(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
        final com.bytedance.sdk.component.a.z zVarG = com.bytedance.sdk.openadsdk.core.un.io.g();
        if (zVarG == null) {
            z(function, -4, "armor service init fail");
        } else {
            gcVarG.z("application/octet-stream", zVarG.encrypt(bArrZ));
            gcVarG.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.14
                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                    byte[] bArrDecrypt;
                    Function function2 = function;
                    if (function2 == null || gVar == null) {
                        hh.this.z((Function<SparseArray<Object>, Object>) function2, -1, "response is null");
                        return;
                    }
                    String str = gVar.dl().get("content-type");
                    String str2 = gVar.dl().get("x-pglcypher");
                    if (TextUtils.equals(str, "application/octet-stream") || TextUtils.equals(str2, "4")) {
                        bArrDecrypt = zVarG.decrypt(gVar.uy());
                    } else {
                        bArrDecrypt = gVar.a().getBytes();
                    }
                    String strG = com.bytedance.sdk.openadsdk.core.un.i.g(bArrDecrypt);
                    if (TextUtils.isEmpty(strG)) {
                        hh.this.z((Function<SparseArray<Object>, Object>) function, -3, "response unGzipStr is null");
                        return;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(strG);
                        int iOptInt = jSONObject2.optInt("code", -1);
                        String strOptString = jSONObject2.optString("message");
                        if (iOptInt != 0) {
                            hh.this.z((Function<SparseArray<Object>, Object>) function, iOptInt, strOptString);
                            return;
                        }
                        String strOptString2 = jSONObject2.optString("data");
                        if (TextUtils.isEmpty(strOptString2)) {
                            hh.this.z((Function<SparseArray<Object>, Object>) function, iOptInt, "response data is empty");
                        } else {
                            hh.this.z((Function<SparseArray<Object>, Object>) function, strOptString2);
                        }
                    } catch (JSONException unused2) {
                        hh.this.z((Function<SparseArray<Object>, Object>) function, -1, "response create json error");
                    }
                }

                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                    hh.this.z((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Function<SparseArray<Object>, Object> function, String str) {
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(10000).z(Void.class).z(0, str).g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Function<SparseArray<Object>, Object> function, int i, String str) {
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(10001).z(Void.class).z(0, Integer.valueOf(i)).z(1, str).g());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy
    public void z(final Map<String, Object> map, final Function<SparseArray<Object>, Object> function) {
        if (map == null || map.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.fo.g.gc gcVarG = com.bytedance.sdk.openadsdk.core.io.gc.z().g().g();
        gcVarG.z("https://" + uy.ls().lw() + "/ad_union_qa/sdk/get_ad_config");
        gcVarG.g("x-pglcypher", "4");
        gcVarG.g("x-ad-sdk-version", gk.f1105a);
        gcVarG.g("x-plugin-version", "7.1.0.5");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_APP_ID, uy.ls().q());
            jSONObject.put(an.x, "android");
            jSONObject.put("ad_sdk_version", gk.f1105a);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            byte[] bArrZ = com.bytedance.sdk.openadsdk.core.un.i.z(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
            final com.bytedance.sdk.component.a.z zVarG = com.bytedance.sdk.openadsdk.core.un.io.g();
            if (zVarG == null) {
                z(function, -4, "armor service init fail");
            } else {
                gcVarG.z("application/octet-stream", zVarG.encrypt(bArrZ));
                gcVarG.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.15
                    @Override // com.bytedance.sdk.component.fo.z.z
                    public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                        String strG;
                        int iOptInt = -1;
                        if (gVar == null) {
                            hh.this.z((Function<SparseArray<Object>, Object>) function, -1, "response is null");
                            return;
                        }
                        String str = gVar.dl().get("content-type");
                        String str2 = gVar.dl().get("x-pglcypher");
                        String strOptString = "";
                        if (TextUtils.equals(str, "application/octet-stream") || TextUtils.equals(str2, "4")) {
                            strG = com.bytedance.sdk.openadsdk.core.un.i.g(zVarG.decrypt(gVar.uy()));
                            if (TextUtils.isEmpty(strG)) {
                                strOptString = "data is null";
                            } else {
                                PluginValueSet pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function);
                                if (!TextUtils.isEmpty(strG) && function != null && pluginValueSetG != null && TextUtils.equals((CharSequence) pluginValueSetG.objectValue(0, String.class), "GetAdConfigImpl")) {
                                    uy.ls().z(new uy.a(map, strG));
                                }
                                iOptInt = 0;
                            }
                        } else {
                            try {
                                JSONObject jSONObject2 = new JSONObject(gVar.a());
                                iOptInt = jSONObject2.optInt("code");
                                String strOptString2 = jSONObject2.optString("message");
                                try {
                                    strOptString = jSONObject2.optString("data");
                                    PluginValueSet pluginValueSetG2 = com.bytedance.sdk.openadsdk.ls.dl.g(function);
                                    if (!TextUtils.isEmpty(strOptString) && function != null && pluginValueSetG2 != null && TextUtils.equals((CharSequence) pluginValueSetG2.objectValue(0, String.class), "GetAdConfigImpl")) {
                                        uy.ls().z(new uy.a(map, strOptString));
                                    }
                                } catch (JSONException unused) {
                                }
                                String str3 = strOptString;
                                strOptString = strOptString2;
                                strG = str3;
                            } catch (JSONException unused2) {
                                strG = "";
                            }
                        }
                        if (iOptInt == 0) {
                            hh.this.z((Function<SparseArray<Object>, Object>) function, strG);
                        } else {
                            hh.this.z((Function<SparseArray<Object>, Object>) function, iOptInt, strOptString);
                        }
                    }

                    @Override // com.bytedance.sdk.component.fo.z.z
                    public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                        hh.this.z((Function<SparseArray<Object>, Object>) function, -2, "response onFailure");
                    }
                });
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONObject jSONObject, final sy.dl<com.bytedance.sdk.component.fo.g> dlVar) {
        String strZ = com.bytedance.sdk.openadsdk.core.un.eo.z("/api/ad/union/sdk/apply_coupon/v2", false);
        com.bytedance.sdk.openadsdk.core.un.na naVar = new com.bytedance.sdk.openadsdk.core.un.na(com.bytedance.sdk.openadsdk.core.io.gc.z().g().m());
        naVar.z(strZ);
        naVar.dl(jSONObject, "coupon_apply");
        naVar.gc(new HashMap());
        naVar.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.16
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                sy.dl dlVar2 = dlVar;
                if (dlVar2 != null) {
                    dlVar2.z(gVar);
                }
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                sy.dl dlVar2 = dlVar;
                if (dlVar2 != null) {
                    dlVar2.z(601, iOException.getMessage());
                }
            }
        });
    }

    private void a(String str) {
        com.bytedance.sdk.component.fo.g.dl dlVarDl = com.bytedance.sdk.openadsdk.core.io.gc.z().g().dl();
        dlVarDl.z(str);
        dlVarDl.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.hh.17
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
            }
        });
    }

    public static class g {
        public final boolean g;
        public final int z;

        private g(int i, boolean z) {
            this.z = i;
            this.g = z;
        }

        public static g z(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new g(jSONObject.optInt("error_code"), jSONObject.optBoolean("result"));
        }
    }
}
