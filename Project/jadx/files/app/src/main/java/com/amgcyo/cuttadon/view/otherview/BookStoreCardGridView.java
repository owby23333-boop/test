package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class BookStoreCardGridView extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    RecyclerView f4931s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    View f4932t;

    public interface a {
    }

    public BookStoreCardGridView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        this.f4932t = LayoutInflater.from(context).inflate(R.layout.book_store_card_grid, (ViewGroup) null);
        this.f4931s = (RecyclerView) this.f4932t.findViewById(R.id.recyclerview);
        this.f4931s.setHasFixedSize(true);
        this.f4931s.setNestedScrollingEnabled(false);
    }

    public void setGridDividerItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
    }

    public void setListener(a aVar) {
    }
}
