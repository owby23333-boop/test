package com.amgcyo.cuttadon.activity.shelf;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.adapter.shelf.r;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.ShelfCategory;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.f.r;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.amgcyo.cuttadon.utils.otherutils.x;
import com.amgcyo.cuttadon.utils.otherutils.y;
import com.amgcyo.cuttadon.view.otherview.BookCleanupfilterView;
import com.amgcyo.cuttadon.view.otherview.k;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import me.drakeet.multitype.Items;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class BookShelfCleanaupFragment extends com.amgcyo.cuttadon.fragment.base.a<UserPresenter> implements BookCleanupfilterView.b {
    private RecyclerView.ItemDecoration G;
    private com.amgcyo.cuttadon.database.f H;
    private List<MkBook> I;
    private r J;
    private k N;
    private int P;
    private int Q;
    private boolean R;
    private PopupWindow S;
    private Activity T;
    private String U;
    private TextView V;
    private View W;
    private BookCleanupfilterView X;
    private BookCleanupfilterView Y;
    private List<Integer> Z;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private int f2895b0;

    @BindView(R.id.lay_bottom)
    LinearLayout layBottom;

    @BindView(R.id.rv)
    RecyclerView mRecyclerView;

    @BindView(R.id.rl_root)
    View rl_root;

    @BindView(R.id.tv_check_all)
    TextView tvCheckAll;

    @BindView(R.id.tv_delete)
    TextView tvDelete;
    private int K = 0;
    private boolean L = false;
    private int M = 0;
    private int O = 1;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private String f2894a0 = "成功删除所选书籍！";

    class a extends com.amgcyo.cuttadon.j.g.h.a<Integer, List<MkBook>> {
        a(Integer num) {
            super(num);
        }

        @Override // com.amgcyo.cuttadon.j.g.g.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(List<MkBook> list) {
            BookShelfCleanaupFragment.this.I = list;
            if (g.a((List<?>) BookShelfCleanaupFragment.this.I)) {
                BookShelfCleanaupFragment.this.showMessage("书架暂无书籍！");
                FragmentActivity activity = BookShelfCleanaupFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else {
                BookShelfCleanaupFragment.this.J.f(BookShelfCleanaupFragment.this.Q);
                BookShelfCleanaupFragment.this.J.b((Collection) BookShelfCleanaupFragment.this.I);
                BookShelfCleanaupFragment.this.B();
                BookShelfCleanaupFragment.this.z();
            }
            BookShelfCleanaupFragment.this.hideLoading();
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public List<MkBook> a(Integer num) {
            List<MkBook> listL;
            BookShelfCleanaupFragment.this.r();
            int i2 = BookShelfCleanaupFragment.this.f2895b0;
            if (i2 == 0) {
                BookShelfCleanaupFragment.this.Q = 0;
                listL = BookShelfCleanaupFragment.this.H.l(BookShelfCleanaupFragment.this.O);
            } else if (i2 == 2) {
                BookShelfCleanaupFragment.this.Q = 1;
                listL = BookShelfCleanaupFragment.this.H.h(BookShelfCleanaupFragment.this.O);
            } else if (i2 != 3) {
                BookShelfCleanaupFragment.this.Q = 0;
                listL = BookShelfCleanaupFragment.this.H.g(BookShelfCleanaupFragment.this.O);
            } else {
                BookShelfCleanaupFragment.this.Q = 1;
                listL = BookShelfCleanaupFragment.this.H.c(BookShelfCleanaupFragment.this.O);
            }
            if (!g.a(listL)) {
                for (MkBook mkBook : listL) {
                    mkBook.setShow_update_at(y.b(mkBook.getUpdated_at()));
                    mkBook.setShow_last_read_at(y.c(t0.d(mkBook.getReading_datetime() * 1000)));
                }
            }
            return listL;
        }
    }

    class b extends com.amgcyo.cuttadon.j.g.h.a<Integer, List<MkBook>> {
        b(Integer num) {
            super(num);
        }

        @Override // com.amgcyo.cuttadon.j.g.g.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(List<MkBook> list) {
            BookShelfCleanaupFragment.this.I = list;
            if (!g.a((List<?>) BookShelfCleanaupFragment.this.I)) {
                BookShelfCleanaupFragment.this.o();
                return;
            }
            BookShelfCleanaupFragment.this.hideLoading();
            BookShelfCleanaupFragment.this.showMessage("书架暂无书籍！");
            FragmentActivity activity = BookShelfCleanaupFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public List<MkBook> a(Integer num) {
            return g.b(num.intValue());
        }
    }

    class c extends com.amgcyo.cuttadon.j.g.h.a<List<MkBook>, Items> {
        c(List list) {
            super(list);
        }

        @Override // com.amgcyo.cuttadon.j.g.g.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Items items) {
            ShelfCategory shelfCategory;
            BookShelfCleanaupFragment.this.hideLoading();
            if (items.size() <= 0) {
                BookShelfCleanaupFragment.this.q();
                return;
            }
            Iterator<Object> it = items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    shelfCategory = null;
                    break;
                }
                Object next = it.next();
                if (next instanceof ShelfCategory) {
                    shelfCategory = (ShelfCategory) next;
                    break;
                }
            }
            if (shelfCategory == null) {
                BookShelfCleanaupFragment.this.q();
                return;
            }
            BookShelfCleanaupFragment.this.U = String.format(Locale.getDefault(), "%s(共%d本)", g.u(shelfCategory.getCategoryName()), Integer.valueOf(shelfCategory.getCategoryCount()));
            BookShelfCleanaupFragment.this.a(items);
            if (BookShelfCleanaupFragment.this.Y == null) {
                BookShelfCleanaupFragment bookShelfCleanaupFragment = BookShelfCleanaupFragment.this;
                bookShelfCleanaupFragment.Y = (BookCleanupfilterView) LayoutInflater.from(((com.amgcyo.cuttadon.fragment.base.a) bookShelfCleanaupFragment).f3725t).inflate(R.layout.book_cleanup_headview, (ViewGroup) null);
                BookShelfCleanaupFragment.this.Y.setOnTagClickListener(BookShelfCleanaupFragment.this);
            }
            BookShelfCleanaupFragment bookShelfCleanaupFragment2 = BookShelfCleanaupFragment.this;
            bookShelfCleanaupFragment2.a(bookShelfCleanaupFragment2.Y, items);
            if (BookShelfCleanaupFragment.this.J.c() > 0) {
                BookShelfCleanaupFragment.this.J.r();
            }
            BookShelfCleanaupFragment.this.J.b((View) BookShelfCleanaupFragment.this.Y);
            BookShelfCleanaupFragment.this.a(shelfCategory);
            BookShelfCleanaupFragment.this.B();
            BookShelfCleanaupFragment.this.z();
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Items a(List<MkBook> list) {
            long j2;
            long j3;
            long j4 = 1000;
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            ArrayList arrayList = new ArrayList(BookShelfCleanaupFragment.this.I);
            Iterator it = arrayList.iterator();
            while (true) {
                j2 = 0;
                if (!it.hasNext()) {
                    break;
                }
                MkBook mkBook = (MkBook) it.next();
                long reading_datetime = mkBook.getReading_datetime();
                Long.valueOf(reading_datetime);
                mkBook.setShow_update_at(y.b(mkBook.getUpdated_at()));
                if (reading_datetime > 0) {
                    mkBook.setShow_last_read_at(y.c(t0.d(reading_datetime * 1000)));
                }
                if (!TextUtils.isEmpty(mkBook.getReading_site_path()) && reading_datetime > 0) {
                    long days = TimeUnit.SECONDS.toDays(jCurrentTimeMillis - reading_datetime);
                    String str = "阅读状态月份比较：" + mkBook.getName() + "  " + reading_datetime + " == " + days;
                    if (days < 30 || days >= 90) {
                        if (days >= 90) {
                            j3 = 180;
                            if (days < 180) {
                                mkBook.setBook_shelf_category("3个月未读");
                            }
                        } else {
                            j3 = 180;
                        }
                        if (days >= j3 && days < 270) {
                            mkBook.setBook_shelf_category("6个月未读");
                        } else if (days >= 270 && days < 365) {
                            mkBook.setBook_shelf_category("9个月未读");
                        } else if (days < 30) {
                            mkBook.setBook_shelf_category("0最近看过");
                        } else {
                            mkBook.setBook_shelf_category("超过1年未读");
                        }
                    } else {
                        mkBook.setBook_shelf_category("1个月未读");
                    }
                } else {
                    String str2 = "尚未开始阅读: " + mkBook.getName();
                    mkBook.setBook_shelf_category("0尚未开始阅读");
                }
            }
            Items items = new Items();
            List<ShelfCategory> listA = x.a(arrayList);
            boolean z2 = true;
            boolean z3 = !g.a(listA);
            if (z3) {
                items.add("按阅读状态查询：");
                int i2 = 0;
                while (i2 < listA.size()) {
                    ShelfCategory shelfCategory = listA.get(i2);
                    if (i2 != 0) {
                        z2 = false;
                    }
                    shelfCategory.setSelected(z2);
                    shelfCategory.setSortModel(0);
                    items.add(shelfCategory);
                    i2++;
                    z2 = true;
                }
            }
            ArrayList<MkBook> arrayList2 = new ArrayList(BookShelfCleanaupFragment.this.I);
            for (MkBook mkBook2 : arrayList2) {
                long reading_datetime2 = mkBook2.getReading_datetime();
                Long.valueOf(reading_datetime2);
                mkBook2.setShow_update_at(y.b(mkBook2.getUpdated_at()));
                if (reading_datetime2 > j2) {
                    mkBook2.setShow_last_read_at(y.c(t0.d(reading_datetime2 * j4)));
                }
                long jA = t0.a(mkBook2.getUpdated_at()) / j4;
                long days2 = TimeUnit.SECONDS.toDays(jCurrentTimeMillis - jA);
                String str3 = "更新状态月份比较：" + mkBook2.getName() + "  " + jA + " == " + days2;
                if (days2 >= 30 && days2 < 90) {
                    mkBook2.setBook_shelf_category("1个月未更新");
                } else if (days2 >= 90 && days2 < 180) {
                    mkBook2.setBook_shelf_category("3个月未更新");
                } else if (days2 >= 150 && days2 < 210) {
                    mkBook2.setBook_shelf_category("5个月未更新");
                } else if (days2 < 210 || days2 >= 270) {
                    if (days2 >= 270 && days2 < 365) {
                        mkBook2.setBook_shelf_category("9个月未更新");
                    } else if (days2 < 30) {
                        mkBook2.setBook_shelf_category("0最近有更新");
                    } else {
                        mkBook2.setBook_shelf_category("超过1年未更新");
                    }
                    j4 = 1000;
                    j2 = 0;
                } else {
                    mkBook2.setBook_shelf_category("7个月未更新");
                }
                j4 = 1000;
                j2 = 0;
            }
            List<ShelfCategory> listA2 = x.a(arrayList2);
            if (!g.a(listA2)) {
                items.add("按更新状态查询：");
                int i3 = 0;
                while (i3 < listA2.size()) {
                    ShelfCategory shelfCategory2 = listA2.get(i3);
                    if (!z3) {
                        shelfCategory2.setSelected(i3 == 0);
                    }
                    shelfCategory2.setSortModel(1);
                    items.add(shelfCategory2);
                    i3++;
                }
            }
            return items;
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.j() == null) {
                BookShelfCleanaupFragment bookShelfCleanaupFragment = BookShelfCleanaupFragment.this;
                bookShelfCleanaupFragment.a((List<Integer>) bookShelfCleanaupFragment.Z);
                return;
            }
            String strA = com.amgcyo.cuttadon.utils.otherutils.r.a(BookShelfCleanaupFragment.this.Z);
            if (TextUtils.isEmpty(strA)) {
                BookShelfCleanaupFragment.this.m();
                return;
            }
            UserPresenter userPresenter = (UserPresenter) ((com.amgcyo.cuttadon.fragment.base.a) BookShelfCleanaupFragment.this).f3726u;
            BookShelfCleanaupFragment bookShelfCleanaupFragment2 = BookShelfCleanaupFragment.this;
            userPresenter.b(Message.a(bookShelfCleanaupFragment2, new Object[]{strA, Integer.valueOf(bookShelfCleanaupFragment2.O)}));
            com.amgcyo.cuttadon.h.h.c.b("BOOK_CLEAN_DELETE", BookShelfCleanaupFragment.this.U);
        }
    }

    class e extends GridLayoutManager.SpanSizeLookup {
        e(BookShelfCleanaupFragment bookShelfCleanaupFragment) {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return 1;
        }
    }

    private void A() {
        this.K = 0;
        if (this.I == null) {
            this.I = new ArrayList();
        }
        if (this.I.size() > 0) {
            this.I.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.K = this.K == 0 ? 1 : 0;
        if (this.K == 1) {
            this.layBottom.setVisibility(0);
            this.L = true;
        } else {
            this.layBottom.setVisibility(8);
            this.L = false;
            z();
        }
        this.J.e(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.H == null) {
            this.H = AppDatabase.i().a();
        }
    }

    private void s() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f3725t, 3);
        gridLayoutManager.setSpanSizeLookup(new e(this));
        this.mRecyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = this.G;
        if (itemDecoration != null) {
            this.mRecyclerView.removeItemDecoration(itemDecoration);
        }
        com.amgcyo.cuttadon.j.itemdecoration.e eVar = new com.amgcyo.cuttadon.j.itemdecoration.e(n.a(10.0f), true);
        if (this.R) {
            eVar.b(1);
        }
        eVar.a(0);
        this.G = eVar;
        this.mRecyclerView.addItemDecoration(eVar);
    }

    private void t() {
        RecyclerView.ItemDecoration itemDecoration = this.G;
        if (itemDecoration != null) {
            this.mRecyclerView.removeItemDecoration(itemDecoration);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.f3725t));
    }

    private void u() {
        A();
        k();
        com.amgcyo.cuttadon.j.g.b.a(new a(Integer.valueOf(this.O)));
    }

    private void v() {
        if (this.R) {
            w();
        } else {
            u();
        }
    }

    private void w() {
        A();
        k();
        com.amgcyo.cuttadon.j.g.b.a(new b(Integer.valueOf(this.O)));
    }

    private void x() {
        int iFindFirstVisibleItemPosition;
        int i2;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (this.S == null) {
            this.S = p();
        }
        if (this.S == null) {
            return;
        }
        BookCleanupfilterView bookCleanupfilterView = this.X;
        if (bookCleanupfilterView != null && bookCleanupfilterView.getVisibility() == 0) {
            this.X.setVisibility(8);
        }
        if (layoutManager instanceof GridLayoutManager) {
            iFindFirstVisibleItemPosition = ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            i2 = 3;
        } else {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                i2 = 1;
            } else {
                iFindFirstVisibleItemPosition = 0;
                i2 = 0;
            }
        }
        String str = iFindFirstVisibleItemPosition + " index: " + i2;
        if (iFindFirstVisibleItemPosition <= 0) {
            return;
        }
        if (iFindFirstVisibleItemPosition <= i2) {
            if (this.S.isShowing()) {
                this.N.a();
            }
        } else {
            Activity activity = this.T;
            if (activity == null || activity.isFinishing() || this.S.isShowing()) {
                return;
            }
            this.S.showAsDropDown(this.rl_root, 0, 0);
        }
    }

    private void y() {
        if (this.J == null || g.a(this.I)) {
            return;
        }
        for (int i2 = 0; i2 < this.I.size(); i2++) {
            this.I.get(i2).setSelect(true);
        }
        this.tvCheckAll.setText("反选");
        this.J.notifyDataSetChanged();
        this.M = this.I.size();
        this.tvDelete.setText(String.format(Locale.getDefault(), "删除(%d)", Integer.valueOf(this.M)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.J == null || g.a(this.I)) {
            return;
        }
        for (int i2 = 0; i2 < this.I.size(); i2++) {
            this.I.get(i2).setSelect(false);
        }
        this.J.notifyDataSetChanged();
        this.tvDelete.setText("删除");
        this.tvCheckAll.setText("全选");
        this.M = 0;
    }

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.batch_man_book_activity;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s != 826) {
            Object obj = message.f21202x;
            if (obj instanceof String) {
                this.f2894a0 = (String) obj;
            }
            a(this.Z);
            return;
        }
        Object obj2 = message.f21202x;
        if (obj2 instanceof String) {
            a((String) obj2);
        } else {
            m();
        }
    }

    @Override // me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PopupWindow popupWindow = this.S;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @OnClick({R.id.tv_check_all, R.id.tv_delete})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id != R.id.tv_check_all) {
            if (id != R.id.tv_delete) {
                return;
            }
            l();
        } else if ("全选".equals(this.tvCheckAll.getText().toString())) {
            y();
        } else {
            z();
        }
    }

    private void l() {
        if (this.J == null || g.a(this.I)) {
            m();
            return;
        }
        if (this.Z == null) {
            this.Z = new ArrayList();
        }
        if (!g.a(this.Z)) {
            this.Z.clear();
        }
        for (int size = this.I.size() - 1; size >= 0; size--) {
            if (this.I.get(size).isSelect()) {
                this.Z.add(Integer.valueOf(this.I.get(size).getBook_id()));
            }
        }
        if (g.a(this.Z)) {
            a("没有选择任何书籍");
        } else {
            o.a(this.f3725t, "温馨提示", "是否批量删除所选书籍？", new d(), (View.OnClickListener) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        a("删除失败，请退出重试！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.amgcyo.cuttadon.j.g.b.a(new c(this.I));
    }

    private PopupWindow p() {
        k kVar = this.N;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        r0.b(this.f3725t, this.O);
        Context context = this.f3725t;
        if (context instanceof BaseTitleBarActivity) {
            ((BaseTitleBarActivity) context).finish();
        }
    }

    public /* synthetic */ void c(int i2) {
        x();
    }

    void d(int i2) {
        this.f2895b0 = i2;
        u();
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.O = arguments.getInt("form", 1);
            this.P = arguments.getInt("type_id", 10);
        }
        this.R = 10 == this.P;
        int iK = g.K();
        if (iK == 0) {
            this.J = new r(R.layout.bookshelf_list, iK, this.f3728w);
            t();
        } else {
            this.J = new r(R.layout.bookshelf_grid, iK, this.f3728w);
            s();
        }
        this.T = getActivity();
        this.mRecyclerView.setAdapter(this.J);
        this.mRecyclerView.addOnScrollListener(new com.amgcyo.cuttadon.f.r(this.f3725t, new r.a() { // from class: com.amgcyo.cuttadon.activity.shelf.e
            @Override // com.amgcyo.cuttadon.f.r.a
            public final void a(int i2) {
                this.a.c(i2);
            }
        }));
        this.J.a(new BaseQuickAdapter.f() { // from class: com.amgcyo.cuttadon.activity.shelf.d
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.f
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.f2906s.a(baseQuickAdapter, view, i2);
            }
        });
        v();
        com.amgcyo.cuttadon.h.h.c.b("BOOK_CLEAN_VISIABLE", this.R ? "bookClean" : "bookBatch");
    }

    @Override // me.jessyan.art.base.f.i
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }

    public /* synthetic */ void a(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (!this.L || this.J == null) {
            return;
        }
        MkBook mkBook = this.I.get(i2);
        if (!mkBook.isSelect()) {
            this.M++;
            mkBook.setSelect(true);
        } else {
            mkBook.setSelect(false);
            this.M--;
        }
        if (this.M == 0) {
            this.tvDelete.setText("删除");
        } else {
            this.tvDelete.setText(String.format(Locale.getDefault(), "删除(%d)", Integer.valueOf(this.M)));
        }
        this.tvCheckAll.setText("全选");
        this.J.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BookCleanupfilterView bookCleanupfilterView, Items items) {
        bookCleanupfilterView.setData(items);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Items items) {
        if (this.W == null || this.N == null) {
            this.W = LayoutInflater.from(this.f3725t).inflate(R.layout.book_cleanup_pop, (ViewGroup) null);
            k.c cVar = new k.c(this.f3725t);
            cVar.a(this.W);
            cVar.a(R.style.anim_style);
            cVar.a(-1, -2);
            cVar.a(false);
            cVar.b(false);
            this.N = cVar.a();
            this.V = (TextView) this.W.findViewById(R.id.tv_title);
            this.X = (BookCleanupfilterView) this.W.findViewById(R.id.filterView);
            this.X.setOnTagClickListener(this);
            this.V.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.shelf.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2907s.a(view);
                }
            });
        }
        a(this.X, items);
        this.V.setText(this.U);
    }

    public /* synthetic */ void a(View view) {
        BookCleanupfilterView bookCleanupfilterView = this.X;
        if (bookCleanupfilterView != null) {
            if (8 == bookCleanupfilterView.getVisibility()) {
                this.X.setVisibility(0);
            } else {
                this.X.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<Integer> list) {
        if (g.a(list)) {
            m();
            return;
        }
        r();
        if (this.H.a(list) > 0) {
            b(this.f2894a0);
        } else {
            m();
        }
        v();
    }

    public static BookShelfCleanaupFragment a(int i2, int i3) {
        Bundle bundle = new Bundle();
        Integer.valueOf(i2);
        bundle.putInt("form", i2);
        bundle.putInt("type_id", i3);
        BookShelfCleanaupFragment bookShelfCleanaupFragment = new BookShelfCleanaupFragment();
        bookShelfCleanaupFragment.setArguments(bundle);
        return bookShelfCleanaupFragment;
    }

    @Override // com.amgcyo.cuttadon.view.otherview.BookCleanupfilterView.b
    public void a(ShelfCategory shelfCategory, Items items) {
        a(this.Y, items);
        a(this.X, items);
        a(shelfCategory);
        if (shelfCategory != null && this.V != null) {
            this.U = String.format(Locale.getDefault(), "%s(共%d本)", g.u(shelfCategory.getCategoryName()), Integer.valueOf(shelfCategory.getCategoryCount()));
            this.V.setText(this.U);
        }
        this.K = 0;
        B();
        z();
        PopupWindow popupWindow = this.S;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.N.a();
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShelfCategory shelfCategory) {
        if (shelfCategory != null && this.J != null) {
            String strU = g.u(shelfCategory.getCategoryName());
            this.J.f(shelfCategory.getSortModel());
            this.I = shelfCategory.getArtBookList();
            if (!g.a(this.I)) {
                this.J.b((Collection) this.I);
                return;
            }
            a(strU + "暂无数据，请选择其他状态进行筛选");
            return;
        }
        a("参数异常，请退出重试！");
    }

    public void a(@Nullable Object obj) {
        this.f2895b0 = ((Integer) obj).intValue();
    }
}
