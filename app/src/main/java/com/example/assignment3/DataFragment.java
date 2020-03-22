package com.example.assignment3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DataFragment extends Fragment {
    TextView speech, number, most1, most2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_data, container, false);

        speech = v.findViewById(R.id.speechOutput_data);
        number = v.findViewById(R.id.dataPageNumberWordVal);
        most1 = v.findViewById(R.id.dataPageMostOccurringWordVal);
        most2 = v.findViewById(R.id.dataPageMostOccurring2WordVal);

        speech.setText(LazyDatabase.speechText);
        number.setText(LazyDatabase.countNumberOfWords());
        most1.setText(LazyDatabase.countMostOccuring(1));
        most2.setText(LazyDatabase.countMostOccuring(2));

        return v;
    }
}
