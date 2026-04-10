package com.anythink.core.common.res.image;

import com.anythink.core.common.b.n;
import com.anythink.core.common.k.f;
import com.anythink.core.common.res.d;
import com.anythink.core.common.res.e;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {
    e a;
    InterfaceC0171a b;

    /* JADX INFO: renamed from: com.anythink.core.common.res.image.a$a, reason: collision with other inner class name */
    public interface InterfaceC0171a {
        void a(e eVar);

        void a(e eVar, String str);
    }

    public a(e eVar) {
        super(eVar.f7927f);
        this.a = eVar;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    public final void a(InterfaceC0171a interfaceC0171a) {
        this.b = interfaceC0171a;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        InterfaceC0171a interfaceC0171a = this.b;
        if (interfaceC0171a != null) {
            interfaceC0171a.a(this.a);
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        d dVarA = d.a(n.a().g());
        e eVar = this.a;
        return dVarA.a(eVar.f7926e, f.a(eVar.f7927f), inputStream);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(com.anythink.core.common.k.b.b bVar) {
        com.anythink.core.common.k.b.a.a().a(bVar, 5);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str, String str2) {
        InterfaceC0171a interfaceC0171a = this.b;
        if (interfaceC0171a != null) {
            interfaceC0171a.a(this.a, str2);
        }
    }
}
