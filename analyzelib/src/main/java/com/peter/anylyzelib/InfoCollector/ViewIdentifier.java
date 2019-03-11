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

    public static View getViewByCoordinate(int x, int y, View view){
        if (view instanceof ViewGroup){
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++){
                return getViewByCoordinate(x, y , ((ViewGroup) view).getChildAt(i));
            }
            return view;
        }else {
            if (x > view.getLeft() && x < view.getRight() && y > view.getTop() && y < view.getBottom()) {
                return view;
            }
        }
        return null;
    }
}
