package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_this102;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static c a(c cVar, String str) {
        c cVarA = null;
        if (cVar != null && !TextUtils.isEmpty(str) && cVar.B() != null && cVar.B().size() != 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<j> it = cVar.B().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j next = it.next();
                if (str.equals(next.d())) {
                    arrayList.add(next.b());
                    break;
                }
            }
            if (arrayList.size() != 0) {
                j jVar = arrayList.get(0);
                if (jVar != null && jVar.G() && !"pangle".equals(jVar.e())) {
                    Iterator<j> it2 = cVar.B().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        j next2 = it2.next();
                        if (next2.G() && "pangle".equals(next2.e())) {
                            arrayList.add(next2.b());
                            break;
                        }
                    }
                }
                cVarA = cVar.a();
                if (cVarA.J()) {
                    cVarA.a(arrayList);
                } else {
                    cVarA.b(arrayList);
                }
                j jVar2 = arrayList.get(0);
                jVar2.f(0);
                if (jVar2.f() == 0) {
                    cVarA.b(jVar2.i());
                }
                if (jVar2.f() == 2) {
                    cVarA.b(true);
                }
                if (jVar2.f() == 1 || jVar2.f() == 3) {
                    cVarA.a(true);
                }
                cVarA.h(0);
            }
        }
        return cVarA;
    }

    public static String a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("gm_test_slot_")) {
                return str.substring(13);
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
