package one.ftflproject.bbb.arifhasnt.com.bbb;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Arif on 20/10/2015.
 */
public class JoinToCommunity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forumpage);


        WebView view = (WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new MyBrowser());
        view.loadUrl("http://bloodbank.3eeweb.com/#");

        view.getSettings().setBuiltInZoomControls(true);
        view.getSettings().setSupportZoom(true);
    }
}
