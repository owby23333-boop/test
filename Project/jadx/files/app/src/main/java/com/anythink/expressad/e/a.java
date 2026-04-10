package com.anythink.expressad.e;

import android.content.Context;
import com.anythink.expressad.foundation.g.f.m;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.anythink.expressad.b {
    public static Map<String, String> a;
    private Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8438c = false;

    private void a() {
        this.f8438c = false;
        try {
            m.a(this.b);
            com.anythink.expressad.foundation.b.b.a().a(a, this.b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.b
    public final void a(Map<String, String> map, Context context) {
        this.b = context.getApplicationContext();
        a = map;
        this.f8438c = false;
        try {
            m.a(this.b);
            com.anythink.expressad.foundation.b.b.a().a(a, this.b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
