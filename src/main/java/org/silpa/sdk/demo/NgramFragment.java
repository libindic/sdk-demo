package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.ngram.Ngram;
import org.silpa.render.IndicEditText;
import org.silpa.render.IndicTextView;

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

        final Ngram ngram = new Ngram();

        final IndicEditText edtNgram = (IndicEditText) view.findViewById(R.id.edtNgram);
        final EditText edtNValue = (EditText) view.findViewById(R.id.edtNValue);


        final IndicTextView tvLetterNgram = (IndicTextView) view.findViewById(R.id.tvLetterNgram);
        final IndicTextView tvSyllableNgram = (IndicTextView) view.findViewById(R.id.tvSyllableNgram);
        final IndicTextView tvWordNgram = (IndicTextView) view.findViewById(R.id.tvWordNgram);

        final Button btGetNgram = (Button) view.findViewById(R.id.btGetNgram);

        btGetNgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int nValue;
                try {
                    nValue = Integer.parseInt(edtNValue.getText().toString().trim());
                } catch (Exception e) {
                    nValue = Ngram.DEFAULT_NGRAMS_WINDOW_SIZE;
                }
                String text = edtNgram.getText().toString();

                tvLetterNgram.setText(ngram.letterNgram(text, nValue).toString());

                tvSyllableNgram.setText(ngram.syllableNgram(text, nValue).toString());

                tvWordNgram.setText(ngram.wordNgram(text, nValue).toString());
            }
        });
    }
}

