package com.bytedance.sdk.component.widget.recycler.z.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    public interface z<T> {
        T z();

        boolean z(T t);
    }

    public static class g<T> implements z<T> {
        private int g;
        private final Object[] z;

        public g(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.z = new Object[i];
        }

        @Override // com.bytedance.sdk.component.widget.recycler.z.g.a.z
        public T z() {
            int i = this.g;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.z;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.g = i - 1;
            return t;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.z.g.a.z
        public boolean z(T t) {
            if (g(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.g;
            Object[] objArr = this.z;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.g = i + 1;
            return true;
        }

        private boolean g(T t) {
            for (int i = 0; i < this.g; i++) {
                if (this.z[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }
}
