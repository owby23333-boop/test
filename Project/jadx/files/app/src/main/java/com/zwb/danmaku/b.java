package com.zwb.danmaku;

import com.zwb.danmaku.model.BaseDanmaku;

/* JADX INFO: compiled from: IDanmakuView.java */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: IDanmakuView.java */
    public interface a {
        boolean a(float f2, float f3);

        boolean a(b bVar);

        boolean a(BaseDanmaku baseDanmaku);

        boolean b(float f2, float f3);

        boolean b(b bVar);

        boolean b(BaseDanmaku baseDanmaku);
    }

    BaseDanmaku a(float f2, float f3);

    a getOnDanmakuClickListener();
}
