package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.activity.read.MkNovelBaseReaderActivity;
import com.amgcyo.cuttadon.adapter.other.l;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.k;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.DrawerPopupView;
import java.util.ArrayList;
import java.util.Collections;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class NovelCatalogDrawerPopup extends DrawerPopupView implements View.OnClickListener {
    Context V;
    MkBook W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    me.jessyan.art.c.e.c f5142a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    LinearLayout f5143b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    RelativeLayout f5144c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    ImageView f5145d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    ImageView f5146e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    TextView f5147f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    TextView f5148g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    TextView f5149h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    TextView f5150i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    ListView f5151j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    View f5152k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    int f5153l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    k f5154m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    l f5155n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f5156o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private boolean f5157p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    int f5158q0;

    public NovelCatalogDrawerPopup(@NonNull Context context, MkBook mkBook, me.jessyan.art.c.e.c cVar) {
        super(context);
        this.f5157p0 = false;
        this.V = context;
        this.W = mkBook;
        this.f5142a0 = cVar;
    }

    private void b(int i2) {
        ListView listView;
        RelativeLayout relativeLayout = this.f5144c0;
        if (relativeLayout == null || (listView = this.f5151j0) == null) {
            return;
        }
        listView.setSelectionFromTop(i2, this.f5153l0 - relativeLayout.getHeight());
    }

    public /* synthetic */ void a(ArrayList arrayList, AdapterView adapterView, View view, int i2, long j2) {
        if (this.V instanceof MkNovelBaseReaderActivity) {
            MkCatalog mkCatalog = (MkCatalog) arrayList.get(i2);
            String str = "目录：" + mkCatalog.getCatalogId() + "     " + mkCatalog.getName() + " 位置：" + i2 + " 当前阅读id：" + this.f5156o0;
            if (this.f5156o0 == mkCatalog.getCatalogId() && this.f5156o0 != 0) {
                g();
                return;
            }
            if (this.f5157p0) {
                this.f5158q0 = i2;
            } else {
                this.f5158q0 = mkCatalog.getCatalogId();
            }
            ((MkNovelBaseReaderActivity) this.V).applySkipToChapter(mkCatalog);
            g();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.catalog_pager_drawer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MkBook mkBook;
        l lVar;
        int id = view.getId();
        if (id == R.id.rl_root) {
            Context context = this.V;
            if (context == null || (mkBook = this.W) == null) {
                return;
            }
            r0.a(context, mkBook.getBook_id(), this.W.getForm());
            return;
        }
        if (id != R.id.tv_sort || (lVar = this.f5155n0) == null || com.amgcyo.cuttadon.utils.otherutils.g.a(lVar.a())) {
            return;
        }
        if (this.f5157p0) {
            Collections.reverse(this.f5155n0.a());
            this.f5150i0.setText("正序");
        } else {
            Collections.reverse(this.f5155n0.a());
            this.f5150i0.setText("倒序");
        }
        this.f5155n0.notifyDataSetChanged();
        this.f5151j0.setSelection(0);
        this.f5157p0 = !this.f5157p0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.f5143b0 = (LinearLayout) findViewById(R.id.ll_root);
        this.f5144c0 = (RelativeLayout) findViewById(R.id.rl_root);
        this.f5145d0 = (ImageView) findViewById(R.id.iv_bookImg);
        this.f5146e0 = (ImageView) findViewById(R.id.img_right);
        this.f5147f0 = (TextView) findViewById(R.id.book_title_tv);
        this.f5148g0 = (TextView) findViewById(R.id.book_author);
        this.f5152k0 = findViewById(R.id.view_line);
        this.f5149h0 = (TextView) findViewById(R.id.tv_status);
        this.f5150i0 = (TextView) findViewById(R.id.tv_sort);
        this.f5150i0.setOnClickListener(this);
        this.f5151j0 = (ListView) findViewById(R.id.listView_index);
        o.a(this.f5151j0, 0, 0, 0, 0);
        Context context = this.V;
        if (context instanceof MkNovelBaseReaderActivity) {
            this.f5154m0 = ((MkNovelBaseReaderActivity) context).getReaderColorStyle();
            k kVar = this.f5154m0;
            if (kVar != null) {
                this.f5151j0.setBackgroundColor(kVar.f4405i);
                this.f5144c0.setBackgroundColor(this.f5154m0.f4401e);
                this.f5151j0.setDivider(new ColorDrawable(this.f5154m0.f4409m));
                this.f5151j0.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.dimen0_5dp));
                this.f5147f0.setTextColor(this.f5154m0.a);
                this.f5149h0.setTextColor(this.f5154m0.b);
                this.f5148g0.setTextColor(this.f5154m0.b);
                this.f5152k0.setBackgroundColor(this.f5154m0.f4409m);
                this.f5146e0.setColorFilter(this.f5154m0.b);
            }
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f5143b0.getLayoutParams();
        double dC = n.c(this.V);
        Double.isNaN(dC);
        layoutParams.width = (int) (dC * 0.85d);
        layoutParams.height = n.a(this.V);
        this.f5153l0 = layoutParams.height / 2;
        this.f5143b0.setLayoutParams(layoutParams);
        MkBook mkBook = this.W;
        if (mkBook == null) {
            return;
        }
        int form = mkBook.getForm();
        this.f5142a0.a(this.V, ImageConfigImpl.builder().form(form).imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(form), this.W.getImage())).imageView(this.f5145d0).build());
        this.f5147f0.setText(this.W.getName());
        String author = this.W.getAuthor();
        if (TextUtils.isEmpty(author)) {
            this.f5148g0.setVisibility(8);
        } else {
            this.f5148g0.setVisibility(0);
            this.f5148g0.setText(author);
        }
        this.f5144c0.setOnClickListener(this);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void s() {
        super.s();
    }

    public void setAdapterData(final ArrayList<MkCatalog> arrayList) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayList) || this.W == null) {
            return;
        }
        this.f5150i0.setVisibility(0);
        this.f5156o0 = this.W.getReading_chapter_key();
        Context context = this.V;
        if (context instanceof MkNovelBaseReaderActivity) {
            this.f5156o0 = ((MkNovelBaseReaderActivity) context).currentChpaterId;
        }
        this.f5155n0 = new l(this.V, this.f5156o0);
        this.f5155n0.a(arrayList);
        k kVar = this.f5154m0;
        if (kVar != null) {
            this.f5155n0.a(kVar.f4402f, kVar.a);
        }
        this.f5151j0.setAdapter((ListAdapter) this.f5155n0);
        this.f5149h0.setText(String.format("%s · 共%s章", o.a(this.W.getStatus()), Integer.valueOf(arrayList.size())));
        b(this.f5156o0);
        this.f5151j0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.amgcyo.cuttadon.view.popupview.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                this.f5178s.a(arrayList, adapterView, view, i2, j2);
            }
        });
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
        l lVar = this.f5155n0;
        if (lVar != null && !com.amgcyo.cuttadon.utils.otherutils.g.a(lVar.a())) {
            int reading_chapter_key = this.W.getReading_chapter_key();
            this.f5155n0.b(reading_chapter_key);
            if (this.f5157p0) {
                b(this.f5158q0);
                return;
            } else {
                b(reading_chapter_key);
                return;
            }
        }
        if (!(this.V instanceof MkNovelBaseReaderActivity) || this.W == null) {
            return;
        }
        String str = "书源：" + this.W.getReading_site_id();
        ((MkNovelBaseReaderActivity) this.V).getArtCatalogBeanListFragment(896, this.W);
    }
}
