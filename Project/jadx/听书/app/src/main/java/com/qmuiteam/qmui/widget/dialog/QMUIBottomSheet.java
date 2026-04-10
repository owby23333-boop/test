package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIPriorityLinearLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetGridLineLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetListAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class QMUIBottomSheet extends QMUIBaseDialog {
    private static final String TAG = "QMUIBottomSheet";
    private boolean mAnimateToCancel;
    private boolean mAnimateToDismiss;
    private QMUIBottomSheetBehavior<QMUIBottomSheetRootLayout> mBehavior;
    private OnBottomSheetShowListener mOnBottomSheetShowListener;
    private QMUIBottomSheetRootLayout mRootView;

    /* JADX INFO: loaded from: classes4.dex */
    public interface OnBottomSheetShowListener {
        void onShow();
    }

    public QMUIBottomSheet(Context context) {
        this(context, R.style.QMUI_BottomSheet);
    }

    public QMUIBottomSheet(Context context, int i) {
        super(context, i);
        this.mAnimateToCancel = false;
        this.mAnimateToDismiss = false;
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.qmui_bottom_sheet_dialog, (ViewGroup) null);
        this.mRootView = (QMUIBottomSheetRootLayout) viewGroup.findViewById(R.id.bottom_sheet);
        QMUIBottomSheetBehavior<QMUIBottomSheetRootLayout> qMUIBottomSheetBehavior = new QMUIBottomSheetBehavior<>();
        this.mBehavior = qMUIBottomSheetBehavior;
        qMUIBottomSheetBehavior.setHideable(this.cancelable);
        this.mBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet.1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View view, float f) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View view, int i2) {
                if (i2 == 5) {
                    if (!QMUIBottomSheet.this.mAnimateToCancel) {
                        if (QMUIBottomSheet.this.mAnimateToDismiss) {
                            QMUIBottomSheet.this.dismiss();
                            return;
                        } else {
                            QMUIBottomSheet.this.cancel();
                            return;
                        }
                    }
                    QMUIBottomSheet.this.cancel();
                }
            }
        });
        this.mBehavior.setPeekHeight(0);
        this.mBehavior.setAllowDrag(false);
        this.mBehavior.setSkipCollapsed(true);
        ((CoordinatorLayout.LayoutParams) this.mRootView.getLayoutParams()).setBehavior(this.mBehavior);
        viewGroup.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QMUIBottomSheet.this.mBehavior.getState() != 2 && QMUIBottomSheet.this.cancelable && QMUIBottomSheet.this.isShowing() && QMUIBottomSheet.this.shouldWindowCloseOnTouchOutside()) {
                    QMUIBottomSheet.this.cancel();
                }
            }
        });
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        super.setContentView(viewGroup, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.qmuiteam.qmui.widget.dialog.QMUIBaseDialog
    protected void onSetCancelable(boolean z) {
        super.onSetCancelable(z);
        this.mBehavior.setHideable(z);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
        ViewCompat.requestApplyInsets(this.mRootView);
    }

    @Override // com.qmuiteam.qmui.widget.dialog.QMUIBaseDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        if (this.mBehavior.getState() == 5) {
            this.mBehavior.setState(4);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.mBehavior.getState() == 5) {
            this.mAnimateToCancel = false;
            super.cancel();
        } else {
            this.mAnimateToCancel = true;
            this.mBehavior.setState(5);
        }
    }

    @Override // com.qmuiteam.qmui.widget.dialog.QMUIBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.mBehavior.getState() == 5) {
            this.mAnimateToDismiss = false;
            super.dismiss();
        } else {
            this.mAnimateToDismiss = true;
            this.mBehavior.setState(5);
        }
    }

    public void setOnBottomSheetShowListener(OnBottomSheetShowListener onBottomSheetShowListener) {
        this.mOnBottomSheetShowListener = onBottomSheetShowListener;
    }

    public void setRadius(int i) {
        this.mRootView.setRadius(i, 3);
    }

    public QMUIBottomSheetRootLayout getRootView() {
        return this.mRootView;
    }

    public QMUIBottomSheetBehavior<QMUIBottomSheetRootLayout> getBehavior() {
        return this.mBehavior;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        OnBottomSheetShowListener onBottomSheetShowListener = this.mOnBottomSheetShowListener;
        if (onBottomSheetShowListener != null) {
            onBottomSheetShowListener.onShow();
        }
        if (this.mBehavior.getState() != 3) {
            setToExpandWhenShow();
        }
        this.mAnimateToCancel = false;
        this.mAnimateToDismiss = false;
    }

    protected void setToExpandWhenShow() {
        this.mRootView.postOnAnimation(new Runnable() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet.4
            @Override // java.lang.Runnable
            public void run() {
                QMUIBottomSheet.this.mBehavior.setState(3);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        throw new IllegalStateException("Use addContentView(View, ConstraintLayout.LayoutParams) for replacement");
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int i) {
        throw new IllegalStateException("Use addContentView(int) for replacement");
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalStateException("Use addContentView(View, QMUIPriorityLinearLayout.LayoutParams) for replacement");
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalStateException("Use addContentView(View, QMUIPriorityLinearLayout.LayoutParams) for replacement");
    }

    public void addContentView(View view, QMUIPriorityLinearLayout.LayoutParams layoutParams) {
        this.mRootView.addView(view, layoutParams);
    }

    public void addContentView(View view) {
        QMUIPriorityLinearLayout.LayoutParams layoutParams = new QMUIPriorityLinearLayout.LayoutParams(-1, -2);
        layoutParams.setPriority(1);
        this.mRootView.addView(view, layoutParams);
    }

    public void addContentView(int i) {
        LayoutInflater.from(this.mRootView.getContext()).inflate(i, (ViewGroup) this.mRootView, true);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class BottomListSheetBuilder extends QMUIBottomSheetBaseBuilder<BottomListSheetBuilder> {
        private int mCheckedIndex;
        private List<View> mContentFooterViews;
        private List<View> mContentHeaderViews;
        private boolean mGravityCenter;
        private List<QMUIBottomSheetListItemModel> mItems;
        private boolean mNeedRightMark;
        private OnSheetItemClickListener mOnSheetItemClickListener;

        public interface OnSheetItemClickListener {
            void onClick(QMUIBottomSheet qMUIBottomSheet, View view, int i, String str);
        }

        public BottomListSheetBuilder(Context context) {
            this(context, false);
        }

        public BottomListSheetBuilder(Context context, boolean z) {
            super(context);
            this.mGravityCenter = false;
            this.mItems = new ArrayList();
            this.mNeedRightMark = z;
        }

        public BottomListSheetBuilder setCheckedIndex(int i) {
            this.mCheckedIndex = i;
            return this;
        }

        public BottomListSheetBuilder setNeedRightMark(boolean z) {
            this.mNeedRightMark = z;
            return this;
        }

        public BottomListSheetBuilder setGravityCenter(boolean z) {
            this.mGravityCenter = z;
            return this;
        }

        public BottomListSheetBuilder setOnSheetItemClickListener(OnSheetItemClickListener onSheetItemClickListener) {
            this.mOnSheetItemClickListener = onSheetItemClickListener;
            return this;
        }

        public BottomListSheetBuilder addItem(QMUIBottomSheetListItemModel qMUIBottomSheetListItemModel) {
            this.mItems.add(qMUIBottomSheetListItemModel);
            return this;
        }

        public BottomListSheetBuilder addItem(String str) {
            this.mItems.add(new QMUIBottomSheetListItemModel(str, str));
            return this;
        }

        public BottomListSheetBuilder addItem(Drawable drawable, String str) {
            this.mItems.add(new QMUIBottomSheetListItemModel(str, str).image(drawable));
            return this;
        }

        public BottomListSheetBuilder addItem(String str, String str2) {
            this.mItems.add(new QMUIBottomSheetListItemModel(str, str2));
            return this;
        }

        public BottomListSheetBuilder addItem(int i, String str, String str2) {
            this.mItems.add(new QMUIBottomSheetListItemModel(str, str2).image(i));
            return this;
        }

        public BottomListSheetBuilder addItem(int i, String str, String str2, boolean z) {
            this.mItems.add(new QMUIBottomSheetListItemModel(str, str2).image(i).redPoint(z));
            return this;
        }

        public BottomListSheetBuilder addItem(int i, CharSequence charSequence, String str, boolean z, boolean z2) {
            this.mItems.add(new QMUIBottomSheetListItemModel(charSequence, str).image(i).redPoint(z).disabled(z2));
            return this;
        }

        @Deprecated
        public BottomListSheetBuilder addHeaderView(View view) {
            return addContentHeaderView(view);
        }

        public BottomListSheetBuilder addContentHeaderView(View view) {
            if (this.mContentHeaderViews == null) {
                this.mContentHeaderViews = new ArrayList();
            }
            this.mContentHeaderViews.add(view);
            return this;
        }

        public BottomListSheetBuilder addContentFooterView(View view) {
            if (this.mContentFooterViews == null) {
                this.mContentFooterViews = new ArrayList();
            }
            this.mContentFooterViews.add(view);
            return this;
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetBaseBuilder
        protected View onCreateContentView(final QMUIBottomSheet qMUIBottomSheet, QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, Context context) {
            LinearLayout linearLayout;
            RecyclerView recyclerView = new RecyclerView(context);
            recyclerView.setOverScrollMode(2);
            QMUIBottomSheetListAdapter qMUIBottomSheetListAdapter = new QMUIBottomSheetListAdapter(this.mNeedRightMark, this.mGravityCenter);
            recyclerView.setAdapter(qMUIBottomSheetListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(context) { // from class: com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder.1
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                    return new RecyclerView.LayoutParams(-1, -2);
                }
            });
            recyclerView.addItemDecoration(new QMUIBottomSheetListItemDecoration(context));
            List<View> list = this.mContentHeaderViews;
            LinearLayout linearLayout2 = null;
            if (list == null || list.size() <= 0) {
                linearLayout = null;
            } else {
                linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                for (View view : this.mContentHeaderViews) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    linearLayout.addView(view, new LinearLayout.LayoutParams(-1, -2));
                }
            }
            List<View> list2 = this.mContentFooterViews;
            if (list2 != null && list2.size() > 0) {
                linearLayout2 = new LinearLayout(context);
                linearLayout2.setOrientation(1);
                for (View view2 : this.mContentFooterViews) {
                    if (view2.getParent() != null) {
                        ((ViewGroup) view2.getParent()).removeView(view2);
                    }
                    linearLayout2.addView(view2, new LinearLayout.LayoutParams(-1, -2));
                }
            }
            qMUIBottomSheetListAdapter.setData(linearLayout, linearLayout2, this.mItems);
            qMUIBottomSheetListAdapter.setOnItemClickListener(new QMUIBottomSheetListAdapter.OnItemClickListener() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder.2
                @Override // com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetListAdapter.OnItemClickListener
                public void onClick(QMUIBottomSheetListAdapter.VH vh, int i, QMUIBottomSheetListItemModel qMUIBottomSheetListItemModel) {
                    if (BottomListSheetBuilder.this.mOnSheetItemClickListener != null) {
                        BottomListSheetBuilder.this.mOnSheetItemClickListener.onClick(qMUIBottomSheet, vh.itemView, i, qMUIBottomSheetListItemModel.tag);
                    }
                }
            });
            qMUIBottomSheetListAdapter.setCheckedIndex(this.mCheckedIndex);
            recyclerView.scrollToPosition(this.mCheckedIndex + (linearLayout == null ? 0 : 1));
            return recyclerView;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class BottomGridSheetBuilder extends QMUIBottomSheetBaseBuilder<BottomGridSheetBuilder> implements View.OnClickListener {
        public static final ItemViewFactory DEFAULT_ITEM_VIEW_FACTORY = new DefaultItemViewFactory();
        public static final int FIRST_LINE = 0;
        public static final int SECOND_LINE = 1;
        private ArrayList<QMUIBottomSheetGridItemModel> mFirstLineItems;
        private ItemViewFactory mItemViewFactory;
        private QMUIBottomSheetGridLineLayout.ItemWidthCalculator mItemWidthCalculator;
        private OnSheetItemClickListener mOnSheetItemClickListener;
        private ArrayList<QMUIBottomSheetGridItemModel> mSecondLineItems;

        public interface ItemViewFactory {
            QMUIBottomSheetGridItemView create(QMUIBottomSheet qMUIBottomSheet, QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel);
        }

        public interface OnSheetItemClickListener {
            void onClick(QMUIBottomSheet qMUIBottomSheet, View view);
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface Style {
        }

        public static class DefaultItemViewFactory implements ItemViewFactory {
            @Override // com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder.ItemViewFactory
            public QMUIBottomSheetGridItemView create(QMUIBottomSheet qMUIBottomSheet, QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel) {
                QMUIBottomSheetGridItemView qMUIBottomSheetGridItemView = new QMUIBottomSheetGridItemView(qMUIBottomSheet.getContext());
                qMUIBottomSheetGridItemView.render(qMUIBottomSheetGridItemModel);
                return qMUIBottomSheetGridItemView;
            }
        }

        public BottomGridSheetBuilder(Context context) {
            super(context);
            this.mItemViewFactory = DEFAULT_ITEM_VIEW_FACTORY;
            this.mItemWidthCalculator = null;
            this.mFirstLineItems = new ArrayList<>();
            this.mSecondLineItems = new ArrayList<>();
        }

        public BottomGridSheetBuilder addItem(QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel, int i) {
            if (i == 0) {
                this.mFirstLineItems.add(qMUIBottomSheetGridItemModel);
            } else if (i == 1) {
                this.mSecondLineItems.add(qMUIBottomSheetGridItemModel);
            }
            return this;
        }

        public BottomGridSheetBuilder addItem(int i, CharSequence charSequence, int i2) {
            return addItem(i, charSequence, charSequence, i2, 0);
        }

        public BottomGridSheetBuilder addItem(int i, CharSequence charSequence, Object obj, int i2) {
            return addItem(i, charSequence, obj, i2, 0);
        }

        public BottomGridSheetBuilder addItem(int i, CharSequence charSequence, Object obj, int i2, int i3) {
            return addItem(i, charSequence, obj, i2, i3, null);
        }

        public BottomGridSheetBuilder addItem(int i, CharSequence charSequence, Object obj, int i2, int i3, Typeface typeface) {
            return addItem(new QMUIBottomSheetGridItemModel(charSequence, obj).image(i).subscript(i3).typeface(typeface), i2);
        }

        public void setItemViewFactory(ItemViewFactory itemViewFactory) {
            this.mItemViewFactory = itemViewFactory;
        }

        public BottomGridSheetBuilder setOnSheetItemClickListener(OnSheetItemClickListener onSheetItemClickListener) {
            this.mOnSheetItemClickListener = onSheetItemClickListener;
            return this;
        }

        public BottomGridSheetBuilder setItemWidthCalculator(QMUIBottomSheetGridLineLayout.ItemWidthCalculator itemWidthCalculator) {
            this.mItemWidthCalculator = itemWidthCalculator;
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnSheetItemClickListener onSheetItemClickListener = this.mOnSheetItemClickListener;
            if (onSheetItemClickListener != null) {
                onSheetItemClickListener.onClick(this.mDialog, view);
            }
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetBaseBuilder
        protected View onCreateContentView(QMUIBottomSheet qMUIBottomSheet, QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, Context context) {
            ArrayList arrayList;
            ArrayList arrayList2 = null;
            if (this.mFirstLineItems.isEmpty() && this.mSecondLineItems.isEmpty()) {
                return null;
            }
            if (this.mFirstLineItems.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                Iterator<QMUIBottomSheetGridItemModel> it = this.mFirstLineItems.iterator();
                while (it.hasNext()) {
                    QMUIBottomSheetGridItemView qMUIBottomSheetGridItemViewCreate = this.mItemViewFactory.create(qMUIBottomSheet, it.next());
                    qMUIBottomSheetGridItemViewCreate.setOnClickListener(this);
                    arrayList.add(new Pair(qMUIBottomSheetGridItemViewCreate, new LinearLayout.LayoutParams(-2, -2)));
                }
            }
            if (!this.mSecondLineItems.isEmpty()) {
                arrayList2 = new ArrayList();
                Iterator<QMUIBottomSheetGridItemModel> it2 = this.mSecondLineItems.iterator();
                while (it2.hasNext()) {
                    QMUIBottomSheetGridItemView qMUIBottomSheetGridItemViewCreate2 = this.mItemViewFactory.create(qMUIBottomSheet, it2.next());
                    qMUIBottomSheetGridItemViewCreate2.setOnClickListener(this);
                    arrayList2.add(new Pair(qMUIBottomSheetGridItemViewCreate2, new LinearLayout.LayoutParams(-2, -2)));
                }
            }
            return new QMUIBottomSheetGridLineLayout(this.mDialog, this.mItemWidthCalculator, arrayList, arrayList2);
        }
    }
}
