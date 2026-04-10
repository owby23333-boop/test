package com.amgcyo.cuttadon.adapter.other;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.api.entity.comment.CommentReprotType;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ReportTypeAdapter extends me.jessyan.art.base.d<CommentReprotType> {

    public class DaoliuMethodIemHolder extends me.jessyan.art.base.c<CommentReprotType> {

        @BindView(R.id.item_text)
        TextView itemText;

        @BindView(R.id.iv_selected)
        ImageView ivSelected;

        DaoliuMethodIemHolder(ReportTypeAdapter reportTypeAdapter, View view) {
            super(view);
        }

        @Override // me.jessyan.art.base.c
        public void a(@NonNull CommentReprotType commentReprotType, int i2) {
            this.itemText.setText(commentReprotType.getReport_content());
            this.ivSelected.setVisibility(8);
        }
    }

    public class DaoliuMethodIemHolder_ViewBinding implements Unbinder {
        private DaoliuMethodIemHolder a;

        @UiThread
        public DaoliuMethodIemHolder_ViewBinding(DaoliuMethodIemHolder daoliuMethodIemHolder, View view) {
            this.a = daoliuMethodIemHolder;
            daoliuMethodIemHolder.itemText = (TextView) Utils.findRequiredViewAsType(view, R.id.item_text, "field 'itemText'", TextView.class);
            daoliuMethodIemHolder.ivSelected = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_selected, "field 'ivSelected'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            DaoliuMethodIemHolder daoliuMethodIemHolder = this.a;
            if (daoliuMethodIemHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            daoliuMethodIemHolder.itemText = null;
            daoliuMethodIemHolder.ivSelected = null;
        }
    }

    public ReportTypeAdapter(List<CommentReprotType> list) {
        super(list);
    }

    @Override // me.jessyan.art.base.d
    public int a(int i2) {
        return R.layout.item_shelf_sort;
    }

    @Override // me.jessyan.art.base.d
    @NonNull
    public me.jessyan.art.base.c<CommentReprotType> a(@NonNull View view, int i2) {
        return new DaoliuMethodIemHolder(this, view);
    }
}
