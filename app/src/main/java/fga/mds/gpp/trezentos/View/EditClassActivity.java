package fga.mds.gpp.trezentos.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fga.mds.gpp.trezentos.Model.UserClass;
import fga.mds.gpp.trezentos.R;

public class EditClassActivity extends AppCompatActivity{

    private UserClass userClass;
    private EditText className;
    private EditText instituition;
    private EditText classPassword;
    private EditText cutGrade;
    private EditText groupsSize;
    private EditText addition;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Editar Sala");

        Intent intent = getIntent();
        userClass = (UserClass) intent.getSerializableExtra("Class");

        className = (EditText) findViewById(R.id.edit_text_class_name);
        instituition = (EditText) findViewById(R.id.edit_text_institution);
        classPassword = (EditText) findViewById(R.id.edit_text_class_password);
        cutGrade = (EditText) findViewById(R.id.edit_text_cut_grade);
        groupsSize = (EditText) findViewById(R.id.edit_text_size_groups);
        addition = (EditText) findViewById(R.id.edit_text_addition);
        saveButton = (Button) findViewById(R.id.button_save);

        className.setText(userClass.getClassName());
        instituition.setText(userClass.getInstitution());
        classPassword.setText(userClass.getPassword());


        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Update in API

                className.getText();
                instituition.getText();
                classPassword.getText();
                cutGrade.getText();
                groupsSize.getText();
                addition.getText();
                addition.getText();

            }

        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();

        return true;
    }
}
