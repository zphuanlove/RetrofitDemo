package com.zphuan.retrofitdemo.convert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by zhongpeihuan on 2017/5/3.
 */

public class StringConverterFactory extends Converter.Factory {

    public static StringConverterFactory create(){
        return new StringConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if(type == String.class){
            //如果type是String类型，那么就是用StringConverter去解析
            return new StringConverter();
        }else{
            //其他类型不做处理，返回null
            return null;
        }
    }
}
