package com.bytedance.sdk.openadsdk.ls.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z<E> extends SparseArray<E> {
    private final PluginValueSet g;
    private final ValueSet z;

    public z(ValueSet valueSet) {
        this.z = valueSet == null ? com.bykv.z.z.z.z.dl.z : valueSet;
        this.g = com.bykv.z.z.z.z.z.z;
    }

    public z(PluginValueSet pluginValueSet) {
        this.g = pluginValueSet == null ? com.bykv.z.z.z.z.z.z : pluginValueSet;
        this.z = com.bykv.z.z.z.z.dl.z;
    }

    @Override // android.util.SparseArray
    public boolean contains(int i) {
        return super.contains(i) || this.z.containsKey(i) || this.g.containsKey(i);
    }

    @Override // android.util.SparseArray
    public E get(int i, E e) {
        E e2 = (E) super.get(i, null);
        if (e2 != null) {
            return e2;
        }
        E eZ = z(i);
        return eZ != null ? eZ : e;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [E, java.util.ArrayList, java.util.List] */
    private E z(int i) {
        List list = (E) this.z.objectValue(i, Object.class);
        if (list == null) {
            list = (E) this.g.objectValue(i, Object.class);
        }
        if (list != null) {
            if (i == 9) {
                if (list == Bridge.class) {
                    return Function.class;
                }
                if (list == ValueSet.class) {
                    return SparseArray.class;
                }
            } else {
                if (list instanceof Bridge) {
                    return (E) new dl((Bridge) list);
                }
                if (list instanceof ValueSet) {
                    return (E) new z((ValueSet) list);
                }
                if (list instanceof EventListener) {
                    return (E) new a((EventListener) list);
                }
                if (list instanceof Result) {
                    return (E) com.bytedance.sdk.openadsdk.ls.g.dl.z.z((Result) list);
                }
                if (list instanceof List) {
                    List list2 = list;
                    if (!list2.isEmpty() && (list2.get(0) instanceof Bridge)) {
                        ?? r0 = (E) new ArrayList();
                        Iterator<E> it = list2.iterator();
                        while (it.hasNext()) {
                            r0.add(new dl((Bridge) it.next()));
                        }
                        return r0;
                    }
                } else if (list instanceof Map) {
                    return (E) com.bytedance.sdk.openadsdk.ls.g.dl.z.a(list);
                }
            }
        }
        return (E) list;
    }
}
