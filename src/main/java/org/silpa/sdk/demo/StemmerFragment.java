package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.stemmer.StemmerEditText;

import java.util.Map;

/**
 * Created by sujith on 10/6/14.
 */
public class StemmerFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.stemmer_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final StemmerEditText edtStemmer = (StemmerEditText)
                view.findViewById(R.id.edtStemmer);
        final Button btGetStemmedWords = (Button) view.findViewById(R.id.btGetStemmedWords);
        final TextView tvStemmedWords = (TextView) view.findViewById(R.id.tvStemmedWords);

        btGetStemmedWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> stemmedWords = edtStemmer.getStemWordsAsMap();
                String result = "";
                for (Map.Entry<String, String> entry : stemmedWords.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    result = result + key + "  :  " + value + "\n";
                }

                tvStemmedWords.setText(result);
            }
        });

    }
}
