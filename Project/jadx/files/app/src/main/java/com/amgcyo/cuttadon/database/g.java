package com.amgcyo.cuttadon.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.anythink.expressad.foundation.d.c;
import com.umeng.message.proguard.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: MkBookDao_Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements com.amgcyo.cuttadon.database.f {
    private final SharedSQLiteStatement A;
    private final SharedSQLiteStatement B;
    private final SharedSQLiteStatement C;
    private final SharedSQLiteStatement D;
    private final SharedSQLiteStatement E;
    private final SharedSQLiteStatement F;
    private final SharedSQLiteStatement G;
    private final RoomDatabase a;
    private final EntityInsertionAdapter<MkBook> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SharedSQLiteStatement f3629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SharedSQLiteStatement f3630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SharedSQLiteStatement f3631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SharedSQLiteStatement f3632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SharedSQLiteStatement f3633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SharedSQLiteStatement f3634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SharedSQLiteStatement f3635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final SharedSQLiteStatement f3636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final SharedSQLiteStatement f3637k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final SharedSQLiteStatement f3638l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SharedSQLiteStatement f3639m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final SharedSQLiteStatement f3640n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final SharedSQLiteStatement f3641o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final SharedSQLiteStatement f3642p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final SharedSQLiteStatement f3643q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final SharedSQLiteStatement f3644r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final SharedSQLiteStatement f3645s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final SharedSQLiteStatement f3646t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final SharedSQLiteStatement f3647u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final SharedSQLiteStatement f3648v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final SharedSQLiteStatement f3649w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final SharedSQLiteStatement f3650x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final SharedSQLiteStatement f3651y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final SharedSQLiteStatement f3652z;

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class a extends SharedSQLiteStatement {
        a(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set comic_source =? ,reading_site_id =? , siteName=?  where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class a0 implements Callable<MkBook> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f3653s;

        a0(RoomSQLiteQuery roomSQLiteQuery) {
            this.f3653s = roomSQLiteQuery;
        }

        protected void finalize() {
            this.f3653s.release();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public MkBook call() throws Exception {
            MkBook mkBook;
            Cursor cursorQuery = DBUtil.query(g.this.a, this.f3653s, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "refreshtime");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_crawler_book_id");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vertical_top");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_id");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_path");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "site_path_reload");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_count");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score_number");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_reload_path");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "crawl_book_id");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_status");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_today_time");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_1");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_2");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_3");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_4");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_5");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_6");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_shelf_category");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comic_source");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_1");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_2");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_3");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_4");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_5");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_6");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteName");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_fatten");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fatten_num");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_datetime");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_key");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_read_chapterName");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "read_begin");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_path");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reload_updated_at");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated");
                if (cursorQuery.moveToFirst()) {
                    MkBook mkBook2 = new MkBook();
                    mkBook2.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                    mkBook2.setBook_id(cursorQuery.getInt(columnIndexOrThrow2));
                    mkBook2.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    mkBook2.setAuthor(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    mkBook2.setForm(cursorQuery.getInt(columnIndexOrThrow5));
                    mkBook2.setImage(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    mkBook2.setLtype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    mkBook2.setStype(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    mkBook2.setStatus(cursorQuery.getInt(columnIndexOrThrow9));
                    mkBook2.setRefreshtime(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    mkBook2.setFav_count(cursorQuery.getInt(columnIndexOrThrow11));
                    mkBook2.setComment_number(cursorQuery.getInt(columnIndexOrThrow12));
                    mkBook2.setLast_chapter_name(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    mkBook2.setLast_crawler_book_id(cursorQuery.getInt(columnIndexOrThrow14));
                    mkBook2.setUpdated_at(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    mkBook2.setVertical_top(cursorQuery.getInt(columnIndexOrThrow16));
                    mkBook2.setWords_number(cursorQuery.getInt(columnIndexOrThrow17));
                    mkBook2.setList_path(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    mkBook2.setList_reload_path(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19));
                    mkBook2.setChapter_count(cursorQuery.getInt(columnIndexOrThrow20));
                    mkBook2.setReading_site_id(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21));
                    mkBook2.setReading_site_path(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    mkBook2.setSite_path_reload(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    mkBook2.setScore(cursorQuery.isNull(columnIndexOrThrow24) ? null : cursorQuery.getString(columnIndexOrThrow24));
                    mkBook2.setView_count(cursorQuery.getInt(columnIndexOrThrow25));
                    mkBook2.setScore_number(cursorQuery.getInt(columnIndexOrThrow26));
                    mkBook2.setReading_site_reload_path(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    mkBook2.setCrawl_book_id(cursorQuery.getInt(columnIndexOrThrow28));
                    mkBook2.setJpush_status(cursorQuery.getInt(columnIndexOrThrow29));
                    mkBook2.setJpush_today_time(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    mkBook2.setBg_color(cursorQuery.getInt(columnIndexOrThrow31));
                    mkBook2.setBook_int_filed_1(cursorQuery.getInt(columnIndexOrThrow32));
                    mkBook2.setBook_int_filed_2(cursorQuery.getInt(columnIndexOrThrow33));
                    mkBook2.setBook_int_filed_3(cursorQuery.getInt(columnIndexOrThrow34));
                    mkBook2.setBook_int_filed_4(cursorQuery.getInt(columnIndexOrThrow35));
                    mkBook2.setBook_int_filed_5(cursorQuery.getInt(columnIndexOrThrow36));
                    mkBook2.setBook_int_filed_6(cursorQuery.getInt(columnIndexOrThrow37));
                    mkBook2.setBook_shelf_category(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getString(columnIndexOrThrow38));
                    mkBook2.setComic_source(cursorQuery.isNull(columnIndexOrThrow39) ? null : cursorQuery.getString(columnIndexOrThrow39));
                    mkBook2.setBook_text_filed_1(cursorQuery.isNull(columnIndexOrThrow40) ? null : cursorQuery.getString(columnIndexOrThrow40));
                    mkBook2.setBook_text_filed_2(cursorQuery.isNull(columnIndexOrThrow41) ? null : cursorQuery.getString(columnIndexOrThrow41));
                    mkBook2.setBook_text_filed_3(cursorQuery.isNull(columnIndexOrThrow42) ? null : cursorQuery.getString(columnIndexOrThrow42));
                    mkBook2.setBook_text_filed_4(cursorQuery.isNull(columnIndexOrThrow43) ? null : cursorQuery.getString(columnIndexOrThrow43));
                    mkBook2.setBook_text_filed_5(cursorQuery.isNull(columnIndexOrThrow44) ? null : cursorQuery.getString(columnIndexOrThrow44));
                    mkBook2.setBook_text_filed_6(cursorQuery.isNull(columnIndexOrThrow45) ? null : cursorQuery.getString(columnIndexOrThrow45));
                    mkBook2.setSiteName(cursorQuery.isNull(columnIndexOrThrow46) ? null : cursorQuery.getString(columnIndexOrThrow46));
                    mkBook2.setIs_top(cursorQuery.getInt(columnIndexOrThrow47));
                    mkBook2.setIs_fatten(cursorQuery.getInt(columnIndexOrThrow48));
                    mkBook2.setFatten_num(cursorQuery.getInt(columnIndexOrThrow49));
                    mkBook2.setReading_datetime(cursorQuery.getLong(columnIndexOrThrow50));
                    mkBook2.setReading_chapter_key(cursorQuery.getInt(columnIndexOrThrow51));
                    mkBook2.setLast_read_chapterName(cursorQuery.isNull(columnIndexOrThrow52) ? null : cursorQuery.getString(columnIndexOrThrow52));
                    mkBook2.setRead_begin(cursorQuery.getInt(columnIndexOrThrow53));
                    mkBook2.setReading_chapter_path(cursorQuery.isNull(columnIndexOrThrow54) ? null : cursorQuery.getString(columnIndexOrThrow54));
                    mkBook2.setReload_updated_at(cursorQuery.getLong(columnIndexOrThrow55));
                    mkBook2.setUpdated(cursorQuery.getInt(columnIndexOrThrow56));
                    mkBook = mkBook2;
                } else {
                    mkBook = null;
                }
                return mkBook;
            } finally {
                cursorQuery.close();
            }
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class b extends SharedSQLiteStatement {
        b(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set reading_site_id =? , siteName=?  where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class b0 extends SharedSQLiteStatement {
        b0(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "delete  from MkBook where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class c extends SharedSQLiteStatement {
        c(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set updated_at =? ,updated =?, fatten_num =?, last_chapter_name=? where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class c0 extends SharedSQLiteStatement {
        c0(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set reading_site_id =? , siteName=? ,reading_site_path =?  ,site_path_reload =? , crawl_book_id =?  where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class d extends SharedSQLiteStatement {
        d(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set updated_at =? ,updated =?,   last_chapter_name=? where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class d0 extends SharedSQLiteStatement {
        d0(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set reload_updated_at =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class e extends SharedSQLiteStatement {
        e(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set comment_number =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class e0 extends SharedSQLiteStatement {
        e0(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set jpush_status =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class f extends SharedSQLiteStatement {
        f(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set fav_count =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class f0 extends SharedSQLiteStatement {
        f0(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set jpush_today_time =?   where book_id = ? ";
        }
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.database.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class C0087g extends SharedSQLiteStatement {
        C0087g(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set words_number =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class g0 extends SharedSQLiteStatement {
        g0(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set updated =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class h extends SharedSQLiteStatement {
        h(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set crawl_book_id =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class h0 extends SharedSQLiteStatement {
        h0(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set book_shelf_category =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class i extends SharedSQLiteStatement {
        i(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set score =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class j extends SharedSQLiteStatement {
        j(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set list_path =? ,list_reload_path =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class k extends EntityInsertionAdapter<MkBook> {
        k(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, MkBook mkBook) {
            supportSQLiteStatement.bindLong(1, mkBook.getArt_id());
            supportSQLiteStatement.bindLong(2, mkBook.getBook_id());
            if (mkBook.getName() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, mkBook.getName());
            }
            if (mkBook.getAuthor() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, mkBook.getAuthor());
            }
            supportSQLiteStatement.bindLong(5, mkBook.getForm());
            if (mkBook.getImage() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, mkBook.getImage());
            }
            if (mkBook.getLtype() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, mkBook.getLtype());
            }
            if (mkBook.getStype() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, mkBook.getStype());
            }
            supportSQLiteStatement.bindLong(9, mkBook.getStatus());
            if (mkBook.getRefreshtime() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, mkBook.getRefreshtime());
            }
            supportSQLiteStatement.bindLong(11, mkBook.getFav_count());
            supportSQLiteStatement.bindLong(12, mkBook.getComment_number());
            if (mkBook.getLast_chapter_name() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, mkBook.getLast_chapter_name());
            }
            supportSQLiteStatement.bindLong(14, mkBook.getLast_crawler_book_id());
            if (mkBook.getUpdated_at() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, mkBook.getUpdated_at());
            }
            supportSQLiteStatement.bindLong(16, mkBook.getVertical_top());
            supportSQLiteStatement.bindLong(17, mkBook.getWords_number());
            if (mkBook.getList_path() == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, mkBook.getList_path());
            }
            if (mkBook.getList_reload_path() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, mkBook.getList_reload_path());
            }
            supportSQLiteStatement.bindLong(20, mkBook.getChapter_count());
            if (mkBook.getReading_site_id() == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, mkBook.getReading_site_id());
            }
            if (mkBook.getReading_site_path() == null) {
                supportSQLiteStatement.bindNull(22);
            } else {
                supportSQLiteStatement.bindString(22, mkBook.getReading_site_path());
            }
            if (mkBook.getSite_path_reload() == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, mkBook.getSite_path_reload());
            }
            if (mkBook.getScore() == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, mkBook.getScore());
            }
            supportSQLiteStatement.bindLong(25, mkBook.getView_count());
            supportSQLiteStatement.bindLong(26, mkBook.getScore_number());
            if (mkBook.getReading_site_reload_path() == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, mkBook.getReading_site_reload_path());
            }
            supportSQLiteStatement.bindLong(28, mkBook.getCrawl_book_id());
            supportSQLiteStatement.bindLong(29, mkBook.getJpush_status());
            if (mkBook.getJpush_today_time() == null) {
                supportSQLiteStatement.bindNull(30);
            } else {
                supportSQLiteStatement.bindString(30, mkBook.getJpush_today_time());
            }
            supportSQLiteStatement.bindLong(31, mkBook.getBg_color());
            supportSQLiteStatement.bindLong(32, mkBook.getBook_int_filed_1());
            supportSQLiteStatement.bindLong(33, mkBook.getBook_int_filed_2());
            supportSQLiteStatement.bindLong(34, mkBook.getBook_int_filed_3());
            supportSQLiteStatement.bindLong(35, mkBook.getBook_int_filed_4());
            supportSQLiteStatement.bindLong(36, mkBook.getBook_int_filed_5());
            supportSQLiteStatement.bindLong(37, mkBook.getBook_int_filed_6());
            if (mkBook.getBook_shelf_category() == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, mkBook.getBook_shelf_category());
            }
            if (mkBook.getComic_source() == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, mkBook.getComic_source());
            }
            if (mkBook.getBook_text_filed_1() == null) {
                supportSQLiteStatement.bindNull(40);
            } else {
                supportSQLiteStatement.bindString(40, mkBook.getBook_text_filed_1());
            }
            if (mkBook.getBook_text_filed_2() == null) {
                supportSQLiteStatement.bindNull(41);
            } else {
                supportSQLiteStatement.bindString(41, mkBook.getBook_text_filed_2());
            }
            if (mkBook.getBook_text_filed_3() == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, mkBook.getBook_text_filed_3());
            }
            if (mkBook.getBook_text_filed_4() == null) {
                supportSQLiteStatement.bindNull(43);
            } else {
                supportSQLiteStatement.bindString(43, mkBook.getBook_text_filed_4());
            }
            if (mkBook.getBook_text_filed_5() == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindString(44, mkBook.getBook_text_filed_5());
            }
            if (mkBook.getBook_text_filed_6() == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindString(45, mkBook.getBook_text_filed_6());
            }
            if (mkBook.getSiteName() == null) {
                supportSQLiteStatement.bindNull(46);
            } else {
                supportSQLiteStatement.bindString(46, mkBook.getSiteName());
            }
            supportSQLiteStatement.bindLong(47, mkBook.getIs_top());
            supportSQLiteStatement.bindLong(48, mkBook.getIs_fatten());
            supportSQLiteStatement.bindLong(49, mkBook.getFatten_num());
            supportSQLiteStatement.bindLong(50, mkBook.getReading_datetime());
            supportSQLiteStatement.bindLong(51, mkBook.getReading_chapter_key());
            if (mkBook.getLast_read_chapterName() == null) {
                supportSQLiteStatement.bindNull(52);
            } else {
                supportSQLiteStatement.bindString(52, mkBook.getLast_read_chapterName());
            }
            supportSQLiteStatement.bindLong(53, mkBook.getRead_begin());
            if (mkBook.getReading_chapter_path() == null) {
                supportSQLiteStatement.bindNull(54);
            } else {
                supportSQLiteStatement.bindString(54, mkBook.getReading_chapter_path());
            }
            supportSQLiteStatement.bindLong(55, mkBook.getReload_updated_at());
            supportSQLiteStatement.bindLong(56, mkBook.getUpdated());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `MkBook` (`art_id`,`book_id`,`name`,`author`,`form`,`image`,`ltype`,`stype`,`status`,`refreshtime`,`fav_count`,`comment_number`,`last_chapter_name`,`last_crawler_book_id`,`updated_at`,`vertical_top`,`words_number`,`list_path`,`list_reload_path`,`chapter_count`,`reading_site_id`,`reading_site_path`,`site_path_reload`,`score`,`view_count`,`score_number`,`reading_site_reload_path`,`crawl_book_id`,`jpush_status`,`jpush_today_time`,`bg_color`,`book_int_filed_1`,`book_int_filed_2`,`book_int_filed_3`,`book_int_filed_4`,`book_int_filed_5`,`book_int_filed_6`,`book_shelf_category`,`comic_source`,`book_text_filed_1`,`book_text_filed_2`,`book_text_filed_3`,`book_text_filed_4`,`book_text_filed_5`,`book_text_filed_6`,`siteName`,`is_top`,`is_fatten`,`fatten_num`,`reading_datetime`,`reading_chapter_key`,`last_read_chapterName`,`read_begin`,`reading_chapter_path`,`reload_updated_at`,`updated`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class l extends SharedSQLiteStatement {
        l(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set list_path =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class m extends SharedSQLiteStatement {
        m(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set score_number =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class n extends SharedSQLiteStatement {
        n(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set view_count =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class o extends SharedSQLiteStatement {
        o(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set name =?,author=?, image =?,ltype=?,  stype=?,  status=? , is_fatten=? , is_top=?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class p extends SharedSQLiteStatement {
        p(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set name =?,author=?, image =?,ltype=?,  stype=?,  status=?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class q extends SharedSQLiteStatement {
        q(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set name =?,author=?, image =?,list_path=?,last_chapter_name=? , list_reload_path=?,  status=? ,chapter_count=? ,is_fatten=?,is_top=? where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class r extends SharedSQLiteStatement {
        r(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set reading_chapter_key =? ,updated =8, read_begin = ?,vertical_top=?,  reading_datetime=? where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class s extends SharedSQLiteStatement {
        s(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set reading_chapter_key =? ,updated =?, read_begin = ?,vertical_top=?,  reading_datetime=?, last_read_chapterName=?  where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class t extends SharedSQLiteStatement {
        t(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set reading_chapter_key =? ,updated =8, last_read_chapterName=? where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class u extends SharedSQLiteStatement {
        u(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set is_top =? where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class v extends SharedSQLiteStatement {
        v(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set book_text_filed_3 =?   where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class w extends SharedSQLiteStatement {
        w(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set is_fatten =?,fatten_num = 0 where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class x extends SharedSQLiteStatement {
        x(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM MkBook  ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class y extends SharedSQLiteStatement {
        y(g gVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update MkBook set book_text_filed_1 =?  where book_id = ? ";
        }
    }

    /* JADX INFO: compiled from: MkBookDao_Impl.java */
    class z implements Callable<List<MkBook>> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f3655s;

        z(RoomSQLiteQuery roomSQLiteQuery) {
            this.f3655s = roomSQLiteQuery;
        }

        protected void finalize() {
            this.f3655s.release();
        }

        @Override // java.util.concurrent.Callable
        public List<MkBook> call() throws Exception {
            int i2;
            String string;
            String string2;
            String string3;
            int i3;
            String string4;
            String string5;
            String string6;
            String string7;
            String string8;
            String string9;
            int i4;
            String string10;
            String string11;
            String string12;
            String string13;
            String string14;
            String string15;
            String string16;
            String string17;
            String string18;
            int i5;
            String string19;
            int i6;
            String string20;
            Cursor cursorQuery = DBUtil.query(g.this.a, this.f3655s, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "refreshtime");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_crawler_book_id");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vertical_top");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_id");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_path");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "site_path_reload");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_count");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score_number");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_reload_path");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "crawl_book_id");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_status");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_today_time");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_1");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_2");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_3");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_4");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_5");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_6");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_shelf_category");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comic_source");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_1");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_2");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_3");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_4");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_5");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_6");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteName");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_fatten");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fatten_num");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_datetime");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_key");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_read_chapterName");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "read_begin");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_path");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reload_updated_at");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated");
                int i7 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    MkBook mkBook = new MkBook();
                    ArrayList arrayList2 = arrayList;
                    mkBook.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                    mkBook.setBook_id(cursorQuery.getInt(columnIndexOrThrow2));
                    mkBook.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    mkBook.setAuthor(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    mkBook.setForm(cursorQuery.getInt(columnIndexOrThrow5));
                    mkBook.setImage(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    mkBook.setLtype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    mkBook.setStype(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    mkBook.setStatus(cursorQuery.getInt(columnIndexOrThrow9));
                    mkBook.setRefreshtime(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    mkBook.setFav_count(cursorQuery.getInt(columnIndexOrThrow11));
                    mkBook.setComment_number(cursorQuery.getInt(columnIndexOrThrow12));
                    mkBook.setLast_chapter_name(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    int i8 = i7;
                    int i9 = columnIndexOrThrow;
                    mkBook.setLast_crawler_book_id(cursorQuery.getInt(i8));
                    int i10 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i10)) {
                        i2 = i10;
                        string = null;
                    } else {
                        i2 = i10;
                        string = cursorQuery.getString(i10);
                    }
                    mkBook.setUpdated_at(string);
                    int i11 = columnIndexOrThrow16;
                    mkBook.setVertical_top(cursorQuery.getInt(i11));
                    columnIndexOrThrow16 = i11;
                    int i12 = columnIndexOrThrow17;
                    mkBook.setWords_number(cursorQuery.getInt(i12));
                    int i13 = columnIndexOrThrow18;
                    if (cursorQuery.isNull(i13)) {
                        columnIndexOrThrow18 = i13;
                        string2 = null;
                    } else {
                        columnIndexOrThrow18 = i13;
                        string2 = cursorQuery.getString(i13);
                    }
                    mkBook.setList_path(string2);
                    int i14 = columnIndexOrThrow19;
                    if (cursorQuery.isNull(i14)) {
                        columnIndexOrThrow19 = i14;
                        string3 = null;
                    } else {
                        columnIndexOrThrow19 = i14;
                        string3 = cursorQuery.getString(i14);
                    }
                    mkBook.setList_reload_path(string3);
                    columnIndexOrThrow17 = i12;
                    int i15 = columnIndexOrThrow20;
                    mkBook.setChapter_count(cursorQuery.getInt(i15));
                    int i16 = columnIndexOrThrow21;
                    if (cursorQuery.isNull(i16)) {
                        i3 = i15;
                        string4 = null;
                    } else {
                        i3 = i15;
                        string4 = cursorQuery.getString(i16);
                    }
                    mkBook.setReading_site_id(string4);
                    int i17 = columnIndexOrThrow22;
                    if (cursorQuery.isNull(i17)) {
                        columnIndexOrThrow22 = i17;
                        string5 = null;
                    } else {
                        columnIndexOrThrow22 = i17;
                        string5 = cursorQuery.getString(i17);
                    }
                    mkBook.setReading_site_path(string5);
                    int i18 = columnIndexOrThrow23;
                    if (cursorQuery.isNull(i18)) {
                        columnIndexOrThrow23 = i18;
                        string6 = null;
                    } else {
                        columnIndexOrThrow23 = i18;
                        string6 = cursorQuery.getString(i18);
                    }
                    mkBook.setSite_path_reload(string6);
                    int i19 = columnIndexOrThrow24;
                    if (cursorQuery.isNull(i19)) {
                        columnIndexOrThrow24 = i19;
                        string7 = null;
                    } else {
                        columnIndexOrThrow24 = i19;
                        string7 = cursorQuery.getString(i19);
                    }
                    mkBook.setScore(string7);
                    int i20 = columnIndexOrThrow25;
                    mkBook.setView_count(cursorQuery.getInt(i20));
                    columnIndexOrThrow25 = i20;
                    int i21 = columnIndexOrThrow26;
                    mkBook.setScore_number(cursorQuery.getInt(i21));
                    int i22 = columnIndexOrThrow27;
                    if (cursorQuery.isNull(i22)) {
                        columnIndexOrThrow27 = i22;
                        string8 = null;
                    } else {
                        columnIndexOrThrow27 = i22;
                        string8 = cursorQuery.getString(i22);
                    }
                    mkBook.setReading_site_reload_path(string8);
                    columnIndexOrThrow26 = i21;
                    int i23 = columnIndexOrThrow28;
                    mkBook.setCrawl_book_id(cursorQuery.getInt(i23));
                    columnIndexOrThrow28 = i23;
                    int i24 = columnIndexOrThrow29;
                    mkBook.setJpush_status(cursorQuery.getInt(i24));
                    int i25 = columnIndexOrThrow30;
                    if (cursorQuery.isNull(i25)) {
                        columnIndexOrThrow30 = i25;
                        string9 = null;
                    } else {
                        columnIndexOrThrow30 = i25;
                        string9 = cursorQuery.getString(i25);
                    }
                    mkBook.setJpush_today_time(string9);
                    columnIndexOrThrow29 = i24;
                    int i26 = columnIndexOrThrow31;
                    mkBook.setBg_color(cursorQuery.getInt(i26));
                    columnIndexOrThrow31 = i26;
                    int i27 = columnIndexOrThrow32;
                    mkBook.setBook_int_filed_1(cursorQuery.getInt(i27));
                    columnIndexOrThrow32 = i27;
                    int i28 = columnIndexOrThrow33;
                    mkBook.setBook_int_filed_2(cursorQuery.getInt(i28));
                    columnIndexOrThrow33 = i28;
                    int i29 = columnIndexOrThrow34;
                    mkBook.setBook_int_filed_3(cursorQuery.getInt(i29));
                    columnIndexOrThrow34 = i29;
                    int i30 = columnIndexOrThrow35;
                    mkBook.setBook_int_filed_4(cursorQuery.getInt(i30));
                    columnIndexOrThrow35 = i30;
                    int i31 = columnIndexOrThrow36;
                    mkBook.setBook_int_filed_5(cursorQuery.getInt(i31));
                    columnIndexOrThrow36 = i31;
                    int i32 = columnIndexOrThrow37;
                    mkBook.setBook_int_filed_6(cursorQuery.getInt(i32));
                    int i33 = columnIndexOrThrow38;
                    if (cursorQuery.isNull(i33)) {
                        i4 = i32;
                        string10 = null;
                    } else {
                        i4 = i32;
                        string10 = cursorQuery.getString(i33);
                    }
                    mkBook.setBook_shelf_category(string10);
                    int i34 = columnIndexOrThrow39;
                    if (cursorQuery.isNull(i34)) {
                        columnIndexOrThrow39 = i34;
                        string11 = null;
                    } else {
                        columnIndexOrThrow39 = i34;
                        string11 = cursorQuery.getString(i34);
                    }
                    mkBook.setComic_source(string11);
                    int i35 = columnIndexOrThrow40;
                    if (cursorQuery.isNull(i35)) {
                        columnIndexOrThrow40 = i35;
                        string12 = null;
                    } else {
                        columnIndexOrThrow40 = i35;
                        string12 = cursorQuery.getString(i35);
                    }
                    mkBook.setBook_text_filed_1(string12);
                    int i36 = columnIndexOrThrow41;
                    if (cursorQuery.isNull(i36)) {
                        columnIndexOrThrow41 = i36;
                        string13 = null;
                    } else {
                        columnIndexOrThrow41 = i36;
                        string13 = cursorQuery.getString(i36);
                    }
                    mkBook.setBook_text_filed_2(string13);
                    int i37 = columnIndexOrThrow42;
                    if (cursorQuery.isNull(i37)) {
                        columnIndexOrThrow42 = i37;
                        string14 = null;
                    } else {
                        columnIndexOrThrow42 = i37;
                        string14 = cursorQuery.getString(i37);
                    }
                    mkBook.setBook_text_filed_3(string14);
                    int i38 = columnIndexOrThrow43;
                    if (cursorQuery.isNull(i38)) {
                        columnIndexOrThrow43 = i38;
                        string15 = null;
                    } else {
                        columnIndexOrThrow43 = i38;
                        string15 = cursorQuery.getString(i38);
                    }
                    mkBook.setBook_text_filed_4(string15);
                    int i39 = columnIndexOrThrow44;
                    if (cursorQuery.isNull(i39)) {
                        columnIndexOrThrow44 = i39;
                        string16 = null;
                    } else {
                        columnIndexOrThrow44 = i39;
                        string16 = cursorQuery.getString(i39);
                    }
                    mkBook.setBook_text_filed_5(string16);
                    int i40 = columnIndexOrThrow45;
                    if (cursorQuery.isNull(i40)) {
                        columnIndexOrThrow45 = i40;
                        string17 = null;
                    } else {
                        columnIndexOrThrow45 = i40;
                        string17 = cursorQuery.getString(i40);
                    }
                    mkBook.setBook_text_filed_6(string17);
                    int i41 = columnIndexOrThrow46;
                    if (cursorQuery.isNull(i41)) {
                        columnIndexOrThrow46 = i41;
                        string18 = null;
                    } else {
                        columnIndexOrThrow46 = i41;
                        string18 = cursorQuery.getString(i41);
                    }
                    mkBook.setSiteName(string18);
                    int i42 = columnIndexOrThrow47;
                    mkBook.setIs_top(cursorQuery.getInt(i42));
                    columnIndexOrThrow47 = i42;
                    int i43 = columnIndexOrThrow48;
                    mkBook.setIs_fatten(cursorQuery.getInt(i43));
                    columnIndexOrThrow48 = i43;
                    int i44 = columnIndexOrThrow49;
                    mkBook.setFatten_num(cursorQuery.getInt(i44));
                    int i45 = columnIndexOrThrow2;
                    int i46 = columnIndexOrThrow50;
                    int i47 = columnIndexOrThrow3;
                    mkBook.setReading_datetime(cursorQuery.getLong(i46));
                    int i48 = columnIndexOrThrow51;
                    mkBook.setReading_chapter_key(cursorQuery.getInt(i48));
                    int i49 = columnIndexOrThrow52;
                    if (cursorQuery.isNull(i49)) {
                        i5 = i44;
                        string19 = null;
                    } else {
                        i5 = i44;
                        string19 = cursorQuery.getString(i49);
                    }
                    mkBook.setLast_read_chapterName(string19);
                    int i50 = columnIndexOrThrow53;
                    mkBook.setRead_begin(cursorQuery.getInt(i50));
                    int i51 = columnIndexOrThrow54;
                    if (cursorQuery.isNull(i51)) {
                        i6 = i50;
                        string20 = null;
                    } else {
                        i6 = i50;
                        string20 = cursorQuery.getString(i51);
                    }
                    mkBook.setReading_chapter_path(string20);
                    int i52 = columnIndexOrThrow55;
                    mkBook.setReload_updated_at(cursorQuery.getLong(i52));
                    int i53 = columnIndexOrThrow56;
                    mkBook.setUpdated(cursorQuery.getInt(i53));
                    arrayList2.add(mkBook);
                    columnIndexOrThrow56 = i53;
                    columnIndexOrThrow2 = i45;
                    columnIndexOrThrow49 = i5;
                    columnIndexOrThrow52 = i49;
                    columnIndexOrThrow55 = i52;
                    columnIndexOrThrow = i9;
                    i7 = i8;
                    columnIndexOrThrow15 = i2;
                    int i54 = i6;
                    columnIndexOrThrow54 = i51;
                    arrayList = arrayList2;
                    columnIndexOrThrow3 = i47;
                    columnIndexOrThrow50 = i46;
                    columnIndexOrThrow51 = i48;
                    columnIndexOrThrow53 = i54;
                    int i55 = i3;
                    columnIndexOrThrow21 = i16;
                    columnIndexOrThrow20 = i55;
                    int i56 = i4;
                    columnIndexOrThrow38 = i33;
                    columnIndexOrThrow37 = i56;
                }
                return arrayList;
            } finally {
                cursorQuery.close();
            }
        }
    }

    public g(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new k(this, roomDatabase);
        this.f3629c = new v(this, roomDatabase);
        this.f3630d = new b0(this, roomDatabase);
        this.f3631e = new c0(this, roomDatabase);
        this.f3632f = new d0(this, roomDatabase);
        this.f3633g = new e0(this, roomDatabase);
        this.f3634h = new f0(this, roomDatabase);
        this.f3635i = new g0(this, roomDatabase);
        this.f3636j = new h0(this, roomDatabase);
        this.f3637k = new a(this, roomDatabase);
        this.f3638l = new b(this, roomDatabase);
        this.f3639m = new c(this, roomDatabase);
        this.f3640n = new d(this, roomDatabase);
        this.f3641o = new e(this, roomDatabase);
        this.f3642p = new f(this, roomDatabase);
        this.f3643q = new C0087g(this, roomDatabase);
        this.f3644r = new h(this, roomDatabase);
        this.f3645s = new i(this, roomDatabase);
        this.f3646t = new j(this, roomDatabase);
        this.f3647u = new l(this, roomDatabase);
        this.f3648v = new m(this, roomDatabase);
        this.f3649w = new n(this, roomDatabase);
        this.f3650x = new o(this, roomDatabase);
        this.f3651y = new p(this, roomDatabase);
        this.f3652z = new q(this, roomDatabase);
        this.A = new r(this, roomDatabase);
        this.B = new s(this, roomDatabase);
        this.C = new t(this, roomDatabase);
        this.D = new u(this, roomDatabase);
        this.E = new w(this, roomDatabase);
        this.F = new x(this, roomDatabase);
        this.G = new y(this, roomDatabase);
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void b(String str, String str2, int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3638l.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str2);
        }
        supportSQLiteStatementAcquire.bindLong(3, i2);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3638l.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void c(String str, int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3634h.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        supportSQLiteStatementAcquire.bindLong(2, i2);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3634h.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void d(String str, int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3645s.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        supportSQLiteStatementAcquire.bindLong(2, i2);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3645s.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void e(int i2, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3641o.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i3);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3641o.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void f(String str, int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3629c.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        supportSQLiteStatementAcquire.bindLong(2, i2);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3629c.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public List<MkBook> g(int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i3;
        String string;
        String string2;
        String string3;
        int i4;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i5;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        int i6;
        String string19;
        int i7;
        String string20;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkBook  where form=? ORDER BY is_top DESC ,reading_datetime ASC ", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "refreshtime");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_crawler_book_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vertical_top");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_path");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "site_path_reload");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_count");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score_number");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_reload_path");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "crawl_book_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_status");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_today_time");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_1");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_2");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_3");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_4");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_5");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_6");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_shelf_category");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comic_source");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_1");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_2");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_3");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_4");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_5");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_6");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteName");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_fatten");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fatten_num");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_datetime");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_key");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_read_chapterName");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "read_begin");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_path");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reload_updated_at");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated");
            int i8 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MkBook mkBook = new MkBook();
                ArrayList arrayList2 = arrayList;
                mkBook.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                mkBook.setBook_id(cursorQuery.getInt(columnIndexOrThrow2));
                mkBook.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                mkBook.setAuthor(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                mkBook.setForm(cursorQuery.getInt(columnIndexOrThrow5));
                mkBook.setImage(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                mkBook.setLtype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                mkBook.setStype(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                mkBook.setStatus(cursorQuery.getInt(columnIndexOrThrow9));
                mkBook.setRefreshtime(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                mkBook.setFav_count(cursorQuery.getInt(columnIndexOrThrow11));
                mkBook.setComment_number(cursorQuery.getInt(columnIndexOrThrow12));
                mkBook.setLast_chapter_name(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i9 = i8;
                int i10 = columnIndexOrThrow;
                mkBook.setLast_crawler_book_id(cursorQuery.getInt(i9));
                int i11 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i11)) {
                    i3 = i11;
                    string = null;
                } else {
                    i3 = i11;
                    string = cursorQuery.getString(i11);
                }
                mkBook.setUpdated_at(string);
                int i12 = columnIndexOrThrow16;
                mkBook.setVertical_top(cursorQuery.getInt(i12));
                columnIndexOrThrow16 = i12;
                int i13 = columnIndexOrThrow17;
                mkBook.setWords_number(cursorQuery.getInt(i13));
                int i14 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i14)) {
                    columnIndexOrThrow18 = i14;
                    string2 = null;
                } else {
                    columnIndexOrThrow18 = i14;
                    string2 = cursorQuery.getString(i14);
                }
                mkBook.setList_path(string2);
                int i15 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i15)) {
                    columnIndexOrThrow19 = i15;
                    string3 = null;
                } else {
                    columnIndexOrThrow19 = i15;
                    string3 = cursorQuery.getString(i15);
                }
                mkBook.setList_reload_path(string3);
                columnIndexOrThrow17 = i13;
                int i16 = columnIndexOrThrow20;
                mkBook.setChapter_count(cursorQuery.getInt(i16));
                int i17 = columnIndexOrThrow21;
                if (cursorQuery.isNull(i17)) {
                    i4 = i16;
                    string4 = null;
                } else {
                    i4 = i16;
                    string4 = cursorQuery.getString(i17);
                }
                mkBook.setReading_site_id(string4);
                int i18 = columnIndexOrThrow22;
                if (cursorQuery.isNull(i18)) {
                    columnIndexOrThrow22 = i18;
                    string5 = null;
                } else {
                    columnIndexOrThrow22 = i18;
                    string5 = cursorQuery.getString(i18);
                }
                mkBook.setReading_site_path(string5);
                int i19 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i19)) {
                    columnIndexOrThrow23 = i19;
                    string6 = null;
                } else {
                    columnIndexOrThrow23 = i19;
                    string6 = cursorQuery.getString(i19);
                }
                mkBook.setSite_path_reload(string6);
                int i20 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i20)) {
                    columnIndexOrThrow24 = i20;
                    string7 = null;
                } else {
                    columnIndexOrThrow24 = i20;
                    string7 = cursorQuery.getString(i20);
                }
                mkBook.setScore(string7);
                int i21 = columnIndexOrThrow25;
                mkBook.setView_count(cursorQuery.getInt(i21));
                columnIndexOrThrow25 = i21;
                int i22 = columnIndexOrThrow26;
                mkBook.setScore_number(cursorQuery.getInt(i22));
                int i23 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i23)) {
                    columnIndexOrThrow27 = i23;
                    string8 = null;
                } else {
                    columnIndexOrThrow27 = i23;
                    string8 = cursorQuery.getString(i23);
                }
                mkBook.setReading_site_reload_path(string8);
                columnIndexOrThrow26 = i22;
                int i24 = columnIndexOrThrow28;
                mkBook.setCrawl_book_id(cursorQuery.getInt(i24));
                columnIndexOrThrow28 = i24;
                int i25 = columnIndexOrThrow29;
                mkBook.setJpush_status(cursorQuery.getInt(i25));
                int i26 = columnIndexOrThrow30;
                if (cursorQuery.isNull(i26)) {
                    columnIndexOrThrow30 = i26;
                    string9 = null;
                } else {
                    columnIndexOrThrow30 = i26;
                    string9 = cursorQuery.getString(i26);
                }
                mkBook.setJpush_today_time(string9);
                columnIndexOrThrow29 = i25;
                int i27 = columnIndexOrThrow31;
                mkBook.setBg_color(cursorQuery.getInt(i27));
                columnIndexOrThrow31 = i27;
                int i28 = columnIndexOrThrow32;
                mkBook.setBook_int_filed_1(cursorQuery.getInt(i28));
                columnIndexOrThrow32 = i28;
                int i29 = columnIndexOrThrow33;
                mkBook.setBook_int_filed_2(cursorQuery.getInt(i29));
                columnIndexOrThrow33 = i29;
                int i30 = columnIndexOrThrow34;
                mkBook.setBook_int_filed_3(cursorQuery.getInt(i30));
                columnIndexOrThrow34 = i30;
                int i31 = columnIndexOrThrow35;
                mkBook.setBook_int_filed_4(cursorQuery.getInt(i31));
                columnIndexOrThrow35 = i31;
                int i32 = columnIndexOrThrow36;
                mkBook.setBook_int_filed_5(cursorQuery.getInt(i32));
                columnIndexOrThrow36 = i32;
                int i33 = columnIndexOrThrow37;
                mkBook.setBook_int_filed_6(cursorQuery.getInt(i33));
                int i34 = columnIndexOrThrow38;
                if (cursorQuery.isNull(i34)) {
                    i5 = i33;
                    string10 = null;
                } else {
                    i5 = i33;
                    string10 = cursorQuery.getString(i34);
                }
                mkBook.setBook_shelf_category(string10);
                int i35 = columnIndexOrThrow39;
                if (cursorQuery.isNull(i35)) {
                    columnIndexOrThrow39 = i35;
                    string11 = null;
                } else {
                    columnIndexOrThrow39 = i35;
                    string11 = cursorQuery.getString(i35);
                }
                mkBook.setComic_source(string11);
                int i36 = columnIndexOrThrow40;
                if (cursorQuery.isNull(i36)) {
                    columnIndexOrThrow40 = i36;
                    string12 = null;
                } else {
                    columnIndexOrThrow40 = i36;
                    string12 = cursorQuery.getString(i36);
                }
                mkBook.setBook_text_filed_1(string12);
                int i37 = columnIndexOrThrow41;
                if (cursorQuery.isNull(i37)) {
                    columnIndexOrThrow41 = i37;
                    string13 = null;
                } else {
                    columnIndexOrThrow41 = i37;
                    string13 = cursorQuery.getString(i37);
                }
                mkBook.setBook_text_filed_2(string13);
                int i38 = columnIndexOrThrow42;
                if (cursorQuery.isNull(i38)) {
                    columnIndexOrThrow42 = i38;
                    string14 = null;
                } else {
                    columnIndexOrThrow42 = i38;
                    string14 = cursorQuery.getString(i38);
                }
                mkBook.setBook_text_filed_3(string14);
                int i39 = columnIndexOrThrow43;
                if (cursorQuery.isNull(i39)) {
                    columnIndexOrThrow43 = i39;
                    string15 = null;
                } else {
                    columnIndexOrThrow43 = i39;
                    string15 = cursorQuery.getString(i39);
                }
                mkBook.setBook_text_filed_4(string15);
                int i40 = columnIndexOrThrow44;
                if (cursorQuery.isNull(i40)) {
                    columnIndexOrThrow44 = i40;
                    string16 = null;
                } else {
                    columnIndexOrThrow44 = i40;
                    string16 = cursorQuery.getString(i40);
                }
                mkBook.setBook_text_filed_5(string16);
                int i41 = columnIndexOrThrow45;
                if (cursorQuery.isNull(i41)) {
                    columnIndexOrThrow45 = i41;
                    string17 = null;
                } else {
                    columnIndexOrThrow45 = i41;
                    string17 = cursorQuery.getString(i41);
                }
                mkBook.setBook_text_filed_6(string17);
                int i42 = columnIndexOrThrow46;
                if (cursorQuery.isNull(i42)) {
                    columnIndexOrThrow46 = i42;
                    string18 = null;
                } else {
                    columnIndexOrThrow46 = i42;
                    string18 = cursorQuery.getString(i42);
                }
                mkBook.setSiteName(string18);
                int i43 = columnIndexOrThrow47;
                mkBook.setIs_top(cursorQuery.getInt(i43));
                columnIndexOrThrow47 = i43;
                int i44 = columnIndexOrThrow48;
                mkBook.setIs_fatten(cursorQuery.getInt(i44));
                columnIndexOrThrow48 = i44;
                int i45 = columnIndexOrThrow49;
                mkBook.setFatten_num(cursorQuery.getInt(i45));
                int i46 = columnIndexOrThrow2;
                int i47 = columnIndexOrThrow50;
                int i48 = columnIndexOrThrow3;
                mkBook.setReading_datetime(cursorQuery.getLong(i47));
                int i49 = columnIndexOrThrow51;
                mkBook.setReading_chapter_key(cursorQuery.getInt(i49));
                int i50 = columnIndexOrThrow52;
                if (cursorQuery.isNull(i50)) {
                    i6 = i45;
                    string19 = null;
                } else {
                    i6 = i45;
                    string19 = cursorQuery.getString(i50);
                }
                mkBook.setLast_read_chapterName(string19);
                int i51 = columnIndexOrThrow53;
                mkBook.setRead_begin(cursorQuery.getInt(i51));
                int i52 = columnIndexOrThrow54;
                if (cursorQuery.isNull(i52)) {
                    i7 = i51;
                    string20 = null;
                } else {
                    i7 = i51;
                    string20 = cursorQuery.getString(i52);
                }
                mkBook.setReading_chapter_path(string20);
                int i53 = columnIndexOrThrow13;
                int i54 = columnIndexOrThrow55;
                mkBook.setReload_updated_at(cursorQuery.getLong(i54));
                int i55 = columnIndexOrThrow56;
                mkBook.setUpdated(cursorQuery.getInt(i55));
                arrayList2.add(mkBook);
                columnIndexOrThrow56 = i55;
                arrayList = arrayList2;
                columnIndexOrThrow13 = i53;
                columnIndexOrThrow53 = i7;
                columnIndexOrThrow54 = i52;
                columnIndexOrThrow55 = i54;
                columnIndexOrThrow = i10;
                i8 = i9;
                columnIndexOrThrow15 = i3;
                columnIndexOrThrow51 = i49;
                columnIndexOrThrow2 = i46;
                columnIndexOrThrow49 = i6;
                columnIndexOrThrow52 = i50;
                columnIndexOrThrow3 = i48;
                columnIndexOrThrow50 = i47;
                int i56 = i4;
                columnIndexOrThrow21 = i17;
                columnIndexOrThrow20 = i56;
                int i57 = i5;
                columnIndexOrThrow38 = i34;
                columnIndexOrThrow37 = i57;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void h(int i2, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3642p.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i3);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3642p.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void i(int i2, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3649w.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i3);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3649w.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public long insert(MkBook mkBook) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            long jInsertAndReturnId = this.b.insertAndReturnId(mkBook);
            this.a.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void j(int i2, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3644r.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i3);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3644r.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void k(int i2, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3633g.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i3);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3633g.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public List<MkBook> l(int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i3;
        String string;
        String string2;
        String string3;
        int i4;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i5;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        int i6;
        String string19;
        int i7;
        String string20;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkBook  where form=? ORDER BY is_top DESC ,reading_datetime DESC ", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "refreshtime");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_crawler_book_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vertical_top");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_path");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "site_path_reload");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_count");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score_number");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_reload_path");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "crawl_book_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_status");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_today_time");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_1");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_2");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_3");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_4");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_5");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_6");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_shelf_category");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comic_source");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_1");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_2");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_3");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_4");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_5");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_6");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteName");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_fatten");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fatten_num");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_datetime");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_key");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_read_chapterName");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "read_begin");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_path");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reload_updated_at");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated");
            int i8 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MkBook mkBook = new MkBook();
                ArrayList arrayList2 = arrayList;
                mkBook.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                mkBook.setBook_id(cursorQuery.getInt(columnIndexOrThrow2));
                mkBook.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                mkBook.setAuthor(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                mkBook.setForm(cursorQuery.getInt(columnIndexOrThrow5));
                mkBook.setImage(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                mkBook.setLtype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                mkBook.setStype(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                mkBook.setStatus(cursorQuery.getInt(columnIndexOrThrow9));
                mkBook.setRefreshtime(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                mkBook.setFav_count(cursorQuery.getInt(columnIndexOrThrow11));
                mkBook.setComment_number(cursorQuery.getInt(columnIndexOrThrow12));
                mkBook.setLast_chapter_name(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i9 = i8;
                int i10 = columnIndexOrThrow;
                mkBook.setLast_crawler_book_id(cursorQuery.getInt(i9));
                int i11 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i11)) {
                    i3 = i11;
                    string = null;
                } else {
                    i3 = i11;
                    string = cursorQuery.getString(i11);
                }
                mkBook.setUpdated_at(string);
                int i12 = columnIndexOrThrow16;
                mkBook.setVertical_top(cursorQuery.getInt(i12));
                columnIndexOrThrow16 = i12;
                int i13 = columnIndexOrThrow17;
                mkBook.setWords_number(cursorQuery.getInt(i13));
                int i14 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i14)) {
                    columnIndexOrThrow18 = i14;
                    string2 = null;
                } else {
                    columnIndexOrThrow18 = i14;
                    string2 = cursorQuery.getString(i14);
                }
                mkBook.setList_path(string2);
                int i15 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i15)) {
                    columnIndexOrThrow19 = i15;
                    string3 = null;
                } else {
                    columnIndexOrThrow19 = i15;
                    string3 = cursorQuery.getString(i15);
                }
                mkBook.setList_reload_path(string3);
                columnIndexOrThrow17 = i13;
                int i16 = columnIndexOrThrow20;
                mkBook.setChapter_count(cursorQuery.getInt(i16));
                int i17 = columnIndexOrThrow21;
                if (cursorQuery.isNull(i17)) {
                    i4 = i16;
                    string4 = null;
                } else {
                    i4 = i16;
                    string4 = cursorQuery.getString(i17);
                }
                mkBook.setReading_site_id(string4);
                int i18 = columnIndexOrThrow22;
                if (cursorQuery.isNull(i18)) {
                    columnIndexOrThrow22 = i18;
                    string5 = null;
                } else {
                    columnIndexOrThrow22 = i18;
                    string5 = cursorQuery.getString(i18);
                }
                mkBook.setReading_site_path(string5);
                int i19 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i19)) {
                    columnIndexOrThrow23 = i19;
                    string6 = null;
                } else {
                    columnIndexOrThrow23 = i19;
                    string6 = cursorQuery.getString(i19);
                }
                mkBook.setSite_path_reload(string6);
                int i20 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i20)) {
                    columnIndexOrThrow24 = i20;
                    string7 = null;
                } else {
                    columnIndexOrThrow24 = i20;
                    string7 = cursorQuery.getString(i20);
                }
                mkBook.setScore(string7);
                int i21 = columnIndexOrThrow25;
                mkBook.setView_count(cursorQuery.getInt(i21));
                columnIndexOrThrow25 = i21;
                int i22 = columnIndexOrThrow26;
                mkBook.setScore_number(cursorQuery.getInt(i22));
                int i23 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i23)) {
                    columnIndexOrThrow27 = i23;
                    string8 = null;
                } else {
                    columnIndexOrThrow27 = i23;
                    string8 = cursorQuery.getString(i23);
                }
                mkBook.setReading_site_reload_path(string8);
                columnIndexOrThrow26 = i22;
                int i24 = columnIndexOrThrow28;
                mkBook.setCrawl_book_id(cursorQuery.getInt(i24));
                columnIndexOrThrow28 = i24;
                int i25 = columnIndexOrThrow29;
                mkBook.setJpush_status(cursorQuery.getInt(i25));
                int i26 = columnIndexOrThrow30;
                if (cursorQuery.isNull(i26)) {
                    columnIndexOrThrow30 = i26;
                    string9 = null;
                } else {
                    columnIndexOrThrow30 = i26;
                    string9 = cursorQuery.getString(i26);
                }
                mkBook.setJpush_today_time(string9);
                columnIndexOrThrow29 = i25;
                int i27 = columnIndexOrThrow31;
                mkBook.setBg_color(cursorQuery.getInt(i27));
                columnIndexOrThrow31 = i27;
                int i28 = columnIndexOrThrow32;
                mkBook.setBook_int_filed_1(cursorQuery.getInt(i28));
                columnIndexOrThrow32 = i28;
                int i29 = columnIndexOrThrow33;
                mkBook.setBook_int_filed_2(cursorQuery.getInt(i29));
                columnIndexOrThrow33 = i29;
                int i30 = columnIndexOrThrow34;
                mkBook.setBook_int_filed_3(cursorQuery.getInt(i30));
                columnIndexOrThrow34 = i30;
                int i31 = columnIndexOrThrow35;
                mkBook.setBook_int_filed_4(cursorQuery.getInt(i31));
                columnIndexOrThrow35 = i31;
                int i32 = columnIndexOrThrow36;
                mkBook.setBook_int_filed_5(cursorQuery.getInt(i32));
                columnIndexOrThrow36 = i32;
                int i33 = columnIndexOrThrow37;
                mkBook.setBook_int_filed_6(cursorQuery.getInt(i33));
                int i34 = columnIndexOrThrow38;
                if (cursorQuery.isNull(i34)) {
                    i5 = i33;
                    string10 = null;
                } else {
                    i5 = i33;
                    string10 = cursorQuery.getString(i34);
                }
                mkBook.setBook_shelf_category(string10);
                int i35 = columnIndexOrThrow39;
                if (cursorQuery.isNull(i35)) {
                    columnIndexOrThrow39 = i35;
                    string11 = null;
                } else {
                    columnIndexOrThrow39 = i35;
                    string11 = cursorQuery.getString(i35);
                }
                mkBook.setComic_source(string11);
                int i36 = columnIndexOrThrow40;
                if (cursorQuery.isNull(i36)) {
                    columnIndexOrThrow40 = i36;
                    string12 = null;
                } else {
                    columnIndexOrThrow40 = i36;
                    string12 = cursorQuery.getString(i36);
                }
                mkBook.setBook_text_filed_1(string12);
                int i37 = columnIndexOrThrow41;
                if (cursorQuery.isNull(i37)) {
                    columnIndexOrThrow41 = i37;
                    string13 = null;
                } else {
                    columnIndexOrThrow41 = i37;
                    string13 = cursorQuery.getString(i37);
                }
                mkBook.setBook_text_filed_2(string13);
                int i38 = columnIndexOrThrow42;
                if (cursorQuery.isNull(i38)) {
                    columnIndexOrThrow42 = i38;
                    string14 = null;
                } else {
                    columnIndexOrThrow42 = i38;
                    string14 = cursorQuery.getString(i38);
                }
                mkBook.setBook_text_filed_3(string14);
                int i39 = columnIndexOrThrow43;
                if (cursorQuery.isNull(i39)) {
                    columnIndexOrThrow43 = i39;
                    string15 = null;
                } else {
                    columnIndexOrThrow43 = i39;
                    string15 = cursorQuery.getString(i39);
                }
                mkBook.setBook_text_filed_4(string15);
                int i40 = columnIndexOrThrow44;
                if (cursorQuery.isNull(i40)) {
                    columnIndexOrThrow44 = i40;
                    string16 = null;
                } else {
                    columnIndexOrThrow44 = i40;
                    string16 = cursorQuery.getString(i40);
                }
                mkBook.setBook_text_filed_5(string16);
                int i41 = columnIndexOrThrow45;
                if (cursorQuery.isNull(i41)) {
                    columnIndexOrThrow45 = i41;
                    string17 = null;
                } else {
                    columnIndexOrThrow45 = i41;
                    string17 = cursorQuery.getString(i41);
                }
                mkBook.setBook_text_filed_6(string17);
                int i42 = columnIndexOrThrow46;
                if (cursorQuery.isNull(i42)) {
                    columnIndexOrThrow46 = i42;
                    string18 = null;
                } else {
                    columnIndexOrThrow46 = i42;
                    string18 = cursorQuery.getString(i42);
                }
                mkBook.setSiteName(string18);
                int i43 = columnIndexOrThrow47;
                mkBook.setIs_top(cursorQuery.getInt(i43));
                columnIndexOrThrow47 = i43;
                int i44 = columnIndexOrThrow48;
                mkBook.setIs_fatten(cursorQuery.getInt(i44));
                columnIndexOrThrow48 = i44;
                int i45 = columnIndexOrThrow49;
                mkBook.setFatten_num(cursorQuery.getInt(i45));
                int i46 = columnIndexOrThrow2;
                int i47 = columnIndexOrThrow50;
                int i48 = columnIndexOrThrow3;
                mkBook.setReading_datetime(cursorQuery.getLong(i47));
                int i49 = columnIndexOrThrow51;
                mkBook.setReading_chapter_key(cursorQuery.getInt(i49));
                int i50 = columnIndexOrThrow52;
                if (cursorQuery.isNull(i50)) {
                    i6 = i45;
                    string19 = null;
                } else {
                    i6 = i45;
                    string19 = cursorQuery.getString(i50);
                }
                mkBook.setLast_read_chapterName(string19);
                int i51 = columnIndexOrThrow53;
                mkBook.setRead_begin(cursorQuery.getInt(i51));
                int i52 = columnIndexOrThrow54;
                if (cursorQuery.isNull(i52)) {
                    i7 = i51;
                    string20 = null;
                } else {
                    i7 = i51;
                    string20 = cursorQuery.getString(i52);
                }
                mkBook.setReading_chapter_path(string20);
                int i53 = columnIndexOrThrow13;
                int i54 = columnIndexOrThrow55;
                mkBook.setReload_updated_at(cursorQuery.getLong(i54));
                int i55 = columnIndexOrThrow56;
                mkBook.setUpdated(cursorQuery.getInt(i55));
                arrayList2.add(mkBook);
                columnIndexOrThrow56 = i55;
                arrayList = arrayList2;
                columnIndexOrThrow13 = i53;
                columnIndexOrThrow53 = i7;
                columnIndexOrThrow54 = i52;
                columnIndexOrThrow55 = i54;
                columnIndexOrThrow = i10;
                i8 = i9;
                columnIndexOrThrow15 = i3;
                columnIndexOrThrow51 = i49;
                columnIndexOrThrow2 = i46;
                columnIndexOrThrow49 = i6;
                columnIndexOrThrow52 = i50;
                columnIndexOrThrow3 = i48;
                columnIndexOrThrow50 = i47;
                int i56 = i4;
                columnIndexOrThrow21 = i17;
                columnIndexOrThrow20 = i56;
                int i57 = i5;
                columnIndexOrThrow38 = i34;
                columnIndexOrThrow37 = i57;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int a(int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3630d.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.f3630d.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int a(String str, String str2, String str3, int i2, String str4, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3631e.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        if (str3 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str3);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str2);
        }
        if (str4 == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str4);
        }
        supportSQLiteStatementAcquire.bindLong(5, i3);
        supportSQLiteStatementAcquire.bindLong(6, i2);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.f3631e.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void e(String str, int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3647u.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        supportSQLiteStatementAcquire.bindLong(2, i2);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3647u.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public List<MkBook> h(int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i3;
        String string;
        String string2;
        String string3;
        int i4;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i5;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        int i6;
        String string19;
        int i7;
        String string20;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkBook    where form=?   ORDER BY is_top DESC ,updated_at DESC", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "refreshtime");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_crawler_book_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vertical_top");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_path");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "site_path_reload");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_count");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score_number");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_reload_path");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "crawl_book_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_status");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_today_time");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_1");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_2");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_3");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_4");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_5");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_6");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_shelf_category");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comic_source");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_1");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_2");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_3");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_4");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_5");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_6");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteName");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_fatten");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fatten_num");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_datetime");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_key");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_read_chapterName");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "read_begin");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_path");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reload_updated_at");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated");
            int i8 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MkBook mkBook = new MkBook();
                ArrayList arrayList2 = arrayList;
                mkBook.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                mkBook.setBook_id(cursorQuery.getInt(columnIndexOrThrow2));
                mkBook.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                mkBook.setAuthor(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                mkBook.setForm(cursorQuery.getInt(columnIndexOrThrow5));
                mkBook.setImage(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                mkBook.setLtype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                mkBook.setStype(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                mkBook.setStatus(cursorQuery.getInt(columnIndexOrThrow9));
                mkBook.setRefreshtime(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                mkBook.setFav_count(cursorQuery.getInt(columnIndexOrThrow11));
                mkBook.setComment_number(cursorQuery.getInt(columnIndexOrThrow12));
                mkBook.setLast_chapter_name(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i9 = i8;
                int i10 = columnIndexOrThrow;
                mkBook.setLast_crawler_book_id(cursorQuery.getInt(i9));
                int i11 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i11)) {
                    i3 = i11;
                    string = null;
                } else {
                    i3 = i11;
                    string = cursorQuery.getString(i11);
                }
                mkBook.setUpdated_at(string);
                int i12 = columnIndexOrThrow16;
                mkBook.setVertical_top(cursorQuery.getInt(i12));
                columnIndexOrThrow16 = i12;
                int i13 = columnIndexOrThrow17;
                mkBook.setWords_number(cursorQuery.getInt(i13));
                int i14 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i14)) {
                    columnIndexOrThrow18 = i14;
                    string2 = null;
                } else {
                    columnIndexOrThrow18 = i14;
                    string2 = cursorQuery.getString(i14);
                }
                mkBook.setList_path(string2);
                int i15 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i15)) {
                    columnIndexOrThrow19 = i15;
                    string3 = null;
                } else {
                    columnIndexOrThrow19 = i15;
                    string3 = cursorQuery.getString(i15);
                }
                mkBook.setList_reload_path(string3);
                columnIndexOrThrow17 = i13;
                int i16 = columnIndexOrThrow20;
                mkBook.setChapter_count(cursorQuery.getInt(i16));
                int i17 = columnIndexOrThrow21;
                if (cursorQuery.isNull(i17)) {
                    i4 = i16;
                    string4 = null;
                } else {
                    i4 = i16;
                    string4 = cursorQuery.getString(i17);
                }
                mkBook.setReading_site_id(string4);
                int i18 = columnIndexOrThrow22;
                if (cursorQuery.isNull(i18)) {
                    columnIndexOrThrow22 = i18;
                    string5 = null;
                } else {
                    columnIndexOrThrow22 = i18;
                    string5 = cursorQuery.getString(i18);
                }
                mkBook.setReading_site_path(string5);
                int i19 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i19)) {
                    columnIndexOrThrow23 = i19;
                    string6 = null;
                } else {
                    columnIndexOrThrow23 = i19;
                    string6 = cursorQuery.getString(i19);
                }
                mkBook.setSite_path_reload(string6);
                int i20 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i20)) {
                    columnIndexOrThrow24 = i20;
                    string7 = null;
                } else {
                    columnIndexOrThrow24 = i20;
                    string7 = cursorQuery.getString(i20);
                }
                mkBook.setScore(string7);
                int i21 = columnIndexOrThrow25;
                mkBook.setView_count(cursorQuery.getInt(i21));
                columnIndexOrThrow25 = i21;
                int i22 = columnIndexOrThrow26;
                mkBook.setScore_number(cursorQuery.getInt(i22));
                int i23 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i23)) {
                    columnIndexOrThrow27 = i23;
                    string8 = null;
                } else {
                    columnIndexOrThrow27 = i23;
                    string8 = cursorQuery.getString(i23);
                }
                mkBook.setReading_site_reload_path(string8);
                columnIndexOrThrow26 = i22;
                int i24 = columnIndexOrThrow28;
                mkBook.setCrawl_book_id(cursorQuery.getInt(i24));
                columnIndexOrThrow28 = i24;
                int i25 = columnIndexOrThrow29;
                mkBook.setJpush_status(cursorQuery.getInt(i25));
                int i26 = columnIndexOrThrow30;
                if (cursorQuery.isNull(i26)) {
                    columnIndexOrThrow30 = i26;
                    string9 = null;
                } else {
                    columnIndexOrThrow30 = i26;
                    string9 = cursorQuery.getString(i26);
                }
                mkBook.setJpush_today_time(string9);
                columnIndexOrThrow29 = i25;
                int i27 = columnIndexOrThrow31;
                mkBook.setBg_color(cursorQuery.getInt(i27));
                columnIndexOrThrow31 = i27;
                int i28 = columnIndexOrThrow32;
                mkBook.setBook_int_filed_1(cursorQuery.getInt(i28));
                columnIndexOrThrow32 = i28;
                int i29 = columnIndexOrThrow33;
                mkBook.setBook_int_filed_2(cursorQuery.getInt(i29));
                columnIndexOrThrow33 = i29;
                int i30 = columnIndexOrThrow34;
                mkBook.setBook_int_filed_3(cursorQuery.getInt(i30));
                columnIndexOrThrow34 = i30;
                int i31 = columnIndexOrThrow35;
                mkBook.setBook_int_filed_4(cursorQuery.getInt(i31));
                columnIndexOrThrow35 = i31;
                int i32 = columnIndexOrThrow36;
                mkBook.setBook_int_filed_5(cursorQuery.getInt(i32));
                columnIndexOrThrow36 = i32;
                int i33 = columnIndexOrThrow37;
                mkBook.setBook_int_filed_6(cursorQuery.getInt(i33));
                int i34 = columnIndexOrThrow38;
                if (cursorQuery.isNull(i34)) {
                    i5 = i33;
                    string10 = null;
                } else {
                    i5 = i33;
                    string10 = cursorQuery.getString(i34);
                }
                mkBook.setBook_shelf_category(string10);
                int i35 = columnIndexOrThrow39;
                if (cursorQuery.isNull(i35)) {
                    columnIndexOrThrow39 = i35;
                    string11 = null;
                } else {
                    columnIndexOrThrow39 = i35;
                    string11 = cursorQuery.getString(i35);
                }
                mkBook.setComic_source(string11);
                int i36 = columnIndexOrThrow40;
                if (cursorQuery.isNull(i36)) {
                    columnIndexOrThrow40 = i36;
                    string12 = null;
                } else {
                    columnIndexOrThrow40 = i36;
                    string12 = cursorQuery.getString(i36);
                }
                mkBook.setBook_text_filed_1(string12);
                int i37 = columnIndexOrThrow41;
                if (cursorQuery.isNull(i37)) {
                    columnIndexOrThrow41 = i37;
                    string13 = null;
                } else {
                    columnIndexOrThrow41 = i37;
                    string13 = cursorQuery.getString(i37);
                }
                mkBook.setBook_text_filed_2(string13);
                int i38 = columnIndexOrThrow42;
                if (cursorQuery.isNull(i38)) {
                    columnIndexOrThrow42 = i38;
                    string14 = null;
                } else {
                    columnIndexOrThrow42 = i38;
                    string14 = cursorQuery.getString(i38);
                }
                mkBook.setBook_text_filed_3(string14);
                int i39 = columnIndexOrThrow43;
                if (cursorQuery.isNull(i39)) {
                    columnIndexOrThrow43 = i39;
                    string15 = null;
                } else {
                    columnIndexOrThrow43 = i39;
                    string15 = cursorQuery.getString(i39);
                }
                mkBook.setBook_text_filed_4(string15);
                int i40 = columnIndexOrThrow44;
                if (cursorQuery.isNull(i40)) {
                    columnIndexOrThrow44 = i40;
                    string16 = null;
                } else {
                    columnIndexOrThrow44 = i40;
                    string16 = cursorQuery.getString(i40);
                }
                mkBook.setBook_text_filed_5(string16);
                int i41 = columnIndexOrThrow45;
                if (cursorQuery.isNull(i41)) {
                    columnIndexOrThrow45 = i41;
                    string17 = null;
                } else {
                    columnIndexOrThrow45 = i41;
                    string17 = cursorQuery.getString(i41);
                }
                mkBook.setBook_text_filed_6(string17);
                int i42 = columnIndexOrThrow46;
                if (cursorQuery.isNull(i42)) {
                    columnIndexOrThrow46 = i42;
                    string18 = null;
                } else {
                    columnIndexOrThrow46 = i42;
                    string18 = cursorQuery.getString(i42);
                }
                mkBook.setSiteName(string18);
                int i43 = columnIndexOrThrow47;
                mkBook.setIs_top(cursorQuery.getInt(i43));
                columnIndexOrThrow47 = i43;
                int i44 = columnIndexOrThrow48;
                mkBook.setIs_fatten(cursorQuery.getInt(i44));
                columnIndexOrThrow48 = i44;
                int i45 = columnIndexOrThrow49;
                mkBook.setFatten_num(cursorQuery.getInt(i45));
                int i46 = columnIndexOrThrow2;
                int i47 = columnIndexOrThrow50;
                int i48 = columnIndexOrThrow3;
                mkBook.setReading_datetime(cursorQuery.getLong(i47));
                int i49 = columnIndexOrThrow51;
                mkBook.setReading_chapter_key(cursorQuery.getInt(i49));
                int i50 = columnIndexOrThrow52;
                if (cursorQuery.isNull(i50)) {
                    i6 = i45;
                    string19 = null;
                } else {
                    i6 = i45;
                    string19 = cursorQuery.getString(i50);
                }
                mkBook.setLast_read_chapterName(string19);
                int i51 = columnIndexOrThrow53;
                mkBook.setRead_begin(cursorQuery.getInt(i51));
                int i52 = columnIndexOrThrow54;
                if (cursorQuery.isNull(i52)) {
                    i7 = i51;
                    string20 = null;
                } else {
                    i7 = i51;
                    string20 = cursorQuery.getString(i52);
                }
                mkBook.setReading_chapter_path(string20);
                int i53 = columnIndexOrThrow13;
                int i54 = columnIndexOrThrow55;
                mkBook.setReload_updated_at(cursorQuery.getLong(i54));
                int i55 = columnIndexOrThrow56;
                mkBook.setUpdated(cursorQuery.getInt(i55));
                arrayList2.add(mkBook);
                columnIndexOrThrow56 = i55;
                arrayList = arrayList2;
                columnIndexOrThrow13 = i53;
                columnIndexOrThrow53 = i7;
                columnIndexOrThrow54 = i52;
                columnIndexOrThrow55 = i54;
                columnIndexOrThrow = i10;
                i8 = i9;
                columnIndexOrThrow15 = i3;
                columnIndexOrThrow51 = i49;
                columnIndexOrThrow2 = i46;
                columnIndexOrThrow49 = i6;
                columnIndexOrThrow52 = i50;
                columnIndexOrThrow3 = i48;
                columnIndexOrThrow50 = i47;
                int i56 = i4;
                columnIndexOrThrow21 = i17;
                columnIndexOrThrow20 = i56;
                int i57 = i5;
                columnIndexOrThrow38 = i34;
                columnIndexOrThrow37 = i57;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public MkBook i(int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        MkBook mkBook;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkBook where book_id = ? ", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "refreshtime");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_crawler_book_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vertical_top");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_id");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_path");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "site_path_reload");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_count");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score_number");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_reload_path");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "crawl_book_id");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_status");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_today_time");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_1");
                int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_2");
                int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_3");
                int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_4");
                int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_5");
                int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_6");
                int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_shelf_category");
                int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comic_source");
                int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_1");
                int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_2");
                int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_3");
                int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_4");
                int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_5");
                int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_6");
                int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteName");
                int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top");
                int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_fatten");
                int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fatten_num");
                int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_datetime");
                int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_key");
                int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_read_chapterName");
                int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "read_begin");
                int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_path");
                int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reload_updated_at");
                int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated");
                if (cursorQuery.moveToFirst()) {
                    mkBook = new MkBook();
                    mkBook.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                    mkBook.setBook_id(cursorQuery.getInt(columnIndexOrThrow2));
                    mkBook.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    mkBook.setAuthor(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    mkBook.setForm(cursorQuery.getInt(columnIndexOrThrow5));
                    mkBook.setImage(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    mkBook.setLtype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    mkBook.setStype(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    mkBook.setStatus(cursorQuery.getInt(columnIndexOrThrow9));
                    mkBook.setRefreshtime(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    mkBook.setFav_count(cursorQuery.getInt(columnIndexOrThrow11));
                    mkBook.setComment_number(cursorQuery.getInt(columnIndexOrThrow12));
                    mkBook.setLast_chapter_name(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    mkBook.setLast_crawler_book_id(cursorQuery.getInt(columnIndexOrThrow14));
                    mkBook.setUpdated_at(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    mkBook.setVertical_top(cursorQuery.getInt(columnIndexOrThrow16));
                    mkBook.setWords_number(cursorQuery.getInt(columnIndexOrThrow17));
                    mkBook.setList_path(cursorQuery.isNull(columnIndexOrThrow18) ? null : cursorQuery.getString(columnIndexOrThrow18));
                    mkBook.setList_reload_path(cursorQuery.isNull(columnIndexOrThrow19) ? null : cursorQuery.getString(columnIndexOrThrow19));
                    mkBook.setChapter_count(cursorQuery.getInt(columnIndexOrThrow20));
                    mkBook.setReading_site_id(cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21));
                    mkBook.setReading_site_path(cursorQuery.isNull(columnIndexOrThrow22) ? null : cursorQuery.getString(columnIndexOrThrow22));
                    mkBook.setSite_path_reload(cursorQuery.isNull(columnIndexOrThrow23) ? null : cursorQuery.getString(columnIndexOrThrow23));
                    mkBook.setScore(cursorQuery.isNull(columnIndexOrThrow24) ? null : cursorQuery.getString(columnIndexOrThrow24));
                    mkBook.setView_count(cursorQuery.getInt(columnIndexOrThrow25));
                    mkBook.setScore_number(cursorQuery.getInt(columnIndexOrThrow26));
                    mkBook.setReading_site_reload_path(cursorQuery.isNull(columnIndexOrThrow27) ? null : cursorQuery.getString(columnIndexOrThrow27));
                    mkBook.setCrawl_book_id(cursorQuery.getInt(columnIndexOrThrow28));
                    mkBook.setJpush_status(cursorQuery.getInt(columnIndexOrThrow29));
                    mkBook.setJpush_today_time(cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30));
                    mkBook.setBg_color(cursorQuery.getInt(columnIndexOrThrow31));
                    mkBook.setBook_int_filed_1(cursorQuery.getInt(columnIndexOrThrow32));
                    mkBook.setBook_int_filed_2(cursorQuery.getInt(columnIndexOrThrow33));
                    mkBook.setBook_int_filed_3(cursorQuery.getInt(columnIndexOrThrow34));
                    mkBook.setBook_int_filed_4(cursorQuery.getInt(columnIndexOrThrow35));
                    mkBook.setBook_int_filed_5(cursorQuery.getInt(columnIndexOrThrow36));
                    mkBook.setBook_int_filed_6(cursorQuery.getInt(columnIndexOrThrow37));
                    mkBook.setBook_shelf_category(cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getString(columnIndexOrThrow38));
                    mkBook.setComic_source(cursorQuery.isNull(columnIndexOrThrow39) ? null : cursorQuery.getString(columnIndexOrThrow39));
                    mkBook.setBook_text_filed_1(cursorQuery.isNull(columnIndexOrThrow40) ? null : cursorQuery.getString(columnIndexOrThrow40));
                    mkBook.setBook_text_filed_2(cursorQuery.isNull(columnIndexOrThrow41) ? null : cursorQuery.getString(columnIndexOrThrow41));
                    mkBook.setBook_text_filed_3(cursorQuery.isNull(columnIndexOrThrow42) ? null : cursorQuery.getString(columnIndexOrThrow42));
                    mkBook.setBook_text_filed_4(cursorQuery.isNull(columnIndexOrThrow43) ? null : cursorQuery.getString(columnIndexOrThrow43));
                    mkBook.setBook_text_filed_5(cursorQuery.isNull(columnIndexOrThrow44) ? null : cursorQuery.getString(columnIndexOrThrow44));
                    mkBook.setBook_text_filed_6(cursorQuery.isNull(columnIndexOrThrow45) ? null : cursorQuery.getString(columnIndexOrThrow45));
                    mkBook.setSiteName(cursorQuery.isNull(columnIndexOrThrow46) ? null : cursorQuery.getString(columnIndexOrThrow46));
                    mkBook.setIs_top(cursorQuery.getInt(columnIndexOrThrow47));
                    mkBook.setIs_fatten(cursorQuery.getInt(columnIndexOrThrow48));
                    mkBook.setFatten_num(cursorQuery.getInt(columnIndexOrThrow49));
                    mkBook.setReading_datetime(cursorQuery.getLong(columnIndexOrThrow50));
                    mkBook.setReading_chapter_key(cursorQuery.getInt(columnIndexOrThrow51));
                    mkBook.setLast_read_chapterName(cursorQuery.isNull(columnIndexOrThrow52) ? null : cursorQuery.getString(columnIndexOrThrow52));
                    mkBook.setRead_begin(cursorQuery.getInt(columnIndexOrThrow53));
                    mkBook.setReading_chapter_path(cursorQuery.isNull(columnIndexOrThrow54) ? null : cursorQuery.getString(columnIndexOrThrow54));
                    mkBook.setReload_updated_at(cursorQuery.getLong(columnIndexOrThrow55));
                    mkBook.setUpdated(cursorQuery.getInt(columnIndexOrThrow56));
                } else {
                    mkBook = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return mkBook;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public List<MkBook> j(int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i3;
        String string;
        String string2;
        String string3;
        int i4;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i5;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        int i6;
        String string19;
        int i7;
        String string20;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkBook  WHERE is_fatten ==1 and form =? ORDER BY is_top DESC ,updated_at DESC", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "refreshtime");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_crawler_book_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vertical_top");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_path");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "site_path_reload");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_count");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score_number");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_reload_path");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "crawl_book_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_status");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_today_time");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_1");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_2");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_3");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_4");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_5");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_6");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_shelf_category");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comic_source");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_1");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_2");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_3");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_4");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_5");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_6");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteName");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_fatten");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fatten_num");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_datetime");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_key");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_read_chapterName");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "read_begin");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_path");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reload_updated_at");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated");
            int i8 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MkBook mkBook = new MkBook();
                ArrayList arrayList2 = arrayList;
                mkBook.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                mkBook.setBook_id(cursorQuery.getInt(columnIndexOrThrow2));
                mkBook.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                mkBook.setAuthor(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                mkBook.setForm(cursorQuery.getInt(columnIndexOrThrow5));
                mkBook.setImage(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                mkBook.setLtype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                mkBook.setStype(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                mkBook.setStatus(cursorQuery.getInt(columnIndexOrThrow9));
                mkBook.setRefreshtime(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                mkBook.setFav_count(cursorQuery.getInt(columnIndexOrThrow11));
                mkBook.setComment_number(cursorQuery.getInt(columnIndexOrThrow12));
                mkBook.setLast_chapter_name(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i9 = i8;
                int i10 = columnIndexOrThrow;
                mkBook.setLast_crawler_book_id(cursorQuery.getInt(i9));
                int i11 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i11)) {
                    i3 = i11;
                    string = null;
                } else {
                    i3 = i11;
                    string = cursorQuery.getString(i11);
                }
                mkBook.setUpdated_at(string);
                int i12 = columnIndexOrThrow16;
                mkBook.setVertical_top(cursorQuery.getInt(i12));
                columnIndexOrThrow16 = i12;
                int i13 = columnIndexOrThrow17;
                mkBook.setWords_number(cursorQuery.getInt(i13));
                int i14 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i14)) {
                    columnIndexOrThrow18 = i14;
                    string2 = null;
                } else {
                    columnIndexOrThrow18 = i14;
                    string2 = cursorQuery.getString(i14);
                }
                mkBook.setList_path(string2);
                int i15 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i15)) {
                    columnIndexOrThrow19 = i15;
                    string3 = null;
                } else {
                    columnIndexOrThrow19 = i15;
                    string3 = cursorQuery.getString(i15);
                }
                mkBook.setList_reload_path(string3);
                columnIndexOrThrow17 = i13;
                int i16 = columnIndexOrThrow20;
                mkBook.setChapter_count(cursorQuery.getInt(i16));
                int i17 = columnIndexOrThrow21;
                if (cursorQuery.isNull(i17)) {
                    i4 = i16;
                    string4 = null;
                } else {
                    i4 = i16;
                    string4 = cursorQuery.getString(i17);
                }
                mkBook.setReading_site_id(string4);
                int i18 = columnIndexOrThrow22;
                if (cursorQuery.isNull(i18)) {
                    columnIndexOrThrow22 = i18;
                    string5 = null;
                } else {
                    columnIndexOrThrow22 = i18;
                    string5 = cursorQuery.getString(i18);
                }
                mkBook.setReading_site_path(string5);
                int i19 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i19)) {
                    columnIndexOrThrow23 = i19;
                    string6 = null;
                } else {
                    columnIndexOrThrow23 = i19;
                    string6 = cursorQuery.getString(i19);
                }
                mkBook.setSite_path_reload(string6);
                int i20 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i20)) {
                    columnIndexOrThrow24 = i20;
                    string7 = null;
                } else {
                    columnIndexOrThrow24 = i20;
                    string7 = cursorQuery.getString(i20);
                }
                mkBook.setScore(string7);
                int i21 = columnIndexOrThrow25;
                mkBook.setView_count(cursorQuery.getInt(i21));
                columnIndexOrThrow25 = i21;
                int i22 = columnIndexOrThrow26;
                mkBook.setScore_number(cursorQuery.getInt(i22));
                int i23 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i23)) {
                    columnIndexOrThrow27 = i23;
                    string8 = null;
                } else {
                    columnIndexOrThrow27 = i23;
                    string8 = cursorQuery.getString(i23);
                }
                mkBook.setReading_site_reload_path(string8);
                columnIndexOrThrow26 = i22;
                int i24 = columnIndexOrThrow28;
                mkBook.setCrawl_book_id(cursorQuery.getInt(i24));
                columnIndexOrThrow28 = i24;
                int i25 = columnIndexOrThrow29;
                mkBook.setJpush_status(cursorQuery.getInt(i25));
                int i26 = columnIndexOrThrow30;
                if (cursorQuery.isNull(i26)) {
                    columnIndexOrThrow30 = i26;
                    string9 = null;
                } else {
                    columnIndexOrThrow30 = i26;
                    string9 = cursorQuery.getString(i26);
                }
                mkBook.setJpush_today_time(string9);
                columnIndexOrThrow29 = i25;
                int i27 = columnIndexOrThrow31;
                mkBook.setBg_color(cursorQuery.getInt(i27));
                columnIndexOrThrow31 = i27;
                int i28 = columnIndexOrThrow32;
                mkBook.setBook_int_filed_1(cursorQuery.getInt(i28));
                columnIndexOrThrow32 = i28;
                int i29 = columnIndexOrThrow33;
                mkBook.setBook_int_filed_2(cursorQuery.getInt(i29));
                columnIndexOrThrow33 = i29;
                int i30 = columnIndexOrThrow34;
                mkBook.setBook_int_filed_3(cursorQuery.getInt(i30));
                columnIndexOrThrow34 = i30;
                int i31 = columnIndexOrThrow35;
                mkBook.setBook_int_filed_4(cursorQuery.getInt(i31));
                columnIndexOrThrow35 = i31;
                int i32 = columnIndexOrThrow36;
                mkBook.setBook_int_filed_5(cursorQuery.getInt(i32));
                columnIndexOrThrow36 = i32;
                int i33 = columnIndexOrThrow37;
                mkBook.setBook_int_filed_6(cursorQuery.getInt(i33));
                int i34 = columnIndexOrThrow38;
                if (cursorQuery.isNull(i34)) {
                    i5 = i33;
                    string10 = null;
                } else {
                    i5 = i33;
                    string10 = cursorQuery.getString(i34);
                }
                mkBook.setBook_shelf_category(string10);
                int i35 = columnIndexOrThrow39;
                if (cursorQuery.isNull(i35)) {
                    columnIndexOrThrow39 = i35;
                    string11 = null;
                } else {
                    columnIndexOrThrow39 = i35;
                    string11 = cursorQuery.getString(i35);
                }
                mkBook.setComic_source(string11);
                int i36 = columnIndexOrThrow40;
                if (cursorQuery.isNull(i36)) {
                    columnIndexOrThrow40 = i36;
                    string12 = null;
                } else {
                    columnIndexOrThrow40 = i36;
                    string12 = cursorQuery.getString(i36);
                }
                mkBook.setBook_text_filed_1(string12);
                int i37 = columnIndexOrThrow41;
                if (cursorQuery.isNull(i37)) {
                    columnIndexOrThrow41 = i37;
                    string13 = null;
                } else {
                    columnIndexOrThrow41 = i37;
                    string13 = cursorQuery.getString(i37);
                }
                mkBook.setBook_text_filed_2(string13);
                int i38 = columnIndexOrThrow42;
                if (cursorQuery.isNull(i38)) {
                    columnIndexOrThrow42 = i38;
                    string14 = null;
                } else {
                    columnIndexOrThrow42 = i38;
                    string14 = cursorQuery.getString(i38);
                }
                mkBook.setBook_text_filed_3(string14);
                int i39 = columnIndexOrThrow43;
                if (cursorQuery.isNull(i39)) {
                    columnIndexOrThrow43 = i39;
                    string15 = null;
                } else {
                    columnIndexOrThrow43 = i39;
                    string15 = cursorQuery.getString(i39);
                }
                mkBook.setBook_text_filed_4(string15);
                int i40 = columnIndexOrThrow44;
                if (cursorQuery.isNull(i40)) {
                    columnIndexOrThrow44 = i40;
                    string16 = null;
                } else {
                    columnIndexOrThrow44 = i40;
                    string16 = cursorQuery.getString(i40);
                }
                mkBook.setBook_text_filed_5(string16);
                int i41 = columnIndexOrThrow45;
                if (cursorQuery.isNull(i41)) {
                    columnIndexOrThrow45 = i41;
                    string17 = null;
                } else {
                    columnIndexOrThrow45 = i41;
                    string17 = cursorQuery.getString(i41);
                }
                mkBook.setBook_text_filed_6(string17);
                int i42 = columnIndexOrThrow46;
                if (cursorQuery.isNull(i42)) {
                    columnIndexOrThrow46 = i42;
                    string18 = null;
                } else {
                    columnIndexOrThrow46 = i42;
                    string18 = cursorQuery.getString(i42);
                }
                mkBook.setSiteName(string18);
                int i43 = columnIndexOrThrow47;
                mkBook.setIs_top(cursorQuery.getInt(i43));
                columnIndexOrThrow47 = i43;
                int i44 = columnIndexOrThrow48;
                mkBook.setIs_fatten(cursorQuery.getInt(i44));
                columnIndexOrThrow48 = i44;
                int i45 = columnIndexOrThrow49;
                mkBook.setFatten_num(cursorQuery.getInt(i45));
                int i46 = columnIndexOrThrow2;
                int i47 = columnIndexOrThrow50;
                int i48 = columnIndexOrThrow3;
                mkBook.setReading_datetime(cursorQuery.getLong(i47));
                int i49 = columnIndexOrThrow51;
                mkBook.setReading_chapter_key(cursorQuery.getInt(i49));
                int i50 = columnIndexOrThrow52;
                if (cursorQuery.isNull(i50)) {
                    i6 = i45;
                    string19 = null;
                } else {
                    i6 = i45;
                    string19 = cursorQuery.getString(i50);
                }
                mkBook.setLast_read_chapterName(string19);
                int i51 = columnIndexOrThrow53;
                mkBook.setRead_begin(cursorQuery.getInt(i51));
                int i52 = columnIndexOrThrow54;
                if (cursorQuery.isNull(i52)) {
                    i7 = i51;
                    string20 = null;
                } else {
                    i7 = i51;
                    string20 = cursorQuery.getString(i52);
                }
                mkBook.setReading_chapter_path(string20);
                int i53 = columnIndexOrThrow13;
                int i54 = columnIndexOrThrow55;
                mkBook.setReload_updated_at(cursorQuery.getLong(i54));
                int i55 = columnIndexOrThrow56;
                mkBook.setUpdated(cursorQuery.getInt(i55));
                arrayList2.add(mkBook);
                columnIndexOrThrow56 = i55;
                arrayList = arrayList2;
                columnIndexOrThrow13 = i53;
                columnIndexOrThrow53 = i7;
                columnIndexOrThrow54 = i52;
                columnIndexOrThrow55 = i54;
                columnIndexOrThrow = i10;
                i8 = i9;
                columnIndexOrThrow15 = i3;
                columnIndexOrThrow51 = i49;
                columnIndexOrThrow2 = i46;
                columnIndexOrThrow49 = i6;
                columnIndexOrThrow52 = i50;
                columnIndexOrThrow3 = i48;
                columnIndexOrThrow50 = i47;
                int i56 = i4;
                columnIndexOrThrow21 = i17;
                columnIndexOrThrow20 = i56;
                int i57 = i5;
                columnIndexOrThrow38 = i34;
                columnIndexOrThrow37 = i57;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int k(int i2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*)  FROM MkBook   where is_fatten >=1 and form=?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void c(int i2, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3635i.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i3);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3635i.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int d(int i2, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.D.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i3);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.D.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void f(int i2, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3643q.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i3);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3643q.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void b(int i2, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3648v.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i3);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3648v.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public List<MkBook> c() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i2;
        String string;
        String string2;
        String string3;
        int i3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i4;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        int i5;
        String string19;
        int i6;
        String string20;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkBook  ORDER BY is_top DESC ,reading_datetime DESC ", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "refreshtime");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_crawler_book_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vertical_top");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_path");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "site_path_reload");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_count");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score_number");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_reload_path");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "crawl_book_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_status");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_today_time");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_1");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_2");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_3");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_4");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_5");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_6");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_shelf_category");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comic_source");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_1");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_2");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_3");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_4");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_5");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_6");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteName");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_fatten");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fatten_num");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_datetime");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_key");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_read_chapterName");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "read_begin");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_path");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reload_updated_at");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated");
            int i7 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MkBook mkBook = new MkBook();
                ArrayList arrayList2 = arrayList;
                mkBook.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                mkBook.setBook_id(cursorQuery.getInt(columnIndexOrThrow2));
                mkBook.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                mkBook.setAuthor(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                mkBook.setForm(cursorQuery.getInt(columnIndexOrThrow5));
                mkBook.setImage(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                mkBook.setLtype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                mkBook.setStype(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                mkBook.setStatus(cursorQuery.getInt(columnIndexOrThrow9));
                mkBook.setRefreshtime(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                mkBook.setFav_count(cursorQuery.getInt(columnIndexOrThrow11));
                mkBook.setComment_number(cursorQuery.getInt(columnIndexOrThrow12));
                mkBook.setLast_chapter_name(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i8 = i7;
                int i9 = columnIndexOrThrow;
                mkBook.setLast_crawler_book_id(cursorQuery.getInt(i8));
                int i10 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i10)) {
                    i2 = i10;
                    string = null;
                } else {
                    i2 = i10;
                    string = cursorQuery.getString(i10);
                }
                mkBook.setUpdated_at(string);
                int i11 = columnIndexOrThrow16;
                mkBook.setVertical_top(cursorQuery.getInt(i11));
                columnIndexOrThrow16 = i11;
                int i12 = columnIndexOrThrow17;
                mkBook.setWords_number(cursorQuery.getInt(i12));
                int i13 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i13)) {
                    columnIndexOrThrow18 = i13;
                    string2 = null;
                } else {
                    columnIndexOrThrow18 = i13;
                    string2 = cursorQuery.getString(i13);
                }
                mkBook.setList_path(string2);
                int i14 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i14)) {
                    columnIndexOrThrow19 = i14;
                    string3 = null;
                } else {
                    columnIndexOrThrow19 = i14;
                    string3 = cursorQuery.getString(i14);
                }
                mkBook.setList_reload_path(string3);
                columnIndexOrThrow17 = i12;
                int i15 = columnIndexOrThrow20;
                mkBook.setChapter_count(cursorQuery.getInt(i15));
                int i16 = columnIndexOrThrow21;
                if (cursorQuery.isNull(i16)) {
                    i3 = i15;
                    string4 = null;
                } else {
                    i3 = i15;
                    string4 = cursorQuery.getString(i16);
                }
                mkBook.setReading_site_id(string4);
                int i17 = columnIndexOrThrow22;
                if (cursorQuery.isNull(i17)) {
                    columnIndexOrThrow22 = i17;
                    string5 = null;
                } else {
                    columnIndexOrThrow22 = i17;
                    string5 = cursorQuery.getString(i17);
                }
                mkBook.setReading_site_path(string5);
                int i18 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i18)) {
                    columnIndexOrThrow23 = i18;
                    string6 = null;
                } else {
                    columnIndexOrThrow23 = i18;
                    string6 = cursorQuery.getString(i18);
                }
                mkBook.setSite_path_reload(string6);
                int i19 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i19)) {
                    columnIndexOrThrow24 = i19;
                    string7 = null;
                } else {
                    columnIndexOrThrow24 = i19;
                    string7 = cursorQuery.getString(i19);
                }
                mkBook.setScore(string7);
                int i20 = columnIndexOrThrow25;
                mkBook.setView_count(cursorQuery.getInt(i20));
                columnIndexOrThrow25 = i20;
                int i21 = columnIndexOrThrow26;
                mkBook.setScore_number(cursorQuery.getInt(i21));
                int i22 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i22)) {
                    columnIndexOrThrow27 = i22;
                    string8 = null;
                } else {
                    columnIndexOrThrow27 = i22;
                    string8 = cursorQuery.getString(i22);
                }
                mkBook.setReading_site_reload_path(string8);
                columnIndexOrThrow26 = i21;
                int i23 = columnIndexOrThrow28;
                mkBook.setCrawl_book_id(cursorQuery.getInt(i23));
                columnIndexOrThrow28 = i23;
                int i24 = columnIndexOrThrow29;
                mkBook.setJpush_status(cursorQuery.getInt(i24));
                int i25 = columnIndexOrThrow30;
                if (cursorQuery.isNull(i25)) {
                    columnIndexOrThrow30 = i25;
                    string9 = null;
                } else {
                    columnIndexOrThrow30 = i25;
                    string9 = cursorQuery.getString(i25);
                }
                mkBook.setJpush_today_time(string9);
                columnIndexOrThrow29 = i24;
                int i26 = columnIndexOrThrow31;
                mkBook.setBg_color(cursorQuery.getInt(i26));
                columnIndexOrThrow31 = i26;
                int i27 = columnIndexOrThrow32;
                mkBook.setBook_int_filed_1(cursorQuery.getInt(i27));
                columnIndexOrThrow32 = i27;
                int i28 = columnIndexOrThrow33;
                mkBook.setBook_int_filed_2(cursorQuery.getInt(i28));
                columnIndexOrThrow33 = i28;
                int i29 = columnIndexOrThrow34;
                mkBook.setBook_int_filed_3(cursorQuery.getInt(i29));
                columnIndexOrThrow34 = i29;
                int i30 = columnIndexOrThrow35;
                mkBook.setBook_int_filed_4(cursorQuery.getInt(i30));
                columnIndexOrThrow35 = i30;
                int i31 = columnIndexOrThrow36;
                mkBook.setBook_int_filed_5(cursorQuery.getInt(i31));
                columnIndexOrThrow36 = i31;
                int i32 = columnIndexOrThrow37;
                mkBook.setBook_int_filed_6(cursorQuery.getInt(i32));
                int i33 = columnIndexOrThrow38;
                if (cursorQuery.isNull(i33)) {
                    i4 = i32;
                    string10 = null;
                } else {
                    i4 = i32;
                    string10 = cursorQuery.getString(i33);
                }
                mkBook.setBook_shelf_category(string10);
                int i34 = columnIndexOrThrow39;
                if (cursorQuery.isNull(i34)) {
                    columnIndexOrThrow39 = i34;
                    string11 = null;
                } else {
                    columnIndexOrThrow39 = i34;
                    string11 = cursorQuery.getString(i34);
                }
                mkBook.setComic_source(string11);
                int i35 = columnIndexOrThrow40;
                if (cursorQuery.isNull(i35)) {
                    columnIndexOrThrow40 = i35;
                    string12 = null;
                } else {
                    columnIndexOrThrow40 = i35;
                    string12 = cursorQuery.getString(i35);
                }
                mkBook.setBook_text_filed_1(string12);
                int i36 = columnIndexOrThrow41;
                if (cursorQuery.isNull(i36)) {
                    columnIndexOrThrow41 = i36;
                    string13 = null;
                } else {
                    columnIndexOrThrow41 = i36;
                    string13 = cursorQuery.getString(i36);
                }
                mkBook.setBook_text_filed_2(string13);
                int i37 = columnIndexOrThrow42;
                if (cursorQuery.isNull(i37)) {
                    columnIndexOrThrow42 = i37;
                    string14 = null;
                } else {
                    columnIndexOrThrow42 = i37;
                    string14 = cursorQuery.getString(i37);
                }
                mkBook.setBook_text_filed_3(string14);
                int i38 = columnIndexOrThrow43;
                if (cursorQuery.isNull(i38)) {
                    columnIndexOrThrow43 = i38;
                    string15 = null;
                } else {
                    columnIndexOrThrow43 = i38;
                    string15 = cursorQuery.getString(i38);
                }
                mkBook.setBook_text_filed_4(string15);
                int i39 = columnIndexOrThrow44;
                if (cursorQuery.isNull(i39)) {
                    columnIndexOrThrow44 = i39;
                    string16 = null;
                } else {
                    columnIndexOrThrow44 = i39;
                    string16 = cursorQuery.getString(i39);
                }
                mkBook.setBook_text_filed_5(string16);
                int i40 = columnIndexOrThrow45;
                if (cursorQuery.isNull(i40)) {
                    columnIndexOrThrow45 = i40;
                    string17 = null;
                } else {
                    columnIndexOrThrow45 = i40;
                    string17 = cursorQuery.getString(i40);
                }
                mkBook.setBook_text_filed_6(string17);
                int i41 = columnIndexOrThrow46;
                if (cursorQuery.isNull(i41)) {
                    columnIndexOrThrow46 = i41;
                    string18 = null;
                } else {
                    columnIndexOrThrow46 = i41;
                    string18 = cursorQuery.getString(i41);
                }
                mkBook.setSiteName(string18);
                int i42 = columnIndexOrThrow47;
                mkBook.setIs_top(cursorQuery.getInt(i42));
                columnIndexOrThrow47 = i42;
                int i43 = columnIndexOrThrow48;
                mkBook.setIs_fatten(cursorQuery.getInt(i43));
                columnIndexOrThrow48 = i43;
                int i44 = columnIndexOrThrow49;
                mkBook.setFatten_num(cursorQuery.getInt(i44));
                int i45 = columnIndexOrThrow2;
                int i46 = columnIndexOrThrow50;
                int i47 = columnIndexOrThrow13;
                mkBook.setReading_datetime(cursorQuery.getLong(i46));
                int i48 = columnIndexOrThrow51;
                mkBook.setReading_chapter_key(cursorQuery.getInt(i48));
                int i49 = columnIndexOrThrow52;
                if (cursorQuery.isNull(i49)) {
                    i5 = i44;
                    string19 = null;
                } else {
                    i5 = i44;
                    string19 = cursorQuery.getString(i49);
                }
                mkBook.setLast_read_chapterName(string19);
                int i50 = columnIndexOrThrow53;
                mkBook.setRead_begin(cursorQuery.getInt(i50));
                int i51 = columnIndexOrThrow54;
                if (cursorQuery.isNull(i51)) {
                    i6 = i50;
                    string20 = null;
                } else {
                    i6 = i50;
                    string20 = cursorQuery.getString(i51);
                }
                mkBook.setReading_chapter_path(string20);
                int i52 = columnIndexOrThrow55;
                mkBook.setReload_updated_at(cursorQuery.getLong(i52));
                int i53 = columnIndexOrThrow56;
                mkBook.setUpdated(cursorQuery.getInt(i53));
                arrayList2.add(mkBook);
                columnIndexOrThrow56 = i53;
                columnIndexOrThrow13 = i47;
                columnIndexOrThrow50 = i46;
                columnIndexOrThrow51 = i48;
                columnIndexOrThrow53 = i6;
                columnIndexOrThrow54 = i51;
                arrayList = arrayList2;
                columnIndexOrThrow2 = i45;
                columnIndexOrThrow49 = i5;
                columnIndexOrThrow52 = i49;
                columnIndexOrThrow55 = i52;
                columnIndexOrThrow = i9;
                i7 = i8;
                columnIndexOrThrow15 = i2;
                int i54 = i3;
                columnIndexOrThrow21 = i16;
                columnIndexOrThrow20 = i54;
                int i55 = i4;
                columnIndexOrThrow38 = i33;
                columnIndexOrThrow37 = i55;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public LiveData<List<MkBook>> d() {
        return this.a.getInvalidationTracker().createLiveData(new String[]{"MkBook"}, false, new z(RoomSQLiteQuery.acquire("select * from MkBook  ORDER BY is_top DESC ,reading_datetime DESC ", 0)));
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int e(int i2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select count(book_id) from MkBook where form=? ", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public List<String> f(int i2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select image from MkBook  WHERE is_fatten ==1 and form =? ORDER BY is_top DESC ,updated_at DESC", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int b(String str, int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.G.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        supportSQLiteStatementAcquire.bindLong(2, i2);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.G.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public LiveData<MkBook> d(int i2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkBook where book_id = ? ", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        return this.a.getInvalidationTracker().createLiveData(new String[]{"MkBook"}, false, new a0(roomSQLiteQueryAcquire));
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int a(long j2, int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3632f.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j2);
        supportSQLiteStatementAcquire.bindLong(2, i2);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.f3632f.release(supportSQLiteStatementAcquire);
        }
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    @Override // com.amgcyo.cuttadon.database.f
    public List<MkBook> b() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i2;
        String string;
        String string2;
        String string3;
        int i3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i4;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        int i5;
        String string19;
        int i6;
        String string20;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkBook  WHERE jpush_status == 1  ", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "refreshtime");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_crawler_book_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vertical_top");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_path");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "site_path_reload");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_count");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score_number");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_reload_path");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "crawl_book_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_status");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_today_time");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_1");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_2");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_3");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_4");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_5");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_6");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_shelf_category");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comic_source");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_1");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_2");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_3");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_4");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_5");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_6");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteName");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_fatten");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fatten_num");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_datetime");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_key");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_read_chapterName");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "read_begin");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_path");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reload_updated_at");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated");
            int i7 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MkBook mkBook = new MkBook();
                ArrayList arrayList2 = arrayList;
                mkBook.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                mkBook.setBook_id(cursorQuery.getInt(columnIndexOrThrow2));
                mkBook.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                mkBook.setAuthor(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                mkBook.setForm(cursorQuery.getInt(columnIndexOrThrow5));
                mkBook.setImage(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                mkBook.setLtype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                mkBook.setStype(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                mkBook.setStatus(cursorQuery.getInt(columnIndexOrThrow9));
                mkBook.setRefreshtime(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                mkBook.setFav_count(cursorQuery.getInt(columnIndexOrThrow11));
                mkBook.setComment_number(cursorQuery.getInt(columnIndexOrThrow12));
                mkBook.setLast_chapter_name(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i8 = i7;
                int i9 = columnIndexOrThrow;
                mkBook.setLast_crawler_book_id(cursorQuery.getInt(i8));
                int i10 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i10)) {
                    i2 = i10;
                    string = null;
                } else {
                    i2 = i10;
                    string = cursorQuery.getString(i10);
                }
                mkBook.setUpdated_at(string);
                int i11 = columnIndexOrThrow16;
                mkBook.setVertical_top(cursorQuery.getInt(i11));
                columnIndexOrThrow16 = i11;
                int i12 = columnIndexOrThrow17;
                mkBook.setWords_number(cursorQuery.getInt(i12));
                int i13 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i13)) {
                    columnIndexOrThrow18 = i13;
                    string2 = null;
                } else {
                    columnIndexOrThrow18 = i13;
                    string2 = cursorQuery.getString(i13);
                }
                mkBook.setList_path(string2);
                int i14 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i14)) {
                    columnIndexOrThrow19 = i14;
                    string3 = null;
                } else {
                    columnIndexOrThrow19 = i14;
                    string3 = cursorQuery.getString(i14);
                }
                mkBook.setList_reload_path(string3);
                columnIndexOrThrow17 = i12;
                int i15 = columnIndexOrThrow20;
                mkBook.setChapter_count(cursorQuery.getInt(i15));
                int i16 = columnIndexOrThrow21;
                if (cursorQuery.isNull(i16)) {
                    i3 = i15;
                    string4 = null;
                } else {
                    i3 = i15;
                    string4 = cursorQuery.getString(i16);
                }
                mkBook.setReading_site_id(string4);
                int i17 = columnIndexOrThrow22;
                if (cursorQuery.isNull(i17)) {
                    columnIndexOrThrow22 = i17;
                    string5 = null;
                } else {
                    columnIndexOrThrow22 = i17;
                    string5 = cursorQuery.getString(i17);
                }
                mkBook.setReading_site_path(string5);
                int i18 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i18)) {
                    columnIndexOrThrow23 = i18;
                    string6 = null;
                } else {
                    columnIndexOrThrow23 = i18;
                    string6 = cursorQuery.getString(i18);
                }
                mkBook.setSite_path_reload(string6);
                int i19 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i19)) {
                    columnIndexOrThrow24 = i19;
                    string7 = null;
                } else {
                    columnIndexOrThrow24 = i19;
                    string7 = cursorQuery.getString(i19);
                }
                mkBook.setScore(string7);
                int i20 = columnIndexOrThrow25;
                mkBook.setView_count(cursorQuery.getInt(i20));
                columnIndexOrThrow25 = i20;
                int i21 = columnIndexOrThrow26;
                mkBook.setScore_number(cursorQuery.getInt(i21));
                int i22 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i22)) {
                    columnIndexOrThrow27 = i22;
                    string8 = null;
                } else {
                    columnIndexOrThrow27 = i22;
                    string8 = cursorQuery.getString(i22);
                }
                mkBook.setReading_site_reload_path(string8);
                columnIndexOrThrow26 = i21;
                int i23 = columnIndexOrThrow28;
                mkBook.setCrawl_book_id(cursorQuery.getInt(i23));
                columnIndexOrThrow28 = i23;
                int i24 = columnIndexOrThrow29;
                mkBook.setJpush_status(cursorQuery.getInt(i24));
                int i25 = columnIndexOrThrow30;
                if (cursorQuery.isNull(i25)) {
                    columnIndexOrThrow30 = i25;
                    string9 = null;
                } else {
                    columnIndexOrThrow30 = i25;
                    string9 = cursorQuery.getString(i25);
                }
                mkBook.setJpush_today_time(string9);
                columnIndexOrThrow29 = i24;
                int i26 = columnIndexOrThrow31;
                mkBook.setBg_color(cursorQuery.getInt(i26));
                columnIndexOrThrow31 = i26;
                int i27 = columnIndexOrThrow32;
                mkBook.setBook_int_filed_1(cursorQuery.getInt(i27));
                columnIndexOrThrow32 = i27;
                int i28 = columnIndexOrThrow33;
                mkBook.setBook_int_filed_2(cursorQuery.getInt(i28));
                columnIndexOrThrow33 = i28;
                int i29 = columnIndexOrThrow34;
                mkBook.setBook_int_filed_3(cursorQuery.getInt(i29));
                columnIndexOrThrow34 = i29;
                int i30 = columnIndexOrThrow35;
                mkBook.setBook_int_filed_4(cursorQuery.getInt(i30));
                columnIndexOrThrow35 = i30;
                int i31 = columnIndexOrThrow36;
                mkBook.setBook_int_filed_5(cursorQuery.getInt(i31));
                columnIndexOrThrow36 = i31;
                int i32 = columnIndexOrThrow37;
                mkBook.setBook_int_filed_6(cursorQuery.getInt(i32));
                int i33 = columnIndexOrThrow38;
                if (cursorQuery.isNull(i33)) {
                    i4 = i32;
                    string10 = null;
                } else {
                    i4 = i32;
                    string10 = cursorQuery.getString(i33);
                }
                mkBook.setBook_shelf_category(string10);
                int i34 = columnIndexOrThrow39;
                if (cursorQuery.isNull(i34)) {
                    columnIndexOrThrow39 = i34;
                    string11 = null;
                } else {
                    columnIndexOrThrow39 = i34;
                    string11 = cursorQuery.getString(i34);
                }
                mkBook.setComic_source(string11);
                int i35 = columnIndexOrThrow40;
                if (cursorQuery.isNull(i35)) {
                    columnIndexOrThrow40 = i35;
                    string12 = null;
                } else {
                    columnIndexOrThrow40 = i35;
                    string12 = cursorQuery.getString(i35);
                }
                mkBook.setBook_text_filed_1(string12);
                int i36 = columnIndexOrThrow41;
                if (cursorQuery.isNull(i36)) {
                    columnIndexOrThrow41 = i36;
                    string13 = null;
                } else {
                    columnIndexOrThrow41 = i36;
                    string13 = cursorQuery.getString(i36);
                }
                mkBook.setBook_text_filed_2(string13);
                int i37 = columnIndexOrThrow42;
                if (cursorQuery.isNull(i37)) {
                    columnIndexOrThrow42 = i37;
                    string14 = null;
                } else {
                    columnIndexOrThrow42 = i37;
                    string14 = cursorQuery.getString(i37);
                }
                mkBook.setBook_text_filed_3(string14);
                int i38 = columnIndexOrThrow43;
                if (cursorQuery.isNull(i38)) {
                    columnIndexOrThrow43 = i38;
                    string15 = null;
                } else {
                    columnIndexOrThrow43 = i38;
                    string15 = cursorQuery.getString(i38);
                }
                mkBook.setBook_text_filed_4(string15);
                int i39 = columnIndexOrThrow44;
                if (cursorQuery.isNull(i39)) {
                    columnIndexOrThrow44 = i39;
                    string16 = null;
                } else {
                    columnIndexOrThrow44 = i39;
                    string16 = cursorQuery.getString(i39);
                }
                mkBook.setBook_text_filed_5(string16);
                int i40 = columnIndexOrThrow45;
                if (cursorQuery.isNull(i40)) {
                    columnIndexOrThrow45 = i40;
                    string17 = null;
                } else {
                    columnIndexOrThrow45 = i40;
                    string17 = cursorQuery.getString(i40);
                }
                mkBook.setBook_text_filed_6(string17);
                int i41 = columnIndexOrThrow46;
                if (cursorQuery.isNull(i41)) {
                    columnIndexOrThrow46 = i41;
                    string18 = null;
                } else {
                    columnIndexOrThrow46 = i41;
                    string18 = cursorQuery.getString(i41);
                }
                mkBook.setSiteName(string18);
                int i42 = columnIndexOrThrow47;
                mkBook.setIs_top(cursorQuery.getInt(i42));
                columnIndexOrThrow47 = i42;
                int i43 = columnIndexOrThrow48;
                mkBook.setIs_fatten(cursorQuery.getInt(i43));
                columnIndexOrThrow48 = i43;
                int i44 = columnIndexOrThrow49;
                mkBook.setFatten_num(cursorQuery.getInt(i44));
                int i45 = columnIndexOrThrow2;
                int i46 = columnIndexOrThrow50;
                int i47 = columnIndexOrThrow13;
                mkBook.setReading_datetime(cursorQuery.getLong(i46));
                int i48 = columnIndexOrThrow51;
                mkBook.setReading_chapter_key(cursorQuery.getInt(i48));
                int i49 = columnIndexOrThrow52;
                if (cursorQuery.isNull(i49)) {
                    i5 = i44;
                    string19 = null;
                } else {
                    i5 = i44;
                    string19 = cursorQuery.getString(i49);
                }
                mkBook.setLast_read_chapterName(string19);
                int i50 = columnIndexOrThrow53;
                mkBook.setRead_begin(cursorQuery.getInt(i50));
                int i51 = columnIndexOrThrow54;
                if (cursorQuery.isNull(i51)) {
                    i6 = i50;
                    string20 = null;
                } else {
                    i6 = i50;
                    string20 = cursorQuery.getString(i51);
                }
                mkBook.setReading_chapter_path(string20);
                int i52 = columnIndexOrThrow55;
                mkBook.setReload_updated_at(cursorQuery.getLong(i52));
                int i53 = columnIndexOrThrow56;
                mkBook.setUpdated(cursorQuery.getInt(i53));
                arrayList2.add(mkBook);
                columnIndexOrThrow56 = i53;
                columnIndexOrThrow13 = i47;
                columnIndexOrThrow50 = i46;
                columnIndexOrThrow51 = i48;
                columnIndexOrThrow53 = i6;
                columnIndexOrThrow54 = i51;
                arrayList = arrayList2;
                columnIndexOrThrow2 = i45;
                columnIndexOrThrow49 = i5;
                columnIndexOrThrow52 = i49;
                columnIndexOrThrow55 = i52;
                columnIndexOrThrow = i9;
                i7 = i8;
                columnIndexOrThrow15 = i2;
                int i54 = i3;
                columnIndexOrThrow21 = i16;
                columnIndexOrThrow20 = i54;
                int i55 = i4;
                columnIndexOrThrow38 = i33;
                columnIndexOrThrow37 = i55;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int a(String str, int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3636j.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        supportSQLiteStatementAcquire.bindLong(2, i2);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.f3636j.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void a(String str, String str2, String str3, int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3637k.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str2);
        }
        if (str3 == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str3);
        }
        supportSQLiteStatementAcquire.bindLong(4, i2);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3637k.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int a(String str, int i2, int i3, String str2, int i4) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3639m.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        supportSQLiteStatementAcquire.bindLong(2, i2);
        supportSQLiteStatementAcquire.bindLong(3, i3);
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str2);
        }
        supportSQLiteStatementAcquire.bindLong(5, i4);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.f3639m.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void a(String str, int i2, String str2, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3640n.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        supportSQLiteStatementAcquire.bindLong(2, i2);
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str2);
        }
        supportSQLiteStatementAcquire.bindLong(4, i3);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3640n.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void a(String str, String str2, int i2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3646t.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str2);
        }
        supportSQLiteStatementAcquire.bindLong(3, i2);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3646t.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void a(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, int i5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3650x.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str2);
        }
        if (str3 == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str3);
        }
        if (str4 == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str4);
        }
        if (str5 == null) {
            supportSQLiteStatementAcquire.bindNull(5);
        } else {
            supportSQLiteStatementAcquire.bindString(5, str5);
        }
        supportSQLiteStatementAcquire.bindLong(6, i2);
        supportSQLiteStatementAcquire.bindLong(7, i3);
        supportSQLiteStatementAcquire.bindLong(8, i4);
        supportSQLiteStatementAcquire.bindLong(9, i5);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3650x.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void a(String str, String str2, String str3, String str4, String str5, int i2, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3651y.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str2);
        }
        if (str3 == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str3);
        }
        if (str4 == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str4);
        }
        if (str5 == null) {
            supportSQLiteStatementAcquire.bindNull(5);
        } else {
            supportSQLiteStatementAcquire.bindString(5, str5);
        }
        supportSQLiteStatementAcquire.bindLong(6, i2);
        supportSQLiteStatementAcquire.bindLong(7, i3);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3651y.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public void a(String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, int i4, int i5, int i6) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f3652z.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        if (str2 == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str2);
        }
        if (str3 == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, str3);
        }
        if (str4 == null) {
            supportSQLiteStatementAcquire.bindNull(4);
        } else {
            supportSQLiteStatementAcquire.bindString(4, str4);
        }
        if (str5 == null) {
            supportSQLiteStatementAcquire.bindNull(5);
        } else {
            supportSQLiteStatementAcquire.bindString(5, str5);
        }
        if (str6 == null) {
            supportSQLiteStatementAcquire.bindNull(6);
        } else {
            supportSQLiteStatementAcquire.bindString(6, str6);
        }
        supportSQLiteStatementAcquire.bindLong(7, i2);
        supportSQLiteStatementAcquire.bindLong(8, i3);
        supportSQLiteStatementAcquire.bindLong(9, i4);
        supportSQLiteStatementAcquire.bindLong(10, i5);
        supportSQLiteStatementAcquire.bindLong(11, i6);
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f3652z.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int a(int i2, long j2, int i3, int i4, int i5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.A.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i4);
        supportSQLiteStatementAcquire.bindLong(3, i5);
        supportSQLiteStatementAcquire.bindLong(4, j2);
        supportSQLiteStatementAcquire.bindLong(5, i3);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.A.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int g(int i2, int i3) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*)  FROM MkBook   where fatten_num >=? and form=?", 2);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        roomSQLiteQueryAcquire.bindLong(2, i3);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int a(int i2, long j2, int i3, int i4, int i5, int i6, String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.B.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i3);
        supportSQLiteStatementAcquire.bindLong(3, i5);
        supportSQLiteStatementAcquire.bindLong(4, i6);
        supportSQLiteStatementAcquire.bindLong(5, j2);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(6);
        } else {
            supportSQLiteStatementAcquire.bindString(6, str);
        }
        supportSQLiteStatementAcquire.bindLong(7, i4);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.B.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int a(int i2, String str, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.C.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        supportSQLiteStatementAcquire.bindLong(3, i3);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.C.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public List<MkBook> c(int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i3;
        String string;
        String string2;
        String string3;
        int i4;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i5;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        int i6;
        String string19;
        int i7;
        String string20;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkBook    where form=?   ORDER BY is_top DESC ,updated_at ASC", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "refreshtime");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_crawler_book_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vertical_top");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_path");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "site_path_reload");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_count");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score_number");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_reload_path");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "crawl_book_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_status");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_today_time");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_1");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_2");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_3");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_4");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_5");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_6");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_shelf_category");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comic_source");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_1");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_2");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_3");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_4");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_5");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_6");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteName");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_fatten");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fatten_num");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_datetime");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_key");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_read_chapterName");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "read_begin");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_path");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reload_updated_at");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated");
            int i8 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MkBook mkBook = new MkBook();
                ArrayList arrayList2 = arrayList;
                mkBook.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                mkBook.setBook_id(cursorQuery.getInt(columnIndexOrThrow2));
                mkBook.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                mkBook.setAuthor(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                mkBook.setForm(cursorQuery.getInt(columnIndexOrThrow5));
                mkBook.setImage(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                mkBook.setLtype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                mkBook.setStype(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                mkBook.setStatus(cursorQuery.getInt(columnIndexOrThrow9));
                mkBook.setRefreshtime(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                mkBook.setFav_count(cursorQuery.getInt(columnIndexOrThrow11));
                mkBook.setComment_number(cursorQuery.getInt(columnIndexOrThrow12));
                mkBook.setLast_chapter_name(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i9 = i8;
                int i10 = columnIndexOrThrow;
                mkBook.setLast_crawler_book_id(cursorQuery.getInt(i9));
                int i11 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i11)) {
                    i3 = i11;
                    string = null;
                } else {
                    i3 = i11;
                    string = cursorQuery.getString(i11);
                }
                mkBook.setUpdated_at(string);
                int i12 = columnIndexOrThrow16;
                mkBook.setVertical_top(cursorQuery.getInt(i12));
                columnIndexOrThrow16 = i12;
                int i13 = columnIndexOrThrow17;
                mkBook.setWords_number(cursorQuery.getInt(i13));
                int i14 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i14)) {
                    columnIndexOrThrow18 = i14;
                    string2 = null;
                } else {
                    columnIndexOrThrow18 = i14;
                    string2 = cursorQuery.getString(i14);
                }
                mkBook.setList_path(string2);
                int i15 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i15)) {
                    columnIndexOrThrow19 = i15;
                    string3 = null;
                } else {
                    columnIndexOrThrow19 = i15;
                    string3 = cursorQuery.getString(i15);
                }
                mkBook.setList_reload_path(string3);
                columnIndexOrThrow17 = i13;
                int i16 = columnIndexOrThrow20;
                mkBook.setChapter_count(cursorQuery.getInt(i16));
                int i17 = columnIndexOrThrow21;
                if (cursorQuery.isNull(i17)) {
                    i4 = i16;
                    string4 = null;
                } else {
                    i4 = i16;
                    string4 = cursorQuery.getString(i17);
                }
                mkBook.setReading_site_id(string4);
                int i18 = columnIndexOrThrow22;
                if (cursorQuery.isNull(i18)) {
                    columnIndexOrThrow22 = i18;
                    string5 = null;
                } else {
                    columnIndexOrThrow22 = i18;
                    string5 = cursorQuery.getString(i18);
                }
                mkBook.setReading_site_path(string5);
                int i19 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i19)) {
                    columnIndexOrThrow23 = i19;
                    string6 = null;
                } else {
                    columnIndexOrThrow23 = i19;
                    string6 = cursorQuery.getString(i19);
                }
                mkBook.setSite_path_reload(string6);
                int i20 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i20)) {
                    columnIndexOrThrow24 = i20;
                    string7 = null;
                } else {
                    columnIndexOrThrow24 = i20;
                    string7 = cursorQuery.getString(i20);
                }
                mkBook.setScore(string7);
                int i21 = columnIndexOrThrow25;
                mkBook.setView_count(cursorQuery.getInt(i21));
                columnIndexOrThrow25 = i21;
                int i22 = columnIndexOrThrow26;
                mkBook.setScore_number(cursorQuery.getInt(i22));
                int i23 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i23)) {
                    columnIndexOrThrow27 = i23;
                    string8 = null;
                } else {
                    columnIndexOrThrow27 = i23;
                    string8 = cursorQuery.getString(i23);
                }
                mkBook.setReading_site_reload_path(string8);
                columnIndexOrThrow26 = i22;
                int i24 = columnIndexOrThrow28;
                mkBook.setCrawl_book_id(cursorQuery.getInt(i24));
                columnIndexOrThrow28 = i24;
                int i25 = columnIndexOrThrow29;
                mkBook.setJpush_status(cursorQuery.getInt(i25));
                int i26 = columnIndexOrThrow30;
                if (cursorQuery.isNull(i26)) {
                    columnIndexOrThrow30 = i26;
                    string9 = null;
                } else {
                    columnIndexOrThrow30 = i26;
                    string9 = cursorQuery.getString(i26);
                }
                mkBook.setJpush_today_time(string9);
                columnIndexOrThrow29 = i25;
                int i27 = columnIndexOrThrow31;
                mkBook.setBg_color(cursorQuery.getInt(i27));
                columnIndexOrThrow31 = i27;
                int i28 = columnIndexOrThrow32;
                mkBook.setBook_int_filed_1(cursorQuery.getInt(i28));
                columnIndexOrThrow32 = i28;
                int i29 = columnIndexOrThrow33;
                mkBook.setBook_int_filed_2(cursorQuery.getInt(i29));
                columnIndexOrThrow33 = i29;
                int i30 = columnIndexOrThrow34;
                mkBook.setBook_int_filed_3(cursorQuery.getInt(i30));
                columnIndexOrThrow34 = i30;
                int i31 = columnIndexOrThrow35;
                mkBook.setBook_int_filed_4(cursorQuery.getInt(i31));
                columnIndexOrThrow35 = i31;
                int i32 = columnIndexOrThrow36;
                mkBook.setBook_int_filed_5(cursorQuery.getInt(i32));
                columnIndexOrThrow36 = i32;
                int i33 = columnIndexOrThrow37;
                mkBook.setBook_int_filed_6(cursorQuery.getInt(i33));
                int i34 = columnIndexOrThrow38;
                if (cursorQuery.isNull(i34)) {
                    i5 = i33;
                    string10 = null;
                } else {
                    i5 = i33;
                    string10 = cursorQuery.getString(i34);
                }
                mkBook.setBook_shelf_category(string10);
                int i35 = columnIndexOrThrow39;
                if (cursorQuery.isNull(i35)) {
                    columnIndexOrThrow39 = i35;
                    string11 = null;
                } else {
                    columnIndexOrThrow39 = i35;
                    string11 = cursorQuery.getString(i35);
                }
                mkBook.setComic_source(string11);
                int i36 = columnIndexOrThrow40;
                if (cursorQuery.isNull(i36)) {
                    columnIndexOrThrow40 = i36;
                    string12 = null;
                } else {
                    columnIndexOrThrow40 = i36;
                    string12 = cursorQuery.getString(i36);
                }
                mkBook.setBook_text_filed_1(string12);
                int i37 = columnIndexOrThrow41;
                if (cursorQuery.isNull(i37)) {
                    columnIndexOrThrow41 = i37;
                    string13 = null;
                } else {
                    columnIndexOrThrow41 = i37;
                    string13 = cursorQuery.getString(i37);
                }
                mkBook.setBook_text_filed_2(string13);
                int i38 = columnIndexOrThrow42;
                if (cursorQuery.isNull(i38)) {
                    columnIndexOrThrow42 = i38;
                    string14 = null;
                } else {
                    columnIndexOrThrow42 = i38;
                    string14 = cursorQuery.getString(i38);
                }
                mkBook.setBook_text_filed_3(string14);
                int i39 = columnIndexOrThrow43;
                if (cursorQuery.isNull(i39)) {
                    columnIndexOrThrow43 = i39;
                    string15 = null;
                } else {
                    columnIndexOrThrow43 = i39;
                    string15 = cursorQuery.getString(i39);
                }
                mkBook.setBook_text_filed_4(string15);
                int i40 = columnIndexOrThrow44;
                if (cursorQuery.isNull(i40)) {
                    columnIndexOrThrow44 = i40;
                    string16 = null;
                } else {
                    columnIndexOrThrow44 = i40;
                    string16 = cursorQuery.getString(i40);
                }
                mkBook.setBook_text_filed_5(string16);
                int i41 = columnIndexOrThrow45;
                if (cursorQuery.isNull(i41)) {
                    columnIndexOrThrow45 = i41;
                    string17 = null;
                } else {
                    columnIndexOrThrow45 = i41;
                    string17 = cursorQuery.getString(i41);
                }
                mkBook.setBook_text_filed_6(string17);
                int i42 = columnIndexOrThrow46;
                if (cursorQuery.isNull(i42)) {
                    columnIndexOrThrow46 = i42;
                    string18 = null;
                } else {
                    columnIndexOrThrow46 = i42;
                    string18 = cursorQuery.getString(i42);
                }
                mkBook.setSiteName(string18);
                int i43 = columnIndexOrThrow47;
                mkBook.setIs_top(cursorQuery.getInt(i43));
                columnIndexOrThrow47 = i43;
                int i44 = columnIndexOrThrow48;
                mkBook.setIs_fatten(cursorQuery.getInt(i44));
                columnIndexOrThrow48 = i44;
                int i45 = columnIndexOrThrow49;
                mkBook.setFatten_num(cursorQuery.getInt(i45));
                int i46 = columnIndexOrThrow2;
                int i47 = columnIndexOrThrow50;
                int i48 = columnIndexOrThrow3;
                mkBook.setReading_datetime(cursorQuery.getLong(i47));
                int i49 = columnIndexOrThrow51;
                mkBook.setReading_chapter_key(cursorQuery.getInt(i49));
                int i50 = columnIndexOrThrow52;
                if (cursorQuery.isNull(i50)) {
                    i6 = i45;
                    string19 = null;
                } else {
                    i6 = i45;
                    string19 = cursorQuery.getString(i50);
                }
                mkBook.setLast_read_chapterName(string19);
                int i51 = columnIndexOrThrow53;
                mkBook.setRead_begin(cursorQuery.getInt(i51));
                int i52 = columnIndexOrThrow54;
                if (cursorQuery.isNull(i52)) {
                    i7 = i51;
                    string20 = null;
                } else {
                    i7 = i51;
                    string20 = cursorQuery.getString(i52);
                }
                mkBook.setReading_chapter_path(string20);
                int i53 = columnIndexOrThrow13;
                int i54 = columnIndexOrThrow55;
                mkBook.setReload_updated_at(cursorQuery.getLong(i54));
                int i55 = columnIndexOrThrow56;
                mkBook.setUpdated(cursorQuery.getInt(i55));
                arrayList2.add(mkBook);
                columnIndexOrThrow56 = i55;
                arrayList = arrayList2;
                columnIndexOrThrow13 = i53;
                columnIndexOrThrow53 = i7;
                columnIndexOrThrow54 = i52;
                columnIndexOrThrow55 = i54;
                columnIndexOrThrow = i10;
                i8 = i9;
                columnIndexOrThrow15 = i3;
                columnIndexOrThrow51 = i49;
                columnIndexOrThrow2 = i46;
                columnIndexOrThrow49 = i6;
                columnIndexOrThrow52 = i50;
                columnIndexOrThrow3 = i48;
                columnIndexOrThrow50 = i47;
                int i56 = i4;
                columnIndexOrThrow21 = i17;
                columnIndexOrThrow20 = i56;
                int i57 = i5;
                columnIndexOrThrow38 = i34;
                columnIndexOrThrow37 = i57;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int a(int i2, int i3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.E.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i3);
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.E.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public List<MkBook> b(int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i3;
        String string;
        String string2;
        String string3;
        int i4;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i5;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        String string18;
        int i6;
        String string19;
        int i7;
        String string20;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from MkBook WHERE is_fatten ==1 and form =?  ORDER BY is_top DESC ,reading_datetime DESC ", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "art_id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "author");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "form");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, c.C0205c.f10205e);
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ltype");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "stype");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "status");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "refreshtime");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fav_count");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comment_number");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_chapter_name");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_crawler_book_id");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated_at");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "vertical_top");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "words_number");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_path");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "list_reload_path");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "chapter_count");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_id");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_path");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "site_path_reload");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "view_count");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "score_number");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_site_reload_path");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "crawl_book_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_status");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "jpush_today_time");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bg_color");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_1");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_2");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_3");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_4");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_5");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_int_filed_6");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_shelf_category");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "comic_source");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_1");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_2");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_3");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_4");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_5");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "book_text_filed_6");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteName");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_top");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_fatten");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fatten_num");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_datetime");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_key");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "last_read_chapterName");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "read_begin");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reading_chapter_path");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reload_updated_at");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updated");
            int i8 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MkBook mkBook = new MkBook();
                ArrayList arrayList2 = arrayList;
                mkBook.setArt_id(cursorQuery.getInt(columnIndexOrThrow));
                mkBook.setBook_id(cursorQuery.getInt(columnIndexOrThrow2));
                mkBook.setName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                mkBook.setAuthor(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                mkBook.setForm(cursorQuery.getInt(columnIndexOrThrow5));
                mkBook.setImage(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                mkBook.setLtype(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                mkBook.setStype(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                mkBook.setStatus(cursorQuery.getInt(columnIndexOrThrow9));
                mkBook.setRefreshtime(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                mkBook.setFav_count(cursorQuery.getInt(columnIndexOrThrow11));
                mkBook.setComment_number(cursorQuery.getInt(columnIndexOrThrow12));
                mkBook.setLast_chapter_name(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                int i9 = i8;
                int i10 = columnIndexOrThrow;
                mkBook.setLast_crawler_book_id(cursorQuery.getInt(i9));
                int i11 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i11)) {
                    i3 = i11;
                    string = null;
                } else {
                    i3 = i11;
                    string = cursorQuery.getString(i11);
                }
                mkBook.setUpdated_at(string);
                int i12 = columnIndexOrThrow16;
                mkBook.setVertical_top(cursorQuery.getInt(i12));
                columnIndexOrThrow16 = i12;
                int i13 = columnIndexOrThrow17;
                mkBook.setWords_number(cursorQuery.getInt(i13));
                int i14 = columnIndexOrThrow18;
                if (cursorQuery.isNull(i14)) {
                    columnIndexOrThrow18 = i14;
                    string2 = null;
                } else {
                    columnIndexOrThrow18 = i14;
                    string2 = cursorQuery.getString(i14);
                }
                mkBook.setList_path(string2);
                int i15 = columnIndexOrThrow19;
                if (cursorQuery.isNull(i15)) {
                    columnIndexOrThrow19 = i15;
                    string3 = null;
                } else {
                    columnIndexOrThrow19 = i15;
                    string3 = cursorQuery.getString(i15);
                }
                mkBook.setList_reload_path(string3);
                columnIndexOrThrow17 = i13;
                int i16 = columnIndexOrThrow20;
                mkBook.setChapter_count(cursorQuery.getInt(i16));
                int i17 = columnIndexOrThrow21;
                if (cursorQuery.isNull(i17)) {
                    i4 = i16;
                    string4 = null;
                } else {
                    i4 = i16;
                    string4 = cursorQuery.getString(i17);
                }
                mkBook.setReading_site_id(string4);
                int i18 = columnIndexOrThrow22;
                if (cursorQuery.isNull(i18)) {
                    columnIndexOrThrow22 = i18;
                    string5 = null;
                } else {
                    columnIndexOrThrow22 = i18;
                    string5 = cursorQuery.getString(i18);
                }
                mkBook.setReading_site_path(string5);
                int i19 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i19)) {
                    columnIndexOrThrow23 = i19;
                    string6 = null;
                } else {
                    columnIndexOrThrow23 = i19;
                    string6 = cursorQuery.getString(i19);
                }
                mkBook.setSite_path_reload(string6);
                int i20 = columnIndexOrThrow24;
                if (cursorQuery.isNull(i20)) {
                    columnIndexOrThrow24 = i20;
                    string7 = null;
                } else {
                    columnIndexOrThrow24 = i20;
                    string7 = cursorQuery.getString(i20);
                }
                mkBook.setScore(string7);
                int i21 = columnIndexOrThrow25;
                mkBook.setView_count(cursorQuery.getInt(i21));
                columnIndexOrThrow25 = i21;
                int i22 = columnIndexOrThrow26;
                mkBook.setScore_number(cursorQuery.getInt(i22));
                int i23 = columnIndexOrThrow27;
                if (cursorQuery.isNull(i23)) {
                    columnIndexOrThrow27 = i23;
                    string8 = null;
                } else {
                    columnIndexOrThrow27 = i23;
                    string8 = cursorQuery.getString(i23);
                }
                mkBook.setReading_site_reload_path(string8);
                columnIndexOrThrow26 = i22;
                int i24 = columnIndexOrThrow28;
                mkBook.setCrawl_book_id(cursorQuery.getInt(i24));
                columnIndexOrThrow28 = i24;
                int i25 = columnIndexOrThrow29;
                mkBook.setJpush_status(cursorQuery.getInt(i25));
                int i26 = columnIndexOrThrow30;
                if (cursorQuery.isNull(i26)) {
                    columnIndexOrThrow30 = i26;
                    string9 = null;
                } else {
                    columnIndexOrThrow30 = i26;
                    string9 = cursorQuery.getString(i26);
                }
                mkBook.setJpush_today_time(string9);
                columnIndexOrThrow29 = i25;
                int i27 = columnIndexOrThrow31;
                mkBook.setBg_color(cursorQuery.getInt(i27));
                columnIndexOrThrow31 = i27;
                int i28 = columnIndexOrThrow32;
                mkBook.setBook_int_filed_1(cursorQuery.getInt(i28));
                columnIndexOrThrow32 = i28;
                int i29 = columnIndexOrThrow33;
                mkBook.setBook_int_filed_2(cursorQuery.getInt(i29));
                columnIndexOrThrow33 = i29;
                int i30 = columnIndexOrThrow34;
                mkBook.setBook_int_filed_3(cursorQuery.getInt(i30));
                columnIndexOrThrow34 = i30;
                int i31 = columnIndexOrThrow35;
                mkBook.setBook_int_filed_4(cursorQuery.getInt(i31));
                columnIndexOrThrow35 = i31;
                int i32 = columnIndexOrThrow36;
                mkBook.setBook_int_filed_5(cursorQuery.getInt(i32));
                columnIndexOrThrow36 = i32;
                int i33 = columnIndexOrThrow37;
                mkBook.setBook_int_filed_6(cursorQuery.getInt(i33));
                int i34 = columnIndexOrThrow38;
                if (cursorQuery.isNull(i34)) {
                    i5 = i33;
                    string10 = null;
                } else {
                    i5 = i33;
                    string10 = cursorQuery.getString(i34);
                }
                mkBook.setBook_shelf_category(string10);
                int i35 = columnIndexOrThrow39;
                if (cursorQuery.isNull(i35)) {
                    columnIndexOrThrow39 = i35;
                    string11 = null;
                } else {
                    columnIndexOrThrow39 = i35;
                    string11 = cursorQuery.getString(i35);
                }
                mkBook.setComic_source(string11);
                int i36 = columnIndexOrThrow40;
                if (cursorQuery.isNull(i36)) {
                    columnIndexOrThrow40 = i36;
                    string12 = null;
                } else {
                    columnIndexOrThrow40 = i36;
                    string12 = cursorQuery.getString(i36);
                }
                mkBook.setBook_text_filed_1(string12);
                int i37 = columnIndexOrThrow41;
                if (cursorQuery.isNull(i37)) {
                    columnIndexOrThrow41 = i37;
                    string13 = null;
                } else {
                    columnIndexOrThrow41 = i37;
                    string13 = cursorQuery.getString(i37);
                }
                mkBook.setBook_text_filed_2(string13);
                int i38 = columnIndexOrThrow42;
                if (cursorQuery.isNull(i38)) {
                    columnIndexOrThrow42 = i38;
                    string14 = null;
                } else {
                    columnIndexOrThrow42 = i38;
                    string14 = cursorQuery.getString(i38);
                }
                mkBook.setBook_text_filed_3(string14);
                int i39 = columnIndexOrThrow43;
                if (cursorQuery.isNull(i39)) {
                    columnIndexOrThrow43 = i39;
                    string15 = null;
                } else {
                    columnIndexOrThrow43 = i39;
                    string15 = cursorQuery.getString(i39);
                }
                mkBook.setBook_text_filed_4(string15);
                int i40 = columnIndexOrThrow44;
                if (cursorQuery.isNull(i40)) {
                    columnIndexOrThrow44 = i40;
                    string16 = null;
                } else {
                    columnIndexOrThrow44 = i40;
                    string16 = cursorQuery.getString(i40);
                }
                mkBook.setBook_text_filed_5(string16);
                int i41 = columnIndexOrThrow45;
                if (cursorQuery.isNull(i41)) {
                    columnIndexOrThrow45 = i41;
                    string17 = null;
                } else {
                    columnIndexOrThrow45 = i41;
                    string17 = cursorQuery.getString(i41);
                }
                mkBook.setBook_text_filed_6(string17);
                int i42 = columnIndexOrThrow46;
                if (cursorQuery.isNull(i42)) {
                    columnIndexOrThrow46 = i42;
                    string18 = null;
                } else {
                    columnIndexOrThrow46 = i42;
                    string18 = cursorQuery.getString(i42);
                }
                mkBook.setSiteName(string18);
                int i43 = columnIndexOrThrow47;
                mkBook.setIs_top(cursorQuery.getInt(i43));
                columnIndexOrThrow47 = i43;
                int i44 = columnIndexOrThrow48;
                mkBook.setIs_fatten(cursorQuery.getInt(i44));
                columnIndexOrThrow48 = i44;
                int i45 = columnIndexOrThrow49;
                mkBook.setFatten_num(cursorQuery.getInt(i45));
                int i46 = columnIndexOrThrow2;
                int i47 = columnIndexOrThrow50;
                int i48 = columnIndexOrThrow3;
                mkBook.setReading_datetime(cursorQuery.getLong(i47));
                int i49 = columnIndexOrThrow51;
                mkBook.setReading_chapter_key(cursorQuery.getInt(i49));
                int i50 = columnIndexOrThrow52;
                if (cursorQuery.isNull(i50)) {
                    i6 = i45;
                    string19 = null;
                } else {
                    i6 = i45;
                    string19 = cursorQuery.getString(i50);
                }
                mkBook.setLast_read_chapterName(string19);
                int i51 = columnIndexOrThrow53;
                mkBook.setRead_begin(cursorQuery.getInt(i51));
                int i52 = columnIndexOrThrow54;
                if (cursorQuery.isNull(i52)) {
                    i7 = i51;
                    string20 = null;
                } else {
                    i7 = i51;
                    string20 = cursorQuery.getString(i52);
                }
                mkBook.setReading_chapter_path(string20);
                int i53 = columnIndexOrThrow13;
                int i54 = columnIndexOrThrow55;
                mkBook.setReload_updated_at(cursorQuery.getLong(i54));
                int i55 = columnIndexOrThrow56;
                mkBook.setUpdated(cursorQuery.getInt(i55));
                arrayList2.add(mkBook);
                columnIndexOrThrow56 = i55;
                arrayList = arrayList2;
                columnIndexOrThrow13 = i53;
                columnIndexOrThrow53 = i7;
                columnIndexOrThrow54 = i52;
                columnIndexOrThrow55 = i54;
                columnIndexOrThrow = i10;
                i8 = i9;
                columnIndexOrThrow15 = i3;
                columnIndexOrThrow51 = i49;
                columnIndexOrThrow2 = i46;
                columnIndexOrThrow49 = i6;
                columnIndexOrThrow52 = i50;
                columnIndexOrThrow3 = i48;
                columnIndexOrThrow50 = i47;
                int i56 = i4;
                columnIndexOrThrow21 = i17;
                columnIndexOrThrow20 = i56;
                int i57 = i5;
                columnIndexOrThrow38 = i34;
                columnIndexOrThrow37 = i57;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int a() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.F.acquire();
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.F.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.amgcyo.cuttadon.database.f
    public int a(List<Integer> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("delete from MkBook where book_id in (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, list.size());
        sbNewStringBuilder.append(ad.f20406s);
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.a.compileStatement(sbNewStringBuilder.toString());
        Iterator<Integer> it = list.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            if (it.next() == null) {
                supportSQLiteStatementCompileStatement.bindNull(i2);
            } else {
                supportSQLiteStatementCompileStatement.bindLong(i2, r2.intValue());
            }
            i2++;
        }
        this.a.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
        }
    }
}
