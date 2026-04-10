package com.bykv.z.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PluginValueSet f128a;
    private final SparseArray<Object> dl;
    public static final PluginValueSet z = z(0).g();
    public static final Function<SparseArray<Object>, Object> g = new C0037z();

    private z(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
        this.dl = sparseArray;
        this.f128a = pluginValueSet;
    }

    private z(SparseArray<Object> sparseArray) {
        this.dl = sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public static final z z() {
        return new z(new SparseArray());
    }

    public static final z z(int i) {
        return new z(new SparseArray(i));
    }

    public static final z z(SparseArray<Object> sparseArray) {
        return new z(sparseArray);
    }

    public static final z z(PluginValueSet pluginValueSet) {
        return new z(new SparseArray(), pluginValueSet);
    }

    public z z(int i, Object obj) {
        this.dl.put(i, obj);
        return this;
    }

    public z z(int i, String str) {
        this.dl.put(i, str);
        return this;
    }

    public z z(int i, int i2) {
        this.dl.put(i, Integer.valueOf(i2));
        return this;
    }

    public z z(int i, double d) {
        this.dl.put(i, Double.valueOf(d));
        return this;
    }

    public z z(int i, boolean z2) {
        this.dl.put(i, Boolean.valueOf(z2));
        return this;
    }

    public z z(int i, float f) {
        this.dl.put(i, Float.valueOf(f));
        return this;
    }

    public PluginValueSet g() {
        return new g(this.dl, this.f128a);
    }

    /* JADX INFO: renamed from: com.bykv.z.z.z.z.z$z, reason: collision with other inner class name */
    private static final class C0037z<T, R> implements Function<T, R> {
        private C0037z() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public R apply(T t) {
            if (!(t instanceof SparseArray)) {
                return null;
            }
            Class cls = (Class) ((SparseArray) t).get(-99999985);
            if (cls != Boolean.class && cls != Boolean.TYPE) {
                if (cls != Integer.TYPE && cls != Integer.class) {
                    if (cls != Long.TYPE && cls != Long.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls == Float.TYPE || cls == Float.class) {
                                return (R) Float.valueOf(0.0f);
                            }
                            return null;
                        }
                        return (R) Double.valueOf(0.0d);
                    }
                    return (R) 0L;
                }
                return (R) 0;
            }
            return (R) Boolean.FALSE;
        }
    }

    private static final class g implements PluginValueSet {
        private int dl;
        private PluginValueSet g;
        private final SparseArray<Object> z;

        private g(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
            this.dl = -1;
            this.z = sparseArray;
            this.g = pluginValueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.z.get(i);
            if (obj == null) {
                PluginValueSet pluginValueSet = this.g;
                if (pluginValueSet != null) {
                    return (T[]) pluginValueSet.arrayValue(i, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        private boolean z() {
            return com.bykv.z.z().g() >= 6803 && com.bykv.z.z().g() < 7000;
        }

        private boolean z(Object obj) {
            return z() ? (!(obj instanceof Supplier) || (obj instanceof Function) || (obj instanceof ValueSet)) ? false : true : (obj instanceof Supplier) && !(obj instanceof Function);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Supplier supplier = (T) this.z.get(i);
            if (supplier == null) {
                PluginValueSet pluginValueSet = this.g;
                if (pluginValueSet != null) {
                    return (T) pluginValueSet.objectValue(i, cls);
                }
                return null;
            }
            if (z(supplier)) {
                supplier = (T) supplier.get();
            }
            if (cls.isInstance(supplier)) {
                return (T) supplier;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public double doubleValue(int i) {
            PluginValueSet pluginValueSet;
            Object obj = this.z.get(i);
            if (obj == null && (pluginValueSet = this.g) != null) {
                return pluginValueSet.doubleValue(i);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public String stringValue(int i, String str) {
            PluginValueSet pluginValueSet;
            Object obj = this.z.get(i);
            if (obj == null && (pluginValueSet = this.g) != null) {
                return pluginValueSet.stringValue(i, str);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int intValue(int i, int i2) {
            PluginValueSet pluginValueSet;
            Object obj = this.z.get(i);
            if (obj == null && (pluginValueSet = this.g) != null) {
                return pluginValueSet.intValue(i, i2);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean booleanValue(int i, boolean z) {
            PluginValueSet pluginValueSet;
            Object obj = this.z.get(i);
            if (obj == null && (pluginValueSet = this.g) != null) {
                return pluginValueSet.booleanValue(i, z);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public long longValue(int i, long j) {
            PluginValueSet pluginValueSet;
            Object obj = this.z.get(i);
            if (obj == null && (pluginValueSet = this.g) != null) {
                return pluginValueSet.longValue(i, j);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public float floatValue(int i, float f) {
            PluginValueSet pluginValueSet;
            Object obj = this.z.get(i);
            if (obj == null && (pluginValueSet = this.g) != null) {
                return pluginValueSet.floatValue(i, f);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean containsKey(int i) {
            PluginValueSet pluginValueSet;
            int iIndexOfKey = this.z.indexOfKey(i);
            if (iIndexOfKey >= 0 || (pluginValueSet = this.g) == null) {
                return iIndexOfKey >= 0;
            }
            return pluginValueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public Set<Integer> keys() {
            int size = this.z.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.z.keyAt(i)));
            }
            PluginValueSet pluginValueSet = this.g;
            if (pluginValueSet != null) {
                hashSet.addAll(pluginValueSet.keys());
            }
            this.dl = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int size() {
            if (this.dl < 0) {
                keys();
            }
            return this.dl;
        }

        private boolean g() {
            if (this.z instanceof com.bytedance.sdk.openadsdk.ls.g.z) {
                return true;
            }
            PluginValueSet pluginValueSet = this.g;
            return pluginValueSet != null && (pluginValueSet.sparseArray() instanceof com.bytedance.sdk.openadsdk.ls.g.z);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            if (com.bykv.z.z().g() < 6803 && g()) {
                return new com.bytedance.sdk.openadsdk.ls.g.z(this);
            }
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            PluginValueSet pluginValueSet = this.g;
            if (pluginValueSet != null && (sparseArray = pluginValueSet.sparseArray()) != null && sparseArray.size() > 0) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
            SparseArray<Object> sparseArray3 = this.z;
            if (sparseArray3 != null && sparseArray3.size() > 0) {
                for (int i2 = 0; i2 < this.z.size(); i2++) {
                    sparseArray2.put(this.z.keyAt(i2), this.z.valueAt(i2));
                }
            }
            return sparseArray2;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public void remove(int i) {
            this.z.remove(i);
        }
    }
}
