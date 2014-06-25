package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.soundex.SoundexEditText;
import org.silpa.soundex.SoundexTextView;

/**
 * Created by sujith on 10/6/14.
 */
public class SoundexFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.soundex_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final SoundexEditText edtSoundex1 = (SoundexEditText) view.findViewById(R.id.edtSoundex1);
        final Button btCompare = (Button) view.findViewById(R.id.btCompare);
        final TextView tvCompareResult = (TextView) view.findViewById(R.id.tvCompareResult);

        btCompare.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int cmp = edtSoundex1.getCompareValue();
                if (cmp == 0) tvCompareResult.setText("0 - Strings equal");
                else if (cmp == 1) tvCompareResult.setText("1 - Strings sound phonetically same");
                else if (cmp == 2) tvCompareResult.setText("2 - Strings are not phonetically same");
                else if (cmp == -1) tvCompareResult.setText("-1 - Cant compare");
            }
        });


        final SoundexTextView tvSoundex = (SoundexTextView) view.findViewById(R.id.tvSoundex);
        System.out.println(tvSoundex.getSoundexCode());
    }
}
