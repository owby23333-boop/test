package com.amgcyo.cuttadon.adapter.bookcity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.api.entity.bookcity.BookStoreMaleBean;
import com.amgcyo.cuttadon.api.entity.bookcity.RankBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.view.otherview.BookStoreLinearLayoutGrid;
import com.amgcyo.cuttadon.view.otherview.EnhancedWrapContentViewPager;
import com.amgcyo.cuttadon.view.otherview.SegmentControlView;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MkV7Style2RankTagBookData extends me.drakeet.multitype.b<BookStoreMaleBean, ViewHolder> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private me.jessyan.art.c.e.c f3016c;
    private List<Fragment> b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3017d = MkApplication.getAppContext().getResources().getDimensionPixelSize(R.dimen.dimen5dp);

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.seg_male)
        SegmentControlView seg_male;

        @BindView(R.id.vp_male)
        EnhancedWrapContentViewPager vp_male;

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
            viewHolder.seg_male = (SegmentControlView) Utils.findRequiredViewAsType(view, R.id.seg_male, "field 'seg_male'", SegmentControlView.class);
            viewHolder.vp_male = (EnhancedWrapContentViewPager) Utils.findRequiredViewAsType(view, R.id.vp_male, "field 'vp_male'", EnhancedWrapContentViewPager.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.seg_male = null;
            viewHolder.vp_male = null;
        }
    }

    private class a extends PagerAdapter {
        private ArrayList<BookStoreLinearLayoutGrid> a = new ArrayList<>();
        private int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Context f3018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List<RankBean> f3019d;

        a(int i2, Context context, List<RankBean> list) {
            this.b = i2;
            this.f3018c = context;
            this.f3019d = list;
            for (int i3 = 0; i3 < i2; i3++) {
                this.a.add(null);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull View view, int i2, @NonNull Object obj) {
            ((ViewPager) view).removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            return super.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            return "";
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
            BookStoreLinearLayoutGrid bookStoreLinearLayoutGrid = this.a.get(i2);
            if (bookStoreLinearLayoutGrid == null) {
                bookStoreLinearLayoutGrid = new BookStoreLinearLayoutGrid(this.f3018c);
                RankBean rankBean = this.f3019d.get(i2);
                List<MkBook> data = rankBean.getData();
                if (!com.amgcyo.cuttadon.utils.otherutils.g.a(data)) {
                    bookStoreLinearLayoutGrid.a(new GridLayoutManager(this.f3018c, 2), new p(data, MkV7Style2RankTagBookData.this.f3016c, rankBean.getSub_name()), new com.amgcyo.cuttadon.j.itemdecoration.c(2, MkV7Style2RankTagBookData.this.f3017d, true));
                    this.a.set(i2, bookStoreLinearLayoutGrid);
                }
            }
            viewGroup.addView(bookStoreLinearLayoutGrid);
            return bookStoreLinearLayoutGrid;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }
    }

    public MkV7Style2RankTagBookData(me.jessyan.art.c.e.c cVar) {
        this.f3016c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.book_store_male_view, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull BookStoreMaleBean bookStoreMaleBean) {
        a(viewHolder, bookStoreMaleBean.getRank());
    }

    private void a(final ViewHolder viewHolder, List<RankBean> list) {
        Context context = viewHolder.itemView.getContext();
        String[] strArr = new String[list.size()];
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.b)) {
            this.b.clear();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            strArr[i2] = list.get(i2).getName();
        }
        viewHolder.seg_male.setTexts(strArr);
        viewHolder.vp_male.setOffscreenPageLimit(strArr.length);
        viewHolder.vp_male.setAdapter(new a(strArr.length, context, list));
        viewHolder.seg_male.setViewPager(viewHolder.vp_male);
        viewHolder.seg_male.setOnSegmentChangedListener(new SegmentControlView.c() { // from class: com.amgcyo.cuttadon.adapter.bookcity.o
            @Override // com.amgcyo.cuttadon.view.otherview.SegmentControlView.c
            public final void a(int i3) {
                viewHolder.vp_male.setCurrentItem(i3);
            }
        });
    }
}
