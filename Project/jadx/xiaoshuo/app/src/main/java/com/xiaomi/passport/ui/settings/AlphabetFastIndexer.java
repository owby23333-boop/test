package com.xiaomi.passport.ui.settings;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.WrapperListAdapter;
import androidx.core.view.GravityCompat;
import com.xiaomi.account.passportsdk.account_sso.R;
import com.yuewen.pt;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
@SuppressLint({"AppCompatCustomView"})
public class AlphabetFastIndexer extends ImageView {
    private static final int FADE_DELAYED = 1500;
    private static final int MSG_FADE = 1;
    private static final String STARRED_LABEL = "★";
    public static final String STARRED_TITLE = "!";
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_NONE = 0;
    private Handler mHandler;
    private int mLastAlphabetIndex;
    private int mListScrollState;
    private AdapterView<?> mListView;
    private TextView mOverlay;
    private Drawable mOverlayBackground;
    private int mOverlayLeftMargin;
    private int mOverlayTextColor;
    private int mOverlayTextSize;
    private int mOverlayTopMargin;
    private Runnable mRefreshMaskRunnable;
    private int mState;
    private ValueAnimator.AnimatorUpdateListener mTextHilightAnimListener;
    private TextHilighter mTextHilighter;
    private int mVerticalPosition;

    public static class OnScrollerDecorator implements AbsListView.OnScrollListener {
        private final WeakReference<AlphabetFastIndexer> mIndexerRef;
        private final AbsListView.OnScrollListener mListener;

