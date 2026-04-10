package com.anythink.core.common.k;

import com.anythink.core.common.e.ai;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class t {
    public static boolean a(List<ai> list) {
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ai aiVar = list.get(i2);
                if (aiVar != null && aiVar.aa()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean b(ai aiVar) {
        if (aiVar == null) {
            return false;
        }
        return aiVar.c() == 66 || aiVar.c() == 6;
    }

    public static boolean a(ai aiVar) {
        return aiVar.c() == 15 && !aiVar.j();
    }

    public static boolean a(String str, ai aiVar) {
        if (aiVar == null) {
            return false;
        }
        if (com.anythink.core.common.a.a().a(str, aiVar) != null) {
            return true;
        }
        com.anythink.core.common.e.m mVarA = com.anythink.core.b.f.a().a(aiVar);
        return (mVarA == null || mVarA.a()) ? false : true;
    }
}
