package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WelcomeFragment extends Fragment {

    private TextView welcomeTextView;
    private Button navigateButton;
    private Button navigateToItemListButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        welcomeTextView = view.findViewById(R.id.welcome_text_view);
        navigateButton = view.findViewById(R.id.navigate_button);
        navigateToItemListButton = view.findViewById(R.id.buttonNavigateToItemList);


        navigateButton.setOnClickListener(v -> {

            welcomeTextView.setText("Button Clicked!");
        });


        navigateToItemListButton.setOnClickListener(v -> {

            ((MainActivity) getActivity()).loadFragment(new ItemListFragmen());
        });

        return view;
    }
}
