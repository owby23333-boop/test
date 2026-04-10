package com.amgcyo.cuttadon.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amgcyo.cuttadon.api.entity.other.ShelfSortBean;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import me.jessyan.art.base.d;

/* JADX INFO: compiled from: ShelfFattenDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class p1 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4780s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private a f4781t;

    /* JADX INFO: compiled from: ShelfFattenDialog.java */
    public interface a {
        void a(ShelfSortBean shelfSortBean);
    }

    public p1(@NonNull Context context) {
        super(context);
        this.f4780s = context;
    }

    private void a() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_view);
        ((TextView) findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4729s.a(view);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f4780s);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList arrayList = new ArrayList();
        final String strA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("shelf_fatten_key", "sort_fatten_by_first");
        arrayList.add(new ShelfSortBean(this.f4780s.getResources().getString(R.string.fatten_sort_first), "sort_fatten_by_first"));
        arrayList.add(new ShelfSortBean(this.f4780s.getResources().getString(R.string.fatten_sort_last), "sort_fatten_by_last"));
        final com.amgcyo.cuttadon.adapter.other.m mVar = new com.amgcyo.cuttadon.adapter.other.m(arrayList, strA);
        recyclerView.setAdapter(mVar);
        mVar.a(new d.a() { // from class: com.amgcyo.cuttadon.view.dialog.j0
            @Override // me.jessyan.art.base.d.a
            public final void a(View view, int i2, Object obj, int i3) {
                this.a.a(mVar, strA, view, i2, obj, i3);
            }
        });
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.bottom_shelfsort_dialog, (ViewGroup) null);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setGravity(80);
        window.setContentView(viewInflate);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.dialog_animation);
        a();
    }

    public /* synthetic */ void a(View view) {
        dismiss();
    }

    public /* synthetic */ void a(com.amgcyo.cuttadon.adapter.other.m mVar, String str, View view, int i2, Object obj, int i3) {
        ShelfSortBean item;
        if (this.f4781t == null || (item = mVar.getItem(i3)) == null) {
            return;
        }
        if (item.getTitle_key().equals(str)) {
            String str2 = "没有变化" + item.getTitle_key() + "==" + item.getTitle();
        } else {
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("shelf_fatten_key", item.getTitle_key());
            this.f4781t.a(item);
            String str3 = item.getTitle_key() + "==" + item.getTitle();
        }
        dismiss();
    }

    public void a(a aVar) {
        this.f4781t = aVar;
    }
}
