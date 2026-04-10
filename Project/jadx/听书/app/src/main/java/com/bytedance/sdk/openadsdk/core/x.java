package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.live.EcBackUpWebView;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.model.AdnName;
import com.umeng.analytics.pro.an;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x implements Function<SparseArray<Object>, Object> {
    private final PluginValueSet z = com.bykv.z.z.z.z.z.z().z(11, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.core.x.1
        @Override // java.util.function.Supplier
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Integer get() {
            return Integer.valueOf(uy.ls().bv());
        }
    })).z(12, "7.1.0.5").g();

    public void z(Object obj) {
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            if (bundle.containsKey(PluginConstants.KEY_PL_CONFIG_INFO)) {
                uy.ls().z(bundle.getBundle(PluginConstants.KEY_PL_CONFIG_INFO));
                if (uy.ls().lq().length() == 0 || com.bytedance.sdk.openadsdk.core.un.ls.g()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.hh.z.z.z().g();
                return;
            }
            return;
        }
        if ((obj instanceof Function) && !com.bytedance.sdk.openadsdk.core.ti.z.dl.g(obj)) {
            z((Function<SparseArray<Object>, Object>) obj);
            return;
        }
        if (obj instanceof PluginValueSet) {
            PluginValueSet pluginValueSet = (PluginValueSet) obj;
            try {
                if (pluginValueSet.intValue(0) == 1) {
                    z((ClassLoader) pluginValueSet.objectValue(2, ClassLoader.class), pluginValueSet.stringValue(1));
                }
            } catch (Throwable th) {
                new Object[]{th};
            }
        }
        if ((gk.e() || com.bytedance.sdk.openadsdk.core.un.eo.fo().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.bytedance.sdk.openadsdk.core.ti.z.dl.z(obj);
        }
        if (obj instanceof TTAdInteractionListener) {
            uy.ls().oq().apply(com.bytedance.sdk.openadsdk.ls.a.z().z(162).z(0, new com.bytedance.sdk.openadsdk.core.un.lq().z("listener", obj)).z(Void.class).g());
        }
    }

    private void z(ClassLoader classLoader, String str) throws Throwable {
        ZipFile zipFile;
        getClass().getClassLoader();
        if (classLoader == null || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(gk.z(str, com.bytedance.sdk.openadsdk.hh.kb.dl(str)), "apk/base-1.apk");
        String strSubstring = null;
        if (file.exists() && file.canRead()) {
            try {
                zipFile = new ZipFile(file);
            } catch (Throwable th) {
                th = th;
                zipFile = null;
            }
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (true) {
                    if (!enumerationEntries.hasMoreElements()) {
                        break;
                    }
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (zipEntryNextElement.getName().startsWith("ats")) {
                        strSubstring = zipEntryNextElement.getName().substring(3);
                        break;
                    }
                }
                if (strSubstring != null) {
                    Constructor<?> declaredConstructor = classLoader.loadClass(strSubstring).getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    new com.bytedance.sdk.openadsdk.ats.dl().apply(declaredConstructor.newInstance(new Object[0]));
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("class", strSubstring);
                    jSONObject.put("pkg", str);
                    com.bytedance.sdk.openadsdk.core.q.v.z().z("ats_reg", jSONObject, th);
                    return;
                } finally {
                    com.bytedance.sdk.component.m.dl.dl.g.z(zipFile);
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.q.v.z().z("ats_reg", (JSONObject) null, (Throwable) null);
    }

    public lq z(Context context) {
        return new lq(context);
    }

    public SparseArray<Object> z() {
        return this.z.sparseArray();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        String strOptString;
        String strOptString2;
        String strOptString3 = null;
        if (sparseArray != null) {
            PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
            int iIntValue = pluginValueSetG.intValue(-99999987);
            if (iIntValue == -99999986) {
                PluginValueSet pluginValueSet = this.z;
                if (pluginValueSet != null) {
                    return pluginValueSet.sparseArray();
                }
            } else {
                if (iIntValue == -999800) {
                    return new lq((Context) pluginValueSetG.objectValue(-998000, Context.class));
                }
                if (iIntValue == 16) {
                    uy.ls().z(pluginValueSetG.booleanValue(17, false), (SparseArray<Object>) pluginValueSetG.objectValue(21, SparseArray.class));
                    return null;
                }
                if (iIntValue == 19) {
                    Bundle bundle = (Bundle) pluginValueSetG.objectValue(20, Bundle.class);
                    if (bundle != null) {
                        int i = bundle.getInt("event_id", -1);
                        int i2 = bundle.getInt("event_type", -1);
                        String string = bundle.getString(an.o);
                        try {
                            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.z.dl(bundle.getString("event_token")));
                            strOptString = jSONObject.optString("tag");
                            try {
                                strOptString2 = jSONObject.optString("value");
                                try {
                                    strOptString3 = jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA);
                                } catch (JSONException unused) {
                                }
                            } catch (JSONException unused2) {
                                strOptString2 = null;
                            }
                        } catch (JSONException unused3) {
                            strOptString = null;
                            strOptString2 = null;
                        }
                        return com.bytedance.sdk.openadsdk.core.kb.a.pf.z(i, i2, string, strOptString, strOptString2, strOptString3);
                    }
                    return new Bundle();
                }
                if (iIntValue == 999801) {
                    return this;
                }
                switch (iIntValue) {
                    case 1:
                        z(pluginValueSetG != null ? pluginValueSetG.intValue(11) : -1);
                        break;
                    case 2:
                        return z(com.bykv.z.z.z.z.z.z(pluginValueSetG).g(), pluginValueSetG.booleanValue(13), pluginValueSetG.intValue(14));
                    case 3:
                        g((Context) pluginValueSetG.objectValue(7, Context.class));
                        break;
                    case 4:
                        z(pluginValueSetG.objectValue(8, Object.class));
                        break;
                    case 5:
                        g(pluginValueSetG.objectValue(8, Function.class));
                        break;
                    case 6:
                        return z((Class) pluginValueSetG.objectValue(9, Class.class), (Bundle) pluginValueSetG.objectValue(10, Bundle.class));
                    default:
                        return null;
                }
            }
        }
        return null;
    }

    private void z(Function<SparseArray<Object>, Object> function) {
        if (function != null && com.bykv.z.z.z.z.z.z(com.bytedance.sdk.openadsdk.ls.dl.z(function)).g().intValue(10000) == 1 && gk.e()) {
            com.bytedance.sdk.openadsdk.core.live.g.z().z(function);
        }
    }

    public void g(Object obj) {
        if ((gk.e() || com.bytedance.sdk.openadsdk.core.un.eo.fo().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.bytedance.sdk.openadsdk.core.ti.z.dl.dl(obj);
        }
    }

    /* JADX WARN: Type inference failed for: r8v13, types: [T, java.util.HashMap, java.util.Map] */
    public <T> T z(Class<T> cls, Bundle bundle) {
        boolean z = false;
        int i = bundle != null ? bundle.getInt("type") : 0;
        if (com.bytedance.sdk.openadsdk.core.ti.z.a.z(cls, bundle)) {
            return (T) com.bytedance.sdk.openadsdk.core.ti.z.a.z(com.bytedance.sdk.openadsdk.core.multipro.m.z(zw.getContext()), cls, bundle);
        }
        if (cls == SparseArray.class || (cls != null && "com.bytedance.sdk.openadsdk.AdConfig".equals(cls.getName()))) {
            if (bundle != null && !bundle.keySet().isEmpty()) {
                if (bundle.containsKey("is_paid")) {
                    uy.ls().gc(bundle.getBoolean("is_paid"));
                }
                if (bundle.containsKey("extra_data")) {
                    uy.ls().e(bundle.getString("extra_data"));
                }
                if (bundle.containsKey("keywords")) {
                    uy.ls().gz(bundle.getString("keywords"));
                }
                if (bundle.containsKey("quit_work")) {
                    uy.ls().z(bundle.getBoolean("quit_work", false), (SparseArray<Object>) null);
                }
            }
        } else {
            if (!com.bytedance.sdk.openadsdk.ls.dl.a.g(gk.dl) && i == 1 && cls == ITTDownloadVisitor.class) {
                return (T) com.bytedance.sdk.openadsdk.core.kb.z.uy.create();
            }
            if (cls == Bundle.class) {
                if (bundle == null) {
                    return null;
                }
                int i2 = bundle.getInt("action", 0);
                if (i2 == 0) {
                    uy.ls().z(bundle.getString("plugin_pkg_name"), bundle.getString(PluginConstants.KEY_PLUGIN_VERSION));
                } else if (i2 == 1) {
                    com.bytedance.sdk.openadsdk.core.q.v.z().g(bundle.getString("event_name"), bundle.getString("event_extra"));
                } else if (i2 == 2) {
                    g();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(MediationConstant.RIT_TYPE_SPLASH, 0);
                        jSONObject.put("reward", 0);
                        jSONObject.put("brand", 0);
                        jSONObject.put(AdnName.OTHER, 0);
                        com.bykv.vk.openvk.component.video.z.z.z(jSONObject);
                        com.bytedance.sdk.openadsdk.hh.fo.z(0).gc();
                        com.bykv.vk.openvk.component.video.z.z.z(zw.g().te());
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.dl(th.getMessage());
                    }
                } else if (i2 == 3) {
                    com.bytedance.sdk.component.uy.e.z(-1);
                }
            } else if (cls == ExecutorService.class) {
                if (bundle != null) {
                    int i3 = bundle.getInt("action", 0);
                    if (i3 == 1) {
                        return (T) com.bytedance.sdk.component.uy.kb.g.uy();
                    }
                    if (i3 == 2) {
                        return (T) com.bytedance.sdk.component.uy.kb.g.fo();
                    }
                    if (i3 == 3) {
                        return (T) com.bytedance.sdk.component.uy.kb.g.wp();
                    }
                    return (T) com.bytedance.sdk.component.uy.kb.g.i();
                }
            } else if (cls == Handler.class) {
                if (bundle != null && bundle.getInt("action", 0) == 1) {
                    return (T) com.bytedance.sdk.component.utils.gz.z();
                }
            } else {
                if (cls == View.class) {
                    return (T) new EcBackUpWebView(zw.getContext());
                }
                if (cls == Map.class) {
                    ?? r8 = (T) new HashMap();
                    if (bundle != null && bundle.getString("extra_name").equals("use_mediation_map")) {
                        if (AdSdkInitializerHolder.isSdkInitSuccess() && zw.g().dh() && AdSdkInitializerHolder.hasDispatchAdSdkInitializer()) {
                            z = true;
                        }
                        r8.put("use_mediation_map", Boolean.valueOf(z));
                    }
                    return r8;
                }
                if (cls == Function.class && bundle != null && bundle.getInt("action", 0) == 4) {
                    return (T) com.bytedance.sdk.openadsdk.tools.dl.z();
                }
            }
        }
        return null;
    }

    public void g(Context context) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarJs = uy.ls().js();
        if (aVarJs != null) {
            boolean z = aVarJs.z();
            boolean zDl = aVarJs.dl();
            boolean zGc = aVarJs.gc();
            if (!z && !zDl && !zGc) {
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        if (context != null) {
            com.bytedance.sdk.component.utils.g.z(context, intent, null);
        }
    }

    public String z(PluginValueSet pluginValueSet, boolean z, int i) {
        if (pluginValueSet == null || zw.z() == null) {
            return null;
        }
        return zw.z().z(new com.bytedance.sdk.openadsdk.ls.dl.dl.g(pluginValueSet.sparseArray()), z, i);
    }

    public void z(int i) {
        if (i != uy.ls().bv()) {
            uy.ls().gc(i);
            Intent intent = new Intent();
            intent.setAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            intent.putExtra("theme_status_change", i);
            zw.getContext().sendBroadcast(intent, com.bytedance.sdk.openadsdk.core.un.eo.sy());
        }
    }

    public void g() {
        com.bytedance.sdk.openadsdk.core.un.x.z("open_ad_sdk_meta_cache_kv").clear();
        com.bytedance.sdk.openadsdk.core.un.x.z("tt_materialMeta").clear();
        com.bytedance.sdk.openadsdk.core.un.x.z("tt_splash").clear();
    }
}
