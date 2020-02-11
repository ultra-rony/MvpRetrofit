package ru.msai.paper.main;

import java.util.List;

interface MainActivityView {

    // Success
    void getSuccess(List<MainModel> list);
    // Error
    void getError();

}
