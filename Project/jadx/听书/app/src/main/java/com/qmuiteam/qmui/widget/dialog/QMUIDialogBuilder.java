package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUIWrapContentScrollView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogRootLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogView;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUIDialogBuilder<T extends QMUIDialogBuilder> {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private static OnProvideDefaultTheme sOnProvideDefaultTheme;
    private Context mContext;
    protected QMUIDialog mDialog;
    protected QMUIDialogView mDialogView;
    private QMUIDialogView.OnDecorationListener mOnDecorationListener;
    protected QMUIDialogRootLayout mRootView;
    private QMUISkinManager mSkinManager;
    protected String mTitle;
    private boolean mCancelable = true;
    private boolean mCanceledOnTouchOutside = true;
    protected List<QMUIDialogAction> mActions = new ArrayList();
    private int mActionContainerOrientation = 0;
    private boolean mChangeAlphaForPressOrDisable = true;
    private int mActionDividerThickness = 0;
    private int mActionDividerColorAttr = R.attr.qmui_skin_support_dialog_action_divider_color;
    private int mActionDividerInsetStart = 0;
    private int mActionDividerInsetEnd = 0;
    private int mActionDividerColor = 0;
    private boolean mCheckKeyboardOverlay = false;
    private float mMaxPercent = 0.75f;

    public interface OnProvideDefaultTheme {
        int getThemeForBuilder(QMUIDialogBuilder qMUIDialogBuilder);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    protected void configRootLayout(QMUIDialogRootLayout qMUIDialogRootLayout) {
    }

    protected void onAfterCreate(QMUIDialog qMUIDialog, QMUIDialogRootLayout qMUIDialogRootLayout, Context context) {
    }

    protected abstract View onCreateContent(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context);

    protected void onOverlayOccurredInMeasure() {
    }

    public static void setOnProvideDefaultTheme(OnProvideDefaultTheme onProvideDefaultTheme) {
        sOnProvideDefaultTheme = onProvideDefaultTheme;
    }

    public QMUIDialogBuilder(Context context) {
        this.mContext = context;
    }

    public Context getBaseContext() {
        return this.mContext;
    }

    public T setTitle(String str) {
        if (str != null && str.length() > 0) {
            this.mTitle = str + this.mContext.getString(R.string.qmui_tool_fixellipsize);
        }
        return this;
    }

    public T setTitle(int i) {
        return (T) setTitle(this.mContext.getResources().getString(i));
    }

    public T setCancelable(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public T setCanceledOnTouchOutside(boolean z) {
        this.mCanceledOnTouchOutside = z;
        return this;
    }

    public T setOnDecorationListener(QMUIDialogView.OnDecorationListener onDecorationListener) {
        this.mOnDecorationListener = onDecorationListener;
        return this;
    }

    public T setActionContainerOrientation(int i) {
        this.mActionContainerOrientation = i;
        return this;
    }

    public T setChangeAlphaForPressOrDisable(boolean z) {
        this.mChangeAlphaForPressOrDisable = z;
        return this;
    }

    public T setActionDivider(int i, int i2, int i3, int i4) {
        this.mActionDividerThickness = i;
        this.mActionDividerColorAttr = i2;
        this.mActionDividerInsetStart = i3;
        this.mActionDividerInsetEnd = i4;
        return this;
    }

    public T setActionDividerInsetAndThickness(int i, int i2, int i3) {
        this.mActionDividerThickness = i;
        this.mActionDividerInsetStart = i2;
        this.mActionDividerInsetEnd = i3;
        return this;
    }

    public T setActionDividerColorAttr(int i) {
        this.mActionDividerColorAttr = i;
        return this;
    }

    public T setActionDividerColor(int i) {
        this.mActionDividerColor = i;
        this.mActionDividerColorAttr = 0;
        return this;
    }

    public T setCheckKeyboardOverlay(boolean z) {
        this.mCheckKeyboardOverlay = z;
        return this;
    }

    public T setSkinManager(QMUISkinManager qMUISkinManager) {
        this.mSkinManager = qMUISkinManager;
        return this;
    }

    public T setMaxPercent(float f) {
        this.mMaxPercent = f;
        return this;
    }

    public T addAction(QMUIDialogAction qMUIDialogAction) {
        if (qMUIDialogAction != null) {
            this.mActions.add(qMUIDialogAction);
        }
        return this;
    }

    public T addAction(int i, QMUIDialogAction.ActionListener actionListener) {
        return (T) addAction(0, i, actionListener);
    }

    public T addAction(CharSequence charSequence, QMUIDialogAction.ActionListener actionListener) {
        return (T) addAction(0, charSequence, 1, actionListener);
    }

    public T addAction(int i, int i2, QMUIDialogAction.ActionListener actionListener) {
        return (T) addAction(i, i2, 1, actionListener);
    }

    public T addAction(int i, CharSequence charSequence, QMUIDialogAction.ActionListener actionListener) {
        return (T) addAction(i, charSequence, 1, actionListener);
    }

    public T addAction(int i, int i2, int i3, QMUIDialogAction.ActionListener actionListener) {
        return (T) addAction(i, this.mContext.getResources().getString(i2), i3, actionListener);
    }

    public T addAction(int i, CharSequence charSequence, int i2, QMUIDialogAction.ActionListener actionListener) {
        this.mActions.add(new QMUIDialogAction(charSequence).iconRes(i).prop(i2).onClick(actionListener));
        return this;
    }

    protected boolean hasTitle() {
        String str = this.mTitle;
        return (str == null || str.length() == 0) ? false : true;
    }

    public QMUIDialog show() {
        QMUIDialog qMUIDialogCreate = create();
        qMUIDialogCreate.show();
        return qMUIDialogCreate;
    }

    public QMUIDialog create() {
        int themeForBuilder;
        OnProvideDefaultTheme onProvideDefaultTheme = sOnProvideDefaultTheme;
        if (onProvideDefaultTheme != null && (themeForBuilder = onProvideDefaultTheme.getThemeForBuilder(this)) > 0) {
            return create(themeForBuilder);
        }
        return create(R.style.QMUI_Dialog);
    }

    public QMUIDialog create(int i) {
        QMUIDialog qMUIDialog = new QMUIDialog(this.mContext, i);
        this.mDialog = qMUIDialog;
        Context context = qMUIDialog.getContext();
        this.mDialogView = onCreateDialogView(context);
        QMUIDialogRootLayout qMUIDialogRootLayout = new QMUIDialogRootLayout(context, this.mDialogView, onCreateDialogLayoutParams());
        this.mRootView = qMUIDialogRootLayout;
        qMUIDialogRootLayout.setCheckKeyboardOverlay(this.mCheckKeyboardOverlay);
        this.mRootView.setOverlayOccurInMeasureCallback(new QMUIDialogRootLayout.OverlayOccurInMeasureCallback() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder.1
            @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogRootLayout.OverlayOccurInMeasureCallback
            public void call() {
                QMUIDialogBuilder.this.onOverlayOccurredInMeasure();
            }
        });
        this.mRootView.setMaxPercent(this.mMaxPercent);
        configRootLayout(this.mRootView);
        QMUIDialogView dialogView = this.mRootView.getDialogView();
        this.mDialogView = dialogView;
        dialogView.setOnDecorationListener(this.mOnDecorationListener);
        View viewOnCreateTitle = onCreateTitle(this.mDialog, this.mDialogView, context);
        View viewOnCreateOperatorLayout = onCreateOperatorLayout(this.mDialog, this.mDialogView, context);
        View viewOnCreateContent = onCreateContent(this.mDialog, this.mDialogView, context);
        checkAndSetId(viewOnCreateTitle, R.id.qmui_dialog_title_id);
        checkAndSetId(viewOnCreateOperatorLayout, R.id.qmui_dialog_operator_layout_id);
        checkAndSetId(viewOnCreateContent, R.id.qmui_dialog_content_id);
        if (viewOnCreateTitle != null) {
            ConstraintLayout.LayoutParams layoutParamsOnCreateTitleLayoutParams = onCreateTitleLayoutParams(context);
            if (viewOnCreateContent != null) {
                layoutParamsOnCreateTitleLayoutParams.bottomToTop = viewOnCreateContent.getId();
            } else if (viewOnCreateOperatorLayout != null) {
                layoutParamsOnCreateTitleLayoutParams.bottomToTop = viewOnCreateOperatorLayout.getId();
            } else {
                layoutParamsOnCreateTitleLayoutParams.bottomToBottom = 0;
            }
            this.mDialogView.addView(viewOnCreateTitle, layoutParamsOnCreateTitleLayoutParams);
        }
        if (viewOnCreateContent != null) {
            ConstraintLayout.LayoutParams layoutParamsOnCreateContentLayoutParams = onCreateContentLayoutParams(context);
            if (viewOnCreateTitle != null) {
                layoutParamsOnCreateContentLayoutParams.topToBottom = viewOnCreateTitle.getId();
            } else {
                layoutParamsOnCreateContentLayoutParams.topToTop = 0;
            }
            if (viewOnCreateOperatorLayout != null) {
                layoutParamsOnCreateContentLayoutParams.bottomToTop = viewOnCreateOperatorLayout.getId();
            } else {
                layoutParamsOnCreateContentLayoutParams.bottomToBottom = 0;
            }
            this.mDialogView.addView(viewOnCreateContent, layoutParamsOnCreateContentLayoutParams);
        }
        if (viewOnCreateOperatorLayout != null) {
            ConstraintLayout.LayoutParams layoutParamsOnCreateOperatorLayoutLayoutParams = onCreateOperatorLayoutLayoutParams(context);
            if (viewOnCreateContent != null) {
                layoutParamsOnCreateOperatorLayoutLayoutParams.topToBottom = viewOnCreateContent.getId();
            } else if (viewOnCreateTitle != null) {
                layoutParamsOnCreateOperatorLayoutLayoutParams.topToBottom = viewOnCreateTitle.getId();
            } else {
                layoutParamsOnCreateOperatorLayoutLayoutParams.topToTop = 0;
            }
            this.mDialogView.addView(viewOnCreateOperatorLayout, layoutParamsOnCreateOperatorLayoutLayoutParams);
        }
        this.mDialog.addContentView(this.mRootView, new ViewGroup.LayoutParams(-2, -2));
        this.mDialog.setCancelable(this.mCancelable);
        this.mDialog.setCanceledOnTouchOutside(this.mCanceledOnTouchOutside);
        this.mDialog.setSkinManager(this.mSkinManager);
        onAfterCreate(this.mDialog, this.mRootView, context);
        return this.mDialog;
    }

    private void checkAndSetId(View view, int i) {
        if (view == null || view.getId() != -1) {
            return;
        }
        view.setId(i);
    }

    protected void skinConfigDialogView(QMUIDialogView qMUIDialogView) {
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.background(R.attr.qmui_skin_support_dialog_bg);
        QMUISkinHelper.setSkinValue(qMUIDialogView, qMUISkinValueBuilderAcquire);
        QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
    }

    protected void skinConfigTitleView(TextView textView) {
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.textColor(R.attr.qmui_skin_support_dialog_title_text_color);
        QMUISkinHelper.setSkinValue(textView, qMUISkinValueBuilderAcquire);
        QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
    }

    protected void skinConfigActionContainer(ViewGroup viewGroup) {
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.topSeparator(R.attr.qmui_skin_support_dialog_action_container_separator_color);
        QMUISkinHelper.setSkinValue(viewGroup, qMUISkinValueBuilderAcquire);
        QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
    }

    protected QMUIDialogView onCreateDialogView(Context context) {
        QMUIDialogView qMUIDialogView = new QMUIDialogView(context);
        qMUIDialogView.setBackground(QMUIResHelper.getAttrDrawable(context, R.attr.qmui_skin_support_dialog_bg));
        qMUIDialogView.setRadius(QMUIResHelper.getAttrDimen(context, R.attr.qmui_dialog_radius));
        skinConfigDialogView(qMUIDialogView);
        return qMUIDialogView;
    }

    protected FrameLayout.LayoutParams onCreateDialogLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    protected View onCreateTitle(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context) {
        if (!hasTitle()) {
            return null;
        }
        QMUISpanTouchFixTextView qMUISpanTouchFixTextView = new QMUISpanTouchFixTextView(context);
        qMUISpanTouchFixTextView.setId(R.id.qmui_dialog_title_id);
        qMUISpanTouchFixTextView.setText(this.mTitle);
        QMUIResHelper.assignTextViewWithAttr(qMUISpanTouchFixTextView, R.attr.qmui_dialog_title_style);
        skinConfigTitleView(qMUISpanTouchFixTextView);
        return qMUISpanTouchFixTextView;
    }

    protected ConstraintLayout.LayoutParams onCreateTitleLayoutParams(Context context) {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.topToTop = 0;
        layoutParams.verticalChainStyle = 2;
        return layoutParams;
    }

    protected QMUIWrapContentScrollView wrapWithScroll(View view) {
        QMUIWrapContentScrollView qMUIWrapContentScrollView = new QMUIWrapContentScrollView(view.getContext());
        qMUIWrapContentScrollView.addView(view);
        qMUIWrapContentScrollView.setVerticalScrollBarEnabled(false);
        return qMUIWrapContentScrollView;
    }

    protected ConstraintLayout.LayoutParams onCreateContentLayoutParams(Context context) {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.constrainedHeight = true;
        return layoutParams;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected android.view.View onCreateOperatorLayout(com.qmuiteam.qmui.widget.dialog.QMUIDialog r17, com.qmuiteam.qmui.widget.dialog.QMUIDialogView r18, android.content.Context r19) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder.onCreateOperatorLayout(com.qmuiteam.qmui.widget.dialog.QMUIDialog, com.qmuiteam.qmui.widget.dialog.QMUIDialogView, android.content.Context):android.view.View");
    }

    protected ConstraintLayout.LayoutParams onCreateOperatorLayoutLayoutParams(Context context) {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.verticalChainStyle = 2;
        return layoutParams;
    }

    private View createActionContainerSpace(Context context) {
        Space space = new Space(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        space.setLayoutParams(layoutParams);
        return space;
    }

    public List<QMUIDialogAction> getPositiveAction() {
        ArrayList arrayList = new ArrayList();
        for (QMUIDialogAction qMUIDialogAction : this.mActions) {
            if (qMUIDialogAction.getActionProp() == 0) {
                arrayList.add(qMUIDialogAction);
            }
        }
        return arrayList;
    }
}
