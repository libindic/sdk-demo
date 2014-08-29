package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import org.silpa.render.IndicEditText;
import org.silpa.render.IndicTextView;
import org.silpa.spellchecker.SpellChecker;

import java.util.List;

/**
 * Created by sujith on 17/8/14.
 */
public class SpellCheckerFragment extends SherlockFragment {

    private SpellChecker spellChecker;

    private EditText edtSpellCheck1, edtSpellCheck2, edtSpellCheck3;
    private Button btSpellCheck1, btSpellCheck2, btSpellCheck3;
    private TextView tvSpellCheck1, tvSpellCheck2, tvSpellCheck3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.spell_checker_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        spellChecker = new SpellChecker(getActivity());

        edtSpellCheck1 = (EditText) view.findViewById(R.id.edtSpellCheck1);
        edtSpellCheck2 = (EditText) view.findViewById(R.id.edtSpellCheck2);
        edtSpellCheck3 = (EditText) view.findViewById(R.id.edtSpellCheck3);

        btSpellCheck1 = (Button) view.findViewById(R.id.btSpellCheck1);
        btSpellCheck2 = (Button) view.findViewById(R.id.btSpellCheck2);
        btSpellCheck3 = (Button) view.findViewById(R.id.btSpellCheck3);

        tvSpellCheck1 = (TextView) view.findViewById(R.id.tvSpellCheck1);
        tvSpellCheck2 = (TextView) view.findViewById(R.id.tvSpellCheck2);
        tvSpellCheck3 = (TextView) view.findViewById(R.id.tvSpellCheck3);

        btSpellCheck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtSpellCheck1.getText().toString().trim();

                if (text == null || text.length() == 0) {
                    showWarning();
                }

                boolean correctness = spellChecker.check(text);
                tvSpellCheck1.setText(String.valueOf(correctness));
            }
        });

        btSpellCheck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtSpellCheck2.getText().toString().trim();

                if (text == null || text.length() == 0) {
                    showWarning();
                }

                List<String> suggestions = spellChecker.suggest(text);
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

                if (text == null || text.length() == 0) {
                    showWarning();
                }

                List<String> misspeltWords = spellChecker.checkBatch(text);
                tvSpellCheck3.setText(misspeltWords.toString());
            }
        });
    }

    private void showWarning() {
        Toast.makeText(getActivity(), "Warning : Empty fields.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_fill_sample_data, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_fill_sample_fields:
                fillSampleData();
                return true;

            case R.id.menu_clear_fields:
                clearFields();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void fillSampleData() {
        if (edtSpellCheck1 != null) {
            edtSpellCheck1.setText(R.string.spell_checker_sample_1);

            if (btSpellCheck1 != null && tvSpellCheck1 != null) {
                btSpellCheck1.performClick();
            }
        }

        if (edtSpellCheck2 != null) {
            edtSpellCheck2.setText(R.string.spell_checker_sample_2);

            if (btSpellCheck2 != null && tvSpellCheck2 != null) {
                btSpellCheck2.performClick();
            }
        }

        if (edtSpellCheck3 != null) {
            edtSpellCheck3.setText(R.string.spell_checker_sample_3);

            if (btSpellCheck3 != null && tvSpellCheck3 != null) {
                btSpellCheck3.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtSpellCheck1 != null && tvSpellCheck1 != null) {
            edtSpellCheck1.setText("");
            tvSpellCheck1.setText("");
        }
        if (edtSpellCheck2 != null && tvSpellCheck2 != null) {
            edtSpellCheck2.setText("");
            tvSpellCheck2.setText("");
        }
        if (edtSpellCheck3 != null && tvSpellCheck3 != null) {
            edtSpellCheck3.setText("");
            tvSpellCheck3.setText("");
        }
    }
}

