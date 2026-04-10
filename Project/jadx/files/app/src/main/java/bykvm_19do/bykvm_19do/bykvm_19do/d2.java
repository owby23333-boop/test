package bykvm_19do.bykvm_19do.bykvm_19do;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class d2 {
    private static final LinkedList<u> a = new LinkedList<>();
    private static final LinkedList<u> b = new LinkedList<>();

    public static void a() {
        c0 c0Var;
        c0 c0Var2;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (a) {
            linkedList.addAll(a);
            linkedList2.addAll(b);
            a.clear();
            b.clear();
        }
        while (!linkedList.isEmpty()) {
            v1.a((u) linkedList.poll());
        }
        while (!linkedList2.isEmpty()) {
            u uVar = (u) linkedList2.poll();
            if (uVar instanceof c0) {
                c0Var = (c0) uVar;
            } else {
                if (uVar instanceof w) {
                    w wVar = (w) uVar;
                    c0Var2 = new c0("" + wVar.j() + wVar.k(), "16", 1);
                } else if (uVar instanceof y) {
                    c0Var2 = new c0(((y) uVar).k(), "16", 1);
                } else {
                    c0Var = null;
                }
                c0Var = c0Var2;
            }
            v1.a(c0Var);
        }
    }

    public static void a(u uVar) {
        synchronized (a) {
            if (a.size() > 200) {
                u uVarPoll = a.poll();
                l0.b("drop event in cache", null);
                b.add(uVarPoll);
            }
            a.add(uVar);
        }
    }
}
