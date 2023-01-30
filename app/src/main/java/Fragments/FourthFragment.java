package Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iman_tunaliev_hw3_2.R;

public class FourthFragment extends Fragment {
    TextView textViewAge;
    TextView textViewCity;
    TextView textViewName;
    String nameFromOtherFragments;
    Integer ageFromOtherFragments;
    String cityFromOtherFragments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews();
        getBundle();
        setTextViews();
    }

    private void findViews() {
        textViewAge = requireActivity().findViewById(R.id.text_view_age_fourth);
        textViewCity = requireActivity().findViewById(R.id.text_view_city_fourth);
        textViewName = requireActivity().findViewById(R.id.text_view_name_fourth);

    }

    private void getBundle() {
        if (getArguments() != null) {
            nameFromOtherFragments = getArguments().getString("name");
            ageFromOtherFragments = getArguments().getInt("age");
            cityFromOtherFragments = getArguments().getString("city");
        }
    }

    private void setTextViews() {
        textViewName.setText("Name: " + nameFromOtherFragments);
        textViewAge.setText("Age: " + ageFromOtherFragments);
        textViewCity.setText("City: " + cityFromOtherFragments);
    }

}