package me.key.android2;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableDouble;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorRes;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.text.NumberFormat;
import java.util.ArrayList;
import me.key.android2.keychain.KeyChainRecyclerAdapter;
import me.key.android2.keychain.viewmodels.KeyGroupCardViewModel;
import me.key.android2.keychain.viewmodels.KeySingleCardViewModel;
import me.key.android2.keychain.viewmodels.LoginCardViewModel;

/**
 * Created by andrew.madden on 8/29/16.
 */
public final class BindingUtils {

    private BindingUtils() { throw new AssertionError(); }

    /**
     * For all image views using glide.
     * The progress spinner is only used in the "activity_detail.xml" file, after that the image has already been downloaded to cache.
     *
     * @param imageView
     * @param resource
     */


    @BindingAdapter(value = {"imageURL", "transform"}, requireAll = false)
    public static void setImageResource(ImageView imageView, int resource, Boolean transform) {
        Context context = imageView.getContext();
        final ObjectAnimator anim = ObjectAnimator.ofInt(imageView, "ImageLevel", 0, 10000); // http://stackoverflow.com/questions/4651618/is-it-possible-to-have-an-animated-drawable
        anim.setRepeatCount(ObjectAnimator.INFINITE);
        anim.start();

        Glide.with(context).load(imageView.getResources().getDrawable(resource))
                //.placeholder(R.drawable.progressbar_keyme)
                //.skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .dontAnimate()
                .override(100, 200)
                .centerCrop()
                .dontTransform()
                .into(imageView);
    }/**

    @BindingAdapter(value = {"imageURL", "transform"}, requireAll = false)
    public static void setImageURL(ImageView imageView, String url, Boolean transform) {
        Context context = imageView.getContext();
        final ObjectAnimator anim = ObjectAnimator.ofInt(imageView, "ImageLevel", 0, 10000); // http://stackoverflow.com/questions/4651618/is-it-possible-to-have-an-animated-drawable
        anim.setRepeatCount(ObjectAnimator.INFINITE);
        anim.start();

        Glide.with(context).load(url)
                //.placeholder(R.drawable.progressbar_keyme)
                //.skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .dontAnimate()
                .override(100, 200)
                .centerCrop()
                .dontTransform()
                .error(android.R.drawable.ic_delete)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model,
                                               Target<GlideDrawable> target, boolean isFirstResource) {
                        anim.cancel();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model,
                                                   Target<GlideDrawable> target,
                                                   boolean isFromMemoryCache, boolean isFirstResource) {
                        anim.cancel();
                        return false;
                    }
                })
                .into(imageView);
    }/**

    @BindingAdapter("bannerUrl")
    public static void setBannerUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        final ObjectAnimator anim = ObjectAnimator.ofInt(imageView, "ImageLevel", 0, 10000);
        anim.setRepeatCount(ObjectAnimator.INFINITE);
        anim.start();

        Glide.with(context).load(url)
                //.placeholder(R.drawable.progressbar_keyme)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                //.dontTransform()                                     // Image is transforming when the you press BACK to get to the shopping cart and glide requests a [1400x1] pixel image??
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model,
                                               Target<GlideDrawable> target, boolean isFirstResource) {
                        anim.cancel();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model,
                                                   Target<GlideDrawable> target,
                                                   boolean isFromMemoryCache, boolean isFirstResource) {
                        anim.cancel();
                        return false;
                    }
                })
                .into(imageView);
    }

    */

    /**
     *
     *
     *      RecyclerViewAdapters
     *
     */


    @BindingAdapter({"kioskImageUrl", "loginCardViewModel", "promoImageUrls", "keySingleCardViewModels", "keyGroupCardViewModels"})
    public static void bindKeyChainRecyclerView(RecyclerView rv, String kioskImageUrl, LoginCardViewModel loginCardViewModel, ArrayList<String> promoImageUrls, ArrayList<KeySingleCardViewModel> keySingleCardViewModels, ArrayList<KeyGroupCardViewModel> keyGroupCardViewModels) {
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        rv.setAdapter(new KeyChainRecyclerAdapter(kioskImageUrl, loginCardViewModel, promoImageUrls, keySingleCardViewModels, keyGroupCardViewModels));
        //rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL_LIST));
        rv.setItemAnimator(new DefaultItemAnimator());
        ((DefaultItemAnimator)rv.getItemAnimator()).setSupportsChangeAnimations(false);
        rv.getItemAnimator().setRemoveDuration(195);
        rv.getItemAnimator().setMoveDuration(225);
        rv.getItemAnimator().setChangeDuration(195);
    }


    /**

    @BindingAdapter("keySingleCardViewModels")
    public static void bindKeyHistoryRecyclerView(RecyclerView rv, KeySingleCardViewModel keySingleCardViewModel) {
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        //rv.setAdapter(new RecyclerView(keySingleCardViewModel));
        //rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL_LIST));
        rv.setItemAnimator(new DefaultItemAnimator());
        ((DefaultItemAnimator)rv.getItemAnimator()).setSupportsChangeAnimations(false);
        rv.getItemAnimator().setRemoveDuration(195);
        rv.getItemAnimator().setMoveDuration(225);
        rv.getItemAnimator().setChangeDuration(195);
    }

    */

    /**
     *
     *        Visibility adapters
     *
     */
    // General
    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return color != 0 ? new ColorDrawable(color) : null;
    }
    @BindingAdapter("visible")
    public static void bindVisible(View view, boolean b) {
        view.setVisibility(b ? View.VISIBLE : View.INVISIBLE);
    }

    @BindingAdapter("invisible")
    public static void bindInvisible(View view, boolean b) {
        view.setVisibility(b ? View.INVISIBLE : View.VISIBLE);
    }
}
