package com.yuewen;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.duokan.reader.ui.general.expandable.SelectionMode;
import com.duokan.reader.ui.general.expandable.ViewMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class lh3 extends BaseAdapter implements pr1, to1 {
    public static final /* synthetic */ boolean e = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Integer, Boolean> f13921b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<vo1> f13920a = new LinkedList<>();
    public ViewMode c = ViewMode.Normal;
    public SelectionMode d = SelectionMode.Multiple;

    public void b() {
        Iterator<vo1> it = this.f13920a.iterator();
        while (it.hasNext()) {
            it.next().i(getItemCount());
        }
    }

    @Override // com.yuewen.to1
    public View c(View view, ViewGroup viewGroup) {
        return null;
    }

    @Override // com.yuewen.pr1
    public int c0() {
        if (this.f13921b == null) {
            return 0;
        }
        int count = getCount();
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            if (this.f13921b.containsKey(Integer.valueOf(i2)) && this.f13921b.get(Integer.valueOf(i2)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public final void d(int i, boolean z, boolean z2) {
        if (l0(i)) {
            if (this.f13921b == null) {
                this.f13921b = new HashMap();
            }
            if (this.d == SelectionMode.Radio) {
                this.f13921b.clear();
            }
            this.f13921b.put(Integer.valueOf(i), Boolean.valueOf(z));
            if (z2) {
                notifyDataSetChanged();
            }
        }
    }

    @Override // com.yuewen.pr1
    public void d0(int i, boolean z) {
        d(i, z, true);
    }

    @Override // com.yuewen.pr1
    public List<Object> e0() {
        ArrayList arrayList = new ArrayList();
        if (this.f13921b != null) {
            for (int i = 0; i < getCount(); i++) {
                if (this.f13921b.containsKey(Integer.valueOf(i)) && this.f13921b.get(Integer.valueOf(i)).booleanValue()) {
                    arrayList.add(getItem(i));
                }
            }
        }
        return arrayList;
    }

    @Override // com.yuewen.pr1
    public void f0() {
        if (this.d == SelectionMode.Radio) {
            return;
        }
        int count = getCount();
        int i = 0;
        while (i < count) {
            d(i, true, i == count + (-1));
            i++;
        }
    }

    @Override // com.yuewen.pr1
    public SelectionMode g0() {
        return this.d;
    }

    @Override // com.yuewen.to1
    public int getItemCount() {
        return getCount();
    }

    @Override // com.yuewen.pr1
    public boolean h0(int i) {
        Map<Integer, Boolean> map = this.f13921b;
        if (map == null || !map.containsKey(Integer.valueOf(i))) {
            return false;
        }
        return this.f13921b.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // com.yuewen.pr1
    public void i0(SelectionMode selectionMode) {
        this.d = selectionMode;
    }

    @Override // com.yuewen.to1
    public void j(vo1 vo1Var) {
        if (this.f13920a.contains(vo1Var)) {
            return;
        }
        this.f13920a.add(vo1Var);
    }

    @Override // com.yuewen.pr1
    public ViewMode j0() {
        return this.c;
    }

    @Override // com.yuewen.to1
    public View k(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup);
    }

    @Override // com.yuewen.pr1
    public void k0(ViewMode viewMode) {
        Map<Integer, Boolean> map;
        this.c = viewMode;
        if (viewMode == ViewMode.Normal && (map = this.f13921b) != null) {
            map.clear();
        }
        notifyDataSetChanged();
    }

    @Override // com.yuewen.to1
    public void l(vo1 vo1Var) {
        this.f13920a.remove(vo1Var);
    }

    @Override // com.yuewen.pr1
    public boolean l0(int i) {
        return true;
    }

    @Override // com.yuewen.pr1
    public void m0() {
        if (this.d == SelectionMode.Radio) {
            return;
        }
        int count = getCount();
        int i = 0;
        while (i < count) {
            d(i, false, i == count + (-1));
            i++;
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        b();
    }
}
