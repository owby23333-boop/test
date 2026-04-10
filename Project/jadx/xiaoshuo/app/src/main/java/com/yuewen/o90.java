package com.yuewen;

import com.duokan.reader.ui.store.data.FeedItem;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface o90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o90 f15232a = new a();

    public class a implements o90 {
        @Override // com.yuewen.o90
        public void a() {
        }

        @Override // com.yuewen.o90
        public List<FeedItem> b(List<FeedItem> list) {
            return list;
        }

        @Override // com.yuewen.o90
        public List<String> c() {
            return Collections.EMPTY_LIST;
        }
    }

    void a();

    List<FeedItem> b(List<FeedItem> list);

    List<String> c();
}
