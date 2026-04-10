package com.yuewen;

import com.duokan.reader.domain.document.PageAnchor;
import com.duokan.reader.ui.reading.PageAnimationMode;
import com.duokan.reader.ui.reading.ReadingTheme;

/* JADX INFO: loaded from: classes12.dex */
public interface gi1 extends w01 {
    PageAnimationMode A();

    void L(PageAnchor pageAnchor);

    default void L6(boolean z) {
    }

    void M0(boolean z);

    ef2 N0();

    default ji1 V9() {
        return null;
    }

    default void W7(String str) {
    }

    void X8(String str);

    void c1(Runnable runnable, Runnable runnable2);

    boolean d1();

    boolean e();

    boolean g1();

    PageAnchor getCurrentPageAnchor();

    as0 getDocument();

    ReadingTheme i();

    int i1();

    void i4(boolean z);

    boolean l();

    void l1();

    void o();

    default long o2() {
        return 0L;
    }

    boolean r0(int i);

    int r1();

    void u0();

    com.duokan.reader.domain.bookshelf.b v();
}
