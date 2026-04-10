package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTDislikeDialogAbstract extends Dialog {
    private View z;

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    @Deprecated
    public void startPersonalizePromptActivity() {
    }

    public TTDislikeDialogAbstract(Context context) {
        super(context);
    }

    public TTDislikeDialogAbstract(Context context, int i) {
        super(context, i);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            View viewInflate = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
            this.z = viewInflate;
            if (viewInflate == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            View view = this.z;
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            setContentView(view, layoutParams);
            z();
        } catch (Exception unused) {
            m.gc("TTDislikeDialogAbstract", "getLayoutId布局文件id可能异常，请检查");
        }
    }

    protected void z() {
        if (this.z == null) {
            return;
        }
        int[] tTDislikeListViewIds = getTTDislikeListViewIds();
        if (tTDislikeListViewIds == null || tTDislikeListViewIds.length <= 0) {
            throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
        }
        for (int i : tTDislikeListViewIds) {
            View viewFindViewById = this.z.findViewById(i);
            if (viewFindViewById == null) {
                throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
            }
            if (!(viewFindViewById instanceof TTDislikeListView)) {
                throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
            }
        }
    }
}
