package com.matt2393.kotlinmultiparadigma.Tools

import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.matt2393.kotlinmultiparadigma.R


fun changeMargins(pos: Int, itemCount: Int, view: View, fragmentActivity: FragmentActivity){
    val params = view.layoutParams as RecyclerView.LayoutParams
    if(pos == 0) {
        params.topMargin = getAppBarHeight(activity = fragmentActivity) //+ Tools.getStatusBarHeight(fragmentActivity)
        params.bottomMargin = px(15, fragmentActivity.resources.displayMetrics)
    }
    else{
        if(pos == itemCount-1)
            params.bottomMargin = px(15, fragmentActivity.resources.displayMetrics) + navBarHeigth2(fragmentActivity)
        else
            params.bottomMargin = dpToPx(15, fragmentActivity.resources.displayMetrics)
        params.topMargin = 0
    }
    view.layoutParams = params
}


fun dpToPx2(dp: Int, displayMetrics: DisplayMetrics): Int{
    return dp * displayMetrics.densityDpi / 160
}

fun getStatusBarHeight(fragmentActivity: FragmentActivity): Int {
    val resourceId = fragmentActivity.resources.getIdentifier("status_bar_height", "dimen", "android")
    return if (resourceId > 0) fragmentActivity.resources.getDimensionPixelSize(resourceId)
        else 0
}

fun getNavBarHeight(fragmentActivity: FragmentActivity): Int {
    val resourceId = fragmentActivity.resources.getIdentifier("navigation_bar_height", "dimen", "android")
    return if (resourceId > 0) fragmentActivity.resources.getDimensionPixelSize(resourceId)
    else 0
}

fun getAppBarHeight(activity: FragmentActivity): Int{
    val tv = TypedValue()
    var actionBarHeight = 0
    if (activity.theme.resolveAttribute(R.attr.actionBarSize, tv, true)) {
        actionBarHeight = TypedValue.complexToDimensionPixelSize(
            tv.data,
            activity.resources.displayMetrics
        )
    }
    return actionBarHeight
}






fun dpToPx(dp: Int, displayMetrics: DisplayMetrics): Int = dp * displayMetrics.densityDpi / 160











val px: (Int, DisplayMetrics) -> Int = ::dpToPx









inline fun dpPx(dp: Int, displayMetrics: DisplayMetrics): Int = dp * displayMetrics.densityDpi / 160











val navBarHeight = { fragmentActivity: FragmentActivity ->
    val resourceId = fragmentActivity.resources.getIdentifier("navigation_bar_height", "dimen", "android")
    if (resourceId > 0) fragmentActivity.resources.getDimensionPixelSize(resourceId)
     else 0
}


val appBarHeight = {activity: FragmentActivity -> Int
    val tv = TypedValue()
    var actionBarHeight = 0
    if (activity.theme.resolveAttribute(R.attr.actionBarSize, tv, true)) {
        actionBarHeight = TypedValue.complexToDimensionPixelSize(
            tv.data,
            activity.resources.displayMetrics
        )
    }
    actionBarHeight
}






val navBarHeigth2: (FragmentActivity) -> Int = {
    val resourceId = it.resources.getIdentifier("navigation_bar_height", "dimen", "android")
    if (resourceId > 0) it.resources.getDimensionPixelSize(resourceId)
    else 0
}



