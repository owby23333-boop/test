package com.yuewen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import androidx.annotation.NonNull;
import com.duokan.advertisement.bookshelf.BookShelfAdFactory;
import com.duokan.reader.domain.bookshelf.BookshelfItem;

/* JADX INFO: loaded from: classes13.dex */
public class er extends BookshelfItem {
    public View r;
    public w6 s;

    public static class a implements fr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BookShelfAdFactory f10714a;

        public a(Context context, @NonNull BookShelfAdFactory bookShelfAdFactory) {
            this.f10714a = bookShelfAdFactory;
        }

        @Override // com.yuewen.fr
        public er a(boolean z, int i) {
            View viewC = z ? i == 6 ? this.f10714a.c() : this.f10714a.b() : this.f10714a.d();
            if (viewC == null) {
                return null;
            }
            return new er(viewC);
        }
    }

    public er(View view) {
        super(null, -1L, true, false);
        this.r = null;
        if (view != null) {
            this.r = view;
            if (view.getTag() instanceof w6) {
                this.s = (w6) view.getTag();
            }
        }
    }

    @Override // com.duokan.reader.domain.bookshelf.BookshelfItem
    public String E() {
        return null;
    }

    @Override // com.duokan.reader.domain.bookshelf.BookshelfItem
    public long F() {
        return 0L;
    }

    @Override // com.duokan.reader.domain.bookshelf.BookshelfItem
    public void L(Cursor cursor) throws Exception {
    }

    @Override // com.duokan.reader.domain.bookshelf.BookshelfItem
    public boolean M() {
        return false;
    }

    @Override // com.duokan.reader.domain.bookshelf.BookshelfItem
    public boolean N() {
        return false;
    }

    @Override // com.duokan.reader.domain.bookshelf.BookshelfItem
    public boolean O() {
        return false;
    }

    @Override // com.duokan.reader.domain.bookshelf.BookshelfItem
    public String a() {
        return null;
    }

    @Override // com.duokan.reader.domain.bookshelf.BookshelfItem
    public void b0(String str) {
    }

    @Override // com.duokan.reader.domain.bookshelf.BookshelfItem
    public void c0(ContentValues contentValues) throws Exception {
    }

    public View d0() {
        return this.r;
    }

    public boolean e0() {
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof er)) {
            return false;
        }
        w6 w6Var = this.s;
        return w6Var == null ? super.equals(obj) : w6Var.equals(((er) obj).s);
    }

    public int hashCode() {
        w6 w6Var = this.s;
        return w6Var == null ? super.hashCode() : w6Var.hashCode();
    }
}
