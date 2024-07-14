package com.example.task6;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText StudentID, Name, Email, Department, Year;
    private Button Submit;
    private Animation fadeOutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        StudentID = findViewById(R.id.StudentID);
        Name = findViewById(R.id.Name);
        Email = findViewById(R.id.Email);
        Department = findViewById(R.id.Department);
        Year = findViewById(R.id.Year);
        Submit = findViewById(R.id.Submit);


        fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        Submit.setOnClickListener(v -> submitForm());
    }

    private void submitForm() {
        String studentID = StudentID.getText().toString().trim();
        String name = Name.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String department = Department.getText().toString().trim();
        String yearText = Year.getText().toString().trim();
        if (studentID.isEmpty() || name.isEmpty() || email.isEmpty() || department.isEmpty() || yearText.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        String message = "Form Submitted";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        applyFadeOutAnimation();
    }

    private void applyFadeOutAnimation() {
        StudentID.startAnimation(fadeOutAnimation);
        Name.startAnimation(fadeOutAnimation);
        Email.startAnimation(fadeOutAnimation);
        Department.startAnimation(fadeOutAnimation);
        Year.startAnimation(fadeOutAnimation);
        Submit.startAnimation(fadeOutAnimation);
        clearFormFields();
    }

    private void clearFormFields() {
        StudentID.getText().clear();
        Name.getText().clear();
        Email.getText().clear();
        Department.getText().clear();
        Year.getText().clear();
    }
}
