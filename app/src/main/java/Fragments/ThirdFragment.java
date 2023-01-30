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

public class ThirdFragment extends Fragment {

    EditText editTextCity;
    TextView textViewAge;
    TextView textViewName;
    AppCompatButton button;
    String nameFromOtherFragments;
    Integer ageFromOtherFragments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        getBundle();
        setTextViews();
        clickListener();

    }

    private void findViews() {
        button = requireActivity().findViewById(R.id.third_fragment_button);
        editTextCity = requireActivity().findViewById(R.id.edit_text_city);
        textViewAge = requireActivity().findViewById(R.id.text_view_age_third);
        textViewName = requireActivity().findViewById(R.id.text_view_name_third);
    }

    private void getBundle() {
        if (getArguments() != null) {
            nameFromOtherFragments = getArguments().getString("name");
            ageFromOtherFragments = getArguments().getInt("age");
        }
    }

    private void setTextViews() {
        textViewName.setText("Name: " + nameFromOtherFragments);
        textViewAge.setText("Age: " + ageFromOtherFragments);
    }

    private void clickListener() {
        button.setOnClickListener(view -> {
            String textFromEditText = editTextCity.getText().toString();
            if (!textFromEditText.isEmpty() && textFromEditText.length() >= 3) {
                navigate(textFromEditText);
            } else {
                Toast.makeText(requireActivity(), "Write city", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void navigate(String city) {
        Bundle bundle = new Bundle();
        bundle.putString("city", city);
        bundle.putInt("age", ageFromOtherFragments);
        bundle.putString("name", nameFromOtherFragments);
        FourthFragment fourthFragment = new FourthFragment();
        fourthFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container_view, fourthFragment).
                addToBackStack(null).
                commit();
    }
}