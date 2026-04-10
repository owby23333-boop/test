package com.qmuiteam.qmui.widget.grouplist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIGroupListView extends LinearLayout {
    private SparseArray<Section> mSections;

    public QMUIGroupListView(Context context) {
        this(context, null);
    }

    public QMUIGroupListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIGroupListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSections = new SparseArray<>();
        setOrientation(1);
    }

    public static Section newSection(Context context) {
        return new Section(context);
    }

    public int getSectionCount() {
        return this.mSections.size();
    }

    public QMUICommonListItemView createItemView(Drawable drawable, CharSequence charSequence, String str, int i, int i2, int i3) {
        QMUICommonListItemView qMUICommonListItemView = new QMUICommonListItemView(getContext());
        qMUICommonListItemView.setOrientation(i);
        qMUICommonListItemView.setLayoutParams(new LinearLayout.LayoutParams(-1, i3));
        qMUICommonListItemView.setImageDrawable(drawable);
        qMUICommonListItemView.setText(charSequence);
        qMUICommonListItemView.setDetailText(str);
        qMUICommonListItemView.setAccessoryType(i2);
        return qMUICommonListItemView;
    }

    public QMUICommonListItemView createItemView(Drawable drawable, CharSequence charSequence, String str, int i, int i2) {
        if (i == 0) {
            return createItemView(drawable, charSequence, str, i, i2, QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_list_item_height_higher));
        }
        return createItemView(drawable, charSequence, str, i, i2, QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_list_item_height));
    }

    public QMUICommonListItemView createItemView(CharSequence charSequence) {
        return createItemView(null, charSequence, null, 1, 0);
    }

    public QMUICommonListItemView createItemView(int i) {
        return createItemView(null, null, null, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSection(Section section) {
        SparseArray<Section> sparseArray = this.mSections;
        sparseArray.append(sparseArray.size(), section);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSection(Section section) {
        for (int i = 0; i < this.mSections.size(); i++) {
            if (this.mSections.valueAt(i) == section) {
                this.mSections.remove(i);
            }
        }
    }

    public Section getSection(int i) {
        return this.mSections.get(i);
    }

    public static class Section {
        private Context mContext;
        private QMUIGroupListSectionHeaderFooterView mDescriptionView;
        private QMUIGroupListSectionHeaderFooterView mTitleView;
        private boolean mUseDefaultTitleIfNone;
        private boolean mUseTitleViewForSectionSpace = true;
        private int mSeparatorColorAttr = R.attr.qmui_skin_support_common_list_separator_color;
        private boolean mHandleSeparatorCustom = false;
        private boolean mShowSeparator = true;
        private boolean mOnlyShowStartEndSeparator = false;
        private boolean mOnlyShowMiddleSeparator = false;
        private int mMiddleSeparatorInsetLeft = 0;
        private int mMiddleSeparatorInsetRight = 0;
        private int mBgAttr = R.attr.qmui_skin_support_s_common_list_bg;
        private int mLeftIconWidth = -2;
        private int mLeftIconHeight = -2;
        private SparseArray<QMUICommonListItemView> mItemViews = new SparseArray<>();

        public Section(Context context) {
            this.mContext = context;
        }

        public Section addItemView(QMUICommonListItemView qMUICommonListItemView, View.OnClickListener onClickListener) {
            return addItemView(qMUICommonListItemView, onClickListener, null);
        }

        public Section addItemView(QMUICommonListItemView qMUICommonListItemView, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
            if (onClickListener != null) {
                qMUICommonListItemView.setOnClickListener(onClickListener);
            }
            if (onLongClickListener != null) {
                qMUICommonListItemView.setOnLongClickListener(onLongClickListener);
            }
            SparseArray<QMUICommonListItemView> sparseArray = this.mItemViews;
            sparseArray.append(sparseArray.size(), qMUICommonListItemView);
            return this;
        }

        public Section setTitle(CharSequence charSequence) {
            this.mTitleView = createSectionHeader(charSequence);
            return this;
        }

        public Section setDescription(CharSequence charSequence) {
            this.mDescriptionView = createSectionFooter(charSequence);
            return this;
        }

        public Section setUseDefaultTitleIfNone(boolean z) {
            this.mUseDefaultTitleIfNone = z;
            return this;
        }

        public Section setUseTitleViewForSectionSpace(boolean z) {
            this.mUseTitleViewForSectionSpace = z;
            return this;
        }

        public Section setLeftIconSize(int i, int i2) {
            this.mLeftIconHeight = i2;
            this.mLeftIconWidth = i;
            return this;
        }

        public Section setSeparatorColorAttr(int i) {
            this.mSeparatorColorAttr = i;
            return this;
        }

        public Section setHandleSeparatorCustom(boolean z) {
            this.mHandleSeparatorCustom = z;
            return this;
        }

        public Section setShowSeparator(boolean z) {
            this.mShowSeparator = z;
            return this;
        }

        public Section setOnlyShowStartEndSeparator(boolean z) {
            this.mOnlyShowStartEndSeparator = z;
            return this;
        }

        public Section setOnlyShowMiddleSeparator(boolean z) {
            this.mOnlyShowMiddleSeparator = z;
            return this;
        }

        public Section setMiddleSeparatorInset(int i, int i2) {
            this.mMiddleSeparatorInsetLeft = i;
            this.mMiddleSeparatorInsetRight = i2;
            return this;
        }

        public Section setBgAttr(int i) {
            this.mBgAttr = i;
            return this;
        }

        public void addTo(QMUIGroupListView qMUIGroupListView) {
            if (this.mTitleView == null) {
                if (this.mUseDefaultTitleIfNone) {
                    setTitle("Section " + qMUIGroupListView.getSectionCount());
                } else if (this.mUseTitleViewForSectionSpace) {
                    setTitle("");
                }
            }
            View view = this.mTitleView;
            if (view != null) {
                qMUIGroupListView.addView(view);
            }
            int size = this.mItemViews.size();
            QMUICommonListItemView.LayoutParamConfig layoutParamConfig = new QMUICommonListItemView.LayoutParamConfig() { // from class: com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView.Section.1
                @Override // com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView.LayoutParamConfig
                public ConstraintLayout.LayoutParams onConfig(ConstraintLayout.LayoutParams layoutParams) {
                    layoutParams.width = Section.this.mLeftIconWidth;
                    layoutParams.height = Section.this.mLeftIconHeight;
                    return layoutParams;
                }
            };
            QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
            String strBuild = qMUISkinValueBuilderAcquire.background(this.mBgAttr).topSeparator(this.mSeparatorColorAttr).bottomSeparator(this.mSeparatorColorAttr).build();
            QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
            int attrColor = QMUIResHelper.getAttrColor(qMUIGroupListView.getContext(), this.mSeparatorColorAttr);
            for (int i = 0; i < size; i++) {
                QMUICommonListItemView qMUICommonListItemView = this.mItemViews.get(i);
                Drawable skinDrawable = QMUISkinHelper.getSkinDrawable(qMUIGroupListView, this.mBgAttr);
                QMUIViewHelper.setBackgroundKeepingPadding(qMUICommonListItemView, skinDrawable == null ? null : skinDrawable.mutate());
                QMUISkinHelper.setSkinValue(qMUICommonListItemView, strBuild);
                if (!this.mHandleSeparatorCustom && this.mShowSeparator) {
                    if (size == 1) {
                        qMUICommonListItemView.updateTopDivider(0, 0, 1, attrColor);
                        qMUICommonListItemView.updateBottomDivider(0, 0, 1, attrColor);
                    } else if (i == 0) {
                        if (!this.mOnlyShowMiddleSeparator) {
                            qMUICommonListItemView.updateTopDivider(0, 0, 1, attrColor);
                        }
                        if (!this.mOnlyShowStartEndSeparator) {
                            qMUICommonListItemView.updateBottomDivider(this.mMiddleSeparatorInsetLeft, this.mMiddleSeparatorInsetRight, 1, attrColor);
                        }
                    } else if (i == size - 1) {
                        if (!this.mOnlyShowMiddleSeparator) {
                            qMUICommonListItemView.updateBottomDivider(0, 0, 1, attrColor);
                        }
                    } else if (!this.mOnlyShowStartEndSeparator) {
                        qMUICommonListItemView.updateBottomDivider(this.mMiddleSeparatorInsetLeft, this.mMiddleSeparatorInsetRight, 1, attrColor);
                    }
                }
                qMUICommonListItemView.updateImageViewLp(layoutParamConfig);
                qMUIGroupListView.addView(qMUICommonListItemView);
            }
            View view2 = this.mDescriptionView;
            if (view2 != null) {
                qMUIGroupListView.addView(view2);
            }
            qMUIGroupListView.addSection(this);
        }

        public void removeFrom(QMUIGroupListView qMUIGroupListView) {
            QMUIGroupListSectionHeaderFooterView qMUIGroupListSectionHeaderFooterView = this.mTitleView;
            if (qMUIGroupListSectionHeaderFooterView != null && qMUIGroupListSectionHeaderFooterView.getParent() == qMUIGroupListView) {
                qMUIGroupListView.removeView(this.mTitleView);
            }
            for (int i = 0; i < this.mItemViews.size(); i++) {
                qMUIGroupListView.removeView(this.mItemViews.get(i));
            }
            QMUIGroupListSectionHeaderFooterView qMUIGroupListSectionHeaderFooterView2 = this.mDescriptionView;
            if (qMUIGroupListSectionHeaderFooterView2 != null && qMUIGroupListSectionHeaderFooterView2.getParent() == qMUIGroupListView) {
                qMUIGroupListView.removeView(this.mDescriptionView);
            }
            qMUIGroupListView.removeSection(this);
        }

        public QMUIGroupListSectionHeaderFooterView createSectionHeader(CharSequence charSequence) {
            return new QMUIGroupListSectionHeaderFooterView(this.mContext, charSequence);
        }

        public QMUIGroupListSectionHeaderFooterView createSectionFooter(CharSequence charSequence) {
            return new QMUIGroupListSectionHeaderFooterView(this.mContext, charSequence, true);
        }
    }
}
