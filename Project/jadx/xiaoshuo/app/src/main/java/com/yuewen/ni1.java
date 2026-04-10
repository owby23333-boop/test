package com.yuewen;

import com.duokan.reader.domain.document.RangeAnchor;
import com.duokan.reader.domain.document.TextAnchor;

/* JADX INFO: loaded from: classes3.dex */
public interface ni1 {
    void a(Cif cif);

    void b(RangeAnchor rangeAnchor, Integer[] numArr);

    void c(jg[] jgVarArr, Integer num, long j);

    TextAnchor d();

    void e(Cif cif);

    Class f();

    boolean isPlaying();

    void pause();

    void resume();

    void stop();
}
