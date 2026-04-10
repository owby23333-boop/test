package com.qmuiteam.qmui.widget.popup;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;
import com.qmuiteam.qmui.skin.IQMUISkinDispatchInterceptor;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.popup.QMUIBasePopup;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class QMUINormalPopup<T extends QMUIBasePopup> extends QMUIBasePopup<T> {
    public static final int ANIM_AUTO = 0;
    public static final int ANIM_GROW_FROM_CENTER = 3;
    public static final int ANIM_GROW_FROM_LEFT = 1;
    public static final int ANIM_GROW_FROM_RIGHT = 2;
    public static final int ANIM_SPEC = 4;
    public static final int DIRECTION_BOTTOM = 1;
    public static final int DIRECTION_CENTER_IN_SCREEN = 2;
    public static final int DIRECTION_TOP = 0;
    private boolean mAddShadow;
    protected int mAnimStyle;
    private int mArrowHeight;
    private int mArrowWidth;
    private int mBgColor;
    private int mBgColorAttr;
    private int mBgUsedColor;
    private int mBorderColor;
    private int mBorderColorAttr;
    private int mBorderUsedColor;
    private int mBorderWidth;
    private View mContentView;
    private int mEdgeProtectionBottom;
    private int mEdgeProtectionLeft;
    private int mEdgeProtectionRight;
    private int mEdgeProtectionTop;
    protected final int mInitHeight;
    protected final int mInitWidth;
    private boolean mIsBgColorSet;
    private boolean mIsBorderColorSet;
    private int mOffsetX;
    private int mOffsetYIfBottom;
    private int mOffsetYIfTop;
    private int mPreferredDirection;
    private int mRadius;
    private boolean mRemoveBorderWhenShadow;
    private float mShadowAlpha;
    private int mShadowElevation;
    private int mShadowInset;
    private boolean mShowArrow;
    protected int mSpecAnimStyle;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
    }

    protected int proxyHeight(int i) {
        return i;
    }

    protected int proxyWidth(int i) {
        return i;
    }

    public QMUINormalPopup(Context context, int i, int i2) {
        super(context);
        this.mShowArrow = true;
        this.mAddShadow = false;
        this.mRadius = -1;
        this.mBorderColor = 0;
        this.mBorderUsedColor = 0;
        this.mBorderColorAttr = R.attr.qmui_skin_support_popup_border_color;
        this.mIsBorderColorSet = false;
        this.mBorderWidth = -1;
        this.mShadowElevation = -1;
        this.mShadowAlpha = 0.0f;
        this.mShadowInset = -1;
        this.mBgColor = 0;
        this.mIsBgColorSet = false;
        this.mBgUsedColor = 0;
        this.mBgColorAttr = R.attr.qmui_skin_support_popup_bg;
        this.mOffsetX = 0;
        this.mOffsetYIfTop = 0;
        this.mOffsetYIfBottom = 0;
        this.mPreferredDirection = 1;
        this.mArrowWidth = -1;
        this.mArrowHeight = -1;
        this.mRemoveBorderWhenShadow = false;
        this.mInitWidth = i;
        this.mInitHeight = i2;
    }

    public T arrow(boolean z) {
        this.mShowArrow = z;
        return this;
    }

    public T arrowSize(int i, int i2) {
        this.mArrowWidth = i;
        this.mArrowHeight = i2;
        return this;
    }

    public T shadow(boolean z) {
        this.mAddShadow = z;
        return this;
    }

    public T removeBorderWhenShadow(boolean z) {
        this.mRemoveBorderWhenShadow = z;
        return this;
    }

    public T animStyle(int i) {
        this.mAnimStyle = i;
        return this;
    }

    public T customAnimStyle(int i) {
        this.mAnimStyle = 4;
        this.mSpecAnimStyle = i;
        return this;
    }

    public T radius(int i) {
        this.mRadius = i;
        return this;
    }

    public T shadowElevation(int i, float f) {
        this.mShadowAlpha = f;
        this.mShadowElevation = i;
        return this;
    }

    public T shadowInset(int i) {
        this.mShadowInset = i;
        return this;
    }

    public T edgeProtection(int i) {
        this.mEdgeProtectionLeft = i;
        this.mEdgeProtectionRight = i;
        this.mEdgeProtectionTop = i;
        this.mEdgeProtectionBottom = i;
        return this;
    }

    public T edgeProtection(int i, int i2, int i3, int i4) {
        this.mEdgeProtectionLeft = i;
        this.mEdgeProtectionTop = i2;
        this.mEdgeProtectionRight = i3;
        this.mEdgeProtectionBottom = i4;
        return this;
    }

    public T offsetX(int i) {
        this.mOffsetX = i;
        return this;
    }

    public T offsetYIfTop(int i) {
        this.mOffsetYIfTop = i;
        return this;
    }

    public T offsetYIfBottom(int i) {
        this.mOffsetYIfBottom = i;
        return this;
    }

    public T preferredDirection(int i) {
        this.mPreferredDirection = i;
        return this;
    }

    public T view(View view) {
        this.mContentView = view;
        return this;
    }

    public T view(int i) {
        return (T) view(LayoutInflater.from(this.mContext).inflate(i, (ViewGroup) null));
    }

    public T borderWidth(int i) {
        this.mBorderWidth = i;
        return this;
    }

    public T borderColor(int i) {
        this.mBorderColor = i;
        this.mIsBorderColorSet = true;
        return this;
    }

    public int getBgColor() {
        return this.mBgColor;
    }

    public int getBgColorAttr() {
        return this.mBgColorAttr;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderColorAttr() {
        return this.mBorderColorAttr;
    }

    public T bgColor(int i) {
        this.mBgColor = i;
        this.mIsBgColorSet = true;
        return this;
    }

    public T borderColorAttr(int i) {
        this.mBorderColorAttr = i;
        if (i != 0) {
            this.mIsBorderColorSet = false;
        }
        return this;
    }

    public T bgColorAttr(int i) {
        this.mBgColorAttr = i;
        if (i != 0) {
            this.mIsBgColorSet = false;
        }
        return this;
    }

    class ShowInfo {
        int anchorCenter;
        private Rect anchorFrame;
        int anchorHeight;
        private int[] anchorRootLocation;
        int contentHeightMeasureSpec;
        int contentWidthMeasureSpec;
        int decorationBottom;
        int decorationLeft;
        int decorationRight;
        int decorationTop;
        int direction;
        int height;
        Rect visibleWindowFrame;
        int width;
        int x;
        int y;

        ShowInfo(View view, int i, int i2, int i3, int i4) {
            this.anchorRootLocation = new int[2];
            this.anchorFrame = new Rect();
            this.visibleWindowFrame = new Rect();
            this.direction = QMUINormalPopup.this.mPreferredDirection;
            this.decorationLeft = 0;
            this.decorationRight = 0;
            this.decorationTop = 0;
            this.decorationBottom = 0;
            this.anchorHeight = i4 - i2;
            view.getRootView().getLocationOnScreen(this.anchorRootLocation);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.anchorCenter = iArr[0] + ((i + i3) / 2);
            view.getWindowVisibleDisplayFrame(this.visibleWindowFrame);
            this.anchorFrame.left = iArr[0] + i;
            this.anchorFrame.top = iArr[1] + i2;
            this.anchorFrame.right = iArr[0] + i3;
            this.anchorFrame.bottom = iArr[1] + i4;
        }

        ShowInfo(QMUINormalPopup qMUINormalPopup, View view) {
            this(view, 0, 0, view.getWidth(), view.getHeight());
        }

        float anchorProportion() {
            return (this.anchorCenter - this.x) / this.width;
        }

        int windowWidth() {
            return this.decorationLeft + this.width + this.decorationRight;
        }

        int windowHeight() {
            return this.decorationTop + this.height + this.decorationBottom;
        }

        int getVisibleWidth() {
            return this.visibleWindowFrame.width();
        }

        int getVisibleHeight() {
            return this.visibleWindowFrame.height();
        }

        int getWindowX() {
            return this.x - this.anchorRootLocation[0];
        }

        int getWindowY() {
            return this.y - this.anchorRootLocation[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldShowShadow() {
        return this.mAddShadow && QMUILayoutHelper.useFeature();
    }

    public T show(View view) {
        return (T) show(view, 0, 0, view.getWidth(), view.getHeight());
    }

    public T show(View view, int i, int i2, int i3, int i4) {
        if (this.mContentView == null) {
            throw new RuntimeException("you should call view() to set your content view");
        }
        QMUINormalPopup<T>.ShowInfo showInfo = new ShowInfo(view, i, i2, i3, i4);
        calculateWindowSize(showInfo);
        calculateXY(showInfo);
        adjustShowInfo(showInfo);
        decorateContentView(showInfo);
        setAnimationStyle(showInfo.anchorProportion(), showInfo.direction);
        this.mWindow.setWidth(showInfo.windowWidth());
        this.mWindow.setHeight(showInfo.windowHeight());
        showAtLocation(view, showInfo.getWindowX(), showInfo.getWindowY());
        return this;
    }

    private void decorateContentView(QMUINormalPopup<T>.ShowInfo showInfo) {
        ContentView contentViewWrap = ContentView.wrap(this.mContentView, this.mInitWidth, this.mInitHeight);
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        if (this.mIsBorderColorSet) {
            this.mBorderUsedColor = this.mBorderColor;
        } else if (this.mBorderColorAttr != 0) {
            this.mBorderUsedColor = QMUIResHelper.getAttrColor(this.mContext, this.mBorderColorAttr);
            qMUISkinValueBuilderAcquire.border(this.mBorderColorAttr);
        }
        if (this.mIsBgColorSet) {
            this.mBgUsedColor = this.mBgColor;
        } else if (this.mBgColorAttr != 0) {
            this.mBgUsedColor = QMUIResHelper.getAttrColor(this.mContext, this.mBgColorAttr);
            qMUISkinValueBuilderAcquire.background(this.mBgColorAttr);
        }
        if (this.mBorderWidth == -1) {
            this.mBorderWidth = QMUIResHelper.getAttrDimen(this.mContext, R.attr.qmui_popup_border_width);
        }
        QMUISkinHelper.setSkinValue(contentViewWrap, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
        contentViewWrap.setBackgroundColor(this.mBgUsedColor);
        contentViewWrap.setBorderColor(this.mBorderUsedColor);
        contentViewWrap.setBorderWidth(this.mBorderWidth);
        contentViewWrap.setShowBorderOnlyBeforeL(this.mRemoveBorderWhenShadow);
        if (this.mRadius == -1) {
            this.mRadius = QMUIResHelper.getAttrDimen(this.mContext, R.attr.qmui_popup_radius);
        }
        if (shouldShowShadow()) {
            contentViewWrap.setRadiusAndShadow(this.mRadius, this.mShadowElevation, this.mShadowAlpha);
        } else {
            contentViewWrap.setRadius(this.mRadius);
        }
        DecorRootView decorRootView = new DecorRootView(this.mContext, showInfo);
        decorRootView.setContentView(contentViewWrap);
        this.mWindow.setContentView(decorRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustShowInfo(QMUINormalPopup<T>.ShowInfo showInfo) {
        if (shouldShowShadow()) {
            if (this.mShadowElevation == -1) {
                this.mShadowElevation = QMUIResHelper.getAttrDimen(this.mContext, R.attr.qmui_popup_shadow_elevation);
                this.mShadowAlpha = QMUIResHelper.getAttrFloatValue(this.mContext, R.attr.qmui_popup_shadow_alpha);
            }
            if (this.mShadowInset == -1) {
                this.mShadowInset = QMUIResHelper.getAttrDimen(this.mContext, R.attr.qmui_popup_shadow_inset);
            }
            int i = showInfo.x;
            int i2 = showInfo.y;
            if (i - this.mShadowInset > showInfo.visibleWindowFrame.left) {
                showInfo.x -= this.mShadowInset;
                showInfo.decorationLeft = this.mShadowInset;
            } else {
                showInfo.decorationLeft = i - showInfo.visibleWindowFrame.left;
                showInfo.x = showInfo.visibleWindowFrame.left;
            }
            if (showInfo.width + i + this.mShadowInset < showInfo.visibleWindowFrame.right) {
                showInfo.decorationRight = this.mShadowInset;
            } else {
                showInfo.decorationRight = (showInfo.visibleWindowFrame.right - i) - showInfo.width;
            }
            if (i2 - this.mShadowInset > showInfo.visibleWindowFrame.top) {
                showInfo.y -= this.mShadowInset;
                showInfo.decorationTop = this.mShadowInset;
            } else {
                showInfo.decorationTop = i2 - showInfo.visibleWindowFrame.top;
                showInfo.y = showInfo.visibleWindowFrame.top;
            }
            if (showInfo.height + i2 + this.mShadowInset < showInfo.visibleWindowFrame.bottom) {
                showInfo.decorationBottom = this.mShadowInset;
            } else {
                showInfo.decorationBottom = (showInfo.visibleWindowFrame.bottom - i2) - showInfo.height;
            }
        }
        if (!this.mShowArrow || showInfo.direction == 2) {
            return;
        }
        if (this.mArrowWidth == -1) {
            this.mArrowWidth = QMUIResHelper.getAttrDimen(this.mContext, R.attr.qmui_popup_arrow_width);
        }
        if (this.mArrowHeight == -1) {
            this.mArrowHeight = QMUIResHelper.getAttrDimen(this.mContext, R.attr.qmui_popup_arrow_height);
        }
        if (showInfo.direction == 1) {
            if (shouldShowShadow()) {
                showInfo.y += this.mArrowHeight;
            }
            showInfo.decorationTop = Math.max(showInfo.decorationTop, this.mArrowHeight);
        } else if (showInfo.direction == 0) {
            showInfo.decorationBottom = Math.max(showInfo.decorationBottom, this.mArrowHeight);
            showInfo.y -= this.mArrowHeight;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void calculateXY(QMUINormalPopup<T>.ShowInfo showInfo) {
        int i = 2;
        if (showInfo.anchorCenter < showInfo.visibleWindowFrame.left + (showInfo.getVisibleWidth() / 2)) {
            showInfo.x = Math.max(this.mEdgeProtectionLeft + showInfo.visibleWindowFrame.left, (showInfo.anchorCenter - (showInfo.width / 2)) + this.mOffsetX);
        } else {
            showInfo.x = Math.min((showInfo.visibleWindowFrame.right - this.mEdgeProtectionRight) - showInfo.width, (showInfo.anchorCenter - (showInfo.width / 2)) + this.mOffsetX);
        }
        int i2 = this.mPreferredDirection;
        if (i2 == 1) {
            i = 0;
        } else if (i2 == 0) {
            i = 1;
        }
        handleDirection(showInfo, i2, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleDirection(QMUINormalPopup<T>.ShowInfo showInfo, int i, int i2) {
        if (i == 2) {
            showInfo.x = showInfo.visibleWindowFrame.left + ((showInfo.getVisibleWidth() - showInfo.width) / 2);
            showInfo.y = showInfo.visibleWindowFrame.top + ((showInfo.getVisibleHeight() - showInfo.height) / 2);
            showInfo.direction = 2;
        } else {
            if (i == 0) {
                showInfo.y = (((ShowInfo) showInfo).anchorFrame.top - showInfo.height) - this.mOffsetYIfTop;
                if (showInfo.y < this.mEdgeProtectionTop + showInfo.visibleWindowFrame.top) {
                    handleDirection(showInfo, i2, 2);
                    return;
                } else {
                    showInfo.direction = 0;
                    return;
                }
            }
            if (i == 1) {
                showInfo.y = ((ShowInfo) showInfo).anchorFrame.top + showInfo.anchorHeight + this.mOffsetYIfBottom;
                if (showInfo.y > (showInfo.visibleWindowFrame.bottom - this.mEdgeProtectionBottom) - showInfo.height) {
                    handleDirection(showInfo, i2, 2);
                } else {
                    showInfo.direction = 1;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0080 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void calculateWindowSize(com.qmuiteam.qmui.widget.popup.QMUINormalPopup<T>.ShowInfo r9) {
        /*
            r8 = this;
            int r0 = r8.mInitWidth
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1
            r3 = -1
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 0
            if (r0 <= 0) goto L1a
            int r0 = r8.proxyWidth(r0)
            r9.width = r0
            int r0 = r9.width
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            r9.contentWidthMeasureSpec = r0
            goto L36
        L1a:
            int r0 = r9.getVisibleWidth()
            int r6 = r8.mEdgeProtectionLeft
            int r0 = r0 - r6
            int r6 = r8.mEdgeProtectionRight
            int r0 = r0 - r6
            int r6 = r8.mInitWidth
            if (r6 != r3) goto L38
            int r0 = r8.proxyWidth(r0)
            r9.width = r0
            int r0 = r9.width
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            r9.contentWidthMeasureSpec = r0
        L36:
            r0 = r5
            goto L43
        L38:
            int r0 = r8.proxyWidth(r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r9.contentWidthMeasureSpec = r0
            r0 = r2
        L43:
            int r6 = r8.mInitHeight
            if (r6 <= 0) goto L56
            int r1 = r8.proxyHeight(r6)
            r9.height = r1
            int r1 = r9.height
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r4)
            r9.contentHeightMeasureSpec = r1
            goto L72
        L56:
            int r6 = r9.getVisibleHeight()
            int r7 = r8.mEdgeProtectionTop
            int r6 = r6 - r7
            int r7 = r8.mEdgeProtectionBottom
            int r6 = r6 - r7
            int r7 = r8.mInitHeight
            if (r7 != r3) goto L74
            int r1 = r8.proxyHeight(r6)
            r9.height = r1
            int r1 = r9.height
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r4)
            r9.contentHeightMeasureSpec = r1
        L72:
            r2 = r5
            goto L7e
        L74:
            int r3 = r8.proxyHeight(r6)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r1)
            r9.contentHeightMeasureSpec = r1
        L7e:
            if (r0 != 0) goto L82
            if (r2 == 0) goto La7
        L82:
            android.view.View r1 = r8.mContentView
            int r3 = r9.contentWidthMeasureSpec
            int r4 = r9.contentHeightMeasureSpec
            r1.measure(r3, r4)
            if (r0 == 0) goto L99
            android.view.View r0 = r8.mContentView
            int r0 = r0.getMeasuredWidth()
            int r0 = r8.proxyWidth(r0)
            r9.width = r0
        L99:
            if (r2 == 0) goto La7
            android.view.View r0 = r8.mContentView
            int r0 = r0.getMeasuredHeight()
            int r0 = r8.proxyHeight(r0)
            r9.height = r0
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qmuiteam.qmui.widget.popup.QMUINormalPopup.calculateWindowSize(com.qmuiteam.qmui.widget.popup.QMUINormalPopup$ShowInfo):void");
    }

    private void setAnimationStyle(float f, int i) {
        boolean z = i == 0;
        int i2 = this.mAnimStyle;
        if (i2 == 0) {
            if (f <= 0.25f) {
                this.mWindow.setAnimationStyle(z ? R.style.QMUI_Animation_PopUpMenu_Left : R.style.QMUI_Animation_PopDownMenu_Left);
                return;
            } else if (f > 0.25f && f < 0.75f) {
                this.mWindow.setAnimationStyle(z ? R.style.QMUI_Animation_PopUpMenu_Center : R.style.QMUI_Animation_PopDownMenu_Center);
                return;
            } else {
                this.mWindow.setAnimationStyle(z ? R.style.QMUI_Animation_PopUpMenu_Right : R.style.QMUI_Animation_PopDownMenu_Right);
                return;
            }
        }
        if (i2 == 1) {
            this.mWindow.setAnimationStyle(z ? R.style.QMUI_Animation_PopUpMenu_Left : R.style.QMUI_Animation_PopDownMenu_Left);
            return;
        }
        if (i2 == 2) {
            this.mWindow.setAnimationStyle(z ? R.style.QMUI_Animation_PopUpMenu_Right : R.style.QMUI_Animation_PopDownMenu_Right);
        } else if (i2 == 3) {
            this.mWindow.setAnimationStyle(z ? R.style.QMUI_Animation_PopUpMenu_Center : R.style.QMUI_Animation_PopDownMenu_Center);
        } else {
            if (i2 != 4) {
                return;
            }
            this.mWindow.setAnimationStyle(this.mSpecAnimStyle);
        }
    }

    static class ContentView extends QMUIFrameLayout {
        private ContentView(Context context) {
            super(context);
        }

        static ContentView wrap(View view, int i, int i2) {
            ContentView contentView = new ContentView(view.getContext());
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            contentView.addView(view, new FrameLayout.LayoutParams(i, i2));
            return contentView;
        }
    }

    class DecorRootView extends FrameLayout implements IQMUISkinDispatchInterceptor {
        private PorterDuffXfermode mArrowAlignMode;
        private Paint mArrowPaint;
        private Path mArrowPath;
        private RectF mArrowSaveRect;
        private View mContentView;
        private int mPendingHeight;
        private int mPendingWidth;
        private QMUINormalPopup<T>.ShowInfo mShowInfo;
        private Runnable mUpdateWindowAction;

        private DecorRootView(Context context, QMUINormalPopup<T>.ShowInfo showInfo) {
            super(context);
            this.mArrowSaveRect = new RectF();
            this.mArrowAlignMode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.mUpdateWindowAction = new Runnable() { // from class: com.qmuiteam.qmui.widget.popup.QMUINormalPopup.DecorRootView.1
                @Override // java.lang.Runnable
                public void run() {
                    DecorRootView.this.mShowInfo.width = DecorRootView.this.mPendingWidth;
                    DecorRootView.this.mShowInfo.height = DecorRootView.this.mPendingHeight;
                    QMUINormalPopup.this.calculateXY(DecorRootView.this.mShowInfo);
                    QMUINormalPopup.this.adjustShowInfo(DecorRootView.this.mShowInfo);
                    QMUINormalPopup.this.mWindow.update(DecorRootView.this.mShowInfo.getWindowX(), DecorRootView.this.mShowInfo.getWindowY(), DecorRootView.this.mShowInfo.windowWidth(), DecorRootView.this.mShowInfo.windowHeight());
                }
            };
            this.mShowInfo = showInfo;
            Paint paint = new Paint();
            this.mArrowPaint = paint;
            paint.setAntiAlias(true);
            this.mArrowPath = new Path();
        }

        public void setContentView(View view) {
            View view2 = this.mContentView;
            if (view2 != null) {
                removeView(view2);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.mContentView = view;
            addView(view);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            removeCallbacks(this.mUpdateWindowAction);
            View view = this.mContentView;
            if (view != null) {
                view.measure(this.mShowInfo.contentWidthMeasureSpec, this.mShowInfo.contentHeightMeasureSpec);
                int measuredWidth = this.mContentView.getMeasuredWidth();
                int measuredHeight = this.mContentView.getMeasuredHeight();
                if (this.mShowInfo.width != measuredWidth || this.mShowInfo.height != measuredHeight) {
                    this.mPendingWidth = measuredWidth;
                    this.mPendingHeight = measuredHeight;
                    post(this.mUpdateWindowAction);
                }
            }
            setMeasuredDimension(this.mShowInfo.windowWidth(), this.mShowInfo.windowHeight());
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            View view = this.mContentView;
            if (view != null) {
                view.layout(this.mShowInfo.decorationLeft, this.mShowInfo.decorationTop, this.mShowInfo.width + this.mShowInfo.decorationLeft, this.mShowInfo.height + this.mShowInfo.decorationTop);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            removeCallbacks(this.mUpdateWindowAction);
        }

        @Override // com.qmuiteam.qmui.skin.IQMUISkinDispatchInterceptor
        public boolean intercept(int i, Resources.Theme theme) {
            if (!QMUINormalPopup.this.mIsBorderColorSet && QMUINormalPopup.this.mBorderColorAttr != 0) {
                QMUINormalPopup qMUINormalPopup = QMUINormalPopup.this;
                qMUINormalPopup.mBorderUsedColor = QMUIResHelper.getAttrColor(theme, qMUINormalPopup.mBorderColorAttr);
            }
            if (QMUINormalPopup.this.mIsBgColorSet || QMUINormalPopup.this.mBgColorAttr == 0) {
                return false;
            }
            QMUINormalPopup qMUINormalPopup2 = QMUINormalPopup.this;
            qMUINormalPopup2.mBgUsedColor = QMUIResHelper.getAttrColor(theme, qMUINormalPopup2.mBgColorAttr);
            return false;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            if (QMUINormalPopup.this.mShowArrow) {
                if (this.mShowInfo.direction == 0) {
                    canvas.save();
                    this.mArrowSaveRect.set(0.0f, 0.0f, this.mShowInfo.width, this.mShowInfo.height);
                    this.mArrowPaint.setStyle(Paint.Style.FILL);
                    this.mArrowPaint.setColor(QMUINormalPopup.this.mBgUsedColor);
                    this.mArrowPaint.setXfermode(null);
                    canvas.translate(Math.min(Math.max((this.mShowInfo.anchorCenter - this.mShowInfo.x) - (QMUINormalPopup.this.mArrowWidth / 2), this.mShowInfo.decorationLeft), (getWidth() - this.mShowInfo.decorationRight) - QMUINormalPopup.this.mArrowWidth), (this.mShowInfo.decorationTop + this.mShowInfo.height) - QMUINormalPopup.this.mBorderWidth);
                    this.mArrowPath.reset();
                    this.mArrowPath.setLastPoint((-QMUINormalPopup.this.mArrowWidth) / 2.0f, -QMUINormalPopup.this.mArrowHeight);
                    this.mArrowPath.lineTo(QMUINormalPopup.this.mArrowWidth / 2.0f, QMUINormalPopup.this.mArrowHeight);
                    this.mArrowPath.lineTo((QMUINormalPopup.this.mArrowWidth * 3) / 2.0f, -QMUINormalPopup.this.mArrowHeight);
                    this.mArrowPath.close();
                    canvas.drawPath(this.mArrowPath, this.mArrowPaint);
                    if (!QMUINormalPopup.this.mRemoveBorderWhenShadow || !QMUINormalPopup.this.shouldShowShadow()) {
                        this.mArrowSaveRect.set(0.0f, -QMUINormalPopup.this.mBorderWidth, QMUINormalPopup.this.mArrowWidth, QMUINormalPopup.this.mArrowHeight + QMUINormalPopup.this.mBorderWidth);
                        int iSaveLayer = canvas.saveLayer(this.mArrowSaveRect, this.mArrowPaint, 31);
                        this.mArrowPaint.setStrokeWidth(QMUINormalPopup.this.mBorderWidth);
                        this.mArrowPaint.setColor(QMUINormalPopup.this.mBorderUsedColor);
                        this.mArrowPaint.setStyle(Paint.Style.STROKE);
                        canvas.drawPath(this.mArrowPath, this.mArrowPaint);
                        this.mArrowPaint.setXfermode(this.mArrowAlignMode);
                        this.mArrowPaint.setStyle(Paint.Style.FILL);
                        canvas.drawRect(0.0f, -QMUINormalPopup.this.mBorderWidth, QMUINormalPopup.this.mArrowWidth, 0.0f, this.mArrowPaint);
                        canvas.restoreToCount(iSaveLayer);
                    }
                    canvas.restore();
                    return;
                }
                if (this.mShowInfo.direction == 1) {
                    canvas.save();
                    this.mArrowPaint.setStyle(Paint.Style.FILL);
                    this.mArrowPaint.setXfermode(null);
                    this.mArrowPaint.setColor(QMUINormalPopup.this.mBgUsedColor);
                    canvas.translate(Math.min(Math.max((this.mShowInfo.anchorCenter - this.mShowInfo.x) - (QMUINormalPopup.this.mArrowWidth / 2), this.mShowInfo.decorationLeft), (getWidth() - this.mShowInfo.decorationRight) - QMUINormalPopup.this.mArrowWidth), this.mShowInfo.decorationTop + QMUINormalPopup.this.mBorderWidth);
                    this.mArrowPath.reset();
                    this.mArrowPath.setLastPoint((-QMUINormalPopup.this.mArrowWidth) / 2.0f, QMUINormalPopup.this.mArrowHeight);
                    this.mArrowPath.lineTo(QMUINormalPopup.this.mArrowWidth / 2.0f, -QMUINormalPopup.this.mArrowHeight);
                    this.mArrowPath.lineTo((QMUINormalPopup.this.mArrowWidth * 3) / 2.0f, QMUINormalPopup.this.mArrowHeight);
                    this.mArrowPath.close();
                    canvas.drawPath(this.mArrowPath, this.mArrowPaint);
                    if (!QMUINormalPopup.this.mRemoveBorderWhenShadow || !QMUINormalPopup.this.shouldShowShadow()) {
                        this.mArrowSaveRect.set(0.0f, (-QMUINormalPopup.this.mArrowHeight) - QMUINormalPopup.this.mBorderWidth, QMUINormalPopup.this.mArrowWidth, QMUINormalPopup.this.mBorderWidth);
                        int iSaveLayer2 = canvas.saveLayer(this.mArrowSaveRect, this.mArrowPaint, 31);
                        this.mArrowPaint.setStrokeWidth(QMUINormalPopup.this.mBorderWidth);
                        this.mArrowPaint.setStyle(Paint.Style.STROKE);
                        this.mArrowPaint.setColor(QMUINormalPopup.this.mBorderUsedColor);
                        canvas.drawPath(this.mArrowPath, this.mArrowPaint);
                        this.mArrowPaint.setXfermode(this.mArrowAlignMode);
                        this.mArrowPaint.setStyle(Paint.Style.FILL);
                        canvas.drawRect(0.0f, 0.0f, QMUINormalPopup.this.mArrowWidth, QMUINormalPopup.this.mBorderWidth, this.mArrowPaint);
                        canvas.restoreToCount(iSaveLayer2);
                    }
                    canvas.restore();
                }
            }
        }
    }
}
