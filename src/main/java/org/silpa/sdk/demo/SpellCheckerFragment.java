package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.render.IndicEditText;
import org.silpa.render.IndicTextView;
import org.silpa.spellchecker.SpellChecker;

import java.util.List;

/**
 * Created by sujith on 17/8/14.
 */
public class SpellCheckerFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.spell_checker_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final SpellChecker spellChecker = new SpellChecker(getActivity());

        final IndicEditText edtSpellCheck1 = (IndicEditText) view.findViewById(R.id.edtSpellCheck1);
        final IndicEditText edtSpellCheck2 = (IndicEditText) view.findViewById(R.id.edtSpellCheck2);
        final IndicEditText edtSpellCheck3 = (IndicEditText) view.findViewById(R.id.edtSpellCheck3);

        final Button btSpellCheck1 = (Button) view.findViewById(R.id.btSpellCheck1);
        final Button btSpellCheck2 = (Button) view.findViewById(R.id.btSpellCheck2);
        final Button btSpellCheck3 = (Button) view.findViewById(R.id.btSpellCheck3);

        final IndicTextView tvSpellCheck1 = (IndicTextView) view.findViewById(R.id.tvSpellCheck1);
        final IndicTextView tvSpellCheck2 = (IndicTextView) view.findViewById(R.id.tvSpellCheck2);
        final IndicTextView tvSpellCheck3 = (IndicTextView) view.findViewById(R.id.tvSpellCheck3);

        btSpellCheck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = edtSpellCheck1.getText().toString().trim();
                boolean correctness = spellChecker.check(word);
                tvSpellCheck1.setText(String.valueOf(correctness));
            }
        });

        btSpellCheck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = edtSpellCheck2.getText().toString().trim();
                List<String> suggestions = spellChecker.suggest(word);
                String res = "[ ";
                for (String str : suggestions) {
                    res += str + " ";
                }
                res += "]";
                tvSpellCheck2.setText(res);
            }
        });

        btSpellCheck3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtSpellCheck3.getText().toString().trim();
                List<String> misspeltWords = spellChecker.checkBatch(text);
                tvSpellCheck3.setText(misspeltWords.toString());
            }
        });
    }
}

