# TMDB - The Movie Database

<img src='Screenshot1.png'/>
<img src='Screenshot2.png'/>
<img src='Screenshot3.png'/>
<img src='Screenshot4.png'/>

TMDB application is created to demonstrate how to use MVVM Clean Architecture in android using all below android components in the app

* Kotlin
* Kotlin Coroutine
* Room Database
* ViewModel
* Data Binding
* Dagger 2 (Dependency injection)
* Retrofit
* GSON
* Glide

Also each screen has swipe to refresh functionality to fetch latest data from the API.

# Data Management

Application has 3 data sources,

1. Remote Data Source (REST API)
2. Local Data Source (Room Database)
3. Cache Data Source

To improve the performance while loading data into recycler views below is the flow of checking and fetching data

## Cache Data Source -> Room Database -> REST API

The above sentance means if cache data source does not have data to display then it will get it from database and update in cache and return. If room database also does not have to data to return then it will get data from API and save it inside the database and return to the view model

