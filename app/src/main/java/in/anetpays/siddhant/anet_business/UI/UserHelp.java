package in.anetpays.siddhant.anet_business.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.anetpays.siddhant.anet_business.R;


/**
 * Created by siddh on 19-02-2018.
 */

public class UserHelp extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help_activity, container, false);
        getActivity().setTitle("Help");

        return view;
    }
}
