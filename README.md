# TeaTime
An app that helps college students find study groups and TA sessions easier.

An app that helps change the way students spend their study time!
Spending time studying by yourself is not the only option of studying, what if you can find anybody also working on the same subject that you can seek help and hang out with?

Our TeaTime App makes it super easy to find a happening study group or find TA hours just by a glance at the phone.  
Any student can publish their schedule and get other people joined. 

# Implementation
There are two main parts to this innovation.

The first developer engine we used was Parser Server which is an open-source API serve. As a data-driven appliation, we use Parser Server to host our database (MongoDB based).
[Parser Server](https://parseplatform.org/)

The next part was the Maps SDK for Android. This with the TeaTime API integrated into the app. We use GeoPoint to visualize real time events on Rice University map.

[Maps SDK for Android](https://developers.google.com/maps/documentation/android-sdk/intro)
