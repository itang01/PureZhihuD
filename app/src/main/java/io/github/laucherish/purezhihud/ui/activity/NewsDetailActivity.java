package io.github.laucherish.purezhihud.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import io.github.laucherish.purezhihud.R;
import io.github.laucherish.purezhihud.base.BaseActivity;
import io.github.laucherish.purezhihud.bean.News;
import io.github.laucherish.purezhihud.ui.fragment.NewsDetailFragment;

/**
 * Created by laucherish on 16/3/17.
 */
public class NewsDetailActivity extends BaseActivity {

    public static final String KEY_NEWS = "key_news";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    public static void start(Context context, News news) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra(KEY_NEWS, news);
        context.startActivity(intent);
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        mSwipeBackLayout.setEdgeDp(360);
        News news = getIntent().getParcelableExtra(KEY_NEWS);
        showNewsDetailFragment(news);
    }

    private void showNewsDetailFragment(News news) {
        Fragment fragment = NewsDetailFragment.newInstance(news);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fl_container, fragment, NewsDetailFragment.TAG);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
