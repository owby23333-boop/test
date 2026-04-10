package com.zwb.danmaku.c;

import com.zwb.danmaku.model.BaseDanmaku;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: L2RHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends b {
    @Override // com.zwb.danmaku.c.b
    protected void a(BaseDanmaku baseDanmaku, com.zwb.danmaku.model.h hVar, int i2, int i3) {
        baseDanmaku.j(hVar.h()).d(hVar.h());
        if (hVar.d() > 0.0f) {
            baseDanmaku.i((-baseDanmaku.i()) - baseDanmaku.A()).c((-baseDanmaku.i()) - baseDanmaku.A());
        } else {
            baseDanmaku.i((hVar.d() - baseDanmaku.i()) - baseDanmaku.A()).c((hVar.d() - baseDanmaku.i()) - baseDanmaku.A());
        }
    }

    @Override // com.zwb.danmaku.c.b
    protected com.zwb.danmaku.model.h b() {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f20632i.size()) {
                i2 = -1;
                break;
            }
            if (this.f20632i.get(i2).g().isEmpty()) {
                break;
            }
            i2++;
        }
        if (i2 == -1) {
            return null;
        }
        com.zwb.danmaku.model.h hVar = this.f20632i.get(i2);
        a(hVar);
        if (hVar.h() > 0.0f || i2 == 0) {
            return hVar;
        }
        hVar.c(a(i2 - 1)[3] + this.f20628e);
        return hVar;
    }

    @Override // com.zwb.danmaku.c.b
    protected com.zwb.danmaku.model.h a(float[] fArr) {
        float f2 = fArr[3];
        if (this.f20628e + f2 > this.b) {
            return null;
        }
        com.zwb.danmaku.model.h hVar = new com.zwb.danmaku.model.h();
        hVar.a(((-this.f20632i.size()) % 3) * this.f20627d * new Random().nextInt(100));
        hVar.c(f2 + (this.f20632i.isEmpty() ? 0.0f : this.f20628e));
        hVar.a(this.f20632i.size());
        this.f20632i.add(hVar);
        return hVar;
    }

    @Override // com.zwb.danmaku.c.b
    protected com.zwb.danmaku.model.h a(List<com.zwb.danmaku.model.h> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        com.zwb.danmaku.model.h hVar = list.get(0);
        a(hVar);
        if (hVar.d() == 0.0f && hVar.f() == 0.0f) {
            return hVar;
        }
        float fD = hVar.d();
        int i2 = 1;
        int i3 = 0;
        while (true) {
            if (i2 >= list.size()) {
                i2 = i3;
                break;
            }
            com.zwb.danmaku.model.h hVar2 = list.get(i2);
            a(hVar2);
            if (hVar2.d() == 0.0f && hVar2.f() == 0.0f) {
                break;
            }
            if (fD < hVar2.d()) {
                fD = hVar2.d();
                i3 = i2;
            }
            i2++;
        }
        com.zwb.danmaku.model.h hVar3 = list.get(i2);
        if (hVar3.h() <= 0.0f && i2 != 0) {
            hVar3.c(a(i2 - 1)[3] + this.f20628e);
        }
        return hVar3;
    }
}
