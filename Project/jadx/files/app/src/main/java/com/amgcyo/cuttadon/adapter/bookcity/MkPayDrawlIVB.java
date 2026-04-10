package com.amgcyo.cuttadon.adapter.bookcity;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.api.entity.fission5.BasePlay;
import com.fatcatfat.io.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class MkPayDrawlIVB extends me.drakeet.multitype.b<BasePlay, ViewHolder> {
    private a b;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_wx_1)
        TextView tv_wx_1;

        @BindView(R.id.tv_wx_read5)
        TextView tv_wx_read5;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.tv_wx_1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_wx_1, "field 'tv_wx_1'", TextView.class);
            viewHolder.tv_wx_read5 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_wx_read5, "field 'tv_wx_read5'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.tv_wx_1 = null;
            viewHolder.tv_wx_read5 = null;
        }
    }

    public interface a {
        void onclickListener(BasePlay basePlay);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.paly_coin_item, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull final BasePlay basePlay) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.amgcyo.cuttadon.f.o.b(R.color.color_222222));
        String str = "提现" + (basePlay.getAmount() + "元");
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(foregroundColorSpan, 0, 2, 17);
        spannableString.setSpan(new ForegroundColorSpan(com.amgcyo.cuttadon.f.o.b(R.color.color_ef514a)), 2, str.length(), 17);
        viewHolder.tv_wx_1.setText(spannableString);
        viewHolder.tv_wx_1.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.bookcity.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3042s.a(basePlay, view);
            }
        });
        int read_time = basePlay.getRead_time();
        if (read_time > 0) {
            viewHolder.tv_wx_read5.setText(String.format(Locale.getDefault(), "阅读%d分钟", Integer.valueOf(read_time)));
            viewHolder.tv_wx_read5.setVisibility(0);
        } else {
            viewHolder.tv_wx_read5.setVisibility(8);
        }
    }

    public /* synthetic */ void a(BasePlay basePlay, View view) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.onclickListener(basePlay);
        }
    }

    public void a(a aVar) {
        this.b = aVar;
    }
}
