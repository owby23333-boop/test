package com.bytedance.msdk.core.e;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.core.z.z.gc;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.gz.x;
import com.bytedance.msdk.m.g.a;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.funny.audio.core.utils.FileUtils;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static String dl = "KEY_LOAD_SEQ_TIME";
    private static String g = "KEY_LOAD_SEQ";
    private static Comparator<com.bytedance.msdk.g.dl> z;

    public static boolean g(String str) {
        return true;
    }

    public static Comparator<com.bytedance.msdk.g.dl> z() {
        Comparator<com.bytedance.msdk.g.dl> comparator = z;
        return comparator != null ? comparator : g();
    }

    public static Comparator<com.bytedance.msdk.g.dl> g() {
        Comparator<com.bytedance.msdk.g.dl> comparator = new Comparator<com.bytedance.msdk.g.dl>() { // from class: com.bytedance.msdk.core.e.dl.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.g.dl dlVar2) {
                if (dlVar.u() > dlVar2.u()) {
                    return -1;
                }
                if (dlVar.u() < dlVar2.u()) {
                    return 1;
                }
                return (dlVar.u() == dlVar2.u() && dlVar.r() == 1) ? -1 : 0;
            }
        };
        z = comparator;
        return comparator;
    }

    public static void z(List<com.bytedance.msdk.g.dl> list, Comparator<com.bytedance.msdk.g.dl> comparator) {
        if (comparator == null) {
            x.z(list);
        } else {
            x.z(list, comparator);
        }
    }

    public static String z(String str, String str2, String str3) {
        return "com.bytedance.msdk.adapter." + com.bytedance.msdk.g.z.z(str2) + FileUtils.FILE_EXTENSION_SEPARATOR + String.format(str, str2, str3);
    }

    public static boolean z(uy uyVar) {
        if (uyVar != null && TextUtils.equals(uyVar.pf(), MediationConstant.ADN_PANGLE)) {
            return true;
        }
        if (uyVar != null && gc.z(uyVar.pf())) {
            return true;
        }
        if (uyVar == null) {
            return false;
        }
        Function<SparseArray<Object>, Object> functionE = com.bytedance.msdk.core.kb.z.z().e();
        if (functionE != null) {
            String strG = g(uyVar);
            String strG2 = a.g(uyVar.pf());
            if (TextUtils.isEmpty(strG)) {
                return false;
            }
            com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
            zVarZ.z(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, strG);
            zVarZ.z(8560, strG2);
            zVarZ.z(-99999987, 8229);
            zVarZ.z(-99999985, Boolean.class);
            return ((Boolean) functionE.apply(zVarZ.g().sparseArray())).booleanValue();
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "load ad check class loader is null ");
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String g(com.bytedance.msdk.core.uy.uy r14) {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.e.dl.g(com.bytedance.msdk.core.uy.uy):java.lang.String");
    }

    public static String z(String str) {
        return !TextUtils.isEmpty(str) ? str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase()) : str;
    }

    public static String dl() {
        return UUID.randomUUID().toString();
    }

    public static uy z(String str, String str2, int i, int i2) {
        uy uyVar = new uy();
        uyVar.dl(str2);
        uyVar.gc(str);
        uyVar.uy(0);
        uyVar.m("0");
        uyVar.g("1");
        uyVar.kb(i);
        uyVar.wp(i2);
        uyVar.fo(3);
        uyVar.z("%1$s%2$sAdapter");
        return uyVar;
    }

    private static boolean z(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    public static int a() {
        long jG = l.z((String) null, com.bytedance.msdk.core.g.getContext()).g(dl, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = z(new Date(jG), new Date(jCurrentTimeMillis));
        l.z((String) null, com.bytedance.msdk.core.g.getContext()).z(dl, jCurrentTimeMillis);
        int iG = (z2 ? l.z((String) null, com.bytedance.msdk.core.g.getContext()).g(g, 0) : 0) + 1;
        l.z((String) null, com.bytedance.msdk.core.g.getContext()).z(g, iG);
        return iG;
    }

    public static void z(com.bytedance.msdk.api.z zVar, uy uyVar) {
        if (!com.bytedance.msdk.core.g.g().xl() || zVar == null || uyVar == null) {
            return;
        }
        if (820001 == zVar.z) {
            com.bytedance.msdk.api.a.z(com.bytedance.msdk.core.g.getContext(), String.format("error_adn:%1$s no ads，please check ad network", uyVar.p()));
        } else {
            com.bytedance.msdk.api.a.z(com.bytedance.msdk.core.g.getContext(), String.format("test error_adn:%1$s  error_slot_id: %2$s  error_code:%3$d  error_message:%4$s", uyVar.p(), uyVar.fv(), Integer.valueOf(zVar.dl), zVar.f366a));
        }
    }

    public static void z(String str, uy uyVar, com.bytedance.msdk.g.dl dlVar) {
        if (com.bytedance.msdk.core.g.g().xl() && uyVar != null && g(str, dlVar)) {
            com.bytedance.msdk.api.a.z(com.bytedance.msdk.core.g.getContext(), String.format("fill_suceess ,test_adn:%1$s,slot_id : %2$s", uyVar.pf(), Integer.valueOf(uyVar.js())));
        }
    }

    public static void z(String str, com.bytedance.msdk.g.dl dlVar) {
        if (com.bytedance.msdk.core.g.g().xl() && dlVar != null && g(str, dlVar)) {
            com.bytedance.msdk.api.a.z(com.bytedance.msdk.core.g.getContext(), String.format("test_suceess ,test_adn:%1$s,slot_id : %2$s", com.bytedance.msdk.g.z.z(dlVar.r()), dlVar.yz()));
        }
    }

    private static boolean g(String str, com.bytedance.msdk.g.dl dlVar) {
        if (dlVar == null) {
            return false;
        }
        com.bytedance.msdk.core.uy.g gVarZ = com.bytedance.msdk.core.g.g().z(str, dlVar.hy(), 101);
        return com.bytedance.msdk.core.g.g().g(str, dlVar.hy()) && gVarZ != null && gVarZ.mc() != null && gVarZ.mc().size() > 0 && gVarZ.sy() != null && gVarZ.sy().size() > 0;
    }
}
