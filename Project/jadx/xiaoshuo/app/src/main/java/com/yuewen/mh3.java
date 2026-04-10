package com.yuewen;

import android.widget.BaseExpandableListAdapter;
import com.duokan.reader.ui.general.expandable.SelectionMode;
import com.duokan.reader.ui.general.expandable.ViewMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class mh3 extends BaseExpandableListAdapter implements zz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewMode f14377a = ViewMode.Normal;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SelectionMode f14378b = SelectionMode.Multiple;
    public Map<Integer, Map<Integer, Boolean>> c;

    @Override // com.yuewen.pr1
    public int c0() {
        if (this.c == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < getGroupCount(); i2++) {
            for (int i3 = 0; i3 < getChildrenCount(i2); i3++) {
                if (g(i2, i3)) {
                    i++;
                }
            }
        }
        return i;
    }

    @Override // com.yuewen.pr1
    public void d0(int i, boolean z) {
        if (l0(i)) {
            if (this.c == null) {
                this.c = new HashMap();
            }
            if (this.f14378b == SelectionMode.Radio) {
                this.c.clear();
            }
            for (int i2 = 0; i2 < getChildrenCount(i); i2++) {
                e(i, i2, z);
            }
        }
    }

    @Override // com.yuewen.zz0
    public void e(int i, int i2, boolean z) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        if (this.f14378b == SelectionMode.Radio) {
            this.c.clear();
        }
        HashMap map = this.c.containsKey(Integer.valueOf(i)) ? (HashMap) this.c.get(Integer.valueOf(i)) : new HashMap();
        map.put(Integer.valueOf(i2), Boolean.valueOf(z));
        this.c.put(Integer.valueOf(i), map);
        notifyDataSetChanged();
    }

    @Override // com.yuewen.pr1
    public List<Object> e0() {
        ArrayList arrayList = new ArrayList();
        if (this.c != null) {
            for (int i = 0; i < getGroupCount(); i++) {
                for (int i2 = 0; i2 < getChildrenCount(i); i2++) {
                    if (g(i, i2)) {
                        arrayList.add(getChild(i, i2));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.yuewen.pr1
    public void f0() {
        if (this.f14378b == SelectionMode.Radio) {
            return;
        }
        int groupCount = getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            d0(i, true);
        }
    }

    @Override // com.yuewen.zz0
    public boolean g(int i, int i2) {
        Map<Integer, Map<Integer, Boolean>> map = this.c;
        if (map != null && map.containsKey(Integer.valueOf(i)) && this.c.get(Integer.valueOf(i)).containsKey(Integer.valueOf(i2))) {
            return this.c.get(Integer.valueOf(i)).get(Integer.valueOf(i2)).booleanValue();
        }
        return false;
    }

    @Override // com.yuewen.pr1
    public SelectionMode g0() {
        return this.f14378b;
    }

    @Override // com.yuewen.pr1
    public boolean h0(int i) {
        if (this.c == null) {
            return false;
        }
        boolean zG = true;
        for (int i2 = 0; i2 < getChildrenCount(i); i2++) {
            zG &= g(i, i2);
        }
        return zG;
    }

    @Override // com.yuewen.pr1
    public void i0(SelectionMode selectionMode) {
        this.f14378b = selectionMode;
    }

    @Override // com.yuewen.pr1
    public ViewMode j0() {
        return this.f14377a;
    }

    @Override // com.yuewen.pr1
    public void k0(ViewMode viewMode) {
        Map<Integer, Map<Integer, Boolean>> map;
        this.f14377a = viewMode;
        if (viewMode == ViewMode.Normal && (map = this.c) != null) {
            map.clear();
        }
        notifyDataSetChanged();
    }

    @Override // com.yuewen.pr1
    public boolean l0(int i) {
        return true;
    }

    @Override // com.yuewen.pr1
    public void m0() {
        if (this.f14378b == SelectionMode.Radio) {
            return;
        }
        int groupCount = getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            d0(i, false);
        }
    }
}
