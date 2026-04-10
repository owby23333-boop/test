package com.yuewen;

import android.view.View;
import android.view.ViewGroup;
import com.duokan.core.ui.Scrollable;
import com.duokan.reader.domain.bookshelf.BookShelfType;

/* JADX INFO: loaded from: classes13.dex */
public interface iq {
    default void c() {
    }

    View getView();

    void init(ViewGroup viewGroup);

    default void onBookShelfTypeUpdate(BookShelfType bookShelfType) {
    }

    default void onDeActive() {
    }

    default void onRefresh() {
    }

    default void onScroll(Scrollable scrollable) {
    }

    default void onViewEnableChanged(boolean z) {
    }
}
