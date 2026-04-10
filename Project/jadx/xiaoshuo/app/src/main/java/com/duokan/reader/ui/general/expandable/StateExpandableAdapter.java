package com.duokan.reader.ui.general.expandable;

import com.yuewen.yz0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StateExpandableAdapter extends yz0 {
    public Map<Integer, Map<Integer, ExpandableAdapterState>> g = new HashMap();
    public a h = null;
    public boolean i = false;

    public enum ExpandableAdapterState {
        SELECTED,
        UNSELECT,
        IGNORE
    }

    public interface a {
        void a(int i, boolean z);
    }

    public final Map<Integer, ExpandableAdapterState> Q(int i) {
        Map<Integer, ExpandableAdapterState> map = this.g.get(Integer.valueOf(i));
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        this.g.put(Integer.valueOf(i), map2);
        return map2;
    }

    public ExpandableAdapterState R(int i, int i2) {
        return Q(i).get(Integer.valueOf(i2));
    }

    public ExpandableAdapterState S(int i) {
        Map<Integer, ExpandableAdapterState> map = this.g.get(Integer.valueOf(i));
        if (map == null) {
            return ExpandableAdapterState.IGNORE;
        }
        Iterator<Map.Entry<Integer, ExpandableAdapterState>> it = map.entrySet().iterator();
        ExpandableAdapterState expandableAdapterState = ExpandableAdapterState.SELECTED;
        boolean z = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, ExpandableAdapterState> next = it.next();
            next.getKey();
            ExpandableAdapterState value = next.getValue();
            ExpandableAdapterState expandableAdapterState2 = ExpandableAdapterState.UNSELECT;
            if (value == expandableAdapterState2) {
                expandableAdapterState = expandableAdapterState2;
                break;
            }
            if (value == ExpandableAdapterState.SELECTED) {
                z = false;
            }
        }
        return (expandableAdapterState == ExpandableAdapterState.UNSELECT || !z) ? expandableAdapterState : ExpandableAdapterState.IGNORE;
    }

    public abstract void T();

    public boolean U() {
        return this.i;
    }

    public void V(boolean z) {
        for (int i = 0; i < getGroupCount(); i++) {
            for (int i2 = 0; i2 < C(i); i2++) {
                if (z) {
                    if (R(i, i2) == ExpandableAdapterState.UNSELECT) {
                        W(i, i2, ExpandableAdapterState.SELECTED, false);
                    }
                } else if (R(i, i2) == ExpandableAdapterState.SELECTED) {
                    W(i, i2, ExpandableAdapterState.UNSELECT, false);
                }
            }
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(c0(), this.i);
        }
        K();
    }

    public void W(int i, int i2, ExpandableAdapterState expandableAdapterState, boolean z) {
        Q(i).put(Integer.valueOf(i2), expandableAdapterState);
        if (z) {
            a aVar = this.h;
            if (aVar != null) {
                aVar.a(c0(), this.i);
            }
            K();
        }
    }

    public void X(int i, ExpandableAdapterState expandableAdapterState) {
        for (Map.Entry<Integer, ExpandableAdapterState> entry : this.g.get(Integer.valueOf(i)).entrySet()) {
            entry.getKey();
            ExpandableAdapterState value = entry.getValue();
            if (value != ExpandableAdapterState.IGNORE && value != expandableAdapterState) {
                entry.setValue(expandableAdapterState);
            }
        }
        K();
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(c0(), this.i);
        }
    }

    public void Y(a aVar) {
        this.h = aVar;
        aVar.a(c0(), this.i);
    }

    public int c0() {
        this.i = true;
        int i = 0;
        for (int i2 = 0; i2 < getGroupCount(); i2++) {
            for (int i3 = 0; i3 < C(i2); i3++) {
                ExpandableAdapterState expandableAdapterStateR = R(i2, i3);
                if (expandableAdapterStateR == ExpandableAdapterState.SELECTED) {
                    i++;
                } else if (expandableAdapterStateR == ExpandableAdapterState.UNSELECT) {
                    this.i = false;
                }
            }
        }
        return i;
    }

    public List<Object> e0() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getGroupCount(); i++) {
            for (int i2 = 0; i2 < C(i); i2++) {
                if (R(i, i2) == ExpandableAdapterState.SELECTED) {
                    arrayList.add(A(i, i2));
                }
            }
        }
        return arrayList;
    }
}
