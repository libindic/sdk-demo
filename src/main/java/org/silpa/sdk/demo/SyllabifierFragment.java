package org.silpa.sdk.demo;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.silpa.payyans.Payyans;
import org.silpa.payyans.PayyansEditText;
import org.silpa.payyans.PayyansTextView;
import org.silpa.syllabifier.SyllabifierEditText;
import org.silpa.syllabifier.SyllabifierTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sujith on 10/6/14.
 */
public class SyllabifierFragment extends Fragment {

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
