package com.husky.library.tools;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SizeReadyCallback;

/**
 * @author husky
 */
public class GlideUtils {

    private static final String TAG = GlideUtils.class.getSimpleName();

    public static void displayImage(ImageView view , String url){

    }

    public static void displayUrl(final ImageView view, String url, @DrawableRes int defaultImage){
        if (view == null){
            Log.e(TAG,"Glide Utils : image view is null");
            return;
        }
        Context context = view.getContext();
        if (context instanceof Activity){
            if (((Activity)context).isFinishing()){
                return;
            }
        }

        try{
            Glide.with(context)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(defaultImage)
                    .into(view)
                    .getSize(new SizeReadyCallback() {
                        @Override
                        public void onSizeReady(int width, int height) {
                            if (!view.isShown()){
                                view.setVisibility(View.VISIBLE);
                            }
                        }
                    });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void displayNative(final ImageView view,@DrawableRes int resId){
        if (view == null){
            Log.e(TAG,"Glide Utils : image view is null");
            return;
        }
        Context context = view.getContext();
        if (context instanceof Activity){
            if (((Activity)context).isFinishing()){
                return;
            }
        }
        try{
            Glide.with(context)
                    .load(resId)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .crossFade()
                    .centerCrop()
                    .into(view)
                    .getSize(new SizeReadyCallback() {
                        @Override
                        public void onSizeReady(int width, int height) {
                            if (!view.isShown()){
                                view.setVisibility(View.VISIBLE);
                            }
                        }
                    });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
