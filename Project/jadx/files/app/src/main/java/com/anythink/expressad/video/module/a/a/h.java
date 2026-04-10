package com.anythink.expressad.video.module.a.a;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends k {
    public h(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.b.c cVar2, com.anythink.expressad.videocommon.c.c cVar3, String str, String str2, com.anythink.expressad.video.module.a.a aVar, int i2, boolean z2) {
        super(cVar, cVar2, cVar3, str, str2, aVar, i2, z2);
    }

    @Override // com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public final void a(int i2, Object obj) {
        if (i2 == 100) {
            e();
            d();
            c();
            a(2);
        } else if (i2 == 109) {
            b(2);
        } else if (i2 == 122) {
            a();
        } else if (i2 != 129) {
            String str = "";
            if (i2 == 118) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(3, str);
            } else if (i2 == 119) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(4, str);
            }
        } else {
            com.anythink.expressad.foundation.d.c cVar = this.X;
            if (cVar != null && cVar.J() == 2) {
                e();
                d();
                c();
                a(1);
            }
        }
        super.a(i2, obj);
    }
}
