package com.amgcyo.cuttadon.adapter.shelf;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.adapter.shelf.MkShelfBookDataItem;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.fragment.books.MkBookshelfFragment;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.widget.ui.RoundProgressWidthNumber;
import com.fatcatfat.io.R;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkShelfBookDataItem extends me.drakeet.multitype.b<MkBook, com.amgcyo.cuttadon.adapter.other.p> {
    private MkBookshelfFragment b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected me.jessyan.art.c.e.c f3107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.amgcyo.cuttadon.g.a f3108d;

    static class BookShelfGridViewHolder extends com.amgcyo.cuttadon.adapter.other.p {

        @BindView(R.id.book_top_icon)
        ImageView book_top_icon;

        @BindView(R.id.fade_cover)
        ImageView fade_cover;

        @BindView(R.id.iv_bookImg_grid)
        ImageView ivBookImgGrid;

        @BindView(R.id.progressBarSmall)
        RoundProgressWidthNumber progressBarSmall;

        @BindView(R.id.rl_item_book_grid)
        LinearLayout rlItemBookGrid;

        @BindView(R.id.shelf_status)
        TextView shelfStatus;

        @BindView(R.id.tv_bookName_grid)
        TextView tvBookNameGrid;

        @BindView(R.id.tv_time_list)
        TextView tvTimeList;

        BookShelfGridViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class BookShelfGridViewHolder_ViewBinding implements Unbinder {
        private BookShelfGridViewHolder a;

        @UiThread
        public BookShelfGridViewHolder_ViewBinding(BookShelfGridViewHolder bookShelfGridViewHolder, View view) {
            this.a = bookShelfGridViewHolder;
            bookShelfGridViewHolder.ivBookImgGrid = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg_grid, "field 'ivBookImgGrid'", ImageView.class);
            bookShelfGridViewHolder.book_top_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.book_top_icon, "field 'book_top_icon'", ImageView.class);
            bookShelfGridViewHolder.tvBookNameGrid = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bookName_grid, "field 'tvBookNameGrid'", TextView.class);
            bookShelfGridViewHolder.tvTimeList = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time_list, "field 'tvTimeList'", TextView.class);
            bookShelfGridViewHolder.shelfStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.shelf_status, "field 'shelfStatus'", TextView.class);
            bookShelfGridViewHolder.rlItemBookGrid = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.rl_item_book_grid, "field 'rlItemBookGrid'", LinearLayout.class);
            bookShelfGridViewHolder.progressBarSmall = (RoundProgressWidthNumber) Utils.findRequiredViewAsType(view, R.id.progressBarSmall, "field 'progressBarSmall'", RoundProgressWidthNumber.class);
            bookShelfGridViewHolder.fade_cover = (ImageView) Utils.findRequiredViewAsType(view, R.id.fade_cover, "field 'fade_cover'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BookShelfGridViewHolder bookShelfGridViewHolder = this.a;
            if (bookShelfGridViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            bookShelfGridViewHolder.ivBookImgGrid = null;
            bookShelfGridViewHolder.book_top_icon = null;
            bookShelfGridViewHolder.tvBookNameGrid = null;
            bookShelfGridViewHolder.tvTimeList = null;
            bookShelfGridViewHolder.shelfStatus = null;
            bookShelfGridViewHolder.rlItemBookGrid = null;
            bookShelfGridViewHolder.progressBarSmall = null;
            bookShelfGridViewHolder.fade_cover = null;
        }
    }

    static class BookShelfListViewHolder extends com.amgcyo.cuttadon.adapter.other.p {

        @BindView(R.id.book_top_icon)
        ImageView book_top_icon;

        @BindView(R.id.card_view)
        LinearLayout cardView;

        @BindView(R.id.fade_cover)
        ImageView fade_cover;

        @BindView(R.id.iv_bookImg)
        ImageView ivBookImg;

        @BindView(R.id.progressBarSmall)
        RoundProgressWidthNumber progressBarSmall;

        @BindView(R.id.rl_item_book)
        RelativeLayout rlItemBook;

        @BindView(R.id.shelf_more)
        ImageView shelf_more;

        @BindView(R.id.tv_bookName)
        TextView tvBookName;

        @BindView(R.id.tv_time_list)
        TextView tvTimeList;

        @BindView(R.id.tv_last_read_chapterName)
        TextView tv_last_read_chapterName;

        @BindView(R.id.tv_status)
        TextView tv_status;

        BookShelfListViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class BookShelfListViewHolder_ViewBinding implements Unbinder {
        private BookShelfListViewHolder a;

        @UiThread
        public BookShelfListViewHolder_ViewBinding(BookShelfListViewHolder bookShelfListViewHolder, View view) {
            this.a = bookShelfListViewHolder;
            bookShelfListViewHolder.ivBookImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg, "field 'ivBookImg'", ImageView.class);
            bookShelfListViewHolder.tvBookName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bookName, "field 'tvBookName'", TextView.class);
            bookShelfListViewHolder.tvTimeList = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time_list, "field 'tvTimeList'", TextView.class);
            bookShelfListViewHolder.tv_status = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_status, "field 'tv_status'", TextView.class);
            bookShelfListViewHolder.tv_last_read_chapterName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_last_read_chapterName, "field 'tv_last_read_chapterName'", TextView.class);
            bookShelfListViewHolder.shelf_more = (ImageView) Utils.findRequiredViewAsType(view, R.id.shelf_more, "field 'shelf_more'", ImageView.class);
            bookShelfListViewHolder.rlItemBook = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_item_book, "field 'rlItemBook'", RelativeLayout.class);
            bookShelfListViewHolder.cardView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.card_view, "field 'cardView'", LinearLayout.class);
            bookShelfListViewHolder.book_top_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.book_top_icon, "field 'book_top_icon'", ImageView.class);
            bookShelfListViewHolder.progressBarSmall = (RoundProgressWidthNumber) Utils.findRequiredViewAsType(view, R.id.progressBarSmall, "field 'progressBarSmall'", RoundProgressWidthNumber.class);
            bookShelfListViewHolder.fade_cover = (ImageView) Utils.findRequiredViewAsType(view, R.id.fade_cover, "field 'fade_cover'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BookShelfListViewHolder bookShelfListViewHolder = this.a;
            if (bookShelfListViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            bookShelfListViewHolder.ivBookImg = null;
            bookShelfListViewHolder.tvBookName = null;
            bookShelfListViewHolder.tvTimeList = null;
            bookShelfListViewHolder.tv_status = null;
            bookShelfListViewHolder.tv_last_read_chapterName = null;
            bookShelfListViewHolder.shelf_more = null;
            bookShelfListViewHolder.rlItemBook = null;
            bookShelfListViewHolder.cardView = null;
            bookShelfListViewHolder.book_top_icon = null;
            bookShelfListViewHolder.progressBarSmall = null;
            bookShelfListViewHolder.fade_cover = null;
        }
    }

    public MkShelfBookDataItem(MkBookshelfFragment mkBookshelfFragment, me.jessyan.art.c.e.c cVar, com.amgcyo.cuttadon.g.a aVar) {
        this.b = mkBookshelfFragment;
        this.f3107c = cVar;
        this.f3108d = aVar;
    }

    public /* synthetic */ void b(MkBook mkBook, View view) {
        com.amgcyo.cuttadon.g.a aVar = this.f3108d;
        if (aVar != null) {
            aVar.onItemClick(mkBook);
        }
    }

    public /* synthetic */ void c(MkBook mkBook, View view) {
        com.amgcyo.cuttadon.g.a aVar = this.f3108d;
        if (aVar != null) {
            aVar.moreClickListener(mkBook);
        }
    }

    public /* synthetic */ boolean d(MkBook mkBook, View view) {
        com.amgcyo.cuttadon.g.a aVar = this.f3108d;
        if (aVar == null) {
            return true;
        }
        aVar.moreClickListener(mkBook);
        return true;
    }

    public /* synthetic */ void e(MkBook mkBook, View view) {
        com.amgcyo.cuttadon.g.a aVar = this.f3108d;
        if (aVar != null) {
            aVar.onItemClick(mkBook);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public com.amgcyo.cuttadon.adapter.other.p a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R.layout.bookshelf_list, viewGroup, false);
        if (this.b.G == 1) {
            return new BookShelfGridViewHolder(layoutInflater.inflate(R.layout.bookshelf_grid, viewGroup, false));
        }
        return new BookShelfListViewHolder(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull com.amgcyo.cuttadon.adapter.other.p pVar, @NonNull MkBook mkBook) {
        int i2 = this.b.G;
        if (i2 == 0) {
            a((BookShelfListViewHolder) pVar, mkBook);
        } else if (i2 == 1) {
            a((BookShelfGridViewHolder) pVar, mkBook);
        }
    }

    private void a(BookShelfGridViewHolder bookShelfGridViewHolder, final MkBook mkBook) {
        Context context = bookShelfGridViewHolder.itemView.getContext();
        bookShelfGridViewHolder.rlItemBookGrid.setVisibility(0);
        String name = mkBook.getName();
        if (!TextUtils.isEmpty(name)) {
            bookShelfGridViewHolder.tvBookNameGrid.setText(name);
        } else {
            bookShelfGridViewHolder.tvBookNameGrid.setText("\u3000\u3000");
        }
        String show_update_at = mkBook.getShow_update_at();
        int updated = mkBook.getUpdated();
        if (!TextUtils.isEmpty(show_update_at)) {
            if (updated == 8) {
                bookShelfGridViewHolder.tvTimeList.setText(String.format("%s·更新", show_update_at));
            } else {
                bookShelfGridViewHolder.tvTimeList.setText(String.format("%s", show_update_at));
            }
        }
        try {
            bookShelfGridViewHolder.shelfStatus.setVisibility(updated);
            bookShelfGridViewHolder.book_top_icon.setVisibility(mkBook.getIs_top() == 1 ? 0 : 8);
        } catch (Exception unused) {
            bookShelfGridViewHolder.shelfStatus.setVisibility(8);
            bookShelfGridViewHolder.book_top_icon.setVisibility(8);
        }
        if (MkApplication.getAppContext().downloadArray.get(mkBook.getBook_id()) == mkBook.getBook_id()) {
            bookShelfGridViewHolder.fade_cover.setVisibility(0);
            bookShelfGridViewHolder.progressBarSmall.setVisibility(0);
            bookShelfGridViewHolder.progressBarSmall.setMax(mkBook.getCacheTotalSize());
            bookShelfGridViewHolder.progressBarSmall.setProgress(mkBook.getCacheProgress());
        } else {
            bookShelfGridViewHolder.fade_cover.setVisibility(8);
            bookShelfGridViewHolder.progressBarSmall.setVisibility(8);
        }
        this.f3107c.a(context, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkBook.getForm()), mkBook.getImage())).imageView(bookShelfGridViewHolder.ivBookImgGrid).build());
        bookShelfGridViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.k
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f3130s.a(mkBook, view);
            }
        });
        bookShelfGridViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3136s.b(mkBook, view);
            }
        });
    }

    public /* synthetic */ boolean a(MkBook mkBook, View view) {
        com.amgcyo.cuttadon.g.a aVar = this.f3108d;
        if (aVar == null) {
            return true;
        }
        aVar.moreClickListener(mkBook);
        return true;
    }

    private void a(final BookShelfListViewHolder bookShelfListViewHolder, final MkBook mkBook) {
        final Context context = bookShelfListViewHolder.itemView.getContext();
        bookShelfListViewHolder.rlItemBook.setVisibility(0);
        bookShelfListViewHolder.rlItemBook.post(new Runnable() { // from class: com.amgcyo.cuttadon.adapter.shelf.l
            @Override // java.lang.Runnable
            public final void run() {
                Context context2 = context;
                MkShelfBookDataItem.BookShelfListViewHolder bookShelfListViewHolder2 = bookShelfListViewHolder;
                g0.a().b("key_shelf_width", com.amgcyo.cuttadon.utils.otherutils.n.b(context2, (bookShelfListViewHolder2.rlItemBook.getWidth() - bookShelfListViewHolder2.rlItemBook.getPaddingStart()) - bookShelfListViewHolder2.rlItemBook.getPaddingEnd()));
            }
        });
        bookShelfListViewHolder.shelf_more.setVisibility(0);
        String name = mkBook.getName();
        if (!TextUtils.isEmpty(name)) {
            bookShelfListViewHolder.tvBookName.setText(name);
        } else {
            bookShelfListViewHolder.tvBookName.setText("\u3000");
        }
        String show_update_at = mkBook.getShow_update_at();
        String show_last_read_at = mkBook.getShow_last_read_at();
        String last_chapter_name = mkBook.getLast_chapter_name();
        String str = TextUtils.isEmpty(last_chapter_name) ? "\u3000" : last_chapter_name;
        int updated = mkBook.getUpdated();
        if (!TextUtils.isEmpty(show_update_at)) {
            if (mkBook.getStatus() == 1) {
                bookShelfListViewHolder.tvTimeList.setText(String.format("%s·完结至：%s", show_update_at, str));
            } else {
                bookShelfListViewHolder.tvTimeList.setText(String.format("%s·更新至：%s", show_update_at, str));
            }
            bookShelfListViewHolder.tv_status.setVisibility(updated);
        }
        String last_read_chapterName = mkBook.getLast_read_chapterName();
        if (!TextUtils.isEmpty(last_read_chapterName)) {
            if (!TextUtils.isEmpty(show_last_read_at)) {
                bookShelfListViewHolder.tv_last_read_chapterName.setText(String.format("%s·阅读至：%s", show_last_read_at, last_read_chapterName));
            } else {
                bookShelfListViewHolder.tv_last_read_chapterName.setText(String.format("阅读至：%s", last_read_chapterName));
            }
        } else {
            int reading_chapter_key = mkBook.getReading_chapter_key();
            if (reading_chapter_key > 0) {
                if (!TextUtils.isEmpty(show_last_read_at)) {
                    bookShelfListViewHolder.tv_last_read_chapterName.setText(String.format("%s·阅读至：第%s章节", show_last_read_at, Integer.valueOf(reading_chapter_key)));
                } else {
                    bookShelfListViewHolder.tv_last_read_chapterName.setText(String.format("阅读至：第%s章节", Integer.valueOf(reading_chapter_key)));
                }
            } else if (!TextUtils.isEmpty(mkBook.getReading_site_path())) {
                if (!TextUtils.isEmpty(show_last_read_at)) {
                    bookShelfListViewHolder.tv_last_read_chapterName.setText(String.format("%s·阅读过", show_last_read_at));
                } else if (mkBook.getReading_datetime() <= 0) {
                    bookShelfListViewHolder.tv_last_read_chapterName.setText("尚未开始阅读");
                } else {
                    bookShelfListViewHolder.tv_last_read_chapterName.setText("阅读过");
                }
            } else {
                bookShelfListViewHolder.tv_last_read_chapterName.setText("尚未开始阅读");
            }
        }
        try {
            bookShelfListViewHolder.book_top_icon.setVisibility(mkBook.getIs_top() == 1 ? 0 : 8);
        } catch (Exception unused) {
            bookShelfListViewHolder.book_top_icon.setVisibility(8);
        }
        if (MkApplication.getAppContext().downloadArray.get(mkBook.getBook_id()) == mkBook.getBook_id()) {
            bookShelfListViewHolder.progressBarSmall.setVisibility(0);
            bookShelfListViewHolder.fade_cover.setVisibility(0);
            bookShelfListViewHolder.progressBarSmall.setMax(mkBook.getCacheTotalSize());
            bookShelfListViewHolder.progressBarSmall.setProgress(mkBook.getCacheProgress());
        } else {
            bookShelfListViewHolder.fade_cover.setVisibility(8);
            bookShelfListViewHolder.progressBarSmall.setVisibility(8);
        }
        this.f3107c.a(context, ImageConfigImpl.builder().imageRadius(8).form(mkBook.getForm()).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkBook.getForm()), mkBook.getImage())).imageView(bookShelfListViewHolder.ivBookImg).build());
        bookShelfListViewHolder.shelf_more.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3134s.c(mkBook, view);
            }
        });
        bookShelfListViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.i
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f3126s.d(mkBook, view);
            }
        });
        bookShelfListViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.shelf.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3128s.e(mkBook, view);
            }
        });
    }
}
