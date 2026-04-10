package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.dislike.ui.a;
import com.bytedance.sdk.openadsdk.ls.dl.g.m;
import com.bytedance.sdk.openadsdk.widget.TTDislikeLayout;
import com.bytedance.sdk.openadsdk.widget.TTDislikeScrollListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1026a;
    private final com.bytedance.sdk.openadsdk.core.dislike.dl.g dl;
    private TTDislikeLayout g;
    private TextView gc;
    private com.bytedance.sdk.openadsdk.core.dislike.g.dl z;

    public dl(Context context, com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar) {
        super(context);
        this.f1026a = false;
        getWindow().addFlags(1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dl = gVar;
    }

    public void z(com.bytedance.sdk.openadsdk.core.dislike.g.dl dlVar) {
        this.z = dlVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        setContentView(com.bytedance.sdk.openadsdk.res.a.z(getContext()), z());
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        g();
        dl();
    }

    public ViewGroup.LayoutParams z() {
        return new ViewGroup.LayoutParams(com.bytedance.sdk.openadsdk.core.dislike.z.z.g().z(getContext(), 345.0f), -2);
    }

    private void g() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setDimAmount(0.34f);
        }
    }

    private void dl() {
        TTDislikeLayout tTDislikeLayout = (TTDislikeLayout) findViewById(2047279103);
        this.g = tTDislikeLayout;
        z(tTDislikeLayout);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.f1026a = false;
            com.bytedance.sdk.openadsdk.core.dislike.g.dl dlVar = this.z;
            if (dlVar != null) {
                dlVar.g();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.bytedance.sdk.openadsdk.core.dislike.g.dl dlVar = this.z;
        if (dlVar == null || this.f1026a) {
            return;
        }
        dlVar.dl();
    }

    public void z(com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar) {
        TTDislikeLayout tTDislikeLayout;
        if (gVar == null || (tTDislikeLayout = this.g) == null) {
            return;
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) tTDislikeLayout.findViewById(2047279097);
        a aVar = (a) tTDislikeScrollListView.getAdapter();
        if (aVar != null) {
            tTDislikeScrollListView.setDislikeController(new com.bytedance.sdk.openadsdk.core.dislike.z.g(gVar));
            aVar.z(gVar.z());
        }
    }

    private void z(View view) {
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(2047279095);
        this.gc = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.dl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (dl.this.z != null) {
                    dl.this.z.z();
                }
                dl.this.dismiss();
            }
        });
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) view.findViewById(2047279097);
        tTDislikeScrollListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.dl.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                try {
                    if (dl.this.z != null) {
                        dl.this.z.z(i, dl.this.dl.z().get(i));
                        dl.this.f1026a = true;
                    }
                    dl.this.dismiss();
                } catch (Throwable unused) {
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar = this.dl;
        a aVar = new a(getContext(), gVar == null ? new ArrayList<>(0) : gVar.z());
        aVar.z(new a.z() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.dl.3
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.a.z
            public void z(int i, m mVar) {
                if (dl.this.z != null) {
                    dl.this.z.z(i, mVar);
                    dl.this.f1026a = true;
                }
                dl.this.dismiss();
                com.bytedance.sdk.openadsdk.core.dislike.z.z.z().z(dl.this.dl, mVar);
            }
        });
        tTDislikeScrollListView.setAdapter((ListAdapter) aVar);
        if (this.dl != null) {
            tTDislikeScrollListView.setDislikeController(new com.bytedance.sdk.openadsdk.core.dislike.z.g(this.dl));
        }
    }

    public void z(String str) {
        TextView textView = this.gc;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
