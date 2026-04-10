package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.l;

/* JADX INFO: loaded from: classes2.dex */
public class TextInputEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Rect f15903s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f15904t;

    public TextInputEditText(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private String a(@NonNull TextInputLayout textInputLayout) {
        Editable text = getText();
        CharSequence hint = textInputLayout.getHint();
        boolean z2 = !TextUtils.isEmpty(text);
        boolean z3 = !TextUtils.isEmpty(hint);
        if (Build.VERSION.SDK_INT >= 17) {
            setLabelFor(R$id.textinput_helper_text);
        }
        String str = "";
        String string = z3 ? hint.toString() : "";
        if (!z2) {
            return !TextUtils.isEmpty(string) ? string : "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) text);
        if (!TextUtils.isEmpty(string)) {
            str = ", " + string;
        }
        sb.append(str);
        return sb.toString();
    }

    @Nullable
    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    @Nullable
    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@Nullable Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !this.f15904t || rect == null) {
            return;
        }
        textInputLayout.getFocusedRect(this.f15903s);
        rect.bottom = this.f15903s.bottom;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@Nullable Rect rect, @Nullable Point point) {
        boolean globalVisibleRect = super.getGlobalVisibleRect(rect, point);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f15904t && rect != null) {
            textInputLayout.getGlobalVisibleRect(this.f15903s, point);
            rect.bottom = this.f15903s.bottom;
        }
        return globalVisibleRect;
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.d()) ? super.getHint() : textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.d() && super.getHint() == null && com.google.android.material.internal.d.c()) {
            setHint("");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT >= 23 || textInputLayout == null) {
            return;
        }
        accessibilityNodeInfo.setText(a(textInputLayout));
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@Nullable Rect rect) {
        boolean zRequestRectangleOnScreen = super.requestRectangleOnScreen(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f15904t) {
            this.f15903s.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(R$dimen.mtrl_edittext_rectangle_top_offset), textInputLayout.getWidth(), textInputLayout.getHeight());
            textInputLayout.requestRectangleOnScreen(this.f15903s, true);
        }
        return zRequestRectangleOnScreen;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z2) {
        this.f15904t = z2;
    }

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, 0), attributeSet, i2);
        this.f15903s = new Rect();
        TypedArray typedArrayC = l.c(context, attributeSet, R$styleable.TextInputEditText, i2, R$style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(typedArrayC.getBoolean(R$styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        typedArrayC.recycle();
    }
}
