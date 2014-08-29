package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import org.silpa.render.IndicEditText;
import org.silpa.render.IndicTextView;
import org.silpa.soundex.Soundex;

/**
 * Created by sujith on 10/6/14.
 */
public class SoundexFragment extends SherlockFragment {

    private Soundex soundex;

    private IndicEditText edtSoundex1, edtSoundex2;
    private Button btCompare;
    private IndicTextView tvSoundexCode1, tvSoundexCode2;
    private TextView tvCompareResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.soundex_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        soundex = new Soundex();

        edtSoundex1 = (IndicEditText) view.findViewById(R.id.edtSoundex1);
        edtSoundex2 = (IndicEditText) view.findViewById(R.id.edtSoundex2);
        btCompare = (Button) view.findViewById(R.id.btCompare);

        tvSoundexCode1 = (IndicTextView) view.findViewById(R.id.tvSoundexCode1);
        tvSoundexCode2 = (IndicTextView) view.findViewById(R.id.tvSoundexCode2);
        tvCompareResult = (TextView) view.findViewById(R.id.tvCompareResult);

        btCompare.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String text1 = edtSoundex1.getText().toString();
                String text2 = edtSoundex2.getText().toString();

                if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
                    showWarning();
                }

                tvSoundexCode1.setText(" " + soundex.soundex(text1));
                tvSoundexCode2.setText(" " + soundex.soundex(text2));
                int cmp = soundex.compare(text1, text2);

                if (cmp == 0) tvCompareResult.setText("0  :  Strings equal");
                else if (cmp == 1) tvCompareResult.setText("1  :  Strings sound phonetically same");
                else if (cmp == 2)
                    tvCompareResult.setText("2  :  Strings are not phonetically same");
                else if (cmp == -1) tvCompareResult.setText("-1  :  Cant compare");
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
        if (edtSoundex1 != null && edtSoundex2 != null) {
            edtSoundex1.setText(R.string.soundex_sample_1);
            edtSoundex2.setText(R.string.soundex_sample_2);

            if (btCompare != null && tvSoundexCode1 != null && tvSoundexCode2 != null && tvCompareResult != null) {
                btCompare.performClick();
            }
        }
    }

    private void clearFields() {
        if (edtSoundex1 != null && edtSoundex2 != null && tvSoundexCode1 != null &&
                tvSoundexCode2 != null && tvCompareResult != null) {
            edtSoundex1.setText("");
            edtSoundex2.setText("");
            tvSoundexCode1.setText("");
            tvSoundexCode2.setText("");
            tvCompareResult.setText("");
        }
    }
}
