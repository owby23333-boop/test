package com.bytedance.sdk.openadsdk.core.dislike.z;

import android.app.Dialog;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.ls.dl.g.m;
import java.lang.reflect.Field;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final com.bytedance.sdk.openadsdk.core.dislike.dl.g z;

    public g(com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar) {
        this.z = gVar;
    }

    public void z(m mVar) {
        if (this.z == null || mVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.z.z.z().z(this.z, mVar);
    }

    public static final void z(com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar, Dialog dialog, Integer[] numArr) {
        if (numArr == null || numArr.length <= 0) {
            return;
        }
        g gVar2 = new g(gVar);
        for (Integer num : numArr) {
            View viewFindViewById = dialog.findViewById(num.intValue());
            if (viewFindViewById instanceof ListView) {
                ListView listView = (ListView) viewFindViewById;
                listView.setOnItemClickListener(new z(listView.getOnItemClickListener(), gVar2));
            }
        }
    }

    private static final class z implements AdapterView.OnItemClickListener {
        private final AdapterView.OnItemClickListener g;
        private final g z;

        private z(AdapterView.OnItemClickListener onItemClickListener, g gVar) {
            this.z = gVar;
            this.g = onItemClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Adapter adapter = adapterView.getAdapter();
            if (adapter != null) {
                Object item = adapter.getItem(i);
                if (item instanceof Function) {
                    this.z.z(z(item));
                }
            }
            AdapterView.OnItemClickListener onItemClickListener = this.g;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
        }

        private com.bytedance.sdk.openadsdk.core.dislike.dl.dl z(Object obj) {
            if (obj == null) {
                return null;
            }
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                try {
                    declaredFields[i].setAccessible(true);
                    Object obj2 = declaredFields[i].get(obj);
                    if (obj2 instanceof m) {
                        return new com.bytedance.sdk.openadsdk.core.dislike.dl.dl(((m) obj2).z(), ((m) obj2).g());
                    }
                    continue;
                } catch (Exception e) {
                    wp.z(e);
                }
            }
            return null;
        }
    }
}
