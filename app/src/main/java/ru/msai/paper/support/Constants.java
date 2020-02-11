package ru.msai.paper.support;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Constants {

    private static Retrofit retrofit;
    protected static Reference ref;

    static String provideBaseUrlString() {
        return ref.DOMAIN;
    }

    public static Retrofit getMainService() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(provideBaseUrlString())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
