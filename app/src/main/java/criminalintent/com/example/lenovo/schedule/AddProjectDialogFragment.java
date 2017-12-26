package criminalintent.com.example.lenovo.schedule;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by lenovo on 2017/12/20.
 */

public class AddProjectDialogFragment extends DialogFragment {




    private ChooseDDLDialogFragment mChooseDDLDialogFragment;
    final static private String DDLDIALOGFRAGMENT = "ddlDialogFragment";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.selfdialog,null);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view);
        builder.setTitle("新建项目");

        view.findViewById(R.id.projectddllabel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChooseDDLDialogFragment=new ChooseDDLDialogFragment();
                mChooseDDLDialogFragment.show(getChildFragmentManager(),DDLDIALOGFRAGMENT);
            }
        });

        view.findViewById(R.id.addmember).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        builder.setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // sign in the user ...
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                AddProjectDialogFragment.this.getDialog().cancel();
            }
        });
        return builder.create();
    }

}
