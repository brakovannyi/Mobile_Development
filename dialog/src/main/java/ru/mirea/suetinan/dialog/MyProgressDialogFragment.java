package ru.mirea.suetinan.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class MyProgressDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressBar pb = new ProgressBar(this.getActivity(), null, androidx.appcompat.R.attr.progressBarStyle);
        return new ProgressDialog(getActivity(), androidx.appcompat.R.style.Base_Widget_AppCompat_ProgressBar_Horizontal);
    }
}