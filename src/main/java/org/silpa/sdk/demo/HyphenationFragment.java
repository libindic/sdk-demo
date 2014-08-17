package org.silpa.sdk.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.actionbarsherlock.app.SherlockFragment;

import org.silpa.hyphenation.text.Hyphenator;

/**
 * Created by sujith on 26/8/14.
 */
public class HyphenationFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.hyphenation_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        try {
            Hyphenator hyphenator = new Hyphenator(getActivity());
            hyphenator.loadTable(getActivity().getResources().openRawResource(R.raw.silpa_sdk_hyph_en));

            String text1 = "SILPA is an acronym of Swathanthra (Mukth, " +
                    "Free as in Freedom) Indian Language Processing Applications. " +
                    "Its a web framework written using Flask microframework for hosting " +
                    "various Indian language computing algorithms written in python. " +
                    "It currently provides JSONRPC support which is also used by web framework " +
                    "itself to input data and fetch result." +
                    "The modules work as standalone python packages which will serve their " +
                    "purpose and also they plug into the silpa-flask webframewok so that " +
                    "they can be accessed as web services also, or become just another webapp " +
                    "like the dictionary module.";

            String text2 = "ശരിയ്ക്കും അങ്ങനെ ഒരു ലിനക്സ് ഉണ്ടു് എന്നു് മാത്രമല്ല ആളുകള്‍ അതു് ഉപയോഗിയ്ക്കുന്നുമുണ്ടു്, പക്ഷേ അതു് പ്രവര്‍ത്തക സംവിധാനത്തിന്റെ ഒരു ഭാഗം മാത്രമാണു്. ലിനക്സൊരു കെര്‍ണലാണു്: നിങ്ങള്‍ പ്രവര്‍ത്തിപ്പിയ്ക്കുന്ന മറ്റു് പ്രോഗ്രാമുകള്‍ക്കു് സിസ്റ്റത്തിന്റെ വിഭവങ്ങള്‍ വിട്ടുകൊടുക്കുന്ന പ്രോഗ്രാമാണതു്. ഒരു പ്രവര്‍ത്തക സംവിധാനത്തിന്റെ ഒഴിച്ചുകൂടാനാവാത്ത ഭാഗമാണു് കെര്‍ണല്‍, പക്ഷേ അതു് മാത്രം കൊണ്ടു് വലിയ പ്രയോജനമൊന്നുമില്ല; മുഴുവന്‍ പ്രവര്‍ത്തക സംവിധാനത്തിനൊപ്പമേ അതിനു് പ്രവര്‍ത്തിയ്ക്കാനാകൂ. ലിനക്സ് സാധാരണയായി ഗ്നു എന്ന പ്രവര്‍ത്തക സംവിധാനവുമായി ചേര്‍ന്നാണുപയോഗിയ്ക്കുന്നതു്: ലിനക്സ് കെര്‍ണലായി പ്രവര്‍ത്തിയ്ക്കുന്ന മുഴുവന്‍ സിസ്റ്റവും അടിസ്ഥാനപരമായി ഗ്നുവാണു് അഥവാ ഗ്നു/ലിനക്സ് ആണു്. “ലിനക്സ്” എന്നു് പറയപ്പെടുന്ന എല്ലാ വിതരണങ്ങളും ശരിയ്ക്കും, ഗ്നു/ലിനക്സ് വിതരണങ്ങളാണു്.";

            String hyphenatedText1 = hyphenator.hyphenate(text1);
            String hyphenatedText2 = hyphenator.hyphenateWithDetectLangauge(text2);

            String script1 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
            WebView webView1 = (WebView) view.findViewById(R.id.webview1);
            webView1.loadDataWithBaseURL(null, String.format(script1, hyphenatedText1), "text/html", "utf-8", null);

            String script2 = "<html><body> %s </body></Html>";
            WebView webView2 = (WebView) view.findViewById(R.id.webview2);
            webView2.loadDataWithBaseURL(null, String.format(script2, text1), "text/html", "utf-8", null);

            String script3 = "<html><body style=\"text-align:justify\"> %s </body></Html>";
            WebView webView3 = (WebView) view.findViewById(R.id.webview3);
            webView3.loadDataWithBaseURL(null, String.format(script3, hyphenatedText2), "text/html", "utf-8", null);

        } catch (Exception ioe) {

        }
    }
}

