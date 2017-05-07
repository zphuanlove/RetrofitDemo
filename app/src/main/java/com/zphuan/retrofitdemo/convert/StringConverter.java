package com.zphuan.retrofitdemo.convert;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by zhongpeihuan on 2017/5/3.
 */

public class StringConverter implements Converter<ResponseBody,String> {

    @Override
    public String convert(ResponseBody value) throws IOException {
        return value.string();
    }
}
