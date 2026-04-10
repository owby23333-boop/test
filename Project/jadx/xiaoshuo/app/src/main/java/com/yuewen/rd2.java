package com.yuewen;

/* JADX INFO: loaded from: classes12.dex */
public class rd2<T> {
    private boolean mHasValue;
    private T mValue;

    public rd2() {
        this.mValue = null;
        this.mHasValue = false;
    }

    public void clear() {
        this.mValue = null;
        this.mHasValue = false;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        rd2 rd2Var = (rd2) obj;
        boolean z = this.mHasValue;
        return (z && rd2Var.mHasValue) ? equalsValue(rd2Var.mValue) : z == rd2Var.mHasValue;
    }

    public boolean equalsValue(T t) {
        if (!this.mHasValue) {
            return false;
        }
        T t2 = this.mValue;
        return (t2 == null || t == null) ? t2 == t : t2.equals(t);
    }

    public T getValue() {
        return this.mValue;
    }

    public boolean hasValue() {
        return this.mHasValue;
    }

    public void set(rd2<T> rd2Var) {
        this.mValue = rd2Var.mValue;
        this.mHasValue = rd2Var.mHasValue;
    }

    public void setValue(T t) {
        this.mValue = t;
        this.mHasValue = true;
    }

    public rd2(T t) {
        this.mValue = t;
        this.mHasValue = t != null;
    }

    public rd2(rd2<T> rd2Var) {
        this.mValue = null;
        this.mValue = rd2Var.mValue;
        this.mHasValue = rd2Var.mHasValue;
    }
}
