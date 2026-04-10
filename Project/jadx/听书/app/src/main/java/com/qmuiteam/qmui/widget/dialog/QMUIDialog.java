package com.qmuiteam.qmui.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUIWrapContentScrollView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class QMUIDialog extends QMUIBaseDialog {
    private Context mBaseContext;

    public QMUIDialog(Context context) {
        this(context, R.style.QMUI_Dialog);
    }

    public QMUIDialog(Context context, int i) {
        super(context, i);
        this.mBaseContext = context;
        init();
    }

    private void init() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    public void showWithImmersiveCheck(Activity activity) {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        if ((systemUiVisibility & 1024) == 1024 || (systemUiVisibility & 4) == 4) {
            window.setFlags(8, 8);
            window.getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
            super.show();
            window.clearFlags(8);
            return;
        }
        super.show();
    }

    public void showWithImmersiveCheck() {
        Context context = this.mBaseContext;
        if (!(context instanceof Activity)) {
            super.show();
        } else {
            showWithImmersiveCheck((Activity) context);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class MessageDialogBuilder extends QMUIDialogBuilder<MessageDialogBuilder> {
        protected CharSequence mMessage;

        public MessageDialogBuilder(Context context) {
            super(context);
        }

        public MessageDialogBuilder setMessage(CharSequence charSequence) {
            this.mMessage = charSequence;
            return this;
        }

        public MessageDialogBuilder setMessage(int i) {
            return setMessage(getBaseContext().getResources().getString(i));
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
        protected View onCreateContent(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context) {
            CharSequence charSequence = this.mMessage;
            if (charSequence == null || charSequence.length() == 0) {
                return null;
            }
            QMUISpanTouchFixTextView qMUISpanTouchFixTextView = new QMUISpanTouchFixTextView(context);
            assignMessageTvWithAttr(qMUISpanTouchFixTextView, hasTitle(), R.attr.qmui_dialog_message_content_style);
            qMUISpanTouchFixTextView.setText(this.mMessage);
            qMUISpanTouchFixTextView.setMovementMethodDefault();
            QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
            qMUISkinValueBuilderAcquire.textColor(R.attr.qmui_skin_support_dialog_message_text_color);
            QMUISkinHelper.setSkinValue(qMUISpanTouchFixTextView, qMUISkinValueBuilderAcquire);
            QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
            return wrapWithScroll(qMUISpanTouchFixTextView);
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
        protected View onCreateTitle(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context) {
            CharSequence charSequence;
            View viewOnCreateTitle = super.onCreateTitle(qMUIDialog, qMUIDialogView, context);
            if (viewOnCreateTitle != null && ((charSequence = this.mMessage) == null || charSequence.length() == 0)) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.QMUIDialogTitleTvCustomDef, R.attr.qmui_dialog_title_style, 0);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i);
                    if (index == R.styleable.QMUIDialogTitleTvCustomDef_qmui_paddingBottomWhenNotContent) {
                        viewOnCreateTitle.setPadding(viewOnCreateTitle.getPaddingLeft(), viewOnCreateTitle.getPaddingTop(), viewOnCreateTitle.getPaddingRight(), typedArrayObtainStyledAttributes.getDimensionPixelSize(index, viewOnCreateTitle.getPaddingBottom()));
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }
            return viewOnCreateTitle;
        }

        public static void assignMessageTvWithAttr(TextView textView, boolean z, int i) {
            QMUIResHelper.assignTextViewWithAttr(textView, i);
            if (z) {
                return;
            }
            TypedArray typedArrayObtainStyledAttributes = textView.getContext().obtainStyledAttributes(null, R.styleable.QMUIDialogMessageTvCustomDef, i, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.QMUIDialogMessageTvCustomDef_qmui_paddingTopWhenNotTitle) {
                    textView.setPadding(textView.getPaddingLeft(), typedArrayObtainStyledAttributes.getDimensionPixelSize(index, textView.getPaddingTop()), textView.getPaddingRight(), textView.getPaddingBottom());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class CheckBoxMessageDialogBuilder extends QMUIDialogBuilder<CheckBoxMessageDialogBuilder> {
        private boolean mIsChecked;
        protected String mMessage;
        private QMUISpanTouchFixTextView mTextView;

        public CheckBoxMessageDialogBuilder(Context context) {
            super(context);
            this.mIsChecked = false;
        }

        public CheckBoxMessageDialogBuilder setMessage(String str) {
            this.mMessage = str;
            return this;
        }

        public CheckBoxMessageDialogBuilder setMessage(int i) {
            return setMessage(getBaseContext().getResources().getString(i));
        }

        public boolean isChecked() {
            return this.mIsChecked;
        }

        public CheckBoxMessageDialogBuilder setChecked(boolean z) {
            if (this.mIsChecked != z) {
                this.mIsChecked = z;
                QMUISpanTouchFixTextView qMUISpanTouchFixTextView = this.mTextView;
                if (qMUISpanTouchFixTextView != null) {
                    qMUISpanTouchFixTextView.setSelected(z);
                }
            }
            return this;
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
        protected View onCreateContent(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context) {
            String str = this.mMessage;
            if (str == null || str.length() == 0) {
                return null;
            }
            QMUISpanTouchFixTextView qMUISpanTouchFixTextView = new QMUISpanTouchFixTextView(context);
            this.mTextView = qMUISpanTouchFixTextView;
            qMUISpanTouchFixTextView.setMovementMethodDefault();
            MessageDialogBuilder.assignMessageTvWithAttr(this.mTextView, hasTitle(), R.attr.qmui_dialog_message_content_style);
            this.mTextView.setText(this.mMessage);
            Drawable skinDrawable = QMUISkinHelper.getSkinDrawable(this.mTextView, R.attr.qmui_skin_support_s_dialog_check_drawable);
            if (skinDrawable != null) {
                skinDrawable.setBounds(0, 0, skinDrawable.getIntrinsicWidth(), skinDrawable.getIntrinsicHeight());
                this.mTextView.setCompoundDrawables(skinDrawable, null, null, null);
            }
            QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
            qMUISkinValueBuilderAcquire.textColor(R.attr.qmui_skin_support_dialog_message_text_color);
            qMUISkinValueBuilderAcquire.textCompoundLeftSrc(R.attr.qmui_skin_support_s_dialog_check_drawable);
            QMUISkinHelper.setSkinValue(this.mTextView, qMUISkinValueBuilderAcquire);
            QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
            this.mTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIDialog.CheckBoxMessageDialogBuilder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CheckBoxMessageDialogBuilder.this.setChecked(!r2.mIsChecked);
                }
            });
            this.mTextView.setSelected(this.mIsChecked);
            return wrapWithScroll(this.mTextView);
        }

        @Deprecated
        public QMUISpanTouchFixTextView getTextView() {
            return this.mTextView;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class EditTextDialogBuilder extends QMUIDialogBuilder<EditTextDialogBuilder> {
        private CharSequence mDefaultText;
        protected EditText mEditText;
        private int mInputType;
        protected String mPlaceholder;
        protected AppCompatImageView mRightImageView;
        private TextWatcher mTextWatcher;
        protected TransformationMethod mTransformationMethod;

        protected void configRightImageView(AppCompatImageView appCompatImageView, EditText editText) {
        }

        public EditTextDialogBuilder(Context context) {
            super(context);
            this.mInputType = 1;
            this.mDefaultText = null;
        }

        public EditTextDialogBuilder setPlaceholder(String str) {
            this.mPlaceholder = str;
            return this;
        }

        public EditTextDialogBuilder setPlaceholder(int i) {
            return setPlaceholder(getBaseContext().getResources().getString(i));
        }

        public EditTextDialogBuilder setDefaultText(CharSequence charSequence) {
            this.mDefaultText = charSequence;
            return this;
        }

        public EditTextDialogBuilder setTransformationMethod(TransformationMethod transformationMethod) {
            this.mTransformationMethod = transformationMethod;
            return this;
        }

        public EditTextDialogBuilder setInputType(int i) {
            this.mInputType = i;
            return this;
        }

        public EditTextDialogBuilder setTextWatcher(TextWatcher textWatcher) {
            this.mTextWatcher = textWatcher;
            return this;
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
        protected ConstraintLayout.LayoutParams onCreateContentLayoutParams(Context context) {
            ConstraintLayout.LayoutParams layoutParamsOnCreateContentLayoutParams = super.onCreateContentLayoutParams(context);
            int attrDimen = QMUIResHelper.getAttrDimen(context, R.attr.qmui_dialog_padding_horizontal);
            layoutParamsOnCreateContentLayoutParams.leftMargin = attrDimen;
            layoutParamsOnCreateContentLayoutParams.rightMargin = attrDimen;
            layoutParamsOnCreateContentLayoutParams.topMargin = QMUIResHelper.getAttrDimen(context, R.attr.qmui_dialog_edit_margin_top);
            layoutParamsOnCreateContentLayoutParams.bottomMargin = QMUIResHelper.getAttrDimen(context, R.attr.qmui_dialog_edit_margin_bottom);
            return layoutParamsOnCreateContentLayoutParams;
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
        protected View onCreateContent(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context) {
            QMUIConstraintLayout qMUIConstraintLayout = new QMUIConstraintLayout(context);
            qMUIConstraintLayout.onlyShowBottomDivider(0, 0, QMUIResHelper.getAttrDimen(context, R.attr.qmui_dialog_edit_bottom_line_height), QMUIResHelper.getAttrColor(context, R.attr.qmui_skin_support_dialog_edit_bottom_line_color));
            QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
            qMUISkinValueBuilderAcquire.bottomSeparator(R.attr.qmui_skin_support_dialog_edit_bottom_line_color);
            QMUISkinHelper.setSkinValue(qMUIConstraintLayout, qMUISkinValueBuilderAcquire);
            AppCompatEditText appCompatEditText = new AppCompatEditText(context);
            this.mEditText = appCompatEditText;
            appCompatEditText.setBackgroundResource(0);
            MessageDialogBuilder.assignMessageTvWithAttr(this.mEditText, hasTitle(), R.attr.qmui_dialog_edit_content_style);
            this.mEditText.setFocusable(true);
            this.mEditText.setFocusableInTouchMode(true);
            this.mEditText.setImeOptions(2);
            this.mEditText.setId(R.id.qmui_dialog_edit_input);
            if (!QMUILangHelper.isNullOrEmpty(this.mDefaultText)) {
                this.mEditText.setText(this.mDefaultText);
            }
            TextWatcher textWatcher = this.mTextWatcher;
            if (textWatcher != null) {
                this.mEditText.addTextChangedListener(textWatcher);
            }
            qMUISkinValueBuilderAcquire.clear();
            qMUISkinValueBuilderAcquire.textColor(R.attr.qmui_skin_support_dialog_edit_text_color);
            qMUISkinValueBuilderAcquire.hintColor(R.attr.qmui_skin_support_dialog_edit_text_hint_color);
            QMUISkinHelper.setSkinValue(this.mEditText, qMUISkinValueBuilderAcquire);
            QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
            AppCompatImageView appCompatImageView = new AppCompatImageView(context);
            this.mRightImageView = appCompatImageView;
            appCompatImageView.setId(R.id.qmui_dialog_edit_right_icon);
            this.mRightImageView.setVisibility(8);
            configRightImageView(this.mRightImageView, this.mEditText);
            TransformationMethod transformationMethod = this.mTransformationMethod;
            if (transformationMethod != null) {
                this.mEditText.setTransformationMethod(transformationMethod);
            } else {
                this.mEditText.setInputType(this.mInputType);
            }
            String str = this.mPlaceholder;
            if (str != null) {
                this.mEditText.setHint(str);
            }
            qMUIConstraintLayout.addView(this.mEditText, createEditTextLayoutParams(context));
            qMUIConstraintLayout.addView(this.mRightImageView, createRightIconLayoutParams(context));
            return qMUIConstraintLayout;
        }

        protected ConstraintLayout.LayoutParams createEditTextLayoutParams(Context context) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -2);
            layoutParams.leftToLeft = 0;
            layoutParams.topToTop = 0;
            layoutParams.rightToLeft = R.id.qmui_dialog_edit_right_icon;
            layoutParams.rightToRight = QMUIDisplayHelper.dp2px(context, 5);
            layoutParams.goneRightMargin = 0;
            return layoutParams;
        }

        protected ConstraintLayout.LayoutParams createRightIconLayoutParams(Context context) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.rightToRight = 0;
            layoutParams.bottomToBottom = R.id.qmui_dialog_edit_input;
            return layoutParams;
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
        protected void onAfterCreate(QMUIDialog qMUIDialog, QMUIDialogRootLayout qMUIDialogRootLayout, Context context) {
            super.onAfterCreate(qMUIDialog, qMUIDialogRootLayout, context);
            final InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            qMUIDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    inputMethodManager.hideSoftInputFromWindow(EditTextDialogBuilder.this.mEditText.getWindowToken(), 0);
                }
            });
            this.mEditText.postDelayed(new Runnable() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder.2
                @Override // java.lang.Runnable
                public void run() {
                    EditTextDialogBuilder.this.mEditText.requestFocus();
                    inputMethodManager.showSoftInput(EditTextDialogBuilder.this.mEditText, 0);
                }
            }, 300L);
        }

        @Deprecated
        public EditText getEditText() {
            return this.mEditText;
        }

        public ImageView getRightImageView() {
            return this.mRightImageView;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class MenuBaseDialogBuilder<T extends QMUIDialogBuilder> extends QMUIDialogBuilder<T> {
        protected ArrayList<QMUIDialogMenuItemView> mMenuItemViews;
        protected ArrayList<ItemViewFactory> mMenuItemViewsFactoryList;

        public interface ItemViewFactory {
            QMUIDialogMenuItemView createItemView(Context context);
        }

        protected void onItemClick(int i) {
        }

        public MenuBaseDialogBuilder(Context context) {
            super(context);
            this.mMenuItemViews = new ArrayList<>();
            this.mMenuItemViewsFactoryList = new ArrayList<>();
        }

        public void clear() {
            this.mMenuItemViewsFactoryList.clear();
        }

        @Deprecated
        public T addItem(final QMUIDialogMenuItemView qMUIDialogMenuItemView, final DialogInterface.OnClickListener onClickListener) {
            qMUIDialogMenuItemView.setMenuIndex(this.mMenuItemViewsFactoryList.size());
            qMUIDialogMenuItemView.setListener(new QMUIDialogMenuItemView.MenuItemViewListener() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.1
                @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView.MenuItemViewListener
                public void onClick(int i) {
                    MenuBaseDialogBuilder.this.onItemClick(i);
                    DialogInterface.OnClickListener onClickListener2 = onClickListener;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(MenuBaseDialogBuilder.this.mDialog, i);
                    }
                }
            });
            this.mMenuItemViewsFactoryList.add(new ItemViewFactory() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.2
                @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory
                public QMUIDialogMenuItemView createItemView(Context context) {
                    return qMUIDialogMenuItemView;
                }
            });
            return this;
        }

        public T addItem(final ItemViewFactory itemViewFactory, final DialogInterface.OnClickListener onClickListener) {
            this.mMenuItemViewsFactoryList.add(new ItemViewFactory() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.3
                @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory
                public QMUIDialogMenuItemView createItemView(Context context) {
                    QMUIDialogMenuItemView qMUIDialogMenuItemViewCreateItemView = itemViewFactory.createItemView(context);
                    qMUIDialogMenuItemViewCreateItemView.setMenuIndex(MenuBaseDialogBuilder.this.mMenuItemViewsFactoryList.indexOf(this));
                    qMUIDialogMenuItemViewCreateItemView.setListener(new QMUIDialogMenuItemView.MenuItemViewListener() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.3.1
                        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView.MenuItemViewListener
                        public void onClick(int i) {
                            MenuBaseDialogBuilder.this.onItemClick(i);
                            if (onClickListener != null) {
                                onClickListener.onClick(MenuBaseDialogBuilder.this.mDialog, i);
                            }
                        }
                    });
                    return qMUIDialogMenuItemViewCreateItemView;
                }
            });
            return this;
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
        protected View onCreateContent(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context) {
            QMUILinearLayout qMUILinearLayout = new QMUILinearLayout(context);
            qMUILinearLayout.setOrientation(1);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.QMUIDialogMenuContainerStyleDef, R.attr.qmui_dialog_menu_container_style, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            int dimensionPixelSize = 0;
            int dimensionPixelSize2 = 0;
            int dimensionPixelSize3 = 0;
            int dimensionPixelSize4 = 0;
            int dimensionPixelSize5 = 0;
            int dimensionPixelSize6 = -1;
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.QMUIDialogMenuContainerStyleDef_android_paddingTop) {
                    dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize2);
                } else if (index == R.styleable.QMUIDialogMenuContainerStyleDef_android_paddingBottom) {
                    dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize4);
                } else if (index == R.styleable.QMUIDialogMenuContainerStyleDef_qmui_dialog_menu_container_single_padding_vertical) {
                    dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize);
                } else if (index == R.styleable.QMUIDialogMenuContainerStyleDef_qmui_dialog_menu_container_padding_top_when_title_exist) {
                    dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize3);
                } else if (index == R.styleable.QMUIDialogMenuContainerStyleDef_qmui_dialog_menu_container_padding_bottom_when_action_exist) {
                    dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize5);
                } else if (index == R.styleable.QMUIDialogMenuContainerStyleDef_qmui_dialog_menu_item_height) {
                    dimensionPixelSize6 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize6);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.mMenuItemViewsFactoryList.size() == 1) {
                dimensionPixelSize4 = dimensionPixelSize;
            } else {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!hasTitle()) {
                dimensionPixelSize3 = dimensionPixelSize;
            }
            if (this.mActions.size() <= 0) {
                dimensionPixelSize5 = dimensionPixelSize4;
            }
            qMUILinearLayout.setPadding(0, dimensionPixelSize3, 0, dimensionPixelSize5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dimensionPixelSize6);
            layoutParams.gravity = 16;
            this.mMenuItemViews.clear();
            Iterator<ItemViewFactory> it = this.mMenuItemViewsFactoryList.iterator();
            while (it.hasNext()) {
                QMUIDialogMenuItemView qMUIDialogMenuItemViewCreateItemView = it.next().createItemView(context);
                qMUILinearLayout.addView(qMUIDialogMenuItemViewCreateItemView, layoutParams);
                this.mMenuItemViews.add(qMUIDialogMenuItemViewCreateItemView);
            }
            return wrapWithScroll(qMUILinearLayout);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class MenuDialogBuilder extends MenuBaseDialogBuilder<MenuDialogBuilder> {
        public MenuDialogBuilder(Context context) {
            super(context);
        }

        public MenuDialogBuilder addItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            for (CharSequence charSequence : charSequenceArr) {
                addItem(charSequence, onClickListener);
            }
            return this;
        }

        public MenuDialogBuilder addItem(final CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            addItem(new MenuBaseDialogBuilder.ItemViewFactory() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuDialogBuilder.1
                @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory
                public QMUIDialogMenuItemView createItemView(Context context) {
                    return new QMUIDialogMenuItemView.TextItemView(context, charSequence);
                }
            }, onClickListener);
            return this;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class CheckableDialogBuilder extends MenuBaseDialogBuilder<CheckableDialogBuilder> {
        private int mCheckedIndex;

        public CheckableDialogBuilder(Context context) {
            super(context);
            this.mCheckedIndex = -1;
        }

        public int getCheckedIndex() {
            return this.mCheckedIndex;
        }

        public CheckableDialogBuilder setCheckedIndex(int i) {
            this.mCheckedIndex = i;
            return this;
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder, com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
        protected View onCreateContent(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context) {
            View viewOnCreateContent = super.onCreateContent(qMUIDialog, qMUIDialogView, context);
            int i = this.mCheckedIndex;
            if (i > -1 && i < this.mMenuItemViews.size()) {
                this.mMenuItemViews.get(this.mCheckedIndex).setChecked(true);
            }
            return viewOnCreateContent;
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder
        protected void onItemClick(int i) {
            for (int i2 = 0; i2 < this.mMenuItemViews.size(); i2++) {
                QMUIDialogMenuItemView qMUIDialogMenuItemView = this.mMenuItemViews.get(i2);
                if (i2 == i) {
                    qMUIDialogMenuItemView.setChecked(true);
                    this.mCheckedIndex = i;
                } else {
                    qMUIDialogMenuItemView.setChecked(false);
                }
            }
        }

        public CheckableDialogBuilder addItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            for (final CharSequence charSequence : charSequenceArr) {
                addItem(new MenuBaseDialogBuilder.ItemViewFactory() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIDialog.CheckableDialogBuilder.1
                    @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory
                    public QMUIDialogMenuItemView createItemView(Context context) {
                        return new QMUIDialogMenuItemView.MarkItemView(context, charSequence);
                    }
                }, onClickListener);
            }
            return this;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class MultiCheckableDialogBuilder extends MenuBaseDialogBuilder<MultiCheckableDialogBuilder> {
        private BitSet mCheckedItems;

        public MultiCheckableDialogBuilder(Context context) {
            super(context);
            this.mCheckedItems = new BitSet();
        }

        public MultiCheckableDialogBuilder setCheckedItems(BitSet bitSet) {
            this.mCheckedItems.clear();
            this.mCheckedItems.or(bitSet);
            return this;
        }

        public MultiCheckableDialogBuilder setCheckedItems(int[] iArr) {
            this.mCheckedItems.clear();
            if (iArr != null && iArr.length > 0) {
                for (int i : iArr) {
                    this.mCheckedItems.set(i);
                }
            }
            return this;
        }

        public MultiCheckableDialogBuilder addItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            for (final CharSequence charSequence : charSequenceArr) {
                addItem(new MenuBaseDialogBuilder.ItemViewFactory() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIDialog.MultiCheckableDialogBuilder.1
                    @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory
                    public QMUIDialogMenuItemView createItemView(Context context) {
                        return new QMUIDialogMenuItemView.CheckItemView(context, true, charSequence);
                    }
                }, onClickListener);
            }
            return this;
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder, com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
        protected View onCreateContent(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context) {
            View viewOnCreateContent = super.onCreateContent(qMUIDialog, qMUIDialogView, context);
            for (int i = 0; i < this.mMenuItemViews.size(); i++) {
                this.mMenuItemViews.get(i).setChecked(this.mCheckedItems.get(i));
            }
            return viewOnCreateContent;
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder
        protected void onItemClick(int i) {
            QMUIDialogMenuItemView qMUIDialogMenuItemView = this.mMenuItemViews.get(i);
            qMUIDialogMenuItemView.setChecked(!qMUIDialogMenuItemView.isChecked());
            this.mCheckedItems.set(i, qMUIDialogMenuItemView.isChecked());
        }

        public BitSet getCheckedItemRecord() {
            return (BitSet) this.mCheckedItems.clone();
        }

        public int[] getCheckedItemIndexes() {
            ArrayList arrayList = new ArrayList();
            int size = this.mMenuItemViews.size();
            for (int i = 0; i < size; i++) {
                QMUIDialogMenuItemView qMUIDialogMenuItemView = this.mMenuItemViews.get(i);
                if (qMUIDialogMenuItemView.isChecked()) {
                    arrayList.add(Integer.valueOf(qMUIDialogMenuItemView.getMenuIndex()));
                }
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            return iArr;
        }

        protected boolean existCheckedItem() {
            return !this.mCheckedItems.isEmpty();
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class CustomDialogBuilder extends QMUIDialogBuilder {
        private int mLayoutId;

        public CustomDialogBuilder(Context context) {
            super(context);
        }

        public CustomDialogBuilder setLayout(int i) {
            this.mLayoutId = i;
            return this;
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
        protected View onCreateContent(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context) {
            return LayoutInflater.from(context).inflate(this.mLayoutId, (ViewGroup) qMUIDialogView, false);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static abstract class AutoResizeDialogBuilder extends QMUIDialogBuilder {
        protected ScrollView mScrollView;

        public abstract View onBuildContent(QMUIDialog qMUIDialog, Context context);

        public AutoResizeDialogBuilder(Context context) {
            super(context);
            setCheckKeyboardOverlay(true);
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
        protected View onCreateContent(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context) {
            QMUIWrapContentScrollView qMUIWrapContentScrollViewWrapWithScroll = wrapWithScroll(onBuildContent(qMUIDialog, context));
            this.mScrollView = qMUIWrapContentScrollViewWrapWithScroll;
            return qMUIWrapContentScrollViewWrapWithScroll;
        }
    }
}
