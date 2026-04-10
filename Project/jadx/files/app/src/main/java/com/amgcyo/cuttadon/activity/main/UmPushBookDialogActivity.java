package com.amgcyo.cuttadon.activity.main;

import android.app.NotificationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.read.MkReadModelHActivity;
import com.amgcyo.cuttadon.activity.read.MkReadModelVActivity;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkSiteBean;
import com.amgcyo.cuttadon.api.presenter.BookPresenter;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.amgcyo.cuttadon.view.popupview.NovelSourceDrawerPopup;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.umeng.message.entity.UMessage;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class UmPushBookDialogActivity extends BaseTitleBarActivity<BookPresenter> {

    @BindView(R.id.book_cover)
    ImageView book_cover;

    @BindView(R.id.btn_add_shelf)
    TextView btn_add_shelf;

    @BindView(R.id.btn_exit)
    TextView btn_exit;

    @BindView(R.id.ff)
    FrameLayout ff;

    @BindView(R.id.iv_close)
    ImageView iv_close;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private NovelSourceDrawerPopup f2630n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private com.amgcyo.cuttadon.database.f f2631o0;

    @BindView(R.id.tv_author)
    TextView tv_author;

    @BindView(R.id.tv_tips)
    TextView tv_tips;

    @BindView(R.id.tv_word_count)
    TextView tv_word_count;

    class a implements NovelSourceDrawerPopup.b {
        final /* synthetic */ MkBook a;

        /* JADX INFO: renamed from: com.amgcyo.cuttadon.activity.main.UmPushBookDialogActivity$a$a, reason: collision with other inner class name */
        class C0084a extends com.amgcyo.cuttadon.j.g.h.b<Object> {
            final /* synthetic */ MkBook b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0084a(Object obj, MkBook mkBook) {
                super(obj);
                this.b = mkBook;
            }

            @Override // com.amgcyo.cuttadon.j.g.g.a
            public Void a(Object obj) {
                UmPushBookDialogActivity.this.n().a(this.b.getReading_site_id(), this.b.getReading_site_path(), this.b.getReading_site_id(), this.b.getBook_id(), this.b.getSite_path_reload(), this.b.getCrawl_book_id());
                return null;
            }
        }

        a(MkBook mkBook) {
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
            UmPushBookDialogActivity.this.b(this.a);
            com.amgcyo.cuttadon.j.g.b.a(new C0084a("", mkBook));
        }

        @Override // com.amgcyo.cuttadon.view.popupview.NovelSourceDrawerPopup.b
        public void b(MkBook mkBook) {
            ((BookPresenter) ((BaseTitleBarActivity) UmPushBookDialogActivity.this).f2276v).m(Message.a(UmPushBookDialogActivity.this, new Object[]{Integer.valueOf(mkBook.getBook_id())}));
        }
    }

    private void c(MkBook mkBook) {
        a.b bVar = new a.b(this.f2277w);
        bVar.a(PopupPosition.Left);
        bVar.e(true);
        NovelSourceDrawerPopup novelSourceDrawerPopup = new NovelSourceDrawerPopup((BaseTitleBarActivity) this.f2277w, mkBook);
        bVar.a((BasePopupView) novelSourceDrawerPopup);
        this.f2630n0 = (NovelSourceDrawerPopup) novelSourceDrawerPopup.u();
        this.f2630n0.setListener(new a(mkBook));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.amgcyo.cuttadon.database.f n() {
        if (this.f2631o0 == null) {
            this.f2631o0 = AppDatabase.i().a();
        }
        return this.f2631o0;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    public /* synthetic */ void e(View view) {
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        try {
            ((NotificationManager) getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).cancelAll();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        int i2 = message.f21197s;
        if (i2 == 832) {
            finish();
            return;
        }
        if (i2 == 897) {
            List<MkSiteBean> list = (List) message.f21202x;
            if (this.f2630n0 != null) {
                if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
                    this.f2630n0.g();
                } else {
                    this.f2630n0.a(list, (com.amgcyo.cuttadon.utils.otherutils.k) null);
                }
            }
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        if (getIntent() == null) {
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        final MkBook mkBook = (MkBook) extras.getSerializable("book");
        if (mkBook == null) {
            finish();
            return;
        }
        int iA = com.amgcyo.cuttadon.utils.otherutils.n.a(20.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ff.getLayoutParams();
        layoutParams.leftMargin = iA;
        layoutParams.rightMargin = iA;
        this.ff.setLayoutParams(layoutParams);
        final int book_id = mkBook.getBook_id();
        if (c(book_id) != null) {
            this.btn_add_shelf.setText("立即阅读");
            this.btn_add_shelf.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.q0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2667s.a(mkBook, view);
                }
            });
        } else {
            mkBook.setSkipToDetailPage(false);
            this.btn_add_shelf.setText("加入书架");
            this.btn_add_shelf.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.p0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2664s.b(mkBook, view);
                }
            });
        }
        this.btn_exit.setText("查看书籍详情");
        this.btn_exit.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2673s.a(book_id, mkBook, view);
            }
        });
        this.G.a(this.f2277w, ImageConfigImpl.builder().imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkBook.getForm()), mkBook.getImage())).imageView(this.book_cover).build());
        this.tv_tips.setText(mkBook.getRemark());
        this.tv_author.setText(String.format("%s", mkBook.getAuthor()));
        this.tv_word_count.setText(String.format(Locale.getDefault(), "%s · %s", mkBook.getPush_status(), mkBook.getLtype()));
        this.iv_close.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2672s.e(view);
            }
        });
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.dialog_add_book;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    public /* synthetic */ void b(MkBook mkBook, View view) {
        ((BookPresenter) this.f2276v).a(Message.a(a(), new Object[]{mkBook}));
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public BookPresenter obtainPresenter() {
        return new BookPresenter(me.jessyan.art.f.e.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MkBook mkBook) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", mkBook);
        if (com.amgcyo.cuttadon.view.read.page.m.a(this.f2277w)) {
            com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f2277w, bundle, MkReadModelHActivity.class);
            x0.c().a(1, mkBook.getBook_id(), mkBook.getRead_begin(), "水平", mkBook.getUpdated());
        } else {
            com.amgcyo.cuttadon.utils.otherutils.r0.startActivity(this.f2277w, bundle, MkReadModelVActivity.class);
            x0.c().a(1, mkBook.getBook_id(), mkBook.getRead_begin(), "上下", mkBook.getUpdated());
        }
        a(mkBook);
    }

    public /* synthetic */ void a(MkBook mkBook, View view) {
        if (1 == mkBook.getForm()) {
            if (!TextUtils.isEmpty(mkBook.getReading_site_id()) && !TextUtils.isEmpty(mkBook.getSite_path_reload())) {
                b(mkBook);
                return;
            } else {
                c(mkBook);
                x0.c().b();
                return;
            }
        }
        com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f2277w, mkBook);
        finish();
        a(mkBook);
    }

    private MkBook c(int i2) {
        return AppDatabase.i().a().i(i2);
    }

    public /* synthetic */ void a(int i2, MkBook mkBook, View view) {
        com.amgcyo.cuttadon.utils.otherutils.r0.a(this.f2277w, i2, mkBook.getForm());
        finish();
    }

    private void a(MkBook mkBook) {
        final int book_id = mkBook.getBook_id();
        MkBook mkBookI = n().i(book_id);
        if (mkBookI != null && mkBookI.getJpush_status() == 1) {
            String strA = t0.a();
            String jpush_today_time = mkBookI.getJpush_today_time();
            String str = "今日时间：" + strA + " 本书上次极光推送检查时间：" + jpush_today_time;
            if (TextUtils.isEmpty(jpush_today_time) || !jpush_today_time.equals(strA)) {
                com.amgcyo.cuttadon.i.n.a(com.anythink.expressad.d.a.b.ay, new com.amgcyo.cuttadon.i.o() { // from class: com.amgcyo.cuttadon.activity.main.o0
                    @Override // com.amgcyo.cuttadon.i.o
                    public final void a(String str2) {
                        this.a.a(book_id, str2);
                    }
                }, String.valueOf(book_id));
            }
        }
        finish();
    }

    public /* synthetic */ void a(int i2, String str) {
        String strA = t0.a();
        n().c(strA, i2);
        String str2 = "更新" + strA;
    }
}
