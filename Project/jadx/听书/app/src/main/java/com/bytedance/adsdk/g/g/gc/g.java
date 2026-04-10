package com.bytedance.adsdk.g.g.gc;

import com.bytedance.adsdk.g.g.a.a;
import com.bytedance.adsdk.g.g.a.dl;
import com.bytedance.adsdk.g.g.g.z.fo;
import com.bytedance.adsdk.g.g.g.z.fv;
import com.bytedance.adsdk.g.g.g.z.gc;
import com.bytedance.adsdk.g.g.g.z.gz;
import com.bytedance.adsdk.g.g.g.z.i;
import com.bytedance.adsdk.g.g.g.z.js;
import com.bytedance.adsdk.g.g.g.z.kb;
import com.bytedance.adsdk.g.g.g.z.m;
import com.bytedance.adsdk.g.g.g.z.p;
import com.bytedance.adsdk.g.g.g.z.v;
import com.bytedance.adsdk.g.g.g.z.wp;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static com.bytedance.adsdk.g.g.g.z z(List<com.bytedance.adsdk.g.g.g.z> list, String str, int i) {
        dl(list, str, i);
        Deque<com.bytedance.adsdk.g.g.g.z> dequeZ = z(g(list, str, i));
        if (dequeZ.size() != 1) {
            throw new IllegalStateException();
        }
        return dequeZ.getFirst();
    }

    private static Deque<com.bytedance.adsdk.g.g.g.z> z(Deque<com.bytedance.adsdk.g.g.g.z> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.adsdk.g.g.g.z zVar : deque) {
            if (!linkedList.isEmpty() && ((com.bytedance.adsdk.g.g.g.z) linkedList.peekLast()).z() == dl.COLON) {
                linkedList.pollLast();
                com.bytedance.adsdk.g.g.g.z zVar2 = (com.bytedance.adsdk.g.g.g.z) linkedList.pollLast();
                if (((com.bytedance.adsdk.g.g.g.z) linkedList.pollLast()).z() != dl.QUESTION) {
                    throw new IllegalStateException();
                }
                com.bytedance.adsdk.g.g.g.z zVar3 = (com.bytedance.adsdk.g.g.g.z) linkedList.pollLast();
                js jsVar = new js();
                jsVar.z(zVar3);
                jsVar.g(zVar2);
                jsVar.dl(zVar);
                linkedList.addLast(jsVar);
            } else {
                linkedList.addLast(zVar);
            }
        }
        return linkedList;
    }

    private static Deque<com.bytedance.adsdk.g.g.g.z> g(List<com.bytedance.adsdk.g.g.g.z> list, String str, int i) {
        LinkedList<com.bytedance.adsdk.g.g.g.z> linkedList = new LinkedList(list);
        int i2 = 5;
        while (i2 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.bytedance.adsdk.g.g.g.z zVar : linkedList) {
                if (!linkedList2.isEmpty() && dl.z(((com.bytedance.adsdk.g.g.g.z) linkedList2.peekLast()).z()) && ((dl) ((com.bytedance.adsdk.g.g.g.z) linkedList2.peekLast()).z()).g() == i2) {
                    com.bytedance.adsdk.g.g.g.z zVar2 = (com.bytedance.adsdk.g.g.g.z) linkedList2.pollLast();
                    com.bytedance.adsdk.g.g.g.z zVar3 = (com.bytedance.adsdk.g.g.g.z) linkedList2.pollLast();
                    if (!dl.z(zVar3.z()) && !dl.z(zVar.z())) {
                        linkedList2.addLast(z(zVar3, zVar2, zVar));
                    } else {
                        throw new IllegalArgumentException(str.substring(0, i));
                    }
                } else {
                    linkedList2.addLast(zVar);
                }
            }
            i2--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static void dl(List<com.bytedance.adsdk.g.g.g.z> list, String str, int i) {
        Iterator<com.bytedance.adsdk.g.g.g.z> it = list.iterator();
        while (it.hasNext()) {
            if (a.z(it.next().z())) {
                throw new IllegalArgumentException(str.substring(0, i));
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.g.g.gc.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[dl.values().length];
            z = iArr;
            try {
                iArr[dl.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[dl.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[dl.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                z[dl.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                z[dl.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                z[dl.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                z[dl.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                z[dl.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                z[dl.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                z[dl.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                z[dl.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                z[dl.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                z[dl.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static com.bytedance.adsdk.g.g.g.z z(com.bytedance.adsdk.g.g.g.z zVar, com.bytedance.adsdk.g.g.g.z zVar2, com.bytedance.adsdk.g.g.g.z zVar3) {
        p kbVar;
        switch (AnonymousClass1.z[((dl) zVar2.z()).ordinal()]) {
            case 1:
                kbVar = new kb();
                break;
            case 2:
                kbVar = new fv();
                break;
            case 3:
                kbVar = new com.bytedance.adsdk.g.g.g.z.z();
                break;
            case 4:
                kbVar = new i();
                break;
            case 5:
                kbVar = new wp();
                break;
            case 6:
                kbVar = new com.bytedance.adsdk.g.g.g.z.a();
                break;
            case 7:
                kbVar = new v();
                break;
            case 8:
                kbVar = new m();
                break;
            case 9:
                kbVar = new fo();
                break;
            case 10:
                kbVar = new gc();
                break;
            case 11:
                kbVar = new gz();
                break;
            case 12:
                kbVar = new com.bytedance.adsdk.g.g.g.z.g();
                break;
            case 13:
                kbVar = new com.bytedance.adsdk.g.g.g.z.dl();
                break;
            default:
                throw new UnsupportedOperationException(zVar2.z().toString());
        }
        kbVar.z(zVar);
        kbVar.g(zVar3);
        return kbVar;
    }

    public static boolean z(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }
}
