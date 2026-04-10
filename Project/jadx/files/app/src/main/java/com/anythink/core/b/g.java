package com.anythink.core.b;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends e {
    public g(com.anythink.core.common.e.a aVar) {
        super(aVar);
    }

    @Override // com.anythink.core.b.e
    protected final void a(List<JSONObject> list, com.anythink.core.common.g.i iVar) {
        com.anythink.core.b.a.b bVar = new com.anythink.core.b.a.b();
        bVar.f6509f = this.f6527d.f7091n.ar();
        com.anythink.core.b.a.a aVar = new com.anythink.core.b.a.a(this.f6543n, this.f6542m, this.f6541l, list, 1);
        aVar.a(bVar);
        aVar.a(0, iVar);
    }

    @Override // com.anythink.core.b.e
    protected final String b() {
        return this.f6527d.f7093p;
    }
}
