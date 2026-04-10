package com.bytedance.msdk.core.pf;

import android.text.TextUtils;
import com.bytedance.msdk.core.uy.g;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static g z(g gVar, String str) {
        if (gVar == null || TextUtils.isEmpty(str) || gVar.t() == null || gVar.t().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<uy> it = gVar.t().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            uy next = it.next();
            if (str.equals(next.fv())) {
                arrayList.add(next.gc());
                break;
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        uy uyVar = arrayList.get(0);
        if (uyVar != null && uyVar.gk() && !MediationConstant.ADN_PANGLE.equals(uyVar.pf())) {
            Iterator<uy> it2 = gVar.t().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                uy next2 = it2.next();
                if (next2.gk() && MediationConstant.ADN_PANGLE.equals(next2.pf())) {
                    arrayList.add(next2.gc());
                    break;
                }
            }
        }
        g gVarLs = gVar.ls();
        if (gVarLs.wp()) {
            gVarLs.g(arrayList);
        } else {
            gVarLs.z(arrayList);
        }
        uy uyVar2 = arrayList.get(0);
        uyVar2.gc(0);
        if (uyVar2.js() == 0) {
            gVarLs.a(uyVar2.zw());
        }
        if (uyVar2.js() == 2) {
            gVarLs.z(true);
        }
        if (uyVar2.js() == 1 || uyVar2.js() == 3) {
            gVarLs.g(true);
        }
        gVarLs.i(0);
        return gVarLs;
    }

    public static String z(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("gm_test_slot_")) {
                return str.substring(13);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
