package com.qmuiteam.qmui.widget.popup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIQuickAction extends QMUINormalPopup<QMUIQuickAction> {
    private int mActionHeight;
    private int mActionWidth;
    private ArrayList<Action> mActions;
    private int mMoreArrowWidth;
    private int mPaddingHor;
    private boolean mShowMoreArrowIfNeeded;

    public interface OnClickListener {
        void onClick(QMUIQuickAction qMUIQuickAction, Action action, int i);
    }

    public QMUIQuickAction(Context context, int i, int i2) {
        super(context, i, i2);
        this.mActions = new ArrayList<>();
        this.mActionWidth = -2;
        this.mShowMoreArrowIfNeeded = true;
        this.mActionHeight = i2;
        this.mMoreArrowWidth = QMUIResHelper.getAttrDimen(context, R.attr.qmui_quick_action_more_arrow_width);
        this.mPaddingHor = QMUIResHelper.getAttrDimen(context, R.attr.qmui_quick_action_padding_hor);
    }

    public QMUIQuickAction moreArrowWidth(int i) {
        this.mMoreArrowWidth = i;
        return this;
    }

    public QMUIQuickAction paddingHor(int i) {
        this.mPaddingHor = i;
        return this;
    }

    public QMUIQuickAction actionWidth(int i) {
        this.mActionWidth = i;
        return this;
    }

    public QMUIQuickAction actionHeight(int i) {
        this.mActionHeight = i;
        return this;
    }

    public QMUIQuickAction addAction(Action action) {
        this.mActions.add(action);
        return this;
    }

    public QMUIQuickAction showMoreArrowIfNeeded(boolean z) {
        this.mShowMoreArrowIfNeeded = z;
        return this;
    }

    @Override // com.qmuiteam.qmui.widget.popup.QMUINormalPopup
    protected int proxyWidth(int i) {
        int i2;
        if (i > 0 && (i2 = this.mActionWidth) > 0) {
            int size = i2 * this.mActions.size();
            int i3 = this.mPaddingHor;
            if (i >= size + (i3 * 2)) {
                return super.proxyWidth(i);
            }
            int i4 = this.mMoreArrowWidth;
            int i5 = this.mActionWidth;
            return (i5 * (((i - i3) - i4) / i5)) + i3 + i4;
        }
        return super.proxyWidth(i);
    }

    @Override // com.qmuiteam.qmui.widget.popup.QMUINormalPopup
    public QMUIQuickAction show(View view) {
        return (QMUIQuickAction) super.show(view);
    }

    @Override // com.qmuiteam.qmui.widget.popup.QMUINormalPopup
    public QMUIQuickAction show(View view, int i, int i2, int i3, int i4) {
        view(createContentView());
        return (QMUIQuickAction) super.show(view, i, i2, i3, i4);
    }

    private ConstraintLayout createContentView() {
        ConstraintLayout constraintLayout = new ConstraintLayout(this.mContext);
        final RecyclerView recyclerView = new RecyclerView(this.mContext);
        recyclerView.setLayoutManager(new LayoutManager(this.mContext));
        recyclerView.setId(View.generateViewId());
        int i = this.mPaddingHor;
        recyclerView.setPadding(i, 0, i, 0);
        recyclerView.setClipToPadding(false);
        final Adapter adapter = new Adapter();
        adapter.submitList(this.mActions);
        recyclerView.setAdapter(adapter);
        constraintLayout.addView(recyclerView);
        if (this.mShowMoreArrowIfNeeded) {
            AppCompatImageView appCompatImageViewCreateMoreArrowView = createMoreArrowView(true);
            AppCompatImageView appCompatImageViewCreateMoreArrowView2 = createMoreArrowView(false);
            appCompatImageViewCreateMoreArrowView.setOnClickListener(new View.OnClickListener() { // from class: com.qmuiteam.qmui.widget.popup.QMUIQuickAction.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    recyclerView.smoothScrollToPosition(0);
                }
            });
            appCompatImageViewCreateMoreArrowView2.setOnClickListener(new View.OnClickListener() { // from class: com.qmuiteam.qmui.widget.popup.QMUIQuickAction.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                }
            });
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(this.mMoreArrowWidth, 0);
            layoutParams.leftToLeft = recyclerView.getId();
            layoutParams.topToTop = recyclerView.getId();
            layoutParams.bottomToBottom = recyclerView.getId();
            constraintLayout.addView(appCompatImageViewCreateMoreArrowView, layoutParams);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(this.mMoreArrowWidth, 0);
            layoutParams2.rightToRight = recyclerView.getId();
            layoutParams2.topToTop = recyclerView.getId();
            layoutParams2.bottomToBottom = recyclerView.getId();
            constraintLayout.addView(appCompatImageViewCreateMoreArrowView2, layoutParams2);
            recyclerView.addItemDecoration(new ItemDecoration(appCompatImageViewCreateMoreArrowView, appCompatImageViewCreateMoreArrowView2));
        }
        return constraintLayout;
    }

    protected AppCompatImageView createMoreArrowView(boolean z) {
        QMUIRadiusImageView2 qMUIRadiusImageView2 = new QMUIRadiusImageView2(this.mContext);
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        if (z) {
            qMUIRadiusImageView2.setPadding(this.mPaddingHor, 0, 0, 0);
            qMUISkinValueBuilderAcquire.src(R.attr.qmui_skin_support_quick_action_more_left_arrow);
        } else {
            qMUIRadiusImageView2.setPadding(0, 0, this.mPaddingHor, 0);
            qMUISkinValueBuilderAcquire.src(R.attr.qmui_skin_support_quick_action_more_right_arrow);
        }
        qMUISkinValueBuilderAcquire.tintColor(R.attr.qmui_skin_support_quick_action_more_tint_color);
        int bgColor = getBgColor();
        int bgColorAttr = getBgColorAttr();
        if (bgColorAttr != 0) {
            qMUISkinValueBuilderAcquire.background(bgColorAttr);
        } else if (bgColor != 0) {
            qMUIRadiusImageView2.setBackgroundColor(bgColor);
        }
        QMUISkinHelper.setSkinValue(qMUIRadiusImageView2, qMUISkinValueBuilderAcquire);
        qMUIRadiusImageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        qMUIRadiusImageView2.setVisibility(8);
        qMUIRadiusImageView2.setAlpha(0.0f);
        qMUISkinValueBuilderAcquire.release();
        return qMUIRadiusImageView2;
    }

    private class ItemDecoration extends RecyclerView.ItemDecoration {
        private AppCompatImageView leftMoreArrowView;
        private AppCompatImageView rightMoreArrowView;
        private boolean isLeftMoreShown = false;
        private boolean isRightMoreShown = false;
        private boolean isFirstDraw = true;
        private int TOGGLE_DURATION = 60;
        private Runnable leftHideEndAction = new Runnable() { // from class: com.qmuiteam.qmui.widget.popup.QMUIQuickAction.ItemDecoration.1
            @Override // java.lang.Runnable
            public void run() {
                ItemDecoration.this.leftMoreArrowView.setVisibility(8);
            }
        };
        private Runnable rightHideEndAction = new Runnable() { // from class: com.qmuiteam.qmui.widget.popup.QMUIQuickAction.ItemDecoration.2
            @Override // java.lang.Runnable
            public void run() {
                ItemDecoration.this.rightMoreArrowView.setVisibility(8);
            }
        };

        public ItemDecoration(AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2) {
            this.leftMoreArrowView = appCompatImageView;
            this.rightMoreArrowView = appCompatImageView2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.canScrollHorizontally(-1)) {
                if (!this.isLeftMoreShown) {
                    this.isLeftMoreShown = true;
                    this.leftMoreArrowView.setVisibility(0);
                    if (this.isFirstDraw) {
                        this.leftMoreArrowView.setAlpha(1.0f);
                    } else {
                        this.leftMoreArrowView.animate().alpha(1.0f).setDuration(this.TOGGLE_DURATION).start();
                    }
                }
            } else if (this.isLeftMoreShown) {
                this.isLeftMoreShown = false;
                this.leftMoreArrowView.animate().alpha(0.0f).setDuration(this.TOGGLE_DURATION).withEndAction(this.leftHideEndAction).start();
            }
            if (recyclerView.canScrollHorizontally(1)) {
                if (!this.isRightMoreShown) {
                    this.isRightMoreShown = true;
                    this.rightMoreArrowView.setVisibility(0);
                    if (this.isFirstDraw) {
                        this.rightMoreArrowView.setAlpha(1.0f);
                    } else {
                        this.rightMoreArrowView.animate().setDuration(this.TOGGLE_DURATION).alpha(1.0f).start();
                    }
                }
            } else if (this.isRightMoreShown) {
                this.isRightMoreShown = false;
                this.rightMoreArrowView.animate().alpha(0.0f).setDuration(this.TOGGLE_DURATION).withEndAction(this.rightHideEndAction).start();
            }
            this.isFirstDraw = false;
        }
    }

    private class LayoutManager extends LinearLayoutManager {
        private static final float MILLISECONDS_PER_INCH = 0.01f;

        public LayoutManager(Context context) {
            super(context, 0, false);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(QMUIQuickAction.this.mActionWidth, QMUIQuickAction.this.mActionHeight);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.qmuiteam.qmui.widget.popup.QMUIQuickAction.LayoutManager.1
                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                protected int calculateTimeForScrolling(int i2) {
                    return 100;
                }
            };
            linearSmoothScroller.setTargetPosition(i);
            startSmoothScroll(linearSmoothScroller);
        }
    }

    private static class VH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Callback callback;

        interface Callback {
            void onClick(View view, int i);
        }

        public VH(ItemView itemView, Callback callback) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.callback = callback;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.callback.onClick(view, getAdapterPosition());
        }
    }

    private class DiffCallback extends DiffUtil.ItemCallback<Action> {
        private DiffCallback() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(Action action, Action action2) {
            return Objects.equals(action.text, action2.text) && action.icon == action2.icon && action.iconAttr == action2.iconAttr && action.onClickListener == action2.onClickListener;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(Action action, Action action2) {
            return action.textColorAttr == action2.textColorAttr && action.iconTintColorAttr == action2.iconTintColorAttr;
        }
    }

    protected ItemView createItemView() {
        return new DefaultItemView(this.mContext);
    }

    private class Adapter extends ListAdapter<Action, VH> implements VH.Callback {
        protected Adapter() {
            super(new DiffCallback());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new VH(QMUIQuickAction.this.createItemView(), this);
        }

        @Override // com.qmuiteam.qmui.widget.popup.QMUIQuickAction.VH.Callback
        public void onClick(View view, int i) {
            Action item = getItem(i);
            OnClickListener onClickListener = item.onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(QMUIQuickAction.this, item, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(VH vh, int i) {
            ((ItemView) vh.itemView).render(getItem(i));
        }
    }

    public static class Action {
        Drawable icon;
        int iconRes;
        OnClickListener onClickListener;
        CharSequence text;
        int iconAttr = 0;
        int textColorAttr = R.attr.qmui_skin_support_quick_action_item_tint_color;
        int iconTintColorAttr = R.attr.qmui_skin_support_quick_action_item_tint_color;

        public Action iconAttr(int i) {
            this.iconAttr = i;
            return this;
        }

        public Action icon(Drawable drawable) {
            this.icon = drawable;
            return this;
        }

        public Action icon(int i) {
            this.iconRes = i;
            return this;
        }

        public Action onClick(OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
            return this;
        }

        public Action text(CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public Action textColorAttr(int i) {
            this.textColorAttr = i;
            return this;
        }

        public Action iconTintColorAttr(int i) {
            this.iconTintColorAttr = i;
            return this;
        }
    }

    public static abstract class ItemView extends QMUIConstraintLayout {
        public abstract void render(Action action);

        public ItemView(Context context) {
            super(context);
        }

        public ItemView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class DefaultItemView extends ItemView {
        private AppCompatImageView mIconView;
        private TextView mTextView;

        public DefaultItemView(Context context) {
            this(context, null);
        }

        public DefaultItemView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int attrDimen = QMUIResHelper.getAttrDimen(context, R.attr.qmui_quick_action_item_padding_hor);
            int attrDimen2 = QMUIResHelper.getAttrDimen(context, R.attr.qmui_quick_action_item_padding_ver);
            setPadding(attrDimen, attrDimen2, attrDimen, attrDimen2);
            AppCompatImageView appCompatImageView = new AppCompatImageView(context);
            this.mIconView = appCompatImageView;
            appCompatImageView.setId(QMUIViewHelper.generateViewId());
            TextView textView = new TextView(context);
            this.mTextView = textView;
            textView.setId(QMUIViewHelper.generateViewId());
            this.mTextView.setTextSize(10.0f);
            this.mTextView.setTypeface(Typeface.DEFAULT_BOLD);
            setChangeAlphaWhenPress(true);
            setChangeAlphaWhenDisable(true);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.leftToLeft = 0;
            layoutParams.rightToRight = 0;
            layoutParams.topToTop = 0;
            layoutParams.bottomToTop = this.mTextView.getId();
            layoutParams.verticalChainStyle = 2;
            addView(this.mIconView, layoutParams);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams2.leftToLeft = 0;
            layoutParams2.rightToRight = 0;
            layoutParams2.topToBottom = this.mIconView.getId();
            layoutParams2.bottomToBottom = 0;
            layoutParams2.topMargin = QMUIResHelper.getAttrDimen(context, R.attr.qmui_quick_action_item_middle_space);
            layoutParams2.verticalChainStyle = 2;
            layoutParams2.goneTopMargin = 0;
            addView(this.mTextView, layoutParams2);
        }

        @Override // com.qmuiteam.qmui.widget.popup.QMUIQuickAction.ItemView
        public void render(Action action) {
            QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
            if (action.icon != null || action.iconRes != 0) {
                if (action.icon != null) {
                    this.mIconView.setImageDrawable(action.icon.mutate());
                } else {
                    this.mIconView.setImageResource(action.iconRes);
                }
                if (action.iconTintColorAttr != 0) {
                    qMUISkinValueBuilderAcquire.tintColor(action.iconTintColorAttr);
                }
                this.mIconView.setVisibility(0);
                QMUISkinHelper.setSkinValue(this.mIconView, qMUISkinValueBuilderAcquire);
            } else if (action.iconAttr != 0) {
                qMUISkinValueBuilderAcquire.src(action.iconAttr);
                this.mIconView.setVisibility(0);
                QMUISkinHelper.setSkinValue(this.mIconView, qMUISkinValueBuilderAcquire);
            } else {
                this.mIconView.setVisibility(8);
            }
            this.mTextView.setText(action.text);
            qMUISkinValueBuilderAcquire.clear();
            qMUISkinValueBuilderAcquire.textColor(action.textColorAttr);
            QMUISkinHelper.setSkinValue(this.mTextView, qMUISkinValueBuilderAcquire);
            qMUISkinValueBuilderAcquire.release();
        }
    }
}
