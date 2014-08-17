package org.silpa.sdk.demo;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.render.IndicEditText;
import org.silpa.render.ScriptRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private static List<String> listColor = new ArrayList<String>();

    static {
        listColor.add("Black");
        listColor.add("Blue");
        listColor.add("Red");
        listColor.add("Yellow");
        listColor.add("Green");
    }

    private static Map<String, Integer> colorMap = new HashMap<String, Integer>();

    static {
        colorMap.put("Black", Color.BLACK);
        colorMap.put("Blue", Color.BLUE);
        colorMap.put("Red", Color.RED);
        colorMap.put("Yellow", Color.YELLOW);
        colorMap.put("Green", Color.GREEN);
    }

    private void initView(View view) {

        final ScriptRenderer obj = new ScriptRenderer(getSherlockActivity());

        final IndicEditText edtIndicText = (IndicEditText) view.findViewById(R.id.edtRenderInput);
        final EditText edtWidth = (EditText) view.findViewById(R.id.edtRenderWidth);
        final EditText edtHeight = (EditText) view.findViewById(R.id.edtRenderHeight);
        final EditText edtFontSize = (EditText) view.findViewById(R.id.edtRenderFontSize);
        final Spinner spRenderColor = (Spinner) view.findViewById(R.id.spRenderColor);
        final Button btGetImage = (Button) view.findViewById(R.id.btGetRenderImage);
        final ImageView ivRenderedImage = (ImageView) view.findViewById(R.id.ivRenderedImage);

        ArrayAdapter<String> dataAdapterFontMap = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, listColor);
        dataAdapterFontMap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRenderColor.setAdapter(dataAdapterFontMap);

        btGetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtIndicText.getText().toString();
                int width = getValue(edtWidth, DEFAULT_WIDTH);
                int height = getValue(edtHeight, DEFAULT_HEIGHT);
                int fontSize = getValue(edtFontSize, DEFAULT_FONT_SIZE);

                Bitmap bitmap = obj.getRenderedBitmap(text, fontSize,
                        colorMap.get(listColor.get(spRenderColor.getSelectedItemPosition())), height, width);
                try {
                    ivRenderedImage.setImageBitmap(bitmap);
                } catch (Exception e) {

                }
            }
        });

//        Bitmap bitmap = obj.getRenderedBitmap(text, fontSize,
//                colorMap.get(listColor.get(spRenderColor.getSelectedItemPosition())), height, width);
//        File file = new File(Environment.getExternalStorageDirectory() + "/render.png");
//        try {
//            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
//            Toast.makeText(getSherlockActivity(), "Image saved", Toast.LENGTH_LONG).show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Toast.makeText(getSherlockActivity(), "Error in generating bitmap", Toast.LENGTH_LONG).show();
//        }
    }

    private static final int DEFAULT_WIDTH = 100;
    private static final int DEFAULT_HEIGHT = 100;
    private static final int DEFAULT_FONT_SIZE = 18;

    private static int getValue(EditText edt, int defaultValue) {
        try {
            int val = Integer.parseInt(edt.getText().toString().trim());
            return val;
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }
}
