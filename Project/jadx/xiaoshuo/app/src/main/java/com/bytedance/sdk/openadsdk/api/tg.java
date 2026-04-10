package com.bytedance.sdk.openadsdk.api;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.yuewen.w51;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes10.dex */
public final class tg {
    private final SparseArray<Object> e;

    public static final class e implements ValueSet {
        private final SparseArray<Object> e;

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.e.get(i);
            if (obj == null) {
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i) {
            return this.e.indexOfKey(i) >= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            Object obj = this.e.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Double ? ((Double) obj).doubleValue() : w51.l;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.e.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(i));
            }
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Object obj = this.e.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (cls.isInstance(obj)) {
                return (T) this.e.get(i);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            SparseArray<Object> sparseArray = this.e;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.size();
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        private e(SparseArray<Object> sparseArray) {
            this.e = sparseArray;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            Object obj = this.e.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            Object obj = this.e.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            Object obj = this.e.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            Object obj = this.e.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            Object obj = this.e.get(i);
            return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
        }
    }

    private tg(SparseArray<Object> sparseArray) {
        this.e = sparseArray;
    }

    public static final tg e() {
        return new tg(new SparseArray());
    }

    public ValueSet bf() {
        return new e(this.e);
    }

    public tg e(int i, Object obj) {
        this.e.put(i, obj);
        return this;
    }

    public tg e(int i, String str) {
        this.e.put(i, str);
        return this;
    }

    public tg e(int i, int i2) {
        this.e.put(i, Integer.valueOf(i2));
        return this;
    }

    public tg e(int i, boolean z) {
        this.e.put(i, Boolean.valueOf(z));
        return this;
    }

    public tg e(int i, long j) {
        this.e.put(i, Long.valueOf(j));
        return this;
    }
}
