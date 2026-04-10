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
import com.amgcyo.cuttadon.view.otherview.CommonShapeButton;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: OpenAppDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class h1 extends Dialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f4712s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private a f4713t;

    /* JADX INFO: compiled from: OpenAppDialog.java */
    public interface a {
        void onClick();
    }

    public h1(@NonNull Context context) {
        super(context);
    }

    private void a() {
        this.f4712s = (TextView) findViewById(R.id.tv_title);
        CommonShapeButton commonShapeButton = (CommonShapeButton) findViewById(R.id.btn_cancle);
        CommonShapeButton commonShapeButton2 = (CommonShapeButton) findViewById(R.id.btn_ok);
        commonShapeButton.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4666s.a(view);
            }
        });
        commonShapeButton2.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.dialog.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4842s.b(view);
            }
        });
    }

    public /* synthetic */ void b(View view) {
        a aVar = this.f4713t;
        if (aVar != null) {
            aVar.onClick();
            dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.bottom_open_dialog, (ViewGroup) null);
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

    public void a(String str) {
        TextView textView = this.f4712s;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void a(a aVar) {
        this.f4713t = aVar;
    }
}
