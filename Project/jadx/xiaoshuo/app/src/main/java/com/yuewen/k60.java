package com.yuewen;

import com.duokan.reader.domain.document.PageAnchor;
import com.duokan.reader.domain.document.PointAnchor;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k60[] f13380a = null;

    public boolean a(k60 k60Var) {
        if (k60Var == this) {
            return true;
        }
        for (k60 k60Var2 : c()) {
            if (k60Var2.a(k60Var)) {
                return true;
            }
        }
        return false;
    }

    public abstract int b();

    public abstract k60[] c();

    public abstract PointAnchor d();

    public abstract int e();

    public abstract int f();

    public int g() {
        m();
        return this.f13380a.length;
    }

    public k60[] h() {
        m();
        return this.f13380a;
    }

    public abstract PageAnchor i();

    public abstract String j();

    public abstract int k();

    public abstract boolean l();

    public final void m() {
        if (this.f13380a != null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(Arrays.asList(c()));
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            k60[] k60VarArrC = ((k60) listIterator.next()).c();
            for (int length = k60VarArrC.length - 1; length >= 0; length--) {
                listIterator.add(k60VarArrC[length]);
                listIterator.previous();
            }
        }
        this.f13380a = (k60[]) linkedList.toArray(new k60[0]);
    }
}
