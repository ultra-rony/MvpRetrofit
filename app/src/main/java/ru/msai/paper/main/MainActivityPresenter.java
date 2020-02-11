package ru.msai.paper.main;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.msai.paper.support.Constants;

class MainActivityPresenter {

    private MainActivityView view;

    public MainActivityPresenter(MainActivity view) {
        this.view = view;
    }
    // Parse JSON
    public void onPaperParse() {
        MainResult service = Constants.getMainService().create(MainResult.class);
        Call<MainResponse> call = service.getResponseResult();
        call.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.code() == 200) {
                    if (response.body().isError() == false)
                        view.getSuccess(response.body().getPaper());
                    else
                        view.getError();
                }
            }
            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                view.getError();
            }
        });
    }
}
