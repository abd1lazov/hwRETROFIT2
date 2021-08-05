package kg.geektech.hwretrofit.data;

import kg.geektech.hwretrofit.model.Model;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BoredApi {

    @GET("activity/")
    Call<Model> getActivities();
}
