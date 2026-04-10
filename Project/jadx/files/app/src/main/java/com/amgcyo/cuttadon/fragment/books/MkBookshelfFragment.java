package com.amgcyo.cuttadon.fragment.books;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.feedback.MkFeedBackActivity;
import com.amgcyo.cuttadon.activity.fission6.Fission6IndexActivity;
import com.amgcyo.cuttadon.activity.main.MkMainActivity;
import com.amgcyo.cuttadon.activity.read.MkReadModelHActivity;
import com.amgcyo.cuttadon.activity.read.MkReadModelVActivity;
import com.amgcyo.cuttadon.adapter.bookcity.MkBookCityBaseAdIVBNew;
import com.amgcyo.cuttadon.adapter.shelf.MkAddBookItem;
import com.amgcyo.cuttadon.adapter.shelf.MkFattenBeanItem;
import com.amgcyo.cuttadon.adapter.shelf.MkShelfBookDataItem;
import com.amgcyo.cuttadon.adapter.shelf.MkShelfCategoryDataItem;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.comic.CategoryComicBean;
import com.amgcyo.cuttadon.api.entity.other.MkAddBook;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkFattenBean;
import com.amgcyo.cuttadon.api.entity.other.MkSiteBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.ShelfCategory;
import com.amgcyo.cuttadon.api.entity.other.ShelfSortBean;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.j.itemdecoration.GridItemDecoration;
import com.amgcyo.cuttadon.j.itemdecoration.RecyclerViewDivider;
import com.amgcyo.cuttadon.sdk.utils.AdFrameLayout;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.view.dialog.n1;
import com.amgcyo.cuttadon.view.dialog.o1;
import com.amgcyo.cuttadon.view.dialog.p1;
import com.amgcyo.cuttadon.view.dialog.q1;
import com.amgcyo.cuttadon.view.otherview.m;
import com.amgcyo.cuttadon.view.popupview.NovelSourceDrawerPopup;
import com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView;
import com.amgcyo.cuttadon.widget.lovelydialog.d;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import me.jessyan.art.mvp.Message;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class MkBookshelfFragment extends com.amgcyo.cuttadon.fragment.base.a<BookPresenter> implements com.amgcyo.cuttadon.g.a, PullToRefreshView.j {
    me.drakeet.multitype.d J;
    private com.amgcyo.cuttadon.database.f K;
    private g L;
    private int M;
    private int N;
    private MkBook Q;
    private p1 S;
    private File X;
    private File Y;
    private File Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private File f3746a0;

    @BindView(R.id.shelf_top_ad)
    AdFrameLayout adFrameLayout;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private File f3747b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private String f3748c0;

    @BindView(R.id.constraintlayout)
    ConstraintLayout constraintlayout;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private MkBook f3749d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private List<MkBook> f3750e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private RecyclerView.ItemDecoration f3751f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private q1 f3752g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private m.b f3753h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private MkBook f3754i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private com.amgcyo.cuttadon.view.otherview.m f3755j0;

    @BindView(R.id.ll_bookNull)
    RelativeLayout ll_bookNull;

    @BindView(R.id.ll_book_size)
    LinearLayout ll_book_size;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private n1 f3758m0;

    @BindView(android.R.id.list)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh_layout)
    PullToRefreshView mRefreshView;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private NovelSourceDrawerPopup f3759n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private o1 f3760o0;

    @BindView(R.id.tv_bottom_text)
    TextView tv_bottom_text;

    @BindView(R.id.tv_shelf_fission6)
    TextView tv_shelf_fission6;

    @BindView(R.id.tv_vali)
    TextView tv_vali;
    public int G = 1;
    private MkAddBook H = new MkAddBook();
    private List<Object> I = new ArrayList();
    public int O = 1;
    private int P = -1;
    private boolean R = false;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    private boolean W = false;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private View.OnClickListener f3756k0 = new b();

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f3757l0 = new CompoundButton.OnCheckedChangeListener() { // from class: com.amgcyo.cuttadon.fragment.books.u
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            this.a.a(compoundButton, z2);
        }
    };

    class a extends GridLayoutManager.SpanSizeLookup {
        a(MkBookshelfFragment mkBookshelfFragment) {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return 1;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MkBookshelfFragment.this.f3754i0 == null) {
                return;
            }
            switch (view.getId()) {
                case R.id.chatLayout /* 2131296798 */:
                    MkBookshelfFragment mkBookshelfFragment = MkBookshelfFragment.this;
                    mkBookshelfFragment.e(mkBookshelfFragment.f3754i0);
                    com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[MENU]分组");
                    break;
                case R.id.clear_layout /* 2131296826 */:
                    MkBookshelfFragment mkBookshelfFragment2 = MkBookshelfFragment.this;
                    mkBookshelfFragment2.b(mkBookshelfFragment2.f3754i0);
                    com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[MENU]清除缓存");
                    break;
                case R.id.delete_layout /* 2131296902 */:
                    if (MkApplication.getAppContext().downloadArray.get(MkBookshelfFragment.this.f3754i0.getBook_id()) == MkBookshelfFragment.this.f3754i0.getBook_id()) {
                        MkBookshelfFragment.this.P = -1;
                        me.jessyan.art.d.f.a().a(new MkCommentEvent(), "stop_Download");
                    }
                    BookPresenter bookPresenter = (BookPresenter) ((com.amgcyo.cuttadon.fragment.base.a) MkBookshelfFragment.this).f3726u;
                    MkBookshelfFragment mkBookshelfFragment3 = MkBookshelfFragment.this;
                    bookPresenter.d(Message.a(mkBookshelfFragment3, new Object[]{mkBookshelfFragment3.f3754i0}));
                    com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[MENU]删除书籍");
                    break;
                case R.id.download_layout /* 2131296933 */:
                    if (MkBookshelfFragment.this.s().a(MkBookshelfFragment.this.f3754i0.getIs_fatten() == 1 ? 0 : 1, MkBookshelfFragment.this.f3754i0.getBook_id()) > 0) {
                        if (com.amgcyo.cuttadon.utils.otherutils.g0.a().a("shelf_show_fatten_desc_dialog", false)) {
                            new com.amgcyo.cuttadon.view.dialog.x0(((com.amgcyo.cuttadon.fragment.base.a) MkBookshelfFragment.this).f3725t).show();
                        }
                        if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
                            try {
                                ((BookPresenter) ((com.amgcyo.cuttadon.fragment.base.a) MkBookshelfFragment.this).f3726u).i(Message.a(MkBookshelfFragment.this, new Object[]{Integer.valueOf(MkBookshelfFragment.this.f3754i0.getBook_id()), Integer.valueOf(MkBookshelfFragment.this.f3754i0.getForm())}));
                                break;
                            } catch (Exception unused) {
                            }
                        }
                    } else {
                        MkBookshelfFragment.this.showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.fatten_error));
                    }
                    com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[MENU]养肥");
                    break;
                case R.id.muluLayout /* 2131298091 */:
                    if (!com.amgcyo.cuttadon.utils.otherutils.h.L0()) {
                        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(((com.amgcyo.cuttadon.fragment.base.a) MkBookshelfFragment.this).f3725t, MkFeedBackActivity.class);
                    } else {
                        com.amgcyo.cuttadon.utils.otherutils.r0.c(((com.amgcyo.cuttadon.fragment.base.a) MkBookshelfFragment.this).f3725t, MkBookshelfFragment.this.f3754i0);
                        com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[MENU]查看书评");
                    }
                    break;
                case R.id.rl_detail /* 2131298256 */:
                    new Bundle().putInt("book_id", MkBookshelfFragment.this.f3754i0.getBook_id());
                    com.amgcyo.cuttadon.utils.otherutils.r0.a(((com.amgcyo.cuttadon.fragment.base.a) MkBookshelfFragment.this).f3725t, MkBookshelfFragment.this.f3754i0.getBook_id(), MkBookshelfFragment.this.O);
                    com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[MENU]详情");
                    break;
                case R.id.shareLayout /* 2131298358 */:
                    if (MkBookshelfFragment.this.getActivity() != null && !MkBookshelfFragment.this.getActivity().isFinishing()) {
                        com.amgcyo.cuttadon.f.o.a((Activity) MkBookshelfFragment.this.getActivity());
                        com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[MENU]分享好友");
                    }
                    break;
                case R.id.tv_batch_book /* 2131298603 */:
                    com.amgcyo.cuttadon.utils.otherutils.r0.b(((com.amgcyo.cuttadon.fragment.base.a) MkBookshelfFragment.this).f3725t, MkBookshelfFragment.this.f3754i0.getForm());
                    break;
                case R.id.tv_copy_book /* 2131298650 */:
                    if (((com.amgcyo.cuttadon.fragment.base.a) MkBookshelfFragment.this).f3725t == null) {
                        return;
                    }
                    String name = MkBookshelfFragment.this.f3754i0.getName();
                    String author = MkBookshelfFragment.this.f3754i0.getAuthor();
                    String reading_site_id = MkBookshelfFragment.this.f3754i0.getReading_site_id();
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(name)) {
                        sb.append("书名：");
                        sb.append(name);
                    }
                    if (!TextUtils.isEmpty(author)) {
                        sb.append(" 作者：");
                        sb.append(author);
                    }
                    if (!TextUtils.isEmpty(reading_site_id)) {
                        sb.append(" 书源：");
                        sb.append(reading_site_id);
                    }
                    com.amgcyo.cuttadon.f.o.a(((com.amgcyo.cuttadon.fragment.base.a) MkBookshelfFragment.this).f3725t, sb.toString(), R.string.copy_suc);
                    break;
            }
            if (MkBookshelfFragment.this.f3755j0 == null || !MkBookshelfFragment.this.f3755j0.isShowing()) {
                return;
            }
            MkBookshelfFragment.this.f3755j0.dismiss();
        }
    }

    class c implements n1.c {
        final /* synthetic */ MkBook a;

        c(MkBook mkBook) {
            this.a = mkBook;
        }

        @Override // com.amgcyo.cuttadon.view.dialog.n1.c
        public void a(String str) {
            MkBookshelfFragment.this.a(str, this.a);
        }

        @Override // com.amgcyo.cuttadon.view.dialog.n1.c
        public void a() {
            MkBook mkBook = this.a;
            if (mkBook != null) {
                MkBookshelfFragment.this.c(mkBook);
            }
            if (MkBookshelfFragment.this.f3758m0 == null || !MkBookshelfFragment.this.f3758m0.isShowing()) {
                return;
            }
            MkBookshelfFragment.this.f3758m0.dismiss();
        }
    }

    class d implements d.c {
        final /* synthetic */ MkBook a;

        d(MkBook mkBook) {
            this.a = mkBook;
        }

        @Override // com.amgcyo.cuttadon.widget.lovelydialog.d.c
        public void a(String str) {
            MkBookshelfFragment.this.a(str, this.a);
        }
    }

    class e implements NovelSourceDrawerPopup.b {
        final /* synthetic */ MkBook a;

        class a extends com.amgcyo.cuttadon.j.g.h.b<Object> {
            final /* synthetic */ MkBook b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, MkBook mkBook) {
                super(obj);
                this.b = mkBook;
            }

            @Override // com.amgcyo.cuttadon.j.g.g.a
            public Void a(Object obj) {
                MkBookshelfFragment.this.s().a(this.b.getReading_site_id(), this.b.getReading_site_path(), this.b.getReading_site_id(), this.b.getBook_id(), this.b.getSite_path_reload(), this.b.getCrawl_book_id());
                return null;
            }
        }

        e(MkBook mkBook) {
            this.a = mkBook;
        }

        @Override // com.amgcyo.cuttadon.view.popupview.NovelSourceDrawerPopup.b
        public void a(MkBook mkBook) {
            if (mkBook == null || TextUtils.isEmpty(mkBook.getReading_site_path())) {
                return;
            }
            this.a.setReading_site_path(mkBook.getReading_site_path());
            this.a.setReading_site_id(mkBook.getReading_site_id());
            this.a.setSiteName(mkBook.getSiteName());
            this.a.setCrawl_book_id(mkBook.getCrawl_book_id());
            this.a.setSite_path_reload(mkBook.getSite_path_reload());
            MkBookshelfFragment.this.d(this.a);
            com.amgcyo.cuttadon.j.g.b.a(new a("", mkBook));
        }

        @Override // com.amgcyo.cuttadon.view.popupview.NovelSourceDrawerPopup.b
        public void b(MkBook mkBook) {
            ((BookPresenter) ((com.amgcyo.cuttadon.fragment.base.a) MkBookshelfFragment.this).f3726u).m(Message.a(MkBookshelfFragment.this, new Object[]{Integer.valueOf(mkBook.getBook_id())}));
        }
    }

    class f implements d.c {
        final /* synthetic */ List a;

        f(List list) {
            this.a = list;
        }

        @Override // com.amgcyo.cuttadon.widget.lovelydialog.d.c
        public void a(String str) {
            if (TextUtils.isEmpty(str) || com.amgcyo.cuttadon.f.o.d(R.string.book_shelf).equals(str)) {
                str = null;
            }
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                MkBookshelfFragment.this.s().a(str, ((MkBook) it.next()).getBook_id());
            }
            MkBookshelfFragment.this.showMessage("修改分组成功");
        }
    }

    class g extends BroadcastReceiver {
        g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MkBookshelfFragment.this.R = true;
            int i2 = 0;
            int intExtra = intent.getIntExtra("total", 0);
            int intExtra2 = intent.getIntExtra(NotificationCompat.CATEGORY_PROGRESS, 0);
            int intExtra3 = intent.getIntExtra("book_id", 0);
            String str = "传递的id：" + intExtra3;
            if (MkBookshelfFragment.this.f3760o0 != null && MkBookshelfFragment.this.f3760o0.isShowing()) {
                MkBookshelfFragment.this.f3760o0.a(intExtra, intExtra2, intExtra3);
                return;
            }
            while (true) {
                if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) MkBookshelfFragment.this.I) || i2 >= MkBookshelfFragment.this.I.size() || MkBookshelfFragment.this.P >= 0) {
                    break;
                }
                Object obj = MkBookshelfFragment.this.I.get(i2);
                if (obj instanceof MkBook) {
                    MkBook mkBook = (MkBook) obj;
                    if (mkBook.getBook_id() == intExtra3) {
                        MkBookshelfFragment.this.P = i2;
                        MkBookshelfFragment.this.Q = mkBook;
                        String str2 = "找到需要更新的位置：" + MkBookshelfFragment.this.P;
                        break;
                    }
                }
                i2++;
            }
            if (MkBookshelfFragment.this.Q != null && MkBookshelfFragment.this.P >= 0) {
                MkBookshelfFragment mkBookshelfFragment = MkBookshelfFragment.this;
                if (mkBookshelfFragment.J != null) {
                    mkBookshelfFragment.Q.setCacheTotalSize(intExtra);
                    MkBookshelfFragment.this.Q.setCacheProgress(intExtra2);
                    MkBookshelfFragment mkBookshelfFragment2 = MkBookshelfFragment.this;
                    mkBookshelfFragment2.J.notifyItemChanged(mkBookshelfFragment2.P);
                }
            }
            if (intExtra2 == intExtra - 1) {
                com.amgcyo.cuttadon.f.o.b("缓存完成!");
                MkBookshelfFragment.this.P = -1;
                MkBookshelfFragment.this.Q = null;
                MkApplication.getAppContext().downloadArray.clear();
            }
        }
    }

    private boolean A() {
        Context context = this.f3725t;
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
        String packageName = this.f3725t.getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    private void B() {
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_book_shelf_top", "csj_new_position_shelf");
        if (normalAdParamsA != null) {
            normalAdParamsA.setFailRestart(true);
            normalAdParamsA.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3710x);
            this.adFrameLayout.b(normalAdParamsA);
        }
    }

    private void C() {
        ((BookPresenter) this.f3726u).D(Message.a(this, new Object[]{Integer.valueOf(this.O)}));
    }

    private void D() {
        final String strE = com.amgcyo.cuttadon.utils.otherutils.z.e();
        this.f3748c0 = com.amgcyo.cuttadon.utils.otherutils.g.L();
        com.amgcyo.cuttadon.k.c.a aVar = (com.amgcyo.cuttadon.k.c.a) new ViewModelProvider(this).get(com.amgcyo.cuttadon.k.c.a.class);
        aVar.c().observe(this, new Observer() { // from class: com.amgcyo.cuttadon.fragment.books.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) throws Throwable {
                this.a.a(strE, (List) obj);
            }
        });
        aVar.d().observe(this, new Observer() { // from class: com.amgcyo.cuttadon.fragment.books.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) throws Throwable {
                this.a.a(strE, (MkUser) obj);
            }
        });
        aVar.a().observe(this, new Observer() { // from class: com.amgcyo.cuttadon.fragment.books.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) throws Throwable {
                this.a.b(strE, (List) obj);
            }
        });
        aVar.b().observe(this, new Observer() { // from class: com.amgcyo.cuttadon.fragment.books.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) throws Throwable {
                this.a.c(strE, (List) obj);
            }
        });
        ((com.amgcyo.cuttadon.k.c.b) new ViewModelProvider(this).get(com.amgcyo.cuttadon.k.c.b.class)).a().observe(this, new Observer() { // from class: com.amgcyo.cuttadon.fragment.books.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) throws Throwable {
                this.a.d(strE, (List) obj);
            }
        });
    }

    private void E() {
        if (this.f3749d0 != null) {
            this.f3748c0 = com.amgcyo.cuttadon.utils.otherutils.g.L();
            String str = "更新" + this.f3749d0.getName();
            s().f(String.valueOf(System.currentTimeMillis()), this.f3749d0.getBook_id());
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "tag_bookshelf__operate")
    private void bookAndAdOperate(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            w();
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "add_delete_book")
    private void bookOperate(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            w();
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "hide_loading")
    private void hideLoading(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            w();
        }
    }

    @Subscriber(mode = ThreadMode.POST, tag = "merge_book")
    private void mergeBook(com.amgcyo.cuttadon.view.read.page.i iVar) {
        if (iVar == null) {
            return;
        }
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.amgcyo.cuttadon.database.f s() {
        if (this.K == null) {
            this.K = AppDatabase.i().a();
        }
        return this.K;
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "comic_tag_sort_shelf")
    private void sortShelf(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            int iF = mkCommentEvent.f();
            if (iF == -32768) {
                E();
                return;
            }
            if (iF == 32767) {
                if (this.f3749d0 != null) {
                    E();
                }
            } else if (iF == 0 || iF == 1) {
                e(iF);
            }
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "tag_daoliu_view")
    private void subscriberDaoliuView(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent != null) {
            com.amgcyo.cuttadon.utils.otherutils.g.r0();
            onRefresh();
        }
    }

    @Subscriber(mode = ThreadMode.POST, tag = "refreshingBookShelf")
    private void subscriberRefeshShelfWhenLogin(MkUser mkUser) {
        String str = "isOnFirstVisible:" + this.W + " 当前form：" + this.O;
        if (mkUser != null && mkUser.isLogin() && this.W) {
            showMessage("正在同步云端书架...");
            this.mRefreshView.setRefreshing(true);
            if (com.amgcyo.cuttadon.utils.otherutils.h.H0()) {
                this.V = true;
            }
            b(true);
        }
    }

    private void t() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
            b(false);
        } else {
            C();
        }
    }

    private int u() {
        return this.N;
    }

    private int v() {
        return this.M;
    }

    private void w() {
        hideLoading();
        com.amgcyo.cuttadon.view.otherview.m mVar = this.f3755j0;
        if (mVar == null || !mVar.isShowing()) {
            return;
        }
        this.f3755j0.dismiss();
    }

    private void x() {
        this.J = new me.drakeet.multitype.d();
        this.mRefreshView.setColorSchemeColors(com.amgcyo.cuttadon.utils.otherutils.g.a(R.color.colorPrimary), SupportMenu.CATEGORY_MASK);
        this.mRefreshView.measure(0, 0);
        this.mRefreshView.setRefreshing(true);
        this.mRefreshView.setOnRefreshListener(this);
        this.mRecyclerView.setItemAnimator(null);
        MkFattenBeanItem mkFattenBeanItem = new MkFattenBeanItem(this, this.f3728w);
        MkShelfCategoryDataItem mkShelfCategoryDataItem = new MkShelfCategoryDataItem(this, this.f3728w, this);
        MkAddBookItem mkAddBookItem = new MkAddBookItem(this);
        MkShelfBookDataItem mkShelfBookDataItem = new MkShelfBookDataItem(this, this.f3728w, this);
        this.G = com.amgcyo.cuttadon.utils.otherutils.g.K();
        this.J.a(MkFattenBean.class, mkFattenBeanItem);
        this.J.a(NormalAdParams.class, new MkBookCityBaseAdIVBNew(this.f3725t));
        this.J.a(ShelfCategory.class, mkShelfCategoryDataItem);
        this.J.a(MkAddBook.class, mkAddBookItem);
        this.J.a(MkBook.class, mkShelfBookDataItem);
        if (this.G == 0) {
            z();
        } else {
            y();
        }
        this.J.a(this.I);
        this.mRecyclerView.setAdapter(this.J);
        this.mRecyclerView.addOnScrollListener(new com.amgcyo.cuttadon.f.q(this.f3725t));
        D();
        t();
    }

    private void y() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f3725t, 3);
        gridLayoutManager.setSpanSizeLookup(new a(this));
        this.mRecyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView.ItemDecoration itemDecoration = this.f3751f0;
        if (itemDecoration != null) {
            this.mRecyclerView.removeItemDecoration(itemDecoration);
        }
        GridItemDecoration.a aVarA = RecyclerViewDivider.a();
        aVarA.a(0);
        aVarA.b(com.amgcyo.cuttadon.utils.otherutils.n.a(20.0f));
        aVarA.e();
        GridItemDecoration gridItemDecorationA = aVarA.a();
        gridItemDecorationA.a(this.mRecyclerView);
        this.f3751f0 = gridItemDecorationA;
    }

    private void z() {
        RecyclerView.ItemDecoration itemDecoration = this.f3751f0;
        if (itemDecoration != null) {
            this.mRecyclerView.removeItemDecoration(itemDecoration);
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.fragment_bookshelf;
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        int i2 = message.f21197s;
        if (i2 == 825) {
            List<MkBook> list = (List) message.f21202x;
            this.mRecyclerView.setItemViewCacheSize(list.size());
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                this.mRecyclerView.setVisibility(8);
                this.ll_bookNull.setVisibility(0);
            } else {
                this.mRecyclerView.setVisibility(0);
                this.ll_bookNull.setVisibility(8);
                list.size();
            }
            a(list);
            this.mRefreshView.setRefreshing(false);
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("bookshelf_time" + this.O, System.currentTimeMillis() / 1000);
            if (this.V) {
                this.V = false;
                return;
            }
            return;
        }
        if (i2 == 826) {
            PullToRefreshView pullToRefreshView = this.mRefreshView;
            if (pullToRefreshView != null) {
                pullToRefreshView.setRefreshing(false);
                return;
            }
            return;
        }
        if (i2 == 857) {
            hideLoading();
            hideLoading();
            d((MkBook) message.f21202x);
        } else {
            if (i2 != 897) {
                return;
            }
            List<MkSiteBean> list2 = (List) message.f21202x;
            if (this.f3759n0 != null) {
                if (com.amgcyo.cuttadon.utils.otherutils.g.a(list2)) {
                    this.f3759n0.g();
                } else {
                    this.f3759n0.a(list2, (com.amgcyo.cuttadon.utils.otherutils.k) null);
                }
            }
        }
    }

    @Override // me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
    }

    @Override // com.amgcyo.cuttadon.g.a
    public void moreClickListener(MkBook mkBook) {
        if (this.f3725t == null || mkBook == null) {
            return;
        }
        o();
        this.f3753h0 = new m.b(this.f3725t);
        this.f3754i0 = mkBook;
        com.amgcyo.cuttadon.view.otherview.m mVar = this.f3755j0;
        if (mVar == null || mVar.isShowing()) {
            m.b bVar = this.f3753h0;
            bVar.a(true);
            bVar.a(R.layout.dialog_shelf_edit);
            bVar.a(mkBook, this.f3728w);
            bVar.a(R.id.rl_detail, this.f3756k0);
            bVar.a(R.id.tv_copy_book, this.f3756k0);
            bVar.a(R.id.tv_batch_book, this.f3756k0);
            bVar.a(R.id.muluLayout, this.f3756k0);
            bVar.a(R.id.chatLayout, this.f3756k0);
            bVar.a(R.id.download_layout, this.f3756k0);
            bVar.a(R.id.delete_layout, this.f3756k0);
            bVar.a(R.id.clear_layout, this.f3756k0);
            bVar.a(R.id.shareLayout, this.f3756k0);
            bVar.a(R.id.switch_book_jpush, this.f3757l0);
            bVar.a(R.id.switch_book_top, this.f3757l0);
            this.f3755j0 = bVar.a();
            if (this.f3753h0.b() != null && !this.f3755j0.isShowing()) {
                this.f3755j0.show();
            }
            this.f3755j0.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.amgcyo.cuttadon.fragment.books.p
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f3825s.b(dialogInterface);
                }
            });
        }
    }

    @OnClick({R.id.tv_findBookCity})
    public void onClick(View view) {
        if (com.amgcyo.cuttadon.fragment.base.a.n()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
        } else if (view.getId() == R.id.tv_findBookCity) {
            m();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.L == null || !this.R) {
                return;
            }
            this.f3725t.unregisterReceiver(this.L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amgcyo.cuttadon.g.a
    public void onItemCategoryClick(ShelfCategory shelfCategory) {
        if (shelfCategory == null) {
            return;
        }
        List<MkBook> artBookList = shelfCategory.getArtBookList();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(artBookList)) {
            return;
        }
        this.f3760o0 = new o1(this.f3725t);
        this.f3760o0.show();
        this.f3760o0.a(this, shelfCategory.getCategoryName(), artBookList, this.f3728w);
        this.f3760o0.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.amgcyo.cuttadon.fragment.books.v
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f3827s.c(dialogInterface);
            }
        });
    }

    @Override // com.amgcyo.cuttadon.g.a
    public void onItemCategoryLongClick(ShelfCategory shelfCategory) {
        if (shelfCategory == null) {
            return;
        }
        List<MkBook> artBookList = shelfCategory.getArtBookList();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(artBookList)) {
            return;
        }
        com.amgcyo.cuttadon.f.o.a(this.f3725t, R.string.text_input_error_catename, shelfCategory.getCategoryName(), "提示", "请输入自定义分类名称", new f(artBookList), (View.OnClickListener) null);
    }

    @Override // com.amgcyo.cuttadon.g.a
    public void onItemClick(MkBook mkBook) {
        List<Integer> shield_data = mkBook.getShield_data();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(shield_data) && shield_data.contains(Integer.valueOf(com.amgcyo.cuttadon.utils.otherutils.g.l())) && com.amgcyo.cuttadon.utils.otherutils.h.u0()) {
            a("该书籍已下架!");
            return;
        }
        o();
        if (1 != mkBook.getForm()) {
            com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f3725t, mkBook);
            a(mkBook);
            return;
        }
        String str = "site:" + mkBook.getReading_site_id() + " reload:" + mkBook.getSite_path_reload();
        if (!TextUtils.isEmpty(mkBook.getReading_site_id()) && !TextUtils.isEmpty(mkBook.getSite_path_reload())) {
            d(mkBook);
        } else {
            f(mkBook);
            com.amgcyo.cuttadon.utils.otherutils.x0.c().b();
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.T = true;
        com.amgcyo.cuttadon.view.otherview.m mVar = this.f3755j0;
        if (mVar != null && mVar.isShowing()) {
            this.f3755j0.dismiss();
            this.f3755j0 = null;
        }
        q1 q1Var = this.f3752g0;
        if (q1Var != null && q1Var.isShowing()) {
            this.f3752g0.dismiss();
            this.f3752g0 = null;
        }
        if (A()) {
            return;
        }
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("bg_key_" + this.O, System.currentTimeMillis() / 1000);
        this.U = false;
    }

    @Override // com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.j
    public void onRefresh() {
        this.mRefreshView.setRefreshing(true);
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
            b(false);
            return;
        }
        if (com.amgcyo.cuttadon.h.a.c.a("bookshelf_time" + this.O, com.amgcyo.cuttadon.utils.otherutils.h.S())) {
            C();
            return;
        }
        PullToRefreshView pullToRefreshView = this.mRefreshView;
        if (pullToRefreshView != null) {
            pullToRefreshView.setRefreshing(false);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        p();
        try {
            q();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        this.D = z2;
    }

    private void o() {
        try {
            if (this.f3760o0 == null || !this.f3760o0.isShowing()) {
                return;
            }
            this.f3760o0.dismiss();
        } catch (Exception unused) {
        }
    }

    private void p() {
        if (MkApplication.getAppContext().downloadArray.size() > 0) {
            if (this.L == null) {
                this.L = new g();
            }
            this.f3725t.registerReceiver(this.L, new IntentFilter("com.example.servicecallback.content"));
        }
    }

    private void q() {
        if (getParentFragment() != null && ((BookAndComicFragment) getParentFragment()).D && this.O > 0 && this.D && this.T && !this.U) {
            this.U = true;
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            if ((jCurrentTimeMillis - com.amgcyo.cuttadon.utils.otherutils.g0.a().a("bookshelf_time" + this.O, jCurrentTimeMillis)) / 60 >= 20) {
                r();
            }
        }
        this.T = false;
    }

    private void r() {
        this.mRefreshView.setRefreshing(true);
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
            b(false);
        } else {
            C();
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a
    protected void f() {
        super.f();
        this.W = true;
        B();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.O = arguments.getInt("form", 1);
        }
        x();
        if (this.O == 3) {
            com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[SHELF]主页_mh");
        } else {
            com.amgcyo.cuttadon.h.a.h.a(this.f3725t, "bookself");
            com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[SHELF]主页_xs");
        }
        if (com.amgcyo.cuttadon.utils.otherutils.h.I0()) {
            this.constraintlayout.setVisibility(0);
            this.tv_shelf_fission6.setText(com.amgcyo.cuttadon.f.o.c(R.string.shelf_fission6_tips));
            this.tv_vali.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.fragment.books.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3801s.a(view);
                }
            });
        }
    }

    public void l() {
        this.S = new p1(this.f3725t);
        this.S.show();
        this.S.a(new p1.a() { // from class: com.amgcyo.cuttadon.fragment.books.s
            @Override // com.amgcyo.cuttadon.view.dialog.p1.a
            public final void a(ShelfSortBean shelfSortBean) {
                me.jessyan.art.d.f.a().a(new MkCommentEvent(-32768), "comic_tag_sort_shelf");
            }
        });
        this.S.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.amgcyo.cuttadon.fragment.books.z
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f3831s.a(dialogInterface);
            }
        });
    }

    public void m() {
        MkMainActivity mkMainActivity = (MkMainActivity) getActivity();
        if (mkMainActivity != null) {
            mkMainActivity.toBookCity(this.O);
        }
    }

    @Override // me.jessyan.art.base.f.i
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }

    private void b(boolean z2) {
        ((BookPresenter) this.f3726u).C(Message.a(this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(this.O)}));
    }

    public static MkBookshelfFragment d(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("form", i2);
        MkBookshelfFragment mkBookshelfFragment = new MkBookshelfFragment();
        mkBookshelfFragment.setArguments(bundle);
        return mkBookshelfFragment;
    }

    private void e(int i2) {
        if (1 == i2) {
            this.G = 1;
            y();
        } else if (i2 == 0) {
            this.G = 0;
            z();
        }
        this.mRecyclerView.setAdapter(this.J);
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("ShelfModel", i2);
    }

    public /* synthetic */ void c(String str, List list) throws Throwable {
        if (this.f3746a0 == null) {
            this.f3746a0 = new File(str, "site_regular.json");
        }
        com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list);
        com.amgcyo.cuttadon.utils.otherutils.z.a(com.amgcyo.cuttadon.utils.otherutils.r.a(list), this.f3746a0);
    }

    public /* synthetic */ void b(String str, List list) throws Throwable {
        if (this.Z == null) {
            this.Z = new File(str, "comment.json");
        }
        com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list);
        com.amgcyo.cuttadon.utils.otherutils.z.a(com.amgcyo.cuttadon.utils.otherutils.r.a(list), this.Z);
    }

    private void c(int i2) {
        int iA;
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(com.amgcyo.cuttadon.sdk.utils.i.a("bookself", "center")) && i2 >= (iA = com.amgcyo.cuttadon.sdk.utils.i.a("interval_count", "bookself", "center")) && iA > 0) {
            int i3 = 1;
            for (int i4 = 0; i4 < i2; i4++) {
                if (i4 % iA == 0) {
                    if (i4 == 0) {
                        a("if对象：", iA);
                    } else {
                        int i5 = i4 + iA + i3;
                        if (i5 < this.I.size()) {
                            a("else对象：", i5);
                        }
                        i3 += iA;
                    }
                }
            }
        }
    }

    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.S = null;
    }

    public /* synthetic */ void d(String str, List list) throws Throwable {
        if (this.f3747b0 == null) {
            this.f3747b0 = new File(str, "read_history.json");
        }
        com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list);
        com.amgcyo.cuttadon.utils.otherutils.z.a(com.amgcyo.cuttadon.utils.otherutils.r.a(list), this.f3747b0);
    }

    private void b(List<MkBook> list) {
        int size;
        if (this.f3750e0 == null) {
            this.f3750e0 = new ArrayList();
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(this.f3750e0)) {
            this.f3750e0.clear();
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
            for (MkBook mkBook : list) {
                if (this.O == mkBook.getForm()) {
                    this.f3750e0.add(mkBook);
                }
            }
        }
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f3750e0)) {
            this.mRecyclerView.setVisibility(8);
            this.ll_bookNull.setVisibility(0);
            this.mRefreshView.setRefreshing(false);
            size = 0;
        } else {
            size = this.f3750e0.size();
            this.f3749d0 = this.f3750e0.get(0);
            for (MkBook mkBook2 : this.f3750e0) {
                mkBook2.setShow_update_at(com.amgcyo.cuttadon.utils.otherutils.y.b(mkBook2.getUpdated_at()));
                mkBook2.setShow_last_read_at(com.amgcyo.cuttadon.utils.otherutils.y.c(com.amgcyo.cuttadon.utils.otherutils.t0.d(mkBook2.getReading_datetime() * 1000)));
            }
            a(this.f3750e0);
            this.mRecyclerView.setVisibility(0);
            this.ll_bookNull.setVisibility(8);
        }
        if (size > 0) {
            this.ll_book_size.setVisibility(0);
            String str = this.O == 3 ? "漫画" : "小说";
            this.tv_bottom_text.setText(String.format(Locale.getDefault(), "当前%s书架已收藏%d本%s", str, Integer.valueOf(size), str));
            return;
        }
        this.ll_book_size.setVisibility(8);
    }

    public /* synthetic */ void a(View view) {
        com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, Fission6IndexActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MkBook mkBook) {
        this.f3758m0 = new n1(this.f3725t);
        this.f3758m0.show();
        this.f3758m0.a(new c(mkBook));
        this.f3758m0.a(this.I, this.f3728w);
        this.f3758m0.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.amgcyo.cuttadon.fragment.books.y
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f3830s.d(dialogInterface);
            }
        });
    }

    public /* synthetic */ void a(String str, List list) throws Throwable {
        if (this.X == null) {
            this.X = new File(str, "shelf.json");
        }
        if ("sort_by_last_read_time".equals(this.f3748c0)) {
            com.amgcyo.cuttadon.utils.otherutils.q0.a(list, new String[]{"is_top", "reading_datetime"}, new String[]{"desc", "desc"});
        } else {
            com.amgcyo.cuttadon.utils.otherutils.q0.a(list, new String[]{"is_top", "updated_at"}, new String[]{"desc", "desc"});
        }
        b((List<MkBook>) list);
        com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list);
        com.amgcyo.cuttadon.utils.otherutils.z.a(com.amgcyo.cuttadon.utils.otherutils.r.a(list), this.X);
    }

    public /* synthetic */ void d(DialogInterface dialogInterface) {
        this.f3758m0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MkBook mkBook) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", mkBook);
        bundle.putInt("is_from_fuli_source", v());
        bundle.putInt("is_from_fuli_cache", u());
        if (com.amgcyo.cuttadon.view.read.page.m.a(this.f3725t)) {
            com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, bundle, MkReadModelHActivity.class);
            com.amgcyo.cuttadon.utils.otherutils.x0.c().a(1, mkBook.getBook_id(), mkBook.getRead_begin(), "水平", mkBook.getUpdated());
        } else {
            com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f3725t, bundle, MkReadModelVActivity.class);
            com.amgcyo.cuttadon.utils.otherutils.x0.c().a(1, mkBook.getBook_id(), mkBook.getRead_begin(), "上下", mkBook.getUpdated());
        }
        a(mkBook);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MkBook mkBook) {
        com.amgcyo.cuttadon.f.o.a(this.f3725t, R.string.text_input_error_catename, (String) null, "提示", "请输入自定义分类名称", new d(mkBook), (View.OnClickListener) null);
    }

    public /* synthetic */ void c(DialogInterface dialogInterface) {
        this.f3760o0 = null;
    }

    private void f(MkBook mkBook) {
        a.b bVar = new a.b(this.f3725t);
        bVar.a(PopupPosition.Left);
        bVar.e(true);
        NovelSourceDrawerPopup novelSourceDrawerPopup = new NovelSourceDrawerPopup((BaseTitleBarActivity) this.f3725t, mkBook);
        bVar.a((BasePopupView) novelSourceDrawerPopup);
        this.f3759n0 = (NovelSourceDrawerPopup) novelSourceDrawerPopup.u();
        this.f3759n0.setListener(new e(mkBook));
    }

    public /* synthetic */ void a(String str, MkUser mkUser) throws Throwable {
        if (this.Y == null) {
            this.Y = new File(str, "user.json");
        }
        com.amgcyo.cuttadon.utils.otherutils.z.a(com.amgcyo.cuttadon.utils.otherutils.r.a(mkUser), this.Y);
    }

    private void a(List<MkBook> list) {
        if (this.I == null) {
            this.I = new ArrayList();
        }
        this.I.clear();
        int iK = s().k(this.O);
        List<String> listF = s().f(this.O);
        String strA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("shelf_fatten_key", "sort_fatten_by_first");
        if ("sort_fatten_by_first".equals(strA)) {
            a(iK, listF);
        }
        ArrayList<MkBook> arrayList = new ArrayList();
        for (MkBook mkBook : list) {
            if (mkBook.getIs_fatten() == 0) {
                arrayList.add(mkBook);
            }
        }
        HashMap map = new HashMap();
        for (MkBook mkBook2 : arrayList) {
            if (map.containsKey(mkBook2.getBook_shelf_category())) {
                List list2 = (List) map.get(mkBook2.getBook_shelf_category());
                if (list2 != null) {
                    list2.add(mkBook2);
                }
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(mkBook2);
                map.put(mkBook2.getBook_shelf_category(), arrayList2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = map.entrySet().iterator();
        while (true) {
            int i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List<MkBook> list3 = (List) entry.getValue();
            if (!TextUtils.isEmpty(str)) {
                ShelfCategory shelfCategory = new ShelfCategory();
                ArrayList arrayList4 = new ArrayList();
                shelfCategory.setCategoryCount(list3.size());
                shelfCategory.setCategoryName(str);
                for (MkBook mkBook3 : list3) {
                    arrayList4.add(new CategoryComicBean(mkBook3.getImage(), mkBook3.getForm()));
                    if (mkBook3.getUpdated() == 0) {
                        i2++;
                    }
                }
                shelfCategory.setUpdateCount(i2);
                shelfCategory.setCategoryPics(arrayList4);
                shelfCategory.setArtBookList(list3);
                this.I.add(shelfCategory);
            } else {
                arrayList3.addAll(list3);
            }
        }
        this.I.addAll(arrayList3);
        try {
            c(this.I.size());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if ("sort_fatten_by_last".equals(strA)) {
            a(iK, listF);
        }
        this.I.add(this.H);
        me.drakeet.multitype.d dVar = this.J;
        if (dVar != null) {
            dVar.notifyItemRangeChanged(0, this.I.size());
        }
        this.P = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MkBook mkBook) {
        if (mkBook == null) {
            showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.clear_cache_error));
            return;
        }
        if (3 == mkBook.getForm()) {
            if (s().b(String.valueOf(System.currentTimeMillis()), mkBook.getBook_id()) > 0) {
                com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.clear_cache_success);
            } else {
                com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.clear_cache_error);
            }
        }
        com.amgcyo.cuttadon.j.a.e.a((BaseTitleBarActivity) this.f3725t, com.amgcyo.cuttadon.utils.otherutils.z.a(mkBook), true, (com.amgcyo.cuttadon.j.e.b) null, true);
    }

    public /* synthetic */ void b(int i2, String str) {
        String str2 = "操作类型：" + str;
        if (com.anythink.expressad.d.a.b.ay.equals(str)) {
            s().k(1, i2);
        } else if (com.anythink.expressad.d.a.b.az.equals(str)) {
            s().k(0, i2);
        } else {
            String str3 = "操作类型：" + str;
        }
        w();
    }

    public /* synthetic */ void b(DialogInterface dialogInterface) {
        this.f3753h0 = null;
        this.f3754i0 = null;
        this.f3755j0 = null;
    }

    private void a(String str, int i2) {
        NormalAdParams normalAdParamsA = com.amgcyo.cuttadon.sdk.utils.e.a("position_book_shelf_center", "csj_new_position_shelf");
        if (normalAdParamsA != null) {
            normalAdParamsA.setSelfAdPosition(com.amgcyo.cuttadon.f.n.f3711y);
            this.I.add(i2, normalAdParamsA);
        }
    }

    private void a(int i2, List<String> list) {
        if (i2 > 0) {
            this.I.add(new MkFattenBean(this.O, com.amgcyo.cuttadon.f.o.d(R.string.fatten_str), i2, s().g(com.amgcyo.cuttadon.utils.otherutils.g.O(), this.O), list));
        }
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        MkBook mkBook;
        if (compoundButton.isPressed() && (mkBook = this.f3754i0) != null) {
            final int book_id = mkBook.getBook_id();
            switch (compoundButton.getId()) {
                case R.id.switch_book_jpush /* 2131298434 */:
                    if (!com.amgcyo.cuttadon.utils.otherutils.g0.a().a("swtich_jpush", true)) {
                        showMessage("请在设置中先开启个性化内容推荐");
                        compoundButton.setChecked(false);
                    } else {
                        showLoading("正在处理...");
                        String strValueOf = String.valueOf(book_id);
                        String str = "bookId:" + strValueOf;
                        com.amgcyo.cuttadon.i.o oVar = new com.amgcyo.cuttadon.i.o() { // from class: com.amgcyo.cuttadon.fragment.books.x
                            @Override // com.amgcyo.cuttadon.i.o
                            public final void a(String str2) {
                                this.a.b(book_id, str2);
                            }
                        };
                        if (this.f3754i0.getJpush_status() == 1) {
                            com.amgcyo.cuttadon.i.n.a(com.anythink.expressad.d.a.b.az, oVar, strValueOf);
                        } else {
                            com.amgcyo.cuttadon.i.n.a(com.anythink.expressad.d.a.b.ay, oVar, strValueOf);
                        }
                        com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[MENU]更新提醒");
                    }
                    break;
                case R.id.switch_book_top /* 2131298435 */:
                    int is_top = this.f3754i0.getIs_top();
                    if (s().d(is_top == 1 ? 0 : 1, book_id) > 0) {
                        this.f3754i0.setIs_top(is_top == 1 ? 0 : 1);
                        showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.zhiding_success));
                        if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
                            try {
                                if (is_top == 1) {
                                    ((BookPresenter) this.f3726u).K(Message.a(this, new Object[]{Integer.valueOf(book_id), Integer.valueOf(this.f3754i0.getForm())}));
                                } else {
                                    ((BookPresenter) this.f3726u).J(Message.a(this, new Object[]{Integer.valueOf(book_id), Integer.valueOf(this.f3754i0.getForm())}));
                                }
                                break;
                            } catch (Exception unused) {
                            }
                        }
                    } else {
                        showMessage(com.amgcyo.cuttadon.utils.otherutils.g.g(R.string.zhiding_error));
                    }
                    w();
                    com.amgcyo.cuttadon.utils.otherutils.x0.c().a("[MENU]置顶");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MkBook mkBook) {
        if (TextUtils.isEmpty(str) || com.amgcyo.cuttadon.f.o.d(R.string.book_shelf).equals(str)) {
            str = null;
        }
        if (s().a(str, mkBook.getBook_id()) > 0) {
            if (TextUtils.isEmpty(str)) {
                showMessage("已成功放回书架");
            } else {
                showMessage("成功放入“" + str + "”中");
            }
        }
        n1 n1Var = this.f3758m0;
        if (n1Var == null || !n1Var.isShowing()) {
            return;
        }
        this.f3758m0.dismiss();
    }

    private void a(MkBook mkBook) {
        final int book_id = mkBook.getBook_id();
        MkBook mkBookI = s().i(book_id);
        if (mkBookI == null || mkBookI.getJpush_status() != 1) {
            return;
        }
        String strA = com.amgcyo.cuttadon.utils.otherutils.t0.a();
        String jpush_today_time = mkBookI.getJpush_today_time();
        String str = "今日时间：" + strA + " 本书上次极光推送检查时间：" + jpush_today_time;
        if (TextUtils.isEmpty(jpush_today_time) || !jpush_today_time.equals(strA)) {
            com.amgcyo.cuttadon.i.n.a(com.anythink.expressad.d.a.b.ay, new com.amgcyo.cuttadon.i.o() { // from class: com.amgcyo.cuttadon.fragment.books.w
                @Override // com.amgcyo.cuttadon.i.o
                public final void a(String str2) {
                    this.a.a(book_id, str2);
                }
            }, String.valueOf(book_id));
        }
    }

    public /* synthetic */ void a(int i2, String str) {
        String strA = com.amgcyo.cuttadon.utils.otherutils.t0.a();
        s().c(strA, i2);
        String str2 = "更新" + strA;
    }
}
