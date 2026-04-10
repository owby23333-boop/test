package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.j.itemdecoration.GridItemDecoration;
import com.amgcyo.cuttadon.j.itemdecoration.RecyclerViewDivider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class BookStoreLinearLayoutGrid extends CardView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    RecyclerView f4933s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    View f4934t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    LinearLayout f4935u;

    public BookStoreLinearLayoutGrid(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f4934t = LayoutInflater.from(context).inflate(R.layout.only_recyclerview, (ViewGroup) null);
        this.f4933s = (RecyclerView) this.f4934t.findViewById(R.id.recyclerview);
        this.f4935u = (LinearLayout) this.f4934t.findViewById(R.id.ll_title);
        this.f4933s.setHasFixedSize(true);
        this.f4933s.setNestedScrollingEnabled(false);
    }

    public void setRootViewBgColor(int i2) {
        LinearLayout linearLayout = this.f4935u;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(i2);
        }
    }

    public BookStoreLinearLayoutGrid(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void a(RecyclerView.LayoutManager layoutManager, BaseQuickAdapter baseQuickAdapter, RecyclerView.ItemDecoration itemDecoration) {
        RecyclerView recyclerView = this.f4933s;
        if (recyclerView == null || baseQuickAdapter == null || layoutManager == null) {
            return;
        }
        recyclerView.setLayoutManager(layoutManager);
        this.f4933s.setAdapter(baseQuickAdapter);
        if (itemDecoration != null) {
            this.f4933s.addItemDecoration(itemDecoration);
        }
        removeAllViews();
        addView(this.f4934t);
    }

    public void a(RecyclerView.LayoutManager layoutManager, BaseQuickAdapter baseQuickAdapter, int i2) {
        RecyclerView recyclerView = this.f4933s;
        if (recyclerView == null || baseQuickAdapter == null || layoutManager == null) {
            return;
        }
        recyclerView.setLayoutManager(layoutManager);
        this.f4933s.setAdapter(baseQuickAdapter);
        GridItemDecoration.a aVarA = RecyclerViewDivider.a();
        aVarA.a(-12303292);
        aVarA.b(i2);
        aVarA.e();
        aVarA.a().a(this.f4933s);
        removeAllViews();
        addView(this.f4934t);
    }
}
