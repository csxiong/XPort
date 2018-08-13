package com.base.multi.di.component;

import me.csxiong.library.di.component.AppComponent;
import me.csxiong.library.di.scope.ActivityScope;
import com.base.multi.business.test.TestActivity;
import com.base.multi.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by csxiong on 2018/5/23.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(TestActivity atc);

}
