package com.kwad.components.ad.reflux;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ad.reflux.a;
import com.kwad.components.core.g.c;
import com.kwad.components.core.g.d;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KsRefluxNativeView extends FrameLayout {
    private RecyclerView nZ;
    private b oa;

    static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        @Nullable
        public final com.kwad.components.ad.reflux.kwai.a fh() {
            View view = this.itemView;
            if (view instanceof com.kwad.components.ad.reflux.kwai.a) {
                return (com.kwad.components.ad.reflux.kwai.a) view;
            }
            return null;
        }
    }

    static class b extends RecyclerView.Adapter {
        private Context mContext;
        private List<com.kwad.components.ad.reflux.a> ob = new ArrayList();
        private d oc;

        public b(Context context) {
            this.mContext = context;
        }

        private static void a(List<com.kwad.components.ad.reflux.a> list, List<com.kwad.components.ad.reflux.a> list2) {
            com.kwad.components.ad.reflux.a aVar;
            int i2;
            int size = list2.size();
            for (int i3 = 0; i3 < size; i3++) {
                list.add(list2.get(i3));
                if (i3 == size - 1) {
                    aVar = new com.kwad.components.ad.reflux.a(null);
                    i2 = -2;
                } else {
                    aVar = new com.kwad.components.ad.reflux.a(null);
                    i2 = -1;
                }
                aVar.N(i2);
                list.add(aVar);
            }
        }

        public final void d(List<com.kwad.components.ad.reflux.a> list) {
            if (list == null) {
                return;
            }
            this.ob.clear();
            a(this.ob, list);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.ob.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final long getItemId(int i2) {
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i2) {
            return this.ob.get(i2).fu();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            com.kwad.components.ad.reflux.a aVar = this.ob.get(i2);
            a aVar2 = (a) viewHolder;
            int itemViewType = aVar2.getItemViewType();
            if (itemViewType == FeedType.FEED_TYPE_UNKNOWN.getType() || itemViewType == FeedType.FEED_TYPE_TEXT_ABOVE.getType() || itemViewType == FeedType.FEED_TYPE_TEXT_LEFT.getType()) {
                if (aVar.fs()) {
                    aVar.fn();
                    aVar.a(new a.InterfaceC0362a() { // from class: com.kwad.components.ad.reflux.KsRefluxNativeView.b.1
                        @Override // com.kwad.components.ad.reflux.a.InterfaceC0362a
                        public final void fi() {
                            try {
                                b.this.notifyDataSetChanged();
                            } catch (IllegalStateException unused) {
                            }
                        }
                    });
                }
                com.kwad.components.ad.reflux.kwai.a aVarFh = aVar2.fh();
                if (aVarFh != null) {
                    aVarFh.a(aVar);
                }
            }
            View view = viewHolder.itemView;
            if (view instanceof com.kwad.components.ad.reflux.kwai.a) {
                final c cVarFm = aVar.fm();
                ((com.kwad.components.ad.reflux.kwai.a) view).setAdClickListener(new b.a() { // from class: com.kwad.components.ad.reflux.KsRefluxNativeView.b.2
                    @Override // com.kwad.components.core.widget.b.a, com.kwad.components.core.widget.b.InterfaceC0422b
                    public final void onAdClicked() {
                        super.onAdClicked();
                        if (b.this.oc != null) {
                            b.this.oc.d(cVarFm);
                        }
                    }

                    @Override // com.kwad.components.core.widget.b.a, com.kwad.components.core.widget.b.InterfaceC0422b
                    public final void onAdShow() {
                        super.onAdShow();
                        if (b.this.oc != null) {
                            b.this.oc.e(cVarFm);
                        }
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            View cVar;
            int i3;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            LayoutInflater layoutInflaterDv = com.kwad.sdk.i.a.dv(viewGroup.getContext());
            if (i2 == FeedType.FEED_TYPE_TEXT_ABOVE.getType()) {
                cVar = new com.kwad.components.ad.reflux.kwai.c(this.mContext);
            } else if (i2 == FeedType.FEED_TYPE_TEXT_LEFT.getType()) {
                cVar = new com.kwad.components.ad.reflux.kwai.b(this.mContext);
            } else {
                if (i2 == -1) {
                    i3 = R.layout.ksad_reflux_card_divider;
                } else if (i2 == -2) {
                    i3 = R.layout.ksad_reflux_native_list_footer;
                } else {
                    cVar = new com.kwad.components.ad.reflux.kwai.c(this.mContext);
                }
                cVar = layoutInflaterDv.inflate(i3, viewGroup, false);
            }
            cVar.setLayoutParams(layoutParams);
            return new a(cVar);
        }

        public final void setInnerAdInteractionListener(d dVar) {
            this.oc = dVar;
        }
    }

    public KsRefluxNativeView(@NonNull Context context) {
        super(context);
        N(context);
    }

    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        N(context);
    }

    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        N(context);
    }

    @RequiresApi(api = 21)
    public KsRefluxNativeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        N(context);
    }

    private void N(@NonNull Context context) {
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_reflux_native, this);
        this.nZ = (RecyclerView) findViewById(R.id.ksad_reflux_native_list);
        this.nZ.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.oa = new b(getContext());
        this.oa.setHasStableIds(true);
        this.nZ.setAdapter(this.oa);
    }

    public final void c(List<com.kwad.components.ad.reflux.a> list) {
        this.oa.d(list);
    }

    public void setInnerAdInteractionListener(d dVar) {
        b bVar = this.oa;
        if (bVar != null) {
            bVar.setInnerAdInteractionListener(dVar);
        }
    }
}
