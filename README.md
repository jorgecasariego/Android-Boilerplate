This is a simple boilerplate application which demonstrates the downloading, persisting and syncing of data - displayed with a common layout used amongst applications.

The project is setup using:

* [RxJava](https://github.com/ReactiveX/RxJava)

* [Retrofit](http://square.github.io/retrofit/) and [OkHttp](https://github.com/square/okhttp)

* [Dagger 2](http://google.github.io/dagger/)

* [Butterknife](https://github.com/JakeWharton/butterknife)

* [Glide](https://github.com/bumptech/glide)

# Project Structure

![alt text](https://github.com/jorgecasariego/Dagger-2-/blob/master/Images/image1.png "Project Structure")

# Demo

<p align="center">
  <img src="https://github.com/jorgecasariego/Dagger-2-/blob/master/Images/image2.jpg" width="350"/>
</p>

# Dagger 2

Many Android apps rely on instantiating objects that often require other dependencies. For instance, a Twitter API client may be built using a networking library such as Retrofit. To use this library, you might also need to add parsing libraries such as Gson. In addition, classes that implement authentication or caching may require accessing shared preferences or other common storage, requiring instantiating them first and creating an inherent dependency chain.

Dagger 2 analyzes these dependencies for you and generates code to help wire them together. While there are other Java dependency injection frameworks, many of them suffered limitations in relying on XML, required validating dependency issues at run-time, or incurred performance penalties during startup. Dagger 2 relies purely on using Java annotation processors and compile-time checks to analyze and verify dependencies. It is considered to be one of the most efficient dependency injection frameworks built to date.


**Advantages**

* **Simplifies access to shared instances.** Just as the ButterKnife library makes it easier to define references to Views, event handlers, and resources, Dagger 2 provides a simple way to obtain references to shared instances.

* **Easy configuration of complex dependencies.** There is an implicit order in which your objects are often created. Dagger 2 walks through the dependency graph and generates code that is both easy to understand and trace, while also saving you from writing the large amount of boilerplate code you would normally need to write by hand to obtain references and pass them to other objects as dependencies. It also helps simplify refactoring, since you can focus on what modules to build rather than focusing on the order in which they need to be created.

* **Easier unit and integration testing** Because the dependency graph is created for us, we can easily swap out modules that make network responses and mock out this behavior.

* **Scoped instances** Not only can you easily manage instances that can last the entire application lifecycle, you can also leverage Dagger 2 to define instances with shorter lifetimes

# Retrofit

Retrofit is a REST Client for Android and Java by Square. It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice. Retrofit can be configured with converter is used for its data serialization. Typically for JSON you use GSon, but you can add custom converters to process XML or other protocols. Retrofit uses the OkHttp library for HTTP requests.

Retrofit allows to use the following converters:

To work with Retrofit you need basically three classes.

1. Model class which is used to map the JSON data to

2. Interfaces which defines the possible HTTP operations

3. Retrofit.Builder class - Instance which uses the interface. Builder API which allows defining the URL end point for the HTTP operation.

# RxJava

In reactive programming the consumer reacts to the data as it comes in. This is the reason why asynchronous programming is also called reactive programming. Reactive programming allows to propagates event changes to registered observers.

RxJava is a port from Netflix of the Reactive Extensions (Rx) to Java. RxJava was open sourced 2014 and is hosted at [http://reactivex.io/](http://reactivex.io/). The Java version of this concept is called RxJava and is hosted under [https://github.com/ReactiveX/RxJava](https://github.com/ReactiveX/RxJava). RxJava is published under the Apache 2.0 license.

RxJava describes itself as an API for asynchronous programming with observable streams


# Glide

Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.

Glide supports fetching, decoding, and displaying video stills, images, and animated GIFs. Glide includes a flexible API that allows developers to plug in to almost any network stack. By default Glide uses a custom HttpUrlConnection based stack, but also includes utility libraries plug in to Google's Volley project or Square's OkHttp library instead.

Glide's primary focus is on making scrolling any kind of a list of images as smooth and fast as possible, but Glide is also effective for almost any case where you need to fetch, resize, and display a remote image.

# Dependencies use in this project

```
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:25.0.1'
    testCompile 'junit:junit:4.12'

    compile 'com.android.support:recyclerview-v7:25.0.1'
    compile 'com.android.support:cardview-v7:25.0.1'
    compile 'com.squareup.retrofit2:retrofit:2.+'
    compile 'com.squareup.retrofit2:converter-gson:2.+'
    compile 'com.squareup.retrofit2:adapter-rxjava:2.+'
    compile 'io.reactivex:rxjava:1.0.4'
    compile 'io.reactivex:rxandroid:0.24.0'
    compile 'com.github.bumptech.glide:glide:3.7.0'
    provided 'com.google.dagger:dagger-compiler:2.1'
    compile 'com.google.dagger:dagger:2.1'
    provided 'org.glassfish:javax.annotation:10.0-b28'
    compile 'com.jakewharton:butterknife:7.0.1'
    compile 'com.google.code.gson:gson:2.6.2'
}
```



