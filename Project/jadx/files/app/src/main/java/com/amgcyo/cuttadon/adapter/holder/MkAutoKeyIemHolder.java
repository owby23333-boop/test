package com.amgcyo.cuttadon.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.amgcyo.cuttadon.api.entity.other.MkAutoKeyword;
import com.amgcyo.cuttadon.f.o;
import com.fatcatfat.io.R;
import me.jessyan.art.base.c;

/* JADX INFO: loaded from: classes.dex */
public class MkAutoKeyIemHolder extends c<MkAutoKeyword> {

    @BindView(R.id.auto_status)
    View autoStatus;

    @BindView(R.id.ivIconSeach)
    ImageView ivIconSeach;

    @BindView(R.id.tvAutoCompleteItem)
    TextView tvAutoCompleteItem;

    @BindView(R.id.tv_type)
    TextView tv_type;

    public MkAutoKeyIemHolder(View view) {
        super(view);
        ButterKnife.bind(view);
    }

    @Override // me.jessyan.art.base.c
    public void a(@NonNull MkAutoKeyword mkAutoKeyword, int i2) {
        if (mkAutoKeyword.getForm() == 3) {
            this.tvAutoCompleteItem.setText(String.format("%s-%s", mkAutoKeyword.getName(), mkAutoKeyword.getAuthor()));
            this.tv_type.setVisibility(0);
            this.tv_type.setBackgroundResource(R.drawable.border_shape_comic);
            this.tv_type.setTextColor(o.b(R.color.colorPrimary));
            this.tv_type.setText("漫画");
        } else if (mkAutoKeyword.getType() == 1) {
            this.tv_type.setVisibility(0);
            this.tv_type.setText("作者");
            this.tvAutoCompleteItem.setText(String.format("%s", mkAutoKeyword.getName()));
            this.tv_type.setBackgroundResource(R.drawable.border_shape_novel);
            this.tv_type.setTextColor(o.b(R.color.colorPrimary));
        } else {
            this.tvAutoCompleteItem.setText(String.format("%s-%s", mkAutoKeyword.getName(), mkAutoKeyword.getAuthor()));
            this.tv_type.setVisibility(8);
            this.tv_type.setText("");
        }
        if (mkAutoKeyword.getIs_recommend() > 0) {
            this.autoStatus.setVisibility(0);
            this.autoStatus.setBackgroundResource(R.drawable.icon_fire);
        } else {
            this.tvAutoCompleteItem.setTextColor(o.b(R.color.color_ff767575));
            this.autoStatus.setVisibility(8);
        }
    }
}
