package org.silpa.sdk.demo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.ngram.NgramEditText;

/**
 * Created by sujith on 23/7/14.
 */
public class NgramFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.ngram_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final NgramEditText edtNgram = (NgramEditText) view.findViewById(R.id.edtNgram);
        edtNgram.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                System.out.println(edtNgram.getNgram().toString());
            }
        });
    }
}

