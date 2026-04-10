package com.yuewen;

import android.text.TextUtils;
import com.duokan.dkcategory_export.data.CategoryChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class py {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16329b = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<CategoryChannel> f16330a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final py f16331a = new py();
    }

    public static py d() {
        return a.f16331a;
    }

    public CategoryChannel a(String str) {
        for (CategoryChannel categoryChannel : this.f16330a) {
            if (TextUtils.equals(categoryChannel.getChannelId(), str)) {
                return categoryChannel;
            }
        }
        return null;
    }

    public CategoryChannel b(String str) {
        for (CategoryChannel categoryChannel : this.f16330a) {
            if (TextUtils.equals(categoryChannel.getPage(), str)) {
                return categoryChannel;
            }
        }
        return null;
    }

    public List<CategoryChannel> c() {
        ArrayList arrayList = new ArrayList(this.f16330a.size());
        for (CategoryChannel categoryChannel : this.f16330a) {
            if (categoryChannel != CategoryChannel.BOOK_MAGAZINE) {
                arrayList.add(categoryChannel);
            }
        }
        return arrayList;
    }

    public List<CategoryChannel> e() {
        return this.f16330a;
    }

    public py() {
        this.f16330a = Arrays.asList(CategoryChannel.FICTION_FREE_MALE, CategoryChannel.FICTION_FREE_FEMALE, CategoryChannel.FICTION_PAID, CategoryChannel.BOOK_PUB, CategoryChannel.BOOK_MAGAZINE, CategoryChannel.BOOK_AUDIO);
    }
}
