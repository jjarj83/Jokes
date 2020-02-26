package edu.psu.jjb24.csjokes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class DisplaySetupDialog extends DialogFragment {

    public interface SetupDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        //public void onDialogNegativeClick(DialogFragment dialog);
    }

    SetupDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String title = getArguments().getString("title");
        final String content = getArguments().getString("content");

        builder.setTitle(title)
                .setMessage(content)
                .setPositiveButton("Punchline", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onDialogPositiveClick(DisplaySetupDialog.this);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {}
                });



        return builder.create();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (SetupDialogListener) context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement SetupDialogListener");
        }
    }


}

