package Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iman_tunaliev_hw3_2.R;

public class FirstFragment extends Fragment {

    AppCompatButton button;
    EditText editTextName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        onClickListener();
    }

    private void findViews() {
        button = requireActivity().findViewById(R.id.first_fragment_button);
        editTextName = requireActivity().findViewById(R.id.edit_text_name);
    }

    private void onClickListener() {
        button.setOnClickListener(view -> {
            String textFromEditText = editTextName.getText().toString();
            if (!textFromEditText.isEmpty() && textFromEditText.length() >= 4){
                navigate(textFromEditText);
            } else {
                Toast.makeText(requireActivity(), "Write your name", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void navigate(String name) {
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container_view, secondFragment).
                addToBackStack(null).
                commit();
    }
}