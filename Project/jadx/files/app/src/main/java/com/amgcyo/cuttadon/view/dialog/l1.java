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
import com.amgcyo.cuttadon.adapter.other.ReportTypeAdapter;
import com.amgcyo.cuttadon.api.entity.comment.CommentReprotType;
import com.fatcatfat.io.R;
import java.util.List;
import me.jessyan.art.base.d;

/* JADX INFO: compiled from: ReportTypeDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class l1 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4743s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private a f4744t;

    /* JADX INFO: compiled from: ReportTypeDialog.java */
    public interface a {
        void a(CommentReprotType commentReprotType);
    }

    public l1(@NonNull Context context) {
        super(context);
        this.f4743s = context;
    }

    private void a() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_view);
        TextView textView = (TextView) findViewById(R.id.tv_cancel);
        TextView textView2 = (TextView) findViewById(R.id.tv_title);
        textView2.setText("举报");
        textView2.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4711s.a(view);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f4743s);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        final List<CommentReprotType> listK0 = com.amgcyo.cuttadon.utils.otherutils.h.k0();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(listK0)) {
            l.b.a.j.a((CharSequence) "获取数据失败！");
            dismiss();
        } else {
            ReportTypeAdapter reportTypeAdapter = new ReportTypeAdapter(listK0);
            recyclerView.setAdapter(reportTypeAdapter);
            reportTypeAdapter.a(new d.a() { // from class: com.amgcyo.cuttadon.view.dialog.i0
                @Override // me.jessyan.art.base.d.a
                public final void a(View view, int i2, Object obj, int i3) {
                    this.a.a(listK0, view, i2, obj, i3);
                }
            });
        }
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

    public /* synthetic */ void a(List list, View view, int i2, Object obj, int i3) {
        a aVar = this.f4744t;
        if (aVar != null) {
            aVar.a((CommentReprotType) list.get(i3));
            dismiss();
        }
    }

    public void a(a aVar) {
        this.f4744t = aVar;
    }
}
