package com.bytedance.sdk.component.adexpress.dynamic.a;

import com.bytedance.sdk.component.adexpress.dynamic.a.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    public static float z(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<g.z> z(float f, List<g.z> list) {
        ArrayList<g.z> arrayList = new ArrayList();
        Iterator<g.z> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((g.z) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (g.z zVar : arrayList) {
            if (zVar.g) {
                i = (int) (i + zVar.z);
            } else {
                i2 = (int) (i2 + zVar.z);
                z = false;
            }
        }
        if (z && f > i) {
            return arrayList;
        }
        float f2 = i;
        float f3 = f < f2 ? f / f2 : 1.0f;
        float f4 = f > f2 ? (f - f2) / i2 : 0.0f;
        if (f4 > 1.0f) {
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (g.z zVar2 : arrayList) {
                if (!zVar2.g && zVar2.dl != 0.0f && zVar2.z * f4 > zVar2.dl) {
                    zVar2.z = zVar2.dl;
                    zVar2.g = true;
                    z2 = true;
                }
                arrayList2.add(zVar2);
            }
            if (z2) {
                return z(f, arrayList2);
            }
        }
        int i3 = 0;
        for (g.z zVar3 : arrayList) {
            if (zVar3.g) {
                zVar3.z = z(zVar3.z * f3);
            } else {
                zVar3.z = z(zVar3.z * f4);
            }
            i3 = (int) (i3 + zVar3.z);
        }
        float f5 = i3;
        if (f5 < f) {
            float f6 = f - f5;
            for (int size = 0; size < arrayList.size() && f6 > 0.0f; size = (size + 1) % arrayList.size()) {
                g.z zVar4 = (g.z) arrayList.get(size);
                if ((f < f2 && zVar4.g) || (f > f2 && !zVar4.g)) {
                    zVar4.z += 0.0625f;
                    f6 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