        public OnScrollerDecorator(AlphabetFastIndexer alphabetFastIndexer, AbsListView.OnScrollListener onScrollListener) {
            this.mIndexerRef = new WeakReference<>(alphabetFastIndexer);
            this.mListener = onScrollListener;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AlphabetFastIndexer alphabetFastIndexer = this.mIndexerRef.get();
            if (alphabetFastIndexer != null) {
                alphabetFastIndexer.refreshMask();
            }
            AbsListView.OnScrollListener onScrollListener = this.mListener;
            if (onScrollListener != null) {
                onScrollListener.onScroll(absListView, i, i2, i3);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            AlphabetFastIndexer alphabetFastIndexer = this.mIndexerRef.get();
            if (alphabetFastIndexer != null) {
                alphabetFastIndexer.mListScrollState = i;
            }
            AbsListView.OnScrollListener onScrollListener = this.mListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i);
            }
        }
    }

    public static class TextHilighter {
        int mActivatedColor;
        ValueAnimator mAnimator;
        BitmapDrawable mBackground;
        Bitmap mBmpBuffer;
        Canvas mCanvas;
        Xfermode mClearMode;
        Xfermode mDstInMode;
        int mHilightColor;
        String[] mIndexes;
        int mNormalColor;
        Rect mTextBoundIntersect;
        float mXCenter;
        float mYCenter;
        Paint mPaint = new Paint();
        Rect mTextBound = new Rect();
        Rect mSrcBounds = new Rect();

        public TextHilighter(Context context, TypedArray typedArray) {
            Resources resources = context.getResources();
            CharSequence[] textArray = typedArray.getTextArray(R.styleable.Passport_AlphabetFastIndexer_passport_indexerTable);
            if (textArray != null) {
                this.mIndexes = new String[textArray.length];
                int length = textArray.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    this.mIndexes[i2] = textArray[i].toString();
                    i++;
                    i2++;
                }
            } else {
                this.mIndexes = resources.getStringArray(R.array.passport_alphabet_table);
            }
            this.mNormalColor = typedArray.getColor(R.styleable.Passport_AlphabetFastIndexer_passport_indexerTextColor, resources.getColor(R.color.passport_alphabet_indexer_text_color));
            this.mActivatedColor = typedArray.getColor(R.styleable.Passport_AlphabetFastIndexer_passport_indexerTextActivatedColor, resources.getColor(R.color.passport_alphabet_indexer_activated_text_color));
            this.mHilightColor = typedArray.getColor(R.styleable.Passport_AlphabetFastIndexer_passport_indexerTextHighlightColor, resources.getColor(R.color.passport_alphabet_indexer_highlight_text_color));
            this.mPaint.setTextSize(typedArray.getDimension(R.styleable.Passport_AlphabetFastIndexer_passport_indexerTextSize, resources.getDimension(R.dimen.passport_alphabet_indexer_text_size)));
            this.mPaint.setAntiAlias(true);
            this.mPaint.setTextAlign(Paint.Align.CENTER);
            this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
            Drawable drawable2 = typedArray.getDrawable(R.styleable.Passport_AlphabetFastIndexer_passport_indexerTextHighlightBackground);
            drawable2 = drawable2 == null ? resources.getDrawable(R.drawable.passport_alphabet_indexer_text_highlight_bg) : drawable2;
            if (drawable2 != null && (drawable2 instanceof BitmapDrawable)) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable2;
                this.mBackground = bitmapDrawable;
                this.mBmpBuffer = bitmapDrawable.getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                this.mCanvas = new Canvas(this.mBmpBuffer);
                this.mTextBoundIntersect = new Rect();
                this.mClearMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
                this.mDstInMode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
            }
            update(0.0f, 0.0f);
        }

        public void beginDraw() {
            Paint paint = this.mPaint;
            Xfermode xfermode = paint.getXfermode();
            paint.setXfermode(this.mClearMode);
            this.mCanvas.drawPaint(paint);
            paint.setXfermode(xfermode);
            this.mBackground.setBounds(0, 0, this.mTextBound.width(), this.mTextBound.height());
            this.mBackground.draw(this.mCanvas);
            this.mTextBoundIntersect.set(this.mTextBound);
        }

        public void draw(Canvas canvas, boolean z, int i, float f, float f2) {
            Paint paint = this.mPaint;
            String str = TextUtils.equals(this.mIndexes[i], "!") ? AlphabetFastIndexer.STARRED_LABEL : this.mIndexes[i];
            paint.getTextBounds(str, 0, str.length(), this.mSrcBounds);
            float fWidth = this.mSrcBounds.width();
            float fHeight = this.mSrcBounds.height();
            paint.setColor(z ? this.mActivatedColor : this.mNormalColor);
            Rect rect = this.mSrcBounds;
            canvas.drawText(str, f, f2 - ((rect.top + rect.bottom) / 2.0f), paint);
            float f3 = fWidth / 2.0f;
            float f4 = fHeight / 2.0f;
            if (this.mTextBoundIntersect.intersect((int) (f - f3), (int) (f2 - f4), (int) (f3 + f), (int) (f4 + f2))) {
                Rect rect2 = this.mTextBound;
                float f5 = f - rect2.left;
                float f6 = f2 - rect2.top;
                paint.setColor(this.mHilightColor);
                Canvas canvas2 = this.mCanvas;
                Rect rect3 = this.mSrcBounds;
                canvas2.drawText(str, f5, f6 - ((rect3.top + rect3.bottom) / 2.0f), paint);
                this.mTextBoundIntersect.set(this.mTextBound);
            }
        }

        public void endDraw(Canvas canvas) {
            Paint paint = this.mBackground.getPaint();
            Xfermode xfermode = paint.getXfermode();
            paint.setXfermode(this.mDstInMode);
            this.mBackground.draw(this.mCanvas);
            paint.setXfermode(xfermode);
            canvas.drawBitmap(this.mBmpBuffer, (Rect) null, this.mTextBound, (Paint) null);
        }

        public void startSlidding(float f, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mTextBound == null ? f : (r0.top + r0.bottom) / 2.0f, f);
            this.mAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
            this.mAnimator.setDuration(200L);
            this.mAnimator.start();
        }

        public void update(float f, float f2) {
            this.mXCenter = f;
            this.mYCenter = f2;
            float intrinsicWidth = this.mBackground.getIntrinsicWidth() / 2.0f;
            float intrinsicHeight = this.mBackground.getIntrinsicHeight() / 2.0f;
            Rect rect = this.mTextBound;
            float f3 = this.mXCenter;
            float f4 = this.mYCenter;
            rect.set((int) ((f3 - intrinsicWidth) + 1.0f), (int) (f4 - intrinsicHeight), (int) (f3 + intrinsicWidth + 1.0f), (int) (f4 + intrinsicHeight));
        }
    }

    public AlphabetFastIndexer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void drawThumbInternal(CharSequence charSequence) {
        if (this.mListView == null) {
            return;
        }
        if (TextUtils.equals(charSequence, "!")) {
            charSequence = STARRED_LABEL;
        }
        this.mOverlay.setText(charSequence);
        if (getVisibility() == 0) {
            this.mOverlay.setVisibility(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), pt.f16197b);
        }
    }

    private int getListOffset() {
        AdapterView<?> adapterView = this.mListView;
        if (adapterView instanceof ListView) {
            return ((ListView) adapterView).getHeaderViewsCount();
        }
        return 0;
    }

    private int getPostion(float f, SectionIndexer sectionIndexer) {
        Object[] sections = sectionIndexer.getSections();
        if (sections == null) {
            return -1;
        }
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        if (height <= 0) {
            return -1;
        }
        float f2 = (f - paddingTop) / height;
        String[] strArr = this.mTextHilighter.mIndexes;
        int length = (int) (strArr.length * f2);
        if (length < 0) {
            return -1;
        }
        if (length >= strArr.length) {
            return sections.length;
        }
        int iBinarySearch = Arrays.binarySearch(sections, strArr[length]);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        if (iBinarySearch < 0) {
            return 0;
        }
        return iBinarySearch;
    }

    private SectionIndexer getSectionIndexer() {
        boolean z;
        AdapterView<?> adapterView = this.mListView;
        if (adapterView == null) {
            return null;
        }
        Object adapter = adapterView.getAdapter();
        while (true) {
            z = adapter instanceof SectionIndexer;
            if (z || !(adapter instanceof WrapperListAdapter)) {
                break;
            }
            adapter = ((WrapperListAdapter) adapter).getWrappedAdapter();
        }
        if (z) {
            return (SectionIndexer) adapter;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void refreshMask() {
        /*
            r3 = this;
            android.widget.AdapterView<?> r0 = r3.mListView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.SectionIndexer r0 = r3.getSectionIndexer()
            if (r0 == 0) goto L34
            android.widget.AdapterView<?> r1 = r3.mListView
            int r1 = r1.getFirstVisiblePosition()
            int r2 = r3.getListOffset()
            int r1 = r1 - r2
            int r1 = r0.getSectionForPosition(r1)
            r2 = -1
            if (r1 == r2) goto L34
            java.lang.Object[] r0 = r0.getSections()
            r0 = r0[r1]
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L34
            com.xiaomi.passport.ui.settings.AlphabetFastIndexer$TextHilighter r1 = r3.mTextHilighter
            java.lang.String[] r1 = r1.mIndexes
            int r0 = java.util.Arrays.binarySearch(r1, r0)
            goto L35
        L34:
            r0 = 0
        L35:
            int r1 = r3.mLastAlphabetIndex
            if (r1 == r0) goto L46
            r3.mLastAlphabetIndex = r0
            r1 = 1
            int r2 = r3.mState
            if (r1 == r2) goto L43
            r3.slidTextHilightBackground(r0)
        L43:
            r3.invalidate()
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.passport.ui.settings.AlphabetFastIndexer.refreshMask():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void scrollTo(android.widget.SectionIndexer r18, int r19) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.passport.ui.settings.AlphabetFastIndexer.scrollTo(android.widget.SectionIndexer, int):void");
    }

    private void slidTextHilightBackground(int i) {
        if (this.mTextHilighter == null) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        int paddingTop = getPaddingTop();
        float height = (getHeight() - paddingTop) - getPaddingBottom();
        float length = height / r2.mIndexes.length;
        this.mTextHilighter.startSlidding((i * length) + paddingTop + (length / 2.0f) + 1.0f, this.mTextHilightAnimListener);
    }

    public void attatch(AdapterView<?> adapterView) {
        if (this.mListView == adapterView) {
            return;
        }
        detach();
        if (adapterView == null) {
            return;
        }
        this.mLastAlphabetIndex = -1;
        this.mListView = adapterView;
        Context context = getContext();
        FrameLayout frameLayout = (FrameLayout) getParent();
        this.mOverlay = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        layoutParams.leftMargin = this.mOverlayLeftMargin;
        layoutParams.topMargin = this.mOverlayTopMargin;
        this.mOverlay.setLayoutParams(layoutParams);
        this.mOverlay.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mOverlay.setBackground(this.mOverlayBackground);
        this.mOverlay.setGravity(17);
        this.mOverlay.setTextSize(this.mOverlayTextSize);
        this.mOverlay.setTextColor(this.mOverlayTextColor);
        this.mOverlay.setVisibility(8);
        frameLayout.addView(this.mOverlay);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams2.gravity = this.mVerticalPosition | 48;
        setLayoutParams(layoutParams2);
        refreshMask();
    }

    public AbsListView.OnScrollListener decorateScrollListener(AbsListView.OnScrollListener onScrollListener) {
        return new OnScrollerDecorator(this, onScrollListener);
    }

    public void detach() {
        if (this.mListView != null) {
            stop(0);
            ((FrameLayout) getParent()).removeView(this.mOverlay);
            setVisibility(8);
            this.mListView = null;
        }
    }

    public void drawThumb(CharSequence charSequence) {
        if (this.mState == 0 && this.mListScrollState == 2) {
            drawThumbInternal(charSequence);
        }
    }

    public int getIndexerIntrinsicWidth() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicWidth();
        }
        return 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        if (height <= 0) {
            return;
        }
        String[] strArr = this.mTextHilighter.mIndexes;
        float length = height / strArr.length;
        float width = getWidth() / 2.0f;
        float f = paddingTop + (length / 2.0f);
        TextHilighter textHilighter = this.mTextHilighter;
        if (textHilighter.mXCenter == 0.0f || textHilighter.mYCenter == 0.0f) {
            textHilighter.update(width, f);
        }
        this.mTextHilighter.beginDraw();
        for (int i = 0; i < strArr.length; i++) {
            this.mTextHilighter.draw(canvas, isPressed(), i, width, f);
            f += length;
        }
        this.mTextHilighter.endDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mLastAlphabetIndex = -1;
        post(this.mRefreshMaskRunnable);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0025  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.widget.AdapterView<?> r0 = r5.mListView
            r1 = 0
            if (r0 != 0) goto L9
            r5.stop(r1)
            return r1
        L9:
            android.widget.SectionIndexer r0 = r5.getSectionIndexer()
            if (r0 != 0) goto L13
            r5.stop(r1)
            return r1
        L13:
            int r2 = r6.getAction()
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L30
            if (r2 == r4) goto L25
            if (r2 == r3) goto L35
            r6 = 3
            if (r2 == r6) goto L25
            goto L2a
        L25:
            int r6 = r5.mLastAlphabetIndex
            r5.slidTextHilightBackground(r6)
        L2a:
            r6 = 1500(0x5dc, float:2.102E-42)
            r5.stop(r6)
            goto L82
        L30:
            r5.mState = r4
            r5.setPressed(r4)
        L35:
            float r2 = r6.getY()
            int r2 = r5.getPostion(r2, r0)
            if (r2 >= 0) goto L45
            android.widget.AdapterView<?> r6 = r5.mListView
            r6.setSelection(r1)
            goto L82
        L45:
            r5.scrollTo(r0, r2)
            com.xiaomi.passport.ui.settings.AlphabetFastIndexer$TextHilighter r0 = r5.mTextHilighter
            if (r0 == 0) goto L82
            float r0 = r6.getY()
            int r1 = r5.getTop()
            int r2 = r5.getPaddingTop()
            int r1 = r1 + r2
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L82
            float r0 = r6.getY()
            int r1 = r5.getBottom()
            int r2 = r5.getPaddingBottom()
            int r1 = r1 - r2
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L82
            com.xiaomi.passport.ui.settings.AlphabetFastIndexer$TextHilighter r0 = r5.mTextHilighter
            int r1 = r5.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r6 = r6.getY()
            r0.update(r1, r6)
            r5.postInvalidate()
        L82:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.passport.ui.settings.AlphabetFastIndexer.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOverlayOffset(int i, int i2) {
        this.mOverlayLeftMargin = i;
        this.mOverlayTopMargin = i2;
    }

    public void setVerticalPosition(boolean z) {
        this.mVerticalPosition = z ? GravityCompat.END : GravityCompat.START;
    }

    public void stop(int i) {
        setPressed(false);
        this.mState = 0;
        postInvalidate();
        this.mHandler.removeMessages(1);
        if (i > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), i);
        } else {
            TextView textView = this.mOverlay;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    public AlphabetFastIndexer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextHilightAnimListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaomi.passport.ui.settings.AlphabetFastIndexer.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AlphabetFastIndexer.this.mTextHilighter.update(AlphabetFastIndexer.this.getWidth() / 2.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue());
                AlphabetFastIndexer.this.postInvalidate();
            }
        };
        this.mListScrollState = 0;
        this.mState = 0;
        this.mRefreshMaskRunnable = new Runnable() { // from class: com.xiaomi.passport.ui.settings.AlphabetFastIndexer.2
            @Override // java.lang.Runnable
            public void run() {
                AlphabetFastIndexer.this.refreshMask();
            }
        };
        this.mHandler = new Handler() { // from class: com.xiaomi.passport.ui.settings.AlphabetFastIndexer.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1 && AlphabetFastIndexer.this.mOverlay != null) {
                    AlphabetFastIndexer.this.mOverlay.setVisibility(8);
                }
            }
        };
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Passport_AlphabetFastIndexer, 0, attributeSet.getStyleAttribute() != 0 ? attributeSet.getStyleAttribute() : i);
        this.mTextHilighter = new TextHilighter(context, typedArrayObtainStyledAttributes);
        this.mOverlayLeftMargin = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Passport_AlphabetFastIndexer_passport_overlayMarginLeft, resources.getDimensionPixelOffset(R.dimen.passport_alphabet_indexer_overlay_offset));
        this.mOverlayTopMargin = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.Passport_AlphabetFastIndexer_passport_overlayMarginTop, resources.getDimensionPixelOffset(R.dimen.passport_alphabet_indexer_overlay_padding_top));
        this.mOverlayTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Passport_AlphabetFastIndexer_passport_overlayTextSize, resources.getDimensionPixelSize(R.dimen.passport_alphabet_indexer_overlay_text_size));
        this.mOverlayTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.Passport_AlphabetFastIndexer_passport_overlayTextColor, resources.getColor(R.color.passport_alphabet_indexer_overlay_text_color));
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.Passport_AlphabetFastIndexer_passport_overlayBackground);
        this.mOverlayBackground = drawable2;
        if (drawable2 == null) {
            this.mOverlayBackground = resources.getDrawable(R.drawable.passport_alphabet_indexer_overlay);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.Passport_AlphabetFastIndexer_passport_indexerBackground);
        setBackground(drawable3 == null ? resources.getDrawable(R.drawable.passport_alphabet_indexer_bg) : drawable3);
        typedArrayObtainStyledAttributes.recycle();
        this.mVerticalPosition = GravityCompat.END;
    }
}
