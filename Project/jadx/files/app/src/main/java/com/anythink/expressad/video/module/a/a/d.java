package com.anythink.expressad.video.module.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class d extends k {
    public d(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.b.c cVar2, com.anythink.expressad.videocommon.c.c cVar3, String str, String str2, com.anythink.expressad.video.module.a.a aVar, int i2, boolean z2) {
        super(cVar, cVar2, cVar3, str, str2, aVar, i2, z2);
    }

    @Override // com.anythink.expressad.video.module.a.a.k, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public void a(int i2, Object obj) {
        super.a(i2, obj);
        if (!this.W || i2 == 100 || i2 == 101 || i2 == 103 || i2 == 113) {
            return;
        }
        if (i2 == 122) {
            a();
            return;
        }
        switch (i2) {
            case 105:
            case 106:
                break;
            case 107:
                break;
            default:
                switch (i2) {
                    case 109:
                        b(2);
                        a(2);
                        break;
                    case 110:
                        com.anythink.expressad.foundation.d.c cVar = this.X;
                        if (cVar != null && cVar.k() == 5) {
                            a(obj.toString());
                        }
                        b(1);
                        a(1);
                        break;
                    case 111:
                        a(1);
                        break;
                }
                break;
        }
    }
}
