package com.anythink.basead.a.b;

import android.text.TextUtils;
import com.anythink.core.common.e.i;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class e extends com.anythink.core.common.res.image.b {
    private String a;
    private boolean b;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f5797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f5798k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f5799l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private i f5800m;

    public e(String str, boolean z2, i iVar, String str2) {
        super(str2);
        this.f5800m = iVar;
        this.a = str;
        this.b = z2;
        this.f5797j = TextUtils.equals(iVar.x(), str2);
        this.f5798k = iVar.p();
        this.f5799l = iVar.d();
    }

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        com.anythink.basead.a.f.a();
        return com.anythink.basead.a.f.a(this.f7928c, inputStream);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        if (this.f5797j) {
            com.anythink.basead.a.b.a(30, this.f5800m, new com.anythink.basead.c.i("", ""));
            com.anythink.core.common.j.c.a(this.a, this.f5798k, this.f7928c, "1", this.f7934i, (String) null, this.f7930e, this.f7932g, this.f5799l, this.f7933h - this.f7931f);
        }
        d.a().a(this.f7928c, 100);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(com.anythink.core.common.k.b.b bVar) {
        if (this.b) {
            com.anythink.core.common.k.b.a.a().a(bVar, 6);
        } else {
            com.anythink.core.common.k.b.a.a().a(bVar, 5);
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str, String str2) {
        if (this.f5797j) {
            com.anythink.core.common.j.c.a(this.a, this.f5798k, this.f7928c, "0", this.f7934i, str2, this.f7930e, 0L, this.f5799l, this.f7933h - this.f7931f);
        }
        d.a().a(this.f7928c, com.anythink.basead.c.f.a(str, str2));
    }
}
