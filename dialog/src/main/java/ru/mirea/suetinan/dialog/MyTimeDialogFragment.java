package ru.mirea.suetinan.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class MyTimeDialogFragment extends DialogFragment {

    private TimePickerDialog.OnTimeSetListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int cHour = c.get(Calendar.HOUR_OF_DAY);
        int cMinute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), listener, cHour, cMinute,
                android.text.format.DateFormat.is24HourFormat(getActivity()));
    }

}