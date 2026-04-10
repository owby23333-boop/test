package com.qmuiteam.qmui.widget.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.IQMUISkinHandlerView;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider;
import com.qmuiteam.qmui.util.QMUICollapsingTextHelper;
import com.qmuiteam.qmui.util.QMUIColorHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

/* JADX INFO: loaded from: classes4.dex */
public class QMUITabView extends FrameLayout implements IQMUISkinHandlerView {
    private static final String TAG = "QMUITabView";
    private Callback mCallback;
    private QMUICollapsingTextHelper mCollapsingTextHelper;
    private float mCurrentIconHeight;
    private float mCurrentIconLeft;
    private float mCurrentIconTop;
    private float mCurrentIconWidth;
    private float mCurrentTextHeight;
    private float mCurrentTextLeft;
    private float mCurrentTextTop;
    private float mCurrentTextWidth;
    private GestureDetector mGestureDetector;
    private float mNormalIconLeft;
    private float mNormalIconTop;
    private float mNormalTextLeft;
    private float mNormalTextTop;
    private Interpolator mPositionInterpolator;
    private float mSelectFraction;
    private float mSelectedIconLeft;
    private float mSelectedIconTop;
    private float mSelectedTextLeft;
    private float mSelectedTextTop;
    private QMUIRoundButton mSignCountView;
    private QMUITab mTab;

    public interface Callback {
        void onClick(QMUITabView qMUITabView);

        void onDoubleClick(QMUITabView qMUITabView);

        void onLongClick(QMUITabView qMUITabView);
    }

