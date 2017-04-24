package state.better.statedemo.fragment.diff;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;

import state.better.statedemo.R;
import state.better.statedemo.fragment.BaseFragment;

public class FragmentF extends BaseFragment {
	private static final String TEST_URL = "http://www.jd.com/";

	LinearLayout container;
	EditText input;
	WebView webView;
	private Bundle webViewState;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_f, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		container = (LinearLayout) view.findViewById(R.id.container);
		input = (EditText) view.findViewById(R.id.tab2_input);
		webView = (WebView) view.findViewById(R.id.tab2_webview);

		initWebView();
		if (webViewState != null) {
			//Fragment实例并未被销毁, 重新create view
			webView.restoreState(webViewState);
		} else if (savedInstanceState != null) {
			//Fragment实例被销毁重建
			webView.restoreState(savedInstanceState);
		} else {
			//全新Fragment
			webView.loadUrl(TEST_URL);
		}
	}

	@SuppressLint("JavascriptInterface")
	private void initWebView() {
		// Settings
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setDomStorageEnabled(true);
		settings.setGeolocationEnabled(true);
		// settings.setDisplayZoomControls(false);
		settings.setBuiltInZoomControls(true);
		settings.setUseWideViewPort(true);
		settings.setLoadWithOverviewMode(true);

		settings.setDatabaseEnabled(true);
		settings.setAppCacheEnabled(true);
		settings.setAppCachePath(this.getContext().getCacheDir().getAbsolutePath());
		settings.setDisplayZoomControls(false);


		webView.requestFocus();

		webView.setWebViewClient(new WebViewClient() {
		});

		webView.setWebChromeClient(new WebChromeClient() {

		});

	}

	@Override
	public void onResume() {
		super.onResume();
		webView.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		webView.onPause();
		//Fragment不被销毁(Fragment被加入back stack)的情况下, 依靠Fragment中的成员变量保存WebView状态
		webViewState = new Bundle();
		webView.saveState(webViewState);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		//Fragment被销毁的情况, 依靠outState保存WebView状态
		if (webView != null) {
			webView.saveState(outState);
		}
	}

	@Override
	public void onDestroy() {
		if (webView != null) {
			container.removeView(webView);
			webView.destroy();
			webView = null;
		}
		super.onDestroy();
	}

}
