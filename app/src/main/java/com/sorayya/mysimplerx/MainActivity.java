package com.sorayya.mysimplerx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private Disposable disposable;

        /**
         * Basic Observable, Observer, Subscriber example
         * Observable emits list of animal names
         */

        private static final String TAG = MainActivity.class.getSimpleName();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Intent intent=new Intent(this,NoteActivity.class);
            startActivity(intent);
            /*

            // observable
            Observable<String> animalsObservable = getAnimalsObservable();

            // observer
            Observer<String> animalsObserver = getAnimalsObserver();

            // observer subscribing to observable
            animalsObservable
                    .observeOn(Schedulers.io())  //This tell the Observable to run the task on a background thread.
                    .subscribeOn(AndroidSchedulers.mainThread()) //This tells the Observer to receive the data on android UI thread so that you can take any UI related actions.
                    .filter(new Predicate<String>() {
                        @Override
                        public boolean test(String s) throws Exception {
                            return s.toLowerCase().startsWith("b"); //animal names which starts with letter `b` will be filtered.
                        }
                    })
                    .subscribe(animalsObserver);
        }

        private Observer<String> getAnimalsObserver() {
            return new Observer<String>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    Log.d(TAG, "onSubscribe");
                }

                @Override
                public void onNext(String s) {
                    Log.d(TAG, "Name: " + s);
                }

                @Override
                public void onError(Throwable e) {
                    Log.e(TAG, "onError: " + e.getMessage());
                }

                @Override
                public void onComplete() {
                    Log.d(TAG, "All items are emitted!");
                }
            };

             */
        }

    private Observable<String> getAnimalsObservable() {
        return Observable.fromArray(
                "Ant", "Ape",
                "Bat", "Bee", "Bear", "Butterfly",
                "Cat", "Crab", "Cod",
                "Dog", "Dove",
                "Fox", "Frog");
    }
        public void onDestroy(){
            super.onDestroy();
            // don't send events once the activity is destroyed
            disposable.dispose();
        }
    }
