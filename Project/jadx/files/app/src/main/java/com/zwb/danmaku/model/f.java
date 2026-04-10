package com.zwb.danmaku.model;

import com.zwb.danmaku.model.BaseDanmaku;

/* JADX INFO: compiled from: SpecialDanmaku.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends BaseDanmaku {
    private float D;

    private void H() {
        if (this.D < e() || t() != 0.0f) {
            return;
        }
        if (e() <= 0 || d() <= 0) {
            l(a.a);
        } else {
            l((a.a * 16.6f) / d());
        }
    }

    @Override // com.zwb.danmaku.model.BaseDanmaku
    public void G() {
        if (s() != BaseDanmaku.ShowState.STATE_GONE) {
            H();
            a(a() - t());
        }
    }

    @Override // com.zwb.danmaku.model.BaseDanmaku
    public void a(int i2, int i3) {
        if (n() + A() <= 0.0f || n() >= i2 || o() + f() <= 0.0f || o() >= i3 || a() <= a.b) {
            a(BaseDanmaku.ShowState.STATE_GONE);
            this.D = 0.0f;
        } else {
            a(BaseDanmaku.ShowState.STATE_SHOWING);
            double d2 = this.D;
            Double.isNaN(d2);
            this.D = (float) (d2 + 16.6d);
        }
    }

    @Override // com.zwb.danmaku.model.BaseDanmaku
    public BaseDanmaku.DanmakuType getType() {
        return BaseDanmaku.DanmakuType.TYPE_SPECIAL;
    }
}
