package com.amgcyo.cuttadon.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.amgcyo.cuttadon.view.otherview.CommonShapeButton;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: ExchangeDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class u0 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f4812s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f4813t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f4814u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private CommonShapeButton f4815v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.amgcyo.cuttadon.g.f f4816w;

    public u0(Context context, View view, int i2) {
        super(context, i2);
        setContentView(view);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = (int) (com.amgcyo.cuttadon.utils.otherutils.n.c(context) * 0.8f);
            window.setAttributes(attributes);
        }
        this.f4812s = (TextView) view.findViewById(R.id.tv_content);
        this.f4813t = (TextView) view.findViewById(R.id.tv_tips);
        this.f4815v = (CommonShapeButton) view.findViewById(R.id.btn_kown);
        this.f4814u = (TextView) view.findViewById(R.id.tv_ad_tips);
        this.f4815v.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4706s.a(view2);
            }
        });
        ((ImageView) view.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f4700s.b(view2);
            }
        });
    }

    public /* synthetic */ void a(View view) {
        com.amgcyo.cuttadon.g.f fVar = this.f4816w;
        if (fVar != null) {
            fVar.a();
        }
        dismiss();
    }

    public /* synthetic */ void b(View view) {
        dismiss();
    }

    public void a(int i2) {
        TextView textView = this.f4814u;
        if (textView != null) {
            textView.setVisibility(i2);
        }
    }

    public void a(String str, String str2, String str3) {
        TextView textView = this.f4812s;
        if (textView == null || this.f4815v == null) {
            return;
        }
        textView.setText(str);
        this.f4815v.setText(str3);
        this.f4813t.setText(str2);
    }

    public void a(com.amgcyo.cuttadon.g.f fVar) {
        this.f4816w = fVar;
    }
}
