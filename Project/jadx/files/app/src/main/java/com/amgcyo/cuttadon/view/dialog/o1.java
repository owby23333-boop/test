package com.amgcyo.cuttadon.view.dialog;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.adapter.shelf.MkShelfBookDataItem;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.fragment.books.MkBookshelfFragment;
import com.amgcyo.cuttadon.j.itemdecoration.GridItemDecoration;
import com.amgcyo.cuttadon.j.itemdecoration.RecyclerViewDivider;
import java.util.List;

/* JADX INFO: compiled from: ShelfDialogBookList.java */
/* JADX INFO: loaded from: classes.dex */
public class o1 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4769s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private me.drakeet.multitype.d f4770t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List<MkBook> f4771u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private RecyclerView f4772v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f4773w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4774x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private MkBook f4775y;

    /* JADX INFO: compiled from: ShelfDialogBookList.java */
    class a extends GridLayoutManager.SpanSizeLookup {
        a(o1 o1Var) {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return 1;
        }
    }

    public o1(@NonNull Context context) {
        super(context);
        this.f4774x = -1;
        this.f4769s = context;
    }

    private void b() {
        this.f4772v.setLayoutManager(new LinearLayoutManager(this.f4769s));
    }

    private void c() {
        this.f4772v = (RecyclerView) findViewById(R.id.list);
        this.f4773w = (TextView) findViewById(com.fatcatfat.io.R.id.tv_cate_name);
        this.f4772v.setItemAnimator(null);
    }

    public void a(MkBookshelfFragment mkBookshelfFragment, String str, List<MkBook> list, me.jessyan.art.c.e.c cVar) {
        this.f4771u = list;
        if (mkBookshelfFragment.G == 0) {
            b();
        } else {
            a();
        }
        this.f4770t.a(MkBook.class, new MkShelfBookDataItem(mkBookshelfFragment, cVar, mkBookshelfFragment));
        this.f4770t.a(list);
        this.f4772v.setAdapter(this.f4770t);
        this.f4773w.setText(str);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(com.fatcatfat.io.R.layout.shelf_dialog_booklist, (ViewGroup) null);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setGravity(80);
        window.setContentView(viewInflate);
        window.setBackgroundDrawableResource(R.color.transparent);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        double dA = com.amgcyo.cuttadon.utils.otherutils.n.a(this.f4769s);
        Double.isNaN(dA);
        attributes.height = (int) (dA * 0.7d);
        window.setAttributes(attributes);
        window.setWindowAnimations(com.fatcatfat.io.R.style.dialog_animation);
        this.f4770t = new me.drakeet.multitype.d();
        c();
    }

    private void a() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f4769s, 3);
        gridLayoutManager.setSpanSizeLookup(new a(this));
        this.f4772v.setLayoutManager(gridLayoutManager);
        GridItemDecoration.a aVarA = RecyclerViewDivider.a();
        aVarA.a(0);
        aVarA.b(com.amgcyo.cuttadon.utils.otherutils.n.a(20.0f));
        aVarA.e();
        aVarA.a().a(this.f4772v);
    }

    public void a(int i2, int i3, int i4) {
        int i5 = 0;
        while (true) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f4771u) || i5 >= this.f4771u.size() || this.f4774x >= 0) {
                break;
            }
            MkBook mkBook = this.f4771u.get(i5);
            if (mkBook != null) {
                MkBook mkBook2 = mkBook;
                if (mkBook2.getBook_id() == i4) {
                    this.f4774x = i5;
                    this.f4775y = mkBook2;
                    String str = "找到需要更新的位置：" + this.f4774x;
                    break;
                }
            }
            i5++;
        }
        MkBook mkBook3 = this.f4775y;
        if (mkBook3 != null && this.f4774x >= 0 && this.f4770t != null) {
            mkBook3.setCacheTotalSize(i2);
            this.f4775y.setCacheProgress(i3);
            this.f4770t.notifyItemChanged(this.f4774x);
        }
        if (i3 == i2 - 1) {
            com.amgcyo.cuttadon.f.o.b("缓存完成!");
            this.f4774x = -1;
            this.f4775y = null;
            MkApplication.getAppContext().downloadArray.clear();
        }
    }
}
