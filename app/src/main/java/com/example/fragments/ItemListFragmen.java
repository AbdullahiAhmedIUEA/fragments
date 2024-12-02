package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ItemListFragmen extends Fragment {

    private ListView listView;
    private TextView emptyTextView;
    private Button addButton;
    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        listView = view.findViewById(R.id.list_view);
        emptyTextView = view.findViewById(R.id.empty_text_view);
        addButton = view.findViewById(R.id.add_button);

        // Initialize the item list or restore the saved state
        if (savedInstanceState != null) {
            itemList = savedInstanceState.getStringArrayList("itemList");
        } else {
            itemList = new ArrayList<>();
        }
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);
        listView.setEmptyView(emptyTextView);

        addButton.setOnClickListener(v -> {
            itemList.add("Item " + (itemList.size() + 1));
            adapter.notifyDataSetChanged();
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("itemList", itemList);
    }
}
