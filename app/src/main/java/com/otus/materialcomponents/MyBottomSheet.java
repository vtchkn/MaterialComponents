package com.otus.materialcomponents;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public  class MyBottomSheet extends BottomSheetDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);

        final View contentView = View.inflate(getContext(), R.layout.bottom_sheet, null);
        dialog.setContentView(contentView);

        final EditText editText = (EditText) contentView.findViewById(R.id.edit_text);
        editText.setText("A\nB\nC\nD\nE\nF\nG");

        final View parentView = (View) contentView.getParent();
        final CoordinatorLayout.LayoutParams parentParams =
                (CoordinatorLayout.LayoutParams) parentView.getLayoutParams();
        parentParams.setBehavior(new QuickShareSheetBottomBehavior());

        return dialog;
    }

    private static class QuickShareSheetBottomBehavior extends BottomSheetBehavior {
        private QuickShareSheetBottomBehavior() {
            setState(BottomSheetBehavior.STATE_EXPANDED);
            setSkipCollapsed(true);
            setHideable(false);
        }
    }
}