package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

/**
 * Created by sujith on 9/7/14.
 */
public class TransliteratorFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.transliterator_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {


    }
}
