package com.anythink.core.common.d;

import android.content.Context;
import com.anythink.core.common.c.j;
import com.anythink.core.common.e.x;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    j a;
    protected int b;

    protected a(Context context) {
        this.a = j.a(com.anythink.core.common.c.c.a(context));
    }

    public final void a(String str, int i2, int i3) {
        this.a.a(this.b, str, i2, i3);
    }

    public final void a(String str, long j2) {
        this.a.a(this.b, str, j2);
    }

    public final void a(String str, String str2) {
        this.a.a(str, this.b, str2);
    }

    private List<x> a() {
        return this.a.a(this.b);
    }

    public final List<x> a(List<String> list) {
        return this.a.a(list, this.b);
    }
}
