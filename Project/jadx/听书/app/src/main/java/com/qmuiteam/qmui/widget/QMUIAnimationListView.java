package com.qmuiteam.qmui.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.QMUILog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIAnimationListView extends ListView {
    private static final float DEFAULT_OFFSET_DURATION_UNIT = 0.5f;
    private static final long DURATION_ALPHA = 300;
    private static final long DURATION_OFFSET_MAX = 1000;
    private static final long DURATION_OFFSET_MIN = 0;
    private static final String TAG = "QMUIAnimationListView";
    protected final Set<Long> mAfterVisible;
    private int mAnimationManipulateDurationLimit;
    protected final Set<Long> mBeforeVisible;
    private ValueAnimator mChangeDisappearAnimator;
    private long mChangeDisappearPlayTime;
    protected final LongSparseArray<View> mDetachViewsMap;
    private boolean mIsAnimating;
    private long mLastManipulateTime;
    private float mOffsetDurationUnit;
    private Interpolator mOffsetInterpolator;
    private boolean mOpenChangeDisappearAnimation;
    private final List<Manipulator> mPendingManipulations;
    private final List<Manipulator> mPendingManipulationsWithoutAnimation;
    protected final LongSparseArray<Integer> mPositionMap;
    private ListAdapter mRealAdapter;
    protected final LongSparseArray<Integer> mTopMap;
    private WrapperAdapter mWrapperAdapter;

    public interface Manipulator<T extends ListAdapter> {
        void manipulate(T t);
    }

    public QMUIAnimationListView(Context context) {
        this(context, null);
    }

    public QMUIAnimationListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTopMap = new LongSparseArray<>();
        this.mPositionMap = new LongSparseArray<>();
        this.mDetachViewsMap = new LongSparseArray<>();
        this.mBeforeVisible = new HashSet();
        this.mAfterVisible = new HashSet();
        this.mPendingManipulations = new ArrayList();
        this.mPendingManipulationsWithoutAnimation = new ArrayList();
        this.mChangeDisappearPlayTime = 0L;
        this.mIsAnimating = false;
        this.mAnimationManipulateDurationLimit = 0;
        this.mLastManipulateTime = 0L;
        this.mOffsetDurationUnit = 0.5f;
        this.mOffsetInterpolator = new LinearInterpolator();
        this.mOpenChangeDisappearAnimation = false;
        init();
    }

    public QMUIAnimationListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTopMap = new LongSparseArray<>();
        this.mPositionMap = new LongSparseArray<>();
        this.mDetachViewsMap = new LongSparseArray<>();
        this.mBeforeVisible = new HashSet();
        this.mAfterVisible = new HashSet();
        this.mPendingManipulations = new ArrayList();
        this.mPendingManipulationsWithoutAnimation = new ArrayList();
        this.mChangeDisappearPlayTime = 0L;
        this.mIsAnimating = false;
        this.mAnimationManipulateDurationLimit = 0;
        this.mLastManipulateTime = 0L;
        this.mOffsetDurationUnit = 0.5f;
        this.mOffsetInterpolator = new LinearInterpolator();
        this.mOpenChangeDisappearAnimation = false;
        init();
    }

    public QMUIAnimationListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mTopMap = new LongSparseArray<>();
        this.mPositionMap = new LongSparseArray<>();
        this.mDetachViewsMap = new LongSparseArray<>();
        this.mBeforeVisible = new HashSet();
        this.mAfterVisible = new HashSet();
        this.mPendingManipulations = new ArrayList();
        this.mPendingManipulationsWithoutAnimation = new ArrayList();
        this.mChangeDisappearPlayTime = 0L;
        this.mIsAnimating = false;
        this.mAnimationManipulateDurationLimit = 0;
        this.mLastManipulateTime = 0L;
        this.mOffsetDurationUnit = 0.5f;
        this.mOffsetInterpolator = new LinearInterpolator();
        this.mOpenChangeDisappearAnimation = false;
        init();
    }

    private void init() {
        setWillNotDraw(false);
    }

    public ListAdapter getRealAdapter() {
        return this.mRealAdapter;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        this.mRealAdapter = listAdapter;
        WrapperAdapter wrapperAdapter = listAdapter != null ? new WrapperAdapter(this.mRealAdapter) : null;
        this.mWrapperAdapter = wrapperAdapter;
        super.setAdapter((ListAdapter) wrapperAdapter);
    }

    public void setAnimationManipulateDurationLimit(int i) {
        this.mAnimationManipulateDurationLimit = i;
    }

    public <T extends ListAdapter> void manipulate(Manipulator<T> manipulator) {
        Log.i(TAG, "manipulate");
        if (!this.mWrapperAdapter.isAnimationEnabled()) {
            manipulateWithoutAnimation(manipulator);
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean z = jUptimeMillis - this.mLastManipulateTime > ((long) this.mAnimationManipulateDurationLimit);
        this.mLastManipulateTime = jUptimeMillis;
        if (this.mIsAnimating) {
            if (z) {
                this.mPendingManipulations.add(manipulator);
                return;
            } else {
                this.mPendingManipulationsWithoutAnimation.add(manipulator);
                return;
            }
        }
        if (z) {
            this.mIsAnimating = true;
            prepareAnimation();
            manipulator.manipulate(this.mRealAdapter);
            doAnimation();
            return;
        }
        manipulator.manipulate(this.mRealAdapter);
        this.mWrapperAdapter.notifyDataSetChanged();
    }

    public <T extends ListAdapter> void manipulateWithoutAnimation(Manipulator<T> manipulator) {
        Log.i(TAG, "manipulateWithoutAnimation");
        if (!this.mIsAnimating) {
            manipulator.manipulate(this.mRealAdapter);
            this.mWrapperAdapter.notifyDataSetChanged();
        } else {
            this.mPendingManipulationsWithoutAnimation.add(manipulator);
        }
    }

    public float getOffsetDurationUnit() {
        return this.mOffsetDurationUnit;
    }

    public void setOffsetDurationUnit(float f) {
        this.mOffsetDurationUnit = f;
    }

    private long getOffsetDuration(int i, int i2) {
        return Math.max(0L, Math.min((long) (Math.abs(i - i2) * this.mOffsetDurationUnit), 1000L));
    }

    public void setOpenChangeDisappearAnimation(boolean z) {
        this.mOpenChangeDisappearAnimation = z;
    }

    public void setOffsetInterpolator(Interpolator interpolator) {
        this.mOffsetInterpolator = interpolator;
    }

    private void prepareAnimation() {
        this.mTopMap.clear();
        this.mPositionMap.clear();
        this.mBeforeVisible.clear();
        this.mAfterVisible.clear();
        this.mDetachViewsMap.clear();
        this.mWrapperAdapter.setShouldNotifyChange(false);
        int childCount = getChildCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            long itemId = this.mWrapperAdapter.getItemId(firstVisiblePosition + i);
            this.mTopMap.put(itemId, Integer.valueOf(childAt.getTop()));
            this.mPositionMap.put(itemId, Integer.valueOf(i));
        }
        for (int i2 = 0; i2 < firstVisiblePosition; i2++) {
            this.mBeforeVisible.add(Long.valueOf(this.mWrapperAdapter.getItemId(i2)));
        }
        int count = this.mWrapperAdapter.getCount();
        for (int i3 = firstVisiblePosition + childCount; i3 < count; i3++) {
            this.mAfterVisible.add(Long.valueOf(this.mWrapperAdapter.getItemId(i3)));
        }
    }

    private void doAnimation() {
        setEnabled(false);
        setClickable(false);
        doPreLayoutAnimation(new ManipulateAnimatorListener() { // from class: com.qmuiteam.qmui.widget.QMUIAnimationListView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QMUIAnimationListView.this.mWrapperAdapter.notifyDataSetChanged();
                QMUIAnimationListView.this.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.qmuiteam.qmui.widget.QMUIAnimationListView.1.1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        QMUIAnimationListView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                        QMUIAnimationListView.this.doPostLayoutAnimation();
                        return true;
                    }
                });
            }
        });
    }

    private void doPreLayoutAnimation(Animator.AnimatorListener animatorListener) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mTopMap.size(); i++) {
            long jKeyAt = this.mTopMap.keyAt(i);
            if (getPositionForId(jKeyAt) < 0) {
                Animator deleteAnimator = getDeleteAnimator(getChildAt(this.mPositionMap.get(jKeyAt).intValue()));
                this.mPositionMap.remove(jKeyAt);
                animatorSet.play(deleteAnimator);
                arrayList.add(Long.valueOf(jKeyAt));
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.mTopMap.remove(((Long) arrayList.get(i2)).longValue());
        }
        if (this.mOpenChangeDisappearAnimation) {
            for (int i3 = 0; i3 < this.mPositionMap.size(); i3++) {
                View childAt = getChildAt(this.mPositionMap.valueAt(i3).intValue());
                ViewCompat.setHasTransientState(childAt, true);
                this.mDetachViewsMap.put(this.mPositionMap.keyAt(i3), childAt);
            }
        }
        if (!animatorSet.getChildAnimations().isEmpty()) {
            animatorSet.addListener(animatorListener);
            animatorSet.start();
        } else {
            animatorListener.onAnimationEnd(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ae A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doPostLayoutAnimation() {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qmuiteam.qmui.widget.QMUIAnimationListView.doPostLayoutAnimation():void");
    }

    protected long getChangeDisappearDuration() {
        return (long) (getHeight() * this.mOffsetDurationUnit);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006f A[PHI: r2
  0x006f: PHI (r2v8 int) = (r2v7 int), (r2v17 int) binds: [B:21:0x006c, B:18:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            super.onDraw(r9)
            boolean r0 = r8.mOpenChangeDisappearAnimation
            if (r0 == 0) goto L95
            android.animation.ValueAnimator r0 = r8.mChangeDisappearAnimator
            if (r0 == 0) goto L95
            boolean r0 = r0.isStarted()
            if (r0 == 0) goto L95
            androidx.collection.LongSparseArray<android.view.View> r0 = r8.mDetachViewsMap
            int r0 = r0.size()
            if (r0 <= 0) goto L95
            boolean r0 = r8.mIsAnimating
            if (r0 == 0) goto L95
            r0 = 0
            r1 = r0
        L1f:
            androidx.collection.LongSparseArray<android.view.View> r2 = r8.mDetachViewsMap
            int r2 = r2.size()
            if (r1 >= r2) goto L95
            androidx.collection.LongSparseArray<android.view.View> r2 = r8.mDetachViewsMap
            long r2 = r2.keyAt(r1)
            androidx.collection.LongSparseArray<android.view.View> r4 = r8.mDetachViewsMap
            java.lang.Object r4 = r4.valueAt(r1)
            android.view.View r4 = (android.view.View) r4
            int r5 = r8.getPositionForId(r2)
            long r6 = r8.mChangeDisappearPlayTime
            float r6 = (float) r6
            float r7 = r8.mOffsetDurationUnit
            float r6 = r6 / r7
            int r6 = (int) r6
            int r7 = r8.getFirstVisiblePosition()
            if (r5 >= r7) goto L5b
            androidx.collection.LongSparseArray<java.lang.Integer> r5 = r8.mTopMap
            java.lang.Object r2 = r5.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r2 = r2 - r6
            int r3 = r4.getHeight()
            int r3 = -r3
            if (r2 >= r3) goto L6f
            goto L92
        L5b:
            androidx.collection.LongSparseArray<java.lang.Integer> r5 = r8.mTopMap
            java.lang.Object r2 = r5.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r2 = r2 + r6
            int r3 = r8.getHeight()
            if (r2 <= r3) goto L6f
            goto L92
        L6f:
            int r3 = r4.getWidth()
            int r5 = r4.getHeight()
            int r5 = r5 + r2
            r4.layout(r0, r2, r3, r5)
            long r2 = r8.mChangeDisappearPlayTime
            float r2 = (float) r2
            r3 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 * r3
            long r5 = r8.getChangeDisappearDuration()
            float r5 = (float) r5
            float r2 = r2 / r5
            float r3 = r3 - r2
            r4.setAlpha(r3)
            long r2 = r8.getDrawingTime()
            r8.drawChild(r9, r4, r2)
        L92:
            int r1 = r1 + 1
            goto L1f
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qmuiteam.qmui.widget.QMUIAnimationListView.onDraw(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishAnimation() {
        this.mWrapperAdapter.setShouldNotifyChange(true);
        this.mChangeDisappearAnimator = null;
        if (this.mOpenChangeDisappearAnimation) {
            for (int i = 0; i < this.mDetachViewsMap.size(); i++) {
                this.mDetachViewsMap.valueAt(i).setAlpha(1.0f);
            }
            this.mDetachViewsMap.clear();
        }
        this.mIsAnimating = false;
        setEnabled(true);
        setClickable(true);
        manipulatePending();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manipulatePending() {
        if (!this.mPendingManipulationsWithoutAnimation.isEmpty()) {
            this.mIsAnimating = true;
            Iterator<Manipulator> it = this.mPendingManipulationsWithoutAnimation.iterator();
            while (it.hasNext()) {
                it.next().manipulate(this.mRealAdapter);
            }
            this.mPendingManipulationsWithoutAnimation.clear();
            this.mWrapperAdapter.notifyDataSetChanged();
            post(new Runnable() { // from class: com.qmuiteam.qmui.widget.QMUIAnimationListView.5
                @Override // java.lang.Runnable
                public void run() {
                    QMUIAnimationListView.this.mIsAnimating = false;
                    QMUIAnimationListView.this.manipulatePending();
                }
            });
            return;
        }
        if (this.mPendingManipulations.isEmpty()) {
            return;
        }
        this.mIsAnimating = true;
        prepareAnimation();
        Iterator<Manipulator> it2 = this.mPendingManipulations.iterator();
        while (it2.hasNext()) {
            it2.next().manipulate(this.mRealAdapter);
        }
        this.mPendingManipulations.clear();
        doAnimation();
    }

    protected Animator getDeleteAnimator(View view) {
        return alphaObjectAnimator(view, false, DURATION_ALPHA, true);
    }

    protected Animator getOffsetAnimator(View view, int i, int i2) {
        return getOffsetAnimator(view, i, i2, getOffsetDuration(i, i2));
    }

    protected Animator getOffsetAnimator(View view, int i, int i2, long j) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", i - i2, 0.0f);
        objectAnimatorOfFloat.setDuration(j);
        objectAnimatorOfFloat.setInterpolator(this.mOffsetInterpolator);
        return objectAnimatorOfFloat;
    }

    protected Animator getAddAnimator(View view, int i, int i2, int i3, int i4) {
        view.setAlpha(0.0f);
        view.clearAnimation();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alphaObjectAnimator(view, true, 50L, false));
        if (i3 != i) {
            animatorSet.play(getOffsetAnimator(view, i3, i));
        }
        animatorSet.setStartDelay((long) (view.getHeight() * this.mOffsetDurationUnit));
        return animatorSet;
    }

    protected ObjectAnimator alphaObjectAnimator(View view, final boolean z, long j, boolean z2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", z ? new float[]{0.0f, 1.0f} : new float[]{1.0f, 0.0f});
        objectAnimatorOfFloat.setDuration(j);
        if (z2) {
            final WeakReference weakReference = new WeakReference(view);
            objectAnimatorOfFloat.addListener(new ManipulateAnimatorListener() { // from class: com.qmuiteam.qmui.widget.QMUIAnimationListView.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (weakReference.get() != null) {
                        ((View) weakReference.get()).setAlpha(z ? 0.0f : 1.0f);
                    }
                }
            });
        }
        return objectAnimatorOfFloat;
    }

    protected int getPositionForId(long j) {
        for (int i = 0; i < this.mWrapperAdapter.getCount(); i++) {
            if (this.mWrapperAdapter.getItemId(i) == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return isEnabled() && super.dispatchTouchEvent(motionEvent);
    }

    private static class WrapperAdapter extends BaseAdapter {
        private ListAdapter mAdapter;
        private boolean mIsAnimationEnabled;
        private final DataSetObserver mObserver;
        private boolean mShouldNotifyChange = true;

        public WrapperAdapter(ListAdapter listAdapter) {
            DataSetObserver dataSetObserver = new DataSetObserver() { // from class: com.qmuiteam.qmui.widget.QMUIAnimationListView.WrapperAdapter.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    if (WrapperAdapter.this.mShouldNotifyChange) {
                        WrapperAdapter.this.notifyDataSetChanged();
                    }
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    WrapperAdapter.this.notifyDataSetInvalidated();
                }
            };
            this.mObserver = dataSetObserver;
            this.mIsAnimationEnabled = false;
            this.mAdapter = listAdapter;
            listAdapter.registerDataSetObserver(dataSetObserver);
        }

        public void setShouldNotifyChange(boolean z) {
            this.mShouldNotifyChange = z;
        }

        public boolean isAnimationEnabled() {
            return this.mIsAnimationEnabled;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                QMUILog.d(QMUIAnimationListView.TAG, "notifyDataSetChanged not in main Thread", new Object[0]);
            } else {
                super.notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mAdapter.getCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return this.mAdapter.getItemViewType(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.mAdapter.getViewTypeCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.mAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.mAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return this.mAdapter.getView(i, view, viewGroup);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            boolean zHasStableIds = this.mAdapter.hasStableIds();
            this.mIsAnimationEnabled = zHasStableIds;
            return zHasStableIds;
        }
    }

    private abstract class ManipulateAnimatorListener implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        private ManipulateAnimatorListener() {
        }
    }
}
