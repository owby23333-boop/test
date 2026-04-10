package com.yuewen;

import com.duokan.dkcategory.data.secondary.SerializeStatus;
import com.duokan.dkcategory.data.secondary.SortType;
import com.duokan.dkcategory.data.secondary.WordRange;
import com.duokan.dkcategory_export.data.CategoryChannel;

/* JADX INFO: loaded from: classes13.dex */
public class jy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SortType f13279b = SortType.HOTTEST;
    public WordRange c;
    public SerializeStatus d;
    public CategoryChannel e;
    public Integer f;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13280a;

        static {
            int[] iArr = new int[CategoryChannel.values().length];
            f13280a = iArr;
            try {
                iArr[CategoryChannel.FICTION_FREE_MALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13280a[CategoryChannel.FICTION_FREE_FEMALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13280a[CategoryChannel.FICTION_PAID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13280a[CategoryChannel.BOOK_PUB.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13280a[CategoryChannel.BOOK_AUDIO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13280a[CategoryChannel.BOOK_MAGAZINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String a() {
        return this.f13278a;
    }

    public CategoryChannel b() {
        return this.e;
    }

    public Integer c() {
        return this.f;
    }

    public SerializeStatus d() {
        return this.d;
    }

    public SortType e() {
        return this.f13279b;
    }

    public WordRange f() {
        return this.c;
    }

    public void g(String categoryId) {
        this.f13278a = categoryId;
    }

    public void h(CategoryChannel channel) {
        this.e = channel;
        switch (a.f13280a[channel.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.c = WordRange.ALL;
                this.d = SerializeStatus.ALL;
                break;
            case 4:
            case 5:
            case 6:
                this.c = null;
                this.d = null;
                break;
        }
    }

    public void i(Integer primaryType) {
        this.f = primaryType;
    }

    public void j(SerializeStatus serializeStatus) {
        this.d = serializeStatus;
    }

    public void k(SortType sortType) {
        this.f13279b = sortType;
    }

    public void l(WordRange wordRange) {
        this.c = wordRange;
    }
}
