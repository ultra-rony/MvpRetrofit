# MvpRetrofitParseJsonRecyclerView


```ruby
implementation "com.android.support:recyclerview-v7:29.0.1"
implementation 'androidx.cardview:cardview:1.0.0'
implementation 'com.squareup.retrofit2:retrofit:2.6.2'
implementation 'com.squareup.retrofit2:converter-gson:2.6.2'
```

# DateTimeConversion

```ruby
SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ru"));
Date date = null;
try {
    date = dateParser.parse(dateTime);
} catch (ParseException e) {
    e.printStackTrace();
}

String dateFormatter = DateFormat.getDateTimeInstance().format(date);
```


# We can create an interface MainActivityView


```ruby
interface MainActivityView {
    // Success
    void getSuccess(List<MainModel> list);
    // Error
    void getError();
}
```

# Add this interface to MainActivity


```ruby
public class MainActivity extends AppCompatActivity implements MainActivityView
```


# Now in the presenter you can remove all references to MainActivity, and leave only MainActivityView.

```ruby
public class MainActivityPresenter {
 
    private MainActivityView view;
 
    public void attachView(MainActivityView view) {
        this.view = view;
    }
 
    ...
 
}
```
