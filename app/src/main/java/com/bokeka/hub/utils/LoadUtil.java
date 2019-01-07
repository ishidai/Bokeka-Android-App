package com.bokeka.hub.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;

import com.bokeka.hub.loadstate.LoadManager;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class LoadUtil {
    public static LoadManager.StateViewParams getViewParams(Object targetView) {
        ViewGroup contentParent = null;
        Context context = null;
        View rootView = null;
        int rootViewIndex = 0;
        if (targetView != null) {
            if (targetView instanceof Activity) {
                Activity activity = (Activity) targetView;
                context = activity;
                contentParent = activity.findViewById(android.R.id.content);
                rootView = contentParent != null ? contentParent.getChildAt(0) : null;
            } else if (targetView instanceof View) {
                rootView = (View) targetView;
                contentParent = (ViewGroup) (rootView.getParent());
                context = rootView.getContext();
            }
            int childCount = contentParent == null ? 0 : contentParent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (contentParent.getChildAt(i) == rootView) {
                    rootViewIndex = i;
                    break;
                }
            }
            if (contentParent != null) {
                contentParent.removeView(rootView);
            }
        } else {
            throw new IllegalArgumentException("The target must be  View");
        }
        return new LoadManager.StateViewParams(context, contentParent, rootView, rootViewIndex);
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}