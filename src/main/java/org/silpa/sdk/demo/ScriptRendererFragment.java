package org.silpa.sdk.demo;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.render.IndicEditText;
import org.silpa.render.IndicTextView;
import org.silpa.render.ScriptRenderer;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by sujith on 24/6/14.
 */
public class ScriptRendererFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.script_renderer_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        //IndicTextView edt = (IndicTextView) view.findViewById(R.id.edt1);
        //edt.saveBitmap();
        ScriptRenderer obj = new ScriptRenderer(getSherlockActivity());
        Bitmap bitmap = obj.getRenderedBitmap("ആന മെലിഞ്ഞാല്‍ തൊഴുത്തില്‍ കെട്ടാമ", 16, Color.BLACK, 50, 150);

        File file = new File(Environment.getExternalStorageDirectory() + "/render.png");

        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
            System.out.println("saved");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error" + e.getMessage());
        }
    }
}
