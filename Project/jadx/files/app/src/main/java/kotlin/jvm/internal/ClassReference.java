package kotlin.jvm.internal;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.jvm.b.o;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.b.r;
import kotlin.jvm.b.s;
import kotlin.jvm.b.t;
import kotlin.jvm.b.u;
import kotlin.jvm.b.v;
import kotlin.jvm.b.w;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: kotlin.jvm.internal.d, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ClassReference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001MB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010D\u001a\u00020\u00122\b\u0010E\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020\u00122\b\u0010K\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010L\u001a\u00020/H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u001a\u0010\"\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0014\u001a\u0004\b\"\u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001e\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u001e\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0010R\u0016\u0010+\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\u0004\u0018\u00010/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R(\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0014\u001a\u0004\b4\u0010\u000bR\u0016\u00105\u001a\u0004\u0018\u00010/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00101R \u00107\u001a\b\u0012\u0004\u0012\u0002080\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0014\u001a\u0004\b:\u0010\u000bR \u0010;\u001a\b\u0012\u0004\u0012\u00020<0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0014\u001a\u0004\b>\u0010\u000bR\u001c\u0010?\u001a\u0004\u0018\u00010@8VX\u0097\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0014\u001a\u0004\bB\u0010C¨\u0006N"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", TTDownloadField.TT_HASHCODE, "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
public final class ClassReference implements kotlin.reflect.c<Object>, c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Map<Class<? extends kotlin.c<?>>, Integer> f20960t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final HashMap<String, String> f20961u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final HashMap<String, String> f20962v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final HashMap<String, String> f20963w;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    private final Class<?> f20964s;

    /* JADX INFO: renamed from: kotlin.jvm.internal.d$a */
    /* JADX INFO: compiled from: ClassReference.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        new a(null);
        int i2 = 0;
        List listB = kotlin.collections.k.b(kotlin.jvm.b.a.class, kotlin.jvm.b.l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, kotlin.jvm.b.b.class, kotlin.jvm.b.c.class, kotlin.jvm.b.d.class, kotlin.jvm.b.e.class, kotlin.jvm.b.f.class, kotlin.jvm.b.g.class, kotlin.jvm.b.h.class, kotlin.jvm.b.i.class, kotlin.jvm.b.j.class, kotlin.jvm.b.k.class, kotlin.jvm.b.m.class, kotlin.jvm.b.n.class, o.class);
        ArrayList arrayList = new ArrayList(kotlin.collections.l.a(listB, 10));
        for (Object obj : listB) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.collections.i.c();
                throw null;
            }
            arrayList.add(kotlin.h.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        f20960t = y.a(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f20961u = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f20962v = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(f20961u);
        map3.putAll(f20962v);
        for (String str : f20961u.values()) {
            Pair pairA = kotlin.h.a("kotlin.jvm.internal." + StringsKt__StringsKt.a(str, '.', (String) null, 2, (Object) null) + "CompanionObject", str + ".Companion");
            map3.put(pairA.h(), pairA.i());
        }
        for (Map.Entry<Class<? extends kotlin.c<?>>, Integer> entry : f20960t.entrySet()) {
            Class<? extends kotlin.c<?>> key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            map3.put(key.getName(), "kotlin.Function" + iIntValue);
        }
        f20963w = map3;
        HashMap<String, String> map4 = f20963w;
        LinkedHashMap linkedHashMap = new LinkedHashMap(x.a(map4.size()));
        Iterator<T> it = map4.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            linkedHashMap.put(entry2.getKey(), StringsKt__StringsKt.a((String) entry2.getValue(), '.', (String) null, 2, (Object) null));
        }
    }

    public ClassReference(@NotNull Class<?> cls) {
        this.f20964s = cls;
    }

    @Override // kotlin.jvm.internal.c
    @NotNull
    public Class<?> a() {
        return this.f20964s;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof ClassReference) && i.a(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) other));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    @NotNull
    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