    public QMUITabView(Context context) {
        super(context);
        this.mCurrentIconLeft = 0.0f;
        this.mCurrentIconTop = 0.0f;
        this.mCurrentTextLeft = 0.0f;
        this.mCurrentTextTop = 0.0f;
        this.mCurrentIconWidth = 0.0f;
        this.mCurrentIconHeight = 0.0f;
        this.mCurrentTextWidth = 0.0f;
        this.mCurrentTextHeight = 0.0f;
        this.mNormalIconLeft = 0.0f;
        this.mNormalIconTop = 0.0f;
        this.mNormalTextLeft = 0.0f;
        this.mNormalTextTop = 0.0f;
        this.mSelectedIconLeft = 0.0f;
        this.mSelectedIconTop = 0.0f;
        this.mSelectedTextLeft = 0.0f;
        this.mSelectedTextTop = 0.0f;
        this.mSelectFraction = 0.0f;
        setFocusable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        this.mCollapsingTextHelper = new QMUICollapsingTextHelper(this, 1.0f);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.qmuiteam.qmui.widget.tab.QMUITabView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (QMUITabView.this.mCallback == null) {
                    return false;
                }
                QMUITabView.this.mCallback.onDoubleClick(QMUITabView.this);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (QMUITabView.this.mCallback != null) {
                    QMUITabView.this.mCallback.onClick(QMUITabView.this);
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return QMUITabView.this.mCallback != null;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (QMUITabView.this.mCallback != null) {
                    QMUITabView.this.mCallback.onLongClick(QMUITabView.this);
                }
            }
        });
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setPositionInterpolator(Interpolator interpolator) {
        this.mPositionInterpolator = interpolator;
        this.mCollapsingTextHelper.setPositionInterpolator(interpolator);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    public void bind(QMUITab qMUITab) {
        this.mCollapsingTextHelper.setTextSize(qMUITab.normalTextSize, qMUITab.selectedTextSize, false);
        this.mCollapsingTextHelper.setTypeface(qMUITab.normalTypeface, qMUITab.selectedTypeface, false);
        this.mCollapsingTextHelper.setTypefaceUpdateAreaPercent(qMUITab.typefaceUpdateAreaPercent);
        this.mCollapsingTextHelper.setGravity(51, 51, false);
        this.mCollapsingTextHelper.setText(qMUITab.getText());
        this.mTab = qMUITab;
        if (qMUITab.tabIcon != null) {
            qMUITab.tabIcon.setCallback(this);
        }
        boolean z = this.mTab.signCount == -1;
        boolean z2 = this.mTab.signCount > 0;
        if (z || z2) {
            ensureSignCountView(getContext());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mSignCountView.getLayoutParams();
            if (z2) {
                this.mSignCountView.setText(QMUILangHelper.formatNumberToLimitedDigits(this.mTab.signCount, this.mTab.signCountDigits));
                this.mSignCountView.setMinWidth(QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_tab_sign_count_view_min_size_with_text));
                layoutParams.width = -2;
                layoutParams.height = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_tab_sign_count_view_min_size_with_text);
            } else {
                this.mSignCountView.setText((CharSequence) null);
                int attrDimen = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_tab_sign_count_view_min_size);
                layoutParams.width = attrDimen;
                layoutParams.height = attrDimen;
            }
            this.mSignCountView.setLayoutParams(layoutParams);
            this.mSignCountView.setVisibility(0);
        } else {
            QMUIRoundButton qMUIRoundButton = this.mSignCountView;
            if (qMUIRoundButton != null) {
                qMUIRoundButton.setVisibility(8);
            }
        }
        updateSkinInfo(qMUITab);
        requestLayout();
    }

    public float getSelectFraction() {
        return this.mSelectFraction;
    }

    public void setSelectFraction(float f) {
        float fConstrain = QMUILangHelper.constrain(f, 0.0f, 1.0f);
        this.mSelectFraction = fConstrain;
        QMUITabIcon tabIcon = this.mTab.getTabIcon();
        if (tabIcon != null) {
            tabIcon.setSelectFraction(fConstrain, QMUIColorHelper.computeColor(this.mTab.getNormalColor(this), this.mTab.getSelectColor(this), fConstrain));
        }
        updateCurrentInfo(fConstrain);
        this.mCollapsingTextHelper.setExpansionFraction(1.0f - fConstrain);
        if (this.mSignCountView != null) {
            Point pointCalculateSignCountLayoutPosition = calculateSignCountLayoutPosition();
            int measuredWidth = pointCalculateSignCountLayoutPosition.x;
            int measuredHeight = pointCalculateSignCountLayoutPosition.y;
            if (pointCalculateSignCountLayoutPosition.x + this.mSignCountView.getMeasuredWidth() > getMeasuredWidth()) {
                measuredWidth = getMeasuredWidth() - this.mSignCountView.getMeasuredWidth();
            }
            if (pointCalculateSignCountLayoutPosition.y - this.mSignCountView.getMeasuredHeight() < 0) {
                measuredHeight = this.mSignCountView.getMeasuredHeight();
            }
            QMUIRoundButton qMUIRoundButton = this.mSignCountView;
            ViewCompat.offsetLeftAndRight(qMUIRoundButton, measuredWidth - qMUIRoundButton.getLeft());
            QMUIRoundButton qMUIRoundButton2 = this.mSignCountView;
            ViewCompat.offsetTopAndBottom(qMUIRoundButton2, measuredHeight - qMUIRoundButton2.getBottom());
        }
    }

    private void updateCurrentInfo(float f) {
        this.mCurrentIconLeft = QMUICollapsingTextHelper.lerp(this.mNormalIconLeft, this.mSelectedIconLeft, f, this.mPositionInterpolator);
        this.mCurrentIconTop = QMUICollapsingTextHelper.lerp(this.mNormalIconTop, this.mSelectedIconTop, f, this.mPositionInterpolator);
        int normalTabIconWidth = this.mTab.getNormalTabIconWidth();
        int normalTabIconHeight = this.mTab.getNormalTabIconHeight();
        float selectedTabIconScale = this.mTab.getSelectedTabIconScale();
        float f2 = normalTabIconWidth;
        this.mCurrentIconWidth = QMUICollapsingTextHelper.lerp(f2, f2 * selectedTabIconScale, f, this.mPositionInterpolator);
        float f3 = normalTabIconHeight;
        this.mCurrentIconHeight = QMUICollapsingTextHelper.lerp(f3, selectedTabIconScale * f3, f, this.mPositionInterpolator);
        this.mCurrentTextLeft = QMUICollapsingTextHelper.lerp(this.mNormalTextLeft, this.mSelectedTextLeft, f, this.mPositionInterpolator);
        this.mCurrentTextTop = QMUICollapsingTextHelper.lerp(this.mNormalTextTop, this.mSelectedTextTop, f, this.mPositionInterpolator);
        float collapsedTextWidth = this.mCollapsingTextHelper.getCollapsedTextWidth();
        float collapsedTextHeight = this.mCollapsingTextHelper.getCollapsedTextHeight();
        float expandedTextWidth = this.mCollapsingTextHelper.getExpandedTextWidth();
        float expandedTextHeight = this.mCollapsingTextHelper.getExpandedTextHeight();
        this.mCurrentTextWidth = QMUICollapsingTextHelper.lerp(collapsedTextWidth, expandedTextWidth, f, this.mPositionInterpolator);
        this.mCurrentTextHeight = QMUICollapsingTextHelper.lerp(collapsedTextHeight, expandedTextHeight, f, this.mPositionInterpolator);
    }

    public int getContentViewWidth() {
        double iconTextGap;
        if (this.mTab == null) {
            return 0;
        }
        float expandedTextWidth = this.mCollapsingTextHelper.getExpandedTextWidth();
        if (this.mTab.getTabIcon() == null) {
            iconTextGap = expandedTextWidth;
        } else {
            int iconPosition = this.mTab.getIconPosition();
            float normalTabIconWidth = this.mTab.getNormalTabIconWidth() * this.mTab.getSelectedTabIconScale();
            if (iconPosition == 3 || iconPosition == 1) {
                expandedTextWidth = Math.max(normalTabIconWidth, expandedTextWidth);
                iconTextGap = expandedTextWidth;
            } else {
                iconTextGap = normalTabIconWidth + expandedTextWidth + this.mTab.getIconTextGap();
            }
        }
        return (int) (iconTextGap + 0.5d);
    }

    public int getContentViewLeft() {
        QMUITab qMUITab = this.mTab;
        if (qMUITab == null) {
            return 0;
        }
        if (qMUITab.getTabIcon() == null) {
            return (int) (((double) this.mSelectedTextLeft) + 0.5d);
        }
        int iconPosition = this.mTab.getIconPosition();
        if (iconPosition == 3 || iconPosition == 1) {
            return (int) Math.min(this.mSelectedTextLeft, ((double) this.mSelectedIconLeft) + 0.5d);
        }
        if (iconPosition == 0) {
            return (int) (((double) this.mSelectedIconLeft) + 0.5d);
        }
        return (int) (((double) this.mSelectedTextLeft) + 0.5d);
    }

    private QMUIRoundButton ensureSignCountView(Context context) {
        FrameLayout.LayoutParams layoutParams;
        if (this.mSignCountView == null) {
            QMUIRoundButton qMUIRoundButtonCreateSignCountView = createSignCountView(context);
            this.mSignCountView = qMUIRoundButtonCreateSignCountView;
            if (qMUIRoundButtonCreateSignCountView.getLayoutParams() != null) {
                layoutParams = new FrameLayout.LayoutParams(this.mSignCountView.getLayoutParams());
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            addView(this.mSignCountView, layoutParams);
        }
        return this.mSignCountView;
    }

    protected QMUIRoundButton createSignCountView(Context context) {
        QMUIRoundButton qMUIRoundButton = new QMUIRoundButton(context, null, R.attr.qmui_tab_sign_count_view);
        QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new QMUISkinSimpleDefaultAttrProvider();
        qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(QMUISkinValueBuilder.BACKGROUND, R.attr.qmui_skin_support_tab_sign_count_view_bg_color);
        qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(QMUISkinValueBuilder.TEXT_COLOR, R.attr.qmui_skin_support_tab_sign_count_view_text_color);
        qMUIRoundButton.setTag(R.id.qmui_skin_default_attr_provider, qMUISkinSimpleDefaultAttrProvider);
        return qMUIRoundButton;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        float fMax;
        float fMax2;
        if (this.mTab == null) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        onMeasureTab(size, size2);
        QMUITabIcon tabIcon = this.mTab.getTabIcon();
        int iconPosition = this.mTab.getIconPosition();
        if (mode == Integer.MIN_VALUE) {
            if (tabIcon == null) {
                fMax2 = this.mCollapsingTextHelper.getExpandedTextWidth();
            } else if (iconPosition == 3 || iconPosition == 1) {
                fMax2 = Math.max(this.mTab.getNormalTabIconWidth() * this.mTab.getSelectedTabIconScale(), this.mCollapsingTextHelper.getExpandedTextWidth());
            } else {
                fMax2 = this.mCollapsingTextHelper.getExpandedTextWidth() + this.mTab.getIconTextGap() + (this.mTab.getNormalTabIconWidth() * this.mTab.getSelectedTabIconScale());
            }
            int iMax = (int) fMax2;
            QMUIRoundButton qMUIRoundButton = this.mSignCountView;
            if (qMUIRoundButton != null && qMUIRoundButton.getVisibility() != 8) {
                this.mSignCountView.measure(0, 0);
                iMax = Math.max(iMax, this.mSignCountView.getMeasuredWidth() + iMax + this.mTab.signCountHorizontalOffset);
            }
            i = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (tabIcon == null) {
                fMax = this.mCollapsingTextHelper.getExpandedTextHeight();
            } else if (iconPosition == 0 || iconPosition == 2) {
                fMax = Math.max(this.mTab.getNormalTabIconHeight() * this.mTab.getSelectedTabIconScale(), this.mCollapsingTextHelper.getExpandedTextWidth());
            } else {
                fMax = this.mCollapsingTextHelper.getExpandedTextHeight() + this.mTab.getIconTextGap() + (this.mTab.getNormalTabIconHeight() * this.mTab.getSelectedTabIconScale());
            }
            i2 = View.MeasureSpec.makeMeasureSpec((int) fMax, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    protected void onMeasureTab(int i, int i2) {
        if (this.mTab.getTabIcon() != null && !this.mTab.isAllowIconDrawOutside()) {
            float normalTabIconWidth = this.mTab.getNormalTabIconWidth() * this.mTab.selectedTabIconScale;
            float normalTabIconHeight = this.mTab.getNormalTabIconHeight() * this.mTab.selectedTabIconScale;
            int i3 = this.mTab.iconPosition;
            if (i3 == 1 || i3 == 3) {
                i2 = (int) (i2 - (normalTabIconHeight - this.mTab.getIconTextGap()));
            } else {
                i = (int) (i - (normalTabIconWidth - this.mTab.getIconTextGap()));
            }
        }
        this.mCollapsingTextHelper.setCollapsedBounds(0, 0, i, i2);
        this.mCollapsingTextHelper.setExpandedBounds(0, 0, i, i2);
        this.mCollapsingTextHelper.calculateBaseOffsets();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        onLayoutTab(i5, i6);
        onLayoutSignCount(i5, i6);
    }

    protected void onLayoutSignCount(int i, int i2) {
        if (this.mSignCountView == null || this.mTab == null) {
            return;
        }
        Point pointCalculateSignCountLayoutPosition = calculateSignCountLayoutPosition();
        int measuredWidth = pointCalculateSignCountLayoutPosition.x;
        int measuredHeight = pointCalculateSignCountLayoutPosition.y;
        if (pointCalculateSignCountLayoutPosition.x + this.mSignCountView.getMeasuredWidth() > i) {
            measuredWidth = i - this.mSignCountView.getMeasuredWidth();
        }
        if (pointCalculateSignCountLayoutPosition.y - this.mSignCountView.getMeasuredHeight() < 0) {
            measuredHeight = this.mSignCountView.getMeasuredHeight();
        }
        QMUIRoundButton qMUIRoundButton = this.mSignCountView;
        qMUIRoundButton.layout(measuredWidth, measuredHeight - qMUIRoundButton.getMeasuredHeight(), this.mSignCountView.getMeasuredWidth() + measuredWidth, measuredHeight);
    }

    private Point calculateSignCountLayoutPosition() {
        int i;
        float f;
        QMUITabIcon tabIcon = this.mTab.getTabIcon();
        int iconPosition = this.mTab.getIconPosition();
        if (tabIcon == null || iconPosition == 3 || iconPosition == 0) {
            i = (int) (this.mCurrentTextLeft + this.mCurrentTextWidth);
            f = this.mCurrentTextTop;
        } else {
            i = (int) (this.mCurrentIconLeft + this.mCurrentIconWidth);
            f = this.mCurrentIconTop;
        }
        Point point = new Point(i, (int) f);
        int i2 = this.mTab.signCountVerticalAlign;
        int i3 = this.mTab.signCountVerticalOffset;
        if (i2 == 1) {
            point.offset(this.mTab.signCountHorizontalOffset, i3 + this.mSignCountView.getMeasuredHeight());
        } else if (i2 == 2) {
            point.y = getMeasuredHeight() - ((getMeasuredHeight() - this.mSignCountView.getMeasuredHeight()) / 2);
            point.offset(this.mTab.signCountHorizontalOffset, i3);
        } else {
            point.offset(this.mTab.signCountHorizontalOffset, i3);
        }
        return point;
    }

    protected void onLayoutTab(int i, int i2) {
        if (this.mTab == null) {
            return;
        }
        this.mCollapsingTextHelper.calculateCurrentOffsets();
        QMUITabIcon tabIcon = this.mTab.getTabIcon();
        float collapsedTextWidth = this.mCollapsingTextHelper.getCollapsedTextWidth();
        float collapsedTextHeight = this.mCollapsingTextHelper.getCollapsedTextHeight();
        float expandedTextWidth = this.mCollapsingTextHelper.getExpandedTextWidth();
        float expandedTextHeight = this.mCollapsingTextHelper.getExpandedTextHeight();
        if (tabIcon == null) {
            this.mSelectedIconTop = 0.0f;
            this.mSelectedIconLeft = 0.0f;
            this.mNormalIconTop = 0.0f;
            this.mNormalIconLeft = 0.0f;
            int i3 = this.mTab.gravity & 112;
            if (i3 == 48) {
                this.mNormalTextTop = 0.0f;
                this.mSelectedTextTop = 0.0f;
            } else if (i3 == 80) {
                float f = i2;
                this.mNormalTextTop = f - collapsedTextHeight;
                this.mSelectedTextTop = f - expandedTextHeight;
            } else {
                float f2 = i2;
                this.mNormalTextTop = (f2 - collapsedTextHeight) / 2.0f;
                this.mSelectedTextTop = (f2 - expandedTextHeight) / 2.0f;
            }
            int i4 = this.mTab.gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            if (i4 == 3) {
                this.mNormalTextLeft = 0.0f;
                this.mSelectedTextLeft = 0.0f;
            } else if (i4 == 5) {
                float f3 = i;
                this.mNormalTextLeft = f3 - collapsedTextWidth;
                this.mSelectedTextLeft = f3 - expandedTextWidth;
            } else {
                float f4 = i;
                this.mNormalTextLeft = (f4 - collapsedTextWidth) / 2.0f;
                this.mSelectedTextLeft = (f4 - expandedTextWidth) / 2.0f;
            }
        } else {
            int iconTextGap = this.mTab.getIconTextGap();
            int i5 = this.mTab.iconPosition;
            float normalTabIconWidth = this.mTab.getNormalTabIconWidth();
            float normalTabIconHeight = this.mTab.getNormalTabIconHeight();
            float selectedTabIconScale = this.mTab.getSelectedTabIconScale() * normalTabIconWidth;
            float selectedTabIconScale2 = this.mTab.getSelectedTabIconScale() * normalTabIconHeight;
            float f5 = iconTextGap;
            float f6 = collapsedTextWidth + f5;
            float f7 = f6 + normalTabIconWidth;
            float f8 = collapsedTextHeight + f5;
            float f9 = f8 + normalTabIconHeight;
            float f10 = expandedTextWidth + f5;
            float f11 = f10 + selectedTabIconScale;
            float f12 = expandedTextHeight + f5;
            float f13 = f12 + selectedTabIconScale2;
            if (i5 == 1 || i5 == 3) {
                int i6 = this.mTab.gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
                if (i6 == 3) {
                    this.mNormalIconLeft = 0.0f;
                    this.mNormalTextLeft = 0.0f;
                    this.mSelectedIconLeft = 0.0f;
                    this.mSelectedTextLeft = 0.0f;
                } else if (i6 == 5) {
                    float f14 = i;
                    this.mNormalIconLeft = f14 - normalTabIconWidth;
                    this.mNormalTextLeft = f14 - collapsedTextWidth;
                    this.mSelectedIconLeft = f14 - selectedTabIconScale;
                    this.mSelectedTextLeft = f14 - expandedTextWidth;
                } else {
                    float f15 = i;
                    this.mNormalIconLeft = (f15 - normalTabIconWidth) / 2.0f;
                    this.mNormalTextLeft = (f15 - collapsedTextWidth) / 2.0f;
                    this.mSelectedIconLeft = (f15 - selectedTabIconScale) / 2.0f;
                    this.mSelectedTextLeft = (f15 - expandedTextWidth) / 2.0f;
                }
                int i7 = this.mTab.gravity & 112;
                if (i7 != 48) {
                    if (i7 != 80) {
                        if (i5 == 1) {
                            float f16 = i2;
                            if (f9 >= f16) {
                                this.mNormalIconTop = f16 - f9;
                            } else {
                                this.mNormalIconTop = (f16 - f9) / 2.0f;
                            }
                            this.mNormalTextTop = this.mNormalIconTop + f5 + normalTabIconHeight;
                            if (f13 >= f16) {
                                this.mSelectedIconTop = f16 - f13;
                            } else {
                                this.mSelectedIconTop = (f16 - f13) / 2.0f;
                            }
                            this.mSelectedTextTop = this.mSelectedIconTop + f5 + selectedTabIconScale2;
                        } else {
                            float f17 = i2;
                            if (f9 >= f17) {
                                this.mNormalTextTop = 0.0f;
                            } else {
                                this.mNormalTextTop = (f17 - f9) / 2.0f;
                            }
                            this.mNormalIconTop = this.mNormalTextTop + f5 + collapsedTextHeight;
                            if (f13 >= f17) {
                                this.mNormalTextTop = 0.0f;
                            } else {
                                this.mNormalTextTop = (f17 - f13) / 2.0f;
                            }
                            this.mNormalIconTop = this.mNormalTextTop + f5 + expandedTextHeight;
                        }
                    } else if (i5 == 1) {
                        float f18 = i2;
                        float f19 = f18 - collapsedTextHeight;
                        this.mNormalTextTop = f19;
                        float f20 = f18 - expandedTextHeight;
                        this.mSelectedTextTop = f20;
                        this.mNormalIconTop = (f19 - f5) - normalTabIconHeight;
                        this.mSelectedIconTop = (f20 - f5) - selectedTabIconScale2;
                    } else {
                        float f21 = i2;
                        float f22 = f21 - normalTabIconHeight;
                        this.mNormalIconTop = f22;
                        float f23 = f21 - selectedTabIconScale2;
                        this.mSelectedIconTop = f23;
                        this.mNormalTextTop = (f22 - f5) - collapsedTextHeight;
                        this.mSelectedTextTop = (f23 - f5) - expandedTextHeight;
                    }
                } else if (i5 == 1) {
                    this.mNormalIconTop = 0.0f;
                    this.mSelectedIconTop = 0.0f;
                    this.mNormalTextTop = normalTabIconHeight + f5;
                    this.mSelectedTextTop = selectedTabIconScale2 + f5;
                } else {
                    this.mNormalTextTop = 0.0f;
                    this.mSelectedTextTop = 0.0f;
                    this.mNormalIconTop = f8;
                    this.mSelectedIconTop = f12;
                }
            } else {
                int i8 = this.mTab.gravity & 112;
                if (i8 == 48) {
                    this.mNormalIconTop = 0.0f;
                    this.mNormalTextTop = 0.0f;
                    this.mSelectedIconTop = 0.0f;
                    this.mSelectedTextTop = 0.0f;
                } else if (i8 == 80) {
                    float f24 = i2;
                    this.mNormalIconTop = f24 - normalTabIconHeight;
                    this.mNormalTextTop = f24 - collapsedTextHeight;
                    this.mSelectedIconTop = f24 - selectedTabIconScale2;
                    this.mSelectedTextTop = f24 - expandedTextHeight;
                } else {
                    float f25 = i2;
                    this.mNormalIconTop = (f25 - normalTabIconHeight) / 2.0f;
                    this.mNormalTextTop = (f25 - collapsedTextHeight) / 2.0f;
                    this.mSelectedIconTop = (f25 - selectedTabIconScale2) / 2.0f;
                    this.mSelectedTextTop = (f25 - expandedTextHeight) / 2.0f;
                }
                int i9 = this.mTab.gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
                if (i9 != 3) {
                    if (i9 != 5) {
                        if (i5 == 2) {
                            float f26 = i;
                            float f27 = (f26 - f7) / 2.0f;
                            this.mNormalTextLeft = f27;
                            float f28 = (f26 - f11) / 2.0f;
                            this.mSelectedTextLeft = f28;
                            this.mNormalIconLeft = f27 + collapsedTextWidth + f5;
                            this.mSelectedIconLeft = f28 + expandedTextWidth + f5;
                        } else {
                            float f29 = i;
                            float f30 = (f29 - f7) / 2.0f;
                            this.mNormalIconLeft = f30;
                            float f31 = (f29 - f11) / 2.0f;
                            this.mSelectedIconLeft = f31;
                            this.mNormalTextLeft = f30 + normalTabIconWidth + f5;
                            this.mSelectedTextLeft = f31 + selectedTabIconScale + f5;
                        }
                    } else if (i5 == 2) {
                        float f32 = i;
                        this.mNormalTextLeft = f32 - f7;
                        this.mSelectedTextLeft = f32 - f11;
                        this.mNormalIconLeft = f32 - normalTabIconWidth;
                        this.mSelectedIconLeft = f32 - selectedTabIconScale;
                    } else {
                        float f33 = i;
                        this.mNormalIconLeft = f33 - f7;
                        this.mSelectedIconLeft = f33 - f11;
                        this.mNormalTextLeft = f33 - collapsedTextWidth;
                        this.mSelectedTextLeft = f33 - expandedTextWidth;
                    }
                } else if (i5 == 2) {
                    this.mNormalTextLeft = 0.0f;
                    this.mSelectedTextLeft = 0.0f;
                    this.mNormalIconLeft = f6;
                    this.mSelectedIconLeft = f10;
                } else {
                    this.mNormalIconLeft = 0.0f;
                    this.mSelectedIconLeft = 0.0f;
                    this.mNormalTextLeft = normalTabIconWidth + f5;
                    this.mSelectedTextLeft = selectedTabIconScale + f5;
                }
                if (i5 == 0) {
                    float f34 = i;
                    if (f7 >= f34) {
                        this.mNormalIconLeft = f34 - f7;
                    } else {
                        this.mNormalIconLeft = (f34 - f7) / 2.0f;
                    }
                    this.mNormalTextLeft = this.mNormalIconLeft + normalTabIconWidth + f5;
                    if (f11 >= f34) {
                        this.mSelectedIconLeft = f34 - f11;
                    } else {
                        this.mSelectedIconLeft = (f34 - f11) / 2.0f;
                    }
                    this.mSelectedTextLeft = this.mSelectedIconLeft + selectedTabIconScale + f5;
                } else {
                    float f35 = i;
                    if (f7 >= f35) {
                        this.mNormalTextLeft = 0.0f;
                    } else {
                        this.mNormalTextLeft = (f35 - f7) / 2.0f;
                    }
                    this.mNormalIconLeft = this.mNormalTextLeft + collapsedTextWidth + f5;
                    if (f11 >= f35) {
                        this.mSelectedTextLeft = 0.0f;
                    } else {
                        this.mSelectedTextLeft = (f35 - f11) / 2.0f;
                    }
                    this.mSelectedIconLeft = this.mSelectedTextLeft + expandedTextWidth + f5;
                }
            }
        }
        updateCurrentInfo(1.0f - this.mCollapsingTextHelper.getExpansionFraction());
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        onDrawTab(canvas);
        super.draw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setContentDescription(this.mTab.getText());
    }

    protected void onDrawTab(Canvas canvas) {
        QMUITab qMUITab = this.mTab;
        if (qMUITab == null) {
            return;
        }
        QMUITabIcon tabIcon = qMUITab.getTabIcon();
        if (tabIcon != null) {
            canvas.save();
            canvas.translate(this.mCurrentIconLeft, this.mCurrentIconTop);
            tabIcon.setBounds(0, 0, (int) this.mCurrentIconWidth, (int) this.mCurrentIconHeight);
            tabIcon.draw(canvas);
            canvas.restore();
        }
        canvas.save();
        canvas.translate(this.mCurrentTextLeft, this.mCurrentTextTop);
        this.mCollapsingTextHelper.draw(canvas);
        canvas.restore();
    }

    @Override // com.qmuiteam.qmui.skin.IQMUISkinHandlerView
    public void handle(QMUISkinManager qMUISkinManager, int i, Resources.Theme theme, SimpleArrayMap<String, Integer> simpleArrayMap) {
        QMUITab qMUITab = this.mTab;
        if (qMUITab != null) {
            updateSkinInfo(qMUITab);
            invalidate();
        }
    }

    private void updateSkinInfo(QMUITab qMUITab) {
        Drawable skinDrawable;
        Drawable skinDrawable2;
        Drawable skinDrawable3;
        int normalColor = qMUITab.getNormalColor(this);
        int selectColor = qMUITab.getSelectColor(this);
        this.mCollapsingTextHelper.setTextColor(ColorStateList.valueOf(normalColor), ColorStateList.valueOf(selectColor), true);
        if (qMUITab.tabIcon != null) {
            if (qMUITab.skinChangeWithTintColor || (qMUITab.skinChangeNormalWithTintColor && qMUITab.skinChangeSelectedWithTintColor)) {
                qMUITab.tabIcon.tint(normalColor, selectColor);
                return;
            }
            if (qMUITab.tabIcon.hasSelectedIcon()) {
                if (qMUITab.skinChangeNormalWithTintColor) {
                    qMUITab.tabIcon.tintNormal(normalColor);
                } else if (qMUITab.normalIconAttr != 0 && (skinDrawable2 = QMUISkinHelper.getSkinDrawable(this, qMUITab.normalIconAttr)) != null) {
                    qMUITab.tabIcon.srcNormal(skinDrawable2);
                }
                if (qMUITab.skinChangeSelectedWithTintColor) {
                    qMUITab.tabIcon.tintSelected(normalColor);
                    return;
                } else {
                    if (qMUITab.selectedIconAttr == 0 || (skinDrawable3 = QMUISkinHelper.getSkinDrawable(this, qMUITab.selectedIconAttr)) == null) {
                        return;
                    }
                    qMUITab.tabIcon.srcSelected(skinDrawable3);
                    return;
                }
            }
            if (qMUITab.skinChangeNormalWithTintColor) {
                qMUITab.tabIcon.tint(normalColor, selectColor);
            } else {
                if (qMUITab.normalIconAttr == 0 || (skinDrawable = QMUISkinHelper.getSkinDrawable(this, qMUITab.normalIconAttr)) == null) {
                    return;
                }
                qMUITab.tabIcon.src(skinDrawable, normalColor, selectColor);
            }
        }
    }
}
