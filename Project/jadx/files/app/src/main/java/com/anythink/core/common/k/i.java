package com.anythink.core.common.k;

import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.common.e.ai;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    protected static i a = new i();

    public static ATBaseAdAdapter a(String str) throws NoSuchMethodException {
        if (str == null) {
            return null;
        }
        Constructor declaredConstructor = Class.forName(str).asSubclass(ATBaseAdAdapter.class).getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (ATBaseAdAdapter) declaredConstructor.newInstance(new Object[0]);
    }

    private static ATBaseAdAdapter a(Class<? extends com.anythink.core.common.b.d> cls) throws NoSuchMethodException {
        Constructor<? extends com.anythink.core.common.b.d> declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return (ATBaseAdAdapter) declaredConstructor.newInstance(new Object[0]);
    }

    public static ATBaseAdAdapter a(ai aiVar) {
        try {
            return a(aiVar.h());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
