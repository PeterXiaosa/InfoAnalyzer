package com.peter.anylyzelib.InfoCollector;

import android.view.View;
import android.view.ViewGroup;

/**
 *
 */
public class ViewIdentifier {

    public static String getViewId(View view){
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        if (view != null){
            do {
                String viewType = view.getClass().getSimpleName();
                int index = 0;
                // 从ContentView节点开始较好，由于ROM不同，DecorView到ContentView路径可能不一致。
                if ("DecorView".equals(viewType)){
                    builder.insert(0, "DecorView");
                    break;
                }
                ViewGroup parent = (ViewGroup) view.getParent();
                for (int i = 0; i < parent.getChildCount(); i++){
                    View child = parent.getChildAt(i);
                    if (child == view){
                        break;
                    } else if (child.getClass().getSimpleName().equals(viewType)) {
                        index++;
                    }
                }
                builder.insert(0, temp.append("/")
                        .append(viewType)
                        .append("[")
                        .append(index)
                        .append("]"));
                temp.delete(0, temp.length());
            }while ((view = (View) view.getParent()) != null);
        }
        return builder.toString();
    }

    /**
     * 根据触摸指标，计算点击View
     * @param x
     * @param y
     * @param contentView
     * @return
     */
    public static View getViewByCoordinate(int x, int y, ViewGroup contentView){
        // 传进来的View为ContentView
        View result = contentView;
        ViewGroup innerGroup = contentView;
        for (int index = 0; index < innerGroup.getChildCount(); index++){
            View child = innerGroup.getChildAt(index);
            if (child instanceof ViewGroup){
                innerGroup = (ViewGroup) child;
                return getViewByCoordinate(x - child.getLeft(), y - child.getTop(), innerGroup);
            }else {
                if (x > child.getLeft() && x < child.getRight() && y > child.getTop() && y < child.getBottom()){
                    result = child;
                    break;
                }
            }
        }
        return result;

//        if (view instanceof ViewGroup){
//            if (((ViewGroup) view).getChildCount() == 0){
//                // 点击的ViewGroup没有子View。
//            }
//
//            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++){
//                View child = getViewByCoordinate(x, y , ((ViewGroup) view).getChildAt(i));
//                if (child == null){
//                    continue;
//                }
//                return child;
//            }
//            return view;
//        }else {
//            if (x > view.getLeft() && x < view.getRight() && y > view.getTop() && y < view.getBottom()) {
//                //此时的View应该为点击的View
//                return view;
//            }
//        }
//        return null ;
    }
}
