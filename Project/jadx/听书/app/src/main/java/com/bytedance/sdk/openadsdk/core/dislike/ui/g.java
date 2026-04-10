package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.widget.TTDislikeCommentLayout;
import com.qmuiteam.qmui.widget.QMUIProgressBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.g.g f1027a;
    private com.bytedance.sdk.openadsdk.core.dislike.dl.g dl;
    private final List<com.bytedance.sdk.openadsdk.core.dislike.g.z> g;
    private EditText gc;
    private TTDislikeCommentLayout z;

    public g(Context context, com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar) {
        super(context);
        this.g = new ArrayList();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dl = gVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.a.dl(getContext()));
        TTDislikeCommentLayout tTDislikeCommentLayout = (TTDislikeCommentLayout) findViewById(2047279092);
        this.z = tTDislikeCommentLayout;
        z(tTDislikeCommentLayout);
        gc();
    }

    private void z(View view) {
        EditText editText = (EditText) view.findViewById(2047279087);
        this.gc = editText;
        z(editText);
        final TextView textView = (TextView) view.findViewById(2047279088);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String string = g.this.gc.getText().toString();
                if (string.length() <= 0 || string.isEmpty()) {
                    return;
                }
                Iterator it = g.this.g.iterator();
                while (it.hasNext()) {
                    if (((com.bytedance.sdk.openadsdk.core.dislike.g.z) it.next()).z(string, g.this)) {
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.core.dislike.dl.dl dlVar = new com.bytedance.sdk.openadsdk.core.dislike.dl.dl("0:00", string);
                com.bytedance.sdk.openadsdk.core.dislike.z.z.z().z(g.this.dl, dlVar);
                g.this.f1027a.z(0, dlVar);
                g.this.dismiss();
            }
        });
        ((ImageView) view.findViewById(2047279090)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                g.this.dismiss();
            }
        });
        final TextView textView2 = (TextView) findViewById(2047279086);
        this.gc.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.g.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int iRound = Math.round(charSequence.length());
                textView2.setText(String.valueOf(iRound));
                if (iRound > 0) {
                    textView.setTextColor(-16777216);
                    textView.setClickable(true);
                } else {
                    textView.setTextColor(QMUIProgressBar.DEFAULT_BACKGROUND_COLOR);
                    textView.setClickable(false);
                }
            }
        });
    }

    public static void z(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.g.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    int type = Character.getType(charSequence.charAt(i));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i++;
                }
                return null;
            }
        }, new InputFilter.LengthFilter(500)});
    }

    private void gc() {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        g();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        dl();
        super.dismiss();
        com.bytedance.sdk.openadsdk.core.dislike.g.g gVar = this.f1027a;
        if (gVar != null) {
            gVar.z();
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.dislike.g.z zVar) {
        this.g.add(zVar);
    }

    public void z(com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar) {
        if (gVar == null) {
            return;
        }
        this.dl = gVar;
    }

    public void z() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.z;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279087)) == null) {
            return;
        }
        editText.setText((CharSequence) null);
    }

    public void z(com.bytedance.sdk.openadsdk.core.dislike.g.g gVar) {
        this.f1027a = gVar;
    }

    public void g() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.z;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279087)) == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.z.getWindowToken(), 0);
        }
        editText.clearFocus();
    }

    public void dl() {
        EditText editText;
        InputMethodManager inputMethodManager;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.z;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279087)) == null || (inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.z.getWindowToken(), 0);
    }

    public String a() {
        EditText editText = this.gc;
        return editText != null ? editText.getText().toString() : "";
    }
}
