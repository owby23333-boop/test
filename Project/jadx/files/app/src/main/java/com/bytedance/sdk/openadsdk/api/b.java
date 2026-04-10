package com.bytedance.sdk.openadsdk.api;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private final SparseArray<Object> mb;

    private static final class mb implements ValueSet {
        private final SparseArray<Object> mb;

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i2, Class<T> cls) {
            Object obj = this.mb.get(i2);
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
        public boolean booleanValue(int i2) {
            return booleanValue(i2, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i2) {
            return this.mb.indexOfKey(i2) >= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i2) {
            Object obj = this.mb.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Double ? ((Double) obj).doubleValue() : PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i2) {
            return floatValue(i2, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i2) {
            return intValue(i2, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.mb.size();
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < size; i2++) {
                hashSet.add(Integer.valueOf(i2));
            }
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i2) {
            return longValue(i2, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i2, Class<T> cls) {
            Object obj = this.mb.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (cls.isInstance(obj)) {
                return (T) this.mb.get(i2);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            SparseArray<Object> sparseArray = this.mb;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.size();
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i2) {
            return stringValue(i2, null);
        }

        private mb(SparseArray<Object> sparseArray) {
            this.mb = sparseArray;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i2, boolean z2) {
            Object obj = this.mb.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i2, float f2) {
            Object obj = this.mb.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i2, int i3) {
            Object obj = this.mb.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i3;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i2, long j2) {
            Object obj = this.mb.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i2, String str) {
            Object obj = this.mb.get(i2);
            return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
        }
    }

    private b(SparseArray<Object> sparseArray) {
        this.mb = sparseArray;
    }

    public static final b mb() {
        return new b(new SparseArray());
    }

    public ValueSet ox() {
        return new mb(this.mb);
    }

    public b mb(int i2, Object obj) {
        this.mb.put(i2, obj);
        return this;
    }

    public b mb(int i2, String str) {
        this.mb.put(i2, str);
        return this;
    }

    public b mb(int i2, boolean z2) {
        this.mb.put(i2, Boolean.valueOf(z2));
        return this;
    }
}
