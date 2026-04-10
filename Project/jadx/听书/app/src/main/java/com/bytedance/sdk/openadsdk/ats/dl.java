package com.bytedance.sdk.openadsdk.ats;

import com.bytedance.sdk.openadsdk.core.gk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class dl implements Function<Object, Object> {
    private int dl = gk.z;
    private static List<Function> z = new ArrayList();
    private static final z g = new z();

    public static <T> T z(String str) {
        T t = (T) g.z(str);
        if (t == null && z.size() > 0) {
            Iterator<Function> it = z.iterator();
            while (it.hasNext()) {
                Object objApply = it.next().apply(str);
                if (objApply != null) {
                    return (T) g.z(str, objApply);
                }
            }
        }
        return t;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        if (obj == null) {
            return Collections.unmodifiableMap(g.z());
        }
        if (obj instanceof Function) {
            z((Function) obj);
            return null;
        }
        if (obj instanceof String) {
            return g.z(String.valueOf(obj));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(this.dl);
        }
        return null;
    }

    private void z(Function function) {
        z.add(function);
        Object objApply = function.apply(null);
        if (objApply instanceof Map) {
            Object objApply2 = function.apply(0);
            int iIntValue = objApply2 instanceof Integer ? ((Integer) objApply2).intValue() : 0;
            for (Map.Entry entry : ((Map) objApply).entrySet()) {
                g.z((String) entry.getKey(), entry.getValue(), iIntValue);
            }
        }
    }
}
