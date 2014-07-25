package org.silpa.sdk.demo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.shingling.ShinglingEditText;
import org.silpa.shingling.ShinglingTextView;

/**
 * Created by sujith on 25/7/14.
 */
public class ShinglingFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shingling_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final ShinglingEditText edtShingling = (ShinglingEditText) view.findViewById(R.id.edtShingling);
        edtShingling.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                System.out.println(edtShingling.getShingles().toString());
            }
        });

        final ShinglingTextView tvShingling = (ShinglingTextView) view.findViewById(R.id.tvShingling);
        System.out.println(tvShingling.getShingles().toString());
    }
}

