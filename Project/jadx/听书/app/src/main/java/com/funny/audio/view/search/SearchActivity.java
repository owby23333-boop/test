package com.funny.audio.view.search;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.QuickAdapterHelper;
import com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.funny.audio.AppManager;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.SearchHistoryEntity;
import com.funny.audio.databinding.ActivitySearchBinding;
import com.funny.audio.models.AssociateInfo;
import com.funny.audio.models.AssociateRelationType;
import com.funny.audio.models.HotSearchAlbumInfo;
import com.funny.audio.models.HotSearchKeywordInfo;
import com.funny.audio.models.SearchAlbumInfo;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.adapters.AssociateAdapter;
import com.funny.audio.view.adapters.HotSearchAlbumAdapter;
import com.funny.audio.view.adapters.HotSearchKeywordAdapter;
import com.funny.audio.view.adapters.SearchAlbumAdapter;
import com.funny.audio.view.adapters.SearchHistoryAdapter;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.LinearSpacingItemDecoration;
import com.funny.audio.view.core.StatusBarUtils;
import com.google.android.flexbox.FlexboxLayoutManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SearchActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010 \u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0011\u0010#\u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0016J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020!H\u0016J\u0011\u0010.\u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0011\u0010/\u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0011\u00100\u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0011\u00101\u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0019\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00105\u001a\u00020!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lcom/funny/audio/view/search/SearchActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivitySearchBinding;", "()V", "associateAdapter", "Lcom/funny/audio/view/adapters/AssociateAdapter;", "associates", "", "Lcom/funny/audio/models/AssociateInfo;", "currentSearchKeyword", "", "hotSearchAlbumAdapter", "Lcom/funny/audio/view/adapters/HotSearchAlbumAdapter;", "hotSearchAlbums", "Lcom/funny/audio/models/HotSearchAlbumInfo;", "hotSearchKeywordAdapter", "Lcom/funny/audio/view/adapters/HotSearchKeywordAdapter;", "hotSearchKeywords", "Lcom/funny/audio/models/HotSearchKeywordInfo;", "isSearchKeyword", "", "page", "", "pageSize", "searchAlbumAdapter", "Lcom/funny/audio/view/adapters/SearchAlbumAdapter;", "searchAlbumHelper", "Lcom/chad/library/adapter4/QuickAdapterHelper;", "searchHistories", "Lcom/funny/audio/database/entities/SearchHistoryEntity;", "searchHistoryAdapter", "Lcom/funny/audio/view/adapters/SearchHistoryAdapter;", "clearSearchHistory", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "etKeywordInput", "initAssociate", "initData", "initHotSearchAlbum", "initHotSearchKeyword", "initSearchAlbum", "initSearchBar", "initSearchHistory", "initStatusBar", "initTopBar", "initView", "loadHotSearchAlbums", "loadHotSearchKeyword", "loadSearchAlbums", "loadSearchHistory", "saveSearchHistory", "keyword", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchAlbum", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchActivity extends BaseActivity<ActivitySearchBinding> {
    private boolean isSearchKeyword;
    private QuickAdapterHelper searchAlbumHelper;
    private final HotSearchKeywordAdapter hotSearchKeywordAdapter = new HotSearchKeywordAdapter();
    private List<HotSearchKeywordInfo> hotSearchKeywords = new ArrayList();
    private final SearchHistoryAdapter searchHistoryAdapter = new SearchHistoryAdapter();
    private List<SearchHistoryEntity> searchHistories = new ArrayList();
    private final HotSearchAlbumAdapter hotSearchAlbumAdapter = new HotSearchAlbumAdapter();
    private List<HotSearchAlbumInfo> hotSearchAlbums = new ArrayList();
    private final AssociateAdapter associateAdapter = new AssociateAdapter();
    private List<AssociateInfo> associates = new ArrayList();
    private final SearchAlbumAdapter searchAlbumAdapter = new SearchAlbumAdapter();
    private String currentSearchKeyword = "";
    private int page = 1;
    private int pageSize = 15;

    /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$clearSearchHistory$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity", f = "SearchActivity.kt", i = {}, l = {TTAdConstant.IMAGE_LIST_SIZE_CODE}, m = "clearSearchHistory", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchActivity.this.clearSearchHistory(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$etKeywordInput$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity", f = "SearchActivity.kt", i = {0}, l = {322}, m = "etKeywordInput", n = {"this"}, s = {"L$0"})
    static final class C06351 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06351(Continuation<? super C06351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchActivity.this.etKeywordInput(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$loadHotSearchAlbums$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity", f = "SearchActivity.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME}, m = "loadHotSearchAlbums", n = {"this"}, s = {"L$0"})
    static final class C06411 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06411(Continuation<? super C06411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchActivity.this.loadHotSearchAlbums(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$loadHotSearchKeyword$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity", f = "SearchActivity.kt", i = {0}, l = {134}, m = "loadHotSearchKeyword", n = {"this"}, s = {"L$0"})
    static final class C06421 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06421(Continuation<? super C06421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchActivity.this.loadHotSearchKeyword(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$loadSearchAlbums$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity", f = "SearchActivity.kt", i = {0}, l = {TypedValues.Cycle.TYPE_WAVE_PERIOD}, m = "loadSearchAlbums", n = {"this"}, s = {"L$0"})
    static final class C06431 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06431(Continuation<? super C06431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchActivity.this.loadSearchAlbums(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$loadSearchHistory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity", f = "SearchActivity.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME}, m = "loadSearchHistory", n = {"this"}, s = {"L$0"})
    static final class C06441 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06441(Continuation<? super C06441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchActivity.this.loadSearchHistory(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$saveSearchHistory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity", f = "SearchActivity.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE}, m = "saveSearchHistory", n = {}, s = {})
    static final class C06451 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06451(Continuation<? super C06451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchActivity.this.saveSearchHistory(null, this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$searchAlbum$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity", f = "SearchActivity.kt", i = {0, 1}, l = {357, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP_FPS_LIMIT}, m = "searchAlbum", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class C06481 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06481(Continuation<? super C06481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchActivity.this.searchAlbum(this);
        }
    }

    public static final /* synthetic */ ActivitySearchBinding access$getBd(SearchActivity searchActivity) {
        return searchActivity.getBd();
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        initStatusBar();
        initTopBar();
        initSearchHistory();
        initHotSearchKeyword();
        initHotSearchAlbum();
        initAssociate();
        initSearchAlbum();
        initSearchBar();
    }

    /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$initData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity$initData$1", f = "SearchActivity.kt", i = {}, l = {79, 80, 81}, m = "invokeSuspend", n = {}, s = {})
    static final class C06361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06361(Continuation<? super C06361> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SearchActivity.this.new C06361(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0051 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r6)
                goto L52
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1d:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L44
            L21:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L36
            L25:
                kotlin.ResultKt.throwOnFailure(r6)
                com.funny.audio.view.search.SearchActivity r6 = com.funny.audio.view.search.SearchActivity.this
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r4
                java.lang.Object r6 = com.funny.audio.view.search.SearchActivity.access$loadHotSearchKeyword(r6, r1)
                if (r6 != r0) goto L36
                return r0
            L36:
                com.funny.audio.view.search.SearchActivity r6 = com.funny.audio.view.search.SearchActivity.this
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r3
                java.lang.Object r6 = com.funny.audio.view.search.SearchActivity.access$loadSearchHistory(r6, r1)
                if (r6 != r0) goto L44
                return r0
            L44:
                com.funny.audio.view.search.SearchActivity r6 = com.funny.audio.view.search.SearchActivity.this
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r2
                java.lang.Object r6 = com.funny.audio.view.search.SearchActivity.access$loadHotSearchAlbums(r6, r1)
                if (r6 != r0) goto L52
                return r0
            L52:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.search.SearchActivity.C06361.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C06361(null), 3, null);
    }

    private final void initStatusBar() {
        SearchActivity searchActivity = this;
        StatusBarUtils.INSTANCE.translucent(searchActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(searchActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(searchActivity);
        }
    }

    private final void initTopBar() {
        ImageView imageView = getBd().appBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.appBack");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.search.SearchActivity.initTopBar.1
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
                SearchActivity.this.finish();
            }
        }, 1, null);
        TextView textView = getBd().btnSearch;
        Intrinsics.checkNotNullExpressionValue(textView, "bd.btnSearch");
        ViewKt.click$default(textView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.search.SearchActivity.initTopBar.2
            {
                super(0);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$initTopBar$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: SearchActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity$initTopBar$2$1", f = "SearchActivity.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SearchActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SearchActivity searchActivity, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = searchActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.this$0.searchAlbum(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(SearchActivity.this, null), 3, null);
            }
        }, 1, null);
    }

    private final void initHotSearchKeyword() {
        getBd().lyHotSearchKeyword.setVisibility(8);
        RecyclerView recyclerView = getBd().rvHotSearchKeyword;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.setFlexWrap(1);
        flexboxLayoutManager.setFlexDirection(0);
        flexboxLayoutManager.setJustifyContent(0);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.hotSearchKeywordAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.search.SearchActivity$$ExternalSyntheticLambda5
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchActivity.initHotSearchKeyword$lambda$2(this.f$0, baseQuickAdapter, view, i);
            }
        }, 1, null);
        getBd().rvHotSearchKeyword.setAdapter(this.hotSearchKeywordAdapter);
        this.hotSearchKeywordAdapter.submitList(this.hotSearchKeywords);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHotSearchKeyword$lambda$2(SearchActivity this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        HotSearchKeywordInfo hotSearchKeywordInfo = (HotSearchKeywordInfo) adapter.getItem(i);
        if (hotSearchKeywordInfo != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SearchActivity$initHotSearchKeyword$2$1$1(this$0, hotSearchKeywordInfo, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadHotSearchKeyword(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.funny.audio.view.search.SearchActivity.C06421
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.search.SearchActivity$loadHotSearchKeyword$1 r0 = (com.funny.audio.view.search.SearchActivity.C06421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.search.SearchActivity$loadHotSearchKeyword$1 r0 = new com.funny.audio.view.search.SearchActivity$loadHotSearchKeyword$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.search.SearchActivity r0 = (com.funny.audio.view.search.SearchActivity) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> Lb4
            goto L60
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> Lb4
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11     // Catch: java.lang.Exception -> Lb4
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r11)     // Catch: java.lang.Exception -> Lb4
            r5 = 0
            r6 = 0
            com.funny.audio.view.search.SearchActivity$loadHotSearchKeyword$resp$1 r11 = new com.funny.audio.view.search.SearchActivity$loadHotSearchKeyword$resp$1     // Catch: java.lang.Exception -> Lb4
            r2 = 0
            r11.<init>(r2)     // Catch: java.lang.Exception -> Lb4
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> Lb4
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> Lb4
            r0.L$0 = r10     // Catch: java.lang.Exception -> Lb4
            r0.label = r3     // Catch: java.lang.Exception -> Lb4
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> Lb4
            if (r11 != r1) goto L5f
            return r1
        L5f:
            r0 = r10
        L60:
            com.funny.audio.core.net.Response r11 = (com.funny.audio.core.net.Response) r11     // Catch: java.lang.Exception -> Lb4
            boolean r1 = com.funny.audio.core.net.NetModelsKt.successWithData(r11)     // Catch: java.lang.Exception -> Lb4
            if (r1 == 0) goto Lb4
            com.funny.audio.core.net.AppBody r11 = r11.getBody()     // Catch: java.lang.Exception -> Lb4
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)     // Catch: java.lang.Exception -> Lb4
            java.lang.Object r11 = r11.getData()     // Catch: java.lang.Exception -> Lb4
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)     // Catch: java.lang.Exception -> Lb4
            java.util.List r11 = (java.util.List) r11     // Catch: java.lang.Exception -> Lb4
            r1 = r11
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Exception -> Lb4
            boolean r1 = kotlin.collections.CollectionsKt.any(r1)     // Catch: java.lang.Exception -> Lb4
            if (r1 == 0) goto Lb4
            java.util.List<com.funny.audio.models.HotSearchKeywordInfo> r1 = r0.hotSearchKeywords     // Catch: java.lang.Exception -> Lb4
            r1.clear()     // Catch: java.lang.Exception -> Lb4
            java.lang.Iterable r11 = (java.lang.Iterable) r11     // Catch: java.lang.Exception -> Lb4
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Exception -> Lb4
        L8c:
            boolean r1 = r11.hasNext()     // Catch: java.lang.Exception -> Lb4
            if (r1 == 0) goto La3
            java.lang.Object r1 = r11.next()     // Catch: java.lang.Exception -> Lb4
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> Lb4
            java.util.List<com.funny.audio.models.HotSearchKeywordInfo> r2 = r0.hotSearchKeywords     // Catch: java.lang.Exception -> Lb4
            com.funny.audio.models.HotSearchKeywordInfo r3 = new com.funny.audio.models.HotSearchKeywordInfo     // Catch: java.lang.Exception -> Lb4
            r3.<init>(r1)     // Catch: java.lang.Exception -> Lb4
            r2.add(r3)     // Catch: java.lang.Exception -> Lb4
            goto L8c
        La3:
            com.funny.audio.view.adapters.HotSearchKeywordAdapter r11 = r0.hotSearchKeywordAdapter     // Catch: java.lang.Exception -> Lb4
            r11.notifyDataSetChanged()     // Catch: java.lang.Exception -> Lb4
            androidx.viewbinding.ViewBinding r11 = r0.getBd()     // Catch: java.lang.Exception -> Lb4
            com.funny.audio.databinding.ActivitySearchBinding r11 = (com.funny.audio.databinding.ActivitySearchBinding) r11     // Catch: java.lang.Exception -> Lb4
            android.widget.LinearLayout r11 = r11.lyHotSearchKeyword     // Catch: java.lang.Exception -> Lb4
            r0 = 0
            r11.setVisibility(r0)     // Catch: java.lang.Exception -> Lb4
        Lb4:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.search.SearchActivity.loadHotSearchKeyword(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void initSearchHistory() {
        getBd().lySearchHistory.setVisibility(8);
        RecyclerView recyclerView = getBd().rvSearchHistory;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.setFlexWrap(1);
        flexboxLayoutManager.setFlexDirection(0);
        flexboxLayoutManager.setJustifyContent(0);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.searchHistoryAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.search.SearchActivity$$ExternalSyntheticLambda1
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchActivity.initSearchHistory$lambda$6(this.f$0, baseQuickAdapter, view, i);
            }
        }, 1, null);
        getBd().rvSearchHistory.setAdapter(this.searchHistoryAdapter);
        this.searchHistoryAdapter.submitList(this.searchHistories);
        ImageView imageView = getBd().ivClearSearchHistory;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.ivClearSearchHistory");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.search.SearchActivity.initSearchHistory.3
            {
                super(0);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$initSearchHistory$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: SearchActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity$initSearchHistory$3$1", f = "SearchActivity.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SearchActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SearchActivity searchActivity, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = searchActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.this$0.clearSearchHistory(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(SearchActivity.this, null), 3, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSearchHistory$lambda$6(SearchActivity this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        SearchHistoryEntity searchHistoryEntity = (SearchHistoryEntity) adapter.getItem(i);
        if (searchHistoryEntity != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SearchActivity$initSearchHistory$2$1$1(this$0, searchHistoryEntity, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadSearchHistory(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.funny.audio.view.search.SearchActivity.C06441
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.search.SearchActivity$loadSearchHistory$1 r0 = (com.funny.audio.view.search.SearchActivity.C06441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.search.SearchActivity$loadSearchHistory$1 r0 = new com.funny.audio.view.search.SearchActivity$loadSearchHistory$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.search.SearchActivity r0 = (com.funny.audio.view.search.SearchActivity) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L89
            goto L60
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L89
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11     // Catch: java.lang.Exception -> L89
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r11)     // Catch: java.lang.Exception -> L89
            r5 = 0
            r6 = 0
            com.funny.audio.view.search.SearchActivity$loadSearchHistory$list$1 r11 = new com.funny.audio.view.search.SearchActivity$loadSearchHistory$list$1     // Catch: java.lang.Exception -> L89
            r2 = 0
            r11.<init>(r2)     // Catch: java.lang.Exception -> L89
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L89
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L89
            r0.L$0 = r10     // Catch: java.lang.Exception -> L89
            r0.label = r3     // Catch: java.lang.Exception -> L89
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> L89
            if (r11 != r1) goto L5f
            return r1
        L5f:
            r0 = r10
        L60:
            java.util.List r11 = (java.util.List) r11     // Catch: java.lang.Exception -> L89
            r1 = r11
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Exception -> L89
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Exception -> L89
            r1 = r1 ^ r3
            if (r1 == 0) goto L89
            java.util.List<com.funny.audio.database.entities.SearchHistoryEntity> r1 = r0.searchHistories     // Catch: java.lang.Exception -> L89
            r1.clear()     // Catch: java.lang.Exception -> L89
            java.util.List<com.funny.audio.database.entities.SearchHistoryEntity> r1 = r0.searchHistories     // Catch: java.lang.Exception -> L89
            java.util.Collection r11 = (java.util.Collection) r11     // Catch: java.lang.Exception -> L89
            r1.addAll(r11)     // Catch: java.lang.Exception -> L89
            com.funny.audio.view.adapters.SearchHistoryAdapter r11 = r0.searchHistoryAdapter     // Catch: java.lang.Exception -> L89
            r11.notifyDataSetChanged()     // Catch: java.lang.Exception -> L89
            androidx.viewbinding.ViewBinding r11 = r0.getBd()     // Catch: java.lang.Exception -> L89
            com.funny.audio.databinding.ActivitySearchBinding r11 = (com.funny.audio.databinding.ActivitySearchBinding) r11     // Catch: java.lang.Exception -> L89
            android.widget.LinearLayout r11 = r11.lySearchHistory     // Catch: java.lang.Exception -> L89
            r0 = 0
            r11.setVisibility(r0)     // Catch: java.lang.Exception -> L89
        L89:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.search.SearchActivity.loadSearchHistory(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void initHotSearchAlbum() {
        getBd().lyHotSearchAlbum.setVisibility(8);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.hotSearchAlbumAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.search.SearchActivity$$ExternalSyntheticLambda4
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchActivity.initHotSearchAlbum$lambda$8(this.f$0, baseQuickAdapter, view, i);
            }
        }, 1, null);
        getBd().rvHotSearchAlbum.setLayoutManager(new LinearLayoutManager(this));
        getBd().rvHotSearchAlbum.setAdapter(this.hotSearchAlbumAdapter);
        this.hotSearchAlbumAdapter.submitList(this.hotSearchAlbums);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHotSearchAlbum$lambda$8(SearchActivity this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        HotSearchAlbumInfo hotSearchAlbumInfo = (HotSearchAlbumInfo) adapter.getItem(i);
        if (hotSearchAlbumInfo != null) {
            NavigationUtils.INSTANCE.toAlbumDetail(this$0, hotSearchAlbumInfo.getId());
        }
    }

    private final void initAssociate() {
        getBd().lyAssociate.setVisibility(8);
        getBd().rvAssociate.setLayoutManager(new LinearLayoutManager(this));
        getBd().rvAssociate.setAdapter(this.associateAdapter);
        this.associateAdapter.submitList(this.associates);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.associateAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.search.SearchActivity$$ExternalSyntheticLambda2
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchActivity.initAssociate$lambda$10(this.f$0, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAssociate$lambda$10(SearchActivity this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        AssociateInfo associateInfo = (AssociateInfo) adapter.getItem(i);
        if (associateInfo != null) {
            int relationType = associateInfo.getRelationType();
            if (relationType == AssociateRelationType.INSTANCE.getALBUM()) {
                NavigationUtils.INSTANCE.toAlbumDetail(this$0, associateInfo.getRelationId());
            } else if (relationType == AssociateRelationType.INSTANCE.getANNOUNCER()) {
                NavigationUtils.INSTANCE.toAnnouncerAlbum(this$0, associateInfo.getRelationId());
            }
        }
    }

    private final void initSearchAlbum() {
        TextView textView = getBd().tvPleaseAlbum;
        Intrinsics.checkNotNullExpressionValue(textView, "bd.tvPleaseAlbum");
        ViewKt.click$default(textView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.search.SearchActivity.initSearchAlbum.1
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
                NavigationUtils.INSTANCE.toPleaseAlbum(SearchActivity.this);
            }
        }, 1, null);
        getBd().lySearchResult.setVisibility(8);
        getBd().rvSearchResult.setLayoutManager(new LinearLayoutManager(this));
        this.searchAlbumAdapter.setItemAnimation(BaseQuickAdapter.AnimationType.ScaleIn);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.searchAlbumAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.search.SearchActivity$$ExternalSyntheticLambda3
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchActivity.initSearchAlbum$lambda$12(this.f$0, baseQuickAdapter, view, i);
            }
        }, 1, null);
        QuickAdapterHelper quickAdapterHelperBuild = new QuickAdapterHelper.Builder(this.searchAlbumAdapter).setTrailingLoadStateAdapter(new TrailingLoadStateAdapter.OnTrailingListener() { // from class: com.funny.audio.view.search.SearchActivity$initSearchAlbum$helper$1
            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onFailRetry() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SearchActivity$initSearchAlbum$helper$1$onFailRetry$1(this.this$0, null), 3, null);
            }

            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onLoad() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SearchActivity$initSearchAlbum$helper$1$onLoad$1(this.this$0, null), 3, null);
            }
        }).build();
        getBd().rvSearchResult.setAdapter(quickAdapterHelperBuild.getMAdapter());
        getBd().rvSearchResult.addItemDecoration(new LinearSpacingItemDecoration(getContext(), 12.0f, 10.0f, 1));
        this.searchAlbumHelper = quickAdapterHelperBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSearchAlbum$lambda$12(SearchActivity this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        SearchAlbumInfo searchAlbumInfo = (SearchAlbumInfo) adapter.getItem(i);
        if (searchAlbumInfo != null) {
            NavigationUtils.INSTANCE.toAlbumDetail(this$0, searchAlbumInfo.getAlbumId());
        }
    }

    private final void initSearchBar() {
        getBd().etKeyword.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.funny.audio.view.search.SearchActivity$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return SearchActivity.initSearchBar$lambda$13(this.f$0, textView, i, keyEvent);
            }
        });
        EditText editText = getBd().etKeyword;
        Intrinsics.checkNotNullExpressionValue(editText, "bd.etKeyword");
        editText.addTextChangedListener(new TextWatcher() { // from class: com.funny.audio.view.search.SearchActivity$initSearchBar$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SearchActivity$initSearchBar$2$1(this.this$0, null), 3, null);
            }
        });
        ImageView imageView = getBd().ivClearText;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.ivClearText");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.search.SearchActivity.initSearchBar.3
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
                SearchActivity.access$getBd(SearchActivity.this).etKeyword.setText("");
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initSearchBar$lambda$13(SearchActivity this$0, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i != 3) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SearchActivity$initSearchBar$1$1(this$0, null), 3, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object etKeywordInput(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.search.SearchActivity.etKeywordInput(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object searchAlbum(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.search.SearchActivity.searchAlbum(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object saveSearchHistory(final java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.funny.audio.view.search.SearchActivity.C06451
            if (r0 == 0) goto L14
            r0 = r12
            com.funny.audio.view.search.SearchActivity$saveSearchHistory$1 r0 = (com.funny.audio.view.search.SearchActivity.C06451) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.funny.audio.view.search.SearchActivity$saveSearchHistory$1 r0 = new com.funny.audio.view.search.SearchActivity$saveSearchHistory$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L9a
            goto L9a
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L32:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.List<com.funny.audio.database.entities.SearchHistoryEntity> r12 = r10.searchHistories     // Catch: java.lang.Exception -> L9a
            com.funny.audio.view.search.SearchActivity$saveSearchHistory$2 r2 = new com.funny.audio.view.search.SearchActivity$saveSearchHistory$2     // Catch: java.lang.Exception -> L9a
            r2.<init>()     // Catch: java.lang.Exception -> L9a
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch: java.lang.Exception -> L9a
            kotlin.collections.CollectionsKt.removeAll(r12, r2)     // Catch: java.lang.Exception -> L9a
            com.funny.audio.database.entities.SearchHistoryEntity r12 = new com.funny.audio.database.entities.SearchHistoryEntity     // Catch: java.lang.Exception -> L9a
            r12.<init>()     // Catch: java.lang.Exception -> L9a
            r12.setKeyword(r11)     // Catch: java.lang.Exception -> L9a
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L9a
            r12.setTime(r4)     // Catch: java.lang.Exception -> L9a
            java.util.List<com.funny.audio.database.entities.SearchHistoryEntity> r11 = r10.searchHistories     // Catch: java.lang.Exception -> L9a
            r2 = 0
            r11.add(r2, r12)     // Catch: java.lang.Exception -> L9a
            java.util.List<com.funny.audio.database.entities.SearchHistoryEntity> r11 = r10.searchHistories     // Catch: java.lang.Exception -> L9a
            java.util.Collection r11 = (java.util.Collection) r11     // Catch: java.lang.Exception -> L9a
            int r11 = r11.size()     // Catch: java.lang.Exception -> L9a
            r4 = 5
            if (r11 <= r4) goto L66
            java.util.List<com.funny.audio.database.entities.SearchHistoryEntity> r11 = r10.searchHistories     // Catch: java.lang.Exception -> L9a
            kotlin.collections.CollectionsKt.removeLast(r11)     // Catch: java.lang.Exception -> L9a
        L66:
            androidx.viewbinding.ViewBinding r11 = r10.getBd()     // Catch: java.lang.Exception -> L9a
            com.funny.audio.databinding.ActivitySearchBinding r11 = (com.funny.audio.databinding.ActivitySearchBinding) r11     // Catch: java.lang.Exception -> L9a
            android.widget.LinearLayout r11 = r11.lySearchHistory     // Catch: java.lang.Exception -> L9a
            r11.setVisibility(r2)     // Catch: java.lang.Exception -> L9a
            com.funny.audio.view.adapters.SearchHistoryAdapter r11 = r10.searchHistoryAdapter     // Catch: java.lang.Exception -> L9a
            r11.notifyDataSetChanged()     // Catch: java.lang.Exception -> L9a
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L9a
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11     // Catch: java.lang.Exception -> L9a
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r11)     // Catch: java.lang.Exception -> L9a
            r5 = 0
            r6 = 0
            com.funny.audio.view.search.SearchActivity$saveSearchHistory$3 r11 = new com.funny.audio.view.search.SearchActivity$saveSearchHistory$3     // Catch: java.lang.Exception -> L9a
            r2 = 0
            r11.<init>(r12, r2)     // Catch: java.lang.Exception -> L9a
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L9a
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L9a
            r0.label = r3     // Catch: java.lang.Exception -> L9a
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> L9a
            if (r11 != r1) goto L9a
            return r1
        L9a:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.search.SearchActivity.saveSearchHistory(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$saveSearchHistory$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity$saveSearchHistory$3", f = "SearchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06473 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SearchHistoryEntity $history;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06473(SearchHistoryEntity searchHistoryEntity, Continuation<? super C06473> continuation) {
            super(2, continuation);
            this.$history = searchHistoryEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06473(this.$history, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06473) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DbContext.INSTANCE.getCurrent().searchHistory().add(this.$history);
            List<SearchHistoryEntity> list = DbContext.INSTANCE.getCurrent().searchHistory().list();
            if (list.size() > 5) {
                DbContext.INSTANCE.getCurrent().searchHistory().remove(CollectionsKt.last((List) list));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object clearSearchHistory(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.funny.audio.view.search.SearchActivity.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.search.SearchActivity$clearSearchHistory$1 r0 = (com.funny.audio.view.search.SearchActivity.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.search.SearchActivity$clearSearchHistory$1 r0 = new com.funny.audio.view.search.SearchActivity$clearSearchHistory$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L70
            goto L70
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L32:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.List<com.funny.audio.database.entities.SearchHistoryEntity> r11 = r10.searchHistories     // Catch: java.lang.Exception -> L70
            r11.clear()     // Catch: java.lang.Exception -> L70
            com.funny.audio.view.adapters.SearchAlbumAdapter r11 = r10.searchAlbumAdapter     // Catch: java.lang.Exception -> L70
            r11.notifyDataSetChanged()     // Catch: java.lang.Exception -> L70
            androidx.viewbinding.ViewBinding r11 = r10.getBd()     // Catch: java.lang.Exception -> L70
            com.funny.audio.databinding.ActivitySearchBinding r11 = (com.funny.audio.databinding.ActivitySearchBinding) r11     // Catch: java.lang.Exception -> L70
            android.widget.LinearLayout r11 = r11.lySearchHistory     // Catch: java.lang.Exception -> L70
            r2 = 8
            r11.setVisibility(r2)     // Catch: java.lang.Exception -> L70
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L70
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11     // Catch: java.lang.Exception -> L70
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r11)     // Catch: java.lang.Exception -> L70
            r5 = 0
            r6 = 0
            com.funny.audio.view.search.SearchActivity$clearSearchHistory$2 r11 = new com.funny.audio.view.search.SearchActivity$clearSearchHistory$2     // Catch: java.lang.Exception -> L70
            r2 = 0
            r11.<init>(r2)     // Catch: java.lang.Exception -> L70
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L70
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L70
            r0.label = r3     // Catch: java.lang.Exception -> L70
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> L70
            if (r11 != r1) goto L70
            return r1
        L70:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.search.SearchActivity.clearSearchHistory(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.funny.audio.view.search.SearchActivity$clearSearchHistory$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.search.SearchActivity$clearSearchHistory$2", f = "SearchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DbContext.INSTANCE.getCurrent().searchHistory().clear();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[Catch: Exception -> 0x00d1, TryCatch #1 {Exception -> 0x00d1, blocks: (B:12:0x002a, B:21:0x0060, B:23:0x0068, B:25:0x0089, B:27:0x008d, B:29:0x009a, B:28:0x0093, B:30:0x00b0, B:31:0x00c0), top: B:40:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0 A[Catch: Exception -> 0x00d1, TRY_LEAVE, TryCatch #1 {Exception -> 0x00d1, blocks: (B:12:0x002a, B:21:0x0060, B:23:0x0068, B:25:0x0089, B:27:0x008d, B:29:0x009a, B:28:0x0093, B:30:0x00b0, B:31:0x00c0), top: B:40:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadSearchAlbums(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.search.SearchActivity.loadSearchAlbums(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadHotSearchAlbums(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.funny.audio.view.search.SearchActivity.C06411
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.search.SearchActivity$loadHotSearchAlbums$1 r0 = (com.funny.audio.view.search.SearchActivity.C06411) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.search.SearchActivity$loadHotSearchAlbums$1 r0 = new com.funny.audio.view.search.SearchActivity$loadHotSearchAlbums$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.search.SearchActivity r0 = (com.funny.audio.view.search.SearchActivity) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L9f
            goto L65
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.List<com.funny.audio.models.HotSearchAlbumInfo> r11 = r10.hotSearchAlbums     // Catch: java.lang.Exception -> L9f
            r11.clear()     // Catch: java.lang.Exception -> L9f
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L9f
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11     // Catch: java.lang.Exception -> L9f
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r11)     // Catch: java.lang.Exception -> L9f
            r5 = 0
            r6 = 0
            com.funny.audio.view.search.SearchActivity$loadHotSearchAlbums$resp$1 r11 = new com.funny.audio.view.search.SearchActivity$loadHotSearchAlbums$resp$1     // Catch: java.lang.Exception -> L9f
            r2 = 0
            r11.<init>(r2)     // Catch: java.lang.Exception -> L9f
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L9f
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L9f
            r0.L$0 = r10     // Catch: java.lang.Exception -> L9f
            r0.label = r3     // Catch: java.lang.Exception -> L9f
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> L9f
            if (r11 != r1) goto L64
            return r1
        L64:
            r0 = r10
        L65:
            com.funny.audio.core.net.Response r11 = (com.funny.audio.core.net.Response) r11     // Catch: java.lang.Exception -> L9f
            boolean r1 = com.funny.audio.core.net.NetModelsKt.successWithData(r11)     // Catch: java.lang.Exception -> L9f
            if (r1 == 0) goto L9a
            com.funny.audio.core.net.AppBody r11 = r11.getBody()     // Catch: java.lang.Exception -> L9f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)     // Catch: java.lang.Exception -> L9f
            java.lang.Object r11 = r11.getData()     // Catch: java.lang.Exception -> L9f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)     // Catch: java.lang.Exception -> L9f
            java.util.List r11 = (java.util.List) r11     // Catch: java.lang.Exception -> L9f
            r1 = r11
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Exception -> L9f
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Exception -> L9f
            r1 = r1 ^ r3
            if (r1 == 0) goto L9a
            androidx.viewbinding.ViewBinding r1 = r0.getBd()     // Catch: java.lang.Exception -> L9f
            com.funny.audio.databinding.ActivitySearchBinding r1 = (com.funny.audio.databinding.ActivitySearchBinding) r1     // Catch: java.lang.Exception -> L9f
            android.widget.LinearLayout r1 = r1.lyHotSearchAlbum     // Catch: java.lang.Exception -> L9f
            r2 = 0
            r1.setVisibility(r2)     // Catch: java.lang.Exception -> L9f
            java.util.List<com.funny.audio.models.HotSearchAlbumInfo> r1 = r0.hotSearchAlbums     // Catch: java.lang.Exception -> L9f
            java.util.Collection r11 = (java.util.Collection) r11     // Catch: java.lang.Exception -> L9f
            r1.addAll(r11)     // Catch: java.lang.Exception -> L9f
        L9a:
            com.funny.audio.view.adapters.HotSearchAlbumAdapter r11 = r0.hotSearchAlbumAdapter     // Catch: java.lang.Exception -> L9f
            r11.notifyDataSetChanged()     // Catch: java.lang.Exception -> L9f
        L9f:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.search.SearchActivity.loadHotSearchAlbums(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
