package org.silpa.sdk.demo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.inexactsearch.InexactSearchEditText;

/**
 * Created by sujith on 23/7/14.
 */
public class InexactSearchFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.inexact_search_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final InexactSearchEditText edtInexactSearch1 = (InexactSearchEditText) view.findViewById(R.id.edtInexactSearch1);
        edtInexactSearch1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                System.out.println("Bigram avg : " + edtInexactSearch1.getBigramAverage());
                System.out.println("Compare value : " + edtInexactSearch1.getCompareValue());
                // System.out.println("Bigram avg : " + edtInexactSearch1.getBigramAverage());
                System.out.println();
            }
        });
    }
}

