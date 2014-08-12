package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.guesslanguage.GuessLanguage;
import org.silpa.guesslanguage.LanguageInfo;

/**
 * Created by sujith on 11/8/14.
 */
public class GuessLanguageFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        View view = inflater.inflate(R.layout.guess_language_fragment, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {

        final GuessLanguage gl = new GuessLanguage(getActivity());

        final EditText edtGuessLanguage = (EditText) view.findViewById(R.id.edtGuessLanguage);
        final Button btGetLanguage = (Button) view.findViewById(R.id.btGetLanguage);
        final TextView tvLanguageInfoResult = (TextView) view.findViewById(R.id.tvLanguageInfoResult);

        btGetLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageInfo li = gl.guessLanguageInfo(edtGuessLanguage.getText().toString());
                tvLanguageInfoResult.setText(li.toString());
            }
        });
    }
}
