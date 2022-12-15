package com.vermilion.perpusapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Beranda#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Beranda extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Buku> bukuArrayList;
    private String[] judulBuku;
    private RecyclerView recyclerview;

    public Beranda() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Beranda.
     */
    // TODO: Rename and change types and number of parameters
    public static Beranda newInstance(String param1, String param2) {
        Beranda fragment = new Beranda();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        Adapter adapter = new Adapter(getContext(), bukuArrayList);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void dataInitialize() {
        bukuArrayList = new ArrayList<>();

        judulBuku = new String[] {
                "Alice in Wonderland",
                "A Heartbreaking Work of Staggering Genius",
                "Born Standing Up",
                "Based on a True Story",
                "The Ultimate Hitchhiker's Guide to the Galaxy"
        };

        for (int i = 0; i < judulBuku.length; i++) {
            Buku buku = new Buku(judulBuku[i]);
            bukuArrayList.add(buku);
        }
    }
}