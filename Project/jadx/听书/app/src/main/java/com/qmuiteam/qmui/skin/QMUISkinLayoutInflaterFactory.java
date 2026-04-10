package com.qmuiteam.qmui.skin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.funny.audio.core.utils.FileUtils;
import com.qmuiteam.qmui.QMUILog;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUILangHelper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinLayoutInflaterFactory implements LayoutInflater.Factory2 {
    private static final String TAG = "QMUISkin";
    private WeakReference<Activity> mActivityWeakReference;
    private Resources.Theme mEmptyTheme;
    private LayoutInflater mOriginLayoutInflater;
    private static final String[] sClassPrefixList = {"android.widget.", "android.webkit.", "android.app.", "android.view."};
    private static final HashMap<String, String> sSuccessClassNamePrefixMap = new HashMap<>();
    private static boolean sCanUseCreateViewFourArguments = true;
    private static boolean sDidCheckLayoutInflaterCreateViewExitFourArgMethod = false;

    public QMUISkinLayoutInflaterFactory(Activity activity, LayoutInflater layoutInflater) {
        this.mActivityWeakReference = new WeakReference<>(activity);
        this.mOriginLayoutInflater = layoutInflater;
    }

    public QMUISkinLayoutInflaterFactory cloneForLayoutInflaterIfNeeded(LayoutInflater layoutInflater) {
        return this.mOriginLayoutInflater.getContext() == layoutInflater.getContext() ? this : new QMUISkinLayoutInflaterFactory(this.mActivityWeakReference.get(), layoutInflater);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Activity activity = this.mActivityWeakReference.get();
        View viewCreateView = activity instanceof AppCompatActivity ? ((AppCompatActivity) activity).getDelegate().createView(view, str, context, attributeSet) : null;
        if (viewCreateView == null) {
            try {
                try {
                    if (!str.contains(FileUtils.FILE_EXTENSION_SEPARATOR)) {
                        HashMap<String, String> map = sSuccessClassNamePrefixMap;
                        if (map.containsKey(str)) {
                            viewCreateView = this.mOriginLayoutInflater.createView(str, map.get(str), attributeSet);
                        } else {
                            for (String str2 : sClassPrefixList) {
                                try {
                                    viewCreateView = this.mOriginLayoutInflater.createView(str, str2, attributeSet);
                                    if (viewCreateView != null) {
                                        sSuccessClassNamePrefixMap.put(str, str2);
                                        break;
                                    }
                                    continue;
                                } catch (Exception unused) {
                                }
                            }
                        }
                    } else if (Build.VERSION.SDK_INT >= 28) {
                        if (!sDidCheckLayoutInflaterCreateViewExitFourArgMethod) {
                            try {
                                LayoutInflater.class.getDeclaredMethod("createView", Context.class, String.class, String.class, AttributeSet.class);
                            } catch (Exception unused2) {
                                sCanUseCreateViewFourArguments = false;
                            }
                            sDidCheckLayoutInflaterCreateViewExitFourArgMethod = true;
                        }
                        viewCreateView = sCanUseCreateViewFourArguments ? this.mOriginLayoutInflater.createView(context, str, null, attributeSet) : originCreateViewForLowSDK(str, context, attributeSet);
                    } else {
                        viewCreateView = originCreateViewForLowSDK(str, context, attributeSet);
                    }
                } catch (Exception e) {
                    QMUILog.e(TAG, "Failed to inflate view " + str + "; error: " + e.getMessage(), new Object[0]);
                }
            } catch (ClassNotFoundException unused3) {
            }
        }
        if (viewCreateView != null) {
            QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
            getSkinValueFromAttributeSet(viewCreateView.getContext(), attributeSet, qMUISkinValueBuilderAcquire);
            if (!qMUISkinValueBuilderAcquire.isEmpty()) {
                QMUISkinHelper.setSkinValue(viewCreateView, qMUISkinValueBuilderAcquire);
            }
            QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
        }
        return viewCreateView;
    }

    private View originCreateViewForLowSDK(String str, Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, InflateException, ClassNotFoundException, IllegalArgumentException {
        Field declaredField = LayoutInflater.class.getDeclaredField("mConstructorArgs");
        declaredField.setAccessible(true);
        Object[] objArr = (Object[]) declaredField.get(this.mOriginLayoutInflater);
        Object obj = objArr[0];
        objArr[0] = context;
        View viewCreateView = this.mOriginLayoutInflater.createView(str, null, attributeSet);
        objArr[0] = obj;
        return viewCreateView;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void getSkinValueFromAttributeSet(Context context, AttributeSet attributeSet, QMUISkinValueBuilder qMUISkinValueBuilder) {
        if (this.mEmptyTheme == null) {
            this.mEmptyTheme = context.getApplicationContext().getResources().newTheme();
        }
        TypedArray typedArrayObtainStyledAttributes = this.mEmptyTheme.obtainStyledAttributes(attributeSet, R.styleable.QMUISkinDef, 0, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            String string = typedArrayObtainStyledAttributes.getString(index);
            if (!QMUILangHelper.isNullOrEmpty(string)) {
                if (string.startsWith("?")) {
                    string = string.substring(1);
                }
                int identifier = context.getResources().getIdentifier(string, "attr", context.getPackageName());
                if (identifier != 0) {
                    if (index == R.styleable.QMUISkinDef_qmui_skin_background) {
                        qMUISkinValueBuilder.background(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_alpha) {
                        qMUISkinValueBuilder.alpha(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_border) {
                        qMUISkinValueBuilder.border(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_text_color) {
                        qMUISkinValueBuilder.textColor(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_second_text_color) {
                        qMUISkinValueBuilder.secondTextColor(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_src) {
                        qMUISkinValueBuilder.src(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_tint_color) {
                        qMUISkinValueBuilder.tintColor(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_separator_top) {
                        qMUISkinValueBuilder.topSeparator(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_separator_right) {
                        qMUISkinValueBuilder.rightSeparator(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_separator_bottom) {
                        qMUISkinValueBuilder.bottomSeparator(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_separator_left) {
                        qMUISkinValueBuilder.leftSeparator(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_bg_tint_color) {
                        qMUISkinValueBuilder.bgTintColor(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_progress_color) {
                        qMUISkinValueBuilder.progressColor(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_underline) {
                        qMUISkinValueBuilder.underline(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_more_bg_color) {
                        qMUISkinValueBuilder.moreBgColor(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_more_text_color) {
                        qMUISkinValueBuilder.moreTextColor(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_hint_color) {
                        qMUISkinValueBuilder.hintColor(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_text_compound_tint_color) {
                        qMUISkinValueBuilder.textCompoundTintColor(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_text_compound_src_left) {
                        qMUISkinValueBuilder.textCompoundLeftSrc(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_text_compound_src_top) {
                        qMUISkinValueBuilder.textCompoundTopSrc(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_text_compound_src_right) {
                        qMUISkinValueBuilder.textCompoundRightSrc(identifier);
                    } else if (index == R.styleable.QMUISkinDef_qmui_skin_text_compound_src_bottom) {
                        qMUISkinValueBuilder.textCompoundBottomSrc(identifier);
                    }
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
