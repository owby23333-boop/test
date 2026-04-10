package com.youth.banner.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.youth.banner.R;
import com.youth.banner.holder.IViewHolder;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BannerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements IViewHolder<T, VH> {
    protected List<T> mDatas = new ArrayList();
    private int mIncreaseCount = 2;
    private OnBannerListener<T> mOnBannerListener;
    private VH mViewHolder;

    public BannerAdapter(List<T> list) {
        setDatas(list);
    }

    public void setDatas(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mDatas = list;
        notifyDataSetChanged();
    }

    public T getData(int i) {
        return this.mDatas.get(i);
    }

    public T getRealData(int i) {
        return this.mDatas.get(getRealPosition(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH vh, int i) {
        this.mViewHolder = vh;
        final int realPosition = getRealPosition(i);
        final T t = this.mDatas.get(realPosition);
        vh.itemView.setTag(R.id.banner_data_key, t);
        vh.itemView.setTag(R.id.banner_pos_key, Integer.valueOf(realPosition));
        onBindView(vh, this.mDatas.get(realPosition), realPosition, getRealCount());
        if (this.mOnBannerListener != null) {
            vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.youth.banner.adapter.BannerAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m628lambda$onBindViewHolder$0$comyouthbanneradapterBannerAdapter(t, realPosition, view);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$0$com-youth-banner-adapter-BannerAdapter, reason: not valid java name */
    /* synthetic */ void m628lambda$onBindViewHolder$0$comyouthbanneradapterBannerAdapter(Object obj, int i, View view) {
        this.mOnBannerListener.OnBannerClick(obj, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        final VH vhOnCreateHolder = onCreateHolder(viewGroup, i);
        vhOnCreateHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.youth.banner.adapter.BannerAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m629xaad9b058(vhOnCreateHolder, view);
            }
        });
        return vhOnCreateHolder;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: lambda$onCreateViewHolder$1$com-youth-banner-adapter-BannerAdapter, reason: not valid java name */
    /* synthetic */ void m629xaad9b058(RecyclerView.ViewHolder viewHolder, View view) {
        if (this.mOnBannerListener != null) {
            Object tag = viewHolder.itemView.getTag(R.id.banner_data_key);
            this.mOnBannerListener.OnBannerClick((T) tag, ((Integer) viewHolder.itemView.getTag(R.id.banner_pos_key)).intValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getRealCount() > 1 ? getRealCount() + this.mIncreaseCount : getRealCount();
    }

    public int getRealCount() {
        List<T> list = this.mDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getRealPosition(int i) {
        return BannerUtils.getRealPosition(this.mIncreaseCount == 2, i, getRealCount());
    }

    public void setOnBannerListener(OnBannerListener<T> onBannerListener) {
        this.mOnBannerListener = onBannerListener;
    }

    public VH getViewHolder() {
        return this.mViewHolder;
    }

    public void setIncreaseCount(int i) {
        this.mIncreaseCount = i;
    }
}
