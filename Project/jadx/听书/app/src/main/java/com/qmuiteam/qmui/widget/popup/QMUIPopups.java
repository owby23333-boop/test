package com.qmuiteam.qmui.widget.popup;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.qmuiteam.qmui.widget.QMUIWrapContentListView;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIPopups {
    public static QMUIPopup popup(Context context) {
        return new QMUIPopup(context, -2, -2);
    }

    public static QMUIPopup popup(Context context, int i) {
        return new QMUIPopup(context, i, -2);
    }

    public static QMUIPopup popup(Context context, int i, int i2) {
        return new QMUIPopup(context, i, i2);
    }

    public static QMUIPopup listPopup(Context context, int i, int i2, BaseAdapter baseAdapter, AdapterView.OnItemClickListener onItemClickListener) {
        QMUIWrapContentListView qMUIWrapContentListView = new QMUIWrapContentListView(context, i2);
        qMUIWrapContentListView.setAdapter((ListAdapter) baseAdapter);
        qMUIWrapContentListView.setVerticalScrollBarEnabled(false);
        qMUIWrapContentListView.setOnItemClickListener(onItemClickListener);
        qMUIWrapContentListView.setDivider(null);
        return popup(context, i).view(qMUIWrapContentListView);
    }

    public static QMUIFullScreenPopup fullScreenPopup(Context context) {
        return new QMUIFullScreenPopup(context);
    }

    public static QMUIQuickAction quickAction(Context context, int i, int i2) {
        return new QMUIQuickAction(context, -2, i2).actionWidth(i).actionHeight(i2);
    }
}
