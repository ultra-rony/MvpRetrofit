package ru.msai.paper.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class MainAdapterPresenter {

    private MainAdapterView view;

    public MainAdapterPresenter(MainAdapter view) {
        this.view = view;
    }
    // Date and time conversion
    public void onDateTimeSetting(String dateTime) {

        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ru"));
        Date date = null;
        try {
            date = dateParser.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dateFormatter = DateFormat.getDateTimeInstance().format(date);

        view.getDateTime(dateFormatter);

    }
}
