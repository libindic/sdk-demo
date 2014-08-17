package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.render.IndicEditText;
import org.silpa.render.IndicTextView;
import org.silpa.transliteration.Transliterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private static Map<String, String> languageNameMap = new HashMap<String, String>();

    static {
        languageNameMap.put("English", "en_US");
        languageNameMap.put("Hindi", "hi_IN");
        languageNameMap.put("Bengali", "bn_IN");
        languageNameMap.put("Punjabi", "pa_IN");
        languageNameMap.put("Gujarati", "gu_IN");
        languageNameMap.put("Oriya", "or_IN");
        languageNameMap.put("Tamil", "ta_IN");
        languageNameMap.put("Telugu", "te_IN");
        languageNameMap.put("Kannada", "kn_IN");
        languageNameMap.put("Malayalam", "ml_IN");
        languageNameMap.put("ISO15919", "ISO15919");
        languageNameMap.put("IPA", "IPA");
    }

    private static List<String> listTargetLanguage = new ArrayList<String>();

    static {
        listTargetLanguage.add("English");
        listTargetLanguage.add("Hindi");
        listTargetLanguage.add("Malayalam");
        listTargetLanguage.add("Bengali");
        listTargetLanguage.add("Tamil");
        listTargetLanguage.add("Telugu");
        listTargetLanguage.add("Gujarati");
        listTargetLanguage.add("Punjabi");
        listTargetLanguage.add("Kannada");
        listTargetLanguage.add("ISO15919");
        listTargetLanguage.add("IPA");
    }

    private void initView(View view) {

        final Transliterator transliterator = new Transliterator(getActivity());
        final IndicEditText edtTransliterator = (IndicEditText) view.findViewById(R.id.edtTransliterator);
        final Spinner spTargetLanguage = (Spinner) view.findViewById(R.id.spTargetLanguage);
        final Button btTransliterate = (Button) view.findViewById(R.id.btTransliterate);
        final IndicTextView tvTransliteratorOutput = (IndicTextView) view.findViewById(R.id.tvTransliteratorOutput);

        ArrayAdapter<String> dataAdapterFontMap = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, listTargetLanguage);
        dataAdapterFontMap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTargetLanguage.setAdapter(dataAdapterFontMap);

        btTransliterate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = edtTransliterator.getText().toString();
                String languageCode = languageNameMap.get(spTargetLanguage.getSelectedItem().toString());
                String transliteratedText = transliterator.transliterate(text, languageCode);
                tvTransliteratorOutput.setText(transliteratedText);
            }
        });
    }
}
