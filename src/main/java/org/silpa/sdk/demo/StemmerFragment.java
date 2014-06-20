package org.silpa.sdk.demo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.silpa.stemmer.StemmerEditText;
import org.silpa.stemmer.StemmerTextView;

import java.util.Map;

/**
 * Created by sujith on 10/6/14.
 */
public class StemmerFragment extends Fragment {

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
        final StemmerTextView tvStemmer = (StemmerTextView)
                view.findViewById(R.id.tvStemmer);

        String[] arr1 = edtStemmer.getStemWordsAsArray();
        Map<String, String> map1 = edtStemmer.getStemWordsAsMap();

        String[] arr2 = tvStemmer.getStemWordsAsArray();
        Map<String, String> map2 = tvStemmer.getStemWordsAsMap();

    }
}
