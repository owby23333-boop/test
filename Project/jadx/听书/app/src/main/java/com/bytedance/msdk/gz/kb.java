package com.bytedance.msdk.gz;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class kb {
    private static boolean g;
    private static boolean z;

    public static void g(List<String> list, String str) {
    }

    public static List<String> z() {
        ArrayList arrayList = null;
        if (!com.bytedance.msdk.core.z.kb().tb()) {
            return null;
        }
        Field[] declaredFields = com.bytedance.msdk.core.uy.g.class.getDeclaredFields();
        if (declaredFields != null && declaredFields.length != 0) {
            arrayList = new ArrayList();
            for (Field field : declaredFields) {
                if (declaredFields != null && !TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                    arrayList.add(field.getName());
                }
            }
            arrayList.remove("mTotalWaterFallCount");
            arrayList.remove("mWaterFallConfigList");
            arrayList.remove("mWaterFallConfMap");
            arrayList.remove("mTotalLoadLevelCount");
            arrayList.remove("mCurrentCommonAdMaxCpm");
            arrayList.remove("mLoadSortLevelList");
            arrayList.remove("hasServerBidding");
            arrayList.remove("hasClientOrMultiLevel");
            arrayList.remove("mRitInfoJson");
        }
        return arrayList;
    }

    public static List<String> g() {
        ArrayList arrayList = null;
        if (!com.bytedance.msdk.core.z.kb().tb()) {
            return null;
        }
        Field[] declaredFields = com.bytedance.msdk.core.uy.uy.class.getDeclaredFields();
        if (declaredFields != null && declaredFields.length != 0) {
            arrayList = new ArrayList();
            for (Field field : declaredFields) {
                if (declaredFields != null && !TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                    arrayList.add(field.getName());
                }
            }
            arrayList.remove("mServerBiddingWinner");
        }
        return arrayList;
    }

    public static void z(List<String> list, String str) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        list.remove(str);
    }
}
