package com.bytedance.sdk.openadsdk.ls.g.dl;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bykv.z.z.z.z.g;
import com.bytedance.sdk.openadsdk.ls.g.a;
import com.bytedance.sdk.openadsdk.ls.g.gc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static Result z(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetG = dl.z(sparseArray).g();
        return g.z().z(valueSetG.intValue(-999900)).z(valueSetG.stringValue(-999901)).z(valueSetG.booleanValue(-999903)).z(g((SparseArray<Object>) valueSetG.objectValue(-999902, SparseArray.class))).g();
    }

    public static ValueSet g(SparseArray<Object> sparseArray) {
        SparseArray<Object> sparseArrayZ;
        if (sparseArray == null) {
            return null;
        }
        dl dlVarZ = dl.z();
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            z(dlVarZ, iKeyAt, sparseArray.get(iKeyAt));
        }
        if ((sparseArray instanceof com.bytedance.sdk.openadsdk.ls.g) && (sparseArrayZ = ((com.bytedance.sdk.openadsdk.ls.g) sparseArray).z()) != null && sparseArrayZ.size() > 0) {
            for (int i2 = 0; i2 < sparseArrayZ.size(); i2++) {
                int iKeyAt2 = sparseArrayZ.keyAt(i2);
                z(dlVarZ, iKeyAt2, sparseArrayZ.get(iKeyAt2));
            }
        }
        return dlVarZ.g();
    }

    private static void z(dl dlVar, int i, final Object obj) {
        boolean z = obj instanceof Function;
        if (z) {
            if ((obj instanceof LongSupplier) && ((LongSupplier) obj).getAsLong() == -99999981) {
                dlVar.z(i, new gc((Function) obj));
                return;
            } else {
                dlVar.z(i, new com.bytedance.sdk.openadsdk.ls.g.g((Function) obj));
                return;
            }
        }
        if (obj instanceof SparseArray) {
            if (i == -99999979) {
                dlVar.z(i, z((SparseArray<Object>) obj));
                return;
            } else {
                dlVar.z(i, g((SparseArray<Object>) obj));
                return;
            }
        }
        if ((obj instanceof Supplier) && !z && !(obj instanceof ValueSet)) {
            dlVar.z(i, new Supplier<Object>() { // from class: com.bytedance.sdk.openadsdk.ls.g.dl.z.1
                @Override // java.util.function.Supplier
                public Object get() {
                    return z.g(((Supplier) obj).get());
                }
            });
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty() && (list.get(0) instanceof Function)) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.bytedance.sdk.openadsdk.ls.g.g((Function) it.next()));
                }
                dlVar.z(i, arrayList);
                return;
            }
            dlVar.z(i, obj);
            return;
        }
        if (obj instanceof Map) {
            dlVar.z(i, dl(obj));
        } else {
            dlVar.z(i, obj);
        }
    }

    public static SparseArray<Object> z(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return new SparseArray<>();
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            return (SparseArray) objApply;
        }
        return new SparseArray<>();
    }

    public static Object z(Object obj) {
        if (obj instanceof Bridge) {
            return new com.bytedance.sdk.openadsdk.ls.g.dl((Bridge) obj);
        }
        if (obj instanceof ValueSet) {
            return new com.bytedance.sdk.openadsdk.ls.g.z((ValueSet) obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.isEmpty() || !(list.get(0) instanceof Bridge)) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.bytedance.sdk.openadsdk.ls.g.dl((Bridge) it.next()));
            }
            return arrayList;
        }
        if (obj instanceof Map) {
            return a(obj);
        }
        if (obj == Bridge.class) {
            return Function.class;
        }
        return obj == ValueSet.class ? SparseArray.class : obj;
    }

    public static Object g(Object obj) {
        if (obj instanceof Function) {
            return new com.bytedance.sdk.openadsdk.ls.g.g((Function) obj);
        }
        if (obj instanceof SparseArray) {
            return g((SparseArray<Object>) obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.isEmpty() || !(list.get(0) instanceof Function)) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.bytedance.sdk.openadsdk.ls.g.g((Function) it.next()));
            }
            return arrayList;
        }
        if (obj instanceof Map) {
            return dl(obj);
        }
        if (obj == Function.class) {
            return Bridge.class;
        }
        return obj == SparseArray.class ? ValueSet.class : obj;
    }

    public static Object dl(Object obj) {
        final HashMap map = new HashMap();
        ((Map) obj).forEach(new BiConsumer<Object, Object>() { // from class: com.bytedance.sdk.openadsdk.ls.g.dl.z.2
            @Override // java.util.function.BiConsumer
            public void accept(Object obj2, Object obj3) {
                if (obj3 instanceof Function) {
                    if ((obj3 instanceof LongSupplier) && ((LongSupplier) obj3).getAsLong() == -99999981) {
                        map.put(obj2, new gc((Function) obj3));
                        return;
                    } else {
                        map.put(obj2, new com.bytedance.sdk.openadsdk.ls.g.g((Function) obj3));
                        return;
                    }
                }
                if (obj3 instanceof SparseArray) {
                    map.put(obj2, z.g((SparseArray<Object>) obj3));
                    return;
                }
                if (obj3 == Function.class) {
                    map.put(obj2, Bridge.class);
                } else if (obj3 == SparseArray.class) {
                    map.put(obj2, ValueSet.class);
                } else {
                    map.put(obj2, obj3);
                }
            }
        });
        return map;
    }

    public static Object a(Object obj) {
        final HashMap map = new HashMap();
        ((Map) obj).forEach(new BiConsumer<Object, Object>() { // from class: com.bytedance.sdk.openadsdk.ls.g.dl.z.3
            @Override // java.util.function.BiConsumer
            public void accept(Object obj2, Object obj3) {
                if (obj3 instanceof Bridge) {
                    map.put(obj2, new com.bytedance.sdk.openadsdk.ls.g.dl((Bridge) obj3));
                    return;
                }
                if (obj3 instanceof ValueSet) {
                    map.put(obj2, new com.bytedance.sdk.openadsdk.ls.g.z((ValueSet) obj3));
                    return;
                }
                if (obj3 instanceof EventListener) {
                    map.put(obj2, new a((EventListener) obj3));
                    return;
                }
                if (obj3 == Bridge.class) {
                    map.put(obj2, Function.class);
                } else if (obj3 == ValueSet.class) {
                    map.put(obj2, SparseArray.class);
                } else {
                    map.put(obj2, obj3);
                }
            }
        });
        return map;
    }

    public static SparseArray<Object> z(Result result) {
        if (result == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-999900, Integer.valueOf(result.code()));
        sparseArray.put(-999901, result.message());
        sparseArray.put(-999903, Boolean.valueOf(result.isSuccess()));
        sparseArray.put(-999902, new com.bytedance.sdk.openadsdk.ls.g.z(result.values()));
        return sparseArray;
    }
}
