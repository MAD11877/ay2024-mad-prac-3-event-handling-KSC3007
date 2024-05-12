package sg.edu.np.mad.mad_prac3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        User user = new User("Shan Chun", "MAD Developer", 1, false);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);

        tvName.setText(user.name);
        tvDescription.setText(user.description);


         btnFollow.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (user.followed) {
                     user.followed = false;
                     btnFollow.setText("Unfollow");
                     Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                 }

                 else {
                     user.followed = true;
                     btnFollow.setText("Follow");
                     Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                 }
             }
         });
    }
}