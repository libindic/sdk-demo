package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.syllabifier.SyllabifierTextView;

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

        final SyllabifierTextView tvSyllabifier = (SyllabifierTextView) view.findViewById(R.id.tvSyllabifier);
        System.out.println(tvSyllabifier.getSyllabifiedText());

    }
}
