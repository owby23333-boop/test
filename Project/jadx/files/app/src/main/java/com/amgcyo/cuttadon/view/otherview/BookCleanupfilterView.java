package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.adapter.cleanup.CleanupBeanItemViewBinder;
import com.amgcyo.cuttadon.adapter.cleanup.StringItemViewBinder;
import com.amgcyo.cuttadon.api.entity.other.ShelfCategory;
import com.amgcyo.cuttadon.j.itemdecoration.GridItemDecoration;
import com.amgcyo.cuttadon.j.itemdecoration.RecyclerViewDivider;
import com.fatcatfat.io.R;
import java.util.List;
import me.drakeet.multitype.Items;

/* JADX INFO: loaded from: classes.dex */
public class BookCleanupfilterView extends FrameLayout implements CleanupBeanItemViewBinder.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Context f4926s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private RecyclerView f4927t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    me.drakeet.multitype.d f4928u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Items f4929v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private b f4930w;

    class a extends GridLayoutManager.SpanSizeLookup {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return BookCleanupfilterView.this.f4929v.get(i2) instanceof ShelfCategory ? 1 : 3;
        }
    }

    public interface b {
        void a(ShelfCategory shelfCategory, Items items);
    }

    public BookCleanupfilterView(Context context) {
        super(context);
        this.f4929v = new Items();
        a(context);
    }

    public void setData(Items items) {
        boolean z2 = this.f4928u == null;
        if (z2) {
            this.f4928u = new me.drakeet.multitype.d();
            this.f4928u.a(String.class, new StringItemViewBinder());
            this.f4928u.a(ShelfCategory.class, new CleanupBeanItemViewBinder(this));
            this.f4927t.setAdapter(this.f4928u);
        }
        this.f4929v = items;
        this.f4928u.a(this.f4929v);
        if (z2) {
            return;
        }
        this.f4928u.notifyDataSetChanged();
    }

    public void setOnTagClickListener(b bVar) {
        this.f4930w = bVar;
    }

    private void a(Context context) {
        this.f4926s = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.book_cleanup_filterview, (ViewGroup) null);
        this.f4927t = (RecyclerView) viewInflate.findViewById(R.id.rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f4926s, 3);
        gridLayoutManager.setSpanSizeLookup(new a());
        this.f4927t.setLayoutManager(gridLayoutManager);
        GridItemDecoration.a aVarA = RecyclerViewDivider.a();
        aVarA.a(0);
        aVarA.b(com.amgcyo.cuttadon.utils.otherutils.n.a(10.0f));
        aVarA.e();
        aVarA.a().a(this.f4927t);
        removeAllViews();
        addView(viewInflate);
    }

    public BookCleanupfilterView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4929v = new Items();
        a(context);
    }

    @Override // com.amgcyo.cuttadon.adapter.cleanup.CleanupBeanItemViewBinder.a
    public void a(ShelfCategory shelfCategory) {
        if (this.f4928u == null || this.f4930w == null || com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) this.f4929v)) {
            return;
        }
        for (Object obj : this.f4929v) {
            if (obj instanceof ShelfCategory) {
                ShelfCategory shelfCategory2 = (ShelfCategory) obj;
                if (shelfCategory2.getCategoryName().equals(shelfCategory.getCategoryName())) {
                    shelfCategory2.setSelected(true);
                } else {
                    shelfCategory2.setSelected(false);
                }
            }
        }
        this.f4928u.notifyDataSetChanged();
        this.f4930w.a(shelfCategory, this.f4929v);
    }
}
