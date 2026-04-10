package com.zwb.danmaku.model;

import com.zwb.danmaku.model.BaseDanmaku;

/* JADX INFO: compiled from: B2TDanmaku.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends BaseDanmaku {
    @Override // com.zwb.danmaku.model.BaseDanmaku
    public void G() {
        if (s() != BaseDanmaku.ShowState.STATE_GONE) {
            j(o() - t());
        }
    }

    @Override // com.zwb.danmaku.model.BaseDanmaku
    public void a(int i2, int i3) {
        if (o() + f() <= 0.0f || n() + A() <= 0.0f || n() >= i2) {
            a(BaseDanmaku.ShowState.STATE_GONE);
        } else if (o() >= i3) {
            a(BaseDanmaku.ShowState.STATE_NEVER_SHOWED);
        } else {
            a(BaseDanmaku.ShowState.STATE_SHOWING);
        }
    }

    @Override // com.zwb.danmaku.model.BaseDanmaku
    public BaseDanmaku.DanmakuType getType() {
        return BaseDanmaku.DanmakuType.TYPE_SCROLL_BT;
    }
}
