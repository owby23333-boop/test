package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0086\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0086\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a7\u0010 \u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010%\u001a7\u0010&\u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010%\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b)\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010+\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010+\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010.\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u0010/\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u00100\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a \u00101\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00102\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00103\u001a\u000204*\u00020\u0002H\u0086\u0002\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00106\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u00106\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u0002\u001a\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u0002\u001a\u0015\u0010;\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\f\u001a\u000f\u0010<\u001a\u00020\n*\u0004\u0018\u00010\nH\u0087\b\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010=\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001aG\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010F\u001a=\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u0006\u0010B\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\bE\u001a4\u0010G\u001a\u00020\r*\u00020\u00022\u0006\u0010H\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010J\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u0002\u001a\u0012\u0010J\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u0002\u001a\u001a\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006\u001a\u0012\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a.\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00020SH\u0087\bø\u0001\u0000\u001a\u001d\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\u0087\b\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001d\u0010[\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\u0087\b\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002\u001a%\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002H\u0087\b\u001a=\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010^\u001a0\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a/\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010P\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\b_\u001a%\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010D\u001a\u00020\u0006H\u0087\b\u001a=\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010a\u001a0\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010c\u001a\u00020\u0002*\u00020\n2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u0012\u0010f\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\n\u0010k\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010k\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\bø\u0001\u0000\u001a\u0016\u0010k\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010k\u001a\u00020\n*\u00020\nH\u0087\b\u001a$\u0010k\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\bø\u0001\u0000\u001a\u0016\u0010k\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010m\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010m\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\bø\u0001\u0000\u001a\u0016\u0010m\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010m\u001a\u00020\n*\u00020\nH\u0087\b\u001a$\u0010m\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\bø\u0001\u0000\u001a\u0016\u0010m\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010n\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010n\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\bø\u0001\u0000\u001a\u0016\u0010n\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010n\u001a\u00020\n*\u00020\nH\u0087\b\u001a$\u0010n\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\bø\u0001\u0000\u001a\u0016\u0010n\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006o"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", com.anythink.expressad.foundation.h.i.f10649g, "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", com.anythink.expressad.foundation.d.c.bT, "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xi = 1, xs = "kotlin/text/StringsKt")
public class StringsKt__StringsKt extends n {
    @NotNull
    public static final IntRange b(@NotNull CharSequence charSequence) {
        return new IntRange(0, charSequence.length() - 1);
    }

    public static final int c(@NotNull CharSequence charSequence) {
        return charSequence.length() - 1;
    }

    @NotNull
    public static final kotlin.sequences.c<String> d(@NotNull CharSequence charSequence) {
        return a(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    @NotNull
    public static final List<String> e(@NotNull CharSequence charSequence) {
        return kotlin.sequences.i.b(d(charSequence));
    }

    @NotNull
    public static CharSequence f(@NotNull CharSequence charSequence) {
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            boolean zA = b.a(charSequence.charAt(!z2 ? i2 : length));
            if (z2) {
                if (!zA) {
                    break;
                }
                length--;
            } else if (zA) {
                i2++;
            } else {
                z2 = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    @NotNull
    public static final String a(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        return charSequence.subSequence(intRange.c().intValue(), intRange.b().intValue() + 1).toString();
    }

    @NotNull
    public static String b(@NotNull String str, @NotNull CharSequence charSequence) {
        return b((CharSequence) str, charSequence, false, 2, (Object) null) ? str.substring(0, str.length() - charSequence.length()) : str;
    }

    @NotNull
    public static String c(@NotNull String str, @NotNull CharSequence charSequence) {
        return a(str, charSequence, charSequence);
    }

    public static /* synthetic */ String a(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return a(str, c2, str2);
    }

    public static /* synthetic */ boolean c(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return c(charSequence, charSequence2, z2);
    }

    @NotNull
    public static final String a(@NotNull String str, char c2, @NotNull String str2) {
        int iB = b((CharSequence) str, c2, 0, false, 6, (Object) null);
        return iB == -1 ? str2 : str.substring(iB + 1, str.length());
    }

    public static /* synthetic */ boolean b(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return b(charSequence, charSequence2, z2);
    }

    public static final boolean c(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z2) {
        if (!z2 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return n.b((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return a(charSequence, 0, charSequence2, 0, charSequence2.length(), z2);
    }

    public static final boolean b(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z2) {
        if (!z2 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return n.a((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return a(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z2);
    }

    @NotNull
    public static String a(@NotNull String str, @NotNull CharSequence charSequence) {
        return c(str, charSequence, false, 2, null) ? str.substring(charSequence.length()) : str;
    }

    @NotNull
    public static final String a(@NotNull String str, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        return (str.length() >= charSequence.length() + charSequence2.length() && c(str, charSequence, false, 2, null) && b((CharSequence) str, charSequence2, false, 2, (Object) null)) ? str.substring(charSequence.length(), str.length() - charSequence2.length()) : str;
    }

    public static final int b(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i2, boolean z2) {
        if (!z2 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(kotlin.collections.g.a(cArr), i2);
        }
        for (int iB = kotlin.ranges.g.b(i2, c(charSequence)); iB >= 0; iB--) {
            char cCharAt = charSequence.charAt(iB);
            int length = cArr.length;
            boolean z3 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (c.a(cArr[i3], cCharAt, z2)) {
                    z3 = true;
                    break;
                }
                i3++;
            }
            if (z3) {
                return iB;
            }
        }
        return -1;
    }

    public static final boolean a(@NotNull CharSequence charSequence, int i2, @NotNull CharSequence charSequence2, int i3, int i4, boolean z2) {
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!c.a(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z2)) {
                return false;
            }
        }
        return true;
    }

    public static final int a(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i2, boolean z2) {
        boolean z3;
        if (!z2 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.g.a(cArr), i2);
        }
        int iA = kotlin.ranges.g.a(i2, 0);
        int iC = c(charSequence);
        if (iA > iC) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iA);
            int length = cArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z3 = false;
                    break;
                }
                if (c.a(cArr[i3], cCharAt, z2)) {
                    z3 = true;
                    break;
                }
                i3++;
            }
            if (z3) {
                return iA;
            }
            if (iA == iC) {
                return -1;
            }
            iA++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, String> b(CharSequence charSequence, Collection<String> collection, int i2, boolean z2, boolean z3) {
        Object next;
        Object next2;
        if (!z2 && collection.size() == 1) {
            String str = (String) kotlin.collections.i.c(collection);
            int iA = !z3 ? a(charSequence, str, i2, false, 4, (Object) null) : b(charSequence, str, i2, false, 4, (Object) null);
            if (iA < 0) {
                return null;
            }
            return kotlin.h.a(Integer.valueOf(iA), str);
        }
        IntProgression intRange = !z3 ? new IntRange(kotlin.ranges.g.a(i2, 0), charSequence.length()) : kotlin.ranges.g.c(kotlin.ranges.g.b(i2, c(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = intRange.getF20969s();
            int last = intRange.getF20970t();
            int iA2 = intRange.getF20971u();
            if (iA2 < 0 ? first >= last : first <= last) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (n.a(str2, 0, (String) charSequence, first, str2.length(), z2)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += iA2;
                    } else {
                        return kotlin.h.a(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = intRange.getF20969s();
            int last2 = intRange.getF20970t();
            int iA3 = intRange.getF20971u();
            if (iA3 < 0 ? first2 >= last2 : first2 <= last2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (a(str4, 0, charSequence, first2, str4.length(), z2)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += iA3;
                    } else {
                        return kotlin.h.a(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2, boolean z3, int i4, Object obj) {
        return a(charSequence, charSequence2, i2, i3, z2, (i4 & 16) != 0 ? false : z3);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2, boolean z3) {
        IntProgression intProgressionC;
        if (!z3) {
            intProgressionC = new IntRange(kotlin.ranges.g.a(i2, 0), kotlin.ranges.g.b(i3, charSequence.length()));
        } else {
            intProgressionC = kotlin.ranges.g.c(kotlin.ranges.g.b(i2, c(charSequence)), kotlin.ranges.g.a(i3, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = intProgressionC.getF20969s();
            int last = intProgressionC.getF20970t();
            int iA = intProgressionC.getF20971u();
            if (iA >= 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (!n.a((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z2)) {
                if (first == last) {
                    return -1;
                }
                first += iA;
            }
            return first;
        }
        int first2 = intProgressionC.getF20969s();
        int last2 = intProgressionC.getF20970t();
        int iA2 = intProgressionC.getF20971u();
        if (iA2 >= 0) {
            if (first2 > last2) {
                return -1;
            }
        } else if (first2 < last2) {
            return -1;
        }
        while (!a(charSequence2, 0, charSequence, first2, charSequence2.length(), z2)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += iA2;
        }
        return first2;
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return a(charSequence, c2, i2, z2);
    }

    public static final int a(@NotNull CharSequence charSequence, char c2, int i2, boolean z2) {
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i2);
        }
        return a(charSequence, new char[]{c2}, i2, z2);
    }

    public static /* synthetic */ int b(CharSequence charSequence, char c2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return b(charSequence, c2, i2, z2);
    }

    public static final int b(@NotNull CharSequence charSequence, char c2, int i2, boolean z2) {
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        return b(charSequence, new char[]{c2}, i2, z2);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return a(charSequence, str, i2, z2);
    }

    public static final int a(@NotNull CharSequence charSequence, @NotNull String str, int i2, boolean z2) {
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        return a(charSequence, (CharSequence) str, i2, charSequence.length(), z2, false, 16, (Object) null);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return b(charSequence, str, i2, z2);
    }

    public static final int b(@NotNull CharSequence charSequence, @NotNull String str, int i2, boolean z2) {
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i2);
        }
        return a(charSequence, (CharSequence) str, i2, 0, z2, true);
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return a(charSequence, charSequence2, z2);
    }

    public static final boolean a(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z2) {
        if (charSequence2 instanceof String) {
            if (a(charSequence, (String) charSequence2, 0, z2, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (a(charSequence, charSequence2, 0, charSequence.length(), z2, false, 16, (Object) null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ kotlin.sequences.c b(CharSequence charSequence, char[] cArr, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return b(charSequence, cArr, z2, i2);
    }

    @NotNull
    public static final kotlin.sequences.c<String> b(@NotNull final CharSequence charSequence, @NotNull char[] cArr, boolean z2, int i2) {
        return kotlin.sequences.i.a(a(charSequence, cArr, 0, z2, i2, 2, (Object) null), new kotlin.jvm.b.l<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.b.l
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke(@NotNull IntRange intRange) {
                return StringsKt__StringsKt.a(charSequence, intRange);
            }
        });
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, char c2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return a(charSequence, c2, z2);
    }

    public static final boolean a(@NotNull CharSequence charSequence, char c2, boolean z2) {
        return a(charSequence, c2, 0, z2, 2, (Object) null) >= 0;
    }

    static /* synthetic */ kotlin.sequences.c a(CharSequence charSequence, char[] cArr, int i2, boolean z2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return a(charSequence, cArr, i2, z2, i3);
    }

    private static final kotlin.sequences.c<IntRange> a(CharSequence charSequence, final char[] cArr, int i2, final boolean z2, int i3) {
        if (i3 >= 0) {
            return new DelimitedRangesSequence(charSequence, i2, i3, new kotlin.jvm.b.p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.b.p
                public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> a(CharSequence charSequence2, Integer num) {
                    return a(charSequence2, num.intValue());
                }

                @Nullable
                public final Pair<Integer, Integer> a(@NotNull CharSequence charSequence2, int i4) {
                    int iA = StringsKt__StringsKt.a(charSequence2, cArr, i4, z2);
                    if (iA < 0) {
                        return null;
                    }
                    return kotlin.h.a(Integer.valueOf(iA), 1);
                }
            });
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    static /* synthetic */ kotlin.sequences.c a(CharSequence charSequence, String[] strArr, int i2, boolean z2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return a(charSequence, strArr, i2, z2, i3);
    }

    private static final kotlin.sequences.c<IntRange> a(CharSequence charSequence, String[] strArr, int i2, final boolean z2, int i3) {
        if (i3 >= 0) {
            final List listA = kotlin.collections.f.a(strArr);
            return new DelimitedRangesSequence(charSequence, i2, i3, new kotlin.jvm.b.p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.b.p
                public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> a(CharSequence charSequence2, Integer num) {
                    return a(charSequence2, num.intValue());
                }

                @Nullable
                public final Pair<Integer, Integer> a(@NotNull CharSequence charSequence2, int i4) {
                    Pair pairB = StringsKt__StringsKt.b(charSequence2, (Collection<String>) listA, i4, z2, false);
                    if (pairB != null) {
                        return kotlin.h.a(pairB.h(), Integer.valueOf(((String) pairB.i()).length()));
                    }
                    return null;
                }
            });
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    public static /* synthetic */ kotlin.sequences.c a(CharSequence charSequence, String[] strArr, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return a(charSequence, strArr, z2, i2);
    }

    @NotNull
    public static final kotlin.sequences.c<String> a(@NotNull final CharSequence charSequence, @NotNull String[] strArr, boolean z2, int i2) {
        return kotlin.sequences.i.a(a(charSequence, strArr, 0, z2, i2, 2, (Object) null), new kotlin.jvm.b.l<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.b.l
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke(@NotNull IntRange intRange) {
                return StringsKt__StringsKt.a(charSequence, intRange);
            }
        });
    }

    public static /* synthetic */ List a(CharSequence charSequence, char[] cArr, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return a(charSequence, cArr, z2, i2);
    }

    @NotNull
    public static final List<String> a(@NotNull CharSequence charSequence, @NotNull char[] cArr, boolean z2, int i2) {
        if (cArr.length == 1) {
            return a(charSequence, String.valueOf(cArr[0]), z2, i2);
        }
        Iterable iterableA = kotlin.sequences.i.a(a(charSequence, cArr, 0, z2, i2, 2, (Object) null));
        ArrayList arrayList = new ArrayList(kotlin.collections.l.a(iterableA, 10));
        Iterator it = iterableA.iterator();
        while (it.hasNext()) {
            arrayList.add(a(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List<String> a(CharSequence charSequence, String str, boolean z2, int i2) {
        int length = 0;
        if (i2 >= 0) {
            int iA = a(charSequence, str, 0, z2);
            if (iA != -1 && i2 != 1) {
                boolean z3 = i2 > 0;
                ArrayList arrayList = new ArrayList(z3 ? kotlin.ranges.g.b(i2, 10) : 10);
                do {
                    arrayList.add(charSequence.subSequence(length, iA).toString());
                    length = str.length() + iA;
                    if (z3 && arrayList.size() == i2 - 1) {
                        break;
                    }
                    iA = a(charSequence, str, length, z2);
                } while (iA != -1);
                arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
                return arrayList;
            }
            return kotlin.collections.j.a(charSequence.toString());
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }
}
