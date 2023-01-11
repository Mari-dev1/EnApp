package com.example.enapp.ui.airpollution;

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

import com.example.enapp.databinding.FragmentAirBinding;


public class AirFragment extends Fragment {

    private FragmentAirBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AirViewModel airViewModel =
                new ViewModelProvider(this).get(AirViewModel.class);

        binding = FragmentAirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final WebView airWebView = binding.idWebviewVisual;
        final ProgressBar loadingPB = binding.idVisual;
        airWebView.loadUrl("https://sites.google.com/d/1QLlHSRL2t1-82EyUrvloNIWbc118EEAK/p/1J7fbhZgeLGNAADpYkF-50hfFzKkqyD21/edit");
        airWebView.setWebViewClient(new WebViewClient(){
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
        airWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_DOWN){
                    switch (keyCode){
                        case KeyEvent.KEYCODE_BACK:
                            if(airWebView.canGoBack()){
                                airWebView.goBack();
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