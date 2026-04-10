package com.bytedance.sdk.component.adexpress.dynamic.tg;

import com.bytedance.sdk.component.adexpress.dynamic.tg.bf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {
    public static float e(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<bf.e> e(float f, List<bf.e> list) {
        ArrayList<bf.e> arrayList = new ArrayList();
        Iterator<bf.e> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((bf.e) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (bf.e eVar : arrayList) {
            if (eVar.bf) {
                i = (int) (i + eVar.e);
            } else {
                i2 = (int) (i2 + eVar.e);
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
            for (bf.e eVar2 : arrayList) {
                if (!eVar2.bf) {
                    float f5 = eVar2.d;
                    if (f5 != 0.0f && eVar2.e * f4 > f5) {
                        eVar2.e = f5;
                        eVar2.bf = true;
                        z2 = true;
                    }
                }
                arrayList2.add(eVar2);
            }
            if (z2) {
                return e(f, arrayList2);
            }
        }
        int i3 = 0;
        for (bf.e eVar3 : arrayList) {
            if (eVar3.bf) {
                eVar3.e = e(eVar3.e * f3);
            } else {
                eVar3.e = e(eVar3.e * f4);
            }
            i3 = (int) (i3 + eVar3.e);
        }
        float f6 = i3;
        if (f6 < f) {
            float f7 = f - f6;
            for (int size = 0; size < arrayList.size() && f7 > 0.0f; size = (size + 1) % arrayList.size()) {
                bf.e eVar4 = (bf.e) arrayList.get(size);
                if ((f < f2 && eVar4.bf) || (f > f2 && !eVar4.bf)) {
                    eVar4.e += 0.0625f;
                    f7 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
