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
import com.amgcyo.cuttadon.adapter.other.DaoliuMethodAdapter;
import com.amgcyo.cuttadon.api.entity.other.ShelfSortBean;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import me.jessyan.art.base.d;

/* JADX INFO: compiled from: DaoliuMethodDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class t0 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4804s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private a f4805t;

    /* JADX INFO: compiled from: DaoliuMethodDialog.java */
    public interface a {
        void onClick(int i2);
    }

    public t0(@NonNull Context context) {
        super(context);
        this.f4804s = context;
    }

    private void a() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_view);
        TextView textView = (TextView) findViewById(R.id.tv_cancel);
        TextView textView2 = (TextView) findViewById(R.id.tv_title);
        textView2.setText("请选择恢复方式");
        textView2.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4691s.a(view);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f4804s);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f4804s.getResources().getStringArray(R.array.arrayMethod)) {
            arrayList.add(new ShelfSortBean(str));
        }
        DaoliuMethodAdapter daoliuMethodAdapter = new DaoliuMethodAdapter(arrayList);
        recyclerView.setAdapter(daoliuMethodAdapter);
        daoliuMethodAdapter.a(new d.a() { // from class: com.amgcyo.cuttadon.view.dialog.e
            @Override // me.jessyan.art.base.d.a
            public final void a(View view, int i2, Object obj, int i3) {
                this.a.a(view, i2, obj, i3);
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

    public /* synthetic */ void a(View view, int i2, Object obj, int i3) {
        a aVar = this.f4805t;
        if (aVar != null) {
            aVar.onClick(i3);
            dismiss();
        }
    }

    public void a(a aVar) {
        this.f4805t = aVar;
    }
}
