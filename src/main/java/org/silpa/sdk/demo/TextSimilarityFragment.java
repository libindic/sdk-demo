package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.textsimilarity.TextSimilarity;

/**
 * Created by sujith on 13/8/14.
 */
public class TextSimilarityFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.text_similarity_fragment, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {

        final TextSimilarity textSimilarity = new TextSimilarity();

        final EditText edt1 = (EditText) view.findViewById(R.id.edtTextSimilarity1);
        final EditText edt2 = (EditText) view.findViewById(R.id.edtTextSimilarity2);
        final Button btCompare = (Button) view.findViewById(R.id.btTextSimilarityCompare);
        final TextView tvCompareResults = (TextView) view.findViewById(R.id.tvTextSimilarityResult);

        btCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = edt1.getText().toString();
                String str2 = edt2.getText().toString();
                double result = textSimilarity.compare(str1, str2);
                tvCompareResults.setText(String.valueOf(result));
            }
        });
    }
}
