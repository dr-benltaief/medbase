package tn.freemed.medbase;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.JavascriptInterface;
import android.content.Context;

import android.widget.Toast;

public class MedBaseActivity extends Activity {

	private WebView webView;

	private MedBaseHelper dbMedBaseHelper = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.medbase);

		dbMedBaseHelper = new MedBaseHelper(this);
		dbMedBaseHelper.createDatabase();

		// SQLiteDatabase db = dbMedBaseHelper.getReadableDatabase();

		webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
		webView.loadUrl("file:///android_asset/index.html");
		webView.addJavascriptInterface(new MedBaseInterface(this), "Android");
	}

	@Override
	public void onBackPressed() {
		if(webView.canGoBack()) {
			webView.goBack();
		} else {
			super.onBackPressed();
		}
	}

	public class MedBaseInterface {
		Context mContext;

		MedBaseInterface(Context c) {
			mContext = c;
		}

		@JavascriptInterface
		public String search(int method, String terms) {
			String answer = "Interface Android / ";
			if (method == 1) {
			// Recherche simple
				answer += "Recherche simple / "+terms;
			} else {
			// Recherche avancée
				answer += "Recherche avancée / "+terms;
			}
			return answer;
		}
	}

}