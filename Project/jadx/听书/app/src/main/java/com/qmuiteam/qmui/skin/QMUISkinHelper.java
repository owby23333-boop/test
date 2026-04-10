package com.qmuiteam.qmui.skin;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.QMUILog;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider;
import com.qmuiteam.qmui.util.QMUIResHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISkinHelper {
    public static QMUISkinValueBuilder sSkinValueBuilder = QMUISkinValueBuilder.acquire();

    public static Resources.Theme getSkinTheme(View view) {
        QMUISkinManager.ViewSkinCurrent viewSkinCurrent = QMUISkinManager.getViewSkinCurrent(view);
        if (viewSkinCurrent == null || viewSkinCurrent.index < 0) {
            return view.getContext().getTheme();
        }
        return QMUISkinManager.of(viewSkinCurrent.managerName, view.getContext()).getTheme(viewSkinCurrent.index);
    }

    public static int getSkinColor(View view, int i) {
        return QMUIResHelper.getAttrColor(getSkinTheme(view), i);
    }

    public static ColorStateList getSkinColorStateList(View view, int i) {
        return QMUIResHelper.getAttrColorStateList(view.getContext(), getSkinTheme(view), i);
    }

    public static Drawable getSkinDrawable(View view, int i) {
        return QMUIResHelper.getAttrDrawable(view.getContext(), getSkinTheme(view), i);
    }

    public static void setSkinValue(View view, QMUISkinValueBuilder qMUISkinValueBuilder) {
        setSkinValue(view, qMUISkinValueBuilder.build());
    }

    public static void setSkinValue(View view, String str) {
        view.setTag(R.id.qmui_skin_value, str);
        refreshViewSkin(view);
    }

    public static void setSkinValue(View view, SkinWriter skinWriter) {
        skinWriter.write(sSkinValueBuilder);
        setSkinValue(view, sSkinValueBuilder.build());
        sSkinValueBuilder.clear();
    }

    public static void refreshRVItemDecoration(RecyclerView recyclerView, IQMUISkinHandlerDecoration iQMUISkinHandlerDecoration) {
        QMUISkinManager.ViewSkinCurrent viewSkinCurrent = QMUISkinManager.getViewSkinCurrent(recyclerView);
        if (viewSkinCurrent != null) {
            QMUISkinManager.of(viewSkinCurrent.managerName, recyclerView.getContext()).refreshRecyclerDecoration(recyclerView, iQMUISkinHandlerDecoration, viewSkinCurrent.index);
        }
    }

    public static int getCurrentSkinIndex(View view) {
        QMUISkinManager.ViewSkinCurrent viewSkinCurrent = QMUISkinManager.getViewSkinCurrent(view);
        if (viewSkinCurrent != null) {
            return viewSkinCurrent.index;
        }
        return -1;
    }

    public static void refreshViewSkin(View view) {
        QMUISkinManager.ViewSkinCurrent viewSkinCurrent = QMUISkinManager.getViewSkinCurrent(view);
        if (viewSkinCurrent != null) {
            QMUISkinManager.of(viewSkinCurrent.managerName, view.getContext()).refreshTheme(view, viewSkinCurrent.index);
        }
    }

    public static void syncViewSkin(View view, View view2) {
        QMUISkinManager.ViewSkinCurrent viewSkinCurrent = QMUISkinManager.getViewSkinCurrent(view2);
        if (viewSkinCurrent == null || viewSkinCurrent.equals(QMUISkinManager.getViewSkinCurrent(view))) {
            return;
        }
        QMUISkinManager.of(viewSkinCurrent.managerName, view.getContext()).dispatch(view, viewSkinCurrent.index);
    }

    public static void setSkinDefaultProvider(View view, IQMUISkinDefaultAttrProvider iQMUISkinDefaultAttrProvider) {
        view.setTag(R.id.qmui_skin_default_attr_provider, iQMUISkinDefaultAttrProvider);
    }

    public static void setSkinApplyListener(View view, IQMUISkinApplyListener iQMUISkinApplyListener) {
        view.setTag(R.id.qmui_skin_apply_listener, iQMUISkinApplyListener);
    }

    public static IQMUISkinApplyListener getSkinApplyListener(View view) {
        Object tag = view.getTag(R.id.qmui_skin_apply_listener);
        if (tag instanceof IQMUISkinApplyListener) {
            return (IQMUISkinApplyListener) tag;
        }
        return null;
    }

    public static void setIgnoreSkinApply(View view, boolean z) {
        view.setTag(R.id.qmui_skin_ignore_apply, Boolean.valueOf(z));
    }

    public static void setInterceptSkinDispatch(View view, boolean z) {
        view.setTag(R.id.qmui_skin_intercept_dispatch, Boolean.valueOf(z));
    }

    public static void warnRuleNotSupport(View view, String str) {
        QMUILog.w("QMUISkinManager", view.getClass().getSimpleName() + " does't support " + str, new Object[0]);
    }
}
