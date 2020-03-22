package com.example.assignment3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.File;

public class ExportFragment extends Fragment {
    EditText to, subject, message;
    Button send;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_export, container, false);

        to = v.findViewById(R.id.exportPageToEdit);
        subject = v.findViewById(R.id.exportPageSubjectEdit);
        message = v.findViewById(R.id.exportPageMessageEdit);
        send = v.findViewById(R.id.exportPageSendButton);

        message.setText(LazyDatabase.speechText);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
        return v;
    }

    public void sendMail() {
        String recipientList = to.getText().toString();
        String[] recipients = recipientList.split(",");

        String subjectStr = subject.getText().toString();
        String messageStr = message.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subjectStr);
        intent.putExtra(Intent.EXTRA_TEXT, messageStr);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
}
