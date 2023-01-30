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
import android.widget.TextView;
import android.widget.Toast;

import com.example.iman_tunaliev_hw3_2.R;

public class SecondFragment extends Fragment {

    TextView textView;
    AppCompatButton button;
    String nameFromOtherFragments;
    EditText editTextAge;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        getBundle();
        setNameTextView();
        clickListener();
    }

    private void findViews() {
        textView = requireView().findViewById(R.id.text_view_name);
        button = requireActivity().findViewById(R.id.second_fragment_button);
        editTextAge = requireActivity().findViewById(R.id.edit_text_age);
    }

    private void getBundle() {
        if (getArguments() != null) {
            nameFromOtherFragments = getArguments().getString("name");
        }
    }

    private void setNameTextView() {
        textView.setText("Name: " + nameFromOtherFragments);
    }

    private void clickListener() {
        button.setOnClickListener(view -> {
            Integer textFromEditText = Integer.parseInt(editTextAge.getText().toString());
            if (!textFromEditText.toString().isEmpty() && textFromEditText.toString().length() <= 3) {
                navigate(textFromEditText);
            } else {
                Toast.makeText(requireActivity(), "Write age", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void navigate(Integer age) {
        Bundle bundle = new Bundle();
        bundle.putInt("age", age);
        bundle.putString("name", nameFromOtherFragments);
        ThirdFragment thirdFragment = new ThirdFragment();
        thirdFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container_view, thirdFragment).
                addToBackStack(null).
                commit();
    }
}
