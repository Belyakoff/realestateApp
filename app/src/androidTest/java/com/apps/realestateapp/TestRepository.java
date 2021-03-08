package com.apps.realestateapp;

        import androidx.lifecycle.MutableLiveData;
        import com.apps.realestateapp.model.Apartment;
        import com.apps.realestateapp.networking.ApartmentsApi;
        import com.apps.realestateapp.networking.RetrofitService;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

        import android.util.Log;
        import java.util.List;

public class TestRepository {

    private static TestRepository testRepository;

    public static TestRepository getInstance(){
        if (testRepository == null){
            testRepository = new TestRepository();
        }
        return testRepository;
    }

    private ApartmentsApi apartmentsApi;

    public TestRepository(){
        apartmentsApi = RetrofitService.createService(ApartmentsApi.class);
    }

    public MutableLiveData<List<Apartment>> getApartments(){
        MutableLiveData<List<Apartment>> apartmentsData = new MutableLiveData<>();


        apartmentsApi.getApartmentsList().enqueue(new Callback<List<Apartment>>() {

            @Override
            public void onResponse(Call<List<Apartment>> call,
                                   Response<List<Apartment>> response) {
                if (response.isSuccessful()){

                    apartmentsData.postValue(response.body());
                    Log.d("REPO TEST onresponse ", response.body().get(0).getHREF());
                    Log.d("REPO TEST onresponse ", response.body().get(0).getTitle());
                }
            }

            @Override
            public void onFailure(Call<List<Apartment>> call, Throwable t) {
                t.printStackTrace();

                apartmentsData.setValue(null);
            }
        });

        return apartmentsData;
    }




}
