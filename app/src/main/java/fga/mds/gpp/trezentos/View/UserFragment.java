package fga.mds.gpp.trezentos.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.login.LoginManager;

import fga.mds.gpp.trezentos.Controller.UserAccountControl;
import fga.mds.gpp.trezentos.R;

import static com.facebook.FacebookSdk.getApplicationContext;

public class UserFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button logoutButton;

    public UserFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        logoutButton = (Button) view.findViewById(R.id.button_loggout);
        logoutButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button_loggout: {
                LoginManager.getInstance().logOut();

                UserAccountControl userAccountControl = UserAccountControl.getInstance(getApplicationContext());
                userAccountControl.logOutUser();

                goLoginScreen();

                break;
            }
        }
    }

    private void goLoginScreen(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}