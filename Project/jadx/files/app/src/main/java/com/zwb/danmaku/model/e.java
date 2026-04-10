package com.zwb.danmaku.model;

import com.zwb.danmaku.model.BaseDanmaku;

/* JADX INFO: compiled from: R2LDanmaku.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends BaseDanmaku {
    @Override // com.zwb.danmaku.model.BaseDanmaku
    public void G() {
        if (s() != BaseDanmaku.ShowState.STATE_GONE) {
            i(n() - t());
        }
    }

    @Override // com.zwb.danmaku.model.BaseDanmaku
    public void a(int i2, int i3) {
        if (n() + A() <= 0.0f || o() + f() <= 0.0f || o() >= i3) {
            a(BaseDanmaku.ShowState.STATE_GONE);
        } else if (n() >= i2) {
            a(BaseDanmaku.ShowState.STATE_NEVER_SHOWED);
        } else {
            a(BaseDanmaku.ShowState.STATE_SHOWING);
        }
    }

    @Override // com.zwb.danmaku.model.BaseDanmaku
    public BaseDanmaku.DanmakuType getType() {
        return BaseDanmaku.DanmakuType.TYPE_SCROLL_RL;
    }
}
