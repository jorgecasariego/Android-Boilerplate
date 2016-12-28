package enterprisesolutions.dagger2_rx.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import enterprisesolutions.dagger2_rx.application.CakeApplication;
import enterprisesolutions.dagger2_rx.di.components.ApplicationComponent;

/**
 * Created by jorgecasariego on 19/12/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        onViewReady(savedInstanceState, getIntent());

    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    @CallSuper
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        resolveDaggerDependency();
        //TO be use by childs activities
    }

    protected void resolveDaggerDependency() {
    }

    protected void showDialog(String message){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(true);
        }

        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }


    protected  void hideDialog(){
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    protected ApplicationComponent getApplicationComponent(){
        return ((CakeApplication) getApplication()).getApplicationComponent();
    }

    protected abstract int getContentView();
}
