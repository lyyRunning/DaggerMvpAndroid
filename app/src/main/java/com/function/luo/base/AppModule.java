package com.function.luo.base;

import com.function.luo.module.BaseMainModule;
import com.function.luo.module.TwoActivityModule;

import dagger.Module;

/**
 * Created by luo on 2019/8/7.
 * 注入绑定关系,如果使用到了就需要在这里进行注册，
 * 默认全局module并且加上各个module之间的联系
 * 最上层的 Module
 */

@Module(includes = {BaseMainModule.class})
public abstract  class AppModule {

}
