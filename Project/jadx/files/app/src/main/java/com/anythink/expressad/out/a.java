package com.anythink.expressad.out;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    protected Map<String, Object> a;
    protected Context b;

    public a() {
    }

    public abstract boolean a();

    public abstract void b();

    private a(Map<String, Object> map, Context context) {
        this.a = map;
        this.b = context;
    }
}
