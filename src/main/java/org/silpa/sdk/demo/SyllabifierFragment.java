package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.render.IndicEditText;
import org.silpa.render.IndicTextView;
import org.silpa.syllabifier.Syllabifier;

/**
 * Created by sujith on 10/6/14.
 */
public class SyllabifierFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.syllabifier_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final Syllabifier syllabifier = new Syllabifier();

        final IndicEditText edtSyllabifier = (IndicEditText)
                view.findViewById(R.id.edtSyllabifier);
        final Button btSyllabify = (Button) view.findViewById(R.id.btSyllabify);
        final IndicTextView tvSyllabifiedText = (IndicTextView)
                view.findViewById(R.id.tvSyllabifiedText);


        btSyllabify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSyllabifiedText.setText(syllabifier.syllabify(edtSyllabifier.getText().toString()));
            }
        });

    }
}
