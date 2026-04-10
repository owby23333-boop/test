package com.amgcyo.cuttadon.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.MkAreaCodeBean;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.utils.otherutils.p0;
import com.amgcyo.cuttadon.view.otherview.CustomTextView;
import com.amgcyo.cuttadon.view.slideview.SideBarLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkAreaCodeActivity extends BaseRefreshMoreRecyclerActivity<UserPresenter> implements BaseQuickAdapter.g {

    @BindView(R.id.iv_search)
    ImageView iv_search;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    List<MkAreaCodeBean> f2918r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f2919s0 = -1;

    @BindView(R.id.searchHolder)
    SearchView searchHolder;

    @BindView(R.id.sidebar)
    SideBarLayout sidebarView;

    @BindView(R.id.toolbar_title)
    CustomTextView toolbar_title;

    class a implements SearchView.OnQueryTextListener {
        a() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            MkAreaCodeActivity.this.afterTextChanged(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            MkAreaCodeActivity.this.afterTextChanged(str);
            return false;
        }
    }

    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            MkAreaCodeActivity.this.f2919s0 = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (MkAreaCodeActivity.this.f2919s0 == -1 || com.amgcyo.cuttadon.utils.otherutils.g.a(MkAreaCodeActivity.this.f2918r0)) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            String word = MkAreaCodeActivity.this.f2918r0.get(layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() : 0).getWord();
            if (!TextUtils.isEmpty(word)) {
                MkAreaCodeActivity.this.sidebarView.b(word);
            }
            if (MkAreaCodeActivity.this.f2919s0 == 0) {
                MkAreaCodeActivity.this.f2919s0 = -1;
            }
        }
    }

    private void r() {
        this.sidebarView.setSideBarLayout(new SideBarLayout.a() { // from class: com.amgcyo.cuttadon.activity.user.f
            @Override // com.amgcyo.cuttadon.view.slideview.SideBarLayout.a
            public final void a(String str) {
                this.a.e(str);
            }
        });
        this.recyclerView.addOnScrollListener(new b());
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public void afterTextChanged(String str) {
        List<MkAreaCodeBean> list = this.f2918r0;
        if (list == null || list.size() <= 0 || this.f2256n0 == null || this.sidebarView == null) {
            return;
        }
        if (str.equals("")) {
            this.sidebarView.b(this.f2918r0.get(0).getWord());
            ((com.amgcyo.cuttadon.b.c.n) this.f2256n0).a((List) this.f2918r0);
            this.f2256n0.notifyDataSetChanged();
        } else {
            String strReplace = str.replace("+", "");
            if (matcherSearch(strReplace, this.f2918r0).size() > 0) {
                this.sidebarView.b(matcherSearch(strReplace, this.f2918r0).get(0).getWord());
            }
            ((com.amgcyo.cuttadon.b.c.n) this.f2256n0).a((List) matcherSearch(strReplace, this.f2918r0));
            this.f2256n0.notifyDataSetChanged();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "";
    }

    public /* synthetic */ void e(View view) {
        this.searchHolder.setVisibility(0);
        this.searchHolder.setIconified(false);
        this.searchHolder.setQueryHint("输入国家或地区代码");
        this.toolbar_title.setVisibility(8);
        this.iv_search.setVisibility(8);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 825) {
            c(false);
            d(false);
            this.f2918r0 = (List) message.f21202x;
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2918r0)) {
                showEmpty();
                return;
            }
            Iterator<MkAreaCodeBean> it = this.f2918r0.iterator();
            while (it.hasNext()) {
                it.next().setItemType(2);
            }
            SideBarLayout sideBarLayout = this.sidebarView;
            if (sideBarLayout != null) {
                sideBarLayout.setVisibility(0);
            }
            Collections.sort(this.f2918r0, new p0());
            this.f2256n0 = new com.amgcyo.cuttadon.b.c.n(this.f2918r0);
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(this.f2256n0);
            }
            this.f2256n0.a((BaseQuickAdapter.g) this);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        r();
        this.toolbar_title.setText("选择国家和地区代码");
        this.iv_search.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.user.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2999s.e(view);
            }
        });
        this.searchHolder.setOnCloseListener(new SearchView.OnCloseListener() { // from class: com.amgcyo.cuttadon.activity.user.e
            @Override // androidx.appcompat.widget.SearchView.OnCloseListener
            public final boolean onClose() {
                return this.a.q();
            }
        });
        this.searchHolder.setOnQueryTextListener(new a());
        ((UserPresenter) this.f2276v).d(Message.a(this, new Object[0]));
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_area_code;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    public List<MkAreaCodeBean> matcherSearch(String str, List<MkAreaCodeBean> list) {
        ArrayList arrayList = new ArrayList();
        Pattern patternCompile = Pattern.compile(Pattern.quote(str), 2);
        for (int i2 = 0; i2 < list.size(); i2++) {
            Matcher matcher = patternCompile.matcher(list.get(i2).getTel());
            Matcher matcher2 = patternCompile.matcher(list.get(i2).getWord());
            Matcher matcher3 = patternCompile.matcher(list.get(i2).getName());
            if (matcher2.find() || matcher3.find() || matcher.find()) {
                arrayList.add(list.get(i2));
            }
        }
        return arrayList;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2918r0)) {
            return;
        }
        try {
            MkAreaCodeBean mkAreaCodeBean = (MkAreaCodeBean) ((com.amgcyo.cuttadon.b.c.n) this.f2256n0).getData().get(i2);
            if (mkAreaCodeBean == null) {
                return;
            }
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            bundle.putSerializable("MkAreaCodeBean", mkAreaCodeBean);
            intent.putExtras(bundle);
            setResult(836, intent);
            finish();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    protected boolean p() {
        return false;
    }

    public /* synthetic */ boolean q() {
        this.searchHolder.setVisibility(8);
        this.toolbar_title.setVisibility(0);
        this.iv_search.setVisibility(0);
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }

    public /* synthetic */ void e(String str) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2918r0)) {
            return;
        }
        for (int i2 = 0; i2 < this.f2918r0.size(); i2++) {
            String word = this.f2918r0.get(i2).getWord();
            if (!TextUtils.isEmpty(word) && word.equals(str)) {
                this.recyclerView.scrollToPosition(i2);
                return;
            }
        }
    }
}
