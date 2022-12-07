package com.example.enapp.ui.work;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.enapp.databinding.FragmentWorkBinding;

public class WorkFragment extends Fragment {
    private FragmentWorkBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WorkViewModel workViewModel =
                new ViewModelProvider(this).get(WorkViewModel.class);

        binding = FragmentWorkBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final WebView exportWebView = binding.idWebviewWork;
        final ProgressBar loadingPB = binding.idWork;
        exportWebView.loadUrl("https://sites.google.com/view/greatdataca/energy-use-and-energy-production-in-ca?authuser=0");
        exportWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                loadingPB.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadingPB.setVisibility(View.GONE);
            }
        });
        exportWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if (exportWebView.canGoBack()) {
                                exportWebView.goBack();
                            }
                    }
                }

                return false;
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

