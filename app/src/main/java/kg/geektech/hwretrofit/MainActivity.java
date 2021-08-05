package kg.geektech.hwretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import kg.geektech.hwretrofit.data.BoredApi;
import kg.geektech.hwretrofit.data.RetrofitBuilder;
import kg.geektech.hwretrofit.databinding.ActivityMainBinding;
import kg.geektech.hwretrofit.model.Model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
    public void onClick(View view) {

        RetrofitBuilder.getInstance().getActivities().enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful() && response.body() != null){
                    Log.e("tag","Success: " + response.body().getActivities());
                   binding.textActivity.setText(response.body().getActivities());
                } else {
                    Log.e("tag","error!" + response.code());
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e("tag","failure" + t.getLocalizedMessage());
            }
        });
    }
}