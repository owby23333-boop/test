package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLStartCompleteListener;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.iflytek.aikit.media.param.MscKeys;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DataLoaderHelper implements AVMDLDataLoaderListener, AVMDLStartCompleteListener {
    public static final int DATALOADER_KEY_ENABLE_ALOG = 512;
    public static final int DATALOADER_KEY_INT_MAXCACHESIZE = 1;
    public static final int DATALOADER_KEY_INT_OPENTIMEOUT = 3;
    public static final int DATALOADER_KEY_INT_PARALLEL_NUM = 11;
    public static final int DATALOADER_KEY_INT_RWTIMEOUT = 2;
    public static final int DATALOADER_KEY_INT_TRYCOUNT = 4;
    public static final int DATALOADER_KEY_SET_MDL_PROTOCOL_ENABLE = 1005;
    public static final int DATALOADER_KEY_STRING_CACHEDIR = 0;
    public static final int IsClose = 1;
    public static final int IsPlayTask = 1;
    public static final int IsPreloadTask = 2;
    public static final int IsStart = 0;
    public static final int IsUnknown = 0;
    public static final String MDL_PREFIX = "mdl://";
    private static final DataLoaderHelper p = new DataLoaderHelper();
    private static int q = 0;
    private static int r = 0;
    private static int s = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f2024b;
    private final d c;
    private final d d;
    private final d e;
    private AVMDLDataLoader i;
    private VideoEventEngineUploader k;
    private boolean m;
    private final ConcurrentHashMap<String, c> f = new ConcurrentHashMap<>();
    private final HashMap<String, ArrayList<TTVideoEngine>> g = new HashMap<>();
    private final ReentrantLock h = new ReentrantLock();
    private boolean l = true;
    private int n = 0;
    private final ReentrantLock o = new ReentrantLock();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f2023a = 1;
    private AVMDLDataLoaderConfigure j = AVMDLDataLoaderConfigure.getDefaultonfigure();

    public class DataLoaderCacheInfo {
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;
        public String mLocalFilePath = null;

        public DataLoaderCacheInfo(DataLoaderHelper dataLoaderHelper) {
        }
    }

    public static class DataLoaderTaskProgressInfo {
        public String mKey = null;
        public String mVideoId = null;
        public String mLocalFilePath = null;
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;
        public int mTaskType = 0;
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2025a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f2026b = 0;
        public PreloaderURLItem c = null;
        public boolean d = false;
        public List<a> e = new CopyOnWriteArrayList();

        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f2027a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f2028b = null;
            public String[] c = null;
            public String d = null;
            public long e = 0;
            public long f = 0;
            public long g = 0;
            public long h = 0;
            public long i = 0;

            public a(b bVar) {
            }
        }

        public b(DataLoaderHelper dataLoaderHelper) {
        }

        public a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a aVarB = b(str);
            if (aVarB != null) {
                return aVarB;
            }
            a aVar = new a(this);
            aVar.f2027a = str;
            this.e.add(aVar);
            return aVar;
        }

        public a b(String str) {
            if (this.e.size() > 0) {
                for (int i = 0; i < this.e.size(); i++) {
                    a aVar = this.e.get(i);
                    if (aVar.f2027a.equals(str)) {
                        return aVar;
                    }
                }
            }
            return null;
        }

        public IPreLoaderItemCallBackListener a() {
            PreloaderURLItem preloaderURLItem = this.c;
            if (preloaderURLItem == null || preloaderURLItem.getCallBackListener() == null) {
                return null;
            }
            return this.c.getCallBackListener();
        }

        public void a(int i) {
            TTVideoEngineLog.d("DataLoaderHelper", "startMDLPreloadTask _notifyError " + i);
            if (a() != null) {
                DataLoaderHelper.c();
                TTVideoEngineLog.d("DataLoaderHelper", "preloadCount engine callback " + DataLoaderHelper.s + ", KEY_IS_PRELOAD_END_FAIL");
                PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
                preLoaderItemCallBackInfo.preloadError = new Error(Error.DataLoaderPreload, i);
                a().preloadItemInfo(preLoaderItemCallBackInfo);
            }
        }

        public void a(String str, long j) {
            if (this.e.size() == 0) {
                a aVar = new a(this);
                aVar.f2027a = str;
                aVar.g = j;
                this.e.add(aVar);
            } else {
                TTVideoEngineLog.e("DataLoaderHelper", "[preload] DataLoaderTaskItem setup fail");
            }
            this.f2026b = j;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2030b = 0;
        public List<a> c = null;

        public class a {
            public String e;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f2031a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public long f2032b = 0;
            public long c = 0;
            public List<C0049a> d = null;
            public Error f = null;

            /* JADX INFO: renamed from: com.bykv.vk.component.ttvideo.DataLoaderHelper$c$a$a, reason: collision with other inner class name */
            public class C0049a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public long f2033a = 0;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public long f2034b = 0;

                public C0049a(a aVar) {
                }
            }

            public a(c cVar) {
            }

            public void a(long j) {
                if (this.d == null) {
                    this.d = new ArrayList();
                }
                if (this.d.size() == 0) {
                    this.d.add(new C0049a(this));
                }
                this.d.get(0).f2033a = 0L;
                this.d.get(0).f2034b = j;
            }

            public long b() {
                List<C0049a> list = this.d;
                if (list == null || list.size() <= 0) {
                    return 0L;
                }
                return this.d.get(r0.size() - 1).f2034b;
            }

            public boolean a() {
                long j = this.c;
                long jMin = j > 0 ? Math.min(j, this.f2032b) : this.f2032b;
                List<C0049a> list = this.d;
                C0049a c0049a = list != null ? list.get(list.size() - 1) : null;
                if (this.f == null) {
                    return c0049a != null && this.f2032b > 0 && c0049a.f2033a + c0049a.f2034b >= jMin;
                }
                return true;
            }
        }

        public c(DataLoaderHelper dataLoaderHelper) {
        }

        public long a() {
            long jB = 0;
            if (this.c != null) {
                for (int i = 0; i < this.c.size(); i++) {
                    jB += this.c.get(i).b();
                }
            }
            return jB;
        }

        public boolean b() {
            int i;
            boolean z = true;
            if (this.c != null) {
                i = 0;
                for (int i2 = 0; i2 < this.c.size(); i2++) {
                    a aVar = this.c.get(i2);
                    if (aVar == null || aVar.a()) {
                        i++;
                    } else {
                        z = false;
                    }
                }
            } else {
                i = 0;
            }
            if (z) {
                return true;
            }
            return i >= 2 && this.f2030b == 1;
        }

        public boolean c() {
            if (this.f2030b != 2) {
                TTVideoEngineLog.d("DataLoaderHelper", "task is not a preload task");
                return false;
            }
            if (this.c != null) {
                for (int i = 0; i < this.c.size(); i++) {
                    a aVar = this.c.get(i);
                    if (aVar != null && !aVar.a()) {
                        return false;
                    }
                }
            }
            return true;
        }

        private a a(String str) {
            List<a> list;
            if (!TextUtils.isEmpty(str) && (list = this.c) != null) {
                for (a aVar : list) {
                    if (aVar.f2031a.equals(str)) {
                        return aVar;
                    }
                }
            }
            return null;
        }

        public void a(b bVar) {
            boolean z;
            String str = bVar.f2025a;
            if (this.c == null) {
                this.c = new ArrayList();
            }
            for (b.a aVar : bVar.e) {
                a aVarA = a(aVar.f2027a);
                if (aVarA == null) {
                    aVarA = new a(this);
                    z = false;
                } else {
                    z = true;
                }
                aVarA.f2031a = aVar.f2027a;
                aVarA.f2032b = aVar.h;
                aVarA.a(aVar.i);
                aVarA.c = aVar.g;
                aVarA.e = aVar.d;
                if (!z) {
                    this.c.add(aVarA);
                }
            }
        }

        public void a(String str, Error error) {
            a aVarA = a(str);
            if (aVarA != null) {
                aVarA.f = error;
            }
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ReentrantLock f2035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<b> f2036b;
        private long c;

        private d(DataLoaderHelper dataLoaderHelper) {
            this.f2035a = new ReentrantLock();
            this.f2036b = new ArrayList<>();
            this.c = 0L;
        }

        private Boolean e() {
            if (this.c >= 1) {
                return Boolean.valueOf(((long) this.f2036b.size()) >= this.c);
            }
            return Boolean.FALSE;
        }

        public b a() {
            this.f2035a.lock();
            if (this.f2036b.size() == 0) {
                this.f2035a.unlock();
                return null;
            }
            b bVar = this.f2036b.get(r0.size() - 1);
            this.f2035a.unlock();
            return bVar;
        }

        public long b() {
            this.f2035a.lock();
            long size = this.f2036b.size();
            this.f2035a.unlock();
            return size;
        }

        public b c() {
            this.f2035a.lock();
            if (this.f2036b.size() == 0) {
                this.f2035a.unlock();
                return null;
            }
            b bVar = this.f2036b.get(r0.size() - 1);
            this.f2036b.remove(bVar);
            this.f2035a.unlock();
            return bVar;
        }

        public b d(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f2035a.lock();
            int i = 0;
            while (true) {
                if (i >= this.f2036b.size()) {
                    break;
                }
                b bVar2 = this.f2036b.get(i);
                if (!TextUtils.isEmpty(bVar2.f2025a) && bVar2.f2025a.equals(str)) {
                    bVar = bVar2;
                    break;
                }
                i++;
            }
            if (bVar != null) {
                this.f2036b.remove(bVar);
            }
            this.f2035a.unlock();
            return bVar;
        }

        public void a(long j) {
            this.c = j;
        }

        public b b(b bVar) {
            b bVarC;
            if (TextUtils.isEmpty(bVar.f2025a)) {
                bVarC = null;
            } else {
                bVarC = d(bVar.f2025a);
                if (bVarC != null) {
                    return bVarC;
                }
            }
            Iterator<b.a> it = bVar.e.iterator();
            while (it.hasNext() && (bVarC = c(it.next().f2027a)) == null) {
            }
            return bVarC;
        }

        public b c(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f2035a.lock();
            int i = 0;
            while (true) {
                if (i >= this.f2036b.size()) {
                    break;
                }
                b bVar2 = this.f2036b.get(i);
                if (bVar2.b(str) != null) {
                    bVar = bVar2;
                    break;
                }
                i++;
            }
            if (bVar != null) {
                TTVideoEngineLog.d("DataLoaderHelper", "popItem remove this " + this + ", item " + bVar);
                this.f2036b.remove(bVar);
            }
            this.f2035a.unlock();
            return bVar;
        }

        public ArrayList<b> d() {
            try {
                this.f2035a.lock();
                return new ArrayList<>(this.f2036b);
            } finally {
                this.f2035a.unlock();
            }
        }

        public boolean a(b bVar) {
            Boolean bool;
            if (bVar == null || bVar.e.size() == 0) {
                return false;
            }
            this.f2035a.lock();
            if (e().booleanValue()) {
                bool = Boolean.FALSE;
            } else {
                this.f2036b.add(bVar);
                bool = Boolean.TRUE;
            }
            this.f2035a.unlock();
            return bool.booleanValue();
        }

        public b b(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f2035a.lock();
            int i = 0;
            while (true) {
                if (i >= this.f2036b.size()) {
                    break;
                }
                b bVar2 = this.f2036b.get(i);
                if (bVar2.b(str) != null) {
                    bVar = bVar2;
                    break;
                }
                i++;
            }
            this.f2035a.unlock();
            return bVar;
        }

        public boolean a(String str) {
            int i = 0;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Boolean bool = Boolean.FALSE;
            this.f2035a.lock();
            while (true) {
                if (i >= this.f2036b.size()) {
                    break;
                }
                if (this.f2036b.get(i).b(str) != null) {
                    bool = Boolean.TRUE;
                    break;
                }
                i++;
            }
            this.f2035a.unlock();
            return bool.booleanValue();
        }
    }

    private DataLoaderHelper() {
        this.f2024b = new d();
        this.c = new d();
        this.d = new d();
        this.e = new d();
    }

    private String a(String str, String str2, long j, long j2, String[] strArr, String str3) {
        String strEncode;
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length < 1) {
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        long j3 = j2 > 0 ? j2 : 0L;
        for (String str4 : strArr2) {
            if (!c(str4)) {
                return null;
            }
        }
        String[] strArrA = a(strArr2);
        String strEncodeUrl = encodeUrl(str);
        if (TextUtils.isEmpty(strEncodeUrl)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("preloadProxyQuery: key = ");
        String str5 = str;
        sb.append(str);
        sb.append(", rawKey = ");
        sb.append(str2);
        TTVideoEngineLog.i("DataLoaderHelper", sb.toString());
        if (!TextUtils.isEmpty(str2)) {
            str5 = str2;
        }
        String strEncodeUrl2 = encodeUrl(str5);
        if (TextUtils.isEmpty(strEncodeUrl2)) {
            strEncodeUrl2 = "videoId";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?rk=");
        stringBuffer.append(strEncodeUrl2);
        stringBuffer.append("&k=");
        stringBuffer.append(strEncodeUrl);
        if (j3 > 0) {
            stringBuffer.append("&s=");
            stringBuffer.append(j + j3);
        }
        if (!TextUtils.isEmpty(str3)) {
            try {
                strEncode = URLEncoder.encode(str3, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                strEncode = null;
            }
            if (!TextUtils.isEmpty(strEncode)) {
                stringBuffer.append("&p=");
                stringBuffer.append(strEncode);
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i = 0; i < strArrA.length; i++) {
            String strEncodeUrlByQuery = encodeUrlByQuery(strArrA[i]);
            StringBuffer stringBuffer3 = new StringBuffer();
            if (!TextUtils.isEmpty(strEncodeUrlByQuery)) {
                stringBuffer3.append("&u");
                stringBuffer3.append(i);
                stringBuffer3.append(MscKeys.KEY_VAL_SEP);
                stringBuffer3.append(strEncodeUrlByQuery);
            }
            if (stringBuffer.length() + stringBuffer2.length() + stringBuffer3.length() + 32 > 3096) {
                break;
            }
            stringBuffer2.append(stringBuffer3);
        }
        if (stringBuffer2.length() < 1) {
            return null;
        }
        stringBuffer.append(stringBuffer2);
        return stringBuffer.toString();
    }

    public static /* synthetic */ int c() {
        int i = s;
        s = i + 1;
        return i;
    }

    private boolean d() {
        if (this.i != null) {
            return true;
        }
        if (AVMDLDataLoader.init(false, false) != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "library has not been loaded");
            return false;
        }
        try {
            AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
            this.i = aVMDLDataLoader;
            aVMDLDataLoader.setConfigure(this.j);
            this.i.setListener(this);
            this.i.setStartCompleteListener(this);
            return true;
        } catch (Exception e) {
            TTVideoEngineLog.d(e);
            return false;
        }
    }

    public static String encodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String encodeUrlByQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        TTVideoEngineLog.d("TTHelperEncode", "before encode:" + str);
        try {
            String strQueryComponentEncode = AVMDLDataLoader.queryComponentEncode(str);
            if (TextUtils.isEmpty(strQueryComponentEncode)) {
                TTVideoEngineLog.d("TTHelperEncode", "call native encode fail,try java");
                strQueryComponentEncode = URLEncoder.encode(str, "UTF-8");
            }
            TTVideoEngineLog.d("TTHelperEncode", "after encode:" + strQueryComponentEncode);
            return strQueryComponentEncode;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static DataLoaderHelper getDataLoader() {
        return p;
    }

    public void _addEngine(TTVideoEngine tTVideoEngine, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.h.lock();
            ArrayList<TTVideoEngine> arrayList = this.g.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.g.put(str, arrayList);
            }
            if (!arrayList.contains(tTVideoEngine)) {
                arrayList.add(tTVideoEngine);
                TTVideoEngineLog.i("DataLoaderHelper", "add engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
            }
        } finally {
            this.h.unlock();
        }
    }

    public String _proxyUrl(String str, String str2, long j, String[] strArr, String str3) {
        if (this.f2023a != 0 || TextUtils.isEmpty(str) || strArr == null || strArr.length < 1) {
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (String str4 : strArr2) {
            if (!c(str4)) {
                TTVideoEngineLog.d("DataLoaderHelper", "not support");
                return str4;
            }
        }
        if (this.i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "start mdl first");
            return null;
        }
        this.o.lock();
        try {
            String localAddr = this.i.getLocalAddr();
            if (TextUtils.isEmpty(localAddr)) {
                TTVideoEngineLog.e("DataLoaderHelper", "local host error");
                return null;
            }
            String strA = a(str, str2, 0L, j, strArr2, str3);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i = this.n;
            this.n = i + 1;
            StringBuffer stringBuffer2 = new StringBuffer();
            TTVideoEngineLog.i("DataLoaderHelper", "proxy url, mInvalidMdlProcotol: " + this.l);
            if (this.l || !this.m) {
                stringBuffer.append("http://");
                stringBuffer.append(localAddr);
                stringBuffer.append("/");
                stringBuffer.append(i);
            } else {
                stringBuffer.append(MDL_PREFIX);
                stringBuffer.append("id");
                stringBuffer.append(i);
                stringBuffer.append("/");
            }
            stringBuffer.append(strA);
            stringBuffer2.append(strA);
            String auth = this.i.getAuth(strA);
            if (!TextUtils.isEmpty(auth)) {
                stringBuffer.append("&ah=");
                stringBuffer.append(auth);
                stringBuffer.append("&ah=");
                stringBuffer.append(auth);
            }
            String string = stringBuffer.toString();
            TTVideoEngineLog.i("DataLoaderHelper", "_proxyUrl: " + string);
            this.o.unlock();
            b bVarD = this.e.d(str2);
            if (bVarD == null) {
                bVarD = new b(this);
            }
            b.a aVarA = bVarD.a(str);
            if (aVarA != null) {
                aVarA.f2027a = str;
                bVarD.f2025a = str2;
                aVarA.f2028b = string;
                aVarA.c = strArr2;
                aVarA.d = str3;
                this.e.a(bVarD);
            }
            return string;
        } finally {
            this.o.unlock();
        }
    }

    public void _removeEngine(TTVideoEngine tTVideoEngine, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.h.lock();
            ArrayList<TTVideoEngine> arrayList = this.g.get(str);
            if (arrayList != null) {
                arrayList.remove(tTVideoEngine);
                TTVideoEngineLog.i("DataLoaderHelper", "remove engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
                if (arrayList.size() == 0) {
                    this.g.remove(str);
                }
            }
        } finally {
            this.h.unlock();
        }
    }

    public void _removePlayTask(String str) {
        this.e.c(str);
    }

    public void addTask(PreloaderURLItem preloaderURLItem) {
        q++;
        TTVideoEngineLog.d("DataLoaderHelper", "preloadCount addTask " + q);
        if (preloaderURLItem == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] url item invalid");
            return;
        }
        this.o.lock();
        try {
            a(preloaderURLItem.getKey(), preloaderURLItem.getVideoId(), preloaderURLItem.getPreloadSize(), preloaderURLItem);
        } finally {
            this.o.unlock();
        }
    }

    public void cancelAllTasks() {
        if (this.i == null || this.f2023a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
            return;
        }
        this.o.lock();
        try {
            cancelAllTasksInternal();
        } finally {
            try {
            } finally {
            }
        }
    }

    public void cancelAllTasksInternal() {
        TTVideoEngineLog.d("DataLoaderHelper", "cancelAllTasksInternal");
        a(this.c);
        a(this.f2024b);
        if (a(this.d)) {
            this.i.cancelAll();
        }
    }

    public void cancelTask(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.i == null || this.f2023a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
            return;
        }
        this.o.lock();
        try {
            b bVarC = this.f2024b.c(str);
            if (bVarC == null && (bVarC = this.c.c(str)) == null) {
                bVarC = this.d.c(str);
                if (bVarC != null) {
                    this.i.cancel(str);
                    c(bVarC);
                }
                TTVideoEngineLog.i("DataLoaderHelper", "[preload] cancel preload task. key = " + str);
            } else {
                c(bVarC);
                TTVideoEngineLog.i("DataLoaderHelper", "[preload] cancel preload task. key = " + str);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public void clearAllCaches() {
        AVMDLDataLoader aVMDLDataLoader;
        if (this.f2023a != 0) {
            return;
        }
        this.o.lock();
        try {
            aVMDLDataLoader = this.i;
        } finally {
            try {
            } finally {
            }
        }
        if (aVMDLDataLoader == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
        } else {
            aVMDLDataLoader.clearAllCaches();
        }
    }

    public void close() {
        this.o.lock();
        try {
            if (this.f2023a == 1) {
                TTVideoEngineLog.e("DataLoaderHelper", "DataLoader not started, not need close");
            } else {
                this.i.close();
                cancelAllTasksInternal();
                this.f2023a = 1;
            }
        } finally {
            this.o.unlock();
        }
    }

    public DataLoaderCacheInfo getCacheInfoByFilePath(String str, String str2) {
        this.o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.i;
            if (aVMDLDataLoader != null) {
                return b(aVMDLDataLoader.getStringCacheInfo(str, str2));
            }
        } finally {
            try {
            } finally {
            }
        }
        return null;
    }

    public long getCacheSize(String str) {
        long j = 0;
        if (this.f2023a != 0) {
            return 0L;
        }
        this.o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.i;
            if (aVMDLDataLoader != null) {
                long cacheSize = aVMDLDataLoader.getCacheSize(str);
                if (cacheSize > 0) {
                    j = cacheSize;
                }
            }
        } finally {
            try {
            } finally {
            }
        }
        return j;
    }

    public long getCacheSizeByFilePath(String str, String str2) {
        TTVideoEngineLog.d("DataLoaderHelper", "getCacheSizeByFilePath key:" + str + ", filePath:" + str2);
        this.o.lock();
        try {
            DataLoaderCacheInfo cacheInfoByFilePath = getCacheInfoByFilePath(str, str2);
            long j = cacheInfoByFilePath != null ? cacheInfoByFilePath.mCacheSizeFromZero : 0L;
            TTVideoEngineLog.d("DataLoaderHelper", "getCacheSizeByFilePath result:" + j);
            return j;
        } catch (Throwable th) {
            try {
                TTVideoEngineLog.d(th);
                return 0L;
            } finally {
                this.o.unlock();
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getCheckSumInfo(String str) {
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public long getInt64Value(int i, long j) {
        return 0L;
    }

    public c getLoadProgressByRawKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f.get(str);
        }
        TTVideoEngineLog.e("DataLoaderHelper", "[preload] get, param is invalid key is null");
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getStringValue(int i, long j, String str) {
        return null;
    }

    public void notifyPreloadError(PreloaderURLItem preloaderURLItem, int i) {
        TTVideoEngineLog.d("DataLoaderHelper", "notifyPreloadError " + i);
        IPreLoaderItemCallBackListener callBackListener = preloaderURLItem.getCallBackListener();
        if (callBackListener != null) {
            s++;
            TTVideoEngineLog.d("DataLoaderHelper", "preloadCount engine callback " + s + ", KEY_IS_PRELOAD_END_FAIL");
            PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
            preLoaderItemCallBackInfo.preloadError = new Error(Error.DataLoaderPreload, i);
            callBackListener.preloadItemInfo(preLoaderItemCallBackInfo);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public void onNotify(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        String str;
        JSONObject jSONObject;
        if (aVMDLDataLoaderNotifyInfo == null) {
            return;
        }
        try {
            jSONObject = aVMDLDataLoaderNotifyInfo.jsonLog;
        } catch (Exception e) {
            e.printStackTrace();
        }
        String string = jSONObject != null ? jSONObject.toString() : "";
        int i = aVMDLDataLoaderNotifyInfo.what;
        if (i != 0 && i != 15) {
            if (i != 20) {
                if (i == 3 || i == 4) {
                    TTVideoEngineLog.d("DataLoaderHelper", "KeyIsFileCacheProgress log = " + aVMDLDataLoaderNotifyInfo.logInfo + ", what = " + aVMDLDataLoaderNotifyInfo.what + ", task type = " + aVMDLDataLoaderNotifyInfo.parameter + " code = " + ((int) aVMDLDataLoaderNotifyInfo.code));
                    if (aVMDLDataLoaderNotifyInfo.what == 4) {
                        r++;
                        TTVideoEngineLog.d("DataLoaderHelper", "preloadCount mdl callback " + r + ", KeyIsPreloadEnd");
                    }
                    if (aVMDLDataLoaderNotifyInfo.logInfo != null) {
                        long j = aVMDLDataLoaderNotifyInfo.parameter;
                        if (j != 3) {
                            a(aVMDLDataLoaderNotifyInfo, j == 2, aVMDLDataLoaderNotifyInfo.what == 4);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i == 7) {
                    r++;
                    TTVideoEngineLog.d("DataLoaderHelper", "preloadCount mdl callback " + r + ", KeyIsIsPreloadCancel");
                    if (TextUtils.isEmpty(aVMDLDataLoaderNotifyInfo.logInfo)) {
                        TTVideoEngineLog.d("DataLoaderHelper", "KeyIsIsPreloadCancel log is empty");
                        return;
                    }
                    TTVideoEngineLog.d("DataLoaderHelper", "KeyIsIsPreloadCancel " + aVMDLDataLoaderNotifyInfo.logInfo);
                    String[] strArrSplit = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
                    if (strArrSplit.length < 4) {
                        return;
                    }
                    String str2 = strArrSplit[2];
                    b bVarB = this.d.b(str2);
                    this.d.c(str2);
                    c(bVarB);
                    return;
                }
                if (i != 8) {
                    if (i != 10 && i != 11) {
                        return;
                    }
                }
            }
            TTVideoEngineLog.d("DataLoaderHelper", "KeyIsPreloadFail " + aVMDLDataLoaderNotifyInfo.what + " " + aVMDLDataLoaderNotifyInfo.parameter + " " + aVMDLDataLoaderNotifyInfo.logInfo);
            if (aVMDLDataLoaderNotifyInfo.what == 8) {
                r++;
                TTVideoEngineLog.d("DataLoaderHelper", "preloadCount mdl callback " + r + ", KeyIsPreloadFail");
            }
            String str3 = aVMDLDataLoaderNotifyInfo.logInfo;
            if ((str3 == null || aVMDLDataLoaderNotifyInfo.parameter != 3) && str3 != null) {
                TTVideoEngineLog.i("DataLoaderHelper", " task fail log = " + aVMDLDataLoaderNotifyInfo.logInfo + ", code = " + aVMDLDataLoaderNotifyInfo.code + ", task type = " + aVMDLDataLoaderNotifyInfo.parameter);
                String[] strArrSplit2 = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
                if (strArrSplit2.length < 1) {
                    TTVideoEngineLog.d("DataLoaderHelper", "preloadCount temArray.length " + strArrSplit2.length);
                    return;
                }
                String str4 = strArrSplit2[0];
                b bVarB2 = this.d.b(str4);
                if (bVarB2 == null) {
                    TTVideoEngineLog.d("DataLoaderHelper", "preloadCount item is null");
                    return;
                }
                d dVar = this.d;
                Error error = new Error(Error.DataLoaderPreload, (int) aVMDLDataLoaderNotifyInfo.code, aVMDLDataLoaderNotifyInfo.logInfo);
                String str5 = TextUtils.isEmpty(bVarB2.f2025a) ? str4 : bVarB2.f2025a;
                c loadProgressByRawKey = getLoadProgressByRawKey(str5);
                if (loadProgressByRawKey == null) {
                    loadProgressByRawKey = new c(this);
                }
                loadProgressByRawKey.f2029a = bVarB2.f2025a;
                loadProgressByRawKey.f2030b = (int) aVMDLDataLoaderNotifyInfo.parameter;
                loadProgressByRawKey.a(bVarB2);
                loadProgressByRawKey.a(str4, error);
                putByRawKey(str5, loadProgressByRawKey);
                if (loadProgressByRawKey.b() || loadProgressByRawKey.c()) {
                    dVar.c(str4);
                    TTVideoEngineLog.i("DataLoaderHelper", "pop all task item. videoId = " + bVarB2.f2025a + " key = " + str4);
                    removeLoadProgressByRawKey(str5);
                    if (bVarB2.a() != null && aVMDLDataLoaderNotifyInfo.parameter == 2) {
                        PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
                        preLoaderItemCallBackInfo.preloadError = error;
                        preLoaderItemCallBackInfo.loadProgress = loadProgressByRawKey;
                        preLoaderItemCallBackInfo.preloadDataInfo = null;
                        s++;
                        TTVideoEngineLog.d("DataLoaderHelper", "preloadCount engine callback " + s + ", KEY_IS_PRELOAD_END_FAIL");
                        bVarB2.a().preloadItemInfo(preLoaderItemCallBackInfo);
                        return;
                    }
                    str = "getCallBackListener IS NULL";
                } else {
                    str = "preloadCount callback " + loadProgressByRawKey.b() + "isPreloadComplete " + loadProgressByRawKey.c();
                }
                TTVideoEngineLog.d("DataLoaderHelper", str);
                return;
            }
            return;
        }
        TTVideoEngineLog.d("DataLoaderHelper", "uploadLog type:" + aVMDLDataLoaderNotifyInfo.what + ", logType:" + aVMDLDataLoaderNotifyInfo.logType + ", TaskLog: " + string);
        VideoEventEngineUploader videoEventEngineUploader = this.k;
        if (videoEventEngineUploader != null) {
            videoEventEngineUploader.onEvent(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLStartCompleteListener
    public void onStartComplete() {
        TTVideoEngineLog.d("DataLoaderHelper", "MediaDataLoader start complete");
    }

    public void putByRawKey(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] param is invalid");
        } else {
            this.f.put(str, cVar);
        }
    }

    public void removeCacheFile(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.o.lock();
        try {
            if (this.i == null) {
                TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
            } else {
                TTVideoEngineLog.i("DataLoaderHelper", "remove mdl file. key " + str);
                if (z) {
                    this.i.forceRemoveFileCache(str);
                } else {
                    this.i.removeFileCache(str);
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public void removeLoadProgressByRawKey(String str) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] remove, param is invalid key is null");
        } else {
            this.f.remove(str);
        }
    }

    public void setCacheInfoLists(String[] strArr, long[] jArr) {
        TTVideoEngineLog.d("DataLoaderHelper", "setCacheInfoLists dirs:" + Arrays.toString(strArr) + ", maxCaches " + Arrays.toString(jArr));
        this.o.lock();
        try {
            this.j.setCacheInfoList(strArr, jArr);
        } finally {
            this.o.unlock();
        }
    }

    public void setContext(Context context) {
        this.o.lock();
        this.o.unlock();
    }

    public synchronized void setEngineUploader(VideoEventEngineUploader videoEventEngineUploader) {
        TTVideoEngineLog.d("DataLoaderHelper", "setEngineUploader " + videoEventEngineUploader);
        this.k = videoEventEngineUploader;
    }

    public void setIntValue(int i, int i2) {
        this.o.lock();
        TTVideoEngineLog.d("DataLoaderHelper", "setIntValue key = " + i + ", value = " + i2);
        try {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i == 11) {
                this.j.mPreloadParallelNum = i2;
                AVMDLDataLoader aVMDLDataLoader = this.i;
                if (aVMDLDataLoader != null) {
                    aVMDLDataLoader.setIntValue(102, i2);
                }
            } else if (i != 512) {
                boolean z = true;
                if (i == 1005) {
                    if (i2 != 1) {
                        z = false;
                    }
                    this.m = z;
                    TTVideoEngineLog.i("DataLoaderHelper", "config DATALOADER_KEY_SET_MDL_PROTOCOL_ENABLE: " + this.m);
                } else if (i == 1) {
                    this.j.mMaxCacheSize = i2;
                } else if (i == 2) {
                    this.j.mRWTimeOut = i2;
                } else {
                    if (i != 3) {
                        if (i == 4) {
                            this.j.mTryCount = i2;
                        }
                    }
                    this.j.mOpenTimeOut = i2;
                }
            } else {
                this.j.mAlogEnable = i2;
                AVMDLDataLoader aVMDLDataLoader2 = this.i;
                if (aVMDLDataLoader2 != null) {
                    aVMDLDataLoader2.setIntValue(AVMDLDataLoader.KeyIsAlogEnable, i2);
                }
            }
        } finally {
            this.o.unlock();
        }
    }

    public void setStringValue(int i, String str) {
        TTVideoEngineLog.d("DataLoaderHelper", "setStringValue key = " + i + ", value = " + str);
        this.o.lock();
        if (i == 0) {
            try {
                try {
                    this.j.mCacheDir = str;
                } catch (Exception e) {
                    TTVideoEngineLog.d(e);
                }
            } finally {
                this.o.unlock();
            }
        }
    }

    public void start() {
        TTVideoEngineLog.d("DataLoaderHelper", "start");
        this.o.lock();
        try {
            if (this.f2023a == 0) {
                TTVideoEngineLog.e("DataLoaderHelper", "DataLoader has started not need start");
            } else {
                if (!d()) {
                    throw new Exception("init data loader fail");
                }
                this.c.a(4L);
                if (this.j == null) {
                    this.j = AVMDLDataLoaderConfigure.getDefaultonfigure();
                }
                if (this.k != null) {
                    this.j.mEnableReportTaskLog = 1;
                }
                this.i.setConfigure(this.j);
                if (this.i.start() < 0) {
                    throw new Exception("start data loader fail");
                }
                long longValue = this.i.getLongValue(AVMDLDataLoader.KeyIsGetMdlProtocolHandle);
                if (longValue == -1) {
                    this.l = true;
                }
                this.f2023a = 0;
                TTVideoEngineLog.d("DataLoaderHelper", "DataLoader start mdlProtocolHandle:" + longValue);
            }
        } finally {
            this.o.unlock();
        }
    }

    private ArrayList<TTVideoEngine> a(String str) {
        ArrayList<TTVideoEngine> arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            this.h.lock();
            ArrayList<TTVideoEngine> arrayList2 = this.g.get(str);
            if (arrayList2 != null) {
                arrayList = new ArrayList<>(arrayList2);
                TTVideoEngineLog.i("DataLoaderHelper", "get engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
            }
            return arrayList;
        } finally {
            this.h.unlock();
        }
    }

    private DataLoaderCacheInfo b(String str) {
        DataLoaderCacheInfo dataLoaderCacheInfo = null;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length >= 4) {
            dataLoaderCacheInfo = new DataLoaderCacheInfo(this);
            dataLoaderCacheInfo.mLocalFilePath = strArrSplit[3];
            if (!TextUtils.isEmpty(strArrSplit[0])) {
                dataLoaderCacheInfo.mCacheSizeFromZero = Long.parseLong(strArrSplit[0]);
            }
            if (!TextUtils.isEmpty(strArrSplit[1])) {
                dataLoaderCacheInfo.mMediaSize = Long.parseLong(strArrSplit[1]);
            }
            TTVideoEngineLog.d("DataLoaderHelper", "get cache info.");
        }
        return dataLoaderCacheInfo;
    }

    private void c(b bVar) {
        String str;
        if (bVar == null) {
            str = "_notifyPreloadCancel taskItem is null";
        } else {
            if (!bVar.d) {
                bVar.d = true;
                if (bVar.a() == null) {
                    TTVideoEngineLog.d("DataLoaderHelper", "_notifyPreloadCancel getCallBackListener is null");
                    return;
                }
                s++;
                TTVideoEngineLog.d("DataLoaderHelper", "preloadCount engine callback " + s + ", KEY_IS_PRELOAD_END_CANCEL");
                bVar.a().preloadItemInfo(new PreLoaderItemCallBackInfo(5));
                return;
            }
            str = "_notifyPreloadCancel didCanceled";
        }
        TTVideoEngineLog.d("DataLoaderHelper", str);
    }

    private void a() {
        if (this.i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            return;
        }
        b bVarA = this.f2024b.a();
        if (bVarA != null && this.c.a(bVarA)) {
            this.f2024b.c();
            if (bVarA.c != null) {
                b(bVarA);
            }
        }
    }

    private void b(b bVar) {
        if (bVar == null) {
            a();
            return;
        }
        if (this.i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            return;
        }
        this.c.b(bVar);
        long j = bVar.f2026b;
        PreloaderURLItem preloaderURLItem = bVar.c;
        if (preloaderURLItem != null && preloaderURLItem.getUrls() != null && bVar.c.getUrls().length > 0) {
            b.a aVar = bVar.e.get(0);
            aVar.c = bVar.c.getUrls();
            aVar.g = bVar.f2026b;
            aVar.d = bVar.c.getFilePath();
            a(bVar, aVar);
        }
        if (bVar.a() != null) {
            PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(6);
            preLoaderItemCallBackInfo.preloadType = 0;
            preLoaderItemCallBackInfo.videoPreloadSize = j;
            preLoaderItemCallBackInfo.audioPreloadSize = 0L;
            bVar.a().preloadItemInfo(preLoaderItemCallBackInfo);
            TTVideoEngineLog.i("DataLoaderHelper", "[preload] notify info. type = 0");
        }
        a();
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.startsWith("http://127.0.0.1") || lowerCase.startsWith("http://localhost") || lowerCase.startsWith(MDL_PREFIX) || lowerCase.startsWith("file://") || lowerCase.startsWith("/") || lowerCase.endsWith(".mpd") || lowerCase.contains(".mpd?")) ? false : true;
    }

    private void a(b bVar) {
        boolean z;
        ArrayList<TTVideoEngine> arrayListA;
        ArrayList<b> arrayListD = this.e.d();
        int i = 0;
        while (true) {
            if (i >= arrayListD.size()) {
                z = true;
                break;
            }
            b bVar2 = arrayListD.get(i);
            if (!TextUtils.isEmpty(bVar2.f2025a) && !TextUtils.isEmpty(bVar.f2025a) && bVar2.f2025a.equals(bVar.f2025a)) {
                z = false;
                break;
            }
            i++;
        }
        if (!z || (arrayListA = a(bVar.f2025a)) == null || arrayListA.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayListA.size(); i2++) {
            arrayListA.get(i2).a();
        }
    }

    private void a(b bVar, b.a aVar) {
        if (bVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] start mdl preload task fail. item is null");
            return;
        }
        if (aVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] start mdl preload task fail. track is null");
            notifyPreloadError(bVar.c, -100004);
            return;
        }
        TTVideoEngineLog.i("DataLoaderHelper", "[preload] start mdl preload task.  key = " + aVar.f2027a);
        String str = aVar.f2027a;
        String[] strArr = aVar.c;
        if (strArr != null) {
            String strA = a(str, bVar.f2025a, aVar.f, 0L, strArr, aVar.d);
            aVar.f2028b = strA;
            if (!TextUtils.isEmpty(strA)) {
                TTVideoEngineLog.d("DataLoaderHelper", "allPreloadTasks enqueueItem " + this.d + ", item " + bVar);
                this.d.a(bVar);
                if (aVar.f > 0) {
                    long j = aVar.e;
                    if (j > 0) {
                        this.i.preloadResource(aVar.f2028b, (int) j);
                    }
                    this.i.preloadResource(aVar.f2028b, (int) aVar.f, (int) aVar.g);
                } else {
                    this.i.preloadResource(aVar.f2028b, (int) aVar.g);
                }
                TTVideoEngineLog.i("DataLoaderHelper", String.format("[preload] exect preload task ,key is %s; videoId = %s", aVar.f2027a, bVar.f2025a));
                return;
            }
        }
        bVar.a(-100001);
    }

    private void a(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo, boolean z, boolean z2) {
        String str;
        b bVarB;
        d dVar;
        if (aVMDLDataLoaderNotifyInfo == null || TextUtils.isEmpty(aVMDLDataLoaderNotifyInfo.logInfo)) {
            str = "_progressInfoString return";
        } else {
            String[] strArrSplit = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
            if (strArrSplit.length >= 4) {
                boolean z3 = false;
                try {
                    long jLongValue = Long.valueOf(strArrSplit[0]).longValue();
                    long jLongValue2 = Long.valueOf(strArrSplit[1]).longValue();
                    if (jLongValue2 <= 0 && !z2) {
                        TTVideoEngineLog.i("DataLoaderHelper", "[preload] mediaSize <= 0 return " + aVMDLDataLoaderNotifyInfo.logInfo);
                        return;
                    }
                    String str2 = strArrSplit[2];
                    String str3 = strArrSplit[3];
                    if (z || z2) {
                        bVarB = this.d.b(str2);
                        if (bVarB == null) {
                            TTVideoEngineLog.i("DataLoaderHelper", "[preload] preload temItem == null return " + aVMDLDataLoaderNotifyInfo.logInfo);
                            return;
                        }
                        dVar = this.d;
                        z3 = true;
                    } else {
                        bVarB = this.e.b(str2);
                        if (bVarB == null) {
                            TTVideoEngineLog.i("DataLoaderHelper", "[preload] play temItem == null return " + aVMDLDataLoaderNotifyInfo.logInfo);
                            return;
                        }
                        dVar = this.e;
                    }
                    b.a aVarB = bVarB.b(str2);
                    if (aVarB != null) {
                        aVarB.h = jLongValue2;
                        aVarB.i = jLongValue;
                        aVarB.d = str3;
                    }
                    String str4 = TextUtils.isEmpty(bVarB.f2025a) ? str2 : bVarB.f2025a;
                    c loadProgressByRawKey = getLoadProgressByRawKey(str4);
                    if (loadProgressByRawKey == null) {
                        loadProgressByRawKey = new c(this);
                    }
                    loadProgressByRawKey.f2029a = bVarB.f2025a;
                    loadProgressByRawKey.f2030b = z ? 2 : 1;
                    loadProgressByRawKey.a(bVarB);
                    putByRawKey(str4, loadProgressByRawKey);
                    if (loadProgressByRawKey.b() || z2) {
                        if (!z3) {
                            dVar.c(str2);
                        }
                        removeLoadProgressByRawKey(str4);
                        if (!z) {
                            a(bVarB);
                        }
                        if (bVarB.a() == null || !z2) {
                            TTVideoEngineLog.d("DataLoaderHelper", "_progressInfoString getCallBackListener is null or preloadEnd " + z2);
                            return;
                        }
                        s++;
                        TTVideoEngineLog.d("DataLoaderHelper", "preloadCount engine callback " + s + ", KEY_IS_PRELOAD_END_SUCCEED");
                        dVar.c(str2);
                        DataLoaderTaskProgressInfo dataLoaderTaskProgressInfo = new DataLoaderTaskProgressInfo();
                        dataLoaderTaskProgressInfo.mCacheSizeFromZero = jLongValue;
                        dataLoaderTaskProgressInfo.mMediaSize = jLongValue2;
                        dataLoaderTaskProgressInfo.mKey = str2;
                        dataLoaderTaskProgressInfo.mLocalFilePath = str3;
                        dataLoaderTaskProgressInfo.mVideoId = bVarB.f2025a;
                        dataLoaderTaskProgressInfo.mTaskType = loadProgressByRawKey.f2030b;
                        PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(2);
                        preLoaderItemCallBackInfo.preloadDataInfo = dataLoaderTaskProgressInfo;
                        preLoaderItemCallBackInfo.loadProgress = loadProgressByRawKey;
                        bVarB.a().preloadItemInfo(preLoaderItemCallBackInfo);
                        TTVideoEngineLog.i("DataLoaderHelper", "[preload] notify end cache size = " + loadProgressByRawKey.a());
                        return;
                    }
                    return;
                } catch (Exception e) {
                    TTVideoEngineLog.d(e);
                    return;
                }
            }
            str = "_progressInfoString temArray.length " + strArrSplit.length;
        }
        TTVideoEngineLog.d("DataLoaderHelper", str);
    }

    private void a(String str, String str2, long j, PreloaderURLItem preloaderURLItem) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] key invalid.");
            notifyPreloadError(preloaderURLItem, -100001);
            return;
        }
        if (this.i == null || this.f2023a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            notifyPreloadError(preloaderURLItem, -100002);
            return;
        }
        if (this.c.a(str) || this.f2024b.a(str)) {
            TTVideoEngineLog.d("DataLoaderHelper", "[preload] add the same key task.");
            notifyPreloadError(preloaderURLItem, -100003);
            return;
        }
        b bVar = new b(this);
        bVar.a(str, j);
        bVar.f2025a = str2;
        bVar.c = preloaderURLItem;
        this.f2024b.a(bVar);
        a();
    }

    private boolean a(d dVar) {
        TTVideoEngineLog.d("DataLoaderHelper", "cancelTasks");
        boolean z = false;
        if (dVar.b() > 0) {
            while (true) {
                b bVarC = dVar.c();
                if (bVarC == null) {
                    break;
                }
                c(bVarC);
                z = true;
            }
        }
        return z;
    }

    private String[] a(String[] strArr) {
        if (strArr == null || strArr.length <= 1) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            String str = strArr[i];
            Boolean bool = Boolean.TRUE;
            int size = arrayList.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                if (((String) arrayList.get(size)).equals(str)) {
                    bool = Boolean.FALSE;
                    break;
                }
                size--;
            }
            if (bool.booleanValue()) {
                arrayList.add(str);
            }
        }
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        return strArr2;
    }
}
