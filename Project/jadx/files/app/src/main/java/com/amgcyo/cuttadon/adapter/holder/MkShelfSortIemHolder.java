package com.amgcyo.cuttadon.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import com.amgcyo.cuttadon.api.entity.other.ShelfSortBean;
import com.fatcatfat.io.R;
import me.jessyan.art.base.c;

/* JADX INFO: loaded from: classes.dex */
public class MkShelfSortIemHolder extends c<ShelfSortBean> {

    @BindView(R.id.item_text)
    TextView itemText;

    @BindView(R.id.iv_selected)
    ImageView ivSelected;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f3077u;

    public MkShelfSortIemHolder(View view, String str) {
        super(view);
        this.f3077u = str;
    }

    @Override // me.jessyan.art.base.c
    public void a(@NonNull ShelfSortBean shelfSortBean, int i2) {
        this.itemText.setText(shelfSortBean.getTitle());
        if (shelfSortBean.getTitle_key().equals(this.f3077u)) {
            this.ivSelected.setVisibility(0);
        } else {
            this.ivSelected.setVisibility(8);
        }
    }
}
