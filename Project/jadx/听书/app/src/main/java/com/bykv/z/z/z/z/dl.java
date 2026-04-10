package com.bykv.z.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static final Function<SparseArray<Object>, Object> dl;
    public static final Bridge g;
    public static final ValueSet z = z(0).g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<Object> f125a;
    private ValueSet gc;

    static {
        g = new z();
        dl = new g();
    }

    private dl(SparseArray<Object> sparseArray) {
        this.f125a = sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public static final dl z() {
        return new dl(new SparseArray());
    }

    public static final dl z(int i) {
        return new dl(new SparseArray(i));
    }

    public static final dl z(SparseArray<Object> sparseArray) {
        return new dl(sparseArray);
    }

    public dl z(int i, Object obj) {
        this.f125a.put(i, obj);
        return this;
    }

    public dl z(int i, String str) {
        this.f125a.put(i, str);
        return this;
    }

    public dl z(int i, int i2) {
        this.f125a.put(i, Integer.valueOf(i2));
        return this;
    }

    public dl z(int i, double d) {
        this.f125a.put(i, Double.valueOf(d));
        return this;
    }

    public dl z(int i, boolean z2) {
        this.f125a.put(i, Boolean.valueOf(z2));
        return this;
    }

    public dl z(int i, long j) {
        this.f125a.put(i, Long.valueOf(j));
        return this;
    }

    public dl z(int i, float f) {
        this.f125a.put(i, Float.valueOf(f));
        return this;
    }

    public ValueSet g() {
        return new C0036dl(this.f125a, this.gc);
    }

    /* JADX INFO: renamed from: com.bykv.z.z.z.z.dl$dl, reason: collision with other inner class name */
    private static final class C0036dl implements ValueSet {
        private int dl;
        private ValueSet g;
        private final SparseArray<Object> z;

        private C0036dl(SparseArray<Object> sparseArray, ValueSet valueSet) {
            this.dl = -1;
            this.z = sparseArray;
            this.g = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.z.get(i);
            if (obj == null) {
                ValueSet valueSet = this.g;
                if (valueSet != null) {
                    return (T[]) valueSet.arrayValue(i, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Supplier supplier = (T) this.z.get(i);
            if (supplier == null) {
                ValueSet valueSet = this.g;
                if (valueSet != null) {
                    return (T) valueSet.objectValue(i, cls);
                }
                return null;
            }
            if (supplier instanceof Supplier) {
                supplier = (T) supplier.get();
            }
            if (cls.isInstance(supplier)) {
                return (T) supplier;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            ValueSet valueSet;
            Object obj = this.z.get(i);
            if (obj == null && (valueSet = this.g) != null) {
                return valueSet.doubleValue(i);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            ValueSet valueSet;
            Object obj = this.z.get(i);
            if (obj == null && (valueSet = this.g) != null) {
                return valueSet.stringValue(i, str);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            ValueSet valueSet;
            Object obj = this.z.get(i);
            if (obj == null && (valueSet = this.g) != null) {
                return valueSet.intValue(i, i2);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            ValueSet valueSet;
            Object obj = this.z.get(i);
            if (obj == null && (valueSet = this.g) != null) {
                return valueSet.booleanValue(i, z);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            ValueSet valueSet;
            Object obj = this.z.get(i);
            if (obj == null && (valueSet = this.g) != null) {
                return valueSet.longValue(i, j);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            ValueSet valueSet;
            Object obj = this.z.get(i);
            if (obj == null && (valueSet = this.g) != null) {
                return valueSet.floatValue(i, f);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i) {
            ValueSet valueSet;
            int iIndexOfKey = this.z.indexOfKey(i);
            if (iIndexOfKey >= 0 || (valueSet = this.g) == null) {
                return iIndexOfKey >= 0;
            }
            return valueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.z.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.z.keyAt(i)));
            }
            ValueSet valueSet = this.g;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.dl = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.dl < 0) {
                keys();
            }
            return this.dl;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            ValueSet valueSet = this.g;
            if (valueSet != null && (sparseArray = valueSet.sparseArray()) != null && sparseArray.size() > 0) {
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

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public void remove(int i) {
            this.z.remove(i);
        }
    }

    private static final class z implements Bridge {
        private z() {
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return dl.z;
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (T) 0;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (T) 0L;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (T) Double.valueOf(0.0d);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (T) Float.valueOf(0.0f);
            }
            return null;
        }
    }

    private static final class g<T, R> implements Function<T, R> {
        private g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public R apply(T t) {
            if (!(t instanceof SparseArray)) {
                return null;
            }
            Class cls = (Class) ((SparseArray) t).get(-99999985);
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return (R) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (R) 0;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (R) 0L;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (R) Double.valueOf(0.0d);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (R) Float.valueOf(0.0f);
            }
            return null;
        }
    }
}
