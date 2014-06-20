package org.silpa.sdk.demo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.silpa.katapayadi.KatapayadiTextView;

/**
 * Created by sujith on 10/6/14.
 */
public class KatapayadiFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.katapaydi_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        final KatapayadiTextView tvKatapayadi = (KatapayadiTextView) view.findViewById(R.id.tvKatapayadi);
        System.out.println(tvKatapayadi.getKatapayadiNumber());
        System.out.println(tvKatapayadi.getSwarasthanas());

    }
}
