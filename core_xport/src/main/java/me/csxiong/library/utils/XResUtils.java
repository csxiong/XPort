package me.csxiong.library.utils;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import me.csxiong.library.base.APP;

/**
 * @Desc : 资源工具
 * @Author : csxiong create on 2019/7/16
 */
public class XResUtils {

    public static Animation getAnim(int animResId, Animation.AnimationListener listener) {
        Animation animation = AnimationUtils.loadAnimation(APP.get(), animResId);
        if (listener != null) {
            animation.setAnimationListener(listener);
        }
        return animation;
    }

    public static Animation getAnim(int animResId) {
        return getAnim(animResId, null);
    }

    public static String getString(int stringResId) {
        return APP.get().getResources().getString(stringResId);
    }

    public static int getColor(int colorResId) {
        return ContextCompat.getColor(APP.get(), colorResId);
    }

    public static int getColor(String color) {
        return Color.parseColor(color);
    }

    public static float getDimen(int dimensResId) {
        return APP.get().getResources().getDimension(dimensResId);
    }

    public static int getDimenInt(int dimensResId) {
        return (int) getDimen(dimensResId);
    }

    public static int getDimenPx(int dimensResId) {
        return (int) XDisplayUtil.dpToPxInt(getDimen(dimensResId));
    }

    public static float getDimen(String dimenName) {
        return getDimen(getResIdByName(dimenName, "dimen"));
    }

    public static int getResIdByName(String resName, String resType) {
        return APP.get().getResources().getIdentifier(resName, resType, APP.get().getPackageName());
    }

    public static Drawable getDrawable(int drawableResId) {
        Drawable drawable = ContextCompat.getDrawable(APP.get(), drawableResId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public static String getJson(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = APP.get().getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    //获取适配屏幕内容
    public static float getXDimen(int px) {
        return getDimen("x" + px);
    }

    public static float getAttrValue(int styleAttr) {
        TypedValue typedValue = new TypedValue();
        APP.get().getTheme().resolveAttribute(styleAttr, typedValue, true);
        return typedValue.getFloat();
    }

}
