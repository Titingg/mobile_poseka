package com.example.onboarding.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.onboarding.FragmentActivity;
import com.example.onboarding.LoginActivity;
import com.example.onboarding.R;

public class HomeFragment extends Fragment {

private ImageView imageView, imageView2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);

        View v = inflater.inflate(R.layout.fragment_home, container,  false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.ivkonsultasi);
        imageView2 = view.findViewById(R.id.tips);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Url = "https://wa.me/6285343781474/";
                Intent bukaBrowser = new Intent(Intent.ACTION_VIEW);
                bukaBrowser.setData(Uri.parse(Url));
                startActivity(bukaBrowser);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Url = "https://merdekadarikekerasan.kemdikbud.go.id/";
                Intent bukaBrowser = new Intent(Intent.ACTION_VIEW);
                bukaBrowser.setData(Uri.parse(Url));
                startActivity(bukaBrowser);
            }
        });



    }




}