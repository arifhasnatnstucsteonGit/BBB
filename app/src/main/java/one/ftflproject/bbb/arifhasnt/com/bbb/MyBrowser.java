package one.ftflproject.bbb.arifhasnt.com.bbb;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Arif on 27/10/2015.
 */
public class MyBrowser extends WebViewClient {

    @Override
    public  boolean shouldOverrideUrlLoading(WebView view, String url ){
        view.loadUrl(url);
        return true;
    }
}
