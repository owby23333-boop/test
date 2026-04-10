package miuix.internal.util;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import miuix.internal.graphics.drawable.TaggingDrawable;

/* JADX INFO: loaded from: classes8.dex */
public class TaggingDrawableUtil {
    private static final int UNINITIAL = -1;
    private static int mPaddingLarge = -1;
    private static int mPaddingSingle = -1;
    private static int mPaddingSmall = -1;
    private static final int[] STATES_TAGS = {R.attr.state_single, R.attr.state_first, R.attr.state_middle, R.attr.state_last};
    private static final int[] STATE_SET_SINGLE = {R.attr.state_single};
    private static final int[] STATE_SET_FIRST = {R.attr.state_first};
    private static final int[] STATE_SET_MIDDLE = {R.attr.state_middle};
    private static final int[] STATE_SET_LAST = {R.attr.state_last};

    private static int getDimen(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static void updateBackgroundState(View view, int i, int i2) {
        if (view == null || i2 == 0) {
            return;
        }
        Drawable background = view.getBackground();
        if ((background instanceof StateListDrawable) && TaggingDrawable.containsTagState((StateListDrawable) background, STATES_TAGS)) {
            TaggingDrawable taggingDrawable = new TaggingDrawable(background);
            view.setBackground(taggingDrawable);
            background = taggingDrawable;
        }
        if (background instanceof TaggingDrawable) {
            ((TaggingDrawable) background).setTaggingState(i2 == 1 ? STATE_SET_SINGLE : i == 0 ? STATE_SET_FIRST : i == i2 - 1 ? STATE_SET_LAST : STATE_SET_MIDDLE);
        }
    }

    public static void updateItemBackground(View view, int i, int i2) {
        updateBackgroundState(view, i, i2);
        updateItemPadding(view, i, i2);
    }

    public static void updateItemPadding(View view, int i, int i2) {
        int i3;
        int i4;
        if (view == null || i2 == 0) {
            return;
        }
        Context context = view.getContext();
        int paddingStart = view.getPaddingStart();
        view.getPaddingTop();
        int paddingEnd = view.getPaddingEnd();
        view.getPaddingBottom();
        int dimen = getDimen(context, miuix.appcompat.R.dimen.miuix_appcompat_drop_down_item_min_height);
        if (i2 != 1) {
            if (mPaddingSmall == -1) {
                mPaddingSmall = getDimen(context, miuix.appcompat.R.dimen.miuix_appcompat_drop_down_menu_padding_small);
            }
            if (mPaddingLarge == -1) {
                mPaddingLarge = getDimen(context, miuix.appcompat.R.dimen.miuix_appcompat_drop_down_menu_padding_large);
            }
            if (i == 0) {
                i3 = mPaddingLarge;
                i4 = mPaddingSmall;
                dimen = getDimen(context, miuix.appcompat.R.dimen.miuix_appcompat_drop_down_first_item_min_height);
            } else if (i == i2 - 1) {
                i3 = mPaddingSmall;
                i4 = mPaddingLarge;
                dimen = getDimen(context, miuix.appcompat.R.dimen.miuix_appcompat_drop_down_last_item_min_height);
            } else {
                i3 = mPaddingSmall;
            }
            view.setMinimumHeight(dimen);
            view.setPaddingRelative(paddingStart, i3, paddingEnd, i4);
        }
        if (mPaddingSingle == -1) {
            mPaddingSingle = getDimen(context, miuix.appcompat.R.dimen.miuix_appcompat_drop_down_menu_padding_single_item);
        }
        i3 = mPaddingSingle;
        i4 = i3;
        view.setMinimumHeight(dimen);
        view.setPaddingRelative(paddingStart, i3, paddingEnd, i4);
    }
}
