package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class m implements Function<SparseArray<Object>, Object> {
    private Function<SparseArray<Object>, Object> z;

    public m(Function<SparseArray<Object>, Object> function) {
        this.z = com.bykv.z.z.z.z.z.g;
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public String z() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241103);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    public String g() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241104);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    public boolean dl() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241105);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    public List<m> a() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241108);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.z.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new m(com.bytedance.sdk.openadsdk.l.dl.z(it.next())));
        }
        return arrayList2;
    }

    public boolean gc() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241107);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    public boolean m() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 241106);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    public void z(m mVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, mVar);
        sparseArray.put(-99999987, 241101);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z(boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(-99999987, 241102);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        pluginValueSetG.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 241101:
                    z(new m((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 241102:
                    z(pluginValueSetG.booleanValue(0));
                    return null;
                case 241103:
                    return z();
                case 241104:
                    return g();
                case 241105:
                    return Boolean.class.cast(Boolean.valueOf(dl()));
                case 241106:
                    return Boolean.class.cast(Boolean.valueOf(m()));
                case 241107:
                    return Boolean.class.cast(Boolean.valueOf(gc()));
                case 241108:
                    return a();
                default:
                    return null;
            }
        }
        return new SparseArray();
    }
}
