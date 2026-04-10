package com.bytedance.sdk.component.widget.recycler.e.bf;

/* JADX INFO: loaded from: classes.dex */
public final class tg {

    public interface e<T> {
        T e();

        boolean e(T t);
    }

    public static class bf<T> implements e<T> {
        private int bf;
        private final Object[] e;

        public bf(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.e = new Object[i];
        }

        private boolean bf(T t) {
            for (int i = 0; i < this.bf; i++) {
                if (this.e[i] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.e.bf.tg.e
        public T e() {
            int i = this.bf;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.e;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.bf = i - 1;
            return t;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.e.bf.tg.e
        public boolean e(T t) {
            if (!bf(t)) {
                int i = this.bf;
                Object[] objArr = this.e;
                if (i >= objArr.length) {
                    return false;
                }
                objArr[i] = t;
                this.bf = i + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }
}
