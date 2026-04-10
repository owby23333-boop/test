package com.bytedance.embedapplog;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static final LinkedList<sd> z = new LinkedList<>();
    private static final LinkedList<sd> g = new LinkedList<>();

    public static void z(sd sdVar) {
        LinkedList<sd> linkedList = z;
        synchronized (linkedList) {
            if (linkedList.size() > 200) {
                sd sdVarPoll = linkedList.poll();
                cb.g("drop event in cache", null);
                g.add(sdVarPoll);
            }
            linkedList.add(sdVar);
        }
    }

    public static void z() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList<sd> linkedList3 = z;
        synchronized (linkedList3) {
            linkedList.addAll(linkedList3);
            LinkedList<sd> linkedList4 = g;
            linkedList2.addAll(linkedList4);
            linkedList3.clear();
            linkedList4.clear();
        }
        while (!linkedList.isEmpty()) {
            ti.z((sd) linkedList.poll());
        }
    }
}
