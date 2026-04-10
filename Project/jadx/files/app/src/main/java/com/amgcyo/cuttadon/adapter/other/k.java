package com.amgcyo.cuttadon.adapter.other;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MkListViewBaseAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class k<T> extends BaseAdapter {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected List<T> f3088s = new ArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private LayoutInflater f3089t;

    /* JADX INFO: compiled from: MkListViewBaseAdapter.java */
    public static class a {
        View a;
        SparseArray<View> b = new SparseArray<>();

        public a(View view) {
            this.a = view;
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View a(int i2) {
            View view = this.b.get(i2);
            if (view != null) {
                return view;
            }
            View viewFindViewById = this.a.findViewById(i2);
            this.b.put(i2, viewFindViewById);
            return viewFindViewById;
        }
    }

    public k(Context context) {
        this.f3089t = LayoutInflater.from(context);
    }

    public abstract int a(int i2);

    public abstract void a(int i2, int i3, T t2, a aVar, boolean z2);

    public final void a(List<T> list) {
        this.f3088s = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3088s.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i2) {
        return this.f3088s.get(i2);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public abstract int getItemViewType(int i2);

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        boolean z2;
        int itemViewType = getItemViewType(i2);
        if (view == null) {
            view = this.f3089t.inflate(a(itemViewType), (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
            z2 = false;
        } else {
            aVar = (a) view.getTag();
            z2 = true;
        }
        a(itemViewType, i2, this.f3088s.get(i2), aVar, z2);
        return view;
    }

    public final List<T> a() {
        return this.f3088s;
    }
}
