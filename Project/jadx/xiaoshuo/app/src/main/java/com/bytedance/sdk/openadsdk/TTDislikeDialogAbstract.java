package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;

/* JADX INFO: loaded from: classes10.dex */
public abstract class TTDislikeDialogAbstract extends Dialog {
    private TTDislikeController bf;
    private View e;

    public TTDislikeDialogAbstract(Context context) {
        super(context);
    }

    public void e() {
        if (this.bf == null || this.e == null) {
            return;
        }
        int[] tTDislikeListViewIds = getTTDislikeListViewIds();
        if (tTDislikeListViewIds == null || tTDislikeListViewIds.length <= 0) {
            throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
        }
        for (int i : tTDislikeListViewIds) {
            View viewFindViewById = this.e.findViewById(i);
            if (viewFindViewById == null) {
                throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
            }
            if (!(viewFindViewById instanceof TTDislikeListView)) {
                throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
            }
            ((TTDislikeListView) viewFindViewById).setDislikeInfo(this.bf);
        }
    }

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            View viewInflate = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
            this.e = viewInflate;
            if (viewInflate == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            View view = this.e;
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            setContentView(view, layoutParams);
            e();
        } catch (Exception unused) {
            Log.e("TTDislikeDialogAbstract", "getLayoutId布局文件id可能异常，请检查");
        }
    }

    public void setDislikeModel(TTDislikeController tTDislikeController) {
        this.bf = tTDislikeController;
        e();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    @Deprecated
    public void startPersonalizePromptActivity() {
    }

    public TTDislikeDialogAbstract(Context context, int i) {
        super(context, i);
    }
}
