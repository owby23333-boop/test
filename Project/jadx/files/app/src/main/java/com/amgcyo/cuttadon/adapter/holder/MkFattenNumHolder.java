package com.amgcyo.cuttadon.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import com.amgcyo.cuttadon.api.entity.other.FattenChapterNum;
import com.fatcatfat.io.R;
import me.jessyan.art.base.c;

/* JADX INFO: loaded from: classes.dex */
public class MkFattenNumHolder extends c<FattenChapterNum> {

    @BindView(R.id.item_text)
    TextView itemText;

    @BindView(R.id.iv_selected)
    ImageView ivSelected;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f3076u;

    public MkFattenNumHolder(View view, int i2) {
        super(view);
        this.f3076u = i2;
    }

    @Override // me.jessyan.art.base.c
    public void a(@NonNull FattenChapterNum fattenChapterNum, int i2) {
        this.itemText.setText(fattenChapterNum.getChapterTitle());
        if (fattenChapterNum.getChapterNum() == this.f3076u) {
            this.ivSelected.setVisibility(0);
        } else {
            this.ivSelected.setVisibility(8);
        }
    }
}
