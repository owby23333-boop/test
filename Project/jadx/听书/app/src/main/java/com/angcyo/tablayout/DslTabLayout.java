package com.angcyo.tablayout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.d;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DslTabLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0002·\u0002B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010Ñ\u0001\u001a\u00030Ò\u00012\u0007\u0010Ó\u0001\u001a\u00020\b2\u0007\u0010Ô\u0001\u001a\u00020\bJ\u0007\u0010Õ\u0001\u001a\u00020\bJ\u0007\u0010Ö\u0001\u001a\u00020\bJ\b\u0010×\u0001\u001a\u00030Ò\u0001J\u0012\u0010Ø\u0001\u001a\u00030Ò\u00012\b\u0010\u0098\u0001\u001a\u00030Ù\u0001J\u001a\u0010Ú\u0001\u001a\u00030Ò\u00012\u0007\u0010\u008c\u0001\u001a\u00020\b2\u0007\u0010Û\u0001\u001a\u00020BJ\n\u0010Ü\u0001\u001a\u00030Ò\u0001H\u0016J(\u0010Ý\u0001\u001a\u00030Ò\u00012\u001e\b\u0002\u0010Þ\u0001\u001a\u0017\u0012\u0005\u0012\u00030Ë\u0001\u0012\u0005\u0012\u00030Ò\u00010ß\u0001¢\u0006\u0003\bà\u0001J\u0014\u0010á\u0001\u001a\u00030Ò\u00012\b\u0010â\u0001\u001a\u00030ã\u0001H\u0016J&\u0010ä\u0001\u001a\u00020B2\b\u0010â\u0001\u001a\u00030ã\u00012\u0007\u0010\u0089\u0001\u001a\u00020>2\b\u0010å\u0001\u001a\u00030Æ\u0001H\u0014J\n\u0010æ\u0001\u001a\u00030ç\u0001H\u0014J\u0015\u0010è\u0001\u001a\u00030ç\u00012\t\u0010é\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010è\u0001\u001a\u00030ç\u00012\n\u0010ê\u0001\u001a\u0005\u0018\u00010ç\u0001H\u0014J\u0011\u0010ë\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u008c\u0001\u001a\u00020\bJ\u0007\u0010ì\u0001\u001a\u00020BJ5\u0010í\u0001\u001a\u00030Ò\u00012\u0007\u0010î\u0001\u001a\u00020B2\u0007\u0010ï\u0001\u001a\u00020\b2\u0007\u0010ð\u0001\u001a\u00020\b2\u0007\u0010ñ\u0001\u001a\u00020\b2\u0007\u0010ò\u0001\u001a\u00020\bJ5\u0010ó\u0001\u001a\u00030Ò\u00012\u0007\u0010î\u0001\u001a\u00020B2\u0007\u0010ï\u0001\u001a\u00020\b2\u0007\u0010ð\u0001\u001a\u00020\b2\u0007\u0010ñ\u0001\u001a\u00020\b2\u0007\u0010ò\u0001\u001a\u00020\bJ\u001a\u0010ô\u0001\u001a\u00030Ò\u00012\u0007\u0010õ\u0001\u001a\u00020\b2\u0007\u0010ö\u0001\u001a\u00020\bJ\u001a\u0010÷\u0001\u001a\u00030Ò\u00012\u0007\u0010õ\u0001\u001a\u00020\b2\u0007\u0010ö\u0001\u001a\u00020\bJ\u0099\u0001\u0010ø\u0001\u001a\u00030Ò\u00012\u001e\b\u0002\u0010Þ\u0001\u001a\u0017\u0012\u0005\u0012\u00030Ë\u0001\u0012\u0005\u0012\u00030Ò\u00010ß\u0001¢\u0006\u0003\bà\u00012o\u0010ù\u0001\u001aj\u0012\u0016\u0012\u00140\b¢\u0006\u000f\b\u0087\u0001\u0012\n\b\u0088\u0001\u0012\u0005\b\b(Ó\u0001\u0012\u0016\u0012\u00140\b¢\u0006\u000f\b\u0087\u0001\u0012\n\b\u0088\u0001\u0012\u0005\b\b(Ô\u0001\u0012\u0016\u0012\u00140B¢\u0006\u000f\b\u0087\u0001\u0012\n\b\u0088\u0001\u0012\u0005\b\b(û\u0001\u0012\u0016\u0012\u00140B¢\u0006\u000f\b\u0087\u0001\u0012\n\b\u0088\u0001\u0012\u0005\b\b(ü\u0001\u0012\u0005\u0012\u00030Ò\u00010ú\u0001J\n\u0010ý\u0001\u001a\u00030Ò\u0001H\u0014J\n\u0010þ\u0001\u001a\u00030Ò\u0001H\u0014J\u0014\u0010ÿ\u0001\u001a\u00030Ò\u00012\b\u0010â\u0001\u001a\u00030ã\u0001H\u0014J\n\u0010\u0080\u0002\u001a\u00030Ò\u0001H\u0014J\u0014\u0010\u0081\u0002\u001a\u00030Ò\u00012\b\u0010\u0082\u0002\u001a\u00030Ù\u0001H\u0016J\u0013\u0010\u0083\u0002\u001a\u00020B2\b\u0010\u0084\u0002\u001a\u00030\u0085\u0002H\u0016J7\u0010\u0086\u0002\u001a\u00030Ò\u00012\u0007\u0010î\u0001\u001a\u00020B2\u0007\u0010ï\u0001\u001a\u00020\b2\u0007\u0010ð\u0001\u001a\u00020\b2\u0007\u0010ñ\u0001\u001a\u00020\b2\u0007\u0010ò\u0001\u001a\u00020\bH\u0014J\u001c\u0010\u0087\u0002\u001a\u00030Ò\u00012\u0007\u0010õ\u0001\u001a\u00020\b2\u0007\u0010ö\u0001\u001a\u00020\bH\u0014J\u0011\u0010\u0088\u0002\u001a\u00030Ò\u00012\u0007\u0010\u0089\u0002\u001a\u00020\bJ$\u0010\u008a\u0002\u001a\u00030Ò\u00012\u0007\u0010\u008b\u0002\u001a\u00020\b2\b\u0010\u008c\u0002\u001a\u00030Ù\u00012\u0007\u0010\u008d\u0002\u001a\u00020\bJ\u0011\u0010\u008e\u0002\u001a\u00030Ò\u00012\u0007\u0010\u008b\u0002\u001a\u00020\bJ\u0016\u0010\u008f\u0002\u001a\u00030Ò\u00012\n\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u0090\u0002H\u0014J\u0013\u0010\u0091\u0002\u001a\u00030Ò\u00012\u0007\u0010\u0092\u0002\u001a\u00020\bH\u0016J\f\u0010\u0093\u0002\u001a\u0005\u0018\u00010\u0090\u0002H\u0014J\u0013\u0010\u0094\u0002\u001a\u00020B2\b\u0010\u0095\u0002\u001a\u00030Ù\u0001H\u0016J.\u0010\u0096\u0002\u001a\u00030Ò\u00012\u0007\u0010\u0097\u0002\u001a\u00020\b2\u0007\u0010\u0098\u0002\u001a\u00020\b2\u0007\u0010\u0099\u0002\u001a\u00020\b2\u0007\u0010\u009a\u0002\u001a\u00020\bH\u0014J\u0013\u0010\u009b\u0002\u001a\u00020B2\b\u0010\u009c\u0002\u001a\u00030\u0085\u0002H\u0016J\u0015\u0010\u009d\u0002\u001a\u00030Ò\u00012\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010>H\u0016J\u0015\u0010\u009e\u0002\u001a\u00030Ò\u00012\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010>H\u0016J\b\u0010\u009f\u0002\u001a\u00030Ò\u0001J\u001c\u0010 \u0002\u001a\u00030Ò\u00012\u0007\u0010¡\u0002\u001a\u00020\b2\u0007\u0010¢\u0002\u001a\u00020\bH\u0016J'\u0010£\u0002\u001a\u00030Ò\u00012\u0007\u0010\u008c\u0001\u001a\u00020\b2\t\b\u0002\u0010¤\u0002\u001a\u00020B2\t\b\u0002\u0010ü\u0001\u001a\u00020BJ4\u0010Ï\u0001\u001a\u00030Ò\u00012\n\b\u0002\u0010Þ\u0001\u001a\u00030Ë\u00012\u001e\b\u0002\u0010¥\u0002\u001a\u0017\u0012\u0005\u0012\u00030Ë\u0001\u0012\u0005\u0012\u00030Ò\u00010ß\u0001¢\u0006\u0003\bà\u0001J\u0011\u0010¦\u0002\u001a\u00030Ò\u00012\u0007\u0010§\u0002\u001a\u000201J#\u0010¨\u0002\u001a\u00030Ò\u00012\u0007\u0010\u0082\u0002\u001a\u00020\b2\u0007\u0010©\u0002\u001a\u00020\b2\u0007\u0010ª\u0002\u001a\u00020\bJ\u0011\u0010«\u0002\u001a\u00030Ò\u00012\u0007\u0010¬\u0002\u001a\u00020\bJ\u0014\u0010\u00ad\u0002\u001a\u00030Ò\u00012\n\u0010®\u0002\u001a\u0005\u0018\u00010¯\u0002J/\u0010°\u0002\u001a\u00030Ò\u00012\u0007\u0010\u008c\u0001\u001a\u00020\b2\u001c\u0010Þ\u0001\u001a\u0017\u0012\u0005\u0012\u00030\u008d\u0001\u0012\u0005\u0012\u00030Ò\u00010ß\u0001¢\u0006\u0003\bà\u0001J\u001d\u0010°\u0002\u001a\u00030Ò\u00012\u0007\u0010\u008c\u0001\u001a\u00020\b2\n\u0010±\u0002\u001a\u0005\u0018\u00010¯\u0002J\n\u0010²\u0002\u001a\u00030Ò\u0001H\u0016J\u0013\u0010³\u0002\u001a\u00020B2\b\u0010´\u0002\u001a\u00030¨\u0001H\u0014J\u001e\u0010µ\u0002\u001a\u00030Ò\u0001*\u00030ã\u00012\u000f\u0010ù\u0001\u001a\n\u0012\u0005\u0012\u00030Ò\u00010¶\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\u001b\u0010\u001f\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b&\u0010'R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\n\"\u0004\b/\u0010\fR\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\n\"\u0004\b8\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010;\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b<\u0010\nR\u0013\u0010=\u001a\u0004\u0018\u00010>8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR\u001a\u0010J\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010D\"\u0004\bL\u0010FR\u001a\u0010M\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010D\"\u0004\bO\u0010FR\u001a\u0010P\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010D\"\u0004\bR\u0010FR\u001b\u0010S\u001a\u00020T8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u0012\u001a\u0004\bU\u0010VR\u0011\u0010X\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\bX\u0010DR\u001a\u0010Y\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010D\"\u0004\bZ\u0010FR\u0011\u0010[\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\b[\u0010DR\u001a\u0010\\\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010D\"\u0004\b^\u0010FR\u001a\u0010_\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\n\"\u0004\ba\u0010\fR\u001a\u0010b\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010D\"\u0004\bd\u0010FR\u001c\u0010e\u001a\u0004\u0018\u00010fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010D\"\u0004\bm\u0010FR\u001a\u0010n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\n\"\u0004\bp\u0010\fR\u001a\u0010q\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010D\"\u0004\bs\u0010FR\u001a\u0010t\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010D\"\u0004\bv\u0010FR\u0011\u0010w\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bx\u0010\nR\u0011\u0010y\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bz\u0010\nR\u0011\u0010{\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b|\u0010\nR\u0011\u0010}\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b~\u0010\nR\u0012\u0010\u007f\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\nR\u0013\u0010\u0081\u0001\u001a\u00020\b8F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\nR\u0013\u0010\u0083\u0001\u001a\u00020B8F¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010DRr\u0010\u0085\u0001\u001aU\u0012\u0016\u0012\u00140>¢\u0006\u000f\b\u0087\u0001\u0012\n\b\u0088\u0001\u0012\u0005\b\b(\u0089\u0001\u0012\u0017\u0012\u00150\u008a\u0001¢\u0006\u000f\b\u0087\u0001\u0012\n\b\u0088\u0001\u0012\u0005\b\b(\u008b\u0001\u0012\u0016\u0012\u00140\b¢\u0006\u000f\b\u0087\u0001\u0012\n\b\u0088\u0001\u0012\u0005\b\b(\u008c\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u008d\u00010\u0086\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001d\u0010\u0092\u0001\u001a\u00020\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\n\"\u0005\b\u0094\u0001\u0010\fR\u001d\u0010\u0095\u0001\u001a\u00020\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010\n\"\u0005\b\u0097\u0001\u0010\fR0\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u008a\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\"\u0010\u009d\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0005\u0012\u00030\u008d\u00010\u009e\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001R0\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010¡\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R\"\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R\u001d\u0010\u00ad\u0001\u001a\u00020\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\n\"\u0005\b¯\u0001\u0010\fR0\u0010±\u0001\u001a\u0005\u0018\u00010°\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010°\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R\u001d\u0010¶\u0001\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010D\"\u0005\b¸\u0001\u0010FR0\u0010º\u0001\u001a\u0005\u0018\u00010¹\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010¹\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R,\u0010À\u0001\u001a\u00030¿\u00012\b\u0010\u0098\u0001\u001a\u00030¿\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R \u0010Å\u0001\u001a\u00030Æ\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R0\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010Ë\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001¨\u0006¸\u0002"}, d2 = {"Lcom/angcyo/tablayout/DslTabLayout;", "Landroid/view/ViewGroup;", d.R, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_childAllWidthSum", "", "get_childAllWidthSum", "()I", "set_childAllWidthSum", "(I)V", "_gestureDetector", "Landroidx/core/view/GestureDetectorCompat;", "get_gestureDetector", "()Landroidx/core/view/GestureDetectorCompat;", "_gestureDetector$delegate", "Lkotlin/Lazy;", "_layoutDirection", "get_layoutDirection", "set_layoutDirection", "_maxConvexHeight", "get_maxConvexHeight", "set_maxConvexHeight", "_maxFlingVelocity", "get_maxFlingVelocity", "set_maxFlingVelocity", "_minFlingVelocity", "get_minFlingVelocity", "set_minFlingVelocity", "_overScroller", "Landroid/widget/OverScroller;", "get_overScroller", "()Landroid/widget/OverScroller;", "_overScroller$delegate", "_scrollAnimator", "Landroid/animation/ValueAnimator;", "get_scrollAnimator", "()Landroid/animation/ValueAnimator;", "_scrollAnimator$delegate", "_tempRect", "Landroid/graphics/Rect;", "get_tempRect", "()Landroid/graphics/Rect;", "_touchSlop", "get_touchSlop", "set_touchSlop", "_viewPagerDelegate", "Lcom/angcyo/tablayout/ViewPagerDelegate;", "get_viewPagerDelegate", "()Lcom/angcyo/tablayout/ViewPagerDelegate;", "set_viewPagerDelegate", "(Lcom/angcyo/tablayout/ViewPagerDelegate;)V", "_viewPagerScrollState", "get_viewPagerScrollState", "set_viewPagerScrollState", "getAttributeSet", "()Landroid/util/AttributeSet;", "currentItemIndex", "getCurrentItemIndex", "currentItemView", "Landroid/view/View;", "getCurrentItemView", "()Landroid/view/View;", "drawBadge", "", "getDrawBadge", "()Z", "setDrawBadge", "(Z)V", "drawBorder", "getDrawBorder", "setDrawBorder", "drawDivider", "getDrawDivider", "setDrawDivider", "drawHighlight", "getDrawHighlight", "setDrawHighlight", "drawIndicator", "getDrawIndicator", "setDrawIndicator", "dslSelector", "Lcom/angcyo/tablayout/DslSelector;", "getDslSelector", "()Lcom/angcyo/tablayout/DslSelector;", "dslSelector$delegate", "isAnimatorStart", "isFirstLayout", "setFirstLayout", "isLayoutRtl", "itemAutoEquWidth", "getItemAutoEquWidth", "setItemAutoEquWidth", "itemDefaultHeight", "getItemDefaultHeight", "setItemDefaultHeight", "itemEnableSelector", "getItemEnableSelector", "setItemEnableSelector", "itemEquWidthCountRange", "Lkotlin/ranges/IntRange;", "getItemEquWidthCountRange", "()Lkotlin/ranges/IntRange;", "setItemEquWidthCountRange", "(Lkotlin/ranges/IntRange;)V", "itemIsEquWidth", "getItemIsEquWidth", "setItemIsEquWidth", "itemWidth", "getItemWidth", "setItemWidth", "layoutScrollAnim", "getLayoutScrollAnim", "setLayoutScrollAnim", "layoutScrollToTarget", "getLayoutScrollToTarget", "setLayoutScrollToTarget", "maxHeight", "getMaxHeight", "maxScrollX", "getMaxScrollX", "maxScrollY", "getMaxScrollY", "maxWidth", "getMaxWidth", "minScrollX", "getMinScrollX", "minScrollY", "getMinScrollY", "needScroll", "getNeedScroll", "onTabBadgeConfig", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "child", "Lcom/angcyo/tablayout/DslTabBadge;", "tabBadge", "index", "Lcom/angcyo/tablayout/TabBadgeConfig;", "getOnTabBadgeConfig", "()Lkotlin/jvm/functions/Function3;", "setOnTabBadgeConfig", "(Lkotlin/jvm/functions/Function3;)V", "orientation", "getOrientation", "setOrientation", "scrollAnimDuration", "getScrollAnimDuration", "setScrollAnimDuration", "value", "getTabBadge", "()Lcom/angcyo/tablayout/DslTabBadge;", "setTabBadge", "(Lcom/angcyo/tablayout/DslTabBadge;)V", "tabBadgeConfigMap", "", "getTabBadgeConfigMap", "()Ljava/util/Map;", "Lcom/angcyo/tablayout/DslTabBorder;", "tabBorder", "getTabBorder", "()Lcom/angcyo/tablayout/DslTabBorder;", "setTabBorder", "(Lcom/angcyo/tablayout/DslTabBorder;)V", "tabConvexBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getTabConvexBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setTabConvexBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "tabDefaultIndex", "getTabDefaultIndex", "setTabDefaultIndex", "Lcom/angcyo/tablayout/DslTabDivider;", "tabDivider", "getTabDivider", "()Lcom/angcyo/tablayout/DslTabDivider;", "setTabDivider", "(Lcom/angcyo/tablayout/DslTabDivider;)V", "tabEnableSelectorMode", "getTabEnableSelectorMode", "setTabEnableSelectorMode", "Lcom/angcyo/tablayout/DslTabHighlight;", "tabHighlight", "getTabHighlight", "()Lcom/angcyo/tablayout/DslTabHighlight;", "setTabHighlight", "(Lcom/angcyo/tablayout/DslTabHighlight;)V", "Lcom/angcyo/tablayout/DslTabIndicator;", "tabIndicator", "getTabIndicator", "()Lcom/angcyo/tablayout/DslTabIndicator;", "setTabIndicator", "(Lcom/angcyo/tablayout/DslTabIndicator;)V", "tabIndicatorAnimationDuration", "", "getTabIndicatorAnimationDuration", "()J", "setTabIndicatorAnimationDuration", "(J)V", "Lcom/angcyo/tablayout/DslTabLayoutConfig;", "tabLayoutConfig", "getTabLayoutConfig", "()Lcom/angcyo/tablayout/DslTabLayoutConfig;", "setTabLayoutConfig", "(Lcom/angcyo/tablayout/DslTabLayoutConfig;)V", "_animateToItem", "", "fromIndex", "toIndex", "_getViewTargetX", "_getViewTargetY", "_onAnimateEnd", "_onAnimateValue", "", "_scrollToTarget", "scrollAnim", "computeScroll", "configTabLayoutConfig", "config", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", MediationConstant.RIT_TYPE_DRAW, "canvas", "Landroid/graphics/Canvas;", "drawChild", "drawingTime", "generateDefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "attrs", "p", "getBadgeConfig", "isHorizontal", "layoutHorizontal", "changed", "l", an.aI, "r", t.l, "layoutVertical", "measureHorizontal", "widthMeasureSpec", "heightMeasureSpec", "measureVertical", "observeIndexChange", "action", "Lkotlin/Function4;", "reselect", "fromUser", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "onFinishInflate", "onFlingChange", "velocity", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayout", "onMeasure", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "positionOffsetPixels", "onPageSelected", "onRestoreInstanceState", "Landroid/os/Parcelable;", "onRtlPropertiesChanged", "layoutDirection", "onSaveInstanceState", "onScrollChange", "distance", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "onViewAdded", "onViewRemoved", "restoreScroll", "scrollTo", "x", "y", "setCurrentItem", "notify", "doIt", "setupViewPager", "viewPagerDelegate", "startFling", "min", "max", "startScroll", "dv", "updateItemEquWidthCountRange", "range", "", "updateTabBadge", "badgeText", "updateTabLayout", "verifyDrawable", "who", "holdLocation", "Lkotlin/Function0;", "LayoutParams", "TabLayout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class DslTabLayout extends ViewGroup {
    private int _childAllWidthSum;

    /* JADX INFO: renamed from: _gestureDetector$delegate, reason: from kotlin metadata */
    private final Lazy _gestureDetector;
    private int _layoutDirection;
    private int _maxConvexHeight;
    private int _maxFlingVelocity;
    private int _minFlingVelocity;

    /* JADX INFO: renamed from: _overScroller$delegate, reason: from kotlin metadata */
    private final Lazy _overScroller;

    /* JADX INFO: renamed from: _scrollAnimator$delegate, reason: from kotlin metadata */
    private final Lazy _scrollAnimator;
    private final Rect _tempRect;
    private int _touchSlop;
    private ViewPagerDelegate _viewPagerDelegate;
    private int _viewPagerScrollState;
    private final AttributeSet attributeSet;
    private boolean drawBadge;
    private boolean drawBorder;
    private boolean drawDivider;
    private boolean drawHighlight;
    private boolean drawIndicator;

    /* JADX INFO: renamed from: dslSelector$delegate, reason: from kotlin metadata */
    private final Lazy dslSelector;
    private boolean isFirstLayout;
    private boolean itemAutoEquWidth;
    private int itemDefaultHeight;
    private boolean itemEnableSelector;
    private IntRange itemEquWidthCountRange;
    private boolean itemIsEquWidth;
    private int itemWidth;
    private boolean layoutScrollAnim;
    private boolean layoutScrollToTarget;
    private Function3<? super View, ? super DslTabBadge, ? super Integer, TabBadgeConfig> onTabBadgeConfig;
    private int orientation;
    private int scrollAnimDuration;
    private DslTabBadge tabBadge;
    private final Map<Integer, TabBadgeConfig> tabBadgeConfigMap;
    private DslTabBorder tabBorder;
    private Drawable tabConvexBackgroundDrawable;
    private int tabDefaultIndex;
    private DslTabDivider tabDivider;
    private boolean tabEnableSelectorMode;
    private DslTabHighlight tabHighlight;
    private DslTabIndicator tabIndicator;
    private long tabIndicatorAnimationDuration;
    private DslTabLayoutConfig tabLayoutConfig;

    public /* synthetic */ DslTabLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final AttributeSet getAttributeSet() {
        return this.attributeSet;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DslTabLayout(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.attributeSet = attributeSet;
        this.itemDefaultHeight = LibExKt.getDpi(this) * 40;
        this.itemEnableSelector = true;
        this.itemWidth = -3;
        this.drawIndicator = true;
        this.tabIndicator = new DslTabIndicator(this);
        this.tabIndicatorAnimationDuration = 240L;
        this.tabBadgeConfigMap = new LinkedHashMap();
        this.onTabBadgeConfig = new Function3<View, DslTabBadge, Integer, TabBadgeConfig>() { // from class: com.angcyo.tablayout.DslTabLayout$onTabBadgeConfig$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ TabBadgeConfig invoke(View view, DslTabBadge dslTabBadge, Integer num) {
                return invoke(view, dslTabBadge, num.intValue());
            }

            public final TabBadgeConfig invoke(View view, DslTabBadge tabBadge, int i) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(tabBadge, "tabBadge");
                TabBadgeConfig badgeConfig = this.this$0.getBadgeConfig(i);
                if (!this.this$0.isInEditMode()) {
                    tabBadge.updateBadgeConfig(badgeConfig);
                }
                return badgeConfig;
            }
        };
        this.scrollAnimDuration = 250;
        this.isFirstLayout = true;
        this._tempRect = new Rect();
        this.dslSelector = LazyKt.lazy(new Function0<DslSelector>() { // from class: com.angcyo.tablayout.DslTabLayout$dslSelector$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DslSelector invoke() {
                DslSelector dslSelector = new DslSelector();
                DslTabLayout dslTabLayout = this.this$0;
                final DslTabLayout dslTabLayout2 = this.this$0;
                return dslSelector.install(dslTabLayout, new Function1<DslSelectorConfig, Unit>() { // from class: com.angcyo.tablayout.DslTabLayout$dslSelector$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DslSelectorConfig dslSelectorConfig) {
                        invoke2(dslSelectorConfig);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DslSelectorConfig install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        final DslTabLayout dslTabLayout3 = dslTabLayout2;
                        install.setOnStyleItemView(new Function3<View, Integer, Boolean, Unit>() { // from class: com.angcyo.tablayout.DslTabLayout.dslSelector.2.1.1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Boolean bool) {
                                invoke(view, num.intValue(), bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(View itemView, int i, boolean z) {
                                Function3<View, Integer, Boolean, Unit> onStyleItemView;
                                Intrinsics.checkNotNullParameter(itemView, "itemView");
                                DslTabLayoutConfig tabLayoutConfig = dslTabLayout3.getTabLayoutConfig();
                                if (tabLayoutConfig == null || (onStyleItemView = tabLayoutConfig.getOnStyleItemView()) == null) {
                                    return;
                                }
                                onStyleItemView.invoke(itemView, Integer.valueOf(i), Boolean.valueOf(z));
                            }
                        });
                        final DslTabLayout dslTabLayout4 = dslTabLayout2;
                        install.setOnSelectItemView(new Function4<View, Integer, Boolean, Boolean, Boolean>() { // from class: com.angcyo.tablayout.DslTabLayout.dslSelector.2.1.2
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num, Boolean bool, Boolean bool2) {
                                return invoke(view, num.intValue(), bool.booleanValue(), bool2.booleanValue());
                            }

                            public final Boolean invoke(View itemView, int i, boolean z, boolean z2) {
                                Function4<View, Integer, Boolean, Boolean, Boolean> onSelectItemView;
                                Intrinsics.checkNotNullParameter(itemView, "itemView");
                                DslTabLayoutConfig tabLayoutConfig = dslTabLayout4.getTabLayoutConfig();
                                return Boolean.valueOf((tabLayoutConfig == null || (onSelectItemView = tabLayoutConfig.getOnSelectItemView()) == null) ? false : onSelectItemView.invoke(itemView, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)).booleanValue());
                            }
                        });
                        final DslTabLayout dslTabLayout5 = dslTabLayout2;
                        install.setOnSelectViewChange(new Function4<View, List<? extends View>, Boolean, Boolean, Unit>() { // from class: com.angcyo.tablayout.DslTabLayout.dslSelector.2.1.3
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(View view, List<? extends View> list, Boolean bool, Boolean bool2) {
                                invoke(view, list, bool.booleanValue(), bool2.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(View view, List<? extends View> selectViewList, boolean z, boolean z2) {
                                Function4<View, List<? extends View>, Boolean, Boolean, Unit> onSelectViewChange;
                                Intrinsics.checkNotNullParameter(selectViewList, "selectViewList");
                                DslTabLayoutConfig tabLayoutConfig = dslTabLayout5.getTabLayoutConfig();
                                if (tabLayoutConfig == null || (onSelectViewChange = tabLayoutConfig.getOnSelectViewChange()) == null) {
                                    return;
                                }
                                onSelectViewChange.invoke(view, selectViewList, Boolean.valueOf(z), Boolean.valueOf(z2));
                            }
                        });
                        final DslTabLayout dslTabLayout6 = dslTabLayout2;
                        install.setOnSelectIndexChange(new Function4<Integer, List<? extends Integer>, Boolean, Boolean, Unit>() { // from class: com.angcyo.tablayout.DslTabLayout.dslSelector.2.1.4
                            {
                                super(4);
                            }

                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num, List<? extends Integer> list, Boolean bool, Boolean bool2) {
                                invoke(num.intValue(), (List<Integer>) list, bool.booleanValue(), bool2.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i, List<Integer> selectList, boolean z, boolean z2) {
                                Function4<Integer, List<Integer>, Boolean, Boolean, Unit> onSelectIndexChange;
                                Intrinsics.checkNotNullParameter(selectList, "selectList");
                                if (dslTabLayout6.getTabLayoutConfig() == null) {
                                    LibExKt.logi("选择:[" + i + "]->" + selectList + " reselect:" + z + " fromUser:" + z2);
                                }
                                Integer num = (Integer) CollectionsKt.lastOrNull((List) selectList);
                                int iIntValue = num != null ? num.intValue() : -1;
                                dslTabLayout6._animateToItem(i, iIntValue);
                                DslTabLayout dslTabLayout7 = dslTabLayout6;
                                dslTabLayout7._scrollToTarget(iIntValue, dslTabLayout7.getTabIndicator().getIndicatorAnim());
                                dslTabLayout6.postInvalidate();
                                DslTabLayoutConfig tabLayoutConfig = dslTabLayout6.getTabLayoutConfig();
                                if (tabLayoutConfig != null && (onSelectIndexChange = tabLayoutConfig.getOnSelectIndexChange()) != null) {
                                    onSelectIndexChange.invoke(Integer.valueOf(i), selectList, Boolean.valueOf(z), Boolean.valueOf(z2));
                                    return;
                                }
                                ViewPagerDelegate viewPagerDelegate = dslTabLayout6.get_viewPagerDelegate();
                                if (viewPagerDelegate != null) {
                                    viewPagerDelegate.onSetCurrentItem(i, iIntValue, z, z2);
                                }
                            }
                        });
                    }
                });
            }
        });
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DslTabLayout);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.itemIsEquWidth = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_item_is_equ_width, this.itemIsEquWidth);
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_tab_item_equ_width_count, -1);
        if (i >= 0) {
            this.itemEquWidthCountRange = new IntRange(i, Integer.MAX_VALUE);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.DslTabLayout_tab_item_equ_width_count_range)) {
            updateItemEquWidthCountRange(typedArrayObtainStyledAttributes.getString(R.styleable.DslTabLayout_tab_item_equ_width_count_range));
        }
        this.itemAutoEquWidth = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_item_auto_equ_width, this.itemAutoEquWidth);
        this.itemWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_item_width, this.itemWidth);
        this.itemDefaultHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_tab_item_default_height, this.itemDefaultHeight);
        this.tabDefaultIndex = typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_tab_default_index, this.tabDefaultIndex);
        this.drawIndicator = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_draw_indicator, this.drawIndicator);
        this.drawDivider = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_draw_divider, this.drawDivider);
        this.drawBorder = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_draw_border, this.drawBorder);
        this.drawBadge = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_draw_badge, this.drawBadge);
        this.drawHighlight = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_draw_highlight, this.drawHighlight);
        this.tabEnableSelectorMode = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_enable_selector_mode, this.tabEnableSelectorMode);
        this.tabConvexBackgroundDrawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.DslTabLayout_tab_convex_background);
        this.orientation = typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_tab_orientation, this.orientation);
        this.layoutScrollAnim = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DslTabLayout_tab_layout_scroll_anim, this.layoutScrollAnim);
        this.scrollAnimDuration = typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_tab_scroll_anim_duration, this.scrollAnimDuration);
        if (isInEditMode()) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DslTabLayout_tab_preview_item_layout_id, -1);
            int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_tab_preview_item_count, 3);
            if (resourceId != -1) {
                for (int i3 = 0; i3 < i2; i3++) {
                    View viewInflate = LibExKt.inflate(this, resourceId, true);
                    if (viewInflate instanceof TextView) {
                        TextView textView = (TextView) viewInflate;
                        CharSequence text = textView.getText();
                        if (text == null || text.length() == 0) {
                            textView.setText("Item " + i3);
                        } else {
                            textView.setText(new StringBuilder().append((Object) textView.getText()).append('/').append(i3).toString());
                        }
                    }
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this._minFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this._maxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        if (this.drawIndicator) {
            this.tabIndicator.initAttribute(context, this.attributeSet);
        }
        if (this.drawBorder) {
            setTabBorder(new DslTabBorder());
        }
        if (this.drawDivider) {
            setTabDivider(new DslTabDivider());
        }
        if (this.drawBadge) {
            setTabBadge(new DslTabBadge());
        }
        if (this.drawHighlight) {
            setTabHighlight(new DslTabHighlight(this));
        }
        setTabLayoutConfig(new DslTabLayoutConfig(this));
        setWillNotDraw(false);
        this._layoutDirection = -1;
        this._overScroller = LazyKt.lazy(new Function0<OverScroller>() { // from class: com.angcyo.tablayout.DslTabLayout$_overScroller$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OverScroller invoke() {
                return new OverScroller(context);
            }
        });
        this._gestureDetector = LazyKt.lazy(new Function0<GestureDetectorCompat>() { // from class: com.angcyo.tablayout.DslTabLayout$_gestureDetector$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GestureDetectorCompat invoke() {
                Context context2 = context;
                final DslTabLayout dslTabLayout = this;
                return new GestureDetectorCompat(context2, new GestureDetector.SimpleOnGestureListener() { // from class: com.angcyo.tablayout.DslTabLayout$_gestureDetector$2.1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        Intrinsics.checkNotNullParameter(e2, "e2");
                        if (dslTabLayout.isHorizontal()) {
                            if (Math.abs(velocityX) <= dslTabLayout.get_minFlingVelocity()) {
                                return true;
                            }
                            dslTabLayout.onFlingChange(velocityX);
                            return true;
                        }
                        if (Math.abs(velocityY) <= dslTabLayout.get_minFlingVelocity()) {
                            return true;
                        }
                        dslTabLayout.onFlingChange(velocityY);
                        return true;
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                        Intrinsics.checkNotNullParameter(e2, "e2");
                        if (dslTabLayout.isHorizontal()) {
                            if (Math.abs(distanceX) > dslTabLayout.get_touchSlop()) {
                                return dslTabLayout.onScrollChange(distanceX);
                            }
                        } else if (Math.abs(distanceY) > dslTabLayout.get_touchSlop()) {
                            return dslTabLayout.onScrollChange(distanceY);
                        }
                        return false;
                    }
                });
            }
        });
        this._scrollAnimator = LazyKt.lazy(new DslTabLayout$_scrollAnimator$2(this));
    }

    public final int getItemDefaultHeight() {
        return this.itemDefaultHeight;
    }

    public final void setItemDefaultHeight(int i) {
        this.itemDefaultHeight = i;
    }

    public final boolean getItemIsEquWidth() {
        return this.itemIsEquWidth;
    }

    public final void setItemIsEquWidth(boolean z) {
        this.itemIsEquWidth = z;
    }

    public final boolean getItemEnableSelector() {
        return this.itemEnableSelector;
    }

    public final void setItemEnableSelector(boolean z) {
        this.itemEnableSelector = z;
    }

    public final IntRange getItemEquWidthCountRange() {
        return this.itemEquWidthCountRange;
    }

    public final void setItemEquWidthCountRange(IntRange intRange) {
        this.itemEquWidthCountRange = intRange;
    }

    public final boolean getItemAutoEquWidth() {
        return this.itemAutoEquWidth;
    }

    public final void setItemAutoEquWidth(boolean z) {
        this.itemAutoEquWidth = z;
    }

    public final int getItemWidth() {
        return this.itemWidth;
    }

    public final void setItemWidth(int i) {
        this.itemWidth = i;
    }

    public final boolean getDrawIndicator() {
        return this.drawIndicator;
    }

    public final void setDrawIndicator(boolean z) {
        this.drawIndicator = z;
    }

    public final DslTabIndicator getTabIndicator() {
        return this.tabIndicator;
    }

    public final void setTabIndicator(DslTabIndicator value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.tabIndicator = value;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        value.initAttribute(context, this.attributeSet);
    }

    public final long getTabIndicatorAnimationDuration() {
        return this.tabIndicatorAnimationDuration;
    }

    public final void setTabIndicatorAnimationDuration(long j) {
        this.tabIndicatorAnimationDuration = j;
    }

    public final int getTabDefaultIndex() {
        return this.tabDefaultIndex;
    }

    public final void setTabDefaultIndex(int i) {
        this.tabDefaultIndex = i;
    }

    public final DslTabLayoutConfig getTabLayoutConfig() {
        return this.tabLayoutConfig;
    }

    public final void setTabLayoutConfig(DslTabLayoutConfig dslTabLayoutConfig) {
        this.tabLayoutConfig = dslTabLayoutConfig;
        if (dslTabLayoutConfig != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            dslTabLayoutConfig.initAttribute(context, this.attributeSet);
        }
    }

    public final DslTabBorder getTabBorder() {
        return this.tabBorder;
    }

    public final void setTabBorder(DslTabBorder dslTabBorder) {
        this.tabBorder = dslTabBorder;
        if (dslTabBorder != null) {
            dslTabBorder.setCallback(this);
        }
        DslTabBorder dslTabBorder2 = this.tabBorder;
        if (dslTabBorder2 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            dslTabBorder2.initAttribute(context, this.attributeSet);
        }
    }

    public final boolean getDrawBorder() {
        return this.drawBorder;
    }

    public final void setDrawBorder(boolean z) {
        this.drawBorder = z;
    }

    public final DslTabDivider getTabDivider() {
        return this.tabDivider;
    }

    public final void setTabDivider(DslTabDivider dslTabDivider) {
        this.tabDivider = dslTabDivider;
        if (dslTabDivider != null) {
            dslTabDivider.setCallback(this);
        }
        DslTabDivider dslTabDivider2 = this.tabDivider;
        if (dslTabDivider2 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            dslTabDivider2.initAttribute(context, this.attributeSet);
        }
    }

    public final boolean getDrawDivider() {
        return this.drawDivider;
    }

    public final void setDrawDivider(boolean z) {
        this.drawDivider = z;
    }

    public final DslTabBadge getTabBadge() {
        return this.tabBadge;
    }

    public final void setTabBadge(DslTabBadge dslTabBadge) {
        this.tabBadge = dslTabBadge;
        if (dslTabBadge != null) {
            dslTabBadge.setCallback(this);
        }
        DslTabBadge dslTabBadge2 = this.tabBadge;
        if (dslTabBadge2 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            dslTabBadge2.initAttribute(context, this.attributeSet);
        }
    }

    public final boolean getDrawBadge() {
        return this.drawBadge;
    }

    public final void setDrawBadge(boolean z) {
        this.drawBadge = z;
    }

    public final Map<Integer, TabBadgeConfig> getTabBadgeConfigMap() {
        return this.tabBadgeConfigMap;
    }

    public final Function3<View, DslTabBadge, Integer, TabBadgeConfig> getOnTabBadgeConfig() {
        return this.onTabBadgeConfig;
    }

    public final void setOnTabBadgeConfig(Function3<? super View, ? super DslTabBadge, ? super Integer, TabBadgeConfig> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.onTabBadgeConfig = function3;
    }

    public final boolean getDrawHighlight() {
        return this.drawHighlight;
    }

    public final void setDrawHighlight(boolean z) {
        this.drawHighlight = z;
    }

    public final DslTabHighlight getTabHighlight() {
        return this.tabHighlight;
    }

    public final void setTabHighlight(DslTabHighlight dslTabHighlight) {
        this.tabHighlight = dslTabHighlight;
        if (dslTabHighlight != null) {
            dslTabHighlight.setCallback(this);
        }
        DslTabHighlight dslTabHighlight2 = this.tabHighlight;
        if (dslTabHighlight2 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            dslTabHighlight2.initAttribute(context, this.attributeSet);
        }
    }

    public final Drawable getTabConvexBackgroundDrawable() {
        return this.tabConvexBackgroundDrawable;
    }

    public final void setTabConvexBackgroundDrawable(Drawable drawable) {
        this.tabConvexBackgroundDrawable = drawable;
    }

    public final boolean getTabEnableSelectorMode() {
        return this.tabEnableSelectorMode;
    }

    public final void setTabEnableSelectorMode(boolean z) {
        this.tabEnableSelectorMode = z;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(int i) {
        this.orientation = i;
    }

    public final boolean getLayoutScrollAnim() {
        return this.layoutScrollAnim;
    }

    public final void setLayoutScrollAnim(boolean z) {
        this.layoutScrollAnim = z;
    }

    public final int getScrollAnimDuration() {
        return this.scrollAnimDuration;
    }

    public final void setScrollAnimDuration(int i) {
        this.scrollAnimDuration = i;
    }

    public final boolean getLayoutScrollToTarget() {
        return this.layoutScrollToTarget;
    }

    public final void setLayoutScrollToTarget(boolean z) {
        this.layoutScrollToTarget = z;
    }

    /* JADX INFO: renamed from: isFirstLayout, reason: from getter */
    public final boolean getIsFirstLayout() {
        return this.isFirstLayout;
    }

    public final void setFirstLayout(boolean z) {
        this.isFirstLayout = z;
    }

    public final int get_minFlingVelocity() {
        return this._minFlingVelocity;
    }

    public final void set_minFlingVelocity(int i) {
        this._minFlingVelocity = i;
    }

    public final int get_maxFlingVelocity() {
        return this._maxFlingVelocity;
    }

    public final void set_maxFlingVelocity(int i) {
        this._maxFlingVelocity = i;
    }

    public final int get_touchSlop() {
        return this._touchSlop;
    }

    public final void set_touchSlop(int i) {
        this._touchSlop = i;
    }

    public final Rect get_tempRect() {
        return this._tempRect;
    }

    public final DslSelector getDslSelector() {
        return (DslSelector) this.dslSelector.getValue();
    }

    public final int getCurrentItemIndex() {
        return getDslSelector().getDslSelectIndex();
    }

    public final View getCurrentItemView() {
        return (View) CollectionsKt.getOrNull(getDslSelector().getVisibleViewList(), getCurrentItemIndex());
    }

    public static /* synthetic */ void setCurrentItem$default(DslTabLayout dslTabLayout, int i, boolean z, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCurrentItem");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        dslTabLayout.setCurrentItem(i, z, z2);
    }

    public final void setCurrentItem(int index, boolean notify, boolean fromUser) {
        if (getCurrentItemIndex() == index) {
            _scrollToTarget(index, this.tabIndicator.getIndicatorAnim());
        } else {
            DslSelector.selector$default(getDslSelector(), index, true, notify, fromUser, false, 16, null);
        }
    }

    public final void setupViewPager(ViewPagerDelegate viewPagerDelegate) {
        Intrinsics.checkNotNullParameter(viewPagerDelegate, "viewPagerDelegate");
        this._viewPagerDelegate = viewPagerDelegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setTabLayoutConfig$default(DslTabLayout dslTabLayout, DslTabLayoutConfig dslTabLayoutConfig, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTabLayoutConfig");
        }
        if ((i & 1) != 0) {
            dslTabLayoutConfig = new DslTabLayoutConfig(dslTabLayout);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<DslTabLayoutConfig, Unit>() { // from class: com.angcyo.tablayout.DslTabLayout.setTabLayoutConfig.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DslTabLayoutConfig dslTabLayoutConfig2) {
                    Intrinsics.checkNotNullParameter(dslTabLayoutConfig2, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DslTabLayoutConfig dslTabLayoutConfig2) {
                    invoke2(dslTabLayoutConfig2);
                    return Unit.INSTANCE;
                }
            };
        }
        dslTabLayout.setTabLayoutConfig(dslTabLayoutConfig, function1);
    }

    public final void setTabLayoutConfig(DslTabLayoutConfig config, Function1<? super DslTabLayoutConfig, Unit> doIt) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(doIt, "doIt");
        setTabLayoutConfig(config);
        configTabLayoutConfig(doIt);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configTabLayoutConfig$default(DslTabLayout dslTabLayout, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: configTabLayoutConfig");
        }
        if ((i & 1) != 0) {
            function1 = new Function1<DslTabLayoutConfig, Unit>() { // from class: com.angcyo.tablayout.DslTabLayout.configTabLayoutConfig.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DslTabLayoutConfig dslTabLayoutConfig) {
                    Intrinsics.checkNotNullParameter(dslTabLayoutConfig, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DslTabLayoutConfig dslTabLayoutConfig) {
                    invoke2(dslTabLayoutConfig);
                    return Unit.INSTANCE;
                }
            };
        }
        dslTabLayout.configTabLayoutConfig(function1);
    }

    public final void configTabLayoutConfig(Function1<? super DslTabLayoutConfig, Unit> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.tabLayoutConfig == null) {
            setTabLayoutConfig(new DslTabLayoutConfig(this));
        }
        DslTabLayoutConfig dslTabLayoutConfig = this.tabLayoutConfig;
        if (dslTabLayoutConfig != null) {
            config.invoke(dslTabLayoutConfig);
        }
        getDslSelector().updateStyle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void observeIndexChange$default(DslTabLayout dslTabLayout, Function1 function1, Function4 function4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observeIndexChange");
        }
        if ((i & 1) != 0) {
            function1 = new Function1<DslTabLayoutConfig, Unit>() { // from class: com.angcyo.tablayout.DslTabLayout.observeIndexChange.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DslTabLayoutConfig dslTabLayoutConfig) {
                    Intrinsics.checkNotNullParameter(dslTabLayoutConfig, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DslTabLayoutConfig dslTabLayoutConfig) {
                    invoke2(dslTabLayoutConfig);
                    return Unit.INSTANCE;
                }
            };
        }
        dslTabLayout.observeIndexChange(function1, function4);
    }

    public final void observeIndexChange(final Function1<? super DslTabLayoutConfig, Unit> config, final Function4<? super Integer, ? super Integer, ? super Boolean, ? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(action, "action");
        configTabLayoutConfig(new Function1<DslTabLayoutConfig, Unit>() { // from class: com.angcyo.tablayout.DslTabLayout.observeIndexChange.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DslTabLayoutConfig dslTabLayoutConfig) {
                invoke2(dslTabLayoutConfig);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DslTabLayoutConfig configTabLayoutConfig) {
                Intrinsics.checkNotNullParameter(configTabLayoutConfig, "$this$configTabLayoutConfig");
                config.invoke(configTabLayoutConfig);
                final Function4<Integer, Integer, Boolean, Boolean, Unit> function4 = action;
                configTabLayoutConfig.setOnSelectIndexChange(new Function4<Integer, List<? extends Integer>, Boolean, Boolean, Unit>() { // from class: com.angcyo.tablayout.DslTabLayout.observeIndexChange.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, List<? extends Integer> list, Boolean bool, Boolean bool2) {
                        invoke(num.intValue(), (List<Integer>) list, bool.booleanValue(), bool2.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i, List<Integer> selectIndexList, boolean z, boolean z2) {
                        Intrinsics.checkNotNullParameter(selectIndexList, "selectIndexList");
                        Function4<Integer, Integer, Boolean, Boolean, Unit> function42 = function4;
                        Integer numValueOf = Integer.valueOf(i);
                        Integer num = (Integer) CollectionsKt.firstOrNull((List) selectIndexList);
                        function42.invoke(numValueOf, Integer.valueOf(num != null ? num.intValue() : -1), Boolean.valueOf(z), Boolean.valueOf(z2));
                    }
                });
            }
        });
    }

    public final TabBadgeConfig getBadgeConfig(int index) {
        DslTabBadge dslTabBadge;
        TabBadgeConfig defaultBadgeConfig;
        TabBadgeConfig tabBadgeConfig = this.tabBadgeConfigMap.get(Integer.valueOf(index));
        if (tabBadgeConfig == null && ((dslTabBadge = this.tabBadge) == null || (defaultBadgeConfig = dslTabBadge.getDefaultBadgeConfig()) == null || (tabBadgeConfig = defaultBadgeConfig.copy((2097151 & 1) != 0 ? defaultBadgeConfig.badgeText : null, (2097151 & 2) != 0 ? defaultBadgeConfig.badgeGravity : 0, (2097151 & 4) != 0 ? defaultBadgeConfig.badgeSolidColor : 0, (2097151 & 8) != 0 ? defaultBadgeConfig.badgeStrokeColor : 0, (2097151 & 16) != 0 ? defaultBadgeConfig.badgeStrokeWidth : 0, (2097151 & 32) != 0 ? defaultBadgeConfig.badgeTextColor : 0, (2097151 & 64) != 0 ? defaultBadgeConfig.badgeTextSize : 0.0f, (2097151 & 128) != 0 ? defaultBadgeConfig.badgeCircleRadius : 0, (2097151 & 256) != 0 ? defaultBadgeConfig.badgeRadius : 0, (2097151 & 512) != 0 ? defaultBadgeConfig.badgeOffsetX : 0, (2097151 & 1024) != 0 ? defaultBadgeConfig.badgeOffsetY : 0, (2097151 & 2048) != 0 ? defaultBadgeConfig.badgeCircleOffsetX : 0, (2097151 & 4096) != 0 ? defaultBadgeConfig.badgeCircleOffsetY : 0, (2097151 & 8192) != 0 ? defaultBadgeConfig.badgePaddingLeft : 0, (2097151 & 16384) != 0 ? defaultBadgeConfig.badgePaddingRight : 0, (2097151 & 32768) != 0 ? defaultBadgeConfig.badgePaddingTop : 0, (2097151 & 65536) != 0 ? defaultBadgeConfig.badgePaddingBottom : 0, (2097151 & 131072) != 0 ? defaultBadgeConfig.badgeAnchorChildIndex : 0, (2097151 & 262144) != 0 ? defaultBadgeConfig.badgeIgnoreChildPadding : false, (2097151 & 524288) != 0 ? defaultBadgeConfig.badgeMinHeight : 0, (2097151 & 1048576) != 0 ? defaultBadgeConfig.badgeMinWidth : 0)) == null)) {
            tabBadgeConfig = new TabBadgeConfig(null, 0, 0, 0, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 2097151, null);
        }
        return tabBadgeConfig;
    }

    public final void updateTabBadge(int index, final String badgeText) {
        updateTabBadge(index, new Function1<TabBadgeConfig, Unit>() { // from class: com.angcyo.tablayout.DslTabLayout.updateTabBadge.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TabBadgeConfig tabBadgeConfig) {
                invoke2(tabBadgeConfig);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TabBadgeConfig updateTabBadge) {
                Intrinsics.checkNotNullParameter(updateTabBadge, "$this$updateTabBadge");
                updateTabBadge.setBadgeText(badgeText);
            }
        });
    }

    public final void updateTabBadge(int index, Function1<? super TabBadgeConfig, Unit> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        TabBadgeConfig badgeConfig = getBadgeConfig(index);
        this.tabBadgeConfigMap.put(Integer.valueOf(index), badgeConfig);
        config.invoke(badgeConfig);
        postInvalidate();
    }

    public final void updateItemEquWidthCountRange(String range) {
        Integer intOrNull;
        Integer intOrNull2;
        Integer intOrNull3;
        String str = range;
        int iIntValue = 0;
        if (str == null || StringsKt.isBlank(str)) {
            this.itemEquWidthCountRange = null;
        } else {
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"~"}, false, 0, 6, (Object) null);
            int iIntValue2 = Integer.MAX_VALUE;
            if (LibExKt.size(listSplit$default) >= 2) {
                String str2 = (String) CollectionsKt.getOrNull(listSplit$default, 0);
                if (str2 != null && (intOrNull3 = StringsKt.toIntOrNull(str2)) != null) {
                    iIntValue = intOrNull3.intValue();
                }
                String str3 = (String) CollectionsKt.getOrNull(listSplit$default, 1);
                if (str3 != null && (intOrNull2 = StringsKt.toIntOrNull(str3)) != null) {
                    iIntValue2 = intOrNull2.intValue();
                }
                this.itemEquWidthCountRange = new IntRange(iIntValue, iIntValue2);
            } else {
                String str4 = (String) CollectionsKt.getOrNull(listSplit$default, 0);
                this.itemEquWidthCountRange = new IntRange((str4 == null || (intOrNull = StringsKt.toIntOrNull(str4)) == null) ? Integer.MAX_VALUE : intOrNull.intValue(), Integer.MAX_VALUE);
            }
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        updateTabLayout();
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
        updateTabLayout();
    }

    public void updateTabLayout() {
        getDslSelector().updateVisibleList();
        getDslSelector().updateStyle();
        getDslSelector().updateClickListener();
    }

    @Override // android.view.View
    public void draw(final Canvas canvas) {
        DslTabBadge dslTabBadge;
        int left;
        int top2;
        int right;
        int bottom;
        DslTabHighlight dslTabHighlight;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i = 0;
        if (this.drawIndicator) {
            this.tabIndicator.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
        final Drawable drawable = this.tabConvexBackgroundDrawable;
        if (drawable != null) {
            if (isHorizontal()) {
                drawable.setBounds(0, this._maxConvexHeight, getRight() - getLeft(), getBottom() - getTop());
            } else {
                drawable.setBounds(0, 0, getMeasuredWidth() - this._maxConvexHeight, getBottom() - getTop());
            }
            if ((getScrollX() | getScrollY()) == 0) {
                drawable.draw(canvas);
            } else {
                holdLocation(canvas, new Function0<Unit>() { // from class: com.angcyo.tablayout.DslTabLayout$draw$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        drawable.draw(canvas);
                    }
                });
            }
        }
        super.draw(canvas);
        if (this.drawHighlight && (dslTabHighlight = this.tabHighlight) != null) {
            dslTabHighlight.draw(canvas);
        }
        int size = getDslSelector().getVisibleViewList().size();
        if (this.drawDivider) {
            if (isHorizontal()) {
                if (isLayoutRtl()) {
                    DslTabDivider dslTabDivider = this.tabDivider;
                    if (dslTabDivider != null) {
                        int paddingTop = dslTabDivider.getPaddingTop() + dslTabDivider.getDividerMarginTop();
                        int measuredHeight = (getMeasuredHeight() - dslTabDivider.getPaddingBottom()) - dslTabDivider.getDividerMarginBottom();
                        int i2 = 0;
                        for (Object obj : getDslSelector().getVisibleViewList()) {
                            int i3 = i2 + 1;
                            if (i2 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            View view = (View) obj;
                            if (dslTabDivider.haveBeforeDivider(i2, size)) {
                                int right2 = view.getRight() + dslTabDivider.getDividerMarginLeft() + dslTabDivider.getDividerWidth();
                                dslTabDivider.setBounds(right2 - dslTabDivider.getDividerWidth(), paddingTop, right2, measuredHeight);
                                dslTabDivider.draw(canvas);
                            }
                            if (dslTabDivider.haveAfterDivider(i2, size)) {
                                int right3 = (view.getRight() - view.getMeasuredWidth()) - dslTabDivider.getDividerMarginRight();
                                dslTabDivider.setBounds(right3 - dslTabDivider.getDividerWidth(), paddingTop, right3, measuredHeight);
                                dslTabDivider.draw(canvas);
                            }
                            i2 = i3;
                        }
                    }
                } else {
                    DslTabDivider dslTabDivider2 = this.tabDivider;
                    if (dslTabDivider2 != null) {
                        int paddingTop2 = dslTabDivider2.getPaddingTop() + dslTabDivider2.getDividerMarginTop();
                        int measuredHeight2 = (getMeasuredHeight() - dslTabDivider2.getPaddingBottom()) - dslTabDivider2.getDividerMarginBottom();
                        int i4 = 0;
                        for (Object obj2 : getDslSelector().getVisibleViewList()) {
                            int i5 = i4 + 1;
                            if (i4 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            View view2 = (View) obj2;
                            if (dslTabDivider2.haveBeforeDivider(i4, size)) {
                                int left2 = (view2.getLeft() - dslTabDivider2.getDividerMarginRight()) - dslTabDivider2.getDividerWidth();
                                dslTabDivider2.setBounds(left2, paddingTop2, dslTabDivider2.getDividerWidth() + left2, measuredHeight2);
                                dslTabDivider2.draw(canvas);
                            }
                            if (dslTabDivider2.haveAfterDivider(i4, size)) {
                                int right4 = view2.getRight() + dslTabDivider2.getDividerMarginLeft();
                                dslTabDivider2.setBounds(right4, paddingTop2, dslTabDivider2.getDividerWidth() + right4, measuredHeight2);
                                dslTabDivider2.draw(canvas);
                            }
                            i4 = i5;
                        }
                    }
                }
            } else {
                DslTabDivider dslTabDivider3 = this.tabDivider;
                if (dslTabDivider3 != null) {
                    int paddingStart = getPaddingStart() + dslTabDivider3.getDividerMarginLeft();
                    int measuredWidth = (getMeasuredWidth() - getPaddingEnd()) - dslTabDivider3.getDividerMarginRight();
                    int i6 = 0;
                    for (Object obj3 : getDslSelector().getVisibleViewList()) {
                        int i7 = i6 + 1;
                        if (i6 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        View view3 = (View) obj3;
                        if (dslTabDivider3.haveBeforeDivider(i6, size)) {
                            int top3 = (view3.getTop() - dslTabDivider3.getDividerMarginBottom()) - dslTabDivider3.getDividerHeight();
                            dslTabDivider3.setBounds(paddingStart, top3, measuredWidth, dslTabDivider3.getDividerHeight() + top3);
                            dslTabDivider3.draw(canvas);
                        }
                        if (dslTabDivider3.haveAfterDivider(i6, size)) {
                            int bottom2 = view3.getBottom() + dslTabDivider3.getDividerMarginTop();
                            dslTabDivider3.setBounds(paddingStart, bottom2, measuredWidth, dslTabDivider3.getDividerHeight() + bottom2);
                            dslTabDivider3.draw(canvas);
                        }
                        i6 = i7;
                    }
                }
            }
        }
        if (this.drawBorder) {
            holdLocation(canvas, new Function0<Unit>() { // from class: com.angcyo.tablayout.DslTabLayout.draw.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DslTabBorder tabBorder = DslTabLayout.this.getTabBorder();
                    if (tabBorder != null) {
                        tabBorder.draw(canvas);
                    }
                }
            });
        }
        if (this.drawIndicator && LibExKt.have(this.tabIndicator.getIndicatorStyle(), 4096)) {
            this.tabIndicator.draw(canvas);
        }
        if (!this.drawBadge || (dslTabBadge = this.tabBadge) == null) {
            return;
        }
        for (Object obj4 : getDslSelector().getVisibleViewList()) {
            int i8 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view4 = (View) obj4;
            TabBadgeConfig tabBadgeConfigInvoke = this.onTabBadgeConfig.invoke(view4, dslTabBadge, Integer.valueOf(i));
            if (tabBadgeConfigInvoke != null && tabBadgeConfigInvoke.getBadgeAnchorChildIndex() >= 0) {
                View childOrNull = LibExKt.getChildOrNull(view4, tabBadgeConfigInvoke.getBadgeAnchorChildIndex());
                if (childOrNull != null) {
                    view4 = childOrNull;
                }
                LibExKt.getLocationInParent(view4, this, this._tempRect);
                left = this._tempRect.left;
                top2 = this._tempRect.top;
                right = this._tempRect.right;
                bottom = this._tempRect.bottom;
            } else {
                left = view4.getLeft();
                top2 = view4.getTop();
                right = view4.getRight();
                bottom = view4.getBottom();
            }
            if (tabBadgeConfigInvoke != null && tabBadgeConfigInvoke.getBadgeIgnoreChildPadding()) {
                left += view4.getPaddingStart();
                top2 += view4.getPaddingTop();
                right -= view4.getPaddingEnd();
                bottom -= view4.getPaddingBottom();
            }
            dslTabBadge.setBounds(left, top2, right, bottom);
            dslTabBadge.updateOriginDrawable();
            if (dslTabBadge.isInEditMode()) {
                dslTabBadge.setBadgeText(i == size + (-1) ? "" : dslTabBadge.getXmlBadgeText());
            }
            dslTabBadge.draw(canvas);
            i = i8;
        }
    }

    @Override // android.view.View
    protected void onDraw(final Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.drawBorder) {
            holdLocation(canvas, new Function0<Unit>() { // from class: com.angcyo.tablayout.DslTabLayout.onDraw.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DslTabBorder tabBorder = DslTabLayout.this.getTabBorder();
                    if (tabBorder != null) {
                        tabBorder.drawBorderBackground(canvas);
                    }
                }
            });
        }
        if (!this.drawIndicator || LibExKt.have(this.tabIndicator.getIndicatorStyle(), 4096)) {
            return;
        }
        this.tabIndicator.draw(canvas);
    }

    public final void holdLocation(Canvas canvas, Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        canvas.translate(getScrollX(), getScrollY());
        action.invoke();
        canvas.translate(-getScrollX(), -getScrollY());
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        return super.drawChild(canvas, child, drawingTime);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        return super.verifyDrawable(who) || Intrinsics.areEqual(who, this.tabIndicator);
    }

    public final int get_childAllWidthSum() {
        return this._childAllWidthSum;
    }

    public final void set_childAllWidthSum(int i) {
        this._childAllWidthSum = i;
    }

    public final int get_maxConvexHeight() {
        return this._maxConvexHeight;
    }

    public final void set_maxConvexHeight(int i) {
        this._maxConvexHeight = i;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getDslSelector().getDslSelectIndex() < 0) {
            setCurrentItem$default(this, this.tabDefaultIndex, false, false, 6, null);
        }
        if (isHorizontal()) {
            measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        } else {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02e2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void measureHorizontal(int r38, int r39) {
        /*
            Method dump skipped, instruction units count: 1182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.angcyo.tablayout.DslTabLayout.measureHorizontal(int, int):void");
    }

    static /* synthetic */ void measureHorizontal$measureChild$default(DslTabLayout dslTabLayout, Ref.IntRef intRef, Ref.IntRef intRef2, int i, int i2, Ref.IntRef intRef3, Ref.IntRef intRef4, View view, Integer num, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: measureHorizontal$measureChild");
        }
        measureHorizontal$measureChild(dslTabLayout, intRef, intRef2, i, i2, intRef3, intRef4, view, (i3 & 256) != 0 ? null : num);
    }

    private static final void measureHorizontal$measureChild(DslTabLayout dslTabLayout, Ref.IntRef intRef, Ref.IntRef intRef2, int i, int i2, Ref.IntRef intRef3, Ref.IntRef intRef4, View view, Integer num) {
        int iAtmostMeasure;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int[] iArrCalcLayoutWidthHeight = LibExKt.calcLayoutWidthHeight(dslTabLayout, layoutParams2.getLayoutWidth(), layoutParams2.getLayoutHeight(), intRef.element, intRef2.element, 0, 0);
        if (i == 1073741824) {
            iAtmostMeasure = LibExKt.exactlyMeasure((((intRef2.element - dslTabLayout.getPaddingTop()) - dslTabLayout.getPaddingBottom()) - layoutParams2.topMargin) - layoutParams2.bottomMargin);
        } else {
            int i3 = iArrCalcLayoutWidthHeight[1];
            if (i3 > 0) {
                intRef2.element = i3;
                int iExactlyMeasure = LibExKt.exactlyMeasure(intRef2.element);
                intRef2.element += dslTabLayout.getPaddingTop() + dslTabLayout.getPaddingBottom();
                iAtmostMeasure = iExactlyMeasure;
            } else if (layoutParams2.height == -1) {
                iAtmostMeasure = LibExKt.exactlyMeasure(i2);
            } else {
                iAtmostMeasure = LibExKt.atmostMeasure(Integer.MAX_VALUE);
            }
        }
        int layoutConvexHeight = layoutParams2.getLayoutConvexHeight();
        int i4 = intRef3.element;
        if (num != null) {
            view.measure(intRef3.element, num.intValue());
        } else {
            view.measure(intRef3.element, iAtmostMeasure);
        }
        if (layoutConvexHeight > 0) {
            dslTabLayout._maxConvexHeight = Math.max(dslTabLayout._maxConvexHeight, layoutConvexHeight);
            view.measure(intRef3.element, LibExKt.exactlyMeasure(view.getMeasuredHeight() + layoutConvexHeight));
        }
        intRef4.element = Math.max(intRef4.element, view.getMeasuredHeight());
    }

    public final void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        int iExactlyMeasure;
        int suggestedMinimumWidth;
        byte b;
        int iExactlyMeasure2;
        int i;
        int i2;
        String str;
        int i3;
        int measuredHeight;
        int i4;
        int iExactlyMeasure3;
        DslTabDivider dslTabDivider;
        int suggestedMinimumHeight;
        int i5 = widthMeasureSpec;
        getDslSelector().updateVisibleList();
        List<View> visibleViewList = getDslSelector().getVisibleViewList();
        int size = visibleViewList.size();
        if (size == 0) {
            if (getSuggestedMinimumHeight() > 0) {
                suggestedMinimumHeight = getSuggestedMinimumHeight();
            } else {
                suggestedMinimumHeight = this.itemDefaultHeight;
            }
            setMeasuredDimension(ViewGroup.getDefaultSize(suggestedMinimumHeight, i5), ViewGroup.getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
            return;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        this._maxConvexHeight = 0;
        Ref.IntRef intRef3 = new Ref.IntRef();
        intRef3.element = -1;
        Ref.IntRef intRef4 = new Ref.IntRef();
        intRef4.element = -1;
        if (mode2 == 0 && intRef2.element == 0) {
            intRef2.element = Integer.MAX_VALUE;
        }
        if (mode != 0) {
            if (mode == 1073741824) {
                intRef4.element = LibExKt.exactlyMeasure((intRef.element - getPaddingStart()) - getPaddingEnd());
            }
        } else if (intRef.element == 0) {
            intRef.element = Integer.MAX_VALUE;
        }
        int dividerHeight = (!this.drawDivider || (dslTabDivider = this.tabDivider) == null) ? 0 : dslTabDivider.getDividerHeight() + dslTabDivider.getDividerMarginTop() + dslTabDivider.getDividerMarginBottom();
        String str2 = "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams";
        if (this.itemAutoEquWidth) {
            int measuredHeight2 = 0;
            int i6 = 0;
            for (Object obj : visibleViewList) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                View view = (View) obj;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                measureChild(view, i5, heightMeasureSpec);
                measuredHeight2 += layoutParams2.topMargin + layoutParams2.bottomMargin + view.getMeasuredHeight();
                if (this.drawDivider) {
                    DslTabDivider dslTabDivider2 = this.tabDivider;
                    if (dslTabDivider2 != null && dslTabDivider2.haveBeforeDivider(i6, visibleViewList.size())) {
                        measuredHeight2 += dividerHeight;
                    }
                    DslTabDivider dslTabDivider3 = this.tabDivider;
                    if (dslTabDivider3 != null && dslTabDivider3.haveAfterDivider(i6, visibleViewList.size())) {
                        measuredHeight2 += dividerHeight;
                    }
                }
                i5 = widthMeasureSpec;
                i6 = i7;
            }
            this.itemIsEquWidth = measuredHeight2 <= intRef2.element;
        }
        IntRange intRange = this.itemEquWidthCountRange;
        if (intRange != null) {
            this.itemIsEquWidth = intRange.contains(size);
        }
        if (this.itemIsEquWidth) {
            int i8 = this.itemWidth;
            if (i8 <= 0) {
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int i9 = 0;
                for (Object obj2 : visibleViewList) {
                    int i10 = i9 + 1;
                    if (i9 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    View view2 = (View) obj2;
                    if (this.drawDivider) {
                        DslTabDivider dslTabDivider4 = this.tabDivider;
                        if (dslTabDivider4 != null && dslTabDivider4.haveBeforeDivider(i9, visibleViewList.size())) {
                            paddingTop += dividerHeight;
                        }
                        DslTabDivider dslTabDivider5 = this.tabDivider;
                        if (dslTabDivider5 != null && dslTabDivider5.haveAfterDivider(i9, visibleViewList.size())) {
                            paddingTop += dividerHeight;
                        }
                    }
                    ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                    LayoutParams layoutParams4 = (LayoutParams) layoutParams3;
                    paddingTop += layoutParams4.topMargin + layoutParams4.bottomMargin;
                    i9 = i10;
                }
                i8 = (intRef2.element - paddingTop) / size;
            }
            iExactlyMeasure = LibExKt.exactlyMeasure(i8);
        } else {
            iExactlyMeasure = -1;
        }
        this._childAllWidthSum = 0;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        List<View> list = visibleViewList;
        int i11 = 0;
        int i12 = 0;
        for (Object obj3 : list) {
            int i13 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view3 = (View) obj3;
            ViewGroup.LayoutParams layoutParams5 = view3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, str2);
            LayoutParams layoutParams6 = (LayoutParams) layoutParams5;
            if (layoutParams6.getWeight() < 0.0f) {
                int[] iArrCalcLayoutWidthHeight = LibExKt.calcLayoutWidthHeight(this, layoutParams6.getLayoutWidth(), layoutParams6.getLayoutHeight(), intRef.element, intRef2.element, 0, 0);
                if (this.itemIsEquWidth) {
                    iExactlyMeasure3 = iExactlyMeasure;
                } else {
                    int i14 = iArrCalcLayoutWidthHeight[1];
                    if (i14 > 0) {
                        iExactlyMeasure3 = LibExKt.exactlyMeasure(i14);
                    } else if (layoutParams6.height == -1) {
                        iExactlyMeasure3 = LibExKt.exactlyMeasure((intRef2.element - getPaddingTop()) - getPaddingBottom());
                    } else {
                        iExactlyMeasure3 = layoutParams6.height > 0 ? LibExKt.exactlyMeasure(layoutParams6.height) : LibExKt.atmostMeasure((intRef2.element - getPaddingTop()) - getPaddingBottom());
                    }
                }
                intRef3.element = iExactlyMeasure3;
                i2 = iExactlyMeasure;
                str = str2;
                i = mode2;
                i3 = i11;
                measureVertical$measureChild$22(this, intRef, intRef2, booleanRef, intRef4, intRef3, view3);
                measuredHeight = view3.getMeasuredHeight() + layoutParams6.topMargin;
                i4 = layoutParams6.bottomMargin;
            } else {
                i = mode2;
                i2 = iExactlyMeasure;
                str = str2;
                i3 = i11;
                measuredHeight = layoutParams6.topMargin;
                i4 = layoutParams6.bottomMargin;
            }
            int i15 = measuredHeight + i4;
            if (this.drawDivider) {
                DslTabDivider dslTabDivider6 = this.tabDivider;
                if (dslTabDivider6 != null && dslTabDivider6.haveBeforeDivider(i3, visibleViewList.size())) {
                    i15 += dividerHeight;
                }
                DslTabDivider dslTabDivider7 = this.tabDivider;
                if (dslTabDivider7 != null && dslTabDivider7.haveAfterDivider(i3, visibleViewList.size())) {
                    i15 += dividerHeight;
                }
            }
            i12 += i15;
            this._childAllWidthSum += i15;
            str2 = str;
            i11 = i13;
            mode2 = i;
            iExactlyMeasure = i2;
        }
        int i16 = mode2;
        int i17 = iExactlyMeasure;
        String str3 = str2;
        int i18 = intRef2.element - i12;
        for (View view4 : list) {
            ViewGroup.LayoutParams layoutParams7 = view4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams7, str3);
            LayoutParams layoutParams8 = (LayoutParams) layoutParams7;
            if (layoutParams8.getWeight() > 0.0f) {
                int[] iArrCalcLayoutWidthHeight2 = LibExKt.calcLayoutWidthHeight(this, layoutParams8.getLayoutWidth(), layoutParams8.getLayoutHeight(), intRef.element, intRef2.element, 0, 0);
                if (this.itemIsEquWidth) {
                    iExactlyMeasure2 = i17;
                } else if (i18 > 0) {
                    iExactlyMeasure2 = LibExKt.exactlyMeasure(i18 * layoutParams8.getWeight());
                } else {
                    if (iArrCalcLayoutWidthHeight2[1] > 0) {
                        iExactlyMeasure2 = LibExKt.exactlyMeasure(i12);
                        b = -1;
                    } else {
                        b = -1;
                        if (layoutParams8.height == -1) {
                            iExactlyMeasure2 = LibExKt.exactlyMeasure((intRef2.element - getPaddingTop()) - getPaddingBottom());
                        } else {
                            iExactlyMeasure2 = layoutParams8.height > 0 ? LibExKt.exactlyMeasure(layoutParams8.height) : LibExKt.atmostMeasure((intRef2.element - getPaddingTop()) - getPaddingBottom());
                        }
                    }
                    intRef3.element = iExactlyMeasure2;
                    measureVertical$measureChild$22(this, intRef, intRef2, booleanRef, intRef4, intRef3, view4);
                    this._childAllWidthSum += view4.getMeasuredHeight();
                }
                b = -1;
                intRef3.element = iExactlyMeasure2;
                measureVertical$measureChild$22(this, intRef, intRef2, booleanRef, intRef4, intRef3, view4);
                this._childAllWidthSum += view4.getMeasuredHeight();
            }
        }
        if (i16 != 1073741824) {
            intRef2.element = Math.min(this._childAllWidthSum + getPaddingTop() + getPaddingBottom(), intRef2.element);
        }
        if (visibleViewList.isEmpty()) {
            if (getSuggestedMinimumWidth() > 0) {
                suggestedMinimumWidth = getSuggestedMinimumWidth();
            } else {
                suggestedMinimumWidth = this.itemDefaultHeight;
            }
            intRef.element = suggestedMinimumWidth;
        }
        setMeasuredDimension(intRef.element + this._maxConvexHeight, intRef2.element);
    }

    private static final void measureVertical$measureChild$22(DslTabLayout dslTabLayout, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.BooleanRef booleanRef, Ref.IntRef intRef3, Ref.IntRef intRef4, View view) {
        int suggestedMinimumWidth;
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.setMarginStart(0);
        layoutParams2.setMarginEnd(0);
        int layoutConvexHeight = layoutParams2.getLayoutConvexHeight();
        dslTabLayout._maxConvexHeight = Math.max(dslTabLayout._maxConvexHeight, layoutConvexHeight);
        int[] iArrCalcLayoutWidthHeight = LibExKt.calcLayoutWidthHeight(dslTabLayout, layoutParams2.getLayoutWidth(), layoutParams2.getLayoutHeight(), intRef.element, intRef2.element, 0, 0);
        booleanRef.element = false;
        if (intRef3.element == -1 && (i = iArrCalcLayoutWidthHeight[0]) > 0) {
            intRef.element = i;
            intRef3.element = LibExKt.exactlyMeasure(intRef.element);
            intRef.element += dslTabLayout.getPaddingStart() + dslTabLayout.getPaddingEnd();
        }
        if (intRef3.element == -1) {
            if (layoutParams2.width == -1) {
                if (dslTabLayout.getSuggestedMinimumWidth() > 0) {
                    suggestedMinimumWidth = dslTabLayout.getSuggestedMinimumWidth();
                } else {
                    suggestedMinimumWidth = dslTabLayout.itemDefaultHeight;
                }
                intRef.element = suggestedMinimumWidth;
                intRef3.element = LibExKt.exactlyMeasure(intRef.element);
                intRef.element += dslTabLayout.getPaddingStart() + dslTabLayout.getPaddingEnd();
            } else {
                intRef3.element = LibExKt.atmostMeasure(intRef.element);
                booleanRef.element = true;
            }
        }
        int i2 = intRef4.element;
        if (layoutConvexHeight > 0) {
            view.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(intRef3.element) + layoutConvexHeight, View.MeasureSpec.getMode(intRef3.element)), intRef4.element);
        } else {
            view.measure(intRef3.element, intRef4.element);
        }
        if (booleanRef.element) {
            intRef.element = view.getMeasuredWidth();
            intRef3.element = LibExKt.exactlyMeasure(intRef.element);
            intRef.element += dslTabLayout.getPaddingStart() + dslTabLayout.getPaddingEnd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (isHorizontal()) {
            layoutHorizontal(changed, l, t, r, b);
        } else {
            layoutVertical(changed, l, t, r, b);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        restoreScroll();
        if (getDslSelector().getDslSelectIndex() < 0) {
            setCurrentItem$default(this, this.tabDefaultIndex, false, false, 6, null);
        } else if (this.layoutScrollToTarget || this.isFirstLayout) {
            _scrollToTarget(getDslSelector().getDslSelectIndex(), this.layoutScrollAnim);
            this.isFirstLayout = false;
        }
    }

    public final boolean isLayoutRtl() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public final int get_layoutDirection() {
        return this._layoutDirection;
    }

    public final void set_layoutDirection(int i) {
        this._layoutDirection = i;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        if (layoutDirection != this._layoutDirection) {
            this._layoutDirection = layoutDirection;
            if (this.orientation == 0) {
                updateTabLayout();
                requestLayout();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void layoutHorizontal(boolean r10, int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.angcyo.tablayout.DslTabLayout.layoutHorizontal(boolean, int, int, int, int):void");
    }

    public final void layoutVertical(boolean changed, int l, int t, int r, int b) {
        int paddingStart;
        int measuredWidth;
        int measuredWidth2;
        DslTabDivider dslTabDivider;
        int paddingTop = getPaddingTop();
        getPaddingStart();
        int dividerHeight = (!this.drawDivider || (dslTabDivider = this.tabDivider) == null) ? 0 : dslTabDivider.getDividerHeight() + dslTabDivider.getDividerMarginTop() + dslTabDivider.getDividerMarginBottom();
        List<View> visibleViewList = getDslSelector().getVisibleViewList();
        int i = 0;
        for (Object obj : visibleViewList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view = (View) obj;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams2.gravity, 0) & 7;
            int i3 = paddingTop + layoutParams2.topMargin;
            if (this.drawDivider) {
                DslTabDivider dslTabDivider2 = this.tabDivider;
                if (dslTabDivider2 != null && dslTabDivider2.haveBeforeDivider(i, visibleViewList.size())) {
                    i3 += dividerHeight;
                }
            }
            if (absoluteGravity == 1) {
                paddingStart = getPaddingStart();
                measuredWidth = ((((getMeasuredWidth() - getPaddingStart()) - getPaddingEnd()) - this._maxConvexHeight) / 2) - (view.getMeasuredWidth() / 2);
            } else if (absoluteGravity == 5) {
                measuredWidth2 = ((getMeasuredWidth() - getPaddingRight()) - view.getMeasuredWidth()) - layoutParams2.rightMargin;
                view.layout(measuredWidth2, i3, view.getMeasuredWidth() + measuredWidth2, view.getMeasuredHeight() + i3);
                paddingTop = i3 + view.getMeasuredHeight() + layoutParams2.bottomMargin;
                i = i2;
            } else {
                paddingStart = getPaddingLeft();
                measuredWidth = layoutParams2.leftMargin;
            }
            measuredWidth2 = paddingStart + measuredWidth;
            view.layout(measuredWidth2, i3, view.getMeasuredWidth() + measuredWidth2, view.getMeasuredHeight() + i3);
            paddingTop = i3 + view.getMeasuredHeight() + layoutParams2.bottomMargin;
            i = i2;
        }
    }

    public final boolean isHorizontal() {
        return LibExKt.isHorizontal(this.orientation);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 17);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return new LayoutParams(context, attrs);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return p != null ? new LayoutParams(p) : generateDefaultLayoutParams();
    }

    /* JADX INFO: compiled from: DslTabLayout.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rB\u001f\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010'\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001a\u0010*\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001a\u00106\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/angcyo/tablayout/DslTabLayout$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "source", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", MediaFormat.KEY_WIDTH, "", MediaFormat.KEY_HEIGHT, "(II)V", "gravity", "(III)V", "contentIconViewId", "getContentIconViewId", "()I", "setContentIconViewId", "(I)V", "contentIconViewIndex", "getContentIconViewIndex", "setContentIconViewIndex", "contentTextViewId", "getContentTextViewId", "setContentTextViewId", "contentTextViewIndex", "getContentTextViewIndex", "setContentTextViewIndex", "highlightDrawable", "Landroid/graphics/drawable/Drawable;", "getHighlightDrawable", "()Landroid/graphics/drawable/Drawable;", "setHighlightDrawable", "(Landroid/graphics/drawable/Drawable;)V", "indicatorContentId", "getIndicatorContentId", "setIndicatorContentId", "indicatorContentIndex", "getIndicatorContentIndex", "setIndicatorContentIndex", "layoutConvexHeight", "getLayoutConvexHeight", "setLayoutConvexHeight", "layoutHeight", "", "getLayoutHeight", "()Ljava/lang/String;", "setLayoutHeight", "(Ljava/lang/String;)V", "layoutWidth", "getLayoutWidth", "setLayoutWidth", "weight", "", "getWeight", "()F", "setWeight", "(F)V", "TabLayout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LayoutParams extends FrameLayout.LayoutParams {
        private int contentIconViewId;
        private int contentIconViewIndex;
        private int contentTextViewId;
        private int contentTextViewIndex;
        private Drawable highlightDrawable;
        private int indicatorContentId;
        private int indicatorContentIndex;
        private int layoutConvexHeight;
        private String layoutHeight;
        private String layoutWidth;
        private float weight;

        public final String getLayoutWidth() {
            return this.layoutWidth;
        }

        public final void setLayoutWidth(String str) {
            this.layoutWidth = str;
        }

        public final String getLayoutHeight() {
            return this.layoutHeight;
        }

        public final void setLayoutHeight(String str) {
            this.layoutHeight = str;
        }

        public final int getLayoutConvexHeight() {
            return this.layoutConvexHeight;
        }

        public final void setLayoutConvexHeight(int i) {
            this.layoutConvexHeight = i;
        }

        public final int getIndicatorContentIndex() {
            return this.indicatorContentIndex;
        }

        public final void setIndicatorContentIndex(int i) {
            this.indicatorContentIndex = i;
        }

        public final int getIndicatorContentId() {
            return this.indicatorContentId;
        }

        public final void setIndicatorContentId(int i) {
            this.indicatorContentId = i;
        }

        public final int getContentTextViewIndex() {
            return this.contentTextViewIndex;
        }

        public final void setContentTextViewIndex(int i) {
            this.contentTextViewIndex = i;
        }

        public final int getContentTextViewId() {
            return this.contentTextViewId;
        }

        public final void setContentTextViewId(int i) {
            this.contentTextViewId = i;
        }

        public final int getContentIconViewIndex() {
            return this.contentIconViewIndex;
        }

        public final void setContentIconViewIndex(int i) {
            this.contentIconViewIndex = i;
        }

        public final int getContentIconViewId() {
            return this.contentIconViewId;
        }

        public final void setContentIconViewId(int i) {
            this.contentIconViewId = i;
        }

        public final float getWeight() {
            return this.weight;
        }

        public final void setWeight(float f) {
            this.weight = f;
        }

        public final Drawable getHighlightDrawable() {
            return this.highlightDrawable;
        }

        public final void setHighlightDrawable(Drawable drawable) {
            this.highlightDrawable = drawable;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context c, AttributeSet attributeSet) {
            super(c, attributeSet);
            Intrinsics.checkNotNullParameter(c, "c");
            this.indicatorContentIndex = -1;
            this.indicatorContentId = -1;
            this.contentTextViewIndex = -1;
            this.contentTextViewId = -1;
            this.contentIconViewIndex = -1;
            this.contentIconViewId = -1;
            this.weight = -1.0f;
            TypedArray typedArrayObtainStyledAttributes = c.obtainStyledAttributes(attributeSet, R.styleable.DslTabLayout_Layout);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.layoutWidth = typedArrayObtainStyledAttributes.getString(R.styleable.DslTabLayout_Layout_layout_tab_width);
            this.layoutHeight = typedArrayObtainStyledAttributes.getString(R.styleable.DslTabLayout_Layout_layout_tab_height);
            this.layoutConvexHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DslTabLayout_Layout_layout_tab_convex_height, this.layoutConvexHeight);
            this.indicatorContentIndex = typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_Layout_layout_tab_indicator_content_index, this.indicatorContentIndex);
            this.indicatorContentId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DslTabLayout_Layout_layout_tab_indicator_content_id, this.indicatorContentId);
            this.weight = typedArrayObtainStyledAttributes.getFloat(R.styleable.DslTabLayout_Layout_layout_tab_weight, this.weight);
            this.highlightDrawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.DslTabLayout_Layout_layout_highlight_drawable);
            this.contentTextViewIndex = typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_Layout_layout_tab_text_view_index, this.contentTextViewIndex);
            this.contentIconViewIndex = typedArrayObtainStyledAttributes.getInt(R.styleable.DslTabLayout_Layout_layout_tab_text_view_index, this.contentIconViewIndex);
            this.contentTextViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DslTabLayout_Layout_layout_tab_text_view_id, this.contentTextViewId);
            this.contentIconViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DslTabLayout_Layout_layout_tab_icon_view_id, this.contentIconViewIndex);
            typedArrayObtainStyledAttributes.recycle();
            if (this.gravity == -1) {
                this.gravity = this.layoutConvexHeight > 0 ? 80 : 17;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            Intrinsics.checkNotNullParameter(source, "source");
            this.indicatorContentIndex = -1;
            this.indicatorContentId = -1;
            this.contentTextViewIndex = -1;
            this.contentTextViewId = -1;
            this.contentIconViewIndex = -1;
            this.contentIconViewId = -1;
            this.weight = -1.0f;
            if (source instanceof LayoutParams) {
                LayoutParams layoutParams = (LayoutParams) source;
                this.layoutWidth = layoutParams.layoutWidth;
                this.layoutHeight = layoutParams.layoutHeight;
                this.layoutConvexHeight = layoutParams.layoutConvexHeight;
                this.weight = layoutParams.weight;
                this.highlightDrawable = layoutParams.highlightDrawable;
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.indicatorContentIndex = -1;
            this.indicatorContentId = -1;
            this.contentTextViewIndex = -1;
            this.contentTextViewId = -1;
            this.contentIconViewIndex = -1;
            this.contentIconViewId = -1;
            this.weight = -1.0f;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
            this.indicatorContentIndex = -1;
            this.indicatorContentId = -1;
            this.contentTextViewIndex = -1;
            this.contentTextViewId = -1;
            this.contentIconViewIndex = -1;
            this.contentIconViewId = -1;
            this.weight = -1.0f;
        }
    }

    public final OverScroller get_overScroller() {
        return (OverScroller) this._overScroller.getValue();
    }

    public final GestureDetectorCompat get_gestureDetector() {
        return (GestureDetectorCompat) this._gestureDetector.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r3.getNeedScroll()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L39
            int r0 = r4.getActionMasked()
            if (r0 != 0) goto L21
            android.widget.OverScroller r0 = r3.get_overScroller()
            r0.abortAnimation()
            android.animation.ValueAnimator r0 = r3.get_scrollAnimator()
            r0.cancel()
        L21:
            boolean r0 = r3.isEnabled()
            if (r0 == 0) goto L44
            boolean r0 = super.onInterceptTouchEvent(r4)
            if (r0 != 0) goto L37
            androidx.core.view.GestureDetectorCompat r0 = r3.get_gestureDetector()
            boolean r4 = r0.onTouchEvent(r4)
            if (r4 == 0) goto L44
        L37:
            r4 = r1
            goto L45
        L39:
            boolean r0 = r3.isEnabled()
            if (r0 == 0) goto L44
            boolean r4 = super.onInterceptTouchEvent(r4)
            goto L45
        L44:
            r4 = r2
        L45:
            boolean r0 = r3.isEnabled()
            if (r0 == 0) goto L51
            boolean r0 = r3.itemEnableSelector
            if (r0 == 0) goto L52
            r1 = r4
            goto L52
        L51:
            r1 = r2
        L52:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.angcyo.tablayout.DslTabLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isEnabled()) {
            return false;
        }
        if (!getNeedScroll()) {
            return isEnabled() && super.onTouchEvent(event);
        }
        get_gestureDetector().onTouchEvent(event);
        if (event.getActionMasked() == 3 || event.getActionMasked() == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (event.getActionMasked() == 0) {
            get_overScroller().abortAnimation();
        }
        return true;
    }

    public final boolean getNeedScroll() {
        if (this.tabEnableSelectorMode) {
            return true;
        }
        if (isHorizontal()) {
            if (isLayoutRtl()) {
                if (getMinScrollX() < 0) {
                    return true;
                }
            } else if (getMaxScrollX() > 0) {
                return true;
            }
        } else if (getMaxScrollY() > 0) {
            return true;
        }
        return false;
    }

    public final int getMaxScrollX() {
        if (isLayoutRtl() && isHorizontal()) {
            if (this.tabEnableSelectorMode) {
                return LibExKt.getViewDrawWidth(this) / 2;
            }
            return 0;
        }
        return Math.max((getMaxWidth() - getMeasuredWidth()) + (this.tabEnableSelectorMode ? LibExKt.getViewDrawWidth(this) / 2 : 0), 0);
    }

    public final int getMaxScrollY() {
        return Math.max((getMaxHeight() - getMeasuredHeight()) + (this.tabEnableSelectorMode ? LibExKt.getViewDrawHeight(this) / 2 : 0), 0);
    }

    public final int getMinScrollX() {
        if (isLayoutRtl() && isHorizontal()) {
            return Math.min(-((getMaxWidth() - getMeasuredWidth()) + (this.tabEnableSelectorMode ? LibExKt.getViewDrawWidth(this) / 2 : 0)), 0);
        }
        if (this.tabEnableSelectorMode) {
            return (-LibExKt.getViewDrawWidth(this)) / 2;
        }
        return 0;
    }

    public final int getMinScrollY() {
        if (this.tabEnableSelectorMode) {
            return (-LibExKt.getViewDrawHeight(this)) / 2;
        }
        return 0;
    }

    public final int getMaxWidth() {
        return this._childAllWidthSum + getPaddingStart() + getPaddingEnd();
    }

    public final int getMaxHeight() {
        return this._childAllWidthSum + getPaddingTop() + getPaddingBottom();
    }

    public void onFlingChange(float velocity) {
        if (getNeedScroll()) {
            if (this.tabEnableSelectorMode) {
                if (isHorizontal() && isLayoutRtl()) {
                    if (velocity < 0.0f) {
                        setCurrentItem$default(this, getDslSelector().getDslSelectIndex() - 1, false, true, 2, null);
                        return;
                    } else {
                        if (velocity > 0.0f) {
                            setCurrentItem$default(this, getDslSelector().getDslSelectIndex() + 1, false, true, 2, null);
                            return;
                        }
                        return;
                    }
                }
                if (velocity < 0.0f) {
                    setCurrentItem$default(this, getDslSelector().getDslSelectIndex() + 1, false, true, 2, null);
                    return;
                } else {
                    if (velocity > 0.0f) {
                        setCurrentItem$default(this, getDslSelector().getDslSelectIndex() - 1, false, true, 2, null);
                        return;
                    }
                    return;
                }
            }
            if (isHorizontal()) {
                if (isLayoutRtl()) {
                    startFling(-((int) velocity), getMinScrollX(), 0);
                    return;
                } else {
                    startFling(-((int) velocity), 0, getMaxScrollX());
                    return;
                }
            }
            startFling(-((int) velocity), 0, getMaxHeight());
        }
    }

    private static final int startFling$velocity(DslTabLayout dslTabLayout, int i) {
        if (i > 0) {
            return LibExKt.clamp(i, dslTabLayout._minFlingVelocity, dslTabLayout._maxFlingVelocity);
        }
        return LibExKt.clamp(i, -dslTabLayout._maxFlingVelocity, -dslTabLayout._minFlingVelocity);
    }

    public final void startFling(int velocity, int min, int max) {
        int iStartFling$velocity = startFling$velocity(this, velocity);
        get_overScroller().abortAnimation();
        if (isHorizontal()) {
            get_overScroller().fling(getScrollX(), getScrollY(), iStartFling$velocity, 0, min, max, 0, 0, getMeasuredWidth(), 0);
        } else {
            get_overScroller().fling(getScrollX(), getScrollY(), 0, iStartFling$velocity, 0, 0, min, max, 0, getMeasuredHeight());
        }
        postInvalidate();
    }

    public final void startScroll(int dv) {
        get_overScroller().abortAnimation();
        if (isHorizontal()) {
            get_overScroller().startScroll(getScrollX(), getScrollY(), dv, 0, this.scrollAnimDuration);
        } else {
            get_overScroller().startScroll(getScrollX(), getScrollY(), 0, dv, this.scrollAnimDuration);
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public final void restoreScroll() {
        if (this.itemIsEquWidth || !getNeedScroll()) {
            if (getScrollX() == 0 && getScrollY() == 0) {
                return;
            }
            scrollTo(0, 0);
        }
    }

    public boolean onScrollChange(float distance) {
        if (!getNeedScroll()) {
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.tabEnableSelectorMode) {
            if (isHorizontal()) {
                scrollBy((int) distance, 0);
            } else {
                scrollBy(0, (int) distance);
            }
        }
        return true;
    }

    @Override // android.view.View
    public void scrollTo(int x, int y) {
        if (isHorizontal()) {
            if (x > getMaxScrollX()) {
                super.scrollTo(getMaxScrollX(), 0);
                return;
            } else if (x < getMinScrollX()) {
                super.scrollTo(getMinScrollX(), 0);
                return;
            } else {
                super.scrollTo(x, 0);
                return;
            }
        }
        if (y > getMaxScrollY()) {
            super.scrollTo(0, getMaxScrollY());
        } else if (y < getMinScrollY()) {
            super.scrollTo(0, getMinScrollY());
        } else {
            super.scrollTo(0, y);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (get_overScroller().computeScrollOffset()) {
            scrollTo(get_overScroller().getCurrX(), get_overScroller().getCurrY());
            invalidate();
            if (get_overScroller().getCurrX() < getMinScrollX() || get_overScroller().getCurrX() > getMaxScrollX()) {
                get_overScroller().abortAnimation();
            }
        }
    }

    public final int _getViewTargetX() {
        int indicatorGravity = this.tabIndicator.getIndicatorGravity();
        if (indicatorGravity == 1) {
            return getPaddingStart();
        }
        if (indicatorGravity == 2) {
            return getMeasuredWidth() - getPaddingEnd();
        }
        return getPaddingStart() + (LibExKt.getViewDrawWidth(this) / 2);
    }

    public final int _getViewTargetY() {
        int indicatorGravity = this.tabIndicator.getIndicatorGravity();
        if (indicatorGravity == 1) {
            return getPaddingTop();
        }
        if (indicatorGravity == 2) {
            return getMeasuredHeight() - getPaddingBottom();
        }
        return getPaddingTop() + (LibExKt.getViewDrawHeight(this) / 2);
    }

    public final void _scrollToTarget(int index, boolean scrollAnim) {
        int scrollY;
        int measuredHeight;
        int scrollY2;
        int i;
        if (getNeedScroll()) {
            View view = (View) CollectionsKt.getOrNull(getDslSelector().getVisibleViewList(), index);
            if (view == null || ViewCompat.isLaidOut(view)) {
                if (isHorizontal()) {
                    int childTargetX$default = DslTabIndicator.getChildTargetX$default(this.tabIndicator, index, 0, 2, null);
                    int i_getViewTargetX = _getViewTargetX();
                    if (this.tabEnableSelectorMode) {
                        measuredHeight = childTargetX$default - (getMeasuredWidth() / 2);
                        scrollY2 = getScrollX();
                    } else if (isLayoutRtl()) {
                        if (childTargetX$default < i_getViewTargetX) {
                            measuredHeight = childTargetX$default - i_getViewTargetX;
                            scrollY2 = getScrollX();
                        } else {
                            scrollY = getScrollX();
                            i = -scrollY;
                        }
                    } else if (childTargetX$default > i_getViewTargetX) {
                        measuredHeight = childTargetX$default - i_getViewTargetX;
                        scrollY2 = getScrollX();
                    } else {
                        scrollY = getScrollX();
                        i = -scrollY;
                    }
                    i = measuredHeight - scrollY2;
                } else {
                    int childTargetY$default = DslTabIndicator.getChildTargetY$default(this.tabIndicator, index, 0, 2, null);
                    int i_getViewTargetY = _getViewTargetY();
                    if (this.tabEnableSelectorMode) {
                        measuredHeight = childTargetY$default - (getMeasuredHeight() / 2);
                        scrollY2 = getScrollY();
                    } else if (childTargetY$default > i_getViewTargetY) {
                        measuredHeight = childTargetY$default - i_getViewTargetY;
                        scrollY2 = getScrollY();
                    } else if (this.tabIndicator.getIndicatorGravity() == 2 && childTargetY$default < i_getViewTargetY) {
                        measuredHeight = childTargetY$default - i_getViewTargetY;
                        scrollY2 = getScrollY();
                    } else {
                        scrollY = getScrollY();
                        i = -scrollY;
                    }
                    i = measuredHeight - scrollY2;
                }
                if (isHorizontal()) {
                    if (isInEditMode() || !scrollAnim) {
                        get_overScroller().abortAnimation();
                        scrollBy(i, 0);
                        return;
                    } else {
                        startScroll(i);
                        return;
                    }
                }
                if (isInEditMode() || !scrollAnim) {
                    get_overScroller().abortAnimation();
                    scrollBy(0, i);
                } else {
                    startScroll(i);
                }
            }
        }
    }

    public final ValueAnimator get_scrollAnimator() {
        return (ValueAnimator) this._scrollAnimator.getValue();
    }

    public final boolean isAnimatorStart() {
        return get_scrollAnimator().isStarted();
    }

    public final void _animateToItem(int fromIndex, int toIndex) {
        if (toIndex == fromIndex) {
            return;
        }
        get_scrollAnimator().cancel();
        if (!this.tabIndicator.getIndicatorAnim()) {
            _onAnimateEnd();
            return;
        }
        if (fromIndex < 0) {
            this.tabIndicator.setCurrentIndex(toIndex);
        } else {
            this.tabIndicator.setCurrentIndex(fromIndex);
        }
        this.tabIndicator.set_targetIndex(toIndex);
        if (isInEditMode()) {
            this.tabIndicator.setCurrentIndex(toIndex);
        } else {
            if (this.tabIndicator.getCurrentIndex() == this.tabIndicator.get_targetIndex()) {
                return;
            }
            get_scrollAnimator().setFloatValues(this.tabIndicator.getPositionOffset(), 1.0f);
            get_scrollAnimator().start();
        }
    }

    public final void _onAnimateValue(float value) {
        this.tabIndicator.setPositionOffset(value);
        DslTabLayoutConfig dslTabLayoutConfig = this.tabLayoutConfig;
        if (dslTabLayoutConfig != null) {
            dslTabLayoutConfig.onPageIndexScrolled(this.tabIndicator.getCurrentIndex(), this.tabIndicator.get_targetIndex(), value);
        }
        DslTabLayoutConfig dslTabLayoutConfig2 = this.tabLayoutConfig;
        if (dslTabLayoutConfig2 != null) {
            List<View> visibleViewList = getDslSelector().getVisibleViewList();
            View view = (View) CollectionsKt.getOrNull(visibleViewList, this.tabIndicator.get_targetIndex());
            if (view != null) {
                dslTabLayoutConfig2.onPageViewScrolled((View) CollectionsKt.getOrNull(visibleViewList, this.tabIndicator.getCurrentIndex()), view, value);
            }
        }
    }

    public final void _onAnimateEnd() {
        this.tabIndicator.setCurrentIndex(getDslSelector().getDslSelectIndex());
        DslTabIndicator dslTabIndicator = this.tabIndicator;
        dslTabIndicator.set_targetIndex(dslTabIndicator.getCurrentIndex());
        this.tabIndicator.setPositionOffset(0.0f);
    }

    public final ViewPagerDelegate get_viewPagerDelegate() {
        return this._viewPagerDelegate;
    }

    public final void set_viewPagerDelegate(ViewPagerDelegate viewPagerDelegate) {
        this._viewPagerDelegate = viewPagerDelegate;
    }

    public final int get_viewPagerScrollState() {
        return this._viewPagerScrollState;
    }

    public final void set_viewPagerScrollState(int i) {
        this._viewPagerScrollState = i;
    }

    public final void onPageScrollStateChanged(int state) {
        this._viewPagerScrollState = state;
        if (state == 0) {
            _onAnimateEnd();
            getDslSelector().updateStyle();
        }
    }

    public final void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (isAnimatorStart()) {
            return;
        }
        ViewPagerDelegate viewPagerDelegate = this._viewPagerDelegate;
        if (position < (viewPagerDelegate != null ? viewPagerDelegate.onGetCurrentItem() : 0)) {
            if (this._viewPagerScrollState == 1) {
                this.tabIndicator.setCurrentIndex(position + 1);
                this.tabIndicator.set_targetIndex(position);
            }
            _onAnimateValue(1 - positionOffset);
            return;
        }
        if (this._viewPagerScrollState == 1) {
            this.tabIndicator.setCurrentIndex(position);
            this.tabIndicator.set_targetIndex(position + 1);
        }
        _onAnimateValue(positionOffset);
    }

    public final void onPageSelected(int position) {
        setCurrentItem(position, true, false);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            super.onRestoreInstanceState(bundle.getParcelable("old"));
            this.tabDefaultIndex = bundle.getInt("defaultIndex", this.tabDefaultIndex);
            int i = bundle.getInt("currentIndex", -1);
            getDslSelector().setDslSelectIndex(-1);
            if (i > 0) {
                setCurrentItem(i, true, false);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(state);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("old", parcelableOnSaveInstanceState);
        bundle.putInt("defaultIndex", this.tabDefaultIndex);
        bundle.putInt("currentIndex", getCurrentItemIndex());
        return bundle;
    }
}
