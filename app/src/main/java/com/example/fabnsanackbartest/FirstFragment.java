package com.example.fabnsanackbartest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fabnsanackbartest.databinding.FragmentFirstBinding;
import com.google.android.material.snackbar.Snackbar;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);*/
                /*SnackBar*/
                Snackbar.make(view, "Record Saved", Snackbar.LENGTH_LONG)
                        .setAction("Undo", undoOnClickListener).show();

                /* if the undo is difficult, just use the following snack bar instead
                Snackbar.make(view, "Go to Add Record Page", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
    }
        View.OnClickListener undoOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, "Record removed", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}