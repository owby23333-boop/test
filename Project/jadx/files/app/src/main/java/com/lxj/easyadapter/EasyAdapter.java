package com.lxj.easyadapter;

import androidx.exifinterface.media.ExifInterface;
import com.taobao.accs.utl.BaseMonitor;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.lxj.easyadapter.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: EasyAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0006H$¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/lxj/easyadapter/EasyAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/lxj/easyadapter/MultiItemTypeAdapter;", "data", "", "mLayoutId", "", "(Ljava/util/List;I)V", "getMLayoutId", "()I", "setMLayoutId", "(I)V", BaseMonitor.ALARM_POINT_BIND, "", "holder", "Lcom/lxj/easyadapter/ViewHolder;", "t", "position", "(Lcom/lxj/easyadapter/ViewHolder;Ljava/lang/Object;I)V", "easy-adapter_release"}, k = 1, mv = {1, 1, 15})
public abstract class EasyAdapter<T> extends MultiItemTypeAdapter<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17313f;

    /* JADX INFO: renamed from: com.lxj.easyadapter.a$a */
    /* JADX INFO: compiled from: EasyAdapter.kt */
    public static final class a implements b<T> {
        a() {
        }

        @Override // com.lxj.easyadapter.b
        public void a(@NotNull ViewHolder viewHolder, T t2, int i2) {
            EasyAdapter.this.a(viewHolder, t2, i2);
        }

        @Override // com.lxj.easyadapter.b
        public boolean a(T t2, int i2) {
            return true;
        }

        @Override // com.lxj.easyadapter.b
        public int a() {
            return EasyAdapter.this.getF17313f();
        }
    }

    public EasyAdapter(@NotNull List<? extends T> list, int i2) {
        super(list);
        this.f17313f = i2;
        a(new a());
    }

    protected abstract void a(@NotNull ViewHolder viewHolder, T t2, int i2);

    /* JADX INFO: renamed from: e, reason: from getter */
    protected final int getF17313f() {
        return this.f17313f;
    }
}
