package com.bytedance.sdk.openadsdk.core.kb.a;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.extractor.ts.TsExtractor;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.kb.a.dl;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import com.kuaishou.weapon.p0.t;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.ss.android.g.z.z.dl;
import com.ss.android.g.z.z.g;
import com.ss.android.g.z.z.z;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.a.q;
import com.ss.android.z.z.g.p;
import com.ss.android.z.z.g.uf;
import com.ss.android.z.z.gc.m;
import com.umeng.analytics.pro.an;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ls extends com.bytedance.sdk.openadsdk.core.ti.a {
    private static volatile ls z;
    private Function<SparseArray<Object>, Object> fo;
    private final Context g;
    private Map<Integer, dl.z> dl = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Integer, com.ss.android.g.z.z.dl> f1213a = new ConcurrentHashMap();
    private Map<Integer, z.C0450z> gc = new ConcurrentHashMap();
    private Map<Integer, com.ss.android.g.z.z.z> m = new ConcurrentHashMap();
    private Map<Integer, g.z> e = new ConcurrentHashMap();
    private Map<Integer, com.ss.android.g.z.z.g> gz = new ConcurrentHashMap();

    private int wo(int i) {
        return i + 1;
    }

    private Function<SparseArray<Object>, Object> g() {
        Function<SparseArray<Object>, Object> function = this.fo;
        if (function != null) {
            return function;
        }
        if (!com.bytedance.sdk.openadsdk.ls.dl.a.g(gk.dl)) {
            return null;
        }
        this.fo = com.bytedance.sdk.openadsdk.core.uy.ls().m(3);
        HashMap map = new HashMap();
        map.put(t.h, com.bytedance.sdk.openadsdk.core.uy.ls().oq());
        this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(159).z(Map.class).z(0, map).g());
        return this.fo;
    }

    private void yw(int i) {
        this.dl.remove(Integer.valueOf(i));
        this.f1213a.remove(Integer.valueOf(i));
        this.gc.remove(Integer.valueOf(i));
        this.m.remove(Integer.valueOf(i));
        this.e.remove(Integer.valueOf(i));
        this.gz.remove(Integer.valueOf(i));
    }

    private dl.z s(int i) {
        return this.dl.get(Integer.valueOf(i));
    }

    private com.ss.android.g.z.z.dl n(int i) {
        return this.f1213a.get(Integer.valueOf(i));
    }

    private com.ss.android.g.z.z.z ly(int i) {
        return this.m.get(Integer.valueOf(i));
    }

    private com.ss.android.g.z.z.g hn(int i) {
        return this.gz.get(Integer.valueOf(i));
    }

    private ls(Context context) {
        this.g = context;
    }

    public static ls z(Context context) {
        if (z == null) {
            synchronized (ls.class) {
                if (z == null) {
                    z = new ls(context);
                }
            }
        }
        return z;
    }

    public <T> T z(Class<T> cls, int i, Map<String, Object> map) {
        Object obj = map.get("hashCode");
        int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        com.ss.android.z.z.dl.dl dlVarN = n(iIntValue);
        switch (i) {
            case 3:
                pf.z(((Integer) map.get("hid")).intValue());
                break;
            case 4:
                pf.g().z(dlVarN == null ? (String) map.get(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL) : dlVarN.z(), iIntValue);
                yw(iIntValue);
                break;
            case 5:
                if (dlVarN == null) {
                    dlVarN = dl(map.get("downloadModel"));
                }
                pf.g().z(this.g, iIntValue, g(map.get("downloadStatusChangeListener")), dlVarN);
                break;
            case 6:
                break;
            case 7:
                pf.dl();
                break;
            case 8:
                pf.g().z(dlVarN == null ? (String) map.get(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL) : dlVarN.z(), ((Boolean) map.get("force")).booleanValue());
                break;
            case 9:
                pf.z(((Integer) map.get("hid")).intValue(), (dl.z) map.get("onEventLogHandler"));
                break;
            case 10:
                pf.z((String) map.get("downloadPath"));
                break;
            case 12:
                Uri uri = (Uri) map.get(ContentProviderManager.PROVIDER_URI);
                if (dlVarN == null) {
                    dlVarN = dl(map.get("downloadModel"));
                }
                com.ss.android.z.z.dl.dl dlVar = dlVarN;
                com.ss.android.z.z.dl.g gVarHn = hn(iIntValue);
                if (gVarHn == null) {
                    gVarHn = a(map.get("downloadEventConfig"));
                }
                com.ss.android.z.z.dl.g gVar = gVarHn;
                com.ss.android.z.z.dl.z zVarLy = ly(iIntValue);
                if (zVarLy == null) {
                    zVarLy = gc(map.get("downloadController"));
                }
                com.ss.android.z.z.dl.z zVar = zVarLy;
                p pVarFo = fo(map.get("downloadButtonClickListener"));
                if (!z(pVarFo)) {
                }
                break;
            case 13:
                boolean zBooleanValue = ((Boolean) map.get("isDisableDialog")).booleanValue();
                String str = (String) map.get("userAgent");
                if (dlVarN == null) {
                    dlVarN = dl(map.get("downloadModel"));
                }
                com.ss.android.z.z.dl.dl dlVar2 = dlVarN;
                com.ss.android.z.z.dl.g gVarHn2 = hn(iIntValue);
                if (gVarHn2 == null) {
                    gVarHn2 = a(map.get("downloadEventConfig"));
                }
                com.ss.android.z.z.dl.g gVar2 = gVarHn2;
                com.ss.android.z.z.dl.z zVarLy2 = ly(iIntValue);
                if (zVarLy2 == null) {
                    zVarLy2 = gc(map.get("downloadController"));
                }
                com.ss.android.z.z.dl.z zVar2 = zVarLy2;
                com.ss.android.z.z.dl.a aVarG = g(map.get("downloadStatusChangeListener"));
                p pVarFo2 = fo(map.get("downloadButtonClickListener"));
                if (z(pVarFo2)) {
                    pf.g().gc().z(this.g, str, zBooleanValue, dlVar2, gVar2, zVar2, aVarG, iIntValue, pVarFo2);
                } else {
                    pf.g().gc().z(this.g, str, zBooleanValue, dlVar2, gVar2, zVar2, aVarG, iIntValue);
                }
                break;
            case 14:
                break;
            case 16:
                String strZ = dlVarN == null ? (String) map.get(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL) : dlVarN.z();
                long jLongValue = dlVarN == null ? ((Long) map.get("id")).longValue() : dlVarN.a();
                int iIntValue2 = ((Integer) map.get("action_type_button")).intValue();
                com.ss.android.z.z.dl.g gVarHn3 = hn(iIntValue);
                if (gVarHn3 == null) {
                    gVarHn3 = a(map.get("downloadEventConfig"));
                }
                com.ss.android.z.z.dl.g gVar3 = gVarHn3;
                com.ss.android.g.z.z.z zVarLy3 = ly(iIntValue);
                pf.g().z(strZ, jLongValue, iIntValue2, gVar3, zVarLy3 == null ? gc(map.get("downloadController")) : zVarLy3);
                break;
            case 17:
                String strZ2 = dlVarN == null ? (String) map.get(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL) : dlVarN.z();
                long jLongValue2 = ((Long) map.get("id")).longValue();
                int iIntValue3 = ((Integer) map.get("action_type_button")).intValue();
                com.ss.android.z.z.dl.g gVarHn4 = hn(iIntValue);
                if (gVarHn4 == null) {
                    gVarHn4 = a(map.get("downloadEventConfig"));
                }
                com.ss.android.z.z.dl.g gVar4 = gVarHn4;
                com.ss.android.z.z.dl.z zVarLy4 = ly(iIntValue);
                if (zVarLy4 == null) {
                    zVarLy4 = gc(map.get("downloadController"));
                }
                pf.g().z(strZ2, jLongValue2, iIntValue3, gVar4, zVarLy4, gz(map.get("itemClickListener")), fo(map.get("downloadButtonClickListener")));
                break;
            case 18:
                T t = (T) Boolean.valueOf(pf.g().gc().z(dlVarN == null ? ((Long) map.get("id")).longValue() : dlVarN.a(), iIntValue));
                yw(iIntValue);
                break;
            case 19:
                break;
            case 23:
                if (((Boolean) map.get("mateIsEmpty")).booleanValue()) {
                    dl.z zVar3 = new dl.z();
                    this.dl.put(Integer.valueOf(iIntValue), zVar3);
                    this.f1213a.put(Integer.valueOf(iIntValue), zVar3.z());
                } else {
                    g(iIntValue, map);
                }
                break;
            case 24:
                z(iIntValue, (String) map.get("appIcon"), (String) map.get("appName"), (String) map.get("packageName"));
                break;
            case 25:
                z(iIntValue, ((Integer) map.get("autoOpen")).intValue(), ((Integer) map.get("downloadMode")).intValue(), ((Boolean) map.get("isHaveDownloadSdkConfig")).booleanValue(), ((Boolean) map.get("isEnableAH")).booleanValue(), ((Boolean) map.get("isEnableAM")).booleanValue());
                break;
            case 26:
                m(iIntValue, ((Integer) map.get("downloadMode")).intValue());
                break;
            case 28:
                z(iIntValue, ((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue(), e(map.get("downloadMarketInterceptor")));
                break;
            case 29:
                a(iIntValue, map);
                break;
            case 30:
                g(iIntValue, ((Integer) map.get("downloadScene")).intValue());
                break;
            case 31:
                gc(iIntValue, ((Boolean) map.get("isShowToast")).booleanValue());
                break;
            case 32:
                dl(iIntValue, map);
                break;
            case 44:
                z(iIntValue, ((Integer) map.get("linkMode")).intValue());
                break;
            case 46:
                z(iIntValue, ((Boolean) map.get("enableShowComplianceDialog")).booleanValue());
                break;
            case 49:
                g(iIntValue, ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue());
                break;
            case 50:
                dl(iIntValue, ((Boolean) map.get("enableNewActivity")).booleanValue());
                break;
            case 53:
                z(iIntValue, map.get("extraObject"));
                break;
            case 54:
                z(iIntValue, (JSONObject) map.get("extraJson"));
                break;
            case 56:
                gc(iIntValue, map);
                break;
            case 72:
                g(iIntValue, map.get("extraEventObject"));
                break;
            case 73:
                z(iIntValue, (String) map.get("clickButtonTag"));
                break;
            case 74:
                g(iIntValue, (JSONObject) map.get("eventConfigExtraJson"));
                break;
            case 75:
                dl(iIntValue, (JSONObject) map.get("paramsJson"));
                break;
            case 76:
                g(iIntValue, (String) map.get("clickItemTag"));
                break;
            case 78:
                dl(iIntValue, (String) map.get("refer"));
                break;
            case 79:
                a(iIntValue, (String) map.get("quickAppEventTag"));
                break;
            case 80:
                m(iIntValue, map);
                break;
            case 98:
                jq(iIntValue);
                break;
            case 100:
                f(iIntValue);
                break;
            case 101:
                yx(iIntValue);
                break;
            case 123:
                gc(iIntValue, (String) map.get(TKDownloadReason.KSAD_TK_MD5));
                break;
            case 124:
                z(iIntValue, ((Long) map.get("expectFileLength")).longValue());
                break;
            case 125:
                a(iIntValue, ((Boolean) map.get("needWifi")).booleanValue());
                break;
            case 127:
                g(iIntValue, ((Long) map.get("extraValue")).longValue());
                break;
            case 128:
                m(iIntValue, (String) map.get("appName"));
                break;
            case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                a(iIntValue, (JSONObject) map.get("extraJson"));
                break;
            case 130:
                e(iIntValue, (String) map.get("startToast"));
                break;
            case 131:
                gz(iIntValue, (String) map.get("sdkMonitorScene"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA /* 132 */:
                dl(iIntValue, ((Long) map.get("id")).longValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START /* 133 */:
                m(iIntValue, ((Boolean) map.get("isAd")).booleanValue());
                break;
            case 134:
                dl(iIntValue, ((Integer) map.get("modelType")).intValue());
                break;
            case 135:
                fo(iIntValue, (String) map.get("logExtra"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH /* 136 */:
                uy(iIntValue, (String) map.get("packageName"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME /* 137 */:
                kb(iIntValue, (String) map.get("appIcon"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE /* 139 */:
                z(iIntValue, (List<String>) map.get("clickTrackUrl"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID /* 140 */:
                wp(iIntValue, (String) map.get(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID /* 141 */:
                g(iIntValue, (List<String>) map.get("backupUrls"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO /* 142 */:
                i(iIntValue, (String) map.get("notificationJumpUrl"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE /* 143 */:
                v(iIntValue, (String) map.get("mimeType"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SPADE /* 144 */:
                z(iIntValue, (Map<String, String>) map.get("headers"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES /* 145 */:
                e(iIntValue, ((Boolean) map.get("isShowNotification")).booleanValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK /* 146 */:
                pf(iIntValue, (String) map.get("filePath"));
                break;
            case 147:
                ls(iIntValue, (String) map.get("fileName"));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK /* 148 */:
                gz(iIntValue, ((Boolean) map.get("isNeedIndependentProcess")).booleanValue());
                break;
            case 149:
                a(iIntValue, ((Integer) map.get(DefaultUpdateParser.APIKeyLower.VERSION_CODE)).intValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS /* 150 */:
                p(iIntValue, (String) map.get(DefaultUpdateParser.APIKeyLower.VERSION_NAME));
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS /* 151 */:
                z(iIntValue, new m.z().z((String) map.get("quickAppModelOpenUrl")).g((String) map.get("quickAppModelExtraData")).z());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF /* 152 */:
                fo(iIntValue, ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT /* 153 */:
                gc(iIntValue, ((Integer) map.get("funnelType")).intValue());
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET /* 154 */:
                z(iIntValue, e(map.get("downloadMarketInterceptor")));
                break;
            case 157:
                if (map != null) {
                    Object obj2 = map.get("s");
                    if (obj2 instanceof Service) {
                        com.ss.android.socialbase.downloader.downloader.dl.z((Context) obj2);
                    }
                }
                break;
            case 158:
                if (map != null) {
                    Object obj3 = map.get("i");
                    map.get("c");
                    if (obj3 instanceof Intent) {
                        Intent intent = (Intent) obj3;
                        if (TextUtils.equals(intent.getAction(), "com.csj.install")) {
                            z(intent);
                        } else {
                            intent.setComponent(new ComponentName(com.ss.android.socialbase.downloader.downloader.dl.xl(), (Class<?>) DownloadHandlerService.class));
                            com.ss.android.socialbase.downloader.downloader.dl.xl().startService(intent);
                        }
                    }
                }
                break;
            case 160:
                z(map);
                break;
            case 162:
                Object obj4 = map.get("listener");
                if (obj4 instanceof TTAdInteractionListener) {
                    pf.z((TTAdInteractionListener) obj4);
                }
                break;
        }
        return null;
    }

    private void z(Intent intent) {
        intent.getAction();
        int intExtra = intent.getIntExtra("extra_click_download_ids", -1);
        intent.getIntExtra("extra_click_download_type", -1);
        intent.getStringExtra("extra_tag");
        String stringExtra = intent.getStringExtra("extra_value");
        String stringExtra2 = intent.getStringExtra("extra_log_extra");
        String stringExtra3 = intent.getStringExtra("extra_package_name");
        boolean zDl = eo.dl(this.g, stringExtra3);
        NotificationManager notificationManager = (NotificationManager) this.g.getSystemService("notification");
        com.bytedance.sdk.openadsdk.core.kb.gc.z("notification", stringExtra, stringExtra2, zDl ? TtmlNode.TEXT_EMPHASIS_MARK_OPEN : "install", stringExtra3, "click_other", (String) null, (String) null);
        if (zDl) {
            com.ss.android.downloadlib.e.fo.z(stringExtra3);
            notificationManager.cancel(wo(intExtra));
        } else {
            com.ss.android.socialbase.appdownloader.a.z(this.g, intExtra);
            notificationManager.cancel(wo(intExtra));
        }
    }

    private void z(int i, com.ss.android.z.z.g.gz gzVar) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return;
        }
        zVarLy.z(gzVar);
    }

    private static boolean z(p pVar) {
        if (pVar == null) {
            return false;
        }
        if (TextUtils.equals("main", UMModuleRegister.INNER)) {
            return dl();
        }
        return true;
    }

    private static boolean dl() {
        Field declaredField;
        try {
            try {
                declaredField = com.ss.android.downloadlib.a.class.getDeclaredField("g");
                declaredField.setAccessible(true);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            Field declaredField2 = com.ss.android.downloadlib.a.class.getDeclaredField(an.aD);
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(null);
            if (obj instanceof Integer) {
                int iIntValue = ((Integer) obj).intValue();
                return iIntValue > 107000925 || (iIntValue <= 4061200 && iIntValue > 3000000);
            }
        }
        return declaredField.get(null) instanceof Integer;
    }

    public void z(Bundle bundle) {
        pf.z(this.g);
        g();
    }

    private com.ss.android.z.z.dl.a g(Object obj) {
        if (obj instanceof com.ss.android.z.z.dl.a) {
            return (com.ss.android.z.z.dl.a) obj;
        }
        return null;
    }

    private com.ss.android.z.z.dl.dl dl(Object obj) {
        if (obj instanceof com.ss.android.z.z.dl.dl) {
            return (com.ss.android.z.z.dl.dl) obj;
        }
        return null;
    }

    private com.ss.android.z.z.dl.g a(Object obj) {
        if (obj instanceof com.ss.android.z.z.dl.g) {
            return (com.ss.android.z.z.dl.g) obj;
        }
        return null;
    }

    private com.ss.android.z.z.dl.z gc(Object obj) {
        if (obj instanceof com.ss.android.z.z.dl.z) {
            return (com.ss.android.z.z.dl.z) obj;
        }
        return null;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private com.bytedance.sdk.openadsdk.ls.dl.z.z m(Object obj) {
        if (obj instanceof Function) {
            return new com.bytedance.sdk.openadsdk.ls.dl.z.z(obj);
        }
        return null;
    }

    private com.ss.android.z.z.g.gz e(Object obj) {
        if (obj instanceof com.ss.android.z.z.g.gz) {
            return (com.ss.android.z.z.g.gz) obj;
        }
        return null;
    }

    private uf gz(Object obj) {
        if (obj instanceof uf) {
            return (uf) obj;
        }
        return null;
    }

    private p fo(Object obj) {
        if (obj instanceof p) {
            return (p) obj;
        }
        return null;
    }

    private dl.z z(long j, String str, boolean z2, boolean z3, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z4, String str7, String str8, String str9) {
        dl.z zVarZ = new dl.z().g(j).a(str).dl(z2).m(z3).g(str2).z(jSONObject).gz(true).z(true).z(new q() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.ls.1
            @Override // com.ss.android.socialbase.downloader.a.q
            public Uri z(String str10, String str11) {
                return ls.this.z(str10, str11);
            }
        });
        if (jSONObject2 != null) {
            zVarZ.g(jSONObject2);
        }
        if (!TextUtils.isEmpty(str3)) {
            zVarZ.fo(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            zVarZ.gc(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            zVarZ.e(str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            zVarZ.dl(str6);
        }
        zVarZ.gc(z4);
        zVarZ.z(z(j, str7, str8, str9));
        return zVarZ;
    }

    private void z(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> functionG = g();
        if (functionG == null) {
            com.bytedance.sdk.component.utils.wp.a("xgc_dl", "false");
            return;
        }
        Map map2 = (Map) functionG.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(161).z(Map.class).z(0, map).g());
        if (map2 != null) {
            Notification notification = (Notification) map2.get("notification");
            NotificationManager notificationManager = (NotificationManager) zw.getContext().getSystemService("notification");
            Object obj = map.get("install_download_id");
            notificationManager.notify(wo(obj != null ? ((Integer) obj).intValue() : 0), notification);
        }
    }

    protected Map<String, Object> z(Object obj) {
        HashMap map = new HashMap();
        map.put("params", obj);
        Function<SparseArray<Object>, Object> functionG = g();
        if (functionG == null) {
            return null;
        }
        return (Map) functionG.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(156).z(Map.class).z(0, map).g());
    }

    protected Uri z(String str, String str2) {
        HashMap map = new HashMap();
        map.put("custom_authority", str);
        map.put("custom_file_path", str2);
        Function<SparseArray<Object>, Object> functionG = g();
        if (functionG == null) {
            return null;
        }
        return (Uri) functionG.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(155).z(Uri.class).z(0, map).g());
    }

    private com.ss.android.z.z.gc.g z(long j, String str, String str2, String str3) {
        com.ss.android.z.z.gc.g gVar = new com.ss.android.z.z.gc.g();
        gVar.z(j);
        gVar.g(str);
        gVar.dl(str2);
        gVar.z(str3);
        return gVar;
    }

    private void z(int i, String str, String str2, String str3) {
        dl.z zVarS = s(i);
        if (zVarS == null) {
            return;
        }
        this.f1213a.put(Integer.valueOf(i), zVarS.a(str).e(str2).dl(str3).z());
    }

    private void g(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        dl.z zVarZ = z(((Long) map.get("id")).longValue(), (String) map.get("appIcon"), ((Boolean) map.get("isShowNotification")).booleanValue(), ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue(), (String) map.get("logExtra"), (JSONObject) map.get("extraJson"), (JSONObject) map.get("downloadSettings"), (String) map.get("filePath"), (String) map.get(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL), (String) map.get("appName"), (String) map.get("packageName"), ((Boolean) map.get("isNeedIndependentProcess")).booleanValue(), (String) map.get("openUrl"), (String) map.get("webTitle"), (String) map.get("webUrl"));
        this.dl.put(Integer.valueOf(i), zVarZ);
        this.f1213a.put(Integer.valueOf(i), zVarZ.z());
    }

    private void z(int i, int i2, int i3, boolean z2, boolean z3, boolean z4) {
        z.C0450z c0450zG = new z.C0450z().z(i2).g(i3).z(true).g(false);
        this.gc.put(Integer.valueOf(i), c0450zG);
        if (z2) {
            c0450zG.gz(z3);
            c0450zG.fo(z4);
        }
        this.m.put(Integer.valueOf(i), c0450zG.z());
    }

    private void dl(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int iIntValue = ((Integer) map.get("linkMode")).intValue();
        int iIntValue2 = ((Integer) map.get("downloadMode")).intValue();
        boolean zBooleanValue = ((Boolean) map.get("isEnableBackDialog")).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get("isAddToDownloadManage")).booleanValue();
        map.get("extraOperation");
        boolean zBooleanValue3 = ((Boolean) map.get("shouldUseNewWebView")).booleanValue();
        int iIntValue3 = ((Integer) map.get("interceptFlag")).intValue();
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        Object obj = map.get("extraObject");
        boolean zBooleanValue4 = ((Boolean) map.get("enableShowComplianceDialog")).booleanValue();
        boolean zBooleanValue5 = ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue();
        boolean zBooleanValue6 = ((Boolean) map.get("enableNewActivity")).booleanValue();
        boolean zBooleanValue7 = ((Boolean) map.get("isEnableAH")).booleanValue();
        boolean zBooleanValue8 = ((Boolean) map.get("isEnableAM")).booleanValue();
        z.C0450z c0450zUy = new z.C0450z().z(iIntValue).g(iIntValue2).z(zBooleanValue).g(zBooleanValue2).a(zBooleanValue3).dl(iIntValue3).z(jSONObject).z(obj).gc(zBooleanValue4).m(zBooleanValue5).e(zBooleanValue6).gz(zBooleanValue7).fo(zBooleanValue8).uy(((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue());
        this.gc.put(Integer.valueOf(i), c0450zUy);
        this.m.put(Integer.valueOf(i), c0450zUy.z());
    }

    private void m(int i, int i2) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return;
        }
        zVarLy.z(i2);
    }

    private int k(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return 0;
        }
        return zVarLy.g();
    }

    private void a(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get("clickButtonTag");
        String str2 = (String) map.get("clickItemTag");
        String str3 = (String) map.get("clickStartLabel");
        String str4 = (String) map.get("clickContinueLabel");
        String str5 = (String) map.get("clickPauseLabel");
        String str6 = (String) map.get("storageDenyLabel");
        String str7 = (String) map.get("clickInstallLabel");
        boolean zBooleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get("extraEventObject");
        g.z zVarDl = new g.z().z(str).g(str2).a(str3).m(str4).gc(str5).fo(str6).e(str7).z(zBooleanValue).dl(zBooleanValue2);
        this.e.put(Integer.valueOf(i), zVarDl);
        if (jSONObject != null) {
            zVarDl.z((Object) jSONObject);
        }
        this.gz.put(Integer.valueOf(i), zVarDl.z());
    }

    private void gc(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get("clickButtonTag");
        String str2 = (String) map.get("clickItemTag");
        String str3 = (String) map.get("clickLabel");
        int iIntValue = ((Integer) map.get("downloadScene")).intValue();
        String str4 = (String) map.get("refer");
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        JSONObject jSONObject2 = (JSONObject) map.get("paramsJson");
        String str5 = (String) map.get("clickStartLabel");
        String str6 = (String) map.get("clickContinueLabel");
        String str7 = (String) map.get("clickPauseLabel");
        String str8 = (String) map.get("storageDenyLabel");
        String str9 = (String) map.get("clickInstallLabel");
        boolean zBooleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean zBooleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject3 = (JSONObject) map.get("extraEventObject");
        g.z zVarG = new g.z().z(str).g(str2).dl(str3).a(str5).m(str6).gc(str7).fo(str8).e(str9).z(zBooleanValue).z(iIntValue).dl(zBooleanValue2).uy(str4).z(jSONObject).g(jSONObject2);
        this.e.put(Integer.valueOf(i), zVarG);
        if (jSONObject3 != null) {
            zVarG.z((Object) jSONObject3);
        }
        this.gz.put(Integer.valueOf(i), zVarG.z());
    }

    public int z(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return 0;
        }
        return zVarLy.z();
    }

    public boolean g(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return false;
        }
        return zVarLy.dl();
    }

    public boolean dl(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return false;
        }
        return zVarLy.a();
    }

    public Object a(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return null;
        }
        return zVarLy.e();
    }

    public boolean gc(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return false;
        }
        return zVarLy.gc();
    }

    public int m(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return 1;
        }
        return zVarLy.m();
    }

    public boolean e(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return false;
        }
        return zVarLy.gz();
    }

    public int gz(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return 0;
        }
        return zVarLy.fo();
    }

    public JSONObject fo(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return null;
        }
        return zVarLy.uy();
    }

    public Object uy(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return null;
        }
        return zVarLy.kb();
    }

    public void z(int i, int i2) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return;
        }
        zVarLy.g(i2);
    }

    public boolean kb(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return false;
        }
        return zVarLy.wp();
    }

    public void z(int i, boolean z2) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return;
        }
        zVarLy.z(z2);
    }

    public boolean wp(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return false;
        }
        return zVarLy.i();
    }

    public boolean i(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return false;
        }
        return zVarLy.v();
    }

    public void g(int i, boolean z2) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return;
        }
        zVarLy.dl(z2);
    }

    public void dl(int i, boolean z2) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (this.m == null) {
            return;
        }
        zVarLy.g(z2);
    }

    public boolean v(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return false;
        }
        return zVarLy.pf();
    }

    public boolean pf(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return false;
        }
        return zVarLy.ls();
    }

    public void z(int i, Object obj) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return;
        }
        zVarLy.z(obj);
    }

    public void z(int i, JSONObject jSONObject) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return;
        }
        zVarLy.z(jSONObject);
    }

    public boolean ls(int i) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return false;
        }
        return zVarLy.p();
    }

    private void z(int i, boolean z2, com.ss.android.z.z.g.gz gzVar) {
        com.ss.android.g.z.z.z zVarLy = ly(i);
        if (zVarLy == null) {
            return;
        }
        try {
            zVarLy.z(gzVar);
            zVarLy.a(z2);
        } catch (Throwable unused) {
        }
    }

    public String p(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        return gVarHn == null ? "" : gVarHn.z();
    }

    public String fv(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        return gVarHn == null ? "" : gVarHn.g();
    }

    public String js(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        return gVarHn == null ? "" : gVarHn.dl();
    }

    public String tb(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        return gVarHn == null ? "" : gVarHn.a();
    }

    public String q(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        return gVarHn == null ? "" : gVarHn.gc();
    }

    public String iq(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        return gVarHn == null ? "" : gVarHn.m();
    }

    public String zw(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        return gVarHn == null ? "" : gVarHn.m();
    }

    public String io(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        return gVarHn == null ? "" : gVarHn.gz();
    }

    public String uf(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        return gVarHn == null ? "" : gVarHn.fo();
    }

    public Object sy(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return null;
        }
        return gVarHn.uy();
    }

    public int hh(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return 0;
        }
        return gVarHn.kb();
    }

    public boolean l(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return true;
        }
        return gVarHn.wp();
    }

    public boolean h(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return false;
        }
        return gVarHn.i();
    }

    public JSONObject gk(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return null;
        }
        return gVarHn.v();
    }

    public JSONObject x(int i) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return null;
        }
        return gVarHn.pf();
    }

    public void g(int i, Object obj) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return;
        }
        gVarHn.z(obj);
    }

    public void z(int i, String str) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return;
        }
        gVarHn.g(str);
    }

    public void g(int i, JSONObject jSONObject) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return;
        }
        gVarHn.z(jSONObject);
    }

    public void dl(int i, JSONObject jSONObject) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return;
        }
        gVarHn.g(jSONObject);
    }

    public void g(int i, String str) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return;
        }
        gVarHn.dl(str);
    }

    public void g(int i, int i2) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return;
        }
        gVarHn.z(i2);
    }

    public void dl(int i, String str) {
        com.ss.android.g.z.z.g gVarHn = hn(i);
        if (gVarHn == null) {
            return;
        }
        gVarHn.z(str);
    }

    public void a(int i, String str) {
        hn(i);
    }

    private void m(int i, Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long jLongValue = ((Long) map.get("expectFileLength")).longValue();
        String str = (String) map.get(TKDownloadReason.KSAD_TK_MD5);
        long jLongValue2 = ((Long) map.get("extraValue")).longValue();
        boolean zBooleanValue = ((Boolean) map.get("isAd")).booleanValue();
        int iIntValue = ((Integer) map.get("modelType")).intValue();
        List<String> list = (List) map.get("clickTrackUrl");
        List<String> list2 = (List) map.get("backupUrls");
        String str2 = (String) map.get("notificationJumpUrl");
        String str3 = (String) map.get("mimeType");
        Map<String, String> map2 = (Map) map.get("headers");
        boolean zBooleanValue2 = ((Boolean) map.get("isShowToast")).booleanValue();
        boolean zBooleanValue3 = ((Boolean) map.get("needWifi")).booleanValue();
        String str4 = (String) map.get("fileName");
        int iIntValue2 = ((Integer) map.get(DefaultUpdateParser.APIKeyLower.VERSION_CODE)).intValue();
        String str5 = (String) map.get(DefaultUpdateParser.APIKeyLower.VERSION_NAME);
        String str6 = (String) map.get("quickAppModelOpenUrl");
        com.ss.android.z.z.gc.m mVarZ = new m.z().z(str6).g((String) map.get("quickAppModelExtraData")).z();
        int iIntValue3 = ((Integer) map.get("executorGroup")).intValue();
        String str7 = (String) map.get("startToast");
        String str8 = (String) map.get("sdkMonitorScene");
        boolean zBooleanValue4 = ((Boolean) map.get("autoInstall")).booleanValue();
        boolean zBooleanValue5 = ((Boolean) map.get("distinctDir")).booleanValue();
        boolean zBooleanValue6 = ((Boolean) map.get("enablePause")).booleanValue();
        long jLongValue3 = ((Long) map.get("id")).longValue();
        String str9 = (String) map.get("appIcon");
        boolean zBooleanValue7 = ((Boolean) map.get("isShowNotification")).booleanValue();
        boolean zBooleanValue8 = ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue();
        String str10 = (String) map.get("logExtra");
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        JSONObject jSONObject2 = (JSONObject) map.get("downloadSettings");
        String str11 = (String) map.get("filePath");
        String str12 = (String) map.get(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL);
        String str13 = (String) map.get("appName");
        String str14 = (String) map.get("packageName");
        boolean zBooleanValue9 = ((Boolean) map.get("isNeedIndependentProcess")).booleanValue();
        String str15 = (String) map.get("openUrl");
        String str16 = (String) map.get("webTitle");
        String str17 = (String) map.get("webUrl");
        dl.z zVarZ = new dl.z().z(jLongValue).z(str).dl(jLongValue3).a(jLongValue2).z(zBooleanValue).z(iIntValue).g(str10).a(str9).g(list2).m(str2).z(list).gz(str3).z(map2).g(zBooleanValue2).dl(zBooleanValue7).a(zBooleanValue3).uy(str4).g(iIntValue2).kb(str5).z(mVarZ).m(zBooleanValue8).dl(iIntValue3).wp(str7).i(str8).e(zBooleanValue4).gz(zBooleanValue5).fo(zBooleanValue6).z(jSONObject).z(new q() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.ls.2
            @Override // com.ss.android.socialbase.downloader.a.q
            public Uri z(String str18, String str19) {
                return ls.this.z(str18, str19);
            }
        });
        if (jSONObject2 != null) {
            zVarZ.g(jSONObject2);
        }
        if (!TextUtils.isEmpty(str11)) {
            zVarZ.fo(str11);
        }
        if (!TextUtils.isEmpty(str12)) {
            zVarZ.gc(str12);
        }
        if (!TextUtils.isEmpty(str13)) {
            zVarZ.e(str13);
        }
        if (!TextUtils.isEmpty(str14)) {
            zVarZ.dl(str14);
        }
        zVarZ.gc(zBooleanValue9);
        zVarZ.z(z(jLongValue3, str15, str16, str17));
        this.dl.put(Integer.valueOf(i), zVarZ);
        this.f1213a.put(Integer.valueOf(i), zVarZ.z());
    }

    public long lq(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return 0L;
        }
        return dlVarN.a();
    }

    public String mc(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.gc();
    }

    public long un(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return 0L;
        }
        return dlVarN.m();
    }

    public long ti(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return 0L;
        }
        return dlVarN.e();
    }

    public String eo(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.z();
    }

    public List<String> oq(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.g();
    }

    public String wj(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.dl();
    }

    public String na(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.gz();
    }

    public String xl(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.fo();
    }

    public Map<String, String> j(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.uy();
    }

    public boolean gp(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return true;
        }
        return dlVarN.kb();
    }

    public boolean t(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return true;
        }
        return dlVarN.wp();
    }

    public boolean vm(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return false;
        }
        return dlVarN.i();
    }

    public boolean y(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return false;
        }
        return dlVarN.v();
    }

    public boolean ec(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return false;
        }
        return dlVarN.v();
    }

    public String bv(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.pf();
    }

    public String gb(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.ls();
    }

    public void jq(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return;
        }
        dlVarN.p();
    }

    public JSONObject sv(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.fv();
    }

    public void f(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return;
        }
        dlVarN.js();
    }

    public void yx(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return;
        }
        dlVarN.tb();
    }

    public boolean qd(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return false;
        }
        return dlVarN.q();
    }

    public int zx(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return 0;
        }
        return dlVarN.iq();
    }

    public String b(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.zw();
    }

    public boolean lw(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return true;
        }
        return dlVarN.io();
    }

    public String rv(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.uf();
    }

    public String tc(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.sy();
    }

    public String me(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.hh();
    }

    public com.ss.android.z.z.gc.g nh(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.l();
    }

    public List<String> r(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.h();
    }

    public JSONObject yz(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.gk();
    }

    public int bm(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return 0;
        }
        return dlVarN.x();
    }

    public com.ss.android.z.z.gc.m sd(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.lq();
    }

    public boolean tf(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return false;
        }
        return dlVarN.mc();
    }

    public boolean ja(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return com.ss.android.z.z.m.g.z(com.ss.android.socialbase.downloader.i.z.z(sv(i)), xl(i));
        }
        return dlVarN.ti();
    }

    public int wn(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return 2;
        }
        return dlVarN.eo();
    }

    public int nb(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return 1;
        }
        return dlVarN.oq();
    }

    public String zz(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.wj();
    }

    public String vo(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        return dlVarN == null ? "" : dlVarN.wj();
    }

    public boolean lk(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return true;
        }
        return dlVarN.xl();
    }

    public boolean u(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return false;
        }
        return dlVarN.j();
    }

    public boolean sf(int i) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return true;
        }
        return dlVarN.gp();
    }

    public void gc(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return;
        }
        dlVarN.g(str);
    }

    public void z(int i, long j) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return;
        }
        dlVarN.z(j);
    }

    public void a(int i, boolean z2) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return;
        }
        dlVarN.z(z2);
    }

    public void gc(int i, boolean z2) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return;
        }
        dlVarN.g(z2);
    }

    public void g(int i, long j) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return;
        }
        dlVarN.g(j);
    }

    public void m(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return;
        }
        dlVarN.dl(str);
    }

    public void a(int i, JSONObject jSONObject) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return;
        }
        dlVarN.z(jSONObject);
    }

    public void e(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return;
        }
        dlVarN.a(str);
    }

    public void gz(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return;
        }
        dlVarN.gc(str);
    }

    public com.ss.android.g.z.z.dl dl(int i, long j) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.dl(j);
    }

    public com.ss.android.g.z.z.dl m(int i, boolean z2) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.dl(z2);
    }

    public com.ss.android.g.z.z.dl dl(int i, int i2) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.z(i2);
    }

    public com.ss.android.g.z.z.dl fo(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.e(str);
    }

    public com.ss.android.g.z.z.dl uy(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.gz(str);
    }

    public com.ss.android.g.z.z.dl kb(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.fo(str);
    }

    public com.ss.android.g.z.z.dl z(int i, List<String> list) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.z(list);
    }

    public com.ss.android.g.z.z.dl wp(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.uy(str);
    }

    public com.ss.android.g.z.z.dl g(int i, List<String> list) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.g(list);
    }

    public com.ss.android.g.z.z.dl i(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.kb(str);
    }

    public com.ss.android.g.z.z.dl v(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.wp(str);
    }

    public com.ss.android.g.z.z.dl z(int i, Map<String, String> map) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.z(map);
    }

    public com.ss.android.g.z.z.dl e(int i, boolean z2) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.a(z2);
    }

    public com.ss.android.g.z.z.dl pf(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.z(str);
    }

    public com.ss.android.g.z.z.dl ls(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.v(str);
    }

    public com.ss.android.g.z.z.dl gz(int i, boolean z2) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.gc(z2);
    }

    public com.ss.android.g.z.z.dl a(int i, int i2) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.g(i2);
    }

    public com.ss.android.g.z.z.dl p(int i, String str) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.pf(str);
    }

    public com.ss.android.g.z.z.dl z(int i, com.ss.android.z.z.gc.m mVar) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.z(mVar);
    }

    public com.ss.android.g.z.z.dl fo(int i, boolean z2) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.m(z2);
    }

    public com.ss.android.g.z.z.dl gc(int i, int i2) {
        com.ss.android.g.z.z.dl dlVarN = n(i);
        if (dlVarN == null) {
            return null;
        }
        return dlVarN.dl(i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) z().sparseArray();
        }
        return (T) call(i, pluginValueSet, cls);
    }

    public PluginValueSet z() {
        return com.bykv.z.z.z.z.z.z().z(0, pf.z).z(1, Boolean.valueOf(pf.g)).z(10000, 3).g();
    }

    public <T> T call(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        Map<String, Object> map;
        if (i == 20) {
            z((Bundle) pluginValueSet.objectValue(0, Bundle.class));
            return null;
        }
        if (pluginValueSet != null && pluginValueSet.objectValue(0, Map.class) != null) {
            map = (Map) pluginValueSet.objectValue(0, Map.class);
        } else {
            map = new HashMap<>();
        }
        return (T) z(cls, i, map);
    }
}
