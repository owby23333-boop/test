package com.amgcyo.cuttadon.adapter.bookcity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.adapter.bookcity.MkOneBookListIVB;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkOneBookListIVB extends me.drakeet.multitype.b<MkBook, ViewHolder> {
    private me.jessyan.art.c.e.c b;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_bookImg)
        ImageView ivBookImg;

        @BindView(R.id.tv_authorname)
        TextView tv_authorname;

        @BindView(R.id.tv_bookName)
        TextView tv_bookName;

        @BindView(R.id.tv_book_content)
        TextView tv_book_content;

        @BindView(R.id.tv_book_status)
        TextView tv_book_status;

        @BindView(R.id.tv_chapter_count)
        TextView tv_chapter_count;

        @BindView(R.id.tv_score)
        TextView tv_score;

        @BindView(R.id.tv_word_count)
        TextView tv_word_count;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.ivBookImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bookImg, "field 'ivBookImg'", ImageView.class);
            viewHolder.tv_bookName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bookName, "field 'tv_bookName'", TextView.class);
            viewHolder.tv_score = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_score, "field 'tv_score'", TextView.class);
            viewHolder.tv_book_content = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_book_content, "field 'tv_book_content'", TextView.class);
            viewHolder.tv_authorname = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_authorname, "field 'tv_authorname'", TextView.class);
            viewHolder.tv_book_status = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_book_status, "field 'tv_book_status'", TextView.class);
            viewHolder.tv_chapter_count = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_chapter_count, "field 'tv_chapter_count'", TextView.class);
            viewHolder.tv_word_count = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_word_count, "field 'tv_word_count'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.ivBookImg = null;
            viewHolder.tv_bookName = null;
            viewHolder.tv_score = null;
            viewHolder.tv_book_content = null;
            viewHolder.tv_authorname = null;
            viewHolder.tv_book_status = null;
            viewHolder.tv_chapter_count = null;
            viewHolder.tv_word_count = null;
        }
    }

    public MkOneBookListIVB(me.jessyan.art.c.e.c cVar) {
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.relevantbook_item, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull final ViewHolder viewHolder, @NonNull final MkBook mkBook) {
        this.b.a(viewHolder.itemView.getContext(), ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkBook.getForm()), mkBook.getImage())).imageView(viewHolder.ivBookImg).build());
        String name = mkBook.getName();
        if (TextUtils.isEmpty(name)) {
            viewHolder.tv_bookName.setText("暂无书名");
        } else {
            if (name.length() >= 10) {
                name = name.substring(0, 10) + "...";
            }
            viewHolder.tv_bookName.setText(name);
        }
        viewHolder.tv_book_content.setText(mkBook.getRemark());
        String author = mkBook.getAuthor();
        if (TextUtils.isEmpty(author)) {
            viewHolder.tv_authorname.setVisibility(8);
        } else {
            viewHolder.tv_authorname.setVisibility(0);
            viewHolder.tv_authorname.setText(author);
        }
        viewHolder.tv_book_status.setText(com.amgcyo.cuttadon.f.o.a(mkBook.getStatus()));
        viewHolder.tv_score.setText(String.format("%s分", mkBook.getScore()));
        if (1 == mkBook.getForm()) {
            viewHolder.tv_chapter_count.setText(mkBook.getLtype());
            viewHolder.tv_word_count.setVisibility(0);
            viewHolder.tv_word_count.setText(com.amgcyo.cuttadon.f.o.a(mkBook.getWords_number(), (Integer) 2));
        } else {
            viewHolder.tv_chapter_count.setText(String.format(Locale.getDefault(), "%d话", Integer.valueOf(mkBook.getWords_number())));
            viewHolder.tv_word_count.setVisibility(8);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.bookcity.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MkOneBookListIVB.ViewHolder viewHolder2 = viewHolder;
                MkBook mkBook2 = mkBook;
                r0.a(viewHolder2.itemView.getContext(), mkBook2.getBook_id(), mkBook2.getForm());
            }
        });
    }
}
