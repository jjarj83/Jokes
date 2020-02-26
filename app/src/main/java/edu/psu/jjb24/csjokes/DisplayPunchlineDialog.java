package edu.psu.jjb24.csjokes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class DisplayPunchlineDialog extends DialogFragment {

    public interface PunchDialogListener {
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    PunchDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String title = getArguments().getString("title");
        final String content = getArguments().getString("content");

        builder.setTitle(title)
                .setMessage(content)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int id) {}
                })
                .setNegativeButton("Setup", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int id) {
                        listener.onDialogNegativeClick(DisplayPunchlineDialog.this);
                    }
                });

        return builder.create();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (PunchDialogListener) context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement PunchDialogListener");
        }
    }

}
