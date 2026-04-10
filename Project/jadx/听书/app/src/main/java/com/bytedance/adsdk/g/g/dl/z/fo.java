package com.bytedance.adsdk.g.g.dl.z;

import java.util.Deque;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends m {
    @Override // com.bytedance.adsdk.g.g.dl.z.m
    public int z(String str, int i, Deque<com.bytedance.adsdk.g.g.g.z> deque, com.bytedance.adsdk.g.g.dl.z zVar) {
        com.bytedance.adsdk.g.g.g.z zVarPollFirst;
        if (')' != z(i, str)) {
            return zVar.z(str, i, deque);
        }
        LinkedList<com.bytedance.adsdk.g.g.g.z> linkedList = new LinkedList();
        while (true) {
            zVarPollFirst = deque.pollFirst();
            if (zVarPollFirst == null || zVarPollFirst.z() == com.bytedance.adsdk.g.g.a.g.METHOD || zVarPollFirst.z() == com.bytedance.adsdk.g.g.a.a.LEFT_PAREN) {
                break;
            }
            linkedList.addFirst(zVarPollFirst);
        }
        if (zVarPollFirst == null) {
            throw new IllegalArgumentException(str.substring(0, i));
        }
        if (zVarPollFirst.z() != com.bytedance.adsdk.g.g.a.g.METHOD) {
            deque.push(com.bytedance.adsdk.g.g.gc.g.z(linkedList, str, i));
            return i + 1;
        }
        com.bytedance.adsdk.g.g.g.z.uy uyVar = (com.bytedance.adsdk.g.g.g.z.uy) zVarPollFirst;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (com.bytedance.adsdk.g.g.g.z zVar2 : linkedList) {
            if (zVar2.z() == com.bytedance.adsdk.g.g.a.a.COMMA) {
                linkedList2.add(com.bytedance.adsdk.g.g.gc.g.z(linkedList3, str, i));
                linkedList3.clear();
            } else {
                linkedList3.addLast(zVar2);
            }
        }
        if (!linkedList3.isEmpty()) {
            linkedList2.add(com.bytedance.adsdk.g.g.gc.g.z(linkedList3, str, i));
        }
        uyVar.z((com.bytedance.adsdk.g.g.g.z[]) linkedList2.toArray(new com.bytedance.adsdk.g.g.g.z[linkedList2.size()]));
        int i2 = i + 1;
        deque.push(uyVar);
        return i2;
    }
}
