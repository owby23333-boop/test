package com.funny.audio.view.core;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.FragmentMessageDialogBinding;
import com.funny.audio.view.DialogUtils;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\"\u001a\u00020\u0000J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020$H\u0016J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0005J\u001a\u0010*\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0011J\u001a\u0010,\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0011J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020$2\u0006\u00100\u001a\u000201R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u00062"}, d2 = {"Lcom/funny/audio/view/core/MessageDialogFragment;", "Lcom/funny/audio/view/core/BaseDialogFragment;", "Lcom/funny/audio/databinding/FragmentMessageDialogBinding;", "()V", "contentText", "", "getContentText", "()Ljava/lang/String;", "setContentText", "(Ljava/lang/String;)V", "dialogwidthPixels", "", "getDialogwidthPixels", "()I", "setDialogwidthPixels", "(I)V", "inactiveBtnListener", "Lcom/funny/audio/view/DialogUtils$OnButtonClickListener;", "getInactiveBtnListener", "()Lcom/funny/audio/view/DialogUtils$OnButtonClickListener;", "setInactiveBtnListener", "(Lcom/funny/audio/view/DialogUtils$OnButtonClickListener;)V", "inactiveBtnText", "getInactiveBtnText", "setInactiveBtnText", "positiveBtnListener", "getPositiveBtnListener", "setPositiveBtnListener", "positiveBtnText", "getPositiveBtnText", "setPositiveBtnText", "titleText", "getTitleText", "setTitleText", "disableCancel", "initView", "", "view", "Landroid/view/View;", "onStart", "setContent", "content", "setInactiveBtn", "listener", "setPositiveBtn", "setTitle", "title", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageDialogFragment extends BaseDialogFragment<FragmentMessageDialogBinding> {
    private String contentText;
    private int dialogwidthPixels;
    private DialogUtils.OnButtonClickListener inactiveBtnListener;
    private String inactiveBtnText;
    private DialogUtils.OnButtonClickListener positiveBtnListener;
    private String positiveBtnText;
    private String titleText;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean disableCancel$lambda$4(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    public final int getDialogwidthPixels() {
        return this.dialogwidthPixels;
    }

    public final void setDialogwidthPixels(int i) {
        this.dialogwidthPixels = i;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.dialogwidthPixels = (int) (((double) displayMetrics.widthPixels) * 0.85d);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(this.dialogwidthPixels, -2);
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
        }
    }

    @Override // com.funny.audio.view.core.BaseDialogFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initView(view);
        QMUIFrameLayout qMUIFrameLayout = getBd().btnInactive;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.btnInactive");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.core.MessageDialogFragment.initView.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DialogUtils.OnButtonClickListener inactiveBtnListener = MessageDialogFragment.this.getInactiveBtnListener();
                if (inactiveBtnListener != null) {
                    inactiveBtnListener.onClick(MessageDialogFragment.this.getBd().btnInactive);
                }
                MessageDialogFragment.this.dismiss();
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout2 = getBd().btnPositive;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout2, "bd.btnPositive");
        ViewKt.click$default(qMUIFrameLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.core.MessageDialogFragment.initView.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DialogUtils.OnButtonClickListener positiveBtnListener = MessageDialogFragment.this.getPositiveBtnListener();
                if (positiveBtnListener != null) {
                    positiveBtnListener.onClick(MessageDialogFragment.this.getBd().btnPositive);
                }
                MessageDialogFragment.this.dismiss();
            }
        }, 1, null);
        String str = this.titleText;
        if (str != null) {
            getBd().tvTitle.setVisibility(0);
            getBd().tvTitle.setText(str);
        }
        String str2 = this.contentText;
        if (str2 != null) {
            getBd().tvContent.setVisibility(0);
            getBd().tvContent.setText(str2);
        }
        String str3 = this.positiveBtnText;
        if (str3 != null) {
            getBd().btnPositive.setVisibility(0);
            getBd().tvPositive.setText(str3);
        }
        String str4 = this.inactiveBtnText;
        if (str4 != null) {
            getBd().btnInactive.setVisibility(0);
            getBd().tvInactive.setText(str4);
        }
    }

    public final MessageDialogFragment disableCancel() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.funny.audio.view.core.MessageDialogFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return MessageDialogFragment.disableCancel$lambda$4(dialogInterface, i, keyEvent);
                }
            });
        }
        return this;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setTitleText(String str) {
        this.titleText = str;
    }

    public final String getContentText() {
        return this.contentText;
    }

    public final void setContentText(String str) {
        this.contentText = str;
    }

    public final String getPositiveBtnText() {
        return this.positiveBtnText;
    }

    public final void setPositiveBtnText(String str) {
        this.positiveBtnText = str;
    }

    public final DialogUtils.OnButtonClickListener getPositiveBtnListener() {
        return this.positiveBtnListener;
    }

    public final void setPositiveBtnListener(DialogUtils.OnButtonClickListener onButtonClickListener) {
        this.positiveBtnListener = onButtonClickListener;
    }

    public final String getInactiveBtnText() {
        return this.inactiveBtnText;
    }

    public final void setInactiveBtnText(String str) {
        this.inactiveBtnText = str;
    }

    public final DialogUtils.OnButtonClickListener getInactiveBtnListener() {
        return this.inactiveBtnListener;
    }

    public final void setInactiveBtnListener(DialogUtils.OnButtonClickListener onButtonClickListener) {
        this.inactiveBtnListener = onButtonClickListener;
    }

    public final MessageDialogFragment setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.titleText = title;
        return this;
    }

    public final MessageDialogFragment setContent(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.contentText = content;
        return this;
    }

    public static /* synthetic */ MessageDialogFragment setPositiveBtn$default(MessageDialogFragment messageDialogFragment, String str, DialogUtils.OnButtonClickListener onButtonClickListener, int i, Object obj) {
        if ((i & 2) != 0) {
            onButtonClickListener = null;
        }
        return messageDialogFragment.setPositiveBtn(str, onButtonClickListener);
    }

    public final MessageDialogFragment setPositiveBtn(String positiveBtnText, DialogUtils.OnButtonClickListener listener) {
        Intrinsics.checkNotNullParameter(positiveBtnText, "positiveBtnText");
        this.positiveBtnText = positiveBtnText;
        this.positiveBtnListener = listener;
        return this;
    }

    public static /* synthetic */ MessageDialogFragment setInactiveBtn$default(MessageDialogFragment messageDialogFragment, String str, DialogUtils.OnButtonClickListener onButtonClickListener, int i, Object obj) {
        if ((i & 2) != 0) {
            onButtonClickListener = null;
        }
        return messageDialogFragment.setInactiveBtn(str, onButtonClickListener);
    }

    public final MessageDialogFragment setInactiveBtn(String inactiveBtnText, DialogUtils.OnButtonClickListener listener) {
        Intrinsics.checkNotNullParameter(inactiveBtnText, "inactiveBtnText");
        this.inactiveBtnText = inactiveBtnText;
        this.inactiveBtnListener = listener;
        return this;
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        show(manager, "MessageDialog");
    }
}
