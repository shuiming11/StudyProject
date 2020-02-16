package com.qgapp.todayinformation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ACER on 2020/2/16.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewInject {
    int resId() default -1;
}
