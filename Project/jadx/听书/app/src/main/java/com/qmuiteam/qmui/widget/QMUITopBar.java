package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.collection.SimpleArrayMap;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaImageButton;
import com.qmuiteam.qmui.layout.QMUIRelativeLayout;
import com.qmuiteam.qmui.qqface.QMUIQQFaceView;
import com.qmuiteam.qmui.skin.IQMUISkinHandlerView;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider;
import com.qmuiteam.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QMUITopBar extends QMUIRelativeLayout implements IQMUISkinHandlerView, IQMUISkinDefaultAttrProvider {
    private static final int DEFAULT_VIEW_ID = -1;
    private static SimpleArrayMap<String, Integer> sDefaultSkinAttrs;
    private View mCenterView;
    private boolean mClearLeftPaddingWhenAddLeftBackView;
    private TextUtils.TruncateAt mEllipsize;
    private boolean mIsBackgroundSetterDisabled;
    private int mLeftBackDrawableRes;
    private int mLeftBackViewWidth;
    private int mLeftLastViewId;
    private List<View> mLeftViewList;
    private int mRightLastViewId;
    private List<View> mRightViewList;
    private int mSubTitleTextColor;
    private int mSubTitleTextSize;
    private Typeface mSubTitleTypeface;
    private QMUISpanTouchFixTextView mSubTitleView;
    private int mTitleContainerPaddingHor;
    private Rect mTitleContainerRect;
    private LinearLayout mTitleContainerView;
    private int mTitleGravity;
    private int mTitleMarginHorWhenNoBtnAside;
    private int mTitleTextColor;
    private int mTitleTextSize;
    private int mTitleTextSizeWithSubTitle;
    private Typeface mTitleTypeface;
    private QMUIQQFaceView mTitleView;
    private int mTopBarHeight;
    private int mTopBarImageBtnHeight;
    private int mTopBarImageBtnWidth;
    private IQMUISkinDefaultAttrProvider mTopBarImageColorTintColorProvider;
    private int mTopBarTextBtnPaddingHor;
    private ColorStateList mTopBarTextBtnTextColor;
    private int mTopBarTextBtnTextSize;
    private Typeface mTopBarTextBtnTypeface;
    private IQMUISkinDefaultAttrProvider mTopBarTextDefaultAttrProvider;

    public interface Action {
        void call(View view, int i, boolean z);
    }

    static {
        SimpleArrayMap<String, Integer> simpleArrayMap = new SimpleArrayMap<>(4);
        sDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put(QMUISkinValueBuilder.BOTTOM_SEPARATOR, Integer.valueOf(R.attr.qmui_skin_support_topbar_separator_color));
        sDefaultSkinAttrs.put(QMUISkinValueBuilder.BACKGROUND, Integer.valueOf(R.attr.qmui_skin_support_topbar_bg));
    }

    public QMUITopBar(Context context) {
        this(context, null);
    }

    public QMUITopBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUITopBarStyle);
    }

    public QMUITopBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTopBarHeight = -1;
        this.mIsBackgroundSetterDisabled = false;
        initVar();
        init(context, attributeSet, i);
    }

    private void initVar() {
        this.mLeftLastViewId = -1;
        this.mRightLastViewId = -1;
        this.mLeftViewList = new ArrayList();
        this.mRightViewList = new ArrayList();
    }

    void init(Context context, AttributeSet attributeSet) {
        init(context, attributeSet, R.attr.QMUITopBarStyle);
    }

    void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUITopBar, i, 0);
        this.mLeftBackDrawableRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.QMUITopBar_qmui_topbar_left_back_drawable_id, R.drawable.qmui_icon_topbar_back);
        this.mLeftBackViewWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_left_back_width, -1);
        this.mClearLeftPaddingWhenAddLeftBackView = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUITopBar_qmui_topbar_clear_left_padding_when_add_left_back_view, false);
        this.mTitleGravity = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUITopBar_qmui_topbar_title_gravity, 17);
        this.mTitleTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_title_text_size, QMUIDisplayHelper.sp2px(context, 17));
        this.mTitleTextSizeWithSubTitle = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_title_text_size_with_subtitle, QMUIDisplayHelper.sp2px(context, 16));
        this.mSubTitleTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_subtitle_text_size, QMUIDisplayHelper.sp2px(context, 11));
        this.mTitleTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUITopBar_qmui_topbar_title_color, QMUIResHelper.getAttrColor(context, R.attr.qmui_config_color_gray_1));
        this.mSubTitleTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUITopBar_qmui_topbar_subtitle_color, QMUIResHelper.getAttrColor(context, R.attr.qmui_config_color_gray_4));
        this.mTitleMarginHorWhenNoBtnAside = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_title_margin_horizontal_when_no_btn_aside, 0);
        this.mTitleContainerPaddingHor = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_title_container_padding_horizontal, 0);
        this.mTopBarImageBtnWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_image_btn_width, QMUIDisplayHelper.dp2px(context, 48));
        this.mTopBarImageBtnHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_image_btn_height, QMUIDisplayHelper.dp2px(context, 48));
        this.mTopBarTextBtnPaddingHor = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_text_btn_padding_horizontal, QMUIDisplayHelper.dp2px(context, 12));
        this.mTopBarTextBtnTextColor = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.QMUITopBar_qmui_topbar_text_btn_color_state_list);
        this.mTopBarTextBtnTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITopBar_qmui_topbar_text_btn_text_size, QMUIDisplayHelper.sp2px(context, 16));
        this.mTitleTypeface = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUITopBar_qmui_topbar_title_bold, false) ? Typeface.DEFAULT_BOLD : null;
        this.mSubTitleTypeface = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUITopBar_qmui_topbar_subtitle_bold, false) ? Typeface.DEFAULT_BOLD : null;
        this.mTopBarTextBtnTypeface = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUITopBar_qmui_topbar_text_btn_bold, false) ? Typeface.DEFAULT_BOLD : null;
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUITopBar_android_ellipsize, -1);
        if (i2 == 1) {
            this.mEllipsize = TextUtils.TruncateAt.START;
        } else if (i2 == 2) {
            this.mEllipsize = TextUtils.TruncateAt.MIDDLE;
        } else if (i2 == 3) {
            this.mEllipsize = TextUtils.TruncateAt.END;
        } else {
            this.mEllipsize = null;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof QMUICollapsingTopBarLayout) {
                makeSureTitleContainerView();
                return;
            }
        }
    }

    public void setCenterView(View view) {
        View view2 = this.mCenterView;
        if (view2 == view) {
            return;
        }
        if (view2 != null) {
            removeView(view2);
        }
        this.mCenterView = view;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(13);
        addView(view, layoutParams);
    }

    public QMUIQQFaceView setTitle(int i) {
        return setTitle(getContext().getString(i));
    }

    public QMUIQQFaceView setTitle(String str) {
        QMUIQQFaceView qMUIQQFaceViewEnsureTitleView = ensureTitleView();
        qMUIQQFaceViewEnsureTitleView.setText(str);
        if (QMUILangHelper.isNullOrEmpty(str)) {
            qMUIQQFaceViewEnsureTitleView.setVisibility(8);
        } else {
            qMUIQQFaceViewEnsureTitleView.setVisibility(0);
        }
        return qMUIQQFaceViewEnsureTitleView;
    }

    public CharSequence getTitle() {
        QMUIQQFaceView qMUIQQFaceView = this.mTitleView;
        if (qMUIQQFaceView == null) {
            return null;
        }
        return qMUIQQFaceView.getText();
    }

    public QMUIQQFaceView getTitleView() {
        return this.mTitleView;
    }

    public void showTitleView(boolean z) {
        QMUIQQFaceView qMUIQQFaceView = this.mTitleView;
        if (qMUIQQFaceView != null) {
            qMUIQQFaceView.setVisibility(z ? 0 : 8);
        }
    }

    private QMUIQQFaceView ensureTitleView() {
        if (this.mTitleView == null) {
            QMUIQQFaceView qMUIQQFaceView = new QMUIQQFaceView(getContext());
            this.mTitleView = qMUIQQFaceView;
            qMUIQQFaceView.setGravity(17);
            this.mTitleView.setSingleLine(true);
            this.mTitleView.setEllipsize(this.mEllipsize);
            this.mTitleView.setTypeface(this.mTitleTypeface);
            this.mTitleView.setTextColor(this.mTitleTextColor);
            QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new QMUISkinSimpleDefaultAttrProvider();
            qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(QMUISkinValueBuilder.TEXT_COLOR, R.attr.qmui_skin_support_topbar_title_color);
            this.mTitleView.setTag(R.id.qmui_skin_default_attr_provider, qMUISkinSimpleDefaultAttrProvider);
            updateTitleViewStyle();
            makeSureTitleContainerView().addView(this.mTitleView, generateTitleViewAndSubTitleViewLp());
        }
        return this.mTitleView;
    }

    private void updateTitleViewStyle() {
        if (this.mTitleView != null) {
            QMUISpanTouchFixTextView qMUISpanTouchFixTextView = this.mSubTitleView;
            if (qMUISpanTouchFixTextView == null || QMUILangHelper.isNullOrEmpty(qMUISpanTouchFixTextView.getText())) {
                this.mTitleView.setTextSize(this.mTitleTextSize);
            } else {
                this.mTitleView.setTextSize(this.mTitleTextSizeWithSubTitle);
            }
        }
    }

    public QMUISpanTouchFixTextView setSubTitle(CharSequence charSequence) {
        QMUISpanTouchFixTextView qMUISpanTouchFixTextViewEnsureSubTitleView = ensureSubTitleView();
        qMUISpanTouchFixTextViewEnsureSubTitleView.setText(charSequence);
        if (QMUILangHelper.isNullOrEmpty(charSequence)) {
            qMUISpanTouchFixTextViewEnsureSubTitleView.setVisibility(8);
        } else {
            qMUISpanTouchFixTextViewEnsureSubTitleView.setVisibility(0);
        }
        updateTitleViewStyle();
        return qMUISpanTouchFixTextViewEnsureSubTitleView;
    }

    public QMUISpanTouchFixTextView setSubTitle(int i) {
        return setSubTitle(getResources().getString(i));
    }

    private QMUISpanTouchFixTextView ensureSubTitleView() {
        if (this.mSubTitleView == null) {
            QMUISpanTouchFixTextView qMUISpanTouchFixTextView = new QMUISpanTouchFixTextView(getContext());
            this.mSubTitleView = qMUISpanTouchFixTextView;
            qMUISpanTouchFixTextView.setGravity(17);
            this.mSubTitleView.setSingleLine(true);
            this.mSubTitleView.setTypeface(this.mSubTitleTypeface);
            this.mSubTitleView.setEllipsize(this.mEllipsize);
            this.mSubTitleView.setTextSize(0, this.mSubTitleTextSize);
            this.mSubTitleView.setTextColor(this.mSubTitleTextColor);
            QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new QMUISkinSimpleDefaultAttrProvider();
            qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(QMUISkinValueBuilder.TEXT_COLOR, R.attr.qmui_skin_support_topbar_subtitle_color);
            this.mSubTitleView.setTag(R.id.qmui_skin_default_attr_provider, qMUISkinSimpleDefaultAttrProvider);
            LinearLayout.LayoutParams layoutParamsGenerateTitleViewAndSubTitleViewLp = generateTitleViewAndSubTitleViewLp();
            layoutParamsGenerateTitleViewAndSubTitleViewLp.topMargin = QMUIDisplayHelper.dp2px(getContext(), 1);
            makeSureTitleContainerView().addView(this.mSubTitleView, layoutParamsGenerateTitleViewAndSubTitleViewLp);
        }
        return this.mSubTitleView;
    }

    public QMUISpanTouchFixTextView getSubTitleView() {
        return this.mSubTitleView;
    }

    public void setTitleGravity(int i) {
        this.mTitleGravity = i;
        QMUIQQFaceView qMUIQQFaceView = this.mTitleView;
        if (qMUIQQFaceView != null) {
            ((LinearLayout.LayoutParams) qMUIQQFaceView.getLayoutParams()).gravity = i;
            if (i == 17 || i == 1) {
                this.mTitleView.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingBottom());
            }
        }
        QMUISpanTouchFixTextView qMUISpanTouchFixTextView = this.mSubTitleView;
        if (qMUISpanTouchFixTextView != null) {
            ((LinearLayout.LayoutParams) qMUISpanTouchFixTextView.getLayoutParams()).gravity = i;
        }
        requestLayout();
    }

    public Rect getTitleContainerRect() {
        if (this.mTitleContainerRect == null) {
            this.mTitleContainerRect = new Rect();
        }
        LinearLayout linearLayout = this.mTitleContainerView;
        if (linearLayout == null) {
            this.mTitleContainerRect.set(0, 0, 0, 0);
        } else {
            QMUIViewHelper.getDescendantRect(this, linearLayout, this.mTitleContainerRect);
        }
        return this.mTitleContainerRect;
    }

    public LinearLayout getTitleContainerView() {
        return this.mTitleContainerView;
    }

    void disableBackgroundSetter() {
        this.mIsBackgroundSetterDisabled = true;
        super.setBackgroundDrawable(null);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.mIsBackgroundSetterDisabled) {
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    private LinearLayout makeSureTitleContainerView() {
        if (this.mTitleContainerView == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mTitleContainerView = linearLayout;
            linearLayout.setOrientation(1);
            this.mTitleContainerView.setGravity(17);
            LinearLayout linearLayout2 = this.mTitleContainerView;
            int i = this.mTitleContainerPaddingHor;
            linearLayout2.setPadding(i, 0, i, 0);
            addView(this.mTitleContainerView, generateTitleContainerViewLp());
        }
        return this.mTitleContainerView;
    }

    private RelativeLayout.LayoutParams generateTitleContainerViewLp() {
        return new RelativeLayout.LayoutParams(-1, QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_topbar_height));
    }

    private LinearLayout.LayoutParams generateTitleViewAndSubTitleViewLp() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.mTitleGravity;
        return layoutParams;
    }

    public void addLeftView(View view, int i) {
        RelativeLayout.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null && (layoutParams2 instanceof RelativeLayout.LayoutParams)) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        addLeftView(view, i, layoutParams);
    }

    public void addLeftView(View view, int i, RelativeLayout.LayoutParams layoutParams) {
        int i2 = this.mLeftLastViewId;
        if (i2 == -1) {
            layoutParams.addRule(9);
        } else {
            layoutParams.addRule(1, i2);
        }
        layoutParams.alignWithParent = true;
        this.mLeftLastViewId = i;
        view.setId(i);
        this.mLeftViewList.add(view);
        addView(view, layoutParams);
    }

    public void addRightView(View view, int i) {
        RelativeLayout.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null && (layoutParams2 instanceof RelativeLayout.LayoutParams)) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        addRightView(view, i, layoutParams);
    }

    public void addRightView(View view, int i, RelativeLayout.LayoutParams layoutParams) {
        int i2 = this.mRightLastViewId;
        if (i2 == -1) {
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(0, i2);
        }
        layoutParams.alignWithParent = true;
        this.mRightLastViewId = i;
        view.setId(i);
        this.mRightViewList.add(view);
        addView(view, layoutParams);
    }

    public RelativeLayout.LayoutParams generateTopBarImageButtonLayoutParams() {
        return generateTopBarImageButtonLayoutParams(-1, -1);
    }

    public RelativeLayout.LayoutParams generateTopBarImageButtonLayoutParams(int i, int i2) {
        if (i2 <= 0) {
            i2 = this.mTopBarImageBtnHeight;
        }
        if (i <= 0) {
            i = this.mTopBarImageBtnWidth;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.topMargin = Math.max(0, (getTopBarHeight() - i2) / 2);
        return layoutParams;
    }

    public QMUIAlphaImageButton addRightImageButton(int i, int i2) {
        return addRightImageButton(i, true, i2);
    }

    public QMUIAlphaImageButton addRightImageButton(int i, boolean z, int i2) {
        return addRightImageButton(i, z, i2, -1, -1);
    }

    public QMUIAlphaImageButton addRightImageButton(int i, boolean z, int i2, int i3, int i4) {
        QMUIAlphaImageButton qMUIAlphaImageButtonGenerateTopBarImageButton = generateTopBarImageButton(i, z);
        addRightView(qMUIAlphaImageButtonGenerateTopBarImageButton, i2, generateTopBarImageButtonLayoutParams(i3, i4));
        return qMUIAlphaImageButtonGenerateTopBarImageButton;
    }

    public QMUIAlphaImageButton addLeftImageButton(int i, int i2) {
        return addLeftImageButton(i, true, i2);
    }

    public QMUIAlphaImageButton addLeftImageButton(int i, boolean z, int i2) {
        return addLeftImageButton(i, z, i2, -1, -1);
    }

    public QMUIAlphaImageButton addLeftImageButton(int i, boolean z, int i2, int i3, int i4) {
        QMUIAlphaImageButton qMUIAlphaImageButtonGenerateTopBarImageButton = generateTopBarImageButton(i, z);
        addLeftView(qMUIAlphaImageButtonGenerateTopBarImageButton, i2, generateTopBarImageButtonLayoutParams(i3, i4));
        return qMUIAlphaImageButtonGenerateTopBarImageButton;
    }

    public RelativeLayout.LayoutParams generateTopBarTextButtonLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mTopBarImageBtnHeight);
        layoutParams.topMargin = Math.max(0, (getTopBarHeight() - this.mTopBarImageBtnHeight) / 2);
        return layoutParams;
    }

    public Button addLeftTextButton(int i, int i2) {
        return addLeftTextButton(getResources().getString(i), i2);
    }

    public Button addLeftTextButton(String str, int i) {
        Button buttonGenerateTopBarTextButton = generateTopBarTextButton(str);
        addLeftView(buttonGenerateTopBarTextButton, i, generateTopBarTextButtonLayoutParams());
        return buttonGenerateTopBarTextButton;
    }

    public Button addRightTextButton(int i, int i2) {
        return addRightTextButton(getResources().getString(i), i2);
    }

    public Button addRightTextButton(String str, int i) {
        Button buttonGenerateTopBarTextButton = generateTopBarTextButton(str);
        addRightView(buttonGenerateTopBarTextButton, i, generateTopBarTextButtonLayoutParams());
        return buttonGenerateTopBarTextButton;
    }

    private Button generateTopBarTextButton(String str) {
        Button button = new Button(getContext());
        if (this.mTopBarTextDefaultAttrProvider == null) {
            QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new QMUISkinSimpleDefaultAttrProvider();
            qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(QMUISkinValueBuilder.TEXT_COLOR, R.attr.qmui_skin_support_topbar_text_btn_color_state_list);
            this.mTopBarTextDefaultAttrProvider = qMUISkinSimpleDefaultAttrProvider;
        }
        button.setTag(R.id.qmui_skin_default_attr_provider, this.mTopBarTextDefaultAttrProvider);
        button.setBackgroundResource(0);
        button.setMinWidth(0);
        button.setMinHeight(0);
        button.setMinimumWidth(0);
        button.setMinimumHeight(0);
        button.setTypeface(this.mTopBarTextBtnTypeface);
        int i = this.mTopBarTextBtnPaddingHor;
        button.setPadding(i, 0, i, 0);
        button.setTextColor(this.mTopBarTextBtnTextColor);
        button.setTextSize(0, this.mTopBarTextBtnTextSize);
        button.setGravity(17);
        button.setText(str);
        return button;
    }

    private QMUIAlphaImageButton generateTopBarImageButton(int i, boolean z) {
        QMUIAlphaImageButton qMUIAlphaImageButton = new QMUIAlphaImageButton(getContext());
        if (z) {
            if (this.mTopBarImageColorTintColorProvider == null) {
                QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new QMUISkinSimpleDefaultAttrProvider();
                qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(QMUISkinValueBuilder.TINT_COLOR, R.attr.qmui_skin_support_topbar_image_tint_color);
                this.mTopBarImageColorTintColorProvider = qMUISkinSimpleDefaultAttrProvider;
            }
            qMUIAlphaImageButton.setTag(R.id.qmui_skin_default_attr_provider, this.mTopBarImageColorTintColorProvider);
        }
        qMUIAlphaImageButton.setBackgroundColor(0);
        qMUIAlphaImageButton.setImageResource(i);
        return qMUIAlphaImageButton;
    }

    public QMUIAlphaImageButton addLeftBackImageButton() {
        if (this.mClearLeftPaddingWhenAddLeftBackView) {
            QMUIViewHelper.setPaddingLeft(this, 0);
        }
        if (this.mLeftBackViewWidth > 0) {
            return addLeftImageButton(this.mLeftBackDrawableRes, true, R.id.qmui_topbar_item_left_back, this.mLeftBackViewWidth, -1);
        }
        return addLeftImageButton(this.mLeftBackDrawableRes, R.id.qmui_topbar_item_left_back);
    }

    public void removeAllLeftViews() {
        Iterator<View> it = this.mLeftViewList.iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.mLeftLastViewId = -1;
        this.mLeftViewList.clear();
    }

    public void removeAllRightViews() {
        Iterator<View> it = this.mRightViewList.iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.mRightLastViewId = -1;
        this.mRightViewList.clear();
    }

    public void removeCenterViewAndTitleView() {
        View view = this.mCenterView;
        if (view != null) {
            if (view.getParent() == this) {
                removeView(this.mCenterView);
            }
            this.mCenterView = null;
        }
        QMUIQQFaceView qMUIQQFaceView = this.mTitleView;
        if (qMUIQQFaceView != null) {
            if (qMUIQQFaceView.getParent() == this) {
                removeView(this.mTitleView);
            }
            this.mTitleView = null;
        }
    }

    int getTopBarHeight() {
        if (this.mTopBarHeight == -1) {
            this.mTopBarHeight = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_topbar_height);
        }
        return this.mTopBarHeight;
    }

    public void setBackgroundAlpha(int i) {
        getBackground().mutate().setAlpha(i);
    }

    public int computeAndSetBackgroundAlpha(int i, int i2, int i3) {
        int iMax = (int) (Math.max(0.0d, Math.min((i - i2) / (i3 - i2), 1.0d)) * 255.0d);
        setBackgroundAlpha(iMax);
        return iMax;
    }

    @Override // com.qmuiteam.qmui.layout.QMUIRelativeLayout, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size;
        super.onMeasure(i, i2);
        if (this.mTitleContainerView != null) {
            int paddingLeft = getPaddingLeft();
            for (int i3 = 0; i3 < this.mLeftViewList.size(); i3++) {
                View view = this.mLeftViewList.get(i3);
                if (view.getVisibility() != 8) {
                    paddingLeft += view.getMeasuredWidth();
                }
            }
            int paddingRight = getPaddingRight();
            for (int i4 = 0; i4 < this.mRightViewList.size(); i4++) {
                View view2 = this.mRightViewList.get(i4);
                if (view2.getVisibility() != 8) {
                    paddingRight += view2.getMeasuredWidth();
                }
            }
            int iMax = Math.max(this.mTitleMarginHorWhenNoBtnAside, paddingLeft);
            int iMax2 = Math.max(this.mTitleMarginHorWhenNoBtnAside, paddingRight);
            if ((this.mTitleGravity & 7) == 1) {
                size = View.MeasureSpec.getSize(i) - (Math.max(iMax, iMax2) * 2);
            } else {
                size = (View.MeasureSpec.getSize(i) - iMax) - iMax2;
            }
            this.mTitleContainerView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax;
        super.onLayout(z, i, i2, i3, i4);
        LinearLayout linearLayout = this.mTitleContainerView;
        if (linearLayout != null) {
            int measuredWidth = linearLayout.getMeasuredWidth();
            int measuredHeight = this.mTitleContainerView.getMeasuredHeight();
            int measuredHeight2 = ((i4 - i2) - this.mTitleContainerView.getMeasuredHeight()) / 2;
            int paddingLeft = getPaddingLeft();
            if ((this.mTitleGravity & 7) == 1) {
                iMax = ((i3 - i) - this.mTitleContainerView.getMeasuredWidth()) / 2;
            } else {
                for (int i5 = 0; i5 < this.mLeftViewList.size(); i5++) {
                    View view = this.mLeftViewList.get(i5);
                    if (view.getVisibility() != 8) {
                        paddingLeft += view.getMeasuredWidth();
                    }
                }
                iMax = Math.max(paddingLeft, this.mTitleMarginHorWhenNoBtnAside);
            }
            this.mTitleContainerView.layout(iMax, measuredHeight2, measuredWidth + iMax, measuredHeight + measuredHeight2);
        }
    }

    @Override // com.qmuiteam.qmui.skin.IQMUISkinHandlerView
    public void handle(QMUISkinManager qMUISkinManager, int i, Resources.Theme theme, SimpleArrayMap<String, Integer> simpleArrayMap) {
        if (simpleArrayMap != null) {
            for (int i2 = 0; i2 < simpleArrayMap.size(); i2++) {
                String strKeyAt = simpleArrayMap.keyAt(i2);
                Integer numValueAt = simpleArrayMap.valueAt(i2);
                if (numValueAt != null && (!(getParent() instanceof QMUITopBarLayout) || (!QMUISkinValueBuilder.BACKGROUND.equals(strKeyAt) && !QMUISkinValueBuilder.BOTTOM_SEPARATOR.equals(strKeyAt)))) {
                    qMUISkinManager.defaultHandleSkinAttr(this, theme, strKeyAt, numValueAt.intValue());
                }
            }
        }
    }

    @Override // com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return sDefaultSkinAttrs;
    }

    public void eachLeftRightView(Action action) {
        for (int i = 0; i < this.mLeftViewList.size(); i++) {
            action.call(this.mLeftViewList.get(i), i, true);
        }
        for (int i2 = 0; i2 < this.mRightViewList.size(); i2++) {
            action.call(this.mRightViewList.get(i2), i2, false);
        }
    }
}
