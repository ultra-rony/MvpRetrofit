# MvpRetrofitParseJsonRecyclerView


```ruby
implementation "com.android.support:recyclerview-v7:29.0.1"
implementation 'androidx.cardview:cardview:1.0.0'
implementation 'com.squareup.retrofit2:retrofit:2.6.2'
implementation 'com.squareup.retrofit2:converter-gson:2.6.2'
```

#DateTimeConversion

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
