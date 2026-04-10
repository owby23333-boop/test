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
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.adapter.shelf.MkAddBookDialogItem;
import com.amgcyo.cuttadon.adapter.shelf.MkShelfCategoryItem;
import com.amgcyo.cuttadon.api.entity.other.MkAddBook;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.ShelfCategory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ShelfCategoryDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class n1 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4760s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<Object> f4761t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private me.drakeet.multitype.d f4762u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private RecyclerView f4763v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private c f4764w;

    /* JADX INFO: compiled from: ShelfCategoryDialog.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (n1.this.f4764w != null) {
                n1.this.f4764w.a();
            }
        }
    }

    /* JADX INFO: compiled from: ShelfCategoryDialog.java */
    class b extends GridLayoutManager.SpanSizeLookup {
        b(n1 n1Var) {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return 1;
        }
    }

    /* JADX INFO: compiled from: ShelfCategoryDialog.java */
    public interface c {
        void a();

        void a(String str);
    }

    public n1(@NonNull Context context) {
        super(context);
        this.f4761t = new ArrayList();
        this.f4760s = context;
    }

    private void b() {
        this.f4763v = (RecyclerView) findViewById(R.id.list);
        ((TextView) findViewById(com.fatcatfat.io.R.id.tv_new_category)).setOnClickListener(new a());
        a();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(com.fatcatfat.io.R.layout.dialog_category_item, (ViewGroup) null);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setSoftInputMode(34);
        window.setGravity(80);
        window.setContentView(viewInflate);
        window.setBackgroundDrawableResource(R.color.transparent);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = com.amgcyo.cuttadon.utils.otherutils.n.a(this.f4760s) / 2;
        window.setAttributes(attributes);
        window.setWindowAnimations(com.fatcatfat.io.R.style.dialog_animation);
        this.f4762u = new me.drakeet.multitype.d();
        b();
    }

    public void a(List<Object> list, me.jessyan.art.c.e.c cVar) {
        ArrayList arrayList = new ArrayList();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) list)) {
            for (Object obj : list) {
                if (obj instanceof MkBook) {
                    arrayList.add((MkBook) obj);
                } else if (obj instanceof ShelfCategory) {
                    this.f4761t.add(obj);
                }
            }
        }
        List<ShelfCategory> listB = com.amgcyo.cuttadon.utils.otherutils.x.b(arrayList);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listB)) {
            this.f4761t.addAll(0, listB);
        }
        this.f4762u.a(ShelfCategory.class, new MkShelfCategoryItem(cVar, this.f4764w));
        MkAddBook mkAddBook = new MkAddBook();
        this.f4762u.a(MkAddBook.class, new MkAddBookDialogItem(this.f4764w));
        this.f4761t.add(mkAddBook);
        this.f4762u.a(this.f4761t);
        this.f4763v.setAdapter(this.f4762u);
    }

    private void a() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f4760s, 3);
        gridLayoutManager.setSpanSizeLookup(new b(this));
        this.f4763v.setLayoutManager(gridLayoutManager);
    }

    public void a(c cVar) {
        this.f4764w = cVar;
    }
}
