package com.amgcyo.cuttadon.adapter.shelf;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DataAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends BaseQuickAdapter<MkBook, com.chad.library.adapter.base.b> {
    private int K;
    private me.jessyan.art.c.e.c L;
    private int M;

    public r(int i2, int i3, me.jessyan.art.c.e.c cVar) {
        super(i2);
        this.K = i3;
        this.L = cVar;
    }

    private void b(com.chad.library.adapter.base.b bVar, MkBook mkBook) {
        Context context = bVar.itemView.getContext();
        bVar.a(R.id.re_top);
        ImageView imageView = (ImageView) bVar.a(R.id.shelf_more);
        ImageView imageView2 = (ImageView) bVar.a(R.id.fade_cover);
        imageView.setVisibility(0);
        imageView2.setVisibility(0);
        if (mkBook.isSelect()) {
            imageView.setImageResource(R.drawable.icon_checkbox);
        } else {
            imageView.setImageResource(R.drawable.icon_no_checkbox);
        }
        TextView textView = (TextView) bVar.a(R.id.tv_bookName_grid);
        String name = mkBook.getName();
        if (TextUtils.isEmpty(name)) {
            textView.setText("\u3000");
        } else {
            textView.setText(name);
        }
        String show_last_read_at = mkBook.getShow_last_read_at();
        String last_chapter_name = mkBook.getLast_chapter_name();
        if (TextUtils.isEmpty(last_chapter_name)) {
            last_chapter_name = "\u3000";
        }
        TextView textView2 = (TextView) bVar.a(R.id.tv_time_list);
        if (this.M == 0) {
            String last_read_chapterName = mkBook.getLast_read_chapterName();
            if (TextUtils.isEmpty(last_read_chapterName)) {
                int reading_chapter_key = mkBook.getReading_chapter_key();
                if (reading_chapter_key > 0) {
                    if (TextUtils.isEmpty(show_last_read_at)) {
                        textView2.setText(String.format("阅读至：第%s章节", Integer.valueOf(reading_chapter_key)));
                    } else {
                        textView2.setText(String.format("%s·阅读至：第%s章节", show_last_read_at, Integer.valueOf(reading_chapter_key)));
                    }
                } else if (TextUtils.isEmpty(mkBook.getReading_site_path())) {
                    textView2.setText("尚未开始阅读");
                } else if (!TextUtils.isEmpty(show_last_read_at)) {
                    textView2.setText(String.format("%s·阅读过", show_last_read_at));
                } else if (mkBook.getReading_datetime() <= 0) {
                    textView2.setText("尚未开始阅读");
                } else {
                    textView2.setText("阅读过");
                }
            } else if (TextUtils.isEmpty(show_last_read_at)) {
                textView2.setText(String.format("阅读至：%s", last_read_chapterName));
            } else {
                textView2.setText(String.format("%s·阅读至：%s", show_last_read_at, last_read_chapterName));
            }
        } else {
            String show_update_at = mkBook.getShow_update_at();
            if (!TextUtils.isEmpty(show_update_at)) {
                if (mkBook.getStatus() == 1) {
                    textView2.setText(String.format("%s·完结至：%s", show_update_at, last_chapter_name));
                } else {
                    textView2.setText(String.format("%s·更新至：%s", show_update_at, last_chapter_name));
                }
            }
        }
        ((TextView) bVar.a(R.id.shelf_status)).setVisibility(mkBook.getUpdated());
        ImageView imageView3 = (ImageView) bVar.a(R.id.book_top_icon);
        try {
            imageView3.setVisibility(mkBook.getIs_top() == 1 ? 0 : 8);
        } catch (Exception unused) {
            imageView3.setVisibility(8);
        }
        this.L.a(context, ImageConfigImpl.builder().imageRadius(8).form(mkBook.getForm()).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkBook.getForm()), mkBook.getImage())).imageView((ImageView) bVar.a(R.id.iv_bookImg_grid)).build());
    }

    private void c(com.chad.library.adapter.base.b bVar, MkBook mkBook) {
        Context context = bVar.itemView.getContext();
        bVar.a(R.id.rl_item_book);
        ImageView imageView = (ImageView) bVar.a(R.id.shelf_more);
        if (mkBook.isSelect()) {
            imageView.setImageResource(R.drawable.icon_checkbox);
        } else {
            imageView.setImageResource(R.drawable.icon_no_checkbox);
        }
        TextView textView = (TextView) bVar.a(R.id.tv_bookName);
        String name = mkBook.getName();
        if (TextUtils.isEmpty(name)) {
            textView.setText("\u3000");
        } else {
            textView.setText(name);
        }
        String show_last_read_at = mkBook.getShow_last_read_at();
        String last_chapter_name = mkBook.getLast_chapter_name();
        if (TextUtils.isEmpty(last_chapter_name)) {
            last_chapter_name = "\u3000";
        }
        TextView textView2 = (TextView) bVar.a(R.id.tv_last_read_chapterName);
        if (this.M == 0) {
            String last_read_chapterName = mkBook.getLast_read_chapterName();
            if (TextUtils.isEmpty(last_read_chapterName)) {
                int reading_chapter_key = mkBook.getReading_chapter_key();
                if (reading_chapter_key > 0) {
                    if (TextUtils.isEmpty(show_last_read_at)) {
                        textView2.setText(String.format("阅读至：第%s章节", Integer.valueOf(reading_chapter_key)));
                    } else {
                        textView2.setText(String.format("%s·阅读至：第%s章节", show_last_read_at, Integer.valueOf(reading_chapter_key)));
                    }
                } else if (TextUtils.isEmpty(mkBook.getReading_site_path())) {
                    textView2.setText("尚未开始阅读");
                } else if (!TextUtils.isEmpty(show_last_read_at)) {
                    textView2.setText(String.format("%s·阅读过", show_last_read_at));
                } else if (mkBook.getReading_datetime() <= 0) {
                    textView2.setText("尚未开始阅读");
                } else {
                    textView2.setText("阅读过");
                }
            } else if (TextUtils.isEmpty(show_last_read_at)) {
                textView2.setText(String.format("阅读至：%s", last_read_chapterName));
            } else {
                textView2.setText(String.format("%s·阅读至：%s", show_last_read_at, last_read_chapterName));
            }
        } else {
            String show_update_at = mkBook.getShow_update_at();
            if (!TextUtils.isEmpty(show_update_at)) {
                if (mkBook.getStatus() == 1) {
                    textView2.setText(String.format("%s·完结至：%s", show_update_at, last_chapter_name));
                } else {
                    textView2.setText(String.format("%s·更新至：%s", show_update_at, last_chapter_name));
                }
            }
        }
        ((TextView) bVar.a(R.id.tv_status)).setVisibility(mkBook.getUpdated());
        ImageView imageView2 = (ImageView) bVar.a(R.id.book_top_icon);
        try {
            imageView2.setVisibility(mkBook.getIs_top() == 1 ? 0 : 8);
        } catch (Exception unused) {
            imageView2.setVisibility(8);
        }
        this.L.a(context, ImageConfigImpl.builder().imageRadius(8).form(mkBook.getForm()).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkBook.getForm()), mkBook.getImage())).imageView((ImageView) bVar.a(R.id.iv_bookImg)).build());
    }

    public void e(int i2) {
        notifyDataSetChanged();
    }

    public void f(int i2) {
        this.M = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NotNull com.chad.library.adapter.base.b bVar, MkBook mkBook) {
        int i2 = this.K;
        if (i2 == 0) {
            c(bVar, mkBook);
        } else if (i2 == 1) {
            b(bVar, mkBook);
        }
    }
}
