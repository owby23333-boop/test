package com.qmuiteam.qmui.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.R;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIResHelper {
    private static TypedValue sTmpValue;

    public static float getAttrFloatValue(Context context, int i) {
        return getAttrFloatValue(context.getTheme(), i);
    }

    public static float getAttrFloatValue(Resources.Theme theme, int i) {
        if (sTmpValue == null) {
            sTmpValue = new TypedValue();
        }
        if (theme.resolveAttribute(i, sTmpValue, true)) {
            return sTmpValue.getFloat();
        }
        return 0.0f;
    }

    public static int getAttrColor(Context context, int i) {
        return getAttrColor(context.getTheme(), i);
    }

    public static int getAttrColor(Resources.Theme theme, int i) {
        if (sTmpValue == null) {
            sTmpValue = new TypedValue();
        }
        if (!theme.resolveAttribute(i, sTmpValue, true)) {
            return 0;
        }
        if (sTmpValue.type == 2) {
            return getAttrColor(theme, sTmpValue.data);
        }
        return sTmpValue.data;
    }

    public static ColorStateList getAttrColorStateList(Context context, int i) {
        return getAttrColorStateList(context, context.getTheme(), i);
    }

    public static ColorStateList getAttrColorStateList(Context context, Resources.Theme theme, int i) {
        if (i == 0) {
            return null;
        }
        if (sTmpValue == null) {
            sTmpValue = new TypedValue();
        }
        if (!theme.resolveAttribute(i, sTmpValue, true)) {
            return null;
        }
        if (sTmpValue.type >= 28 && sTmpValue.type <= 31) {
            return ColorStateList.valueOf(sTmpValue.data);
        }
        if (sTmpValue.type == 2) {
            return getAttrColorStateList(context, theme, sTmpValue.data);
        }
        if (sTmpValue.resourceId == 0) {
            return null;
        }
        return ContextCompat.getColorStateList(context, sTmpValue.resourceId);
    }

    public static Drawable getAttrDrawable(Context context, int i) {
        return getAttrDrawable(context, context.getTheme(), i);
    }

    public static Drawable getAttrDrawable(Context context, Resources.Theme theme, int i) {
        if (i == 0) {
            return null;
        }
        if (sTmpValue == null) {
            sTmpValue = new TypedValue();
        }
        if (!theme.resolveAttribute(i, sTmpValue, true)) {
            return null;
        }
        if (sTmpValue.type >= 28 && sTmpValue.type <= 31) {
            return new ColorDrawable(sTmpValue.data);
        }
        if (sTmpValue.type == 2) {
            return getAttrDrawable(context, theme, sTmpValue.data);
        }
        if (sTmpValue.resourceId != 0) {
            return QMUIDrawableHelper.getVectorDrawable(context, sTmpValue.resourceId);
        }
        return null;
    }

    public static Drawable getAttrDrawable(Context context, TypedArray typedArray, int i) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue == null || typedValuePeekValue.type == 2 || typedValuePeekValue.resourceId == 0) {
            return null;
        }
        return QMUIDrawableHelper.getVectorDrawable(context, typedValuePeekValue.resourceId);
    }

    public static int getAttrDimen(Context context, int i) {
        if (sTmpValue == null) {
            sTmpValue = new TypedValue();
        }
        if (context.getTheme().resolveAttribute(i, sTmpValue, true)) {
            return TypedValue.complexToDimensionPixelSize(sTmpValue.data, QMUIDisplayHelper.getDisplayMetrics(context));
        }
        return 0;
    }

    public static String getAttrString(Context context, int i) {
        CharSequence charSequence;
        if (sTmpValue == null) {
            sTmpValue = new TypedValue();
        }
        if (context.getTheme().resolveAttribute(i, sTmpValue, true) && (charSequence = sTmpValue.string) != null) {
            return charSequence.toString();
        }
        return null;
    }

    public static int getAttrInt(Context context, int i) {
        if (sTmpValue == null) {
            sTmpValue = new TypedValue();
        }
        context.getTheme().resolveAttribute(i, sTmpValue, true);
        return sTmpValue.data;
    }

    public static void assignTextViewWithAttr(TextView textView, int i) {
        TypedArray typedArrayObtainStyledAttributes = textView.getContext().obtainStyledAttributes(null, R.styleable.QMUITextCommonStyleDef, i, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        int paddingLeft = textView.getPaddingLeft();
        int paddingRight = textView.getPaddingRight();
        int paddingTop = textView.getPaddingTop();
        int paddingBottom = textView.getPaddingBottom();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.QMUITextCommonStyleDef_android_gravity) {
                textView.setGravity(typedArrayObtainStyledAttributes.getInt(index, -1));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_textColor) {
                textView.setTextColor(typedArrayObtainStyledAttributes.getColorStateList(index));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_textSize) {
                textView.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_paddingLeft) {
                paddingLeft = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_paddingRight) {
                paddingRight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_paddingTop) {
                paddingTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_paddingBottom) {
                paddingBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_singleLine) {
                textView.setSingleLine(typedArrayObtainStyledAttributes.getBoolean(index, false));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_ellipsize) {
                int i3 = typedArrayObtainStyledAttributes.getInt(index, 3);
                if (i3 == 1) {
                    textView.setEllipsize(TextUtils.TruncateAt.START);
                } else if (i3 == 2) {
                    textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                } else if (i3 == 3) {
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                } else if (i3 == 4) {
                    textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                }
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_maxLines) {
                textView.setMaxLines(typedArrayObtainStyledAttributes.getInt(index, -1));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_background) {
                QMUIViewHelper.setBackgroundKeepingPadding(textView, typedArrayObtainStyledAttributes.getDrawable(index));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_lineSpacingExtra) {
                textView.setLineSpacing(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0), 1.0f);
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_drawablePadding) {
                textView.setCompoundDrawablePadding(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_textColorHint) {
                textView.setHintTextColor(typedArrayObtainStyledAttributes.getColor(index, 0));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_textStyle) {
                textView.setTypeface(null, typedArrayObtainStyledAttributes.getInt(index, -1));
            }
        }
        textView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        typedArrayObtainStyledAttributes.recycle();
    }
}
