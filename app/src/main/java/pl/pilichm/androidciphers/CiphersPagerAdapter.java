package pl.pilichm.androidciphers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class CiphersPagerAdapter extends PagerAdapter {
    private final Context passedContext;

    public CiphersPagerAdapter(Context context){
        passedContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        CipherListModel currentView = CipherListModel.values()[position];
        LayoutInflater inflater = LayoutInflater.from(passedContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(currentView.getLayoutId(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return CipherListModel.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
