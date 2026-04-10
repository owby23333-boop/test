package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.qmuiteam.qmui.widget.QMUIProgressBar;

/* JADX INFO: loaded from: classes2.dex */
public class ls extends AlertDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f1421a;
    private boolean dl;
    private String g;
    private Context z;

    public interface z {
        void g(String str);

        void z(String str);
    }

    public ls(Context context, String str) {
        super(context, tb.gz(context, "tt_dialog_full"));
        this.z = context;
        this.g = str;
        this.dl = TextUtils.isEmpty(str);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        if (this.z == null) {
            this.z = zw.getContext();
        }
        z();
    }

    private void z() {
        setContentView(g());
    }

    private View g() {
        LinearLayout linearLayout = new LinearLayout(this.z);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-16777216);
        linearLayout.setGravity(17);
        TextView textView = new TextView(this.z);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setText("您要访问的网站存在风险");
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        linearLayout.addView(textView);
        int iDl = oq.dl(this.z, 10.0f) * 2;
        TextView textView2 = new TextView(this.z);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = iDl;
        layoutParams3.gravity = 17;
        textView2.setLayoutParams(layoutParams3);
        textView2.setText("继续访问可能导致个人隐私泄漏、账号被盗用等危害");
        textView2.setTextColor(-1);
        textView2.setTextSize(15.0f);
        linearLayout.addView(textView2);
        int iDl2 = oq.dl(this.z, 25.0f);
        int iDl3 = oq.dl(this.z, 8.0f);
        if (!this.dl) {
            Button button = new Button(this.z);
            button.setBackgroundColor(QMUIProgressBar.DEFAULT_BACKGROUND_COLOR);
            button.setText("继续访问");
            button.setTextColor(-1);
            button.setPadding(iDl2, iDl3, iDl2, iDl3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(oq.dl(this.z, 230.0f), -2);
            layoutParams4.topMargin = iDl;
            layoutParams4.gravity = 17;
            button.setLayoutParams(layoutParams4);
            button.setTextSize(25.0f);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ls.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ls.this.dismiss();
                    if (ls.this.f1421a == null) {
                        return;
                    }
                    ls.this.f1421a.z(ls.this.g);
                }
            });
            linearLayout.addView(button);
        }
        Button button2 = new Button(this.z);
        button2.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(oq.dl(this.z, 230.0f), -2);
        layoutParams5.topMargin = iDl;
        layoutParams5.gravity = 17;
        button2.setLayoutParams(layoutParams5);
        button2.setText("返回安全链接");
        button2.setTextColor(-1);
        button2.setTextSize(25.0f);
        button2.setTypeface(null, 1);
        button2.setPadding(iDl2, iDl3, iDl2, iDl3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ls.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ls.this.dismiss();
                if (ls.this.f1421a == null) {
                    return;
                }
                ls.this.f1421a.g(ls.this.g);
            }
        });
        linearLayout.addView(button2);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        z zVar = this.f1421a;
        if (zVar == null) {
            return;
        }
        zVar.g(this.g);
    }

    public void z(z zVar) {
        this.f1421a = zVar;
    }
}
