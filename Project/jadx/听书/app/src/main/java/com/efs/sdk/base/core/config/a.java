package com.efs.sdk.base.core.config;

import android.text.TextUtils;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qq.e.comm.pi.ACTD;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f1546a = new ConcurrentHashMap();

    public final void a(String str, Object obj) {
        if (obj != null) {
            this.f1546a.put(str, obj);
        }
    }

    final Object b(String str, Object obj) {
        Object obj2 = this.f1546a.get(str);
        return (obj2 != null || this.f1546a.containsKey(str)) ? obj2 : obj;
    }

    public final Map<String, Object> a() {
        HashMap map = new HashMap(this.f1546a);
        com.efs.sdk.base.core.a.a.a();
        map.put("ctime", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        com.efs.sdk.base.core.a.a.a();
        map.put("w_tm", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        return map;
    }

    public final List<AbsSection> a(String str) {
        ArrayList arrayList = new ArrayList();
        KVSection kVSection = new KVSection("global_head");
        KVSection kVSectionPut = kVSection.put("type", str).put(ACTD.APPID_KEY, this.f1546a.get(ACTD.APPID_KEY)).put("wid", this.f1546a.get("wid")).put("pid", this.f1546a.get("pid")).put("pkg", this.f1546a.get("pkg")).put("ver", this.f1546a.get("ver")).put("vcode", this.f1546a.get("vcode")).put("ps", this.f1546a.get("ps")).put("stime", this.f1546a.get("stime"));
        com.efs.sdk.base.core.a.a.a();
        KVSection kVSectionPut2 = kVSectionPut.put("ctime", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000));
        com.efs.sdk.base.core.a.a.a();
        kVSectionPut2.put("w_tm", Long.valueOf(com.efs.sdk.base.core.a.a.b() / 1000)).put("sdk_ver", this.f1546a.get("sdk_ver"));
        String strValueOf = String.valueOf(b("uid", ""));
        if (!TextUtils.isEmpty(strValueOf)) {
            kVSection.put("uid", strValueOf);
        }
        arrayList.add(kVSection);
        KVSection kVSection2 = new KVSection("device_info");
        kVSection2.put("lang", this.f1546a.get("lang")).put("brand", this.f1546a.get("brand")).put("model", this.f1546a.get("model")).put("build_model", this.f1546a.get("build_model")).put("rom", this.f1546a.get("rom")).put("sdk", this.f1546a.get("sdk")).put("dsp_h", this.f1546a.get("dsp_h")).put("dsp_w", this.f1546a.get("dsp_w")).put("tzone", this.f1546a.get("tzone")).put(TKDownloadReason.KSAD_TK_NET, this.f1546a.get(TKDownloadReason.KSAD_TK_NET)).put("fr", this.f1546a.get("fr"));
        try {
            if (this.f1546a.containsKey(UMCrash.KEY_HEADER_ACCESS)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS, this.f1546a.get(UMCrash.KEY_HEADER_ACCESS));
            }
            if (this.f1546a.containsKey(UMCrash.KEY_HEADER_ACCESS_SUBTYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, this.f1546a.get(UMCrash.KEY_HEADER_ACCESS_SUBTYPE));
            }
            if (this.f1546a.containsKey(UMCrash.KEY_HEADER_NETWORK_TYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_NETWORK_TYPE, this.f1546a.get(UMCrash.KEY_HEADER_NETWORK_TYPE));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        arrayList.add(kVSection2);
        return arrayList;
    }
}
