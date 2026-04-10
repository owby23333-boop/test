package com.qmuiteam.qmui.widget.popup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaImageButton;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.IBlankTouchDetector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIFullScreenPopup extends QMUIBasePopup<QMUIFullScreenPopup> {
    private boolean mAddCloseBtn;
    private int mAnimStyle;
    private Drawable mCloseIcon;
    private int mCloseIconAttr;
    private ConstraintLayout.LayoutParams mCloseIvLayoutParams;
    private OnBlankClickListener mOnBlankClickListener;
    private ArrayList<ViewInfo> mViews;

    public interface OnBlankClickListener {
        void onBlankClick(QMUIFullScreenPopup qMUIFullScreenPopup);
    }

    public QMUIFullScreenPopup(Context context) {
        super(context);
        this.mAddCloseBtn = false;
        this.mCloseIconAttr = R.attr.qmui_skin_support_popup_close_icon;
        this.mCloseIcon = null;
        this.mAnimStyle = -1;
        this.mViews = new ArrayList<>();
        this.mWindow.setWidth(-1);
        this.mWindow.setHeight(-1);
        this.mWindow.setSoftInputMode(16);
        dimAmount(0.6f);
    }

    public QMUIFullScreenPopup onBlankClick(OnBlankClickListener onBlankClickListener) {
        this.mOnBlankClickListener = onBlankClickListener;
        return this;
    }

    public QMUIFullScreenPopup closeBtn(boolean z) {
        this.mAddCloseBtn = z;
        return this;
    }

    public QMUIFullScreenPopup closeIcon(Drawable drawable) {
        this.mCloseIcon = drawable;
        return this;
    }

    public QMUIFullScreenPopup closeIconAttr(int i) {
        this.mCloseIconAttr = i;
        return this;
    }

    public QMUIFullScreenPopup closeLp(ConstraintLayout.LayoutParams layoutParams) {
        this.mCloseIvLayoutParams = layoutParams;
        return this;
    }

    public int getCloseBtnId() {
        return R.id.qmui_popup_close_btn_id;
    }

    public QMUIFullScreenPopup animStyle(int i) {
        this.mAnimStyle = i;
        return this;
    }

    public QMUIFullScreenPopup addView(View view, ConstraintLayout.LayoutParams layoutParams) {
        this.mViews.add(new ViewInfo(view, layoutParams));
        return this;
    }

    public QMUIFullScreenPopup addView(View view) {
        this.mViews.add(new ViewInfo(view, defaultContentLp()));
        return this;
    }

    private ConstraintLayout.LayoutParams defaultContentLp() {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        return layoutParams;
    }

    private ConstraintLayout.LayoutParams defaultCloseIvLp() {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.bottomMargin = QMUIDisplayHelper.dp2px(this.mContext, 48);
        return layoutParams;
    }

    private QMUIAlphaImageButton createCloseIv() {
        QMUIAlphaImageButton qMUIAlphaImageButton = new QMUIAlphaImageButton(this.mContext);
        qMUIAlphaImageButton.setPadding(0, 0, 0, 0);
        qMUIAlphaImageButton.setScaleType(ImageView.ScaleType.CENTER);
        qMUIAlphaImageButton.setId(R.id.qmui_popup_close_btn_id);
        qMUIAlphaImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.qmuiteam.qmui.widget.popup.QMUIFullScreenPopup.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QMUIFullScreenPopup.this.dismiss();
            }
        });
        qMUIAlphaImageButton.setFitsSystemWindows(true);
        Drawable attrDrawable = this.mCloseIcon;
        if (attrDrawable == null) {
            if (this.mCloseIconAttr != 0) {
                QMUISkinValueBuilder qMUISkinValueBuilderSrc = QMUISkinValueBuilder.acquire().src(this.mCloseIconAttr);
                QMUISkinHelper.setSkinValue(qMUIAlphaImageButton, qMUISkinValueBuilderSrc);
                qMUISkinValueBuilderSrc.release();
                attrDrawable = QMUIResHelper.getAttrDrawable(this.mContext, this.mCloseIconAttr);
            } else {
                attrDrawable = null;
            }
        }
        qMUIAlphaImageButton.setImageDrawable(attrDrawable);
        return qMUIAlphaImageButton;
    }

    public boolean isShowing() {
        return this.mWindow.isShowing();
    }

    public void show(View view) {
        if (isShowing()) {
            return;
        }
        if (this.mViews.isEmpty()) {
            throw new RuntimeException("you should call addView() to add content view");
        }
        ArrayList arrayList = new ArrayList(this.mViews);
        RootView rootView = new RootView(this.mContext);
        for (int i = 0; i < arrayList.size(); i++) {
            ViewInfo viewInfo = this.mViews.get(i);
            View view2 = viewInfo.view;
            if (view2.getParent() != null) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            rootView.addView(view2, viewInfo.lp);
        }
        if (this.mAddCloseBtn) {
            if (this.mCloseIvLayoutParams == null) {
                this.mCloseIvLayoutParams = defaultCloseIvLp();
            }
            rootView.addView(createCloseIv(), this.mCloseIvLayoutParams);
        }
        this.mWindow.setContentView(rootView);
        if (this.mAnimStyle != -1) {
            this.mWindow.setAnimationStyle(this.mAnimStyle);
        }
        showAtLocation(view, 0, 0);
    }

    @Override // com.qmuiteam.qmui.widget.popup.QMUIBasePopup
    protected void modifyWindowLayoutParams(WindowManager.LayoutParams layoutParams) {
        layoutParams.flags |= 65792;
        super.modifyWindowLayoutParams(layoutParams);
    }

    class RootView extends QMUIConstraintLayout {
        private boolean mShouldInvokeBlackClickWhenTouchUp;

        public RootView(Context context) {
            super(context);
            this.mShouldInvokeBlackClickWhenTouchUp = false;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (QMUIFullScreenPopup.this.mOnBlankClickListener == null) {
                return true;
            }
            if (actionMasked == 0) {
                this.mShouldInvokeBlackClickWhenTouchUp = isTouchInBlack(motionEvent);
            } else {
                boolean z = false;
                if (actionMasked == 2) {
                    if (this.mShouldInvokeBlackClickWhenTouchUp && isTouchInBlack(motionEvent)) {
                        z = true;
                    }
                    this.mShouldInvokeBlackClickWhenTouchUp = z;
                } else if (actionMasked == 1 || actionMasked == 3) {
                    if (this.mShouldInvokeBlackClickWhenTouchUp && isTouchInBlack(motionEvent)) {
                        z = true;
                    }
                    this.mShouldInvokeBlackClickWhenTouchUp = z;
                    if (z) {
                        QMUIFullScreenPopup.this.mOnBlankClickListener.onBlankClick(QMUIFullScreenPopup.this);
                    }
                }
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private boolean isTouchInBlack(MotionEvent motionEvent) {
            View viewFindChildViewUnder = findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            boolean z = viewFindChildViewUnder == 0;
            if (z || !(viewFindChildViewUnder instanceof IBlankTouchDetector)) {
                return z;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.offsetLocation(getScrollX() - viewFindChildViewUnder.getLeft(), getScrollY() - viewFindChildViewUnder.getTop());
            boolean zIsTouchInBlank = ((IBlankTouchDetector) viewFindChildViewUnder).isTouchInBlank(motionEventObtain);
            motionEventObtain.recycle();
            return zIsTouchInBlank;
        }

        private View findChildViewUnder(float f, float f2) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                float translationX = childAt.getTranslationX();
                float translationY = childAt.getTranslationY();
                if (f >= childAt.getLeft() + translationX && f <= childAt.getRight() + translationX && f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            Iterator it = QMUIFullScreenPopup.this.mViews.iterator();
            while (it.hasNext()) {
                QMUIViewHelper.getOrCreateOffsetHelper(((ViewInfo) it.next()).view).onViewLayout();
            }
        }
    }

    class ViewInfo {
        private ConstraintLayout.LayoutParams lp;
        private View view;

        public ViewInfo(View view, ConstraintLayout.LayoutParams layoutParams) {
            this.view = view;
            this.lp = layoutParams;
        }
    }
}
