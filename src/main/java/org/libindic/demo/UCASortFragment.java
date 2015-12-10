package org.libindic.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.libindic.render.IndicEditText;
import org.libindic.render.IndicTextView;
import org.libindic.ucasort.UCASort;

/**
 * Created by sujith on 16/8/14.
 */
public class UCASortFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.ucasort_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final IndicEditText edtUCAInput = (IndicEditText) view.findViewById(R.id.edtUCASort);
        final Button btUCASort = (Button) view.findViewById(R.id.btUCASort);
        final IndicTextView tvSortResults = (IndicTextView) view.findViewById(R.id.tvSortedWords);

        btUCASort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = edtUCAInput.getText().toString();

                if (text == null || text.length() == 0) {
                    showWarning();
                }

                String[] sortedWords = UCASort.sort(text);

                String res = "[ ";
                for (String x : sortedWords) {
                    res += x + " ";
                }
                res += "]";

                tvSortResults.setText(res);
            }
        });
    }

    private void showWarning() {
        Toast.makeText(getActivity(), "Warning : Empty fields.", Toast.LENGTH_SHORT).show();
    }
}

