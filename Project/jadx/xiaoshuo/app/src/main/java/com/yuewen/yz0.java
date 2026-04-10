package com.yuewen;

import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public abstract class yz0 extends ib1 {
    public b c = null;
    public boolean d = true;
    public int e = -1;
    public HashMap<Integer, Boolean> f = new HashMap<>();

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f20654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f20655b;

        public a(View view, int i) {
            this.f20654a = view;
            this.f20655b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (yz0.this.c != null ? yz0.this.c.a(this.f20654a, this.f20655b) : false) {
                return;
            }
            yz0.this.H(this.f20655b);
        }
    }

    public interface b {
        boolean a(View view, int i);
    }

    public abstract Object A(int i, int i2);

    public abstract View B(int i, int i2, View view, ViewGroup viewGroup);

    public abstract int C(int i);

    public int D() {
        if (this.d) {
            return this.e;
        }
        return -1;
    }

    public Integer[] E() {
        LinkedList linkedList = new LinkedList();
        Iterator<Map.Entry<Integer, Boolean>> it = this.f.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<Integer, Boolean> next = it.next();
            if (next.getValue().booleanValue()) {
                linkedList.add(next.getKey());
            }
        }
        return (Integer[]) linkedList.toArray(new Integer[0]);
    }

    public abstract Object F(int i);

    public abstract View G(int i, boolean z, View view, ViewGroup viewGroup);

    public final void H(int i) {
        if (this.d) {
            M(D() == i ? -1 : i);
        } else {
            this.f.put(Integer.valueOf(i), Boolean.valueOf(!J(i)));
        }
        K();
        L(i);
    }

    public boolean I() {
        return this.d ? D() != -1 : E().length > 0;
    }

    public boolean J(int i) {
        if (this.d) {
            return this.e == i;
        }
        Boolean bool = this.f.get(Integer.valueOf(i));
        return bool != null && bool.booleanValue();
    }

    public void K() {
        q();
    }

    public abstract void L(int i);

    public final void M(int i) {
        if (this.d) {
            this.e = i;
        } else {
            this.f.put(Integer.valueOf(i), Boolean.TRUE);
        }
    }

    public void N(b bVar) {
        this.c = bVar;
    }

    public void O(boolean z) {
        this.d = !z;
    }

    public void P(int i) {
        H(i);
    }

    @Override // com.yuewen.hb1
    public int a(int i) {
        if (J(i)) {
            return C(i);
        }
        return 0;
    }

    @Override // com.yuewen.hb1
    public View f(int i, View view, ViewGroup viewGroup) {
        View viewG = G(i, J(i), view, viewGroup);
        viewG.setOnClickListener(new a(viewG, i));
        return viewG;
    }

    public abstract int getGroupCount();

    @Override // com.yuewen.to1
    public Object getItem(int i) {
        return null;
    }

    @Override // com.yuewen.to1
    public int getItemCount() {
        int iA = 0;
        for (int i = 0; i < getGroupCount(); i++) {
            if (J(i)) {
                iA += a(i);
            }
        }
        return iA;
    }

    @Override // com.yuewen.to1
    public View k(int i, View view, ViewGroup viewGroup) {
        int[] iArrU = u(i);
        return B(iArrU[0], iArrU[1], view, viewGroup);
    }

    public void y() {
        for (int i = 0; i < getGroupCount(); i++) {
            M(i);
        }
        q();
    }

    public void z(int i) {
        M(i);
        q();
    }
}
