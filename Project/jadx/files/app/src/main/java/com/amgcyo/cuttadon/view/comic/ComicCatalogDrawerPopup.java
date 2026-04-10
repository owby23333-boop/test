package com.amgcyo.cuttadon.view.comic;

import android.content.Context;
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
import com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity;
import com.amgcyo.cuttadon.api.entity.comic.ZymkChapter;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.DrawerPopupView;
import java.util.Collections;
import java.util.List;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class ComicCatalogDrawerPopup extends DrawerPopupView implements View.OnClickListener {
    Context V;
    MkBook W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    me.jessyan.art.c.e.c f4433a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    LinearLayout f4434b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    RelativeLayout f4435c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    ImageView f4436d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    TextView f4437e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    TextView f4438f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    TextView f4439g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    TextView f4440h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    ListView f4441i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    int f4442j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    com.amgcyo.cuttadon.adapter.comic.b f4443k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private com.amgcyo.cuttadon.view.comic.m.a f4444l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private int f4445m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f4446n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    int f4447o0;

    public ComicCatalogDrawerPopup(@NonNull Context context, MkBook mkBook, me.jessyan.art.c.e.c cVar, com.amgcyo.cuttadon.view.comic.m.a aVar) {
        super(context);
        this.f4446n0 = false;
        this.V = context;
        this.W = mkBook;
        this.f4433a0 = cVar;
        this.f4444l0 = aVar;
    }

    private void b(int i2) {
        ListView listView;
        RelativeLayout relativeLayout = this.f4435c0;
        if (relativeLayout == null || (listView = this.f4441i0) == null) {
            return;
        }
        listView.setSelectionFromTop(i2, this.f4442j0 - relativeLayout.getHeight());
    }

    public /* synthetic */ void a(List list, AdapterView adapterView, View view, int i2, long j2) {
        ZymkChapter zymkChapter = (ZymkChapter) list.get(i2);
        String str = "目录：" + zymkChapter.getIndex() + "     " + zymkChapter.getName() + " 位置：" + i2;
        if ((this.V instanceof MkComicsBaseReaderActivity) && this.f4445m0 == zymkChapter.getIndex()) {
            g();
            return;
        }
        if (this.f4446n0) {
            this.f4447o0 = i2;
        } else {
            this.f4447o0 = zymkChapter.getIndex();
        }
        com.amgcyo.cuttadon.view.comic.m.a aVar = this.f4444l0;
        if (aVar != null) {
            aVar.a(zymkChapter.getIndex());
        }
        g();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.catalog_pager_drawer;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MkBook mkBook;
        com.amgcyo.cuttadon.adapter.comic.b bVar;
        int id = view.getId();
        if (id == R.id.rl_root) {
            Context context = this.V;
            if (context == null || (mkBook = this.W) == null) {
                return;
            }
            r0.a(context, mkBook.getBook_id(), this.W.getForm());
            return;
        }
        if (id != R.id.tv_sort || (bVar = this.f4443k0) == null || com.amgcyo.cuttadon.utils.otherutils.g.a(bVar.a())) {
            return;
        }
        if (this.f4446n0) {
            Collections.reverse(this.f4443k0.a());
            this.f4440h0.setText("正序");
        } else {
            Collections.reverse(this.f4443k0.a());
            this.f4440h0.setText("倒序");
        }
        this.f4443k0.notifyDataSetChanged();
        this.f4441i0.setSelection(0);
        this.f4446n0 = !this.f4446n0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.f4434b0 = (LinearLayout) findViewById(R.id.ll_root);
        this.f4435c0 = (RelativeLayout) findViewById(R.id.rl_root);
        this.f4436d0 = (ImageView) findViewById(R.id.iv_bookImg);
        this.f4437e0 = (TextView) findViewById(R.id.book_title_tv);
        this.f4438f0 = (TextView) findViewById(R.id.book_author);
        findViewById(R.id.view_line);
        this.f4439g0 = (TextView) findViewById(R.id.tv_status);
        this.f4440h0 = (TextView) findViewById(R.id.tv_sort);
        this.f4440h0.setOnClickListener(this);
        this.f4441i0 = (ListView) findViewById(R.id.listView_index);
        this.f4441i0.setBackgroundColor(o.b(R.color.white));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4434b0.getLayoutParams();
        double dC = n.c(this.V);
        Double.isNaN(dC);
        layoutParams.width = (int) (dC * 0.85d);
        layoutParams.height = n.a(this.V);
        this.f4442j0 = layoutParams.height / 2;
        this.f4434b0.setLayoutParams(layoutParams);
        MkBook mkBook = this.W;
        if (mkBook == null) {
            return;
        }
        int form = mkBook.getForm();
        this.f4433a0.a(this.V, ImageConfigImpl.builder().form(form).imageRadius(8).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(form), this.W.getImage())).imageView(this.f4436d0).build());
        this.f4437e0.setText(this.W.getName());
        String author = this.W.getAuthor();
        if (TextUtils.isEmpty(author)) {
            this.f4438f0.setVisibility(8);
        } else {
            this.f4438f0.setVisibility(0);
            this.f4438f0.setText(author);
        }
        this.f4435c0.setOnClickListener(this);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void s() {
        super.s();
    }

    public void setAdapterData(final List<ZymkChapter> list) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(list) || this.W == null || this.V == null) {
            return;
        }
        this.f4440h0.setVisibility(0);
        this.f4445m0 = this.W.getReading_chapter_key();
        Context context = this.V;
        if (context instanceof MkComicsBaseReaderActivity) {
            this.f4445m0 = ((MkComicsBaseReaderActivity) context).currentId;
        }
        this.f4443k0 = new com.amgcyo.cuttadon.adapter.comic.b(this.V, this.f4445m0);
        this.f4443k0.a(list);
        this.f4441i0.setAdapter((ListAdapter) this.f4443k0);
        this.f4439g0.setText(String.format("%s · 共%s话", o.a(this.W.getStatus()), Integer.valueOf(list.size())));
        b(this.f4445m0);
        this.f4441i0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.amgcyo.cuttadon.view.comic.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                this.f4527s.a(list, adapterView, view, i2, j2);
            }
        });
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
        com.amgcyo.cuttadon.adapter.comic.b bVar = this.f4443k0;
        if (bVar == null || com.amgcyo.cuttadon.utils.otherutils.g.a(bVar.a())) {
            com.amgcyo.cuttadon.view.comic.m.a aVar = this.f4444l0;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        int reading_chapter_key = this.W.getReading_chapter_key();
        this.f4443k0.b(reading_chapter_key);
        if (this.f4446n0) {
            b(this.f4447o0);
        } else {
            b(reading_chapter_key);
        }
    }
}
