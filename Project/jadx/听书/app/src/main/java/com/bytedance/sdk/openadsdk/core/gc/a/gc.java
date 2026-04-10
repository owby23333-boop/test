package com.bytedance.sdk.openadsdk.core.gc.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.gc.a.m;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private final m fo;
    private static final gc z = new gc(7);
    private static final gc g = new gc(8);
    private static final gc dl = new gc(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final gc f1079a = new gc(1);
    private static final gc gc = new gc(5);
    private static final gc m = new gc(9);
    private static final gc e = new gc(6);
    private static final gc gz = new gc(0);

    private gc(int i) {
        this.fo = new m(i);
    }

    public static gc z(int i) {
        if (i == 1) {
            return f1079a;
        }
        if (i != 3) {
            switch (i) {
                case 5:
                    return gc;
                case 6:
                    return e;
                case 7:
                    return z;
                case 8:
                    return g;
                case 9:
                    return m;
                default:
                    return gz;
            }
        }
        return dl;
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, na naVar, boolean z2) {
        if (gVar == null || naVar == null) {
            return;
        }
        if ((naVar.gl() != null ? naVar.gl().optInt("save_type") : 0) == 1) {
            return;
        }
        String strA = gVar.a();
        String strG = com.bytedance.sdk.component.utils.z.g(naVar.kv().toString());
        long jCurrentTimeMillis = ((((System.currentTimeMillis() / 1000) / 60) / 60) / 3) + ((long) eo.pf(naVar));
        long jBp = naVar.bp();
        if (naVar.mt() > 0) {
            jBp = Math.min(jBp, naVar.mt());
        }
        this.fo.z(strA, new m.g(strG, naVar.re(), jBp * 1000, naVar.jt()), z2, jCurrentTimeMillis);
    }

    public na z(String str, boolean z2, long j) {
        System.currentTimeMillis();
        m.g gVarZ = this.fo.z(str, z2, j);
        if (gVarZ == null) {
            System.currentTimeMillis();
            return null;
        }
        System.currentTimeMillis();
        try {
            na naVarZ = com.bytedance.sdk.openadsdk.core.z.z(new JSONObject(com.bytedance.sdk.component.utils.z.dl(gVarZ.dl)));
            naVarZ.gz(true);
            naVarZ.oq(101);
            naVarZ.e(gVarZ.z);
            naVarZ.uf(gVarZ.gc);
            naVarZ.ac().g(2);
            return naVarZ;
        } catch (Exception unused) {
            return null;
        }
    }

    public List<na> z(String str, boolean z2, long j, int i) {
        System.currentTimeMillis();
        List<m.g> listZ = this.fo.z(str, z2, j, i);
        if (listZ == null || listZ.isEmpty()) {
            System.currentTimeMillis();
            return Collections.emptyList();
        }
        System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (m.g gVar : listZ) {
            try {
                na naVarZ = com.bytedance.sdk.openadsdk.core.z.z(new JSONObject(com.bytedance.sdk.component.utils.z.dl(gVar.dl)));
                naVarZ.gz(true);
                naVarZ.oq(101);
                naVarZ.e(gVar.z);
                naVarZ.uf(gVar.gc);
                naVarZ.ac().g(2);
                arrayList.add(naVarZ);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public void z(String str) {
        this.fo.z(str);
    }

    public void g(String str) {
        this.fo.g(str);
    }

    public void dl(String str) {
        this.fo.dl(str);
    }

    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.fo.z(str, str2);
    }

    public void z(String str, String str2, boolean z2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.fo.z(str, str2, z2);
    }

    public void z() {
        this.fo.z();
    }

    public static boolean z(na naVar) {
        if (naVar == null) {
            return false;
        }
        return (naVar.gl() != null ? naVar.gl().optInt("save_type") : 0) != 1;
    }
}
