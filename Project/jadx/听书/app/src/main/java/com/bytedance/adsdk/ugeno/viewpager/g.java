package com.bytedance.adsdk.ugeno.viewpager;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    private DataSetObserver g;
    private final DataSetObservable z = new DataSetObservable();

    public Parcelable g() {
        return null;
    }

    public float z(int i) {
        return 1.0f;
    }

    public abstract int z();

    public int z(Object obj) {
        return -1;
    }

    public abstract boolean z(View view, Object obj);

    public Object z(ViewGroup viewGroup, int i) {
        return z((View) viewGroup, i);
    }

    public void z(ViewGroup viewGroup, int i, Object obj) {
        z((View) viewGroup, i, obj);
    }

    @Deprecated
    public Object z(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void z(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void dl() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.z.notifyChanged();
    }

    void z(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.g = dataSetObserver;
        }
    }
}
