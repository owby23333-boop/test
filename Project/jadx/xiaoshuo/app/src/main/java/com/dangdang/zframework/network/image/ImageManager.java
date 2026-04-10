package com.dangdang.zframework.network.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.utils.L;
import java.io.File;

/* JADX INFO: loaded from: classes10.dex */
public class ImageManager {
    private static ImageManager instance;
    private DisplayImageOptions mImageOptions;

    private ImageManager() {
    }

    public static ImageManager getInstance() {
        if (instance == null) {
            instance = new ImageManager();
        }
        return instance;
    }

    public void dislayImage(String str, ImageView imageView, int i) {
        ImageLoader.getInstance().displayImage(str, imageView, i > 0 ? new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).showImageForEmptyUri(i).showImageOnFail(i).showImageOnLoading(i).bitmapConfig(Bitmap.Config.RGB_565).build() : this.mImageOptions);
    }

    public void init(Context context, String str) {
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(context);
        builder.threadPriority(3);
        builder.denyCacheImageMultipleSizesInMemory();
        builder.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        builder.diskCache(new UnlimitedDiskCache(new File(str)));
        L.writeLogs(false);
        ImageLoader.getInstance().init(builder.build());
        this.mImageOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).build();
    }

    public void loadImage(String str, ImageLoadingListener imageLoadingListener) {
        ImageLoader.getInstance().loadImage(str, this.mImageOptions, imageLoadingListener);
    }

    public void dislayImage(String str, ImageView imageView, SimpleImageLoadingListener simpleImageLoadingListener) {
        ImageLoader.getInstance().displayImage(str, imageView, this.mImageOptions, simpleImageLoadingListener);
    }

    public void dislayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions) {
        ImageLoader.getInstance().displayImage(str, imageView, displayImageOptions);
    }

    public void dislayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        ImageLoader.getInstance().displayImage(str, imageView, displayImageOptions, imageLoadingListener);
    }
}
